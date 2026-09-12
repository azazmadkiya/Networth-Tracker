package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RemoveCircle
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import com.example.data.model.LedgerEntry
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.data.model.FinancialItem
import com.example.data.model.ItemCategory
import com.example.data.model.OwnerProfile
import com.example.ui.theme.AssetGreen
import com.example.ui.theme.LiabilityRed
import com.example.ui.theme.PrimaryGreen

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun AddEditItemDialog(
    initialItem: FinancialItem? = null,
    preselectedCategory: String? = null,
    parties: List<FinancialItem> = emptyList(),
    onDismiss: () -> Unit,
    onSave: (FinancialItem, com.example.data.model.LedgerEntry?, FinancialItem?) -> Unit
) {
    var title by remember { mutableStateOf(initialItem?.title ?: "") }
    var institution by remember { mutableStateOf(initialItem?.institution ?: "") }
    var accountNumber by remember { mutableStateOf(initialItem?.accountNumber ?: "") }
    var selectedOwner by remember { mutableStateOf(initialItem?.owner ?: OwnerProfile.SELF.displayName) }
    var selectedCategory by remember { 
        mutableStateOf(initialItem?.category ?: preselectedCategory ?: ItemCategory.BANK_ACCOUNT.displayName) 
    }
    var currentValueStr by remember { mutableStateOf(initialItem?.let { String.format("%.0f", it.currentValue) } ?: "") }
    var investedValueStr by remember { mutableStateOf(initialItem?.let { String.format("%.0f", it.investedValue) } ?: "") }
    var isLiability by remember { mutableStateOf(initialItem?.isLiability ?: false) }
    var notes by remember { mutableStateOf(initialItem?.notes ?: "") }
    var oppositeAccountName by remember { mutableStateOf("") }
    var selectedOppositeItem by remember { mutableStateOf<FinancialItem?>(null) }
    var oppositeExpanded by remember { mutableStateOf(false) }
    var accountFilterType by remember { mutableStateOf("Bank") }
    var adjustmentMode by remember { mutableStateOf("RECEIVED_PLUS") }

    // Party Drop-down states for Title / Asset Name
    var partyDropdownExpanded by remember { mutableStateOf(false) }
    var selectedPartyItem by remember { mutableStateOf<FinancialItem?>(null) }
    var partyFilterType by remember { mutableStateOf("Parties") }
    var adjustPartyBalance by remember { mutableStateOf(true) }

    // Stock-specific quantity and purchase price helper states
    var stockQuantityStr by remember { mutableStateOf("") }
    var stockBuyPriceStr by remember { mutableStateOf("") }
    var stockCmpStr by remember { mutableStateOf("") }

    var adjustAmountStr by remember { mutableStateOf("") }

    val isEditing = initialItem != null
    val isInvestmentCategory = selectedCategory.equals(ItemCategory.SHARE_MARKET.displayName, ignoreCase = true) ||
                               selectedCategory.equals(ItemCategory.MUTUAL_FUNDS.displayName, ignoreCase = true) ||
                               selectedCategory.equals(ItemCategory.IPO.displayName, ignoreCase = true)

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val safeDismiss = {
        keyboardController?.hide()
        focusManager.clearFocus()
        onDismiss()
    }

    val partyTabCategories = remember {
        listOf(
            ItemCategory.SUNDRY_CREDITORS.displayName,
            ItemCategory.SUNDRY_DEBTORS.displayName,
            ItemCategory.EXPENSE.displayName,
            ItemCategory.LOAN_LIABILITY.displayName,
            ItemCategory.OTHER_ACCOUNT.displayName,
            "Sundry Creditors",
            "Sundry Debtors",
            "Debtors",
            "Creditors",
            "Client",
            "Vendor",
            "Supplier",
            "Customer",
            "Party"
        )
    }

    // STRICT CHECK: Only parties from the Parties Tab (Excludes Banks, Cash, and Investments)
    val isPartyFromPartiesTab: (FinancialItem) -> Boolean = remember(partyTabCategories) {
        { item ->
            val cat = item.category.trim()
            val isExcluded = cat.equals(ItemCategory.BANK_ACCOUNT.displayName, ignoreCase = true) ||
                             cat.equals(ItemCategory.CASH.displayName, ignoreCase = true) ||
                             cat.contains("Bank", ignoreCase = true) ||
                             cat.contains("Cash", ignoreCase = true) ||
                             cat.equals(ItemCategory.SHARE_MARKET.displayName, ignoreCase = true) ||
                             cat.equals(ItemCategory.MUTUAL_FUNDS.displayName, ignoreCase = true) ||
                             cat.equals(ItemCategory.IPO.displayName, ignoreCase = true) ||
                             cat.equals(ItemCategory.GOLD_SILVER.displayName, ignoreCase = true) ||
                             cat.equals(ItemCategory.REAL_ESTATE.displayName, ignoreCase = true) ||
                             cat.equals(ItemCategory.OTHER_INVESTMENT.displayName, ignoreCase = true) ||
                             cat.equals(ItemCategory.INCOME.displayName, ignoreCase = true)
            
            !isExcluded && (
                partyTabCategories.any { it.equals(cat, ignoreCase = true) } ||
                cat.contains("Debtor", ignoreCase = true) ||
                cat.contains("Creditor", ignoreCase = true) ||
                cat.contains("Party", ignoreCase = true) ||
                cat.contains("Supplier", ignoreCase = true) ||
                cat.contains("Vendor", ignoreCase = true) ||
                cat.contains("Customer", ignoreCase = true) ||
                cat.contains("Client", ignoreCase = true) ||
                item.isLiability
            )
        }
    }

    // STRICT CHECK: Already Added Assets (Bank Accounts, Cash on Hand, Liquid Assets)
    val isAlreadyAddedAsset: (FinancialItem) -> Boolean = remember(partyTabCategories) {
        { item ->
            val cat = item.category.trim()
            !item.isLiability && !isPartyFromPartiesTab(item) && (
                cat.equals(ItemCategory.BANK_ACCOUNT.displayName, ignoreCase = true) ||
                cat.equals(ItemCategory.CASH.displayName, ignoreCase = true) ||
                cat.contains("Bank", ignoreCase = true) ||
                cat.contains("Cash", ignoreCase = true) ||
                cat.equals("Savings Account", ignoreCase = true) ||
                cat.equals("Current Account", ignoreCase = true) ||
                cat.equals("Wallet", ignoreCase = true)
            )
        }
    }

    Dialog(
        onDismissRequest = safeDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            decorFitsSystemWindows = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .imePadding()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 520.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Fixed Header
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 12.dp, top = 16.dp, bottom = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (isInvestmentCategory) {
                                Icon(
                                    imageVector = Icons.Default.ShowChart,
                                    contentDescription = null,
                                    tint = PrimaryGreen,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                            Column {
                                Text(
                                    text = when {
                                        isEditing -> "Edit Financial Item"
                                        isInvestmentCategory -> "Add Investment Entry"
                                        else -> "Add Financial Item"
                                    },
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = if (title.isNotBlank()) "Tap Save below when ready" else "Enter item name to save",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = if (title.isNotBlank()) AssetGreen else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                        IconButton(onClick = safeDismiss) {
                            Icon(Icons.Default.Close, contentDescription = "Close")
                        }
                    }

                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                    // Scrollable Form Body
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f, fill = false)
                            .verticalScroll(rememberScrollState())
                            .padding(horizontal = 20.dp, vertical = 14.dp)
                    ) {

                // Title / Asset Name with Party Drop-down option
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = if (isInvestmentCategory) "Asset / Company / Symbol *" else "Title / Asset Name *",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )
                    val partiesFromTab = remember(parties) { parties.filter { isPartyFromPartiesTab(it) } }
                    if (partiesFromTab.isNotEmpty()) {
                        TextButton(
                            onClick = { partyDropdownExpanded = true },
                            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = PrimaryGreen,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Select Party ▾",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryGreen
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))

                ExposedDropdownMenuBox(
                    expanded = partyDropdownExpanded,
                    onExpandedChange = { partyDropdownExpanded = !partyDropdownExpanded },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = title,
                        onValueChange = { 
                            title = it
                            if (selectedPartyItem != null && !selectedPartyItem!!.title.equals(it, ignoreCase = true)) {
                                selectedPartyItem = null
                            }
                        },
                        placeholder = { 
                            Text(if (isInvestmentCategory) "e.g. Reliance, SBI MF, LIC IPO" else "e.g. HDFC Salary, or tap ▾ for Party") 
                        },
                        trailingIcon = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                if (title.isNotBlank()) {
                                    IconButton(onClick = {
                                        title = ""
                                        selectedPartyItem = null
                                    }) {
                                        Icon(Icons.Default.Clear, contentDescription = "Clear", modifier = Modifier.size(18.dp))
                                    }
                                }
                                val partiesFromTab = parties.filter { isPartyFromPartiesTab(it) }
                                if (partiesFromTab.isNotEmpty()) {
                                    IconButton(onClick = { partyDropdownExpanded = !partyDropdownExpanded }) {
                                        Icon(
                                            imageVector = if (partyDropdownExpanded) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
                                            contentDescription = "Open Party Dropdown",
                                            tint = PrimaryGreen
                                        )
                                    }
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(),
                        shape = RoundedCornerShape(12.dp)
                    )

                    val partiesFromTab = remember(parties) { parties.filter { isPartyFromPartiesTab(it) } }
                    if (partiesFromTab.isNotEmpty()) {
                        ExposedDropdownMenu(
                            expanded = partyDropdownExpanded,
                            onDismissRequest = { partyDropdownExpanded = false }
                        ) {
                            Text(
                                text = "Select Party (Parties Tab Only):",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryGreen,
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp, vertical = 2.dp)
                                    .horizontalScroll(rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                FilterChip(
                                    selected = partyFilterType == "Parties",
                                    onClick = { partyFilterType = "Parties" },
                                    label = { Text("👤 All Parties") }
                                )
                                FilterChip(
                                    selected = partyFilterType == "Debtors",
                                    onClick = { partyFilterType = "Debtors" },
                                    label = { Text("Debtors (Customers)") }
                                )
                                FilterChip(
                                    selected = partyFilterType == "Creditors",
                                    onClick = { partyFilterType = "Creditors" },
                                    label = { Text("Creditors (Suppliers)") }
                                )
                            }
                            HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))

                            val displayParties = partiesFromTab.filter { p ->
                                val matchesType = when (partyFilterType) {
                                    "Debtors" -> p.category.contains("Debtor", ignoreCase = true) || (!p.isLiability && isPartyFromPartiesTab(p))
                                    "Creditors" -> p.category.contains("Creditor", ignoreCase = true) || p.isLiability
                                    else -> true
                                }
                                val matchesQuery = title.isBlank() ||
                                    p.title.contains(title, ignoreCase = true) ||
                                    p.institution.contains(title, ignoreCase = true) ||
                                    p.category.contains(title, ignoreCase = true)
                                matchesType && matchesQuery
                            }

                            if (displayParties.isEmpty()) {
                                DropdownMenuItem(
                                    text = { Text("No matching parties from Parties Tab", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant) },
                                    onClick = { partyDropdownExpanded = false }
                                )
                            } else {
                                displayParties.forEach { p ->
                                    val isDebtor = p.category.contains("Debtor", ignoreCase = true) || (!p.isLiability && isPartyFromPartiesTab(p))
                                    val isCreditor = p.category.contains("Creditor", ignoreCase = true) || p.isLiability
                                    DropdownMenuItem(
                                        leadingIcon = {
                                            Icon(
                                                imageVector = Icons.Default.Person,
                                                contentDescription = null,
                                                tint = if (isCreditor) LiabilityRed else if (isDebtor) AssetGreen else PrimaryGreen,
                                                modifier = Modifier.size(20.dp)
                                            )
                                        },
                                        text = {
                                            Column {
                                                Text(p.title, fontWeight = FontWeight.SemiBold)
                                                Text(
                                                    text = "${p.category} • Balance: ₹${String.format("%,.0f", p.currentValue)}",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                                )
                                            }
                                        },
                                        trailingIcon = {
                                            Surface(
                                                shape = RoundedCornerShape(6.dp),
                                                color = (if (isCreditor) LiabilityRed else AssetGreen).copy(alpha = 0.12f)
                                            ) {
                                                Text(
                                                    text = if (isCreditor) "Creditor" else if (isDebtor) "Debtor" else "Party",
                                                    style = MaterialTheme.typography.labelSmall,
                                                    color = if (isCreditor) LiabilityRed else AssetGreen,
                                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                                )
                                            }
                                        },
                                        onClick = {
                                            title = p.title
                                            selectedPartyItem = p
                                            if (p.institution.isNotBlank()) institution = p.institution
                                            if (p.accountNumber.isNotBlank()) accountNumber = p.accountNumber
                                            selectedCategory = p.category
                                            isLiability = p.isLiability
                                            selectedOwner = p.owner
                                            partyDropdownExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                }

                if (selectedPartyItem != null) {
                    Spacer(modifier = Modifier.height(6.dp))
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = PrimaryGreen.copy(alpha = 0.1f),
                        border = BorderStroke(1.dp, PrimaryGreen.copy(alpha = 0.3f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = PrimaryGreen,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Party: ${selectedPartyItem!!.title} (${selectedPartyItem!!.category}) • Bal: ₹${String.format("%,.0f", selectedPartyItem!!.currentValue)}",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.SemiBold,
                                    color = PrimaryGreen
                                )
                            }
                            IconButton(
                                onClick = { selectedPartyItem = null },
                                modifier = Modifier.size(20.dp)
                            ) {
                                Icon(Icons.Default.Close, contentDescription = "Unlink Party", tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(14.dp))
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Institution & Account / Broker
                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = institution,
                        onValueChange = { institution = it },
                        label = { Text(if (isInvestmentCategory) "Broker / Demat" else "Institution / Broker") },
                        placeholder = { Text(if (isInvestmentCategory) "Zerodha, Groww, Angel One" else "e.g. Zerodha, SBI") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = accountNumber,
                        onValueChange = { accountNumber = it },
                        label = { Text(if (isInvestmentCategory) "Qty / Folio" else "Account / Folio") },
                        placeholder = { Text(if (isInvestmentCategory) "e.g. 50 shares" else "e.g. ••4829") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Stock Quick Auto-Calculator (if Share Market category is selected)
                if (isInvestmentCategory) {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp),
                        color = PrimaryGreen.copy(alpha = 0.08f)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Calculate,
                                    contentDescription = null,
                                    tint = PrimaryGreen,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Investment Calculator (Optional)",
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = PrimaryGreen
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Enter Quantity and Prices to auto-calculate Invested & Current Value",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                OutlinedTextField(
                                    value = stockQuantityStr,
                                    onValueChange = { q ->
                                        stockQuantityStr = q
                                        val qty = q.toDoubleOrNull()
                                        if (qty != null && qty > 0) {
                                            accountNumber = "${q.trim()} shares"
                                            val buy = stockBuyPriceStr.toDoubleOrNull()
                                            if (buy != null && buy > 0) {
                                                investedValueStr = String.format("%.0f", qty * buy)
                                            }
                                            val cmp = stockCmpStr.toDoubleOrNull()
                                            if (cmp != null && cmp > 0) {
                                                currentValueStr = String.format("%.0f", qty * cmp)
                                            }
                                        }
                                    },
                                    label = { Text("Qty") },
                                    placeholder = { Text("50") },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    modifier = Modifier.weight(1f),
                                    shape = RoundedCornerShape(10.dp)
                                )

                                OutlinedTextField(
                                    value = stockBuyPriceStr,
                                    onValueChange = { bp ->
                                        stockBuyPriceStr = bp
                                        val buy = bp.toDoubleOrNull()
                                        val qty = stockQuantityStr.toDoubleOrNull()
                                        if (buy != null && buy > 0 && qty != null && qty > 0) {
                                            investedValueStr = String.format("%.0f", qty * buy)
                                        }
                                    },
                                    label = { Text("Buy Price") },
                                    placeholder = { Text("₹") },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    modifier = Modifier.weight(1.2f),
                                    shape = RoundedCornerShape(10.dp)
                                )

                                OutlinedTextField(
                                    value = stockCmpStr,
                                    onValueChange = { cmp ->
                                        stockCmpStr = cmp
                                        val price = cmp.toDoubleOrNull()
                                        val qty = stockQuantityStr.toDoubleOrNull()
                                        if (price != null && price > 0 && qty != null && qty > 0) {
                                            currentValueStr = String.format("%.0f", qty * price)
                                        }
                                    },
                                    label = { Text("Current CMP") },
                                    placeholder = { Text("₹") },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    modifier = Modifier.weight(1.2f),
                                    shape = RoundedCornerShape(10.dp)
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }

                // Values
                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = currentValueStr,
                        onValueChange = { currentValueStr = it },
                        label = { Text(if (isInvestmentCategory) "Current Total Value (₹) *" else "Current Value (₹) *") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = investedValueStr,
                        onValueChange = { investedValueStr = it },
                        label = { Text(if (isInvestmentCategory) "Total Buy/Invested (₹)" else "Invested Value (₹)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Owner Selection
                Text("Owner Profile", style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    OwnerProfile.entries.forEach { profile ->
                        FilterChip(
                            selected = selectedOwner.equals(profile.displayName, ignoreCase = true),
                            onClick = { selectedOwner = profile.displayName },
                            label = { Text(profile.displayName) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Category Selection
                Text("Category", style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    ItemCategory.entries.forEach { cat ->
                        FilterChip(
                            selected = selectedCategory.equals(cat.displayName, ignoreCase = true),
                            onClick = {
                                selectedCategory = cat.displayName
                                if (cat.isLiability) {
                                    isLiability = true
                                } else if (cat == ItemCategory.SHARE_MARKET) {
                                    isLiability = false
                                }
                            },
                            label = { Text(cat.displayName) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Liability toggle
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Is this a Liability / Debt?",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = if (isLiability) "Deducts from your total Net Worth" else "Adds to your total Assets",
                            style = MaterialTheme.typography.bodySmall,
                            color = if (isLiability) LiabilityRed else AssetGreen
                        )
                    }
                    Switch(
                        checked = isLiability,
                        onCheckedChange = { isLiability = it }
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Notes
                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    label = { Text(if (isInvestmentCategory) "Investment Strategy / Notes" else "Notes / Strategy") },
                    placeholder = { 
                        Text(if (isInvestmentCategory) "e.g. Long-term bluechip, Target ₹3500" else "e.g. Long-term hold, 10k monthly SIP") 
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(20.dp))

                if (parties.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // ERP Header
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountBalance,
                            contentDescription = null,
                            tint = PrimaryGreen,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "Already Added Asset to PLUS (+) / MINUS (-) (Maintain TOTAL NET WORTH)",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryGreen
                            )
                            Text(
                                text = "For Received amounts: select an already added Asset (Bank / Cash) from dropdown to PLUS (+) and maintain your TOTAL NET WORTH accurately.",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(10.dp))

                    // Filter chips for drop-down
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        FilterChip(
                            selected = accountFilterType == "Bank",
                            onClick = { accountFilterType = "Bank" },
                            label = { Text("🏦 Bank & Cash Assets") }
                        )
                        FilterChip(
                            selected = accountFilterType == "AllAssets",
                            onClick = { accountFilterType = "AllAssets" },
                            label = { Text("💼 All Added Assets") }
                        )
                        FilterChip(
                            selected = accountFilterType == "Party",
                            onClick = { accountFilterType = "Party" },
                            label = { Text("👤 Parties Tab") }
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    val filteredOpposite = parties.filter { p ->
                        val matchesSearch = oppositeAccountName.isBlank() ||
                                            p.title.contains(oppositeAccountName, ignoreCase = true) ||
                                            p.institution.contains(oppositeAccountName, ignoreCase = true) ||
                                            p.category.contains(oppositeAccountName, ignoreCase = true)
                        val matchesType = when (accountFilterType) {
                            "Bank" -> isAlreadyAddedAsset(p)
                            "Party" -> isPartyFromPartiesTab(p)
                            "AllAssets" -> !p.isLiability
                            else -> true
                        }
                        matchesSearch && matchesType
                    }

                    ExposedDropdownMenuBox(
                        expanded = oppositeExpanded,
                        onExpandedChange = { oppositeExpanded = !oppositeExpanded },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = if (selectedOppositeItem != null) selectedOppositeItem!!.title else oppositeAccountName,
                            onValueChange = { 
                                oppositeAccountName = it
                                selectedOppositeItem = parties.find { p -> p.title.equals(it, ignoreCase = true) }
                            },
                            label = { 
                                Text(
                                    if (adjustmentMode == "RECEIVED_PLUS") 
                                        "Deposit / Received Into Already Added Asset (PLUS +) *" 
                                    else 
                                        "Withdraw / Paid From Already Added Asset (MINUS -) *"
                                ) 
                            },
                            placeholder = { 
                                Text(
                                    if (adjustmentMode == "RECEIVED_PLUS") 
                                        "Choose Bank Account, Cash on Hand to PLUS (+)..." 
                                    else 
                                        "Choose Bank Account, Cash on Hand to MINUS (-)..."
                                ) 
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor(),
                            trailingIcon = {
                                if (selectedOppositeItem != null || oppositeAccountName.isNotBlank()) {
                                    IconButton(onClick = {
                                        selectedOppositeItem = null
                                        oppositeAccountName = ""
                                    }) {
                                        Icon(Icons.Default.Clear, contentDescription = "Clear selection", modifier = Modifier.size(18.dp))
                                    }
                                } else {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = oppositeExpanded)
                                }
                            },
                            shape = RoundedCornerShape(12.dp)
                        )
                        
                        if (filteredOpposite.isNotEmpty()) {
                            ExposedDropdownMenu(
                                expanded = oppositeExpanded,
                                onDismissRequest = { oppositeExpanded = false }
                            ) {
                                filteredOpposite.forEach { p ->
                                    val isBank = isAlreadyAddedAsset(p)
                                    val isPart = isPartyFromPartiesTab(p)
                                    DropdownMenuItem(
                                        leadingIcon = {
                                            Icon(
                                                imageVector = if (isBank) Icons.Default.AccountBalance else if (isPart) Icons.Default.Person else Icons.Default.ShowChart,
                                                contentDescription = null,
                                                tint = if (isBank) AssetGreen else if (p.isLiability) LiabilityRed else PrimaryGreen,
                                                modifier = Modifier.size(20.dp)
                                            )
                                        },
                                        text = { 
                                            Column {
                                                Text(p.title, fontWeight = FontWeight.SemiBold)
                                                Text(
                                                    text = "${p.category} • Balance: ₹${String.format("%,.0f", p.currentValue)}",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                                )
                                            }
                                        },
                                        trailingIcon = {
                                            Surface(
                                                shape = RoundedCornerShape(6.dp),
                                                color = (if (isBank) AssetGreen else if (p.isLiability) LiabilityRed else PrimaryGreen).copy(alpha = 0.12f)
                                            ) {
                                                Text(
                                                    text = if (isBank) "Asset" else if (p.isLiability) "Liability" else "Party",
                                                    style = MaterialTheme.typography.labelSmall,
                                                    color = if (isBank) AssetGreen else if (p.isLiability) LiabilityRed else PrimaryGreen,
                                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                                )
                                            }
                                        },
                                        onClick = {
                                            selectedOppositeItem = p
                                            oppositeAccountName = p.title
                                            oppositeExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    // Card when an account/party is selected
                    val activeOpposite = selectedOppositeItem ?: parties.find { it.title.equals(oppositeAccountName, ignoreCase = true) }
                    if (activeOpposite != null) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f)
                            ),
                            border = BorderStroke(1.dp, PrimaryGreen.copy(alpha = 0.3f))
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                                        Icon(
                                            imageVector = if (isAlreadyAddedAsset(activeOpposite)) Icons.Default.AccountBalance else Icons.Default.Person,
                                            contentDescription = null,
                                            tint = PrimaryGreen,
                                            modifier = Modifier.size(18.dp)
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = "Selected: ${activeOpposite.title}",
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    Text(
                                        text = "Bal: ₹${String.format("%,.0f", activeOpposite.currentValue)}",
                                        style = MaterialTheme.typography.bodySmall,
                                        fontWeight = FontWeight.SemiBold,
                                        color = if (activeOpposite.isLiability) LiabilityRed else AssetGreen
                                    )
                                }

                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = "Choose Balance Effect on ${activeOpposite.title}:",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.height(6.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    // Option 1: RECEIVED_PLUS
                                    Surface(
                                        modifier = Modifier
                                            .weight(1f)
                                            .clickable { adjustmentMode = "RECEIVED_PLUS" },
                                        shape = RoundedCornerShape(10.dp),
                                        color = if (adjustmentMode == "RECEIVED_PLUS") AssetGreen.copy(alpha = 0.15f) else MaterialTheme.colorScheme.surface,
                                        border = BorderStroke(
                                            width = if (adjustmentMode == "RECEIVED_PLUS") 1.5.dp else 1.dp,
                                            color = if (adjustmentMode == "RECEIVED_PLUS") AssetGreen else MaterialTheme.colorScheme.outlineVariant
                                        )
                                    ) {
                                        Column(modifier = Modifier.padding(8.dp)) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Icon(
                                                    Icons.Default.AddCircle,
                                                    contentDescription = null,
                                                    tint = if (adjustmentMode == "RECEIVED_PLUS") AssetGreen else MaterialTheme.colorScheme.onSurfaceVariant,
                                                    modifier = Modifier.size(16.dp)
                                                )
                                                Spacer(modifier = Modifier.width(4.dp))
                                                Text(
                                                    text = "Received (PLUS +)",
                                                    style = MaterialTheme.typography.labelMedium,
                                                    fontWeight = FontWeight.Bold,
                                                    color = if (adjustmentMode == "RECEIVED_PLUS") AssetGreen else MaterialTheme.colorScheme.onSurface
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(2.dp))
                                            Text(
                                                text = "Adds (+) to Asset",
                                                style = MaterialTheme.typography.labelSmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                    }

                                    // Option 2: FUNDED_MINUS
                                    Surface(
                                        modifier = Modifier
                                            .weight(1f)
                                            .clickable { adjustmentMode = "FUNDED_MINUS" },
                                        shape = RoundedCornerShape(10.dp),
                                        color = if (adjustmentMode == "FUNDED_MINUS") LiabilityRed.copy(alpha = 0.15f) else MaterialTheme.colorScheme.surface,
                                        border = BorderStroke(
                                            width = if (adjustmentMode == "FUNDED_MINUS") 1.5.dp else 1.dp,
                                            color = if (adjustmentMode == "FUNDED_MINUS") LiabilityRed else MaterialTheme.colorScheme.outlineVariant
                                        )
                                    ) {
                                        Column(modifier = Modifier.padding(8.dp)) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Icon(
                                                    Icons.Default.RemoveCircle,
                                                    contentDescription = null,
                                                    tint = if (adjustmentMode == "FUNDED_MINUS") LiabilityRed else MaterialTheme.colorScheme.onSurfaceVariant,
                                                    modifier = Modifier.size(16.dp)
                                                )
                                                Spacer(modifier = Modifier.width(4.dp))
                                                Text(
                                                    text = "Funded (MINUS -)",
                                                    style = MaterialTheme.typography.labelMedium,
                                                    fontWeight = FontWeight.Bold,
                                                    color = if (adjustmentMode == "FUNDED_MINUS") LiabilityRed else MaterialTheme.colorScheme.onSurface
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(2.dp))
                                            Text(
                                                text = "Deducts (-) from Account",
                                                style = MaterialTheme.typography.labelSmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                val cVal = currentValueStr.toDoubleOrNull() ?: 0.0
                                val isPlus = adjustmentMode == "RECEIVED_PLUS"
                                val newCalcBal = if (isPlus) activeOpposite.currentValue + cVal else activeOpposite.currentValue - cVal

                                Surface(
                                    modifier = Modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(8.dp),
                                    color = if (isPlus) AssetGreen.copy(alpha = 0.08f) else MaterialTheme.colorScheme.surface
                                ) {
                                    Column(modifier = Modifier.padding(8.dp)) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(
                                                text = "New ${activeOpposite.title} Balance:",
                                                style = MaterialTheme.typography.bodySmall
                                            )
                                            Text(
                                                text = "₹${String.format("%,.0f", newCalcBal)} (${if (isPlus) "+₹" else "-₹"}${String.format("%,.0f", cVal)})",
                                                style = MaterialTheme.typography.bodySmall,
                                                fontWeight = FontWeight.Bold,
                                                color = if (isPlus) AssetGreen else LiabilityRed
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(2.dp))
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(
                                                text = "Total Net Worth Impact:",
                                                style = MaterialTheme.typography.labelSmall,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                            Text(
                                                text = if (isPlus) "+₹${String.format("%,.0f", cVal)} (Maintained & Increased)" else "₹0 (Asset Exchange / Balanced)",
                                                style = MaterialTheme.typography.labelSmall,
                                                fontWeight = FontWeight.Bold,
                                                color = if (isPlus) AssetGreen else PrimaryGreen
                                            )
                                        }
                                    }
                                }

                                if (selectedPartyItem != null) {
                                    Spacer(modifier = Modifier.height(8.dp))
                                    val isPartyDebtor = selectedPartyItem!!.category.contains("Debtor", ignoreCase = true) || (!selectedPartyItem!!.isLiability && isPartyFromPartiesTab(selectedPartyItem!!))
                                    val isPartyCreditor = selectedPartyItem!!.category.contains("Creditor", ignoreCase = true) || selectedPartyItem!!.isLiability
                                    val newPartyBal = if (isPlus && isPartyDebtor) {
                                        maxOf(0.0, selectedPartyItem!!.currentValue - cVal)
                                    } else if (adjustmentMode == "FUNDED_MINUS" && isPartyCreditor) {
                                        maxOf(0.0, selectedPartyItem!!.currentValue - cVal)
                                    } else {
                                        selectedPartyItem!!.currentValue
                                    }

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable { adjustPartyBalance = !adjustPartyBalance },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Checkbox(
                                            checked = adjustPartyBalance,
                                            onCheckedChange = { adjustPartyBalance = it },
                                            colors = CheckboxDefaults.colors(checkedColor = PrimaryGreen)
                                        )
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = "Adjust Party ${selectedPartyItem!!.title} balance",
                                                style = MaterialTheme.typography.bodySmall,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                            Text(
                                                text = if (isPartyDebtor && isPlus)
                                                    "Debtor receipt: Party balance reduces ₹${String.format("%,.0f", selectedPartyItem!!.currentValue)} ➔ ₹${String.format("%,.0f", newPartyBal)}"
                                                else if (isPartyCreditor && adjustmentMode == "FUNDED_MINUS")
                                                    "Creditor payment: Due balance reduces ₹${String.format("%,.0f", selectedPartyItem!!.currentValue)} ➔ ₹${String.format("%,.0f", newPartyBal)}"
                                                else
                                                    "Keeps Party balance synchronized with transaction",
                                                style = MaterialTheme.typography.labelSmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                

                    }

                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                    // Fixed Action Buttons Footer (Always visible)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(onClick = safeDismiss) {
                            Text("Cancel")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            onClick = {
                                keyboardController?.hide()
                                focusManager.clearFocus()
                                val cVal = currentValueStr.toDoubleOrNull() ?: 0.0
                                val iVal = investedValueStr.toDoubleOrNull() ?: cVal
                                if (title.isNotBlank() && cVal >= 0) {
                                    var ledgerEntry: com.example.data.model.LedgerEntry? = null
                                    var updatedParty: FinancialItem? = null
                                    
                                    val oppAccount = selectedOppositeItem ?: parties.find { it.title.equals(oppositeAccountName, ignoreCase = true) }
                                    if (oppAccount != null && cVal > 0 && adjustmentMode != "NONE") {
                                        val isPlus = adjustmentMode == "RECEIVED_PLUS"
                                        val newOppBal = if (isPlus) {
                                            oppAccount.currentValue + cVal // PLUS to already added asset to maintain TOTAL NET WORTH!
                                        } else {
                                            maxOf(0.0, oppAccount.currentValue - cVal) // MINUS from funding account
                                        }
                                        
                                        updatedParty = oppAccount.copy(currentValue = newOppBal, updatedAt = System.currentTimeMillis())
                                        
                                        ledgerEntry = com.example.data.model.LedgerEntry(
                                            transactionTitle = if (isPlus) "Received: ${title.trim()} into ${oppAccount.title}" else "Funded: ${title.trim()} from ${oppAccount.title}",
                                            accountName = if (isPlus) oppAccount.title else title.trim(),
                                            oppositeAccountName = if (isPlus) title.trim() else oppAccount.title,
                                            entryType = if (isPlus) "CREDIT" else "DEBIT",
                                            debitAmount = if (!isPlus) cVal else 0.0,
                                            creditAmount = if (isPlus) cVal else 0.0,
                                            category = if (isPlus) "Received Inflow" else "Funding",
                                            timestamp = System.currentTimeMillis()
                                        )
                                    }

                                    val itemToSave: FinancialItem = if (selectedPartyItem != null && adjustPartyBalance && initialItem == null) {
                                        val isDebtor = selectedPartyItem!!.category.contains("Debtor", ignoreCase = true) || (!selectedPartyItem!!.isLiability && isPartyFromPartiesTab(selectedPartyItem!!))
                                        val isCreditor = selectedPartyItem!!.category.contains("Creditor", ignoreCase = true) || selectedPartyItem!!.isLiability
                                        val newPartyBal = if (adjustmentMode == "RECEIVED_PLUS" && isDebtor) {
                                            maxOf(0.0, selectedPartyItem!!.currentValue - cVal)
                                        } else if (adjustmentMode == "FUNDED_MINUS" && isCreditor) {
                                            maxOf(0.0, selectedPartyItem!!.currentValue - cVal)
                                        } else if (adjustmentMode == "RECEIVED_PLUS" && isCreditor) {
                                            selectedPartyItem!!.currentValue + cVal
                                        } else if (adjustmentMode == "FUNDED_MINUS" && isDebtor) {
                                            selectedPartyItem!!.currentValue + cVal
                                        } else {
                                            selectedPartyItem!!.currentValue
                                        }
                                        selectedPartyItem!!.copy(
                                            currentValue = newPartyBal,
                                            notes = if (notes.isNotBlank()) notes.trim() else selectedPartyItem!!.notes,
                                            updatedAt = System.currentTimeMillis()
                                        )
                                    } else {
                                        FinancialItem(
                                            id = initialItem?.id ?: 0L,
                                            title = title.trim(),
                                            institution = institution.trim(),
                                            accountNumber = accountNumber.trim(),
                                            owner = selectedOwner,
                                            category = selectedCategory,
                                            currentValue = cVal,
                                            investedValue = iVal,
                                            isLiability = isLiability,
                                            notes = notes.trim(),
                                            updatedAt = System.currentTimeMillis()
                                        )
                                    }

                                    onSave(itemToSave, ledgerEntry, updatedParty)
                                }
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isLiability) LiabilityRed else PrimaryGreen
                            ),
                            enabled = title.isNotBlank()
                        ) {
                            Text(if (isEditing) "Update Item" else if (isInvestmentCategory) "Save Investment" else "Save Item")
                        }
                    }
                }
            }
        }
    }
}
