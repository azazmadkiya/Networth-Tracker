package com.example.ui.utils

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.abs

object NumberFormatUtils {
    private val currencyFormatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale("en", "IN")).apply {
        maximumFractionDigits = 2
        minimumFractionDigits = 0
    }

    fun formatCurrency(amount: Double): String {
        return try {
            currencyFormatter.format(amount)
        } catch (e: Exception) {
            String.format(Locale.getDefault(), "₹ %,.2f", amount)
        }
    }

    fun formatCompact(amount: Double): String {
        val absVal = abs(amount)
        val prefix = if (amount < 0) "-₹ " else "₹ "
        return when {
            absVal >= 10000000.0 -> prefix + String.format(Locale.US, "%.2f Cr", absVal / 10000000.0)
            absVal >= 100000.0 -> prefix + String.format(Locale.US, "%.2f L", absVal / 100000.0)
            absVal >= 1000.0 -> prefix + String.format(Locale.US, "%.1f K", absVal / 1000.0)
            else -> prefix + String.format(Locale.US, "%.0f", absVal)
        }
    }

    fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }

    fun formatDateShort(timestamp: Long): String {
        val sdf = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }

    fun formatEpochDay(epochDay: Long): String {
        val millis = epochDay * 86400000L
        return formatDateShort(millis)
    }

    fun parseAmount(text: String): Double? {
        val cleaned = text.replace("₹", "")
            .replace("$", "")
            .replace(",", "")
            .trim()
        return cleaned.toDoubleOrNull()
    }
}
