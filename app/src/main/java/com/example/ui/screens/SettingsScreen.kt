package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.ContentValues
import android.content.Context
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.viewmodel.NetWorthViewModel
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

enum class SettingsSubScreen {
    PRIVACY_POLICY,
    TERMS_OF_SERVICE,
    DATA_SAFETY,
    ABOUT
}

@Composable
fun SettingsScreen(viewModel: NetWorthViewModel) {
    val context = LocalContext.current
    var showPasswordDialog by remember { mutableStateOf(false) }
    var showExportDialog by remember { mutableStateOf(false) }
    var showImportDialog by remember { mutableStateOf(false) }
    var showDeleteAllConfirmDialog by remember { mutableStateOf(false) }
    var pendingRestoreJson by remember { mutableStateOf<String?>(null) }
    var exportedJsonText by remember { mutableStateOf("") }
    var savedFilePathMsg by remember { mutableStateOf<String?>(null) }
    var importJsonInput by remember { mutableStateOf("") }

    // Sub-screens navigation state
    var activeSubScreen by remember { mutableStateOf<SettingsSubScreen?>(null) }

    if (activeSubScreen != null) {
        when (activeSubScreen) {
            SettingsSubScreen.PRIVACY_POLICY -> {
                PrivacyPolicyScreen(onBack = { activeSubScreen = null })
                return
            }
            SettingsSubScreen.TERMS_OF_SERVICE -> {
                TermsOfServiceScreen(onBack = { activeSubScreen = null })
                return
            }
            SettingsSubScreen.DATA_SAFETY -> {
                DataSafetyScreen(onBack = { activeSubScreen = null })
                return
            }
            SettingsSubScreen.ABOUT -> {
                AboutAppScreen(onBack = { activeSubScreen = null })
                return
            }
            null -> {}
        }
    }

    // SAF Document Launchers for File Manager Integration
    val createDocumentLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.CreateDocument("application/json")
    ) { uri ->
        uri?.let {
            try {
                val jsonText = viewModel.exportBackupJson()
                context.contentResolver.openOutputStream(it)?.use { stream ->
                    stream.write(jsonText.toByteArray())
                }
                Toast.makeText(context, "Backup file saved to File Manager!", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(context, "Failed to save file: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    val openDocumentLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri ->
        uri?.let {
            try {
                val inputStream = context.contentResolver.openInputStream(it)
                val jsonText = inputStream?.bufferedReader()?.use { reader -> reader.readText() }
                if (!jsonText.isNullOrBlank()) {
                    pendingRestoreJson = jsonText
                } else {
                    Toast.makeText(context, "Selected backup file is empty!", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(context, "Failed to read file: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { Spacer(modifier = Modifier.height(8.dp)) }

        // Security & Credentials Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth().testTag("security_settings_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(Icons.Default.Lock, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimaryContainer)
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(text = "Security & Login", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                            Text(
                                text = "ID: ${viewModel.authManager.getStoredUserId()}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedButton(
                            onClick = { showPasswordDialog = true },
                            modifier = Modifier.weight(1f).testTag("change_password_button"),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Change Pass")
                        }

                        Button(
                            onClick = { viewModel.logout() },
                            modifier = Modifier.weight(1f).testTag("logout_button"),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                        ) {
                            Icon(Icons.Default.Logout, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Lock Vault")
                        }
                    }
                }
            }
        }

        // Legal & Play Store Compliance Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth().testTag("legal_compliance_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFF3B82F6).copy(alpha = 0.2f),
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(Icons.Default.Policy, contentDescription = null, tint = Color(0xFF3B82F6))
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(text = "Legal & Play Store Compliance", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                            Text(
                                text = "Privacy policy, terms of service, and store readiness",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        SettingsNavRow(
                            icon = Icons.Default.Shield,
                            iconTint = Color(0xFF10B981),
                            title = "Privacy Policy",
                            subtitle = "100% Offline, Zero Tracking & Hosting Tools",
                            onClick = { activeSubScreen = SettingsSubScreen.PRIVACY_POLICY },
                            tag = "nav_to_privacy_policy"
                        )

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                        SettingsNavRow(
                            icon = Icons.Default.Gavel,
                            iconTint = Color(0xFF3B82F6),
                            title = "Terms of Service & Disclaimer",
                            subtitle = "Personal ledger terms and financial disclaimer",
                            onClick = { activeSubScreen = SettingsSubScreen.TERMS_OF_SERVICE },
                            tag = "nav_to_terms_of_service"
                        )

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                        SettingsNavRow(
                            icon = Icons.Default.Security,
                            iconTint = Color(0xFF8B5CF6),
                            title = "Data Safety & Console Answers",
                            subtitle = "Questionnaire guide for Google Play submission",
                            onClick = { activeSubScreen = SettingsSubScreen.DATA_SAFETY },
                            tag = "nav_to_data_safety"
                        )

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                        SettingsNavRow(
                            icon = Icons.Default.Info,
                            iconTint = Color(0xFFF59E0B),
                            title = "About & Open Source Licenses",
                            subtitle = "Version 1.0.0, developer credit & attributions",
                            onClick = { activeSubScreen = SettingsSubScreen.ABOUT },
                            tag = "nav_to_about"
                        )
                    }
                }
            }
        }

        // Offline Backup & Restore Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth().testTag("backup_settings_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFF059669).copy(alpha = 0.2f),
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(Icons.Default.Upload, contentDescription = null, tint = Color(0xFF059669))
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(text = "Offline Data Backup & Restore", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                            Text(
                                text = "Save backup file to File Manager or restore from file",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Button(
                            onClick = {
                                exportedJsonText = viewModel.exportBackupJson()
                                val path = saveBackupToDownloadsFolder(context, exportedJsonText)
                                savedFilePathMsg = path
                                if (path != null) {
                                    Toast.makeText(context, "Backup file saved to File Manager: $path", Toast.LENGTH_LONG).show()
                                }
                                showExportDialog = true
                            },
                            modifier = Modifier.fillMaxWidth().testTag("export_backup_button"),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669))
                        ) {
                            Icon(Icons.Default.Download, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Create Backup File (Save to File Manager)")
                        }

                        OutlinedButton(
                            onClick = {
                                openDocumentLauncher.launch(arrayOf("application/json", "text/*", "*/*"))
                            },
                            modifier = Modifier.fillMaxWidth().testTag("import_backup_button"),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Icon(Icons.Default.FolderOpen, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Restore Backup File (From File Manager)")
                        }

                        TextButton(
                            onClick = { showImportDialog = true },
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text("Or paste JSON text manually", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }

        // 100% Offline Privacy Guarantee Badge
        item {
            Card(
                modifier = Modifier.fillMaxWidth().testTag("offline_guarantee_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF064E3B))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Shield, contentDescription = null, tint = Color(0xFF34D399), modifier = Modifier.size(28.dp))
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "100% Offline Privacy Guarantee",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "This application requires ZERO internet permissions. All financial numbers, bank balances, stock portfolios, and family account details stay strictly inside your phone's offline SQLite database.",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFFA7F3D0)
                    )
                }
            }
        }

        // Danger Zone: Right to Erasure / Data Deletion (Google Play Mandate)
        item {
            Card(
                modifier = Modifier.fillMaxWidth().testTag("danger_zone_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.3f)),
                border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.error.copy(alpha = 0.4f))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.WarningAmber, contentDescription = null, tint = MaterialTheme.colorScheme.error)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Data Erasure & Reset (GDPR / Play Store)",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.error
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Permanently wipe all local financial assets, transactions, snapshots, ledger records, and reset credentials.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = { showDeleteAllConfirmDialog = true },
                        modifier = Modifier.fillMaxWidth().testTag("btn_delete_all_data"),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                    ) {
                        Icon(Icons.Default.DeleteForever, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Delete All Financial Data & Reset App")
                    }
                }
            }
        }

        // Developer Credit Card Footer
        item {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("developer_credit_footer"),
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Code,
                        contentDescription = "Developer",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Developer By Azazmadkiya",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        letterSpacing = 0.5.sp
                    )
                }
            }
        }

        item { Spacer(modifier = Modifier.height(80.dp)) }
    }

    // Change Password Dialog
    if (showPasswordDialog) {
        var newPass by remember { mutableStateOf("") }
        AlertDialog(
            onDismissRequest = { showPasswordDialog = false },
            title = { Text("Change Offline Password") },
            text = {
                Column {
                    Text("Enter new password for ID '${viewModel.authManager.getStoredUserId()}':")
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = newPass,
                        onValueChange = { newPass = it },
                        label = { Text("New Password") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (newPass.isNotBlank()) {
                            viewModel.authManager.updatePassword(newPass)
                            Toast.makeText(context, "Password updated successfully!", Toast.LENGTH_SHORT).show()
                            showPasswordDialog = false
                        }
                    }
                ) {
                    Text("Save")
                }
            },
            dismissButton = {
                TextButton(onClick = { showPasswordDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Delete All Confirmation Dialog
    if (showDeleteAllConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteAllConfirmDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.WarningAmber, contentDescription = null, tint = MaterialTheme.colorScheme.error)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Permanently Delete All Data?", color = MaterialTheme.colorScheme.error)
                }
            },
            text = {
                Text("This will wipe all accounts, assets, liabilities, ledger history, and snapshots from your phone. This action cannot be undone. Make sure you have exported a backup if needed.")
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.clearAllData()
                        Toast.makeText(context, "All financial records wiped successfully.", Toast.LENGTH_LONG).show()
                        showDeleteAllConfirmDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Yes, Delete Everything")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteAllConfirmDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Export Backup Dialog
    if (showExportDialog) {
        val timeStamp = remember { SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date()) }
        val defaultFileName = "NetWorth_Backup_$timeStamp.json"

        AlertDialog(
            onDismissRequest = { showExportDialog = false },
            title = { Text("Backup Saved & Options") },
            text = {
                Column {
                    if (savedFilePathMsg != null) {
                        Text(
                            text = "✓ Backup saved directly to your phone's File Manager under Downloads:\n$savedFilePathMsg",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF059669)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                    Text("You can also pick a custom location in File Manager or copy the JSON code below:")
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = exportedJsonText,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier.fillMaxWidth().height(140.dp)
                    )
                }
            },
            confirmButton = {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Button(
                        onClick = {
                            createDocumentLauncher.launch(defaultFileName)
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.Save, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Save to Custom Folder")
                    }

                    OutlinedButton(
                        onClick = {
                            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val clip = ClipData.newPlainText("NetWorthBackup", exportedJsonText)
                            clipboard.setPrimaryClip(clip)
                            Toast.makeText(context, "Copied backup JSON to clipboard!", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.ContentCopy, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Copy JSON Code")
                    }
                }
            },
            dismissButton = {
                TextButton(onClick = { showExportDialog = false }) {
                    Text("Done")
                }
            }
        )
    }

    // Import Backup Dialog (Manual Text Paste)
    if (showImportDialog) {
        AlertDialog(
            onDismissRequest = { showImportDialog = false },
            title = { Text("Paste JSON Backup Code") },
            text = {
                Column {
                    Text("Paste your exported JSON backup code below to restore financial records:")
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = importJsonInput,
                        onValueChange = { importJsonInput = it },
                        placeholder = { Text("Paste JSON code here...") },
                        modifier = Modifier.fillMaxWidth().height(160.dp)
                    )
                }
            },
            confirmButton = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Button(
                        onClick = {
                            if (importJsonInput.isNotBlank()) {
                                viewModel.importBackupJson(importJsonInput, clearExisting = false) { success ->
                                    if (success) {
                                        Toast.makeText(context, "Backup merged and appended successfully!", Toast.LENGTH_SHORT).show()
                                        showImportDialog = false
                                        importJsonInput = ""
                                    } else {
                                        Toast.makeText(context, "Invalid JSON format!", Toast.LENGTH_LONG).show()
                                    }
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth().testTag("btn_paste_merge_backup"),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669))
                    ) {
                        Icon(Icons.Default.Upload, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("🔀 Merge with Existing Data")
                    }

                    OutlinedButton(
                        onClick = {
                            if (importJsonInput.isNotBlank()) {
                                viewModel.importBackupJson(importJsonInput, clearExisting = true) { success ->
                                    if (success) {
                                        Toast.makeText(context, "Database replaced with backup data!", Toast.LENGTH_SHORT).show()
                                        showImportDialog = false
                                        importJsonInput = ""
                                    } else {
                                        Toast.makeText(context, "Invalid JSON format!", Toast.LENGTH_LONG).show()
                                    }
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth().testTag("btn_paste_replace_backup"),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFDC2626))
                    ) {
                        Text("⚠️ Replace All Existing Data")
                    }
                }
            },
            dismissButton = {
                TextButton(onClick = { showImportDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // --- RESTORE BACKUP FILE OPTIONS DIALOG (FROM FILE MANAGER) ---
    if (pendingRestoreJson != null) {
        val jsonContent = pendingRestoreJson!!
        AlertDialog(
            onDismissRequest = { pendingRestoreJson = null },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.FolderOpen, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Backup File Restore Options", fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "A valid backup file was loaded from File Manager.",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Choose how you want to restore this data into your offline database:",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFF10B981).copy(alpha = 0.12f),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.4f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text("🔀 Merge & Append to Existing Data", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = Color(0xFF047857))
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                "Appends all backup assets, categories, and ledger transactions to your database without deleting existing items.",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFFEF4444).copy(alpha = 0.12f),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.4f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text("⚠️ Replace All Existing Data", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = Color(0xFFB91C1C))
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                "Wipes current database records first, replacing everything with the records from this backup file.",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            },
            confirmButton = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {
                            viewModel.importBackupJson(jsonContent, clearExisting = false) { success ->
                                if (success) {
                                    Toast.makeText(context, "Backup data merged & appended to existing records successfully!", Toast.LENGTH_LONG).show()
                                    pendingRestoreJson = null
                                } else {
                                    Toast.makeText(context, "Failed to restore backup! Invalid JSON structure.", Toast.LENGTH_LONG).show()
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth().testTag("btn_merge_backup_file_data"),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669))
                    ) {
                        Icon(Icons.Default.Upload, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("🔀 Merge with Existing Data")
                    }

                    OutlinedButton(
                        onClick = {
                            viewModel.importBackupJson(jsonContent, clearExisting = true) { success ->
                                if (success) {
                                    Toast.makeText(context, "Database replaced and backup restored successfully!", Toast.LENGTH_LONG).show()
                                    pendingRestoreJson = null
                                } else {
                                    Toast.makeText(context, "Failed to restore backup! Invalid JSON structure.", Toast.LENGTH_LONG).show()
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth().testTag("btn_replace_backup_file_data"),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFDC2626))
                    ) {
                        Text("⚠️ Replace All Existing Data")
                    }
                }
            },
            dismissButton = {
                TextButton(onClick = { pendingRestoreJson = null }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
private fun SettingsNavRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconTint: Color,
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    tag: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp)
            .testTag(tag),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            shape = RoundedCornerShape(10.dp),
            color = iconTint.copy(alpha = 0.15f),
            modifier = Modifier.size(36.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(imageVector = icon, contentDescription = null, tint = iconTint, modifier = Modifier.size(20.dp))
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyMedium)
            Text(text = subtitle, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
            modifier = Modifier.size(14.dp)
        )
    }
}

private fun saveBackupToDownloadsFolder(context: Context, jsonContent: String): String? {
    return try {
        val fileName = "NetWorth_Backup_${SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())}.json"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val contentValues = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                put(MediaStore.MediaColumns.MIME_TYPE, "application/json")
                put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
            }
            val resolver = context.contentResolver
            val uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)
            if (uri != null) {
                resolver.openOutputStream(uri)?.use { os ->
                    os.write(jsonContent.toByteArray())
                }
                "Downloads/$fileName"
            } else null
        } else {
            val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            if (!downloadsDir.exists()) {
                downloadsDir.mkdirs()
            }
            val file = File(downloadsDir, fileName)
            file.writeText(jsonContent)
            "Downloads/$fileName"
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
