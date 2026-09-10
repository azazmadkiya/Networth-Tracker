import sys

with open('app/src/main/java/com/example/ui/components/AddLedgerEntryDialog.kt', 'r') as f:
    content = f.read()

# Update onSaveAndShare
old_share = """                                    val entry = LedgerEntry(
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
                                    onSaveAndShare(entry)"""
new_share = """                                    val entry = LedgerEntry(
                                        timestamp = System.currentTimeMillis(),
                                        transactionTitle = title.trim(),
                                        accountName = accountName.trim(),
                                        oppositeAccountName = if (enablePartyLink && selectedParty != null) selectedParty!!.title else oppositeAccountName.trim(),
                                        entryType = entryType,
                                        debitAmount = debit,
                                        creditAmount = credit,
                                        runningBalance = 0.0,
                                        category = category,
                                        notes = notes.trim()
                                    )
                                    var updatedParty: FinancialItem? = null
                                    if (enablePartyLink && selectedParty != null) {
                                        val isAdd = adjustType == "Add to Party"
                                        val newBal = if (isAdd) selectedParty!!.currentValue + amt else selectedParty!!.currentValue - amt
                                        updatedParty = selectedParty!!.copy(currentValue = newBal, updatedAt = System.currentTimeMillis())
                                    }
                                    onSaveAndShare(entry, updatedParty)"""

# Update onSave
old_save = """                                val entry = LedgerEntry(
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
                                onSave(entry)"""
new_save = """                                val entry = LedgerEntry(
                                    timestamp = System.currentTimeMillis(),
                                    transactionTitle = title.trim(),
                                    accountName = accountName.trim(),
                                    oppositeAccountName = if (enablePartyLink && selectedParty != null) selectedParty!!.title else oppositeAccountName.trim(),
                                    entryType = entryType,
                                    debitAmount = debit,
                                    creditAmount = credit,
                                    runningBalance = 0.0,
                                    category = category,
                                    notes = notes.trim()
                                )
                                var updatedParty: FinancialItem? = null
                                if (enablePartyLink && selectedParty != null) {
                                    val isAdd = adjustType == "Add to Party"
                                    val newBal = if (isAdd) selectedParty!!.currentValue + amt else selectedParty!!.currentValue - amt
                                    updatedParty = selectedParty!!.copy(currentValue = newBal, updatedAt = System.currentTimeMillis())
                                }
                                onSave(entry, updatedParty)"""

content = content.replace(old_share, new_share)
content = content.replace(old_save, new_save)

with open('app/src/main/java/com/example/ui/components/AddLedgerEntryDialog.kt', 'w') as f:
    f.write(content)
