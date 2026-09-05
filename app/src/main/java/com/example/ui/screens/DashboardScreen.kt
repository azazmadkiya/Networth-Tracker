package com.example.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.TrendingDown
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.FinancialItem
import com.example.data.model.LedgerEntry
import com.example.data.model.OwnerProfile
import com.example.data.notification.NotificationHelper
import com.example.ui.components.AddEditItemDialog
import com.example.ui.components.AddEditReminderDialog
import com.example.ui.components.AssetLiabilityBar
import com.example.ui.components.NetWorthTrendChart
import com.example.ui.components.ShareEntryDialog
import com.example.ui.components.VoiceAssistantDialog
import com.example.ui.theme.AssetGreen
import com.example.ui.theme.LiabilityRed
import com.example.ui.theme.PrimaryGreen
import com.example.ui.theme.PrimaryGreenDark
import com.example.ui.utils.NumberFormatUtils
import com.example.ui.viewmodel.NetWorthViewModel

@Composable
fun DashboardScreen(
    viewModel: NetWorthViewModel,
    onNavigateToTab: (String) -> Unit
) {
    val context = LocalContext.current
    val summary by viewModel.summary.collectAsState()
    val snapshots by viewModel.snapshots.collectAsState()
    val filteredItems by viewModel.filteredItems.collectAsState()
    val reminders by viewModel.allReminders.collectAsState()
    val selectedOwner by viewModel.selectedOwnerFilter.collectAsState()
    val recoveryMessage by viewModel.recoveryBannerMessage.collectAsState()

    var showVoiceDialog by remember { mutableStateOf(false) }
    var showAddItemDialog by remember { mutableStateOf(false) }
    var showAddReminderDialog by remember { mutableStateOf(false) }
    var isEventReminderInitial by remember { mutableStateOf(false) }
    var editingItem by remember { mutableStateOf<FinancialItem?>(null) }
    var entryToShare by remember { mutableStateOf<LedgerEntry?>(null) }

    if (showVoiceDialog) {
        VoiceAssistantDialog(
            viewModel = viewModel,
            onDismiss = { showVoiceDialog = false },
            onNavigate = { screen ->
                showVoiceDialog = false
                onNavigateToTab(screen)
            }
        )
    }

    if (showAddItemDialog || editingItem != null) {
        AddEditItemDialog(
            initialItem = editingItem,
            onDismiss = {
                showAddItemDialog = false
                editingItem = null
            },
            onSave = { item ->
                viewModel.saveFinancialItem(item)
                showAddItemDialog = false
                editingItem = null
                Toast.makeText(context, "Saved ${item.title}", Toast.LENGTH_SHORT).show()
            }
        )
    }

    if (showAddReminderDialog) {
        AddEditReminderDialog(
            isEventReminderInitial = isEventReminderInitial,
            onDismiss = { 
                showAddReminderDialog = false 
                isEventReminderInitial = false
            },
            onSave = { reminder ->
                viewModel.saveReminder(reminder)
                showAddReminderDialog = false
                isEventReminderInitial = false
                val typeName = if (reminder.isEvent) "Event" else "Reminder"
                Toast.makeText(context, "Saved $typeName: ${reminder.title}", Toast.LENGTH_SHORT).show()
                if (NotificationHelper.hasNotificationPermission(context)) {
                    NotificationHelper.notifyReminder(context, reminder)
                }
            }
        )
    }

    entryToShare?.let { entry ->
        ShareEntryDialog(
            entry = entry,
            onDismiss = { entryToShare = null }
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top Header
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Net Worth Portfolio",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Real-time wealth tracking",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Voice Assistant Launch Icon
                    IconButton(
                        onClick = { showVoiceDialog = true },
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(PrimaryGreen.copy(alpha = 0.15f))
                    ) {
                        Icon(
                            imageVector = Icons.Default.Mic,
                            contentDescription = "Voice Assistant",
                            tint = PrimaryGreen
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    // Snapshot button
                    IconButton(
                        onClick = {
                            viewModel.recordSnapshot("Dashboard Manual")
                            Toast.makeText(context, "Snapshot saved!", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Icon(
                            imageVector = Icons.Default.CameraAlt,
                            contentDescription = "Snapshot",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }

        // Reinstall Data Recovery Notification Banner
        recoveryMessage?.let { msg ->
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = PrimaryGreen.copy(alpha = 0.15f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = PrimaryGreen
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = msg,
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        IconButton(
                            onClick = { viewModel.dismissRecoveryBanner() },
                            modifier = Modifier.size(28.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Dismiss",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                }
            }
        }

        // Owner Filter Chips
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("All", OwnerProfile.SELF.displayName, OwnerProfile.FATHER.displayName, OwnerProfile.MOTHER.displayName, OwnerProfile.FAMILY.displayName).forEach { owner ->
                    FilterChip(
                        selected = selectedOwner == owner,
                        onClick = { viewModel.selectedOwnerFilter.value = owner },
                        label = { Text(owner) }
                    )
                }
            }
        }

        // Net Worth Master Hero Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.linearGradient(
                                colors = listOf(PrimaryGreenDark, PrimaryGreen)
                            )
                        )
                        .padding(20.dp)
                ) {
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "TOTAL NET WORTH",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color.White.copy(alpha = 0.8f)
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = NumberFormatUtils.formatCurrency(summary.netWorth),
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        // P&L badge
                        val isPositive = summary.totalProfitLoss >= 0
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = if (isPositive) AssetGreen.copy(alpha = 0.25f) else LiabilityRed.copy(alpha = 0.25f)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = if (isPositive) Icons.Default.TrendingUp else Icons.Default.TrendingDown,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "${if (isPositive) "+" else ""}${NumberFormatUtils.formatCompact(summary.totalProfitLoss)} (${String.format("%.1f", summary.profitLossPercentage)}%)",
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Assets vs Liabilities row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = "Total Assets",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color.White.copy(alpha = 0.8f)
                                )
                                Text(
                                    text = NumberFormatUtils.formatCurrency(summary.totalAssets),
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }

                            Column(horizontalAlignment = Alignment.End) {
                                Text(
                                    text = "Total Liabilities",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color.White.copy(alpha = 0.8f)
                                )
                                Text(
                                    text = NumberFormatUtils.formatCurrency(summary.totalLiabilities),
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = LiabilityRed.copy(alpha = 0.9f)
                                )
                            }
                        }
                    }
                }
            }
        }

        // Quick Actions Row
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Voice Control Button
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { showVoiceDialog = true },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = PrimaryGreen.copy(alpha = 0.12f))
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(Icons.Default.Mic, contentDescription = "Voice", tint = PrimaryGreen)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Voice Control",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryGreen
                        )
                    }
                }

                // Add Item
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { showAddItemDialog = true },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Add Item", tint = MaterialTheme.colorScheme.onSurface)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Add Item",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                // Add Reminder
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { showAddReminderDialog = true },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(Icons.Default.Notifications, contentDescription = "Reminder", tint = MaterialTheme.colorScheme.onSurface)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Reminder",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }

        // Active Reminders & Events Banner (if any pending)
        val pendingReminders = reminders.filter { !it.isCompleted }
        val pendingEvents = pendingReminders.filter { it.isEvent }
        val pendingDues = pendingReminders.filter { !it.isEvent }

        if (pendingReminders.isNotEmpty()) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onNavigateToTab("Reminders") },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (pendingEvents.isNotEmpty()) AssetGreen.copy(alpha = 0.12f) else MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                            Icon(
                                imageVector = if (pendingEvents.isNotEmpty()) Icons.Default.Event else Icons.Default.Notifications,
                                contentDescription = null,
                                tint = if (pendingEvents.isNotEmpty()) AssetGreen else PrimaryGreen
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                val headerTitle = when {
                                    pendingEvents.isNotEmpty() && pendingDues.isNotEmpty() -> 
                                        "${pendingEvents.size} Events • ${pendingDues.size} Dues Pending"
                                    pendingEvents.isNotEmpty() -> 
                                        "${pendingEvents.size} Upcoming Event${if (pendingEvents.size > 1) "s" else ""}"
                                    else -> 
                                        "${pendingDues.size} Active Reminders / Due Bills"
                                }
                                Text(
                                    text = headerTitle,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                val nextItem = pendingEvents.firstOrNull() ?: pendingReminders.first()
                                val amtStr = if (nextItem.amount > 0) " (${NumberFormatUtils.formatCurrency(nextItem.amount)})" else ""
                                Text(
                                    text = "Next: ${nextItem.title}$amtStr",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            TextButton(
                                onClick = {
                                    isEventReminderInitial = true
                                    showAddReminderDialog = true
                                }
                            ) {
                                Text("+ Event", fontWeight = FontWeight.Bold, color = AssetGreen)
                            }
                            Icon(Icons.Default.ChevronRight, contentDescription = null)
                        }
                    }
                }
            }
        }

        // Net Worth Trajectory Chart
        item {
            NetWorthTrendChart(snapshots = snapshots)
        }

        // Asset vs Liability Allocation
        item {
            AssetLiabilityBar(
                totalAssets = summary.totalAssets,
                totalLiabilities = summary.totalLiabilities
            )
        }

        // Holdings List Header
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Key Portfolio Holdings",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "View All (${filteredItems.size})",
                    style = MaterialTheme.typography.labelMedium,
                    color = PrimaryGreen,
                    modifier = Modifier.clickable { onNavigateToTab("Assets") }
                )
            }
        }

        // First 4 items preview or Empty State
        if (filteredItems.isEmpty()) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountBalanceWallet,
                            contentDescription = null,
                            tint = PrimaryGreen,
                            modifier = Modifier.size(44.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "No Accounts or Assets Yet",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Add your bank accounts, investments, properties, or loans to start tracking your family net worth completely offline.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { showAddItemDialog = true },
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Add First Asset / Account")
                        }
                    }
                }
            }
        } else {
            items(filteredItems.take(4)) { item ->
                DashboardItemCard(
                    item = item,
                    onClick = { editingItem = item }
                )
            }
        }
    }
}

@Composable
fun DashboardItemCard(
    item: FinancialItem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${item.category} • ${item.owner}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = NumberFormatUtils.formatCurrency(item.currentValue),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = if (item.isLiability) LiabilityRed else AssetGreen
                )
                if (item.investedValue > 0 && !item.isLiability) {
                    val pl = item.currentValue - item.investedValue
                    val isGain = pl >= 0
                    Text(
                        text = "${if (isGain) "+" else ""}${NumberFormatUtils.formatCompact(pl)}",
                        style = MaterialTheme.typography.labelSmall,
                        color = if (isGain) AssetGreen else LiabilityRed
                    )
                }
            }
        }
    }
}
