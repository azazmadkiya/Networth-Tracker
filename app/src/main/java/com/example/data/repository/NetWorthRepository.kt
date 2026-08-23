package com.example.data.repository

import com.example.data.dao.FinancialItemDao
import com.example.data.dao.LedgerDao
import com.example.data.dao.SnapshotDao
import com.example.data.model.FinancialItem
import com.example.data.model.LedgerEntry
import com.example.data.model.NetWorthSnapshot
import kotlinx.coroutines.flow.Flow
import org.json.JSONArray
import org.json.JSONObject

class NetWorthRepository(
    private val itemDao: FinancialItemDao,
    private val snapshotDao: SnapshotDao,
    private val ledgerDao: LedgerDao
) {
    val allItems: Flow<List<FinancialItem>> = itemDao.getAllItems()
    val allSnapshots: Flow<List<NetWorthSnapshot>> = snapshotDao.getAllSnapshots()
    val allLedgerEntries: Flow<List<LedgerEntry>> = ledgerDao.getAllLedgerEntries()

    fun getLedgerEntriesForAccount(accountName: String): Flow<List<LedgerEntry>> {
        return ledgerDao.getLedgerEntriesForAccount(accountName)
    }

    suspend fun insertLedgerEntry(entry: LedgerEntry): Long {
        return ledgerDao.insertLedgerEntry(entry)
    }

    suspend fun deleteLedgerEntry(entry: LedgerEntry) {
        ledgerDao.deleteLedgerEntry(entry)
    }

    fun getItemsByOwner(owner: String): Flow<List<FinancialItem>> {
        return itemDao.getItemsByOwner(owner)
    }

    suspend fun insertItem(item: FinancialItem): Long {
        return itemDao.insertItem(item)
    }

    suspend fun updateItem(item: FinancialItem) {
        itemDao.updateItem(item)
    }

    suspend fun deleteItem(item: FinancialItem) {
        itemDao.deleteItem(item)
    }

    suspend fun recordSnapshot(note: String = "Manual Snapshot", currentItems: List<FinancialItem>): Long {
        var assets = 0.0
        var liabilities = 0.0

        for (item in currentItems) {
            if (item.isLiability) {
                liabilities += item.currentValue
            } else {
                assets += item.currentValue
            }
        }

        val snapshot = NetWorthSnapshot(
            timestamp = System.currentTimeMillis(),
            totalAssets = assets,
            totalLiabilities = liabilities,
            netWorth = assets - liabilities,
            note = note
        )

        return snapshotDao.insertSnapshot(snapshot)
    }

    suspend fun deleteSnapshot(snapshot: NetWorthSnapshot) {
        snapshotDao.deleteSnapshot(snapshot)
    }

    suspend fun clearAllData() {
        itemDao.deleteAllItems()
        snapshotDao.deleteAllSnapshots()
        ledgerDao.deleteAllLedgerEntries()
    }

    // Offline Export to JSON String
    fun exportToJson(items: List<FinancialItem>, snapshots: List<NetWorthSnapshot>, ledgerEntries: List<LedgerEntry> = emptyList()): String {
        val root = JSONObject()
        root.put("version", 1)
        root.put("exportedAt", System.currentTimeMillis())

        val itemsArr = JSONArray()
        for (item in items) {
            val obj = JSONObject()
            obj.put("title", item.title)
            obj.put("institution", item.institution)
            obj.put("accountNumber", item.accountNumber)
            obj.put("owner", item.owner)
            obj.put("category", item.category)
            obj.put("currentValue", item.currentValue)
            obj.put("investedValue", item.investedValue)
            obj.put("isLiability", item.isLiability)
            obj.put("notes", item.notes)
            itemsArr.put(obj)
        }
        root.put("items", itemsArr)

        val snapArr = JSONArray()
        for (s in snapshots) {
            val obj = JSONObject()
            obj.put("timestamp", s.timestamp)
            obj.put("totalAssets", s.totalAssets)
            obj.put("totalLiabilities", s.totalLiabilities)
            obj.put("netWorth", s.netWorth)
            obj.put("note", s.note)
            snapArr.put(obj)
        }
        root.put("snapshots", snapArr)

        val ledgerArr = JSONArray()
        for (l in ledgerEntries) {
            val obj = JSONObject()
            obj.put("timestamp", l.timestamp)
            obj.put("transactionTitle", l.transactionTitle)
            obj.put("accountName", l.accountName)
            obj.put("oppositeAccountName", l.oppositeAccountName)
            obj.put("entryType", l.entryType)
            obj.put("debitAmount", l.debitAmount)
            obj.put("creditAmount", l.creditAmount)
            obj.put("runningBalance", l.runningBalance)
            obj.put("category", l.category)
            obj.put("notes", l.notes)
            ledgerArr.put(obj)
        }
        root.put("ledgerEntries", ledgerArr)

        return root.toString(2)
    }

    // Offline Import from JSON String (Supports Merging or Replacing)
    suspend fun importFromJson(jsonStr: String, clearExisting: Boolean = false): Boolean {
        return try {
            if (clearExisting) {
                clearAllData()
            }

            val root = JSONObject(jsonStr)
            if (root.has("items")) {
                val itemsArr = root.getJSONArray("items")
                val newItems = mutableListOf<FinancialItem>()
                for (i in 0 until itemsArr.length()) {
                    val obj = itemsArr.getJSONObject(i)
                    newItems.add(
                        FinancialItem(
                            title = obj.getString("title"),
                            institution = obj.optString("institution", ""),
                            accountNumber = obj.optString("accountNumber", ""),
                            owner = obj.optString("owner", "Self"),
                            category = obj.optString("category", "Bank Account"),
                            currentValue = obj.optDouble("currentValue", 0.0),
                            investedValue = obj.optDouble("investedValue", 0.0),
                            isLiability = obj.optBoolean("isLiability", false),
                            notes = obj.optString("notes", ""),
                            updatedAt = System.currentTimeMillis()
                        )
                    )
                }
                if (newItems.isNotEmpty()) {
                    itemDao.insertItems(newItems)
                }
            }

            if (root.has("snapshots")) {
                val snapArr = root.getJSONArray("snapshots")
                for (i in 0 until snapArr.length()) {
                    val obj = snapArr.getJSONObject(i)
                    snapshotDao.insertSnapshot(
                        NetWorthSnapshot(
                            timestamp = obj.optLong("timestamp", System.currentTimeMillis()),
                            totalAssets = obj.optDouble("totalAssets", 0.0),
                            totalLiabilities = obj.optDouble("totalLiabilities", 0.0),
                            netWorth = obj.optDouble("netWorth", 0.0),
                            note = obj.optString("note", "Imported Snapshot")
                        )
                    )
                }
            }

            if (root.has("ledgerEntries")) {
                val ledgerArr = root.getJSONArray("ledgerEntries")
                val newLedger = mutableListOf<LedgerEntry>()
                for (i in 0 until ledgerArr.length()) {
                    val obj = ledgerArr.getJSONObject(i)
                    newLedger.add(
                        LedgerEntry(
                            timestamp = obj.optLong("timestamp", System.currentTimeMillis()),
                            transactionTitle = obj.optString("transactionTitle", "Imported Transaction"),
                            accountName = obj.optString("accountName", "General"),
                            oppositeAccountName = obj.optString("oppositeAccountName", ""),
                            entryType = obj.optString("entryType", "CR"),
                            debitAmount = obj.optDouble("debitAmount", 0.0),
                            creditAmount = obj.optDouble("creditAmount", 0.0),
                            runningBalance = obj.optDouble("runningBalance", 0.0),
                            category = obj.optString("category", "General"),
                            notes = obj.optString("notes", "Imported Backup Entry")
                        )
                    )
                }
                if (newLedger.isNotEmpty()) {
                    ledgerDao.insertLedgerEntries(newLedger)
                }
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}
