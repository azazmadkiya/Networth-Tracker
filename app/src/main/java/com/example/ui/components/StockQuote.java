package com.example.ui.components;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinancialAssetForm.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014¨\u0006!"}, d2 = {"Lcom/example/ui/components/StockQuote;", "", "symbol", "", "name", "exchange", "currentPrice", "", "changePercent", "isPositive", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDZ)V", "getSymbol", "()Ljava/lang/String;", "getName", "getExchange", "getCurrentPrice", "()D", "getChangePercent", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class StockQuote {
    public static final int $stable = 0;
    private final double changePercent;
    private final double currentPrice;
    private final String exchange;
    private final boolean isPositive;
    private final String name;
    private final String symbol;

    public static /* synthetic */ StockQuote copy$default(StockQuote stockQuote, String str, String str2, String str3, double d, double d2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stockQuote.symbol;
        }
        if ((i & 2) != 0) {
            str2 = stockQuote.name;
        }
        if ((i & 4) != 0) {
            str3 = stockQuote.exchange;
        }
        if ((i & 8) != 0) {
            d = stockQuote.currentPrice;
        }
        if ((i & 16) != 0) {
            d2 = stockQuote.changePercent;
        }
        if ((i & 32) != 0) {
            z = stockQuote.isPositive;
        }
        boolean z2 = z;
        double d3 = d2;
        String str4 = str3;
        return stockQuote.copy(str, str2, str4, d, d3, z2);
    }

        public final String component1() {
        return this.symbol;
    }

        public final String component2() {
        return this.name;
    }

        public final String component3() {
        return this.exchange;
    }

        public final double component4() {
        return this.currentPrice;
    }

        public final double component5() {
        return this.changePercent;
    }

        public final boolean component6() {
        return this.isPositive;
    }

    public final StockQuote copy(String symbol, String name, String exchange, double currentPrice, double changePercent, boolean isPositive) {
        Intrinsics.checkNotNullParameter(symbol, "symbol");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        return new StockQuote(symbol, name, exchange, currentPrice, changePercent, isPositive);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StockQuote)) {
            return false;
        }
        StockQuote stockQuote = (StockQuote) other;
        return Intrinsics.areEqual(this.symbol, stockQuote.symbol) && Intrinsics.areEqual(this.name, stockQuote.name) && Intrinsics.areEqual(this.exchange, stockQuote.exchange) && Double.compare(this.currentPrice, stockQuote.currentPrice) == 0 && Double.compare(this.changePercent, stockQuote.changePercent) == 0 && this.isPositive == stockQuote.isPositive;
    }

    public int hashCode() {
        return (((((((((this.symbol.hashCode() * 31) + this.name.hashCode()) * 31) + this.exchange.hashCode()) * 31) + Double.hashCode(this.currentPrice)) * 31) + Double.hashCode(this.changePercent)) * 31) + Boolean.hashCode(this.isPositive);
    }

    public String toString() {
        return "StockQuote(symbol=" + this.symbol + ", name=" + this.name + ", exchange=" + this.exchange + ", currentPrice=" + this.currentPrice + ", changePercent=" + this.changePercent + ", isPositive=" + this.isPositive + ")";
    }

    public StockQuote(String symbol, String name, String exchange, double currentPrice, double changePercent, boolean isPositive) {
        Intrinsics.checkNotNullParameter(symbol, "symbol");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        this.symbol = symbol;
        this.name = name;
        this.exchange = exchange;
        this.currentPrice = currentPrice;
        this.changePercent = changePercent;
        this.isPositive = isPositive;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public final String getName() {
        return this.name;
    }

    public final String getExchange() {
        return this.exchange;
    }

    public final double getCurrentPrice() {
        return this.currentPrice;
    }

    public final double getChangePercent() {
        return this.changePercent;
    }

    public final boolean isPositive() {
        return this.isPositive;
    }
}
