package com.example.ui.viewmodel;

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
@DebugMetadata(c = "com.example.ui.viewmodel.NetWorthViewModel$postDirectLedgerEntry$1", f = "NetWorthViewModel.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {436, 447, 452, 469}, m = "invokeSuspend", n = {"primaryAcc", "now", "updatedVal", "primaryAcc", "secondaryAcc", "now", "newPrimaryBal", "updatedVal", "primaryAcc", "secondaryAcc", "now", "newPrimaryBal", "newSecBal", "primaryAcc", "secondaryAcc", "now", "newPrimaryBal", "newSecBal"}, s = {"L$0", "J$0", "D$0", "L$0", "L$1", "J$0", "D$0", "D$1", "L$0", "L$1", "J$0", "D$0", "D$1", "L$0", "L$1", "J$0", "D$0", "D$1"})
/* loaded from: classes8.dex */
public final class NetWorthViewModel$postDirectLedgerEntry$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ double $amount;
    final /* synthetic */ String $category;
    final /* synthetic */ boolean $isDebitPrimary;
    final /* synthetic */ String $notes;
    final /* synthetic */ String $primaryAccount;
    final /* synthetic */ String $secondaryAccount;
    final /* synthetic */ String $title;
    double D$0;
    double D$1;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ NetWorthViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetWorthViewModel$postDirectLedgerEntry$1(NetWorthViewModel netWorthViewModel, boolean z, double d, String str, String str2, String str3, String str4, String str5, Continuation<? super NetWorthViewModel$postDirectLedgerEntry$1> continuation) {
        super(2, continuation);
        this.this$0 = netWorthViewModel;
        this.$isDebitPrimary = z;
        this.$amount = d;
        this.$secondaryAccount = str;
        this.$title = str2;
        this.$primaryAccount = str3;
        this.$category = str4;
        this.$notes = str5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NetWorthViewModel$postDirectLedgerEntry$1(this.this$0, this.$isDebitPrimary, this.$amount, this.$secondaryAccount, this.$title, this.$primaryAccount, this.$category, this.$notes, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NetWorthViewModel$postDirectLedgerEntry$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0212 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0137  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r40) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.viewmodel.NetWorthViewModel$postDirectLedgerEntry$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
