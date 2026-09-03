package com.example.ui.screens;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material.icons.filled.CalculateKt;
import androidx.compose.material.icons.filled.ContentCopyKt;
import androidx.compose.material.icons.filled.LockKt;
import androidx.compose.material.icons.filled.ShareKt;
import androidx.compose.material.icons.filled.WarningAmberKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TermsOfServiceScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$TermsOfServiceScreenKt {
    public static final ComposableSingletons$TermsOfServiceScreenKt INSTANCE = new ComposableSingletons$TermsOfServiceScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$1244782608 = ComposableLambdaKt.composableLambdaInstance(1244782608, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TermsOfServiceScreenKt.lambda_1244782608$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$471945937 = ComposableLambdaKt.composableLambdaInstance(471945937, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TermsOfServiceScreenKt.lambda_471945937$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1388048802 = ComposableLambdaKt.composableLambdaInstance(1388048802, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TermsOfServiceScreenKt.lambda_1388048802$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1331233995 = ComposableLambdaKt.composableLambdaInstance(1331233995, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TermsOfServiceScreenKt.lambda_1331233995$lambda$3((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-757013651, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f258lambda$757013651 = ComposableLambdaKt.composableLambdaInstance(-757013651, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TermsOfServiceScreenKt.lambda__757013651$lambda$5((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1885551550, reason: not valid java name */
    private static Function3<ColumnScope, Composer, Integer, Unit> f256lambda$1885551550 = ComposableLambdaKt.composableLambdaInstance(-1885551550, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TermsOfServiceScreenKt.lambda__1885551550$lambda$9((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-116128140, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f254lambda$116128140 = ComposableLambdaKt.composableLambdaInstance(-116128140, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TermsOfServiceScreenKt.lambda__116128140$lambda$10((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<ColumnScope, Composer, Integer, Unit> lambda$1372405345 = ComposableLambdaKt.composableLambdaInstance(1372405345, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TermsOfServiceScreenKt.lambda_1372405345$lambda$12((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1153138541, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f253lambda$1153138541 = ComposableLambdaKt.composableLambdaInstance(-1153138541, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TermsOfServiceScreenKt.lambda__1153138541$lambda$13((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1485072190, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f255lambda$1485072190 = ComposableLambdaKt.composableLambdaInstance(-1485072190, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TermsOfServiceScreenKt.lambda__1485072190$lambda$14((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-579115595, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f257lambda$579115595 = ComposableLambdaKt.composableLambdaInstance(-579115595, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TermsOfServiceScreenKt.lambda__579115595$lambda$17((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$30797552 = ComposableLambdaKt.composableLambdaInstance(30797552, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TermsOfServiceScreenKt.lambda_30797552$lambda$18((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1006212849, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f252lambda$1006212849 = ComposableLambdaKt.composableLambdaInstance(-1006212849, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TermsOfServiceScreenKt.lambda__1006212849$lambda$19((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1006212849$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7099getLambda$1006212849$app() {
        return f252lambda$1006212849;
    }

    /* renamed from: getLambda$-1153138541$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7100getLambda$1153138541$app() {
        return f253lambda$1153138541;
    }

    /* renamed from: getLambda$-116128140$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7101getLambda$116128140$app() {
        return f254lambda$116128140;
    }

    /* renamed from: getLambda$-1485072190$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7102getLambda$1485072190$app() {
        return f255lambda$1485072190;
    }

    /* renamed from: getLambda$-1885551550$app, reason: not valid java name */
    public final Function3<ColumnScope, Composer, Integer, Unit> m7103getLambda$1885551550$app() {
        return f256lambda$1885551550;
    }

    /* renamed from: getLambda$-579115595$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7104getLambda$579115595$app() {
        return f257lambda$579115595;
    }

    /* renamed from: getLambda$-757013651$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7105getLambda$757013651$app() {
        return f258lambda$757013651;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1244782608$app() {
        return lambda$1244782608;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1331233995$app() {
        return lambda$1331233995;
    }

    public final Function3<ColumnScope, Composer, Integer, Unit> getLambda$1372405345$app() {
        return lambda$1372405345;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1388048802$app() {
        return lambda$1388048802;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$30797552$app() {
        return lambda$30797552;
    }

    public final Function2<Composer, Integer, Unit> getLambda$471945937$app() {
        return lambda$471945937;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1244782608$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C104@5151L176:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1244782608, $changed, -1, "com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt.lambda$1244782608.<anonymous> (TermsOfServiceScreen.kt:104)");
            }
            TextKt.m2693Text4IGK_g("Terms of Service", (Modifier) null, Color.INSTANCE.m4196getWhite0d7_KjU(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 196998, 0, 131034);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_471945937$lambda$1(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C115@5577L214:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(471945937, $changed, -1, "com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt.lambda$471945937.<anonymous> (TermsOfServiceScreen.kt:115)");
            }
            IconKt.m2150Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, Color.INSTANCE.m4196getWhite0d7_KjU(), $composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1388048802$lambda$2(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C134@6512L205:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1388048802, $changed, -1, "com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt.lambda$1388048802.<anonymous> (TermsOfServiceScreen.kt:134)");
            }
            IconKt.m2150Iconww6aTOc(ShareKt.getShare(Icons.INSTANCE.getDefault()), "Share Terms", (Modifier) null, Color.INSTANCE.m4196getWhite0d7_KjU(), $composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1331233995$lambda$3(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C154@7201L40:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1331233995, $changed, -1, "com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt.lambda$1331233995.<anonymous> (TermsOfServiceScreen.kt:154)");
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
    public static final Unit lambda__116128140$lambda$10(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C161@7510L46,158@7318L2491:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-116128140, $changed, -1, "com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt.lambda$-116128140.<anonymous> (TermsOfServiceScreen.kt:158)");
            }
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "terms_disclaimer_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(20)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(ColorKt.Color(4280171146L), 0L, 0L, 0L, $composer, (CardDefaults.$stable << 12) | 6, 14), null, null, f256lambda$1885551550, $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda__1885551550$lambda$9(androidx.compose.foundation.layout.ColumnScope r97, androidx.compose.runtime.Composer r98, int r99) {
        /*
            Method dump skipped, instructions count: 1272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt.lambda__1885551550$lambda$9(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda__757013651$lambda$5(androidx.compose.runtime.Composer r32, int r33) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt.lambda__757013651$lambda$5(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1153138541$lambda$13(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C212@10087L11,212@10045L74,209@9886L1779:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1153138541, $changed, -1, "com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt.lambda$-1153138541.<anonymous> (TermsOfServiceScreen.kt:209)");
            }
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(18)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, lambda$1372405345, $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1372405345$lambda$12(ColumnScope Card, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C214@10160L1487:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1372405345, $changed, -1, "com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt.lambda$1372405345.<anonymous> (TermsOfServiceScreen.kt:214)");
            }
            Modifier m670padding3ABfNKs = PaddingKt.m670padding3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16));
            Arrangement.Vertical m550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6622constructorimpl(14));
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m550spacedBy0680j_4, Alignment.INSTANCE.getStart(), $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier($composer, m670padding3ABfNKs);
            Function0 constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((54 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                $composer.createNode(constructor);
            } else {
                $composer.useNode();
            }
            Composer m3652constructorimpl = Updater.m3652constructorimpl($composer);
            Updater.m3659setimpl(m3652constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3659setimpl(m3652constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3652constructorimpl.getInserting() || !Intrinsics.areEqual(m3652constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3652constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3652constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3659setimpl(m3652constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i3 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 529710487, "C217@10387L10,215@10280L213,221@10519L364,228@10909L353,235@11288L337:TermsOfServiceScreen.kt#2thlc2");
            TextKt.m2693Text4IGK_g("Core Summary", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 196614, 0, 65502);
            TermsOfServiceScreenKt.m7109TermsItem3IgeMak(CalculateKt.getCalculate(Icons.INSTANCE.getDefault()), ColorKt.Color(4282090230L), "Self-Custody Financial Ledger", "Designed exclusively for personal calculation and tracking. All balance adjustments reflect user input.", $composer, 3504);
            TermsOfServiceScreenKt.m7109TermsItem3IgeMak(WarningAmberKt.getWarningAmber(Icons.INSTANCE.getDefault()), ColorKt.Color(4294286859L), "No Investment Advisory", "Calculations, stock quotes, and analytics are not professional financial or tax recommendations.", $composer, 3504);
            TermsOfServiceScreenKt.m7109TermsItem3IgeMak(LockKt.getLock(Icons.INSTANCE.getDefault()), ColorKt.Color(4279286145L), "User Backup Responsibility", "Because data is stored offline on your device, regular JSON exports are recommended.", $composer, 3504);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1485072190$lambda$14(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C257@12357L91,258@12469L39,259@12529L39:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1485072190, $changed, -1, "com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt.lambda$-1485072190.<anonymous> (TermsOfServiceScreen.kt:257)");
            }
            IconKt.m2150Iconww6aTOc(ContentCopyKt.getContentCopy(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(8)), $composer, 6);
            TextKt.m2693Text4IGK_g("Copy Full Terms of Service Text", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_30797552$lambda$18(LazyItemScope item, Composer $composer, int $changed) {
        long m4157copywmQWz5c;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C294@13908L11,291@13746L1464:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(30797552, $changed, -1, "com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt.lambda$30797552.<anonymous> (TermsOfServiceScreen.kt:291)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            RoundedCornerShape m953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(16));
            m4157copywmQWz5c = Color.m4157copywmQWz5c(r15, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(r15) : 0.5f, (r12 & 2) != 0 ? Color.m4165getRedimpl(r15) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(r15) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceVariant()) : 0.0f);
            SurfaceKt.m2543SurfaceT9BRK9s(fillMaxWidth$default, m953RoundedCornerShape0680j_4, m4157copywmQWz5c, 0L, 0.0f, 0.0f, null, f257lambda$579115595, $composer, 12582918, 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x021f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda__579115595$lambda$17(androidx.compose.runtime.Composer r71, int r72) {
        /*
            Method dump skipped, instructions count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt.lambda__579115595$lambda$17(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1006212849$lambda$19(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C323@15245L41:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1006212849, $changed, -1, "com.example.ui.screens.ComposableSingletons$TermsOfServiceScreenKt.lambda$-1006212849.<anonymous> (TermsOfServiceScreen.kt:323)");
            }
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(30)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
