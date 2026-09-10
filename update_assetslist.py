with open('app/src/main/java/com/example/ui/screens/AssetsListScreen.kt', 'r') as f:
    content = f.read()

old = """        AddEditItemDialog(
            initialItem = editingItem,
            onDismiss = {
                showAddDialog = false
                editingItem = null
            },
            onSave = { savedItem ->
                viewModel.saveFinancialItem(savedItem)
                showAddDialog = false
                editingItem = null
                Toast.makeText(context, "Saved ${savedItem.title}", Toast.LENGTH_SHORT).show()
            }
        )"""

new = """        val parties = items.filter { it.category in listOf("Sundry Creditors", "Sundry Debtors", "Loans & Dues", "Other Account") }
        AddEditItemDialog(
            initialItem = editingItem,
            parties = parties,
            onDismiss = {
                showAddDialog = false
                editingItem = null
            },
            onSave = { savedItem, ledgerEntry, updatedParty ->
                viewModel.saveFinancialItem(savedItem)
                updatedParty?.let { viewModel.saveFinancialItem(it) }
                ledgerEntry?.let { viewModel.postDirectLedgerEntry(it) }
                showAddDialog = false
                editingItem = null
                Toast.makeText(context, "Saved ${savedItem.title}", Toast.LENGTH_SHORT).show()
            }
        )"""

content = content.replace(old, new)
with open('app/src/main/java/com/example/ui/screens/AssetsListScreen.kt', 'w') as f:
    f.write(content)
