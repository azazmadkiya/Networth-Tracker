package com.example.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material.icons.filled.TrendingDown
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.model.FinancialItem
import com.example.data.model.ItemCategory
import com.example.data.model.OwnerProfile
import com.example.ui.utils.NumberFormatUtils
import com.example.ui.viewmodel.NetWorthViewModel

@Composable
fun AssetsListScreen(
    viewModel: NetWorthViewModel,
    onAddNewItem: () -> Unit,
    onEditItem: (FinancialItem) -> Unit
) {
    val items by viewModel.filteredItems.collectAsStateWithLifecycle()
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    val selectedOwner by viewModel.selectedOwnerFilter.collectAsStateWithLifecycle()
    val selectedCategory by viewModel.selectedCategoryFilter.collectAsStateWithLifecycle()

    var itemToDelete by remember { mutableStateOf<FinancialItem?>(null) }
    var itemToAdjust by remember { mutableStateOf<FinancialItem?>(null) }
    var showQuickModifyDialog by remember { mutableStateOf(false) }
    var showQuickDeleteDialog by remember { mutableStateOf(false) }
    var showQuickAdjustDialog by remember { mutableStateOf(false) }
    var adjustLinkedAccountOnDelete by remember { mutableStateOf(true) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { viewModel.searchQuery.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("assets_search_input"),
                placeholder = { Text("Search assets by name...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Assets") },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(
                            onClick = { viewModel.searchQuery.value = "" },
                            modifier = Modifier.testTag("clear_search_button")
                        ) {
                            Icon(Icons.Default.Clear, contentDescription = "Clear search")
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Category Filter Chips
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.testTag("category_filter_row")
            ) {
                val categories = listOf("All") + ItemCategory.entries.map { it.displayName }
                items(categories) { cat ->
                    FilterChip(
                        selected = selectedCategory == cat,
                        onClick = { viewModel.selectedCategoryFilter.value = cat },
                        label = { Text(cat) },
                        modifier = Modifier.testTag("category_chip_$cat")
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Owner Filter Chips
            val context = androidx.compose.ui.platform.LocalContext.current
            val ownerPrefs = remember { context.getSharedPreferences("owner_prefs", android.content.Context.MODE_PRIVATE) }
            val savedOwners = ownerPrefs.getStringSet("custom_owners_v1", null)?.toList() ?: listOf("Self", "Father", "Mother", "Family Joint")
            val owners = (listOf("All") + savedOwners + items.map { it.owner }).distinct()
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.testTag("assets_owner_filter_row")
            ) {
                items(owners) { own ->
                    FilterChip(
                        selected = selectedOwner == own,
                        onClick = { viewModel.selectedOwnerFilter.value = own },
                        label = { Text("Owner: $own") },
                        modifier = Modifier.testTag("assets_owner_chip_$own")
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Filter Summary Bar
            val totalAssets = items.filter { !it.isLiability }.sumOf { it.currentValue }
            val totalLiabilities = items.filter { it.isLiability }.sumOf { it.currentValue }
            val stockItems = items.filter { !it.isLiability && (it.category.contains("Share Market", true) || it.category.contains("Stocks", true)) }
            val totalStockWorth = stockItems.sumOf { it.currentValue }

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.surfaceContainer,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Showing ${items.size} accounts/items",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "Net: ${NumberFormatUtils.formatCompactCurrency(totalAssets - totalLiabilities)}",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    if (totalStockWorth > 0) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "📈 Live Tracked Stocks Value",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = NumberFormatUtils.formatCurrency(totalStockWorth),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF059669)
                            )
                        }
                    }

                    // Owner Management Quick Options Bar (Add, Adjust, Modify, Delete, Refresh)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Owner: $selectedOwner Options:",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp), verticalAlignment = Alignment.CenterVertically) {
                            // Add Asset Button
                            FilledTonalButton(
                                onClick = onAddNewItem,
                                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
                                modifier = Modifier
                                    .height(30.dp)
                                    .testTag("owner_quick_add_button")
                            ) {
                                Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(13.dp))
                                Spacer(modifier = Modifier.width(2.dp))
                                Text("Add", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            }

                            if (items.isNotEmpty()) {
                                // Adjust Amount Button
                                OutlinedButton(
                                    onClick = { showQuickAdjustDialog = true },
                                    contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
                                    modifier = Modifier
                                        .height(30.dp)
                                        .testTag("owner_quick_adjust_button"),
                                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF0284C7))
                                ) {
                                    Icon(Icons.Default.Tune, contentDescription = null, modifier = Modifier.size(13.dp))
                                    Spacer(modifier = Modifier.width(2.dp))
                                    Text("Adjust", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }

                                // Modify Asset Button
                                OutlinedButton(
                                    onClick = { showQuickModifyDialog = true },
                                    contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
                                    modifier = Modifier
                                        .height(30.dp)
                                        .testTag("owner_quick_modify_button")
                                ) {
                                    Icon(Icons.Default.Edit, contentDescription = null, modifier = Modifier.size(13.dp))
                                    Spacer(modifier = Modifier.width(2.dp))
                                    Text("Modify", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }

                                // Delete Asset Button
                                OutlinedButton(
                                    onClick = { showQuickDeleteDialog = true },
                                    contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
                                    modifier = Modifier
                                        .height(30.dp)
                                        .testTag("owner_quick_delete_button"),
                                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFEF4444))
                                ) {
                                    Icon(Icons.Default.Delete, contentDescription = null, modifier = Modifier.size(13.dp))
                                    Spacer(modifier = Modifier.width(2.dp))
                                    Text("Delete", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }
                            }

                            // Quick Re Fresh & Recalculate Button
                            IconButton(
                                onClick = {
                                    viewModel.refreshAndRecalculateAll()
                                    Toast.makeText(context, "🔄 Refreshed & Recalculated Balances", Toast.LENGTH_SHORT).show()
                                },
                                modifier = Modifier
                                    .size(30.dp)
                                    .testTag("assets_quick_refresh_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Refresh,
                                    contentDescription = "Re Fresh Balances",
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Items List
            if (items.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No financial records found matching filters.\nTap + below to add bank accounts, stocks or investments.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(items, key = { it.id }) { item ->
                        FinancialItemCard(
                            item = item,
                            onEdit = { onEditItem(item) },
                            onAdjust = { itemToAdjust = item },
                            onDelete = {
                                adjustLinkedAccountOnDelete = true
                                itemToDelete = item
                            }
                        )
                    }
                    item { Spacer(modifier = Modifier.height(80.dp)) }
                }
            }
        }

        // FAB to Add Item
        FloatingActionButton(
            onClick = onAddNewItem,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp)
                .testTag("assets_add_fab"),
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add Asset")
        }
    }

    // Delete Confirmation Dialog with Linked Account Auto-Adjustment Option
    itemToDelete?.let { item ->
        val hasLinkedAccount = item.sourceAccountTitle.isNotBlank()
        val isIncome = item.category.contains("Income", ignoreCase = true)

        AlertDialog(
            onDismissRequest = { itemToDelete = null },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Delete, contentDescription = null, tint = Color(0xFFEF4444))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Delete Financial Entry?")
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text("Are you sure you want to delete '${item.title}' (${item.owner} - ${item.category})?")

                    if (hasLinkedAccount) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFFEFF6FF),
                            border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFBFDBFE)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(
                                    text = "⚡ Bank / Cash Account Auto-Adjustment",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp,
                                    color = Color(0xFF1E40AF)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = if (!isIncome) {
                                        "Deleting this entry will automatically restore & refund ₹${NumberFormatUtils.formatCurrency(item.currentValue)} back into '${item.sourceAccountTitle}'."
                                    } else {
                                        "Deleting this income entry will automatically deduct ₹${NumberFormatUtils.formatCurrency(item.currentValue)} from '${item.sourceAccountTitle}'."
                                    },
                                    fontSize = 12.sp,
                                    color = Color(0xFF1E3A8A)
                                )
                            }
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { adjustLinkedAccountOnDelete = !adjustLinkedAccountOnDelete }
                        ) {
                            Checkbox(
                                checked = adjustLinkedAccountOnDelete,
                                onCheckedChange = { adjustLinkedAccountOnDelete = it },
                                modifier = Modifier.testTag("checkbox_adjust_linked_account")
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Adjust linked account balance automatically",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.deleteFinancialItem(item, adjustLinkedAccount = adjustLinkedAccountOnDelete)
                        itemToDelete = null
                    },
                    modifier = Modifier.testTag("confirm_delete_button")
                ) {
                    Text("Delete Entry", color = MaterialTheme.colorScheme.error, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { itemToDelete = null },
                    modifier = Modifier.testTag("cancel_delete_button")
                ) {
                    Text("Cancel", fontWeight = FontWeight.Bold)
                }
            }
        )
    }

    // Re Fresh & Adjust Balance Dialog
    itemToAdjust?.let { item ->
        var adjustedAmountStr by remember { mutableStateOf(if (item.currentValue == 0.0) "" else String.format(java.util.Locale.US, "%.2f", item.currentValue)) }
        var adjustmentReason by remember { mutableStateOf("Manual Balance Refresh / Statement Sync") }
        var inputError by remember { mutableStateOf<String?>(null) }

        val newAmount = adjustedAmountStr.toDoubleOrNull() ?: 0.0
        val delta = newAmount - item.currentValue
        val isDifferent = delta != 0.0

        AlertDialog(
            onDismissRequest = { itemToAdjust = null },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Tune, contentDescription = null, tint = Color(0xFF0284C7))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Re Fresh & Adjust Amount", fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceContainerHigh,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(item.title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Text("Category: ${item.category} • Owner: ${item.owner}", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Current Recorded Balance: ₹${NumberFormatUtils.formatCurrency(item.currentValue)}",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }

                    OutlinedTextField(
                        value = adjustedAmountStr,
                        onValueChange = {
                            adjustedAmountStr = it
                            inputError = null
                        },
                        label = { Text("New Adjusted Amount (₹) *") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("adjust_amount_input"),
                        isError = inputError != null,
                        supportingText = inputError?.let { { Text(it, color = MaterialTheme.colorScheme.error) } },
                        singleLine = true
                    )

                    // Delta Indicator Pill
                    if (isDifferent && adjustedAmountStr.isNotBlank()) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = if (delta > 0) Color(0xFFECFDF5) else Color(0xFFFEF2F2),
                            border = androidx.compose.foundation.BorderStroke(1.dp, if (delta > 0) Color(0xFFA7F3D0) else Color(0xFFFECACA)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = if (delta > 0) {
                                        "▲ Net Increase: +₹${NumberFormatUtils.formatCurrency(delta)} (${if (!item.isLiability) "Debit DR" else "Credit CR"} to ledger)"
                                    } else {
                                        "▼ Net Decrease: -₹${NumberFormatUtils.formatCurrency(kotlin.math.abs(delta))} (${if (!item.isLiability) "Credit CR" else "Debit DR"} from ledger)"
                                    },
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp,
                                    color = if (delta > 0) Color(0xFF047857) else Color(0xFFB91C1C)
                                )
                            }
                        }
                    }

                    OutlinedTextField(
                        value = adjustmentReason,
                        onValueChange = { adjustmentReason = it },
                        label = { Text("Adjustment Reason / Note") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("adjust_reason_input"),
                        singleLine = true
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val parsed = adjustedAmountStr.toDoubleOrNull()
                        if (parsed == null || parsed < 0) {
                            inputError = "Please enter a valid non-negative amount"
                            return@Button
                        }
                        viewModel.adjustAccountBalance(item, parsed, adjustmentReason.ifBlank { "Balance Adjustment" })
                        itemToAdjust = null
                    },
                    modifier = Modifier.testTag("save_adjusted_amount_button")
                ) {
                    Text("Apply & Update", fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { itemToAdjust = null }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Quick Adjust Asset Selector Dialog
    if (showQuickAdjustDialog && items.isNotEmpty()) {
        AlertDialog(
            onDismissRequest = { showQuickAdjustDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Tune, contentDescription = null, tint = Color(0xFF0284C7))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Select Account to Adjust / Refresh", fontWeight = FontWeight.Bold, color = Color(0xFF0284C7))
                }
            },
            text = {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                ) {
                    items(items, key = { "adj_${it.id}" }) { item ->
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.surfaceContainerHigh,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    showQuickAdjustDialog = false
                                    itemToAdjust = item
                                }
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(item.title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                                    Text("${item.owner} • ${item.category}", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                }
                                Text(
                                    text = NumberFormatUtils.formatCurrency(item.currentValue),
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showQuickAdjustDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Quick Modify Asset Selector Dialog
    if (showQuickModifyDialog && items.isNotEmpty()) {
        AlertDialog(
            onDismissRequest = { showQuickModifyDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Edit, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Select Asset to Modify", fontWeight = FontWeight.Bold)
                }
            },
            text = {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                ) {
                    items(items, key = { "mod_${it.id}" }) { item ->
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.surfaceContainerHigh,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    showQuickModifyDialog = false
                                    onEditItem(item)
                                }
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(item.title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                                    Text("${item.owner} • ${item.category}", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                }
                                Text(
                                    text = NumberFormatUtils.formatCurrency(item.currentValue),
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showQuickModifyDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Quick Delete Asset Selector Dialog
    if (showQuickDeleteDialog && items.isNotEmpty()) {
        AlertDialog(
            onDismissRequest = { showQuickDeleteDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Delete, contentDescription = null, tint = Color(0xFFEF4444))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Select Asset to Delete", fontWeight = FontWeight.Bold, color = Color(0xFFEF4444))
                }
            },
            text = {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                ) {
                    items(items, key = { "del_${it.id}" }) { item ->
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = Color(0xFFFEE2E2),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    showQuickDeleteDialog = false
                                    itemToDelete = item
                                }
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(item.title, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color(0xFF991B1B))
                                    Text("${item.owner} • ${item.category}", fontSize = 11.sp, color = Color(0xFF7F1D1D))
                                }
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete Item",
                                    tint = Color(0xFFDC2626),
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showQuickDeleteDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FinancialItemCard(
    item: FinancialItem,
    onEdit: () -> Unit,
    onAdjust: () -> Unit = {},
    onDelete: () -> Unit
) {
    var showMenu by remember { mutableStateOf(false) }
    val ownerProf = OwnerProfile.fromString(item.owner)
    val ownerColor = Color(ownerProf.badgeColorHex)

    val categoryIcon = when {
        item.category.contains("Bank", true) -> Icons.Default.AccountBalance
        item.category.contains("Share", true) -> Icons.Default.TrendingUp
        item.category.contains("Mutual", true) -> Icons.Default.PieChart
        item.category.contains("IPO", true) -> Icons.Default.ShowChart
        item.category.contains("Paid Loan", true) || item.category.contains("Aapel", true) || item.category.contains("Chekvel", true) || item.category.contains("Loan Given", true) -> Icons.Default.Handshake
        item.category.contains("Gold", true) -> Icons.Default.Diamond
        item.category.contains("Estate", true) -> Icons.Default.Home
        item.category.contains("Cash", true) -> Icons.Default.Payments
        item.isLiability -> Icons.Default.TrendingDown
        else -> Icons.Default.Savings
    }

    Box(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("financial_item_card_${item.id}")
                .combinedClickable(
                    onClick = onEdit,
                    onLongClick = {
                        showMenu = true
                    }
                ),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Category Icon + Title
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = if (item.isLiability) Color(0xFFFEE2E2) else ownerColor.copy(alpha = 0.15f),
                            modifier = Modifier.size(40.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = categoryIcon,
                                    contentDescription = null,
                                    tint = if (item.isLiability) Color(0xFFEF4444) else ownerColor,
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                // Owner Badge
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = ownerColor.copy(alpha = 0.2f),
                                    modifier = Modifier.padding(end = 6.dp)
                                ) {
                                    Text(
                                        text = item.owner,
                                        color = ownerColor,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }

                                Text(
                                    text = item.category,
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )

                                if (item.category.contains("Share Market", true) || item.category.contains("Stocks", true)) {
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Surface(
                                        shape = RoundedCornerShape(4.dp),
                                        color = Color(0xFF10B981).copy(alpha = 0.15f)
                                    ) {
                                        Text(
                                            text = "● LIVE",
                                            color = Color(0xFF059669),
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    // Amount
                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = NumberFormatUtils.formatCurrency(item.currentValue),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = if (item.isLiability) Color(0xFFEF4444) else MaterialTheme.colorScheme.primary
                        )

                        if (item.investedValue > 0 && item.currentValue != item.investedValue && !item.isLiability) {
                            val pnl = item.currentValue - item.investedValue
                            val pnlPct = (pnl / item.investedValue) * 100
                            val isProfit = pnl >= 0
                            Text(
                                text = "${if (isProfit) "+" else ""}${NumberFormatUtils.formatCurrency(pnl)} (${String.format("%.1f", pnlPct)}%)",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = if (isProfit) Color(0xFF10B981) else Color(0xFFEF4444)
                            )
                        }
                    }
                }

                // Institution, Notes & Action Buttons Row (Edit & Delete always available)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        if (item.sourceAccountTitle.isNotBlank()) {
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = Color(0xFFEF4444).copy(alpha = 0.1f),
                                modifier = Modifier.padding(bottom = 2.dp)
                            ) {
                                Text(
                                    text = "Deducted from: ${item.sourceAccountTitle}",
                                    color = Color(0xFFDC2626),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }
                        if (item.institution.isNotBlank() || item.accountNumber.isNotBlank() || item.notes.isNotBlank()) {
                            Text(
                                text = "${item.institution} ${if (item.accountNumber.isNotBlank()) "• ${item.accountNumber}" else ""} ${if (item.notes.isNotBlank()) "• ${item.notes}" else ""}".trim(),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        } else {
                            Text(
                                text = "Owner: ${item.owner}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(
                            onClick = onAdjust,
                            modifier = Modifier.size(32.dp).testTag("adjust_item_${item.id}")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Tune,
                                contentDescription = "Adjust Balance",
                                tint = Color(0xFF0284C7),
                                modifier = Modifier.size(18.dp)
                            )
                        }
                        IconButton(
                            onClick = onEdit,
                            modifier = Modifier.size(32.dp).testTag("edit_item_${item.id}")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Edit Item",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                        IconButton(
                            onClick = onDelete,
                            modifier = Modifier.size(32.dp).testTag("delete_item_${item.id}")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete Item",
                                tint = Color(0xFFEF4444),
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }
            }
        }

        DropdownMenu(
            expanded = showMenu,
            onDismissRequest = { showMenu = false }
        ) {
            DropdownMenuItem(
                text = { Text("Re Fresh & Adjust Amount") },
                onClick = {
                    showMenu = false
                    onAdjust()
                },
                leadingIcon = { Icon(Icons.Default.Tune, contentDescription = null, tint = Color(0xFF0284C7)) },
                modifier = Modifier.testTag("long_press_menu_adjust_${item.id}")
            )
            DropdownMenuItem(
                text = { Text("Edit Item") },
                onClick = {
                    showMenu = false
                    onEdit()
                },
                leadingIcon = { Icon(Icons.Default.Edit, contentDescription = null) },
                modifier = Modifier.testTag("long_press_menu_edit_${item.id}")
            )
            DropdownMenuItem(
                text = { Text("Delete Item", color = Color(0xFFEF4444)) },
                onClick = {
                    showMenu = false
                    onDelete()
                },
                leadingIcon = { Icon(Icons.Default.Delete, contentDescription = null, tint = Color(0xFFEF4444)) },
                modifier = Modifier.testTag("long_press_menu_delete_${item.id}")
            )
        }
    }
}
