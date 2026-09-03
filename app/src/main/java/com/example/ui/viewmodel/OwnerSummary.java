package com.example.ui.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetWorthViewModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006&"}, d2 = {"Lcom/example/ui/viewmodel/OwnerSummary;", "", "owner", "", "totalAssets", "", "totalLiabilities", "netWorth", "percentage", "", "stockWorth", "stockProfitLoss", "<init>", "(Ljava/lang/String;DDDFDD)V", "getOwner", "()Ljava/lang/String;", "getTotalAssets", "()D", "getTotalLiabilities", "getNetWorth", "getPercentage", "()F", "getStockWorth", "getStockProfitLoss", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class OwnerSummary {
    public static final int $stable = 0;
    private final double netWorth;
    private final String owner;
    private final float percentage;
    private final double stockProfitLoss;
    private final double stockWorth;
    private final double totalAssets;
    private final double totalLiabilities;

    public static /* synthetic */ OwnerSummary copy$default(OwnerSummary ownerSummary, String str, double d, double d2, double d3, float f, double d4, double d5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ownerSummary.owner;
        }
        if ((i & 2) != 0) {
            d = ownerSummary.totalAssets;
        }
        if ((i & 4) != 0) {
            d2 = ownerSummary.totalLiabilities;
        }
        if ((i & 8) != 0) {
            d3 = ownerSummary.netWorth;
        }
        if ((i & 16) != 0) {
            f = ownerSummary.percentage;
        }
        if ((i & 32) != 0) {
            d4 = ownerSummary.stockWorth;
        }
        if ((i & 64) != 0) {
            d5 = ownerSummary.stockProfitLoss;
        }
        float f2 = f;
        double d6 = d3;
        double d7 = d2;
        return ownerSummary.copy(str, d, d7, d6, f2, d4, d5);
    }

        public final String component1() {
        return this.owner;
    }

        public final double component2() {
        return this.totalAssets;
    }

        public final double component3() {
        return this.totalLiabilities;
    }

        public final double component4() {
        return this.netWorth;
    }

        public final float component5() {
        return this.percentage;
    }

        public final double component6() {
        return this.stockWorth;
    }

        public final double component7() {
        return this.stockProfitLoss;
    }

    public final OwnerSummary copy(String owner, double totalAssets, double totalLiabilities, double netWorth, float percentage, double stockWorth, double stockProfitLoss) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        return new OwnerSummary(owner, totalAssets, totalLiabilities, netWorth, percentage, stockWorth, stockProfitLoss);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OwnerSummary)) {
            return false;
        }
        OwnerSummary ownerSummary = (OwnerSummary) other;
        return Intrinsics.areEqual(this.owner, ownerSummary.owner) && Double.compare(this.totalAssets, ownerSummary.totalAssets) == 0 && Double.compare(this.totalLiabilities, ownerSummary.totalLiabilities) == 0 && Double.compare(this.netWorth, ownerSummary.netWorth) == 0 && Float.compare(this.percentage, ownerSummary.percentage) == 0 && Double.compare(this.stockWorth, ownerSummary.stockWorth) == 0 && Double.compare(this.stockProfitLoss, ownerSummary.stockProfitLoss) == 0;
    }

    public int hashCode() {
        return (((((((((((this.owner.hashCode() * 31) + Double.hashCode(this.totalAssets)) * 31) + Double.hashCode(this.totalLiabilities)) * 31) + Double.hashCode(this.netWorth)) * 31) + Float.hashCode(this.percentage)) * 31) + Double.hashCode(this.stockWorth)) * 31) + Double.hashCode(this.stockProfitLoss);
    }

    public String toString() {
        return "OwnerSummary(owner=" + this.owner + ", totalAssets=" + this.totalAssets + ", totalLiabilities=" + this.totalLiabilities + ", netWorth=" + this.netWorth + ", percentage=" + this.percentage + ", stockWorth=" + this.stockWorth + ", stockProfitLoss=" + this.stockProfitLoss + ")";
    }

    public OwnerSummary(String owner, double totalAssets, double totalLiabilities, double netWorth, float percentage, double stockWorth, double stockProfitLoss) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        this.totalAssets = totalAssets;
        this.totalLiabilities = totalLiabilities;
        this.netWorth = netWorth;
        this.percentage = percentage;
        this.stockWorth = stockWorth;
        this.stockProfitLoss = stockProfitLoss;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ OwnerSummary(java.lang.String r17, double r18, double r20, double r22, float r24, double r25, double r27, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r16 = this;
            r0 = r29 & 32
            r1 = 0
            if (r0 == 0) goto L8
            r12 = r1
            goto La
        L8:
            r12 = r25
        La:
            r0 = r29 & 64
            if (r0 == 0) goto L10
            r14 = r1
            goto L12
        L10:
            r14 = r27
        L12:
            r3 = r16
            r4 = r17
            r5 = r18
            r7 = r20
            r9 = r22
            r11 = r24
            r3.<init>(r4, r5, r7, r9, r11, r12, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.viewmodel.OwnerSummary.<init>(java.lang.String, double, double, double, float, double, double, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getOwner() {
        return this.owner;
    }

    public final double getTotalAssets() {
        return this.totalAssets;
    }

    public final double getTotalLiabilities() {
        return this.totalLiabilities;
    }

    public final double getNetWorth() {
        return this.netWorth;
    }

    public final float getPercentage() {
        return this.percentage;
    }

    public final double getStockWorth() {
        return this.stockWorth;
    }

    public final double getStockProfitLoss() {
        return this.stockProfitLoss;
    }
}
