package com.example.ui.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetWorthViewModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/example/ui/viewmodel/CategorySummary;", "", "category", "", "totalValue", "", "percentage", "", "isLiability", "", "<init>", "(Ljava/lang/String;DFZ)V", "getCategory", "()Ljava/lang/String;", "getTotalValue", "()D", "getPercentage", "()F", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class CategorySummary {
    public static final int $stable = 0;
    private final String category;
    private final boolean isLiability;
    private final float percentage;
    private final double totalValue;

    public static /* synthetic */ CategorySummary copy$default(CategorySummary categorySummary, String str, double d, float f, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = categorySummary.category;
        }
        if ((i & 2) != 0) {
            d = categorySummary.totalValue;
        }
        if ((i & 4) != 0) {
            f = categorySummary.percentage;
        }
        if ((i & 8) != 0) {
            z = categorySummary.isLiability;
        }
        return categorySummary.copy(str, d, f, z);
    }

        public final String component1() {
        return this.category;
    }

        public final double component2() {
        return this.totalValue;
    }

        public final float component3() {
        return this.percentage;
    }

        public final boolean component4() {
        return this.isLiability;
    }

    public final CategorySummary copy(String category, double totalValue, float percentage, boolean isLiability) {
        Intrinsics.checkNotNullParameter(category, "category");
        return new CategorySummary(category, totalValue, percentage, isLiability);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CategorySummary)) {
            return false;
        }
        CategorySummary categorySummary = (CategorySummary) other;
        return Intrinsics.areEqual(this.category, categorySummary.category) && Double.compare(this.totalValue, categorySummary.totalValue) == 0 && Float.compare(this.percentage, categorySummary.percentage) == 0 && this.isLiability == categorySummary.isLiability;
    }

    public int hashCode() {
        return (((((this.category.hashCode() * 31) + Double.hashCode(this.totalValue)) * 31) + Float.hashCode(this.percentage)) * 31) + Boolean.hashCode(this.isLiability);
    }

    public String toString() {
        return "CategorySummary(category=" + this.category + ", totalValue=" + this.totalValue + ", percentage=" + this.percentage + ", isLiability=" + this.isLiability + ")";
    }

    public CategorySummary(String category, double totalValue, float percentage, boolean isLiability) {
        Intrinsics.checkNotNullParameter(category, "category");
        this.category = category;
        this.totalValue = totalValue;
        this.percentage = percentage;
        this.isLiability = isLiability;
    }

    public final String getCategory() {
        return this.category;
    }

    public final double getTotalValue() {
        return this.totalValue;
    }

    public final float getPercentage() {
        return this.percentage;
    }

    public final boolean isLiability() {
        return this.isLiability;
    }
}
