package com.example.ui.viewmodel;

import com.example.data.model.FinancialReminder;
import com.example.data.repository.NetWorthRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetWorthViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.viewmodel.NetWorthViewModel$saveReminder$1", f = "NetWorthViewModel.kt", i = {}, l = {647, 649}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class NetWorthViewModel$saveReminder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FinancialReminder $reminder;
    int label;
    final /* synthetic */ NetWorthViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetWorthViewModel$saveReminder$1(FinancialReminder financialReminder, NetWorthViewModel netWorthViewModel, Continuation<? super NetWorthViewModel$saveReminder$1> continuation) {
        super(2, continuation);
        this.$reminder = financialReminder;
        this.this$0 = netWorthViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NetWorthViewModel$saveReminder$1(this.$reminder, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NetWorthViewModel$saveReminder$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        NetWorthRepository netWorthRepository;
        NetWorthRepository netWorthRepository2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                long id = this.$reminder.getId();
                NetWorthViewModel netWorthViewModel = this.this$0;
                if (id == 0) {
                    netWorthRepository2 = netWorthViewModel.repository;
                    this.label = 1;
                    if (netWorthRepository2.insertReminder(this.$reminder, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                netWorthRepository = netWorthViewModel.repository;
                this.label = 2;
                if (netWorthRepository.updateReminder(this.$reminder, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                Unit unit2 = Unit.INSTANCE;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
