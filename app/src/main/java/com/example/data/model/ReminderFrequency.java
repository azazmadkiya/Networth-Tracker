package com.example.data.model;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FinancialReminder.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/example/data/model/ReminderFrequency;", "", "displayName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "ONE_TIME", "MONTHLY", "QUARTERLY", "YEARLY", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public enum ReminderFrequency {
    ONE_TIME("One-time"),
    MONTHLY("Monthly"),
    QUARTERLY("Quarterly"),
    YEARLY("Yearly");

    private final String displayName;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<ReminderFrequency> getEntries() {
        return $ENTRIES;
    }

    ReminderFrequency(String displayName) {
        this.displayName = displayName;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    /* compiled from: FinancialReminder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/example/data/model/ReminderFrequency$Companion;", "", "<init>", "()V", "fromString", "Lcom/example/data/model/ReminderFrequency;", "value", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReminderFrequency fromString(String value) {
            Object obj;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<E> it = ReminderFrequency.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                ReminderFrequency reminderFrequency = (ReminderFrequency) obj;
                boolean z = true;
                if (!StringsKt.equals(reminderFrequency.name(), value, true) && !StringsKt.equals(reminderFrequency.getDisplayName(), value, true)) {
                    z = false;
                }
                if (z) {
                    break;
                }
            }
            ReminderFrequency reminderFrequency2 = (ReminderFrequency) obj;
            return reminderFrequency2 == null ? ReminderFrequency.ONE_TIME : reminderFrequency2;
        }
    }
}
