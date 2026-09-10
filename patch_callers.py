import re

# LedgerScreen
with open('app/src/main/java/com/example/ui/screens/LedgerScreen.kt', 'r') as f:
    content = f.read()

content = content.replace('onSave = { entry, updatedParty ->', 'onSave = { entry, updatedParties ->')
content = content.replace('updatedParty?.let { viewModel.saveFinancialItem(it) }', 'updatedParties.forEach { viewModel.saveFinancialItem(it) }')
content = content.replace('onSaveAndShare = { entry, updatedParty ->', 'onSaveAndShare = { entry, updatedParties ->')

with open('app/src/main/java/com/example/ui/screens/LedgerScreen.kt', 'w') as f:
    f.write(content)

# TransactionScreen
with open('app/src/main/java/com/example/ui/screens/TransactionScreen.kt', 'r') as f:
    content = f.read()

content = content.replace('onSave = { entry, updatedParty ->', 'onSave = { entry, updatedParties ->')
content = content.replace('updatedParty?.let { viewModel.saveFinancialItem(it) }', 'updatedParties.forEach { viewModel.saveFinancialItem(it) }')

with open('app/src/main/java/com/example/ui/screens/TransactionScreen.kt', 'w') as f:
    f.write(content)

