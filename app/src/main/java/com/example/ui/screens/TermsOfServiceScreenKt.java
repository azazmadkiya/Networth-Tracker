package com.example.ui.screens;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SurfaceKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TermsOfServiceScreen.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a/\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"TermsOfServiceScreen", "", "onBack", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "TermsItem", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "iconTint", "Landroidx/compose/ui/graphics/Color;", "title", "", "desc", "TermsItem-3IgeMak", "(Landroidx/compose/ui/graphics/vector/ImageVector;JLjava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "app"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TermsOfServiceScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TermsItem_3IgeMak$lambda$20(ImageVector imageVector, long j, String str, String str2, int i, Composer composer, int i2) {
        m7109TermsItem3IgeMak(imageVector, j, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TermsOfServiceScreen$lambda$15(Function0 function0, int i, Composer composer, int i2) {
        TermsOfServiceScreen(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void TermsOfServiceScreen(final Function0<Unit> onBack, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer $composer2 = $composer.startRestartGroup(531709328);
        ComposerKt.sourceInformation($composer2, "C(TermsOfServiceScreen)56@2488L7,101@5080L1835,146@6922L8382,100@5053L10251:TermsOfServiceScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(onBack) ? 4 : 2;
        }
        if (($dirty & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(531709328, $dirty, -1, "com.example.ui.screens.TermsOfServiceScreen (TermsOfServiceScreen.kt:55)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Context context = (Context) consume;
            final String termsText = "# Terms and Conditions & Financial Disclaimer\n\n**Effective Date:** August 24, 2026\n**Application:** Net Worth Tracker / Net Worth Vault\n**Developer:** Azaz Madkiya (azazmadkiya@gmail.com)\n\n## 1. Acceptance of Terms\nBy downloading, installing, accessing, or using the Net Worth Tracker mobile application (\"the Application\"), you agree to be bound by these Terms and Conditions (\"Terms\"). If you do not agree with any portion of these Terms, please do not use the Application.\n\n---\n\n## 2. Financial Disclaimer — Not Financial, Investment, or Tax Advice\n- **Personal Bookkeeping Tool Only:** Net Worth Tracker is designed strictly as a self-custody personal financial tracking, calculation, and ledger management utility.\n- **No Financial Advisory Services:** The Application, its developer, and its algorithms do NOT provide certified financial advice, investment recommendations, wealth management counseling, or legal/tax advisory services.\n- **Manual Input & Accuracy:** All financial calculations, net worth aggregates, profit/loss figures, and double-entry ledger summaries depend on data entered or imported by you. The developer is not liable for data entry inaccuracies or calculation discrepancies.\n\n---\n\n## 3. User Responsibility & Data Backup\n- **100% Offline Storage:** All records are stored locally on your device in an offline SQLite database. The developer does not host your data on cloud servers and cannot recover lost data if you misplace your device or uninstall the app without backing up.\n- **Backup Responsibility:** You are solely responsible for creating regular offline JSON backups via the app's backup export utility and securing those backup files in your preferred cloud or local drive.\n- **Passcode & Vault Security:** You are responsible for remembering your vault passcode.\n\n---\n\n## 4. Intellectual Property\nAll software code, graphic designs, interfaces, and algorithms in Net Worth Tracker are the intellectual property of developer Azaz Madkiya, protected by copyright and intellectual property laws.\n\n---\n\n## 5. Limitation of Liability\nTo the maximum extent permitted by applicable law, in no event shall the developer be liable for any direct, indirect, incidental, special, consequential, or punitive damages arising from the use of, or inability to use, the Application.\n\n---\n\n## 6. Governing Law & Contact\nThese Terms are governed by applicable laws. For inquiries regarding these terms, please contact:\n- **Developer:** Azaz Madkiya\n- **Email:** azazmadkiya@gmail.com";
            ScaffoldKt.m2408ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(2136605524, true, new Function2() { // from class: com.example.ui.screens.TermsOfServiceScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TermsOfServiceScreenKt.TermsOfServiceScreen$lambda$5(Function0.this, termsText, context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer2, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1244988639, true, new Function3() { // from class: com.example.ui.screens.TermsOfServiceScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TermsOfServiceScreenKt.TermsOfServiceScreen$lambda$14(context, termsText, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer2, 54), $composer2, 805306416, 509);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.TermsOfServiceScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TermsOfServiceScreenKt.TermsOfServiceScreen$lambda$15(Function0.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TermsOfServiceScreen$lambda$5(final Function0 $onBack, final String $termsText, final Context $context, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C110@5380L451,122@5859L898,141@6802L89,102@5094L1811:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2136605524, $changed, -1, "com.example.ui.screens.TermsOfServiceScreen.<anonymous> (TermsOfServiceScreen.kt:102)");
            }
            AppBarKt.m1774TopAppBarGHTll3U(ComposableSingletons$TermsOfServiceScreenKt.INSTANCE.getLambda$1244782608$app(), null, ComposableLambdaKt.rememberComposableLambda(633513550, true, new Function2() { // from class: com.example.ui.screens.TermsOfServiceScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TermsOfServiceScreenKt.TermsOfServiceScreen$lambda$5$lambda$0(Function0.this, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer, 54), ComposableLambdaKt.rememberComposableLambda(-1513866555, true, new Function3() { // from class: com.example.ui.screens.TermsOfServiceScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TermsOfServiceScreenKt.TermsOfServiceScreen$lambda$5$lambda$4($termsText, $context, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), 0.0f, null, TopAppBarDefaults.INSTANCE.m2864topAppBarColorszjMxDiM(ColorKt.Color(4279179050L), 0L, 0L, 0L, 0L, $composer, (TopAppBarDefaults.$stable << 15) | 6, 30), null, $composer, 3462, 178);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TermsOfServiceScreen$lambda$5$lambda$0(Function0 $onBack, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C111@5402L411:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(633513550, $changed, -1, "com.example.ui.screens.TermsOfServiceScreen.<anonymous>.<anonymous> (TermsOfServiceScreen.kt:111)");
            }
            IconButtonKt.IconButton($onBack, TestTagKt.testTag(Modifier.INSTANCE, "terms_back_button"), false, null, null, ComposableSingletons$TermsOfServiceScreenKt.INSTANCE.getLambda$471945937$app(), $composer, 196656, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TermsOfServiceScreen$lambda$5$lambda$4(final String $termsText, final Context $context, RowScope TopAppBar, Composer $composer, int $changed) {
        Object obj;
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        ComposerKt.sourceInformation($composer, "C124@5927L464,123@5881L858:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1513866555, $changed, -1, "com.example.ui.screens.TermsOfServiceScreen.<anonymous>.<anonymous> (TermsOfServiceScreen.kt:123)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1168156629, "CC(remember):TermsOfServiceScreen.kt#9igjgp");
            boolean changed = $composer.changed($termsText) | $composer.changedInstance($context);
            Object rememberedValue = $composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.TermsOfServiceScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TermsOfServiceScreenKt.TermsOfServiceScreen$lambda$5$lambda$4$lambda$3$lambda$2($context, $termsText);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton((Function0) obj, TestTagKt.testTag(Modifier.INSTANCE, "btn_share_terms"), false, null, null, ComposableSingletons$TermsOfServiceScreenKt.INSTANCE.getLambda$1388048802$app(), $composer, 196656, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TermsOfServiceScreen$lambda$5$lambda$4$lambda$3$lambda$2(Context $context, String $termsText) {
        Intent shareIntent = new Intent("android.intent.action.SEND");
        shareIntent.setType("text/plain");
        shareIntent.putExtra("android.intent.extra.SUBJECT", "Terms of Service - Net Worth Tracker");
        shareIntent.putExtra("android.intent.extra.TEXT", $termsText);
        $context.startActivity(Intent.createChooser(shareIntent, "Share Terms"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TermsOfServiceScreen$lambda$14(final Context $context, final String $termsText, PaddingValues innerPadding, Composer $composer, int $changed) {
        Object obj;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "C153@7180L8118,147@6948L8350:TermsOfServiceScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1244988639, $dirty2, -1, "com.example.ui.screens.TermsOfServiceScreen.<anonymous> (TermsOfServiceScreen.kt:147)");
            }
            Modifier m672paddingVpY3zN4$default = PaddingKt.m672paddingVpY3zN4$default(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), innerPadding), Dp.m6622constructorimpl(16), 0.0f, 2, null);
            Arrangement.HorizontalOrVertical m550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6622constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart($composer, -1861777131, "CC(remember):TermsOfServiceScreen.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($context) | $composer.changed($termsText);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function1() { // from class: com.example.ui.screens.TermsOfServiceScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TermsOfServiceScreenKt.TermsOfServiceScreen$lambda$14$lambda$13$lambda$12($context, $termsText, (LazyListScope) obj2);
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
    public static final Unit TermsOfServiceScreen$lambda$14$lambda$13$lambda$12(final Context $context, final String $termsText, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$TermsOfServiceScreenKt.INSTANCE.getLambda$1331233995$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$TermsOfServiceScreenKt.INSTANCE.m7101getLambda$116128140$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$TermsOfServiceScreenKt.INSTANCE.m7100getLambda$1153138541$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(2104818354, true, new Function3() { // from class: com.example.ui.screens.TermsOfServiceScreenKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TermsOfServiceScreenKt.TermsOfServiceScreen$lambda$14$lambda$13$lambda$12$lambda$8($context, $termsText, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1067807953, true, new Function3() { // from class: com.example.ui.screens.TermsOfServiceScreenKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TermsOfServiceScreenKt.TermsOfServiceScreen$lambda$14$lambda$13$lambda$12$lambda$11($termsText, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$TermsOfServiceScreenKt.INSTANCE.getLambda$30797552$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$TermsOfServiceScreenKt.INSTANCE.m7099getLambda$1006212849$app(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TermsOfServiceScreen$lambda$14$lambda$13$lambda$12$lambda$8(final Context $context, final String $termsText, LazyItemScope item, Composer $composer, int $changed) {
        Object obj;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C248@11787L392,247@11749L837:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2104818354, $changed, -1, "com.example.ui.screens.TermsOfServiceScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TermsOfServiceScreen.kt:247)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -199156038, "CC(remember):TermsOfServiceScreen.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($context) | $composer.changed($termsText);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.TermsOfServiceScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TermsOfServiceScreenKt.TermsOfServiceScreen$lambda$14$lambda$13$lambda$12$lambda$8$lambda$7$lambda$6($context, $termsText);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "btn_copy_terms"), false, RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(12)), null, null, null, null, null, ComposableSingletons$TermsOfServiceScreenKt.INSTANCE.m7102getLambda$1485072190$app(), $composer, 805306416, 500);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TermsOfServiceScreen$lambda$14$lambda$13$lambda$12$lambda$8$lambda$7$lambda$6(Context $context, String $termsText) {
        Object systemService = $context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboard = (ClipboardManager) systemService;
        ClipData clip = ClipData.newPlainText("TermsOfService", $termsText);
        clipboard.setPrimaryClip(clip);
        Toast.makeText($context, "Copied Terms of Service to Clipboard!", 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TermsOfServiceScreen$lambda$14$lambda$13$lambda$12$lambda$11(final String $termsText, LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C268@12869L11,268@12827L74,269@12920L742,265@12668L994:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1067807953, $changed, -1, "com.example.ui.screens.TermsOfServiceScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TermsOfServiceScreen.kt:265)");
            }
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(18)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-701615457, true, new Function3() { // from class: com.example.ui.screens.TermsOfServiceScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TermsOfServiceScreenKt.TermsOfServiceScreen$lambda$14$lambda$13$lambda$12$lambda$11$lambda$10($termsText, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TermsOfServiceScreen$lambda$14$lambda$13$lambda$12$lambda$11$lambda$10(String $termsText, ColumnScope Card, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C270@12942L702:TermsOfServiceScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-701615457, $changed, -1, "com.example.ui.screens.TermsOfServiceScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TermsOfServiceScreen.kt:270)");
            }
            Modifier m670padding3ABfNKs = PaddingKt.m670padding3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16));
            Arrangement.Vertical m550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6622constructorimpl(12));
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
            ComposerKt.sourceInformationMarkerStart($composer, 775494026, "C273@13176L10,271@13062L220,277@13308L19,281@13455L10,283@13575L11,279@13353L269:TermsOfServiceScreen.kt#2thlc2");
            TextKt.m2693Text4IGK_g("Full Agreement Text", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 196614, 0, 65502);
            DividerKt.m2072HorizontalDivider9IZ8Weo(null, 0.0f, 0L, $composer, 0, 7);
            TextKt.m2693Text4IGK_g($termsText, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(20), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 0, 6, 64506);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TermsItem-3IgeMak, reason: not valid java name */
    public static final void m7109TermsItem3IgeMak(final ImageVector icon, final long iconTint, final String title, final String desc, Composer $composer, final int $changed) {
        Composer $composer2;
        long m4157copywmQWz5c;
        Function0 function0;
        Composer $composer3 = $composer.startRestartGroup(-1324980936);
        ComposerKt.sourceInformation($composer3, "C(TermsItem)P(1,2:c#ui.graphics.Color,3)335@15467L930:TermsOfServiceScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(icon) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(iconTint) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(title) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(desc) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1324980936, $dirty2, -1, "com.example.ui.screens.TermsItem (TermsOfServiceScreen.kt:334)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical top = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), top, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier($composer3, fillMaxWidth$default);
            Function0 constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((390 << 3) & 112) << 6) & 896) | 6;
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
            Updater.m3659setimpl(m3652constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3659setimpl(m3652constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3652constructorimpl.getInserting() || !Intrinsics.areEqual(m3652constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3652constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3652constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3659setimpl(m3652constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i3 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1727830050, "C343@15734L198,339@15574L358,348@15941L40,349@15990L401:TermsOfServiceScreen.kt#2thlc2");
            RoundedCornerShape m953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(10));
            $composer2 = $composer3;
            m4157copywmQWz5c = Color.m4157copywmQWz5c(iconTint, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(iconTint) : 0.15f, (r12 & 2) != 0 ? Color.m4165getRedimpl(iconTint) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(iconTint) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(iconTint) : 0.0f);
            SurfaceKt.m2543SurfaceT9BRK9s(SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(36)), m953RoundedCornerShape0680j_4, m4157copywmQWz5c, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1488441127, true, new Function2() { // from class: com.example.ui.screens.TermsOfServiceScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TermsOfServiceScreenKt.TermsItem_3IgeMak$lambda$19$lambda$17(ImageVector.this, iconTint, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer3, 54), $composer3, 12582918, 120);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(12)), $composer3, 6);
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier modifier = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier($composer3, modifier);
            Function0 constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int i4 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function0 = constructor2;
                $composer3.createNode(function0);
            } else {
                function0 = constructor2;
                $composer3.useNode();
            }
            Composer m3652constructorimpl2 = Updater.m3652constructorimpl($composer3);
            Updater.m3659setimpl(m3652constructorimpl2, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3659setimpl(m3652constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3652constructorimpl2.getInserting() || !Intrinsics.areEqual(m3652constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3652constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3652constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3659setimpl(m3652constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            int i5 = (i4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -954624717, "C350@16052L10,350@16011L93,351@16117L40,354@16243L10,355@16303L11,352@16170L211:TermsOfServiceScreen.kt#2thlc2");
            TextKt.m2693Text4IGK_g(title, (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, (($dirty2 >> 6) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(2)), $composer3, 6);
            TextKt.m2693Text4IGK_g(desc, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(16), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), $composer3, ($dirty2 >> 9) & 14, 6, 64506);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.TermsOfServiceScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TermsOfServiceScreenKt.TermsItem_3IgeMak$lambda$20(ImageVector.this, iconTint, title, desc, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit TermsItem_3IgeMak$lambda$19$lambda$17(androidx.compose.ui.graphics.vector.ImageVector r32, long r33, androidx.compose.runtime.Composer r35, int r36) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.TermsOfServiceScreenKt.TermsItem_3IgeMak$lambda$19$lambda$17(androidx.compose.ui.graphics.vector.ImageVector, long, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }
}
