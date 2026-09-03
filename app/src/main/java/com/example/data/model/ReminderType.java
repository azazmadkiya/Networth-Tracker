package com.example.data.model;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FinancialReminder.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/example/data/model/ReminderType;", "", "displayName", "", "iconName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getIconName", "DUE_DATE", "SIP_INVESTMENT", "LOAN_EMI", "CREDIT_CARD_BILL", "INSURANCE_PREMIUM", "CUSTOM", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public enum ReminderType {
    DUE_DATE("Payment / Bill Due", "Payment"),
    SIP_INVESTMENT("SIP / Mutual Fund", "TrendingUp"),
    LOAN_EMI("Loan EMI / Interest", "CreditCard"),
    CREDIT_CARD_BILL("Credit Card Bill", "AccountBalance"),
    INSURANCE_PREMIUM("Insurance Premium", "Shield"),
    CUSTOM("Custom Reminder", "Notifications");

    private final String displayName;
    private final String iconName;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<ReminderType> getEntries() {
        return $ENTRIES;
    }

    ReminderType(String displayName, String iconName) {
        this.displayName = displayName;
        this.iconName = iconName;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getIconName() {
        return this.iconName;
    }

    /* compiled from: FinancialReminder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/example/data/model/ReminderType$Companion;", "", "<init>", "()V", "fromString", "Lcom/example/data/model/ReminderType;", "value", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReminderType fromString(String value) {
            Object obj;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<E> it = ReminderType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                ReminderType reminderType = (ReminderType) obj;
                boolean z = true;
                if (!StringsKt.equals(reminderType.name(), value, true) && !StringsKt.equals(reminderType.getDisplayName(), value, true)) {
                    z = false;
                }
                if (z) {
                    break;
                }
            }
            ReminderType reminderType2 = (ReminderType) obj;
            return reminderType2 == null ? ReminderType.CUSTOM : reminderType2;
        }
    }
}
