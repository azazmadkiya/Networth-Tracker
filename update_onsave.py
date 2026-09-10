with open('app/src/main/java/com/example/ui/components/AddEditItemDialog.kt', 'r') as f:
    content = f.read()

old_logic = """                                val item = FinancialItem(
                                    id = initialItem?.id ?: 0L,
                                    title = title.trim(),
                                    institution = institution.trim(),
                                    accountNumber = accountNumber.trim(),
                                    owner = selectedOwner,
                                    category = selectedCategory,
                                    currentValue = cVal,
                                    investedValue = iVal,
                                    isLiability = isLiability,
                                    notes = notes.trim(),
                                    updatedAt = System.currentTimeMillis()
                                )
                                onSave(item)"""

new_logic = """                                var finalCVal = cVal
                                var ledgerEntry: com.example.data.model.LedgerEntry? = null
                                var updatedParty: FinancialItem? = null
                                
                                if (enablePartyLink && selectedParty != null) {
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
                                }

                                val item = FinancialItem(
                                    id = initialItem?.id ?: 0L,
                                    title = title.trim(),
                                    institution = institution.trim(),
                                    accountNumber = accountNumber.trim(),
                                    owner = selectedOwner,
                                    category = selectedCategory,
                                    currentValue = finalCVal,
                                    investedValue = iVal,
                                    isLiability = isLiability,
                                    notes = notes.trim(),
                                    updatedAt = System.currentTimeMillis()
                                )
                                onSave(item, ledgerEntry, updatedParty)"""

content = content.replace(old_logic, new_logic)

with open('app/src/main/java/com/example/ui/components/AddEditItemDialog.kt', 'w') as f:
    f.write(content)
