package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.model.Asset
import com.example.data.model.FinancialItem
import com.example.data.model.FinancialReminder
import com.example.data.model.LedgerEntry
import com.example.data.model.NetWorthSnapshot
import com.example.data.model.Reminder
import kotlinx.coroutines.flow.Flow

@Dao
interface FinancialItemDao {
    @Query("SELECT * FROM financial_items ORDER BY id DESC")
    fun getAllItems(): Flow<List<FinancialItem>>

    @Query("SELECT * FROM financial_items WHERE owner = :owner ORDER BY id DESC")
    fun getItemsByOwner(owner: String): Flow<List<FinancialItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: FinancialItem): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<FinancialItem>)

    @Update
    suspend fun updateItem(item: FinancialItem)

    @Delete
    suspend fun deleteItem(item: FinancialItem)

    @Query("DELETE FROM financial_items WHERE id = :id")
    suspend fun deleteItemById(id: Long)

    @Query("DELETE FROM financial_items")
    suspend fun deleteAllItems()

    @Query("SELECT COUNT(*) FROM financial_items")
    suspend fun getItemCount(): Int

    @Query("SELECT * FROM financial_items")
    suspend fun getAllItemsList(): List<FinancialItem>
}

@Dao
interface SnapshotDao {
    @Query("SELECT * FROM net_worth_snapshots ORDER BY timestamp DESC")
    fun getAllSnapshots(): Flow<List<NetWorthSnapshot>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSnapshot(snapshot: NetWorthSnapshot): Long

    @Delete
    suspend fun deleteSnapshot(snapshot: NetWorthSnapshot)

    @Query("DELETE FROM net_worth_snapshots")
    suspend fun deleteAllSnapshots()
}

@Dao
interface LedgerDao {
    @Query("SELECT * FROM ledger_entries ORDER BY timestamp DESC")
    fun getAllLedgerEntries(): Flow<List<LedgerEntry>>

    @Query("SELECT * FROM ledger_entries WHERE accountName = :accountName OR oppositeAccountName = :accountName ORDER BY timestamp DESC")
    fun getLedgerEntriesForAccount(accountName: String): Flow<List<LedgerEntry>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLedgerEntry(entry: LedgerEntry): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLedgerEntries(entries: List<LedgerEntry>)

    @Delete
    suspend fun deleteLedgerEntry(entry: LedgerEntry)

    @Query("DELETE FROM ledger_entries")
    suspend fun deleteAllLedgerEntries()
}

@Dao
interface ReminderDao {
    @Query("SELECT * FROM financial_reminders ORDER BY dueDateEpochDay ASC, createdAt DESC")
    fun getAllReminders(): Flow<List<FinancialReminder>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminder(reminder: FinancialReminder): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminders(reminders: List<FinancialReminder>)

    @Update
    suspend fun updateReminder(reminder: FinancialReminder)

    @Delete
    suspend fun deleteReminder(reminder: FinancialReminder)

    @Query("DELETE FROM financial_reminders WHERE id = :id")
    suspend fun deleteReminderById(id: Long)

    @Query("UPDATE financial_reminders SET isCompleted = :completed WHERE id = :id")
    suspend fun updateCompletionStatus(id: Long, completed: Boolean)

    @Query("DELETE FROM financial_reminders")
    suspend fun deleteAllReminders()

    @Query("SELECT * FROM reminders ORDER BY dueDate ASC")
    fun getAllSimpleReminders(): Flow<List<Reminder>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSimpleReminder(reminder: Reminder): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSimpleReminders(reminders: List<Reminder>)

    @Update
    suspend fun updateSimpleReminder(reminder: Reminder)

    @Delete
    suspend fun deleteSimpleReminder(reminder: Reminder)

    @Query("DELETE FROM reminders WHERE id = :id")
    suspend fun deleteSimpleReminderById(id: Long)

    @Query("UPDATE reminders SET isCompleted = :completed WHERE id = :id")
    suspend fun updateSimpleReminderCompletionStatus(id: Long, completed: Boolean)

    @Query("DELETE FROM reminders")
    suspend fun deleteAllSimpleReminders()
}

@Dao
interface AssetDao {
    @Query("SELECT * FROM assets ORDER BY id DESC")
    fun getAllAssets(): Flow<List<Asset>>

    @Query("SELECT * FROM assets WHERE category = :category ORDER BY id DESC")
    fun getAssetsByCategory(category: String): Flow<List<Asset>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAsset(asset: Asset): Long

    @Update
    suspend fun updateAsset(asset: Asset)

    @Delete
    suspend fun deleteAsset(asset: Asset)
}
