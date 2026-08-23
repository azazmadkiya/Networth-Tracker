package com.example.ui.utils

import java.text.NumberFormat
import java.util.Locale

object NumberFormatUtils {
    fun formatCurrency(amount: Double): String {
        return try {
            val format = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
            format.maximumFractionDigits = 0
            format.format(amount)
        } catch (e: Exception) {
            "₹" + String.format(Locale.US, "%,.0f", amount)
        }
    }

    fun formatCompactCurrency(amount: Double): String {
        val absVal = Math.abs(amount)
        return when {
            absVal >= 1_00_00_000 -> String.format(Locale.US, "₹%.2f Cr", amount / 1_00_00_000)
            absVal >= 1_00_000 -> String.format(Locale.US, "₹%.2f L", amount / 1_00_000)
            absVal >= 1_000 -> String.format(Locale.US, "₹%.1f k", amount / 1_000)
            else -> formatCurrency(amount)
        }
    }

    fun formatDate(timestamp: Long): String {
        val sdf = java.text.SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        return sdf.format(java.util.Date(timestamp))
    }
}
