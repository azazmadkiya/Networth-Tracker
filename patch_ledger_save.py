import re

with open('app/src/main/java/com/example/ui/components/AddLedgerEntryDialog.kt', 'r') as f:
    content = f.read()

# Change onSave signature to accept List<FinancialItem>
content = content.replace(
    'onSave: (LedgerEntry, FinancialItem?) -> Unit,',
    'onSave: (LedgerEntry, List<FinancialItem>) -> Unit,'
)
content = content.replace(
    'onSaveAndShare: ((LedgerEntry, FinancialItem?) -> Unit)? = null',
    'onSaveAndShare: ((LedgerEntry, List<FinancialItem>) -> Unit)? = null'
)

# Update the save block
target_save = """                                    var updatedParty: FinancialItem? = null
                                    if (selectedParty != null) {
                                        val isAdd = adjustType == "Add to Party"
                                        val newBal = if (isAdd) selectedParty!!.currentValue + amt else selectedParty!!.currentValue - amt
                                        updatedParty = selectedParty!!.copy(currentValue = newBal, updatedAt = System.currentTimeMillis())
                                    }
                                    onSaveAndShare(entry, updatedParty)"""

replacement_save = """                                    val itemsToUpdate = mutableListOf<FinancialItem>()
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
                                        // For DEBIT/CREDIT we leave opposite account update to selectedParty if they match, else we might not know if it adds or subtracts. 
                                        // But if it's a Transfer, we always add to the To Account.
                                        if (entryType == "TRANSFER") {
                                            itemsToUpdate.add(oppAccount.copy(currentValue = newBal, updatedAt = System.currentTimeMillis()))
                                        }
                                    }
                                    
                                    onSaveAndShare(entry, itemsToUpdate)"""

content = content.replace(target_save, replacement_save)

target_save2 = """                                var updatedParty: FinancialItem? = null
                                if (selectedParty != null) {
                                    val isAdd = adjustType == "Add to Party"
                                    val newBal = if (isAdd) selectedParty!!.currentValue + amt else selectedParty!!.currentValue - amt
                                    updatedParty = selectedParty!!.copy(currentValue = newBal, updatedAt = System.currentTimeMillis())
                                }
                                onSave(entry, updatedParty)"""

replacement_save2 = """                                val itemsToUpdate = mutableListOf<FinancialItem>()
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
                                
                                onSave(entry, itemsToUpdate)"""

content = content.replace(target_save2, replacement_save2)

with open('app/src/main/java/com/example/ui/components/AddLedgerEntryDialog.kt', 'w') as f:
    f.write(content)

