package com.example.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinancialModels.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/example/data/model/NetWorthSnapshot;", "", "id", "", "timestamp", "totalAssets", "", "totalLiabilities", "netWorth", "note", "", "<init>", "(JJDDDLjava/lang/String;)V", "getId", "()J", "getTimestamp", "getTotalAssets", "()D", "getTotalLiabilities", "getNetWorth", "getNote", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class NetWorthSnapshot {
    public static final int $stable = 0;
    private final long id;
    private final double netWorth;
    private final String note;
    private final long timestamp;
    private final double totalAssets;
    private final double totalLiabilities;

    public static /* synthetic */ NetWorthSnapshot copy$default(NetWorthSnapshot netWorthSnapshot, long j, long j2, double d, double d2, double d3, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = netWorthSnapshot.id;
        }
        return netWorthSnapshot.copy(j, (i & 2) != 0 ? netWorthSnapshot.timestamp : j2, (i & 4) != 0 ? netWorthSnapshot.totalAssets : d, (i & 8) != 0 ? netWorthSnapshot.totalLiabilities : d2, (i & 16) != 0 ? netWorthSnapshot.netWorth : d3, (i & 32) != 0 ? netWorthSnapshot.note : str);
    }

        public final long component1() {
        return this.id;
    }

        public final long component2() {
        return this.timestamp;
    }

        public final double component3() {
        return this.totalAssets;
    }

        public final double component4() {
        return this.totalLiabilities;
    }

        public final double component5() {
        return this.netWorth;
    }

        public final String component6() {
        return this.note;
    }

    public final NetWorthSnapshot copy(long id, long timestamp, double totalAssets, double totalLiabilities, double netWorth, String note) {
        Intrinsics.checkNotNullParameter(note, "note");
        return new NetWorthSnapshot(id, timestamp, totalAssets, totalLiabilities, netWorth, note);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetWorthSnapshot)) {
            return false;
        }
        NetWorthSnapshot netWorthSnapshot = (NetWorthSnapshot) other;
        return this.id == netWorthSnapshot.id && this.timestamp == netWorthSnapshot.timestamp && Double.compare(this.totalAssets, netWorthSnapshot.totalAssets) == 0 && Double.compare(this.totalLiabilities, netWorthSnapshot.totalLiabilities) == 0 && Double.compare(this.netWorth, netWorthSnapshot.netWorth) == 0 && Intrinsics.areEqual(this.note, netWorthSnapshot.note);
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.timestamp)) * 31) + Double.hashCode(this.totalAssets)) * 31) + Double.hashCode(this.totalLiabilities)) * 31) + Double.hashCode(this.netWorth)) * 31) + this.note.hashCode();
    }

    public String toString() {
        return "NetWorthSnapshot(id=" + this.id + ", timestamp=" + this.timestamp + ", totalAssets=" + this.totalAssets + ", totalLiabilities=" + this.totalLiabilities + ", netWorth=" + this.netWorth + ", note=" + this.note + ")";
    }

    public NetWorthSnapshot(long id, long timestamp, double totalAssets, double totalLiabilities, double netWorth, String note) {
        Intrinsics.checkNotNullParameter(note, "note");
        this.id = id;
        this.timestamp = timestamp;
        this.totalAssets = totalAssets;
        this.totalLiabilities = totalLiabilities;
        this.netWorth = netWorth;
        this.note = note;
    }

    public /* synthetic */ NetWorthSnapshot(long j, long j2, double d, double d2, double d3, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? System.currentTimeMillis() : j2, d, d2, d3, (i & 32) != 0 ? "Routine Snapshot" : str);
    }

    public final long getId() {
        return this.id;
    }

    public final long getTimestamp() {
        return this.timestamp;
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

    public final String getNote() {
        return this.note;
    }
}
