package com.example.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
    preselectedCategory: String? = null,
    onDismiss: () -> Unit,
    onSave: (FinancialItem) -> Unit
) {
    var title by remember { mutableStateOf(initialItem?.title ?: "") }
    var institution by remember { mutableStateOf(initialItem?.institution ?: "") }
    var accountNumber by remember { mutableStateOf(initialItem?.accountNumber ?: "") }
    var selectedOwner by remember { mutableStateOf(initialItem?.owner ?: OwnerProfile.SELF.displayName) }
    var selectedCategory by remember { 
        mutableStateOf(initialItem?.category ?: preselectedCategory ?: ItemCategory.BANK_ACCOUNT.displayName) 
    }
    var currentValueStr by remember { mutableStateOf(initialItem?.let { String.format("%.0f", it.currentValue) } ?: "") }
    var investedValueStr by remember { mutableStateOf(initialItem?.let { String.format("%.0f", it.investedValue) } ?: "") }
    var isLiability by remember { mutableStateOf(initialItem?.isLiability ?: false) }
    var notes by remember { mutableStateOf(initialItem?.notes ?: "") }

    // Stock-specific quantity and purchase price helper states
    var stockQuantityStr by remember { mutableStateOf("") }
    var stockBuyPriceStr by remember { mutableStateOf("") }
    var stockCmpStr by remember { mutableStateOf("") }

    val isEditing = initialItem != null
    val isStockCategory = selectedCategory.equals(ItemCategory.SHARE_MARKET.displayName, ignoreCase = true)

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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (isStockCategory) {
                        Icon(
                            imageVector = Icons.Default.ShowChart,
                            contentDescription = null,
                            tint = PrimaryGreen,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    Text(
                        text = when {
                            isEditing -> "Edit Financial Item"
                            isStockCategory -> "Add Stock / Share Entry"
                            else -> "Add Financial Item"
                        },
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Title
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { 
                        Text(if (isStockCategory) "Stock / Company / Symbol *" else "Title / Asset Name *") 
                    },
                    placeholder = { 
                        Text(if (isStockCategory) "e.g. Reliance Industries, TCS, TATA MOTORS" else "e.g. HDFC Salary, Reliance Stock") 
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Institution & Account / Broker
                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = institution,
                        onValueChange = { institution = it },
                        label = { Text(if (isStockCategory) "Broker / Demat" else "Institution / Broker") },
                        placeholder = { Text(if (isStockCategory) "Zerodha, Groww, Angel One" else "e.g. Zerodha, SBI") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = accountNumber,
                        onValueChange = { accountNumber = it },
                        label = { Text(if (isStockCategory) "Qty / Folio" else "Account / Folio") },
                        placeholder = { Text(if (isStockCategory) "e.g. 50 shares" else "e.g. ••4829") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Stock Quick Auto-Calculator (if Share Market category is selected)
                if (isStockCategory) {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp),
                        color = PrimaryGreen.copy(alpha = 0.08f)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Calculate,
                                    contentDescription = null,
                                    tint = PrimaryGreen,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Stock Calculator (Optional)",
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = PrimaryGreen
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Enter Quantity and Prices to auto-calculate Invested & Current Value",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                OutlinedTextField(
                                    value = stockQuantityStr,
                                    onValueChange = { q ->
                                        stockQuantityStr = q
                                        val qty = q.toDoubleOrNull()
                                        if (qty != null && qty > 0) {
                                            accountNumber = "${q.trim()} shares"
                                            val buy = stockBuyPriceStr.toDoubleOrNull()
                                            if (buy != null && buy > 0) {
                                                investedValueStr = String.format("%.0f", qty * buy)
                                            }
                                            val cmp = stockCmpStr.toDoubleOrNull()
                                            if (cmp != null && cmp > 0) {
                                                currentValueStr = String.format("%.0f", qty * cmp)
                                            }
                                        }
                                    },
                                    label = { Text("Qty") },
                                    placeholder = { Text("50") },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    modifier = Modifier.weight(1f),
                                    shape = RoundedCornerShape(10.dp)
                                )

                                OutlinedTextField(
                                    value = stockBuyPriceStr,
                                    onValueChange = { bp ->
                                        stockBuyPriceStr = bp
                                        val buy = bp.toDoubleOrNull()
                                        val qty = stockQuantityStr.toDoubleOrNull()
                                        if (buy != null && buy > 0 && qty != null && qty > 0) {
                                            investedValueStr = String.format("%.0f", qty * buy)
                                        }
                                    },
                                    label = { Text("Buy Price") },
                                    placeholder = { Text("₹") },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    modifier = Modifier.weight(1.2f),
                                    shape = RoundedCornerShape(10.dp)
                                )

                                OutlinedTextField(
                                    value = stockCmpStr,
                                    onValueChange = { cmp ->
                                        stockCmpStr = cmp
                                        val price = cmp.toDoubleOrNull()
                                        val qty = stockQuantityStr.toDoubleOrNull()
                                        if (price != null && price > 0 && qty != null && qty > 0) {
                                            currentValueStr = String.format("%.0f", qty * price)
                                        }
                                    },
                                    label = { Text("Current CMP") },
                                    placeholder = { Text("₹") },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    modifier = Modifier.weight(1.2f),
                                    shape = RoundedCornerShape(10.dp)
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }

                // Values
                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = currentValueStr,
                        onValueChange = { currentValueStr = it },
                        label = { Text(if (isStockCategory) "Current Total Value (₹) *" else "Current Value (₹) *") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = investedValueStr,
                        onValueChange = { investedValueStr = it },
                        label = { Text(if (isStockCategory) "Total Buy/Invested (₹)" else "Invested Value (₹)") },
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
                                } else if (cat == ItemCategory.SHARE_MARKET) {
                                    isLiability = false
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
                    label = { Text(if (isStockCategory) "Stock Strategy / Notes" else "Notes / Strategy") },
                    placeholder = { 
                        Text(if (isStockCategory) "e.g. Long-term bluechip, Target ₹3500" else "e.g. Long-term hold, 10k monthly SIP") 
                    },
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
                        Text(if (isEditing) "Update Item" else if (isStockCategory) "Save Stock" else "Save Item")
                    }
                }
            }
        }
    }
}
