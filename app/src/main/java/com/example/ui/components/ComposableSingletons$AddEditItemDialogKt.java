package com.example.ui.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: AddEditItemDialog.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ComposableSingletons$AddEditItemDialogKt {
    public static final ComposableSingletons$AddEditItemDialogKt INSTANCE = new ComposableSingletons$AddEditItemDialogKt();

    /* renamed from: lambda$-1533357584, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f98lambda$1533357584 = ComposableLambdaKt.composableLambdaInstance(-1533357584, false, new Function2() { // from class: com.example.ui.components.ComposableSingletons$AddEditItemDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AddEditItemDialogKt.lambda__1533357584$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1122747218, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f97lambda$1122747218 = ComposableLambdaKt.composableLambdaInstance(-1122747218, false, new Function2() { // from class: com.example.ui.components.ComposableSingletons$AddEditItemDialogKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AddEditItemDialogKt.lambda__1122747218$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-1122747218$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6943getLambda$1122747218$app() {
        return f97lambda$1122747218;
    }

    /* renamed from: getLambda$-1533357584$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6944getLambda$1533357584$app() {
        return f98lambda$1533357584;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1533357584$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:AddEditItemDialog.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1533357584, $changed, -1, "com.example.ui.components.ComposableSingletons$AddEditItemDialogKt.lambda$-1533357584.<anonymous> (AddEditItemDialog.kt:39)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1122747218$lambda$1(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:AddEditItemDialog.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1122747218, $changed, -1, "com.example.ui.components.ComposableSingletons$AddEditItemDialogKt.lambda$-1122747218.<anonymous> (AddEditItemDialog.kt:40)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
