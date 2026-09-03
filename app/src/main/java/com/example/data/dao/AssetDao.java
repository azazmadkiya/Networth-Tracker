package com.example.data.dao;

import com.example.data.model.Asset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: AssetDao.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH'J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\fJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/example/data/dao/AssetDao;", "", "getAllAssets", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/model/Asset;", "getAssetsByCategory", "category", "", "insertAsset", "", "asset", "(Lcom/example/data/model/Asset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAsset", "", "deleteAsset", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AssetDao {
    Object deleteAsset(Asset asset, Continuation<? super Unit> continuation);

    Flow<List<Asset>> getAllAssets();

    Flow<List<Asset>> getAssetsByCategory(String category);

    Object insertAsset(Asset asset, Continuation<? super Long> continuation);

    Object updateAsset(Asset asset, Continuation<? super Unit> continuation);
}
