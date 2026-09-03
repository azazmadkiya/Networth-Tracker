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
@DebugMetadata(c = "com.example.ui.viewmodel.NetWorthViewModel$deleteFinancialItem$1", f = "NetWorthViewModel.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4}, l = {579, 582, 599, 602, 621}, m = "invokeSuspend", n = {"sourceAcc", "now", "isIncome", "restoredBal", "sourceAcc", "now", "isIncome", "restoredBal", "sourceAcc", "now", "isIncome", "adjustedBal", "sourceAcc", "now", "isIncome", "adjustedBal", "now"}, s = {"L$0", "J$0", "Z$0", "D$0", "L$0", "J$0", "Z$0", "D$0", "L$0", "J$0", "Z$0", "D$0", "L$0", "J$0", "Z$0", "D$0", "J$0"})
/* loaded from: classes8.dex */
public final class NetWorthViewModel$deleteFinancialItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $adjustLinkedAccount;
    final /* synthetic */ FinancialItem $item;
    double D$0;
    long J$0;
    Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ NetWorthViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetWorthViewModel$deleteFinancialItem$1(boolean z, FinancialItem financialItem, NetWorthViewModel netWorthViewModel, Continuation<? super NetWorthViewModel$deleteFinancialItem$1> continuation) {
        super(2, continuation);
        this.$adjustLinkedAccount = z;
        this.$item = financialItem;
        this.this$0 = netWorthViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NetWorthViewModel$deleteFinancialItem$1(this.$adjustLinkedAccount, this.$item, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NetWorthViewModel$deleteFinancialItem$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0361 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0338 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0219 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[LOOP:0: B:32:0x00a6->B:57:?, LOOP_END, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r52) {
        /*
            Method dump skipped, instructions count: 886
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.viewmodel.NetWorthViewModel$deleteFinancialItem$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
