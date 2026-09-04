package com.example.data.repository

import com.example.data.dao.FinancialItemDao
import com.example.data.dao.LedgerDao
import com.example.data.dao.ReminderDao
import com.example.data.dao.SnapshotDao
import com.example.data.model.FinancialItem
import com.example.data.model.FinancialReminder
import com.example.data.model.LedgerEntry
import com.example.data.model.NetWorthSnapshot
import kotlinx.coroutines.flow.Flow
import org.json.JSONArray
import org.json.JSONObject

class NetWorthRepository(
    private val itemDao: FinancialItemDao,
    private val snapshotDao: SnapshotDao,
    private val ledgerDao: LedgerDao,
    private val reminderDao: ReminderDao
) {
    val allItems: Flow<List<FinancialItem>> = itemDao.getAllItems()
    val allSnapshots: Flow<List<NetWorthSnapshot>> = snapshotDao.getAllSnapshots()
    val allLedgerEntries: Flow<List<LedgerEntry>> = ledgerDao.getAllLedgerEntries()
    val allReminders: Flow<List<FinancialReminder>> = reminderDao.getAllReminders()

    suspend fun insertItem(item: FinancialItem): Long {
        return itemDao.insertItem(item)
    }

    suspend fun updateItem(item: FinancialItem) {
        itemDao.updateItem(item)
    }

    suspend fun deleteItem(item: FinancialItem) {
        itemDao.deleteItem(item)
    }

    suspend fun deleteItemById(id: Long) {
        itemDao.deleteItemById(id)
    }

    suspend fun recordSnapshot(note: String = "", currentItems: List<FinancialItem>): Long {
        var totalAssets = 0.0
        var totalLiabilities = 0.0
        for (item in currentItems) {
            if (item.isLiability) {
                totalLiabilities += item.currentValue
            } else {
                totalAssets += item.currentValue
            }
        }
        val netWorth = totalAssets - totalLiabilities
        val snapshot = NetWorthSnapshot(
            timestamp = System.currentTimeMillis(),
            totalAssets = totalAssets,
            totalLiabilities = totalLiabilities,
            netWorth = netWorth,
            note = note.ifBlank { "Snapshot" }
        )
        return snapshotDao.insertSnapshot(snapshot)
    }

    suspend fun deleteSnapshot(snapshot: NetWorthSnapshot) {
        snapshotDao.deleteSnapshot(snapshot)
    }

    suspend fun insertLedgerEntry(entry: LedgerEntry): Long {
        return ledgerDao.insertLedgerEntry(entry)
    }

    suspend fun deleteLedgerEntry(entry: LedgerEntry) {
        ledgerDao.deleteLedgerEntry(entry)
    }

    suspend fun insertReminder(reminder: FinancialReminder): Long {
        return reminderDao.insertReminder(reminder)
    }

    suspend fun updateReminder(reminder: FinancialReminder) {
        reminderDao.updateReminder(reminder)
    }

    suspend fun deleteReminder(reminder: FinancialReminder) {
        reminderDao.deleteReminder(reminder)
    }

    suspend fun deleteReminderById(id: Long) {
        reminderDao.deleteReminderById(id)
    }

    suspend fun setReminderCompleted(id: Long, completed: Boolean) {
        reminderDao.updateCompletionStatus(id, completed)
    }

    suspend fun clearAllData() {
        itemDao.deleteAllItems()
        snapshotDao.deleteAllSnapshots()
        ledgerDao.deleteAllLedgerEntries()
        reminderDao.deleteAllReminders()
        reminderDao.deleteAllSimpleReminders()
    }

    fun exportToJson(
        items: List<FinancialItem>,
        snapshots: List<NetWorthSnapshot>,
        ledgerEntries: List<LedgerEntry> = emptyList(),
        reminders: List<FinancialReminder> = emptyList()
    ): String {
        val root = JSONObject()

        val itemsArr = JSONArray()
        for (item in items) {
            val obj = JSONObject().apply {
                put("id", item.id)
                put("title", item.title)
                put("institution", item.institution)
                put("accountNumber", item.accountNumber)
                put("owner", item.owner)
                put("category", item.category)
                put("currentValue", item.currentValue)
                put("investedValue", item.investedValue)
                put("isLiability", item.isLiability)
                put("notes", item.notes)
                put("sourceAccountTitle", item.sourceAccountTitle)
                put("updatedAt", item.updatedAt)
            }
            itemsArr.put(obj)
        }
        root.put("items", itemsArr)

        val snapArr = JSONArray()
        for (snap in snapshots) {
            val obj = JSONObject().apply {
                put("id", snap.id)
                put("timestamp", snap.timestamp)
                put("totalAssets", snap.totalAssets)
                put("totalLiabilities", snap.totalLiabilities)
                put("netWorth", snap.netWorth)
                put("note", snap.note)
            }
            snapArr.put(obj)
        }
        root.put("snapshots", snapArr)

        val remArr = JSONArray()
        for (rem in reminders) {
            val obj = JSONObject().apply {
                put("id", rem.id)
                put("title", rem.title)
                put("amount", rem.amount)
                put("reminderType", rem.reminderType)
                put("priority", rem.priority)
                put("dueDateEpochDay", rem.dueDateEpochDay)
                put("frequency", rem.frequency)
                put("owner", rem.owner)
                put("associatedAccount", rem.associatedAccount)
                put("notes", rem.notes)
                put("isCompleted", rem.isCompleted)
                put("createdAt", rem.createdAt)
            }
            remArr.put(obj)
        }
        root.put("reminders", remArr)

        val ledArr = JSONArray()
        for (led in ledgerEntries) {
            val obj = JSONObject().apply {
                put("id", led.id)
                put("timestamp", led.timestamp)
                put("transactionTitle", led.transactionTitle)
                put("accountName", led.accountName)
                put("oppositeAccountName", led.oppositeAccountName)
                put("entryType", led.entryType)
                put("debitAmount", led.debitAmount)
                put("creditAmount", led.creditAmount)
                put("runningBalance", led.runningBalance)
                put("category", led.category)
                put("notes", led.notes)
            }
            ledArr.put(obj)
        }
        root.put("ledger", ledArr)

        return root.toString(2)
    }

    suspend fun importFromJson(jsonStr: String, clearExisting: Boolean = false): Boolean {
        return try {
            val root = JSONObject(jsonStr)
            if (clearExisting) {
                clearAllData()
            }

            if (root.has("items")) {
                val itemsArr = root.getJSONArray("items")
                val items = mutableListOf<FinancialItem>()
                for (i in 0 until itemsArr.length()) {
                    val obj = itemsArr.getJSONObject(i)
                    items.add(
                        FinancialItem(
                            title = obj.optString("title", "Unnamed Asset"),
                            institution = obj.optString("institution", ""),
                            accountNumber = obj.optString("accountNumber", ""),
                            owner = obj.optString("owner", "Self"),
                            category = obj.optString("category", "Bank Account"),
                            currentValue = obj.optDouble("currentValue", 0.0),
                            investedValue = obj.optDouble("investedValue", 0.0),
                            isLiability = obj.optBoolean("isLiability", false),
                            notes = obj.optString("notes", ""),
                            sourceAccountTitle = obj.optString("sourceAccountTitle", ""),
                            updatedAt = obj.optLong("updatedAt", System.currentTimeMillis())
                        )
                    )
                }
                itemDao.insertItems(items)
            }

            if (root.has("reminders")) {
                val remArr = root.getJSONArray("reminders")
                val reminders = mutableListOf<FinancialReminder>()
                for (i in 0 until remArr.length()) {
                    val obj = remArr.getJSONObject(i)
                    reminders.add(
                        FinancialReminder(
                            title = obj.optString("title", "Reminder"),
                            amount = obj.optDouble("amount", 0.0),
                            reminderType = obj.optString("reminderType", "DUE_DATE"),
                            priority = obj.optString("priority", "MEDIUM"),
                            dueDateEpochDay = obj.optLong("dueDateEpochDay", 0L),
                            frequency = obj.optString("frequency", "ONE_TIME"),
                            owner = obj.optString("owner", "Self"),
                            associatedAccount = obj.optString("associatedAccount", ""),
                            notes = obj.optString("notes", ""),
                            isCompleted = obj.optBoolean("isCompleted", false),
                            createdAt = obj.optLong("createdAt", System.currentTimeMillis())
                        )
                    )
                }
                reminderDao.insertReminders(reminders)
            }

            if (root.has("ledger")) {
                val ledArr = root.getJSONArray("ledger")
                val ledger = mutableListOf<LedgerEntry>()
                for (i in 0 until ledArr.length()) {
                    val obj = ledArr.getJSONObject(i)
                    ledger.add(
                        LedgerEntry(
                            timestamp = obj.optLong("timestamp", System.currentTimeMillis()),
                            transactionTitle = obj.optString("transactionTitle", "Transaction"),
                            accountName = obj.optString("accountName", ""),
                            oppositeAccountName = obj.optString("oppositeAccountName", ""),
                            entryType = obj.optString("entryType", "DEBIT"),
                            debitAmount = obj.optDouble("debitAmount", 0.0),
                            creditAmount = obj.optDouble("creditAmount", 0.0),
                            runningBalance = obj.optDouble("runningBalance", 0.0),
                            category = obj.optString("category", "General"),
                            notes = obj.optString("notes", "")
                        )
                    )
                }
                ledgerDao.insertLedgerEntries(ledger)
            }

            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}
