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
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.data.model.FinancialItem
import com.example.data.model.ItemCategory
import com.example.data.model.OwnerProfile
import com.example.ui.theme.AssetGreen
import com.example.ui.theme.LiabilityRed
import com.example.ui.theme.PrimaryGreen

@Composable
fun AddEditItemDialog(
    initialItem: FinancialItem? = null,
    onDismiss: () -> Unit,
    onSave: (FinancialItem) -> Unit
) {
    var title by remember { mutableStateOf(initialItem?.title ?: "") }
    var institution by remember { mutableStateOf(initialItem?.institution ?: "") }
    var accountNumber by remember { mutableStateOf(initialItem?.accountNumber ?: "") }
    var selectedOwner by remember { mutableStateOf(initialItem?.owner ?: OwnerProfile.SELF.displayName) }
    var selectedCategory by remember { mutableStateOf(initialItem?.category ?: ItemCategory.BANK_ACCOUNT.displayName) }
    var currentValueStr by remember { mutableStateOf(initialItem?.let { String.format("%.0f", it.currentValue) } ?: "") }
    var investedValueStr by remember { mutableStateOf(initialItem?.let { String.format("%.0f", it.investedValue) } ?: "") }
    var isLiability by remember { mutableStateOf(initialItem?.isLiability ?: false) }
    var notes by remember { mutableStateOf(initialItem?.notes ?: "") }

    val isEditing = initialItem != null

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
                    text = if (isEditing) "Edit Financial Item" else "Add Financial Item",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Title
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title / Asset Name *") },
                    placeholder = { Text("e.g. HDFC Salary, Reliance Stock") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Institution & Account
                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = institution,
                        onValueChange = { institution = it },
                        label = { Text("Institution / Broker") },
                        placeholder = { Text("e.g. Zerodha, SBI") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = accountNumber,
                        onValueChange = { accountNumber = it },
                        label = { Text("Account / Folio") },
                        placeholder = { Text("e.g. 50 qty, ••4829") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Values
                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = currentValueStr,
                        onValueChange = { currentValueStr = it },
                        label = { Text("Current Value (₹) *") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = investedValueStr,
                        onValueChange = { investedValueStr = it },
                        label = { Text("Invested Value (₹)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Owner Selection
                Text("Owner Profile", style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    OwnerProfile.entries.forEach { profile ->
                        FilterChip(
                            selected = selectedOwner.equals(profile.displayName, ignoreCase = true),
                            onClick = { selectedOwner = profile.displayName },
                            label = { Text(profile.displayName) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Category Selection
                Text("Category", style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    ItemCategory.entries.forEach { cat ->
                        FilterChip(
                            selected = selectedCategory.equals(cat.displayName, ignoreCase = true),
                            onClick = {
                                selectedCategory = cat.displayName
                                if (cat.isLiability) {
                                    isLiability = true
                                }
                            },
                            label = { Text(cat.displayName) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Liability toggle
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Is this a Liability / Debt?",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = if (isLiability) "Deducts from your total Net Worth" else "Adds to your total Assets",
                            style = MaterialTheme.typography.bodySmall,
                            color = if (isLiability) LiabilityRed else AssetGreen
                        )
                    }
                    Switch(
                        checked = isLiability,
                        onCheckedChange = { isLiability = it }
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Notes
                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    label = { Text("Notes / Strategy") },
                    placeholder = { Text("e.g. Long-term hold, 10k monthly SIP") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Actions
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
                            val cVal = currentValueStr.toDoubleOrNull() ?: 0.0
                            val iVal = investedValueStr.toDoubleOrNull() ?: cVal
                            if (title.isNotBlank() && cVal >= 0) {
                                val item = FinancialItem(
                                    id = initialItem?.id ?: 0L,
                                    title = title.trim(),
                                    institution = institution.trim(),
                                    accountNumber = accountNumber.trim(),
                                    owner = selectedOwner,
                                    category = selectedCategory,
                                    currentValue = cVal,
                                    investedValue = iVal,
                                    isLiability = isLiability,
                                    notes = notes.trim(),
                                    updatedAt = System.currentTimeMillis()
                                )
                                onSave(item)
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isLiability) LiabilityRed else PrimaryGreen
                        ),
                        enabled = title.isNotBlank()
                    ) {
                        Text(if (isEditing) "Update Item" else "Save Item")
                    }
                }
            }
        }
    }
}
