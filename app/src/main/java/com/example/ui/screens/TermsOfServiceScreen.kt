package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsOfServiceScreen(onBack: () -> Unit) {
    val context = LocalContext.current

    val termsText = """
# Terms and Conditions & Financial Disclaimer

**Effective Date:** August 24, 2026
**Application:** Net Worth Tracker / Net Worth Vault
**Developer:** Azaz Madkiya (azazmadkiya@gmail.com)

## 1. Acceptance of Terms
By downloading, installing, accessing, or using the Net Worth Tracker mobile application ("the Application"), you agree to be bound by these Terms and Conditions ("Terms"). If you do not agree with any portion of these Terms, please do not use the Application.

---

## 2. Financial Disclaimer — Not Financial, Investment, or Tax Advice
- **Personal Bookkeeping Tool Only:** Net Worth Tracker is designed strictly as a self-custody personal financial tracking, calculation, and ledger management utility.
- **No Financial Advisory Services:** The Application, its developer, and its algorithms do NOT provide certified financial advice, investment recommendations, wealth management counseling, or legal/tax advisory services.
- **Manual Input & Accuracy:** All financial calculations, net worth aggregates, profit/loss figures, and double-entry ledger summaries depend on data entered or imported by you. The developer is not liable for data entry inaccuracies or calculation discrepancies.

---

## 3. User Responsibility & Data Backup
- **100% Offline Storage:** All records are stored locally on your device in an offline SQLite database. The developer does not host your data on cloud servers and cannot recover lost data if you misplace your device or uninstall the app without backing up.
- **Backup Responsibility:** You are solely responsible for creating regular offline JSON backups via the app's backup export utility and securing those backup files in your preferred cloud or local drive.
- **Passcode & Vault Security:** You are responsible for remembering your vault passcode.

---

## 4. Intellectual Property
All software code, graphic designs, interfaces, and algorithms in Net Worth Tracker are the intellectual property of developer Azaz Madkiya, protected by copyright and intellectual property laws.

---

## 5. Limitation of Liability
To the maximum extent permitted by applicable law, in no event shall the developer be liable for any direct, indirect, incidental, special, consequential, or punitive damages arising from the use of, or inability to use, the Application.

---

## 6. Governing Law & Contact
These Terms are governed by applicable laws. For inquiries regarding these terms, please contact:
- **Developer:** Azaz Madkiya
- **Email:** azazmadkiya@gmail.com
""".trimIndent()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Terms of Service",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("terms_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_SUBJECT, "Terms of Service - Net Worth Tracker")
                                putExtra(Intent.EXTRA_TEXT, termsText)
                            }
                            context.startActivity(Intent.createChooser(shareIntent, "Share Terms"))
                        },
                        modifier = Modifier.testTag("btn_share_terms")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share Terms",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF0F172A)
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { Spacer(modifier = Modifier.height(8.dp)) }

            // Disclaimer Banner Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth().testTag("terms_disclaimer_card"),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E3A8A))
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                shape = CircleShape,
                                color = Color(0xFF3B82F6).copy(alpha = 0.25f),
                                modifier = Modifier.size(44.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Default.Gavel,
                                        contentDescription = null,
                                        tint = Color(0xFF93C5FD),
                                        modifier = Modifier.size(26.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(14.dp))
                            Column {
                                Text(
                                    text = "Legal & Terms",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF93C5FD)
                                )
                                Text(
                                    text = "Terms of Service & Disclaimer",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Net Worth Tracker is an offline personal ledger utility. Calculations and summaries are for personal informational tracking only and do not constitute financial advice.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFFDBEAFE)
                        )
                    }
                }
            }

            // Key Points
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        Text(
                            text = "Core Summary",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        TermsItem(
                            icon = Icons.Default.Calculate,
                            iconTint = Color(0xFF3B82F6),
                            title = "Self-Custody Financial Ledger",
                            desc = "Designed exclusively for personal calculation and tracking. All balance adjustments reflect user input."
                        )

                        TermsItem(
                            icon = Icons.Default.WarningAmber,
                            iconTint = Color(0xFFF59E0B),
                            title = "No Investment Advisory",
                            desc = "Calculations, stock quotes, and analytics are not professional financial or tax recommendations."
                        )

                        TermsItem(
                            icon = Icons.Default.Lock,
                            iconTint = Color(0xFF10B981),
                            title = "User Backup Responsibility",
                            desc = "Because data is stored offline on your device, regular JSON exports are recommended."
                        )
                    }
                }
            }

            // Copy Terms Action
            item {
                Button(
                    onClick = {
                        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        val clip = ClipData.newPlainText("TermsOfService", termsText)
                        clipboard.setPrimaryClip(clip)
                        Toast.makeText(context, "Copied Terms of Service to Clipboard!", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.fillMaxWidth().testTag("btn_copy_terms"),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(Icons.Default.ContentCopy, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Copy Full Terms of Service Text")
                }
            }

            // Full Legal Text
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Text(
                            text = "Full Agreement Text",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        HorizontalDivider()

                        Text(
                            text = termsText,
                            style = MaterialTheme.typography.bodySmall,
                            lineHeight = 20.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            // Developer Contact
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Contact Support",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "Questions & Legal Inquiries",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = "Azaz Madkiya (azazmadkiya@gmail.com)",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(30.dp)) }
        }
    }
}

@Composable
private fun TermsItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconTint: Color,
    title: String,
    desc: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Surface(
            shape = RoundedCornerShape(10.dp),
            color = iconTint.copy(alpha = 0.15f),
            modifier = Modifier.size(36.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(imageVector = icon, contentDescription = null, tint = iconTint, modifier = Modifier.size(20.dp))
            }
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(text = title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = desc,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 16.sp
            )
        }
    }
}
