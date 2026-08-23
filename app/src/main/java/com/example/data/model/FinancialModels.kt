package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class OwnerProfile(val displayName: String, val badgeColorHex: Long) {
    SELF("Self", 0xFF0284C7),       // Sky Blue
    FATHER("Father", 0xFF059669),   // Emerald Green
    MOTHER("Mother", 0xFF9333EA),   // Purple
    FAMILY("Family Joint", 0xFFD97706); // Amber

    companion object {
        fun fromString(value: String): OwnerProfile {
            return entries.find { it.displayName.equals(value, ignoreCase = true) || it.name.equals(value, ignoreCase = true) } ?: SELF
        }
    }
}

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
    LOAN_LIABILITY("Loans & Dues", true, "CreditCard");

    companion object {
        fun fromString(value: String): ItemCategory {
            return entries.find { it.displayName.equals(value, ignoreCase = true) || it.name.equals(value, ignoreCase = true) } ?: BANK_ACCOUNT
        }
    }
}

@Entity(tableName = "financial_items")
data class FinancialItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,                // e.g. "HDFC Savings Account", "Zerodha Demat"
    val institution: String = "",     // e.g. "HDFC Bank", "Zerodha", "Groww"
    val accountNumber: String = "",   // e.g. "x8921"
    val owner: String = "Self",       // Self, Father, Mother, Family Joint
    val category: String = "Bank Account",
    val currentValue: Double = 0.0,
    val investedValue: Double = 0.0,  // Original buying price for Stocks/MF
    val isLiability: Boolean = false,
    val notes: String = "",
    val sourceAccountTitle: String = "", // Opposite Account from which expense is deducted
    val updatedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "ledger_entries")
data class LedgerEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val timestamp: Long = System.currentTimeMillis(),
    val transactionTitle: String,         // e.g. "House Rent", "Grocery Shopping"
    val accountName: String,              // e.g. "HDFC Savings Account" or "Rent Expense"
    val oppositeAccountName: String = "", // e.g. "HDFC Savings Account"
    val entryType: String,                // "DR" (Debit) or "CR" (Credit)
    val debitAmount: Double = 0.0,        // DR Amount
    val creditAmount: Double = 0.0,       // CR Amount
    val runningBalance: Double = 0.0,     // Running Account Balance after entry
    val category: String = "Expense",     // Expense, Transfer, Asset, Liability
    val notes: String = ""
)

@Entity(tableName = "net_worth_snapshots")
data class NetWorthSnapshot(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val timestamp: Long = System.currentTimeMillis(),
    val totalAssets: Double,
    val totalLiabilities: Double,
    val netWorth: Double,
    val note: String = "Routine Snapshot"
)
