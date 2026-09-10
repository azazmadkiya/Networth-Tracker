import re

with open('app/src/main/java/com/example/ui/components/AddLedgerEntryDialog.kt', 'r') as f:
    content = f.read()

# Replace the title OutlinedTextField with a Dropdown
target_title = """                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Description / Merchant *") },
                    placeholder = { Text("e.g. Grocery shopping, Client payment") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )"""

replacement_title = """                var titleExpanded by remember { mutableStateOf(false) }
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
                }"""

content = content.replace(target_title, replacement_title)

# Now, because the Party is selected at the top, we can hide the redundant Link to Party dropdown at the bottom, but keep the Add/Deduct chips.
target_bottom_link = """                    Text("Link to Party / Account (ERP)", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = PrimaryGreen)
                    Text("Select a party to automatically update their balance.", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    
                    if (true) {
                        Spacer(modifier = Modifier.height(12.dp))
                        ExposedDropdownMenuBox(
                            expanded = partyExpanded,
                            onExpandedChange = { partyExpanded = !partyExpanded }
                        ) {
                            OutlinedTextField(
                                value = selectedParty?.title ?: "Select Party",
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("Party Account") },
                                modifier = Modifier.fillMaxWidth().menuAnchor(),
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = partyExpanded) },
                                shape = RoundedCornerShape(12.dp)
                            )
                            ExposedDropdownMenu(
                                expanded = partyExpanded,
                                onDismissRequest = { partyExpanded = false }
                            ) {
                                parties.forEach { p ->
                                    DropdownMenuItem(
                                        text = { Text("${p.title} (₹${String.format("%.0f", p.currentValue)})") },
                                        onClick = {
                                            selectedParty = p
                                            partyExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                        
                        if (selectedParty != null) {"""

replacement_bottom = """                    if (selectedParty != null) {
                        Text("Update Party Balance (ERP)", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = PrimaryGreen)
                        Text("How should this transaction affect ${selectedParty?.title}?", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        """

content = content.replace(target_bottom_link, replacement_bottom)

with open('app/src/main/java/com/example/ui/components/AddLedgerEntryDialog.kt', 'w') as f:
    f.write(content)

