with open('app/src/main/java/com/example/ui/screens/AnalyticsScreen.kt', 'r') as f:
    content = f.read()

content = content.replace('    val snapshots by viewModel.snapshots.collectAsState()', '    val snapshots by viewModel.snapshots.collectAsState()\n    val allItems by viewModel.liveItems.collectAsState()')
content = content.replace('        val parties = filteredItems.filter', '        val parties = allItems.filter')

with open('app/src/main/java/com/example/ui/screens/AnalyticsScreen.kt', 'w') as f:
    f.write(content)
