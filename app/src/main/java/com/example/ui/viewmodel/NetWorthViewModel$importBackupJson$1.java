package com.example.ui.viewmodel;

import com.example.data.repository.NetWorthRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetWorthViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.viewmodel.NetWorthViewModel$importBackupJson$1", f = "NetWorthViewModel.kt", i = {}, l = {672}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class NetWorthViewModel$importBackupJson$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $clearExisting;
    final /* synthetic */ String $jsonStr;
    final /* synthetic */ Function1<Boolean, Unit> $onResult;
    int label;
    final /* synthetic */ NetWorthViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NetWorthViewModel$importBackupJson$1(NetWorthViewModel netWorthViewModel, String str, boolean z, Function1<? super Boolean, Unit> function1, Continuation<? super NetWorthViewModel$importBackupJson$1> continuation) {
        super(2, continuation);
        this.this$0 = netWorthViewModel;
        this.$jsonStr = str;
        this.$clearExisting = z;
        this.$onResult = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NetWorthViewModel$importBackupJson$1(this.this$0, this.$jsonStr, this.$clearExisting, this.$onResult, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NetWorthViewModel$importBackupJson$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        NetWorthRepository netWorthRepository;
        Object importFromJson;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                netWorthRepository = this.this$0.repository;
                this.label = 1;
                importFromJson = netWorthRepository.importFromJson(this.$jsonStr, this.$clearExisting, this);
                if (importFromJson == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                importFromJson = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean success = ((Boolean) importFromJson).booleanValue();
        this.$onResult.invoke(Boxing.boxBoolean(success));
        return Unit.INSTANCE;
    }
}
