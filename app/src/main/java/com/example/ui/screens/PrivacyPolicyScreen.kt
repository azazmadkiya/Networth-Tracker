package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Html
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
fun PrivacyPolicyScreen(onBack: () -> Unit) {
    val context = LocalContext.current

    val privacyPolicyText = """
# Privacy Policy for Net Worth Tracker / Net Worth Vault

**Effective Date:** August 24, 2026
**Last Updated:** August 24, 2026
**Developer:** Azaz Madkiya (azazmadkiya@gmail.com)

## 1. Introduction & Core Privacy Commitment
Net Worth Tracker ("the Application") is an offline-first personal finance, asset tracking, and double-entry ledger tool designed to empower individuals and families to monitor assets, bank balances, mutual funds, gold, real estate, and liabilities securely.

**Your privacy is our utmost priority.** Unlike traditional financial apps, Net Worth Tracker operates on a **100% offline, zero-tracking model**. We do not collect, transmit, monetize, sell, or share any of your personal financial numbers with remote cloud servers or third parties.

---

## 2. Information Handled by the Application
All data you input into the application remains exclusively on your physical Android device:
- **Financial Account Records:** Bank account names, institutions, account/folio identifiers, and current/invested values.
- **Family Profiles:** Allocations labeled under Self, Father, Mother, or Family Joint.
- **Double-Entry Ledger:** Transaction notes, income deposits, expense outflows, and running balances.
- **Local Security Passcode:** Hashed locally on your device for vault authentication.

---

## 3. Data Storage & Security
- **Local SQLite / Room Database:** All financial records are stored locally inside the application's secure private sandbox directory (`/data/data/com.example/databases/`).
- **Zero Cloud Servers:** We do not operate user accounts on remote servers, backend APIs, or external storage buckets.
- **Vault Passcode Protection:** Access to the application is protected by a local offline passcode configured by you.

---

## 4. Device Permissions Explained
- **Storage / File Access (Storage Access Framework / MediaStore):** Used strictly on your request when you tap "Export Backup" to save a JSON backup file to your phone's File Manager / Downloads, or when you tap "Restore Backup" to import your own backup file.
- **Zero Internet Obligation:** The core app functions fully without requiring any internet connection.

---

## 5. Third-Party Services & Trackers
- **No Third-Party Analytics:** We do NOT integrate Google Analytics for Firebase, Mixpanel, Adjust, or any behavior tracking SDKs.
- **No Advertising Networks:** We do NOT display banner ads, interstitial ads, or track user ad identifiers (AD_ID).
- **No Data Selling / Sharing:** Your financial numbers are never sold, rented, or shared with financial institutions, advertisers, or third-party data brokers.

---

## 6. User Rights & Data Deletion (Right to Erasure)
Under GDPR, CCPA, and Google Play Data Safety policies, you retain complete sovereignty over your data:
- **Data Export:** You can export all your financial records to a human-readable JSON backup file at any time via Settings > Offline Data Backup.
- **Permanent Data Deletion:** You can permanently wipe all accounts, transactions, ledger history, and security credentials directly from the app via Settings > Danger Zone > Delete All Financial Data. Uninstalling the app also permanently removes all local databases from the device.

---

## 7. Children's Privacy
Net Worth Tracker is designed for general audiences and personal financial bookkeeping. It does not knowingly collect or solicit information from children under the age of 13.

---

## 8. Changes to this Privacy Policy
We may update this Privacy Policy periodically to reflect new features or regulatory requirements. Any updates will be reflected inside the app with an updated effective date.

---

## 9. Contact & Developer Information
If you have any questions, feedback, or inquiries regarding this Privacy Policy, please contact:
- **Developer:** Azaz Madkiya
- **Email:** azazmadkiya@gmail.com
- **App:** Net Worth Tracker / Net Worth Vault
""".trimIndent()

    val privacyPolicyHtml = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Privacy Policy - Net Worth Tracker</title>
    <style>
        body { font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif; line-height: 1.6; color: #1e293b; max-width: 800px; margin: 0 auto; padding: 24px; background: #f8fafc; }
        .container { background: #ffffff; padding: 36px; border-radius: 16px; box-shadow: 0 4px 12px rgba(0,0,0,0.05); }
        h1 { color: #0f172a; border-bottom: 2px solid #e2e8f0; padding-bottom: 12px; }
        h2 { color: #1e40af; margin-top: 28px; }
        .badge { display: inline-block; background: #10b981; color: white; padding: 4px 12px; border-radius: 20px; font-weight: bold; font-size: 14px; margin-bottom: 16px; }
        .highlight-box { background: #ecfdf5; border-left: 4px solid #10b981; padding: 16px; border-radius: 8px; margin: 20px 0; }
        footer { margin-top: 40px; padding-top: 20px; border-top: 1px solid #e2e8f0; font-size: 14px; color: #64748b; }
    </style>
</head>
<body>
    <div class="container">
        <span class="badge">100% Offline & Private</span>
        <h1>Privacy Policy for Net Worth Tracker</h1>
        <p><strong>Effective Date:</strong> August 24, 2026<br>
        <strong>Developer:</strong> Azaz Madkiya (<a href="mailto:azazmadkiya@gmail.com">azazmadkiya@gmail.com</a>)</p>

        <div class="highlight-box">
            <strong>Key Summary:</strong> Net Worth Tracker does NOT collect, store, or transmit your financial data, account numbers, or balances to any external servers. Everything is stored 100% locally on your device.
        </div>

        <h2>1. Core Privacy Commitment</h2>
        <p>Net Worth Tracker ("the Application") is an offline-first personal financial ledger designed to help users track assets, bank balances, mutual funds, gold, and liabilities safely.</p>

        <h2>2. Data Collection & Processing</h2>
        <p>All data entered into the application remains solely on your physical device in an encrypted/private SQLite database. We do NOT operate remote databases or user tracking servers.</p>

        <h2>3. Permissions</h2>
        <p>File Manager permissions are requested only when you choose to export or import your personal JSON backup files.</p>

        <h2>4. Data Deletion (Right to Erasure)</h2>
        <p>You can completely delete all stored records anytime using the in-app "Delete All Data" button or by uninstalling the application.</p>

        <h2>5. Contact Information</h2>
        <p>For questions or support, contact: <strong>azazmadkiya@gmail.com</strong></p>

        <footer>
            &copy; 2026 Net Worth Tracker. All rights reserved.
        </footer>
    </div>
</body>
</html>
""".trimIndent()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Privacy Policy",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("privacy_policy_back_button")
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
                                putExtra(Intent.EXTRA_SUBJECT, "Privacy Policy - Net Worth Tracker")
                                putExtra(Intent.EXTRA_TEXT, privacyPolicyText)
                            }
                            context.startActivity(Intent.createChooser(shareIntent, "Share Privacy Policy"))
                        },
                        modifier = Modifier.testTag("btn_share_privacy_policy")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share Policy",
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

            // Privacy Guarantee Hero Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth().testTag("privacy_hero_card"),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF064E3B))
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                shape = CircleShape,
                                color = Color(0xFF10B981).copy(alpha = 0.25f),
                                modifier = Modifier.size(44.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Default.Shield,
                                        contentDescription = null,
                                        tint = Color(0xFF34D399),
                                        modifier = Modifier.size(26.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(14.dp))
                            Column {
                                Text(
                                    text = "Google Play Compliant",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF34D399)
                                )
                                Text(
                                    text = "100% On-Device Privacy",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Net Worth Tracker does not collect, transmit, or share your financial data. All balances, account numbers, and records remain on your device.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFFA7F3D0)
                        )
                    }
                }
            }

            // Quick Copy Actions for Play Store Console Submission
            item {
                Card(
                    modifier = Modifier.fillMaxWidth().testTag("copy_policy_card"),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text(
                            text = "Play Store Console & Hosting Tools",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Copy the full Privacy Policy in Markdown or HTML format to host on GitHub Pages, Notion, or your website for Google Play Console URL requirement:",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Button(
                                onClick = {
                                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                    val clip = ClipData.newPlainText("PrivacyPolicyMarkdown", privacyPolicyText)
                                    clipboard.setPrimaryClip(clip)
                                    Toast.makeText(context, "Copied Markdown Privacy Policy to Clipboard!", Toast.LENGTH_SHORT).show()
                                },
                                modifier = Modifier.weight(1f).testTag("btn_copy_markdown_policy"),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Icon(Icons.Default.ContentCopy, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Copy Markdown", fontSize = 12.sp)
                            }

                            OutlinedButton(
                                onClick = {
                                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                    val clip = ClipData.newPlainText("PrivacyPolicyHtml", privacyPolicyHtml)
                                    clipboard.setPrimaryClip(clip)
                                    Toast.makeText(context, "Copied HTML Privacy Policy to Clipboard!", Toast.LENGTH_SHORT).show()
                                },
                                modifier = Modifier.weight(1f).testTag("btn_copy_html_policy"),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Icon(Icons.Default.Html, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Copy HTML", fontSize = 12.sp)
                            }
                        }
                    }
                }
            }

            // Key Privacy Highlights List
            item {
                Card(
                    modifier = Modifier.fillMaxWidth().testTag("privacy_highlights_card"),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        Text(
                            text = "Privacy & Data Safety Highlights",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        PrivacyBulletPoint(
                            icon = Icons.Default.Storage,
                            iconTint = Color(0xFF3B82F6),
                            title = "Local SQLite Storage",
                            description = "Your financial figures, bank accounts, and family assets are stored locally in private application sandbox memory."
                        )

                        PrivacyBulletPoint(
                            icon = Icons.Default.VisibilityOff,
                            iconTint = Color(0xFF8B5CF6),
                            title = "No Trackers or Analytics",
                            description = "No telemetry, behavioral analytics, or marketing tracking SDKs exist within this application."
                        )

                        PrivacyBulletPoint(
                            icon = Icons.Default.Lock,
                            iconTint = Color(0xFF10B981),
                            title = "Passcode Vault Protection",
                            description = "App lock credentials are encrypted and verified exclusively on-device without remote auth servers."
                        )

                        PrivacyBulletPoint(
                            icon = Icons.Default.DeleteForever,
                            iconTint = Color(0xFFEF4444),
                            title = "Instant Local Erasure",
                            description = "You can wipe all data, reset credentials, or export JSON backups at any moment from the Settings menu."
                        )
                    }
                }
            }

            // Full Legal Policy Details
            item {
                Card(
                    modifier = Modifier.fillMaxWidth().testTag("full_policy_card"),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Text(
                            text = "Complete Policy Text",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        HorizontalDivider()

                        Text(
                            text = privacyPolicyText,
                            style = MaterialTheme.typography.bodySmall,
                            lineHeight = 20.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            // Contact & Developer Info
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
                                text = "Developer & Inquiries",
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
private fun PrivacyBulletPoint(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconTint: Color,
    title: String,
    description: String
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
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 16.sp
            )
        }
    }
}
