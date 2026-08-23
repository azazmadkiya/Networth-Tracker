package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Refresh
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.model.FinancialItem
import com.example.ui.components.AddEditItemDialog
import com.example.ui.screens.AnalyticsScreen
import com.example.ui.screens.AssetsListScreen
import com.example.ui.screens.DashboardScreen
import com.example.ui.screens.LedgerScreen
import com.example.ui.screens.LoginScreen
import com.example.ui.screens.SettingsScreen
import com.example.ui.screens.SplashScreen
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.viewmodel.NetWorthViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: NetWorthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainAppContent(viewModel = viewModel)
            }
        }
    }
}

enum class NavTab(val title: String) {
    DASHBOARD("Dashboard"),
    ASSETS("Assets"),
    LEDGER("Ledger"),
    ANALYTICS("Analytics"),
    SETTINGS("Settings")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppContent(viewModel: NetWorthViewModel) {
    var showSplash by remember { mutableStateOf(true) }
    val isLoggedIn by viewModel.isLoggedIn.collectAsStateWithLifecycle()
    val allItems by viewModel.allItems.collectAsStateWithLifecycle()
    var currentTab by remember { mutableStateOf(NavTab.DASHBOARD) }

    var showAddEditDialog by remember { mutableStateOf(false) }
    var itemToEdit by remember { mutableStateOf<FinancialItem?>(null) }

    if (showSplash) {
        SplashScreen(
            onSplashFinished = {
                showSplash = false
            }
        )
    } else if (!isLoggedIn) {
        LoginScreen(
            onLoginSuccess = { idInput, passInput ->
                viewModel.login(idInput, passInput)
            }
        )
    } else {
        val context = LocalContext.current
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Net Worth Vault",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    },
                    actions = {
                        // Re Fresh Option to Recalculate & Adjust Live Balances
                        IconButton(
                            onClick = {
                                viewModel.refreshAndRecalculateAll()
                                Toast.makeText(context, "🔄 Refreshed & Recalculated Balances", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.testTag("top_bar_refresh_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Re Fresh & Adjust Balances",
                                tint = Color(0xFF60A5FA)
                            )
                        }

                        IconButton(
                            onClick = { viewModel.logout() },
                            modifier = Modifier.testTag("top_bar_lock_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Lock Vault",
                                tint = Color(0xFF34D399)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF0F172A) // Dark Navy
                    )
                )
            },
            bottomBar = {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer,
                    modifier = Modifier.testTag("bottom_navigation_bar")
                ) {
                    NavigationBarItem(
                        selected = currentTab == NavTab.DASHBOARD,
                        onClick = { currentTab = NavTab.DASHBOARD },
                        icon = { Icon(Icons.Default.PieChart, contentDescription = "Dashboard") },
                        label = {
                            Text(
                                text = "Dashboard",
                                maxLines = 1,
                                softWrap = false,
                                fontSize = 11.sp,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        modifier = Modifier.testTag("nav_tab_dashboard")
                    )

                    NavigationBarItem(
                        selected = currentTab == NavTab.ASSETS,
                        onClick = { currentTab = NavTab.ASSETS },
                        icon = { Icon(Icons.Default.AccountBalance, contentDescription = "Assets") },
                        label = {
                            Text(
                                text = "Assets",
                                maxLines = 1,
                                softWrap = false,
                                fontSize = 11.sp,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        modifier = Modifier.testTag("nav_tab_assets")
                    )

                    NavigationBarItem(
                        selected = currentTab == NavTab.LEDGER,
                        onClick = { currentTab = NavTab.LEDGER },
                        icon = { Icon(Icons.Default.ReceiptLong, contentDescription = "Ledger") },
                        label = {
                            Text(
                                text = "Ledger",
                                maxLines = 1,
                                softWrap = false,
                                fontSize = 11.sp,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        modifier = Modifier.testTag("nav_tab_ledger")
                    )

                    NavigationBarItem(
                        selected = currentTab == NavTab.ANALYTICS,
                        onClick = { currentTab = NavTab.ANALYTICS },
                        icon = { Icon(Icons.Default.ShowChart, contentDescription = "Analytics") },
                        label = {
                            Text(
                                text = "Analytics",
                                maxLines = 1,
                                softWrap = false,
                                fontSize = 11.sp,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        modifier = Modifier.testTag("nav_tab_analytics")
                    )

                    NavigationBarItem(
                        selected = currentTab == NavTab.SETTINGS,
                        onClick = { currentTab = NavTab.SETTINGS },
                        icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                        label = {
                            Text(
                                text = "Settings",
                                maxLines = 1,
                                softWrap = false,
                                fontSize = 11.sp,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        modifier = Modifier.testTag("nav_tab_settings")
                    )
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                when (currentTab) {
                    NavTab.DASHBOARD -> {
                        DashboardScreen(
                            viewModel = viewModel,
                            onAddNewItem = {
                                itemToEdit = null
                                showAddEditDialog = true
                            },
                            onNavigateToAssets = {
                                currentTab = NavTab.ASSETS
                            },
                            onEditItem = { item ->
                                itemToEdit = item
                                showAddEditDialog = true
                            }
                        )
                    }

                    NavTab.ASSETS -> {
                        AssetsListScreen(
                            viewModel = viewModel,
                            onAddNewItem = {
                                itemToEdit = null
                                showAddEditDialog = true
                            },
                            onEditItem = { item ->
                                itemToEdit = item
                                showAddEditDialog = true
                            }
                        )
                    }

                    NavTab.LEDGER -> {
                        LedgerScreen(
                            viewModel = viewModel,
                            onAddNewExpense = {
                                itemToEdit = null
                                showAddEditDialog = true
                            }
                        )
                    }

                    NavTab.ANALYTICS -> {
                        AnalyticsScreen(viewModel = viewModel)
                    }

                    NavTab.SETTINGS -> {
                        SettingsScreen(viewModel = viewModel)
                    }
                }
            }
        }

        // Add / Edit Item Dialog
        if (showAddEditDialog) {
            AddEditItemDialog(
                itemToEdit = itemToEdit,
                existingAssetAccounts = allItems.filter { !it.isLiability },
                onDismiss = {
                    showAddEditDialog = false
                    itemToEdit = null
                },
                onSave = { newItem ->
                    viewModel.saveFinancialItem(newItem)
                    showAddEditDialog = false
                    itemToEdit = null
                }
            )
        }
    }
}
