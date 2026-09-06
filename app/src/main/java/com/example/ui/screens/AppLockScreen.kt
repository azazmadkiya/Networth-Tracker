package com.example.ui.screens

import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.security.BiometricAuthHelper
import com.example.data.security.BiometricStatus
import com.example.data.security.findFragmentActivity
import com.example.ui.theme.PrimaryGreen
import kotlinx.coroutines.delay

@Composable
fun AppLockScreen(
    isSetupMode: Boolean,
    onPinSet: (String) -> Unit,
    onUnlock: () -> Unit,
    onLogout: (() -> Unit)? = null,
    expectedPin: String? = null
) {
    var pin by remember { mutableStateOf("") }
    var confirmPin by remember { mutableStateOf("") }
    var isConfirming by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val fragmentActivity = remember(context) { context.findFragmentActivity() }
    val biometricStatus = remember(context) { BiometricAuthHelper.getBiometricStatus(context) }
    val isBiometricReady = biometricStatus == BiometricStatus.READY

    val launchBiometric = {
        if (fragmentActivity != null && isBiometricReady) {
            BiometricAuthHelper.authenticate(
                activity = fragmentActivity,
                title = "Unlock App",
                subtitle = "Confirm fingerprint or face unlock",
                description = "Authenticate to unlock",
                negativeButtonText = "Use PIN",
                onSuccess = { onUnlock() },
                onError = { _, _ -> },
                onFailed = { }
            )
        }
    }

    LaunchedEffect(Unit) {
        if (!isSetupMode && isBiometricReady) {
            launchBiometric()
        }
    }

    LaunchedEffect(pin) {
        if (pin.length == 4) {
            if (isSetupMode) {
                if (!isConfirming) {
                    isConfirming = true
                    confirmPin = pin
                    pin = ""
                } else {
                    if (pin == confirmPin) {
                        onPinSet(pin)
                    } else {
                        error = true
                        delay(500)
                        pin = ""
                        confirmPin = ""
                        isConfirming = false
                        error = false
                    }
                }
            } else {
                if (pin == expectedPin) {
                    onUnlock()
                } else {
                    error = true
                    delay(500)
                    pin = ""
                    error = false
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = "Lock",
            tint = if (error) MaterialTheme.colorScheme.error else PrimaryGreen,
            modifier = Modifier.size(48.dp)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = when {
                isSetupMode && !isConfirming -> "Set 4-Digit PIN"
                isSetupMode && isConfirming -> "Confirm PIN"
                else -> "Enter PIN to Unlock"
            },
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(4) { index ->
                val isFilled = index < pin.length
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(CircleShape)
                        .background(
                            when {
                                error -> MaterialTheme.colorScheme.error
                                isFilled -> PrimaryGreen
                                else -> MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.3f)
                            }
                        )
                )
            }
        }

        Spacer(modifier = Modifier.height(64.dp))

        // Keypad
        val keys = listOf(
            listOf("1", "2", "3"),
            listOf("4", "5", "6"),
            listOf("7", "8", "9"),
            listOf(if (!isSetupMode && isBiometricReady) "BIO" else "", "0", "DEL")
        )

        keys.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { key ->
                    Box(
                        modifier = Modifier
                            .size(72.dp)
                            .clip(CircleShape)
                            .clickable(enabled = key.isNotEmpty()) {
                                if (key == "DEL") {
                                    if (pin.isNotEmpty()) pin = pin.dropLast(1)
                                } else if (key == "BIO") {
                                    launchBiometric()
                                } else if (pin.length < 4) {
                                    pin += key
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        if (key == "DEL") {
                            Icon(Icons.Default.Backspace, contentDescription = "Delete")
                        } else if (key == "BIO") {
                            Icon(Icons.Default.Fingerprint, contentDescription = "Biometric", tint = PrimaryGreen)
                        } else if (key.isNotEmpty()) {
                            Text(
                                text = key,
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        if (!isSetupMode && onLogout != null) {
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = onLogout) {
                Text("Sign Out", color = MaterialTheme.colorScheme.error)
            }
        }
    }
}
