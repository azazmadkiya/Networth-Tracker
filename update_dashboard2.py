with open('app/src/main/java/com/example/ui/screens/DashboardScreen.kt', 'r') as f:
    content = f.read()

old = """        AddEditItemDialog(
            initialItem = editingItem,
            onDismiss = {
                showAddItemDialog = false
                editingItem = null
            },
            onSave = { item ->
                viewModel.saveFinancialItem(item)
                showAddItemDialog = false
                editingItem = null
                Toast.makeText(context, "Saved ${item.title}", Toast.LENGTH_SHORT).show()
            }
        )"""

new = """        val parties = filteredItems.filter { it.category in listOf("Sundry Creditors", "Sundry Debtors", "Loans & Dues", "Other Account") }
        AddEditItemDialog(
            initialItem = editingItem,
            parties = parties,
            onDismiss = {
                showAddItemDialog = false
                editingItem = null
            },
            onSave = { item, ledgerEntry, updatedParty ->
                viewModel.saveFinancialItem(item)
                updatedParty?.let { viewModel.saveFinancialItem(it) }
                ledgerEntry?.let { viewModel.postDirectLedgerEntry(it) }
                showAddItemDialog = false
                editingItem = null
                Toast.makeText(context, "Saved ${item.title}", Toast.LENGTH_SHORT).show()
            }
        )"""

content = content.replace(old, new)
with open('app/src/main/java/com/example/ui/screens/DashboardScreen.kt', 'w') as f:
    f.write(content)
