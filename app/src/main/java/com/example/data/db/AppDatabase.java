package com.example.data.db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.data.dao.AssetDao;
import com.example.data.dao.FinancialItemDao;
import com.example.data.dao.LedgerDao;
import com.example.data.dao.ReminderDao;
import com.example.data.dao.SnapshotDao;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: AppDatabase.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&¨\u0006\u000f"}, d2 = {"Lcom/example/data/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "financialItemDao", "Lcom/example/data/dao/FinancialItemDao;", "snapshotDao", "Lcom/example/data/dao/SnapshotDao;", "assetDao", "Lcom/example/data/dao/AssetDao;", "ledgerDao", "Lcom/example/data/dao/LedgerDao;", "reminderDao", "Lcom/example/data/dao/ReminderDao;", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase instance;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Migration MIGRATION_4_5 = new Migration(4, 5) {
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS `ledger_entries` (\n    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    `timestamp` INTEGER NOT NULL,\n    `transactionTitle` TEXT NOT NULL,\n    `accountName` TEXT NOT NULL,\n    `oppositeAccountName` TEXT NOT NULL,\n    `entryType` TEXT NOT NULL,\n    `debitAmount` REAL NOT NULL,\n    `creditAmount` REAL NOT NULL,\n    `runningBalance` REAL NOT NULL,\n    `category` TEXT NOT NULL,\n    `notes` TEXT NOT NULL\n)");
        }
    };
    private static final Migration MIGRATION_5_6 = new Migration(5, 6) {
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS `financial_reminders` (\n    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    `title` TEXT NOT NULL,\n    `amount` REAL NOT NULL,\n    `reminderType` TEXT NOT NULL,\n    `dueDateEpochDay` INTEGER NOT NULL,\n    `frequency` TEXT NOT NULL,\n    `owner` TEXT NOT NULL,\n    `associatedAccount` TEXT NOT NULL,\n    `notes` TEXT NOT NULL,\n    `isCompleted` INTEGER NOT NULL,\n    `createdAt` INTEGER NOT NULL\n)");
        }
    };
    private static final Migration MIGRATION_6_7 = new Migration(6, 7) {
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE `financial_reminders` ADD COLUMN `priority` TEXT NOT NULL DEFAULT 'MEDIUM'");
        }
    };
    private static final Migration MIGRATION_7_8 = new Migration(7, 8) {
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS `reminders` (\n    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    `message` TEXT NOT NULL,\n    `dueDate` INTEGER NOT NULL,\n    `priority` TEXT NOT NULL,\n    `isCompleted` INTEGER NOT NULL,\n    `amount` REAL NOT NULL,\n    `category` TEXT NOT NULL\n)");
        }
    };

    public abstract AssetDao assetDao();

    public abstract FinancialItemDao financialItemDao();

    public abstract LedgerDao ledgerDao();

    public abstract ReminderDao reminderDao();

    public abstract SnapshotDao snapshotDao();

    /* compiled from: AppDatabase.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0004\u0007\n\r\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010\u001bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/example/data/db/AppDatabase$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/example/data/db/AppDatabase;", "MIGRATION_4_5", "com/example/data/db/AppDatabase$Companion$MIGRATION_4_5$1", "Lcom/example/data/db/AppDatabase$Companion$MIGRATION_4_5$1;", "MIGRATION_5_6", "com/example/data/db/AppDatabase$Companion$MIGRATION_5_6$1", "Lcom/example/data/db/AppDatabase$Companion$MIGRATION_5_6$1;", "MIGRATION_6_7", "com/example/data/db/AppDatabase$Companion$MIGRATION_6_7$1", "Lcom/example/data/db/AppDatabase$Companion$MIGRATION_6_7$1;", "MIGRATION_7_8", "com/example/data/db/AppDatabase$Companion$MIGRATION_7_8$1", "Lcom/example/data/db/AppDatabase$Companion$MIGRATION_7_8$1;", "getInstance", "context", "Landroid/content/Context;", "seedDefaultData", "", "itemDao", "Lcom/example/data/dao/FinancialItemDao;", "snapshotDao", "Lcom/example/data/dao/SnapshotDao;", "(Lcom/example/data/dao/FinancialItemDao;Lcom/example/data/dao/SnapshotDao;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DatabaseCallback", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AppDatabase getInstance(Context context) {
            AppDatabase appDatabase;
            Intrinsics.checkNotNullParameter(context, "context");
            AppDatabase appDatabase2 = AppDatabase.instance;
            if (appDatabase2 != null) {
                return appDatabase2;
            }
            synchronized (this) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                appDatabase = (AppDatabase) Room.databaseBuilder(applicationContext, AppDatabase.class, "networth_vault.db").addMigrations(AppDatabase.MIGRATION_4_5, AppDatabase.MIGRATION_5_6, AppDatabase.MIGRATION_6_7, AppDatabase.MIGRATION_7_8).fallbackToDestructiveMigrationOnDowngrade().addCallback(new DatabaseCallback()).build();
                AppDatabase.instance = appDatabase;
            }
            return appDatabase;
        }

        /* compiled from: AppDatabase.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/example/data/db/AppDatabase$Companion$DatabaseCallback;", "Landroidx/room/RoomDatabase$Callback;", "<init>", "()V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        private static final class DatabaseCallback extends RoomDatabase.Callback {
            @Override // androidx.room.RoomDatabase.Callback
            public void onCreate(SupportSQLiteDatabase db) {
                Intrinsics.checkNotNullParameter(db, "db");
                super.onCreate(db);
                AppDatabase appDatabase = AppDatabase.instance;
                if (appDatabase != null) {
                    BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AppDatabase$Companion$DatabaseCallback$onCreate$1$1(appDatabase, null), 3, null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object seedDefaultData(FinancialItemDao itemDao, SnapshotDao snapshotDao, Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }
    }
}
