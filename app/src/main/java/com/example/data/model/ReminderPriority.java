package com.example.data.model;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FinancialReminder.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/example/data/model/ReminderPriority;", "", "displayName", "", "level", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getDisplayName", "()Ljava/lang/String;", "getLevel", "()I", "HIGH", "MEDIUM", "LOW", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public enum ReminderPriority {
    HIGH("High", 3),
    MEDIUM("Medium", 2),
    LOW("Low", 1);

    private final String displayName;
    private final int level;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<ReminderPriority> getEntries() {
        return $ENTRIES;
    }

    ReminderPriority(String displayName, int level) {
        this.displayName = displayName;
        this.level = level;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final int getLevel() {
        return this.level;
    }

    /* compiled from: FinancialReminder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/example/data/model/ReminderPriority$Companion;", "", "<init>", "()V", "fromString", "Lcom/example/data/model/ReminderPriority;", "value", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReminderPriority fromString(String value) {
            Object obj;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<E> it = ReminderPriority.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                ReminderPriority reminderPriority = (ReminderPriority) obj;
                boolean z = true;
                if (!StringsKt.equals(reminderPriority.name(), value, true) && !StringsKt.equals(reminderPriority.getDisplayName(), value, true)) {
                    z = false;
                }
                if (z) {
                    break;
                }
            }
            ReminderPriority reminderPriority2 = (ReminderPriority) obj;
            return reminderPriority2 == null ? ReminderPriority.MEDIUM : reminderPriority2;
        }
    }
}
