package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.NetWorthSnapshot
import com.example.ui.utils.NumberFormatUtils

@Composable
fun NetWorthTrendChart(
    snapshots: List<NetWorthSnapshot>,
    modifier: Modifier = Modifier,
    lineColor: Color = MaterialTheme.colorScheme.primary,
    gradientTopColor: Color = lineColor.copy(alpha = 0.35f)
) {
    if (snapshots.isEmpty()) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(
                    MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                    RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No history snapshots recorded yet.\nTap 'Record Snapshot' to start tracking growth!",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        return
    }

    var selectedSnapshot by remember { mutableStateOf<NetWorthSnapshot?>(snapshots.lastOrNull()) }

    Column(modifier = modifier.fillMaxWidth()) {
        // Selected snapshot info header
        selectedSnapshot?.let { snap ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = NumberFormatUtils.formatCurrency(snap.netWorth),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "${NumberFormatUtils.formatDate(snap.timestamp)} • ${snap.note}",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        val sortedSnapshots = remember(snapshots) { snapshots.sortedBy { it.timestamp } }
        val minNetWorth = remember(sortedSnapshots) { (sortedSnapshots.minOfOrNull { it.netWorth } ?: 0.0) * 0.95 }
        val maxNetWorth = remember(sortedSnapshots) { (sortedSnapshots.maxOfOrNull { it.netWorth } ?: 100.0) * 1.05 }

        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surfaceContainer,
            tonalElevation = 2.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
            ) {
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .testTag("net_worth_trend_canvas")
                        .pointerInput(sortedSnapshots) {
                            detectTapGestures { tapOffset ->
                                if (sortedSnapshots.isNotEmpty()) {
                                    val width = size.width
                                    val stepX = width / (sortedSnapshots.size - 1).coerceAtLeast(1)
                                    val index = (tapOffset.x / stepX).toInt().coerceIn(0, sortedSnapshots.lastIndex)
                                    selectedSnapshot = sortedSnapshots[index]
                                }
                            }
                        }
                ) {
                    val width = size.width
                    val height = size.height
                    val points = mutableListOf<Offset>()

                    val valueRange = (maxNetWorth - minNetWorth).coerceAtLeast(1.0)
                    val stepX = width / (sortedSnapshots.size - 1).coerceAtLeast(1)

                    // Draw Horizontal Grid Lines
                    val gridLines = 3
                    for (i in 0..gridLines) {
                        val y = height * (i.toFloat() / gridLines)
                        drawLine(
                            color = Color.Gray.copy(alpha = 0.2f),
                            start = Offset(0f, y),
                            end = Offset(width, y),
                            strokeWidth = 1.dp.toPx(),
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
                        )
                    }

                    // Compute points
                    sortedSnapshots.forEachIndexed { i, snap ->
                        val x = i * stepX
                        val normalizedY = ((snap.netWorth - minNetWorth) / valueRange).toFloat()
                        val y = height - (normalizedY * height)
                        points.add(Offset(x, y))
                    }

                    if (points.size > 1) {
                        val strokePath = Path().apply {
                            moveTo(points[0].x, points[0].y)
                            for (i in 0 until points.size - 1) {
                                val p1 = points[i]
                                val p2 = points[i + 1]
                                val controlPoint1 = Offset(p1.x + (p2.x - p1.x) / 2f, p1.y)
                                val controlPoint2 = Offset(p1.x + (p2.x - p1.x) / 2f, p2.y)
                                cubicTo(controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y, p2.x, p2.y)
                            }
                        }

                        val fillPath = Path().apply {
                            addPath(strokePath)
                            lineTo(points.last().x, height)
                            lineTo(points.first().x, height)
                            close()
                        }

                        // Draw Gradient Area below line
                        drawPath(
                            path = fillPath,
                            brush = Brush.verticalGradient(
                                colors = listOf(gradientTopColor, Color.Transparent)
                            )
                        )

                        // Draw Curve Line
                        drawPath(
                            path = strokePath,
                            color = lineColor,
                            style = Stroke(width = 3.dp.toPx())
                        )

                        // Draw Point Circles
                        points.forEachIndexed { idx, point ->
                            val isSelected = sortedSnapshots[idx] == selectedSnapshot
                            val radius = if (isSelected) 6.dp.toPx() else 4.dp.toPx()
                            drawCircle(
                                color = if (isSelected) Color.White else lineColor,
                                radius = radius,
                                center = point
                            )
                            drawCircle(
                                color = lineColor,
                                radius = radius,
                                center = point,
                                style = Stroke(width = 2.dp.toPx())
                            )
                        }
                    }
                }
            }
        }
    }
}
