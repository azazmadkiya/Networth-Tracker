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
@DebugMetadata(c = "com.example.ui.viewmodel.NetWorthViewModel$adjustAccountBalance$1", f = "NetWorthViewModel.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {508, 514}, m = "invokeSuspend", n = {"updatedItem", "now", "oldAmount", "delta", "updatedItem", "now", "oldAmount", "delta", "isIncrease", "absDiff"}, s = {"L$0", "J$0", "D$0", "D$1", "L$0", "J$0", "D$0", "D$1", "I$0", "D$2"})
/* loaded from: classes8.dex */
public final class NetWorthViewModel$adjustAccountBalance$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FinancialItem $item;
    final /* synthetic */ double $newAmount;
    final /* synthetic */ String $reason;
    double D$0;
    double D$1;
    double D$2;
    int I$0;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ NetWorthViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetWorthViewModel$adjustAccountBalance$1(FinancialItem financialItem, double d, NetWorthViewModel netWorthViewModel, String str, Continuation<? super NetWorthViewModel$adjustAccountBalance$1> continuation) {
        super(2, continuation);
        this.$item = financialItem;
        this.$newAmount = d;
        this.this$0 = netWorthViewModel;
        this.$reason = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NetWorthViewModel$adjustAccountBalance$1(this.$item, this.$newAmount, this.this$0, this.$reason, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NetWorthViewModel$adjustAccountBalance$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01bd  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r34) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.viewmodel.NetWorthViewModel$adjustAccountBalance$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
