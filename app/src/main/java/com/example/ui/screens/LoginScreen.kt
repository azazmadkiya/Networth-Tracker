package com.example.ui.screens

import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockReset
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.data.security.AuthManager
import com.example.data.security.BiometricAuthHelper
import com.example.data.security.BiometricStatus
import com.example.data.security.findFragmentActivity
import com.example.ui.theme.PrimaryGreen

@Composable
fun LoginScreen(
    authManager: AuthManager,
    onLoginSuccess: () -> Unit
) {
    val context = LocalContext.current
    val fragmentActivity = remember(context) { context.findFragmentActivity() }
    val biometricStatus = remember(context) { BiometricAuthHelper.getBiometricStatus(context) }
    val isBiometricReady = biometricStatus == BiometricStatus.READY
    val isBiometricEnabled = remember { authManager.isBiometricEnabled() }
    val hasExistingAccount = remember { authManager.hasAccount() }

    // If no account exists yet, start directly in Sign-Up mode
    var isSignUpMode by remember { mutableStateOf(!hasExistingAccount) }

    var userId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    val launchBiometricPrompt = {
        if (fragmentActivity != null && isBiometricReady) {
            BiometricAuthHelper.authenticate(
                activity = fragmentActivity,
                title = "Unlock Portfolio & Database",
                subtitle = "Confirm fingerprint or face unlock",
                description = "Authenticate to access encrypted local database records",
                negativeButtonText = "Use Password",
                onSuccess = {
                    authManager.setLoggedIn(true)
                    Toast.makeText(context, "Biometric authentication verified!", Toast.LENGTH_SHORT).show()
                    onLoginSuccess()
                },
                onError = { errorCode, errString ->
                    if (errorCode != BiometricPrompt.ERROR_USER_CANCELED &&
                        errorCode != BiometricPrompt.ERROR_NEGATIVE_BUTTON
                    ) {
                        Toast.makeText(context, "Biometric: $errString", Toast.LENGTH_SHORT).show()
                    }
                },
                onFailed = {
                    Toast.makeText(context, "Biometric not recognized. Try again or enter password.", Toast.LENGTH_SHORT).show()
                }
            )
        } else if (biometricStatus == BiometricStatus.NOT_ENROLLED) {
            Toast.makeText(context, "No biometrics enrolled. Opening security settings...", Toast.LENGTH_SHORT).show()
            BiometricAuthHelper.openBiometricSettings(context)
        } else {
            Toast.makeText(context, "Biometric hardware unavailable on this device", Toast.LENGTH_SHORT).show()
        }
    }

    // Auto-prompt on launch if biometrics is enabled, ready, and user is in Sign-In mode with existing account
    LaunchedEffect(Unit) {
        if (!isSignUpMode && hasExistingAccount && isBiometricEnabled && isBiometricReady) {
            launchBiometricPrompt()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(PrimaryGreen.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (isSignUpMode) Icons.Default.PersonAdd else Icons.Default.Security,
                        contentDescription = "Security",
                        tint = PrimaryGreen,
                        modifier = Modifier.size(36.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = if (isSignUpMode) "Create Account" else "Welcome Back",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = if (isSignUpMode)
                        "Set up your secure local credentials"
                    else
                        "Unlock your personal financial portfolio",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Biometric unlock option in Sign-In mode
                if (!isSignUpMode && hasExistingAccount && (isBiometricReady || biometricStatus == BiometricStatus.NOT_ENROLLED)) {
                    OutlinedButton(
                        onClick = { launchBiometricPrompt() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = PrimaryGreen)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Fingerprint,
                            contentDescription = "Biometric Scan",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Unlock with Fingerprint / Face",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        HorizontalDivider(modifier = Modifier.weight(1f))
                        Text(
                            text = " OR ENTER PASSWORD ",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                        HorizontalDivider(modifier = Modifier.weight(1f))
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }

                // User ID input
                OutlinedTextField(
                    value = userId,
                    onValueChange = { userId = it },
                    label = { Text(if (isSignUpMode) "Choose User ID" else "User ID") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Password input
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(if (isSignUpMode) "Create Password" else "Password") },
                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                    trailingIcon = {
                        val icon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(icon, contentDescription = "Toggle password")
                        }
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp)
                )

                // Confirm Password input (only in Sign-Up mode)
                if (isSignUpMode) {
                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = { Text("Confirm Password") },
                        leadingIcon = { Icon(Icons.Default.LockReset, contentDescription = null) },
                        trailingIcon = {
                            val icon = if (confirmPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                            IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                                Icon(icon, contentDescription = "Toggle confirm password")
                            }
                        },
                        visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Action button (Sign Up or Unlock)
                Button(
                    onClick = {
                        if (isSignUpMode) {
                            val trimmedId = userId.trim()
                            val trimmedPass = password.trim()
                            val trimmedConfirm = confirmPassword.trim()

                            when {
                                trimmedId.isEmpty() -> {
                                    Toast.makeText(context, "Please enter a User ID", Toast.LENGTH_SHORT).show()
                                }
                                trimmedPass.isEmpty() -> {
                                    Toast.makeText(context, "Please enter a Password", Toast.LENGTH_SHORT).show()
                                }
                                trimmedPass.length < 4 -> {
                                    Toast.makeText(context, "Password must be at least 4 characters", Toast.LENGTH_SHORT).show()
                                }
                                trimmedPass != trimmedConfirm -> {
                                    Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                                }
                                else -> {
                                    if (authManager.registerUser(trimmedId, trimmedPass)) {
                                        Toast.makeText(context, "Account created successfully!", Toast.LENGTH_SHORT).show()
                                        onLoginSuccess()
                                    } else {
                                        Toast.makeText(context, "Failed to create account. Please try again.", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        } else {
                            if (authManager.validateLogin(userId, password)) {
                                Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                                onLoginSuccess()
                            } else {
                                Toast.makeText(context, "Invalid User ID or Password. Please try again.", Toast.LENGTH_SHORT).show()
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen)
                ) {
                    Text(
                        text = if (isSignUpMode) "Create Account & Sign In" else "Unlock Portfolio",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Mode toggle (Sign In <-> Sign Up)
                TextButton(
                    onClick = {
                        isSignUpMode = !isSignUpMode
                        password = ""
                        confirmPassword = ""
                    }
                ) {
                    Text(
                        text = if (isSignUpMode)
                            "Already have an account? Sign In"
                        else
                            "Don't have an account? Sign Up",
                        style = MaterialTheme.typography.bodyMedium,
                        color = PrimaryGreen,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}
