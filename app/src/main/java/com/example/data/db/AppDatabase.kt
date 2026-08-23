package com.example.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.data.dao.AssetDao
import com.example.data.dao.FinancialItemDao
import com.example.data.dao.LedgerDao
import com.example.data.dao.SnapshotDao
import com.example.data.model.Asset
import com.example.data.model.FinancialItem
import com.example.data.model.LedgerEntry
import com.example.data.model.NetWorthSnapshot
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [FinancialItem::class, NetWorthSnapshot::class, Asset::class, LedgerEntry::class],
    version = 5,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun financialItemDao(): FinancialItemDao
    abstract fun snapshotDao(): SnapshotDao
    abstract fun assetDao(): AssetDao
    abstract fun ledgerDao(): LedgerDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        private val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    """
                    CREATE TABLE IF NOT EXISTS `ledger_entries` (
                        `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                        `timestamp` INTEGER NOT NULL,
                        `transactionTitle` TEXT NOT NULL,
                        `accountName` TEXT NOT NULL,
                        `oppositeAccountName` TEXT NOT NULL,
                        `entryType` TEXT NOT NULL,
                        `debitAmount` REAL NOT NULL,
                        `creditAmount` REAL NOT NULL,
                        `runningBalance` REAL NOT NULL,
                        `category` TEXT NOT NULL,
                        `notes` TEXT NOT NULL
                    )
                    """.trimIndent()
                )
            }
        }

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "networth_vault.db"
                )
                .addMigrations(MIGRATION_4_5)
                .fallbackToDestructiveMigrationOnDowngrade()
                .addCallback(DatabaseCallback())
                .build()
                INSTANCE = instance
                instance
            }
        }

        private class DatabaseCallback : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    CoroutineScope(Dispatchers.IO).launch {
                        seedDefaultData(database.financialItemDao(), database.snapshotDao())
                    }
                }
            }
        }

        private suspend fun seedDefaultData(itemDao: FinancialItemDao, snapshotDao: SnapshotDao) {
            // Pre-seeded sample data removed for clean initial state
        }
    }
}
