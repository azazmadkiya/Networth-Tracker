package com.example.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.data.model.FinancialReminder
import com.example.data.model.ReminderPriority
import com.example.data.model.ReminderType
import com.example.ui.components.AddEditReminderDialog
import com.example.ui.components.VoiceAssistantDialog
import com.example.ui.theme.AssetGreen
import com.example.ui.theme.LiabilityRed
import com.example.ui.theme.PrimaryGreen
import com.example.ui.utils.NumberFormatUtils
import com.example.ui.viewmodel.NetWorthViewModel

@Composable
fun RemindersScreen(
    viewModel: NetWorthViewModel
) {
    val context = LocalContext.current
    val reminders by viewModel.allReminders.collectAsState()

    var showVoiceDialog by remember { mutableStateOf(false) }
    var showAddDialog by remember { mutableStateOf(false) }
    var editingReminder by remember { mutableStateOf<FinancialReminder?>(null) }

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
            onDismiss = {
                showAddDialog = false
                editingReminder = null
            },
            onSave = { reminder ->
                viewModel.saveReminder(reminder)
                showAddDialog = false
                editingReminder = null
                Toast.makeText(context, "Saved reminder ${reminder.title}", Toast.LENGTH_SHORT).show()
            }
        )
    }

    Scaffold(
        floatingActionButton = {
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                FloatingActionButton(
                    onClick = { showVoiceDialog = true },
                    containerColor = PrimaryGreen.copy(alpha = 0.2f),
                    contentColor = PrimaryGreen,
                    shape = CircleShape
                ) {
                    Icon(Icons.Default.Mic, contentDescription = "Voice Assistant")
                }
                FloatingActionButton(
                    onClick = { showAddDialog = true },
                    containerColor = PrimaryGreen,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    shape = CircleShape
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add Reminder")
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Financial Reminders",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Never miss a SIP, EMI, or critical bill payment",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(
                    onClick = { showVoiceDialog = true },
                    modifier = Modifier
                        .size(42.dp)
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

            if (reminders.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No reminders yet. Say 'Add reminder pay credit card 8500' or tap +!",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                val currentEpochDay = System.currentTimeMillis() / 86400000L
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 80.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(reminders, key = { it.id }) { reminder ->
                        ReminderCard(
                            reminder = reminder,
                            currentEpochDay = currentEpochDay,
                            onToggleCompleted = {
                                viewModel.setReminderCompleted(reminder.id, !reminder.isCompleted)
                            },
                            onEdit = { editingReminder = reminder },
                            onDelete = {
                                viewModel.deleteReminder(reminder)
                                Toast.makeText(context, "Deleted reminder", Toast.LENGTH_SHORT).show()
                            }
                        )
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
    onDelete: () -> Unit
) {
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

                Text(
                    text = NumberFormatUtils.formatCurrency(reminder.amount),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = if (reminder.isCompleted) MaterialTheme.colorScheme.onSurfaceVariant else PrimaryGreen
                )
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

                Row {
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
