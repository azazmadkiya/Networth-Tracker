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
import androidx.compose.material.icons.filled.AssignmentTurnedIn
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.theme.PrimaryGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataSafetyScreen(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Data Safety & Console Answers") },
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
            // Header
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
                        imageVector = Icons.Default.Security,
                        contentDescription = null,
                        tint = PrimaryGreen,
                        modifier = Modifier.size(36.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Play Store Data Safety Overview",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryGreen
                        )
                        Text(
                            text = "Standard disclosures & Google Play Console questionnaire guide",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Core safety card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "General Data Safety Declarations",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    SafetyPoint(
                        title = "No Data Shared with Third Parties",
                        detail = "Zero personal, financial, biometric, or device data is shared with advertisers, analytics providers, or external companies."
                    )
                    SafetyPoint(
                        title = "No Remote Data Collection",
                        detail = "All financial items, account balances, and profiles stay solely within the device's local sandboxed SQLite database."
                    )
                    SafetyPoint(
                        title = "Ephemeral Microphone Audio",
                        detail = "Voice input for adding reminders/accounts is processed in real-time by the Android system speech recognizer and never saved."
                    )
                    SafetyPoint(
                        title = "Hardware Biometric Isolation",
                        detail = "Biometric credentials (fingerprint/face) are validated by the Android Keystore/TEE and never accessed by the app."
                    )
                    SafetyPoint(
                        title = "User Data Deletion Mechanism",
                        detail = "Users can purge all stored financial tables and credentials instantly via 'Wipe All Financial Data' in Settings."
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Google Play Console Questionnaire Guide
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.QuestionAnswer, contentDescription = null, tint = PrimaryGreen, modifier = Modifier.size(22.dp))
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Google Play Console Answers Guide",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Use these exact responses when completing the Play Console Data Safety form:",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(12.dp))

                    ConsoleAnswerItem(
                        question = "Does your app collect or share any of the required user data types?",
                        answer = "NO",
                        note = "The app only stores data locally on the user's device in Room SQLite; it does not collect or transmit data to remote servers."
                    )

                    ConsoleAnswerItem(
                        question = "Is all user data collected by your app encrypted in transit?",
                        answer = "YES",
                        note = "Voice transcription is routed through the secure Android platform SpeechRecognizer."
                    )

                    ConsoleAnswerItem(
                        question = "Do you provide a way for users to request that their data be deleted?",
                        answer = "YES",
                        note = "The app includes an in-app 'Wipe All Financial Data' button that wipes all local databases and SharedPreferences."
                    )

                    ConsoleAnswerItem(
                        question = "Data Type: Financial info (user payment info, purchase history, credit score)?",
                        answer = "NOT COLLECTED / NOT SHARED",
                        note = "Financial data is kept strictly in local offline storage and never transmitted."
                    )

                    ConsoleAnswerItem(
                        question = "Data Type: Voice or sound recordings?",
                        answer = "EPHEMERAL / NOT COLLECTED",
                        note = "Audio streamed to SpeechRecognizer is processed transiently and not stored on device or server."
                    )

                    ConsoleAnswerItem(
                        question = "Data Type: Personal info (Name, User ID)?",
                        answer = "NOT COLLECTED / NOT SHARED",
                        note = "Profile names and login IDs remain on the local device only."
                    )
                }
            }
        }
    }
}

@Composable
fun SafetyPoint(
    title: String,
    detail: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.Top
    ) {
        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = PrimaryGreen, modifier = Modifier.size(18.dp).padding(top = 2.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
            Text(detail, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
fun ConsoleAnswerItem(
    question: String,
    answer: String,
    note: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(question, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.AssignmentTurnedIn, contentDescription = null, tint = PrimaryGreen, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text(answer, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold, color = PrimaryGreen)
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(note, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Spacer(modifier = Modifier.height(6.dp))
        HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
    }
}
