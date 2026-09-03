package com.example.ui.screens;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: SplashScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.screens.SplashScreenKt$SplashScreen$1$1", f = "SplashScreen.kt", i = {}, l = {49, 56, LockFreeTaskQueueCore.FROZEN_SHIFT}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SplashScreenKt$SplashScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $alpha;
    final /* synthetic */ Function0<Unit> $onSplashFinished;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $scale;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashScreenKt$SplashScreen$1$1(Animatable<Float, AnimationVector1D> animatable, Animatable<Float, AnimationVector1D> animatable2, Function0<Unit> function0, Continuation<? super SplashScreenKt$SplashScreen$1$1> continuation) {
        super(2, continuation);
        this.$scale = animatable;
        this.$alpha = animatable2;
        this.$onSplashFinished = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashScreenKt$SplashScreen$1$1(this.$scale, this.$alpha, this.$onSplashFinished, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SplashScreenKt$SplashScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006c A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 2
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r1) {
                case 0: goto L22;
                case 1: goto L1e;
                case 2: goto L1a;
                case 3: goto L16;
                default: goto Le;
            }
        Le:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L16:
            kotlin.ResultKt.throwOnFailure(r15)
            goto L7c
        L1a:
            kotlin.ResultKt.throwOnFailure(r15)
            goto L6d
        L1e:
            kotlin.ResultKt.throwOnFailure(r15)
            goto L4c
        L22:
            kotlin.ResultKt.throwOnFailure(r15)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r6 = r14.$scale
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            androidx.compose.animation.core.Easing r1 = androidx.compose.animation.core.EasingKt.getFastOutSlowInEasing()
            r8 = 800(0x320, float:1.121E-42)
            androidx.compose.animation.core.TweenSpec r1 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r8, r3, r1, r2, r5)
            r8 = r1
            androidx.compose.animation.core.AnimationSpec r8 = (androidx.compose.animation.core.AnimationSpec) r8
            r11 = r14
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r1 = 1
            r14.label = r1
            r9 = 0
            r10 = 0
            r12 = 12
            r13 = 0
            java.lang.Object r1 = androidx.compose.animation.core.Animatable.animateTo$default(r6, r7, r8, r9, r10, r11, r12, r13)
            if (r1 != r0) goto L4c
            return r0
        L4c:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r6 = r14.$alpha
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            r1 = 600(0x258, float:8.41E-43)
            r4 = 6
            androidx.compose.animation.core.TweenSpec r1 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r1, r3, r5, r4, r5)
            r8 = r1
            androidx.compose.animation.core.AnimationSpec r8 = (androidx.compose.animation.core.AnimationSpec) r8
            r11 = r14
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r14.label = r2
            r9 = 0
            r10 = 0
            r12 = 12
            r13 = 0
            java.lang.Object r1 = androidx.compose.animation.core.Animatable.animateTo$default(r6, r7, r8, r9, r10, r11, r12, r13)
            if (r1 != r0) goto L6d
            return r0
        L6d:
            r1 = r14
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r2 = 3
            r14.label = r2
            r2 = 1800(0x708, double:8.893E-321)
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r2, r1)
            if (r1 != r0) goto L7c
            return r0
        L7c:
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r14.$onSplashFinished
            r0.invoke()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.SplashScreenKt$SplashScreen$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
