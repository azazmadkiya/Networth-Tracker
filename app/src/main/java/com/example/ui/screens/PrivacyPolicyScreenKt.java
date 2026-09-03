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

/* compiled from: PrivacyPolicyScreen.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a/\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"PrivacyPolicyScreen", "", "onBack", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "PrivacyBulletPoint", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "iconTint", "Landroidx/compose/ui/graphics/Color;", "title", "", "description", "PrivacyBulletPoint-3IgeMak", "(Landroidx/compose/ui/graphics/vector/ImageVector;JLjava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "app"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PrivacyPolicyScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrivacyBulletPoint_3IgeMak$lambda$25(ImageVector imageVector, long j, String str, String str2, int i, Composer composer, int i2) {
        m7106PrivacyBulletPoint3IgeMak(imageVector, j, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrivacyPolicyScreen$lambda$20(Function0 function0, int i, Composer composer, int i2) {
        PrivacyPolicyScreen(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PrivacyPolicyScreen(final Function0<Unit> onBack, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer $composer2 = $composer.startRestartGroup(429329244);
        ComposerKt.sourceInformation($composer2, "C(PrivacyPolicyScreen)61@2742L7,182@9618L1867,227@11492L11610,181@9591L13511:PrivacyPolicyScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(onBack) ? 4 : 2;
        }
        if (($dirty & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(429329244, $dirty, -1, "com.example.ui.screens.PrivacyPolicyScreen (PrivacyPolicyScreen.kt:60)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Context context = (Context) consume;
            final String privacyPolicyText = "# Privacy Policy for Net Worth Tracker / Net Worth Vault\n\n**Effective Date:** August 24, 2026\n**Last Updated:** August 24, 2026\n**Developer:** Azaz Madkiya (azazmadkiya@gmail.com)\n\n## 1. Introduction & Core Privacy Commitment\nNet Worth Tracker (\"the Application\") is an offline-first personal finance, asset tracking, and double-entry ledger tool designed to empower individuals and families to monitor assets, bank balances, mutual funds, gold, real estate, and liabilities securely.\n\n**Your privacy is our utmost priority.** Unlike traditional financial apps, Net Worth Tracker operates on a **100% offline, zero-tracking model**. We do not collect, transmit, monetize, sell, or share any of your personal financial numbers with remote cloud servers or third parties.\n\n---\n\n## 2. Information Handled by the Application\nAll data you input into the application remains exclusively on your physical Android device:\n- **Financial Account Records:** Bank account names, institutions, account/folio identifiers, and current/invested values.\n- **Family Profiles:** Allocations labeled under Self, Father, Mother, or Family Joint.\n- **Double-Entry Ledger:** Transaction notes, income deposits, expense outflows, and running balances.\n- **Local Security Passcode:** Hashed locally on your device for vault authentication.\n\n---\n\n## 3. Data Storage & Security\n- **Local SQLite / Room Database:** All financial records are stored locally inside the application's secure private sandbox directory (`/data/data/com.example/databases/`).\n- **Zero Cloud Servers:** We do not operate user accounts on remote servers, backend APIs, or external storage buckets.\n- **Vault Passcode Protection:** Access to the application is protected by a local offline passcode configured by you.\n\n---\n\n## 4. Device Permissions Explained\n- **Storage / File Access (Storage Access Framework / MediaStore):** Used strictly on your request when you tap \"Export Backup\" to save a JSON backup file to your phone's File Manager / Downloads, or when you tap \"Restore Backup\" to import your own backup file.\n- **Zero Internet Obligation:** The core app functions fully without requiring any internet connection.\n\n---\n\n## 5. Third-Party Services & Trackers\n- **No Third-Party Analytics:** We do NOT integrate Google Analytics for Firebase, Mixpanel, Adjust, or any behavior tracking SDKs.\n- **No Advertising Networks:** We do NOT display banner ads, interstitial ads, or track user ad identifiers (AD_ID).\n- **No Data Selling / Sharing:** Your financial numbers are never sold, rented, or shared with financial institutions, advertisers, or third-party data brokers.\n\n---\n\n## 6. User Rights & Data Deletion (Right to Erasure)\nUnder GDPR, CCPA, and Google Play Data Safety policies, you retain complete sovereignty over your data:\n- **Data Export:** You can export all your financial records to a human-readable JSON backup file at any time via Settings > Offline Data Backup.\n- **Permanent Data Deletion:** You can permanently wipe all accounts, transactions, ledger history, and security credentials directly from the app via Settings > Danger Zone > Delete All Financial Data. Uninstalling the app also permanently removes all local databases from the device.\n\n---\n\n## 7. Children's Privacy\nNet Worth Tracker is designed for general audiences and personal financial bookkeeping. It does not knowingly collect or solicit information from children under the age of 13.\n\n---\n\n## 8. Changes to this Privacy Policy\nWe may update this Privacy Policy periodically to reflect new features or regulatory requirements. Any updates will be reflected inside the app with an updated effective date.\n\n---\n\n## 9. Contact & Developer Information\nIf you have any questions, feedback, or inquiries regarding this Privacy Policy, please contact:\n- **Developer:** Azaz Madkiya\n- **Email:** azazmadkiya@gmail.com\n- **App:** Net Worth Tracker / Net Worth Vault";
            final String privacyPolicyHtml = "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Privacy Policy - Net Worth Tracker</title>\n    <style>\n        body { font-family: -apple-system, BlinkMacSystemFont, \"Segoe UI\", Roboto, Helvetica, Arial, sans-serif; line-height: 1.6; color: #1e293b; max-width: 800px; margin: 0 auto; padding: 24px; background: #f8fafc; }\n        .container { background: #ffffff; padding: 36px; border-radius: 16px; box-shadow: 0 4px 12px rgba(0,0,0,0.05); }\n        h1 { color: #0f172a; border-bottom: 2px solid #e2e8f0; padding-bottom: 12px; }\n        h2 { color: #1e40af; margin-top: 28px; }\n        .badge { display: inline-block; background: #10b981; color: white; padding: 4px 12px; border-radius: 20px; font-weight: bold; font-size: 14px; margin-bottom: 16px; }\n        .highlight-box { background: #ecfdf5; border-left: 4px solid #10b981; padding: 16px; border-radius: 8px; margin: 20px 0; }\n        footer { margin-top: 40px; padding-top: 20px; border-top: 1px solid #e2e8f0; font-size: 14px; color: #64748b; }\n    </style>\n</head>\n<body>\n    <div class=\"container\">\n        <span class=\"badge\">100% Offline & Private</span>\n        <h1>Privacy Policy for Net Worth Tracker</h1>\n        <p><strong>Effective Date:</strong> August 24, 2026<br>\n        <strong>Developer:</strong> Azaz Madkiya (<a href=\"mailto:azazmadkiya@gmail.com\">azazmadkiya@gmail.com</a>)</p>\n\n        <div class=\"highlight-box\">\n            <strong>Key Summary:</strong> Net Worth Tracker does NOT collect, store, or transmit your financial data, account numbers, or balances to any external servers. Everything is stored 100% locally on your device.\n        </div>\n\n        <h2>1. Core Privacy Commitment</h2>\n        <p>Net Worth Tracker (\"the Application\") is an offline-first personal financial ledger designed to help users track assets, bank balances, mutual funds, gold, and liabilities safely.</p>\n\n        <h2>2. Data Collection & Processing</h2>\n        <p>All data entered into the application remains solely on your physical device in an encrypted/private SQLite database. We do NOT operate remote databases or user tracking servers.</p>\n\n        <h2>3. Permissions</h2>\n        <p>File Manager permissions are requested only when you choose to export or import your personal JSON backup files.</p>\n\n        <h2>4. Data Deletion (Right to Erasure)</h2>\n        <p>You can completely delete all stored records anytime using the in-app \"Delete All Data\" button or by uninstalling the application.</p>\n\n        <h2>5. Contact Information</h2>\n        <p>For questions or support, contact: <strong>azazmadkiya@gmail.com</strong></p>\n\n        <footer>\n            &copy; 2026 Net Worth Tracker. All rights reserved.\n        </footer>\n    </div>\n</body>\n</html>";
            ScaffoldKt.m2408ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-713133536, true, new Function2() { // from class: com.example.ui.screens.PrivacyPolicyScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PrivacyPolicyScreenKt.PrivacyPolicyScreen$lambda$5(Function0.this, privacyPolicyText, context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer2, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-575514005, true, new Function3() { // from class: com.example.ui.screens.PrivacyPolicyScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PrivacyPolicyScreenKt.PrivacyPolicyScreen$lambda$19(context, privacyPolicyText, privacyPolicyHtml, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer2, 54), $composer2, 805306416, 509);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.PrivacyPolicyScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PrivacyPolicyScreenKt.PrivacyPolicyScreen$lambda$20(Function0.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrivacyPolicyScreen$lambda$5(final Function0 $onBack, final String $privacyPolicyText, final Context $context, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C191@9916L460,203@10404L923,222@11372L89,183@9632L1843:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-713133536, $changed, -1, "com.example.ui.screens.PrivacyPolicyScreen.<anonymous> (PrivacyPolicyScreen.kt:183)");
            }
            AppBarKt.m1774TopAppBarGHTll3U(ComposableSingletons$PrivacyPolicyScreenKt.INSTANCE.m7064getLambda$119648804$app(), null, ComposableLambdaKt.rememberComposableLambda(1774685082, true, new Function2() { // from class: com.example.ui.screens.PrivacyPolicyScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PrivacyPolicyScreenKt.PrivacyPolicyScreen$lambda$5$lambda$0(Function0.this, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer, 54), ComposableLambdaKt.rememberComposableLambda(1598149073, true, new Function3() { // from class: com.example.ui.screens.PrivacyPolicyScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PrivacyPolicyScreenKt.PrivacyPolicyScreen$lambda$5$lambda$4($privacyPolicyText, $context, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), 0.0f, null, TopAppBarDefaults.INSTANCE.m2864topAppBarColorszjMxDiM(ColorKt.Color(4279179050L), 0L, 0L, 0L, 0L, $composer, (TopAppBarDefaults.$stable << 15) | 6, 30), null, $composer, 3462, 178);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrivacyPolicyScreen$lambda$5$lambda$0(Function0 $onBack, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C192@9938L420:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1774685082, $changed, -1, "com.example.ui.screens.PrivacyPolicyScreen.<anonymous>.<anonymous> (PrivacyPolicyScreen.kt:192)");
            }
            IconButtonKt.IconButton($onBack, TestTagKt.testTag(Modifier.INSTANCE, "privacy_policy_back_button"), false, null, null, ComposableSingletons$PrivacyPolicyScreenKt.INSTANCE.getLambda$232619229$app(), $composer, 196656, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrivacyPolicyScreen$lambda$5$lambda$4(final String $privacyPolicyText, final Context $context, RowScope TopAppBar, Composer $composer, int $changed) {
        Object obj;
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        ComposerKt.sourceInformation($composer, "C205@10472L479,204@10426L883:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1598149073, $changed, -1, "com.example.ui.screens.PrivacyPolicyScreen.<anonymous>.<anonymous> (PrivacyPolicyScreen.kt:204)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1777030160, "CC(remember):PrivacyPolicyScreen.kt#9igjgp");
            boolean changed = $composer.changed($privacyPolicyText) | $composer.changedInstance($context);
            Object rememberedValue = $composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.PrivacyPolicyScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PrivacyPolicyScreenKt.PrivacyPolicyScreen$lambda$5$lambda$4$lambda$3$lambda$2($context, $privacyPolicyText);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton((Function0) obj, TestTagKt.testTag(Modifier.INSTANCE, "btn_share_privacy_policy"), false, null, null, ComposableSingletons$PrivacyPolicyScreenKt.INSTANCE.m7067getLambda$1786536978$app(), $composer, 196656, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrivacyPolicyScreen$lambda$5$lambda$4$lambda$3$lambda$2(Context $context, String $privacyPolicyText) {
        Intent shareIntent = new Intent("android.intent.action.SEND");
        shareIntent.setType("text/plain");
        shareIntent.putExtra("android.intent.extra.SUBJECT", "Privacy Policy - Net Worth Tracker");
        shareIntent.putExtra("android.intent.extra.TEXT", $privacyPolicyText);
        $context.startActivity(Intent.createChooser(shareIntent, "Share Privacy Policy"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrivacyPolicyScreen$lambda$19(final Context $context, final String $privacyPolicyText, final String $privacyPolicyHtml, PaddingValues innerPadding, Composer $composer, int $changed) {
        Object obj;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "C234@11750L11346,228@11518L11578:PrivacyPolicyScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        if (($dirty & 19) == 18 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-575514005, $dirty, -1, "com.example.ui.screens.PrivacyPolicyScreen.<anonymous> (PrivacyPolicyScreen.kt:228)");
            }
            Modifier m672paddingVpY3zN4$default = PaddingKt.m672paddingVpY3zN4$default(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), innerPadding), Dp.m6622constructorimpl(16), 0.0f, 2, null);
            Arrangement.HorizontalOrVertical m550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6622constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart($composer, 981841981, "CC(remember):PrivacyPolicyScreen.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($context) | $composer.changed($privacyPolicyText) | $composer.changed($privacyPolicyHtml);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function1() { // from class: com.example.ui.screens.PrivacyPolicyScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return PrivacyPolicyScreenKt.PrivacyPolicyScreen$lambda$19$lambda$18$lambda$17($context, $privacyPolicyText, $privacyPolicyHtml, (LazyListScope) obj2);
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
    public static final Unit PrivacyPolicyScreen$lambda$19$lambda$18$lambda$17(final Context $context, final String $privacyPolicyText, final String $privacyPolicyHtml, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$PrivacyPolicyScreenKt.INSTANCE.m7071getLambda$445815465$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$PrivacyPolicyScreenKt.INSTANCE.m7066getLambda$165757632$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1544893215, true, new Function3() { // from class: com.example.ui.screens.PrivacyPolicyScreenKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PrivacyPolicyScreenKt.PrivacyPolicyScreen$lambda$19$lambda$18$lambda$17$lambda$13($context, $privacyPolicyText, $privacyPolicyHtml, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$PrivacyPolicyScreenKt.INSTANCE.m7063getLambda$1039423234$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(671227613, true, new Function3() { // from class: com.example.ui.screens.PrivacyPolicyScreenKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PrivacyPolicyScreenKt.PrivacyPolicyScreen$lambda$19$lambda$18$lambda$17$lambda$16($privacyPolicyText, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$PrivacyPolicyScreenKt.INSTANCE.m7068getLambda$1913088836$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$PrivacyPolicyScreenKt.INSTANCE.m7070getLambda$202437989$app(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrivacyPolicyScreen$lambda$19$lambda$18$lambda$17$lambda$13(final Context $context, final String $privacyPolicyText, final String $privacyPolicyHtml, LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C293@14703L11,293@14661L74,294@14754L3192,290@14474L3472:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1544893215, $changed, -1, "com.example.ui.screens.PrivacyPolicyScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrivacyPolicyScreen.kt:290)");
            }
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "copy_policy_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(18)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-240186259, true, new Function3() { // from class: com.example.ui.screens.PrivacyPolicyScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PrivacyPolicyScreenKt.PrivacyPolicyScreen$lambda$19$lambda$18$lambda$17$lambda$13$lambda$12($context, $privacyPolicyText, $privacyPolicyHtml, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x03b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x026b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit PrivacyPolicyScreen$lambda$19$lambda$18$lambda$17$lambda$13$lambda$12(final android.content.Context r70, final java.lang.String r71, final java.lang.String r72, androidx.compose.foundation.layout.ColumnScope r73, androidx.compose.runtime.Composer r74, int r75) {
        /*
            Method dump skipped, instructions count: 1101
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.PrivacyPolicyScreenKt.PrivacyPolicyScreen$lambda$19$lambda$18$lambda$17$lambda$13$lambda$12(android.content.Context, java.lang.String, java.lang.String, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrivacyPolicyScreen$lambda$19$lambda$18$lambda$17$lambda$13$lambda$12$lambda$11$lambda$10$lambda$7$lambda$6(Context $context, String $privacyPolicyText) {
        Object systemService = $context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboard = (ClipboardManager) systemService;
        ClipData clip = ClipData.newPlainText("PrivacyPolicyMarkdown", $privacyPolicyText);
        clipboard.setPrimaryClip(clip);
        Toast.makeText($context, "Copied Markdown Privacy Policy to Clipboard!", 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrivacyPolicyScreen$lambda$19$lambda$18$lambda$17$lambda$13$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8(Context $context, String $privacyPolicyHtml) {
        Object systemService = $context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboard = (ClipboardManager) systemService;
        ClipData clip = ClipData.newPlainText("PrivacyPolicyHtml", $privacyPolicyHtml);
        clipboard.setPrimaryClip(clip);
        Toast.makeText($context, "Copied HTML Privacy Policy to Clipboard!", 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrivacyPolicyScreen$lambda$19$lambda$18$lambda$17$lambda$16(final String $privacyPolicyText, LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C396@20657L11,396@20615L74,397@20708L751,393@20428L1031:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(671227613, $changed, -1, "com.example.ui.screens.PrivacyPolicyScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrivacyPolicyScreen.kt:393)");
            }
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "full_policy_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(18)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-1113851861, true, new Function3() { // from class: com.example.ui.screens.PrivacyPolicyScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PrivacyPolicyScreenKt.PrivacyPolicyScreen$lambda$19$lambda$18$lambda$17$lambda$16$lambda$15($privacyPolicyText, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrivacyPolicyScreen$lambda$19$lambda$18$lambda$17$lambda$16$lambda$15(String $privacyPolicyText, ColumnScope Card, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C398@20730L711:PrivacyPolicyScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1113851861, $changed, -1, "com.example.ui.screens.PrivacyPolicyScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrivacyPolicyScreen.kt:398)");
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
            ComposerKt.sourceInformationMarkerStart($composer, 2122014485, "C401@20965L10,399@20850L221,405@21097L19,409@21252L10,411@21372L11,407@21142L277:PrivacyPolicyScreen.kt#2thlc2");
            TextKt.m2693Text4IGK_g("Complete Policy Text", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 196614, 0, 65502);
            DividerKt.m2072HorizontalDivider9IZ8Weo(null, 0.0f, 0L, $composer, 0, 7);
            TextKt.m2693Text4IGK_g($privacyPolicyText, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(20), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 0, 6, 64506);
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
    /* renamed from: PrivacyBulletPoint-3IgeMak, reason: not valid java name */
    public static final void m7106PrivacyBulletPoint3IgeMak(final ImageVector icon, final long iconTint, final String title, final String description, Composer $composer, final int $changed) {
        Composer $composer2;
        long m4157copywmQWz5c;
        Function0 function0;
        Composer $composer3 = $composer.startRestartGroup(312980853);
        ComposerKt.sourceInformation($composer3, "C(PrivacyBulletPoint)P(1,2:c#ui.graphics.Color,3)463@23281L937:PrivacyPolicyScreen.kt#2thlc2");
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
            $dirty |= $composer3.changed(description) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(312980853, $dirty2, -1, "com.example.ui.screens.PrivacyBulletPoint (PrivacyPolicyScreen.kt:462)");
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
            ComposerKt.sourceInformationMarkerStart($composer3, -517394598, "C471@23548L198,467@23388L358,476@23755L40,477@23804L408:PrivacyPolicyScreen.kt#2thlc2");
            RoundedCornerShape m953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(10));
            $composer2 = $composer3;
            m4157copywmQWz5c = Color.m4157copywmQWz5c(iconTint, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(iconTint) : 0.15f, (r12 & 2) != 0 ? Color.m4165getRedimpl(iconTint) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(iconTint) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(iconTint) : 0.0f);
            SurfaceKt.m2543SurfaceT9BRK9s(SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(36)), m953RoundedCornerShape0680j_4, m4157copywmQWz5c, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1158131690, true, new Function2() { // from class: com.example.ui.screens.PrivacyPolicyScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PrivacyPolicyScreenKt.PrivacyBulletPoint_3IgeMak$lambda$24$lambda$22(ImageVector.this, iconTint, (Composer) obj, ((Integer) obj2).intValue());
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
            ComposerKt.sourceInformationMarkerStart($composer3, 1124009647, "C478@23866L10,478@23825L93,479@23931L40,482@24064L10,483@24124L11,480@23984L218:PrivacyPolicyScreen.kt#2thlc2");
            TextKt.m2693Text4IGK_g(title, (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, (($dirty2 >> 6) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(2)), $composer3, 6);
            TextKt.m2693Text4IGK_g(description, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(16), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), $composer3, ($dirty2 >> 9) & 14, 6, 64506);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.PrivacyPolicyScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PrivacyPolicyScreenKt.PrivacyBulletPoint_3IgeMak$lambda$25(ImageVector.this, iconTint, title, description, $changed, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final kotlin.Unit PrivacyBulletPoint_3IgeMak$lambda$24$lambda$22(androidx.compose.ui.graphics.vector.ImageVector r32, long r33, androidx.compose.runtime.Composer r35, int r36) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.PrivacyPolicyScreenKt.PrivacyBulletPoint_3IgeMak$lambda$24$lambda$22(androidx.compose.ui.graphics.vector.ImageVector, long, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }
}
