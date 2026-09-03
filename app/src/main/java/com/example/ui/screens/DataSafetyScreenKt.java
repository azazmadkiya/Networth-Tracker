package com.example.ui.screens;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataSafetyScreen.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a%\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"DataSafetyScreen", "", "onBack", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SafetyRow", "question", "", "answer", "isPositive", "", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)V", "app"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DataSafetyScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DataSafetyScreen$lambda$8(Function0 function0, int i, Composer composer, int i2) {
        DataSafetyScreen(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SafetyRow$lambda$12(String str, String str2, boolean z, int i, Composer composer, int i2) {
        SafetyRow(str, str2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DataSafetyScreen(final Function0<Unit> onBack, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer $composer2 = $composer.startRestartGroup(1006600134);
        ComposerKt.sourceInformation($composer2, "C(DataSafetyScreen)53@2349L7,76@3248L929,102@4184L7105,75@3221L8068:DataSafetyScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(onBack) ? 4 : 2;
        }
        if (($dirty & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1006600134, $dirty, -1, "com.example.ui.screens.DataSafetyScreen (DataSafetyScreen.kt:52)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Context context = (Context) consume;
            final String consoleSummaryText = "Google Play Console Data Safety Questionnaire Answers for Net Worth Tracker:\n\n1. Data Collection:\n- Does your app collect or share any user data? -> NO.\n- All user data (financial items, bank balances, notes) stays exclusively on the user's device (Offline SQLite/Room).\n\n2. Data Sharing:\n- Is any user data shared with other companies or organizations? -> NO.\n\n3. Security Practices:\n- Is data encrypted in transit? -> N/A (App does not transmit user data across the network).\n- Is data encrypted on-device? -> Protected by Android OS sandbox and user vault passcode.\n- Do you provide a way for users to request that their data is deleted? -> YES (In-app 'Delete All Data' button in Settings).\n\n4. Target Audience & Content:\n- Financial / Productivity app for ages 13+.\n- Zero advertising ID (AD_ID) usage.";
            ScaffoldKt.m2408ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(941377930, true, new Function2() { // from class: com.example.ui.screens.DataSafetyScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DataSafetyScreenKt.DataSafetyScreen$lambda$1(Function0.this, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer2, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1313539605, true, new Function3() { // from class: com.example.ui.screens.DataSafetyScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DataSafetyScreenKt.DataSafetyScreen$lambda$7(context, consoleSummaryText, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer2, 54), $composer2, 805306416, 509);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.DataSafetyScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DataSafetyScreenKt.DataSafetyScreen$lambda$8(Function0.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DataSafetyScreen$lambda$1(final Function0 $onBack, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C85@3562L457,97@4064L89,77@3262L905:DataSafetyScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(941377930, $changed, -1, "com.example.ui.screens.DataSafetyScreen.<anonymous> (DataSafetyScreen.kt:77)");
            }
            AppBarKt.m1774TopAppBarGHTll3U(ComposableSingletons$DataSafetyScreenKt.INSTANCE.m7038getLambda$393567674$app(), null, ComposableLambdaKt.rememberComposableLambda(-1716746620, true, new Function2() { // from class: com.example.ui.screens.DataSafetyScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DataSafetyScreenKt.DataSafetyScreen$lambda$1$lambda$0(Function0.this, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer, 54), null, 0.0f, null, TopAppBarDefaults.INSTANCE.m2864topAppBarColorszjMxDiM(ColorKt.Color(4279179050L), 0L, 0L, 0L, 0L, $composer, (TopAppBarDefaults.$stable << 15) | 6, 30), null, $composer, 390, 186);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DataSafetyScreen$lambda$1$lambda$0(Function0 $onBack, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C86@3584L417:DataSafetyScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1716746620, $changed, -1, "com.example.ui.screens.DataSafetyScreen.<anonymous>.<anonymous> (DataSafetyScreen.kt:86)");
            }
            IconButtonKt.IconButton($onBack, TestTagKt.testTag(Modifier.INSTANCE, "data_safety_back_button"), false, null, null, ComposableSingletons$DataSafetyScreenKt.INSTANCE.getLambda$1012229639$app(), $composer, 196656, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DataSafetyScreen$lambda$7(final Context $context, final String $consoleSummaryText, PaddingValues innerPadding, Composer $composer, int $changed) {
        Object obj;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "C109@4442L6841,103@4210L7073:DataSafetyScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1313539605, $dirty2, -1, "com.example.ui.screens.DataSafetyScreen.<anonymous> (DataSafetyScreen.kt:103)");
            }
            Modifier m672paddingVpY3zN4$default = PaddingKt.m672paddingVpY3zN4$default(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), innerPadding), Dp.m6622constructorimpl(16), 0.0f, 2, null);
            Arrangement.HorizontalOrVertical m550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6622constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart($composer, -408809522, "CC(remember):DataSafetyScreen.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($context) | $composer.changed($consoleSummaryText);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function1() { // from class: com.example.ui.screens.DataSafetyScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return DataSafetyScreenKt.DataSafetyScreen$lambda$7$lambda$6$lambda$5($context, $consoleSummaryText, (LazyListScope) obj2);
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
    public static final Unit DataSafetyScreen$lambda$7$lambda$6$lambda$5(final Context $context, final String $consoleSummaryText, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$DataSafetyScreenKt.INSTANCE.getLambda$1446228481$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$DataSafetyScreenKt.INSTANCE.getLambda$1025207466$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1558481463, true, new Function3() { // from class: com.example.ui.screens.DataSafetyScreenKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DataSafetyScreenKt.DataSafetyScreen$lambda$7$lambda$6$lambda$5$lambda$4($context, $consoleSummaryText, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$DataSafetyScreenKt.INSTANCE.getLambda$152796904$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$DataSafetyScreenKt.INSTANCE.getLambda$1864075271$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$DataSafetyScreenKt.INSTANCE.m7040getLambda$719613658$app(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DataSafetyScreen$lambda$7$lambda$6$lambda$5$lambda$4(final Context $context, final String $consoleSummaryText, LazyItemScope item, Composer $composer, int $changed) {
        Object obj;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C161@6895L408,160@6857L875:DataSafetyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1558481463, $changed, -1, "com.example.ui.screens.DataSafetyScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DataSafetyScreen.kt:160)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1242902561, "CC(remember):DataSafetyScreen.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($context) | $composer.changed($consoleSummaryText);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.DataSafetyScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DataSafetyScreenKt.DataSafetyScreen$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3$lambda$2($context, $consoleSummaryText);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "btn_copy_data_safety_answers"), false, RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(12)), null, null, null, null, null, ComposableSingletons$DataSafetyScreenKt.INSTANCE.m7037getLambda$1570167847$app(), $composer, 805306416, 500);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DataSafetyScreen$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3$lambda$2(Context $context, String $consoleSummaryText) {
        Object systemService = $context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboard = (ClipboardManager) systemService;
        ClipData clip = ClipData.newPlainText("PlayConsoleAnswers", $consoleSummaryText);
        clipboard.setPrimaryClip(clip);
        Toast.makeText($context, "Copied Play Console Data Safety Answers!", 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SafetyRow(final String question, final String answer, final boolean isPositive, Composer $composer, final int $changed) {
        long m4157copywmQWz5c;
        long m4157copywmQWz5c2;
        Composer $composer2 = $composer.startRestartGroup(-268126286);
        ComposerKt.sourceInformation($composer2, "C(SafetyRow)P(2)259@11776L933,254@11402L1307:DataSafetyScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(question) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(answer) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(isPositive) ? 256 : 128;
        }
        if (($dirty & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-268126286, $dirty, -1, "com.example.ui.screens.SafetyRow (DataSafetyScreen.kt:253)");
            }
            RoundedCornerShape m953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(12));
            m4157copywmQWz5c = Color.m4157copywmQWz5c(r16, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(r16) : 0.1f, (r12 & 2) != 0 ? Color.m4165getRedimpl(r16) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(r16) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(isPositive ? ColorKt.Color(4279286145L) : ColorKt.Color(4293870660L)) : 0.0f);
            float m6622constructorimpl = Dp.m6622constructorimpl(1);
            m4157copywmQWz5c2 = Color.m4157copywmQWz5c(r16, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(r16) : 0.3f, (r12 & 2) != 0 ? Color.m4165getRedimpl(r16) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(r16) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(isPositive ? ColorKt.Color(4279286145L) : ColorKt.Color(4293870660L)) : 0.0f);
            SurfaceKt.m2543SurfaceT9BRK9s(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), m953RoundedCornerShape0680j_4, m4157copywmQWz5c, 0L, 0.0f, 0.0f, BorderStrokeKt.m252BorderStrokecXLIe8U(m6622constructorimpl, m4157copywmQWz5c2), ComposableLambdaKt.rememberComposableLambda(620270775, true, new Function2() { // from class: com.example.ui.screens.DataSafetyScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DataSafetyScreenKt.SafetyRow$lambda$11(isPositive, question, answer, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer2, 54), $composer2, 12582918, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.DataSafetyScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DataSafetyScreenKt.SafetyRow$lambda$12(question, answer, isPositive, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SafetyRow$lambda$11(boolean r73, java.lang.String r74, java.lang.String r75, androidx.compose.runtime.Composer r76, int r77) {
        /*
            Method dump skipped, instructions count: 923
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.DataSafetyScreenKt.SafetyRow$lambda$11(boolean, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }
}
