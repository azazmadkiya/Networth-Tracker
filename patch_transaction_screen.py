with open('app/src/main/java/com/example/ui/screens/TransactionScreen.kt', 'r') as f:
    content = f.read()

# Instead of passing partyList to AddLedgerEntryDialog and AddEditItemDialog, pass ALL items (excluding maybe negative items if any, but `items` is fine).
content = content.replace('parties = partyList,', 'parties = items,')

with open('app/src/main/java/com/example/ui/screens/TransactionScreen.kt', 'w') as f:
    f.write(content)
