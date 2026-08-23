package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Checkbox
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.model.FinancialItem
import com.example.data.model.ItemCategory
import com.example.data.model.LedgerEntry
import com.example.ui.viewmodel.NetWorthViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun LedgerScreen(
    viewModel: NetWorthViewModel,
    onAddNewExpense: () -> Unit
) {
    val ledgerEntries by viewModel.allLedgerEntries.collectAsStateWithLifecycle()
    val allItems by viewModel.allItems.collectAsStateWithLifecycle()

    var selectedAccountFilter by remember { mutableStateOf("All Accounts") }

    var entryToDelete by remember { mutableStateOf<LedgerEntry?>(null) }
    var showDirectLedgerDialog by remember { mutableStateOf(false) }
    var showManageAccountsDialog by remember { mutableStateOf(false) }
    var adjustBalanceOnLedgerDelete by remember { mutableStateOf(true) }

    var accountToDelete by remember { mutableStateOf<FinancialItem?>(null) }

    val accountNames = remember(allItems) {
        val names = mutableListOf("All Accounts")
        names.addAll(allItems.map { it.title }.distinct())
        names
    }

    val filteredEntries = remember(ledgerEntries, selectedAccountFilter) {
        if (selectedAccountFilter == "All Accounts") {
            ledgerEntries
        } else {
            ledgerEntries.filter {
                it.accountName.equals(selectedAccountFilter, ignoreCase = true) ||
                        it.oppositeAccountName.equals(selectedAccountFilter, ignoreCase = true)
            }
        }
    }

    val totalDebits = remember(filteredEntries) {
        filteredEntries.sumOf { it.debitAmount }
    }

    val totalCredits = remember(filteredEntries) {
        filteredEntries.sumOf { it.creditAmount }
    }

    val dateFormatter = remember { SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // --- Header Section ---
        val context = LocalContext.current
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.ReceiptLong,
                            contentDescription = "Accounting Ledger",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Accounting Ledger",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Text(
                        text = "Double-Entry Statements (DR/CR) & Accounts",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(
                    onClick = {
                        viewModel.refreshAndRecalculateAll()
                        Toast.makeText(context, "🔄 Refreshed & Recalculated Ledger", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.testTag("ledger_refresh_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Re Fresh Ledger",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = { showManageAccountsDialog = true },
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
                    modifier = Modifier
                        .weight(1f)
                        .testTag("btn_manage_accounts")
                ) {
                    Icon(
                        imageVector = Icons.Default.Tune,
                        contentDescription = "Manage Accounts",
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Accounts", fontSize = 11.sp, fontWeight = FontWeight.Bold, maxLines = 1)
                }

                OutlinedButton(
                    onClick = { showDirectLedgerDialog = true },
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
                    modifier = Modifier
                        .weight(1f)
                        .testTag("btn_direct_ledger_posting")
                ) {
                    Icon(
                        imageVector = Icons.Default.SwapHoriz,
                        contentDescription = "Record DR/CR",
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("DR/CR Post", fontSize = 11.sp, fontWeight = FontWeight.Bold, maxLines = 1)
                }

                Button(
                    onClick = onAddNewExpense,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF7C3AED)
                    ),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
                    modifier = Modifier
                        .weight(1f)
                        .testTag("btn_add_expense_ledger")
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Entry",
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Entry", fontSize = 11.sp, fontWeight = FontWeight.Bold, maxLines = 1)
                }
            }
        }

        // --- Active Accounts Carousel Section ---
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Active Accounts (${allItems.size})",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "+ Add / Manage",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { showManageAccountsDialog = true }
                    )
                }

                if (selectedAccountFilter != "All Accounts") {
                    Text(
                        text = "Reset Filter",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { selectedAccountFilter = "All Accounts" }
                    )
                }
            }
            Spacer(modifier = Modifier.height(6.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 2.dp)
            ) {
                item {
                    FilterChip(
                        selected = selectedAccountFilter == "All Accounts",
                        onClick = { selectedAccountFilter = "All Accounts" },
                        label = { Text("All Accounts", fontWeight = FontWeight.Bold) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primary,
                            selectedLabelColor = Color.White
                        )
                    )
                }

                items(allItems, key = { it.id }) { acc ->
                    val isSelected = selectedAccountFilter.equals(acc.title, ignoreCase = true)
                    FilterChip(
                        selected = isSelected,
                        onClick = { selectedAccountFilter = acc.title },
                        label = {
                            Text(
                                text = "${acc.title} • ₹${String.format(Locale.US, "%,.0f", acc.currentValue)}",
                                fontWeight = FontWeight.SemiBold
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = when {
                                    acc.isLiability -> Icons.Default.CreditCard
                                    acc.category.contains("Expense", ignoreCase = true) -> Icons.Default.ShoppingCart
                                    acc.category.contains("Cash", ignoreCase = true) -> Icons.Default.Payments
                                    else -> Icons.Default.AccountBalance
                                },
                                contentDescription = null,
                                modifier = Modifier.size(14.dp)
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = if (acc.isLiability) Color(0xFFDC2626) else if (acc.category.contains("Expense", true)) Color(0xFF7C3AED) else Color(0xFF059669),
                            selectedLabelColor = Color.White,
                            selectedLeadingIconColor = Color.White
                        )
                    )
                }
            }
        }

        // --- KPI Summary Cards ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Debit (DR) Total Card
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF7C3AED).copy(alpha = 0.12f)
                ),
                modifier = Modifier.weight(1f)
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "TOTAL DEBITS (DR)",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF7C3AED)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "₹${String.format(Locale.US, "%,.2f", totalDebits)}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF6D28D9)
                    )
                }
            }

            // Credit (CR) Total Card
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF059669).copy(alpha = 0.12f)
                ),
                modifier = Modifier.weight(1f)
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "TOTAL CREDITS (CR)",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF059669)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "₹${String.format(Locale.US, "%,.2f", totalCredits)}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF047857)
                    )
                }
            }
        }

        // --- Ledger Statement Table / List ---
        if (filteredEntries.isEmpty()) {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerLow
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ReceiptLong,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp),
                        tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "No Ledger Entries for $selectedAccountFilter",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Record an expense, transfer, or financial entry to track double-entry DR and CR statements.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedButton(
                            onClick = { showManageAccountsDialog = true },
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Icon(Icons.Default.Tune, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Add Accounts")
                        }

                        Button(
                            onClick = onAddNewExpense,
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED))
                        ) {
                            Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Record Entry")
                        }
                    }
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(filteredEntries, key = { it.id }) { entry ->
                    val isDebit = entry.entryType.equals("DR", ignoreCase = true)
                    val formattedDate = try {
                        dateFormatter.format(Date(entry.timestamp))
                    } catch (e: Exception) {
                        ""
                    }

                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("ledger_entry_card_${entry.id}")
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            // Top Row: Date, DR/CR Badge, Delete Action
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = formattedDate,
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        color = if (isDebit) Color(0xFF7C3AED) else Color(0xFF059669)
                                    ) {
                                        Text(
                                            text = if (isDebit) "DEBIT (DR)" else "CREDIT (CR)",
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }

                                    IconButton(
                                        onClick = { entryToDelete = entry },
                                        modifier = Modifier.size(26.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = "Delete Entry",
                                            tint = MaterialTheme.colorScheme.error,
                                            modifier = Modifier.size(15.dp)
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(4.dp))

                            // Main Details Row: Title & Amount
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = entry.transactionTitle,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "Account: ${entry.accountName}",
                                        style = MaterialTheme.typography.bodySmall,
                                        fontWeight = FontWeight.SemiBold,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    if (entry.oppositeAccountName.isNotBlank()) {
                                        Text(
                                            text = "Opposite Account: ${entry.oppositeAccountName}",
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }

                                Column(horizontalAlignment = Alignment.End) {
                                    val amountStr = if (isDebit) entry.debitAmount else entry.creditAmount
                                    Text(
                                        text = "${if (isDebit) "+" else "-"}₹${String.format(Locale.US, "%,.2f", amountStr)}",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = if (isDebit) Color(0xFF7C3AED) else Color(0xFF059669)
                                    )
                                    if (entry.runningBalance > 0) {
                                        Text(
                                            text = "Bal: ₹${String.format(Locale.US, "%,.0f", entry.runningBalance)}",
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }
                            }

                            if (entry.notes.isNotBlank()) {
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = "Note: ${entry.notes}",
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

    // --- Manage Accounts Dialog (Add, Edit, Delete Accounts) ---
    if (showManageAccountsDialog) {
        var editingAccount by remember { mutableStateOf<FinancialItem?>(null) }

        var accTitle by remember { mutableStateOf("") }
        var accCategory by remember { mutableStateOf("Expense / Outflow") }
        var accValueStr by remember { mutableStateOf("") }
        var accOwner by remember { mutableStateOf("Self") }
        var accNotes by remember { mutableStateOf("") }

        var categoryDropdownExpanded by remember { mutableStateOf(false) }
        var ownerDropdownExpanded by remember { mutableStateOf(false) }

        val categories = listOf(
            "Expense / Outflow",
            "Bank Account",
            "Cash on Hand",
            "Loans & Dues",
            "Share Market / Stocks",
            "Mutual Funds",
            "Gold & Silver",
            "Real Estate / Land",
            "Other Investments (PF/FD/PPF)"
        )

        val owners = listOf("Self", "Father", "Mother", "Family Joint")

        // Quick Presets
        val presets = listOf(
            Pair("PETROL", "Expense / Outflow"),
            Pair("Salary", "Bank Account"),
            Pair("Electric Bill", "Expense / Outflow"),
            Pair("House Rent", "Expense / Outflow"),
            Pair("Grocery", "Expense / Outflow"),
            Pair("Mobile & WiFi Bill", "Expense / Outflow"),
            Pair("Medical Expense", "Expense / Outflow"),
            Pair("School Fees", "Expense / Outflow"),
            Pair("HDFC Savings Account", "Bank Account"),
            Pair("Cash on Hand", "Cash on Hand")
        )

        AlertDialog(
            onDismissRequest = { showManageAccountsDialog = false },
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Tune, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Manage Accounts & Headings", fontWeight = FontWeight.Bold)
                    }
                    IconButton(onClick = { showManageAccountsDialog = false }) {
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
                    // Quick Preset Chips
                    Text(
                        text = "Quick Presets (Click to Auto-fill):",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        items(presets) { preset ->
                            FilterChip(
                                selected = accTitle.equals(preset.first, ignoreCase = true),
                                onClick = {
                                    accTitle = preset.first
                                    accCategory = preset.second
                                },
                                label = { Text(preset.first, fontSize = 11.sp) }
                            )
                        }
                    }

                    HorizontalDivider()

                    // Add / Edit Account Form
                    Text(
                        text = if (editingAccount == null) "➕ Add New Account" else "✏️ Edit Account: ${editingAccount?.title}",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    OutlinedTextField(
                        value = accTitle,
                        onValueChange = { accTitle = it },
                        label = { Text("Account / Heading Name *") },
                        placeholder = { Text("e.g. PETROL, Salary, Electric Bill, HDFC Bank") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("manage_acc_title_input")
                    )

                    // Category Dropdown
                    Column {
                        Text("Category / Type", style = MaterialTheme.typography.labelMedium)
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { categoryDropdownExpanded = true }
                                .padding(12.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(accCategory, fontWeight = FontWeight.Bold)
                                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                            }
                        }
                        DropdownMenu(
                            expanded = categoryDropdownExpanded,
                            onDismissRequest = { categoryDropdownExpanded = false }
                        ) {
                            categories.forEach { cat ->
                                DropdownMenuItem(
                                    text = { Text(cat) },
                                    onClick = {
                                        accCategory = cat
                                        categoryDropdownExpanded = false
                                    }
                                )
                            }
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Opening / Current Balance
                        OutlinedTextField(
                            value = accValueStr,
                            onValueChange = { accValueStr = it },
                            label = { Text("Opening Balance (₹)") },
                            placeholder = { Text("0") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            modifier = Modifier.weight(1f).testTag("manage_acc_balance_input")
                        )

                        // Owner Dropdown
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Owner Profile", style = MaterialTheme.typography.labelMedium)
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { ownerDropdownExpanded = true }
                                    .padding(12.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(accOwner, fontWeight = FontWeight.Bold)
                                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                                }
                            }
                            DropdownMenu(
                                expanded = ownerDropdownExpanded,
                                onDismissRequest = { ownerDropdownExpanded = false }
                            ) {
                                owners.forEach { o ->
                                    DropdownMenuItem(
                                        text = { Text(o) },
                                        onClick = {
                                            accOwner = o
                                            ownerDropdownExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    OutlinedTextField(
                        value = accNotes,
                        onValueChange = { accNotes = it },
                        label = { Text("Description / Notes") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        if (editingAccount != null) {
                            TextButton(
                                onClick = {
                                    editingAccount = null
                                    accTitle = ""
                                    accValueStr = ""
                                    accNotes = ""
                                }
                            ) {
                                Text("Cancel Edit")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                        }

                        Button(
                            onClick = {
                                if (accTitle.isNotBlank()) {
                                    val valDouble = accValueStr.toDoubleOrNull() ?: 0.0
                                    val isLiab = accCategory.contains("Loans", ignoreCase = true) || accCategory.contains("Expense", ignoreCase = true)

                                    val itemToSave = if (editingAccount != null) {
                                        editingAccount!!.copy(
                                            title = accTitle.trim(),
                                            category = accCategory,
                                            currentValue = valDouble,
                                            owner = accOwner,
                                            isLiability = isLiab,
                                            notes = accNotes,
                                            updatedAt = System.currentTimeMillis()
                                        )
                                    } else {
                                        FinancialItem(
                                            title = accTitle.trim(),
                                            category = accCategory,
                                            currentValue = valDouble,
                                            owner = accOwner,
                                            isLiability = isLiab,
                                            notes = accNotes,
                                            updatedAt = System.currentTimeMillis()
                                        )
                                    }

                                    viewModel.saveFinancialItem(itemToSave)

                                    // Reset form
                                    editingAccount = null
                                    accTitle = ""
                                    accValueStr = ""
                                    accNotes = ""
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED)),
                            modifier = Modifier.testTag("btn_save_account")
                        ) {
                            Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(if (editingAccount == null) "Add Account" else "Update Account")
                        }
                    }

                    HorizontalDivider()

                    // Existing Accounts List Section
                    Text(
                        text = "Existing Active Accounts (${allItems.size})",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )

                    if (allItems.isEmpty()) {
                        Text(
                            text = "No accounts created yet.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    } else {
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            allItems.forEach { acc ->
                                val isBeingEdited = editingAccount?.id == acc.id
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
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = acc.title,
                                                fontWeight = FontWeight.Bold,
                                                style = MaterialTheme.typography.bodyMedium
                                            )
                                            Text(
                                                text = "${acc.category} • ${acc.owner} • Bal: ₹${String.format(Locale.US, "%,.0f", acc.currentValue)}",
                                                style = MaterialTheme.typography.labelSmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }

                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            IconButton(
                                                onClick = {
                                                    editingAccount = acc
                                                    accTitle = acc.title
                                                    accCategory = acc.category
                                                    accValueStr = if (acc.currentValue > 0) acc.currentValue.toString() else ""
                                                    accOwner = acc.owner
                                                    accNotes = acc.notes
                                                },
                                                modifier = Modifier.size(32.dp)
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Default.Edit,
                                                    contentDescription = "Edit Account",
                                                    tint = Color(0xFF60A5FA),
                                                    modifier = Modifier.size(18.dp)
                                                )
                                            }

                                            IconButton(
                                                onClick = { accountToDelete = acc },
                                                modifier = Modifier.size(32.dp)
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Default.Delete,
                                                    contentDescription = "Delete Account",
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
                }
            },
            confirmButton = {},
            dismissButton = {}
        )
    }

    // --- Direct Double-Entry Posting Dialog ---
    if (showDirectLedgerDialog) {
        var txTitle by remember { mutableStateOf("Transfer / Deposit") }
        var primaryAccount by remember { mutableStateOf(accountNames.getOrElse(1) { "HDFC Savings Account" }) }
        var secondaryAccount by remember { mutableStateOf("Cash Account") }
        var amountStr by remember { mutableStateOf("") }
        var isDebitPrimary by remember { mutableStateOf(true) } // DR Primary
        var notesStr by remember { mutableStateOf("") }

        var primaryDropdownExpanded by remember { mutableStateOf(false) }

        AlertDialog(
            onDismissRequest = { showDirectLedgerDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.SwapHoriz, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Direct DR/CR Ledger Posting", fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedTextField(
                        value = txTitle,
                        onValueChange = { txTitle = it },
                        label = { Text("Transaction Particulars") },
                        placeholder = { Text("e.g. Salary Credit, Bank Transfer") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Primary Account Selector
                    Column {
                        Text("Primary Account", style = MaterialTheme.typography.labelMedium)
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { primaryDropdownExpanded = true }
                                .padding(12.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(primaryAccount, fontWeight = FontWeight.Bold)
                                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                            }
                        }
                        DropdownMenu(
                            expanded = primaryDropdownExpanded,
                            onDismissRequest = { primaryDropdownExpanded = false }
                        ) {
                            allItems.forEach { item ->
                                DropdownMenuItem(
                                    text = { Text(item.title) },
                                    onClick = {
                                        primaryAccount = item.title
                                        primaryDropdownExpanded = false
                                    }
                                )
                            }
                        }
                    }

                    // Secondary Account Input
                    OutlinedTextField(
                        value = secondaryAccount,
                        onValueChange = { secondaryAccount = it },
                        label = { Text("Secondary / Opposite Account") },
                        placeholder = { Text("e.g. Cash, Income, Vendor") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Entry Type (DR vs CR)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        FilterChip(
                            selected = isDebitPrimary,
                            onClick = { isDebitPrimary = true },
                            label = { Text("DEBIT (DR)", fontWeight = FontWeight.Bold) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Color(0xFF7C3AED),
                                selectedLabelColor = Color.White
                            ),
                            modifier = Modifier.weight(1f)
                        )

                        FilterChip(
                            selected = !isDebitPrimary,
                            onClick = { isDebitPrimary = false },
                            label = { Text("CREDIT (CR)", fontWeight = FontWeight.Bold) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Color(0xFF059669),
                                selectedLabelColor = Color.White
                            ),
                            modifier = Modifier.weight(1f)
                        )
                    }

                    // Amount
                    OutlinedTextField(
                        value = amountStr,
                        onValueChange = { amountStr = it },
                        label = { Text("Amount (₹) *") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Notes
                    OutlinedTextField(
                        value = notesStr,
                        onValueChange = { notesStr = it },
                        label = { Text("Notes / Memo") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val amt = amountStr.toDoubleOrNull() ?: 0.0
                        if (txTitle.isNotBlank() && primaryAccount.isNotBlank() && amt > 0) {
                            viewModel.postDirectLedgerEntry(
                                title = txTitle,
                                primaryAccount = primaryAccount,
                                secondaryAccount = secondaryAccount,
                                amount = amt,
                                isDebitPrimary = isDebitPrimary,
                                category = "Ledger Adjustment",
                                notes = notesStr
                            )
                            showDirectLedgerDialog = false
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED))
                ) {
                    Text("Post Entry")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDirectLedgerDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // --- Delete Entry Confirmation Dialog ---
    if (entryToDelete != null) {
        val target = entryToDelete!!
        val isDR = target.entryType.equals("DR", ignoreCase = true)
        val amount = if (isDR) target.debitAmount else target.creditAmount

        AlertDialog(
            onDismissRequest = { entryToDelete = null },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Delete, contentDescription = null, tint = Color(0xFFEF4444))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Delete Ledger Entry?")
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text("Are you sure you want to delete '${target.transactionTitle}' (${target.entryType} ₹${String.format(Locale.US, "%,.2f", amount)}) from the ledger?")

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFFEFF6FF),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFBFDBFE)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = "⚡ Account Balance Auto-Adjustment",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = Color(0xFF1E40AF)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Deleting this entry will automatically revert the ${target.entryType} amount (₹${String.format(Locale.US, "%,.2f", amount)}) on '${target.accountName}'.",
                                fontSize = 12.sp,
                                color = Color(0xFF1E3A8A)
                            )
                        }
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { adjustBalanceOnLedgerDelete = !adjustBalanceOnLedgerDelete }
                    ) {
                        Checkbox(
                            checked = adjustBalanceOnLedgerDelete,
                            onCheckedChange = { adjustBalanceOnLedgerDelete = it }
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Auto-revert account balance",
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.deleteLedgerEntry(target, adjustAccountBalance = adjustBalanceOnLedgerDelete)
                        entryToDelete = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = { entryToDelete = null }) {
                    Text("Cancel")
                }
            }
        )
    }

    // --- Delete Account Confirmation Dialog ---
    if (accountToDelete != null) {
        val targetAcc = accountToDelete!!
        AlertDialog(
            onDismissRequest = { accountToDelete = null },
            title = { Text("Delete Account '${targetAcc.title}'?") },
            text = { Text("Are you sure you want to delete this account? It will be removed from your active accounts list.") },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.deleteFinancialItem(targetAcc, adjustLinkedAccount = true)
                        accountToDelete = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Delete Account")
                }
            },
            dismissButton = {
                TextButton(onClick = { accountToDelete = null }) {
                    Text("Cancel")
                }
            }
        )
    }
}
