package com.example.data.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.example.data.model.NetWorthSnapshot;
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

/* compiled from: SnapshotDao_Impl.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u0012H\u0016J\u000e\u0010\u0014\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/example/data/dao/SnapshotDao_Impl;", "Lcom/example/data/dao/SnapshotDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfNetWorthSnapshot", "Landroidx/room/EntityInsertAdapter;", "Lcom/example/data/model/NetWorthSnapshot;", "__deleteAdapterOfNetWorthSnapshot", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "insertSnapshot", "", "snapshot", "(Lcom/example/data/model/NetWorthSnapshot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSnapshot", "", "getAllSnapshots", "Lkotlinx/coroutines/flow/Flow;", "", "deleteAllSnapshots", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SnapshotDao_Impl implements SnapshotDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<NetWorthSnapshot> __deleteAdapterOfNetWorthSnapshot;
    private final EntityInsertAdapter<NetWorthSnapshot> __insertAdapterOfNetWorthSnapshot;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public SnapshotDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfNetWorthSnapshot = new EntityInsertAdapter<NetWorthSnapshot>() { // from class: com.example.data.dao.SnapshotDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `net_worth_snapshots` (`id`,`timestamp`,`totalAssets`,`totalLiabilities`,`netWorth`,`note`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, NetWorthSnapshot entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
                statement.mo6930bindLong(2, entity.getTimestamp());
                statement.mo6929bindDouble(3, entity.getTotalAssets());
                statement.mo6929bindDouble(4, entity.getTotalLiabilities());
                statement.mo6929bindDouble(5, entity.getNetWorth());
                statement.mo6932bindText(6, entity.getNote());
            }
        };
        this.__deleteAdapterOfNetWorthSnapshot = new EntityDeleteOrUpdateAdapter<NetWorthSnapshot>() { // from class: com.example.data.dao.SnapshotDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `net_worth_snapshots` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, NetWorthSnapshot entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
            }
        };
    }

    @Override // com.example.data.dao.SnapshotDao
    public Object insertSnapshot(final NetWorthSnapshot snapshot, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.SnapshotDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(SnapshotDao_Impl.insertSnapshot$lambda$0(SnapshotDao_Impl.this, snapshot, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final long insertSnapshot$lambda$0(SnapshotDao_Impl this$0, NetWorthSnapshot $snapshot, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        long _result = this$0.__insertAdapterOfNetWorthSnapshot.insertAndReturnId(_connection, $snapshot);
        return _result;
    }

    @Override // com.example.data.dao.SnapshotDao
    public Object deleteSnapshot(final NetWorthSnapshot snapshot, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.SnapshotDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SnapshotDao_Impl.deleteSnapshot$lambda$1(SnapshotDao_Impl.this, snapshot, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteSnapshot$lambda$1(SnapshotDao_Impl this$0, NetWorthSnapshot $snapshot, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__deleteAdapterOfNetWorthSnapshot.handle(_connection, $snapshot);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.dao.SnapshotDao
    public Flow<List<NetWorthSnapshot>> getAllSnapshots() {
        final String _sql = "SELECT * FROM net_worth_snapshots ORDER BY timestamp ASC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"net_worth_snapshots"}, new Function1() { // from class: com.example.data.dao.SnapshotDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SnapshotDao_Impl.getAllSnapshots$lambda$2(_sql, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getAllSnapshots$lambda$2(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
            int _columnIndexOfTotalAssets = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalAssets");
            int _columnIndexOfTotalLiabilities = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalLiabilities");
            int _columnIndexOfNetWorth = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "netWorth");
            int _columnIndexOfNote = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "note");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_columnIndexOfId);
                long _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
                double _tmpTotalAssets = _stmt.getDouble(_columnIndexOfTotalAssets);
                double _tmpTotalLiabilities = _stmt.getDouble(_columnIndexOfTotalLiabilities);
                double _tmpNetWorth = _stmt.getDouble(_columnIndexOfNetWorth);
                String _tmpNote = _stmt.getText(_columnIndexOfNote);
                NetWorthSnapshot _item = new NetWorthSnapshot(_tmpId, _tmpTimestamp, _tmpTotalAssets, _tmpTotalLiabilities, _tmpNetWorth, _tmpNote);
                _result.add(_item);
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.dao.SnapshotDao
    public Object deleteAllSnapshots(Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM net_worth_snapshots";
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.SnapshotDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SnapshotDao_Impl.deleteAllSnapshots$lambda$3(_sql, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteAllSnapshots$lambda$3(String $_sql, SQLiteConnection _connection) {
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

    /* compiled from: SnapshotDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/example/data/dao/SnapshotDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
