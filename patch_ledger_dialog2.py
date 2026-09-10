import re

with open('app/src/main/java/com/example/ui/components/AddLedgerEntryDialog.kt', 'r') as f:
    content = f.read()

# Add states for expanded dropdowns at the top
content = content.replace(
    'var oppositeAccountName by remember { mutableStateOf("") }',
    'var oppositeAccountName by remember { mutableStateOf("") }\n    var accountExpanded by remember { mutableStateOf(false) }\n    var oppositeExpanded by remember { mutableStateOf(false) }'
)

# Replace the text fields with dropdowns
target = """                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = accountName,
                        onValueChange = { accountName = it },
                        label = { Text("From / Primary Account") },
                        placeholder = { Text("e.g. Bank, Cash") },
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
                }"""

replacement = """                Row(modifier = Modifier.fillMaxWidth()) {
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
                }"""

content = content.replace(target, replacement)

with open('app/src/main/java/com/example/ui/components/AddLedgerEntryDialog.kt', 'w') as f:
    f.write(content)

