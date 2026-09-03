package com.example.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinancialModels.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u00100\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015¨\u00065"}, d2 = {"Lcom/example/data/model/FinancialItem;", "", "id", "", "title", "", "institution", "accountNumber", "owner", "category", "currentValue", "", "investedValue", "isLiability", "", "notes", "sourceAccountTitle", "updatedAt", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDZLjava/lang/String;Ljava/lang/String;J)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "getInstitution", "getAccountNumber", "getOwner", "getCategory", "getCurrentValue", "()D", "getInvestedValue", "()Z", "getNotes", "getSourceAccountTitle", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class FinancialItem {
    public static final int $stable = 0;
    private final String accountNumber;
    private final String category;
    private final double currentValue;
    private final long id;
    private final String institution;
    private final double investedValue;
    private final boolean isLiability;
    private final String notes;
    private final String owner;
    private final String sourceAccountTitle;
    private final String title;
    private final long updatedAt;

    public static /* synthetic */ FinancialItem copy$default(FinancialItem financialItem, long j, String str, String str2, String str3, String str4, String str5, double d, double d2, boolean z, String str6, String str7, long j2, int i, Object obj) {
        long j3;
        long j4;
        long j5 = (i & 1) != 0 ? financialItem.id : j;
        String str8 = (i & 2) != 0 ? financialItem.title : str;
        String str9 = (i & 4) != 0 ? financialItem.institution : str2;
        String str10 = (i & 8) != 0 ? financialItem.accountNumber : str3;
        String str11 = (i & 16) != 0 ? financialItem.owner : str4;
        String str12 = (i & 32) != 0 ? financialItem.category : str5;
        double d3 = (i & 64) != 0 ? financialItem.currentValue : d;
        double d4 = (i & 128) != 0 ? financialItem.investedValue : d2;
        boolean z2 = (i & 256) != 0 ? financialItem.isLiability : z;
        String str13 = (i & 512) != 0 ? financialItem.notes : str6;
        String str14 = (i & 1024) != 0 ? financialItem.sourceAccountTitle : str7;
        if ((i & 2048) != 0) {
            j3 = financialItem.updatedAt;
            j4 = j5;
        } else {
            j3 = j2;
            j4 = j5;
        }
        return financialItem.copy(j4, str8, str9, str10, str11, str12, d3, d4, z2, str13, str14, j3);
    }

        public final long component1() {
        return this.id;
    }

        public final String component10() {
        return this.notes;
    }

        public final String component11() {
        return this.sourceAccountTitle;
    }

        public final long component12() {
        return this.updatedAt;
    }

        public final String component2() {
        return this.title;
    }

        public final String component3() {
        return this.institution;
    }

        public final String component4() {
        return this.accountNumber;
    }

        public final String component5() {
        return this.owner;
    }

        public final String component6() {
        return this.category;
    }

        public final double component7() {
        return this.currentValue;
    }

        public final double component8() {
        return this.investedValue;
    }

        public final boolean component9() {
        return this.isLiability;
    }

    public final FinancialItem copy(long id, String title, String institution, String accountNumber, String owner, String category, double currentValue, double investedValue, boolean isLiability, String notes, String sourceAccountTitle, long updatedAt) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(institution, "institution");
        Intrinsics.checkNotNullParameter(accountNumber, "accountNumber");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(notes, "notes");
        Intrinsics.checkNotNullParameter(sourceAccountTitle, "sourceAccountTitle");
        return new FinancialItem(id, title, institution, accountNumber, owner, category, currentValue, investedValue, isLiability, notes, sourceAccountTitle, updatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FinancialItem)) {
            return false;
        }
        FinancialItem financialItem = (FinancialItem) other;
        return this.id == financialItem.id && Intrinsics.areEqual(this.title, financialItem.title) && Intrinsics.areEqual(this.institution, financialItem.institution) && Intrinsics.areEqual(this.accountNumber, financialItem.accountNumber) && Intrinsics.areEqual(this.owner, financialItem.owner) && Intrinsics.areEqual(this.category, financialItem.category) && Double.compare(this.currentValue, financialItem.currentValue) == 0 && Double.compare(this.investedValue, financialItem.investedValue) == 0 && this.isLiability == financialItem.isLiability && Intrinsics.areEqual(this.notes, financialItem.notes) && Intrinsics.areEqual(this.sourceAccountTitle, financialItem.sourceAccountTitle) && this.updatedAt == financialItem.updatedAt;
    }

    public int hashCode() {
        return (((((((((((((((((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.institution.hashCode()) * 31) + this.accountNumber.hashCode()) * 31) + this.owner.hashCode()) * 31) + this.category.hashCode()) * 31) + Double.hashCode(this.currentValue)) * 31) + Double.hashCode(this.investedValue)) * 31) + Boolean.hashCode(this.isLiability)) * 31) + this.notes.hashCode()) * 31) + this.sourceAccountTitle.hashCode()) * 31) + Long.hashCode(this.updatedAt);
    }

    public String toString() {
        return "FinancialItem(id=" + this.id + ", title=" + this.title + ", institution=" + this.institution + ", accountNumber=" + this.accountNumber + ", owner=" + this.owner + ", category=" + this.category + ", currentValue=" + this.currentValue + ", investedValue=" + this.investedValue + ", isLiability=" + this.isLiability + ", notes=" + this.notes + ", sourceAccountTitle=" + this.sourceAccountTitle + ", updatedAt=" + this.updatedAt + ")";
    }

    public FinancialItem(long id, String title, String institution, String accountNumber, String owner, String category, double currentValue, double investedValue, boolean isLiability, String notes, String sourceAccountTitle, long updatedAt) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(institution, "institution");
        Intrinsics.checkNotNullParameter(accountNumber, "accountNumber");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(notes, "notes");
        Intrinsics.checkNotNullParameter(sourceAccountTitle, "sourceAccountTitle");
        this.id = id;
        this.title = title;
        this.institution = institution;
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.category = category;
        this.currentValue = currentValue;
        this.investedValue = investedValue;
        this.isLiability = isLiability;
        this.notes = notes;
        this.sourceAccountTitle = sourceAccountTitle;
        this.updatedAt = updatedAt;
    }

    public /* synthetic */ FinancialItem(long j, String str, String str2, String str3, String str4, String str5, double d, double d2, boolean z, String str6, String str7, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "Self" : str4, (i & 32) != 0 ? "Bank Account" : str5, (i & 64) != 0 ? 0.0d : d, (i & 128) == 0 ? d2 : 0.0d, (i & 256) != 0 ? false : z, (i & 512) != 0 ? "" : str6, (i & 1024) != 0 ? "" : str7, (i & 2048) != 0 ? System.currentTimeMillis() : j2);
    }

    public final long getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getInstitution() {
        return this.institution;
    }

    public final String getAccountNumber() {
        return this.accountNumber;
    }

    public final String getOwner() {
        return this.owner;
    }

    public final String getCategory() {
        return this.category;
    }

    public final double getCurrentValue() {
        return this.currentValue;
    }

    public final double getInvestedValue() {
        return this.investedValue;
    }

    public final boolean isLiability() {
        return this.isLiability;
    }

    public final String getNotes() {
        return this.notes;
    }

    public final String getSourceAccountTitle() {
        return this.sourceAccountTitle;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }
}
