import re

with open('app/src/main/java/com/example/ui/components/AddEditItemDialog.kt', 'r') as f:
    content = f.read()

# 1. Add state variables at the top
content = content.replace(
    'var notes by remember { mutableStateOf(initialItem?.notes ?: "") }',
    'var notes by remember { mutableStateOf(initialItem?.notes ?: "") }\n    var oppositeAccountName by remember { mutableStateOf("") }\n    var oppositeExpanded by remember { mutableStateOf(false) }'
)

# 2. Replace the ERP UI block
target_ui = """                if (parties.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(16.dp))
                    if (selectedParty != null) {
                        Text("Update Party Balance (ERP)", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = PrimaryGreen)
                        Text("How should this item affect ${selectedParty?.title}?", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                FilterChip(
                                    selected = adjustType == "Add to this Item",
                                    onClick = { adjustType = "Add to this Item" },
                                    label = { Text("Add / Debit Party") }
                                )
                                FilterChip(
                                    selected = adjustType == "Deduct from this Item",
                                    onClick = { adjustType = "Deduct from this Item" },
                                    label = { Text("Deduct / Credit Party") }
                                )
                            }
                            
                            Spacer(modifier = Modifier.height(12.dp))
                            OutlinedTextField(
                                value = adjustAmountStr,
                                onValueChange = { adjustAmountStr = it },
                                label = { Text("Adjustment Amount (₹)") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(12.dp)
                            )
                        }
                    }
                }"""

replacement_ui = """                if (!isEditing && parties.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Opening Balance / Funding (ERP)", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = PrimaryGreen)
                    Text("Select an opposite account to automatically adjust its balance and record a ledger entry.", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    ExposedDropdownMenuBox(
                        expanded = oppositeExpanded,
                        onExpandedChange = { oppositeExpanded = !oppositeExpanded },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = oppositeAccountName,
                            onValueChange = { oppositeAccountName = it },
                            label = { Text("Opposite Account / Funding Source") },
                            placeholder = { Text("e.g. Bank, Cash (Optional)") },
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
                                        text = { Text("${p.title} (₹${String.format("%.0f", p.currentValue)})") },
                                        onClick = {
                                            oppositeAccountName = p.title
                                            oppositeExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                }"""

content = content.replace(target_ui, replacement_ui)

# 3. Replace the onSave block
target_save = """                                if (selectedParty != null) {
                                    val adjAmt = adjustAmountStr.toDoubleOrNull() ?: 0.0
                                    if (adjAmt > 0) {
                                        val isAdd = adjustType == "Add to this Item"
                                        finalCVal = if (isAdd) cVal + adjAmt else cVal - adjAmt
                                        
                                        val partyNewVal = if (isAdd) selectedParty!!.currentValue - adjAmt else selectedParty!!.currentValue + adjAmt
                                        updatedParty = selectedParty!!.copy(currentValue = partyNewVal, updatedAt = System.currentTimeMillis())
                                        
                                        ledgerEntry = com.example.data.model.LedgerEntry(
                                            transactionTitle = "Adjustment: ${title.trim()}",
                                            accountName = title.trim(),
                                            oppositeAccountName = selectedParty!!.title,
                                            entryType = if (isAdd) "DEBIT" else "CREDIT",
                                            debitAmount = if (isAdd) adjAmt else 0.0,
                                            creditAmount = if (!isAdd) adjAmt else 0.0,
                                            category = "Adjustment",
                                            timestamp = System.currentTimeMillis()
                                        )
                                    }
                                }"""

replacement_save = """                                val oppAccount = parties.find { it.title.equals(oppositeAccountName, ignoreCase = true) }
                                if (!isEditing && oppAccount != null && cVal > 0) {
                                    // If creating a new item with an initial balance and an opposite account is selected
                                    // e.g., creating a new Asset (cVal = 10k), opposite is Bank. Asset increases, Bank decreases.
                                    val isIncreasingAsset = !isLiability
                                    
                                    val newOppBal = if (isIncreasingAsset) {
                                        oppAccount.currentValue - cVal // Deduct from bank to buy asset
                                    } else {
                                        oppAccount.currentValue + cVal // Add to bank from loan
                                    }
                                    
                                    updatedParty = oppAccount.copy(currentValue = newOppBal, updatedAt = System.currentTimeMillis())
                                    
                                    ledgerEntry = com.example.data.model.LedgerEntry(
                                        transactionTitle = "Opening Balance: ${title.trim()}",
                                        accountName = title.trim(),
                                        oppositeAccountName = oppAccount.title,
                                        entryType = if (isIncreasingAsset) "DEBIT" else "CREDIT",
                                        debitAmount = if (isIncreasingAsset) cVal else 0.0,
                                        creditAmount = if (!isIncreasingAsset) cVal else 0.0,
                                        category = "Opening Balance",
                                        timestamp = System.currentTimeMillis()
                                    )
                                }"""

content = content.replace(target_save, replacement_save)

with open('app/src/main/java/com/example/ui/components/AddEditItemDialog.kt', 'w') as f:
    f.write(content)

