package com.example.data.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.example.data.model.Asset;
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

/* compiled from: AssetDao_Impl.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00150\u0014H\u0016J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/example/data/dao/AssetDao_Impl;", "Lcom/example/data/dao/AssetDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfAsset", "Landroidx/room/EntityInsertAdapter;", "Lcom/example/data/model/Asset;", "__deleteAdapterOfAsset", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfAsset", "insertAsset", "", "asset", "(Lcom/example/data/model/Asset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAsset", "", "updateAsset", "getAllAssets", "Lkotlinx/coroutines/flow/Flow;", "", "getAssetsByCategory", "category", "", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AssetDao_Impl implements AssetDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<Asset> __deleteAdapterOfAsset;
    private final EntityInsertAdapter<Asset> __insertAdapterOfAsset;
    private final EntityDeleteOrUpdateAdapter<Asset> __updateAdapterOfAsset;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public AssetDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfAsset = new EntityInsertAdapter<Asset>() { // from class: com.example.data.dao.AssetDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `assets` (`id`,`name`,`type`,`category`,`value`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Asset entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
                statement.mo6932bindText(2, entity.getName());
                statement.mo6932bindText(3, entity.getType());
                statement.mo6932bindText(4, entity.getCategory());
                statement.mo6929bindDouble(5, entity.getValue());
            }
        };
        this.__deleteAdapterOfAsset = new EntityDeleteOrUpdateAdapter<Asset>() { // from class: com.example.data.dao.AssetDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `assets` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, Asset entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfAsset = new EntityDeleteOrUpdateAdapter<Asset>() { // from class: com.example.data.dao.AssetDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `assets` SET `id` = ?,`name` = ?,`type` = ?,`category` = ?,`value` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, Asset entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
                statement.mo6932bindText(2, entity.getName());
                statement.mo6932bindText(3, entity.getType());
                statement.mo6932bindText(4, entity.getCategory());
                statement.mo6929bindDouble(5, entity.getValue());
                statement.mo6930bindLong(6, entity.getId());
            }
        };
    }

    @Override // com.example.data.dao.AssetDao
    public Object insertAsset(final Asset asset, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.AssetDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(AssetDao_Impl.insertAsset$lambda$0(AssetDao_Impl.this, asset, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final long insertAsset$lambda$0(AssetDao_Impl this$0, Asset $asset, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        long _result = this$0.__insertAdapterOfAsset.insertAndReturnId(_connection, $asset);
        return _result;
    }

    @Override // com.example.data.dao.AssetDao
    public Object deleteAsset(final Asset asset, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.AssetDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AssetDao_Impl.deleteAsset$lambda$1(AssetDao_Impl.this, asset, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteAsset$lambda$1(AssetDao_Impl this$0, Asset $asset, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__deleteAdapterOfAsset.handle(_connection, $asset);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.dao.AssetDao
    public Object updateAsset(final Asset asset, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.AssetDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AssetDao_Impl.updateAsset$lambda$2(AssetDao_Impl.this, asset, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit updateAsset$lambda$2(AssetDao_Impl this$0, Asset $asset, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__updateAdapterOfAsset.handle(_connection, $asset);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.dao.AssetDao
    public Flow<List<Asset>> getAllAssets() {
        final String _sql = "SELECT * FROM assets ORDER BY id DESC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"assets"}, new Function1() { // from class: com.example.data.dao.AssetDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AssetDao_Impl.getAllAssets$lambda$3(_sql, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getAllAssets$lambda$3(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "name");
            int _columnIndexOfType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "type");
            int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
            int _columnIndexOfValue = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "value");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_columnIndexOfId);
                String _tmpName = _stmt.getText(_columnIndexOfName);
                String _tmpType = _stmt.getText(_columnIndexOfType);
                String _tmpCategory = _stmt.getText(_columnIndexOfCategory);
                double _tmpValue = _stmt.getDouble(_columnIndexOfValue);
                Asset _item = new Asset(_tmpId, _tmpName, _tmpType, _tmpCategory, _tmpValue);
                _result.add(_item);
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.dao.AssetDao
    public Flow<List<Asset>> getAssetsByCategory(final String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        final String _sql = "SELECT * FROM assets WHERE category = ?";
        return FlowUtil.createFlow(this.__db, false, new String[]{"assets"}, new Function1() { // from class: com.example.data.dao.AssetDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AssetDao_Impl.getAssetsByCategory$lambda$4(_sql, category, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getAssetsByCategory$lambda$4(String $_sql, String $category, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.mo6932bindText(1, $category);
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "name");
            int _columnIndexOfType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "type");
            int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
            int _columnIndexOfValue = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "value");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_columnIndexOfId);
                String _tmpName = _stmt.getText(_columnIndexOfName);
                String _tmpType = _stmt.getText(_columnIndexOfType);
                String _tmpCategory = _stmt.getText(_columnIndexOfCategory);
                double _tmpValue = _stmt.getDouble(_columnIndexOfValue);
                Asset _item = new Asset(_tmpId, _tmpName, _tmpType, _tmpCategory, _tmpValue);
                _result.add(_item);
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    /* compiled from: AssetDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/example/data/dao/AssetDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
