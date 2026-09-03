package com.example.ui.screens;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AboutAppScreen.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"AboutAppScreen", "", "onBack", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "LicenseItem", "name", "", "license", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "app"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AboutAppScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AboutAppScreen$lambda$13(Function0 function0, int i, Composer composer, int i2) {
        AboutAppScreen(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LicenseItem$lambda$15(String str, String str2, int i, Composer composer, int i2) {
        LicenseItem(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AboutAppScreen(final Function0<Unit> onBack, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer $composer2 = $composer.startRestartGroup(192662934);
        ComposerKt.sourceInformation($composer2, "C(AboutAppScreen)53@2393L7,56@2433L909,82@3349L10514,55@2406L11457:AboutAppScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(onBack) ? 4 : 2;
        }
        if (($dirty & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(192662934, $dirty, -1, "com.example.ui.screens.AboutAppScreen (AboutAppScreen.kt:52)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Context context = (Context) consume;
            ScaffoldKt.m2408ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-1813243558, true, new Function2() { // from class: com.example.ui.screens.AboutAppScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AboutAppScreenKt.AboutAppScreen$lambda$1(Function0.this, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer2, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1402154139, true, new Function3() { // from class: com.example.ui.screens.AboutAppScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AboutAppScreenKt.AboutAppScreen$lambda$12(context, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer2, 54), $composer2, 805306416, 509);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.AboutAppScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AboutAppScreenKt.AboutAppScreen$lambda$13(Function0.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AboutAppScreen$lambda$1(final Function0 $onBack, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C65@2733L451,77@3229L89,57@2447L885:AboutAppScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1813243558, $changed, -1, "com.example.ui.screens.AboutAppScreen.<anonymous> (AboutAppScreen.kt:57)");
            }
            AppBarKt.m1774TopAppBarGHTll3U(ComposableSingletons$AboutAppScreenKt.INSTANCE.m7016getLambda$1946406890$app(), null, ComposableLambdaKt.rememberComposableLambda(1808130900, true, new Function2() { // from class: com.example.ui.screens.AboutAppScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AboutAppScreenKt.AboutAppScreen$lambda$1$lambda$0(Function0.this, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer, 54), null, 0.0f, null, TopAppBarDefaults.INSTANCE.m2864topAppBarColorszjMxDiM(ColorKt.Color(4279179050L), 0L, 0L, 0L, 0L, $composer, (TopAppBarDefaults.$stable << 15) | 6, 30), null, $composer, 390, 186);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AboutAppScreen$lambda$1$lambda$0(Function0 $onBack, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C66@2755L411:AboutAppScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1808130900, $changed, -1, "com.example.ui.screens.AboutAppScreen.<anonymous>.<anonymous> (AboutAppScreen.kt:66)");
            }
            IconButtonKt.IconButton($onBack, TestTagKt.testTag(Modifier.INSTANCE, "about_back_button"), false, null, null, ComposableSingletons$AboutAppScreenKt.INSTANCE.m7013getLambda$1082590121$app(), $composer, 196656, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AboutAppScreen$lambda$12(final Context $context, PaddingValues innerPadding, Composer $composer, int $changed) {
        Object obj;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "C89@3607L10250,83@3375L10482:AboutAppScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1402154139, $dirty2, -1, "com.example.ui.screens.AboutAppScreen.<anonymous> (AboutAppScreen.kt:83)");
            }
            Modifier m672paddingVpY3zN4$default = PaddingKt.m672paddingVpY3zN4$default(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), innerPadding), Dp.m6622constructorimpl(16), 0.0f, 2, null);
            Arrangement.HorizontalOrVertical m550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6622constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart($composer, 1149621871, "CC(remember):AboutAppScreen.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($context);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function1() { // from class: com.example.ui.screens.AboutAppScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return AboutAppScreenKt.AboutAppScreen$lambda$12$lambda$11$lambda$10($context, (LazyListScope) obj2);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyColumn(m672paddingVpY3zN4$default, null, null, false, m550spacedBy0680j_4, null, null, false, (Function1) obj, $composer, 24576, 238);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AboutAppScreen$lambda$12$lambda$11$lambda$10(final Context $context, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$AboutAppScreenKt.INSTANCE.getLambda$251680081$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$AboutAppScreenKt.INSTANCE.getLambda$725208186$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$AboutAppScreenKt.INSTANCE.getLambda$1907440921$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1205293640, true, new Function3() { // from class: com.example.ui.screens.AboutAppScreenKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AboutAppScreenKt.AboutAppScreen$lambda$12$lambda$11$lambda$10$lambda$9($context, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$AboutAppScreenKt.INSTANCE.m7017getLambda$23060905$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$AboutAppScreenKt.INSTANCE.getLambda$1159171830$app(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AboutAppScreen$lambda$12$lambda$11$lambda$10$lambda$9(final android.content.Context r38, androidx.compose.foundation.lazy.LazyItemScope r39, androidx.compose.runtime.Composer r40, int r41) {
        /*
            Method dump skipped, instructions count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AboutAppScreenKt.AboutAppScreen$lambda$12$lambda$11$lambda$10$lambda$9(android.content.Context, androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AboutAppScreen$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8$lambda$4$lambda$3(Context $context) {
        Intent shareIntent = new Intent("android.intent.action.SEND");
        shareIntent.setType("text/plain");
        shareIntent.putExtra("android.intent.extra.SUBJECT", "Net Worth Vault - Offline Portfolio Manager");
        shareIntent.putExtra("android.intent.extra.TEXT", "Track your family's net worth, bank accounts, stocks, mutual funds, and liabilities with 100% offline privacy using Net Worth Vault! Developed by Azaz Madkiya.");
        $context.startActivity(Intent.createChooser(shareIntent, "Share App"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AboutAppScreen$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6(Context $context) {
        Intent emailIntent = new Intent("android.intent.action.SENDTO");
        emailIntent.setData(Uri.parse("mailto:azazmadkiya@gmail.com"));
        emailIntent.putExtra("android.intent.extra.SUBJECT", "Net Worth Vault - Support & Feedback");
        try {
            $context.startActivity(emailIntent);
        } catch (Exception e) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LicenseItem(final String name, String license, Composer $composer, final int $changed) {
        Composer $composer2;
        final String str;
        Composer $composer3 = $composer.startRestartGroup(-1843018294);
        ComposerKt.sourceInformation($composer3, "C(LicenseItem)P(1)291@13940L305:AboutAppScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(name) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(license) ? 32 : 16;
        }
        if (($dirty & 19) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            str = license;
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1843018294, $dirty, -1, "com.example.ui.screens.LicenseItem (AboutAppScreen.kt:290)");
            }
            Modifier m672paddingVpY3zN4$default = PaddingKt.m672paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6622constructorimpl(4), 1, null);
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier($composer3, m672paddingVpY3zN4$default);
            Function0 constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((6 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer m3652constructorimpl = Updater.m3652constructorimpl($composer3);
            Updater.m3659setimpl(m3652constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3659setimpl(m3652constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3652constructorimpl.getInserting() || !Intrinsics.areEqual(m3652constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3652constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3652constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3659setimpl(m3652constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i3 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1909350798, "C292@14092L10,292@14018L96,293@14166L10,293@14210L11,293@14123L116:AboutAppScreen.kt#2thlc2");
            $composer2 = $composer3;
            TextKt.m2693Text4IGK_g(name, (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, ($dirty & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
            str = license;
            TextKt.m2693Text4IGK_g(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), $composer3, ($dirty >> 3) & 14, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.AboutAppScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AboutAppScreenKt.LicenseItem$lambda$15(name, str, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
