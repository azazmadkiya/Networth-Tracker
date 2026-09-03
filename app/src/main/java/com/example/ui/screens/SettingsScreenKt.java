package com.example.ui.screens;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.example.ui.viewmodel.NetWorthViewModel;
import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: SettingsScreen.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001aE\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0002¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\f\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u008a\u008e\u0002²\u0006\n\u0010\u001d\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\f\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\f\u0010 \u001a\u0004\u0018\u00010!X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u000bX\u008a\u008e\u0002"}, d2 = {"SettingsScreen", "", "viewModel", "Lcom/example/ui/viewmodel/NetWorthViewModel;", "(Lcom/example/ui/viewmodel/NetWorthViewModel;Landroidx/compose/runtime/Composer;I)V", "SettingsNavRow", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "iconTint", "Landroidx/compose/ui/graphics/Color;", "title", "", "subtitle", "onClick", "Lkotlin/Function0;", "tag", "SettingsNavRow-8V94_ZQ", "(Landroidx/compose/ui/graphics/vector/ImageVector;JLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "saveBackupToDownloadsFolder", "context", "Landroid/content/Context;", "jsonContent", "app", "showPasswordDialog", "", "showExportDialog", "showImportDialog", "showDeleteAllConfirmDialog", "pendingRestoreJson", "exportedJsonText", "savedFilePathMsg", "importJsonInput", "activeSubScreen", "Lcom/example/ui/screens/SettingsSubScreen;", "newPass"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsScreenKt {

    /* compiled from: SettingsScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SettingsSubScreen.values().length];
            try {
                iArr[SettingsSubScreen.REMINDERS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SettingsSubScreen.PRIVACY_POLICY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SettingsSubScreen.TERMS_OF_SERVICE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SettingsSubScreen.DATA_SAFETY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[SettingsSubScreen.ABOUT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsNavRow_8V94_ZQ$lambda$171(ImageVector imageVector, long j, String str, String str2, Function0 function0, String str3, int i, Composer composer, int i2) {
        m7108SettingsNavRow8V94_ZQ(imageVector, j, str, str2, function0, str3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$166(NetWorthViewModel netWorthViewModel, int i, Composer composer, int i2) {
        SettingsScreen(netWorthViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$29(NetWorthViewModel netWorthViewModel, int i, Composer composer, int i2) {
        SettingsScreen(netWorthViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$32(NetWorthViewModel netWorthViewModel, int i, Composer composer, int i2) {
        SettingsScreen(netWorthViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$35(NetWorthViewModel netWorthViewModel, int i, Composer composer, int i2) {
        SettingsScreen(netWorthViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$38(NetWorthViewModel netWorthViewModel, int i, Composer composer, int i2) {
        SettingsScreen(netWorthViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$41(NetWorthViewModel netWorthViewModel, int i, Composer composer, int i2) {
        SettingsScreen(netWorthViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x05ba  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x073a  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0844  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x08e8  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0989  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x097a  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x08d7  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0831  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x072b  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0693  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SettingsScreen(final com.example.ui.viewmodel.NetWorthViewModel r42, androidx.compose.runtime.Composer r43, final int r44) {
        /*
            Method dump skipped, instructions count: 2482
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.SettingsScreenKt.SettingsScreen(com.example.ui.viewmodel.NetWorthViewModel, androidx.compose.runtime.Composer, int):void");
    }

    private static final boolean SettingsScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SettingsScreen$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean SettingsScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SettingsScreen$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean SettingsScreen$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SettingsScreen$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean SettingsScreen$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SettingsScreen$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String SettingsScreen$lambda$13(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String SettingsScreen$lambda$16(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String SettingsScreen$lambda$19(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String SettingsScreen$lambda$22(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final SettingsSubScreen SettingsScreen$lambda$25(MutableState<SettingsSubScreen> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$28$lambda$27(MutableState $activeSubScreen$delegate) {
        $activeSubScreen$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$31$lambda$30(MutableState $activeSubScreen$delegate) {
        $activeSubScreen$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$34$lambda$33(MutableState $activeSubScreen$delegate) {
        $activeSubScreen$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$37$lambda$36(MutableState $activeSubScreen$delegate) {
        $activeSubScreen$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$40$lambda$39(MutableState $activeSubScreen$delegate) {
        $activeSubScreen$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$45$lambda$44(NetWorthViewModel $viewModel, Context $context, Uri uri) {
        if (uri != null) {
            try {
                String exportBackupJson = $viewModel.exportBackupJson();
                OutputStream openOutputStream = $context.getContentResolver().openOutputStream(uri);
                if (openOutputStream != null) {
                    OutputStream outputStream = openOutputStream;
                    try {
                        byte[] bytes = exportBackupJson.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                        outputStream.write(bytes);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(outputStream, null);
                    } finally {
                    }
                }
                Toast.makeText($context, "Backup file saved to File Manager!", 1).show();
            } catch (Exception e) {
                Toast.makeText($context, "Failed to save file: " + e.getMessage(), 0).show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0053 A[Catch: Exception -> 0x0063, TryCatch #2 {Exception -> 0x0063, blocks: (B:4:0x0006, B:6:0x0011, B:8:0x001e, B:9:0x0029, B:12:0x0036, B:21:0x003e, B:22:0x0041, B:23:0x0021, B:24:0x0042, B:26:0x0047, B:31:0x0053, B:32:0x0057, B:11:0x002b, B:17:0x003c), top: B:3:0x0006, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0057 A[Catch: Exception -> 0x0063, TRY_LEAVE, TryCatch #2 {Exception -> 0x0063, blocks: (B:4:0x0006, B:6:0x0011, B:8:0x001e, B:9:0x0029, B:12:0x0036, B:21:0x003e, B:22:0x0041, B:23:0x0021, B:24:0x0042, B:26:0x0047, B:31:0x0053, B:32:0x0057, B:11:0x002b, B:17:0x003c), top: B:3:0x0006, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SettingsScreen$lambda$49$lambda$48(android.content.Context r9, androidx.compose.runtime.MutableState r10, android.net.Uri r11) {
        /*
            if (r11 == 0) goto L86
            r0 = r11
            r1 = 0
            r2 = 0
            android.content.ContentResolver r3 = r9.getContentResolver()     // Catch: java.lang.Exception -> L63
            java.io.InputStream r3 = r3.openInputStream(r0)     // Catch: java.lang.Exception -> L63
            r4 = 0
            if (r3 == 0) goto L42
            java.nio.charset.Charset r5 = kotlin.text.Charsets.UTF_8     // Catch: java.lang.Exception -> L63
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L63
            r6.<init>(r3, r5)     // Catch: java.lang.Exception -> L63
            java.io.Reader r6 = (java.io.Reader) r6     // Catch: java.lang.Exception -> L63
            boolean r5 = r6 instanceof java.io.BufferedReader     // Catch: java.lang.Exception -> L63
            if (r5 == 0) goto L21
            java.io.BufferedReader r6 = (java.io.BufferedReader) r6     // Catch: java.lang.Exception -> L63
            goto L29
        L21:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L63
            r7 = 8192(0x2000, float:1.148E-41)
            r5.<init>(r6, r7)     // Catch: java.lang.Exception -> L63
            r6 = r5
        L29:
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch: java.lang.Exception -> L63
            r5 = r6
            java.io.BufferedReader r5 = (java.io.BufferedReader) r5     // Catch: java.lang.Throwable -> L3b
            r7 = 0
            r8 = r5
            java.io.Reader r8 = (java.io.Reader) r8     // Catch: java.lang.Throwable -> L3b
            java.lang.String r8 = kotlin.io.TextStreamsKt.readText(r8)     // Catch: java.lang.Throwable -> L3b
            kotlin.io.CloseableKt.closeFinally(r6, r4)     // Catch: java.lang.Exception -> L63
            r4 = r8
            goto L42
        L3b:
            r4 = move-exception
            throw r4     // Catch: java.lang.Throwable -> L3d
        L3d:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r4)     // Catch: java.lang.Exception -> L63
            throw r5     // Catch: java.lang.Exception -> L63
        L42:
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch: java.lang.Exception -> L63
            if (r5 == 0) goto L50
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)     // Catch: java.lang.Exception -> L63
            if (r5 == 0) goto L4e
            goto L50
        L4e:
            r5 = r2
            goto L51
        L50:
            r5 = 1
        L51:
            if (r5 != 0) goto L57
            SettingsScreen$lambda$14(r10, r4)     // Catch: java.lang.Exception -> L63
            goto L84
        L57:
            java.lang.String r5 = "Selected backup file is empty!"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch: java.lang.Exception -> L63
            android.widget.Toast r5 = android.widget.Toast.makeText(r9, r5, r2)     // Catch: java.lang.Exception -> L63
            r5.show()     // Catch: java.lang.Exception -> L63
            goto L84
        L63:
            r3 = move-exception
            java.lang.String r4 = r3.getMessage()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to read file: "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            android.widget.Toast r2 = android.widget.Toast.makeText(r9, r4, r2)
            r2.show()
        L84:
        L86:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.SettingsScreenKt.SettingsScreen$lambda$49$lambda$48(android.content.Context, androidx.compose.runtime.MutableState, android.net.Uri):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95(final NetWorthViewModel $viewModel, final MutableState $showPasswordDialog$delegate, final MutableState $activeSubScreen$delegate, final Context $context, final ManagedActivityResultLauncher $openDocumentLauncher, final MutableState $exportedJsonText$delegate, final MutableState $savedFilePathMsg$delegate, final MutableState $showExportDialog$delegate, final MutableState $showImportDialog$delegate, final MutableState $showDeleteAllConfirmDialog$delegate, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.getLambda$354649585$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1543545368, true, new Function3() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda73
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SettingsScreenKt.SettingsScreen$lambda$96$lambda$95$lambda$59(NetWorthViewModel.this, $showPasswordDialog$delegate, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-820254935, true, new Function3() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SettingsScreenKt.SettingsScreen$lambda$96$lambda$95$lambda$62(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-96964502, true, new Function3() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SettingsScreenKt.SettingsScreen$lambda$96$lambda$95$lambda$76(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(626325931, true, new Function3() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SettingsScreenKt.SettingsScreen$lambda$96$lambda$95$lambda$88(NetWorthViewModel.this, $context, $openDocumentLauncher, $exportedJsonText$delegate, $savedFilePathMsg$delegate, $showExportDialog$delegate, $showImportDialog$delegate, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.getLambda$1349616364$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(2072906797, true, new Function3() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SettingsScreenKt.SettingsScreen$lambda$96$lambda$95$lambda$94(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.m7083getLambda$1498770066$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.m7095getLambda$775479633$app(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$59(final NetWorthViewModel $viewModel, final MutableState $showPasswordDialog$delegate, LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C174@7262L11,174@7220L74,175@7309L2555,171@7039L2825:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1543545368, $changed, -1, "com.example.ui.screens.SettingsScreen.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:171)");
            }
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "security_settings_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(20)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-906256166, true, new Function3() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SettingsScreenKt.SettingsScreen$lambda$96$lambda$95$lambda$59$lambda$58(NetWorthViewModel.this, $showPasswordDialog$delegate, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0724  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0670 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x05f8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x057a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0398 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SettingsScreen$lambda$96$lambda$95$lambda$59$lambda$58(final com.example.ui.viewmodel.NetWorthViewModel r104, final androidx.compose.runtime.MutableState r105, androidx.compose.foundation.layout.ColumnScope r106, androidx.compose.runtime.Composer r107, int r108) {
        /*
            Method dump skipped, instructions count: 1834
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.SettingsScreenKt.SettingsScreen$lambda$96$lambda$95$lambda$59$lambda$58(com.example.ui.viewmodel.NetWorthViewModel, androidx.compose.runtime.MutableState, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$59$lambda$58$lambda$57$lambda$56$lambda$53$lambda$52(MutableState $showPasswordDialog$delegate) {
        SettingsScreen$lambda$2($showPasswordDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$59$lambda$58$lambda$57$lambda$56$lambda$55$lambda$54(NetWorthViewModel $viewModel) {
        $viewModel.logout();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$62(final MutableState $activeSubScreen$delegate, LazyItemScope item, Composer $composer, int $changed) {
        Object obj;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C232@10055L49,235@10293L11,235@10251L74,229@9946L2268:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-820254935, $changed, -1, "com.example.ui.screens.SettingsScreen.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:229)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer, 2008993914, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreen$lambda$96$lambda$95$lambda$62$lambda$61$lambda$60(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CardKt.Card(TestTagKt.testTag(ClickableKt.m258clickableXHw0xAI$default(fillMaxWidth$default, false, null, null, (Function0) obj, 7, null), "settings_reminders_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(20)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.m7087getLambda$182965733$app(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$62$lambda$61$lambda$60(MutableState $activeSubScreen$delegate) {
        $activeSubScreen$delegate.setValue(SettingsSubScreen.REMINDERS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$76(final MutableState $activeSubScreen$delegate, LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C285@12521L11,285@12479L74,286@12568L3693,282@12299L3962:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-96964502, $changed, -1, "com.example.ui.screens.SettingsScreen.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:282)");
            }
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "legal_compliance_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(20)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(540324700, true, new Function3() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda72
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SettingsScreenKt.SettingsScreen$lambda$96$lambda$95$lambda$76$lambda$75(MutableState.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x05e9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x066c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x06ee  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x076f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x07cb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x077d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x06fc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x067a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x05f9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SettingsScreen$lambda$96$lambda$95$lambda$76$lambda$75(final androidx.compose.runtime.MutableState r106, androidx.compose.foundation.layout.ColumnScope r107, androidx.compose.runtime.Composer r108, int r109) {
        /*
            Method dump skipped, instructions count: 2001
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.SettingsScreenKt.SettingsScreen$lambda$96$lambda$95$lambda$76$lambda$75(androidx.compose.runtime.MutableState, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$76$lambda$75$lambda$74$lambda$73$lambda$66$lambda$65(MutableState $activeSubScreen$delegate) {
        $activeSubScreen$delegate.setValue(SettingsSubScreen.PRIVACY_POLICY);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$76$lambda$75$lambda$74$lambda$73$lambda$68$lambda$67(MutableState $activeSubScreen$delegate) {
        $activeSubScreen$delegate.setValue(SettingsSubScreen.TERMS_OF_SERVICE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$76$lambda$75$lambda$74$lambda$73$lambda$70$lambda$69(MutableState $activeSubScreen$delegate) {
        $activeSubScreen$delegate.setValue(SettingsSubScreen.DATA_SAFETY);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$76$lambda$75$lambda$74$lambda$73$lambda$72$lambda$71(MutableState $activeSubScreen$delegate) {
        $activeSubScreen$delegate.setValue(SettingsSubScreen.ABOUT);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$88(final NetWorthViewModel $viewModel, final Context $context, final ManagedActivityResultLauncher $openDocumentLauncher, final MutableState $exportedJsonText$delegate, final MutableState $savedFilePathMsg$delegate, final MutableState $showExportDialog$delegate, final MutableState $showImportDialog$delegate, LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C363@16562L11,363@16520L74,364@16609L3660,360@16341L3928:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626325931, $changed, -1, "com.example.ui.screens.SettingsScreen.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:360)");
            }
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "backup_settings_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(20)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(1263615133, true, new Function3() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SettingsScreenKt.SettingsScreen$lambda$96$lambda$95$lambda$88$lambda$87(NetWorthViewModel.this, $context, $openDocumentLauncher, $exportedJsonText$delegate, $savedFilePathMsg$delegate, $showExportDialog$delegate, $showImportDialog$delegate, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0701  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0785  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03a8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SettingsScreen$lambda$96$lambda$95$lambda$88$lambda$87(final com.example.ui.viewmodel.NetWorthViewModel r106, final android.content.Context r107, final androidx.activity.compose.ManagedActivityResultLauncher r108, final androidx.compose.runtime.MutableState r109, final androidx.compose.runtime.MutableState r110, final androidx.compose.runtime.MutableState r111, final androidx.compose.runtime.MutableState r112, androidx.compose.foundation.layout.ColumnScope r113, androidx.compose.runtime.Composer r114, int r115) {
        /*
            Method dump skipped, instructions count: 1931
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.SettingsScreenKt.SettingsScreen$lambda$96$lambda$95$lambda$88$lambda$87(com.example.ui.viewmodel.NetWorthViewModel, android.content.Context, androidx.activity.compose.ManagedActivityResultLauncher, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$88$lambda$87$lambda$86$lambda$85$lambda$80$lambda$79(NetWorthViewModel $viewModel, Context $context, MutableState $exportedJsonText$delegate, MutableState $savedFilePathMsg$delegate, MutableState $showExportDialog$delegate) {
        $exportedJsonText$delegate.setValue($viewModel.exportBackupJson());
        String path = saveBackupToDownloadsFolder($context, SettingsScreen$lambda$16($exportedJsonText$delegate));
        $savedFilePathMsg$delegate.setValue(path);
        if (path != null) {
            Toast.makeText($context, "Backup file saved to File Manager: " + path, 1).show();
        }
        SettingsScreen$lambda$5($showExportDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$88$lambda$87$lambda$86$lambda$85$lambda$82$lambda$81(ManagedActivityResultLauncher $openDocumentLauncher) {
        $openDocumentLauncher.launch(new String[]{"application/json", "text/*", "*/*"});
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$88$lambda$87$lambda$86$lambda$85$lambda$84$lambda$83(MutableState $showImportDialog$delegate) {
        SettingsScreen$lambda$8($showImportDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$94(final MutableState $showDeleteAllConfirmDialog$delegate, LazyItemScope item, Composer $composer, int $changed) {
        long m4157copywmQWz5c;
        long m4157copywmQWz5c2;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C465@22086L11,465@22044L88,466@22220L11,467@22272L1833,462@21869L2236:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2072906797, $changed, -1, "com.example.ui.screens.SettingsScreen.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:462)");
            }
            Modifier testTag = TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "danger_zone_card");
            RoundedCornerShape m953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(20));
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            m4157copywmQWz5c = Color.m4157copywmQWz5c(r17, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(r17) : 0.3f, (r12 & 2) != 0 ? Color.m4165getRedimpl(r17) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(r17) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getErrorContainer()) : 0.0f);
            CardColors m1829cardColorsro_MJ88 = cardDefaults.m1829cardColorsro_MJ88(m4157copywmQWz5c, 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14);
            float m6622constructorimpl = Dp.m6622constructorimpl(1);
            m4157copywmQWz5c2 = Color.m4157copywmQWz5c(r17, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(r17) : 0.4f, (r12 & 2) != 0 ? Color.m4165getRedimpl(r17) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(r17) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError()) : 0.0f);
            CardKt.Card(testTag, m953RoundedCornerShape0680j_4, m1829cardColorsro_MJ88, null, BorderStrokeKt.m252BorderStrokecXLIe8U(m6622constructorimpl, m4157copywmQWz5c2), ComposableLambdaKt.rememberComposableLambda(-1584771297, true, new Function3() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda67
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SettingsScreenKt.SettingsScreen$lambda$96$lambda$95$lambda$94$lambda$93(MutableState.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196614, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SettingsScreen$lambda$96$lambda$95$lambda$94$lambda$93(final androidx.compose.runtime.MutableState r83, androidx.compose.foundation.layout.ColumnScope r84, androidx.compose.runtime.Composer r85, int r86) {
        /*
            Method dump skipped, instructions count: 1066
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.SettingsScreenKt.SettingsScreen$lambda$96$lambda$95$lambda$94$lambda$93(androidx.compose.runtime.MutableState, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$96$lambda$95$lambda$94$lambda$93$lambda$92$lambda$91$lambda$90(MutableState $showDeleteAllConfirmDialog$delegate) {
        SettingsScreen$lambda$11($showDeleteAllConfirmDialog$delegate, true);
        return Unit.INSTANCE;
    }

    private static final String SettingsScreen$lambda$98(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$101$lambda$100(MutableState $showPasswordDialog$delegate) {
        SettingsScreen$lambda$2($showPasswordDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SettingsScreen$lambda$111(com.example.ui.viewmodel.NetWorthViewModel r54, final androidx.compose.runtime.MutableState r55, androidx.compose.runtime.Composer r56, int r57) {
        /*
            Method dump skipped, instructions count: 581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.SettingsScreenKt.SettingsScreen$lambda$111(com.example.ui.viewmodel.NetWorthViewModel, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$111$lambda$110$lambda$109$lambda$108(MutableState $newPass$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $newPass$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$104(final NetWorthViewModel $viewModel, final Context $context, final MutableState $newPass$delegate, final MutableState $showPasswordDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C563@26567L343,562@26529L452:SettingsScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1113630055, $changed, -1, "com.example.ui.screens.SettingsScreen.<anonymous> (SettingsScreen.kt:562)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 751628286, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($viewModel) | $composer.changedInstance($context);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda68
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreen$lambda$104$lambda$103$lambda$102(NetWorthViewModel.this, $context, $newPass$delegate, $showPasswordDialog$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.m7086getLambda$1788713097$app(), $composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$104$lambda$103$lambda$102(NetWorthViewModel $viewModel, Context $context, MutableState $newPass$delegate, MutableState $showPasswordDialog$delegate) {
        if (!StringsKt.isBlank(SettingsScreen$lambda$98($newPass$delegate))) {
            $viewModel.getAuthManager().updatePassword(SettingsScreen$lambda$98($newPass$delegate));
            Toast.makeText($context, "Password updated successfully!", 0).show();
            SettingsScreen$lambda$2($showPasswordDialog$delegate, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$107(final MutableState $showPasswordDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C575@27064L30,575@27043L107:SettingsScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-936778843, $changed, -1, "com.example.ui.screens.SettingsScreen.<anonymous> (SettingsScreen.kt:575)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1698665315, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda60
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreen$lambda$107$lambda$106$lambda$105(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.getLambda$327312072$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$107$lambda$106$lambda$105(MutableState $showPasswordDialog$delegate) {
        SettingsScreen$lambda$2($showPasswordDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$113$lambda$112(MutableState $showDeleteAllConfirmDialog$delegate) {
        SettingsScreen$lambda$11($showDeleteAllConfirmDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$116(final NetWorthViewModel $viewModel, final Context $context, final MutableState $showDeleteAllConfirmDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C598@28072L250,603@28412L11,603@28368L62,597@28034L485:SettingsScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(671875560, $changed, -1, "com.example.ui.screens.SettingsScreen.<anonymous> (SettingsScreen.kt:597)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1427320802, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($viewModel) | $composer.changedInstance($context);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda62
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreen$lambda$116$lambda$115$lambda$114(NetWorthViewModel.this, $context, $showDeleteAllConfirmDialog$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, null, false, null, ButtonDefaults.INSTANCE.m1809buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.getLambda$2064499704$app(), $composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$116$lambda$115$lambda$114(NetWorthViewModel $viewModel, Context $context, MutableState $showDeleteAllConfirmDialog$delegate) {
        $viewModel.clearAllData();
        Toast.makeText($context, "All financial records wiped successfully.", 1).show();
        SettingsScreen$lambda$11($showDeleteAllConfirmDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$119(final MutableState $showDeleteAllConfirmDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C609@28602L38,609@28581L115:SettingsScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1378533338, $changed, -1, "com.example.ui.screens.SettingsScreen.<anonymous> (SettingsScreen.kt:609)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1920609364, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda65
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreen$lambda$119$lambda$118$lambda$117(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.m7078getLambda$114442423$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$119$lambda$118$lambda$117(MutableState $showDeleteAllConfirmDialog$delegate) {
        SettingsScreen$lambda$11($showDeleteAllConfirmDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$122$lambda$121(MutableState $showExportDialog$delegate) {
        SettingsScreen$lambda$5($showExportDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SettingsScreen$lambda$135(androidx.compose.runtime.MutableState r54, androidx.compose.runtime.MutableState r55, androidx.compose.runtime.Composer r56, int r57) {
        /*
            Method dump skipped, instructions count: 690
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.SettingsScreenKt.SettingsScreen$lambda$135(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$135$lambda$134$lambda$133$lambda$132(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x017a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SettingsScreen$lambda$128(final androidx.activity.compose.ManagedActivityResultLauncher r40, final java.lang.String r41, final android.content.Context r42, final androidx.compose.runtime.MutableState r43, androidx.compose.runtime.Composer r44, int r45) {
        /*
            Method dump skipped, instructions count: 585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.SettingsScreenKt.SettingsScreen$lambda$128(androidx.activity.compose.ManagedActivityResultLauncher, java.lang.String, android.content.Context, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$128$lambda$127$lambda$124$lambda$123(ManagedActivityResultLauncher $createDocumentLauncher, String $defaultFileName) {
        $createDocumentLauncher.launch($defaultFileName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$128$lambda$127$lambda$126$lambda$125(Context $context, MutableState $exportedJsonText$delegate) {
        Object systemService = $context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboard = (ClipboardManager) systemService;
        ClipData clip = ClipData.newPlainText("NetWorthBackup", SettingsScreen$lambda$16($exportedJsonText$delegate));
        clipboard.setPrimaryClip(clip);
        Toast.makeText($context, "Copied backup JSON to clipboard!", 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$131(final MutableState $showExportDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C674@31649L28,674@31628L103:SettingsScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1820287833, $changed, -1, "com.example.ui.screens.SettingsScreen.<anonymous> (SettingsScreen.kt:674)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1244916765, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreen$lambda$131$lambda$130$lambda$129(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.m7092getLambda$556196918$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$131$lambda$130$lambda$129(MutableState $showExportDialog$delegate) {
        SettingsScreen$lambda$5($showExportDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$137$lambda$136(MutableState $showImportDialog$delegate) {
        SettingsScreen$lambda$8($showImportDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SettingsScreen$lambda$152(final androidx.compose.runtime.MutableState r54, androidx.compose.runtime.Composer r55, int r56) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.SettingsScreenKt.SettingsScreen$lambda$152(androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$152$lambda$151$lambda$150$lambda$149(MutableState $importJsonInput$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $importJsonInput$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0219 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0183  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SettingsScreen$lambda$145(final com.example.ui.viewmodel.NetWorthViewModel r43, final android.content.Context r44, final androidx.compose.runtime.MutableState r45, final androidx.compose.runtime.MutableState r46, androidx.compose.runtime.Composer r47, int r48) {
        /*
            Method dump skipped, instructions count: 678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.SettingsScreenKt.SettingsScreen$lambda$145(com.example.ui.viewmodel.NetWorthViewModel, android.content.Context, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$145$lambda$144$lambda$140$lambda$139(NetWorthViewModel $viewModel, final MutableState $importJsonInput$delegate, final Context $context, final MutableState $showImportDialog$delegate) {
        if (!StringsKt.isBlank(SettingsScreen$lambda$22($importJsonInput$delegate))) {
            $viewModel.importBackupJson(SettingsScreen$lambda$22($importJsonInput$delegate), false, new Function1() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda69
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SettingsScreenKt.SettingsScreen$lambda$145$lambda$144$lambda$140$lambda$139$lambda$138($context, $showImportDialog$delegate, $importJsonInput$delegate, ((Boolean) obj).booleanValue());
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$145$lambda$144$lambda$140$lambda$139$lambda$138(Context $context, MutableState $showImportDialog$delegate, MutableState $importJsonInput$delegate, boolean success) {
        if (success) {
            Toast.makeText($context, "Backup merged and appended successfully!", 0).show();
            SettingsScreen$lambda$8($showImportDialog$delegate, false);
            $importJsonInput$delegate.setValue("");
        } else {
            Toast.makeText($context, "Invalid JSON format!", 1).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$145$lambda$144$lambda$143$lambda$142(NetWorthViewModel $viewModel, final MutableState $importJsonInput$delegate, final Context $context, final MutableState $showImportDialog$delegate) {
        if (!StringsKt.isBlank(SettingsScreen$lambda$22($importJsonInput$delegate))) {
            $viewModel.importBackupJson(SettingsScreen$lambda$22($importJsonInput$delegate), true, new Function1() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda71
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SettingsScreenKt.SettingsScreen$lambda$145$lambda$144$lambda$143$lambda$142$lambda$141($context, $showImportDialog$delegate, $importJsonInput$delegate, ((Boolean) obj).booleanValue());
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$145$lambda$144$lambda$143$lambda$142$lambda$141(Context $context, MutableState $showImportDialog$delegate, MutableState $importJsonInput$delegate, boolean success) {
        if (success) {
            Toast.makeText($context, "Database replaced with backup data!", 0).show();
            SettingsScreen$lambda$8($showImportDialog$delegate, false);
            $importJsonInput$delegate.setValue("");
        } else {
            Toast.makeText($context, "Invalid JSON format!", 1).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$148(final MutableState $showImportDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C747@35303L28,747@35282L105:SettingsScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2032924968, $changed, -1, "com.example.ui.screens.SettingsScreen.<anonymous> (SettingsScreen.kt:747)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -569224156, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreen$lambda$148$lambda$147$lambda$146(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.m7097getLambda$997951413$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$148$lambda$147$lambda$146(MutableState $showImportDialog$delegate) {
        SettingsScreen$lambda$8($showImportDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$154$lambda$153(MutableState $pendingRestoreJson$delegate) {
        $pendingRestoreJson$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0225 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x018a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SettingsScreen$lambda$162(final com.example.ui.viewmodel.NetWorthViewModel r43, final java.lang.String r44, final android.content.Context r45, final androidx.compose.runtime.MutableState r46, androidx.compose.runtime.Composer r47, int r48) {
        /*
            Method dump skipped, instructions count: 690
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.SettingsScreenKt.SettingsScreen$lambda$162(com.example.ui.viewmodel.NetWorthViewModel, java.lang.String, android.content.Context, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$162$lambda$161$lambda$157$lambda$156(NetWorthViewModel $viewModel, String $jsonContent, final Context $context, final MutableState $pendingRestoreJson$delegate) {
        $viewModel.importBackupJson($jsonContent, false, new Function1() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SettingsScreenKt.SettingsScreen$lambda$162$lambda$161$lambda$157$lambda$156$lambda$155($context, $pendingRestoreJson$delegate, ((Boolean) obj).booleanValue());
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$162$lambda$161$lambda$157$lambda$156$lambda$155(Context $context, MutableState $pendingRestoreJson$delegate, boolean success) {
        if (success) {
            Toast.makeText($context, "Backup data merged & appended to existing records successfully!", 1).show();
            $pendingRestoreJson$delegate.setValue(null);
        } else {
            Toast.makeText($context, "Failed to restore backup! Invalid JSON structure.", 1).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$162$lambda$161$lambda$160$lambda$159(NetWorthViewModel $viewModel, String $jsonContent, final Context $context, final MutableState $pendingRestoreJson$delegate) {
        $viewModel.importBackupJson($jsonContent, true, new Function1() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda59
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SettingsScreenKt.SettingsScreen$lambda$162$lambda$161$lambda$160$lambda$159$lambda$158($context, $pendingRestoreJson$delegate, ((Boolean) obj).booleanValue());
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$162$lambda$161$lambda$160$lambda$159$lambda$158(Context $context, MutableState $pendingRestoreJson$delegate, boolean success) {
        if (success) {
            Toast.makeText($context, "Database replaced and backup restored successfully!", 1).show();
            $pendingRestoreJson$delegate.setValue(null);
        } else {
            Toast.makeText($context, "Failed to restore backup! Invalid JSON structure.", 1).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$165(final MutableState $pendingRestoreJson$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C857@41271L29,857@41250L106:SettingsScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1591170473, $changed, -1, "com.example.ui.screens.SettingsScreen.<anonymous> (SettingsScreen.kt:857)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 106468454, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreen$lambda$165$lambda$164$lambda$163(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.m7082getLambda$1439705908$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$165$lambda$164$lambda$163(MutableState $pendingRestoreJson$delegate) {
        $pendingRestoreJson$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0489  */
    /* renamed from: SettingsNavRow-8V94_ZQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m7108SettingsNavRow8V94_ZQ(final androidx.compose.ui.graphics.vector.ImageVector r69, final long r70, final java.lang.String r72, final java.lang.String r73, final kotlin.jvm.functions.Function0<kotlin.Unit> r74, final java.lang.String r75, androidx.compose.runtime.Composer r76, final int r77) {
        /*
            Method dump skipped, instructions count: 1193
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.SettingsScreenKt.m7108SettingsNavRow8V94_ZQ(androidx.compose.ui.graphics.vector.ImageVector, long, java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, java.lang.String, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SettingsNavRow_8V94_ZQ$lambda$170$lambda$168(androidx.compose.ui.graphics.vector.ImageVector r32, long r33, androidx.compose.runtime.Composer r35, int r36) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.SettingsScreenKt.SettingsNavRow_8V94_ZQ$lambda$170$lambda$168(androidx.compose.ui.graphics.vector.ImageVector, long, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    private static final String saveBackupToDownloadsFolder(Context context, String jsonContent) {
        try {
            String fileName = "NetWorth_Backup_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".json";
            if (Build.VERSION.SDK_INT >= 29) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_display_name", fileName);
                contentValues.put("mime_type", "application/json");
                contentValues.put("relative_path", Environment.DIRECTORY_DOWNLOADS);
                ContentResolver resolver = context.getContentResolver();
                Uri uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);
                if (uri == null) {
                    return null;
                }
                OutputStream openOutputStream = resolver.openOutputStream(uri);
                if (openOutputStream != null) {
                    OutputStream outputStream = openOutputStream;
                    try {
                        byte[] bytes = jsonContent.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                        outputStream.write(bytes);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(outputStream, null);
                    } finally {
                    }
                }
                return "Downloads/" + fileName;
            }
            File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            if (!downloadsDir.exists()) {
                downloadsDir.mkdirs();
            }
            File file = new File(downloadsDir, fileName);
            FilesKt.writeText$default(file, jsonContent, null, 2, null);
            return "Downloads/" + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
