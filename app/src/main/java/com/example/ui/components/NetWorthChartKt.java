package com.example.ui.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import androidx.core.location.LocationRequestCompat;
import com.example.data.model.NetWorthSnapshot;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: NetWorthChart.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f²\u0006\f\u0010\r\u001a\u0004\u0018\u00010\u0004X\u008a\u008e\u0002"}, d2 = {"NetWorthTrendChart", "", "snapshots", "", "Lcom/example/data/model/NetWorthSnapshot;", "modifier", "Landroidx/compose/ui/Modifier;", "lineColor", "Landroidx/compose/ui/graphics/Color;", "gradientTopColor", "NetWorthTrendChart-eaDK9VM", "(Ljava/util/List;Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "app", "selectedSnapshot"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class NetWorthChartKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NetWorthTrendChart_eaDK9VM$lambda$1(List list, Modifier modifier, long j, long j2, int i, int i2, Composer composer, int i3) {
        m7012NetWorthTrendCharteaDK9VM(list, modifier, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NetWorthTrendChart_eaDK9VM$lambda$24(List list, Modifier modifier, long j, long j2, int i, int i2, Composer composer, int i3) {
        m7012NetWorthTrendCharteaDK9VM(list, modifier, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0970  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x088e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x08cb  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x08d0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0896  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x07f9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x083a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x083f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0801  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0606  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0434  */
    /* renamed from: NetWorthTrendChart-eaDK9VM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m7012NetWorthTrendCharteaDK9VM(final java.util.List<com.example.data.model.NetWorthSnapshot> r105, androidx.compose.ui.Modifier r106, long r107, long r109, androidx.compose.runtime.Composer r111, final int r112, final int r113) {
        /*
            Method dump skipped, instructions count: 2447
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.NetWorthChartKt.m7012NetWorthTrendCharteaDK9VM(java.util.List, androidx.compose.ui.Modifier, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final NetWorthSnapshot NetWorthTrendChart_eaDK9VM$lambda$3(MutableState<NetWorthSnapshot> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x024e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit NetWorthTrendChart_eaDK9VM$lambda$23$lambda$22(final java.util.List r41, final double r42, final double r44, final long r46, final long r48, androidx.compose.runtime.MutableState r50, androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.NetWorthChartKt.NetWorthTrendChart_eaDK9VM$lambda$23$lambda$22(java.util.List, double, double, long, long, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NetWorthTrendChart_eaDK9VM$lambda$23$lambda$22$lambda$21$lambda$20$lambda$19(double $maxNetWorth, double $minNetWorth, List $sortedSnapshots, long $gradientTopColor, long $lineColor, MutableState $selectedSnapshot$delegate, DrawScope $this$Canvas) {
        long m4157copywmQWz5c;
        List points;
        float height;
        DrawScope Canvas = $this$Canvas;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float width = Size.m3987getWidthimpl(Canvas.mo4709getSizeNHjbRc());
        float height2 = Size.m3984getHeightimpl(Canvas.mo4709getSizeNHjbRc());
        List points2 = new ArrayList();
        double valueRange = RangesKt.coerceAtLeast($maxNetWorth - $minNetWorth, 1.0d);
        boolean z = true;
        float stepX = width / RangesKt.coerceAtLeast($sortedSnapshots.size() - 1, 1);
        int gridLines = 3;
        int i = 0;
        while (true) {
            float y = (i / gridLines) * height2;
            m4157copywmQWz5c = Color.m4157copywmQWz5c(r19, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(r19) : 0.2f, (r12 & 2) != 0 ? Color.m4165getRedimpl(r19) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(r19) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(Color.INSTANCE.m4189getGray0d7_KjU()) : 0.0f);
            points = points2;
            int gridLines2 = gridLines;
            int i2 = i;
            float width2 = width;
            height = height2;
            DrawScope.m4695drawLineNGM6Ib0$default($this$Canvas, m4157copywmQWz5c, OffsetKt.Offset(0.0f, y), OffsetKt.Offset(width, y), Canvas.mo362toPx0680j_4(Dp.m6622constructorimpl(1)), 0, PathEffect.Companion.dashPathEffect$default(PathEffect.INSTANCE, new float[]{10.0f, 10.0f}, 0.0f, 2, null), 0.0f, null, 0, 464, null);
            if (i2 == gridLines2) {
                break;
            }
            i = i2 + 1;
            Canvas = $this$Canvas;
            gridLines = gridLines2;
            height2 = height;
            width = width2;
            points2 = points;
            z = true;
        }
        int i3 = 0;
        for (Object obj : $sortedSnapshots) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            points.add(Offset.m3907boximpl(OffsetKt.Offset(i3 * stepX, height - (((float) ((((NetWorthSnapshot) obj).getNetWorth() - $minNetWorth) / valueRange)) * height))));
            i3 = i4;
        }
        if (points.size() > 1) {
            Path Path = AndroidPath_androidKt.Path();
            Path.moveTo(Offset.m3918getXimpl(((Offset) points.get(0)).getPackedValue()), Offset.m3919getYimpl(((Offset) points.get(0)).getPackedValue()));
            int size = points.size() - 1;
            for (int i5 = 0; i5 < size; i5++) {
                long packedValue = ((Offset) points.get(i5)).getPackedValue();
                long packedValue2 = ((Offset) points.get(i5 + 1)).getPackedValue();
                long Offset = OffsetKt.Offset(Offset.m3918getXimpl(packedValue) + ((Offset.m3918getXimpl(packedValue2) - Offset.m3918getXimpl(packedValue)) / 2.0f), Offset.m3919getYimpl(packedValue));
                long Offset2 = OffsetKt.Offset(Offset.m3918getXimpl(packedValue) + ((Offset.m3918getXimpl(packedValue2) - Offset.m3918getXimpl(packedValue)) / 2.0f), Offset.m3919getYimpl(packedValue2));
                Path.cubicTo(Offset.m3918getXimpl(Offset), Offset.m3919getYimpl(Offset), Offset.m3918getXimpl(Offset2), Offset.m3919getYimpl(Offset2), Offset.m3918getXimpl(packedValue2), Offset.m3919getYimpl(packedValue2));
            }
            Path fillPath = AndroidPath_androidKt.Path();
            Path.m4428addPathUv8p0NA$default(fillPath, Path, 0L, 2, null);
            fillPath.lineTo(Offset.m3918getXimpl(((Offset) CollectionsKt.last(points)).getPackedValue()), height);
            fillPath.lineTo(Offset.m3918getXimpl(((Offset) CollectionsKt.first(points)).getPackedValue()), height);
            fillPath.close();
            DrawScope drawScope = $this$Canvas;
            DrawScope.m4698drawPathGBMwjPU$default(drawScope, fillPath, Brush.Companion.m4116verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m4149boximpl($gradientTopColor), Color.m4149boximpl(Color.INSTANCE.m4194getTransparent0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), 0.0f, null, null, 0, 60, null);
            DrawScope.m4699drawPathLG529CI$default(drawScope, Path, $lineColor, 0.0f, new Stroke(drawScope.mo362toPx0680j_4(Dp.m6622constructorimpl(3)), 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
            int i6 = 0;
            for (Object obj2 : points) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                long packedValue3 = ((Offset) obj2).getPackedValue();
                boolean areEqual = Intrinsics.areEqual($sortedSnapshots.get(i6), NetWorthTrendChart_eaDK9VM$lambda$3($selectedSnapshot$delegate));
                float f = drawScope.mo362toPx0680j_4(areEqual ? Dp.m6622constructorimpl(6) : Dp.m6622constructorimpl(4));
                DrawScope.m4690drawCircleVaOC9Bg$default(drawScope, areEqual ? Color.INSTANCE.m4196getWhite0d7_KjU() : $lineColor, f, packedValue3, 0.0f, null, null, 0, 120, null);
                DrawScope.m4690drawCircleVaOC9Bg$default(drawScope, $lineColor, f, packedValue3, 0.0f, new Stroke(drawScope.mo362toPx0680j_4(Dp.m6622constructorimpl(2)), 0.0f, 0, 0, null, 30, null), null, 0, LocationRequestCompat.QUALITY_LOW_POWER, null);
                drawScope = $this$Canvas;
                i6 = i7;
            }
        }
        return Unit.INSTANCE;
    }
}
