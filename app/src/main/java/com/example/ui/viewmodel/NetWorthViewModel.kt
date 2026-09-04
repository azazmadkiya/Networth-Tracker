package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.db.AppDatabase
import com.example.data.model.FinancialItem
import com.example.data.model.FinancialReminder
import com.example.data.model.ItemCategory
import com.example.data.model.LedgerEntry
import com.example.data.model.NetWorthSnapshot
import com.example.data.repository.NetWorthRepository
import com.example.data.security.AuthManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.random.Random

class NetWorthViewModel(application: Application) : AndroidViewModel(application) {
    private val database = AppDatabase.getInstance(application)
    val repository = NetWorthRepository(
        database.financialItemDao(),
        database.snapshotDao(),
        database.ledgerDao(),
        database.reminderDao()
    )
    val authManager = AuthManager(application)

    private val _isLoggedIn = MutableStateFlow(authManager.isLoggedIn())
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    val selectedOwnerFilter = MutableStateFlow("All")
    val selectedCategoryFilter = MutableStateFlow("All")
    val searchQuery = MutableStateFlow("")

    val isLiveStockTracking = MutableStateFlow(false)
    private val liveTickCount = MutableStateFlow(0)

    val allItems: StateFlow<List<FinancialItem>> = repository.allItems.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    val allLedgerEntries: StateFlow<List<LedgerEntry>> = repository.allLedgerEntries.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    val allReminders: StateFlow<List<FinancialReminder>> = repository.allReminders.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    val snapshots: StateFlow<List<NetWorthSnapshot>> = repository.allSnapshots.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    // Stock price simulator loop
    init {
        viewModelScope.launch {
            while (true) {
                delay(3000)
                if (isLiveStockTracking.value) {
                    liveTickCount.value += 1
                }
            }
        }
    }

    val liveItems: StateFlow<List<FinancialItem>> = combine(
        allItems,
        liveTickCount,
        isLiveStockTracking
    ) { items, tick, isTracking ->
        if (!isTracking || tick == 0) {
            items
        } else {
            items.map { item ->
                if (item.category == ItemCategory.SHARE_MARKET.displayName) {
                    val deltaPercent = (Random.nextDouble(-0.8, 0.9) / 100.0)
                    val newCurrent = (item.currentValue * (1.0 + deltaPercent)).coerceAtLeast(1.0)
                    item.copy(currentValue = newCurrent)
                } else {
                    item
                }
            }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val filteredItems: StateFlow<List<FinancialItem>> = combine(
        liveItems,
        selectedOwnerFilter,
        selectedCategoryFilter,
        searchQuery
    ) { items, owner, category, query ->
        items.filter { item ->
            val matchesOwner = owner == "All" || item.owner.equals(owner, ignoreCase = true)
            val matchesCategory = category == "All" || item.category.equals(category, ignoreCase = true)
            val matchesQuery = query.isBlank() ||
                item.title.contains(query, ignoreCase = true) ||
                item.institution.contains(query, ignoreCase = true) ||
                item.category.contains(query, ignoreCase = true) ||
                item.notes.contains(query, ignoreCase = true)
            matchesOwner && matchesCategory && matchesQuery
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val summary: StateFlow<NetWorthSummary> = combine(
        liveItems,
        selectedOwnerFilter
    ) { items, owner ->
        val relevantItems = if (owner == "All") items else items.filter { it.owner.equals(owner, ignoreCase = true) }

        var totalAssets = 0.0
        var totalLiabilities = 0.0
        var totalInvested = 0.0
        var totalStockWorth = 0.0
        var totalStockInvested = 0.0

        for (item in relevantItems) {
            if (item.isLiability) {
                totalLiabilities += item.currentValue
            } else {
                totalAssets += item.currentValue
                totalInvested += item.investedValue
                if (item.category == ItemCategory.SHARE_MARKET.displayName) {
                    totalStockWorth += item.currentValue
                    totalStockInvested += item.investedValue
                }
            }
        }

        val netWorth = totalAssets - totalLiabilities
        val totalProfitLoss = totalAssets - totalInvested
        val profitLossPercentage = if (totalInvested > 0.0) (totalProfitLoss / totalInvested) * 100.0 else 0.0
        val totalStockProfitLoss = totalStockWorth - totalStockInvested

        NetWorthSummary(
            totalAssets = totalAssets,
            totalLiabilities = totalLiabilities,
            netWorth = netWorth,
            totalInvested = totalInvested,
            totalProfitLoss = totalProfitLoss,
            profitLossPercentage = profitLossPercentage,
            totalStockWorth = totalStockWorth,
            totalStockProfitLoss = totalStockProfitLoss
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NetWorthSummary())

    val categorySummaries: StateFlow<List<CategorySummary>> = combine(
        liveItems,
        selectedOwnerFilter
    ) { items, owner ->
        val relevantItems = if (owner == "All") items else items.filter { it.owner.equals(owner, ignoreCase = true) }
        val totalWorth = relevantItems.filter { !it.isLiability }.sumOf { it.currentValue }

        val grouped = relevantItems.groupBy { it.category }
        grouped.map { (catName, catItems) ->
            val sum = catItems.sumOf { it.currentValue }
            val isLiab = catItems.any { it.isLiability }
            val pct = if (totalWorth > 0.0 && !isLiab) ((sum / totalWorth) * 100.0).toFloat() else 0f
            CategorySummary(
                category = catName,
                totalValue = sum,
                percentage = pct,
                isLiability = isLiab
            )
        }.sortedByDescending { it.totalValue }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val ownerSummaries: StateFlow<List<OwnerSummary>> = liveItems.combine(allItems) { liveList, _ ->
        val totalAssetsAll = liveList.filter { !it.isLiability }.sumOf { it.currentValue }
        val groupedByOwner = liveList.groupBy { it.owner }

        groupedByOwner.map { (ownerName, ownerItems) ->
            val assets = ownerItems.filter { !it.isLiability }.sumOf { it.currentValue }
            val liab = ownerItems.filter { it.isLiability }.sumOf { it.currentValue }
            val nw = assets - liab
            val pct = if (totalAssetsAll > 0.0) ((assets / totalAssetsAll) * 100.0).toFloat() else 0f
            val stocks = ownerItems.filter { it.category == ItemCategory.SHARE_MARKET.displayName }
            val stockWorth = stocks.sumOf { it.currentValue }
            val stockInvested = stocks.sumOf { it.investedValue }

            OwnerSummary(
                owner = ownerName,
                totalAssets = assets,
                totalLiabilities = liab,
                netWorth = nw,
                percentage = pct,
                stockWorth = stockWorth,
                stockProfitLoss = stockWorth - stockInvested
            )
        }.sortedByDescending { it.netWorth }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun saveFinancialItem(item: FinancialItem) {
        viewModelScope.launch {
            if (item.id == 0L) {
                repository.insertItem(item)
            } else {
                repository.updateItem(item)
            }
        }
    }

    fun deleteFinancialItem(item: FinancialItem) {
        viewModelScope.launch {
            repository.deleteItem(item)
        }
    }

    fun saveReminder(reminder: FinancialReminder) {
        viewModelScope.launch {
            if (reminder.id == 0L) {
                repository.insertReminder(reminder)
            } else {
                repository.updateReminder(reminder)
            }
        }
    }

    fun deleteReminder(reminder: FinancialReminder) {
        viewModelScope.launch {
            repository.deleteReminder(reminder)
        }
    }

    fun setReminderCompleted(id: Long, completed: Boolean) {
        viewModelScope.launch {
            repository.setReminderCompleted(id, completed)
        }
    }

    fun postDirectLedgerEntry(entry: LedgerEntry) {
        viewModelScope.launch {
            repository.insertLedgerEntry(entry)
        }
    }

    fun deleteLedgerEntry(entry: LedgerEntry) {
        viewModelScope.launch {
            repository.deleteLedgerEntry(entry)
        }
    }

    fun recordSnapshot(note: String = "") {
        viewModelScope.launch {
            repository.recordSnapshot(note, liveItems.value)
        }
    }

    fun deleteSnapshot(snapshot: NetWorthSnapshot) {
        viewModelScope.launch {
            repository.deleteSnapshot(snapshot)
        }
    }

    fun clearAllData() {
        viewModelScope.launch {
            repository.clearAllData()
        }
    }

    fun exportBackupJson(): String {
        return repository.exportToJson(
            items = liveItems.value,
            snapshots = snapshots.value,
            ledgerEntries = allLedgerEntries.value,
            reminders = allReminders.value
        )
    }

    fun importBackupJson(json: String, clearExisting: Boolean = false, onComplete: (Boolean) -> Unit) {
        viewModelScope.launch {
            val result = repository.importFromJson(json, clearExisting)
            onComplete(result)
        }
    }

    fun executeVoiceAction(action: ParsedVoiceAction, onComplete: (String) -> Unit) {
        viewModelScope.launch {
            when (action) {
                is ParsedVoiceAction.AddAccountAction -> {
                    repository.insertItem(action.accountItem)
                    if (action.initialBalance > 0.0) {
                        repository.insertLedgerEntry(
                            LedgerEntry(
                                timestamp = System.currentTimeMillis(),
                                transactionTitle = "Opening Balance",
                                accountName = action.accountItem.title,
                                oppositeAccountName = "Initial Deposit",
                                entryType = "CREDIT",
                                debitAmount = 0.0,
                                creditAmount = action.initialBalance,
                                runningBalance = action.initialBalance,
                                category = ItemCategory.BANK_ACCOUNT.displayName,
                                notes = "Account opened via Voice Control"
                            )
                        )
                    }
                    onComplete("Added Account '${action.accountItem.title}' with balance ₹ ${String.format("%.0f", action.initialBalance)}!")
                }
                is ParsedVoiceAction.AddReminderAction -> {
                    val id = repository.insertReminder(action.reminder)
                    onComplete("Added reminder '${action.reminder.title}' successfully!")
                }
                is ParsedVoiceAction.AddFinancialItemAction -> {
                    val id = repository.insertItem(action.item)
                    onComplete("Added '${action.item.title}' (${action.item.category}) successfully!")
                }
                is ParsedVoiceAction.AddLedgerAction -> {
                    val id = repository.insertLedgerEntry(action.entry)
                    onComplete("Recorded ${action.entry.entryType} of ₹ ${String.format("%.0f", action.entry.debitAmount + action.entry.creditAmount)} successfully!")
                }
                is ParsedVoiceAction.TakeSnapshotAction -> {
                    repository.recordSnapshot(action.note, liveItems.value)
                    onComplete("Portfolio snapshot recorded!")
                }
                is ParsedVoiceAction.NavigateAction -> {
                    onComplete("Navigating to ${action.targetScreen}")
                }
                is ParsedVoiceAction.UnknownAction -> {
                    onComplete("Command not recognized. Please try again.")
                }
            }
        }
    }

    fun setLoggedIn(loggedIn: Boolean) {
        authManager.setLoggedIn(loggedIn)
        _isLoggedIn.value = loggedIn
    }

    fun logout() {
        authManager.logout()
        _isLoggedIn.value = false
    }
}
