package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.data.model.LedgerEntry
import com.example.ui.theme.AssetGreen
import com.example.ui.theme.LiabilityRed
import com.example.ui.theme.PrimaryGreen
import com.example.ui.utils.NumberFormatUtils
import com.example.ui.utils.ShareUtils

// Branded Platform Colors
val WhatsAppBrandColor = Color(0xFF25D366)
val SmsBrandColor = Color(0xFF1976D2)
val EmailBrandColor = Color(0xFFEA4335)
val OtherAppsBrandColor = Color(0xFF673AB7)

@Composable
fun ShareEntryDialog(
    entry: LedgerEntry? = null,
    summaryEntries: List<LedgerEntry>? = null,
    totalCredit: Double = 0.0,
    totalDebit: Double = 0.0,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val isSummary = summaryEntries != null
    val isCredit = entry?.entryType?.equals("CREDIT", ignoreCase = true) == true
    val isDebit = entry?.entryType?.equals("DEBIT", ignoreCase = true) == true

    val shareText = remember(entry, summaryEntries, totalCredit, totalDebit) {
        if (isSummary && summaryEntries != null) {
            ShareUtils.formatLedgerSummary(summaryEntries, totalCredit, totalDebit)
        } else if (entry != null) {
            ShareUtils.formatLedgerEntry(entry)
        } else {
            ""
        }
    }

    val shareSubject = remember(entry, isSummary) {
        if (isSummary) {
            "Income & Expense Statement - Net Worth Tracker"
        } else if (entry != null) {
            val typeStr = if (isCredit) "Income" else if (isDebit) "Expense" else "Transfer"
            val amt = if (isCredit) entry.creditAmount else entry.debitAmount
            "$typeStr: ${entry.transactionTitle} (${NumberFormatUtils.formatCurrency(amt)})"
        } else {
            "Financial Transaction"
        }
    }

    var recipientPhone by remember { mutableStateOf("") }
    var recipientEmail by remember { mutableStateOf("") }
    var showPreview by remember { mutableStateOf(false) }

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
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (isSummary) "Share Financial Statement" else "Share ${if (isCredit) "Income" else "Expense"} Entry",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Send via WhatsApp, SMS, Email, or more",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    IconButton(onClick = safeDismiss, modifier = Modifier.size(32.dp)) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Highlight Card
                if (entry != null) {
                    val amt = if (isCredit) entry.creditAmount else entry.debitAmount
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = if (isCredit) AssetGreen.copy(alpha = 0.12f) else LiabilityRed.copy(alpha = 0.12f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = entry.transactionTitle,
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "${if (isCredit) "+" else "-"}${NumberFormatUtils.formatCurrency(amt)}",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isCredit) AssetGreen else LiabilityRed
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "${entry.accountName} • ${NumberFormatUtils.formatDate(entry.timestamp)}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                } else if (isSummary) {
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = PrimaryGreen.copy(alpha = 0.12f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("Total Inflow: ${NumberFormatUtils.formatCompact(totalCredit)}", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold, color = AssetGreen)
                                Text("Total Outflow: ${NumberFormatUtils.formatCompact(totalDebit)}", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold, color = LiabilityRed)
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Statement containing ${summaryEntries?.size ?: 0} transaction records",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Primary Platform Buttons
                Text(
                    text = "Select Sharing Platform",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(10.dp))

                // WhatsApp Option Button
                PlatformShareItem(
                    brandColor = WhatsAppBrandColor,
                    icon = Icons.Default.Send,
                    title = "WhatsApp Message",
                    subtitle = "Send direct message or choose contact",
                    onClick = {
                        ShareUtils.shareViaWhatsApp(context, shareText, recipientPhone.ifBlank { null })
                        onDismiss()
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

                // SMS Option Button
                PlatformShareItem(
                    brandColor = SmsBrandColor,
                    icon = Icons.Default.Phone,
                    title = "SMS Text Message",
                    subtitle = "Send via phone carrier SMS app",
                    onClick = {
                        ShareUtils.shareViaSms(context, shareText, recipientPhone.ifBlank { null })
                        onDismiss()
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Email Option Button
                PlatformShareItem(
                    brandColor = EmailBrandColor,
                    icon = Icons.Default.Email,
                    title = "Email Dispatch",
                    subtitle = "Send formatted receipt via Email",
                    onClick = {
                        ShareUtils.shareViaEmail(
                            context = context,
                            subject = shareSubject,
                            body = shareText,
                            recipientEmail = recipientEmail.ifBlank { null }
                        )
                        onDismiss()
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Other Platforms Option Button
                PlatformShareItem(
                    brandColor = OtherAppsBrandColor,
                    icon = Icons.Default.Share,
                    title = "Other Platforms",
                    subtitle = "Telegram, Slack, Notes, Drive, etc.",
                    onClick = {
                        ShareUtils.shareViaOtherPlatforms(context, shareSubject, shareText)
                        onDismiss()
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Optional Recipient Details Accordion
                Text(
                    text = "Optional Direct Recipient",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = recipientPhone,
                        onValueChange = { recipientPhone = it },
                        label = { Text("Phone (WhatsApp/SMS)") },
                        placeholder = { Text("e.g. 9876543210") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp),
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = recipientEmail,
                        onValueChange = { recipientEmail = it },
                        label = { Text("Email (Optional)") },
                        placeholder = { Text("accountant@mail.com") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp),
                        singleLine = true
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Toggle Preview of Message
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { showPreview = !showPreview }
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (showPreview) "Hide Message Preview" else "View Formatted Receipt Text",
                        style = MaterialTheme.typography.bodySmall,
                        color = PrimaryGreen,
                        fontWeight = FontWeight.SemiBold
                    )
                    Icon(
                        imageVector = if (showPreview) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        tint = PrimaryGreen
                    )
                }

                AnimatedVisibility(visible = showPreview) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                    ) {
                        Text(
                            text = shareText,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontFamily = FontFamily.Monospace,
                                fontSize = 11.sp,
                                lineHeight = 16.sp
                            ),
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Bottom actions: Copy to Clipboard & Cancel
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = {
                            ShareUtils.copyToClipboard(context, "TransactionReceipt", shareText)
                        },
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Copy Text")
                    }

                    Button(
                        onClick = safeDismiss,
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Text("Close", color = MaterialTheme.colorScheme.onSurface)
                    }
                }
            }
        }
    }
}
}

@Composable
fun PlatformShareItem(
    brandColor: Color,
    icon: ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(14.dp),
        color = brandColor.copy(alpha = 0.08f),
        border = androidx.compose.foundation.BorderStroke(1.dp, brandColor.copy(alpha = 0.25f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(brandColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Send",
                tint = brandColor,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
