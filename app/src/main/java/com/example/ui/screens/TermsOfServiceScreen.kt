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
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Backup
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Warning
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
fun TermsOfServiceScreen(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Terms of Service & Disclaimer") },
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
            // Disclaimer Banner Card
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
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = PrimaryGreen,
                        modifier = Modifier.size(36.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Financial & Usage Disclaimer",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryGreen
                        )
                        Text(
                            text = "Please read these terms carefully before using the app",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            TermsCard(
                icon = Icons.Default.Warning,
                title = "1. Non-Advisory Financial Disclaimer",
                content = "Net Worth Tracker is an independent personal budgeting, calculation, and ledger utility. The calculations, net worth summaries, liability amortization schedules, and asset valuations are provided solely for personal organizational and educational purposes.\n\n" +
                        "• Not Financial or Investment Advice: Nothing in this application constitutes certified financial advice, investment counsel, legal guidance, taxation advice, or brokerage services.\n" +
                        "• Consult Certified Professionals: You are encouraged to consult certified financial planners (CFP), chartered accountants, or registered investment advisers before undertaking any material financial transactions."
            )

            Spacer(modifier = Modifier.height(14.dp))

            TermsCard(
                icon = Icons.Default.Backup,
                title = "2. Offline Storage & Backup Responsibility",
                content = "Because Net Worth Tracker does not transmit your records to a remote cloud or company server, you retain sole custody and responsibility for your financial records.\n\n" +
                        "• Exporting Backups: You are advised to use the 'Export Backup JSON' feature regularly.\n" +
                        "• Device Loss or Reset: The developer is not liable for data loss arising from device damage, uninstallation, factory resets, operating system upgrades, or hardware corruption."
            )

            Spacer(modifier = Modifier.height(14.dp))

            TermsCard(
                icon = Icons.Default.Mic,
                title = "3. Voice Recognition & Data Accuracy",
                content = "The Voice Control feature uses acoustic models and heuristic pattern matching to parse spoken phrases into financial entries. Due to varying microphone quality, accents, and background noise, speech transcription may occasionally misunderstand quantities or categories. You must review parsed entries prior to final confirmation."
            )

            Spacer(modifier = Modifier.height(14.dp))

            TermsCard(
                icon = Icons.Default.Assignment,
                title = "4. Permitted Personal Use",
                content = "You are granted a personal, revocable, non-exclusive, non-transferable license to use Net Worth Tracker on your Android devices for personal and household financial record management in compliance with applicable laws."
            )

            Spacer(modifier = Modifier.height(14.dp))

            TermsCard(
                icon = Icons.Default.Gavel,
                title = "5. Limitation of Liability & Warranties",
                content = "The application is provided 'AS IS' and 'AS AVAILABLE' without warranties of any kind, whether express, implied, or statutory. In no event shall the developer or contributors be liable for any indirect, incidental, special, or consequential damages resulting from your use of or inability to use the application."
            )
        }
    }
}

@Composable
fun TermsCard(
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
