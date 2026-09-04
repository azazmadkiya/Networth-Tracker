package com.example.ui.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.example.data.model.LedgerEntry

object ShareUtils {

    /**
     * Formats a single Ledger Entry (Income, Expense, Transfer) into a clean, professional receipt text.
     */
    fun formatLedgerEntry(entry: LedgerEntry): String {
        val isCredit = entry.entryType.equals("CREDIT", ignoreCase = true)
        val isDebit = entry.entryType.equals("DEBIT", ignoreCase = true)
        val typeLabel = when {
            isCredit -> "🟢 Income (Credit)"
            isDebit -> "🔴 Expense (Debit)"
            else -> "🔄 Transfer"
        }
        val amount = if (isCredit) entry.creditAmount else entry.debitAmount
        val formattedAmount = NumberFormatUtils.formatCurrency(amount)
        val formattedDate = NumberFormatUtils.formatDate(entry.timestamp)

        val builder = StringBuilder()
        builder.appendLine("════════════════════════════")
        builder.appendLine("🧾 FINANCIAL TRANSACTION RECEIPT")
        builder.appendLine("════════════════════════════")
        builder.appendLine("📌 Type: $typeLabel")
        builder.appendLine("📝 Title: ${entry.transactionTitle}")
        builder.appendLine("💰 Amount: $formattedAmount")
        builder.appendLine("🏦 Account: ${entry.accountName}")
        if (entry.oppositeAccountName.isNotBlank()) {
            val oppLabel = if (isCredit) "Source / Sender" else if (isDebit) "Payee / Merchant" else "Transferred To"
            builder.appendLine("👤 $oppLabel: ${entry.oppositeAccountName}")
        }
        if (entry.category.isNotBlank()) {
            builder.appendLine("🏷️ Category: ${entry.category}")
        }
        builder.appendLine("📅 Date: $formattedDate")
        if (entry.notes.isNotBlank()) {
            builder.appendLine("💬 Notes: ${entry.notes}")
        }
        builder.appendLine("────────────────────────────")
        builder.appendLine("Shared via Net Worth Tracker App")
        builder.appendLine("════════════════════════════")
        return builder.toString()
    }

    /**
     * Formats a summary of Income and Expenses across the ledger.
     */
    fun formatLedgerSummary(
        entries: List<LedgerEntry>,
        totalCredit: Double,
        totalDebit: Double
    ): String {
        val netCashFlow = totalCredit - totalDebit
        val builder = StringBuilder()
        builder.appendLine("════════════════════════════")
        builder.appendLine("📊 INCOME & EXPENSE STATEMENT")
        builder.appendLine("════════════════════════════")
        builder.appendLine("🟢 Total Inflow (Income):  ${NumberFormatUtils.formatCurrency(totalCredit)}")
        builder.appendLine("🔴 Total Outflow (Expense): ${NumberFormatUtils.formatCurrency(totalDebit)}")
        builder.appendLine("⚖️ Net Cash Flow:         ${if (netCashFlow >= 0) "+" else ""}${NumberFormatUtils.formatCurrency(netCashFlow)}")
        builder.appendLine("🔢 Total Entries:          ${entries.size}")
        builder.appendLine("────────────────────────────")

        if (entries.isNotEmpty()) {
            builder.appendLine("📋 Recent Transactions:")
            val topEntries = entries.take(15)
            topEntries.forEachIndexed { index, entry ->
                val isCredit = entry.entryType.equals("CREDIT", ignoreCase = true)
                val sign = if (isCredit) "+ " else "- "
                val amt = if (isCredit) entry.creditAmount else entry.debitAmount
                val dateStr = NumberFormatUtils.formatDateShort(entry.timestamp)
                builder.appendLine("${index + 1}. [${entry.entryType}] ${entry.transactionTitle}: $sign${NumberFormatUtils.formatCurrency(amt)} ($dateStr)")
            }
            if (entries.size > 15) {
                builder.appendLine("... and ${entries.size - 15} more entries")
            }
            builder.appendLine("────────────────────────────")
        }
        builder.appendLine("Shared via Net Worth Tracker App")
        builder.appendLine("════════════════════════════")
        return builder.toString()
    }

    /**
     * Shares formatted text directly to WhatsApp or WhatsApp Business.
     * If phoneNumber is provided, initiates a direct chat.
     */
    fun shareViaWhatsApp(context: Context, text: String, phoneNumber: String? = null): Boolean {
        return try {
            val cleanPhone = phoneNumber?.replace(Regex("[^0-9+]"), "")?.trim()
            if (!cleanPhone.isNullOrBlank()) {
                // Direct WhatsApp message to specific phone number
                val formattedPhone = if (!cleanPhone.startsWith("+") && cleanPhone.length == 10) {
                    "91$cleanPhone" // Default country code if 10 digits
                } else {
                    cleanPhone.removePrefix("+")
                }
                val uri = Uri.parse("https://api.whatsapp.com/send?phone=$formattedPhone&text=${Uri.encode(text)}")
                val intent = Intent(Intent.ACTION_VIEW, uri).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                context.startActivity(intent)
                true
            } else {
                // Share to WhatsApp contact picker
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    `package` = "com.whatsapp"
                    putExtra(Intent.EXTRA_TEXT, text)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                context.startActivity(intent)
                true
            }
        } catch (e: Exception) {
            // Fallback: Check WhatsApp Business
            try {
                val intentW4b = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    `package` = "com.whatsapp.w4b"
                    putExtra(Intent.EXTRA_TEXT, text)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                context.startActivity(intentW4b)
                true
            } catch (e2: Exception) {
                // Fallback: Web WhatsApp via browser or general share sheet
                try {
                    val webUri = Uri.parse("https://api.whatsapp.com/send?text=${Uri.encode(text)}")
                    val webIntent = Intent(Intent.ACTION_VIEW, webUri).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }
                    context.startActivity(webIntent)
                    true
                } catch (e3: Exception) {
                    Toast.makeText(context, "WhatsApp is not installed. Opening Share menu...", Toast.LENGTH_SHORT).show()
                    shareViaOtherPlatforms(context, "Transaction Details", text)
                    false
                }
            }
        }
    }

    /**
     * Shares formatted text via SMS application.
     */
    fun shareViaSms(context: Context, text: String, phoneNumber: String? = null): Boolean {
        return try {
            val cleanPhone = phoneNumber?.replace(Regex("[^0-9+]"), "")?.trim() ?: ""
            val uri = Uri.parse("smsto:$cleanPhone")
            val intent = Intent(Intent.ACTION_SENDTO, uri).apply {
                putExtra("sms_body", text)
                putExtra(Intent.EXTRA_TEXT, text)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
            true
        } catch (e: Exception) {
            try {
                // Fallback to standard ACTION_VIEW for SMS
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("sms:${phoneNumber ?: ""}")
                    putExtra("sms_body", text)
                    putExtra(Intent.EXTRA_TEXT, text)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                context.startActivity(intent)
                true
            } catch (e2: Exception) {
                Toast.makeText(context, "No SMS app found. Opening Share menu...", Toast.LENGTH_SHORT).show()
                shareViaOtherPlatforms(context, "Transaction Details", text)
                false
            }
        }
    }

    /**
     * Shares formatted text via Email with Subject and Body.
     */
    fun shareViaEmail(
        context: Context,
        subject: String,
        body: String,
        recipientEmail: String? = null
    ): Boolean {
        return try {
            val email = recipientEmail?.trim() ?: ""
            val uri = Uri.parse("mailto:$email")
            val intent = Intent(Intent.ACTION_SENDTO, uri).apply {
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, body)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
            true
        } catch (e: Exception) {
            try {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "message/rfc822"
                    if (!recipientEmail.isNullOrBlank()) {
                        putExtra(Intent.EXTRA_EMAIL, arrayOf(recipientEmail.trim()))
                    }
                    putExtra(Intent.EXTRA_SUBJECT, subject)
                    putExtra(Intent.EXTRA_TEXT, body)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                context.startActivity(Intent.createChooser(intent, "Send Email via..."))
                true
            } catch (e2: Exception) {
                Toast.makeText(context, "No Email app found. Opening Share menu...", Toast.LENGTH_SHORT).show()
                shareViaOtherPlatforms(context, subject, body)
                false
            }
        }
    }

    /**
     * Shares text to any installed app via Android's System Share Chooser.
     */
    fun shareViaOtherPlatforms(context: Context, subject: String, text: String) {
        try {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, text)
            }
            val chooser = Intent.createChooser(intent, "Share Transaction via...").apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(chooser)
        } catch (e: Exception) {
            Toast.makeText(context, "Could not open share menu: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Copies text to system clipboard.
     */
    fun copyToClipboard(context: Context, label: String, text: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText(label, text)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(context, "Copied to clipboard!", Toast.LENGTH_SHORT).show()
    }
}
