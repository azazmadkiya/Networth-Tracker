import sys

with open('app/src/main/java/com/example/ui/screens/LedgerScreen.kt', 'r') as f:
    content = f.read()

old_usage = """        AddLedgerEntryDialog(
            onDismiss = { showAddDialog = false },
            onSave = { entry ->
                viewModel.postDirectLedgerEntry(entry)
                showAddDialog = false
                Toast.makeText(context, "Transaction recorded", Toast.LENGTH_SHORT).show()
            },
            onSaveAndShare = { entry ->
                viewModel.postDirectLedgerEntry(entry)
                showAddDialog = false
                entryToShare = entry
            }
        )"""
new_usage = """        val partyList = items.filter { it.category in listOf("Sundry Creditors", "Sundry Debtors", "Loans & Dues", "Other Account") }
        AddLedgerEntryDialog(
            parties = partyList,
            onDismiss = { showAddDialog = false },
            onSave = { entry, updatedParty ->
                viewModel.postDirectLedgerEntry(entry)
                updatedParty?.let { viewModel.saveFinancialItem(it) }
                showAddDialog = false
                Toast.makeText(context, "Transaction recorded", Toast.LENGTH_SHORT).show()
            },
            onSaveAndShare = { entry, updatedParty ->
                viewModel.postDirectLedgerEntry(entry)
                updatedParty?.let { viewModel.saveFinancialItem(it) }
                showAddDialog = false
                entryToShare = entry
            }
        )"""

content = content.replace(old_usage, new_usage)

with open('app/src/main/java/com/example/ui/screens/LedgerScreen.kt', 'w') as f:
    f.write(content)
