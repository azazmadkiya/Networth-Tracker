package com.example.ui.screens;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material.icons.filled.EditKt;
import androidx.compose.material.icons.filled.RefreshKt;
import androidx.compose.material.icons.filled.SwapHorizKt;
import androidx.compose.material.icons.filled.TuneKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LedgerScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$LedgerScreenKt {
    public static final ComposableSingletons$LedgerScreenKt INSTANCE = new ComposableSingletons$LedgerScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$1468020594 = ComposableLambdaKt.composableLambdaInstance(1468020594, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda_1468020594$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$304632830 = ComposableLambdaKt.composableLambdaInstance(304632830, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LedgerScreenKt.lambda_304632830$lambda$1((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1189886923, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f195lambda$1189886923 = ComposableLambdaKt.composableLambdaInstance(-1189886923, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda14
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LedgerScreenKt.lambda__1189886923$lambda$2((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-558502788, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f205lambda$558502788 = ComposableLambdaKt.composableLambdaInstance(-558502788, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda21
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LedgerScreenKt.lambda__558502788$lambda$3((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$316794099 = ComposableLambdaKt.composableLambdaInstance(316794099, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda23
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda_316794099$lambda$4((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1963990252, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f203lambda$1963990252 = ComposableLambdaKt.composableLambdaInstance(-1963990252, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda24
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LedgerScreenKt.lambda__1963990252$lambda$5((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1212826130 = ComposableLambdaKt.composableLambdaInstance(1212826130, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda25
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LedgerScreenKt.lambda_1212826130$lambda$6((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1046490659 = ComposableLambdaKt.composableLambdaInstance(1046490659, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda26
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda_1046490659$lambda$7((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1560594712 = ComposableLambdaKt.composableLambdaInstance(1560594712, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda27
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda_1560594712$lambda$8((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1130936406 = ComposableLambdaKt.composableLambdaInstance(1130936406, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda28
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda_1130936406$lambda$9((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1611475853, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f198lambda$1611475853 = ComposableLambdaKt.composableLambdaInstance(-1611475853, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda__1611475853$lambda$10((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1657224541, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f199lambda$1657224541 = ComposableLambdaKt.composableLambdaInstance(-1657224541, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda22
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda__1657224541$lambda$11((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-104137180, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f194lambda$104137180 = ComposableLambdaKt.composableLambdaInstance(-104137180, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda29
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda__104137180$lambda$12((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$238990655 = ComposableLambdaKt.composableLambdaInstance(238990655, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda30
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda_238990655$lambda$13((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1800472832, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f201lambda$1800472832 = ComposableLambdaKt.composableLambdaInstance(-1800472832, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda31
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda__1800472832$lambda$14((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1319793420 = ComposableLambdaKt.composableLambdaInstance(1319793420, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda32
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda_1319793420$lambda$15((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$595954346 = ComposableLambdaKt.composableLambdaInstance(595954346, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda33
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LedgerScreenKt.lambda_595954346$lambda$16((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1255557576 = ComposableLambdaKt.composableLambdaInstance(1255557576, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda34
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda_1255557576$lambda$17((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-2018895233, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f204lambda$2018895233 = ComposableLambdaKt.composableLambdaInstance(-2018895233, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda35
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda__2018895233$lambda$18((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1847177185, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f202lambda$1847177185 = ComposableLambdaKt.composableLambdaInstance(-1847177185, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LedgerScreenKt.lambda__1847177185$lambda$19((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$901171888 = ComposableLambdaKt.composableLambdaInstance(901171888, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LedgerScreenKt.lambda_901171888$lambda$20((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$916752779 = ComposableLambdaKt.composableLambdaInstance(916752779, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda_916752779$lambda$22((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$2138447066 = ComposableLambdaKt.composableLambdaInstance(2138447066, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda_2138447066$lambda$23((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$6781979 = ComposableLambdaKt.composableLambdaInstance(6781979, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda_6781979$lambda$24((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1690478845, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f200lambda$1690478845 = ComposableLambdaKt.composableLambdaInstance(-1690478845, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda__1690478845$lambda$25((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1521227260, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f197lambda$1521227260 = ComposableLambdaKt.composableLambdaInstance(-1521227260, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda__1521227260$lambda$26((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-906539715, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f207lambda$906539715 = ComposableLambdaKt.composableLambdaInstance(-906539715, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda__906539715$lambda$27((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-919662106, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f208lambda$919662106 = ComposableLambdaKt.composableLambdaInstance(-919662106, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda__919662106$lambda$28((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$20172002 = ComposableLambdaKt.composableLambdaInstance(20172002, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda_20172002$lambda$29((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1730822849 = ComposableLambdaKt.composableLambdaInstance(1730822849, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda13
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda_1730822849$lambda$30((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1331656736, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f196lambda$1331656736 = ComposableLambdaKt.composableLambdaInstance(-1331656736, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda15
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LedgerScreenKt.lambda__1331656736$lambda$31((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1416692337 = ComposableLambdaKt.composableLambdaInstance(1416692337, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda16
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LedgerScreenKt.lambda_1416692337$lambda$32((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1432273228 = ComposableLambdaKt.composableLambdaInstance(1432273228, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda17
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda_1432273228$lambda$34((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-816136287, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f206lambda$816136287 = ComposableLambdaKt.composableLambdaInstance(-816136287, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda18
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LedgerScreenKt.lambda__816136287$lambda$35((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1932212786 = ComposableLambdaKt.composableLambdaInstance(1932212786, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda19
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LedgerScreenKt.lambda_1932212786$lambda$36((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1655407852 = ComposableLambdaKt.composableLambdaInstance(1655407852, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$LedgerScreenKt$$ExternalSyntheticLambda20
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LedgerScreenKt.lambda_1655407852$lambda$37((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-104137180$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7041getLambda$104137180$app() {
        return f194lambda$104137180;
    }

    /* renamed from: getLambda$-1189886923$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7042getLambda$1189886923$app() {
        return f195lambda$1189886923;
    }

    /* renamed from: getLambda$-1331656736$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7043getLambda$1331656736$app() {
        return f196lambda$1331656736;
    }

    /* renamed from: getLambda$-1521227260$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7044getLambda$1521227260$app() {
        return f197lambda$1521227260;
    }

    /* renamed from: getLambda$-1611475853$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7045getLambda$1611475853$app() {
        return f198lambda$1611475853;
    }

    /* renamed from: getLambda$-1657224541$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7046getLambda$1657224541$app() {
        return f199lambda$1657224541;
    }

    /* renamed from: getLambda$-1690478845$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7047getLambda$1690478845$app() {
        return f200lambda$1690478845;
    }

    /* renamed from: getLambda$-1800472832$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7048getLambda$1800472832$app() {
        return f201lambda$1800472832;
    }

    /* renamed from: getLambda$-1847177185$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7049getLambda$1847177185$app() {
        return f202lambda$1847177185;
    }

    /* renamed from: getLambda$-1963990252$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7050getLambda$1963990252$app() {
        return f203lambda$1963990252;
    }

    /* renamed from: getLambda$-2018895233$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7051getLambda$2018895233$app() {
        return f204lambda$2018895233;
    }

    /* renamed from: getLambda$-558502788$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7052getLambda$558502788$app() {
        return f205lambda$558502788;
    }

    /* renamed from: getLambda$-816136287$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7053getLambda$816136287$app() {
        return f206lambda$816136287;
    }

    /* renamed from: getLambda$-906539715$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7054getLambda$906539715$app() {
        return f207lambda$906539715;
    }

    /* renamed from: getLambda$-919662106$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7055getLambda$919662106$app() {
        return f208lambda$919662106;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1046490659$app() {
        return lambda$1046490659;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1130936406$app() {
        return lambda$1130936406;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1212826130$app() {
        return lambda$1212826130;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1255557576$app() {
        return lambda$1255557576;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1319793420$app() {
        return lambda$1319793420;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1416692337$app() {
        return lambda$1416692337;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1432273228$app() {
        return lambda$1432273228;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1468020594$app() {
        return lambda$1468020594;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1560594712$app() {
        return lambda$1560594712;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1655407852$app() {
        return lambda$1655407852;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1730822849$app() {
        return lambda$1730822849;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1932212786$app() {
        return lambda$1932212786;
    }

    public final Function2<Composer, Integer, Unit> getLambda$20172002$app() {
        return lambda$20172002;
    }

    public final Function2<Composer, Integer, Unit> getLambda$2138447066$app() {
        return lambda$2138447066;
    }

    public final Function2<Composer, Integer, Unit> getLambda$238990655$app() {
        return lambda$238990655;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$304632830$app() {
        return lambda$304632830;
    }

    public final Function2<Composer, Integer, Unit> getLambda$316794099$app() {
        return lambda$316794099;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$595954346$app() {
        return lambda$595954346;
    }

    public final Function2<Composer, Integer, Unit> getLambda$6781979$app() {
        return lambda$6781979;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$901171888$app() {
        return lambda$901171888;
    }

    public final Function2<Composer, Integer, Unit> getLambda$916752779$app() {
        return lambda$916752779;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1468020594$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C175@7580L11,172@7404L217:LedgerScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1468020594, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$1468020594.<anonymous> (LedgerScreen.kt:172)");
            }
            IconKt.m2150Iconww6aTOc(RefreshKt.getRefresh(Icons.INSTANCE.getDefault()), "Re Fresh Ledger", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary(), $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_304632830$lambda$1(RowScope OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C192@8221L205,197@8447L39,198@8507L78:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(304632830, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$304632830.<anonymous> (LedgerScreen.kt:192)");
            }
            IconKt.m2150Iconww6aTOc(TuneKt.getTune(Icons.INSTANCE.getDefault()), "Manage Accounts", SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(15)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(4)), $composer, 6);
            TextKt.m2693Text4IGK_g("Accounts", (Modifier) null, 0L, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 199686, 3072, 122838);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1189886923$lambda$2(RowScope OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C209@9023L207,214@9251L39,215@9311L80:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1189886923, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$-1189886923.<anonymous> (LedgerScreen.kt:209)");
            }
            IconKt.m2150Iconww6aTOc(SwapHorizKt.getSwapHoriz(Icons.INSTANCE.getDefault()), "Record DR/CR", SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(15)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(4)), $composer, 6);
            TextKt.m2693Text4IGK_g("DR/CR Post", (Modifier) null, 0L, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 199686, 3072, 122838);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__558502788$lambda$3(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C229@9940L198,234@10159L39,235@10219L75:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-558502788, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$-558502788.<anonymous> (LedgerScreen.kt:229)");
            }
            IconKt.m2150Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "Add Entry", SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(15)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(4)), $composer, 6);
            TextKt.m2693Text4IGK_g("Entry", (Modifier) null, 0L, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 199686, 3072, 122838);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_316794099$lambda$4(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C284@12408L50:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(316794099, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$316794099.<anonymous> (LedgerScreen.kt:284)");
            }
            TextKt.m2693Text4IGK_g("All Accounts", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 196614, 0, 131038);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1963990252$lambda$5(RowScope OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C423@18904L84,424@19017L39,425@19085L20:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1963990252, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$-1963990252.<anonymous> (LedgerScreen.kt:423)");
            }
            IconKt.m2150Iconww6aTOc(TuneKt.getTune(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(6)), $composer, 6);
            TextKt.m2693Text4IGK_g("Add Accounts", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1212826130$lambda$6(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C433@19440L83,434@19552L39,435@19620L20:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1212826130, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$1212826130.<anonymous> (LedgerScreen.kt:433)");
            }
            IconKt.m2150Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(6)), $composer, 6);
            TextKt.m2693Text4IGK_g("Record Entry", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1046490659$lambda$7(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C497@22873L11,494@22641L368:LedgerScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1046490659, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$1046490659.<anonymous> (LedgerScreen.kt:494)");
            }
            IconKt.m2150Iconww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Delete Entry", SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(15)), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), $composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1611475853$lambda$10(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C621@29096L55:LedgerScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1611475853, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$-1611475853.<anonymous> (LedgerScreen.kt:621)");
            }
            IconKt.m2150Iconww6aTOc(CloseKt.getClose(Icons.INSTANCE.getDefault()), "Close", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1657224541$lambda$11(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C665@31103L32:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1657224541, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$-1657224541.<anonymous> (LedgerScreen.kt:665)");
            }
            TextKt.m2693Text4IGK_g("Account / Heading Name *", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__104137180$lambda$12(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C666@31179L53:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-104137180, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$-104137180.<anonymous> (LedgerScreen.kt:666)");
            }
            TextKt.m2693Text4IGK_g("e.g. PETROL, Salary, Electric Bill, HDFC Bank", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_238990655$lambda$13(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C714@33568L27:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(238990655, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$238990655.<anonymous> (LedgerScreen.kt:714)");
            }
            TextKt.m2693Text4IGK_g("Opening Balance (₹)", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1800472832$lambda$14(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C715@33643L9:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1800472832, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$-1800472832.<anonymous> (LedgerScreen.kt:715)");
            }
            TextKt.m2693Text4IGK_g("0", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1319793420$lambda$15(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C760@35995L27:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1319793420, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$1319793420.<anonymous> (LedgerScreen.kt:760)");
            }
            TextKt.m2693Text4IGK_g("Description / Notes", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_595954346$lambda$16(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C778@36771L19:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(595954346, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$595954346.<anonymous> (LedgerScreen.kt:778)");
            }
            TextKt.m2693Text4IGK_g("Cancel Edit", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1255557576$lambda$17(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C886@43302L392:LedgerScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1255557576, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$1255557576.<anonymous> (LedgerScreen.kt:886)");
            }
            IconKt.m2150Iconww6aTOc(EditKt.getEdit(Icons.INSTANCE.getDefault()), "Edit Account", SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(18)), ColorKt.Color(4284524026L), $composer, 3504, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__2018895233$lambda$18(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C898@44059L396:LedgerScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2018895233, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$-2018895233.<anonymous> (LedgerScreen.kt:898)");
            }
            IconKt.m2150Iconww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Delete Account", SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(18)), ColorKt.Color(4294472049L), $composer, 3504, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1560594712$lambda$8(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1560594712, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$1560594712.<anonymous> (LedgerScreen.kt:913)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1130936406$lambda$9(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1130936406, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$1130936406.<anonymous> (LedgerScreen.kt:914)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda_916752779$lambda$22(androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda_916752779$lambda$22(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_2138447066$lambda$23(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C946@46283L31:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2138447066, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$2138447066.<anonymous> (LedgerScreen.kt:946)");
            }
            TextKt.m2693Text4IGK_g("Transaction Particulars", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_6781979$lambda$24(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C947@46358L41:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(6781979, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$6781979.<anonymous> (LedgerScreen.kt:947)");
            }
            TextKt.m2693Text4IGK_g("e.g. Salary Credit, Bank Transfer", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1690478845$lambda$25(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C991@48527L36:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1690478845, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$-1690478845.<anonymous> (LedgerScreen.kt:991)");
            }
            TextKt.m2693Text4IGK_g("Secondary / Opposite Account", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1521227260$lambda$26(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C992@48607L33:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1521227260, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$-1521227260.<anonymous> (LedgerScreen.kt:992)");
            }
            TextKt.m2693Text4IGK_g("e.g. Cash, Income, Vendor", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__906539715$lambda$27(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1005@49192L48:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-906539715, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$-906539715.<anonymous> (LedgerScreen.kt:1005)");
            }
            TextKt.m2693Text4IGK_g("DEBIT (DR)", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 196614, 0, 131038);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__919662106$lambda$28(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1016@49772L49:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-919662106, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$-919662106.<anonymous> (LedgerScreen.kt:1016)");
            }
            TextKt.m2693Text4IGK_g("CREDIT (CR)", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 196614, 0, 131038);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_20172002$lambda$29(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1029@50385L20:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(20172002, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$20172002.<anonymous> (LedgerScreen.kt:1029)");
            }
            TextKt.m2693Text4IGK_g("Amount (₹) *", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1730822849$lambda$30(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1039@50832L20:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1730822849, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$1730822849.<anonymous> (LedgerScreen.kt:1039)");
            }
            TextKt.m2693Text4IGK_g("Notes / Memo", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1847177185$lambda$19(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C1064@52000L18:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1847177185, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$-1847177185.<anonymous> (LedgerScreen.kt:1064)");
            }
            TextKt.m2693Text4IGK_g("Post Entry", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_901171888$lambda$20(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C1069@52177L14:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(901171888, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$901171888.<anonymous> (LedgerScreen.kt:1069)");
            }
            TextKt.m2693Text4IGK_g("Cancel", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda_1432273228$lambda$34(androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda_1432273228$lambda$34(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1331656736$lambda$31(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C1143@55680L14:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1331656736, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$-1331656736.<anonymous> (LedgerScreen.kt:1143)");
            }
            TextKt.m2693Text4IGK_g("Delete", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1416692337$lambda$32(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C1148@55843L14:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1416692337, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$1416692337.<anonymous> (LedgerScreen.kt:1148)");
            }
            TextKt.m2693Text4IGK_g("Cancel", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1655407852$lambda$37(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1160@56205L104:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1655407852, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$1655407852.<anonymous> (LedgerScreen.kt:1160)");
            }
            TextKt.m2693Text4IGK_g("Are you sure you want to delete this account? It will be removed from your active accounts list.", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__816136287$lambda$35(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C1169@56709L22:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-816136287, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$-816136287.<anonymous> (LedgerScreen.kt:1169)");
            }
            TextKt.m2693Text4IGK_g("Delete Account", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1932212786$lambda$36(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C1174@56882L14:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1932212786, $changed, -1, "com.example.ui.screens.ComposableSingletons$LedgerScreenKt.lambda$1932212786.<anonymous> (LedgerScreen.kt:1174)");
            }
            TextKt.m2693Text4IGK_g("Cancel", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
