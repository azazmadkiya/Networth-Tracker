package com.example.ui.viewmodel

data class NetWorthSummary(
    val totalAssets: Double = 0.0,
    val totalLiabilities: Double = 0.0,
    val netWorth: Double = 0.0,
    val totalInvested: Double = 0.0,
    val totalProfitLoss: Double = 0.0,
    val profitLossPercentage: Double = 0.0,
    val totalStockWorth: Double = 0.0,
    val totalStockProfitLoss: Double = 0.0
)

data class CategorySummary(
    val category: String,
    val totalValue: Double,
    val percentage: Float,
    val isLiability: Boolean
)

data class OwnerSummary(
    val owner: String,
    val totalAssets: Double,
    val totalLiabilities: Double,
    val netWorth: Double,
    val percentage: Float,
    val stockWorth: Double = 0.0,
    val stockProfitLoss: Double = 0.0
)
