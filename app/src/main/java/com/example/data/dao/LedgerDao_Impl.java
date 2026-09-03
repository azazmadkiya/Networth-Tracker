package com.example.data.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.example.data.model.LedgerEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;

/* compiled from: LedgerDao_Impl.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u0016H\u0016J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/example/data/dao/LedgerDao_Impl;", "Lcom/example/data/dao/LedgerDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfLedgerEntry", "Landroidx/room/EntityInsertAdapter;", "Lcom/example/data/model/LedgerEntry;", "__deleteAdapterOfLedgerEntry", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "insertLedgerEntry", "", "entry", "(Lcom/example/data/model/LedgerEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLedgerEntries", "", "entries", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLedgerEntry", "getAllLedgerEntries", "Lkotlinx/coroutines/flow/Flow;", "getLedgerEntriesForAccount", "accountName", "", "deleteAllLedgerEntries", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LedgerDao_Impl implements LedgerDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<LedgerEntry> __deleteAdapterOfLedgerEntry;
    private final EntityInsertAdapter<LedgerEntry> __insertAdapterOfLedgerEntry;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public LedgerDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfLedgerEntry = new EntityInsertAdapter<LedgerEntry>() { // from class: com.example.data.dao.LedgerDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ledger_entries` (`id`,`timestamp`,`transactionTitle`,`accountName`,`oppositeAccountName`,`entryType`,`debitAmount`,`creditAmount`,`runningBalance`,`category`,`notes`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, LedgerEntry entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
                statement.mo6930bindLong(2, entity.getTimestamp());
                statement.mo6932bindText(3, entity.getTransactionTitle());
                statement.mo6932bindText(4, entity.getAccountName());
                statement.mo6932bindText(5, entity.getOppositeAccountName());
                statement.mo6932bindText(6, entity.getEntryType());
                statement.mo6929bindDouble(7, entity.getDebitAmount());
                statement.mo6929bindDouble(8, entity.getCreditAmount());
                statement.mo6929bindDouble(9, entity.getRunningBalance());
                statement.mo6932bindText(10, entity.getCategory());
                statement.mo6932bindText(11, entity.getNotes());
            }
        };
        this.__deleteAdapterOfLedgerEntry = new EntityDeleteOrUpdateAdapter<LedgerEntry>() { // from class: com.example.data.dao.LedgerDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `ledger_entries` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, LedgerEntry entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
            }
        };
    }

    @Override // com.example.data.dao.LedgerDao
    public Object insertLedgerEntry(final LedgerEntry entry, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.LedgerDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(LedgerDao_Impl.insertLedgerEntry$lambda$0(LedgerDao_Impl.this, entry, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final long insertLedgerEntry$lambda$0(LedgerDao_Impl this$0, LedgerEntry $entry, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        long _result = this$0.__insertAdapterOfLedgerEntry.insertAndReturnId(_connection, $entry);
        return _result;
    }

    @Override // com.example.data.dao.LedgerDao
    public Object insertLedgerEntries(final List<LedgerEntry> list, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.LedgerDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LedgerDao_Impl.insertLedgerEntries$lambda$1(LedgerDao_Impl.this, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit insertLedgerEntries$lambda$1(LedgerDao_Impl this$0, List $entries, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__insertAdapterOfLedgerEntry.insert(_connection, $entries);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.dao.LedgerDao
    public Object deleteLedgerEntry(final LedgerEntry entry, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.LedgerDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LedgerDao_Impl.deleteLedgerEntry$lambda$2(LedgerDao_Impl.this, entry, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteLedgerEntry$lambda$2(LedgerDao_Impl this$0, LedgerEntry $entry, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__deleteAdapterOfLedgerEntry.handle(_connection, $entry);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.dao.LedgerDao
    public Flow<List<LedgerEntry>> getAllLedgerEntries() {
        final String _sql = "SELECT * FROM ledger_entries ORDER BY timestamp DESC, id DESC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"ledger_entries"}, new Function1() { // from class: com.example.data.dao.LedgerDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LedgerDao_Impl.getAllLedgerEntries$lambda$3(_sql, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getAllLedgerEntries$lambda$3(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
            int _columnIndexOfTransactionTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "transactionTitle");
            int _columnIndexOfAccountName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "accountName");
            int _columnIndexOfOppositeAccountName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "oppositeAccountName");
            int _columnIndexOfEntryType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "entryType");
            int _columnIndexOfDebitAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "debitAmount");
            int _columnIndexOfCreditAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "creditAmount");
            int _columnIndexOfRunningBalance = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "runningBalance");
            int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
            int _columnIndexOfNotes = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "notes");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_columnIndexOfId);
                long _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
                String _tmpTransactionTitle = _stmt.getText(_columnIndexOfTransactionTitle);
                String _tmpAccountName = _stmt.getText(_columnIndexOfAccountName);
                String _tmpOppositeAccountName = _stmt.getText(_columnIndexOfOppositeAccountName);
                String _tmpEntryType = _stmt.getText(_columnIndexOfEntryType);
                double _tmpDebitAmount = _stmt.getDouble(_columnIndexOfDebitAmount);
                double _tmpCreditAmount = _stmt.getDouble(_columnIndexOfCreditAmount);
                double _tmpRunningBalance = _stmt.getDouble(_columnIndexOfRunningBalance);
                String _tmpCategory = _stmt.getText(_columnIndexOfCategory);
                String _tmpNotes = _stmt.getText(_columnIndexOfNotes);
                LedgerEntry _item = new LedgerEntry(_tmpId, _tmpTimestamp, _tmpTransactionTitle, _tmpAccountName, _tmpOppositeAccountName, _tmpEntryType, _tmpDebitAmount, _tmpCreditAmount, _tmpRunningBalance, _tmpCategory, _tmpNotes);
                _result.add(_item);
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.dao.LedgerDao
    public Flow<List<LedgerEntry>> getLedgerEntriesForAccount(final String accountName) {
        Intrinsics.checkNotNullParameter(accountName, "accountName");
        final String _sql = "SELECT * FROM ledger_entries WHERE accountName = ? OR oppositeAccountName = ? ORDER BY timestamp DESC, id DESC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"ledger_entries"}, new Function1() { // from class: com.example.data.dao.LedgerDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LedgerDao_Impl.getLedgerEntriesForAccount$lambda$4(_sql, accountName, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getLedgerEntriesForAccount$lambda$4(String $_sql, String $accountName, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.mo6932bindText(1, $accountName);
            int _argIndex = 2;
            _stmt.mo6932bindText(2, $accountName);
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
            int _columnIndexOfTransactionTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "transactionTitle");
            int _columnIndexOfAccountName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "accountName");
            int _columnIndexOfOppositeAccountName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "oppositeAccountName");
            int _columnIndexOfEntryType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "entryType");
            int _columnIndexOfDebitAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "debitAmount");
            int _columnIndexOfCreditAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "creditAmount");
            int _columnIndexOfRunningBalance = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "runningBalance");
            int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
            int _columnIndexOfNotes = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "notes");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_columnIndexOfId);
                long _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
                String _tmpTransactionTitle = _stmt.getText(_columnIndexOfTransactionTitle);
                String _tmpAccountName = _stmt.getText(_columnIndexOfAccountName);
                String _tmpOppositeAccountName = _stmt.getText(_columnIndexOfOppositeAccountName);
                String _tmpEntryType = _stmt.getText(_columnIndexOfEntryType);
                double _tmpDebitAmount = _stmt.getDouble(_columnIndexOfDebitAmount);
                double _tmpCreditAmount = _stmt.getDouble(_columnIndexOfCreditAmount);
                double _tmpRunningBalance = _stmt.getDouble(_columnIndexOfRunningBalance);
                String _tmpCategory = _stmt.getText(_columnIndexOfCategory);
                String _tmpNotes = _stmt.getText(_columnIndexOfNotes);
                LedgerEntry _item = new LedgerEntry(_tmpId, _tmpTimestamp, _tmpTransactionTitle, _tmpAccountName, _tmpOppositeAccountName, _tmpEntryType, _tmpDebitAmount, _tmpCreditAmount, _tmpRunningBalance, _tmpCategory, _tmpNotes);
                int _argIndex2 = _argIndex;
                List _result2 = _result;
                _result2.add(_item);
                _result = _result2;
                _argIndex = _argIndex2;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.dao.LedgerDao
    public Object deleteAllLedgerEntries(Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM ledger_entries";
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.LedgerDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LedgerDao_Impl.deleteAllLedgerEntries$lambda$5(_sql, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteAllLedgerEntries$lambda$5(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.step();
            _stmt.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    /* compiled from: LedgerDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/example/data/dao/LedgerDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<KClass<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}
