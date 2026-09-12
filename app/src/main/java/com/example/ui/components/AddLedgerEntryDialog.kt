package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Switch
import com.example.data.model.FinancialItem
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
import com.example.data.model.ItemCategory
import com.example.data.model.LedgerEntry
import com.example.ui.theme.AssetGreen
import com.example.ui.theme.LiabilityRed
import com.example.ui.theme.PrimaryGreen

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun AddLedgerEntryDialog(
    parties: List<FinancialItem> = emptyList(),
    onDismiss: () -> Unit,
    onSave: (LedgerEntry, List<FinancialItem>) -> Unit,
    onSaveAndShare: ((LedgerEntry, List<FinancialItem>) -> Unit)? = null
) {
    var title by remember { mutableStateOf("") }
    var entryType by remember { mutableStateOf("DEBIT") } // DEBIT, CREDIT, TRANSFER
    var amountStr by remember { mutableStateOf("") }
    var accountName by remember { mutableStateOf("") }
    var oppositeAccountName by remember { mutableStateOf("") }
    var accountExpanded by remember { mutableStateOf(false) }
    var oppositeExpanded by remember { mutableStateOf(false) }
    var category by remember { mutableStateOf(ItemCategory.EXPENSE.displayName) }
    var notes by remember { mutableStateOf("") }

    
    var selectedParty by remember { mutableStateOf<FinancialItem?>(null) }
    var partyExpanded by remember { mutableStateOf(false) }
    var adjustType by remember { mutableStateOf("Add to Party") }

    val canSave = title.isNotBlank() && (amountStr.toDoubleOrNull() ?: 0.0) > 0

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
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Record Transaction",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = if (canSave) "Ready to record" else "Fill Party Name & Amount to save",
                                style = MaterialTheme.typography.bodySmall,
                                color = if (canSave) AssetGreen else MaterialTheme.colorScheme.onSurfaceVariant
                            )
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

                        Spacer(modifier = Modifier.height(14.dp))

                        var titleExpanded by remember { mutableStateOf(false) }
                        ExposedDropdownMenuBox(
                            expanded = titleExpanded,
                            onExpandedChange = { titleExpanded = !titleExpanded }
                        ) {
                            OutlinedTextField(
                                value = title,
                                onValueChange = { 
                                    title = it
                                    selectedParty = parties.find { p -> p.title.equals(it, ignoreCase = true) }
                                },
                                label = { Text("Party / Account Name *") },
                                placeholder = { Text("Select or type name") },
                                supportingText = if (title.isBlank() && amountStr.isNotBlank()) {
                                    { Text("Party/Account name is required to save", color = MaterialTheme.colorScheme.error) }
                                } else null,
                                isError = title.isBlank() && amountStr.isNotBlank(),
                                modifier = Modifier.fillMaxWidth().menuAnchor(),
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = titleExpanded) },
                                shape = RoundedCornerShape(12.dp)
                            )
                            
                            val filteredParties = parties.filter { it.title.contains(title, ignoreCase = true) }
                            if (filteredParties.isNotEmpty()) {
                                ExposedDropdownMenu(
                                    expanded = titleExpanded,
                                    onDismissRequest = { titleExpanded = false }
                                ) {
                                    filteredParties.forEach { p ->
                                        DropdownMenuItem(
                                            text = { Text("${p.title} (₹${String.format("%.0f", p.currentValue)})") },
                                            onClick = {
                                                title = p.title
                                                selectedParty = p
                                                titleExpanded = false
                                            }
                                        )
                                    }
                                }
                            }
                        }

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
                            ExposedDropdownMenuBox(
                                expanded = accountExpanded,
                                onExpandedChange = { accountExpanded = !accountExpanded },
                                modifier = Modifier.weight(1f)
                            ) {
                                OutlinedTextField(
                                    value = accountName,
                                    onValueChange = { accountName = it },
                                    label = { Text("Primary Account") },
                                    placeholder = { Text("Select") },
                                    modifier = Modifier.fillMaxWidth().menuAnchor(),
                                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = accountExpanded) },
                                    shape = RoundedCornerShape(12.dp)
                                )
                                
                                val filteredAccounts = parties.filter { it.title.contains(accountName, ignoreCase = true) }
                                if (filteredAccounts.isNotEmpty()) {
                                    ExposedDropdownMenu(
                                        expanded = accountExpanded,
                                        onDismissRequest = { accountExpanded = false }
                                    ) {
                                        filteredAccounts.forEach { p ->
                                            DropdownMenuItem(
                                                text = { Text(p.title) },
                                                onClick = {
                                                    accountName = p.title
                                                    accountExpanded = false
                                                }
                                            )
                                        }
                                    }
                                }
                            }
                            
                            Spacer(modifier = Modifier.width(8.dp))
                            
                            ExposedDropdownMenuBox(
                                expanded = oppositeExpanded,
                                onExpandedChange = { oppositeExpanded = !oppositeExpanded },
                                modifier = Modifier.weight(1f)
                            ) {
                                OutlinedTextField(
                                    value = oppositeAccountName,
                                    onValueChange = { oppositeAccountName = it },
                                    label = { Text(if (entryType == "TRANSFER") "To Account" else "Payee / Source") },
                                    placeholder = { Text("Select") },
                                    modifier = Modifier.fillMaxWidth().menuAnchor(),
                                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = oppositeExpanded) },
                                    shape = RoundedCornerShape(12.dp)
                                )
                                
                                val filteredOpposite = parties.filter { it.title.contains(oppositeAccountName, ignoreCase = true) }
                                if (filteredOpposite.isNotEmpty()) {
                                    ExposedDropdownMenu(
                                        expanded = oppositeExpanded,
                                        onDismissRequest = { oppositeExpanded = false }
                                    ) {
                                        filteredOpposite.forEach { p ->
                                            DropdownMenuItem(
                                                text = { Text(p.title) },
                                                onClick = {
                                                    oppositeAccountName = p.title
                                                    oppositeExpanded = false
                                                }
                                            )
                                        }
                                    }
                                }
                            }
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

                        if (parties.isNotEmpty() && selectedParty != null) {
                            Spacer(modifier = Modifier.height(16.dp))
                            Text("Update Party Balance (ERP)", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = PrimaryGreen)
                            Text("How should this transaction affect ${selectedParty?.title}?", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                FilterChip(
                                    selected = adjustType == "Add to Party",
                                    onClick = { adjustType = "Add to Party" },
                                    label = { Text("Add / Debit Party") }
                                )
                                FilterChip(
                                    selected = adjustType == "Deduct from Party",
                                    onClick = { adjustType = "Deduct from Party" },
                                    label = { Text("Deduct / Credit Party") }
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
                        if (onSaveAndShare != null) {
                            Spacer(modifier = Modifier.width(6.dp))
                            OutlinedButton(
                                onClick = {
                                    keyboardController?.hide()
                                    focusManager.clearFocus()
                                    val amt = amountStr.toDoubleOrNull() ?: 0.0
                                    if (title.isNotBlank() && amt > 0) {
                                        val debit = if (entryType == "DEBIT" || entryType == "TRANSFER") amt else 0.0
                                        val credit = if (entryType == "CREDIT") amt else 0.0
                                        val entry = LedgerEntry(
                                            timestamp = System.currentTimeMillis(),
                                            transactionTitle = title.trim(),
                                            accountName = accountName.trim(),
                                            oppositeAccountName = if (selectedParty != null) selectedParty!!.title else oppositeAccountName.trim(),
                                            entryType = entryType,
                                            debitAmount = debit,
                                            creditAmount = credit,
                                            runningBalance = 0.0,
                                            category = category,
                                            notes = notes.trim()
                                        )
                                        val itemsToUpdate = mutableListOf<FinancialItem>()
                                        if (selectedParty != null) {
                                            val isAdd = adjustType == "Add to Party"
                                            val newBal = if (isAdd) selectedParty!!.currentValue + amt else selectedParty!!.currentValue - amt
                                            itemsToUpdate.add(selectedParty!!.copy(currentValue = newBal, updatedAt = System.currentTimeMillis()))
                                        }
                                        
                                        // Automatic ERP update for Primary and Opposite accounts
                                        val primaryAccount = parties.find { it.title.equals(accountName, ignoreCase = true) }
                                        if (primaryAccount != null && primaryAccount.id != selectedParty?.id) {
                                            val newBal = if (entryType == "DEBIT" || entryType == "TRANSFER") primaryAccount.currentValue - amt else primaryAccount.currentValue + amt
                                            itemsToUpdate.add(primaryAccount.copy(currentValue = newBal, updatedAt = System.currentTimeMillis()))
                                        }
                                        
                                        val oppAccount = parties.find { it.title.equals(oppositeAccountName, ignoreCase = true) }
                                        if (oppAccount != null && oppAccount.id != selectedParty?.id && oppAccount.id != primaryAccount?.id) {
                                            val newBal = if (entryType == "TRANSFER") oppAccount.currentValue + amt else oppAccount.currentValue
                                            if (entryType == "TRANSFER") {
                                                itemsToUpdate.add(oppAccount.copy(currentValue = newBal, updatedAt = System.currentTimeMillis()))
                                            }
                                        }
                                        
                                        onSaveAndShare(entry, itemsToUpdate)
                                    }
                                },
                                shape = RoundedCornerShape(12.dp),
                                enabled = canSave
                            ) {
                                Icon(Icons.Default.Share, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Save & Share")
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            onClick = {
                                keyboardController?.hide()
                                focusManager.clearFocus()
                                val amt = amountStr.toDoubleOrNull() ?: 0.0
                                if (title.isNotBlank() && amt > 0) {
                                    val debit = if (entryType == "DEBIT" || entryType == "TRANSFER") amt else 0.0
                                    val credit = if (entryType == "CREDIT") amt else 0.0
                                    val entry = LedgerEntry(
                                        timestamp = System.currentTimeMillis(),
                                        transactionTitle = title.trim(),
                                        accountName = accountName.trim(),
                                        oppositeAccountName = if (selectedParty != null) selectedParty!!.title else oppositeAccountName.trim(),
                                        entryType = entryType,
                                        debitAmount = debit,
                                        creditAmount = credit,
                                        runningBalance = 0.0,
                                        category = category,
                                        notes = notes.trim()
                                    )
                                    val itemsToUpdate = mutableListOf<FinancialItem>()
                                    if (selectedParty != null) {
                                        val isAdd = adjustType == "Add to Party"
                                        val newBal = if (isAdd) selectedParty!!.currentValue + amt else selectedParty!!.currentValue - amt
                                        itemsToUpdate.add(selectedParty!!.copy(currentValue = newBal, updatedAt = System.currentTimeMillis()))
                                    }
                                    
                                    // Automatic ERP update for Primary and Opposite accounts
                                    val primaryAccount = parties.find { it.title.equals(accountName, ignoreCase = true) }
                                    if (primaryAccount != null && primaryAccount.id != selectedParty?.id) {
                                        val newBal = if (entryType == "DEBIT" || entryType == "TRANSFER") primaryAccount.currentValue - amt else primaryAccount.currentValue + amt
                                        itemsToUpdate.add(primaryAccount.copy(currentValue = newBal, updatedAt = System.currentTimeMillis()))
                                    }
                                    
                                    val oppAccount = parties.find { it.title.equals(oppositeAccountName, ignoreCase = true) }
                                    if (oppAccount != null && oppAccount.id != selectedParty?.id && oppAccount.id != primaryAccount?.id) {
                                        val newBal = if (entryType == "TRANSFER") oppAccount.currentValue + amt else oppAccount.currentValue
                                        if (entryType == "TRANSFER") {
                                            itemsToUpdate.add(oppAccount.copy(currentValue = newBal, updatedAt = System.currentTimeMillis()))
                                        }
                                    }
                                    
                                    onSave(entry, itemsToUpdate)
                                }
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (entryType == "DEBIT") LiabilityRed else if (entryType == "CREDIT") AssetGreen else PrimaryGreen
                            ),
                            enabled = canSave
                        ) {
                            Text(
                                when (entryType) {
                                    "DEBIT" -> "Save Expense"
                                    "CREDIT" -> "Save Income"
                                    else -> "Save Transfer"
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
