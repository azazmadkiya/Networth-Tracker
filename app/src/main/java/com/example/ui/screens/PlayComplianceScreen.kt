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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material.icons.filled.VerifiedUser
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
fun PlayComplianceScreen(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Legal & Play Store Compliance") },
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
                        imageVector = Icons.Default.VerifiedUser,
                        contentDescription = null,
                        tint = PrimaryGreen,
                        modifier = Modifier.size(36.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Google Play Policy Certified",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryGreen
                        )
                        Text(
                            text = "Updated for 2026 Developer Program Policies",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Permissions Policy Section
            ComplianceSectionCard(
                icon = Icons.Default.Security,
                title = "Permissions Justification",
                subtitle = "Only minimal, user-facing permissions requested"
            ) {
                ComplianceItem(
                    icon = Icons.Default.Notifications,
                    title = "POST_NOTIFICATIONS (System Alerts)",
                    description = "Used solely on Android 13+ (API 33+) to alert users about upcoming SIP installments, EMI repayment due dates, and custom bill reminders. All alerts are generated locally on-device without remote push servers."
                )
                ComplianceItem(
                    icon = Icons.Default.Mic,
                    title = "RECORD_AUDIO (Microphone)",
                    description = "Used exclusively for the user-initiated Voice Assistant dialog to add reminders, accounts, and financial ledger items. Audio is streamed ephemerally to the system SpeechRecognizer and immediately discarded. Never recorded to files or uploaded."
                )
                ComplianceItem(
                    icon = Icons.Default.Cloud,
                    title = "INTERNET (Voice Control System Only - User Choice Yes/No)",
                    description = "Used strictly and exclusively for speech recognition when the user explicitly grants 'Yes' permission. When set to 'No', speech recognition runs 100% offline. Financial balances, assets, liabilities, and transactions never connect to the internet."
                )
                ComplianceItem(
                    icon = Icons.Default.Fingerprint,
                    title = "USE_BIOMETRIC / USE_FINGERPRINT",
                    description = "Used solely to authenticate local database access via the AndroidX BiometricPrompt API. All biometric data remains within the device Hardware Security Module (TEE/SE); the app never touches or stores biometric signatures."
                )
                ComplianceItem(
                    icon = Icons.Default.Storage,
                    title = "Zero Broad Storage Permissions",
                    description = "Complies fully with Google Play Storage Policies. Does NOT request READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE, or MANAGE_EXTERNAL_STORAGE. Backup export and import operate via Android Storage Access Framework (SAF)."
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Financial Services Compliance
            ComplianceSectionCard(
                icon = Icons.Default.Policy,
                title = "Financial Services Policy Compliance",
                subtitle = "Classification: Personal Organization & Calculator"
            ) {
                Text(
                    text = "• Not a Lending or Loan Disbursement App: Net Worth Tracker does not provide personal loans, payday advances, micro-finance lending, or financial brokerage services.\n\n" +
                            "• No Payment Processing / Creditor Fees: The app does not facilitate credit cards, bank wire transfers, or loan interest collections.\n\n" +
                            "• Self-Contained Calculations: EMI calculators and liability schedules are purely mathematical utilities for personal bookkeeping.",
                    style = MaterialTheme.typography.bodyMedium,
                    lineHeight = MaterialTheme.typography.bodyLarge.lineHeight
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Ads, Families & Integrity
            ComplianceSectionCard(
                icon = Icons.Default.CheckCircle,
                title = "System Integrity & Families Policy",
                subtitle = "Safe, transparent, zero-tracker environment"
            ) {
                Text(
                    text = "• Zero Advertising / No AdMob: The application contains NO advertisements, ad identifiers (AAID), or ad fraud SDKs.\n\n" +
                            "• Zero Dynamic Code Loading: Complies with Google Play System Integrity rules. All code is compiled statically into the release APK/AAB with no secondary runtime payload execution.\n\n" +
                            "• Target API Compliance: Built strictly targeting modern Android API levels (API 34+) using Android Jetpack Compose and modern Kotlin standards.",
                    style = MaterialTheme.typography.bodyMedium,
                    lineHeight = MaterialTheme.typography.bodyLarge.lineHeight
                )
            }
        }
    }
}

@Composable
fun ComplianceSectionCard(
    icon: ImageVector,
    title: String,
    subtitle: String,
    content: @Composable () -> Unit
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
                Column {
                    Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Text(subtitle, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
            content()
        }
    }
}

@Composable
fun ComplianceItem(
    icon: ImageVector,
    title: String,
    description: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.Top
    ) {
        Icon(icon, contentDescription = null, tint = PrimaryGreen, modifier = Modifier.size(20.dp).padding(top = 2.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(2.dp))
            Text(description, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}
