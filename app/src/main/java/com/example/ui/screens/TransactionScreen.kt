package com.example.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Receipt
import /* Add more icons here later if needed */ androidx.compose.material.icons.filled.SyncAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.components.AddEditItemDialog
import com.example.ui.components.AddLedgerEntryDialog
import com.example.ui.components.DoubleEntryDialog
import com.example.ui.theme.PrimaryGreen
import com.example.ui.viewmodel.NetWorthViewModel

@Composable
fun TransactionScreen(viewModel: NetWorthViewModel) {
    val context = LocalContext.current
    val items by viewModel.liveItems.collectAsState()
    
    var showRecordTransaction by remember { mutableStateOf(false) }
    var showAddFinancialItem by remember { mutableStateOf(false) }
    var showDoubleEntry by remember { mutableStateOf(false) }
    
    val partyList = items.filter { it.category in listOf("Sundry Creditors", "Sundry Debtors", "Loans & Dues", "Other Account") }

    if (showRecordTransaction) {
        AddLedgerEntryDialog(
            parties = items,
            onDismiss = { showRecordTransaction = false },
            onSave = { entry, updatedParties ->
                viewModel.postDirectLedgerEntry(entry)
                updatedParties.forEach { viewModel.saveFinancialItem(it) }
                showRecordTransaction = false
                Toast.makeText(context, "Transaction recorded in Ledger", Toast.LENGTH_SHORT).show()
            }
        )
    }
    
    if (showAddFinancialItem) {
        AddEditItemDialog(
            parties = items,
            onDismiss = { showAddFinancialItem = false },
            onSave = { item, ledgerEntry, updatedParty ->
                viewModel.saveFinancialItem(item)
                updatedParty?.let { viewModel.saveFinancialItem(it) }
                ledgerEntry?.let { viewModel.postDirectLedgerEntry(it) }
                showAddFinancialItem = false
                Toast.makeText(context, "Item added and synced to Ledger", Toast.LENGTH_SHORT).show()
            }
        )
    }
    
    if (showDoubleEntry) {
        DoubleEntryDialog(
            items = items,
            onDismiss = { showDoubleEntry = false },
            onSave = { entry, acc1, acc2 ->
                viewModel.saveFinancialItem(acc1)
                viewModel.saveFinancialItem(acc2)
                viewModel.postDirectLedgerEntry(entry)
                showDoubleEntry = false
                Toast.makeText(context, "Journal entry saved to Ledger", Toast.LENGTH_SHORT).show()
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Transactions & Entries",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = "Select a transaction type to record new entries.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Option 1: Record Transaction
        TransactionOptionCard(
            title = "Record Ledger Transaction",
            description = "Add a standard Debit/Credit transaction to your Ledger.",
            icon = Icons.Default.Receipt,
            onClick = { showRecordTransaction = true }
        )

        // Option 2: Add Financial Item
        TransactionOptionCard(
            title = "Add Financial Item",
            description = "Create a new Asset, Liability, or Party Account.",
            icon = Icons.Default.Add,
            onClick = { showAddFinancialItem = true }
        )

        // Option 3: ERP Double Entry
        TransactionOptionCard(
            title = "Double Entry Journal (ERP)",
            description = "Transfer amounts between two accounts simultaneously. Automatically updates both balances.",
            icon = Icons.Default.SyncAlt,
            onClick = { showDoubleEntry = true }
        )
    }
}

@Composable
fun TransactionOptionCard(
    title: String,
    description: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(PrimaryGreen.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = PrimaryGreen,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
