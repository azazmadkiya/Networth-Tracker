package com.example.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.data.model.FinancialReminder
import com.example.data.model.OwnerProfile
import com.example.data.model.ReminderFrequency
import com.example.data.model.ReminderPriority
import com.example.data.model.ReminderType
import com.example.ui.theme.PrimaryGreen

@Composable
fun AddEditReminderDialog(
    initialReminder: FinancialReminder? = null,
    onDismiss: () -> Unit,
    onSave: (FinancialReminder) -> Unit
) {
    var title by remember { mutableStateOf(initialReminder?.title ?: "") }
    var amountStr by remember { mutableStateOf(initialReminder?.let { String.format("%.0f", it.amount) } ?: "") }
    var selectedType by remember { mutableStateOf(initialReminder?.reminderType ?: ReminderType.DUE_DATE.name) }
    var selectedPriority by remember { mutableStateOf(initialReminder?.priority ?: ReminderPriority.MEDIUM.name) }
    var selectedFrequency by remember { mutableStateOf(initialReminder?.frequency ?: ReminderFrequency.MONTHLY.name) }
    var dueDaysFromNowStr by remember {
        val currentDay = System.currentTimeMillis() / 86400000L
        val diff = if (initialReminder != null && initialReminder.dueDateEpochDay > 0) {
            (initialReminder.dueDateEpochDay - currentDay).coerceAtLeast(0)
        } else {
            3
        }
        mutableStateOf(diff.toString())
    }
    var associatedAccount by remember { mutableStateOf(initialReminder?.associatedAccount ?: "") }
    var notes by remember { mutableStateOf(initialReminder?.notes ?: "") }

    val isEditing = initialReminder != null

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = if (isEditing) "Edit Financial Reminder" else "Add Financial Reminder",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Reminder Title *") },
                    placeholder = { Text("e.g. Parag Parikh SIP, Electricity Bill") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = amountStr,
                        onValueChange = { amountStr = it },
                        label = { Text("Amount (₹) *") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = dueDaysFromNowStr,
                        onValueChange = { dueDaysFromNowStr = it },
                        label = { Text("Due In (Days) *") },
                        placeholder = { Text("e.g. 1, 5, 30") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text("Reminder Type", style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    ReminderType.entries.forEach { type ->
                        FilterChip(
                            selected = selectedType == type.name,
                            onClick = { selectedType = type.name },
                            label = { Text(type.displayName) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

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

                OutlinedTextField(
                    value = associatedAccount,
                    onValueChange = { associatedAccount = it },
                    label = { Text("Debit Account / Card") },
                    placeholder = { Text("e.g. HDFC Salary Account") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    label = { Text("Notes / Instructions") },
                    placeholder = { Text("e.g. Pay before 5 PM to avoid penalty") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            val amt = amountStr.toDoubleOrNull() ?: 0.0
                            val days = dueDaysFromNowStr.toLongOrNull() ?: 3L
                            val dueDayEpoch = (System.currentTimeMillis() / 86400000L) + days

                            if (title.isNotBlank()) {
                                val reminder = FinancialReminder(
                                    id = initialReminder?.id ?: 0L,
                                    title = title.trim(),
                                    amount = amt,
                                    reminderType = selectedType,
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
                        Text(if (isEditing) "Update Reminder" else "Save Reminder")
                    }
                }
            }
        }
    }
}
