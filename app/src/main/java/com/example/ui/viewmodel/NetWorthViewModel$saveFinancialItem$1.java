package com.example.ui.viewmodel;

import com.example.data.model.FinancialItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetWorthViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.viewmodel.NetWorthViewModel$saveFinancialItem$1", f = "NetWorthViewModel.kt", i = {0, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 9, 9}, l = {282, 284, 296, 302, 326, 347, 353, 369, 386, 401}, m = "invokeSuspend", n = {"isNewItem", "isNewItem", "sourceAcc", "isNewItem", "insertedId", "updatedVal", "sourceAcc", "isNewItem", "insertedId", "newSourceBal", "sourceAcc", "noteDetail", "isNewItem", "insertedId", "newSourceBal", "targetAcc", "isNewItem", "insertedId", "updatedVal", "targetAcc", "isNewItem", "insertedId", "newTargetBal", "targetAcc", "isNewItem", "insertedId", "newTargetBal", "isNewItem", "insertedId", "isNewItem", "insertedId"}, s = {"I$0", "I$0", "L$0", "I$0", "J$0", "D$0", "L$0", "I$0", "J$0", "D$0", "L$0", "L$1", "I$0", "J$0", "D$0", "L$0", "I$0", "J$0", "D$0", "L$0", "I$0", "J$0", "D$0", "L$0", "I$0", "J$0", "D$0", "I$0", "J$0", "I$0", "J$0"})
/* loaded from: classes8.dex */
public final class NetWorthViewModel$saveFinancialItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FinancialItem $item;
    double D$0;
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ NetWorthViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetWorthViewModel$saveFinancialItem$1(FinancialItem financialItem, NetWorthViewModel netWorthViewModel, Continuation<? super NetWorthViewModel$saveFinancialItem$1> continuation) {
        super(2, continuation);
        this.$item = financialItem;
        this.this$0 = netWorthViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NetWorthViewModel$saveFinancialItem$1(this.$item, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NetWorthViewModel$saveFinancialItem$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0009. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0473 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:? A[LOOP:1: B:97:0x0424->B:116:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x05bc  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x05b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0542 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0543  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x03ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0244 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0172 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[LOOP:0: B:67:0x0124->B:87:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0402  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r43) {
        /*
            Method dump skipped, instructions count: 1736
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.viewmodel.NetWorthViewModel$saveFinancialItem$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
