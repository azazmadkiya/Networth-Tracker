package com.example.data.model;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FinancialModels.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/example/data/model/OwnerProfile;", "", "displayName", "", "badgeColorHex", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;J)V", "getDisplayName", "()Ljava/lang/String;", "getBadgeColorHex", "()J", "SELF", "FATHER", "MOTHER", "FAMILY", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public enum OwnerProfile {
    SELF("Self", 4278355143L),
    FATHER("Father", 4278556265L),
    MOTHER("Mother", 4287837162L),
    FAMILY("Family Joint", 4292441862L);

    private final long badgeColorHex;
    private final String displayName;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<OwnerProfile> getEntries() {
        return $ENTRIES;
    }

    OwnerProfile(String displayName, long badgeColorHex) {
        this.displayName = displayName;
        this.badgeColorHex = badgeColorHex;
    }

    public final long getBadgeColorHex() {
        return this.badgeColorHex;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    /* compiled from: FinancialModels.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/example/data/model/OwnerProfile$Companion;", "", "<init>", "()V", "fromString", "Lcom/example/data/model/OwnerProfile;", "value", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OwnerProfile fromString(String value) {
            Object obj;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<E> it = OwnerProfile.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                OwnerProfile ownerProfile = (OwnerProfile) obj;
                boolean z = true;
                if (!StringsKt.equals(ownerProfile.getDisplayName(), value, true) && !StringsKt.equals(ownerProfile.name(), value, true)) {
                    z = false;
                }
                if (z) {
                    break;
                }
            }
            OwnerProfile ownerProfile2 = (OwnerProfile) obj;
            return ownerProfile2 == null ? OwnerProfile.SELF : ownerProfile2;
        }
    }
}
