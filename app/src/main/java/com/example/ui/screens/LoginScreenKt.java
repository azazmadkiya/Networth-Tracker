package com.example.ui.screens;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.VisibilityKt;
import androidx.compose.material.icons.filled.VisibilityOffKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.example.data.security.AuthManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginScreen.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a'\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\u0004X\u008a\u008e\u0002²\u0006\n\u0010\t\u001a\u00020\u0004X\u008a\u008e\u0002²\u0006\n\u0010\n\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\f\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u008a\u008e\u0002"}, d2 = {"LoginScreen", "", "onLoginSuccess", "Lkotlin/Function2;", "", "", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app", "userId", "password", "passwordVisible", "errorMessage"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoginScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LoginScreen$lambda$32(Function2 function2, int i, Composer composer, int i2) {
        LoginScreen(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x05c2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LoginScreen(kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, java.lang.Boolean> r83, androidx.compose.runtime.Composer r84, final int r85) {
        /*
            Method dump skipped, instructions count: 1492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.LoginScreenKt.LoginScreen(kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    private static final String LoginScreen$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String LoginScreen$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean LoginScreen$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void LoginScreen$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String LoginScreen$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x05f8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x053c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit LoginScreen$lambda$31$lambda$30$lambda$29(final kotlin.jvm.functions.Function2 r127, final androidx.compose.runtime.MutableState r128, final androidx.compose.runtime.MutableState r129, final androidx.compose.runtime.MutableState r130, final androidx.compose.runtime.MutableState r131, androidx.compose.foundation.layout.ColumnScope r132, androidx.compose.runtime.Composer r133, int r134) {
        /*
            Method dump skipped, instructions count: 1682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.LoginScreenKt.LoginScreen$lambda$31$lambda$30$lambda$29(kotlin.jvm.functions.Function2, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LoginScreen$lambda$31$lambda$30$lambda$29$lambda$28$lambda$13$lambda$12(MutableState $userId$delegate, MutableState $errorMessage$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $userId$delegate.setValue(it);
        $errorMessage$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LoginScreen$lambda$31$lambda$30$lambda$29$lambda$28$lambda$17$lambda$16(MutableState $password$delegate, MutableState $errorMessage$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $password$delegate.setValue(it);
        $errorMessage$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LoginScreen$lambda$31$lambda$30$lambda$29$lambda$28$lambda$21(final MutableState $passwordVisible$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C186@7740L38,188@7900L372,185@7686L586:LoginScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1950624112, $changed, -1, "com.example.ui.screens.LoginScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoginScreen.kt:185)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1944027850, "CC(remember):LoginScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.LoginScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LoginScreenKt.LoginScreen$lambda$31$lambda$30$lambda$29$lambda$28$lambda$21$lambda$19$lambda$18(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton((Function0) obj, TestTagKt.testTag(Modifier.INSTANCE, "toggle_password_visibility"), false, null, null, ComposableLambdaKt.rememberComposableLambda(-1553219885, true, new Function2() { // from class: com.example.ui.screens.LoginScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return LoginScreenKt.LoginScreen$lambda$31$lambda$30$lambda$29$lambda$28$lambda$21$lambda$20(MutableState.this, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196662, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LoginScreen$lambda$31$lambda$30$lambda$29$lambda$28$lambda$21$lambda$19$lambda$18(MutableState $passwordVisible$delegate) {
        LoginScreen$lambda$8($passwordVisible$delegate, !LoginScreen$lambda$7($passwordVisible$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LoginScreen$lambda$31$lambda$30$lambda$29$lambda$28$lambda$21$lambda$20(MutableState $passwordVisible$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C189@7934L308:LoginScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1553219885, $changed, -1, "com.example.ui.screens.LoginScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoginScreen.kt:189)");
            }
            IconKt.m2150Iconww6aTOc(LoginScreen$lambda$7($passwordVisible$delegate) ? VisibilityKt.getVisibility(Icons.INSTANCE.getDefault()) : VisibilityOffKt.getVisibilityOff(Icons.INSTANCE.getDefault()), "Toggle Visibility", (Modifier) null, ColorKt.Color(4287931320L), $composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LoginScreen$lambda$31$lambda$30$lambda$29$lambda$28$lambda$15$lambda$14(Function2 $onLoginSuccess, MutableState $userId$delegate, MutableState $password$delegate, MutableState $errorMessage$delegate, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        boolean ok = ((Boolean) $onLoginSuccess.invoke(LoginScreen$lambda$1($userId$delegate), LoginScreen$lambda$4($password$delegate))).booleanValue();
        if (!ok) {
            $errorMessage$delegate.setValue("Invalid ID or Password!");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LoginScreen$lambda$31$lambda$30$lambda$29$lambda$28$lambda$23(MutableState $errorMessage$delegate, AnimatedVisibilityScope AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C:LoginScreen.kt#2thlc2");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-891554566, $changed, -1, "com.example.ui.screens.LoginScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoginScreen.kt:219)");
        }
        String LoginScreen$lambda$10 = LoginScreen$lambda$10($errorMessage$delegate);
        if (LoginScreen$lambda$10 == null) {
            $composer.startReplaceGroup(-224266184);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-224266183);
            ComposerKt.sourceInformation($composer, "*222@9783L11,223@9856L10,220@9679L300");
            TextKt.m2693Text4IGK_g(LoginScreen$lambda$10, PaddingKt.m674paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6622constructorimpl(8), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 48, 0, 65528);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LoginScreen$lambda$31$lambda$30$lambda$29$lambda$28$lambda$25$lambda$24(Function2 $onLoginSuccess, MutableState $userId$delegate, MutableState $password$delegate, MutableState $errorMessage$delegate) {
        boolean ok = ((Boolean) $onLoginSuccess.invoke(LoginScreen$lambda$1($userId$delegate), LoginScreen$lambda$4($password$delegate))).booleanValue();
        if (!ok) {
            $errorMessage$delegate.setValue("Invalid ID or Password. Check credentials.");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LoginScreen$lambda$31$lambda$30$lambda$29$lambda$28$lambda$27$lambda$26(Function2 $onLoginSuccess, MutableState $userId$delegate, MutableState $password$delegate, MutableState $errorMessage$delegate) {
        $userId$delegate.setValue(AuthManager.DEFAULT_USER_ID);
        $password$delegate.setValue(AuthManager.DEFAULT_PASSWORD);
        $errorMessage$delegate.setValue(null);
        $onLoginSuccess.invoke(LoginScreen$lambda$1($userId$delegate), LoginScreen$lambda$4($password$delegate));
        return Unit.INSTANCE;
    }
}
