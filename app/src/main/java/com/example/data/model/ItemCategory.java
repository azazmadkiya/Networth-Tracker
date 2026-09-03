package com.example.data.model;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FinancialModels.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001a"}, d2 = {"Lcom/example/data/model/ItemCategory;", "", "displayName", "", "isLiability", "", "iconName", "<init>", "(Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "()Z", "getIconName", "BANK_ACCOUNT", "SHARE_MARKET", "MUTUAL_FUNDS", "IPO", "PAID_LOAN", "GOLD_SILVER", "REAL_ESTATE", "CASH", "OTHER_INVESTMENT", "INCOME", "EXPENSE", "LOAN_LIABILITY", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public enum ItemCategory {
    BANK_ACCOUNT("Bank Account", false, "AccountBalance"),
    SHARE_MARKET("Share Market / Stocks", false, "TrendingUp"),
    MUTUAL_FUNDS("Mutual Funds", false, "PieChart"),
    IPO("IPO Application", false, "ShowChart"),
    PAID_LOAN("Paid Loan / Aapel Loan (આપેલ લોન)", false, "Handshake"),
    GOLD_SILVER("Gold & Silver", false, "Diamond"),
    REAL_ESTATE("Real Estate / Land", false, "Home"),
    CASH("Cash on Hand", false, "Payments"),
    OTHER_INVESTMENT("Other Investments (PF/FD/PPF)", false, "Savings"),
    INCOME("Income / Earnings", false, "TrendingUp"),
    EXPENSE("Expense / Outflow", true, "ShoppingCart"),
    LOAN_LIABILITY("Loans & Dues", true, "CreditCard");

    private final String displayName;
    private final String iconName;
    private final boolean isLiability;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<ItemCategory> getEntries() {
        return $ENTRIES;
    }

    ItemCategory(String displayName, boolean isLiability, String iconName) {
        this.displayName = displayName;
        this.isLiability = isLiability;
        this.iconName = iconName;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    /* synthetic */ ItemCategory(java.lang.String r9, boolean r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 2
            if (r13 == 0) goto L7
            r10 = 0
            r4 = r10
            goto L8
        L7:
            r4 = r10
        L8:
            r10 = r12 & 4
            if (r10 == 0) goto L10
            java.lang.String r11 = "AccountBalance"
            r5 = r11
            goto L11
        L10:
            r5 = r11
        L11:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r0.<init>(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.data.model.ItemCategory.<init>(java.lang.String, int, java.lang.String, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: isLiability, reason: from getter */
    public final boolean getIsLiability() {
        return this.isLiability;
    }

    public final String getIconName() {
        return this.iconName;
    }

    /* compiled from: FinancialModels.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/example/data/model/ItemCategory$Companion;", "", "<init>", "()V", "fromString", "Lcom/example/data/model/ItemCategory;", "value", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ItemCategory fromString(String value) {
            Object obj;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<E> it = ItemCategory.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                ItemCategory itemCategory = (ItemCategory) obj;
                boolean z = true;
                if (!StringsKt.equals(itemCategory.getDisplayName(), value, true) && !StringsKt.equals(itemCategory.name(), value, true)) {
                    z = false;
                }
                if (z) {
                    break;
                }
            }
            ItemCategory itemCategory2 = (ItemCategory) obj;
            return itemCategory2 == null ? ItemCategory.BANK_ACCOUNT : itemCategory2;
        }
    }
}
