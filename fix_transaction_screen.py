with open('app/src/main/java/com/example/ui/screens/TransactionScreen.kt', 'r') as f:
    content = f.read()

content = content.replace(
    'onSave = { item, ledgerEntry, updatedParty ->\n                viewModel.saveFinancialItem(item)\n                updatedParties.forEach { viewModel.saveFinancialItem(it) }',
    'onSave = { item, ledgerEntry, updatedParty ->\n                viewModel.saveFinancialItem(item)\n                updatedParty?.let { viewModel.saveFinancialItem(it) }'
)

with open('app/src/main/java/com/example/ui/screens/TransactionScreen.kt', 'w') as f:
    f.write(content)
