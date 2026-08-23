package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.model.FinancialItem
import com.example.data.model.LedgerEntry
import com.example.data.model.NetWorthSnapshot
import kotlinx.coroutines.flow.Flow

@Dao
interface FinancialItemDao {
    @Query("SELECT * FROM financial_items ORDER BY currentValue DESC")
    fun getAllItems(): Flow<List<FinancialItem>>

    @Query("SELECT * FROM financial_items WHERE owner = :owner ORDER BY currentValue DESC")
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
}

@Dao
interface SnapshotDao {
    @Query("SELECT * FROM net_worth_snapshots ORDER BY timestamp ASC")
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
    @Query("SELECT * FROM ledger_entries ORDER BY timestamp DESC, id DESC")
    fun getAllLedgerEntries(): Flow<List<LedgerEntry>>

    @Query("SELECT * FROM ledger_entries WHERE accountName = :accountName OR oppositeAccountName = :accountName ORDER BY timestamp DESC, id DESC")
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
