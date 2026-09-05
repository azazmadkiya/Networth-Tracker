package com.example

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.screens.AboutAppScreen
import com.example.ui.screens.AnalyticsScreen
import com.example.ui.screens.AssetsListScreen
import com.example.ui.screens.DashboardScreen
import com.example.ui.screens.DataSafetyScreen
import com.example.ui.screens.LedgerScreen
import com.example.ui.screens.LoginScreen
import com.example.ui.screens.OpenSourceLicensesScreen
import com.example.ui.screens.PlayComplianceScreen
import com.example.ui.screens.PrivacyPolicyScreen
import com.example.ui.screens.RemindersScreen
import com.example.ui.screens.SettingsScreen
import com.example.ui.screens.SettingsSubScreen
import com.example.ui.screens.SplashScreen
import com.example.ui.screens.TermsOfServiceScreen
import com.example.data.notification.NotificationHelper
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.PrimaryGreen
import com.example.ui.viewmodel.NetWorthViewModel

class MainActivity : FragmentActivity() {
    private val viewModel: NetWorthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        NotificationHelper.initNotificationChannel(this)

        setContent {
            MyApplicationTheme {
                MainAppContent(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun MainAppContent(viewModel: NetWorthViewModel) {
    var showSplash by remember { mutableStateOf(true) }
    val isLoggedIn by viewModel.isLoggedIn.collectAsState()
    var currentTab by remember { mutableStateOf(NavTab.DASHBOARD) }
    var currentSubScreen by remember { mutableStateOf<SettingsSubScreen?>(null) }

    when {
        showSplash -> {
            SplashScreen(onSplashFinished = { showSplash = false })
        }
        !isLoggedIn -> {
            LoginScreen(
                authManager = viewModel.authManager,
                onLoginSuccess = { viewModel.setLoggedIn(true) }
            )
        }
        currentSubScreen != null -> {
            BackHandler {
                currentSubScreen = null
            }
            when (currentSubScreen) {
                SettingsSubScreen.REMINDERS -> RemindersScreen(viewModel = viewModel)
                SettingsSubScreen.PRIVACY_POLICY -> PrivacyPolicyScreen(onNavigateBack = { currentSubScreen = null })
                SettingsSubScreen.TERMS_OF_SERVICE -> TermsOfServiceScreen(onNavigateBack = { currentSubScreen = null })
                SettingsSubScreen.DATA_SAFETY -> DataSafetyScreen(onNavigateBack = { currentSubScreen = null })
                SettingsSubScreen.PLAY_COMPLIANCE -> PlayComplianceScreen(onNavigateBack = { currentSubScreen = null })
                SettingsSubScreen.OPEN_SOURCE_LICENSES -> OpenSourceLicensesScreen(onNavigateBack = { currentSubScreen = null })
                SettingsSubScreen.ABOUT -> AboutAppScreen(
                    onNavigateBack = { currentSubScreen = null },
                    onOpenLicenses = { currentSubScreen = SettingsSubScreen.OPEN_SOURCE_LICENSES }
                )
                null -> {}
            }
        }
        else -> {
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
                ) {
                    when (currentTab) {
                        NavTab.DASHBOARD -> DashboardScreen(
                            viewModel = viewModel,
                            onNavigateToTab = { destination ->
                                when (destination) {
                                    "Assets" -> currentTab = NavTab.ASSETS
                                    "Ledger" -> currentTab = NavTab.LEDGER
                                    "Reminders", "Reminder" -> currentTab = NavTab.REMINDERS
                                    "Analytics", "Analytic" -> currentTab = NavTab.ANALYTICS
                                    "Settings", "Setting" -> currentTab = NavTab.SETTINGS
                                    else -> currentTab = NavTab.DASHBOARD
                                }
                            }
                        )
                        NavTab.ASSETS -> AssetsListScreen(viewModel = viewModel)
                        NavTab.LEDGER -> LedgerScreen(viewModel = viewModel)
                        NavTab.ANALYTICS -> AnalyticsScreen(viewModel = viewModel)
                        NavTab.REMINDERS -> RemindersScreen(viewModel = viewModel)
                        NavTab.SETTINGS -> SettingsScreen(
                            viewModel = viewModel,
                            onNavigateToSubScreen = { sub ->
                                if (sub == SettingsSubScreen.REMINDERS) {
                                    currentTab = NavTab.REMINDERS
                                } else {
                                    currentSubScreen = sub
                                }
                            },
                            onLogout = { currentTab = NavTab.DASHBOARD }
                        )
                    }
                }
            }
        }
    }
}
