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
import com.example.data.backup.OfflineBackupManager
import com.example.data.backup.OfflineBackupSummary
import com.example.data.repository.NetWorthRepository
import com.example.data.security.AuthManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    private val _themeMode = MutableStateFlow(authManager.getThemeMode())
    val themeMode: StateFlow<String> = _themeMode.asStateFlow()

    fun setThemeMode(mode: String) {
        authManager.setThemeMode(mode)
        _themeMode.value = mode
    }

    private val _isLoggedIn = MutableStateFlow(authManager.isLoggedIn())
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()
    
    private val _isAppUnlocked = MutableStateFlow(false)
    val isAppUnlocked: StateFlow<Boolean> = _isAppUnlocked.asStateFlow()

    fun setAppUnlocked(unlocked: Boolean) {
        _isAppUnlocked.value = unlocked
    }

    val offlineBackupSummary = MutableStateFlow<OfflineBackupSummary?>(null)
    val recoveryBannerMessage = MutableStateFlow<String?>(null)

    val selectedOwnerFilter = MutableStateFlow("All")
    val selectedCategoryFilter = MutableStateFlow("All")
    val searchQuery = MutableStateFlow("")

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

    private val prefs = application.getSharedPreferences("app_prefs", android.content.Context.MODE_PRIVATE)

    private val _customCategories = MutableStateFlow<List<String>>(emptyList())
    val customCategories: StateFlow<List<String>> = _customCategories.asStateFlow()

    init {
        loadCustomCategories()
    }

    private fun loadCustomCategories() {
        val cats = prefs.getStringSet("custom_categories", emptySet())?.toList()?.sorted() ?: emptyList()
        _customCategories.value = cats
    }

    fun addCustomCategory(category: String) {
        val current = prefs.getStringSet("custom_categories", emptySet()) ?: emptySet()
        val newSet = current.toMutableSet().apply { add(category) }
        prefs.edit().putStringSet("custom_categories", newSet).apply()
        loadCustomCategories()
    }

    fun updateCustomCategory(oldCategory: String, newCategory: String) {
        val current = prefs.getStringSet("custom_categories", emptySet()) ?: emptySet()
        val newSet = current.toMutableSet().apply {
            remove(oldCategory)
            add(newCategory)
        }
        prefs.edit().putStringSet("custom_categories", newSet).apply()
        
        viewModelScope.launch(Dispatchers.IO) {
            val items = database.financialItemDao().getAllItemsList()
            val itemsToUpdate = items.filter { it.category == oldCategory }
            itemsToUpdate.forEach { 
                database.financialItemDao().updateItem(it.copy(category = newCategory)) 
            }
        }

        loadCustomCategories()
    }

    fun deleteCustomCategory(category: String) {
        val current = prefs.getStringSet("custom_categories", emptySet()) ?: emptySet()
        val newSet = current.toMutableSet().apply { remove(category) }
        prefs.edit().putStringSet("custom_categories", newSet).apply()
        
        viewModelScope.launch(Dispatchers.IO) {
            val items = database.financialItemDao().getAllItemsList()
            val itemsToUpdate = items.filter { it.category == category }
            itemsToUpdate.forEach { 
                database.financialItemDao().updateItem(it.copy(category = "Other Account")) 
            }
        }
        
        loadCustomCategories()
    }

    val liveItems: StateFlow<List<FinancialItem>> = allItems

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
                if (item.category == ItemCategory.SHARE_MARKET.displayName ||
                    item.category == ItemCategory.MUTUAL_FUNDS.displayName ||
                    item.category == ItemCategory.IPO.displayName) {
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
            val stocks = ownerItems.filter { 
                it.category == ItemCategory.SHARE_MARKET.displayName ||
                it.category == ItemCategory.MUTUAL_FUNDS.displayName ||
                it.category == ItemCategory.IPO.displayName
            }
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
        viewModelScope.launch(Dispatchers.IO) {
            repository.clearAllData()
            OfflineBackupManager.deleteOfflineBackup(getApplication())
            offlineBackupSummary.value = null
            recoveryBannerMessage.value = null
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
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.importFromJson(json, clearExisting)
            onComplete(result)
        }
    }

    fun exportBackupToUri(uri: android.net.Uri, context: android.content.Context, onComplete: (Boolean, String) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val json = exportBackupJson()
                context.contentResolver.openOutputStream(uri)?.use { outputStream ->
                    outputStream.write(json.toByteArray())
                }
                withContext(Dispatchers.Main) {
                    onComplete(true, "Backup saved successfully")
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onComplete(false, "Failed to save backup: ${e.message}")
                }
            }
        }
    }

    fun importBackupFromUri(uri: android.net.Uri, context: android.content.Context, onComplete: (Boolean, String) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val json = context.contentResolver.openInputStream(uri)?.use { inputStream ->
                    inputStream.bufferedReader().use { it.readText() }
                }
                if (!json.isNullOrBlank()) {
                    val result = repository.importFromJson(json, clearExisting = false)
                    withContext(Dispatchers.Main) {
                        if (result) {
                            onComplete(true, "Backup restored successfully")
                        } else {
                            onComplete(false, "Failed to parse backup file")
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        onComplete(false, "Selected file is empty")
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onComplete(false, "Failed to read backup file: ${e.message}")
                }
            }
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

    init {
        checkAndAutoRecoverOfflineData()
        observeAndAutoPersistOfflineBackup()
    }

    fun checkAndAutoRecoverOfflineData() {
        viewModelScope.launch(Dispatchers.IO) {
            val app = getApplication<Application>()
            val summary = OfflineBackupManager.getOfflineBackupSummary(app)
            offlineBackupSummary.value = summary
            // Do NOT automatically inject or restore data on launch.
            // The app starts completely clean with zero pre-added data.
        }
    }

    private fun observeAndAutoPersistOfflineBackup() {
        viewModelScope.launch(Dispatchers.IO) {
            combine(allItems, allLedgerEntries, allReminders) { items, ledger, reminders ->
                Triple(items, ledger, reminders)
            }.collect { (items, ledger, reminders) ->
                if (items.isNotEmpty() || ledger.isNotEmpty() || reminders.isNotEmpty()) {
                    val json = repository.exportToJson(
                        items = items,
                        snapshots = snapshots.value,
                        ledgerEntries = ledger,
                        reminders = reminders
                    )
                    OfflineBackupManager.saveOfflineBackup(getApplication(), json)
                    offlineBackupSummary.value = OfflineBackupManager.getOfflineBackupSummary(getApplication())
                }
            }
        }
    }

    fun triggerManualOfflineBackup(onComplete: (Boolean, String) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val json = exportBackupJson()
            if (json.isNotBlank()) {
                val success = OfflineBackupManager.saveOfflineBackup(getApplication(), json)
                val summary = OfflineBackupManager.getOfflineBackupSummary(getApplication())
                offlineBackupSummary.value = summary
                onComplete(success, if (success) "Offline backup saved to device storage (Downloads/FamilyNetWorth)!" else "Failed to save offline backup")
            } else {
                onComplete(false, "No financial data available to backup")
            }
        }
    }

    fun restoreFromOfflineBackup(onComplete: (Boolean, String) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val app = getApplication<Application>()
            val json = OfflineBackupManager.readOfflineBackup(app)
            if (!json.isNullOrBlank()) {
                val success = repository.importFromJson(json, clearExisting = false)
                if (success) {
                    val summary = OfflineBackupManager.getOfflineBackupSummary(app)
                    offlineBackupSummary.value = summary
                    recoveryBannerMessage.value = "Data recovered from device storage!"
                    onComplete(true, "Successfully restored ${summary?.itemCount ?: 0} accounts!")
                } else {
                    onComplete(false, "Failed to parse offline backup file")
                }
            } else {
                onComplete(false, "No offline backup file found on device storage")
            }
        }
    }

    fun deleteOfflineBackup(onComplete: (Boolean, String) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val app = getApplication<Application>()
            val deleted = OfflineBackupManager.deleteOfflineBackup(app)
            offlineBackupSummary.value = null
            recoveryBannerMessage.value = null
            onComplete(deleted, if (deleted) "Offline backup file deleted from device" else "No backup file found to delete")
        }
    }

    fun dismissRecoveryBanner() {
        recoveryBannerMessage.value = null
    }
}
