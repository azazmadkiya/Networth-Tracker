package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*

import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.SyncAlt
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.NavTab
import com.example.ui.theme.PrimaryGreen

@Composable
fun AppDrawer(
    currentTab: NavTab,
    onTabSelected: (NavTab) -> Unit,
    onCloseDrawer: () -> Unit
) {
    ModalDrawerSheet(
        modifier = Modifier.width(300.dp),
        drawerContainerColor = MaterialTheme.colorScheme.surface
    ) {
        Spacer(Modifier.height(24.dp))
        
        // Drawer Header
        Row(
            modifier = Modifier.padding(horizontal = 28.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(PrimaryGreen.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Text("NW", style = MaterialTheme.typography.titleMedium, color = PrimaryGreen, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Net Worth",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        
        // Drawer Items
        NavTab.entries.forEach { tab ->
            val isSelected = currentTab == tab
            NavigationDrawerItem(
                icon = { 
                    val icon = getIconForTab(tab)
                    Icon(icon, contentDescription = null) 
                },
                label = { Text(tab.title, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal) },
                selected = isSelected,
                onClick = {
                    onTabSelected(tab)
                    onCloseDrawer()
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                colors = NavigationDrawerItemDefaults.colors(
                    selectedContainerColor = PrimaryGreen.copy(alpha = 0.1f),
                    selectedIconColor = PrimaryGreen,
                    selectedTextColor = PrimaryGreen,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }
    }
}

fun getIconForTab(tab: NavTab): androidx.compose.ui.graphics.vector.ImageVector {
    return when (tab) {
        NavTab.DASHBOARD -> androidx.compose.material.icons.Icons.Default.Dashboard
        NavTab.PARTIES -> androidx.compose.material.icons.Icons.Default.Group
        NavTab.TRANSACTIONS -> androidx.compose.material.icons.Icons.Default.SyncAlt
        NavTab.ASSETS -> androidx.compose.material.icons.Icons.Default.AccountBalance
        NavTab.LEDGER -> androidx.compose.material.icons.Icons.Default.ReceiptLong
        NavTab.ANALYTICS -> androidx.compose.material.icons.Icons.Default.BarChart
        NavTab.REMINDERS -> androidx.compose.material.icons.Icons.Default.Notifications
        NavTab.SETTINGS -> androidx.compose.material.icons.Icons.Default.Settings
    }
}
