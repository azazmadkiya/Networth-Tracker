package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.components.VoiceAssistantDialog
import com.example.ui.theme.LiabilityRed
import com.example.ui.theme.PrimaryGreen
import com.example.ui.viewmodel.NetWorthViewModel

@Composable
fun SettingsScreen(
    viewModel: NetWorthViewModel,
    onNavigateToSubScreen: (SettingsSubScreen) -> Unit,
    onLogout: () -> Unit
) {
    val context = LocalContext.current
    var showPasswordDialog by remember { mutableStateOf(false) }
    var newPassword by remember { mutableStateOf("") }

    var showImportDialog by remember { mutableStateOf(false) }
    var importJsonText by remember { mutableStateOf("") }

    var showClearDataDialog by remember { mutableStateOf(false) }
    var showVoiceDialog by remember { mutableStateOf(false) }

    if (showVoiceDialog) {
        VoiceAssistantDialog(
            viewModel = viewModel,
            onDismiss = { showVoiceDialog = false },
            onNavigate = { _ -> showVoiceDialog = false }
        )
    }

    // Password Dialog
    if (showPasswordDialog) {
        AlertDialog(
            onDismissRequest = { showPasswordDialog = false },
            title = { Text("Change Password") },
            text = {
                OutlinedTextField(
                    value = newPassword,
                    onValueChange = { newPassword = it },
                    label = { Text("New Password") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (newPassword.isNotBlank()) {
                            viewModel.authManager.updatePassword(newPassword.trim())
                            Toast.makeText(context, "Password updated", Toast.LENGTH_SHORT).show()
                            showPasswordDialog = false
                            newPassword = ""
                        }
                    }
                ) {
                    Text("Update")
                }
            },
            dismissButton = {
                TextButton(onClick = { showPasswordDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Import Dialog
    if (showImportDialog) {
        AlertDialog(
            onDismissRequest = { showImportDialog = false },
            title = { Text("Import JSON Backup") },
            text = {
                Column {
                    Text("Paste your exported JSON data below:")
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = importJsonText,
                        onValueChange = { importJsonText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        placeholder = { Text("{\"items\": [...], \"reminders\": [...]}") }
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (importJsonText.isNotBlank()) {
                            viewModel.importBackupJson(importJsonText) { success ->
                                if (success) {
                                    Toast.makeText(context, "Backup restored successfully!", Toast.LENGTH_SHORT).show()
                                    showImportDialog = false
                                    importJsonText = ""
                                } else {
                                    Toast.makeText(context, "Failed to parse JSON backup", Toast.LENGTH_LONG).show()
                                }
                            }
                        }
                    }
                ) {
                    Text("Import")
                }
            },
            dismissButton = {
                TextButton(onClick = { showImportDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Clear Data Confirmation Dialog
    if (showClearDataDialog) {
        AlertDialog(
            onDismissRequest = { showClearDataDialog = false },
            title = { Text("Wipe All Data?") },
            text = { Text("This will permanently delete all your financial items, ledger entries, reminders, and snapshots. This action cannot be undone.") },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.clearAllData()
                        Toast.makeText(context, "All data wiped", Toast.LENGTH_SHORT).show()
                        showClearDataDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = LiabilityRed)
                ) {
                    Text("Wipe Data")
                }
            },
            dismissButton = {
                TextButton(onClick = { showClearDataDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Settings & Security",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        // Profile & Auth Card
        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Account & Security", style = MaterialTheme.typography.labelLarge, color = PrimaryGreen, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))

                SettingsRow(
                    icon = Icons.Default.Person,
                    title = "User ID",
                    subtitle = viewModel.authManager.getStoredUserId(),
                    onClick = {}
                )

                SettingsRow(
                    icon = Icons.Default.Key,
                    title = "Change Password",
                    subtitle = "Update local access passkey",
                    onClick = { showPasswordDialog = true }
                )

                SettingsRow(
                    icon = Icons.Default.Mic,
                    title = "Voice Control System",
                    subtitle = "Tap voice symbol to activate voice assistant",
                    onClick = { showVoiceDialog = true }
                )
            }
        }

        // Data & Backup Card
        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Data & Backup", style = MaterialTheme.typography.labelLarge, color = PrimaryGreen, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))

                SettingsRow(
                    icon = Icons.Default.Share,
                    title = "Export Portfolio JSON",
                    subtitle = "Share or copy full database backup",
                    onClick = {
                        val json = viewModel.exportBackupJson()
                        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        val clip = ClipData.newPlainText("NetWorthBackup", json)
                        clipboard.setPrimaryClip(clip)

                        val shareIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, json)
                            putExtra(Intent.EXTRA_SUBJECT, "Net Worth Tracker Backup")
                        }
                        context.startActivity(Intent.createChooser(shareIntent, "Export Backup"))
                    }
                )

                SettingsRow(
                    icon = Icons.Default.Download,
                    title = "Import JSON Backup",
                    subtitle = "Restore portfolio from JSON string",
                    onClick = { showImportDialog = true }
                )

                SettingsRow(
                    icon = Icons.Default.DeleteForever,
                    title = "Clear All Portfolio Data",
                    subtitle = "Reset database to empty state",
                    titleColor = LiabilityRed,
                    onClick = { showClearDataDialog = true }
                )
            }
        }

        // Information & Policy
        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Legal & Info", style = MaterialTheme.typography.labelLarge, color = PrimaryGreen, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))

                SettingsRow(
                    icon = Icons.Default.Notifications,
                    title = "Reminders & Alerts",
                    subtitle = "Manage recurring bills & notifications",
                    onClick = { onNavigateToSubScreen(SettingsSubScreen.REMINDERS) }
                )

                SettingsRow(
                    icon = Icons.Default.Policy,
                    title = "Privacy Policy",
                    subtitle = "100% offline data protection",
                    onClick = { onNavigateToSubScreen(SettingsSubScreen.PRIVACY_POLICY) }
                )

                SettingsRow(
                    icon = Icons.Default.Security,
                    title = "Data Safety Disclosures",
                    subtitle = "Play Store compliance rules",
                    onClick = { onNavigateToSubScreen(SettingsSubScreen.DATA_SAFETY) }
                )

                SettingsRow(
                    icon = Icons.Default.Info,
                    title = "Terms of Service",
                    subtitle = "Usage conditions",
                    onClick = { onNavigateToSubScreen(SettingsSubScreen.TERMS_OF_SERVICE) }
                )

                SettingsRow(
                    icon = Icons.Default.Info,
                    title = "About Net Worth Tracker",
                    subtitle = "Version, creator & features",
                    onClick = { onNavigateToSubScreen(SettingsSubScreen.ABOUT) }
                )
            }
        }

        // Logout button
        Button(
            onClick = {
                viewModel.logout()
                onLogout()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Icon(Icons.Default.Lock, contentDescription = null, tint = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Lock & Logout", color = MaterialTheme.colorScheme.onSurface)
        }
    }
}

@Composable
fun SettingsRow(
    icon: ImageVector,
    title: String,
    subtitle: String,
    titleColor: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.onSurface,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = titleColor, modifier = Modifier.size(22.dp))
        Spacer(modifier = Modifier.width(14.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold, color = titleColor)
            Text(subtitle, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        Icon(Icons.Default.ChevronRight, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}
