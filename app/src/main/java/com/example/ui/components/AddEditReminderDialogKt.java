package com.example.ui.components;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.Toast;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CreditCardKt;
import androidx.compose.material.icons.filled.NotificationsKt;
import androidx.compose.material.icons.filled.PaymentKt;
import androidx.compose.material.icons.filled.RepeatKt;
import androidx.compose.material.icons.filled.ShieldKt;
import androidx.compose.material.icons.filled.TrendingUpKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
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
import com.example.data.model.FinancialItem;
import com.example.data.model.FinancialReminder;
import com.example.data.model.ReminderFrequency;
import com.example.data.model.ReminderPriority;
import com.example.data.model.ReminderType;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AddEditReminderDialog.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u000f\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010\u0016\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001cX\u008a\u008e\u0002²\u0006\n\u0010\u001d\u001a\u00020\u001cX\u008a\u008e\u0002²\u0006\n\u0010\u001e\u001a\u00020\u001cX\u008a\u008e\u0002"}, d2 = {"AddEditReminderDialog", "", "reminderToEdit", "Lcom/example/data/model/FinancialReminder;", "existingAssetAccounts", "", "Lcom/example/data/model/FinancialItem;", "onDismiss", "Lkotlin/Function0;", "onSave", "Lkotlin/Function1;", "(Lcom/example/data/model/FinancialReminder;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app", "title", "", "amountText", "selectedType", "Lcom/example/data/model/ReminderType;", "selectedPriority", "Lcom/example/data/model/ReminderPriority;", "selectedFrequency", "Lcom/example/data/model/ReminderFrequency;", "selectedOwner", "associatedAccount", "notes", "dueDateEpoch", "", "expandedTypeDropdown", "", "expandedFreqDropdown", "expandedAccountDropdown"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AddEditReminderDialogKt {

    /* compiled from: AddEditReminderDialog.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ReminderType.values().length];
            try {
                iArr[ReminderType.DUE_DATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ReminderType.SIP_INVESTMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ReminderType.LOAN_EMI.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ReminderType.CREDIT_CARD_BILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ReminderType.INSURANCE_PREMIUM.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ReminderType.CUSTOM.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ReminderPriority.values().length];
            try {
                iArr2[ReminderPriority.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[ReminderPriority.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr2[ReminderPriority.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$117(FinancialReminder financialReminder, List list, Function0 function0, Function1 function1, int i, int i2, Composer composer, int i3) {
        AddEditReminderDialog(financialReminder, list, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x017f, code lost:
    
        if (r1 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01c6, code lost:
    
        if (r1 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0212, code lost:
    
        if (r1 != null) goto L105;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AddEditReminderDialog(com.example.data.model.FinancialReminder r43, java.util.List<com.example.data.model.FinancialItem> r44, final kotlin.jvm.functions.Function0<kotlin.Unit> r45, final kotlin.jvm.functions.Function1<? super com.example.data.model.FinancialReminder, kotlin.Unit> r46, androidx.compose.runtime.Composer r47, final int r48, final int r49) {
        /*
            Method dump skipped, instructions count: 1442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.AddEditReminderDialogKt.AddEditReminderDialog(com.example.data.model.FinancialReminder, java.util.List, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final String AddEditReminderDialog$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String AddEditReminderDialog$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final ReminderType AddEditReminderDialog$lambda$8(MutableState<ReminderType> mutableState) {
        return mutableState.getValue();
    }

    private static final ReminderPriority AddEditReminderDialog$lambda$12(MutableState<ReminderPriority> mutableState) {
        return mutableState.getValue();
    }

    private static final ReminderFrequency AddEditReminderDialog$lambda$16(MutableState<ReminderFrequency> mutableState) {
        return mutableState.getValue();
    }

    private static final String AddEditReminderDialog$lambda$19(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String AddEditReminderDialog$lambda$22(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String AddEditReminderDialog$lambda$25(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final long AddEditReminderDialog$lambda$28(MutableState<Long> mutableState) {
        return mutableState.getValue().longValue();
    }

    private static final void AddEditReminderDialog$lambda$29(MutableState<Long> mutableState, long j) {
        mutableState.setValue(Long.valueOf(j));
    }

    private static final boolean AddEditReminderDialog$lambda$33(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AddEditReminderDialog$lambda$34(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean AddEditReminderDialog$lambda$36(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AddEditReminderDialog$lambda$37(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean AddEditReminderDialog$lambda$39(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AddEditReminderDialog$lambda$40(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void AddEditReminderDialog$lambda$44$lambda$43(MutableState $dueDateEpoch$delegate, DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar newCal = Calendar.getInstance();
        newCal.set(1, year);
        newCal.set(2, month);
        newCal.set(5, dayOfMonth);
        newCal.set(11, 9);
        newCal.set(12, 0);
        newCal.set(13, 0);
        newCal.set(14, 0);
        AddEditReminderDialog$lambda$29($dueDateEpoch$delegate, newCal.getTimeInMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x019a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AddEditReminderDialog$lambda$51(com.example.data.model.FinancialReminder r51, androidx.compose.runtime.Composer r52, int r53) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.AddEditReminderDialogKt.AddEditReminderDialog$lambda$51(com.example.data.model.FinancialReminder, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0d72  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0d7e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0db7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0ed9  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0ee5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0f1e  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0fa3  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x102f  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x10af  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x128c  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x1298  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x1356  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x13e2  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x14d2  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x14de  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x1517  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x165c  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x1668  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x169f  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x173e  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x1872  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x18e9  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x1880  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x16b5  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x166e  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x152b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x14e4  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x13f0  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x1368  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x129e  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x145b  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x103d  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0fb5  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0f34 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0eeb  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0dcd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0d84  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0ad7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0a8e  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x094a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0901  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x081b  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0799  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0720 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x05b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0450 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x06d1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x070a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x078b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x080d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x08ef  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x08fb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0934  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0a7c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0a88  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0ac1  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0b43  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AddEditReminderDialog$lambda$116(final java.util.List r139, final androidx.compose.runtime.MutableState r140, final androidx.compose.runtime.MutableState r141, final android.app.DatePickerDialog r142, final java.lang.String r143, final androidx.compose.runtime.MutableState r144, final androidx.compose.runtime.MutableState r145, final androidx.compose.runtime.MutableState r146, androidx.compose.runtime.MutableState r147, final androidx.compose.runtime.MutableState r148, androidx.compose.runtime.MutableState r149, final androidx.compose.runtime.MutableState r150, final androidx.compose.runtime.MutableState r151, final androidx.compose.runtime.MutableState r152, androidx.compose.runtime.Composer r153, int r154) {
        /*
            Method dump skipped, instructions count: 6394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.AddEditReminderDialogKt.AddEditReminderDialog$lambda$116(java.util.List, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, android.app.DatePickerDialog, java.lang.String, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$53$lambda$52(MutableState $title$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $title$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        if (new kotlin.text.Regex("^\\d*\\.?\\d*$").matches(r4) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$55$lambda$54(androidx.compose.runtime.MutableState r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 != 0) goto L23
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            kotlin.text.Regex r1 = new kotlin.text.Regex
            java.lang.String r2 = "^\\d*\\.?\\d*$"
            r1.<init>(r2)
            boolean r0 = r1.matches(r0)
            if (r0 == 0) goto L26
        L23:
            AddEditReminderDialog$lambda$5(r3, r4)
        L26:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.AddEditReminderDialogKt.AddEditReminderDialog$lambda$116$lambda$115$lambda$55$lambda$54(androidx.compose.runtime.MutableState, java.lang.String):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$61$lambda$57$lambda$56(DatePickerDialog $datePickerDialog) {
        $datePickerDialog.show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$61$lambda$60(java.lang.String r84, androidx.compose.runtime.Composer r85, int r86) {
        /*
            Method dump skipped, instructions count: 895
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.AddEditReminderDialogKt.AddEditReminderDialog$lambda$116$lambda$115$lambda$61$lambda$60(java.lang.String, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$73$lambda$72$lambda$63$lambda$62(MutableState $expandedTypeDropdown$delegate) {
        AddEditReminderDialog$lambda$34($expandedTypeDropdown$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$73$lambda$72$lambda$64(MutableState $selectedType$delegate, RowScope OutlinedButton, Composer $composer, int $changed) {
        ImageVector icon;
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C242@11777L70,243@11876L39,244@11944L62:AddEditReminderDialog.kt#qonjpd");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(OutlinedButton) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1007068367, $dirty2, -1, "com.example.ui.components.AddEditReminderDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddEditReminderDialog.kt:234)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[AddEditReminderDialog$lambda$8($selectedType$delegate).ordinal()]) {
                case 1:
                    icon = PaymentKt.getPayment(Icons.INSTANCE.getDefault());
                    break;
                case 2:
                    icon = TrendingUpKt.getTrendingUp(Icons.INSTANCE.getDefault());
                    break;
                case 3:
                    icon = CreditCardKt.getCreditCard(Icons.INSTANCE.getDefault());
                    break;
                case 4:
                    icon = CreditCardKt.getCreditCard(Icons.INSTANCE.getDefault());
                    break;
                case 5:
                    icon = ShieldKt.getShield(Icons.INSTANCE.getDefault());
                    break;
                case 6:
                    icon = NotificationsKt.getNotifications(Icons.INSTANCE.getDefault());
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            IconKt.m2150Iconww6aTOc(icon, (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(18)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(8)), $composer, 6);
            TextKt.m2693Text4IGK_g(AddEditReminderDialog$lambda$8($selectedType$delegate).getDisplayName(), RowScope.weight$default(OutlinedButton, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$73$lambda$72$lambda$66$lambda$65(MutableState $expandedTypeDropdown$delegate) {
        AddEditReminderDialog$lambda$34($expandedTypeDropdown$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$73$lambda$72$lambda$71(final MutableState $selectedType$delegate, final MutableState $expandedTypeDropdown$delegate, ColumnScope DropdownMenu, Composer $composer, int $changed) {
        Object obj;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C*252@12400L26,253@12474L168,251@12339L337:AddEditReminderDialog.kt#qonjpd");
        if (($changed & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(669433212, $changed, -1, "com.example.ui.components.AddEditReminderDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddEditReminderDialog.kt:250)");
            }
            for (final ReminderType reminderType : ReminderType.getEntries()) {
                ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1975318839, true, new Function2() { // from class: com.example.ui.components.AddEditReminderDialogKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return AddEditReminderDialogKt.AddEditReminderDialog$lambda$116$lambda$115$lambda$73$lambda$72$lambda$71$lambda$70$lambda$67(ReminderType.this, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54);
                ComposerKt.sourceInformationMarkerStart(composer, -703664113, "CC(remember):AddEditReminderDialog.kt#9igjgp");
                boolean changed = composer.changed(reminderType.ordinal());
                Object rememberedValue = $composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    obj = new Function0() { // from class: com.example.ui.components.AddEditReminderDialogKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AddEditReminderDialogKt.AddEditReminderDialog$lambda$116$lambda$115$lambda$73$lambda$72$lambda$71$lambda$70$lambda$69$lambda$68(ReminderType.this, $selectedType$delegate, $expandedTypeDropdown$delegate);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AndroidMenu_androidKt.DropdownMenuItem(rememberComposableLambda, (Function0) obj, null, null, null, false, null, null, null, composer, 6, 508);
                composer = $composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$73$lambda$72$lambda$71$lambda$70$lambda$67(ReminderType $type, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C252@12402L22:AddEditReminderDialog.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1975318839, $changed, -1, "com.example.ui.components.AddEditReminderDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddEditReminderDialog.kt:252)");
            }
            TextKt.m2693Text4IGK_g($type.getDisplayName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$73$lambda$72$lambda$71$lambda$70$lambda$69$lambda$68(ReminderType $type, MutableState $selectedType$delegate, MutableState $expandedTypeDropdown$delegate) {
        $selectedType$delegate.setValue($type);
        AddEditReminderDialog$lambda$34($expandedTypeDropdown$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$80$lambda$79$lambda$78$lambda$75$lambda$74(ReminderPriority $priority, MutableState $selectedPriority$delegate) {
        $selectedPriority$delegate.setValue($priority);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$80$lambda$79$lambda$78$lambda$77(boolean r51, long r52, java.lang.String r54, androidx.compose.runtime.Composer r55, int r56) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.AddEditReminderDialogKt.AddEditReminderDialog$lambda$116$lambda$115$lambda$80$lambda$79$lambda$78$lambda$77(boolean, long, java.lang.String, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$92$lambda$91$lambda$82$lambda$81(MutableState $expandedFreqDropdown$delegate) {
        AddEditReminderDialog$lambda$37($expandedFreqDropdown$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$92$lambda$91$lambda$83(MutableState $selectedFrequency$delegate, RowScope OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C325@16143L86,326@16258L39,327@16326L67:AddEditReminderDialog.kt#qonjpd");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(OutlinedButton) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1987819149, $dirty2, -1, "com.example.ui.components.AddEditReminderDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddEditReminderDialog.kt:325)");
            }
            IconKt.m2150Iconww6aTOc(RepeatKt.getRepeat(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(18)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(8)), $composer, 6);
            TextKt.m2693Text4IGK_g(AddEditReminderDialog$lambda$16($selectedFrequency$delegate).getDisplayName(), RowScope.weight$default(OutlinedButton, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$92$lambda$91$lambda$85$lambda$84(MutableState $expandedFreqDropdown$delegate) {
        AddEditReminderDialog$lambda$37($expandedFreqDropdown$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$92$lambda$91$lambda$90(final MutableState $selectedFrequency$delegate, final MutableState $expandedFreqDropdown$delegate, ColumnScope DropdownMenu, Composer $composer, int $changed) {
        Object obj;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C*335@16792L26,336@16866L173,334@16731L342:AddEditReminderDialog.kt#qonjpd");
        if (($changed & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1650183994, $changed, -1, "com.example.ui.components.AddEditReminderDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddEditReminderDialog.kt:333)");
            }
            for (final ReminderFrequency reminderFrequency : ReminderFrequency.getEntries()) {
                ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-830788291, true, new Function2() { // from class: com.example.ui.components.AddEditReminderDialogKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return AddEditReminderDialogKt.AddEditReminderDialog$lambda$116$lambda$115$lambda$92$lambda$91$lambda$90$lambda$89$lambda$86(ReminderFrequency.this, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54);
                ComposerKt.sourceInformationMarkerStart(composer, 1863596282, "CC(remember):AddEditReminderDialog.kt#9igjgp");
                boolean changed = composer.changed(reminderFrequency.ordinal());
                Object rememberedValue = $composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    obj = new Function0() { // from class: com.example.ui.components.AddEditReminderDialogKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AddEditReminderDialogKt.AddEditReminderDialog$lambda$116$lambda$115$lambda$92$lambda$91$lambda$90$lambda$89$lambda$88$lambda$87(ReminderFrequency.this, $selectedFrequency$delegate, $expandedFreqDropdown$delegate);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AndroidMenu_androidKt.DropdownMenuItem(rememberComposableLambda, (Function0) obj, null, null, null, false, null, null, null, composer, 6, 508);
                composer = $composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$92$lambda$91$lambda$90$lambda$89$lambda$86(ReminderFrequency $freq, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C335@16794L22:AddEditReminderDialog.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-830788291, $changed, -1, "com.example.ui.components.AddEditReminderDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddEditReminderDialog.kt:335)");
            }
            TextKt.m2693Text4IGK_g($freq.getDisplayName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$92$lambda$91$lambda$90$lambda$89$lambda$88$lambda$87(ReminderFrequency $freq, MutableState $selectedFrequency$delegate, MutableState $expandedFreqDropdown$delegate) {
        $selectedFrequency$delegate.setValue($freq);
        AddEditReminderDialog$lambda$37($expandedFreqDropdown$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$106$lambda$105$lambda$94$lambda$93(MutableState $expandedAccountDropdown$delegate) {
        AddEditReminderDialog$lambda$40($expandedAccountDropdown$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$106$lambda$105$lambda$95(MutableState $associatedAccount$delegate, RowScope OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C361@18047L227:AddEditReminderDialog.kt#qonjpd");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(OutlinedButton) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-967018709, $dirty2, -1, "com.example.ui.components.AddEditReminderDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddEditReminderDialog.kt:361)");
            }
            TextKt.m2693Text4IGK_g(!StringsKt.isBlank(AddEditReminderDialog$lambda$22($associatedAccount$delegate)) ? AddEditReminderDialog$lambda$22($associatedAccount$delegate) : "None (Unlinked)", RowScope.weight$default(OutlinedButton, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$106$lambda$105$lambda$97$lambda$96(MutableState $expandedAccountDropdown$delegate) {
        AddEditReminderDialog$lambda$40($expandedAccountDropdown$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$106$lambda$105$lambda$104(List $existingAssetAccounts, final MutableState $associatedAccount$delegate, final MutableState $expandedAccountDropdown$delegate, ColumnScope DropdownMenu, Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C372@18702L174,370@18566L344,*379@19083L42,380@19177L193,378@19018L390:AddEditReminderDialog.kt#qonjpd");
        if (($changed & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1860408024, $changed, -1, "com.example.ui.components.AddEditReminderDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddEditReminderDialog.kt:370)");
            }
            Function2<Composer, Integer, Unit> lambda$2143390376$app = ComposableSingletons$AddEditReminderDialogKt.INSTANCE.getLambda$2143390376$app();
            ComposerKt.sourceInformationMarkerStart(composer, 1145721542, "CC(remember):AddEditReminderDialog.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.AddEditReminderDialogKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddEditReminderDialogKt.AddEditReminderDialog$lambda$116$lambda$115$lambda$106$lambda$105$lambda$104$lambda$99$lambda$98(MutableState.this, $expandedAccountDropdown$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidMenu_androidKt.DropdownMenuItem(lambda$2143390376$app, (Function0) obj, null, null, null, false, null, null, null, composer, 54, 508);
            Iterator it = $existingAssetAccounts.iterator();
            while (it.hasNext()) {
                final FinancialItem financialItem = (FinancialItem) it.next();
                ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-846830323, true, new Function2() { // from class: com.example.ui.components.AddEditReminderDialogKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return AddEditReminderDialogKt.AddEditReminderDialog$lambda$116$lambda$115$lambda$106$lambda$105$lambda$104$lambda$103$lambda$100(FinancialItem.this, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer, 54);
                ComposerKt.sourceInformationMarkerStart(composer, 1387079742, "CC(remember):AddEditReminderDialog.kt#9igjgp");
                boolean changed = composer.changed(financialItem);
                Object rememberedValue2 = $composer.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    obj2 = new Function0() { // from class: com.example.ui.components.AddEditReminderDialogKt$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AddEditReminderDialogKt.AddEditReminderDialog$lambda$116$lambda$115$lambda$106$lambda$105$lambda$104$lambda$103$lambda$102$lambda$101(FinancialItem.this, $associatedAccount$delegate, $expandedAccountDropdown$delegate);
                        }
                    };
                    $composer.updateRememberedValue(obj2);
                } else {
                    obj2 = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AndroidMenu_androidKt.DropdownMenuItem(rememberComposableLambda, (Function0) obj2, null, null, null, false, null, null, null, composer, 6, 508);
                composer = $composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$106$lambda$105$lambda$104$lambda$99$lambda$98(MutableState $associatedAccount$delegate, MutableState $expandedAccountDropdown$delegate) {
        $associatedAccount$delegate.setValue("");
        AddEditReminderDialog$lambda$40($expandedAccountDropdown$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$106$lambda$105$lambda$104$lambda$103$lambda$100(FinancialItem $acc, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C379@19085L38:AddEditReminderDialog.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-846830323, $changed, -1, "com.example.ui.components.AddEditReminderDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddEditReminderDialog.kt:379)");
            }
            TextKt.m2693Text4IGK_g($acc.getTitle() + " (" + $acc.getCategory() + ")", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$106$lambda$105$lambda$104$lambda$103$lambda$102$lambda$101(FinancialItem $acc, MutableState $associatedAccount$delegate, MutableState $expandedAccountDropdown$delegate) {
        $associatedAccount$delegate.setValue($acc.getTitle());
        AddEditReminderDialog$lambda$40($expandedAccountDropdown$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$112$lambda$111$lambda$110$lambda$108$lambda$107(String $owner, MutableState $selectedOwner$delegate) {
        $selectedOwner$delegate.setValue($owner);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$112$lambda$111$lambda$110$lambda$109(String $owner, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C407@20431L29:AddEditReminderDialog.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1721069795, $changed, -1, "com.example.ui.components.AddEditReminderDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddEditReminderDialog.kt:407)");
            }
            TextKt.m2693Text4IGK_g($owner, (Modifier) null, 0L, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3072, 0, 131062);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$116$lambda$115$lambda$114$lambda$113(MutableState $notes$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $notes$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$48(final Context $context, final FinancialReminder $reminderToEdit, final Function1 $onSave, final MutableState $title$delegate, final MutableState $amountText$delegate, final MutableState $selectedType$delegate, final MutableState $selectedPriority$delegate, final MutableState $dueDateEpoch$delegate, final MutableState $selectedFrequency$delegate, final MutableState $selectedOwner$delegate, final MutableState $associatedAccount$delegate, final MutableState $notes$delegate, Composer $composer, int $changed) {
        Object obj;
        final FinancialReminder financialReminder;
        ComposerKt.sourceInformation($composer, "C427@21233L1122,450@22439L94,426@21199L1334:AddEditReminderDialog.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1735808687, $changed, -1, "com.example.ui.components.AddEditReminderDialog.<anonymous> (AddEditReminderDialog.kt:426)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1664840017, "CC(remember):AddEditReminderDialog.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($context) | $composer.changed($reminderToEdit) | $composer.changed($onSave);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.AddEditReminderDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddEditReminderDialogKt.AddEditReminderDialog$lambda$48$lambda$46$lambda$45($context, $reminderToEdit, $onSave, $title$delegate, $amountText$delegate, $selectedType$delegate, $selectedPriority$delegate, $dueDateEpoch$delegate, $selectedFrequency$delegate, $selectedOwner$delegate, $associatedAccount$delegate, $notes$delegate);
                    }
                };
                financialReminder = $reminderToEdit;
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
                financialReminder = $reminderToEdit;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, TestTagKt.testTag(Modifier.INSTANCE, "save_reminder_button"), false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-117105473, true, new Function3() { // from class: com.example.ui.components.AddEditReminderDialogKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return AddEditReminderDialogKt.AddEditReminderDialog$lambda$48$lambda$47(FinancialReminder.this, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, $composer, 54), $composer, 805306416, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$48$lambda$46$lambda$45(Context $context, FinancialReminder $reminderToEdit, Function1 $onSave, MutableState $title$delegate, MutableState $amountText$delegate, MutableState $selectedType$delegate, MutableState $selectedPriority$delegate, MutableState $dueDateEpoch$delegate, MutableState $selectedFrequency$delegate, MutableState $selectedOwner$delegate, MutableState $associatedAccount$delegate, MutableState $notes$delegate) {
        if (StringsKt.isBlank(AddEditReminderDialog$lambda$1($title$delegate))) {
            Toast.makeText($context, "Please enter a reminder title", 0).show();
            return Unit.INSTANCE;
        }
        Double doubleOrNull = StringsKt.toDoubleOrNull(AddEditReminderDialog$lambda$4($amountText$delegate));
        double amount = doubleOrNull != null ? doubleOrNull.doubleValue() : 0.0d;
        FinancialReminder newReminder = new FinancialReminder($reminderToEdit != null ? $reminderToEdit.getId() : 0L, StringsKt.trim((CharSequence) AddEditReminderDialog$lambda$1($title$delegate)).toString(), amount, AddEditReminderDialog$lambda$8($selectedType$delegate).name(), AddEditReminderDialog$lambda$12($selectedPriority$delegate).name(), AddEditReminderDialog$lambda$28($dueDateEpoch$delegate), AddEditReminderDialog$lambda$16($selectedFrequency$delegate).name(), AddEditReminderDialog$lambda$19($selectedOwner$delegate), StringsKt.trim((CharSequence) AddEditReminderDialog$lambda$22($associatedAccount$delegate)).toString(), StringsKt.trim((CharSequence) AddEditReminderDialog$lambda$25($notes$delegate)).toString(), $reminderToEdit != null ? $reminderToEdit.isCompleted() : false, $reminderToEdit != null ? $reminderToEdit.getCreatedAt() : System.currentTimeMillis());
        $onSave.invoke(newReminder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$48$lambda$47(FinancialReminder $reminderToEdit, RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C451@22457L62:AddEditReminderDialog.kt#qonjpd");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-117105473, $changed, -1, "com.example.ui.components.AddEditReminderDialog.<anonymous>.<anonymous> (AddEditReminderDialog.kt:451)");
            }
            TextKt.m2693Text4IGK_g($reminderToEdit == null ? "Add Reminder" : "Update", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AddEditReminderDialog$lambda$49(Function0 $onDismiss, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C455@22583L179:AddEditReminderDialog.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-664824723, $changed, -1, "com.example.ui.components.AddEditReminderDialog.<anonymous> (AddEditReminderDialog.kt:455)");
            }
            ButtonKt.TextButton($onDismiss, TestTagKt.testTag(Modifier.INSTANCE, "cancel_reminder_button"), false, null, null, null, null, null, null, ComposableSingletons$AddEditReminderDialogKt.INSTANCE.getLambda$283325520$app(), $composer, 805306416, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
