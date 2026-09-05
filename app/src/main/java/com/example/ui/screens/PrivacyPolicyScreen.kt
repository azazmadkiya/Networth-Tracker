package com.example.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.theme.PrimaryGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicyScreen(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Privacy Policy") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Header card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = PrimaryGreen.copy(alpha = 0.1f))
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Policy,
                        contentDescription = null,
                        tint = PrimaryGreen,
                        modifier = Modifier.size(36.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Privacy Policy & Transparency",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryGreen
                        )
                        Text(
                            text = "Last Updated: September 2026 • 100% Offline-First",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            PolicyCard(
                icon = Icons.Default.Storage,
                title = "1. Local Database & Data Sovereignty",
                content = "Net Worth Tracker is engineered with an offline-first architecture. All user data—including bank accounts, investment assets, real estate holdings, gold valuations, liabilities, EMIs, income and expense entries, and reminder notifications—is stored locally in a private Room SQLite database on your device.\n\n" +
                        "• No Remote Server Storage: We operate no remote databases or cloud servers that sync or receive your financial details.\n" +
                        "• No Account Telemetry: No analytics platforms, tracking cookies, or user identifiers are collected."
            )

            Spacer(modifier = Modifier.height(14.dp))

            PolicyCard(
                icon = Icons.Default.Mic,
                title = "2. Microphone & Voice Assistant (RECORD_AUDIO)",
                content = "When you tap the Voice Control icon, the application requests the RECORD_AUDIO permission to capture verbal instructions (such as adding reminders, bank accounts, or financial transactions):\n\n" +
                        "• Ephemeral Processing: Audio streams are processed strictly in real-time by the Android SpeechRecognizer service on your device.\n" +
                        "• No Audio File Retention: No audio recordings, audio clips, or voice samples are saved, cached on disk, or transferred to any remote servers.\n" +
                        "• User-Initiated Only: Microphone recording operates only when the voice dialog is actively open on screen."
            )

            Spacer(modifier = Modifier.height(14.dp))

            PolicyCard(
                icon = Icons.Default.Notifications,
                title = "3. System Notifications & Reminders (POST_NOTIFICATIONS)",
                content = "The application requests the POST_NOTIFICATIONS permission (on Android 13+) to deliver timely local alerts regarding upcoming SIP deposits, EMI due dates, and critical bill deadlines:\n\n" +
                        "• 100% Local Notifications: All notifications are triggered and managed on-device through the Android NotificationManager system.\n" +
                        "• Zero Cloud Push Tokens: We do NOT use Firebase Cloud Messaging (FCM), OneSignal, or any remote servers to send notifications.\n" +
                        "• Fully Granular Control: You can disable or re-enable notifications at any time directly in the app's Settings or device notification channels."
            )

            Spacer(modifier = Modifier.height(14.dp))

            PolicyCard(
                icon = Icons.Default.Cloud,
                title = "4. Internet Permission (INTERNET) - Voice Control Only",
                content = "The application includes the android.permission.INTERNET permission with strict architectural boundaries:\n\n" +
                        "• Strictly Restricted to Voice Control: Internet access is accessed ONLY by the Android SpeechRecognizer service when you explicitly choose 'Yes' to enable online speech recognition for enhanced accuracy.\n" +
                        "• User-Driven Choice (Yes / No): You maintain 100% control. When you select 'No', voice recognition runs completely offline on-device with zero network connectivity.\n" +
                        "• Zero Cloud Financial Tracking: Your financial assets, liabilities, reminders, accounts, ledger entries, and net worth calculations remain 100% offline in local Room SQLite storage and NEVER transmit over the internet."
            )

            Spacer(modifier = Modifier.height(14.dp))

            PolicyCard(
                icon = Icons.Default.Fingerprint,
                title = "5. Biometric Authentication (Fingerprint & Face)",
                content = "The application supports biometric authentication via the AndroidX BiometricPrompt API (USE_BIOMETRIC and USE_FINGERPRINT):\n\n" +
                        "• Hardware Module Enclave: Biometric checks are executed entirely by your device's secure hardware enclave (TEE/Secure Element).\n" +
                        "• Zero App Access: The application never sees, collects, transmits, or stores your fingerprint or facial geometry data.\n" +
                        "• Optional Security: Biometric authentication can be enabled or disabled at any time in Settings."
            )

            Spacer(modifier = Modifier.height(14.dp))

            PolicyCard(
                icon = Icons.Default.Share,
                title = "6. User-Directed Financial Sharing",
                content = "The application allows you to share individual transaction receipts, income/expense entries, and ledger statements via WhatsApp, SMS, Email, or other communication apps:\n\n" +
                        "• 100% User Controlled: Sharing occurs strictly through the standard Android Share Sheet upon your explicit click.\n" +
                        "• No Third-Party Intermediaries: No third-party servers capture or intermediate shared messages."
            )

            Spacer(modifier = Modifier.height(14.dp))

            PolicyCard(
                icon = Icons.Default.Security,
                title = "7. Encryption & Data Security",
                content = "App credentials, profile selections, and biometric flags are protected using AndroidX Security Crypto (EncryptedSharedPreferences) backed by the Android Keystore system. Data is isolated within the Android application sandbox."
            )

            Spacer(modifier = Modifier.height(14.dp))

            PolicyCard(
                icon = Icons.Default.DeleteForever,
                title = "8. Data Deletion & Right to Erasure",
                content = "You have full autonomy over your data. You can instantly erase all database records, snapshots, reminders, and reset your credentials by tapping 'Wipe All Financial Data' in the Settings screen. Once confirmed, all local database tables are purged immediately."
            )

            Spacer(modifier = Modifier.height(14.dp))

            PolicyCard(
                icon = Icons.Default.Policy,
                title = "7. Children's Privacy & COPPA",
                content = "Net Worth Tracker is designed for general audiences and personal financial bookkeeping. The application does not knowingly collect, store, or solicit personal information from children under 13 years of age."
            )
        }
    }
}

@Composable
fun PolicyCard(
    icon: ImageVector,
    title: String,
    content: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(icon, contentDescription = null, tint = PrimaryGreen, modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = MaterialTheme.typography.bodyLarge.lineHeight
            )
        }
    }
}
