package com.example.ui.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NetWorthViewModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006&"}, d2 = {"Lcom/example/ui/viewmodel/NetWorthSummary;", "", "totalAssets", "", "totalLiabilities", "netWorth", "totalInvested", "totalProfitLoss", "profitLossPercentage", "totalStockWorth", "totalStockProfitLoss", "<init>", "(DDDDDDDD)V", "getTotalAssets", "()D", "getTotalLiabilities", "getNetWorth", "getTotalInvested", "getTotalProfitLoss", "getProfitLossPercentage", "getTotalStockWorth", "getTotalStockProfitLoss", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class NetWorthSummary {
    public static final int $stable = 0;
    private final double netWorth;
    private final double profitLossPercentage;
    private final double totalAssets;
    private final double totalInvested;
    private final double totalLiabilities;
    private final double totalProfitLoss;
    private final double totalStockProfitLoss;
    private final double totalStockWorth;

    public NetWorthSummary() {
        this(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 255, null);
    }

    public static /* synthetic */ NetWorthSummary copy$default(NetWorthSummary netWorthSummary, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, Object obj) {
        double d9;
        double d10;
        double d11 = (i & 1) != 0 ? netWorthSummary.totalAssets : d;
        double d12 = (i & 2) != 0 ? netWorthSummary.totalLiabilities : d2;
        double d13 = (i & 4) != 0 ? netWorthSummary.netWorth : d3;
        double d14 = (i & 8) != 0 ? netWorthSummary.totalInvested : d4;
        double d15 = (i & 16) != 0 ? netWorthSummary.totalProfitLoss : d5;
        double d16 = (i & 32) != 0 ? netWorthSummary.profitLossPercentage : d6;
        double d17 = (i & 64) != 0 ? netWorthSummary.totalStockWorth : d7;
        if ((i & 128) != 0) {
            d9 = netWorthSummary.totalStockProfitLoss;
            d10 = d11;
        } else {
            d9 = d8;
            d10 = d11;
        }
        return netWorthSummary.copy(d10, d12, d13, d14, d15, d16, d17, d9);
    }

        public final double component1() {
        return this.totalAssets;
    }

        public final double component2() {
        return this.totalLiabilities;
    }

        public final double component3() {
        return this.netWorth;
    }

        public final double component4() {
        return this.totalInvested;
    }

        public final double component5() {
        return this.totalProfitLoss;
    }

        public final double component6() {
        return this.profitLossPercentage;
    }

        public final double component7() {
        return this.totalStockWorth;
    }

        public final double component8() {
        return this.totalStockProfitLoss;
    }

    public final NetWorthSummary copy(double totalAssets, double totalLiabilities, double netWorth, double totalInvested, double totalProfitLoss, double profitLossPercentage, double totalStockWorth, double totalStockProfitLoss) {
        return new NetWorthSummary(totalAssets, totalLiabilities, netWorth, totalInvested, totalProfitLoss, profitLossPercentage, totalStockWorth, totalStockProfitLoss);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetWorthSummary)) {
            return false;
        }
        NetWorthSummary netWorthSummary = (NetWorthSummary) other;
        return Double.compare(this.totalAssets, netWorthSummary.totalAssets) == 0 && Double.compare(this.totalLiabilities, netWorthSummary.totalLiabilities) == 0 && Double.compare(this.netWorth, netWorthSummary.netWorth) == 0 && Double.compare(this.totalInvested, netWorthSummary.totalInvested) == 0 && Double.compare(this.totalProfitLoss, netWorthSummary.totalProfitLoss) == 0 && Double.compare(this.profitLossPercentage, netWorthSummary.profitLossPercentage) == 0 && Double.compare(this.totalStockWorth, netWorthSummary.totalStockWorth) == 0 && Double.compare(this.totalStockProfitLoss, netWorthSummary.totalStockProfitLoss) == 0;
    }

    public int hashCode() {
        return (((((((((((((Double.hashCode(this.totalAssets) * 31) + Double.hashCode(this.totalLiabilities)) * 31) + Double.hashCode(this.netWorth)) * 31) + Double.hashCode(this.totalInvested)) * 31) + Double.hashCode(this.totalProfitLoss)) * 31) + Double.hashCode(this.profitLossPercentage)) * 31) + Double.hashCode(this.totalStockWorth)) * 31) + Double.hashCode(this.totalStockProfitLoss);
    }

    public String toString() {
        return "NetWorthSummary(totalAssets=" + this.totalAssets + ", totalLiabilities=" + this.totalLiabilities + ", netWorth=" + this.netWorth + ", totalInvested=" + this.totalInvested + ", totalProfitLoss=" + this.totalProfitLoss + ", profitLossPercentage=" + this.profitLossPercentage + ", totalStockWorth=" + this.totalStockWorth + ", totalStockProfitLoss=" + this.totalStockProfitLoss + ")";
    }

    public NetWorthSummary(double totalAssets, double totalLiabilities, double netWorth, double totalInvested, double totalProfitLoss, double profitLossPercentage, double totalStockWorth, double totalStockProfitLoss) {
        this.totalAssets = totalAssets;
        this.totalLiabilities = totalLiabilities;
        this.netWorth = netWorth;
        this.totalInvested = totalInvested;
        this.totalProfitLoss = totalProfitLoss;
        this.profitLossPercentage = profitLossPercentage;
        this.totalStockWorth = totalStockWorth;
        this.totalStockProfitLoss = totalStockProfitLoss;
    }

    public /* synthetic */ NetWorthSummary(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2, (i & 4) != 0 ? 0.0d : d3, (i & 8) != 0 ? 0.0d : d4, (i & 16) != 0 ? 0.0d : d5, (i & 32) != 0 ? 0.0d : d6, (i & 64) != 0 ? 0.0d : d7, (i & 128) == 0 ? d8 : 0.0d);
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

    public final double getTotalInvested() {
        return this.totalInvested;
    }

    public final double getTotalProfitLoss() {
        return this.totalProfitLoss;
    }

    public final double getProfitLossPercentage() {
        return this.profitLossPercentage;
    }

    public final double getTotalStockWorth() {
        return this.totalStockWorth;
    }

    public final double getTotalStockProfitLoss() {
        return this.totalStockProfitLoss;
    }
}
