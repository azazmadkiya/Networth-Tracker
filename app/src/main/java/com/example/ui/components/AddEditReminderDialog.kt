package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.data.model.EventReminderPresets
import com.example.data.model.FinancialReminder
import com.example.data.model.OwnerProfile
import com.example.data.model.ReminderFrequency
import com.example.data.model.ReminderPriority
import com.example.data.model.ReminderType
import com.example.ui.theme.AssetGreen
import com.example.ui.theme.PrimaryGreen
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun AddEditReminderDialog(
    initialReminder: FinancialReminder? = null,
    isEventReminderInitial: Boolean = false,
    onDismiss: () -> Unit,
    onSave: (FinancialReminder) -> Unit
) {
    val initialIsEvent = initialReminder?.isEvent == true || 
        initialReminder?.reminderType == ReminderType.EVENT_REMINDER.name || 
        isEventReminderInitial

    var isEventMode by remember { mutableStateOf(initialIsEvent) }
    var title by remember { mutableStateOf(initialReminder?.title ?: "") }
    var amountStr by remember { 
        mutableStateOf(
            if (initialReminder != null && initialReminder.amount > 0) {
                String.format(Locale.US, "%.0f", initialReminder.amount)
            } else ""
        ) 
    }
    var selectedType by remember { 
        mutableStateOf(
            if (initialIsEvent) ReminderType.EVENT_REMINDER.name 
            else (initialReminder?.reminderType ?: ReminderType.DUE_DATE.name)
        ) 
    }
    var selectedPriority by remember { mutableStateOf(initialReminder?.priority ?: ReminderPriority.MEDIUM.name) }
    var selectedFrequency by remember { 
        mutableStateOf(
            if (initialIsEvent && initialReminder == null) ReminderFrequency.ONE_TIME.name
            else (initialReminder?.frequency ?: ReminderFrequency.MONTHLY.name)
        ) 
    }
    var dueDaysFromNowStr by remember {
        val currentDay = System.currentTimeMillis() / 86400000L
        val diff = if (initialReminder != null && initialReminder.dueDateEpochDay > 0) {
            (initialReminder.dueDateEpochDay - currentDay).coerceAtLeast(0)
        } else {
            if (initialIsEvent) 7 else 3
        }
        mutableStateOf(diff.toString())
    }
    var associatedAccount by remember { mutableStateOf(initialReminder?.associatedAccount ?: "") }
    var notes by remember { mutableStateOf(initialReminder?.notes ?: "") }

    val isEditing = initialReminder != null
    val currentEpochDay = System.currentTimeMillis() / 86400000L
    val targetEpochDay = currentEpochDay + (dueDaysFromNowStr.toLongOrNull() ?: 0L)
    val targetDateFormatted = remember(targetEpochDay) {
        val sdf = SimpleDateFormat("EEEE, dd MMM yyyy", Locale.getDefault())
        sdf.format(Date(targetEpochDay * 86400000L))
    }
    
    val context = LocalContext.current
    
    val showDatePicker = {
        val calendar = java.util.Calendar.getInstance()
        calendar.timeInMillis = targetEpochDay * 86400000L
        android.app.DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                val selectedCal = java.util.Calendar.getInstance()
                selectedCal.set(year, month, dayOfMonth)
                val selectedEpochDay = selectedCal.timeInMillis / 86400000L
                val diff = (selectedEpochDay - currentEpochDay).coerceAtLeast(0)
                dueDaysFromNowStr = diff.toString()
            },
            calendar.get(java.util.Calendar.YEAR),
            calendar.get(java.util.Calendar.MONTH),
            calendar.get(java.util.Calendar.DAY_OF_MONTH)
        ).apply {
            datePicker.minDate = System.currentTimeMillis() - 86400000L
        }.show()
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val safeDismiss = {
        keyboardController?.hide()
        focusManager.clearFocus()
        onDismiss()
    }

    Dialog(
        onDismissRequest = safeDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            decorFitsSystemWindows = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .imePadding()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 520.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Fixed Header
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 12.dp, top = 16.dp, bottom = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = if (isEditing) {
                                    if (isEventMode) "Edit Event Reminder" else "Edit Reminder"
                                } else {
                                    if (isEventMode) "Add Event Reminder" else "Add Financial Reminder"
                                },
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = if (isEventMode) "Schedule tax dates, renewals, milestones & events" else "Track SIPs, bills, loan EMIs, and dues",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        IconButton(onClick = safeDismiss) {
                            Icon(Icons.Default.Close, contentDescription = "Close")
                        }
                    }

                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                    // Scrollable Form Body
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f, fill = false)
                            .verticalScroll(rememberScrollState())
                            .padding(horizontal = 20.dp, vertical = 14.dp)
                    ) {
                        // Mode Selector Chips
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                    FilterChip(
                        selected = !isEventMode,
                        onClick = {
                            isEventMode = false
                            if (selectedType == ReminderType.EVENT_REMINDER.name) {
                                selectedType = ReminderType.DUE_DATE.name
                            }
                        },
                        label = { Text("💳 Bill / Due Reminder") },
                        modifier = Modifier.weight(1f)
                    )
                    FilterChip(
                        selected = isEventMode,
                        onClick = {
                            isEventMode = true
                            selectedType = ReminderType.EVENT_REMINDER.name
                        },
                        label = { Text("📅 Event Reminder") },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Event Presets if in Event Mode
                if (isEventMode) {
                    Text(
                        text = "Quick Event Templates",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        EventReminderPresets.presets.forEach { preset ->
                            FilterChip(
                                selected = title == preset.title,
                                onClick = {
                                    title = preset.title
                                    dueDaysFromNowStr = preset.defaultDays.toString()
                                    selectedFrequency = preset.frequency.name
                                    selectedPriority = preset.priority.name
                                    associatedAccount = preset.category
                                    if (preset.placeholderBudget > 0) {
                                        amountStr = String.format(Locale.US, "%.0f", preset.placeholderBudget)
                                    }
                                },
                                label = { Text(preset.title, fontSize = 12.sp) }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(14.dp))
                }

                // Title Input
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text(if (isEventMode) "Event Title *" else "Reminder Title *") },
                    placeholder = { 
                        Text(if (isEventMode) "e.g. Tax Filing Deadline, FD Maturity, Birthday" else "e.g. Parag Parikh SIP, Electricity Bill") 
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Date / Days Section
                Text(
                    text = if (isEventMode) "Event Date & Schedule *" else "Due In (Days) *",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(6.dp))

                // Quick Day Presets
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    val presets = listOf(
                        "Today (0d)" to "0",
                        "Tomorrow (1d)" to "1",
                        "+3 Days" to "3",
                        "+7 Days" to "7",
                        "+15 Days" to "15",
                        "+30 Days" to "30"
                    )
                    presets.forEach { (label, dayVal) ->
                        FilterChip(
                            selected = dueDaysFromNowStr == dayVal,
                            onClick = { dueDaysFromNowStr = dayVal },
                            label = { Text(label, fontSize = 11.sp) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = PrimaryGreen.copy(alpha = 0.2f),
                                selectedLabelColor = PrimaryGreen
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    OutlinedTextField(
                        value = dueDaysFromNowStr,
                        onValueChange = { dueDaysFromNowStr = it },
                        label = { Text("Days from Now") },
                        placeholder = { Text("0, 1, 7, 30...") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = amountStr,
                        onValueChange = { amountStr = it },
                        label = { Text(if (isEventMode) "Budget (₹ Optional)" else "Amount (₹) *") },
                        placeholder = { Text(if (isEventMode) "0" else "e.g. 5000") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                }

                // Target Date Info Card
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = PrimaryGreen.copy(alpha = 0.1f),
                    modifier = Modifier.fillMaxWidth().clickable { showDatePicker() }
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = null,
                            tint = PrimaryGreen,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Target Date: $targetDateFormatted (${dueDaysFromNowStr.ifBlank { "0" }} days) (Tap to change)",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = PrimaryGreen
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Reminder Type (only if not event mode)
                if (!isEventMode) {
                    Text("Reminder Type", style = MaterialTheme.typography.labelMedium)
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        ReminderType.entries.filter { it != ReminderType.EVENT_REMINDER }.forEach { type ->
                            FilterChip(
                                selected = selectedType == type.name,
                                onClick = { selectedType = type.name },
                                label = { Text(type.displayName) }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }

                // Priority
                Text("Priority Level", style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ReminderPriority.entries.forEach { priority ->
                        FilterChip(
                            selected = selectedPriority == priority.name,
                            onClick = { selectedPriority = priority.name },
                            label = { Text(priority.displayName) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Frequency
                Text("Repeat Frequency", style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    ReminderFrequency.entries.forEach { freq ->
                        FilterChip(
                            selected = selectedFrequency == freq.name,
                            onClick = { selectedFrequency = freq.name },
                            label = { Text(freq.displayName) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Associated Account / Venue
                OutlinedTextField(
                    value = associatedAccount,
                    onValueChange = { associatedAccount = it },
                    label = { Text(if (isEventMode) "Category / Venue / Portal" else "Debit Account / Card") },
                    placeholder = { 
                        Text(if (isEventMode) "e.g. Income Tax Portal, SBI Branch, Family" else "e.g. HDFC Salary Account") 
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Notes
                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    label = { Text(if (isEventMode) "Agenda / Instructions" else "Notes / Instructions") },
                    placeholder = { 
                        Text(if (isEventMode) "e.g. Keep Form 16, Aadhaar, and bank statements ready" else "e.g. Pay before 5 PM to avoid penalty") 
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(20.dp))

                    }

                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                    // Fixed Action Buttons Footer (Always visible)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(onClick = safeDismiss) {
                            Text("Cancel")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            onClick = {
                                keyboardController?.hide()
                                focusManager.clearFocus()
                                val amt = amountStr.toDoubleOrNull() ?: 0.0
                                val days = dueDaysFromNowStr.toLongOrNull() ?: 3L
                                val dueDayEpoch = currentEpochDay + days

                                val finalType = if (isEventMode) ReminderType.EVENT_REMINDER.name else selectedType

                                if (title.isNotBlank()) {
                                    val reminder = FinancialReminder(
                                        id = initialReminder?.id ?: 0L,
                                        title = title.trim(),
                                        amount = amt,
                                        reminderType = finalType,
                                        priority = selectedPriority,
                                        dueDateEpochDay = dueDayEpoch,
                                        frequency = selectedFrequency,
                                        owner = OwnerProfile.SELF.displayName,
                                        associatedAccount = associatedAccount.trim(),
                                        notes = notes.trim(),
                                        isCompleted = initialReminder?.isCompleted ?: false,
                                        createdAt = initialReminder?.createdAt ?: System.currentTimeMillis()
                                    )
                                    onSave(reminder)
                                }
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen),
                            enabled = title.isNotBlank()
                        ) {
                            Text(
                                if (isEditing) {
                                    if (isEventMode) "Update Event" else "Update Reminder"
                                } else {
                                    if (isEventMode) "Save Event Reminder" else "Save Reminder"
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
