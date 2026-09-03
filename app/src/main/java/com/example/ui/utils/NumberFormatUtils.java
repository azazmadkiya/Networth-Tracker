package com.example.ui.utils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: NumberFormatUtils.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/example/ui/utils/NumberFormatUtils;", "", "<init>", "()V", "formatCurrency", "", "amount", "", "formatCompactCurrency", "formatDate", "timestamp", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NumberFormatUtils {
    public static final int $stable = 0;
    public static final NumberFormatUtils INSTANCE = new NumberFormatUtils();

    private NumberFormatUtils() {
    }

    public final String formatCurrency(double amount) {
        try {
            NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
            format.setMaximumFractionDigits(0);
            String format2 = format.format(amount);
            Intrinsics.checkNotNull(format2);
            return format2;
        } catch (Exception e) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format3 = String.format(Locale.US, "%,.0f", Arrays.copyOf(new Object[]{Double.valueOf(amount)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            return "₹" + format3;
        }
    }

    public final String formatCompactCurrency(double amount) {
        double absVal = Math.abs(amount);
        if (absVal >= 1.0E7d) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "₹%.2f Cr", Arrays.copyOf(new Object[]{Double.valueOf(amount / 1.0E7d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
        if (absVal >= 100000.0d) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(Locale.US, "₹%.2f L", Arrays.copyOf(new Object[]{Double.valueOf(amount / 100000.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        }
        if (absVal >= 1000.0d) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format(Locale.US, "₹%.1f k", Arrays.copyOf(new Object[]{Double.valueOf(amount / 1000.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            return format3;
        }
        return formatCurrency(amount);
    }

    public final String formatDate(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
        String format = sdf.format(new Date(timestamp));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
