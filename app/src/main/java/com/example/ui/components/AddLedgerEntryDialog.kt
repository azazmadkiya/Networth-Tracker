package com.example.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.data.model.ItemCategory
import com.example.data.model.LedgerEntry
import com.example.ui.theme.AssetGreen
import com.example.ui.theme.LiabilityRed
import com.example.ui.theme.PrimaryGreen

@Composable
fun AddLedgerEntryDialog(
    onDismiss: () -> Unit,
    onSave: (LedgerEntry) -> Unit,
    onSaveAndShare: ((LedgerEntry) -> Unit)? = null
) {
    var title by remember { mutableStateOf("") }
    var entryType by remember { mutableStateOf("DEBIT") } // DEBIT, CREDIT, TRANSFER
    var amountStr by remember { mutableStateOf("") }
    var accountName by remember { mutableStateOf("HDFC Salary Account") }
    var oppositeAccountName by remember { mutableStateOf("") }
    var category by remember { mutableStateOf(ItemCategory.EXPENSE.displayName) }
    var notes by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Record Transaction",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Entry Type tabs
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilterChip(
                        selected = entryType == "DEBIT",
                        onClick = {
                            entryType = "DEBIT"
                            category = ItemCategory.EXPENSE.displayName
                        },
                        label = { Text("Expense (Debit)") }
                    )
                    FilterChip(
                        selected = entryType == "CREDIT",
                        onClick = {
                            entryType = "CREDIT"
                            category = ItemCategory.INCOME.displayName
                        },
                        label = { Text("Income (Credit)") }
                    )
                    FilterChip(
                        selected = entryType == "TRANSFER",
                        onClick = {
                            entryType = "TRANSFER"
                            category = ItemCategory.BANK_ACCOUNT.displayName
                        },
                        label = { Text("Transfer") }
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Description / Merchant *") },
                    placeholder = { Text("e.g. Grocery shopping, Client payment") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = amountStr,
                    onValueChange = { amountStr = it },
                    label = { Text("Amount (₹) *") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = accountName,
                        onValueChange = { accountName = it },
                        label = { Text("From / Primary Account") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = oppositeAccountName,
                        onValueChange = { oppositeAccountName = it },
                        label = { Text(if (entryType == "TRANSFER") "To Account" else "Payee / Source") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

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
                            selected = category.equals(cat.displayName, ignoreCase = true),
                            onClick = { category = cat.displayName },
                            label = { Text(cat.displayName) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    label = { Text("Notes / Reference") },
                    placeholder = { Text("e.g. UPI Ref #981293") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    if (onSaveAndShare != null) {
                        Spacer(modifier = Modifier.width(6.dp))
                        OutlinedButton(
                            onClick = {
                                val amt = amountStr.toDoubleOrNull() ?: 0.0
                                if (title.isNotBlank() && amt > 0) {
                                    val debit = if (entryType == "DEBIT" || entryType == "TRANSFER") amt else 0.0
                                    val credit = if (entryType == "CREDIT") amt else 0.0
                                    val entry = LedgerEntry(
                                        timestamp = System.currentTimeMillis(),
                                        transactionTitle = title.trim(),
                                        accountName = accountName.trim(),
                                        oppositeAccountName = oppositeAccountName.trim(),
                                        entryType = entryType,
                                        debitAmount = debit,
                                        creditAmount = credit,
                                        runningBalance = 0.0,
                                        category = category,
                                        notes = notes.trim()
                                    )
                                    onSaveAndShare(entry)
                                }
                            },
                            shape = RoundedCornerShape(12.dp),
                            enabled = title.isNotBlank() && (amountStr.toDoubleOrNull() ?: 0.0) > 0
                        ) {
                            Icon(Icons.Default.Share, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Save & Share")
                        }
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            val amt = amountStr.toDoubleOrNull() ?: 0.0
                            if (title.isNotBlank() && amt > 0) {
                                val debit = if (entryType == "DEBIT" || entryType == "TRANSFER") amt else 0.0
                                val credit = if (entryType == "CREDIT") amt else 0.0
                                val entry = LedgerEntry(
                                    timestamp = System.currentTimeMillis(),
                                    transactionTitle = title.trim(),
                                    accountName = accountName.trim(),
                                    oppositeAccountName = oppositeAccountName.trim(),
                                    entryType = entryType,
                                    debitAmount = debit,
                                    creditAmount = credit,
                                    runningBalance = 0.0,
                                    category = category,
                                    notes = notes.trim()
                                )
                                onSave(entry)
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (entryType == "DEBIT") LiabilityRed else if (entryType == "CREDIT") AssetGreen else PrimaryGreen
                        ),
                        enabled = title.isNotBlank() && (amountStr.toDoubleOrNull() ?: 0.0) > 0
                    ) {
                        Text("Save")
                    }
                }
            }
        }
    }
}
