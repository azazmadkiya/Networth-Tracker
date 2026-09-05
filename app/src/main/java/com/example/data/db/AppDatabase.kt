package com.example.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.dao.AssetDao
import com.example.data.dao.FinancialItemDao
import com.example.data.dao.LedgerDao
import com.example.data.dao.ReminderDao
import com.example.data.dao.SnapshotDao
import com.example.data.model.Asset
import com.example.data.model.FinancialItem
import com.example.data.model.FinancialReminder
import com.example.data.model.LedgerEntry
import com.example.data.model.NetWorthSnapshot
import com.example.data.model.Reminder

@Database(
    entities = [
        FinancialItem::class,
        NetWorthSnapshot::class,
        Asset::class,
        LedgerEntry::class,
        FinancialReminder::class,
        Reminder::class
    ],
    version = 9,
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
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
