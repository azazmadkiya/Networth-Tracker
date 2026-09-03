package com.example.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinancialModels.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003Jw\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0006HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016¨\u00062"}, d2 = {"Lcom/example/data/model/LedgerEntry;", "", "id", "", "timestamp", "transactionTitle", "", "accountName", "oppositeAccountName", "entryType", "debitAmount", "", "creditAmount", "runningBalance", "category", "notes", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDDLjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getTimestamp", "getTransactionTitle", "()Ljava/lang/String;", "getAccountName", "getOppositeAccountName", "getEntryType", "getDebitAmount", "()D", "getCreditAmount", "getRunningBalance", "getCategory", "getNotes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class LedgerEntry {
    public static final int $stable = 0;
    private final String accountName;
    private final String category;
    private final double creditAmount;
    private final double debitAmount;
    private final String entryType;
    private final long id;
    private final String notes;
    private final String oppositeAccountName;
    private final double runningBalance;
    private final long timestamp;
    private final String transactionTitle;

        public final long component1() {
        return this.id;
    }

        public final String component10() {
        return this.category;
    }

        public final String component11() {
        return this.notes;
    }

        public final long component2() {
        return this.timestamp;
    }

        public final String component3() {
        return this.transactionTitle;
    }

        public final String component4() {
        return this.accountName;
    }

        public final String component5() {
        return this.oppositeAccountName;
    }

        public final String component6() {
        return this.entryType;
    }

        public final double component7() {
        return this.debitAmount;
    }

        public final double component8() {
        return this.creditAmount;
    }

        public final double component9() {
        return this.runningBalance;
    }

    public final LedgerEntry copy(long id, long timestamp, String transactionTitle, String accountName, String oppositeAccountName, String entryType, double debitAmount, double creditAmount, double runningBalance, String category, String notes) {
        Intrinsics.checkNotNullParameter(transactionTitle, "transactionTitle");
        Intrinsics.checkNotNullParameter(accountName, "accountName");
        Intrinsics.checkNotNullParameter(oppositeAccountName, "oppositeAccountName");
        Intrinsics.checkNotNullParameter(entryType, "entryType");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(notes, "notes");
        return new LedgerEntry(id, timestamp, transactionTitle, accountName, oppositeAccountName, entryType, debitAmount, creditAmount, runningBalance, category, notes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LedgerEntry)) {
            return false;
        }
        LedgerEntry ledgerEntry = (LedgerEntry) other;
        return this.id == ledgerEntry.id && this.timestamp == ledgerEntry.timestamp && Intrinsics.areEqual(this.transactionTitle, ledgerEntry.transactionTitle) && Intrinsics.areEqual(this.accountName, ledgerEntry.accountName) && Intrinsics.areEqual(this.oppositeAccountName, ledgerEntry.oppositeAccountName) && Intrinsics.areEqual(this.entryType, ledgerEntry.entryType) && Double.compare(this.debitAmount, ledgerEntry.debitAmount) == 0 && Double.compare(this.creditAmount, ledgerEntry.creditAmount) == 0 && Double.compare(this.runningBalance, ledgerEntry.runningBalance) == 0 && Intrinsics.areEqual(this.category, ledgerEntry.category) && Intrinsics.areEqual(this.notes, ledgerEntry.notes);
    }

    public int hashCode() {
        return (((((((((((((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.timestamp)) * 31) + this.transactionTitle.hashCode()) * 31) + this.accountName.hashCode()) * 31) + this.oppositeAccountName.hashCode()) * 31) + this.entryType.hashCode()) * 31) + Double.hashCode(this.debitAmount)) * 31) + Double.hashCode(this.creditAmount)) * 31) + Double.hashCode(this.runningBalance)) * 31) + this.category.hashCode()) * 31) + this.notes.hashCode();
    }

    public String toString() {
        return "LedgerEntry(id=" + this.id + ", timestamp=" + this.timestamp + ", transactionTitle=" + this.transactionTitle + ", accountName=" + this.accountName + ", oppositeAccountName=" + this.oppositeAccountName + ", entryType=" + this.entryType + ", debitAmount=" + this.debitAmount + ", creditAmount=" + this.creditAmount + ", runningBalance=" + this.runningBalance + ", category=" + this.category + ", notes=" + this.notes + ")";
    }

    public LedgerEntry(long id, long timestamp, String transactionTitle, String accountName, String oppositeAccountName, String entryType, double debitAmount, double creditAmount, double runningBalance, String category, String notes) {
        Intrinsics.checkNotNullParameter(transactionTitle, "transactionTitle");
        Intrinsics.checkNotNullParameter(accountName, "accountName");
        Intrinsics.checkNotNullParameter(oppositeAccountName, "oppositeAccountName");
        Intrinsics.checkNotNullParameter(entryType, "entryType");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(notes, "notes");
        this.id = id;
        this.timestamp = timestamp;
        this.transactionTitle = transactionTitle;
        this.accountName = accountName;
        this.oppositeAccountName = oppositeAccountName;
        this.entryType = entryType;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.runningBalance = runningBalance;
        this.category = category;
        this.notes = notes;
    }

    public /* synthetic */ LedgerEntry(long j, long j2, String str, String str2, String str3, String str4, double d, double d2, double d3, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? System.currentTimeMillis() : j2, str, str2, (i & 16) != 0 ? "" : str3, str4, (i & 64) != 0 ? 0.0d : d, (i & 128) != 0 ? 0.0d : d2, (i & 256) != 0 ? 0.0d : d3, (i & 512) != 0 ? "Expense" : str5, (i & 1024) != 0 ? "" : str6);
    }

    public final long getId() {
        return this.id;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTransactionTitle() {
        return this.transactionTitle;
    }

    public final String getAccountName() {
        return this.accountName;
    }

    public final String getOppositeAccountName() {
        return this.oppositeAccountName;
    }

    public final String getEntryType() {
        return this.entryType;
    }

    public final double getDebitAmount() {
        return this.debitAmount;
    }

    public final double getCreditAmount() {
        return this.creditAmount;
    }

    public final double getRunningBalance() {
        return this.runningBalance;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getNotes() {
        return this.notes;
    }
}
