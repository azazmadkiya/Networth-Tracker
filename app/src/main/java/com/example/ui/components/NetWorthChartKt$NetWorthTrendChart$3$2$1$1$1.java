package com.example.ui.components;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntSize;
import com.example.data.model.NetWorthSnapshot;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetWorthChart.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.components.NetWorthChartKt$NetWorthTrendChart$3$2$1$1$1", f = "NetWorthChart.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$pointerInput"}, s = {"L$0"})
/* loaded from: classes8.dex */
public final class NetWorthChartKt$NetWorthTrendChart$3$2$1$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<NetWorthSnapshot> $selectedSnapshot$delegate;
    final /* synthetic */ List<NetWorthSnapshot> $sortedSnapshots;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetWorthChartKt$NetWorthTrendChart$3$2$1$1$1(List<NetWorthSnapshot> list, MutableState<NetWorthSnapshot> mutableState, Continuation<? super NetWorthChartKt$NetWorthTrendChart$3$2$1$1$1> continuation) {
        super(2, continuation);
        this.$sortedSnapshots = list;
        this.$selectedSnapshot$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NetWorthChartKt$NetWorthTrendChart$3$2$1$1$1 netWorthChartKt$NetWorthTrendChart$3$2$1$1$1 = new NetWorthChartKt$NetWorthTrendChart$3$2$1$1$1(this.$sortedSnapshots, this.$selectedSnapshot$delegate, continuation);
        netWorthChartKt$NetWorthTrendChart$3$2$1$1$1.L$0 = obj;
        return netWorthChartKt$NetWorthTrendChart$3$2$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((NetWorthChartKt$NetWorthTrendChart$3$2$1$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        final PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final List<NetWorthSnapshot> list = this.$sortedSnapshots;
                final MutableState<NetWorthSnapshot> mutableState = this.$selectedSnapshot$delegate;
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$pointerInput);
                this.label = 1;
                if (TapGestureDetectorKt.detectTapGestures$default($this$pointerInput, null, null, null, new Function1() { // from class: com.example.ui.components.NetWorthChartKt$NetWorthTrendChart$3$2$1$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NetWorthChartKt$NetWorthTrendChart$3$2$1$1$1.invokeSuspend$lambda$0(list, $this$pointerInput, mutableState, (Offset) obj);
                    }
                }, this, 7, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invokeSuspend$lambda$0(List $sortedSnapshots, PointerInputScope $$this$pointerInput, MutableState $selectedSnapshot$delegate, Offset tapOffset) {
        if (!$sortedSnapshots.isEmpty()) {
            int width = IntSize.m6792getWidthimpl($$this$pointerInput.getBoundsSize());
            int stepX = width / RangesKt.coerceAtLeast($sortedSnapshots.size() - 1, 1);
            int index = RangesKt.coerceIn((int) (Offset.m3918getXimpl(tapOffset.getPackedValue()) / stepX), 0, CollectionsKt.getLastIndex($sortedSnapshots));
            $selectedSnapshot$delegate.setValue((NetWorthSnapshot) $sortedSnapshots.get(index));
        }
        return Unit.INSTANCE;
    }
}
