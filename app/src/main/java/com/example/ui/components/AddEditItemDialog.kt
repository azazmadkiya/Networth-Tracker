package com.example.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.data.model.FinancialItem

/**
 * Dialog wrapping the reusable FinancialAssetForm component.
 */
@Composable
fun AddEditItemDialog(
    itemToEdit: FinancialItem? = null,
    existingAssetAccounts: List<FinancialItem> = emptyList(),
    onDismiss: () -> Unit,
    onSave: (FinancialItem) -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = if (itemToEdit == null) "Add Financial Entry" else "Edit Financial Entry",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            FinancialAssetForm(
                itemToEdit = itemToEdit,
                existingAssetAccounts = existingAssetAccounts,
                onSave = onSave,
                onCancel = onDismiss,
                modifier = Modifier.fillMaxWidth()
            )
        },
        confirmButton = {},
        dismissButton = {}
    )
}

