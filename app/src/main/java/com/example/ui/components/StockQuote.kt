package com.example.ui.components

data class StockQuote(
    val symbol: String,
    val name: String,
    val exchange: String,
    val currentPrice: Double,
    val changePercent: Double,
    val isPositive: Boolean
)
