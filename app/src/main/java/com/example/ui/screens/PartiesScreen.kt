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
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.TrendingDown
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.data.model.FinancialItem
import com.example.data.model.ItemCategory
import com.example.data.model.OwnerProfile
import com.example.ui.theme.AssetGreen
import com.example.ui.theme.LiabilityRed
import com.example.ui.theme.PrimaryGreen
import com.example.ui.utils.NumberFormatUtils
import com.example.ui.viewmodel.NetWorthViewModel

@Composable
fun PartiesScreen(
    viewModel: NetWorthViewModel
) {
    val context = LocalContext.current
    val allItems by viewModel.filteredItems.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val customCategories by viewModel.customCategories.collectAsState()

    // Filter to only show party-related categories
    val basePartyCategories = listOf(
        ItemCategory.BANK_ACCOUNT.displayName,
        ItemCategory.SUNDRY_CREDITORS.displayName,
        ItemCategory.SUNDRY_DEBTORS.displayName,
        ItemCategory.EXPENSE.displayName,
        ItemCategory.LOAN_LIABILITY.displayName,
        ItemCategory.OTHER_ACCOUNT.displayName
    )
    val partyCategories = basePartyCategories + customCategories

    var selectedCategory by remember { mutableStateOf("All") }

    val items = allItems.filter { item ->
        val matchesSearch = item.title.contains(searchQuery, ignoreCase = true) ||
                            item.institution.contains(searchQuery, ignoreCase = true) ||
                            item.accountNumber.contains(searchQuery, ignoreCase = true)
        
        val isPartyType = partyCategories.contains(item.category)
        val matchesCat = if (selectedCategory == "All") isPartyType else item.category == selectedCategory
        
        matchesSearch && matchesCat
    }

    var showAddDialog by remember { mutableStateOf(false) }
    var editingItem by remember { mutableStateOf<FinancialItem?>(null) }
    var showManageCategories by remember { mutableStateOf(false) }

    if (showManageCategories) {
        ManageCategoriesDialog(
            viewModel = viewModel,
            onDismiss = { showManageCategories = false }
        )
    }

    if (showAddDialog || editingItem != null) {
        AddPartyDialog(
            viewModel = viewModel,
            initialItem = editingItem,
            partyCategories = partyCategories,
            onManageCategories = { showManageCategories = true },
            onDismiss = {
                showAddDialog = false
                editingItem = null
            },
            onSave = { savedItem ->
                viewModel.saveFinancialItem(savedItem)
                showAddDialog = false
                editingItem = null
                Toast.makeText(context, "Saved ${savedItem.title}", Toast.LENGTH_SHORT).show()
            }
        )
    }

    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true },
                containerColor = PrimaryGreen,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                shape = CircleShape
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Party")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
        ) {
            // Header & Search
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Parties & Accounts",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Manage your bank accounts, creditors, debtors, and more",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { viewModel.searchQuery.value = it },
                    placeholder = { Text("Search parties...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Category Filters
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    val displayCategories = listOf("All") + partyCategories
                    displayCategories.forEach { cat ->
                        FilterChip(
                            selected = selectedCategory == cat,
                            onClick = { selectedCategory = cat },
                            label = { Text(cat) }
                        )
                    }
                }
            }

            // List of items
            if (items.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No parties match current filters. Tap + to add a party!",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 80.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(items, key = { it.id }) { item ->
                        PartyDetailCard(
                            item = item,
                            onEdit = { editingItem = item },
                            onDelete = {
                                viewModel.deleteFinancialItem(item)
                                Toast.makeText(context, "Deleted ${item.title}", Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PartyDetailCard(
    item: FinancialItem,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onEdit() },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    if (item.institution.isNotBlank()) {
                        Text(
                            text = "Mobile: ${item.institution}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    if (item.accountNumber.isNotBlank()) {
                        Text(
                            text = "GSTIN: ${item.accountNumber}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = NumberFormatUtils.formatCurrency(item.currentValue),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = if (item.isLiability) LiabilityRed else AssetGreen
                    )
                    Text(
                        text = "Balance",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    Text(
                        text = item.category,
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
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

@Composable
fun AddPartyDialog(
    viewModel: NetWorthViewModel,
    initialItem: FinancialItem? = null,
    partyCategories: List<String>,
    onManageCategories: () -> Unit,
    onDismiss: () -> Unit,
    onSave: (FinancialItem) -> Unit
) {
    var partyName by remember { mutableStateOf(initialItem?.title ?: "") }
    var mobileNumber by remember { mutableStateOf(initialItem?.institution ?: "") }
    var gstin by remember { mutableStateOf(initialItem?.accountNumber ?: "") }
    var openingBalanceStr by remember { mutableStateOf(initialItem?.let { String.format("%.0f", it.currentValue) } ?: "") }
    var accountType by remember { mutableStateOf(initialItem?.category ?: ItemCategory.BANK_ACCOUNT.displayName) }

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
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = if (initialItem != null) "Edit Party" else "Add Party",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = if (partyName.isNotBlank()) "Ready to save" else "Enter party name to save",
                                style = MaterialTheme.typography.bodySmall,
                                color = if (partyName.isNotBlank()) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
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
                        OutlinedTextField(
                            value = partyName,
                            onValueChange = { partyName = it },
                            label = { Text("Party Name *") },
                            placeholder = { Text("e.g. Acme Corp / Rahul Sharma") },
                            supportingText = if (partyName.isBlank()) {
                                { Text("Party name is required", color = MaterialTheme.colorScheme.error) }
                            } else null,
                            isError = partyName.isBlank(),
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        OutlinedTextField(
                            value = mobileNumber,
                            onValueChange = { mobileNumber = it },
                            label = { Text("Mobile Number") },
                            placeholder = { Text("e.g. 9876543210") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        OutlinedTextField(
                            value = gstin,
                            onValueChange = { gstin = it },
                            label = { Text("GSTIN (Optional)") },
                            placeholder = { Text("e.g. 27AAAAA0000A1Z5") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        OutlinedTextField(
                            value = openingBalanceStr,
                            onValueChange = { openingBalanceStr = it },
                            label = { Text("Opening Balance (₹) *") },
                            placeholder = { Text("0.00") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Account Type", style = MaterialTheme.typography.labelMedium)
                            TextButton(onClick = onManageCategories) {
                                Text("Manage")
                            }
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            partyCategories.forEach { cat ->
                                FilterChip(
                                    selected = accountType == cat,
                                    onClick = { accountType = cat },
                                    label = { Text(cat) }
                                )
                            }
                        }
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
                                val bal = openingBalanceStr.toDoubleOrNull() ?: 0.0
                                if (partyName.isNotBlank()) {
                                    val isLiab = accountType == ItemCategory.SUNDRY_CREDITORS.displayName || 
                                                 accountType == ItemCategory.EXPENSE.displayName || 
                                                 accountType == ItemCategory.LOAN_LIABILITY.displayName
                                                 
                                    val item = FinancialItem(
                                        id = initialItem?.id ?: 0L,
                                        title = partyName.trim(),
                                        institution = mobileNumber.trim(),
                                        accountNumber = gstin.trim(),
                                        owner = initialItem?.owner ?: OwnerProfile.SELF.displayName,
                                        category = accountType,
                                        currentValue = bal,
                                        investedValue = bal,
                                        isLiability = isLiab,
                                        notes = initialItem?.notes ?: "",
                                        updatedAt = System.currentTimeMillis()
                                    )
                                    onSave(item)
                                }
                            },
                            shape = RoundedCornerShape(12.dp),
                            enabled = partyName.isNotBlank()
                        ) {
                            Text(if (initialItem != null) "Update Party" else "Save Party")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ManageCategoriesDialog(
    viewModel: NetWorthViewModel,
    onDismiss: () -> Unit
) {
    val customCategories by viewModel.customCategories.collectAsState()
    var newCategory by remember { mutableStateOf("") }

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
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Manage Account Types", 
                            style = MaterialTheme.typography.titleMedium, 
                            fontWeight = FontWeight.Bold
                        )
                        IconButton(onClick = safeDismiss) {
                            Icon(Icons.Default.Close, contentDescription = "Close")
                        }
                    }

                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f, fill = false)
                            .verticalScroll(rememberScrollState())
                            .padding(horizontal = 20.dp, vertical = 14.dp)
                    ) {
                        LazyColumn(modifier = Modifier.heightIn(max = 220.dp)) {
                            items(customCategories) { cat ->
                                var isEditing by remember { mutableStateOf(false) }
                                var editValue by remember { mutableStateOf(cat) }
                                
                                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                                    if (isEditing) {
                                        OutlinedTextField(
                                            value = editValue,
                                            onValueChange = { editValue = it },
                                            modifier = Modifier.weight(1f),
                                            shape = RoundedCornerShape(12.dp)
                                        )
                                        IconButton(onClick = { 
                                            if(editValue.isNotBlank()) {
                                                viewModel.updateCustomCategory(cat, editValue)
                                            }
                                            isEditing = false 
                                        }) { Icon(Icons.Default.Check, contentDescription = "Save", tint = PrimaryGreen) }
                                    } else {
                                        Text(cat, modifier = Modifier.weight(1f))
                                        IconButton(onClick = { isEditing = true }) { 
                                            Icon(Icons.Default.Edit, contentDescription = "Edit", modifier = Modifier.size(20.dp)) 
                                        }
                                        IconButton(onClick = { viewModel.deleteCustomCategory(cat) }) { 
                                            Icon(Icons.Default.Delete, contentDescription = "Delete", tint = LiabilityRed, modifier = Modifier.size(20.dp)) 
                                        }
                                    }
                                }
                            }
                        }

                        if (customCategories.isEmpty()) {
                            Text("No custom types added yet.", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            OutlinedTextField(
                                value = newCategory,
                                onValueChange = { newCategory = it },
                                label = { Text("New Account Type") },
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(12.dp)
                            )
                            IconButton(onClick = { 
                                if(newCategory.isNotBlank()) {
                                    viewModel.addCustomCategory(newCategory)
                                    newCategory = ""
                                }
                            }) {
                                Icon(Icons.Default.Add, contentDescription = "Add", tint = PrimaryGreen)
                            }
                        }
                    }

                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(
                            onClick = safeDismiss, 
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen)
                        ) {
                            Text("Close")
                        }
                    }
                }
            }
        }
    }
}
