package com.example.ui.screens

import android.Manifest
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Smartphone
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.notification.NotificationHelper
import com.example.data.security.BiometricAuthHelper
import com.example.data.security.BiometricStatus
import com.example.data.security.findFragmentActivity
import com.example.ui.components.VoiceAssistantDialog
import com.example.ui.theme.AssetGreen
import com.example.ui.theme.LiabilityRed
import com.example.ui.theme.PrimaryGreen
import com.example.ui.theme.PrimaryGreenDark
import com.example.ui.viewmodel.NetWorthViewModel

@Composable
fun SettingsScreen(
    viewModel: NetWorthViewModel,
    onNavigateToSubScreen: (SettingsSubScreen) -> Unit,
    onLogout: () -> Unit
) {
    val context = LocalContext.current
    val fragmentActivity = remember(context) { context.findFragmentActivity() }
    val biometricStatus = remember(context) { BiometricAuthHelper.getBiometricStatus(context) }
    var isBiometricEnabled by remember { mutableStateOf(viewModel.authManager.isBiometricEnabled()) }

    val verifyBiometrics = { onVerified: () -> Unit ->
        if (fragmentActivity != null && biometricStatus == BiometricStatus.READY) {
            BiometricAuthHelper.authenticate(
                activity = fragmentActivity,
                title = "Verify Biometric Identity",
                subtitle = "Touch fingerprint sensor or look at camera",
                description = "Confirm authorization to protect local financial database",
                negativeButtonText = "Cancel",
                onSuccess = {
                    onVerified()
                },
                onError = { code, err ->
                    if (code != BiometricPrompt.ERROR_USER_CANCELED && code != BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                        Toast.makeText(context, "Biometric: $err", Toast.LENGTH_SHORT).show()
                    }
                },
                onFailed = {
                    Toast.makeText(context, "Biometric not recognized. Please try again.", Toast.LENGTH_SHORT).show()
                }
            )
        } else if (biometricStatus == BiometricStatus.NOT_ENROLLED) {
            Toast.makeText(context, "No biometrics registered on device. Opening security settings...", Toast.LENGTH_SHORT).show()
            BiometricAuthHelper.openBiometricSettings(context)
        } else {
            Toast.makeText(context, "Biometric hardware unavailable on this device", Toast.LENGTH_SHORT).show()
        }
    }

    var showPasswordDialog by remember { mutableStateOf(false) }
    var newPassword by remember { mutableStateOf("") }

    var showImportDialog by remember { mutableStateOf(false) }
    var importJsonText by remember { mutableStateOf("") }

    var showClearDataDialog by remember { mutableStateOf(false) }
    var showVoiceDialog by remember { mutableStateOf(false) }

    var hasNotificationPermission by remember {
        mutableStateOf(NotificationHelper.hasNotificationPermission(context))
    }
    var hasMicPermission by remember {
        mutableStateOf(NotificationHelper.hasMicrophonePermission(context))
    }
    var isVoiceInternetAllowed by remember {
        mutableStateOf(viewModel.authManager.isVoiceInternetAllowed())
    }
    val offlineBackupSummary by viewModel.offlineBackupSummary.collectAsState()

    val notificationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        hasNotificationPermission = isGranted
        if (isGranted) {
            Toast.makeText(context, "Notifications enabled! Sending test alert...", Toast.LENGTH_SHORT).show()
            NotificationHelper.sendTestNotification(context)
        } else {
            Toast.makeText(context, "Notification permission not granted.", Toast.LENGTH_SHORT).show()
        }
    }

    val micPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        hasMicPermission = isGranted
        if (isGranted) {
            Toast.makeText(context, "Microphone access granted for Voice Assistant!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Microphone permission not granted.", Toast.LENGTH_SHORT).show()
        }
    }

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

    val currentThemeMode by viewModel.themeMode.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // Instagram Developer Hero Card
        Card(
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/azazmadkiya"))
                    context.startActivity(intent)
                },
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF4A56E2), // Vibrant Royal Indigo
                                Color(0xFF833AB4), // Instagram Purple
                                Color(0xFFE1306C), // Instagram Pink/Red
                                Color(0xFFFD1D1D)  // Warm Coral Red
                            )
                        )
                    )
                    .padding(horizontal = 20.dp, vertical = 22.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Made with privacy in mind by",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White.copy(alpha = 0.9f)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "@Azazmadkiya",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = Color.White.copy(alpha = 0.22f),
                        modifier = Modifier.size(46.dp)
                    ) {
                        IconButton(
                            onClick = {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/azazmadkiya"))
                                context.startActivity(intent)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.OpenInNew,
                                contentDescription = "Open Instagram Profile",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
        }

        // Customisation Section (Theme Switcher)
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = "CUSTOMISATION",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
            )

            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFFFFECEE),
                            modifier = Modifier.size(42.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Palette,
                                    contentDescription = null,
                                    tint = Color(0xFFE53935),
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(14.dp))
                        Column {
                            Text(
                                text = "Theme",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "Follow your phone or choose a fixed appearance.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Theme Selection Segmented Container
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            // System option
                            val isSystem = currentThemeMode == "system"
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = if (isSystem) MaterialTheme.colorScheme.surface else Color.Transparent,
                                shadowElevation = if (isSystem) 2.dp else 0.dp,
                                modifier = Modifier
                                    .weight(1f)
                                    .clickable { viewModel.setThemeMode("system") }
                            ) {
                                Row(
                                    modifier = Modifier.padding(vertical = 10.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Smartphone,
                                        contentDescription = null,
                                        tint = if (isSystem) Color(0xFFE53935) else MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "System",
                                        style = MaterialTheme.typography.labelMedium,
                                        fontWeight = if (isSystem) FontWeight.Bold else FontWeight.Normal,
                                        color = if (isSystem) Color(0xFFE53935) else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }

                            // Light option
                            val isLight = currentThemeMode == "light"
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = if (isLight) MaterialTheme.colorScheme.surface else Color.Transparent,
                                shadowElevation = if (isLight) 2.dp else 0.dp,
                                modifier = Modifier
                                    .weight(1f)
                                    .clickable { viewModel.setThemeMode("light") }
                            ) {
                                Row(
                                    modifier = Modifier.padding(vertical = 10.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.LightMode,
                                        contentDescription = null,
                                        tint = if (isLight) Color(0xFFE53935) else MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "Light",
                                        style = MaterialTheme.typography.labelMedium,
                                        fontWeight = if (isLight) FontWeight.Bold else FontWeight.Normal,
                                        color = if (isLight) Color(0xFFE53935) else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }

                            // Dark option
                            val isDark = currentThemeMode == "dark"
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = if (isDark) MaterialTheme.colorScheme.surface else Color.Transparent,
                                shadowElevation = if (isDark) 2.dp else 0.dp,
                                modifier = Modifier
                                    .weight(1f)
                                    .clickable { viewModel.setThemeMode("dark") }
                            ) {
                                Row(
                                    modifier = Modifier.padding(vertical = 10.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.DarkMode,
                                        contentDescription = null,
                                        tint = if (isDark) Color(0xFFE53935) else MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "Dark",
                                        style = MaterialTheme.typography.labelMedium,
                                        fontWeight = if (isDark) FontWeight.Bold else FontWeight.Normal,
                                        color = if (isDark) Color(0xFFE53935) else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

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
                    subtitle = viewModel.authManager.getStoredUserId().ifEmpty { "Not Set" },
                    onClick = {}
                )

                SettingsRow(
                    icon = Icons.Default.Key,
                    title = "Change Password",
                    subtitle = "Update local access passkey",
                    onClick = { showPasswordDialog = true }
                )

                SettingsToggleRow(
                    icon = Icons.Default.Fingerprint,
                    title = "Biometric Lock (Fingerprint / Face)",
                    subtitle = if (isBiometricEnabled) "Securing local database on startup" else biometricStatus.description,
                    checked = isBiometricEnabled,
                    onCheckedChange = { enable ->
                        if (enable) {
                            verifyBiometrics {
                                viewModel.authManager.setBiometricEnabled(true)
                                isBiometricEnabled = true
                                Toast.makeText(context, "Biometric authentication activated for database security", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            viewModel.authManager.setBiometricEnabled(false)
                            isBiometricEnabled = false
                            Toast.makeText(context, "Biometric unlock disabled", Toast.LENGTH_SHORT).show()
                        }
                    }
                )

                if (biometricStatus == BiometricStatus.READY) {
                    SettingsRow(
                        icon = Icons.Default.Security,
                        title = "Test Biometric Sensor",
                        subtitle = "Verify fingerprint or face scanner",
                        onClick = {
                            verifyBiometrics {
                                Toast.makeText(context, "Biometric verification successful!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
                } else if (biometricStatus == BiometricStatus.NOT_ENROLLED) {
                    SettingsRow(
                        icon = Icons.Default.Fingerprint,
                        title = "Enroll Biometrics in Device",
                        subtitle = "Open device settings to register fingerprint or face",
                        onClick = { BiometricAuthHelper.openBiometricSettings(context) }
                    )
                }

                SettingsRow(
                    icon = Icons.Default.Lock,
                    title = "Lock Database & App",
                    subtitle = "Require biometric or password unlock",
                    onClick = {
                        viewModel.logout()
                        onLogout()
                    }
                )

                SettingsRow(
                    icon = Icons.Default.Mic,
                    title = "Voice Control System",
                    subtitle = "Tap voice symbol to activate voice assistant",
                    onClick = { showVoiceDialog = true }
                )
            }
        }

        // App Permissions & Device Hardware Card
        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Permissions & Device Access",
                        style = MaterialTheme.typography.labelLarge,
                        color = PrimaryGreen,
                        fontWeight = FontWeight.Bold
                    )
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = if (hasNotificationPermission && hasMicPermission) AssetGreen.copy(alpha = 0.15f) else PrimaryGreen.copy(alpha = 0.1f)
                    ) {
                        Text(
                            text = if (hasNotificationPermission && hasMicPermission) "All Granted" else "Action Available",
                            style = MaterialTheme.typography.labelSmall,
                            color = if (hasNotificationPermission && hasMicPermission) AssetGreen else PrimaryGreen,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))

                // Notifications
                PermissionStatusRow(
                    icon = Icons.Default.Notifications,
                    title = "System Notifications",
                    subtitle = if (hasNotificationPermission) "Alerts for upcoming SIP payments, EMI dues, and financial deadlines" else "Allow permission to receive timely due date alerts",
                    isGranted = hasNotificationPermission,
                    onRequestPermission = {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                            notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                        } else {
                            Toast.makeText(context, "Notifications enabled on this OS version", Toast.LENGTH_SHORT).show()
                        }
                    },
                    onAction = {
                        val sent = NotificationHelper.sendTestNotification(context)
                        if (sent) {
                            Toast.makeText(context, "🔔 Test alert sent to your status bar!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "Please allow notification permission first.", Toast.LENGTH_SHORT).show()
                        }
                    },
                    actionButtonLabel = "Send Test Alert"
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Microphone
                PermissionStatusRow(
                    icon = Icons.Default.Mic,
                    title = "Microphone (Voice Control)",
                    subtitle = if (hasMicPermission) "Speak commands to record transactions and reminders hands-free" else "Allow permission to use the Voice Assistant",
                    isGranted = hasMicPermission,
                    onRequestPermission = {
                        micPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                    },
                    onAction = {
                        showVoiceDialog = true
                    },
                    actionButtonLabel = "Open Voice Assistant"
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Voice Control Internet Access (User Choice Yes/No)
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .background(
                                        if (isVoiceInternetAllowed) AssetGreen.copy(alpha = 0.15f) else PrimaryGreen.copy(alpha = 0.15f),
                                        CircleShape
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Cloud,
                                    contentDescription = "Voice Internet Access",
                                    tint = if (isVoiceInternetAllowed) AssetGreen else PrimaryGreen,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text("Voice Internet Access", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                                Text(
                                    text = if (isVoiceInternetAllowed)
                                        "Choice: YES • Cloud speech recognition enabled for maximum accuracy."
                                    else
                                        "Choice: NO • Strictly 100% offline speech recognition without internet.",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Spacer(modifier = Modifier.width(6.dp))
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = if (isVoiceInternetAllowed) AssetGreen.copy(alpha = 0.15f) else MaterialTheme.colorScheme.surfaceVariant
                            ) {
                                Text(
                                    text = if (isVoiceInternetAllowed) "YES (Online)" else "NO (Offline)",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isVoiceInternetAllowed) AssetGreen else MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // User Choice YES / NO Chips
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            FilterChip(
                                selected = isVoiceInternetAllowed,
                                onClick = {
                                    viewModel.authManager.setVoiceInternetAllowed(true)
                                    isVoiceInternetAllowed = true
                                    Toast.makeText(context, "Internet access allowed for Voice Control (Yes)", Toast.LENGTH_SHORT).show()
                                },
                                label = { Text("YES (Allow Internet)") },
                                leadingIcon = {
                                    if (isVoiceInternetAllowed) {
                                        Icon(Icons.Default.CheckCircle, contentDescription = null, modifier = Modifier.size(16.dp), tint = AssetGreen)
                                    }
                                },
                                modifier = Modifier.weight(1f)
                            )
                            FilterChip(
                                selected = !isVoiceInternetAllowed,
                                onClick = {
                                    viewModel.authManager.setVoiceInternetAllowed(false)
                                    isVoiceInternetAllowed = false
                                    Toast.makeText(context, "Internet access disabled for Voice Control (No - Offline only)", Toast.LENGTH_SHORT).show()
                                },
                                label = { Text("NO (100% Offline)") },
                                leadingIcon = {
                                    if (!isVoiceInternetAllowed) {
                                        Icon(Icons.Default.CheckCircle, contentDescription = null, modifier = Modifier.size(16.dp))
                                    }
                                },
                                modifier = Modifier.weight(1f)
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Restricted ONLY to voice recognizer. Financial data stays offline.",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "🔒 Zero Financial Cloud Tracking: Internet access is restricted EXCLUSIVELY to speech recognition if enabled. Financial ledger, balances, assets, and liabilities remain 100% offline on your device.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
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

                // Offline Reinstall Recovery Box (Survives APK Uninstall/Reinstall)
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = PrimaryGreen.copy(alpha = 0.08f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Security,
                                contentDescription = null,
                                tint = PrimaryGreen,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Reinstall Data Recovery (100% Offline)",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryGreen
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Your entered financial accounts, balances, and records are safely preserved in offline device storage (Downloads/FamilyNetWorth). Even if you uninstall this APK and reinstall it later, your data is never deleted and recovers completely offline.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        offlineBackupSummary?.let { summary ->
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "📁 Saved Backup: ${summary.itemCount} accounts, ${summary.reminderCount} reminders (${summary.formattedDate})",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.SemiBold,
                                color = PrimaryGreenDark
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            OutlinedButton(
                                onClick = {
                                    viewModel.triggerManualOfflineBackup { success, msg ->
                                        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                                    }
                                },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Save Backup", style = MaterialTheme.typography.labelSmall)
                            }
                            Button(
                                onClick = {
                                    viewModel.restoreFromOfflineBackup { success, msg ->
                                        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Recover Data", style = MaterialTheme.typography.labelSmall)
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

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
                    subtitle = "100% offline, biometric & voice disclosures",
                    onClick = { onNavigateToSubScreen(SettingsSubScreen.PRIVACY_POLICY) }
                )

                SettingsRow(
                    icon = Icons.Default.Gavel,
                    title = "Terms of Service & Disclaimer",
                    subtitle = "Non-advisory terms & backup custody",
                    onClick = { onNavigateToSubScreen(SettingsSubScreen.TERMS_OF_SERVICE) }
                )

                SettingsRow(
                    icon = Icons.Default.Security,
                    title = "Data Safety & Console Answers",
                    subtitle = "Play Store Data Safety questionnaire guide",
                    onClick = { onNavigateToSubScreen(SettingsSubScreen.DATA_SAFETY) }
                )

                SettingsRow(
                    icon = Icons.Default.VerifiedUser,
                    title = "Legal & Play Store Compliance",
                    subtitle = "Permissions, storage & integrity policies",
                    onClick = { onNavigateToSubScreen(SettingsSubScreen.PLAY_COMPLIANCE) }
                )

                SettingsRow(
                    icon = Icons.Default.Code,
                    title = "About & Open Source Licenses",
                    subtitle = "Third-party attributions & Apache 2.0 notices",
                    onClick = { onNavigateToSubScreen(SettingsSubScreen.OPEN_SOURCE_LICENSES) }
                )

                SettingsRow(
                    icon = Icons.Default.Info,
                    title = "About Net Worth Tracker",
                    subtitle = "Version, capabilities & architecture",
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

@Composable
fun SettingsToggleRow(
    icon: ImageVector,
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCheckedChange(!checked) }
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = PrimaryGreen, modifier = Modifier.size(22.dp))
        Spacer(modifier = Modifier.width(14.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
            Text(subtitle, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = PrimaryGreen
            )
        )
    }
}

@Composable
fun PermissionStatusRow(
    icon: ImageVector,
    title: String,
    subtitle: String,
    isGranted: Boolean,
    onRequestPermission: () -> Unit,
    onAction: () -> Unit,
    actionButtonLabel: String
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .background(if (isGranted) AssetGreen.copy(alpha = 0.15f) else PrimaryGreen.copy(alpha = 0.15f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        tint = if (isGranted) AssetGreen else PrimaryGreen,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                    Text(subtitle, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
                Spacer(modifier = Modifier.width(6.dp))
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = if (isGranted) AssetGreen.copy(alpha = 0.15f) else LiabilityRed.copy(alpha = 0.15f)
                ) {
                    Text(
                        text = if (isGranted) "Granted" else "Needed",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = if (isGranted) AssetGreen else LiabilityRed,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (!isGranted) {
                    Button(
                        onClick = onRequestPermission,
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Grant Permission", style = MaterialTheme.typography.labelSmall)
                    }
                } else {
                    Button(
                        onClick = onAction,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryGreen.copy(alpha = 0.15f),
                            contentColor = PrimaryGreen
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(actionButtonLabel, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

