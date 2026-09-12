package com.example.ui.components

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.Settings
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MicOff
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.TrendingUp
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.ContextCompat
import com.example.data.security.AuthManager
import com.example.ui.theme.AssetGreen
import com.example.ui.theme.LiabilityRed
import com.example.ui.theme.PrimaryGreen
import com.example.ui.utils.NumberFormatUtils
import com.example.ui.viewmodel.NetWorthViewModel
import com.example.ui.viewmodel.ParsedVoiceAction
import com.example.ui.viewmodel.VoiceCommandParser
import java.util.Locale

@Composable
fun VoiceAssistantDialog(
    viewModel: NetWorthViewModel,
    onDismiss: () -> Unit,
    onNavigate: (String) -> Unit
) {
    val context = LocalContext.current
    val authManager = remember { AuthManager(context) }
    var isInternetAllowed by remember { mutableStateOf(authManager.isVoiceInternetAllowed()) }
    var showInternetConsentDialog by remember { mutableStateOf(!authManager.hasUserDecidedVoiceInternet()) }

    var spokenText by remember { mutableStateOf("") }
    var isListening by remember { mutableStateOf(false) }
    var statusText by remember {
        mutableStateOf(
            if (isInternetAllowed) "Cloud Voice Active (Internet Enabled)" else "Offline Voice Active (100% On-Device)"
        )
    }
    var speechServiceAvailable by remember {
        mutableStateOf(SpeechRecognizer.isRecognitionAvailable(context))
    }

    var hasMicPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
        )
    }

    // In-app SpeechRecognizer instance
    val speechRecognizer = remember {
        try {
            if (SpeechRecognizer.isRecognitionAvailable(context)) {
                SpeechRecognizer.createSpeechRecognizer(context)
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    DisposableEffect(speechRecognizer) {
        onDispose {
            try {
                speechRecognizer?.stopListening()
                speechRecognizer?.destroy()
            } catch (e: Exception) {
                // ignore
            }
        }
    }

    // System Speech recognition launcher (Fallback)
    val speechLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        isListening = false
        if (result.resultCode == Activity.RESULT_OK && result.data != null) {
            val matches = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            if (!matches.isNullOrEmpty()) {
                spokenText = matches[0]
                statusText = "Captured: \"${matches[0]}\""
            } else {
                statusText = if (isInternetAllowed) "Cloud Voice Active (Tap mic to speak)" else "Offline Voice Active (Tap mic to speak)"
            }
        } else {
            statusText = if (isInternetAllowed) "Cloud Voice Active (Tap mic to speak)" else "Offline Voice Active (Tap mic to speak)"
        }
    }

    val createSpeechIntent = {
        Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            putExtra(
                RecognizerIntent.EXTRA_PROMPT,
                if (isInternetAllowed) "Speak financial command (Cloud Voice)..." else "Speak financial command (Offline Voice)..."
            )
            putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
            putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3)
            // User choice: Internet Permission strictly for Voice Control (Yes/No)
            if (isInternetAllowed) {
                putExtra("android.speech.extra.PREFER_OFFLINE", false)
            } else {
                putExtra("android.speech.extra.PREFER_OFFLINE", true)
            }
        }
    }

    fun stopListening() {
        try {
            speechRecognizer?.stopListening()
        } catch (e: Exception) {
            // ignore
        }
        isListening = false
        statusText = "Tap microphone to speak"
    }

    fun startListening() {
        if (isListening) {
            stopListening()
            return
        }

        // Try in-app SpeechRecognizer first
        if (speechRecognizer != null) {
            try {
                speechRecognizer.setRecognitionListener(object : RecognitionListener {
                    override fun onReadyForSpeech(params: Bundle?) {
                        isListening = true
                        statusText = "Listening... Speak now"
                    }

                    override fun onBeginningOfSpeech() {
                        statusText = "Hearing your voice..."
                    }

                    override fun onRmsChanged(rmsdB: Float) {}

                    override fun onBufferReceived(buffer: ByteArray?) {}

                    override fun onEndOfSpeech() {
                        isListening = false
                        statusText = "Processing command..."
                    }

                    override fun onError(error: Int) {
                        isListening = false
                        when (error) {
                            SpeechRecognizer.ERROR_NO_MATCH -> {
                                statusText = "No speech detected. Tap mic to retry."
                            }
                            SpeechRecognizer.ERROR_SPEECH_TIMEOUT -> {
                                statusText = "Listening timed out. Tap to speak."
                            }
                            SpeechRecognizer.ERROR_AUDIO -> {
                                statusText = "Audio recording issue. Tap mic again."
                            }
                            SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS -> {
                                statusText = "Microphone permission required."
                            }
                            else -> {
                                // Try system dialog fallback
                                try {
                                    val intent = createSpeechIntent()
                                    speechLauncher.launch(intent)
                                } catch (e: Exception) {
                                    statusText = "Speech recognizer unavailable. Type below!"
                                    speechServiceAvailable = false
                                }
                            }
                        }
                    }

                    override fun onResults(results: Bundle?) {
                        isListening = false
                        val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                        if (!matches.isNullOrEmpty()) {
                            spokenText = matches[0]
                            statusText = "Understood: \"${matches[0]}\""
                        } else {
                            statusText = "Tap microphone to speak"
                        }
                    }

                    override fun onPartialResults(partialResults: Bundle?) {
                        val matches = partialResults?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                        if (!matches.isNullOrEmpty()) {
                            spokenText = matches[0]
                            statusText = "Hearing: ${matches[0]}"
                        }
                    }

                    override fun onEvent(eventType: Int, params: Bundle?) {}
                })

                val intent = createSpeechIntent()
                speechRecognizer.startListening(intent)
                isListening = true
                statusText = "Listening... Speak now"
                return
            } catch (e: Exception) {
                // fall through to Intent launcher
            }
        }

        // Secondary fallback: Launch system speech activity
        try {
            val intent = createSpeechIntent()
            isListening = true
            speechLauncher.launch(intent)
        } catch (e: Exception) {
            isListening = false
            speechServiceAvailable = false
            statusText = "Voice service unavailable. You can type commands below!"
        }
    }

    // Permission launcher
    val micPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        hasMicPermission = isGranted
        if (isGranted) {
            startListening()
        } else {
            statusText = "Microphone permission denied"
            Toast.makeText(context, "Microphone permission required for voice input. You can type commands below!", Toast.LENGTH_LONG).show()
        }
    }

    fun requestAndStartListening() {
        if (hasMicPermission) {
            startListening()
        } else {
            micPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
        }
    }

    // Attempt start on open only if microphone permission already granted
    LaunchedEffect(Unit) {
        if (hasMicPermission && speechServiceAvailable) {
            try {
                startListening()
            } catch (e: Exception) {
                // quiet ignore on initial auto-launch
            }
        }
    }

    val parsedAction = remember(spokenText) {
        VoiceCommandParser.parse(spokenText)
    }

    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = if (isListening) 1.25f else 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulseScale"
    )

    if (showInternetConsentDialog) {
        AlertDialog(
            onDismissRequest = {
                authManager.setVoiceInternetAllowed(false)
                isInternetAllowed = false
                showInternetConsentDialog = false
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Cloud,
                    contentDescription = null,
                    tint = PrimaryGreen,
                    modifier = Modifier.size(32.dp)
                )
            },
            title = {
                Text(
                    text = "Internet Permission (Voice Control Only)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "Access Internet Permission for Voice Control System?",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "• YES (Online Speech): Enables cloud-assisted speech recognition for greater vocabulary, accents, and high precision.\n\n" +
                               "• NO (100% Offline): Operates strictly on-device with zero network access.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = PrimaryGreen.copy(alpha = 0.1f)
                    ) {
                        Text(
                            text = "🔒 Sandboxed Protection: Internet permission is strictly restricted ONLY to speech recognition. Your financial database, balances, ledger, and numbers NEVER touch the internet.",
                            style = MaterialTheme.typography.labelSmall,
                            color = PrimaryGreen,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        authManager.setVoiceInternetAllowed(true)
                        isInternetAllowed = true
                        showInternetConsentDialog = false
                        statusText = "Online Voice active (Internet: YES)"
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen)
                ) {
                    Text("YES (Allow Internet)")
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = {
                        authManager.setVoiceInternetAllowed(false)
                        isInternetAllowed = false
                        showInternetConsentDialog = false
                        statusText = "Offline Voice active (Internet: NO)"
                    }
                ) {
                    Text("NO (100% Offline)")
                }
            }
        )
    }

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
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(PrimaryGreen.copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Mic,
                                contentDescription = "Voice Assistant",
                                tint = PrimaryGreen,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Voice Financial Control",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    IconButton(onClick = safeDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Voice Control Internet Access Mode (User Choice Yes/No)
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isInternetAllowed) AssetGreen.copy(alpha = 0.10f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                                Icon(
                                    imageVector = if (isInternetAllowed) Icons.Default.Cloud else Icons.Default.Lock,
                                    contentDescription = "Voice Internet Mode",
                                    tint = if (isInternetAllowed) AssetGreen else MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Internet Permission (Voice Only)",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = if (isInternetAllowed) AssetGreen.copy(alpha = 0.2f) else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
                            ) {
                                Text(
                                    text = if (isInternetAllowed) "YES (Online)" else "NO (Offline)",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isInternetAllowed) AssetGreen else MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = if (isInternetAllowed)
                                "User Choice: YES • Cloud speech recognition enabled for maximum accuracy."
                            else
                                "User Choice: NO • 100% offline speech recognition without internet.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Explicit YES / NO Choice Chips
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            FilterChip(
                                selected = isInternetAllowed,
                                onClick = {
                                    authManager.setVoiceInternetAllowed(true)
                                    isInternetAllowed = true
                                    if (isListening) stopListening()
                                    statusText = "Cloud Voice active (Internet: YES)"
                                },
                                label = { Text("YES (Allow Internet)") },
                                leadingIcon = {
                                    if (isInternetAllowed) {
                                        Icon(Icons.Default.CheckCircle, contentDescription = null, modifier = Modifier.size(16.dp), tint = AssetGreen)
                                    }
                                },
                                modifier = Modifier.weight(1f)
                            )
                            FilterChip(
                                selected = !isInternetAllowed,
                                onClick = {
                                    authManager.setVoiceInternetAllowed(false)
                                    isInternetAllowed = false
                                    if (isListening) stopListening()
                                    statusText = "Offline Voice active (Internet: NO)"
                                },
                                label = { Text("NO (100% Offline)") },
                                leadingIcon = {
                                    if (!isInternetAllowed) {
                                        Icon(Icons.Default.CheckCircle, contentDescription = null, modifier = Modifier.size(16.dp))
                                    }
                                },
                                modifier = Modifier.weight(1f)
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "🔒 Sandboxed: Internet access applies ONLY to voice recognition. Financial database & ledger NEVER access internet.",
                            style = MaterialTheme.typography.labelSmall,
                            color = PrimaryGreen,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                // Microphone Permission Banner if not granted
                if (!hasMicPermission) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.5f)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.MicOff,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.error,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Microphone access needed",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                            TextButton(
                                onClick = { micPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO) }
                            ) {
                                Text("Allow", fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }

                // If speech service is unavailable on device
                if (!speechServiceAvailable) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Speech Service Inactive",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Enable Google Voice Typing or type commands directly below.",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(
                                onClick = {
                                    try {
                                        context.startActivity(Intent(Settings.ACTION_VOICE_INPUT_SETTINGS))
                                    } catch (e: Exception) {
                                        try {
                                            context.startActivity(Intent(Settings.ACTION_SETTINGS))
                                        } catch (e2: Exception) {
                                            Toast.makeText(context, "Open system settings to enable voice typing", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                },
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen)
                            ) {
                                Text("Settings", style = MaterialTheme.typography.labelSmall)
                            }
                        }
                    }
                }

                // Pulsing Mic Button
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .scale(pulseScale)
                        .clip(CircleShape)
                        .background(if (isListening) PrimaryGreen else PrimaryGreen.copy(alpha = 0.85f))
                        .clickable { requestAndStartListening() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (hasMicPermission) Icons.Default.Mic else Icons.Default.MicOff,
                        contentDescription = if (isListening) "Listening (Tap to stop)" else "Tap to Speak",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = when {
                        !hasMicPermission -> "Tap to grant microphone permission"
                        isListening -> "Listening... Speak now (Tap to finish)"
                        else -> statusText
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (isListening) PrimaryGreen else MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = if (isListening) FontWeight.SemiBold else FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Speech Input / Text Field with clear & quick execute actions
                OutlinedTextField(
                    value = spokenText,
                    onValueChange = { spokenText = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Command / Spoken text") },
                    placeholder = { Text("e.g. Add account HDFC 50000 / Add reminder...") },
                    trailingIcon = {
                        if (spokenText.isNotBlank()) {
                            IconButton(onClick = { spokenText = "" }) {
                                Icon(Icons.Default.Clear, contentDescription = "Clear")
                            }
                        }
                    },
                    shape = RoundedCornerShape(16.dp),
                    singleLine = false,
                    maxLines = 3
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Parsed Result Card
                AnimatedVisibility(visible = spokenText.isNotBlank()) {
                    ParsedActionPreview(
                        action = parsedAction,
                        onConfirm = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                            viewModel.executeVoiceAction(parsedAction) { message ->
                                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                                if (parsedAction is ParsedVoiceAction.NavigateAction) {
                                    onNavigate(parsedAction.targetScreen)
                                }
                                onDismiss()
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Suggestion chips
                Text(
                    text = "Quick Voice Commands:",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(6.dp))
                val quickChips = listOf(
                    "Add event reminder Tax Filing in 5 days",
                    "Add reminder pay electricity bill 1500 tomorrow",
                    "Add account HDFC Bank 50000",
                    "Add asset Reliance stock 50000",
                    "Add expense 450 groceries",
                    "Add income 80000 salary",
                    "Add liability car loan 350000",
                    "Add bank account SBI 25000",
                    "Take snapshot"
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    quickChips.forEach { chip ->
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.clickable {
                                spokenText = chip
                            }
                        ) {
                            Text(
                                text = chip,
                                style = MaterialTheme.typography.labelSmall,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "🔒 Internet permission is sandboxed strictly to Voice Control. All financial records and calculations remain 100% offline.",
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.75f)
                )
            }
        }
    }
}
}

@Composable
fun ParsedActionPreview(
    action: ParsedVoiceAction,
    onConfirm: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
        )
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            when (action) {
                is ParsedVoiceAction.AddReminderAction -> {
                    val isEvent = action.reminder.isEvent || action.reminder.reminderType == com.example.data.model.ReminderType.EVENT_REMINDER.name
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            if (isEvent) Icons.Default.Event else Icons.Default.Notifications,
                            contentDescription = null,
                            tint = if (isEvent) AssetGreen else PrimaryGreen,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (isEvent) "Detected Event Reminder" else "Detected Reminder",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = if (isEvent) AssetGreen else PrimaryGreen
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Title: ${action.reminder.title}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    if (action.reminder.amount > 0) {
                        Text(
                            text = if (isEvent) "Budget: ${NumberFormatUtils.formatCurrency(action.reminder.amount)}" else "Amount: ${NumberFormatUtils.formatCurrency(action.reminder.amount)}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    val currentDay = System.currentTimeMillis() / 86400000L
                    val daysDiff = action.reminder.dueDateEpochDay - currentDay
                    Text(
                        text = "Type: ${action.reminder.reminderType.replace('_', ' ')} | Schedule: ${if (daysDiff <= 0) "Today" else "In $daysDiff days"}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = onConfirm,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = if (isEvent) AssetGreen else PrimaryGreen)
                    ) {
                        Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(if (isEvent) "Confirm & Add Event Reminder" else "Confirm & Add Reminder")
                    }
                }
                is ParsedVoiceAction.AddAccountAction -> {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.AccountBalance,
                            contentDescription = null,
                            tint = PrimaryGreen,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Detected Bank / Account",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryGreen
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Account: ${action.accountItem.title}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Initial Balance: ${NumberFormatUtils.formatCurrency(action.initialBalance)}",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "Type: Bank Account | Owner: ${action.accountItem.owner}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = onConfirm,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen)
                    ) {
                        Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Confirm & Add Account")
                    }
                }
                is ParsedVoiceAction.AddFinancialItemAction -> {
                    val isLiab = action.item.isLiability
                    val color = if (isLiab) LiabilityRed else AssetGreen
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = if (isLiab) Icons.Default.Receipt else Icons.Default.AccountBalance,
                            contentDescription = null,
                            tint = color,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (isLiab) "Detected Liability" else "Detected Asset Entry",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = color
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Name: ${action.item.title}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Value: ${NumberFormatUtils.formatCurrency(action.item.currentValue)}",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "Category: ${action.item.category} | Owner: ${action.item.owner}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = onConfirm,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = color)
                    ) {
                        Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(if (isLiab) "Confirm & Add Liability" else "Confirm & Add Asset")
                    }
                }
                is ParsedVoiceAction.AddLedgerAction -> {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.TrendingUp,
                            contentDescription = null,
                            tint = PrimaryGreen,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Detected Ledger Transaction",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryGreen
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = action.explanation,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = onConfirm,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen)
                    ) {
                        Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Record Transaction")
                    }
                }
                is ParsedVoiceAction.TakeSnapshotAction -> {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.CameraAlt, contentDescription = null, tint = PrimaryGreen)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Take Portfolio Snapshot",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryGreen
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = onConfirm,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Save Snapshot Now")
                    }
                }
                is ParsedVoiceAction.NavigateAction -> {
                    Text(
                        text = "Navigation: Open ${action.targetScreen}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = onConfirm, modifier = Modifier.fillMaxWidth()) {
                        Text("Go to ${action.targetScreen}")
                    }
                }
                is ParsedVoiceAction.UnknownAction -> {
                    Text(
                        text = "I didn't quite catch the specific financial command. Tap one of the examples below or speak again!",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
