package com.example.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinancialReminder.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b*\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0010HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u00108\u001a\u00020\u00102\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010!R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010#\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b$\u0010\u0017R\u0011\u0010%\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b&\u0010\u0017R\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010\u0015R\u0011\u0010)\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b*\u0010!¨\u0006="}, d2 = {"Lcom/example/data/model/FinancialReminder;", "", "id", "", "title", "", "amount", "", "reminderType", "priority", "dueDateEpochDay", "frequency", "owner", "associatedAccount", "notes", "isCompleted", "", "createdAt", "<init>", "(JLjava/lang/String;DLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJ)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "getAmount", "()D", "getReminderType", "getPriority", "getDueDateEpochDay", "getFrequency", "getOwner", "getAssociatedAccount", "getNotes", "()Z", "getCreatedAt", "message", "getMessage", "reminderMessage", "getReminderMessage", "dueDate", "getDueDate", "completionStatus", "getCompletionStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class FinancialReminder {
    public static final int $stable = 0;
    private final double amount;
    private final String associatedAccount;
    private final long createdAt;
    private final long dueDateEpochDay;
    private final String frequency;
    private final long id;
    private final boolean isCompleted;
    private final String notes;
    private final String owner;
    private final String priority;
    private final String reminderType;
    private final String title;

    public static /* synthetic */ FinancialReminder copy$default(FinancialReminder financialReminder, long j, String str, double d, String str2, String str3, long j2, String str4, String str5, String str6, String str7, boolean z, long j3, int i, Object obj) {
        long j4;
        long j5;
        long j6 = (i & 1) != 0 ? financialReminder.id : j;
        String str8 = (i & 2) != 0 ? financialReminder.title : str;
        double d2 = (i & 4) != 0 ? financialReminder.amount : d;
        String str9 = (i & 8) != 0 ? financialReminder.reminderType : str2;
        String str10 = (i & 16) != 0 ? financialReminder.priority : str3;
        long j7 = (i & 32) != 0 ? financialReminder.dueDateEpochDay : j2;
        String str11 = (i & 64) != 0 ? financialReminder.frequency : str4;
        String str12 = (i & 128) != 0 ? financialReminder.owner : str5;
        String str13 = (i & 256) != 0 ? financialReminder.associatedAccount : str6;
        String str14 = (i & 512) != 0 ? financialReminder.notes : str7;
        boolean z2 = (i & 1024) != 0 ? financialReminder.isCompleted : z;
        if ((i & 2048) != 0) {
            j4 = financialReminder.createdAt;
            j5 = j6;
        } else {
            j4 = j3;
            j5 = j6;
        }
        return financialReminder.copy(j5, str8, d2, str9, str10, j7, str11, str12, str13, str14, z2, j4);
    }

        public final long component1() {
        return this.id;
    }

        public final String component10() {
        return this.notes;
    }

        public final boolean component11() {
        return this.isCompleted;
    }

        public final long component12() {
        return this.createdAt;
    }

        public final String component2() {
        return this.title;
    }

        public final double component3() {
        return this.amount;
    }

        public final String component4() {
        return this.reminderType;
    }

        public final String component5() {
        return this.priority;
    }

        public final long component6() {
        return this.dueDateEpochDay;
    }

        public final String component7() {
        return this.frequency;
    }

        public final String component8() {
        return this.owner;
    }

        public final String component9() {
        return this.associatedAccount;
    }

    public final FinancialReminder copy(long id, String title, double amount, String reminderType, String priority, long dueDateEpochDay, String frequency, String owner, String associatedAccount, String notes, boolean isCompleted, long createdAt) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(reminderType, "reminderType");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(frequency, "frequency");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(associatedAccount, "associatedAccount");
        Intrinsics.checkNotNullParameter(notes, "notes");
        return new FinancialReminder(id, title, amount, reminderType, priority, dueDateEpochDay, frequency, owner, associatedAccount, notes, isCompleted, createdAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FinancialReminder)) {
            return false;
        }
        FinancialReminder financialReminder = (FinancialReminder) other;
        return this.id == financialReminder.id && Intrinsics.areEqual(this.title, financialReminder.title) && Double.compare(this.amount, financialReminder.amount) == 0 && Intrinsics.areEqual(this.reminderType, financialReminder.reminderType) && Intrinsics.areEqual(this.priority, financialReminder.priority) && this.dueDateEpochDay == financialReminder.dueDateEpochDay && Intrinsics.areEqual(this.frequency, financialReminder.frequency) && Intrinsics.areEqual(this.owner, financialReminder.owner) && Intrinsics.areEqual(this.associatedAccount, financialReminder.associatedAccount) && Intrinsics.areEqual(this.notes, financialReminder.notes) && this.isCompleted == financialReminder.isCompleted && this.createdAt == financialReminder.createdAt;
    }

    public int hashCode() {
        return (((((((((((((((((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Double.hashCode(this.amount)) * 31) + this.reminderType.hashCode()) * 31) + this.priority.hashCode()) * 31) + Long.hashCode(this.dueDateEpochDay)) * 31) + this.frequency.hashCode()) * 31) + this.owner.hashCode()) * 31) + this.associatedAccount.hashCode()) * 31) + this.notes.hashCode()) * 31) + Boolean.hashCode(this.isCompleted)) * 31) + Long.hashCode(this.createdAt);
    }

    public String toString() {
        return "FinancialReminder(id=" + this.id + ", title=" + this.title + ", amount=" + this.amount + ", reminderType=" + this.reminderType + ", priority=" + this.priority + ", dueDateEpochDay=" + this.dueDateEpochDay + ", frequency=" + this.frequency + ", owner=" + this.owner + ", associatedAccount=" + this.associatedAccount + ", notes=" + this.notes + ", isCompleted=" + this.isCompleted + ", createdAt=" + this.createdAt + ")";
    }

    public FinancialReminder(long id, String title, double amount, String reminderType, String priority, long dueDateEpochDay, String frequency, String owner, String associatedAccount, String notes, boolean isCompleted, long createdAt) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(reminderType, "reminderType");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(frequency, "frequency");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(associatedAccount, "associatedAccount");
        Intrinsics.checkNotNullParameter(notes, "notes");
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.reminderType = reminderType;
        this.priority = priority;
        this.dueDateEpochDay = dueDateEpochDay;
        this.frequency = frequency;
        this.owner = owner;
        this.associatedAccount = associatedAccount;
        this.notes = notes;
        this.isCompleted = isCompleted;
        this.createdAt = createdAt;
    }

    public /* synthetic */ FinancialReminder(long j, String str, double d, String str2, String str3, long j2, String str4, String str5, String str6, String str7, boolean z, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, (i & 4) != 0 ? 0.0d : d, (i & 8) != 0 ? "LOAN_EMI" : str2, (i & 16) != 0 ? "MEDIUM" : str3, j2, (i & 64) != 0 ? "MONTHLY" : str4, (i & 128) != 0 ? "Self" : str5, (i & 256) != 0 ? "" : str6, (i & 512) != 0 ? "" : str7, (i & 1024) != 0 ? false : z, (i & 2048) != 0 ? System.currentTimeMillis() : j3);
    }

    public final long getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final String getReminderType() {
        return this.reminderType;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final long getDueDateEpochDay() {
        return this.dueDateEpochDay;
    }

    public final String getFrequency() {
        return this.frequency;
    }

    public final String getOwner() {
        return this.owner;
    }

    public final String getAssociatedAccount() {
        return this.associatedAccount;
    }

    public final String getNotes() {
        return this.notes;
    }

    public final boolean isCompleted() {
        return this.isCompleted;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getMessage() {
        return this.title;
    }

    public final String getReminderMessage() {
        return this.title;
    }

    public final long getDueDate() {
        return this.dueDateEpochDay;
    }

    public final boolean getCompletionStatus() {
        return this.isCompleted;
    }
}
