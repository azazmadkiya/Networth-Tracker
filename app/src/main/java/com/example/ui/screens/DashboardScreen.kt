package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.model.FinancialItem
import com.example.data.model.OwnerProfile
import com.example.ui.components.NetWorthTrendChart
import com.example.ui.utils.NumberFormatUtils
import com.example.ui.viewmodel.CategorySummary
import com.example.ui.viewmodel.NetWorthViewModel
import com.example.ui.viewmodel.OwnerSummary

import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import com.example.ui.components.GLOBAL_STOCK_LIST

@Composable
fun DashboardScreen(
    viewModel: NetWorthViewModel,
    onAddNewItem: () -> Unit,
    onNavigateToAssets: () -> Unit,
    onEditItem: (FinancialItem) -> Unit
) {
    val summary by viewModel.summary.collectAsStateWithLifecycle()
    val snapshots by viewModel.snapshots.collectAsStateWithLifecycle()
    val selectedOwner by viewModel.selectedOwnerFilter.collectAsStateWithLifecycle()
    val categorySummaries by viewModel.categorySummaries.collectAsStateWithLifecycle()
    val ownerSummaries by viewModel.ownerSummaries.collectAsStateWithLifecycle()
    val items by viewModel.filteredItems.collectAsStateWithLifecycle()
    val isLiveTracking by viewModel.isLiveStockTracking.collectAsStateWithLifecycle()
    val liveTickCount by viewModel.liveTickCount.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { Spacer(modifier = Modifier.height(8.dp)) }

            // Category / Profile Filter Chip Component
            item {
                Text(
                    text = "Filter Assets by Category",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(4.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.testTag("owner_filter_row")
                ) {
                    val filterCategories = listOf("All", "Self", "Father", "Mother")
                    items(filterCategories) { category ->
                        val isSelected = selectedOwner.equals(category, ignoreCase = true)
                        FilterChip(
                            selected = isSelected,
                            onClick = { viewModel.selectedOwnerFilter.value = category },
                            label = {
                                Text(
                                    text = if (category == "All") "All Assets" else category,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            leadingIcon = if (isSelected) {
                                { Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp)) }
                            } else null,
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                            ),
                            modifier = Modifier.testTag("filter_chip_${category.lowercase()}")
                        )
                    }
                }
            }

            // Hero Net Worth Display Card
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("net_worth_hero_card"),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        Color(0xFF0F172A), // Dark Navy
                                        Color(0xFF064E3B)  // Dark Emerald
                                    )
                                )
                            )
                            .padding(20.dp)
                    ) {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Surface(
                                        shape = CircleShape,
                                        color = Color(0xFF10B981).copy(alpha = 0.2f),
                                        modifier = Modifier.size(32.dp)
                                    ) {
                                        Box(contentAlignment = Alignment.Center) {
                                            Icon(
                                                imageVector = Icons.Default.Shield,
                                                contentDescription = null,
                                                tint = Color(0xFF34D399),
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = if (selectedOwner == "All") "TOTAL FAMILY NET WORTH" else "$selectedOwner'S NET WORTH",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFA7F3D0),
                                        letterSpacing = 1.sp
                                    )
                                }

                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = Color.White.copy(alpha = 0.15f),
                                    modifier = Modifier
                                        .clickable { viewModel.refreshAndRecalculateAll() }
                                        .testTag("dashboard_refresh_button")
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Refresh,
                                            contentDescription = "Re Fresh",
                                            tint = Color(0xFF6EE7B7),
                                            modifier = Modifier.size(14.dp)
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(text = "Re Fresh", fontSize = 11.sp, color = Color(0xFF6EE7B7), fontWeight = FontWeight.SemiBold)
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = NumberFormatUtils.formatCurrency(summary.netWorth),
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            // Assets vs Liabilities Split Bar
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(Icons.Default.ArrowUpward, contentDescription = "Assets", tint = Color(0xFF34D399), modifier = Modifier.size(16.dp))
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text("Total Assets", fontSize = 12.sp, color = Color(0xFFCBD5E1))
                                    }
                                    Text(
                                        text = NumberFormatUtils.formatCompactCurrency(summary.totalAssets),
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF34D399)
                                    )
                                }

                                Column(horizontalAlignment = Alignment.End) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(Icons.Default.ArrowDownward, contentDescription = "Liabilities", tint = Color(0xFFF87171), modifier = Modifier.size(16.dp))
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text("Total Liabilities", fontSize = 12.sp, color = Color(0xFFCBD5E1))
                                    }
                                    Text(
                                        text = NumberFormatUtils.formatCompactCurrency(summary.totalLiabilities),
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFF87171)
                                    )
                                }
                            }

                            // Share Market Investment P&L preview
                            if (summary.totalInvested > 0) {
                                Spacer(modifier = Modifier.height(12.dp))
                                Surface(
                                    shape = RoundedCornerShape(10.dp),
                                    color = Color.Black.copy(alpha = 0.25f),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "Investments P&L",
                                            fontSize = 12.sp,
                                            color = Color(0xFF94A3B8)
                                        )
                                        val isProfit = summary.totalProfitLoss >= 0
                                        Text(
                                            text = "${if (isProfit) "+" else ""}${NumberFormatUtils.formatCurrency(summary.totalProfitLoss)} (${String.format("%.1f", summary.profitLossPercentage)}%)",
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (isProfit) Color(0xFF34D399) else Color(0xFFF87171)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }



            // Family Member Distribution Cards (Self, Father, Mother)
            if (selectedOwner == "All") {
                item {
                    Text(
                        text = "Family Net Worth Breakdown",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        ownerSummaries.forEach { ownerSum ->
                            OwnerSummaryCard(summary = ownerSum)
                        }
                    }
                }
            }

            // Asset Categories Allocation
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Asset & Liability Allocation",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "View All",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .clickable { onNavigateToAssets() }
                            .padding(4.dp)
                            .testTag("view_all_assets_link")
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    categorySummaries.forEach { catSum ->
                        CategoryAllocationCard(summary = catSum)
                    }
                }
            }

            // High Value Account Items
            item {
                Text(
                    text = "Top Holdings & Bank Accounts",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                val topItems = items.take(4)
                if (topItems.isEmpty()) {
                    OutlinedCard(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                        Text(
                            text = "No financial items registered for this profile filter.",
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                } else {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        topItems.forEach { item ->
                            TopHoldingCard(item = item, onClick = { onEditItem(item) })
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(80.dp)) }
        }

        // FAB to Add New Asset / Liability
        FloatingActionButton(
            onClick = onAddNewItem,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp)
                .testTag("add_item_fab"),
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add Item")
        }
    }
}

@Composable
fun OwnerSummaryCard(summary: OwnerSummary) {
    val profile = OwnerProfile.fromString(summary.owner)
    val color = Color(profile.badgeColorHex)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("owner_summary_card_${summary.owner}"),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = CircleShape,
                        color = color.copy(alpha = 0.2f),
                        modifier = Modifier.size(28.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = summary.owner.take(1),
                                fontWeight = FontWeight.Bold,
                                color = color,
                                fontSize = 13.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = summary.owner,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    text = NumberFormatUtils.formatCurrency(summary.netWorth),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = color
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { (summary.percentage / 100f).coerceIn(0f, 1f) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp),
                color = color,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Assets: ${NumberFormatUtils.formatCompactCurrency(summary.totalAssets)}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "${String.format("%.1f", summary.percentage)}% of Portfolio",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.SemiBold,
                    color = color
                )
            }

            if (summary.stockWorth > 0) {
                Spacer(modifier = Modifier.height(6.dp))
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surfaceContainerHigh,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.TrendingUp,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Live Stocks",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        val isProf = summary.stockProfitLoss >= 0
                        Text(
                            text = "${NumberFormatUtils.formatCompactCurrency(summary.stockWorth)} (${if (isProf) "+" else ""}${NumberFormatUtils.formatCompactCurrency(summary.stockProfitLoss)})",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isProf) Color(0xFF059669) else Color(0xFFDC2626)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryAllocationCard(summary: CategorySummary) {
    val categoryIcon = when {
        summary.category.contains("Bank", true) -> Icons.Default.AccountBalance
        summary.category.contains("Share", true) -> Icons.Default.TrendingUp
        summary.category.contains("Mutual", true) -> Icons.Default.PieChart
        summary.category.contains("IPO", true) -> Icons.Default.ShowChart
        summary.category.contains("Paid Loan", true) || summary.category.contains("Aapel", true) || summary.category.contains("Chekvel", true) || summary.category.contains("Loan Given", true) -> Icons.Default.Handshake
        summary.category.contains("Gold", true) -> Icons.Default.Diamond
        summary.category.contains("Estate", true) -> Icons.Default.Home
        summary.category.contains("Cash", true) -> Icons.Default.Payments
        summary.isLiability -> Icons.Default.ArrowDownward
        else -> Icons.Default.Savings
    }

    val color = if (summary.isLiability) Color(0xFFEF4444) else MaterialTheme.colorScheme.primary

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("category_allocation_card_${summary.category}"),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = CircleShape,
                color = color.copy(alpha = 0.15f),
                modifier = Modifier.size(36.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(imageVector = categoryIcon, contentDescription = null, tint = color, modifier = Modifier.size(20.dp))
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = summary.category,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = NumberFormatUtils.formatCurrency(summary.totalValue),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = if (summary.isLiability) Color(0xFFEF4444) else MaterialTheme.colorScheme.onSurface
                    )
                }

                if (!summary.isLiability) {
                    Spacer(modifier = Modifier.height(4.dp))
                    LinearProgressIndicator(
                        progress = { (summary.percentage / 100f).coerceIn(0f, 1f) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp),
                        color = color,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
fun TopHoldingCard(
    item: FinancialItem,
    onClick: () -> Unit = {}
) {
    val ownerProf = OwnerProfile.fromString(item.owner)
    val ownerColor = Color(ownerProf.badgeColorHex)

    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .testTag("top_holding_card_${item.id}"),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = ownerColor.copy(alpha = 0.2f),
                        modifier = Modifier.padding(end = 6.dp)
                    ) {
                        Text(
                            text = item.owner,
                            color = ownerColor,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                    Text(
                        text = item.category,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )

                if (item.institution.isNotBlank() || item.accountNumber.isNotBlank()) {
                    Text(
                        text = "${item.institution} ${if (item.accountNumber.isNotBlank()) "(${item.accountNumber})" else ""}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = NumberFormatUtils.formatCurrency(item.currentValue),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = if (item.isLiability) Color(0xFFEF4444) else MaterialTheme.colorScheme.primary
                )

                if (item.investedValue > 0 && item.currentValue != item.investedValue && !item.isLiability) {
                    val pnl = item.currentValue - item.investedValue
                    val pnlPct = (pnl / item.investedValue) * 100
                    val isProfit = pnl >= 0
                    Text(
                        text = "${if (isProfit) "+" else ""}${String.format("%.1f", pnlPct)}%",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = if (isProfit) Color(0xFF10B981) else Color(0xFFEF4444)
                    )
                }
            }
        }
    }
}
