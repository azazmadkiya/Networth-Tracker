package com.example.data.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.example.data.model.FinancialItem;
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

/* compiled from: FinancialItemDao_Impl.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u0018H\u0016J\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0016\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/example/data/dao/FinancialItemDao_Impl;", "Lcom/example/data/dao/FinancialItemDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfFinancialItem", "Landroidx/room/EntityInsertAdapter;", "Lcom/example/data/model/FinancialItem;", "__deleteAdapterOfFinancialItem", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfFinancialItem", "insertItem", "", "item", "(Lcom/example/data/model/FinancialItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertItems", "", "items", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteItem", "updateItem", "getAllItems", "Lkotlinx/coroutines/flow/Flow;", "getItemsByOwner", "owner", "", "deleteItemById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllItems", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FinancialItemDao_Impl implements FinancialItemDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<FinancialItem> __deleteAdapterOfFinancialItem;
    private final EntityInsertAdapter<FinancialItem> __insertAdapterOfFinancialItem;
    private final EntityDeleteOrUpdateAdapter<FinancialItem> __updateAdapterOfFinancialItem;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public FinancialItemDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfFinancialItem = new EntityInsertAdapter<FinancialItem>() { // from class: com.example.data.dao.FinancialItemDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `financial_items` (`id`,`title`,`institution`,`accountNumber`,`owner`,`category`,`currentValue`,`investedValue`,`isLiability`,`notes`,`sourceAccountTitle`,`updatedAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, FinancialItem entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
                statement.mo6932bindText(2, entity.getTitle());
                statement.mo6932bindText(3, entity.getInstitution());
                statement.mo6932bindText(4, entity.getAccountNumber());
                statement.mo6932bindText(5, entity.getOwner());
                statement.mo6932bindText(6, entity.getCategory());
                statement.mo6929bindDouble(7, entity.getCurrentValue());
                statement.mo6929bindDouble(8, entity.getInvestedValue());
                statement.mo6930bindLong(9, entity.isLiability() ? 1L : 0L);
                statement.mo6932bindText(10, entity.getNotes());
                statement.mo6932bindText(11, entity.getSourceAccountTitle());
                statement.mo6930bindLong(12, entity.getUpdatedAt());
            }
        };
        this.__deleteAdapterOfFinancialItem = new EntityDeleteOrUpdateAdapter<FinancialItem>() { // from class: com.example.data.dao.FinancialItemDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `financial_items` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, FinancialItem entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfFinancialItem = new EntityDeleteOrUpdateAdapter<FinancialItem>() { // from class: com.example.data.dao.FinancialItemDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `financial_items` SET `id` = ?,`title` = ?,`institution` = ?,`accountNumber` = ?,`owner` = ?,`category` = ?,`currentValue` = ?,`investedValue` = ?,`isLiability` = ?,`notes` = ?,`sourceAccountTitle` = ?,`updatedAt` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, FinancialItem entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
                statement.mo6932bindText(2, entity.getTitle());
                statement.mo6932bindText(3, entity.getInstitution());
                statement.mo6932bindText(4, entity.getAccountNumber());
                statement.mo6932bindText(5, entity.getOwner());
                statement.mo6932bindText(6, entity.getCategory());
                statement.mo6929bindDouble(7, entity.getCurrentValue());
                statement.mo6929bindDouble(8, entity.getInvestedValue());
                statement.mo6930bindLong(9, entity.isLiability() ? 1L : 0L);
                statement.mo6932bindText(10, entity.getNotes());
                statement.mo6932bindText(11, entity.getSourceAccountTitle());
                statement.mo6930bindLong(12, entity.getUpdatedAt());
                statement.mo6930bindLong(13, entity.getId());
            }
        };
    }

    @Override // com.example.data.dao.FinancialItemDao
    public Object insertItem(final FinancialItem item, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.FinancialItemDao_Impl$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(FinancialItemDao_Impl.insertItem$lambda$0(FinancialItemDao_Impl.this, item, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final long insertItem$lambda$0(FinancialItemDao_Impl this$0, FinancialItem $item, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        long _result = this$0.__insertAdapterOfFinancialItem.insertAndReturnId(_connection, $item);
        return _result;
    }

    @Override // com.example.data.dao.FinancialItemDao
    public Object insertItems(final List<FinancialItem> list, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.FinancialItemDao_Impl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FinancialItemDao_Impl.insertItems$lambda$1(FinancialItemDao_Impl.this, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit insertItems$lambda$1(FinancialItemDao_Impl this$0, List $items, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__insertAdapterOfFinancialItem.insert(_connection, $items);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.dao.FinancialItemDao
    public Object deleteItem(final FinancialItem item, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.FinancialItemDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FinancialItemDao_Impl.deleteItem$lambda$2(FinancialItemDao_Impl.this, item, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteItem$lambda$2(FinancialItemDao_Impl this$0, FinancialItem $item, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__deleteAdapterOfFinancialItem.handle(_connection, $item);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.dao.FinancialItemDao
    public Object updateItem(final FinancialItem item, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.FinancialItemDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FinancialItemDao_Impl.updateItem$lambda$3(FinancialItemDao_Impl.this, item, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit updateItem$lambda$3(FinancialItemDao_Impl this$0, FinancialItem $item, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__updateAdapterOfFinancialItem.handle(_connection, $item);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.dao.FinancialItemDao
    public Flow<List<FinancialItem>> getAllItems() {
        final String _sql = "SELECT * FROM financial_items ORDER BY currentValue DESC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"financial_items"}, new Function1() { // from class: com.example.data.dao.FinancialItemDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FinancialItemDao_Impl.getAllItems$lambda$4(_sql, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getAllItems$lambda$4(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            int _tmp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
            int _columnIndexOfInstitution = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "institution");
            int _columnIndexOfAccountNumber = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "accountNumber");
            int _columnIndexOfOwner = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "owner");
            int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
            int _columnIndexOfCurrentValue = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "currentValue");
            int _columnIndexOfInvestedValue = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "investedValue");
            int _columnIndexOfIsLiability = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isLiability");
            int _columnIndexOfNotes = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "notes");
            int _columnIndexOfSourceAccountTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sourceAccountTitle");
            int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_tmp);
                String _tmpTitle = _stmt.getText(_columnIndexOfTitle);
                String _tmpInstitution = _stmt.getText(_columnIndexOfInstitution);
                String _tmpAccountNumber = _stmt.getText(_columnIndexOfAccountNumber);
                String _tmpOwner = _stmt.getText(_columnIndexOfOwner);
                String _tmpCategory = _stmt.getText(_columnIndexOfCategory);
                double _tmpCurrentValue = _stmt.getDouble(_columnIndexOfCurrentValue);
                double _tmpInvestedValue = _stmt.getDouble(_columnIndexOfInvestedValue);
                int _columnIndexOfId = _tmp;
                int _tmp2 = (int) _stmt.getLong(_columnIndexOfIsLiability);
                boolean _tmpIsLiability = _tmp2 != 0;
                String _tmpNotes = _stmt.getText(_columnIndexOfNotes);
                String _tmpSourceAccountTitle = _stmt.getText(_columnIndexOfSourceAccountTitle);
                long _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
                FinancialItem _item = new FinancialItem(_tmpId, _tmpTitle, _tmpInstitution, _tmpAccountNumber, _tmpOwner, _tmpCategory, _tmpCurrentValue, _tmpInvestedValue, _tmpIsLiability, _tmpNotes, _tmpSourceAccountTitle, _tmpUpdatedAt);
                _result.add(_item);
                _tmp = _columnIndexOfId;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.dao.FinancialItemDao
    public Flow<List<FinancialItem>> getItemsByOwner(final String owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        final String _sql = "SELECT * FROM financial_items WHERE owner = ? ORDER BY currentValue DESC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"financial_items"}, new Function1() { // from class: com.example.data.dao.FinancialItemDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FinancialItemDao_Impl.getItemsByOwner$lambda$5(_sql, owner, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getItemsByOwner$lambda$5(String $_sql, String $owner, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.mo6932bindText(1, $owner);
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
            int _columnIndexOfInstitution = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "institution");
            int _columnIndexOfAccountNumber = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "accountNumber");
            int _columnIndexOfOwner = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "owner");
            int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
            int _columnIndexOfCurrentValue = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "currentValue");
            int _columnIndexOfInvestedValue = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "investedValue");
            int _columnIndexOfIsLiability = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isLiability");
            int _columnIndexOfNotes = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "notes");
            int _columnIndexOfSourceAccountTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sourceAccountTitle");
            int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_columnIndexOfId);
                String _tmpTitle = _stmt.getText(_columnIndexOfTitle);
                String _tmpInstitution = _stmt.getText(_columnIndexOfInstitution);
                String _tmpAccountNumber = _stmt.getText(_columnIndexOfAccountNumber);
                String _tmpOwner = _stmt.getText(_columnIndexOfOwner);
                String _tmpCategory = _stmt.getText(_columnIndexOfCategory);
                double _tmpCurrentValue = _stmt.getDouble(_columnIndexOfCurrentValue);
                double _tmpInvestedValue = _stmt.getDouble(_columnIndexOfInvestedValue);
                int _tmp = (int) _stmt.getLong(_columnIndexOfIsLiability);
                boolean _tmpIsLiability = _tmp != 0;
                String _tmpNotes = _stmt.getText(_columnIndexOfNotes);
                String _tmpSourceAccountTitle = _stmt.getText(_columnIndexOfSourceAccountTitle);
                long _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
                FinancialItem _item = new FinancialItem(_tmpId, _tmpTitle, _tmpInstitution, _tmpAccountNumber, _tmpOwner, _tmpCategory, _tmpCurrentValue, _tmpInvestedValue, _tmpIsLiability, _tmpNotes, _tmpSourceAccountTitle, _tmpUpdatedAt);
                int _columnIndexOfUpdatedAt2 = _columnIndexOfUpdatedAt;
                List _result2 = _result;
                _result2.add(_item);
                _result = _result2;
                _columnIndexOfUpdatedAt = _columnIndexOfUpdatedAt2;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.dao.FinancialItemDao
    public Object deleteItemById(final long id, Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM financial_items WHERE id = ?";
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.FinancialItemDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FinancialItemDao_Impl.deleteItemById$lambda$6(_sql, id, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteItemById$lambda$6(String $_sql, long $id, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.mo6930bindLong(1, $id);
            _stmt.step();
            _stmt.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    @Override // com.example.data.dao.FinancialItemDao
    public Object deleteAllItems(Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM financial_items";
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.FinancialItemDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FinancialItemDao_Impl.deleteAllItems$lambda$7(_sql, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteAllItems$lambda$7(String $_sql, SQLiteConnection _connection) {
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

    /* compiled from: FinancialItemDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/example/data/dao/FinancialItemDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
