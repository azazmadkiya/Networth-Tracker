package com.example.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Asset.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/example/data/model/Asset;", "", "id", "", "name", "", "type", "category", "value", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;D)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getType", "getCategory", "getValue", "()D", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class Asset {
    public static final int $stable = 0;
    private final String category;
    private final long id;
    private final String name;
    private final String type;
    private final double value;

    public static /* synthetic */ Asset copy$default(Asset asset, long j, String str, String str2, String str3, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            j = asset.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = asset.name;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = asset.type;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = asset.category;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            d = asset.value;
        }
        return asset.copy(j2, str4, str5, str6, d);
    }

        public final long component1() {
        return this.id;
    }

        public final String component2() {
        return this.name;
    }

        public final String component3() {
        return this.type;
    }

        public final String component4() {
        return this.category;
    }

        public final double component5() {
        return this.value;
    }

    public final Asset copy(long id, String name, String type, String category, double value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(category, "category");
        return new Asset(id, name, type, category, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) other;
        return this.id == asset.id && Intrinsics.areEqual(this.name, asset.name) && Intrinsics.areEqual(this.type, asset.type) && Intrinsics.areEqual(this.category, asset.category) && Double.compare(this.value, asset.value) == 0;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31) + this.category.hashCode()) * 31) + Double.hashCode(this.value);
    }

    public String toString() {
        return "Asset(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", category=" + this.category + ", value=" + this.value + ")";
    }

    public Asset(long id, String name, String type, String category, double value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(category, "category");
        this.id = id;
        this.name = name;
        this.type = type;
        this.category = category;
        this.value = value;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ Asset(long r9, java.lang.String r11, java.lang.String r12, java.lang.String r13, double r14, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r8 = this;
            r0 = r16 & 1
            if (r0 == 0) goto L8
            r9 = 0
            r1 = r9
            goto L9
        L8:
            r1 = r9
        L9:
            r0 = r8
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r0.<init>(r1, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.data.model.Asset.<init>(long, java.lang.String, java.lang.String, java.lang.String, double, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final String getCategory() {
        return this.category;
    }

    public final double getValue() {
        return this.value;
    }
}
