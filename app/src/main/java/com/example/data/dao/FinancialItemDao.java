package com.example.data.dao;

import com.example.data.model.FinancialItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: FinancialDao.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH'J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\fJ\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\fJ\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\nH§@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u0017¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/example/data/dao/FinancialItemDao;", "", "getAllItems", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/model/FinancialItem;", "getItemsByOwner", "owner", "", "insertItem", "", "item", "(Lcom/example/data/model/FinancialItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertItems", "", "items", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateItem", "deleteItem", "deleteItemById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllItems", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface FinancialItemDao {
    Object deleteAllItems(Continuation<? super Unit> continuation);

    Object deleteItem(FinancialItem financialItem, Continuation<? super Unit> continuation);

    Object deleteItemById(long j, Continuation<? super Unit> continuation);

    Flow<List<FinancialItem>> getAllItems();

    Flow<List<FinancialItem>> getItemsByOwner(String owner);

    Object insertItem(FinancialItem financialItem, Continuation<? super Long> continuation);

    Object insertItems(List<FinancialItem> list, Continuation<? super Unit> continuation);

    Object updateItem(FinancialItem financialItem, Continuation<? super Unit> continuation);
}
