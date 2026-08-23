package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.CurrencyRupee
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material.icons.filled.TrendingDown
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.FinancialItem
import com.example.data.model.ItemCategory
import com.example.data.model.OwnerProfile
import java.util.Locale

data class StockQuote(
    val symbol: String,
    val name: String,
    val exchange: String,
    val currentPrice: Double,
    val changePercent: Double,
    val isPositive: Boolean
)

val GLOBAL_STOCK_LIST = mutableStateListOf<StockQuote>()

/**
 * Reusable form component for adding and editing financial asset or liability entries.
 * For Share Market / Stocks category, it replaces manual valuation with Google Finance Auto Share Valuation.
 */
@Composable
fun FinancialAssetForm(
    itemToEdit: FinancialItem? = null,
    existingAssetAccounts: List<FinancialItem> = emptyList(),
    onSave: (FinancialItem) -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier,
    submitButtonText: String = if (itemToEdit == null) "Save Asset" else "Update Item"
) {
    var title by remember { mutableStateOf(itemToEdit?.title ?: "") }
    var institution by remember { mutableStateOf(itemToEdit?.institution ?: "") }
    var accountNumber by remember { mutableStateOf(itemToEdit?.accountNumber ?: "") }
    var owner by remember { mutableStateOf(itemToEdit?.owner ?: OwnerProfile.SELF.displayName) }
    var category by remember { mutableStateOf(itemToEdit?.category ?: ItemCategory.BANK_ACCOUNT.displayName) }
    
    var currentValueStr by remember {
        mutableStateOf(itemToEdit?.currentValue?.let {
            if (it % 1.0 == 0.0) it.toLong().toString() else it.toString()
        } ?: "")
    }
    
    var investedValueStr by remember {
        mutableStateOf(itemToEdit?.investedValue?.let {
            if (it % 1.0 == 0.0) it.toLong().toString() else it.toString()
        } ?: "")
    }
    
    var isLiability by remember { mutableStateOf(itemToEdit?.isLiability ?: false) }
    var notes by remember { mutableStateOf(itemToEdit?.notes ?: "") }
    var sourceAccountTitle by remember { mutableStateOf(itemToEdit?.sourceAccountTitle ?: "") }
    var shouldDeductOrAddOpposite by remember { mutableStateOf(true) }

    var ownerDropdownExpanded by remember { mutableStateOf(false) }
    var categoryDropdownExpanded by remember { mutableStateOf(false) }
    var sourceAccountDropdownExpanded by remember { mutableStateOf(false) }
    var titleDropdownExpanded by remember { mutableStateOf(false) }
    var instDropdownExpanded by remember { mutableStateOf(false) }
    var accNoDropdownExpanded by remember { mutableStateOf(false) }

    val context = androidx.compose.ui.platform.LocalContext.current
    val prefs = remember { context.getSharedPreferences("category_prefs", android.content.Context.MODE_PRIVATE) }
    val ownerPrefs = remember { context.getSharedPreferences("owner_prefs", android.content.Context.MODE_PRIVATE) }
    val titlePrefs = remember { context.getSharedPreferences("title_prefs", android.content.Context.MODE_PRIVATE) }
    val instPrefs = remember { context.getSharedPreferences("inst_prefs", android.content.Context.MODE_PRIVATE) }
    val accNoPrefs = remember { context.getSharedPreferences("acc_no_prefs", android.content.Context.MODE_PRIVATE) }

    // Titles List (Add, Modify, Delete)
    var titlesList by remember {
        mutableStateOf(
            run {
                val saved = titlePrefs.getStringSet("custom_titles_v1", null)
                if (!saved.isNullOrEmpty()) {
                    saved.toList()
                } else {
                    val defaults = listOf(
                        "HDFC Salary Account",
                        "SBI Savings Account",
                        "ICICI Bank A/c",
                        "Zerodha Demat Account",
                        "Groww Trading & Demat",
                        "Nifty 50 Index Fund",
                        "Emergency Cash Fund",
                        "Gold 24K Sovereign / Physical",
                        "Real Estate Property / Plot",
                        "Salary / Monthly Income",
                        "House Rent / Household",
                        "Home Loan / Mortgage",
                        "Loan Given to Friend / Relative"
                    )
                    val existing = existingAssetAccounts.map { it.title }.filter { it.isNotBlank() }
                    (defaults + existing).distinct()
                }
            }
        )
    }

    fun saveTitlesToPrefs(newList: List<String>) {
        titlesList = newList
        titlePrefs.edit().putStringSet("custom_titles_v1", newList.toSet()).apply()
    }

    var showManageTitlesDialog by remember { mutableStateOf(false) }
    var titleInputName by remember { mutableStateOf("") }
    var editingTitleName by remember { mutableStateOf<String?>(null) }
    var titleToDelete by remember { mutableStateOf<String?>(null) }

    // Institutions List (Add, Modify, Delete)
    var institutionsList by remember {
        mutableStateOf(
            run {
                val saved = instPrefs.getStringSet("custom_institutions_v1", null)
                if (!saved.isNullOrEmpty()) {
                    saved.toList()
                } else {
                    val defaults = listOf(
                        "HDFC Bank",
                        "State Bank of India (SBI)",
                        "ICICI Bank",
                        "Axis Bank",
                        "Kotak Mahindra Bank",
                        "Bank of Baroda (BOB)",
                        "Punjab National Bank (PNB)",
                        "Zerodha Broking",
                        "Groww / Nextbillion",
                        "Angel One",
                        "Upstox",
                        "CAMS / KFintech",
                        "Post Office / India Post",
                        "LIC of India",
                        "Cash Wallet / Vault",
                        "Personal / Borrower"
                    )
                    val existing = existingAssetAccounts.map { it.institution }.filter { it.isNotBlank() }
                    (defaults + existing).distinct()
                }
            }
        )
    }

    fun saveInstitutionsToPrefs(newList: List<String>) {
        institutionsList = newList
        instPrefs.edit().putStringSet("custom_institutions_v1", newList.toSet()).apply()
    }

    var showManageInstitutionsDialog by remember { mutableStateOf(false) }
    var institutionInputName by remember { mutableStateOf("") }
    var editingInstitutionName by remember { mutableStateOf<String?>(null) }
    var institutionToDelete by remember { mutableStateOf<String?>(null) }

    // Account Numbers List (Add, Modify, Delete)
    var accountNumbersList by remember {
        mutableStateOf(
            run {
                val saved = accNoPrefs.getStringSet("custom_account_nos_v1", null)
                if (!saved.isNullOrEmpty()) {
                    saved.toList()
                } else {
                    val defaults = listOf(
                        "Primary A/c No.",
                        "Salary A/c No.",
                        "Savings A/c No.",
                        "Demat Client ID 12081600",
                        "Folio No. MF-01",
                        "PPF A/c No.",
                        "Fixed Deposit FD-01",
                        "Cash / Direct"
                    )
                    val existing = existingAssetAccounts.map { it.accountNumber }.filter { it.isNotBlank() }
                    (defaults + existing).distinct()
                }
            }
        )
    }

    fun saveAccountNumbersToPrefs(newList: List<String>) {
        accountNumbersList = newList
        accNoPrefs.edit().putStringSet("custom_account_nos_v1", newList.toSet()).apply()
    }

    var showManageAccountNumbersDialog by remember { mutableStateOf(false) }
    var accountNumberInputName by remember { mutableStateOf("") }
    var editingAccountNumberName by remember { mutableStateOf<String?>(null) }
    var accountNumberToDelete by remember { mutableStateOf<String?>(null) }

    var ownersList by remember {
        mutableStateOf(
            run {
                val saved = ownerPrefs.getStringSet("custom_owners_v1", null)
                if (!saved.isNullOrEmpty()) {
                    saved.toList()
                } else {
                    listOf("Self", "Father", "Mother", "Family Joint")
                }
            }
        )
    }

    fun saveOwnersToPrefs(newList: List<String>) {
        ownersList = newList
        ownerPrefs.edit().putStringSet("custom_owners_v1", newList.toSet()).apply()
    }

    var showManageOwnersDialog by remember { mutableStateOf(false) }
    var ownerInputName by remember { mutableStateOf("") }
    var editingOwnerName by remember { mutableStateOf<String?>(null) }
    var ownerToDelete by remember { mutableStateOf<String?>(null) }

    var categoriesList by remember {
        mutableStateOf(
            run {
                val saved = prefs.getStringSet("custom_categories_v2", null)
                if (!saved.isNullOrEmpty()) {
                    saved.toList().sorted()
                } else {
                    listOf(
                        "Bank Account",
                        "Share Market / Stocks",
                        "Mutual Funds",
                        "IPO Application",
                        "Paid Loan / Aapel Loan (આપેલ લોન)",
                        "Gold & Silver",
                        "Real Estate / Land",
                        "Cash on Hand",
                        "Other Investments (PF/FD/PPF)",
                        "Income / Earnings",
                        "Expense / Outflow",
                        "Loans & Dues (લીધેલ લોન)"
                    )
                }
            }
        )
    }

    fun saveCategoriesToPrefs(newList: List<String>) {
        categoriesList = newList
        prefs.edit().putStringSet("custom_categories_v2", newList.toSet()).apply()
    }

    var showManageCategoriesDialog by remember { mutableStateOf(false) }
    var editingCategoryName by remember { mutableStateOf<String?>(null) }
    var categoryToDelete by remember { mutableStateOf<String?>(null) }

    val isExpenseCategory = category.equals(ItemCategory.EXPENSE.displayName, ignoreCase = true) ||
            category.contains("Expense", ignoreCase = true) ||
            category.contains("Outflow", ignoreCase = true)

    val isIncomeCategory = category.equals("Income / Earnings", ignoreCase = true) ||
            category.contains("Income", ignoreCase = true) ||
            category.contains("Earnings", ignoreCase = true) ||
            category.contains("Salary", ignoreCase = true)

    val isIpoCategory = category.equals("IPO Application", ignoreCase = true) ||
            category.contains("IPO", ignoreCase = true)

    val isPaidLoanCategory = category.equals("Paid Loan / Aapel Loan (આપેલ લોન)", ignoreCase = true) ||
            category.contains("Paid Loan", ignoreCase = true) ||
            category.contains("Aapel Loan", ignoreCase = true) ||
            category.contains("Aapel", ignoreCase = true) ||
            category.contains("Chekvel", ignoreCase = true) ||
            category.contains("Loan Given", ignoreCase = true)

    // Stock / Share Market Auto-Valuation State
    val isStockCategory = category.equals(ItemCategory.SHARE_MARKET.displayName, ignoreCase = true) ||
            category.contains("Share Market", ignoreCase = true) ||
            category.contains("Stocks", ignoreCase = true)

    val stockList = GLOBAL_STOCK_LIST
    val stockLazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    var showAddStockDialog by remember { mutableStateOf(false) }
    var stockToEdit by remember { mutableStateOf<StockQuote?>(null) }
    var showDeleteStockDialog by remember { mutableStateOf(false) }

    var customSymbol by remember { mutableStateOf("") }
    var customName by remember { mutableStateOf("") }
    var customExchange by remember { mutableStateOf("NSE") }
    var customPriceStr by remember { mutableStateOf("") }

    var selectedStockSymbol by remember { mutableStateOf(stockList.firstOrNull()?.symbol ?: "") }
    var selectedStockName by remember { mutableStateOf(stockList.firstOrNull()?.name ?: "") }
    var exchangeName by remember { mutableStateOf(stockList.firstOrNull()?.exchange ?: "NSE") }
    var sharesQuantityStr by remember { mutableStateOf(if (stockList.isNotEmpty()) "10" else "") }
    var marketPricePerShareStr by remember { mutableStateOf(stockList.firstOrNull()?.let { String.format(Locale.US, "%.2f", it.currentPrice) } ?: "") }
    var buyPricePerShareStr by remember { mutableStateOf(stockList.firstOrNull()?.let { String.format(Locale.US, "%.2f", it.currentPrice * 0.9) } ?: "") }
    var stockQuoteChangePercent by remember { mutableStateOf(stockList.firstOrNull()?.changePercent ?: 0.0) }
    var isQuotePositive by remember { mutableStateOf(stockList.firstOrNull()?.isPositive ?: true) }

    androidx.compose.runtime.LaunchedEffect(itemToEdit) {
        if (itemToEdit != null && (itemToEdit.category.contains("Share Market", ignoreCase = true) || itemToEdit.category.contains("Stocks", ignoreCase = true))) {
            val titleParts = itemToEdit.title.split("-").map { it.trim() }
            if (titleParts.isNotEmpty()) {
                val symbol = titleParts[0].uppercase()
                val name = if (titleParts.size > 1) titleParts[1] else symbol
                val currentStock = stockList.find { it.symbol == symbol }
                if (currentStock == null) {
                    val price = if (itemToEdit.currentValue > 0) itemToEdit.currentValue / 10.0 else 100.0
                    val newQuote = StockQuote(symbol, name, "NSE", price, 1.0, true)
                    stockList.add(0, newQuote)
                    selectedStockSymbol = symbol
                    selectedStockName = name
                    marketPricePerShareStr = String.format(Locale.US, "%.2f", price)
                } else {
                    selectedStockSymbol = currentStock.symbol
                    selectedStockName = currentStock.name
                    exchangeName = currentStock.exchange
                    marketPricePerShareStr = String.format(Locale.US, "%.2f", currentStock.currentPrice)
                }
            }
        }
    }

    var stockQuantityError by remember { mutableStateOf<String?>(null) }
    var stockPriceError by remember { mutableStateOf<String?>(null) }

    // Field-level error validation states for general form
    var titleError by remember { mutableStateOf<String?>(null) }
    var currentValueError by remember { mutableStateOf<String?>(null) }
    var investedValueError by remember { mutableStateOf<String?>(null) }

    val isMFOnly = category.contains("Mutual", ignoreCase = true)

    fun validateAndCleanCurrencyInput(input: String): String {
        return input.replace(" ", "").replace(",", "")
    }

    fun performValidation(): Boolean {
        var isValid = true

        // Title validation
        if (title.trim().isEmpty()) {
            if (isStockCategory) {
                title = "$selectedStockSymbol - $selectedStockName"
                titleError = null
            } else {
                titleError = "Title is required (e.g., Savings Account)"
                isValid = false
            }
        } else {
            titleError = null
        }

        if (isStockCategory) {
            // Stock Auto-Valuation Validation
            val cleanedQty = validateAndCleanCurrencyInput(sharesQuantityStr)
            val qty = cleanedQty.toDoubleOrNull()
            if (qty == null || qty <= 0) {
                stockQuantityError = "Enter valid share quantity (> 0)"
                isValid = false
            } else {
                stockQuantityError = null
            }

            val cleanedMktPrice = validateAndCleanCurrencyInput(marketPricePerShareStr)
            val mktPrice = cleanedMktPrice.toDoubleOrNull()
            if (mktPrice == null || mktPrice <= 0) {
                stockPriceError = "Enter valid share price (> 0)"
                isValid = false
            } else {
                stockPriceError = null
            }

            if (isValid && qty != null && mktPrice != null) {
                val cleanedBuyPrice = validateAndCleanCurrencyInput(buyPricePerShareStr)
                val buyPrice = cleanedBuyPrice.toDoubleOrNull() ?: mktPrice

                val totalCurVal = qty * mktPrice
                val totalInvVal = qty * buyPrice

                currentValueStr = String.format(Locale.US, "%.2f", totalCurVal)
                investedValueStr = String.format(Locale.US, "%.2f", totalInvVal)
            }
        } else {
            // Standard Current Value currency validation
            val cleanedCurVal = validateAndCleanCurrencyInput(currentValueStr)
            if (cleanedCurVal.isEmpty()) {
                currentValueError = "Current amount is required"
                isValid = false
            } else {
                val num = cleanedCurVal.toDoubleOrNull()
                if (num == null || num < 0) {
                    currentValueError = "Enter a valid non-negative number"
                    isValid = false
                } else {
                    currentValueError = null
                }
            }

            // Invested Value currency validation
            if (isMFOnly && investedValueStr.isNotBlank()) {
                val cleanedInvVal = validateAndCleanCurrencyInput(investedValueStr)
                val num = cleanedInvVal.toDoubleOrNull()
                if (num == null || num < 0) {
                    investedValueError = "Enter a valid positive investment amount"
                    isValid = false
                } else {
                    investedValueError = null
                }
            } else {
                investedValueError = null
            }
        }

        return isValid
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Item Type Selection (Asset vs Liability vs Income vs Expense)
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Entry Type *",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 1. Asset Option
                FilterChip(
                    selected = !isLiability && !isIncomeCategory && !isExpenseCategory && !isIpoCategory && !isPaidLoanCategory,
                    onClick = {
                        isLiability = false
                        category = ItemCategory.BANK_ACCOUNT.displayName
                    },
                    label = { Text("Asset", fontWeight = FontWeight.Bold, fontSize = 12.sp) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.AccountBalance,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFF059669),
                        selectedLabelColor = Color.White,
                        selectedLeadingIconColor = Color.White
                    ),
                    modifier = Modifier.testTag("radio_asset")
                )

                // 2. IPO Option
                FilterChip(
                    selected = isIpoCategory,
                    onClick = {
                        isLiability = false
                        category = "IPO Application"
                        if (title.isBlank()) title = "IPO Application"
                    },
                    label = { Text("IPO", fontWeight = FontWeight.Bold, fontSize = 12.sp) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.ShowChart,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFF7C3AED),
                        selectedLabelColor = Color.White,
                        selectedLeadingIconColor = Color.White
                    ),
                    modifier = Modifier.testTag("radio_ipo")
                )

                // 3. Paid Loan / Aapel Loan Option
                FilterChip(
                    selected = isPaidLoanCategory,
                    onClick = {
                        isLiability = false
                        category = "Paid Loan / Aapel Loan (આપેલ લોન)"
                        if (title.isBlank()) title = "Loan Given to "
                        if (institution.isBlank()) institution = "Borrower / Friend"
                    },
                    label = { Text("Paid Loan / Aapel Loan", fontWeight = FontWeight.Bold, fontSize = 11.sp) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Handshake,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFF0D9488),
                        selectedLabelColor = Color.White,
                        selectedLeadingIconColor = Color.White
                    ),
                    modifier = Modifier.testTag("radio_paid_loan")
                )

                // 4. Liability / Loan Option
                FilterChip(
                    selected = isLiability && !isExpenseCategory,
                    onClick = {
                        isLiability = true
                        category = ItemCategory.LOAN_LIABILITY.displayName
                    },
                    label = { Text("Liability / Loan", fontWeight = FontWeight.Bold, fontSize = 11.sp) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.CreditCard,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFFDC2626),
                        selectedLabelColor = Color.White,
                        selectedLeadingIconColor = Color.White
                    ),
                    modifier = Modifier.testTag("radio_liability")
                )

                // 5. Income Option
                FilterChip(
                    selected = isIncomeCategory,
                    onClick = {
                        isLiability = false
                        category = "Income / Earnings"
                        if (title.isBlank()) title = "Salary / Income"
                    },
                    label = { Text("Income", fontWeight = FontWeight.Bold, fontSize = 12.sp) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.TrendingUp,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFF0284C7),
                        selectedLabelColor = Color.White,
                        selectedLeadingIconColor = Color.White
                    ),
                    modifier = Modifier.testTag("radio_income")
                )

                // 6. Expense Option
                FilterChip(
                    selected = isExpenseCategory,
                    onClick = {
                        isLiability = true
                        category = ItemCategory.EXPENSE.displayName
                        if (title.isBlank()) title = "Expense Outflow"
                    },
                    label = { Text("Expense", fontWeight = FontWeight.Bold, fontSize = 12.sp) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFF7C3AED),
                        selectedLabelColor = Color.White,
                        selectedLeadingIconColor = Color.White
                    ),
                    modifier = Modifier.testTag("radio_expense")
                )
            }
        }

        // Category Dropdown
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Category *",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "+ Add / Manage Categories",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable { showManageCategoriesDialog = true }
                        .testTag("btn_open_manage_categories")
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { categoryDropdownExpanded = true }
                    .padding(vertical = 12.dp, horizontal = 16.dp)
                    .testTag("category_dropdown")
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = category,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Select Category"
                    )
                }
            }
            DropdownMenu(
                expanded = categoryDropdownExpanded,
                onDismissRequest = { categoryDropdownExpanded = false }
            ) {
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "➕ Add / Manage Categories...",
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    onClick = {
                        categoryDropdownExpanded = false
                        showManageCategoriesDialog = true
                    }
                )

                HorizontalDivider()

                categoriesList.forEach { catName ->
                    DropdownMenuItem(
                        text = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = catName,
                                    fontWeight = if (category.equals(catName, ignoreCase = true)) FontWeight.Bold else FontWeight.Normal,
                                    color = if (category.equals(catName, ignoreCase = true)) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.weight(1f)
                                )

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    IconButton(
                                        onClick = {
                                            categoryDropdownExpanded = false
                                            editingCategoryName = catName
                                            showManageCategoriesDialog = true
                                        },
                                        modifier = Modifier.size(28.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Edit,
                                            contentDescription = "Edit Category",
                                            tint = Color(0xFF60A5FA),
                                            modifier = Modifier.size(15.dp)
                                        )
                                    }

                                    IconButton(
                                        onClick = {
                                            categoryDropdownExpanded = false
                                            categoryToDelete = catName
                                        },
                                        modifier = Modifier.size(28.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = "Delete Category",
                                            tint = Color(0xFFF87171),
                                            modifier = Modifier.size(15.dp)
                                        )
                                    }
                                }
                            }
                        },
                        onClick = {
                            category = catName
                            if (catName.contains("Share Market", ignoreCase = true) || catName.contains("Stocks", ignoreCase = true)) {
                                if (institution.isBlank()) institution = "Zerodha / Groww"
                                if (title.isBlank()) title = "RELIANCE - Reliance Industries"
                            } else if (catName.contains("Expense", ignoreCase = true)) {
                                isLiability = true
                                if (title.isBlank()) title = "Expense Outflow"
                            } else if (catName.contains("Paid Loan", ignoreCase = true) || catName.contains("Aapel", ignoreCase = true) || catName.contains("Chekvel", ignoreCase = true) || catName.contains("Loan Given", ignoreCase = true)) {
                                isLiability = false
                                if (title.isBlank()) title = "Loan Given to "
                                if (institution.isBlank()) institution = "Borrower / Friend"
                            } else if (catName.contains("Loan", ignoreCase = true) || catName.contains("Due", ignoreCase = true)) {
                                isLiability = true
                            } else {
                                isLiability = false
                            }
                            categoryDropdownExpanded = false
                        }
                    )
                }
            }
        }

        // Paid By / Deposit To (Source or Target Bank/Cash Account) Selection
        if (isExpenseCategory || isLiability || isIncomeCategory || isIpoCategory || isPaidLoanCategory || isStockCategory || category.contains("Mutual", ignoreCase = true) || !category.equals(ItemCategory.BANK_ACCOUNT.displayName, ignoreCase = true)) {
            val isIncome = isIncomeCategory
            val sectionHeader = when {
                isIncome -> "Deposit To / Received In (Bank / Cash Account) *"
                isIpoCategory -> "Paid By / Deduct From Bank Account (Opposite Account) *"
                isPaidLoanCategory -> "Paid By / Deduct From (Bank / Cash Account) *"
                else -> "Paid By / Deduct From (Bank / Cash Account) *"
            }
            val defaultAccountText = when {
                isIncome -> "None (Standalone Income)"
                isIpoCategory -> "None (Direct ASBA / Unlinked)"
                isPaidLoanCategory -> "None (Direct Cash / Unlinked)"
                else -> "None (Standalone / Unlinked)"
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = if (isIncome) Color(0xFF0284C7).copy(alpha = 0.08f) else if (isIpoCategory) Color(0xFF7C3AED).copy(alpha = 0.08f) else if (isPaidLoanCategory) Color(0xFF0D9488).copy(alpha = 0.08f) else Color(0xFF7C3AED).copy(alpha = 0.08f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = if (isIncome) Icons.Default.TrendingUp else if (isIpoCategory) Icons.Default.ShowChart else if (isPaidLoanCategory) Icons.Default.Handshake else Icons.Default.AccountBalance,
                        contentDescription = null,
                        tint = if (isIncome) Color(0xFF0284C7) else if (isPaidLoanCategory) Color(0xFF0D9488) else Color(0xFF7C3AED),
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = sectionHeader,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = if (isIncome) Color(0xFF0369A1) else if (isPaidLoanCategory) Color(0xFF0F766E) else Color(0xFF6D28D9)
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))

                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.surface,
                    border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { sourceAccountDropdownExpanded = true }
                        .padding(vertical = 12.dp, horizontal = 16.dp)
                        .testTag("source_account_dropdown")
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (sourceAccountTitle.isBlank()) defaultAccountText else sourceAccountTitle,
                            fontWeight = FontWeight.Bold,
                            color = if (sourceAccountTitle.isBlank()) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.onSurface
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Select Bank/Cash Account"
                        )
                    }
                }
                DropdownMenu(
                    expanded = sourceAccountDropdownExpanded,
                    onDismissRequest = { sourceAccountDropdownExpanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text(defaultAccountText) },
                        onClick = {
                            sourceAccountTitle = ""
                            sourceAccountDropdownExpanded = false
                        }
                    )

                    val bankAndCashAccounts = existingAssetAccounts.filter { !it.isLiability }
                    if (bankAndCashAccounts.isNotEmpty()) {
                        HorizontalDivider()
                        bankAndCashAccounts.forEach { acc ->
                            DropdownMenuItem(
                                text = {
                                    Column {
                                        Text(acc.title, fontWeight = FontWeight.Bold)
                                        Text("${acc.category} • Bal: ₹${String.format(Locale.US, "%,.0f", acc.currentValue)}", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                    }
                                },
                                onClick = {
                                    sourceAccountTitle = acc.title
                                    sourceAccountDropdownExpanded = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                // Quick custom account text field if user wants to specify/edit Bank or Cash account
                OutlinedTextField(
                    value = sourceAccountTitle,
                    onValueChange = { sourceAccountTitle = it },
                    label = { Text(if (isIncome) "Deposit Account Name" else "Paid By Account Name") },
                    placeholder = { Text("e.g., HDFC Bank, Cash on Hand, SBI Account") },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = MaterialTheme.colorScheme.surface, unfocusedContainerColor = MaterialTheme.colorScheme.surface),
                    modifier = Modifier.fillMaxWidth().testTag("source_account_title_input")
                )

                if (sourceAccountTitle.isNotBlank()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { shouldDeductOrAddOpposite = !shouldDeductOrAddOpposite },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = shouldDeductOrAddOpposite,
                            onCheckedChange = { shouldDeductOrAddOpposite = it }
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = when {
                                isIncome -> "Add / Credit amount directly to '$sourceAccountTitle'"
                                isIpoCategory -> "Cut / Deduct IPO amount directly from '$sourceAccountTitle'"
                                isPaidLoanCategory -> "Cut / Deduct Loan amount directly from '$sourceAccountTitle'"
                                else -> "Cut / Deduct amount directly from '$sourceAccountTitle'"
                            },
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isIncome) Color(0xFF047857) else Color(0xFFB91C1C)
                        )
                    }

                    if (shouldDeductOrAddOpposite) {
                        Text(
                            text = when {
                                isIncome -> "⚡ Saving will add ₹${if (currentValueStr.isBlank()) "0" else currentValueStr} to '$sourceAccountTitle' & post Credit/Debit to Ledger."
                                isIpoCategory -> "⚡ Saving will cut ₹${if (currentValueStr.isBlank()) "0" else currentValueStr} from '$sourceAccountTitle' for IPO Application & post Debit/Credit to Ledger."
                                isPaidLoanCategory -> "⚡ Saving will cut ₹${if (currentValueStr.isBlank()) "0" else currentValueStr} from '$sourceAccountTitle' for Paid / Given Loan & post Debit/Credit to Ledger."
                                else -> "⚡ Saving will cut ₹${if (currentValueStr.isBlank()) "0" else currentValueStr} from '$sourceAccountTitle' & post Debit/Credit to Ledger."
                            },
                            style = MaterialTheme.typography.labelSmall,
                            color = if (isIncome) Color(0xFF059669) else Color(0xFFDC2626),
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(start = 12.dp)
                        )
                    }
                }
            }
        }

        // Title Input with Dropdown & Management
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = when {
                        isPaidLoanCategory -> "Borrower Name / Loan Given To *"
                        isIncomeCategory -> "Income Title / Received From *"
                        isExpenseCategory -> "Expense Title / Paid To Vendor *"
                        else -> "Asset / Item Title *"
                    },
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "+ Add / Manage Titles",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable { showManageTitlesDialog = true }
                        .testTag("btn_open_manage_titles")
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = title,
                onValueChange = {
                    title = it
                    if (titleError != null && it.isNotBlank()) titleError = null
                },
                placeholder = {
                    Text(
                        when {
                            isPaidLoanCategory -> "e.g. Ramesh Bhai, Amit Patel, Mitra"
                            isStockCategory -> "e.g. RELIANCE - Reliance Industries"
                            isIncomeCategory -> "e.g. Salary, Client Payment, Dividend"
                            isExpenseCategory -> "e.g. House Rent, Grocery, Medical"
                            else -> "e.g. HDFC Salary Account"
                        }
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = { titleDropdownExpanded = !titleDropdownExpanded },
                        modifier = Modifier.testTag("title_dropdown_toggle")
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Select or Manage Title"
                        )
                    }
                },
                isError = titleError != null,
                supportingText = titleError?.let { err ->
                    { Text(text = err, color = MaterialTheme.colorScheme.error) }
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("item_title_input")
            )

            DropdownMenu(
                expanded = titleDropdownExpanded,
                onDismissRequest = { titleDropdownExpanded = false }
            ) {
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "➕ Add / Manage Titles...",
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    onClick = {
                        titleDropdownExpanded = false
                        showManageTitlesDialog = true
                    }
                )

                HorizontalDivider()

                titlesList.forEach { tName ->
                    DropdownMenuItem(
                        text = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = tName,
                                    fontWeight = if (title.equals(tName, ignoreCase = true)) FontWeight.Bold else FontWeight.Normal,
                                    color = if (title.equals(tName, ignoreCase = true)) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.weight(1f)
                                )

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    IconButton(
                                        onClick = {
                                            titleDropdownExpanded = false
                                            editingTitleName = tName
                                            titleInputName = tName
                                            showManageTitlesDialog = true
                                        },
                                        modifier = Modifier.size(28.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Edit,
                                            contentDescription = "Edit Title",
                                            tint = Color(0xFF60A5FA),
                                            modifier = Modifier.size(15.dp)
                                        )
                                    }

                                    IconButton(
                                        onClick = {
                                            titleDropdownExpanded = false
                                            titleToDelete = tName
                                        },
                                        modifier = Modifier.size(28.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = "Delete Title",
                                            tint = Color(0xFFF87171),
                                            modifier = Modifier.size(15.dp)
                                        )
                                    }
                                }
                            }
                        },
                        onClick = {
                            title = tName
                            if (titleError != null) titleError = null
                            titleDropdownExpanded = false
                        }
                    )
                }
            }
        }

        // Belongs To (Owner Profile Dropdown)
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Belongs To (Owner Profile)",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "+ Add / Manage Owners",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable { showManageOwnersDialog = true }
                        .testTag("btn_open_manage_owners")
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { ownerDropdownExpanded = true }
                    .padding(vertical = 12.dp, horizontal = 16.dp)
                    .testTag("owner_dropdown")
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = owner,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Select Owner"
                    )
                }
            }
            DropdownMenu(
                expanded = ownerDropdownExpanded,
                onDismissRequest = { ownerDropdownExpanded = false }
            ) {
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "➕ Add / Manage Owners...",
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    onClick = {
                        ownerDropdownExpanded = false
                        showManageOwnersDialog = true
                    }
                )

                HorizontalDivider()

                ownersList.forEach { ownerName ->
                    DropdownMenuItem(
                        text = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = ownerName,
                                    fontWeight = if (owner.equals(ownerName, ignoreCase = true)) FontWeight.Bold else FontWeight.Normal,
                                    color = if (owner.equals(ownerName, ignoreCase = true)) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.weight(1f)
                                )

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    IconButton(
                                        onClick = {
                                            ownerDropdownExpanded = false
                                            editingOwnerName = ownerName
                                            ownerInputName = ownerName
                                            showManageOwnersDialog = true
                                        },
                                        modifier = Modifier.size(28.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Edit,
                                            contentDescription = "Edit Owner",
                                            tint = Color(0xFF60A5FA),
                                            modifier = Modifier.size(15.dp)
                                        )
                                    }

                                    IconButton(
                                        onClick = {
                                            ownerDropdownExpanded = false
                                            ownerToDelete = ownerName
                                        },
                                        modifier = Modifier.size(28.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = "Delete Owner",
                                            tint = Color(0xFFF87171),
                                            modifier = Modifier.size(15.dp)
                                        )
                                    }
                                }
                            }
                        },
                        onClick = {
                            owner = ownerName
                            ownerDropdownExpanded = false
                        }
                    )
                }
            }
        }

        // Bank / Broker / Institution Input with Dropdown & Management
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = when {
                        isPaidLoanCategory -> "Borrower Contact / Note (Optional)"
                        isStockCategory -> "Broker / Platform Name"
                        else -> "Bank / Broker / Institution"
                    },
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "+ Add / Manage Institutions",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable { showManageInstitutionsDialog = true }
                        .testTag("btn_open_manage_institutions")
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = institution,
                onValueChange = { institution = it },
                placeholder = {
                    Text(
                        when {
                            isPaidLoanCategory -> "e.g. +91 9876543210 / Friend / Business"
                            isStockCategory -> "e.g. Zerodha, Groww, Angel One"
                            else -> "e.g. State Bank of India"
                        }
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = if (isPaidLoanCategory) Icons.Default.Handshake else Icons.Default.AccountBalance,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = { instDropdownExpanded = !instDropdownExpanded },
                        modifier = Modifier.testTag("institution_dropdown_toggle")
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Select or Manage Institution"
                        )
                    }
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("institution_input")
            )

            DropdownMenu(
                expanded = instDropdownExpanded,
                onDismissRequest = { instDropdownExpanded = false }
            ) {
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "➕ Add / Manage Institutions...",
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    onClick = {
                        instDropdownExpanded = false
                        showManageInstitutionsDialog = true
                    }
                )

                HorizontalDivider()

                institutionsList.forEach { instName ->
                    DropdownMenuItem(
                        text = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = instName,
                                    fontWeight = if (institution.equals(instName, ignoreCase = true)) FontWeight.Bold else FontWeight.Normal,
                                    color = if (institution.equals(instName, ignoreCase = true)) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.weight(1f)
                                )

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    IconButton(
                                        onClick = {
                                            instDropdownExpanded = false
                                            editingInstitutionName = instName
                                            institutionInputName = instName
                                            showManageInstitutionsDialog = true
                                        },
                                        modifier = Modifier.size(28.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Edit,
                                            contentDescription = "Edit Institution",
                                            tint = Color(0xFF60A5FA),
                                            modifier = Modifier.size(15.dp)
                                        )
                                    }

                                    IconButton(
                                        onClick = {
                                            instDropdownExpanded = false
                                            institutionToDelete = instName
                                        },
                                        modifier = Modifier.size(28.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = "Delete Institution",
                                            tint = Color(0xFFF87171),
                                            modifier = Modifier.size(15.dp)
                                        )
                                    }
                                }
                            }
                        },
                        onClick = {
                            institution = instName
                            instDropdownExpanded = false
                        }
                    )
                }
            }
        }

        // Account Number / Demat / Folio Input with Dropdown & Management
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (isStockCategory) "Demat ID / DP Client ID (Optional)" else "Account / Demat No. / Folio",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "+ Add / Manage Nos",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable { showManageAccountNumbersDialog = true }
                        .testTag("btn_open_manage_account_numbers")
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = accountNumber,
                onValueChange = { accountNumber = it },
                placeholder = { Text(if (isStockCategory) "e.g. 1208160012345678" else "e.g. x1234 or FOL-9021") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.CreditCard,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = { accNoDropdownExpanded = !accNoDropdownExpanded },
                        modifier = Modifier.testTag("account_number_dropdown_toggle")
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Select or Manage Account Number"
                        )
                    }
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("account_number_input")
            )

            DropdownMenu(
                expanded = accNoDropdownExpanded,
                onDismissRequest = { accNoDropdownExpanded = false }
            ) {
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "➕ Add / Manage Nos...",
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    onClick = {
                        accNoDropdownExpanded = false
                        showManageAccountNumbersDialog = true
                    }
                )

                HorizontalDivider()

                accountNumbersList.forEach { accNum ->
                    DropdownMenuItem(
                        text = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = accNum,
                                    fontWeight = if (accountNumber.equals(accNum, ignoreCase = true)) FontWeight.Bold else FontWeight.Normal,
                                    color = if (accountNumber.equals(accNum, ignoreCase = true)) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.weight(1f)
                                )

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    IconButton(
                                        onClick = {
                                            accNoDropdownExpanded = false
                                            editingAccountNumberName = accNum
                                            accountNumberInputName = accNum
                                            showManageAccountNumbersDialog = true
                                        },
                                        modifier = Modifier.size(28.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Edit,
                                            contentDescription = "Edit Account Number",
                                            tint = Color(0xFF60A5FA),
                                            modifier = Modifier.size(15.dp)
                                        )
                                    }

                                    IconButton(
                                        onClick = {
                                            accNoDropdownExpanded = false
                                            accountNumberToDelete = accNum
                                        },
                                        modifier = Modifier.size(28.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = "Delete Account Number",
                                            tint = Color(0xFFF87171),
                                            modifier = Modifier.size(15.dp)
                                        )
                                    }
                                }
                            }
                        },
                        onClick = {
                            accountNumber = accNum
                            accNoDropdownExpanded = false
                        }
                    )
                }
            }
        }

        // IF Share Market / Stocks category is selected:
        // REMOVE manual "Current Valuation / Balance" field and REPLACE with Auto Share Valuation (Google Finance Engine)!
        if (isStockCategory) {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("google_finance_auto_valuation_card")
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    // Google Finance Header Badge
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(28.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Default.ShowChart,
                                        contentDescription = "Google Finance",
                                        tint = MaterialTheme.colorScheme.onPrimary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(
                                    text = "Auto Share Valuation",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "Powered by Google Finance Ticker Engine",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        // Live Ticker Badge
                        Surface(
                            shape = RoundedCornerShape(20.dp),
                            color = if (isQuotePositive) Color(0xFF16A34A).copy(alpha = 0.15f) else Color(0xFFDC2626).copy(alpha = 0.15f)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = if (isQuotePositive) Icons.Default.TrendingUp else Icons.Default.TrendingDown,
                                    contentDescription = null,
                                    tint = if (isQuotePositive) Color(0xFF15803D) else Color(0xFFB91C1C),
                                    modifier = Modifier.size(14.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "${if (isQuotePositive) "+" else ""}${String.format(Locale.US, "%.2f", stockQuoteChangePercent)}%",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isQuotePositive) Color(0xFF15803D) else Color(0xFFB91C1C)
                                )
                            }
                        }
                    }

                    // Stock Selection Chips + Add / Modify / Delete Actions
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "My Stock Tickers",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontWeight = FontWeight.Bold
                            )

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(0.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Add New Custom Stock Button
                                TextButton(
                                    onClick = {
                                        customSymbol = ""
                                        customName = ""
                                        customExchange = "NSE"
                                        customPriceStr = ""
                                        showAddStockDialog = true
                                    },
                                    modifier = Modifier.testTag("btn_add_stock")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Add,
                                        contentDescription = "Add Stock",
                                        modifier = Modifier.size(15.dp)
                                    )
                                    Spacer(modifier = Modifier.width(2.dp))
                                    Text("Add", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }

                                // Modify Selected Stock Button
                                TextButton(
                                    onClick = {
                                        val current = stockList.find { it.symbol == selectedStockSymbol }
                                        if (current != null) {
                                            stockToEdit = current
                                            customSymbol = current.symbol
                                            customName = current.name
                                            customExchange = current.exchange
                                            customPriceStr = String.format(Locale.US, "%.2f", current.currentPrice)
                                        }
                                    },
                                    modifier = Modifier.testTag("btn_modify_stock")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = "Modify Stock",
                                        modifier = Modifier.size(15.dp)
                                    )
                                    Spacer(modifier = Modifier.width(2.dp))
                                    Text("Modify", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }

                                // Delete Selected Stock Button
                                TextButton(
                                    onClick = {
                                        if (stockList.isNotEmpty()) {
                                            showDeleteStockDialog = true
                                        }
                                    },
                                    colors = ButtonDefaults.textButtonColors(
                                        contentColor = MaterialTheme.colorScheme.error
                                    ),
                                    modifier = Modifier.testTag("btn_delete_stock")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = "Delete Stock",
                                        modifier = Modifier.size(15.dp)
                                    )
                                    Spacer(modifier = Modifier.width(2.dp))
                                    Text("Delete", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }

                        LazyRow(
                            modifier = Modifier.fillMaxWidth(),
                            state = stockLazyListState,
                            contentPadding = PaddingValues(horizontal = 2.dp, vertical = 2.dp),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            // Direct "+ Add Stock" Chip at position 0 in the scrollable list
                            item(key = "action_chip_add_new") {
                                FilterChip(
                                    selected = false,
                                    onClick = {
                                        customSymbol = ""
                                        customName = ""
                                        customExchange = "NSE"
                                        customPriceStr = ""
                                        showAddStockDialog = true
                                    },
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Default.Add,
                                            contentDescription = "Add Stock",
                                            tint = MaterialTheme.colorScheme.primary,
                                            modifier = Modifier.size(16.dp)
                                        )
                                    },
                                    label = {
                                        Text(
                                            text = "+ Add Ticker",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                    },
                                    colors = FilterChipDefaults.filterChipColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)
                                    )
                                )
                            }

                            // Dynamic list of stock ticker chips
                            items(stockList, key = { it.symbol }) { stock ->
                                val isSelected = selectedStockSymbol == stock.symbol
                                FilterChip(
                                    selected = isSelected,
                                    onClick = {
                                        selectedStockSymbol = stock.symbol
                                        selectedStockName = stock.name
                                        exchangeName = stock.exchange
                                        marketPricePerShareStr = String.format(Locale.US, "%.2f", stock.currentPrice)
                                        stockQuoteChangePercent = stock.changePercent
                                        isQuotePositive = stock.isPositive
                                        if (title.isBlank() || stockList.any { title.contains(it.symbol) }) {
                                            title = "${stock.symbol} - ${stock.name}"
                                        }
                                    },
                                    label = {
                                        Text(
                                            text = "${stock.symbol} (₹${String.format(Locale.US, "%.0f", stock.currentPrice)})",
                                            fontSize = 11.sp,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                        )
                                    },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                                        selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                                    )
                                )
                            }
                        }
                    }

                    // Inputs Row: Number of Shares & Live Market Price
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Shares Quantity Input
                        OutlinedTextField(
                            value = sharesQuantityStr,
                            onValueChange = {
                                sharesQuantityStr = it
                                if (stockQuantityError != null) stockQuantityError = null
                            },
                            label = { Text("No. of Shares *") },
                            placeholder = { Text("10") },
                            isError = stockQuantityError != null,
                            supportingText = stockQuantityError?.let { err ->
                                { Text(text = err, color = MaterialTheme.colorScheme.error) }
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            modifier = Modifier
                                .weight(1f)
                                .testTag("shares_quantity_input")
                        )

                        // Market Price per Share (Live Google Finance CMP)
                        OutlinedTextField(
                            value = marketPricePerShareStr,
                            onValueChange = {
                                marketPricePerShareStr = it
                                if (stockPriceError != null) stockPriceError = null
                            },
                            label = { Text("Market Price/Share (₹) *") },
                            placeholder = { Text("2980.50") },
                            trailingIcon = {
                                IconButton(onClick = {
                                    // Simulate live quote refresh from Google Finance feed
                                    val currentPriceNum = marketPricePerShareStr.toDoubleOrNull() ?: 1000.0
                                    val delta = ((-15..25).random() / 10.0)
                                    val newPrice = (currentPriceNum + delta).coerceAtLeast(1.0)
                                    marketPricePerShareStr = String.format(Locale.US, "%.2f", newPrice)
                                    stockQuoteChangePercent = (delta / currentPriceNum) * 100
                                    isQuotePositive = delta >= 0
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Refresh,
                                        contentDescription = "Refresh Quote",
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            },
                            isError = stockPriceError != null,
                            supportingText = stockPriceError?.let { err ->
                                { Text(text = err, color = MaterialTheme.colorScheme.error) }
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            modifier = Modifier
                                .weight(1.2f)
                                .testTag("market_price_input")
                        )
                    }

                    // Optional Buy / Average Cost Price per Share Input
                    OutlinedTextField(
                        value = buyPricePerShareStr,
                        onValueChange = { buyPricePerShareStr = it },
                        label = { Text("Avg Buy Price per Share (₹) [For Profit & Loss]") },
                        placeholder = { Text("2500.00") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("buy_price_input")
                    )

                    // Live Auto Valuation Calculation Summary Box
                    val qtyNum = sharesQuantityStr.toDoubleOrNull() ?: 0.0
                    val mktPriceNum = marketPricePerShareStr.toDoubleOrNull() ?: 0.0
                    val buyPriceNum = buyPricePerShareStr.toDoubleOrNull() ?: mktPriceNum

                    val autoCurrentValue = qtyNum * mktPriceNum
                    val autoInvestedValue = qtyNum * buyPriceNum
                    val pnlAmount = autoCurrentValue - autoInvestedValue
                    val pnlPercent = if (autoInvestedValue > 0) (pnlAmount / autoInvestedValue) * 100 else 0.0

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.surface,
                        tonalElevation = 2.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = "AUTO CALCULATED SHARE VALUATION",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(
                                        text = "Current Valuation:",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Text(
                                        text = "₹${String.format(Locale.US, "%,.2f", autoCurrentValue)}",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }

                                Column(horizontalAlignment = Alignment.End) {
                                    Text(
                                        text = "Unrealized P&L:",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Text(
                                        text = "${if (pnlAmount >= 0) "+" else ""}₹${String.format(Locale.US, "%,.2f", pnlAmount)} (${String.format(Locale.US, "%.1f", pnlPercent)}%)",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = if (pnlAmount >= 0) Color(0xFF15803D) else Color(0xFFB91C1C)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        } else {
            // Standard Current Valuation / Balance field for non-stock categories
            OutlinedTextField(
                value = currentValueStr,
                onValueChange = { input ->
                    currentValueStr = input
                    if (currentValueError != null) {
                        val cleaned = validateAndCleanCurrencyInput(input)
                        if (cleaned.toDoubleOrNull() != null) {
                            currentValueError = null
                        }
                    }
                },
                label = {
                    Text(
                        when {
                            isPaidLoanCategory -> "Loan Given / Principal Amount (₹) *"
                            isLiability -> "Current Outstanding Amount (₹) *"
                            else -> "Current Valuation / Balance (₹) *"
                        }
                    )
                },
                placeholder = { Text("0.00") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.CurrencyRupee,
                        contentDescription = "Rupees"
                    )
                },
                trailingIcon = {
                    if (currentValueError != null) {
                        Icon(
                            imageVector = Icons.Default.ErrorOutline,
                            contentDescription = "Error",
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                },
                isError = currentValueError != null,
                supportingText = currentValueError?.let { err ->
                    { Text(text = err, color = MaterialTheme.colorScheme.error) }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("current_value_input")
            )

            // Invested Value (Optional for Mutual Funds)
            if (isMFOnly) {
                OutlinedTextField(
                    value = investedValueStr,
                    onValueChange = { input ->
                        investedValueStr = input
                        if (investedValueError != null) {
                            val cleaned = validateAndCleanCurrencyInput(input)
                            if (cleaned.isEmpty() || cleaned.toDoubleOrNull() != null) {
                                investedValueError = null
                            }
                        }
                    },
                    label = { Text("Original Invested Amount (₹) [For P&L tracking]") },
                    placeholder = { Text("0.00") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.CurrencyRupee,
                            contentDescription = "Rupees"
                        )
                    },
                    isError = investedValueError != null,
                    supportingText = investedValueError?.let { err ->
                        { Text(text = err, color = MaterialTheme.colorScheme.error) }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("invested_value_input")
                )
            }
        }

        // Notes / Comments Field
        OutlinedTextField(
            value = notes,
            onValueChange = { notes = it },
            label = { Text("Notes / Comments (Optional)") },
            placeholder = { Text("e.g. SIP date, maturity details") },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("notes_input")
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Form Action Buttons (Save & Cancel)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(
                onClick = onCancel,
                modifier = Modifier.testTag("cancel_item_button")
            ) {
                Text("Cancel")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    if (performValidation()) {
                        val cleanedCurVal = validateAndCleanCurrencyInput(currentValueStr)
                        val curVal = cleanedCurVal.toDoubleOrNull() ?: 0.0
                        val cleanedInvVal = validateAndCleanCurrencyInput(investedValueStr)
                        val invVal = cleanedInvVal.toDoubleOrNull() ?: curVal

                        val finalNotes = if (isStockCategory) {
                            val stockNote = "[Google Finance: ${sharesQuantityStr} shares of $selectedStockSymbol @ ₹${marketPricePerShareStr}]"
                            if (notes.isBlank()) stockNote else "$notes\n$stockNote"
                        } else notes.trim()

                        val newItem = FinancialItem(
                            id = itemToEdit?.id ?: 0L,
                            title = title.trim(),
                            institution = institution.trim(),
                            accountNumber = accountNumber.trim(),
                            owner = owner,
                            category = category,
                            currentValue = curVal,
                            investedValue = invVal,
                            isLiability = isLiability,
                            notes = finalNotes,
                            sourceAccountTitle = if (shouldDeductOrAddOpposite) sourceAccountTitle.trim() else "",
                            updatedAt = System.currentTimeMillis()
                        )
                        onSave(newItem)
                    }
                },
                modifier = Modifier.testTag("save_item_button")
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(submitButtonText)
            }
        }
    }

    // --- ADD CUSTOM STOCK DIALOG ---
    if (showAddStockDialog) {
        var dialogError by remember { mutableStateOf<String?>(null) }
        AlertDialog(
            onDismissRequest = { showAddStockDialog = false },
            title = { Text("Add Custom Stock Name", fontWeight = FontWeight.Bold) },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    OutlinedTextField(
                        value = customSymbol,
                        onValueChange = { customSymbol = it.uppercase() },
                        label = { Text("Stock Symbol / Ticker *") },
                        placeholder = { Text("e.g. ZOMATO, SUZLON, MRF") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("dialog_stock_symbol")
                    )
                    OutlinedTextField(
                        value = customName,
                        onValueChange = { customName = it },
                        label = { Text("Company Name *") },
                        placeholder = { Text("e.g. Zomato Limited") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("dialog_stock_name")
                    )
                    OutlinedTextField(
                        value = customExchange,
                        onValueChange = { customExchange = it.uppercase() },
                        label = { Text("Exchange (NSE, BSE, NASDAQ)") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("dialog_stock_exchange")
                    )
                    OutlinedTextField(
                        value = customPriceStr,
                        onValueChange = { customPriceStr = it },
                        label = { Text("Current Market Price (₹) *") },
                        placeholder = { Text("220.50") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("dialog_stock_price")
                    )
                    dialogError?.let {
                        Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val sym = customSymbol.trim()
                        val name = customName.trim()
                        val price = customPriceStr.toDoubleOrNull()
                        if (sym.isEmpty() || name.isEmpty() || price == null || price <= 0) {
                            dialogError = "Please enter valid symbol, name and price (> 0)."
                            return@Button
                        }
                        val newStock = StockQuote(
                            symbol = sym,
                            name = name,
                            exchange = customExchange.trim().ifEmpty { "NSE" },
                            currentPrice = price,
                            changePercent = 1.20,
                            isPositive = true
                        )
                        stockList.removeAll { it.symbol.equals(sym, ignoreCase = true) }
                        stockList.add(0, newStock)

                        // Set active selections
                        selectedStockSymbol = newStock.symbol
                        selectedStockName = newStock.name
                        exchangeName = newStock.exchange
                        marketPricePerShareStr = String.format(Locale.US, "%.2f", newStock.currentPrice)
                        title = "${newStock.symbol} - ${newStock.name}"

                        // Calculate current values
                        val qty = validateAndCleanCurrencyInput(sharesQuantityStr).toDoubleOrNull() ?: 10.0
                        val buyP = validateAndCleanCurrencyInput(buyPricePerShareStr).toDoubleOrNull() ?: newStock.currentPrice
                        currentValueStr = String.format(Locale.US, "%.2f", qty * newStock.currentPrice)
                        investedValueStr = String.format(Locale.US, "%.2f", qty * buyP)

                        coroutineScope.launch {
                            stockLazyListState.animateScrollToItem(1)
                        }

                        showAddStockDialog = false
                    },
                    modifier = Modifier.testTag("confirm_add_stock")
                ) {
                    Text("Add Stock")
                }
            },
            dismissButton = {
                TextButton(onClick = { showAddStockDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // --- MODIFY (EDIT) STOCK DIALOG ---
    if (stockToEdit != null) {
        var dialogError by remember { mutableStateOf<String?>(null) }
        AlertDialog(
            onDismissRequest = { stockToEdit = null },
            title = { Text("Modify Stock Details", fontWeight = FontWeight.Bold) },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    OutlinedTextField(
                        value = customSymbol,
                        onValueChange = { customSymbol = it.uppercase() },
                        label = { Text("Stock Symbol / Ticker *") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("dialog_edit_stock_symbol")
                    )
                    OutlinedTextField(
                        value = customName,
                        onValueChange = { customName = it },
                        label = { Text("Company Name *") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("dialog_edit_stock_name")
                    )
                    OutlinedTextField(
                        value = customExchange,
                        onValueChange = { customExchange = it.uppercase() },
                        label = { Text("Exchange (NSE, BSE, NASDAQ)") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("dialog_edit_stock_exchange")
                    )
                    OutlinedTextField(
                        value = customPriceStr,
                        onValueChange = { customPriceStr = it },
                        label = { Text("Current Market Price (₹) *") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("dialog_edit_stock_price")
                    )
                    dialogError?.let {
                        Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val sym = customSymbol.trim()
                        val name = customName.trim()
                        val price = customPriceStr.toDoubleOrNull()
                        if (sym.isEmpty() || name.isEmpty() || price == null || price <= 0) {
                            dialogError = "Please enter valid symbol, name and price (> 0)."
                            return@Button
                        }
                        val updatedStock = StockQuote(
                            symbol = sym,
                            name = name,
                            exchange = customExchange.trim().ifEmpty { "NSE" },
                            currentPrice = price,
                            changePercent = stockToEdit?.changePercent ?: 0.8,
                            isPositive = stockToEdit?.isPositive ?: true
                        )

                        val idx = stockList.indexOfFirst { it.symbol == stockToEdit?.symbol }
                        if (idx != -1) {
                            stockList[idx] = updatedStock
                        } else {
                            stockList.add(updatedStock)
                        }

                        // Set active selections
                        selectedStockSymbol = updatedStock.symbol
                        selectedStockName = updatedStock.name
                        exchangeName = updatedStock.exchange
                        marketPricePerShareStr = String.format(Locale.US, "%.2f", updatedStock.currentPrice)
                        title = "${updatedStock.symbol} - ${updatedStock.name}"

                        stockToEdit = null
                    },
                    modifier = Modifier.testTag("confirm_modify_stock")
                ) {
                    Text("Update Stock")
                }
            },
            dismissButton = {
                TextButton(onClick = { stockToEdit = null }) {
                    Text("Cancel")
                }
            }
        )
    }

    // --- DELETE STOCK DIALOG ---
    if (showDeleteStockDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteStockDialog = false },
            title = { Text("Delete Stock Ticker?") },
            text = { Text("Are you sure you want to remove '$selectedStockSymbol' from your stock list?") },
            confirmButton = {
                Button(
                    onClick = {
                        stockList.removeAll { it.symbol == selectedStockSymbol }
                        stockList.firstOrNull()?.let { firstStock ->
                            selectedStockSymbol = firstStock.symbol
                            selectedStockName = firstStock.name
                            exchangeName = firstStock.exchange
                            marketPricePerShareStr = String.format(Locale.US, "%.2f", firstStock.currentPrice)
                            title = "${firstStock.symbol} - ${firstStock.name}"
                        }
                        showDeleteStockDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                    modifier = Modifier.testTag("confirm_delete_stock")
                ) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteStockDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // --- MANAGE CATEGORIES & HEADINGS DIALOG ---
    if (showManageCategoriesDialog) {
        var catInputName by remember { mutableStateOf(editingCategoryName ?: "") }
        var catTypeIsLiability by remember { mutableStateOf(false) }

        val categoryPresets = listOf(
            "PETROL",
            "Electricity Bill",
            "House Rent",
            "Grocery",
            "Mobile & WiFi",
            "Medical Expense",
            "School Fees",
            "Shopping",
            "Entertainment",
            "Vehicle Repair",
            "Salary Income",
            "Business Income"
        )

        AlertDialog(
            onDismissRequest = {
                showManageCategoriesDialog = false
                editingCategoryName = null
            },
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Tune,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Manage Categories & Headings", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    IconButton(onClick = {
                        showManageCategoriesDialog = false
                        editingCategoryName = null
                    }) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }
            },
            text = {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Quick Presets
                    Text(
                        text = "Quick Presets (Click to Auto-Fill):",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        items(categoryPresets) { preset ->
                            FilterChip(
                                selected = catInputName.equals(preset, ignoreCase = true),
                                onClick = {
                                    catInputName = preset
                                },
                                label = { Text(preset, fontSize = 11.sp) }
                            )
                        }
                    }

                    HorizontalDivider()

                    // Add / Edit Form
                    Text(
                        text = if (editingCategoryName == null) "➕ Add New Category" else "✏️ Edit Category: $editingCategoryName",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    OutlinedTextField(
                        value = catInputName,
                        onValueChange = { catInputName = it },
                        label = { Text("Category Name *") },
                        placeholder = { Text("e.g. PETROL, Electric Bill, Salary") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("manage_cat_name_input")
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        FilterChip(
                            selected = !catTypeIsLiability,
                            onClick = { catTypeIsLiability = false },
                            label = { Text("Asset / Account", fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Color(0xFF059669),
                                selectedLabelColor = Color.White
                            ),
                            modifier = Modifier.weight(1f)
                        )

                        FilterChip(
                            selected = catTypeIsLiability,
                            onClick = { catTypeIsLiability = true },
                            label = { Text("Expense / Outflow", fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Color(0xFF7C3AED),
                                selectedLabelColor = Color.White
                            ),
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        if (editingCategoryName != null) {
                            TextButton(
                                onClick = {
                                    editingCategoryName = null
                                    catInputName = ""
                                }
                            ) {
                                Text("Cancel Edit")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                        }

                        Button(
                            onClick = {
                                val trimmed = catInputName.trim()
                                if (trimmed.isNotBlank()) {
                                    if (editingCategoryName != null) {
                                        val oldName = editingCategoryName!!
                                        val updated = categoriesList.map {
                                            if (it.equals(oldName, ignoreCase = true)) trimmed else it
                                        }
                                        saveCategoriesToPrefs(updated)
                                        if (category.equals(oldName, ignoreCase = true)) {
                                            category = trimmed
                                        }
                                    } else {
                                        if (!categoriesList.any { it.equals(trimmed, ignoreCase = true) }) {
                                            val updated = categoriesList + trimmed
                                            saveCategoriesToPrefs(updated)
                                        }
                                        category = trimmed
                                    }

                                    // Reset input
                                    editingCategoryName = null
                                    catInputName = ""
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED)),
                            modifier = Modifier.testTag("btn_save_category")
                        ) {
                            Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(if (editingCategoryName == null) "Add Category" else "Update Category")
                        }
                    }

                    HorizontalDivider()

                    // Existing Categories List
                    Text(
                        text = "Existing Categories (${categoriesList.size})",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        categoriesList.forEach { catName ->
                            val isBeingEdited = editingCategoryName?.equals(catName, ignoreCase = true) == true
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = if (isBeingEdited) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                border = if (isBeingEdited) androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.primary) else null,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = catName,
                                        fontWeight = FontWeight.Bold,
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.weight(1f)
                                    )

                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        IconButton(
                                            onClick = {
                                                editingCategoryName = catName
                                                catInputName = catName
                                            },
                                            modifier = Modifier.size(32.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Edit,
                                                contentDescription = "Edit Category",
                                                tint = Color(0xFF60A5FA),
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }

                                        IconButton(
                                            onClick = {
                                                categoryToDelete = catName
                                            },
                                            modifier = Modifier.size(32.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Delete,
                                                contentDescription = "Delete Category",
                                                tint = Color(0xFFF87171),
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {},
            dismissButton = {}
        )
    }

    // --- DELETE CATEGORY CONFIRMATION DIALOG ---
    if (categoryToDelete != null) {
        val catName = categoryToDelete!!
        AlertDialog(
            onDismissRequest = { categoryToDelete = null },
            title = { Text("Delete Category?") },
            text = { Text("Are you sure you want to delete category '$catName'?") },
            confirmButton = {
                Button(
                    onClick = {
                        val updated = categoriesList.filterNot { it.equals(catName, ignoreCase = true) }
                        saveCategoriesToPrefs(updated)
                        if (category.equals(catName, ignoreCase = true)) {
                            category = updated.firstOrNull() ?: "Bank Account"
                        }
                        categoryToDelete = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = { categoryToDelete = null }) {
                    Text("Cancel")
                }
            }
        )
    }

    // --- MANAGE OWNERS DIALOG (ADD, MODIFY, DELETE) ---
    if (showManageOwnersDialog) {
        AlertDialog(
            onDismissRequest = {
                showManageOwnersDialog = false
                editingOwnerName = null
                ownerInputName = ""
            },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Tune, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Manage Owner Profiles", fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Add / Edit Form
                    Text(
                        text = if (editingOwnerName == null) "➕ Add New Owner" else "✏️ Edit Owner: $editingOwnerName",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    OutlinedTextField(
                        value = ownerInputName,
                        onValueChange = { ownerInputName = it },
                        label = { Text("Owner Profile Name *") },
                        placeholder = { Text("e.g. Spouse, Brother, Sister, Business") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("manage_owner_name_input")
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        if (editingOwnerName != null) {
                            TextButton(
                                onClick = {
                                    editingOwnerName = null
                                    ownerInputName = ""
                                }
                            ) {
                                Text("Cancel Edit")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                        }

                        Button(
                            onClick = {
                                val trimmed = ownerInputName.trim()
                                if (trimmed.isNotBlank()) {
                                    if (editingOwnerName != null) {
                                        val oldName = editingOwnerName!!
                                        val updated = ownersList.map {
                                            if (it.equals(oldName, ignoreCase = true)) trimmed else it
                                        }
                                        saveOwnersToPrefs(updated)
                                        if (owner.equals(oldName, ignoreCase = true)) {
                                            owner = trimmed
                                        }
                                    } else {
                                        if (!ownersList.any { it.equals(trimmed, ignoreCase = true) }) {
                                            val updated = ownersList + trimmed
                                            saveOwnersToPrefs(updated)
                                        }
                                        owner = trimmed
                                    }

                                    // Reset input
                                    editingOwnerName = null
                                    ownerInputName = ""
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                            modifier = Modifier.testTag("btn_save_owner")
                        ) {
                            Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(if (editingOwnerName == null) "Add Owner" else "Update Owner")
                        }
                    }

                    HorizontalDivider()

                    // Existing Owners List
                    Text(
                        text = "Existing Owners (${ownersList.size})",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        ownersList.forEach { ownerName ->
                            val isBeingEdited = editingOwnerName?.equals(ownerName, ignoreCase = true) == true
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = if (isBeingEdited) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                border = if (isBeingEdited) androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.primary) else null,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = ownerName,
                                        fontWeight = FontWeight.Bold,
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.weight(1f)
                                    )

                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        IconButton(
                                            onClick = {
                                                editingOwnerName = ownerName
                                                ownerInputName = ownerName
                                            },
                                            modifier = Modifier.size(32.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Edit,
                                                contentDescription = "Edit Owner",
                                                tint = Color(0xFF60A5FA),
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }

                                        IconButton(
                                            onClick = {
                                                ownerToDelete = ownerName
                                            },
                                            modifier = Modifier.size(32.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Delete,
                                                contentDescription = "Delete Owner",
                                                tint = Color(0xFFF87171),
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {},
            dismissButton = {
                TextButton(
                    onClick = {
                        showManageOwnersDialog = false
                        editingOwnerName = null
                        ownerInputName = ""
                    }
                ) {
                    Text("Close")
                }
            }
        )
    }

    // --- DELETE OWNER CONFIRMATION DIALOG ---
    if (ownerToDelete != null) {
        val oName = ownerToDelete!!
        AlertDialog(
            onDismissRequest = { ownerToDelete = null },
            title = { Text("Delete Owner Profile?") },
            text = { Text("Are you sure you want to delete owner profile '$oName'?") },
            confirmButton = {
                Button(
                    onClick = {
                        val updated = ownersList.filterNot { it.equals(oName, ignoreCase = true) }
                        saveOwnersToPrefs(updated)
                        if (owner.equals(oName, ignoreCase = true)) {
                            owner = updated.firstOrNull() ?: "Self"
                        }
                        ownerToDelete = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = { ownerToDelete = null }) {
                    Text("Cancel")
                }
            }
        )
    }

    // --- MANAGE TITLES DIALOG (ADD, MODIFY, DELETE) ---
    if (showManageTitlesDialog) {
        AlertDialog(
            onDismissRequest = {
                showManageTitlesDialog = false
                editingTitleName = null
                titleInputName = ""
            },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Tune, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Manage Asset / Item Titles", fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = if (editingTitleName == null) "➕ Add New Title Option" else "✏️ Edit Title: $editingTitleName",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    OutlinedTextField(
                        value = titleInputName,
                        onValueChange = { titleInputName = it },
                        label = { Text("Asset / Item Title Name *") },
                        placeholder = { Text("e.g. HDFC Salary, Gold Sovereign, Tata Motors") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("manage_title_name_input")
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        if (editingTitleName != null) {
                            TextButton(
                                onClick = {
                                    editingTitleName = null
                                    titleInputName = ""
                                }
                            ) {
                                Text("Cancel Edit")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                        }

                        Button(
                            onClick = {
                                val trimmed = titleInputName.trim()
                                if (trimmed.isNotBlank()) {
                                    if (editingTitleName != null) {
                                        val oldName = editingTitleName!!
                                        val updated = titlesList.map {
                                            if (it.equals(oldName, ignoreCase = true)) trimmed else it
                                        }
                                        saveTitlesToPrefs(updated)
                                        if (title.equals(oldName, ignoreCase = true)) {
                                            title = trimmed
                                        }
                                    } else {
                                        if (!titlesList.any { it.equals(trimmed, ignoreCase = true) }) {
                                            val updated = titlesList + trimmed
                                            saveTitlesToPrefs(updated)
                                        }
                                        title = trimmed
                                    }

                                    editingTitleName = null
                                    titleInputName = ""
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                            modifier = Modifier.testTag("btn_save_title_option")
                        ) {
                            Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(if (editingTitleName == null) "Add Title" else "Update Title")
                        }
                    }

                    HorizontalDivider()

                    Text(
                        text = "Existing Saved Titles (${titlesList.size})",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        titlesList.forEach { tName ->
                            val isBeingEdited = editingTitleName?.equals(tName, ignoreCase = true) == true
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = if (isBeingEdited) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                border = if (isBeingEdited) androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.primary) else null,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = tName,
                                        fontWeight = FontWeight.Bold,
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.weight(1f)
                                    )

                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        IconButton(
                                            onClick = {
                                                editingTitleName = tName
                                                titleInputName = tName
                                            },
                                            modifier = Modifier.size(32.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Edit,
                                                contentDescription = "Edit Title",
                                                tint = Color(0xFF60A5FA),
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }

                                        IconButton(
                                            onClick = {
                                                titleToDelete = tName
                                            },
                                            modifier = Modifier.size(32.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Delete,
                                                contentDescription = "Delete Title",
                                                tint = Color(0xFFF87171),
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {},
            dismissButton = {
                TextButton(
                    onClick = {
                        showManageTitlesDialog = false
                        editingTitleName = null
                        titleInputName = ""
                    }
                ) {
                    Text("Close")
                }
            }
        )
    }

    // --- DELETE TITLE CONFIRMATION DIALOG ---
    if (titleToDelete != null) {
        val tName = titleToDelete!!
        AlertDialog(
            onDismissRequest = { titleToDelete = null },
            title = { Text("Delete Title Option?") },
            text = { Text("Are you sure you want to delete '$tName' from saved title options?") },
            confirmButton = {
                Button(
                    onClick = {
                        val updated = titlesList.filterNot { it.equals(tName, ignoreCase = true) }
                        saveTitlesToPrefs(updated)
                        if (title.equals(tName, ignoreCase = true)) {
                            title = updated.firstOrNull() ?: ""
                        }
                        titleToDelete = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = { titleToDelete = null }) {
                    Text("Cancel")
                }
            }
        )
    }

    // --- MANAGE INSTITUTIONS DIALOG (ADD, MODIFY, DELETE) ---
    if (showManageInstitutionsDialog) {
        AlertDialog(
            onDismissRequest = {
                showManageInstitutionsDialog = false
                editingInstitutionName = null
                institutionInputName = ""
            },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Tune, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Manage Institutions / Banks", fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = if (editingInstitutionName == null) "➕ Add New Bank / Institution" else "✏️ Edit Institution: $editingInstitutionName",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    OutlinedTextField(
                        value = institutionInputName,
                        onValueChange = { institutionInputName = it },
                        label = { Text("Bank / Broker / Institution Name *") },
                        placeholder = { Text("e.g. HDFC Bank, Zerodha, SBI, Post Office") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("manage_inst_name_input")
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        if (editingInstitutionName != null) {
                            TextButton(
                                onClick = {
                                    editingInstitutionName = null
                                    institutionInputName = ""
                                }
                            ) {
                                Text("Cancel Edit")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                        }

                        Button(
                            onClick = {
                                val trimmed = institutionInputName.trim()
                                if (trimmed.isNotBlank()) {
                                    if (editingInstitutionName != null) {
                                        val oldName = editingInstitutionName!!
                                        val updated = institutionsList.map {
                                            if (it.equals(oldName, ignoreCase = true)) trimmed else it
                                        }
                                        saveInstitutionsToPrefs(updated)
                                        if (institution.equals(oldName, ignoreCase = true)) {
                                            institution = trimmed
                                        }
                                    } else {
                                        if (!institutionsList.any { it.equals(trimmed, ignoreCase = true) }) {
                                            val updated = institutionsList + trimmed
                                            saveInstitutionsToPrefs(updated)
                                        }
                                        institution = trimmed
                                    }

                                    editingInstitutionName = null
                                    institutionInputName = ""
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                            modifier = Modifier.testTag("btn_save_institution_option")
                        ) {
                            Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(if (editingInstitutionName == null) "Add Institution" else "Update Institution")
                        }
                    }

                    HorizontalDivider()

                    Text(
                        text = "Existing Institutions (${institutionsList.size})",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        institutionsList.forEach { instName ->
                            val isBeingEdited = editingInstitutionName?.equals(instName, ignoreCase = true) == true
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = if (isBeingEdited) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                border = if (isBeingEdited) androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.primary) else null,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = instName,
                                        fontWeight = FontWeight.Bold,
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.weight(1f)
                                    )

                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        IconButton(
                                            onClick = {
                                                editingInstitutionName = instName
                                                institutionInputName = instName
                                            },
                                            modifier = Modifier.size(32.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Edit,
                                                contentDescription = "Edit Institution",
                                                tint = Color(0xFF60A5FA),
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }

                                        IconButton(
                                            onClick = {
                                                institutionToDelete = instName
                                            },
                                            modifier = Modifier.size(32.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Delete,
                                                contentDescription = "Delete Institution",
                                                tint = Color(0xFFF87171),
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {},
            dismissButton = {
                TextButton(
                    onClick = {
                        showManageInstitutionsDialog = false
                        editingInstitutionName = null
                        institutionInputName = ""
                    }
                ) {
                    Text("Close")
                }
            }
        )
    }

    // --- DELETE INSTITUTION CONFIRMATION DIALOG ---
    if (institutionToDelete != null) {
        val instName = institutionToDelete!!
        AlertDialog(
            onDismissRequest = { institutionToDelete = null },
            title = { Text("Delete Institution?") },
            text = { Text("Are you sure you want to delete '$instName' from saved institutions?") },
            confirmButton = {
                Button(
                    onClick = {
                        val updated = institutionsList.filterNot { it.equals(instName, ignoreCase = true) }
                        saveInstitutionsToPrefs(updated)
                        if (institution.equals(instName, ignoreCase = true)) {
                            institution = updated.firstOrNull() ?: ""
                        }
                        institutionToDelete = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = { institutionToDelete = null }) {
                    Text("Cancel")
                }
            }
        )
    }

    // --- MANAGE ACCOUNT NUMBERS / FOLIOS DIALOG (ADD, MODIFY, DELETE) ---
    if (showManageAccountNumbersDialog) {
        AlertDialog(
            onDismissRequest = {
                showManageAccountNumbersDialog = false
                editingAccountNumberName = null
                accountNumberInputName = ""
            },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Tune, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Manage Account / Demat / Folio Nos", fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = if (editingAccountNumberName == null) "➕ Add New Account / Demat / Folio No." else "✏️ Edit No.: $editingAccountNumberName",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    OutlinedTextField(
                        value = accountNumberInputName,
                        onValueChange = { accountNumberInputName = it },
                        label = { Text("Account / Demat No. / Folio *") },
                        placeholder = { Text("e.g. A/c 50100234, Demat 12081600, Folio 9021") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("manage_acc_no_name_input")
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        if (editingAccountNumberName != null) {
                            TextButton(
                                onClick = {
                                    editingAccountNumberName = null
                                    accountNumberInputName = ""
                                }
                            ) {
                                Text("Cancel Edit")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                        }

                        Button(
                            onClick = {
                                val trimmed = accountNumberInputName.trim()
                                if (trimmed.isNotBlank()) {
                                    if (editingAccountNumberName != null) {
                                        val oldName = editingAccountNumberName!!
                                        val updated = accountNumbersList.map {
                                            if (it.equals(oldName, ignoreCase = true)) trimmed else it
                                        }
                                        saveAccountNumbersToPrefs(updated)
                                        if (accountNumber.equals(oldName, ignoreCase = true)) {
                                            accountNumber = trimmed
                                        }
                                    } else {
                                        if (!accountNumbersList.any { it.equals(trimmed, ignoreCase = true) }) {
                                            val updated = accountNumbersList + trimmed
                                            saveAccountNumbersToPrefs(updated)
                                        }
                                        accountNumber = trimmed
                                    }

                                    editingAccountNumberName = null
                                    accountNumberInputName = ""
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                            modifier = Modifier.testTag("btn_save_account_no_option")
                        ) {
                            Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(if (editingAccountNumberName == null) "Add Number" else "Update Number")
                        }
                    }

                    HorizontalDivider()

                    Text(
                        text = "Existing Saved Numbers (${accountNumbersList.size})",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        accountNumbersList.forEach { accNum ->
                            val isBeingEdited = editingAccountNumberName?.equals(accNum, ignoreCase = true) == true
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = if (isBeingEdited) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                border = if (isBeingEdited) androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.primary) else null,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = accNum,
                                        fontWeight = FontWeight.Bold,
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.weight(1f)
                                    )

                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        IconButton(
                                            onClick = {
                                                editingAccountNumberName = accNum
                                                accountNumberInputName = accNum
                                            },
                                            modifier = Modifier.size(32.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Edit,
                                                contentDescription = "Edit Account Number",
                                                tint = Color(0xFF60A5FA),
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }

                                        IconButton(
                                            onClick = {
                                                accountNumberToDelete = accNum
                                            },
                                            modifier = Modifier.size(32.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Delete,
                                                contentDescription = "Delete Account Number",
                                                tint = Color(0xFFF87171),
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {},
            dismissButton = {
                TextButton(
                    onClick = {
                        showManageAccountNumbersDialog = false
                        editingAccountNumberName = null
                        accountNumberInputName = ""
                    }
                ) {
                    Text("Close")
                }
            }
        )
    }

    // --- DELETE ACCOUNT NUMBER CONFIRMATION DIALOG ---
    if (accountNumberToDelete != null) {
        val accNum = accountNumberToDelete!!
        AlertDialog(
            onDismissRequest = { accountNumberToDelete = null },
            title = { Text("Delete Account Number?") },
            text = { Text("Are you sure you want to delete '$accNum' from saved numbers?") },
            confirmButton = {
                Button(
                    onClick = {
                        val updated = accountNumbersList.filterNot { it.equals(accNum, ignoreCase = true) }
                        saveAccountNumbersToPrefs(updated)
                        if (accountNumber.equals(accNum, ignoreCase = true)) {
                            accountNumber = updated.firstOrNull() ?: ""
                        }
                        accountNumberToDelete = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = { accountNumberToDelete = null }) {
                    Text("Cancel")
                }
            }
        )
    }
}
