import re

with open('app/src/main/java/com/example/MainActivity.kt', 'r') as f:
    content = f.read()

# I want to inject imports in MainActivity.kt
imports_to_add = """
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import kotlinx.coroutines.launch
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import com.example.ui.components.AppDrawer
"""
content = content.replace("import androidx.compose.material3.NavigationBarItemDefaults", "import androidx.compose.material3.NavigationBarItemDefaults\n" + imports_to_add)

# I need to add @OptIn(ExperimentalMaterial3Api::class) to MainAppContent if it isn't there
if "@OptIn(ExperimentalMaterial3Api::class)" not in content and "fun MainAppContent" in content:
    content = content.replace("@Composable\nfun MainAppContent", "@OptIn(ExperimentalMaterial3Api::class)\n@Composable\nfun MainAppContent")

# Replace Scaffold part
old_scaffold = """            } else {
                Scaffold(
                    contentWindowInsets = WindowInsets.statusBars,
                    bottomBar = {
                        NavigationBar(
                            windowInsets = WindowInsets.navigationBars,
                            containerColor = MaterialTheme.colorScheme.surface,
                            tonalElevation = 3.dp
                        ) {
                            NavTab.entries.forEach { tab ->
                                val isSelected = currentTab == tab
                                val tabIcon = when (tab) {
                                    NavTab.DASHBOARD -> Icons.Default.Dashboard
                                    NavTab.PARTIES -> Icons.Default.Group
                                    NavTab.TRANSACTIONS -> Icons.Default.SyncAlt
                                    NavTab.ASSETS -> Icons.Default.AccountBalance
                                    NavTab.LEDGER -> Icons.Default.ReceiptLong
                                    NavTab.ANALYTICS -> Icons.Default.BarChart
                                    NavTab.REMINDERS -> Icons.Default.Notifications
                                    NavTab.SETTINGS -> Icons.Default.Settings
                                }
                                NavigationBarItem(
                                    selected = isSelected,
                                    onClick = {
                                        currentSubScreen = null
                                        currentTab = tab
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = tabIcon,
                                            contentDescription = tab.title,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    },
                                    label = {
                                        Text(
                                            text = tab.title,
                                            maxLines = 1,
                                            softWrap = false,
                                            overflow = TextOverflow.Ellipsis,
                                            style = MaterialTheme.typography.labelSmall.copy(
                                                fontSize = 10.sp,
                                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                                letterSpacing = (-0.3).sp
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    },
                                    alwaysShowLabel = true,
                                    colors = NavigationBarItemDefaults.colors(
                                        indicatorColor = PrimaryGreen.copy(alpha = 0.18f),
                                        selectedIconColor = PrimaryGreen,
                                        selectedTextColor = PrimaryGreen,
                                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.75f),
                                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.75f)
                                    )
                                )
                            }
                        }
                    }
                ) { padding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {"""

new_scaffold = """            } else {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        AppDrawer(
                            currentTab = currentTab,
                            onTabSelected = { 
                                currentSubScreen = null
                                currentTab = it 
                            },
                            onCloseDrawer = { scope.launch { drawerState.close() } }
                        )
                    }
                ) {
                    Scaffold(
                        contentWindowInsets = WindowInsets.statusBars,
                        topBar = {
                            TopAppBar(
                                title = { Text(currentTab.title, style = MaterialTheme.typography.titleMedium) },
                                navigationIcon = {
                                    IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                                    }
                                },
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.surface,
                                    titleContentColor = MaterialTheme.colorScheme.onSurface
                                )
                            )
                        }
                    ) { padding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding)
                        ) {"""
content = content.replace(old_scaffold, new_scaffold)
# Need to add coroutine scope import
content = content.replace("import androidx.compose.runtime.remember", "import androidx.compose.runtime.remember\nimport androidx.compose.runtime.rememberCoroutineScope")

with open('app/src/main/java/com/example/MainActivity.kt', 'w') as f:
    f.write(content)

