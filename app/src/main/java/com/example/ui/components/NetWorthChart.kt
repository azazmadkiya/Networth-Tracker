package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.NetWorthSnapshot
import com.example.ui.theme.AssetGreen
import com.example.ui.theme.LiabilityRed
import com.example.ui.theme.NeutralBlue
import com.example.ui.theme.PrimaryGreen
import com.example.ui.utils.NumberFormatUtils
import kotlin.math.max
import kotlin.math.min

@Composable
fun NetWorthTrendChart(
    snapshots: List<NetWorthSnapshot>,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Net Worth Trajectory",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                if (snapshots.isNotEmpty()) {
                    Text(
                        text = NumberFormatUtils.formatCompact(snapshots.first().netWorth),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryGreen
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (snapshots.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No snapshots recorded yet. Tap 'Take Snapshot' to track historical growth!",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                val sortedSnapshots = snapshots.sortedBy { it.timestamp }
                val values = sortedSnapshots.map { it.netWorth }
                val minVal = (values.minOrNull() ?: 0.0).coerceAtLeast(0.0)
                val maxVal = max(values.maxOrNull() ?: 1.0, minVal + 1.0)

                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                ) {
                    val w = size.width
                    val h = size.height
                    val paddingBottom = 16f
                    val paddingTop = 16f
                    val chartHeight = h - paddingTop - paddingBottom

                    val points = if (values.size == 1) {
                        listOf(
                            Offset(0f, paddingTop + chartHeight / 2f),
                            Offset(w, paddingTop + chartHeight / 2f)
                        )
                    } else {
                        values.mapIndexed { idx, v ->
                            val x = (idx.toFloat() / (values.size - 1)) * w
                            val normalized = ((v - minVal) / (maxVal - minVal)).toFloat()
                            val y = paddingTop + chartHeight * (1f - normalized)
                            Offset(x, y)
                        }
                    }

                    // Fill gradient
                    val path = Path().apply {
                        moveTo(points.first().x, points.first().y)
                        for (i in 1 until points.size) {
                            val p0 = points[i - 1]
                            val p1 = points[i]
                            val cx = (p0.x + p1.x) / 2f
                            cubicTo(cx, p0.y, cx, p1.y, p1.x, p1.y)
                        }
                        lineTo(points.last().x, h)
                        lineTo(points.first().x, h)
                        close()
                    }

                    drawPath(
                        path = path,
                        brush = Brush.verticalGradient(
                            colors = listOf(PrimaryGreen.copy(alpha = 0.35f), Color.Transparent),
                            startY = paddingTop,
                            endY = h
                        )
                    )

                    // Stroke line
                    val strokePath = Path().apply {
                        moveTo(points.first().x, points.first().y)
                        for (i in 1 until points.size) {
                            val p0 = points[i - 1]
                            val p1 = points[i]
                            val cx = (p0.x + p1.x) / 2f
                            cubicTo(cx, p0.y, cx, p1.y, p1.x, p1.y)
                        }
                    }

                    drawPath(
                        path = strokePath,
                        color = PrimaryGreen,
                        style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round)
                    )

                    // Draw dots on points
                    points.forEach { pt ->
                        drawCircle(
                            color = Color.White,
                            radius = 4.dp.toPx(),
                            center = pt
                        )
                        drawCircle(
                            color = PrimaryGreen,
                            radius = 2.5.dp.toPx(),
                            center = pt
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AssetLiabilityBar(
    totalAssets: Double,
    totalLiabilities: Double,
    modifier: Modifier = Modifier
) {
    val total = totalAssets + totalLiabilities
    val assetRatio = if (total > 0) (totalAssets / total).toFloat() else 1f

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(10.dp).clip(CircleShape).background(AssetGreen))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Assets: ${NumberFormatUtils.formatCompact(totalAssets)}",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(10.dp).clip(CircleShape).background(LiabilityRed))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Liabilities: ${NumberFormatUtils.formatCompact(totalLiabilities)}",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Two-color progress bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(LiabilityRed)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(fraction = assetRatio.coerceIn(0f, 1f))
                        .height(10.dp)
                        .background(AssetGreen)
                )
            }
        }
    }
}
