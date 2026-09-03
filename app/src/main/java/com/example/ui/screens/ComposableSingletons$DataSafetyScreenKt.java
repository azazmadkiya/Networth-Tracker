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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material.icons.filled.ContentCopyKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
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

/* compiled from: DataSafetyScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$DataSafetyScreenKt {
    public static final ComposableSingletons$DataSafetyScreenKt INSTANCE = new ComposableSingletons$DataSafetyScreenKt();

    /* renamed from: lambda$-393567674, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f191lambda$393567674 = ComposableLambdaKt.composableLambdaInstance(-393567674, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DataSafetyScreenKt.lambda__393567674$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1012229639 = ComposableLambdaKt.composableLambdaInstance(1012229639, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DataSafetyScreenKt.lambda_1012229639$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1446228481 = ComposableLambdaKt.composableLambdaInstance(1446228481, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DataSafetyScreenKt.lambda_1446228481$lambda$2((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$705516195 = ComposableLambdaKt.composableLambdaInstance(705516195, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DataSafetyScreenKt.lambda_705516195$lambda$4((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<ColumnScope, Composer, Integer, Unit> lambda$472766584 = ComposableLambdaKt.composableLambdaInstance(472766584, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DataSafetyScreenKt.lambda_472766584$lambda$8((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1025207466 = ComposableLambdaKt.composableLambdaInstance(1025207466, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DataSafetyScreenKt.lambda_1025207466$lambda$9((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1570167847, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f190lambda$1570167847 = ComposableLambdaKt.composableLambdaInstance(-1570167847, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DataSafetyScreenKt.lambda__1570167847$lambda$10((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-399643978, reason: not valid java name */
    private static Function3<ColumnScope, Composer, Integer, Unit> f192lambda$399643978 = ComposableLambdaKt.composableLambdaInstance(-399643978, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DataSafetyScreenKt.lambda__399643978$lambda$12((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$152796904 = ComposableLambdaKt.composableLambdaInstance(152796904, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DataSafetyScreenKt.lambda_152796904$lambda$13((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<ColumnScope, Composer, Integer, Unit> lambda$1311634389 = ComposableLambdaKt.composableLambdaInstance(1311634389, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DataSafetyScreenKt.lambda_1311634389$lambda$16((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1864075271 = ComposableLambdaKt.composableLambdaInstance(1864075271, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DataSafetyScreenKt.lambda_1864075271$lambda$17((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-719613658, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f193lambda$719613658 = ComposableLambdaKt.composableLambdaInstance(-719613658, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DataSafetyScreenKt.lambda__719613658$lambda$18((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1570167847$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7037getLambda$1570167847$app() {
        return f190lambda$1570167847;
    }

    /* renamed from: getLambda$-393567674$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7038getLambda$393567674$app() {
        return f191lambda$393567674;
    }

    /* renamed from: getLambda$-399643978$app, reason: not valid java name */
    public final Function3<ColumnScope, Composer, Integer, Unit> m7039getLambda$399643978$app() {
        return f192lambda$399643978;
    }

    /* renamed from: getLambda$-719613658$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7040getLambda$719613658$app() {
        return f193lambda$719613658;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1012229639$app() {
        return lambda$1012229639;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1025207466$app() {
        return lambda$1025207466;
    }

    public final Function3<ColumnScope, Composer, Integer, Unit> getLambda$1311634389$app() {
        return lambda$1311634389;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1446228481$app() {
        return lambda$1446228481;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$152796904$app() {
        return lambda$152796904;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1864075271$app() {
        return lambda$1864075271;
    }

    public final Function3<ColumnScope, Composer, Integer, Unit> getLambda$472766584$app() {
        return lambda$472766584;
    }

    public final Function2<Composer, Integer, Unit> getLambda$705516195$app() {
        return lambda$705516195;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__393567674$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C79@3319L190:DataSafetyScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-393567674, $changed, -1, "com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt.lambda$-393567674.<anonymous> (DataSafetyScreen.kt:79)");
            }
            TextKt.m2693Text4IGK_g("Data Safety & Play Store Guide", (Modifier) null, Color.INSTANCE.m4196getWhite0d7_KjU(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 196998, 0, 131034);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1012229639$lambda$1(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C90@3765L214:DataSafetyScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1012229639, $changed, -1, "com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt.lambda$1012229639.<anonymous> (DataSafetyScreen.kt:90)");
            }
            IconKt.m2150Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, Color.INSTANCE.m4196getWhite0d7_KjU(), $composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1446228481$lambda$2(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C110@4463L40:DataSafetyScreen.kt#2thlc2");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1446228481, $changed, -1, "com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt.lambda$1446228481.<anonymous> (DataSafetyScreen.kt:110)");
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
    public static final Unit lambda_1025207466$lambda$9(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C117@4728L46,114@4569L2187:DataSafetyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1025207466, $changed, -1, "com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt.lambda$1025207466.<anonymous> (DataSafetyScreen.kt:114)");
            }
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(20)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(ColorKt.Color(4278607686L), 0L, 0L, 0L, $composer, (CardDefaults.$stable << 12) | 6, 14), null, null, lambda$472766584, $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda_472766584$lambda$8(androidx.compose.foundation.layout.ColumnScope r97, androidx.compose.runtime.Composer r98, int r99) {
        /*
            Method dump skipped, instructions count: 1273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt.lambda_472766584$lambda$8(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda_705516195$lambda$4(androidx.compose.runtime.Composer r32, int r33) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt.lambda_705516195$lambda$4(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1570167847$lambda$10(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C170@7495L91,171@7607L39,172@7667L47:DataSafetyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1570167847, $changed, -1, "com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt.lambda$-1570167847.<anonymous> (DataSafetyScreen.kt:170)");
            }
            IconKt.m2150Iconww6aTOc(ContentCopyKt.getContentCopy(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(8)), $composer, 6);
            TextKt.m2693Text4IGK_g("Copy Play Console Questionnaire Answers", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_152796904$lambda$13(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C181@8017L11,181@7975L74,178@7816L1763:DataSafetyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(152796904, $changed, -1, "com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt.lambda$152796904.<anonymous> (DataSafetyScreen.kt:178)");
            }
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(18)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, f192lambda$399643978, $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__399643978$lambda$12(ColumnScope Card, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C183@8090L1471:DataSafetyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-399643978, $changed, -1, "com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt.lambda$-399643978.<anonymous> (DataSafetyScreen.kt:183)");
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
            ComposerKt.sourceInformationMarkerStart($composer, 1179093298, "C186@8328L10,184@8210L224,190@8460L246,196@8732L244,202@9002L259,208@9287L252:DataSafetyScreen.kt#2thlc2");
            TextKt.m2693Text4IGK_g("Play Console Form Guide", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 196614, 0, 65502);
            DataSafetyScreenKt.SafetyRow("Does your app collect or share user data?", "NO (Select 'No' in Google Play Console)", true, $composer, 438);
            DataSafetyScreenKt.SafetyRow("Is data shared with third parties?", "NO (No external SDKs, trackers, or partners)", true, $composer, 438);
            DataSafetyScreenKt.SafetyRow("Does the app provide account/data deletion?", "YES (Users can wipe all data anytime via Settings)", true, $composer, 438);
            DataSafetyScreenKt.SafetyRow("Is the app target audience suitable for General Audiences?", "YES (Finance & Productivity)", true, $composer, 438);
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
    public static final Unit lambda_1864075271$lambda$17(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C222@9878L11,222@9836L74,219@9677L1518:DataSafetyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1864075271, $changed, -1, "com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt.lambda$1864075271.<anonymous> (DataSafetyScreen.kt:219)");
            }
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(18)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, lambda$1311634389, $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda_1311634389$lambda$16(androidx.compose.foundation.layout.ColumnScope r83, androidx.compose.runtime.Composer r84, int r85) {
        /*
            Method dump skipped, instructions count: 899
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt.lambda_1311634389$lambda$16(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__719613658$lambda$18(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C243@11230L41:DataSafetyScreen.kt#2thlc2");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-719613658, $changed, -1, "com.example.ui.screens.ComposableSingletons$DataSafetyScreenKt.lambda$-719613658.<anonymous> (DataSafetyScreen.kt:243)");
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
