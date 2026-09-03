package com.example.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Reminder.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003JO\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0019\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u001b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015¨\u0006*"}, d2 = {"Lcom/example/data/model/Reminder;", "", "id", "", "message", "", "dueDate", "priority", "isCompleted", "", "amount", "", "category", "<init>", "(JLjava/lang/String;JLjava/lang/String;ZDLjava/lang/String;)V", "getId", "()J", "getMessage", "()Ljava/lang/String;", "getDueDate", "getPriority", "()Z", "getAmount", "()D", "getCategory", "reminderMessage", "getReminderMessage", "completionStatus", "getCompletionStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class Reminder {
    public static final int $stable = 0;
    private final double amount;
    private final String category;
    private final long dueDate;
    private final long id;
    private final boolean isCompleted;
    private final String message;
    private final String priority;

    public Reminder() {
        this(0L, null, 0L, null, false, 0.0d, null, 127, null);
    }

    public static /* synthetic */ Reminder copy$default(Reminder reminder, long j, String str, long j2, String str2, boolean z, double d, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = reminder.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = reminder.message;
        }
        return reminder.copy(j3, str, (i & 4) != 0 ? reminder.dueDate : j2, (i & 8) != 0 ? reminder.priority : str2, (i & 16) != 0 ? reminder.isCompleted : z, (i & 32) != 0 ? reminder.amount : d, (i & 64) != 0 ? reminder.category : str3);
    }

        public final long component1() {
        return this.id;
    }

        public final String component2() {
        return this.message;
    }

        public final long component3() {
        return this.dueDate;
    }

        public final String component4() {
        return this.priority;
    }

        public final boolean component5() {
        return this.isCompleted;
    }

        public final double component6() {
        return this.amount;
    }

        public final String component7() {
        return this.category;
    }

    public final Reminder copy(long id, String message, long dueDate, String priority, boolean isCompleted, double amount, String category) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(category, "category");
        return new Reminder(id, message, dueDate, priority, isCompleted, amount, category);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Reminder)) {
            return false;
        }
        Reminder reminder = (Reminder) other;
        return this.id == reminder.id && Intrinsics.areEqual(this.message, reminder.message) && this.dueDate == reminder.dueDate && Intrinsics.areEqual(this.priority, reminder.priority) && this.isCompleted == reminder.isCompleted && Double.compare(this.amount, reminder.amount) == 0 && Intrinsics.areEqual(this.category, reminder.category);
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.id) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.dueDate)) * 31) + this.priority.hashCode()) * 31) + Boolean.hashCode(this.isCompleted)) * 31) + Double.hashCode(this.amount)) * 31) + this.category.hashCode();
    }

    public String toString() {
        return "Reminder(id=" + this.id + ", message=" + this.message + ", dueDate=" + this.dueDate + ", priority=" + this.priority + ", isCompleted=" + this.isCompleted + ", amount=" + this.amount + ", category=" + this.category + ")";
    }

    public Reminder(long id, String message, long dueDate, String priority, boolean isCompleted, double amount, String category) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(category, "category");
        this.id = id;
        this.message = message;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isCompleted = isCompleted;
        this.amount = amount;
        this.category = category;
    }

    public /* synthetic */ Reminder(long j, String str, long j2, String str2, boolean z, double d, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? System.currentTimeMillis() : j2, (i & 8) != 0 ? "MEDIUM" : str2, (i & 16) != 0 ? false : z, (i & 32) != 0 ? 0.0d : d, (i & 64) != 0 ? "Financial" : str3);
    }

    public final long getId() {
        return this.id;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getDueDate() {
        return this.dueDate;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final boolean isCompleted() {
        return this.isCompleted;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getReminderMessage() {
        return this.message;
    }

    public final boolean getCompletionStatus() {
        return this.isCompleted;
    }
}
