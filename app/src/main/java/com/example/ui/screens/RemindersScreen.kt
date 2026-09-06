package com.example.ui.screens

import android.Manifest
import android.content.Intent
import android.provider.CalendarContract
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.FinancialReminder
import com.example.data.model.ReminderPriority
import com.example.data.model.ReminderType
import com.example.data.notification.NotificationHelper
import com.example.ui.components.AddEditReminderDialog
import com.example.ui.components.VoiceAssistantDialog
import com.example.ui.theme.AssetGreen
import com.example.ui.theme.LiabilityRed
import com.example.ui.theme.PrimaryGreen
import com.example.ui.utils.NumberFormatUtils
import com.example.ui.viewmodel.NetWorthViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun RemindersScreen(
    viewModel: NetWorthViewModel
) {
    val context = LocalContext.current
    val reminders by viewModel.allReminders.collectAsState()

    var showVoiceDialog by remember { mutableStateOf(false) }
    var showAddDialog by remember { mutableStateOf(false) }
    var isAddingEventReminder by remember { mutableStateOf(false) }
    var editingReminder by remember { mutableStateOf<FinancialReminder?>(null) }
    var selectedFilter by remember { mutableStateOf("ALL") }

    var hasNotificationPermission by remember {
        mutableStateOf(NotificationHelper.hasNotificationPermission(context))
    }

    val notificationLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        hasNotificationPermission = isGranted
        if (isGranted) {
            Toast.makeText(context, "Notifications enabled! You will receive timely alerts.", Toast.LENGTH_SHORT).show()
            NotificationHelper.sendTestNotification(context)
        } else {
            Toast.makeText(context, "Notification permission denied. You can enable it anytime in Settings.", Toast.LENGTH_LONG).show()
        }
    }

    if (showVoiceDialog) {
        VoiceAssistantDialog(
            viewModel = viewModel,
            onDismiss = { showVoiceDialog = false },
            onNavigate = { showVoiceDialog = false }
        )
    }

    if (showAddDialog || editingReminder != null) {
        AddEditReminderDialog(
            initialReminder = editingReminder,
            isEventReminderInitial = isAddingEventReminder,
            onDismiss = {
                showAddDialog = false
                isAddingEventReminder = false
                editingReminder = null
            },
            onSave = { reminder ->
                viewModel.saveReminder(reminder)
                showAddDialog = false
                isAddingEventReminder = false
                editingReminder = null
                val typeName = if (reminder.isEvent) "Event" else "Reminder"
                Toast.makeText(context, "Saved $typeName: ${reminder.title}", Toast.LENGTH_SHORT).show()
                if (hasNotificationPermission) {
                    NotificationHelper.notifyReminder(context, reminder)
                }
            }
        )
    }

    val eventCount = reminders.count { it.isEvent }
    val duesCount = reminders.count { !it.isEvent }

    val filteredReminders = remember(reminders, selectedFilter) {
        when (selectedFilter) {
            "EVENTS" -> reminders.filter { it.isEvent }
            "DUES" -> reminders.filter { it.reminderType == ReminderType.DUE_DATE.name }
            "SIP" -> reminders.filter { it.reminderType == ReminderType.SIP_INVESTMENT.name }
            "EMI" -> reminders.filter { it.reminderType == ReminderType.LOAN_EMI.name || it.reminderType == ReminderType.CREDIT_CARD_BILL.name }
            else -> reminders
        }
    }

    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        floatingActionButton = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Voice Control FAB
                FloatingActionButton(
                    onClick = { showVoiceDialog = true },
                    containerColor = PrimaryGreen.copy(alpha = 0.18f),
                    contentColor = PrimaryGreen,
                    shape = CircleShape
                ) {
                    Icon(Icons.Default.Mic, contentDescription = "Voice Assistant")
                }

                // Add Event Reminder FAB
                ExtendedFloatingActionButton(
                    onClick = {
                        isAddingEventReminder = true
                        showAddDialog = true
                    },
                    icon = { Icon(Icons.Default.Event, contentDescription = null) },
                    text = { Text("Add Event Reminder", fontWeight = FontWeight.Bold) },
                    containerColor = AssetGreen,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(16.dp)
                )

                // Standard Add Reminder FAB
                FloatingActionButton(
                    onClick = {
                        isAddingEventReminder = false
                        showAddDialog = true
                    },
                    containerColor = PrimaryGreen,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    shape = CircleShape
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add Bill/SIP Reminder")
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
        ) {
            // Screen Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Events & Reminders",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "$eventCount Events • $duesCount Payments & Dues",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    IconButton(
                        onClick = {
                            isAddingEventReminder = true
                            showAddDialog = true
                        },
                        modifier = Modifier
                            .size(38.dp)
                            .background(AssetGreen.copy(alpha = 0.15f), CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Event,
                            contentDescription = "Add Event Reminder",
                            tint = AssetGreen,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    IconButton(
                        onClick = { showVoiceDialog = true },
                        modifier = Modifier
                            .size(38.dp)
                            .background(PrimaryGreen.copy(alpha = 0.15f), CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Mic,
                            contentDescription = "Active Voice Control",
                            tint = PrimaryGreen,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            // Quick Banner for Adding Event Reminder
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = AssetGreen.copy(alpha = 0.10f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Event,
                            contentDescription = null,
                            tint = AssetGreen,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "Never miss key dates & milestones",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Tax deadlines, FD maturity, policy renewals & events",
                                style = MaterialTheme.typography.bodySmall,
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Button(
                        onClick = {
                            isAddingEventReminder = true
                            showAddDialog = true
                        },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = AssetGreen),
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                        Text("+ Event", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            // Notification Permission Alert if not yet granted
            if (!hasNotificationPermission && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 6.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = PrimaryGreen.copy(alpha = 0.1f))
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.NotificationsActive,
                            contentDescription = "Notification Alerts",
                            tint = PrimaryGreen,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Enable Device Notifications",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Get notified on your phone when events and dues approach.",
                                style = MaterialTheme.typography.bodySmall,
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Button(
                            onClick = { notificationLauncher.launch(Manifest.permission.POST_NOTIFICATIONS) },
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text("Allow", style = MaterialTheme.typography.labelSmall)
                        }
                    }
                }
            }

            // Filter Chips Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChip(
                    selected = selectedFilter == "ALL",
                    onClick = { selectedFilter = "ALL" },
                    label = { Text("All (${reminders.size})") }
                )
                FilterChip(
                    selected = selectedFilter == "EVENTS",
                    onClick = { selectedFilter = "EVENTS" },
                    label = { Text("📅 Events ($eventCount)") },
                    leadingIcon = {
                        Icon(Icons.Default.Event, contentDescription = null, modifier = Modifier.size(16.dp))
                    }
                )
                FilterChip(
                    selected = selectedFilter == "DUES",
                    onClick = { selectedFilter = "DUES" },
                    label = { Text("💳 Bills & Dues") }
                )
                FilterChip(
                    selected = selectedFilter == "SIP",
                    onClick = { selectedFilter = "SIP" },
                    label = { Text("📈 SIPs & Funds") }
                )
                FilterChip(
                    selected = selectedFilter == "EMI",
                    onClick = { selectedFilter = "EMI" },
                    label = { Text("🏦 Loan EMIs") }
                )
            }

            // List of Reminders & Events
            if (filteredReminders.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = if (selectedFilter == "EVENTS") Icons.Default.Event else Icons.Default.Notifications,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = if (selectedFilter == "EVENTS") "No event reminders scheduled yet." else "No reminders found.",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = if (selectedFilter == "EVENTS") 
                                "Schedule tax filing, FD maturity, policy renewals or anniversaries."
                            else 
                                "Say 'Add event reminder Tax Filing in 5 days' or tap below.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                isAddingEventReminder = true
                                showAddDialog = true
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = AssetGreen),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Icon(Icons.Default.Event, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Add Event Reminder")
                        }
                    }
                }
            } else {
                val currentEpochDay = System.currentTimeMillis() / 86400000L
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 96.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(filteredReminders, key = { it.id }) { reminder ->
                        if (reminder.isEvent) {
                            EventReminderCard(
                                reminder = reminder,
                                currentEpochDay = currentEpochDay,
                                onToggleCompleted = {
                                    viewModel.setReminderCompleted(reminder.id, !reminder.isCompleted)
                                },
                                onEdit = {
                                    isAddingEventReminder = true
                                    editingReminder = reminder
                                },
                                onDelete = {
                                    viewModel.deleteReminder(reminder)
                                    Toast.makeText(context, "Deleted event reminder", Toast.LENGTH_SHORT).show()
                                },
                                onSendNotification = {
                                    if (hasNotificationPermission) {
                                        val sent = NotificationHelper.notifyReminder(context, reminder)
                                        if (sent) {
                                            Toast.makeText(context, "🔔 Alert notification triggered for ${reminder.title}!", Toast.LENGTH_SHORT).show()
                                        }
                                    } else {
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                            notificationLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                                        }
                                    }
                                }
                            )
                        } else {
                            ReminderCard(
                                reminder = reminder,
                                currentEpochDay = currentEpochDay,
                                onToggleCompleted = {
                                    viewModel.setReminderCompleted(reminder.id, !reminder.isCompleted)
                                },
                                onEdit = {
                                    isAddingEventReminder = false
                                    editingReminder = reminder
                                },
                                onDelete = {
                                    viewModel.deleteReminder(reminder)
                                    Toast.makeText(context, "Deleted reminder", Toast.LENGTH_SHORT).show()
                                },
                                onSendNotification = {
                                    if (hasNotificationPermission) {
                                        val sent = NotificationHelper.notifyReminder(context, reminder)
                                        if (sent) {
                                            Toast.makeText(context, "🔔 Alert notification sent for ${reminder.title}!", Toast.LENGTH_SHORT).show()
                                        }
                                    } else {
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                            notificationLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                                        }
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EventReminderCard(
    reminder: FinancialReminder,
    currentEpochDay: Long,
    onToggleCompleted: () -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
    onSendNotification: () -> Unit
) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val daysRemaining = reminder.dueDateEpochDay - currentEpochDay
    val isPast = daysRemaining < 0 && !reminder.isCompleted
    val isToday = daysRemaining == 0L && !reminder.isCompleted

    val targetDateFormatted = remember(reminder.dueDateEpochDay) {
        val sdf = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        sdf.format(Date(reminder.dueDateEpochDay * 86400000L))
    }

    val monthFormatted = remember(reminder.dueDateEpochDay) {
        val sdf = SimpleDateFormat("MMM", Locale.getDefault())
        sdf.format(Date(reminder.dueDateEpochDay * 86400000L)).uppercase()
    }

    val dayFormatted = remember(reminder.dueDateEpochDay) {
        val sdf = SimpleDateFormat("dd", Locale.getDefault())
        sdf.format(Date(reminder.dueDateEpochDay * 86400000L))
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (reminder.isCompleted) 
                MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f) 
            else 
                MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Calendar Date Tile
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = if (reminder.isCompleted) 
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f)
                    else 
                        AssetGreen.copy(alpha = 0.15f),
                    modifier = Modifier.size(width = 46.dp, height = 48.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = monthFormatted,
                            style = MaterialTheme.typography.labelSmall,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (reminder.isCompleted) MaterialTheme.colorScheme.onSurfaceVariant else AssetGreen
                        )
                        Text(
                            text = dayFormatted,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (reminder.isCompleted) MaterialTheme.colorScheme.onSurfaceVariant else AssetGreen
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Title & Details
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = reminder.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            textDecoration = if (reminder.isCompleted) TextDecoration.LineThrough else TextDecoration.None,
                            modifier = Modifier.weight(1f)
                        )
                        if (reminder.amount > 0) {
                            Text(
                                text = NumberFormatUtils.formatCurrency(reminder.amount),
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = if (reminder.isCompleted) MaterialTheme.colorScheme.onSurfaceVariant else AssetGreen
                            )
                        }
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = "📅 $targetDateFormatted • ${reminder.frequency}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    if (reminder.associatedAccount.isNotBlank()) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Place,
                                contentDescription = null,
                                modifier = Modifier.size(12.dp),
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = reminder.associatedAccount,
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            if (reminder.notes.isNotBlank()) {
                Spacer(modifier = Modifier.height(6.dp))
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "📝 ${reminder.notes}",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Footer Badges and Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
                    // Countdown Status Badge
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = when {
                            reminder.isCompleted -> MaterialTheme.colorScheme.surfaceVariant
                            isPast -> LiabilityRed.copy(alpha = 0.15f)
                            isToday -> AssetGreen.copy(alpha = 0.20f)
                            else -> AssetGreen.copy(alpha = 0.12f)
                        }
                    ) {
                        val statusText = when {
                            reminder.isCompleted -> "Completed"
                            isPast -> "Passed ${-daysRemaining}d ago"
                            isToday -> "Event Today! 🎉"
                            daysRemaining == 1L -> "Tomorrow"
                            else -> "In ${daysRemaining} days"
                        }
                        Text(
                            text = statusText,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = when {
                                reminder.isCompleted -> MaterialTheme.colorScheme.onSurfaceVariant
                                isPast -> LiabilityRed
                                else -> AssetGreen
                            },
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }

                    // Priority Tag
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Text(
                            text = reminder.priority,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                        )
                    }
                }

                // Action icons
                Row(horizontalArrangement = Arrangement.spacedBy(2.dp), verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onToggleCompleted, modifier = Modifier.size(32.dp)) {
                        Icon(
                            imageVector = if (reminder.isCompleted) Icons.Default.CheckCircle else Icons.Outlined.Circle,
                            contentDescription = "Toggle Complete",
                            tint = if (reminder.isCompleted) AssetGreen else MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    IconButton(onClick = onSendNotification, modifier = Modifier.size(32.dp)) {
                        Icon(
                            Icons.Default.Notifications,
                            contentDescription = "Test Notification Alert",
                            tint = AssetGreen,
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    IconButton(onClick = {
                        val intent = Intent(Intent.ACTION_INSERT).apply {
                            data = CalendarContract.Events.CONTENT_URI
                            putExtra(CalendarContract.Events.TITLE, reminder.title)
                            val startTime = reminder.dueDateEpochDay * 86400000L
                            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime)
                            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, startTime + 86400000L)
                            putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true)
                            if (reminder.notes.isNotBlank()) putExtra(CalendarContract.Events.DESCRIPTION, reminder.notes)
                            if (reminder.associatedAccount.isNotBlank()) putExtra(CalendarContract.Events.EVENT_LOCATION, reminder.associatedAccount)
                        }
                        context.startActivity(intent)
                    }, modifier = Modifier.size(32.dp)) {
                        Icon(Icons.Default.Event, contentDescription = "Add to Calendar", tint = AssetGreen, modifier = Modifier.size(18.dp))
                    }

                    IconButton(onClick = onEdit, modifier = Modifier.size(32.dp)) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit", modifier = Modifier.size(18.dp))
                    }

                    IconButton(onClick = onDelete, modifier = Modifier.size(32.dp)) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete", tint = LiabilityRed, modifier = Modifier.size(18.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun ReminderCard(
    reminder: FinancialReminder,
    currentEpochDay: Long,
    onToggleCompleted: () -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
    onSendNotification: () -> Unit
) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val daysRemaining = reminder.dueDateEpochDay - currentEpochDay
    val isOverdue = daysRemaining < 0 && !reminder.isCompleted
    val isDueToday = daysRemaining == 0L && !reminder.isCompleted

    val priorityColor = when (reminder.priority) {
        ReminderPriority.HIGH.name -> LiabilityRed
        ReminderPriority.MEDIUM.name -> PrimaryGreen
        else -> MaterialTheme.colorScheme.onSurfaceVariant
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (reminder.isCompleted) MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f) else MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onToggleCompleted, modifier = Modifier.size(36.dp)) {
                        Icon(
                            imageVector = if (reminder.isCompleted) Icons.Default.CheckCircle else Icons.Outlined.Circle,
                            contentDescription = "Toggle Complete",
                            tint = if (reminder.isCompleted) AssetGreen else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Column {
                        Text(
                            text = reminder.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            textDecoration = if (reminder.isCompleted) TextDecoration.LineThrough else TextDecoration.None
                        )
                        Text(
                            text = "${reminder.reminderType.replace('_', ' ')} • ${reminder.frequency}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                if (reminder.amount > 0) {
                    Text(
                        text = NumberFormatUtils.formatCurrency(reminder.amount),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = if (reminder.isCompleted) MaterialTheme.colorScheme.onSurfaceVariant else PrimaryGreen
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
                    // Due day badge
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = when {
                            reminder.isCompleted -> MaterialTheme.colorScheme.surfaceVariant
                            isOverdue -> LiabilityRed.copy(alpha = 0.15f)
                            isDueToday -> LiabilityRed.copy(alpha = 0.15f)
                            else -> PrimaryGreen.copy(alpha = 0.12f)
                        }
                    ) {
                        val dueText = when {
                            reminder.isCompleted -> "Completed"
                            isOverdue -> "Overdue by ${-daysRemaining}d"
                            isDueToday -> "Due Today!"
                            daysRemaining == 1L -> "Due Tomorrow"
                            else -> "Due in ${daysRemaining}d"
                        }
                        Text(
                            text = dueText,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = when {
                                reminder.isCompleted -> MaterialTheme.colorScheme.onSurfaceVariant
                                isOverdue || isDueToday -> LiabilityRed
                                else -> PrimaryGreen
                            },
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }

                    // Priority badge
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = priorityColor.copy(alpha = 0.12f)
                    ) {
                        Text(
                            text = reminder.priority,
                            style = MaterialTheme.typography.labelSmall,
                            color = priorityColor,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }

                Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                    IconButton(onClick = onSendNotification, modifier = Modifier.size(32.dp)) {
                        Icon(Icons.Default.Notifications, contentDescription = "Test Notification Alert", tint = PrimaryGreen, modifier = Modifier.size(18.dp))
                    }
                    IconButton(onClick = {
                        val intent = Intent(Intent.ACTION_INSERT).apply {
                            data = CalendarContract.Events.CONTENT_URI
                            putExtra(CalendarContract.Events.TITLE, reminder.title)
                            val startTime = reminder.dueDateEpochDay * 86400000L
                            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime)
                            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, startTime + 86400000L)
                            putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true)
                            if (reminder.notes.isNotBlank()) putExtra(CalendarContract.Events.DESCRIPTION, reminder.notes)
                            if (reminder.associatedAccount.isNotBlank()) putExtra(CalendarContract.Events.EVENT_LOCATION, reminder.associatedAccount)
                        }
                        context.startActivity(intent)
                    }, modifier = Modifier.size(32.dp)) {
                        Icon(Icons.Default.Event, contentDescription = "Add to Calendar", tint = PrimaryGreen, modifier = Modifier.size(18.dp))
                    }
                    IconButton(onClick = onEdit, modifier = Modifier.size(32.dp)) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit", modifier = Modifier.size(18.dp))
                    }
                    IconButton(onClick = onDelete, modifier = Modifier.size(32.dp)) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete", tint = LiabilityRed, modifier = Modifier.size(18.dp))
                    }
                }
            }
        }
    }
}
