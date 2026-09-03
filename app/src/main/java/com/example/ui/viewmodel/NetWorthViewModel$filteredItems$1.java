package com.example.ui.viewmodel;

import com.example.data.model.FinancialItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;

/* compiled from: NetWorthViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lcom/example/data/model/FinancialItem;", "items", "owner", "", "category", "query"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.viewmodel.NetWorthViewModel$filteredItems$1", f = "NetWorthViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class NetWorthViewModel$filteredItems$1 extends SuspendLambda implements Function5<List<? extends FinancialItem>, String, String, String, Continuation<? super List<? extends FinancialItem>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NetWorthViewModel$filteredItems$1(Continuation<? super NetWorthViewModel$filteredItems$1> continuation) {
        super(5, continuation);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(List<? extends FinancialItem> list, String str, String str2, String str3, Continuation<? super List<? extends FinancialItem>> continuation) {
        return invoke2((List<FinancialItem>) list, str, str2, str3, (Continuation<? super List<FinancialItem>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<FinancialItem> list, String str, String str2, String str3, Continuation<? super List<FinancialItem>> continuation) {
        NetWorthViewModel$filteredItems$1 netWorthViewModel$filteredItems$1 = new NetWorthViewModel$filteredItems$1(continuation);
        netWorthViewModel$filteredItems$1.L$0 = list;
        netWorthViewModel$filteredItems$1.L$1 = str;
        netWorthViewModel$filteredItems$1.L$2 = str2;
        netWorthViewModel$filteredItems$1.L$3 = str3;
        return netWorthViewModel$filteredItems$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e7 A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.viewmodel.NetWorthViewModel$filteredItems$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
