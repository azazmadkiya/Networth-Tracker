import os
import glob

def patch_file(filepath):
    with open(filepath, 'r') as f:
        content = f.read()

    # Replace specific filters with full items list
    # AssetsListScreen
    content = content.replace('val parties = items.filter { it.category in listOf("Sundry Creditors", "Sundry Debtors", "Loans & Dues", "Other Account") }', 'val parties = items')
    # AnalyticsScreen
    content = content.replace('val parties = allItems.filter { it.category in listOf("Sundry Creditors", "Sundry Debtors", "Loans & Dues", "Other Account") }', 'val parties = allItems')
    # DashboardScreen
    content = content.replace('val parties = filteredItems.filter { it.category in listOf("Sundry Creditors", "Sundry Debtors", "Loans & Dues", "Other Account") }', 'val parties = filteredItems')
    # LedgerScreen
    # LedgerScreen line 86 AddLedgerEntryDialog(parties = partyList) -> Wait, partyList is defined somewhere in LedgerScreen
    
    with open(filepath, 'w') as f:
        f.write(content)

for filepath in glob.glob('app/src/main/java/com/example/ui/screens/*.kt'):
    patch_file(filepath)

