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
import androidx.compose.material.icons.filled.ContentCopyKt;
import androidx.compose.material.icons.filled.DeleteForeverKt;
import androidx.compose.material.icons.filled.HtmlKt;
import androidx.compose.material.icons.filled.LockKt;
import androidx.compose.material.icons.filled.ShareKt;
import androidx.compose.material.icons.filled.StorageKt;
import androidx.compose.material.icons.filled.VisibilityOffKt;
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

/* compiled from: PrivacyPolicyScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$PrivacyPolicyScreenKt {
    public static final ComposableSingletons$PrivacyPolicyScreenKt INSTANCE = new ComposableSingletons$PrivacyPolicyScreenKt();

    /* renamed from: lambda$-119648804, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f217lambda$119648804 = ComposableLambdaKt.composableLambdaInstance(-119648804, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PrivacyPolicyScreenKt.lambda__119648804$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$232619229 = ComposableLambdaKt.composableLambdaInstance(232619229, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PrivacyPolicyScreenKt.lambda_232619229$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1786536978, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f220lambda$1786536978 = ComposableLambdaKt.composableLambdaInstance(-1786536978, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PrivacyPolicyScreenKt.lambda__1786536978$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-445815465, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f224lambda$445815465 = ComposableLambdaKt.composableLambdaInstance(-445815465, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PrivacyPolicyScreenKt.lambda__445815465$lambda$3((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$289440889 = ComposableLambdaKt.composableLambdaInstance(289440889, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PrivacyPolicyScreenKt.lambda_289440889$lambda$5((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1950837106, reason: not valid java name */
    private static Function3<ColumnScope, Composer, Integer, Unit> f222lambda$1950837106 = ComposableLambdaKt.composableLambdaInstance(-1950837106, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt$$ExternalSyntheticLambda13
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PrivacyPolicyScreenKt.lambda__1950837106$lambda$9((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-165757632, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f219lambda$165757632 = ComposableLambdaKt.composableLambdaInstance(-165757632, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PrivacyPolicyScreenKt.lambda__165757632$lambda$10((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1556917021, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f218lambda$1556917021 = ComposableLambdaKt.composableLambdaInstance(-1556917021, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PrivacyPolicyScreenKt.lambda__1556917021$lambda$11((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$24288545 = ComposableLambdaKt.composableLambdaInstance(24288545, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PrivacyPolicyScreenKt.lambda_24288545$lambda$12((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<ColumnScope, Composer, Integer, Unit> lambda$1470464588 = ComposableLambdaKt.composableLambdaInstance(1470464588, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PrivacyPolicyScreenKt.lambda_1470464588$lambda$14((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1039423234, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f216lambda$1039423234 = ComposableLambdaKt.composableLambdaInstance(-1039423234, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PrivacyPolicyScreenKt.lambda__1039423234$lambda$15((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$463927489 = ComposableLambdaKt.composableLambdaInstance(463927489, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PrivacyPolicyScreenKt.lambda_463927489$lambda$18((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1913088836, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f221lambda$1913088836 = ComposableLambdaKt.composableLambdaInstance(-1913088836, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PrivacyPolicyScreenKt.lambda__1913088836$lambda$19((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-202437989, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f223lambda$202437989 = ComposableLambdaKt.composableLambdaInstance(-202437989, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PrivacyPolicyScreenKt.lambda__202437989$lambda$20((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1039423234$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7063getLambda$1039423234$app() {
        return f216lambda$1039423234;
    }

    /* renamed from: getLambda$-119648804$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7064getLambda$119648804$app() {
        return f217lambda$119648804;
    }

    /* renamed from: getLambda$-1556917021$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7065getLambda$1556917021$app() {
        return f218lambda$1556917021;
    }

    /* renamed from: getLambda$-165757632$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7066getLambda$165757632$app() {
        return f219lambda$165757632;
    }

    /* renamed from: getLambda$-1786536978$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7067getLambda$1786536978$app() {
        return f220lambda$1786536978;
    }

    /* renamed from: getLambda$-1913088836$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7068getLambda$1913088836$app() {
        return f221lambda$1913088836;
    }

    /* renamed from: getLambda$-1950837106$app, reason: not valid java name */
    public final Function3<ColumnScope, Composer, Integer, Unit> m7069getLambda$1950837106$app() {
        return f222lambda$1950837106;
    }

    /* renamed from: getLambda$-202437989$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7070getLambda$202437989$app() {
        return f223lambda$202437989;
    }

    /* renamed from: getLambda$-445815465$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7071getLambda$445815465$app() {
        return f224lambda$445815465;
    }

    public final Function3<ColumnScope, Composer, Integer, Unit> getLambda$1470464588$app() {
        return lambda$1470464588;
    }

    public final Function2<Composer, Integer, Unit> getLambda$232619229$app() {
        return lambda$232619229;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$24288545$app() {
        return lambda$24288545;
    }

    public final Function2<Composer, Integer, Unit> getLambda$289440889$app() {
        return lambda$289440889;
    }

    public final Function2<Composer, Integer, Unit> getLambda$463927489$app() {
        return lambda$463927489;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__119648804$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C185@9689L174:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-119648804, $changed, -1, "com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt.lambda$-119648804.<anonymous> (PrivacyPolicyScreen.kt:185)");
            }
            TextKt.m2693Text4IGK_g("Privacy Policy", (Modifier) null, Color.INSTANCE.m4196getWhite0d7_KjU(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 196998, 0, 131034);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_232619229$lambda$1(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C196@10122L214:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(232619229, $changed, -1, "com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt.lambda$232619229.<anonymous> (PrivacyPolicyScreen.kt:196)");
            }
            IconKt.m2150Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, Color.INSTANCE.m4196getWhite0d7_KjU(), $composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1786536978$lambda$2(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C215@11081L206:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1786536978, $changed, -1, "com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt.lambda$-1786536978.<anonymous> (PrivacyPolicyScreen.kt:215)");
            }
            IconKt.m2150Iconww6aTOc(ShareKt.getShare(Icons.INSTANCE.getDefault()), "Share Policy", (Modifier) null, Color.INSTANCE.m4196getWhite0d7_KjU(), $composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__445815465$lambda$3(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C235@11771L40:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-445815465, $changed, -1, "com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt.lambda$-445815465.<anonymous> (PrivacyPolicyScreen.kt:235)");
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
    public static final Unit lambda__165757632$lambda$10(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C242@12081L46,239@11893L2462:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-165757632, $changed, -1, "com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt.lambda$-165757632.<anonymous> (PrivacyPolicyScreen.kt:239)");
            }
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "privacy_hero_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(20)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(ColorKt.Color(4278603323L), 0L, 0L, 0L, $composer, (CardDefaults.$stable << 12) | 6, 14), null, null, f222lambda$1950837106, $composer, 196614, 24);
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
    public static final kotlin.Unit lambda__1950837106$lambda$9(androidx.compose.foundation.layout.ColumnScope r97, androidx.compose.runtime.Composer r98, int r99) {
        /*
            Method dump skipped, instructions count: 1272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt.lambda__1950837106$lambda$9(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda_289440889$lambda$5(androidx.compose.runtime.Composer r32, int r33) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt.lambda_289440889$lambda$5(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1556917021$lambda$11(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C322@16579L91,323@16703L39,324@16775L39:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1556917021, $changed, -1, "com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt.lambda$-1556917021.<anonymous> (PrivacyPolicyScreen.kt:322)");
            }
            IconKt.m2150Iconww6aTOc(ContentCopyKt.getContentCopy(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(6)), $composer, 6);
            TextKt.m2693Text4IGK_g("Copy Markdown", (Modifier) null, 0L, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3078, 0, 131062);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_24288545$lambda$12(RowScope OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C337@17626L84,338@17743L39,339@17815L35:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(24288545, $changed, -1, "com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt.lambda$24288545.<anonymous> (PrivacyPolicyScreen.kt:337)");
            }
            IconKt.m2150Iconww6aTOc(HtmlKt.getHtml(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(18)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(6)), $composer, 6);
            TextKt.m2693Text4IGK_g("Copy HTML", (Modifier) null, 0L, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3078, 0, 131062);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1039423234$lambda$15(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C351@18276L11,351@18234L74,348@18040L2296:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1039423234, $changed, -1, "com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt.lambda$-1039423234.<anonymous> (PrivacyPolicyScreen.kt:348)");
            }
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "privacy_highlights_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(18)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, lambda$1470464588, $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1470464588$lambda$14(ColumnScope Card, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C353@18349L1969:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1470464588, $changed, -1, "com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt.lambda$1470464588.<anonymous> (PrivacyPolicyScreen.kt:353)");
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
            ComposerKt.sourceInformationMarkerStart($composer, -90362454, "C356@18596L10,354@18469L233,360@18728L380,367@19134L369,374@19529L366,381@19921L375:PrivacyPolicyScreen.kt#2thlc2");
            TextKt.m2693Text4IGK_g("Privacy & Data Safety Highlights", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 196614, 0, 65502);
            PrivacyPolicyScreenKt.m7106PrivacyBulletPoint3IgeMak(StorageKt.getStorage(Icons.INSTANCE.getDefault()), ColorKt.Color(4282090230L), "Local SQLite Storage", "Your financial figures, bank accounts, and family assets are stored locally in private application sandbox memory.", $composer, 3504);
            PrivacyPolicyScreenKt.m7106PrivacyBulletPoint3IgeMak(VisibilityOffKt.getVisibilityOff(Icons.INSTANCE.getDefault()), ColorKt.Color(4287323382L), "No Trackers or Analytics", "No telemetry, behavioral analytics, or marketing tracking SDKs exist within this application.", $composer, 3504);
            PrivacyPolicyScreenKt.m7106PrivacyBulletPoint3IgeMak(LockKt.getLock(Icons.INSTANCE.getDefault()), ColorKt.Color(4279286145L), "Passcode Vault Protection", "App lock credentials are encrypted and verified exclusively on-device without remote auth servers.", $composer, 3504);
            PrivacyPolicyScreenKt.m7106PrivacyBulletPoint3IgeMak(DeleteForeverKt.getDeleteForever(Icons.INSTANCE.getDefault()), ColorKt.Color(4293870660L), "Instant Local Erasure", "You can wipe all data, reset credentials, or export JSON backups at any moment from the Settings menu.", $composer, 3504);
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
    public static final Unit lambda__1913088836$lambda$19(LazyItemScope item, Composer $composer, int $changed) {
        long m4157copywmQWz5c;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C422@21712L11,419@21550L1458:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1913088836, $changed, -1, "com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt.lambda$-1913088836.<anonymous> (PrivacyPolicyScreen.kt:419)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            RoundedCornerShape m953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(16));
            m4157copywmQWz5c = Color.m4157copywmQWz5c(r15, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(r15) : 0.5f, (r12 & 2) != 0 ? Color.m4165getRedimpl(r15) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(r15) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceVariant()) : 0.0f);
            SurfaceKt.m2543SurfaceT9BRK9s(fillMaxWidth$default, m953RoundedCornerShape0680j_4, m4157copywmQWz5c, 0L, 0.0f, 0.0f, null, lambda$463927489, $composer, 12582918, 120);
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
    public static final kotlin.Unit lambda_463927489$lambda$18(androidx.compose.runtime.Composer r71, int r72) {
        /*
            Method dump skipped, instructions count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt.lambda_463927489$lambda$18(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__202437989$lambda$20(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C451@23043L41:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-202437989, $changed, -1, "com.example.ui.screens.ComposableSingletons$PrivacyPolicyScreenKt.lambda$-202437989.<anonymous> (PrivacyPolicyScreen.kt:451)");
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
