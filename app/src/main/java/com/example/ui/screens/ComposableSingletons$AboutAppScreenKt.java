package com.example.ui.screens;

import androidx.compose.foundation.BorderStrokeKt;
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
import androidx.compose.material.icons.filled.EmailKt;
import androidx.compose.material.icons.filled.ShareKt;
import androidx.compose.material3.CardColors;
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
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AboutAppScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$AboutAppScreenKt {
    public static final ComposableSingletons$AboutAppScreenKt INSTANCE = new ComposableSingletons$AboutAppScreenKt();

    /* renamed from: lambda$-1946406890, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f169lambda$1946406890 = ComposableLambdaKt.composableLambdaInstance(-1946406890, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AboutAppScreenKt.lambda__1946406890$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1082590121, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f166lambda$1082590121 = ComposableLambdaKt.composableLambdaInstance(-1082590121, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AboutAppScreenKt.lambda__1082590121$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$251680081 = ComposableLambdaKt.composableLambdaInstance(251680081, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AboutAppScreenKt.lambda_251680081$lambda$2((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1889679511 = ComposableLambdaKt.composableLambdaInstance(1889679511, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AboutAppScreenKt.lambda_1889679511$lambda$4((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-988737856, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f172lambda$988737856 = ComposableLambdaKt.composableLambdaInstance(-988737856, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AboutAppScreenKt.lambda__988737856$lambda$5((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1660530872, reason: not valid java name */
    private static Function3<ColumnScope, Composer, Integer, Unit> f168lambda$1660530872 = ComposableLambdaKt.composableLambdaInstance(-1660530872, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt$$ExternalSyntheticLambda13
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AboutAppScreenKt.lambda__1660530872$lambda$7((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$725208186 = ComposableLambdaKt.composableLambdaInstance(725208186, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AboutAppScreenKt.lambda_725208186$lambda$8((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-478298137, reason: not valid java name */
    private static Function3<ColumnScope, Composer, Integer, Unit> f171lambda$478298137 = ComposableLambdaKt.composableLambdaInstance(-478298137, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AboutAppScreenKt.lambda__478298137$lambda$12((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1907440921 = ComposableLambdaKt.composableLambdaInstance(1907440921, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AboutAppScreenKt.lambda_1907440921$lambda$13((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1566204956, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f167lambda$1566204956 = ComposableLambdaKt.composableLambdaInstance(-1566204956, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AboutAppScreenKt.lambda__1566204956$lambda$14((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$83527714 = ComposableLambdaKt.composableLambdaInstance(83527714, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AboutAppScreenKt.lambda_83527714$lambda$15((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<ColumnScope, Composer, Integer, Unit> lambda$1886167333 = ComposableLambdaKt.composableLambdaInstance(1886167333, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AboutAppScreenKt.lambda_1886167333$lambda$18((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-23060905, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f170lambda$23060905 = ComposableLambdaKt.composableLambdaInstance(-23060905, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AboutAppScreenKt.lambda__23060905$lambda$19((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1159171830 = ComposableLambdaKt.composableLambdaInstance(1159171830, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AboutAppScreenKt.lambda_1159171830$lambda$20((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1082590121$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7013getLambda$1082590121$app() {
        return f166lambda$1082590121;
    }

    /* renamed from: getLambda$-1566204956$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7014getLambda$1566204956$app() {
        return f167lambda$1566204956;
    }

    /* renamed from: getLambda$-1660530872$app, reason: not valid java name */
    public final Function3<ColumnScope, Composer, Integer, Unit> m7015getLambda$1660530872$app() {
        return f168lambda$1660530872;
    }

    /* renamed from: getLambda$-1946406890$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7016getLambda$1946406890$app() {
        return f169lambda$1946406890;
    }

    /* renamed from: getLambda$-23060905$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7017getLambda$23060905$app() {
        return f170lambda$23060905;
    }

    /* renamed from: getLambda$-478298137$app, reason: not valid java name */
    public final Function3<ColumnScope, Composer, Integer, Unit> m7018getLambda$478298137$app() {
        return f171lambda$478298137;
    }

    /* renamed from: getLambda$-988737856$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7019getLambda$988737856$app() {
        return f172lambda$988737856;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1159171830$app() {
        return lambda$1159171830;
    }

    public final Function3<ColumnScope, Composer, Integer, Unit> getLambda$1886167333$app() {
        return lambda$1886167333;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1889679511$app() {
        return lambda$1889679511;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1907440921$app() {
        return lambda$1907440921;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$251680081$app() {
        return lambda$251680081;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$725208186$app() {
        return lambda$725208186;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$83527714$app() {
        return lambda$83527714;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1946406890$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C59@2504L176:AboutAppScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1946406890, $changed, -1, "com.example.ui.screens.ComposableSingletons$AboutAppScreenKt.lambda$-1946406890.<anonymous> (AboutAppScreen.kt:59)");
            }
            TextKt.m2693Text4IGK_g("About & Licenses", (Modifier) null, Color.INSTANCE.m4196getWhite0d7_KjU(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 196998, 0, 131034);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1082590121$lambda$1(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C70@2930L214:AboutAppScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1082590121, $changed, -1, "com.example.ui.screens.ComposableSingletons$AboutAppScreenKt.lambda$-1082590121.<anonymous> (AboutAppScreen.kt:70)");
            }
            IconKt.m2150Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, Color.INSTANCE.m4196getWhite0d7_KjU(), $composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_251680081$lambda$2(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C90@3628L40:AboutAppScreen.kt#2thlc2");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(251680081, $changed, -1, "com.example.ui.screens.ComposableSingletons$AboutAppScreenKt.lambda$251680081.<anonymous> (AboutAppScreen.kt:90)");
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
    public static final Unit lambda_725208186$lambda$8(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C97@3973L11,97@3931L74,94@3745L3239:AboutAppScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(725208186, $changed, -1, "com.example.ui.screens.ComposableSingletons$AboutAppScreenKt.lambda$725208186.<anonymous> (AboutAppScreen.kt:94)");
            }
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "about_hero_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(22)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, f168lambda$1660530872, $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1660530872$lambda$7(ColumnScope Card, Composer $composer, int $changed) {
        long m4157copywmQWz5c;
        long m4157copywmQWz5c2;
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C99@4046L2920:AboutAppScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1660530872, $changed, -1, "com.example.ui.screens.ComposableSingletons$AboutAppScreenKt.lambda$-1660530872.<anonymous> (AboutAppScreen.kt:99)");
            }
            Modifier m670padding3ABfNKs = PaddingKt.m670padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6622constructorimpl(24));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier($composer, m670padding3ABfNKs);
            Function0 constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((390 << 3) & 112) << 6) & 896) | 6;
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
            int i3 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1934947225, "C107@4418L11,105@4310L713,120@5049L41,124@5226L10,122@5116L218,130@5489L10,131@5561L11,128@5360L255,134@5641L40,136@5707L719,150@6452L41,154@6728L10,155@6801L11,152@6519L425:AboutAppScreen.kt#2thlc2");
            SurfaceKt.m2543SurfaceT9BRK9s(SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(64)), RoundedCornerShapeKt.getCircleShape(), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimaryContainer(), 0L, 0.0f, 0.0f, null, lambda$1889679511, $composer, 12582918, 120);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(14)), $composer, 6);
            TextKt.m2693Text4IGK_g("Net Worth Vault", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getHeadlineSmall(), $composer, 196614, 0, 65502);
            TextKt.m2693Text4IGK_g("Version 1.0.0 (Production Release)", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 6, 0, 65530);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(8)), $composer, 6);
            RoundedCornerShape m953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(20));
            m4157copywmQWz5c = Color.m4157copywmQWz5c(r23, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(r23) : 0.15f, (r12 & 2) != 0 ? Color.m4165getRedimpl(r23) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(r23) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(ColorKt.Color(4279286145L)) : 0.0f);
            float m6622constructorimpl = Dp.m6622constructorimpl(1);
            m4157copywmQWz5c2 = Color.m4157copywmQWz5c(r27, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(r27) : 0.4f, (r12 & 2) != 0 ? Color.m4165getRedimpl(r27) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(r27) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(ColorKt.Color(4279286145L)) : 0.0f);
            SurfaceKt.m2543SurfaceT9BRK9s(null, m953RoundedCornerShape0680j_4, m4157copywmQWz5c, 0L, 0.0f, 0.0f, BorderStrokeKt.m252BorderStrokecXLIe8U(m6622constructorimpl, m4157copywmQWz5c2), f172lambda$988737856, $composer, 14156160, 57);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), $composer, 6);
            TextKt.m2693Text4IGK_g("A complete offline net worth, portfolio, and double-entry accounting ledger designed for individuals and families.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6482boximpl(TextAlign.INSTANCE.m6489getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), $composer, 6, 0, 65018);
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
    /* JADX WARN: Removed duplicated region for block: B:25:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda_1889679511$lambda$4(androidx.compose.runtime.Composer r32, int r33) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt.lambda_1889679511$lambda$4(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__988737856$lambda$5(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C141@6032L368:AboutAppScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-988737856, $changed, -1, "com.example.ui.screens.ComposableSingletons$AboutAppScreenKt.lambda$-988737856.<anonymous> (AboutAppScreen.kt:141)");
            }
            TextKt.m2693Text4IGK_g("100% Offline & Private", PaddingKt.m671paddingVpY3zN4(Modifier.INSTANCE, Dp.m6622constructorimpl(12), Dp.m6622constructorimpl(4)), ColorKt.Color(4278483031L), TextUnitKt.getSp(12), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 200118, 0, 131024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1907440921$lambda$13(LazyItemScope item, Composer $composer, int $changed) {
        long m4157copywmQWz5c;
        long m4157copywmQWz5c2;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C167@7299L11,167@7257L90,168@7439L11,164@7072L2105:AboutAppScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1907440921, $changed, -1, "com.example.ui.screens.ComposableSingletons$AboutAppScreenKt.lambda$1907440921.<anonymous> (AboutAppScreen.kt:164)");
            }
            Modifier testTag = TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "about_dev_card");
            RoundedCornerShape m953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(18));
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            m4157copywmQWz5c = Color.m4157copywmQWz5c(r16, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(r16) : 0.4f, (r12 & 2) != 0 ? Color.m4165getRedimpl(r16) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(r16) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimaryContainer()) : 0.0f);
            CardColors m1829cardColorsro_MJ88 = cardDefaults.m1829cardColorsro_MJ88(m4157copywmQWz5c, 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14);
            float m6622constructorimpl = Dp.m6622constructorimpl(1);
            m4157copywmQWz5c2 = Color.m4157copywmQWz5c(r16, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(r16) : 0.3f, (r12 & 2) != 0 ? Color.m4165getRedimpl(r16) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(r16) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary()) : 0.0f);
            CardKt.Card(testTag, m953RoundedCornerShape0680j_4, m1829cardColorsro_MJ88, null, BorderStrokeKt.m252BorderStrokecXLIe8U(m6622constructorimpl, m4157copywmQWz5c2), f171lambda$478298137, $composer, 196614, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda__478298137$lambda$12(androidx.compose.foundation.layout.ColumnScope r84, androidx.compose.runtime.Composer r85, int r86) {
        /*
            Method dump skipped, instructions count: 1332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt.lambda__478298137$lambda$12(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1566204956$lambda$14(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C222@10390L85,223@10500L39,224@10564L17:AboutAppScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1566204956, $changed, -1, "com.example.ui.screens.ComposableSingletons$AboutAppScreenKt.lambda$-1566204956.<anonymous> (AboutAppScreen.kt:222)");
            }
            IconKt.m2150Iconww6aTOc(ShareKt.getShare(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(6)), $composer, 6);
            TextKt.m2693Text4IGK_g("Share App", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_83527714$lambda$15(RowScope OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C242@11458L85,243@11568L39,244@11632L21:AboutAppScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(83527714, $changed, -1, "com.example.ui.screens.ComposableSingletons$AboutAppScreenKt.lambda$83527714.<anonymous> (AboutAppScreen.kt:242)");
            }
            IconKt.m2150Iconww6aTOc(EmailKt.getEmail(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(6)), $composer, 6);
            TextKt.m2693Text4IGK_g("Email Support", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__23060905$lambda$19(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C254@12006L11,254@11964L74,251@11780L1989:AboutAppScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-23060905, $changed, -1, "com.example.ui.screens.ComposableSingletons$AboutAppScreenKt.lambda$-23060905.<anonymous> (AboutAppScreen.kt:251)");
            }
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "licenses_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(18)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, lambda$1886167333, $composer, 196614, 24);
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
    /* JADX WARN: Removed duplicated region for block: B:36:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda_1886167333$lambda$18(androidx.compose.foundation.layout.ColumnScope r83, androidx.compose.runtime.Composer r84, int r85) {
        /*
            Method dump skipped, instructions count: 947
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$AboutAppScreenKt.lambda_1886167333$lambda$18(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1159171830$lambda$20(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C284@13804L41:AboutAppScreen.kt#2thlc2");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1159171830, $changed, -1, "com.example.ui.screens.ComposableSingletons$AboutAppScreenKt.lambda$1159171830.<anonymous> (AboutAppScreen.kt:284)");
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
