package com.example.ui.viewmodel

import com.example.data.model.FinancialItem
import com.example.data.model.FinancialReminder
import com.example.data.model.ItemCategory
import com.example.data.model.LedgerEntry
import com.example.data.model.OwnerProfile
import com.example.data.model.ReminderFrequency
import com.example.data.model.ReminderPriority
import com.example.data.model.ReminderType
import java.util.Calendar
import java.util.regex.Pattern

sealed class ParsedVoiceAction {
    data class AddReminderAction(
        val reminder: FinancialReminder,
        val explanation: String
    ) : ParsedVoiceAction()

    data class AddAccountAction(
        val accountItem: FinancialItem,
        val initialBalance: Double,
        val explanation: String
    ) : ParsedVoiceAction()

    data class AddFinancialItemAction(
        val item: FinancialItem,
        val explanation: String
    ) : ParsedVoiceAction()

    data class AddLedgerAction(
        val entry: LedgerEntry,
        val explanation: String
    ) : ParsedVoiceAction()

    data class TakeSnapshotAction(
        val note: String
    ) : ParsedVoiceAction()

    data class NavigateAction(
        val targetScreen: String
    ) : ParsedVoiceAction()

    data class UnknownAction(
        val rawSpeech: String,
        val suggestedExamples: List<String>
    ) : ParsedVoiceAction()
}

object VoiceCommandParser {

    fun parse(rawText: String): ParsedVoiceAction {
        val text = rawText.trim()
        if (text.isBlank()) {
            return ParsedVoiceAction.UnknownAction(
                rawSpeech = rawText,
                suggestedExamples = listOf(
                    "Add reminder pay electricity bill 1500 tomorrow",
                    "Add account HDFC Bank 50000",
                    "Add asset Reliance stock 50000",
                    "Add expense 450 groceries",
                    "Add income 80000 salary",
                    "Add liability car loan 350000"
                )
            )
        }

        val lower = text.lowercase()

        // 1. Snapshot command
        if (lower.contains("take snapshot") || lower.contains("record snapshot") || lower.contains("save snapshot")) {
            val note = text.replace("take snapshot", "", ignoreCase = true)
                .replace("record snapshot", "", ignoreCase = true)
                .replace("save snapshot", "", ignoreCase = true)
                .trim()
            return ParsedVoiceAction.TakeSnapshotAction(
                note = if (note.isNotBlank()) note else "Voice Snapshot"
            )
        }

        // 2. Navigation commands
        if (lower.startsWith("go to ") || lower.startsWith("show ") || lower.startsWith("open ")) {
            when {
                lower.contains("asset") -> return ParsedVoiceAction.NavigateAction("Assets")
                lower.contains("ledger") || lower.contains("transaction") -> return ParsedVoiceAction.NavigateAction("Ledger")
                lower.contains("reminder") -> return ParsedVoiceAction.NavigateAction("Reminders")
                lower.contains("analytic") || lower.contains("chart") -> return ParsedVoiceAction.NavigateAction("Analytics")
                lower.contains("setting") -> return ParsedVoiceAction.NavigateAction("Settings")
                lower.contains("dashboard") || lower.contains("home") -> return ParsedVoiceAction.NavigateAction("Dashboard")
            }
        }

        // 3. Extract amount if present
        val extractedAmount = extractAmount(lower) ?: 0.0

        // 4. Extract owner if mentioned
        val detectedOwner = when {
            lower.contains("father") || lower.contains("dad") -> OwnerProfile.FATHER.displayName
            lower.contains("mother") || lower.contains("mom") -> OwnerProfile.MOTHER.displayName
            lower.contains("family") || lower.contains("joint") -> OwnerProfile.FAMILY.displayName
            else -> OwnerProfile.SELF.displayName
        }

        // 5. Check if it is an Account intent (Bank Account / Savings Account)
        val isAccountIntent = lower.contains("add account") || lower.contains("create account") ||
                lower.contains("new account") || lower.contains("bank account") ||
                lower.contains("savings account") || lower.contains("current account") ||
                (lower.startsWith("add ") && (lower.contains("bank") || lower.contains("account")))

        if (isAccountIntent) {
            var cleanedTitle = text
                .replace("(?i)add bank account with balance ".toRegex(), "")
                .replace("(?i)add bank account of ".toRegex(), "")
                .replace("(?i)add bank account ".toRegex(), "")
                .replace("(?i)add savings account with balance ".toRegex(), "")
                .replace("(?i)add savings account of ".toRegex(), "")
                .replace("(?i)add savings account ".toRegex(), "")
                .replace("(?i)add current account with balance ".toRegex(), "")
                .replace("(?i)add current account of ".toRegex(), "")
                .replace("(?i)add current account ".toRegex(), "")
                .replace("(?i)add new account with balance ".toRegex(), "")
                .replace("(?i)add new account of ".toRegex(), "")
                .replace("(?i)add new account ".toRegex(), "")
                .replace("(?i)add account with balance ".toRegex(), "")
                .replace("(?i)add account of ".toRegex(), "")
                .replace("(?i)add account ".toRegex(), "")
                .replace("(?i)create bank account with balance ".toRegex(), "")
                .replace("(?i)create bank account of ".toRegex(), "")
                .replace("(?i)create bank account ".toRegex(), "")
                .replace("(?i)create account with balance ".toRegex(), "")
                .replace("(?i)create account of ".toRegex(), "")
                .replace("(?i)create account ".toRegex(), "")
                .replace("(?i)new bank account ".toRegex(), "")
                .replace("(?i)new account ".toRegex(), "")
                .replace("(?i)with balance ".toRegex(), "")
                .replace("(?i)with initial balance ".toRegex(), "")
                .replace("(?i)with opening balance ".toRegex(), "")
                .replace("(?i)having balance ".toRegex(), "")
                .replace("(?i)balance of ".toRegex(), "")
                .replace("(?i)balance ".toRegex(), "")
                .replace("(?i)for mother".toRegex(), "")
                .replace("(?i)for father".toRegex(), "")
                .replace("(?i)for self".toRegex(), "")
                .replace("(?i)for family".toRegex(), "")

            if (extractedAmount > 0.0) {
                cleanedTitle = cleanedTitle.replace("(?i)(rs\\.?|inr|₹|\\$)?\\s*${extractedAmount.toLong()}".toRegex(), "")
                cleanedTitle = cleanedTitle.replace("(?i)(rs\\.?|inr|₹|\\$)?\\s*$extractedAmount".toRegex(), "")
            }
            cleanedTitle = cleanedTitle.trim().trim(',', '.', '-', ':').capitalizeFirst()
            if (cleanedTitle.isBlank()) {
                cleanedTitle = "Bank Account"
            }

            val accountItem = FinancialItem(
                title = cleanedTitle,
                category = ItemCategory.BANK_ACCOUNT.displayName,
                isLiability = false,
                currentValue = extractedAmount,
                investedValue = extractedAmount,
                institution = cleanedTitle,
                owner = detectedOwner,
                notes = "Created via Voice Control: \"$rawText\""
            )

            return ParsedVoiceAction.AddAccountAction(
                accountItem = accountItem,
                initialBalance = extractedAmount,
                explanation = "New Account: '$cleanedTitle' with balance ₹ ${String.format("%.0f", extractedAmount)}"
            )
        }

        // 5. Check if it is a Reminder intent
        if (lower.contains("remind") || lower.contains("reminder") || lower.contains("bill due") || lower.contains("alert")) {
            val hasEmi = "\\bemi\\b".toRegex().containsMatchIn(lower)
            val reminderType = when {
                lower.contains("sip") || lower.contains("mutual fund") -> ReminderType.SIP_INVESTMENT
                lower.contains("credit card") -> ReminderType.CREDIT_CARD_BILL
                lower.contains("insurance") || lower.contains("premium") -> ReminderType.INSURANCE_PREMIUM
                lower.contains("bill") || lower.contains("due") || lower.contains("electricity") || lower.contains("water") || lower.contains("rent") -> ReminderType.DUE_DATE
                hasEmi || lower.contains("loan") -> ReminderType.LOAN_EMI
                else -> ReminderType.CUSTOM
            }

            val priority = when {
                lower.contains("urgent") || lower.contains("critical") || lower.contains("high") || lower.contains("important") -> ReminderPriority.HIGH
                lower.contains("low") -> ReminderPriority.LOW
                else -> ReminderPriority.MEDIUM
            }

            val frequency = when {
                lower.contains("every month") || lower.contains("monthly") -> ReminderFrequency.MONTHLY
                lower.contains("quarterly") -> ReminderFrequency.QUARTERLY
                lower.contains("yearly") || lower.contains("annual") -> ReminderFrequency.YEARLY
                else -> ReminderFrequency.ONE_TIME
            }

            val dueDayEpoch = calculateDueDayEpoch(lower)

            // Clean title
            var cleanedTitle = text
                .replace("(?i)add reminder to ".toRegex(), "")
                .replace("(?i)add reminder ".toRegex(), "")
                .replace("(?i)remind me to ".toRegex(), "")
                .replace("(?i)remind me ".toRegex(), "")
                .replace("(?i)set reminder for ".toRegex(), "")
                .replace("(?i)set reminder ".toRegex(), "")
                .replace("(?i)tomorrow".toRegex(), "")
                .replace("(?i)today".toRegex(), "")
                .replace("(?i)next week".toRegex(), "")
                .replace("(?i)next month".toRegex(), "")
                .replace("(?i)for mother".toRegex(), "")
                .replace("(?i)for father".toRegex(), "")
                .replace("(?i)for self".toRegex(), "")

            if (extractedAmount > 0.0) {
                cleanedTitle = cleanedTitle.replace("(?i)(rs\\.?|inr|₹|\\$)?\\s*${extractedAmount.toLong()}".toRegex(), "")
                cleanedTitle = cleanedTitle.replace("(?i)(rs\\.?|inr|₹|\\$)?\\s*$extractedAmount".toRegex(), "")
            }
            cleanedTitle = cleanedTitle.trim().trim(',', '.', '-', ':').capitalizeFirst()
            if (cleanedTitle.isBlank()) {
                cleanedTitle = "${reminderType.displayName} Reminder"
            }

            val reminder = FinancialReminder(
                title = cleanedTitle,
                amount = extractedAmount,
                reminderType = reminderType.name,
                priority = priority.name,
                dueDateEpochDay = dueDayEpoch,
                frequency = frequency.name,
                owner = detectedOwner,
                notes = "Created via Voice Command: \"$rawText\""
            )

            return ParsedVoiceAction.AddReminderAction(
                reminder = reminder,
                explanation = "Reminder for '$cleanedTitle' of ₹ ${String.format("%.0f", extractedAmount)} (${reminderType.displayName})"
            )
        }

        // 6. Check if it is an Expense or Income or Ledger intent
        if (lower.contains("expense") || lower.contains("spent") || lower.contains("paid for") || lower.contains("bought") ||
            lower.contains("income") || lower.contains("salary") || lower.contains("credited") || lower.contains("received") ||
            lower.contains("transfer")
        ) {
            val isExpense = lower.contains("expense") || lower.contains("spent") || lower.contains("paid") || lower.contains("bought")
            val isIncome = lower.contains("income") || lower.contains("salary") || lower.contains("received") || lower.contains("credited")

            val entryType = if (isExpense) "DEBIT" else "CREDIT"
            val debit = if (isExpense) extractedAmount else 0.0
            val credit = if (isIncome) extractedAmount else 0.0

            var cleanedTitle = text
                .replace("(?i)add expense of ".toRegex(), "")
                .replace("(?i)add expense ".toRegex(), "")
                .replace("(?i)add income of ".toRegex(), "")
                .replace("(?i)add income ".toRegex(), "")
                .replace("(?i)spent on ".toRegex(), "")
                .replace("(?i)spent ".toRegex(), "")
                .replace("(?i)paid for ".toRegex(), "")
                .replace("(?i)paid ".toRegex(), "")
                .replace("(?i)received from ".toRegex(), "")
                .replace("(?i)received ".toRegex(), "")

            if (extractedAmount > 0.0) {
                cleanedTitle = cleanedTitle.replace("(?i)(rs\\.?|inr|₹|\\$)?\\s*${extractedAmount.toLong()}".toRegex(), "")
                cleanedTitle = cleanedTitle.replace("(?i)(rs\\.?|inr|₹|\\$)?\\s*$extractedAmount".toRegex(), "")
            }
            cleanedTitle = cleanedTitle.trim().trim(',', '.', '-', ':', 'f', 'o', 'r').trim().capitalizeFirst()
            if (cleanedTitle.isBlank()) {
                cleanedTitle = if (isExpense) "Expense Entry" else "Income Entry"
            }

            val entry = LedgerEntry(
                transactionTitle = cleanedTitle,
                accountName = "Bank Account",
                oppositeAccountName = if (isExpense) "Vendor / Merchant" else "Source / Employer",
                entryType = entryType,
                debitAmount = debit,
                creditAmount = credit,
                category = if (isExpense) ItemCategory.EXPENSE.displayName else ItemCategory.INCOME.displayName,
                notes = "Voice entry: \"$rawText\""
            )

            return ParsedVoiceAction.AddLedgerAction(
                entry = entry,
                explanation = "Ledger $entryType: '$cleanedTitle' of ₹ ${String.format("%.0f", extractedAmount)}"
            )
        }

        // 7. Check if it is an Asset or Liability intent
        val isLiability = lower.contains("liability") || lower.contains("loan") || lower.contains("debt") || lower.contains("borrowed") || lower.contains("dues")

        val detectedCategory = when {
            lower.contains("stock") || lower.contains("share") || lower.contains("zerodha") || lower.contains("groww") || lower.contains("angel") -> ItemCategory.SHARE_MARKET
            lower.contains("mutual fund") || lower.contains("sip") -> ItemCategory.MUTUAL_FUNDS
            lower.contains("gold") || lower.contains("silver") || lower.contains("jewelry") -> ItemCategory.GOLD_SILVER
            lower.contains("real estate") || lower.contains("plot") || lower.contains("land") || lower.contains("flat") || lower.contains("house") -> ItemCategory.REAL_ESTATE
            lower.contains("cash") -> ItemCategory.CASH
            lower.contains("ipo") -> ItemCategory.IPO
            lower.contains("loan given") || lower.contains("aapel loan") || lower.contains("lent") -> ItemCategory.PAID_LOAN
            lower.contains("loan") || lower.contains("debt") || lower.contains("liability") || "\\bemi\\b".toRegex().containsMatchIn(lower) -> ItemCategory.LOAN_LIABILITY
            lower.contains("bank") || lower.contains("savings") || lower.contains("fixed deposit") || lower.contains("fd") -> ItemCategory.BANK_ACCOUNT
            else -> if (isLiability) ItemCategory.LOAN_LIABILITY else ItemCategory.OTHER_INVESTMENT
        }

        var cleanedTitle = text
            .replace("(?i)add asset ".toRegex(), "")
            .replace("(?i)add liability ".toRegex(), "")
            .replace("(?i)add loan ".toRegex(), "")
            .replace("(?i)add entry ".toRegex(), "")
            .replace("(?i)add ".toRegex(), "")
            .replace("(?i)for mother".toRegex(), "")
            .replace("(?i)for father".toRegex(), "")
            .replace("(?i)for self".toRegex(), "")

        if (extractedAmount > 0.0) {
            cleanedTitle = cleanedTitle.replace("(?i)(rs\\.?|inr|₹|\\$)?\\s*${extractedAmount.toLong()}".toRegex(), "")
            cleanedTitle = cleanedTitle.replace("(?i)(rs\\.?|inr|₹|\\$)?\\s*$extractedAmount".toRegex(), "")
        }
        cleanedTitle = cleanedTitle.trim().trim(',', '.', '-', ':').capitalizeFirst()
        if (cleanedTitle.isBlank()) {
            cleanedTitle = if (isLiability) "New Liability" else "New Asset"
        }

        val item = FinancialItem(
            title = cleanedTitle,
            institution = detectInstitution(lower),
            owner = detectedOwner,
            category = detectedCategory.displayName,
            currentValue = extractedAmount,
            investedValue = extractedAmount,
            isLiability = isLiability,
            notes = "Created via Voice Command: \"$rawText\""
        )

        return ParsedVoiceAction.AddFinancialItemAction(
            item = item,
            explanation = "${if (isLiability) "Liability" else "Asset"}: '$cleanedTitle' (${detectedCategory.displayName}) valued at ₹ ${String.format("%.0f", extractedAmount)}"
        )
    }

    private fun extractAmount(text: String): Double? {
        // Look for patterns like 5000, 50,000, 2.5 lakh, 1.5 cr, 50k
        val kPattern = Pattern.compile("(\\d+(\\.\\d+)?)\\s*(k|thousand)")
        val kMatcher = kPattern.matcher(text)
        if (kMatcher.find()) {
            val num = kMatcher.group(1)?.toDoubleOrNull() ?: return null
            return num * 1000.0
        }

        val lakhPattern = Pattern.compile("(\\d+(\\.\\d+)?)\\s*(lakh|lac|l)")
        val lakhMatcher = lakhPattern.matcher(text)
        if (lakhMatcher.find()) {
            val num = lakhMatcher.group(1)?.toDoubleOrNull() ?: return null
            return num * 100000.0
        }

        val crPattern = Pattern.compile("(\\d+(\\.\\d+)?)\\s*(cr|crore)")
        val crMatcher = crPattern.matcher(text)
        if (crMatcher.find()) {
            val num = crMatcher.group(1)?.toDoubleOrNull() ?: return null
            return num * 10000000.0
        }

        // Standard number matching (e.g. 1500, 25000, 500.50)
        val numPattern = Pattern.compile("(?<![a-zA-Z])(\\d{2,10}(\\.\\d+)?)(?![a-zA-Z])")
        val numMatcher = numPattern.matcher(text.replace(",", ""))
        if (numMatcher.find()) {
            return numMatcher.group(1)?.toDoubleOrNull()
        }

        return null
    }

    private fun detectInstitution(text: String): String {
        return when {
            text.contains("hdfc") -> "HDFC Bank"
            text.contains("sbi") -> "State Bank of India"
            text.contains("icici") -> "ICICI Bank"
            text.contains("zerodha") -> "Zerodha"
            text.contains("groww") -> "Groww"
            text.contains("upstox") -> "Upstox"
            text.contains("axis") -> "Axis Bank"
            text.contains("kotak") -> "Kotak Mahindra Bank"
            else -> "Self / Portfolio"
        }
    }

    private fun calculateDueDayEpoch(text: String): Long {
        val calendar = Calendar.getInstance()
        when {
            text.contains("tomorrow") -> calendar.add(Calendar.DAY_OF_YEAR, 1)
            text.contains("day after tomorrow") -> calendar.add(Calendar.DAY_OF_YEAR, 2)
            text.contains("next week") -> calendar.add(Calendar.DAY_OF_YEAR, 7)
            text.contains("next month") -> calendar.add(Calendar.MONTH, 1)
            else -> {
                // Check if specific day like "on 5th", "on 15th"
                val dayPattern = Pattern.compile("on (\\d{1,2})(st|nd|rd|th)?")
                val m = dayPattern.matcher(text)
                if (m.find()) {
                    val day = m.group(1)?.toIntOrNull()
                    if (day != null && day in 1..31) {
                        calendar.set(Calendar.DAY_OF_MONTH, day)
                        if (calendar.timeInMillis < System.currentTimeMillis()) {
                            calendar.add(Calendar.MONTH, 1)
                        }
                    }
                } else {
                    calendar.add(Calendar.DAY_OF_YEAR, 3) // default in 3 days
                }
            }
        }
        return calendar.timeInMillis / 86400000L
    }

    private fun String.capitalizeFirst(): String {
        return if (isNotEmpty()) this[0].uppercaseChar() + substring(1) else this
    }
}
