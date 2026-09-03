package com.example.data.db;

import androidx.room.InvalidationTracker;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.example.data.dao.AssetDao;
import com.example.data.dao.AssetDao_Impl;
import com.example.data.dao.FinancialItemDao;
import com.example.data.dao.FinancialItemDao_Impl;
import com.example.data.dao.LedgerDao;
import com.example.data.dao.LedgerDao_Impl;
import com.example.data.dao.ReminderDao;
import com.example.data.dao.ReminderDao_Impl;
import com.example.data.dao.SnapshotDao;
import com.example.data.dao.SnapshotDao_Impl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: AppDatabase_Impl.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u0015\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u00180\u0016H\u0014J\u0016\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u00170\u001aH\u0016J*\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00182\u001a\u0010\u001e\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u0017\u0012\u0004\u0012\u00020\u001b0\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/example/data/db/AppDatabase_Impl;", "Lcom/example/data/db/AppDatabase;", "<init>", "()V", "_financialItemDao", "Lkotlin/Lazy;", "Lcom/example/data/dao/FinancialItemDao;", "_snapshotDao", "Lcom/example/data/dao/SnapshotDao;", "_assetDao", "Lcom/example/data/dao/AssetDao;", "_ledgerDao", "Lcom/example/data/dao/LedgerDao;", "_reminderDao", "Lcom/example/data/dao/ReminderDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", "", "getRequiredTypeConverterClasses", "", "Lkotlin/reflect/KClass;", "", "getRequiredAutoMigrationSpecClasses", "", "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "financialItemDao", "snapshotDao", "assetDao", "ledgerDao", "reminderDao", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AppDatabase_Impl extends AppDatabase {
    public static final int $stable = 8;
    private final Lazy<FinancialItemDao> _financialItemDao = LazyKt.lazy(new Function0() { // from class: com.example.data.db.AppDatabase_Impl$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AppDatabase_Impl._financialItemDao$lambda$0(AppDatabase_Impl.this);
        }
    });
    private final Lazy<SnapshotDao> _snapshotDao = LazyKt.lazy(new Function0() { // from class: com.example.data.db.AppDatabase_Impl$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AppDatabase_Impl._snapshotDao$lambda$1(AppDatabase_Impl.this);
        }
    });
    private final Lazy<AssetDao> _assetDao = LazyKt.lazy(new Function0() { // from class: com.example.data.db.AppDatabase_Impl$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AppDatabase_Impl._assetDao$lambda$2(AppDatabase_Impl.this);
        }
    });
    private final Lazy<LedgerDao> _ledgerDao = LazyKt.lazy(new Function0() { // from class: com.example.data.db.AppDatabase_Impl$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AppDatabase_Impl._ledgerDao$lambda$3(AppDatabase_Impl.this);
        }
    });
    private final Lazy<ReminderDao> _reminderDao = LazyKt.lazy(new Function0() { // from class: com.example.data.db.AppDatabase_Impl$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AppDatabase_Impl._reminderDao$lambda$4(AppDatabase_Impl.this);
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final FinancialItemDao_Impl _financialItemDao$lambda$0(AppDatabase_Impl this$0) {
        return new FinancialItemDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final SnapshotDao_Impl _snapshotDao$lambda$1(AppDatabase_Impl this$0) {
        return new SnapshotDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final AssetDao_Impl _assetDao$lambda$2(AppDatabase_Impl this$0) {
        return new AssetDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LedgerDao_Impl _ledgerDao$lambda$3(AppDatabase_Impl this$0) {
        return new LedgerDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ReminderDao_Impl _reminderDao$lambda$4(AppDatabase_Impl this$0) {
        return new ReminderDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    public RoomOpenDelegate createOpenDelegate() {
        RoomOpenDelegate _openDelegate = new RoomOpenDelegate() { // from class: com.example.data.db.AppDatabase_Impl$createOpenDelegate$_openDelegate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(8, "9888cfcf247c0488c5d8d23a97cc1a09", "e2812d710efbd56e2c28a2726106cb42");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void createAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `financial_items` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `institution` TEXT NOT NULL, `accountNumber` TEXT NOT NULL, `owner` TEXT NOT NULL, `category` TEXT NOT NULL, `currentValue` REAL NOT NULL, `investedValue` REAL NOT NULL, `isLiability` INTEGER NOT NULL, `notes` TEXT NOT NULL, `sourceAccountTitle` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `net_worth_snapshots` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `totalAssets` REAL NOT NULL, `totalLiabilities` REAL NOT NULL, `netWorth` REAL NOT NULL, `note` TEXT NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `assets` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `type` TEXT NOT NULL, `category` TEXT NOT NULL, `value` REAL NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `ledger_entries` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `transactionTitle` TEXT NOT NULL, `accountName` TEXT NOT NULL, `oppositeAccountName` TEXT NOT NULL, `entryType` TEXT NOT NULL, `debitAmount` REAL NOT NULL, `creditAmount` REAL NOT NULL, `runningBalance` REAL NOT NULL, `category` TEXT NOT NULL, `notes` TEXT NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `financial_reminders` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `amount` REAL NOT NULL, `reminderType` TEXT NOT NULL, `priority` TEXT NOT NULL, `dueDateEpochDay` INTEGER NOT NULL, `frequency` TEXT NOT NULL, `owner` TEXT NOT NULL, `associatedAccount` TEXT NOT NULL, `notes` TEXT NOT NULL, `isCompleted` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `reminders` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `message` TEXT NOT NULL, `dueDate` INTEGER NOT NULL, `priority` TEXT NOT NULL, `isCompleted` INTEGER NOT NULL, `amount` REAL NOT NULL, `category` TEXT NOT NULL)");
                SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9888cfcf247c0488c5d8d23a97cc1a09')");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void dropAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `financial_items`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `net_worth_snapshots`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `assets`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `ledger_entries`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `financial_reminders`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `reminders`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onCreate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onOpen(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                AppDatabase_Impl.this.internalInitInvalidationTracker(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onPreMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                DBUtil.dropFtsSyncTriggers(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onPostMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                Map _columnsFinancialItems = new LinkedHashMap();
                _columnsFinancialItems.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                _columnsFinancialItems.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                _columnsFinancialItems.put("institution", new TableInfo.Column("institution", "TEXT", true, 0, null, 1));
                _columnsFinancialItems.put("accountNumber", new TableInfo.Column("accountNumber", "TEXT", true, 0, null, 1));
                _columnsFinancialItems.put("owner", new TableInfo.Column("owner", "TEXT", true, 0, null, 1));
                _columnsFinancialItems.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, 1));
                _columnsFinancialItems.put("currentValue", new TableInfo.Column("currentValue", "REAL", true, 0, null, 1));
                _columnsFinancialItems.put("investedValue", new TableInfo.Column("investedValue", "REAL", true, 0, null, 1));
                _columnsFinancialItems.put("isLiability", new TableInfo.Column("isLiability", "INTEGER", true, 0, null, 1));
                _columnsFinancialItems.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, null, 1));
                _columnsFinancialItems.put("sourceAccountTitle", new TableInfo.Column("sourceAccountTitle", "TEXT", true, 0, null, 1));
                _columnsFinancialItems.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, 1));
                Set _foreignKeysFinancialItems = new LinkedHashSet();
                Set _indicesFinancialItems = new LinkedHashSet();
                TableInfo _infoFinancialItems = new TableInfo("financial_items", _columnsFinancialItems, _foreignKeysFinancialItems, _indicesFinancialItems);
                TableInfo _existingFinancialItems = TableInfo.INSTANCE.read(connection, "financial_items");
                if (!_infoFinancialItems.equals(_existingFinancialItems)) {
                    return new RoomOpenDelegate.ValidationResult(false, "financial_items(com.example.data.model.FinancialItem).\n Expected:\n" + _infoFinancialItems + "\n Found:\n" + _existingFinancialItems);
                }
                Map _columnsNetWorthSnapshots = new LinkedHashMap();
                _columnsNetWorthSnapshots.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                _columnsNetWorthSnapshots.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                _columnsNetWorthSnapshots.put("totalAssets", new TableInfo.Column("totalAssets", "REAL", true, 0, null, 1));
                _columnsNetWorthSnapshots.put("totalLiabilities", new TableInfo.Column("totalLiabilities", "REAL", true, 0, null, 1));
                _columnsNetWorthSnapshots.put("netWorth", new TableInfo.Column("netWorth", "REAL", true, 0, null, 1));
                _columnsNetWorthSnapshots.put("note", new TableInfo.Column("note", "TEXT", true, 0, null, 1));
                Set _foreignKeysNetWorthSnapshots = new LinkedHashSet();
                Set _indicesNetWorthSnapshots = new LinkedHashSet();
                TableInfo _infoNetWorthSnapshots = new TableInfo("net_worth_snapshots", _columnsNetWorthSnapshots, _foreignKeysNetWorthSnapshots, _indicesNetWorthSnapshots);
                TableInfo _existingNetWorthSnapshots = TableInfo.INSTANCE.read(connection, "net_worth_snapshots");
                if (!_infoNetWorthSnapshots.equals(_existingNetWorthSnapshots)) {
                    return new RoomOpenDelegate.ValidationResult(false, "net_worth_snapshots(com.example.data.model.NetWorthSnapshot).\n Expected:\n" + _infoNetWorthSnapshots + "\n Found:\n" + _existingNetWorthSnapshots);
                }
                Map _columnsAssets = new LinkedHashMap();
                _columnsAssets.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                _columnsAssets.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                _columnsAssets.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
                _columnsAssets.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, 1));
                _columnsAssets.put("value", new TableInfo.Column("value", "REAL", true, 0, null, 1));
                Set _foreignKeysAssets = new LinkedHashSet();
                Set _indicesAssets = new LinkedHashSet();
                TableInfo _infoAssets = new TableInfo("assets", _columnsAssets, _foreignKeysAssets, _indicesAssets);
                TableInfo _existingAssets = TableInfo.INSTANCE.read(connection, "assets");
                if (!_infoAssets.equals(_existingAssets)) {
                    return new RoomOpenDelegate.ValidationResult(false, "assets(com.example.data.model.Asset).\n Expected:\n" + _infoAssets + "\n Found:\n" + _existingAssets);
                }
                Map _columnsLedgerEntries = new LinkedHashMap();
                _columnsLedgerEntries.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                _columnsLedgerEntries.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                _columnsLedgerEntries.put("transactionTitle", new TableInfo.Column("transactionTitle", "TEXT", true, 0, null, 1));
                _columnsLedgerEntries.put("accountName", new TableInfo.Column("accountName", "TEXT", true, 0, null, 1));
                _columnsLedgerEntries.put("oppositeAccountName", new TableInfo.Column("oppositeAccountName", "TEXT", true, 0, null, 1));
                _columnsLedgerEntries.put("entryType", new TableInfo.Column("entryType", "TEXT", true, 0, null, 1));
                _columnsLedgerEntries.put("debitAmount", new TableInfo.Column("debitAmount", "REAL", true, 0, null, 1));
                _columnsLedgerEntries.put("creditAmount", new TableInfo.Column("creditAmount", "REAL", true, 0, null, 1));
                _columnsLedgerEntries.put("runningBalance", new TableInfo.Column("runningBalance", "REAL", true, 0, null, 1));
                _columnsLedgerEntries.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, 1));
                _columnsLedgerEntries.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, null, 1));
                Set _foreignKeysLedgerEntries = new LinkedHashSet();
                Set _indicesLedgerEntries = new LinkedHashSet();
                TableInfo _infoLedgerEntries = new TableInfo("ledger_entries", _columnsLedgerEntries, _foreignKeysLedgerEntries, _indicesLedgerEntries);
                TableInfo _existingLedgerEntries = TableInfo.INSTANCE.read(connection, "ledger_entries");
                if (!_infoLedgerEntries.equals(_existingLedgerEntries)) {
                    return new RoomOpenDelegate.ValidationResult(false, "ledger_entries(com.example.data.model.LedgerEntry).\n Expected:\n" + _infoLedgerEntries + "\n Found:\n" + _existingLedgerEntries);
                }
                Map _columnsFinancialReminders = new LinkedHashMap();
                _columnsFinancialReminders.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                _columnsFinancialReminders.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                _columnsFinancialReminders.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, 1));
                _columnsFinancialReminders.put("reminderType", new TableInfo.Column("reminderType", "TEXT", true, 0, null, 1));
                _columnsFinancialReminders.put("priority", new TableInfo.Column("priority", "TEXT", true, 0, null, 1));
                _columnsFinancialReminders.put("dueDateEpochDay", new TableInfo.Column("dueDateEpochDay", "INTEGER", true, 0, null, 1));
                _columnsFinancialReminders.put("frequency", new TableInfo.Column("frequency", "TEXT", true, 0, null, 1));
                _columnsFinancialReminders.put("owner", new TableInfo.Column("owner", "TEXT", true, 0, null, 1));
                _columnsFinancialReminders.put("associatedAccount", new TableInfo.Column("associatedAccount", "TEXT", true, 0, null, 1));
                _columnsFinancialReminders.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, null, 1));
                _columnsFinancialReminders.put("isCompleted", new TableInfo.Column("isCompleted", "INTEGER", true, 0, null, 1));
                _columnsFinancialReminders.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, 1));
                Set _foreignKeysFinancialReminders = new LinkedHashSet();
                Set _indicesFinancialReminders = new LinkedHashSet();
                TableInfo _infoFinancialReminders = new TableInfo("financial_reminders", _columnsFinancialReminders, _foreignKeysFinancialReminders, _indicesFinancialReminders);
                TableInfo _existingFinancialReminders = TableInfo.INSTANCE.read(connection, "financial_reminders");
                if (!_infoFinancialReminders.equals(_existingFinancialReminders)) {
                    return new RoomOpenDelegate.ValidationResult(false, "financial_reminders(com.example.data.model.FinancialReminder).\n Expected:\n" + _infoFinancialReminders + "\n Found:\n" + _existingFinancialReminders);
                }
                Map _columnsReminders = new LinkedHashMap();
                _columnsReminders.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                _columnsReminders.put("message", new TableInfo.Column("message", "TEXT", true, 0, null, 1));
                _columnsReminders.put("dueDate", new TableInfo.Column("dueDate", "INTEGER", true, 0, null, 1));
                _columnsReminders.put("priority", new TableInfo.Column("priority", "TEXT", true, 0, null, 1));
                _columnsReminders.put("isCompleted", new TableInfo.Column("isCompleted", "INTEGER", true, 0, null, 1));
                _columnsReminders.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, 1));
                _columnsReminders.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, 1));
                Set _foreignKeysReminders = new LinkedHashSet();
                Set _indicesReminders = new LinkedHashSet();
                TableInfo _infoReminders = new TableInfo("reminders", _columnsReminders, _foreignKeysReminders, _indicesReminders);
                TableInfo _existingReminders = TableInfo.INSTANCE.read(connection, "reminders");
                if (!_infoReminders.equals(_existingReminders)) {
                    return new RoomOpenDelegate.ValidationResult(false, "reminders(com.example.data.model.Reminder).\n Expected:\n" + _infoReminders + "\n Found:\n" + _existingReminders);
                }
                return new RoomOpenDelegate.ValidationResult(true, null);
            }
        };
        return _openDelegate;
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        Map _shadowTablesMap = new LinkedHashMap();
        Map _viewTables = new LinkedHashMap();
        return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "financial_items", "net_worth_snapshots", "assets", "ledger_entries", "financial_reminders", "reminders");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(false, "financial_items", "net_worth_snapshots", "assets", "ledger_entries", "financial_reminders", "reminders");
    }

    @Override // androidx.room.RoomDatabase
    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        Map _typeConvertersMap = new LinkedHashMap();
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(FinancialItemDao.class), FinancialItemDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(SnapshotDao.class), SnapshotDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(AssetDao.class), AssetDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(LedgerDao.class), LedgerDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(ReminderDao.class), ReminderDao_Impl.INSTANCE.getRequiredConverters());
        return _typeConvertersMap;
    }

    @Override // androidx.room.RoomDatabase
    public Set<KClass<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecClasses() {
        Set _autoMigrationSpecsSet = new LinkedHashSet();
        return _autoMigrationSpecsSet;
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> createAutoMigrations(Map<KClass<? extends AutoMigrationSpec>, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        List _autoMigrations = new ArrayList();
        return _autoMigrations;
    }

    @Override // com.example.data.db.AppDatabase
    public FinancialItemDao financialItemDao() {
        return this._financialItemDao.getValue();
    }

    @Override // com.example.data.db.AppDatabase
    public SnapshotDao snapshotDao() {
        return this._snapshotDao.getValue();
    }

    @Override // com.example.data.db.AppDatabase
    public AssetDao assetDao() {
        return this._assetDao.getValue();
    }

    @Override // com.example.data.db.AppDatabase
    public LedgerDao ledgerDao() {
        return this._ledgerDao.getValue();
    }

    @Override // com.example.data.db.AppDatabase
    public ReminderDao reminderDao() {
        return this._reminderDao.getValue();
    }
}
