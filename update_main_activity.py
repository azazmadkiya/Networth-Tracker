with open('app/src/main/java/com/example/MainActivity.kt', 'r') as f:
    content = f.read()

# 1. Add icon for TRANSACTIONS
old_icons = """                                val tabIcon = when (tab) {
                                    NavTab.DASHBOARD -> Icons.Default.Dashboard
                                    NavTab.PARTIES -> Icons.Default.Group
                                    NavTab.ASSETS -> Icons.Default.AccountBalance
                                    NavTab.LEDGER -> Icons.Default.ReceiptLong
                                    NavTab.ANALYTICS -> Icons.Default.BarChart
                                    NavTab.REMINDERS -> Icons.Default.Notifications
                                    NavTab.SETTINGS -> Icons.Default.Settings
                                }"""
new_icons = """                                val tabIcon = when (tab) {
                                    NavTab.DASHBOARD -> Icons.Default.Dashboard
                                    NavTab.PARTIES -> Icons.Default.Group
                                    NavTab.TRANSACTIONS -> Icons.Default.SyncAlt
                                    NavTab.ASSETS -> Icons.Default.AccountBalance
                                    NavTab.LEDGER -> Icons.Default.ReceiptLong
                                    NavTab.ANALYTICS -> Icons.Default.BarChart
                                    NavTab.REMINDERS -> Icons.Default.Notifications
                                    NavTab.SETTINGS -> Icons.Default.Settings
                                }"""
content = content.replace(old_icons, new_icons)

# 2. Add screen for TRANSACTIONS
old_screens = """                        when (currentTab) {
                            NavTab.DASHBOARD -> DashboardScreen("""
new_screens = """                        when (currentTab) {
                            NavTab.TRANSACTIONS -> com.example.ui.screens.TransactionScreen(viewModel = viewModel)
                            NavTab.DASHBOARD -> DashboardScreen("""
content = content.replace(old_screens, new_screens)

# 3. Add import for SyncAlt
content = content.replace("import androidx.compose.material.icons.filled.Settings", "import androidx.compose.material.icons.filled.Settings\nimport androidx.compose.material.icons.filled.SyncAlt")

with open('app/src/main/java/com/example/MainActivity.kt', 'w') as f:
    f.write(content)
