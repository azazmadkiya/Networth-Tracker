package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.db.AppDatabase
import com.example.data.model.FinancialItem
import com.example.data.model.LedgerEntry
import com.example.data.model.NetWorthSnapshot
import com.example.data.repository.NetWorthRepository
import com.example.data.security.AuthManager
import com.example.ui.components.GLOBAL_STOCK_LIST
import com.example.ui.components.StockQuote
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.flow.map
import java.util.Locale

data class CategorySummary(
    val category: String,
    val totalValue: Double,
    val percentage: Float,
    val isLiability: Boolean
)

data class OwnerSummary(
    val owner: String,
    val totalAssets: Double,
    val totalLiabilities: Double,
    val netWorth: Double,
    val percentage: Float,
    val stockWorth: Double = 0.0,
    val stockProfitLoss: Double = 0.0
)

data class NetWorthSummary(
    val totalAssets: Double = 0.0,
    val totalLiabilities: Double = 0.0,
    val netWorth: Double = 0.0,
    val totalInvested: Double = 0.0,
    val totalProfitLoss: Double = 0.0,
    val profitLossPercentage: Double = 0.0,
    val totalStockWorth: Double = 0.0,
    val totalStockProfitLoss: Double = 0.0
)

class NetWorthViewModel(application: Application) : AndroidViewModel(application) {
    private val database = AppDatabase.getInstance(application)
    private val repository = NetWorthRepository(database.financialItemDao(), database.snapshotDao(), database.ledgerDao())
    val authManager = AuthManager(application)

    val isLoggedIn = MutableStateFlow(authManager.isLoggedIn())

    val allLedgerEntries: StateFlow<List<LedgerEntry>> = repository.allLedgerEntries
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Filters
    val selectedOwnerFilter = MutableStateFlow("All") // All, Self, Father, Mother
    val selectedCategoryFilter = MutableStateFlow("All")
    val searchQuery = MutableStateFlow("")

    // Live Stock Tracking Engine State (OFF by default for total offline privacy)
    val isLiveStockTracking = MutableStateFlow(false)
    val liveTickCount = MutableStateFlow(0)

    private val initialStockPrices = mutableMapOf(
        "RELIANCE" to 2980.50,
        "TCS" to 4210.00,
        "INFY" to 1840.25,
        "HDFCBANK" to 1655.00,
        "TATAMOTORS" to 1035.00,
        "ICICIBANK" to 1210.00,
        "SBIN" to 845.50,
        "ITC" to 495.00,
        "BHARTIARTL" to 1480.00,
        "LTIM" to 5620.00,
        "AAPL" to 228.50,
        "GOOGL" to 178.20,
        "NVDA" to 128.40,
        "MSFT" to 448.20,
        "TSLA" to 215.30
    )

    init {
        // Automatic background live market ticker (ticks every 5 seconds when tracking is enabled)
        viewModelScope.launch {
            while (isActive) {
                delay(5000)
                if (isLiveStockTracking.value) {
                    tickLiveStockPrices()
                }
            }
        }
    }

    fun toggleLiveStockTracking() {
        isLiveStockTracking.value = !isLiveStockTracking.value
    }

    fun triggerLiveStockRefresh() {
        tickLiveStockPrices()
    }

    private fun tickLiveStockPrices() {
        try {
            if (GLOBAL_STOCK_LIST.isNotEmpty()) {
                for (i in GLOBAL_STOCK_LIST.indices) {
                    val item = GLOBAL_STOCK_LIST[i]
                    val sym = item.symbol
                    val name = item.name
                    val exch = item.exchange
                    val curPrice = item.currentPrice

                    // Realistic small market price movement between -0.6% and +0.6%
                    val deltaPercent = ((-60..60).random() / 100.0)
                    val newPrice = (curPrice * (1.0 + (deltaPercent / 100.0))).coerceAtLeast(1.0)
                    val formattedPrice = String.format(Locale.US, "%.2f", newPrice).toDouble()

                    val baseP = initialStockPrices.getOrPut(sym.uppercase()) { formattedPrice }
                    val overallChangePct = if (baseP > 0) ((formattedPrice - baseP) / baseP) * 100.0 else deltaPercent
                    val isPos = overallChangePct >= 0

                    GLOBAL_STOCK_LIST[i] = StockQuote(sym, name, exch, formattedPrice, overallChangePct, isPos)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        liveTickCount.value += 1
    }

    val allItems: StateFlow<List<FinancialItem>> = repository.allItems
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Dynamically recalculated items (Offline stock prices by default)
    val liveItems: StateFlow<List<FinancialItem>> = combine(allItems, liveTickCount, isLiveStockTracking) { items, _, isLive ->
        if (!isLive) {
            items
        } else {
            items.map { item ->
                if (isStockCategory(item.category)) {
                    val symbol = parseStockSymbol(item.title)
                    if (symbol.isNotBlank()) {
                        val quotePrice = getStockPriceFromGlobalList(symbol)
                        if (quotePrice != null && quotePrice > 0) {
                            val basePrice = initialStockPrices.getOrPut(symbol.uppercase()) { quotePrice }
                            val ratio = if (basePrice > 0) quotePrice / basePrice else 1.0
                            val liveVal = item.currentValue * ratio
                            item.copy(currentValue = liveVal)
                        } else item
                    } else item
                } else item
            }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private fun isStockCategory(cat: String): Boolean {
        return cat.contains("Share Market", ignoreCase = true) || cat.contains("Stocks", ignoreCase = true)
    }

    private fun parseStockSymbol(title: String): String {
        val parts = title.split("-").map { it.trim() }
        return if (parts.isNotEmpty()) parts[0].uppercase() else ""
    }

    private fun getStockPriceFromGlobalList(symbol: String): Double? {
        return GLOBAL_STOCK_LIST.find { it.symbol.equals(symbol, ignoreCase = true) }?.currentPrice
    }

    val snapshots: StateFlow<List<NetWorthSnapshot>> = repository.allSnapshots
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Filtered Items using live items
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
                    item.category.contains(query, ignoreCase = true) ||
                    item.institution.contains(query, ignoreCase = true) ||
                    item.accountNumber.contains(query, ignoreCase = true) ||
                    item.notes.contains(query, ignoreCase = true)

            matchesOwner && matchesCategory && matchesQuery
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Overall Net Worth Summary using live stock recalculations
    val summary: StateFlow<NetWorthSummary> = combine(liveItems, selectedOwnerFilter) { items, owner ->
        val relevantItems = if (owner == "All") items else items.filter { it.owner.equals(owner, ignoreCase = true) }

        var assets = 0.0
        var liabilities = 0.0
        var invested = 0.0
        var currentValForInvested = 0.0

        var stockWorth = 0.0
        var stockInvested = 0.0

        for (item in relevantItems) {
            if (item.isLiability) {
                liabilities += item.currentValue
            } else {
                assets += item.currentValue
                if (item.investedValue > 0.0) {
                    invested += item.investedValue
                    currentValForInvested += item.currentValue
                }
                if (isStockCategory(item.category)) {
                    stockWorth += item.currentValue
                    if (item.investedValue > 0.0) {
                        stockInvested += item.investedValue
                    }
                }
            }
        }

        val netWorth = assets - liabilities
        val profitLoss = currentValForInvested - invested
        val profitLossPct = if (invested > 0) (profitLoss / invested) * 100.0 else 0.0
        val stockPnl = stockWorth - stockInvested

        NetWorthSummary(
            totalAssets = assets,
            totalLiabilities = liabilities,
            netWorth = netWorth,
            totalInvested = invested,
            totalProfitLoss = profitLoss,
            profitLossPercentage = profitLossPct,
            totalStockWorth = stockWorth,
            totalStockProfitLoss = stockPnl
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NetWorthSummary())

    // Category Summaries using live items
    val categorySummaries: StateFlow<List<CategorySummary>> = liveItems.mapToCategorySummaries()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Owner Summaries (Total Worth by User) using live stock values
    val ownerSummaries: StateFlow<List<OwnerSummary>> = liveItems.mapToOwnerSummaries()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun login(idInput: String, passwordInput: String): Boolean {
        val success = authManager.validateLogin(idInput, passwordInput)
        if (success) {
            isLoggedIn.value = true
        }
        return success
    }

    fun logout() {
        authManager.logout()
        isLoggedIn.value = false
    }

    fun saveFinancialItem(item: FinancialItem) {
        viewModelScope.launch {
            val isNewItem = item.id == 0L
            val insertedId = if (isNewItem) {
                repository.insertItem(item)
            } else {
                repository.updateItem(item)
                item.id
            }

            // Deduct amount from opposite bank/cash account if selected (for IPO, Share Market, Mutual Funds, Expense, Liabilities, Assets)
            if (item.sourceAccountTitle.isNotBlank() && !item.category.contains("Income", ignoreCase = true)) {
                val sourceAcc = allItems.value.find { 
                    it.title.equals(item.sourceAccountTitle, ignoreCase = true) || 
                    "${it.title} (${it.category})".equals(item.sourceAccountTitle, ignoreCase = true)
                }
                val newSourceBal = if (sourceAcc != null && sourceAcc.id != item.id) {
                    val updatedVal = (sourceAcc.currentValue - item.currentValue).coerceAtLeast(0.0)
                    repository.updateItem(sourceAcc.copy(currentValue = updatedVal, updatedAt = System.currentTimeMillis()))
                    updatedVal
                } else 0.0

                // Post Double-Entry Accounting Ledger Records (DR / CR)
                // 1. Debit (DR) entry to Item (IPO / Asset / Stock / Expense) Account
                repository.insertLedgerEntry(
                    LedgerEntry(
                        timestamp = System.currentTimeMillis(),
                        transactionTitle = item.title,
                        accountName = item.title,
                        oppositeAccountName = item.sourceAccountTitle,
                        entryType = "DR",
                        debitAmount = item.currentValue,
                        creditAmount = 0.0,
                        runningBalance = item.currentValue,
                        category = item.category,
                        notes = item.notes
                    )
                )

                // 2. Credit (CR) entry to Source Bank/Cash Account
                val noteDetail = when {
                    item.category.contains("IPO", ignoreCase = true) -> "IPO Application Outflow from ${item.sourceAccountTitle}"
                    item.category.contains("Paid Loan", ignoreCase = true) || item.category.contains("Aapel", ignoreCase = true) || item.category.contains("Chekvel", ignoreCase = true) || item.category.contains("Loan Given", ignoreCase = true) -> "Paid Loan / Loan Given Outflow from ${item.sourceAccountTitle}"
                    item.category.contains("Share", ignoreCase = true) || item.category.contains("Stock", ignoreCase = true) -> "Stock Purchase Outflow from ${item.sourceAccountTitle}"
                    item.category.contains("Mutual", ignoreCase = true) -> "Mutual Fund Investment Outflow from ${item.sourceAccountTitle}"
                    item.category.contains("Expense", ignoreCase = true) -> "Expense Outflow from ${item.sourceAccountTitle}"
                    else -> "Payment Outflow from ${item.sourceAccountTitle}"
                }
                repository.insertLedgerEntry(
                    LedgerEntry(
                        timestamp = System.currentTimeMillis(),
                        transactionTitle = item.title,
                        accountName = item.sourceAccountTitle,
                        oppositeAccountName = item.title,
                        entryType = "CR",
                        debitAmount = 0.0,
                        creditAmount = item.currentValue,
                        runningBalance = newSourceBal,
                        category = item.category,
                        notes = noteDetail
                    )
                )
            } else if (item.sourceAccountTitle.isNotBlank() && item.category.contains("Income", ignoreCase = true)) {
                val targetAcc = allItems.value.find { 
                    it.title.equals(item.sourceAccountTitle, ignoreCase = true) || 
                    "${it.title} (${it.category})".equals(item.sourceAccountTitle, ignoreCase = true)
                }
                val newTargetBal = if (targetAcc != null && targetAcc.id != item.id) {
                    val updatedVal = targetAcc.currentValue + item.currentValue
                    repository.updateItem(targetAcc.copy(currentValue = updatedVal, updatedAt = System.currentTimeMillis()))
                    updatedVal
                } else item.currentValue

                // Post Double-Entry Accounting Ledger Records (DR / CR) for Income Inflow
                // 1. Credit (CR) entry to Income Source / Category
                repository.insertLedgerEntry(
                    LedgerEntry(
                        timestamp = System.currentTimeMillis(),
                        transactionTitle = item.title,
                        accountName = item.title,
                        oppositeAccountName = item.sourceAccountTitle,
                        entryType = "CR",
                        debitAmount = 0.0,
                        creditAmount = item.currentValue,
                        runningBalance = item.currentValue,
                        category = item.category,
                        notes = item.notes
                    )
                )

                // 2. Debit (DR) entry to Target Deposit Bank/Cash Account
                repository.insertLedgerEntry(
                    LedgerEntry(
                        timestamp = System.currentTimeMillis(),
                        transactionTitle = item.title,
                        accountName = item.sourceAccountTitle,
                        oppositeAccountName = item.title,
                        entryType = "DR",
                        debitAmount = item.currentValue,
                        creditAmount = 0.0,
                        runningBalance = newTargetBal,
                        category = item.category,
                        notes = "Income Deposit to ${item.sourceAccountTitle}"
                    )
                )
            } else if (isNewItem && item.currentValue > 0) {
                // For new Asset / Account or Loan, create an opening balance Ledger Record
                if (!item.isLiability) {
                    repository.insertLedgerEntry(
                        LedgerEntry(
                            timestamp = System.currentTimeMillis(),
                            transactionTitle = "Opening Deposit / Asset Added",
                            accountName = item.title,
                            oppositeAccountName = "Capital / Equity",
                            entryType = "DR",
                            debitAmount = item.currentValue,
                            creditAmount = 0.0,
                            runningBalance = item.currentValue,
                            category = item.category,
                            notes = "Initial balance for ${item.title}"
                        )
                    )
                } else {
                    repository.insertLedgerEntry(
                        LedgerEntry(
                            timestamp = System.currentTimeMillis(),
                            transactionTitle = "Opening Loan / Liability Added",
                            accountName = item.title,
                            oppositeAccountName = "Liability Account",
                            entryType = "CR",
                            debitAmount = 0.0,
                            creditAmount = item.currentValue,
                            runningBalance = item.currentValue,
                            category = item.category,
                            notes = "Initial loan balance for ${item.title}"
                        )
                    )
                }
            }
        }
    }

    fun postDirectLedgerEntry(
        title: String,
        primaryAccount: String,
        secondaryAccount: String,
        amount: Double,
        isDebitPrimary: Boolean, // true = DR Primary & CR Secondary; false = CR Primary & DR Secondary
        category: String,
        notes: String
    ) {
        viewModelScope.launch {
            val now = System.currentTimeMillis()

            // Update Primary Account live balance if it exists in FinancialItems
            val primaryAcc = allItems.value.find { it.title.equals(primaryAccount, ignoreCase = true) }
            val newPrimaryBal = if (primaryAcc != null) {
                val updatedVal = if (isDebitPrimary) primaryAcc.currentValue + amount else (primaryAcc.currentValue - amount).coerceAtLeast(0.0)
                repository.updateItem(primaryAcc.copy(currentValue = updatedVal, updatedAt = now))
                updatedVal
            } else amount

            // Update Secondary Account live balance if it exists in FinancialItems
            val secondaryAcc = if (secondaryAccount.isNotBlank()) {
                allItems.value.find { it.title.equals(secondaryAccount, ignoreCase = true) }
            } else null

            val newSecBal = if (secondaryAcc != null) {
                val updatedVal = if (isDebitPrimary) (secondaryAcc.currentValue - amount).coerceAtLeast(0.0) else secondaryAcc.currentValue + amount
                repository.updateItem(secondaryAcc.copy(currentValue = updatedVal, updatedAt = now))
                updatedVal
            } else amount

            // Insert Primary Account Ledger Entry
            repository.insertLedgerEntry(
                LedgerEntry(
                    timestamp = now,
                    transactionTitle = title,
                    accountName = primaryAccount,
                    oppositeAccountName = secondaryAccount,
                    entryType = if (isDebitPrimary) "DR" else "CR",
                    debitAmount = if (isDebitPrimary) amount else 0.0,
                    creditAmount = if (!isDebitPrimary) amount else 0.0,
                    runningBalance = newPrimaryBal,
                    category = category,
                    notes = notes
                )
            )

            // Insert Secondary Account Ledger Entry if opposite account is specified
            if (secondaryAccount.isNotBlank()) {
                repository.insertLedgerEntry(
                    LedgerEntry(
                        timestamp = now,
                        transactionTitle = title,
                        accountName = secondaryAccount,
                        oppositeAccountName = primaryAccount,
                        entryType = if (isDebitPrimary) "CR" else "DR",
                        debitAmount = if (!isDebitPrimary) amount else 0.0,
                        creditAmount = if (isDebitPrimary) amount else 0.0,
                        runningBalance = newSecBal,
                        category = category,
                        notes = "Opposite entry for $title"
                    )
                )
            }
        }
    }

    fun refreshAndRecalculateAll() {
        tickLiveStockPrices()
        liveTickCount.value += 1
    }

    fun adjustAccountBalance(
        item: FinancialItem,
        newAmount: Double,
        reason: String = "Balance Refresh / Adjustment"
    ) {
        viewModelScope.launch {
            val now = System.currentTimeMillis()
            val oldAmount = item.currentValue
            val delta = newAmount - oldAmount

            if (delta != 0.0) {
                // 1. Update the account item in repository
                val updatedItem = item.copy(
                    currentValue = newAmount,
                    updatedAt = now
                )
                repository.updateItem(updatedItem)

                // 2. Post a Double-Entry Ledger adjustment record
                val isIncrease = delta > 0
                val absDiff = kotlin.math.abs(delta)

                repository.insertLedgerEntry(
                    LedgerEntry(
                        timestamp = now,
                        transactionTitle = "Balance Adjustment: ${item.title}",
                        accountName = item.title,
                        oppositeAccountName = "Adjustment & Reconciliation",
                        entryType = if (isIncrease) (if (!item.isLiability) "DR" else "CR") else (if (!item.isLiability) "CR" else "DR"),
                        debitAmount = if (isIncrease && !item.isLiability || !isIncrease && item.isLiability) absDiff else 0.0,
                        creditAmount = if (!isIncrease && !item.isLiability || isIncrease && item.isLiability) absDiff else 0.0,
                        runningBalance = newAmount,
                        category = item.category,
                        notes = "$reason (Old: ₹${String.format(Locale.US, "%,.2f", oldAmount)} ➔ New: ₹${String.format(Locale.US, "%,.2f", newAmount)})"
                    )
                )
            }
        }
    }

    fun deleteLedgerEntry(entry: LedgerEntry, adjustAccountBalance: Boolean = true) {
        viewModelScope.launch {
            if (adjustAccountBalance) {
                val now = System.currentTimeMillis()
                // Revert primary account balance if it exists
                val primaryAcc = allItems.value.find { it.title.equals(entry.accountName, ignoreCase = true) }
                if (primaryAcc != null) {
                    val adjustedVal = if (entry.entryType.equals("DR", ignoreCase = true)) {
                        (primaryAcc.currentValue - entry.debitAmount).coerceAtLeast(0.0)
                    } else {
                        primaryAcc.currentValue + entry.creditAmount
                    }
                    repository.updateItem(primaryAcc.copy(currentValue = adjustedVal, updatedAt = now))
                }

                // Revert opposite account balance if it exists
                val secAcc = allItems.value.find { it.title.equals(entry.oppositeAccountName, ignoreCase = true) }
                if (secAcc != null) {
                    val adjustedSecVal = if (entry.entryType.equals("DR", ignoreCase = true)) {
                        secAcc.currentValue + entry.debitAmount
                    } else {
                        (secAcc.currentValue - entry.creditAmount).coerceAtLeast(0.0)
                    }
                    repository.updateItem(secAcc.copy(currentValue = adjustedSecVal, updatedAt = now))
                }
            }

            repository.deleteLedgerEntry(entry)
        }
    }

    fun deleteFinancialItem(item: FinancialItem, adjustLinkedAccount: Boolean = true) {
        viewModelScope.launch {
            val now = System.currentTimeMillis()

            // Automatically adjust linked Bank / Cash account balance if this item had a source/deposit account linked
            if (adjustLinkedAccount && item.sourceAccountTitle.isNotBlank()) {
                val isIncome = item.category.contains("Income", ignoreCase = true)
                val sourceAcc = allItems.value.find {
                    it.title.equals(item.sourceAccountTitle, ignoreCase = true) ||
                    "${it.title} (${it.category})".equals(item.sourceAccountTitle, ignoreCase = true)
                }

                if (sourceAcc != null && sourceAcc.id != item.id) {
                    if (!isIncome) {
                        // Outflow entry (Expense, Paid Loan, IPO, Stock, Asset, Liability) was deleted -> Refund / Restore amount to Bank/Cash account
                        val restoredBal = sourceAcc.currentValue + item.currentValue
                        repository.updateItem(sourceAcc.copy(currentValue = restoredBal, updatedAt = now))

                        // Record DR reversal in ledger
                        repository.insertLedgerEntry(
                            LedgerEntry(
                                timestamp = now,
                                transactionTitle = "Reversal / Refund: Deleted ${item.title}",
                                accountName = item.sourceAccountTitle,
                                oppositeAccountName = item.title,
                                entryType = "DR",
                                debitAmount = item.currentValue,
                                creditAmount = 0.0,
                                runningBalance = restoredBal,
                                category = item.category,
                                notes = "Automatic refund of ₹${String.format(Locale.US, "%,.2f", item.currentValue)} to ${item.sourceAccountTitle} after deleting entry '${item.title}'"
                            )
                        )
                    } else {
                        // Income entry was deleted -> Deduct amount back from Bank/Cash account
                        val adjustedBal = (sourceAcc.currentValue - item.currentValue).coerceAtLeast(0.0)
                        repository.updateItem(sourceAcc.copy(currentValue = adjustedBal, updatedAt = now))

                        // Record CR reversal in ledger
                        repository.insertLedgerEntry(
                            LedgerEntry(
                                timestamp = now,
                                transactionTitle = "Reversal: Deleted Income ${item.title}",
                                accountName = item.sourceAccountTitle,
                                oppositeAccountName = item.title,
                                entryType = "CR",
                                debitAmount = 0.0,
                                creditAmount = item.currentValue,
                                runningBalance = adjustedBal,
                                category = item.category,
                                notes = "Automatic deduction of ₹${String.format(Locale.US, "%,.2f", item.currentValue)} from ${item.sourceAccountTitle} after deleting income '${item.title}'"
                            )
                        )
                    }
                }
            }

            // Delete item from repository
            repository.deleteItem(item)
        }
    }

    fun recordSnapshot(note: String = "Routine Snapshot") {
        viewModelScope.launch {
            repository.recordSnapshot(note, allItems.value)
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
        return repository.exportToJson(allItems.value, snapshots.value, allLedgerEntries.value)
    }

    fun importBackupJson(jsonStr: String, clearExisting: Boolean = false, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val success = repository.importFromJson(jsonStr, clearExisting = clearExisting)
            onResult(success)
        }
    }

    private fun StateFlow<List<FinancialItem>>.mapToCategorySummaries() = combine(this) { (items) ->
        val totalAssets = items.filter { !it.isLiability }.sumOf { it.currentValue }
        val categoryGroups = items.groupBy { it.category }

        categoryGroups.map { (cat, catItems) ->
            val catTotal = catItems.sumOf { it.currentValue }
            val isLiab = catItems.firstOrNull()?.isLiability ?: false
            val pct = if (!isLiab && totalAssets > 0) ((catTotal / totalAssets) * 100).toFloat() else 0f

            CategorySummary(
                category = cat,
                totalValue = catTotal,
                percentage = pct,
                isLiability = isLiab
            )
        }.sortedByDescending { it.totalValue }
    }

    private fun StateFlow<List<FinancialItem>>.mapToOwnerSummaries() = combine(this) { (items) ->
        val totalOverallAssets = items.filter { !it.isLiability }.sumOf { it.currentValue }
        val owners = listOf("Self", "Father", "Mother", "Family Joint")

        owners.map { owner ->
            val ownerItems = items.filter { it.owner.equals(owner, ignoreCase = true) }
            val assets = ownerItems.filter { !it.isLiability }.sumOf { it.currentValue }
            val liabilities = ownerItems.filter { it.isLiability }.sumOf { it.currentValue }
            val pct = if (totalOverallAssets > 0) ((assets / totalOverallAssets) * 100).toFloat() else 0f

            val stockItems = ownerItems.filter { !it.isLiability && isStockCategory(it.category) }
            val stkWorth = stockItems.sumOf { it.currentValue }
            val stkInvested = stockItems.filter { it.investedValue > 0 }.sumOf { it.investedValue }
            val stkPnl = if (stkInvested > 0) stkWorth - stkInvested else 0.0

            OwnerSummary(
                owner = owner,
                totalAssets = assets,
                totalLiabilities = liabilities,
                netWorth = assets - liabilities,
                percentage = pct,
                stockWorth = stkWorth,
                stockProfitLoss = stkPnl
            )
        }
    }
}
