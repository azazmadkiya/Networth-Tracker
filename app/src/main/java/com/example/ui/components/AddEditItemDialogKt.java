package com.example.ui.components;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.profileinstaller.ProfileVerifier;
import com.example.data.model.FinancialItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AddEditItemDialog.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"AddEditItemDialog", "", "itemToEdit", "Lcom/example/data/model/FinancialItem;", "existingAssetAccounts", "", "onDismiss", "Lkotlin/Function0;", "onSave", "Lkotlin/Function1;", "(Lcom/example/data/model/FinancialItem;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AddEditItemDialogKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditItemDialog$lambda$2(FinancialItem financialItem, List list, Function0 function0, Function1 function1, int i, int i2, Composer composer, int i3) {
        AddEditItemDialog(financialItem, list, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void AddEditItemDialog(FinancialItem itemToEdit, List<FinancialItem> list, final Function0<Unit> onDismiss, final Function1<? super FinancialItem, Unit> onSave, Composer $composer, final int $changed, final int i) {
        FinancialItem financialItem;
        List list2;
        final FinancialItem itemToEdit2;
        final List existingAssetAccounts;
        Composer $composer2;
        final List existingAssetAccounts2;
        final FinancialItem itemToEdit3;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onSave, "onSave");
        Composer $composer3 = $composer.startRestartGroup(-551699144);
        ComposerKt.sourceInformation($composer3, "C(AddEditItemDialog)P(1)23@739L248,30@1004L283,21@672L677:AddEditItemDialog.kt#qonjpd");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            financialItem = itemToEdit;
        } else if (($changed & 6) == 0) {
            financialItem = itemToEdit;
            $dirty |= $composer3.changed(financialItem) ? 4 : 2;
        } else {
            financialItem = itemToEdit;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            list2 = list;
        } else if (($changed & 48) == 0) {
            list2 = list;
            $dirty |= $composer3.changedInstance(list2) ? 32 : 16;
        } else {
            list2 = list;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(onDismiss) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(onSave) ? 2048 : 1024;
        }
        if (($dirty & 1171) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            itemToEdit3 = financialItem;
            existingAssetAccounts2 = list2;
        } else {
            if (i2 != 0) {
                itemToEdit2 = null;
            } else {
                itemToEdit2 = financialItem;
            }
            if (i3 == 0) {
                existingAssetAccounts = list2;
            } else {
                existingAssetAccounts = CollectionsKt.emptyList();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-551699144, $dirty, -1, "com.example.ui.components.AddEditItemDialog (AddEditItemDialog.kt:20)");
            }
            $composer2 = $composer3;
            List existingAssetAccounts3 = existingAssetAccounts;
            FinancialItem itemToEdit4 = itemToEdit2;
            AndroidAlertDialog_androidKt.m1762AlertDialogOix01E0(onDismiss, ComposableSingletons$AddEditItemDialogKt.INSTANCE.m6944getLambda$1533357584$app(), null, ComposableSingletons$AddEditItemDialogKt.INSTANCE.m6943getLambda$1122747218$app(), null, ComposableLambdaKt.rememberComposableLambda(-712136852, true, new Function2() { // from class: com.example.ui.components.AddEditItemDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddEditItemDialogKt.AddEditItemDialog$lambda$0(FinancialItem.this, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(1640651979, true, new Function2() { // from class: com.example.ui.components.AddEditItemDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddEditItemDialogKt.AddEditItemDialog$lambda$1(FinancialItem.this, existingAssetAccounts, onSave, onDismiss, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty >> 6) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            existingAssetAccounts2 = existingAssetAccounts3;
            itemToEdit3 = itemToEdit4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.components.AddEditItemDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddEditItemDialogKt.AddEditItemDialog$lambda$2(FinancialItem.this, existingAssetAccounts2, onDismiss, onSave, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditItemDialog$lambda$0(FinancialItem $itemToEdit, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C26@895L10,24@753L224:AddEditItemDialog.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-712136852, $changed, -1, "com.example.ui.components.AddEditItemDialog.<anonymous> (AddEditItemDialog.kt:24)");
            }
            TextKt.m2693Text4IGK_g($itemToEdit == null ? "Add Financial Entry" : "Edit Financial Entry", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditItemDialog$lambda$1(FinancialItem $itemToEdit, List $existingAssetAccounts, Function1 $onSave, Function0 $onDismiss, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C31@1018L259:AddEditItemDialog.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1640651979, $changed, -1, "com.example.ui.components.AddEditItemDialog.<anonymous> (AddEditItemDialog.kt:31)");
            }
            FinancialAssetFormKt.FinancialAssetForm($itemToEdit, $existingAssetAccounts, $onSave, $onDismiss, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, $composer, 24576, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
