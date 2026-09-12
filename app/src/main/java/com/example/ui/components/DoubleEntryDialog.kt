package com.example.ui.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.data.model.FinancialItem
import com.example.data.model.LedgerEntry

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoubleEntryDialog(
    items: List<FinancialItem>,
    onDismiss: () -> Unit,
    onSave: (LedgerEntry, FinancialItem, FinancialItem) -> Unit
) {
    val context = LocalContext.current
    var account1 by remember { mutableStateOf<FinancialItem?>(null) }
    var account2 by remember { mutableStateOf<FinancialItem?>(null) }
    var amountStr by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }
    
    // Action: "Add to Account 1" or "Deduct from Account 1"
    var adjustType by remember { mutableStateOf("Add to Account 1") }
    
    var acc1Expanded by remember { mutableStateOf(false) }
    var acc2Expanded by remember { mutableStateOf(false) }

    val canSave = account1 != null && account2 != null && (amountStr.toDoubleOrNull() ?: 0.0) > 0

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val safeDismiss = {
        keyboardController?.hide()
        focusManager.clearFocus()
        onDismiss()
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
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 520.dp)
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
                        Column {
                            Text(
                                text = "Journal Transfer (ERP)",
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = if (canSave) "Ready to transfer" else "Select 2 accounts & enter amount",
                                style = MaterialTheme.typography.bodySmall,
                                color = if (canSave) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        IconButton(onClick = safeDismiss) {
                            Icon(Icons.Default.Close, contentDescription = "Close")
                        }
                    }

                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                    // Scrollable Body
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f, fill = false)
                            .verticalScroll(rememberScrollState())
                            .padding(horizontal = 20.dp, vertical = 14.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Transfer amount between two accounts simultaneously.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                
                // Account 1
                ExposedDropdownMenuBox(
                    expanded = acc1Expanded,
                    onExpandedChange = { acc1Expanded = !acc1Expanded }
                ) {
                    OutlinedTextField(
                        value = account1?.title ?: "Select Account 1",
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Account 1") },
                        modifier = Modifier.fillMaxWidth().menuAnchor(),
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = acc1Expanded) },
                        shape = RoundedCornerShape(12.dp)
                    )
                    ExposedDropdownMenu(
                        expanded = acc1Expanded,
                        onDismissRequest = { acc1Expanded = false }
                    ) {
                        items.forEach { item ->
                            DropdownMenuItem(
                                text = { Text("${item.title} (₹${String.format("%.0f", item.currentValue)})") },
                                onClick = {
                                    account1 = item
                                    acc1Expanded = false
                                }
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Account 2
                ExposedDropdownMenuBox(
                    expanded = acc2Expanded,
                    onExpandedChange = { acc2Expanded = !acc2Expanded }
                ) {
                    OutlinedTextField(
                        value = account2?.title ?: "Select Account 2",
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Account 2") },
                        modifier = Modifier.fillMaxWidth().menuAnchor(),
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = acc2Expanded) },
                        shape = RoundedCornerShape(12.dp)
                    )
                    ExposedDropdownMenu(
                        expanded = acc2Expanded,
                        onDismissRequest = { acc2Expanded = false }
                    ) {
                        items.forEach { item ->
                            if (item.id != account1?.id) { // Prevent selecting same account
                                DropdownMenuItem(
                                    text = { Text("${item.title} (₹${String.format("%.0f", item.currentValue)})") },
                                    onClick = {
                                        account2 = item
                                        acc2Expanded = false
                                    }
                                )
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Action
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilterChip(
                        selected = adjustType == "Add to Account 1",
                        onClick = { adjustType = "Add to Account 1" },
                        label = { Text("Add to Acc 1") }
                    )
                    FilterChip(
                        selected = adjustType == "Deduct from Account 1",
                        onClick = { adjustType = "Deduct from Account 1" },
                        label = { Text("Deduct from Acc 1") }
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Amount
                OutlinedTextField(
                    value = amountStr,
                    onValueChange = { amountStr = it },
                    label = { Text("Amount") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Notes
                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    label = { Text("Notes / Reference") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )
                
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
                                val amt = amountStr.toDoubleOrNull() ?: 0.0
                                if (account1 != null && account2 != null && amt > 0) {
                                    val isAdd = adjustType == "Add to Account 1"
                                    
                                    val acc1NewBal = if (isAdd) account1!!.currentValue + amt else account1!!.currentValue - amt
                                    val acc2NewBal = if (isAdd) account2!!.currentValue - amt else account2!!.currentValue + amt
                                    
                                    val updatedAcc1 = account1!!.copy(currentValue = acc1NewBal, updatedAt = System.currentTimeMillis())
                                    val updatedAcc2 = account2!!.copy(currentValue = acc2NewBal, updatedAt = System.currentTimeMillis())
                                    
                                    val entry = LedgerEntry(
                                        timestamp = System.currentTimeMillis(),
                                        transactionTitle = "Journal Transfer",
                                        accountName = account1!!.title,
                                        oppositeAccountName = account2!!.title,
                                        entryType = "TRANSFER",
                                        debitAmount = amt,
                                        creditAmount = 0.0, // Transfer implies both ways handled conceptually
                                        runningBalance = 0.0,
                                        category = "Transfer",
                                        notes = notes.trim()
                                    )
                                    onSave(entry, updatedAcc1, updatedAcc2)
                                } else {
                                    Toast.makeText(context, "Please select both accounts and enter a valid amount", Toast.LENGTH_SHORT).show()
                                }
                            },
                            shape = RoundedCornerShape(12.dp),
                            enabled = canSave
                        ) {
                            Text("Save Transaction")
                        }
                    }
                }
            }
        }
    }
}
