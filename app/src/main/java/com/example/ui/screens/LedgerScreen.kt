package com.example.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.model.LedgerEntry
import com.example.ui.components.AddLedgerEntryDialog
import com.example.ui.components.AddVoucherDialog
import com.example.ui.components.ShareEntryDialog
import com.example.ui.components.VoiceAssistantDialog
import com.example.ui.theme.AssetGreen
import com.example.ui.theme.LiabilityRed
import com.example.ui.theme.PrimaryGreen
import com.example.ui.utils.NumberFormatUtils
import com.example.ui.viewmodel.NetWorthViewModel

@Composable
fun LedgerScreen(
    viewModel: NetWorthViewModel
) {
    val context = LocalContext.current
    val ledgerEntries by viewModel.allLedgerEntries.collectAsState()
    val items by viewModel.liveItems.collectAsState()

    var showVoiceDialog by remember { mutableStateOf(false) }
    var showAddDialog by remember { mutableStateOf(false) }
    var showAddVoucherDialog by remember { mutableStateOf(false) }
    var entryToShare by remember { mutableStateOf<LedgerEntry?>(null) }
    var showSummaryShareDialog by remember { mutableStateOf(false) }
    var entryToDelete by remember { mutableStateOf<LedgerEntry?>(null) }

    if (entryToDelete != null) {
        val targetEntry = entryToDelete!!
        val adjustments = remember(targetEntry, items) {
            viewModel.previewAdjustmentsForDeletion(targetEntry)
        }
        var autoAdjustHoldings by remember { mutableStateOf(true) }

        AlertDialog(
            onDismissRequest = { entryToDelete = null },
            icon = {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = LiabilityRed,
                    modifier = Modifier.size(28.dp)
                )
            },
            title = {
                Text(
                    text = "Delete Ledger Entry?",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Are you sure you want to delete this transaction from Financial Ledger?",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    // Transaction preview card
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = targetEntry.transactionTitle,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            val isCredit = targetEntry.entryType == "CREDIT"
                            val amt = if (isCredit) targetEntry.creditAmount else targetEntry.debitAmount
                            Text(
                                text = "${if (isCredit) "+" else "-"}${NumberFormatUtils.formatCurrency(amt)} (${targetEntry.entryType})",
                                color = if (isCredit) AssetGreen else LiabilityRed,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleSmall
                            )
                            if (targetEntry.accountName.isNotBlank()) {
                                Text(
                                    text = "Account: ${targetEntry.accountName}${if (targetEntry.oppositeAccountName.isNotBlank()) " ➔ ${targetEntry.oppositeAccountName}" else ""}",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }

                    // Key Portfolio Holdings Auto-Adjustment Section
                    if (adjustments.isNotEmpty()) {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = PrimaryGreen.copy(alpha = 0.08f)
                            )
                        ) {
                            Column(
                                modifier = Modifier.padding(12.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.AccountBalanceWallet,
                                        contentDescription = null,
                                        tint = PrimaryGreen,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "Key Portfolio Holdings Auto-Adjustment",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = PrimaryGreen
                                    )
                                }
                                Text(
                                    text = "Amounts in Key Portfolio Holdings will auto-adjust as follows:",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )

                                adjustments.forEach { adj ->
                                    val isPlus = adj.change > 0
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(
                                                MaterialTheme.colorScheme.surface,
                                                RoundedCornerShape(8.dp)
                                            )
                                            .padding(10.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = adj.item.title,
                                                fontWeight = FontWeight.Bold,
                                                style = MaterialTheme.typography.bodyMedium
                                            )
                                            Text(
                                                text = "${if (isPlus) "+" else ""}${NumberFormatUtils.formatCurrency(adj.change)}",
                                                fontWeight = FontWeight.Bold,
                                                color = if (isPlus) AssetGreen else LiabilityRed,
                                                style = MaterialTheme.typography.bodyMedium
                                            )
                                        }
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(
                                                text = adj.item.category,
                                                style = MaterialTheme.typography.labelSmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                            Text(
                                                text = "₹${String.format("%,.0f", adj.oldBalance)} ➔ ₹${String.format("%,.0f", adj.newBalance)}",
                                                style = MaterialTheme.typography.labelSmall,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        }
                                        Text(
                                            text = adj.explanation,
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                                        )
                                    }
                                }

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { autoAdjustHoldings = !autoAdjustHoldings }
                                        .padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Checkbox(
                                        checked = autoAdjustHoldings,
                                        onCheckedChange = { autoAdjustHoldings = it }
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "Auto-adjust account amount in Portfolio Holdings",
                                        style = MaterialTheme.typography.bodySmall,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        }
                    } else {
                        Text(
                            text = "ℹ️ No matching accounts found in Portfolio Holdings for auto-adjustment.",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val toDelete = targetEntry
                        entryToDelete = null
                        viewModel.deleteLedgerEntry(toDelete, autoAdjustHoldings = autoAdjustHoldings) { result ->
                            if (!result.success) {
                                Toast.makeText(context, result.message, Toast.LENGTH_LONG).show()
                            } else if (autoAdjustHoldings && result.adjustmentsApplied.isNotEmpty()) {
                                val summary = result.adjustmentsApplied.joinToString { "${it.item.title} (₹${String.format("%,.0f", it.newBalance)})" }
                                Toast.makeText(context, "Deleted & Portfolio updated: $summary", Toast.LENGTH_LONG).show()
                            } else {
                                Toast.makeText(context, "Deleted transaction from ledger", Toast.LENGTH_SHORT).show()
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = LiabilityRed)
                ) {
                    Text(if (autoAdjustHoldings && adjustments.isNotEmpty()) "Delete & Auto Adjust" else "Delete Entry")
                }
            },
            dismissButton = {
                TextButton(onClick = { entryToDelete = null }) {
                    Text("Cancel")
                }
            }
        )
    }

    if (showVoiceDialog) {
        VoiceAssistantDialog(
            viewModel = viewModel,
            onDismiss = { showVoiceDialog = false },
            onNavigate = { showVoiceDialog = false }
        )
    }

    if (showAddDialog) {
        val partyList = items
        AddLedgerEntryDialog(
            parties = partyList,
            onDismiss = { showAddDialog = false },
            onSave = { entry, updatedParties ->
                viewModel.postDirectLedgerEntry(entry)
                updatedParties.forEach { viewModel.saveFinancialItem(it) }
                showAddDialog = false
                Toast.makeText(context, "Transaction recorded", Toast.LENGTH_SHORT).show()
            },
            onSaveAndShare = { entry, updatedParties ->
                viewModel.postDirectLedgerEntry(entry)
                updatedParties.forEach { viewModel.saveFinancialItem(it) }
                showAddDialog = false
                entryToShare = entry
            }
        )
    }

    if (showAddVoucherDialog) {
        val parties = items.map { it.title }.distinct().sorted()
        AddVoucherDialog(
            parties = parties,
            onDismiss = { showAddVoucherDialog = false },
            onSave = { entry ->
                viewModel.postDirectLedgerEntry(entry)
                showAddVoucherDialog = false
                Toast.makeText(context, "Voucher recorded", Toast.LENGTH_SHORT).show()
            }
        )
    }

    entryToShare?.let { entry ->
        ShareEntryDialog(
            entry = entry,
            onDismiss = { entryToShare = null }
        )
    }

    if (showSummaryShareDialog) {
        val totalCredit = ledgerEntries.sumOf { it.creditAmount }
        val totalDebit = ledgerEntries.sumOf { it.debitAmount }
        ShareEntryDialog(
            summaryEntries = ledgerEntries,
            totalCredit = totalCredit,
            totalDebit = totalDebit,
            onDismiss = { showSummaryShareDialog = false }
        )
    }

    val totalCredit = ledgerEntries.sumOf { it.creditAmount }
    val totalDebit = ledgerEntries.sumOf { it.debitAmount }
    val netCashFlow = totalCredit - totalDebit

    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        floatingActionButton = {
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                FloatingActionButton(
                    onClick = { showVoiceDialog = true },
                    containerColor = PrimaryGreen.copy(alpha = 0.2f),
                    contentColor = PrimaryGreen,
                    shape = CircleShape
                ) {
                    Icon(Icons.Default.Mic, contentDescription = "Voice Assistant")
                }
                FloatingActionButton(
                    onClick = { showAddVoucherDialog = true },
                    containerColor = PrimaryGreen,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    shape = CircleShape
                ) {
                    Icon(Icons.Default.Receipt, contentDescription = "Add Voucher")
                }
                FloatingActionButton(
                    onClick = { showAddDialog = true },
                    containerColor = PrimaryGreen,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    shape = CircleShape
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add Transaction")
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
        ) {
            // Header & Cashflow summary
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Financial Ledger",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Income, expenses & account movement",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(
                            onClick = { showVoiceDialog = true },
                            modifier = Modifier
                                .size(38.dp)
                                .background(PrimaryGreen.copy(alpha = 0.12f), CircleShape)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Mic,
                                contentDescription = "Active Voice Control",
                                tint = PrimaryGreen,
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        if (ledgerEntries.isNotEmpty()) {
                            Spacer(modifier = Modifier.width(6.dp))
                            IconButton(
                                onClick = { showSummaryShareDialog = true },
                                modifier = Modifier
                                    .size(38.dp)
                                    .background(PrimaryGreen.copy(alpha = 0.12f), CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Share,
                                    contentDescription = "Share Statement",
                                    tint = PrimaryGreen,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    // Inflow card
                    Card(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.ArrowDownward, contentDescription = null, tint = AssetGreen, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Inflow", style = MaterialTheme.typography.labelSmall)
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = NumberFormatUtils.formatCompact(totalCredit),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = AssetGreen
                            )
                        }
                    }

                    // Outflow card
                    Card(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.ArrowUpward, contentDescription = null, tint = LiabilityRed, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Outflow", style = MaterialTheme.typography.labelSmall)
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = NumberFormatUtils.formatCompact(totalDebit),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = LiabilityRed
                            )
                        }
                    }

                    // Net card
                    Card(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text("Net Flow", style = MaterialTheme.typography.labelSmall)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = NumberFormatUtils.formatCompact(netCashFlow),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = if (netCashFlow >= 0) AssetGreen else LiabilityRed
                            )
                        }
                    }
                }
            }

            if (ledgerEntries.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No ledger entries yet. Tap + or use Voice to record a transaction!",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 80.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(ledgerEntries, key = { it.id }) { entry ->
                        LedgerEntryCard(
                            entry = entry,
                            onShare = { entryToShare = entry },
                            onDelete = {
                                entryToDelete = entry
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LedgerEntryCard(
    entry: LedgerEntry,
    onShare: () -> Unit,
    onDelete: () -> Unit
) {
    val isCredit = entry.entryType == "CREDIT"
    val isDebit = entry.entryType == "DEBIT"
    val amount = if (isCredit) entry.creditAmount else entry.debitAmount

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            color = if (isCredit) AssetGreen.copy(alpha = 0.15f) else LiabilityRed.copy(alpha = 0.15f),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (isCredit) Icons.Default.ArrowDownward else Icons.Default.ArrowUpward,
                        contentDescription = null,
                        tint = if (isCredit) AssetGreen else LiabilityRed,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = entry.transactionTitle,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "${entry.accountName} ${if (entry.oppositeAccountName.isNotBlank()) "→ ${entry.oppositeAccountName}" else ""} • ${NumberFormatUtils.formatDateShort(entry.timestamp)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    if (entry.notes.isNotBlank()) {
                        Text(
                            text = entry.notes,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                        )
                    }
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${if (isCredit) "+" else "-"}${NumberFormatUtils.formatCurrency(amount)}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = if (isCredit) AssetGreen else LiabilityRed
                )
                Spacer(modifier = Modifier.width(4.dp))
                IconButton(onClick = onShare, modifier = Modifier.size(32.dp)) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        tint = PrimaryGreen,
                        modifier = Modifier.size(16.dp)
                    )
                }
                IconButton(onClick = onDelete, modifier = Modifier.size(32.dp)) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}
