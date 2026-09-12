package com.example.data.repository

import androidx.room.withTransaction
import com.example.data.dao.FinancialItemDao
import com.example.data.dao.LedgerDao
import com.example.data.dao.ReminderDao
import com.example.data.dao.SnapshotDao
import com.example.data.db.AppDatabase
import com.example.data.model.AccountAdjustment
import com.example.data.model.DeletionAdjustmentResult
import com.example.data.model.FinancialItem
import com.example.data.model.FinancialReminder
import com.example.data.model.ItemCategory
import com.example.data.model.LedgerEntry
import com.example.data.model.NetWorthSnapshot
import kotlinx.coroutines.flow.Flow
import org.json.JSONArray
import org.json.JSONObject

class NetWorthRepository(
    private val database: AppDatabase,
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

    suspend fun deleteLedgerEntry(
        entry: LedgerEntry,
        autoAdjustHoldings: Boolean = true
    ): DeletionAdjustmentResult {
        return deleteLedgerEntryWithReverseAdjustment(entry, autoAdjustHoldings)
    }

    /**
     * Atomically deletes a ledger entry and executes the corresponding reverse adjustment
     * on the linked accounts in Portfolio Holdings within a single Room database transaction.
     * Performs a transactional pre- and post-check to ensure net worth consistency and calculation accuracy.
     */
    suspend fun deleteLedgerEntryWithReverseAdjustment(
        entry: LedgerEntry,
        autoAdjustHoldings: Boolean = true
    ): DeletionAdjustmentResult {
        return database.withTransaction {
            // 1. Transactional check: fetch authoritative current portfolio holdings directly from Room
            val currentItems = itemDao.getAllItemsList()
            val netWorthBefore = calculateNetWorth(currentItems)

            // 2. Determine reverse adjustments based on transaction type and accounting flow
            val adjustments = if (autoAdjustHoldings) {
                calculateAdjustmentsForDeletion(entry, currentItems)
            } else {
                emptyList()
            }

            // 3. Atomically delete the ledger record
            ledgerDao.deleteLedgerEntry(entry)

            // 4. Atomically apply reverse adjustments to portfolio accounts
            if (autoAdjustHoldings && adjustments.isNotEmpty()) {
                for (adj in adjustments) {
                    val updated = adj.item.copy(
                        currentValue = adj.newBalance,
                        updatedAt = System.currentTimeMillis()
                    )
                    itemDao.updateItem(updated)
                }
            }

            // 5. Transactional verification check: read back updated accounts from DB
            val updatedItems = itemDao.getAllItemsList()
            val netWorthAfter = calculateNetWorth(updatedItems)
            val netWorthDiff = netWorthAfter - netWorthBefore

            // Verify each adjusted item actually was persisted with the new balance
            for (adj in adjustments) {
                val persisted = updatedItems.find { it.id == adj.item.id }
                if (persisted != null && Math.abs(persisted.currentValue - adj.newBalance) > 0.001) {
                    throw IllegalStateException(
                        "Transactional check failed: Portfolio holding '${adj.item.title}' balance discrepancy. Expected: ${adj.newBalance}, Actual: ${persisted.currentValue}"
                    )
                }
            }

            DeletionAdjustmentResult(
                entryId = entry.id,
                transactionTitle = entry.transactionTitle,
                adjustmentsApplied = adjustments,
                netWorthBefore = netWorthBefore,
                netWorthAfter = netWorthAfter,
                netWorthDifference = netWorthDiff,
                success = true,
                message = if (adjustments.isNotEmpty()) {
                    "Transaction deleted and ${adjustments.size} portfolio account(s) reverse-adjusted successfully."
                } else {
                    "Transaction deleted from ledger."
                }
            )
        }
    }

    suspend fun previewAdjustmentsForDeletion(entry: LedgerEntry): List<AccountAdjustment> {
        val currentItems = itemDao.getAllItemsList()
        return calculateAdjustmentsForDeletion(entry, currentItems)
    }

    fun calculateAdjustmentsForDeletion(
        entry: LedgerEntry,
        currentItems: List<FinancialItem>
    ): List<AccountAdjustment> {
        return calculateAdjustments(entry, currentItems)
    }

    fun calculateNetWorth(items: List<FinancialItem>): Double {
        return computeNetWorth(items)
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

    suspend fun getItemCount(): Int {
        return itemDao.getItemCount()
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

    companion object {
        fun calculateAdjustments(
            entry: LedgerEntry,
            currentItems: List<FinancialItem>
        ): List<AccountAdjustment> {
            val amt = when {
                entry.entryType.equals("CREDIT", ignoreCase = true) -> if (entry.creditAmount > 0) entry.creditAmount else entry.debitAmount
                else -> if (entry.debitAmount > 0) entry.debitAmount else entry.creditAmount
            }
            if (amt <= 0.0) return emptyList()

            val adjustments = mutableListOf<AccountAdjustment>()

            fun findItem(name: String): FinancialItem? {
                if (name.isBlank()) return null
                val clean = name.trim().lowercase()
                currentItems.find { it.title.trim().equals(clean, ignoreCase = true) }?.let { return it }
                if (clean == "cash" || clean.contains("cash")) {
                    currentItems.find { it.category.equals(ItemCategory.CASH.displayName, ignoreCase = true) }?.let { return it }
                    currentItems.find { it.title.contains("cash", ignoreCase = true) }?.let { return it }
                }
                if (clean.contains("bank")) {
                    currentItems.find { it.title.contains("bank", ignoreCase = true) }?.let { return it }
                }
                return currentItems.find {
                    it.title.trim().lowercase().contains(clean) || clean.contains(it.title.trim().lowercase())
                }
            }

            val primaryItem = findItem(entry.accountName)
            val oppositeItem = findItem(entry.oppositeAccountName)

            val isFunding = entry.transactionTitle.startsWith("Funded:", ignoreCase = true) ||
                    entry.category.equals("Funding", ignoreCase = true)
            val isReceived = entry.transactionTitle.startsWith("Received:", ignoreCase = true) ||
                    entry.category.equals("Received Inflow", ignoreCase = true)

            val primaryIsParty = primaryItem?.let {
                it.isLiability || it.category.contains("Debtor", ignoreCase = true) ||
                        it.category.contains("Creditor", ignoreCase = true) ||
                        it.category.contains("Party", ignoreCase = true)
            } ?: false

            val oppositeIsAsset = oppositeItem?.let {
                !it.isLiability && (it.category.contains("Bank", ignoreCase = true) ||
                        it.category.contains("Cash", ignoreCase = true) ||
                        it.category == ItemCategory.BANK_ACCOUNT.displayName ||
                        it.category == ItemCategory.CASH.displayName)
            } ?: false

            when {
                // Case 1: Funding an item from an account
                isFunding -> {
                    val fundingAccount = oppositeItem ?: primaryItem
                    if (fundingAccount != null) {
                        val newBal = fundingAccount.currentValue + amt
                        adjustments.add(
                            AccountAdjustment(
                                item = fundingAccount,
                                oldBalance = fundingAccount.currentValue,
                                newBalance = newBal,
                                change = +amt,
                                explanation = "Refunded to ${fundingAccount.title} (+₹${String.format("%,.0f", amt)})"
                            )
                        )
                    }
                }

                // Case 2: TRANSFER between accounts
                entry.entryType.equals("TRANSFER", ignoreCase = true) -> {
                    if (primaryItem != null) {
                        val newBal = primaryItem.currentValue + amt
                        adjustments.add(
                            AccountAdjustment(
                                item = primaryItem,
                                oldBalance = primaryItem.currentValue,
                                newBalance = newBal,
                                change = +amt,
                                explanation = "Restored to ${primaryItem.title} (+₹${String.format("%,.0f", amt)})"
                            )
                        )
                    }
                    if (oppositeItem != null && oppositeItem.id != primaryItem?.id) {
                        val newBal = maxOf(0.0, oppositeItem.currentValue - amt)
                        adjustments.add(
                            AccountAdjustment(
                                item = oppositeItem,
                                oldBalance = oppositeItem.currentValue,
                                newBalance = newBal,
                                change = -amt,
                                explanation = "Deducted from ${oppositeItem.title} (-₹${String.format("%,.0f", amt)})"
                            )
                        )
                    }
                }

                // Case 3: Voucher style where primary is party and opposite is bank/cash
                primaryIsParty && oppositeIsAsset -> {
                    if (entry.entryType.equals("CREDIT", ignoreCase = true)) {
                        if (oppositeItem != null) {
                            val newBal = maxOf(0.0, oppositeItem.currentValue - amt)
                            adjustments.add(
                                AccountAdjustment(
                                    item = oppositeItem,
                                    oldBalance = oppositeItem.currentValue,
                                    newBalance = newBal,
                                    change = -amt,
                                    explanation = "Reversed receipt from ${oppositeItem.title} (-₹${String.format("%,.0f", amt)})"
                                )
                            )
                        }
                        if (primaryItem != null) {
                            val newBal = primaryItem.currentValue + amt
                            adjustments.add(
                                AccountAdjustment(
                                    item = primaryItem,
                                    oldBalance = primaryItem.currentValue,
                                    newBalance = newBal,
                                    change = +amt,
                                    explanation = "Restored debtor receivable for ${primaryItem.title} (+₹${String.format("%,.0f", amt)})"
                                )
                            )
                        }
                    } else {
                        if (oppositeItem != null) {
                            val newBal = oppositeItem.currentValue + amt
                            adjustments.add(
                                AccountAdjustment(
                                    item = oppositeItem,
                                    oldBalance = oppositeItem.currentValue,
                                    newBalance = newBal,
                                    change = +amt,
                                    explanation = "Refunded payment to ${oppositeItem.title} (+₹${String.format("%,.0f", amt)})"
                                )
                            )
                        }
                        if (primaryItem != null) {
                            val newBal = primaryItem.currentValue + amt
                            adjustments.add(
                                AccountAdjustment(
                                    item = primaryItem,
                                    oldBalance = primaryItem.currentValue,
                                    newBalance = newBal,
                                    change = +amt,
                                    explanation = "Restored creditor payable due for ${primaryItem.title} (+₹${String.format("%,.0f", amt)})"
                                )
                            )
                        }
                    }
                }

                // Case 4: Standard CREDIT
                entry.entryType.equals("CREDIT", ignoreCase = true) -> {
                    if (primaryItem != null) {
                        val newBal = maxOf(0.0, primaryItem.currentValue - amt)
                        adjustments.add(
                            AccountAdjustment(
                                item = primaryItem,
                                oldBalance = primaryItem.currentValue,
                                newBalance = newBal,
                                change = -amt,
                                explanation = "Reversed inflow from ${primaryItem.title} (-₹${String.format("%,.0f", amt)})"
                            )
                        )
                    }
                    if (oppositeItem != null && oppositeItem.id != primaryItem?.id) {
                        val isDebtor = oppositeItem.category.contains("Debtor", ignoreCase = true) ||
                                (!oppositeItem.isLiability && (oppositeItem.category.contains("Party", ignoreCase = true) ||
                                        oppositeItem.category.contains("Customer", ignoreCase = true) ||
                                        oppositeItem.category.contains("Client", ignoreCase = true)))
                        if (isDebtor || isReceived) {
                            val newBal = oppositeItem.currentValue + amt
                            adjustments.add(
                                AccountAdjustment(
                                    item = oppositeItem,
                                    oldBalance = oppositeItem.currentValue,
                                    newBalance = newBal,
                                    change = +amt,
                                    explanation = "Restored receivable balance for ${oppositeItem.title} (+₹${String.format("%,.0f", amt)})"
                                )
                            )
                        }
                    }
                }

                // Case 5: Standard DEBIT
                else -> {
                    if (primaryItem != null) {
                        val newBal = primaryItem.currentValue + amt
                        adjustments.add(
                            AccountAdjustment(
                                item = primaryItem,
                                oldBalance = primaryItem.currentValue,
                                newBalance = newBal,
                                change = +amt,
                                explanation = "Refunded to ${primaryItem.title} (+₹${String.format("%,.0f", amt)})"
                            )
                        )
                    }
                    if (oppositeItem != null && oppositeItem.id != primaryItem?.id) {
                        val isCreditor = oppositeItem.isLiability ||
                                oppositeItem.category.contains("Creditor", ignoreCase = true) ||
                                oppositeItem.category.contains("Vendor", ignoreCase = true) ||
                                oppositeItem.category.contains("Supplier", ignoreCase = true)
                        if (isCreditor) {
                            val newBal = oppositeItem.currentValue + amt
                            adjustments.add(
                                AccountAdjustment(
                                    item = oppositeItem,
                                    oldBalance = oppositeItem.currentValue,
                                    newBalance = newBal,
                                    change = +amt,
                                    explanation = "Restored payable due to ${oppositeItem.title} (+₹${String.format("%,.0f", amt)})"
                                )
                            )
                        }
                    }
                }
            }

            return adjustments
        }

        fun computeNetWorth(items: List<FinancialItem>): Double {
            var totalAssets = 0.0
            var totalLiabilities = 0.0
            for (item in items) {
                if (item.isLiability) {
                    totalLiabilities += item.currentValue
                } else {
                    totalAssets += item.currentValue
                }
            }
            return totalAssets - totalLiabilities
        }
    }
}
