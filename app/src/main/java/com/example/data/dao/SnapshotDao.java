package com.example.data.dao;

import com.example.data.model.NetWorthSnapshot;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: FinancialDao.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\tJ\u000e\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/example/data/dao/SnapshotDao;", "", "getAllSnapshots", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/model/NetWorthSnapshot;", "insertSnapshot", "", "snapshot", "(Lcom/example/data/model/NetWorthSnapshot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSnapshot", "", "deleteAllSnapshots", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SnapshotDao {
    Object deleteAllSnapshots(Continuation<? super Unit> continuation);

    Object deleteSnapshot(NetWorthSnapshot netWorthSnapshot, Continuation<? super Unit> continuation);

    Flow<List<NetWorthSnapshot>> getAllSnapshots();

    Object insertSnapshot(NetWorthSnapshot netWorthSnapshot, Continuation<? super Long> continuation);
}
