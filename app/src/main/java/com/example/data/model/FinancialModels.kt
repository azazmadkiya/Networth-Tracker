package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "financial_items")
data class FinancialItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val title: String,
    val institution: String = "",
    val accountNumber: String = "",
    val owner: String = "Self",
    val category: String = "Bank Account",
    val currentValue: Double = 0.0,
    val investedValue: Double = 0.0,
    val isLiability: Boolean = false,
    val notes: String = "",
    val sourceAccountTitle: String = "",
    val updatedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "net_worth_snapshots")
data class NetWorthSnapshot(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val timestamp: Long = System.currentTimeMillis(),
    val totalAssets: Double = 0.0,
    val totalLiabilities: Double = 0.0,
    val netWorth: Double = 0.0,
    val note: String = ""
)

@Entity(tableName = "ledger_entries")
data class LedgerEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val timestamp: Long = System.currentTimeMillis(),
    val transactionTitle: String,
    val accountName: String = "",
    val oppositeAccountName: String = "",
    val entryType: String = "DEBIT",
    val debitAmount: Double = 0.0,
    val creditAmount: Double = 0.0,
    val runningBalance: Double = 0.0,
    val category: String = "General",
    val notes: String = ""
)

data class AccountAdjustment(
    val item: FinancialItem,
    val oldBalance: Double,
    val newBalance: Double,
    val change: Double,
    val explanation: String
)

data class DeletionAdjustmentResult(
    val entryId: Long,
    val transactionTitle: String,
    val adjustmentsApplied: List<AccountAdjustment>,
    val netWorthBefore: Double,
    val netWorthAfter: Double,
    val netWorthDifference: Double,
    val success: Boolean,
    val message: String
)

@Entity(tableName = "assets")
data class Asset(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String,
    val type: String = "Asset",
    val category: String = "General",
    val value: Double = 0.0
)

enum class ItemCategory(
    val displayName: String,
    val isLiability: Boolean = false,
    val iconName: String = "AccountBalance"
) {
    BANK_ACCOUNT("Bank Account", false, "AccountBalance"),
    SHARE_MARKET("Share Market / Stocks", false, "TrendingUp"),
    MUTUAL_FUNDS("Mutual Funds", false, "PieChart"),
    IPO("IPO Application", false, "ShowChart"),
    PAID_LOAN("Paid Loan / Aapel Loan (આપેલ લોન)", false, "Handshake"),
    GOLD_SILVER("Gold & Silver", false, "Diamond"),
    REAL_ESTATE("Real Estate / Land", false, "Home"),
    CASH("Cash on Hand", false, "Payments"),
    OTHER_INVESTMENT("Other Investments (PF/FD/PPF)", false, "Savings"),
    INCOME("Income / Earnings", false, "TrendingUp"),
    EXPENSE("Expense / Outflow", true, "ShoppingCart"),
    LOAN_LIABILITY("Loans & Dues", true, "CreditCard"),
    SUNDRY_CREDITORS("Sundry Creditors", true, "MoneyOff"),
    SUNDRY_DEBTORS("Sundry Debtors", false, "AttachMoney"),
    OTHER_ACCOUNT("Other Account", false, "AccountBox");

    companion object {
        fun fromString(value: String): ItemCategory {
            return entries.firstOrNull {
                it.displayName.equals(value, ignoreCase = true) ||
                it.name.equals(value, ignoreCase = true)
            } ?: BANK_ACCOUNT
        }
    }
}

enum class OwnerProfile(
    val displayName: String,
    val badgeColorHex: Long
) {
    SELF("Self", 0xFF00897BL),
    FATHER("Father", 0xFF1E88E5L),
    MOTHER("Mother", 0xFF8E24AAL),
    FAMILY("Family Joint", 0xFFE53935L);

    companion object {
        fun fromString(value: String): OwnerProfile {
            return entries.firstOrNull {
                it.displayName.equals(value, ignoreCase = true) ||
                it.name.equals(value, ignoreCase = true)
            } ?: SELF
        }
    }
}
