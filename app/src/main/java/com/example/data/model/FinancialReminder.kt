package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "financial_reminders")
data class FinancialReminder(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val title: String,
    val amount: Double = 0.0,
    val reminderType: String = ReminderType.DUE_DATE.name,
    val priority: String = ReminderPriority.MEDIUM.name,
    val dueDateEpochDay: Long = 0L,
    val frequency: String = ReminderFrequency.ONE_TIME.name,
    val owner: String = "Self",
    val associatedAccount: String = "",
    val notes: String = "",
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
) {
    val isEvent: Boolean
        get() = reminderType == ReminderType.EVENT_REMINDER.name
}

@Entity(tableName = "reminders")
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val message: String,
    val dueDate: Long = 0L,
    val priority: String = "MEDIUM",
    val isCompleted: Boolean = false,
    val amount: Double = 0.0,
    val category: String = "General"
)

enum class ReminderType(
    val displayName: String,
    val iconName: String
) {
    EVENT_REMINDER("Event Reminder", "Event"),
    DUE_DATE("Payment / Bill Due", "Payment"),
    SIP_INVESTMENT("SIP / Mutual Fund", "TrendingUp"),
    LOAN_EMI("Loan EMI / Interest", "CreditCard"),
    CREDIT_CARD_BILL("Credit Card Bill", "AccountBalance"),
    INSURANCE_PREMIUM("Insurance Premium", "Shield"),
    CUSTOM("Custom Reminder", "Notifications");

    companion object {
        fun fromString(value: String): ReminderType {
            return entries.firstOrNull {
                it.displayName.equals(value, ignoreCase = true) ||
                it.name.equals(value, ignoreCase = true)
            } ?: DUE_DATE
        }
    }
}

data class EventTemplate(
    val title: String,
    val category: String,
    val defaultDays: Long,
    val frequency: ReminderFrequency,
    val priority: ReminderPriority,
    val placeholderBudget: Double = 0.0
)

object EventReminderPresets {
    val presets = listOf(
        EventTemplate("Tax Filing / Return Deadline", "Tax & Compliance", 15, ReminderFrequency.YEARLY, ReminderPriority.HIGH, 0.0),
        EventTemplate("Insurance Policy Renewal", "Insurance", 10, ReminderFrequency.YEARLY, ReminderPriority.HIGH, 15000.0),
        EventTemplate("FD / Bond Maturity Event", "Investment", 30, ReminderFrequency.ONE_TIME, ReminderPriority.HIGH, 0.0),
        EventTemplate("Portfolio Rebalancing & Review", "Financial Review", 7, ReminderFrequency.QUARTERLY, ReminderPriority.MEDIUM, 0.0),
        EventTemplate("Birthday / Anniversary Occasion", "Family & Gifts", 5, ReminderFrequency.YEARLY, ReminderPriority.MEDIUM, 2500.0),
        EventTemplate("Property Tax / Society Dues", "Real Estate", 20, ReminderFrequency.YEARLY, ReminderPriority.MEDIUM, 5000.0),
        EventTemplate("Vehicle Service & Pollution Test", "Automobile", 14, ReminderFrequency.MONTHLY, ReminderPriority.LOW, 2000.0)
    )
}

enum class ReminderPriority(
    val displayName: String,
    val level: Int
) {
    HIGH("High", 3),
    MEDIUM("Medium", 2),
    LOW("Low", 1);

    companion object {
        fun fromString(value: String): ReminderPriority {
            return entries.firstOrNull {
                it.displayName.equals(value, ignoreCase = true) ||
                it.name.equals(value, ignoreCase = true)
            } ?: MEDIUM
        }
    }
}

enum class ReminderFrequency(
    val displayName: String
) {
    ONE_TIME("One-time"),
    MONTHLY("Monthly"),
    QUARTERLY("Quarterly"),
    YEARLY("Yearly");

    companion object {
        fun fromString(value: String): ReminderFrequency {
            return entries.firstOrNull {
                it.displayName.equals(value, ignoreCase = true) ||
                it.name.equals(value, ignoreCase = true)
            } ?: ONE_TIME
        }
    }
}
