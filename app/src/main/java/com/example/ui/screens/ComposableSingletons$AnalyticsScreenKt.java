package com.example.ui.screens;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CameraAltKt;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalyticsScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$AnalyticsScreenKt {
    public static final ComposableSingletons$AnalyticsScreenKt INSTANCE = new ComposableSingletons$AnalyticsScreenKt();

    /* renamed from: lambda$-25352405, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f174lambda$25352405 = ComposableLambdaKt.composableLambdaInstance(-25352405, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AnalyticsScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AnalyticsScreenKt.lambda__25352405$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$123774902 = ComposableLambdaKt.composableLambdaInstance(123774902, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AnalyticsScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AnalyticsScreenKt.lambda_123774902$lambda$1((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-161309818, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f173lambda$161309818 = ComposableLambdaKt.composableLambdaInstance(-161309818, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AnalyticsScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AnalyticsScreenKt.lambda__161309818$lambda$2((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1952386663 = ComposableLambdaKt.composableLambdaInstance(1952386663, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AnalyticsScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AnalyticsScreenKt.lambda_1952386663$lambda$3((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$683245118 = ComposableLambdaKt.composableLambdaInstance(683245118, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AnalyticsScreenKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AnalyticsScreenKt.lambda_683245118$lambda$4((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-161309818$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7020getLambda$161309818$app() {
        return f173lambda$161309818;
    }

    /* renamed from: getLambda$-25352405$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7021getLambda$25352405$app() {
        return f174lambda$25352405;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$123774902$app() {
        return lambda$123774902;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1952386663$app() {
        return lambda$1952386663;
    }

    public final Function2<Composer, Integer, Unit> getLambda$683245118$app() {
        return lambda$683245118;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__25352405$lambda$0(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C61@2687L40:AnalyticsScreen.kt#2thlc2");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-25352405, $changed, -1, "com.example.ui.screens.ComposableSingletons$AnalyticsScreenKt.lambda$-25352405.<anonymous> (AnalyticsScreen.kt:61)");
            }
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(8)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_123774902$lambda$1(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C87@3754L89,88@3864L39,89@3924L16:AnalyticsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(123774902, $changed, -1, "com.example.ui.screens.ComposableSingletons$AnalyticsScreenKt.lambda$123774902.<anonymous> (AnalyticsScreen.kt:87)");
            }
            IconKt.m2150Iconww6aTOc(CameraAltKt.getCameraAlt(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(6)), $composer, 6);
            TextKt.m2693Text4IGK_g("Snapshot", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__161309818$lambda$2(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C229@10499L10,230@10564L11,227@10394L216:AnalyticsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-161309818, $changed, -1, "com.example.ui.screens.ComposableSingletons$AnalyticsScreenKt.lambda$-161309818.<anonymous> (AnalyticsScreen.kt:227)");
            }
            TextKt.m2693Text4IGK_g("No snapshots recorded yet.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), $composer, 6, 0, 65530);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1952386663$lambda$3(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C239@10852L41:AnalyticsScreen.kt#2thlc2");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1952386663, $changed, -1, "com.example.ui.screens.ComposableSingletons$AnalyticsScreenKt.lambda$1952386663.<anonymous> (AnalyticsScreen.kt:239)");
            }
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(80)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_683245118$lambda$4(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C282@12728L116:AnalyticsScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(683245118, $changed, -1, "com.example.ui.screens.ComposableSingletons$AnalyticsScreenKt.lambda$683245118.<anonymous> (AnalyticsScreen.kt:282)");
            }
            IconKt.m2150Iconww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Delete", SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(18)), ColorKt.Color(4293870660L), $composer, 3504, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
