with open('app/src/main/java/com/example/ui/screens/AnalyticsScreen.kt', 'r') as f:
    content = f.read()

old = """        AddEditItemDialog(
            preselectedCategory = ItemCategory.SHARE_MARKET.displayName,
            onDismiss = { showAddStockDialog = false },
            onSave = { stockItem ->
                viewModel.saveFinancialItem(stockItem)
                showAddStockDialog = false
                Toast.makeText(context, "Saved stock ${stockItem.title}", Toast.LENGTH_SHORT).show()
            }
        )"""

new = """        val parties = filteredItems.filter { it.category in listOf("Sundry Creditors", "Sundry Debtors", "Loans & Dues", "Other Account") }
        AddEditItemDialog(
            preselectedCategory = ItemCategory.SHARE_MARKET.displayName,
            parties = parties,
            onDismiss = { showAddStockDialog = false },
            onSave = { stockItem, ledgerEntry, updatedParty ->
                viewModel.saveFinancialItem(stockItem)
                updatedParty?.let { viewModel.saveFinancialItem(it) }
                ledgerEntry?.let { viewModel.postDirectLedgerEntry(it) }
                showAddStockDialog = false
                Toast.makeText(context, "Saved stock ${stockItem.title}", Toast.LENGTH_SHORT).show()
            }
        )"""

content = content.replace(old, new)
with open('app/src/main/java/com/example/ui/screens/AnalyticsScreen.kt', 'w') as f:
    f.write(content)
