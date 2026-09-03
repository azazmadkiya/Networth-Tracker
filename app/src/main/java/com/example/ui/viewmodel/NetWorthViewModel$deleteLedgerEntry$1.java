package com.example.ui.viewmodel;

import com.example.data.model.LedgerEntry;
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
@DebugMetadata(c = "com.example.ui.viewmodel.NetWorthViewModel$deleteLedgerEntry$1", f = "NetWorthViewModel.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {544, 555, 559}, m = "invokeSuspend", n = {"primaryAcc", "now", "adjustedVal", "primaryAcc", "secAcc", "now", "adjustedSecVal"}, s = {"L$0", "J$0", "D$0", "L$0", "L$1", "J$0", "D$0"})
/* loaded from: classes8.dex */
public final class NetWorthViewModel$deleteLedgerEntry$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $adjustAccountBalance;
    final /* synthetic */ LedgerEntry $entry;
    double D$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ NetWorthViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetWorthViewModel$deleteLedgerEntry$1(boolean z, NetWorthViewModel netWorthViewModel, LedgerEntry ledgerEntry, Continuation<? super NetWorthViewModel$deleteLedgerEntry$1> continuation) {
        super(2, continuation);
        this.$adjustAccountBalance = z;
        this.this$0 = netWorthViewModel;
        this.$entry = ledgerEntry;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NetWorthViewModel$deleteLedgerEntry$1(this.$adjustAccountBalance, this.this$0, this.$entry, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NetWorthViewModel$deleteLedgerEntry$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x01a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0119 A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r29) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.viewmodel.NetWorthViewModel$deleteLedgerEntry$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
