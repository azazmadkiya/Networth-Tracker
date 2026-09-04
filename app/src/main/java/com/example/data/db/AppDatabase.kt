package com.example.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.data.dao.AssetDao
import com.example.data.dao.FinancialItemDao
import com.example.data.dao.LedgerDao
import com.example.data.dao.ReminderDao
import com.example.data.dao.SnapshotDao
import com.example.data.model.Asset
import com.example.data.model.FinancialItem
import com.example.data.model.FinancialReminder
import com.example.data.model.ItemCategory
import com.example.data.model.LedgerEntry
import com.example.data.model.NetWorthSnapshot
import com.example.data.model.OwnerProfile
import com.example.data.model.Reminder
import com.example.data.model.ReminderFrequency
import com.example.data.model.ReminderPriority
import com.example.data.model.ReminderType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [
        FinancialItem::class,
        NetWorthSnapshot::class,
        Asset::class,
        LedgerEntry::class,
        FinancialReminder::class,
        Reminder::class
    ],
    version = 8,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun financialItemDao(): FinancialItemDao
    abstract fun snapshotDao(): SnapshotDao
    abstract fun assetDao(): AssetDao
    abstract fun ledgerDao(): LedgerDao
    abstract fun reminderDao(): ReminderDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "networth_tracker_db"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            CoroutineScope(Dispatchers.IO).launch {
                                populateInitialData(getInstance(context))
                            }
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private suspend fun populateInitialData(db: AppDatabase) {
            val now = System.currentTimeMillis()
            val sampleItems = listOf(
                FinancialItem(
                    title = "HDFC Salary Account",
                    institution = "HDFC Bank",
                    accountNumber = "•••• 4829",
                    owner = OwnerProfile.SELF.displayName,
                    category = ItemCategory.BANK_ACCOUNT.displayName,
                    currentValue = 185000.0,
                    investedValue = 185000.0,
                    isLiability = false,
                    notes = "Primary salary & operational account",
                    updatedAt = now
                ),
                FinancialItem(
                    title = "SBI Savings Account",
                    institution = "State Bank of India",
                    accountNumber = "•••• 9102",
                    owner = OwnerProfile.FATHER.displayName,
                    category = ItemCategory.BANK_ACCOUNT.displayName,
                    currentValue = 340000.0,
                    investedValue = 340000.0,
                    isLiability = false,
                    notes = "Father pension & emergency fund",
                    updatedAt = now
                ),
                FinancialItem(
                    title = "Reliance Industries Shares",
                    institution = "Zerodha",
                    accountNumber = "RELIANCE (50 qty)",
                    owner = OwnerProfile.SELF.displayName,
                    category = ItemCategory.SHARE_MARKET.displayName,
                    currentValue = 149025.0,
                    investedValue = 125000.0,
                    isLiability = false,
                    notes = "Bluechip long term holding",
                    updatedAt = now
                ),
                FinancialItem(
                    title = "Tata Motors Long Term",
                    institution = "Groww",
                    accountNumber = "TATAMOTORS (100 qty)",
                    owner = OwnerProfile.SELF.displayName,
                    category = ItemCategory.SHARE_MARKET.displayName,
                    currentValue = 103500.0,
                    investedValue = 82000.0,
                    isLiability = false,
                    notes = "EV growth momentum",
                    updatedAt = now
                ),
                FinancialItem(
                    title = "Parag Parikh Flexi Cap Fund",
                    institution = "Groww",
                    accountNumber = "SIP Folio 88392",
                    owner = OwnerProfile.SELF.displayName,
                    category = ItemCategory.MUTUAL_FUNDS.displayName,
                    currentValue = 285000.0,
                    investedValue = 210000.0,
                    isLiability = false,
                    notes = "Monthly SIP of 10,000",
                    updatedAt = now
                ),
                FinancialItem(
                    title = "Physical Gold Ornaments",
                    institution = "Locker Safe",
                    accountNumber = "50 grams (916)",
                    owner = OwnerProfile.MOTHER.displayName,
                    category = ItemCategory.GOLD_SILVER.displayName,
                    currentValue = 365000.0,
                    investedValue = 240000.0,
                    isLiability = false,
                    notes = "Family heirloom jewelry",
                    updatedAt = now
                ),
                FinancialItem(
                    title = "Residential Flat (Down Payment)",
                    institution = "Registry Office",
                    accountNumber = "Plot 104, Green Meadows",
                    owner = OwnerProfile.FAMILY.displayName,
                    category = ItemCategory.REAL_ESTATE.displayName,
                    currentValue = 1500000.0,
                    investedValue = 1200000.0,
                    isLiability = false,
                    notes = "Appreciating residential property asset",
                    updatedAt = now
                ),
                FinancialItem(
                    title = "Car Loan (Hyundai Creta)",
                    institution = "ICICI Bank",
                    accountNumber = "LOAN-ICICI-882",
                    owner = OwnerProfile.SELF.displayName,
                    category = ItemCategory.LOAN_LIABILITY.displayName,
                    currentValue = 420000.0,
                    investedValue = 420000.0,
                    isLiability = true,
                    notes = "EMI 14,200/mo remaining 30 months",
                    updatedAt = now
                )
            )
            db.financialItemDao().insertItems(sampleItems)

            val sampleReminders = listOf(
                FinancialReminder(
                    title = "Parag Parikh Mutual Fund SIP",
                    amount = 10000.0,
                    reminderType = ReminderType.SIP_INVESTMENT.name,
                    priority = ReminderPriority.HIGH.name,
                    dueDateEpochDay = (now / 86400000L) + 5,
                    frequency = ReminderFrequency.MONTHLY.name,
                    owner = OwnerProfile.SELF.displayName,
                    associatedAccount = "HDFC Salary Account",
                    notes = "Auto-debit from HDFC",
                    isCompleted = false,
                    createdAt = now
                ),
                FinancialReminder(
                    title = "Electricity & Utility Bill",
                    amount = 2850.0,
                    reminderType = ReminderType.DUE_DATE.name,
                    priority = ReminderPriority.MEDIUM.name,
                    dueDateEpochDay = (now / 86400000L) + 2,
                    frequency = ReminderFrequency.MONTHLY.name,
                    owner = OwnerProfile.SELF.displayName,
                    associatedAccount = "HDFC Salary Account",
                    notes = "Pay before 10th to avoid late fees",
                    isCompleted = false,
                    createdAt = now
                ),
                FinancialReminder(
                    title = "Hyundai Car Loan EMI",
                    amount = 14200.0,
                    reminderType = ReminderType.LOAN_EMI.name,
                    priority = ReminderPriority.HIGH.name,
                    dueDateEpochDay = (now / 86400000L) + 12,
                    frequency = ReminderFrequency.MONTHLY.name,
                    owner = OwnerProfile.SELF.displayName,
                    associatedAccount = "HDFC Salary Account",
                    notes = "Mandatory EMI payment",
                    isCompleted = false,
                    createdAt = now
                )
            )
            db.reminderDao().insertReminders(sampleReminders)

            val sampleLedger = listOf(
                LedgerEntry(
                    timestamp = now - 86400000L * 2,
                    transactionTitle = "Monthly Salary Credited",
                    accountName = "HDFC Salary Account",
                    oppositeAccountName = "Company Payroll",
                    entryType = "CREDIT",
                    debitAmount = 0.0,
                    creditAmount = 95000.0,
                    runningBalance = 185000.0,
                    category = ItemCategory.INCOME.displayName,
                    notes = "Monthly tech compensation"
                ),
                LedgerEntry(
                    timestamp = now - 86400000L * 1,
                    transactionTitle = "SIP Investment Debited",
                    accountName = "HDFC Salary Account",
                    oppositeAccountName = "Parag Parikh Flexi Cap",
                    entryType = "DEBIT",
                    debitAmount = 10000.0,
                    creditAmount = 0.0,
                    runningBalance = 175000.0,
                    category = ItemCategory.MUTUAL_FUNDS.displayName,
                    notes = "Automated wealth accumulation"
                )
            )
            db.ledgerDao().insertLedgerEntries(sampleLedger)

            val initialSnapshot = NetWorthSnapshot(
                timestamp = now,
                totalAssets = 2927525.0,
                totalLiabilities = 420000.0,
                netWorth = 2507525.0,
                note = "Initial Portfolio Setup Baseline"
            )
            db.snapshotDao().insertSnapshot(initialSnapshot)
        }
    }
}
