package com.example.ui.screens;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.ClearKt;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material.icons.filled.EditKt;
import androidx.compose.material.icons.filled.RefreshKt;
import androidx.compose.material.icons.filled.SearchKt;
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

/* compiled from: AssetsListScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$AssetsListScreenKt {
    public static final ComposableSingletons$AssetsListScreenKt INSTANCE = new ComposableSingletons$AssetsListScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$1805533597 = ComposableLambdaKt.composableLambdaInstance(1805533597, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda_1805533597$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$425748284 = ComposableLambdaKt.composableLambdaInstance(425748284, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda_425748284$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-773562909, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f187lambda$773562909 = ComposableLambdaKt.composableLambdaInstance(-773562909, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda14
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda__773562909$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$858117784 = ComposableLambdaKt.composableLambdaInstance(858117784, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda19
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AssetsListScreenKt.lambda_858117784$lambda$3((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1719020099, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f180lambda$1719020099 = ComposableLambdaKt.composableLambdaInstance(-1719020099, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda20
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AssetsListScreenKt.lambda__1719020099$lambda$4((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1886652314, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f182lambda$1886652314 = ComposableLambdaKt.composableLambdaInstance(-1886652314, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda21
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AssetsListScreenKt.lambda__1886652314$lambda$5((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1117663173 = ComposableLambdaKt.composableLambdaInstance(1117663173, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda23
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AssetsListScreenKt.lambda_1117663173$lambda$6((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$387523117 = ComposableLambdaKt.composableLambdaInstance(387523117, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda24
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda_387523117$lambda$7((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1021999076, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f175lambda$1021999076 = ComposableLambdaKt.composableLambdaInstance(-1021999076, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda25
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AssetsListScreenKt.lambda__1021999076$lambda$8((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1882586096 = ComposableLambdaKt.composableLambdaInstance(1882586096, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda26
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda_1882586096$lambda$9((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$2021542362 = ComposableLambdaKt.composableLambdaInstance(2021542362, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AssetsListScreenKt.lambda_2021542362$lambda$10((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1947957784 = ComposableLambdaKt.composableLambdaInstance(1947957784, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda22
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AssetsListScreenKt.lambda_1947957784$lambda$11((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1641638349, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f179lambda$1641638349 = ComposableLambdaKt.composableLambdaInstance(-1641638349, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda27
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda__1641638349$lambda$13((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-120359426, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f178lambda$120359426 = ComposableLambdaKt.composableLambdaInstance(-120359426, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda28
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AssetsListScreenKt.lambda__120359426$lambda$14((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1111046159 = ComposableLambdaKt.composableLambdaInstance(1111046159, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda29
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AssetsListScreenKt.lambda_1111046159$lambda$15((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$367901034 = ComposableLambdaKt.composableLambdaInstance(367901034, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda30
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda_367901034$lambda$17((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-741272263, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f186lambda$741272263 = ComposableLambdaKt.composableLambdaInstance(-741272263, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda31
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda__741272263$lambda$18((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$480987874 = ComposableLambdaKt.composableLambdaInstance(480987874, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda32
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda_480987874$lambda$19((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1154160994, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f177lambda$1154160994 = ComposableLambdaKt.composableLambdaInstance(-1154160994, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda33
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AssetsListScreenKt.lambda__1154160994$lambda$20((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1784769335 = ComposableLambdaKt.composableLambdaInstance(1784769335, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda_1784769335$lambda$22((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$682203925 = ComposableLambdaKt.composableLambdaInstance(682203925, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AssetsListScreenKt.lambda_682203925$lambda$23((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1094230674, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f176lambda$1094230674 = ComposableLambdaKt.composableLambdaInstance(-1094230674, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda__1094230674$lambda$25((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1968686230 = ComposableLambdaKt.composableLambdaInstance(1968686230, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AssetsListScreenKt.lambda_1968686230$lambda$26((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$192251631 = ComposableLambdaKt.composableLambdaInstance(192251631, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda_192251631$lambda$28((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$559291787 = ComposableLambdaKt.composableLambdaInstance(559291787, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda_559291787$lambda$29((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$717794631 = ComposableLambdaKt.composableLambdaInstance(717794631, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda_717794631$lambda$30((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-422353296, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f185lambda$422353296 = ComposableLambdaKt.composableLambdaInstance(-422353296, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda__422353296$lambda$31((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-2133025777, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f184lambda$2133025777 = ComposableLambdaKt.composableLambdaInstance(-2133025777, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda__2133025777$lambda$32((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1028467542 = ComposableLambdaKt.composableLambdaInstance(1028467542, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda_1028467542$lambda$33((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-93075047, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f188lambda$93075047 = ComposableLambdaKt.composableLambdaInstance(-93075047, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda13
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda__93075047$lambda$34((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$727932749 = ComposableLambdaKt.composableLambdaInstance(727932749, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda15
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda_727932749$lambda$35((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$962296016 = ComposableLambdaKt.composableLambdaInstance(962296016, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda16
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda_962296016$lambda$36((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-2013947186, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f183lambda$2013947186 = ComposableLambdaKt.composableLambdaInstance(-2013947186, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda17
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda__2013947186$lambda$37((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1779583919, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f181lambda$1779583919 = ComposableLambdaKt.composableLambdaInstance(-1779583919, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt$$ExternalSyntheticLambda18
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssetsListScreenKt.lambda__1779583919$lambda$38((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-1021999076$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7022getLambda$1021999076$app() {
        return f175lambda$1021999076;
    }

    /* renamed from: getLambda$-1094230674$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7023getLambda$1094230674$app() {
        return f176lambda$1094230674;
    }

    /* renamed from: getLambda$-1154160994$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7024getLambda$1154160994$app() {
        return f177lambda$1154160994;
    }

    /* renamed from: getLambda$-120359426$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7025getLambda$120359426$app() {
        return f178lambda$120359426;
    }

    /* renamed from: getLambda$-1641638349$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7026getLambda$1641638349$app() {
        return f179lambda$1641638349;
    }

    /* renamed from: getLambda$-1719020099$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7027getLambda$1719020099$app() {
        return f180lambda$1719020099;
    }

    /* renamed from: getLambda$-1779583919$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7028getLambda$1779583919$app() {
        return f181lambda$1779583919;
    }

    /* renamed from: getLambda$-1886652314$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7029getLambda$1886652314$app() {
        return f182lambda$1886652314;
    }

    /* renamed from: getLambda$-2013947186$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7030getLambda$2013947186$app() {
        return f183lambda$2013947186;
    }

    /* renamed from: getLambda$-2133025777$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7031getLambda$2133025777$app() {
        return f184lambda$2133025777;
    }

    /* renamed from: getLambda$-422353296$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7032getLambda$422353296$app() {
        return f185lambda$422353296;
    }

    /* renamed from: getLambda$-741272263$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7033getLambda$741272263$app() {
        return f186lambda$741272263;
    }

    /* renamed from: getLambda$-773562909$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7034getLambda$773562909$app() {
        return f187lambda$773562909;
    }

    /* renamed from: getLambda$-93075047$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7035getLambda$93075047$app() {
        return f188lambda$93075047;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1028467542$app() {
        return lambda$1028467542;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1111046159$app() {
        return lambda$1111046159;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1117663173$app() {
        return lambda$1117663173;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1784769335$app() {
        return lambda$1784769335;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1805533597$app() {
        return lambda$1805533597;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1882586096$app() {
        return lambda$1882586096;
    }

    public final Function2<Composer, Integer, Unit> getLambda$192251631$app() {
        return lambda$192251631;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1947957784$app() {
        return lambda$1947957784;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1968686230$app() {
        return lambda$1968686230;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$2021542362$app() {
        return lambda$2021542362;
    }

    public final Function2<Composer, Integer, Unit> getLambda$367901034$app() {
        return lambda$367901034;
    }

    public final Function2<Composer, Integer, Unit> getLambda$387523117$app() {
        return lambda$387523117;
    }

    public final Function2<Composer, Integer, Unit> getLambda$425748284$app() {
        return lambda$425748284;
    }

    public final Function2<Composer, Integer, Unit> getLambda$480987874$app() {
        return lambda$480987874;
    }

    public final Function2<Composer, Integer, Unit> getLambda$559291787$app() {
        return lambda$559291787;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$682203925$app() {
        return lambda$682203925;
    }

    public final Function2<Composer, Integer, Unit> getLambda$717794631$app() {
        return lambda$717794631;
    }

    public final Function2<Composer, Integer, Unit> getLambda$727932749$app() {
        return lambda$727932749;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$858117784$app() {
        return lambda$858117784;
    }

    public final Function2<Composer, Integer, Unit> getLambda$962296016$app() {
        return lambda$962296016;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1805533597$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C116@5359L32:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1805533597, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$1805533597.<anonymous> (AssetsListScreen.kt:116)");
            }
            TextKt.m2693Text4IGK_g("Search assets by name...", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_425748284$lambda$1(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C117@5427L64:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(425748284, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$425748284.<anonymous> (AssetsListScreen.kt:117)");
            }
            IconKt.m2150Iconww6aTOc(SearchKt.getSearch(Icons.INSTANCE.getDefault()), "Search Assets", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__773562909$lambda$2(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C124@5827L62:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-773562909, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$-773562909.<anonymous> (AssetsListScreen.kt:124)");
            }
            IconKt.m2150Iconww6aTOc(ClearKt.getClear(Icons.INSTANCE.getDefault()), "Clear search", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_858117784$lambda$3(RowScope FilledTonalButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(FilledTonalButton, "$this$FilledTonalButton");
        ComposerKt.sourceInformation($composer, "C248@12099L83,249@12215L39,250@12287L59:AssetsListScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(858117784, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$858117784.<anonymous> (AssetsListScreen.kt:248)");
            }
            IconKt.m2150Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(13)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(2)), $composer, 6);
            TextKt.m2693Text4IGK_g("Add", (Modifier) null, 0L, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 199686, 0, 131030);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1719020099$lambda$4(RowScope OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C263@13097L84,264@13218L39,265@13294L62:AssetsListScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1719020099, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$-1719020099.<anonymous> (AssetsListScreen.kt:263)");
            }
            IconKt.m2150Iconww6aTOc(TuneKt.getTune(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(13)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(2)), $composer, 6);
            TextKt.m2693Text4IGK_g("Adjust", (Modifier) null, 0L, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 199686, 0, 131030);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1886652314$lambda$5(RowScope OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C276@13940L84,277@14061L39,278@14137L62:AssetsListScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1886652314, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$-1886652314.<anonymous> (AssetsListScreen.kt:276)");
            }
            IconKt.m2150Iconww6aTOc(EditKt.getEdit(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(13)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(2)), $composer, 6);
            TextKt.m2693Text4IGK_g("Modify", (Modifier) null, 0L, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 199686, 0, 131030);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1117663173$lambda$6(RowScope OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C290@14899L86,291@15022L39,292@15098L62:AssetsListScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1117663173, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$1117663173.<anonymous> (AssetsListScreen.kt:290)");
            }
            IconKt.m2150Iconww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(13)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(2)), $composer, 6);
            TextKt.m2693Text4IGK_g("Delete", (Modifier) null, 0L, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 199686, 0, 131030);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_387523117$lambda$7(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C309@16067L11,306@15853L336:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(387523117, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$387523117.<anonymous> (AssetsListScreen.kt:306)");
            }
            IconKt.m2150Iconww6aTOc(RefreshKt.getRefresh(Icons.INSTANCE.getDefault()), "Re Fresh Balances", SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(18)), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary(), $composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1021999076$lambda$8(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C350@17701L41:AssetsListScreen.kt#2thlc2");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1021999076, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$-1021999076.<anonymous> (AssetsListScreen.kt:350)");
            }
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(80)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1882586096$lambda$9(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C364@18120L57:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1882586096, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$1882586096.<anonymous> (AssetsListScreen.kt:364)");
            }
            IconKt.m2150Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "Add Asset", (Modifier) null, 0L, $composer, 48, 12);
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
    public static final kotlin.Unit lambda__1641638349$lambda$13(androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda__1641638349$lambda$13(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_2021542362$lambda$10(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C442@22234L11,442@22191L91:AssetsListScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2021542362, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$2021542362.<anonymous> (AssetsListScreen.kt:442)");
            }
            TextKt.m2693Text4IGK_g("Delete Entry", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 196614, 0, 131034);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1947957784$lambda$11(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C450@22541L44:AssetsListScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1947957784, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$1947957784.<anonymous> (AssetsListScreen.kt:450)");
            }
            TextKt.m2693Text4IGK_g("Cancel", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 196614, 0, 131038);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda_367901034$lambda$17(androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda_367901034$lambda$17(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__741272263$lambda$18(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C506@25274L33:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-741272263, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$-741272263.<anonymous> (AssetsListScreen.kt:506)");
            }
            TextKt.m2693Text4IGK_g("New Adjusted Amount (₹) *", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_480987874$lambda$19(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C545@27602L32:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(480987874, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$480987874.<anonymous> (AssetsListScreen.kt:545)");
            }
            TextKt.m2693Text4IGK_g("Adjustment Reason / Note", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__120359426$lambda$14(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C566@28560L52:AssetsListScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-120359426, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$-120359426.<anonymous> (AssetsListScreen.kt:566)");
            }
            TextKt.m2693Text4IGK_g("Apply & Update", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 196614, 0, 131038);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1111046159$lambda$15(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C571@28760L14:AssetsListScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1111046159, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$1111046159.<anonymous> (AssetsListScreen.kt:571)");
            }
            TextKt.m2693Text4IGK_g("Cancel", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda_1784769335$lambda$22(androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda_1784769335$lambda$22(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1154160994$lambda$20(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C628@31494L14:AssetsListScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1154160994, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$-1154160994.<anonymous> (AssetsListScreen.kt:628)");
            }
            TextKt.m2693Text4IGK_g("Cancel", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda__1094230674$lambda$25(androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda__1094230674$lambda$25(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_682203925$lambda$23(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C685@34202L14:AssetsListScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(682203925, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$682203925.<anonymous> (AssetsListScreen.kt:685)");
            }
            TextKt.m2693Text4IGK_g("Cancel", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda_192251631$lambda$28(androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda_192251631$lambda$28(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1968686230$lambda$26(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C742@36879L14:AssetsListScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1968686230, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$1968686230.<anonymous> (AssetsListScreen.kt:742)");
            }
            TextKt.m2693Text4IGK_g("Cancel", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_559291787$lambda$29(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C846@41824L422:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(559291787, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$559291787.<anonymous> (AssetsListScreen.kt:846)");
            }
            TextKt.m2693Text4IGK_g("● LIVE", PaddingKt.m671paddingVpY3zN4(Modifier.INSTANCE, Dp.m6622constructorimpl(4), Dp.m6622constructorimpl(2)), ColorKt.Color(4278556265L), TextUnitKt.getSp(9), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 200118, 0, 131024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_717794631$lambda$30(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C933@46569L294:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(717794631, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$717794631.<anonymous> (AssetsListScreen.kt:933)");
            }
            IconKt.m2150Iconww6aTOc(TuneKt.getTune(Icons.INSTANCE.getDefault()), "Adjust Balance", SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(18)), ColorKt.Color(4278355143L), $composer, 3504, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__422353296$lambda$31(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C947@47311L11,944@47120L305:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-422353296, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$-422353296.<anonymous> (AssetsListScreen.kt:944)");
            }
            IconKt.m2150Iconww6aTOc(EditKt.getEdit(Icons.INSTANCE.getDefault()), "Edit Item", SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(18)), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary(), $composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__2133025777$lambda$32(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C955@47686L293:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2133025777, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$-2133025777.<anonymous> (AssetsListScreen.kt:955)");
            }
            IconKt.m2150Iconww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Delete Item", SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(18)), ColorKt.Color(4293870660L), $composer, 3504, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1028467542$lambda$33(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C972@48245L32:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1028467542, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$1028467542.<anonymous> (AssetsListScreen.kt:972)");
            }
            TextKt.m2693Text4IGK_g("Re Fresh & Adjust Amount", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__93075047$lambda$34(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C977@48428L77:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-93075047, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$-93075047.<anonymous> (AssetsListScreen.kt:977)");
            }
            IconKt.m2150Iconww6aTOc(TuneKt.getTune(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, ColorKt.Color(4278355143L), $composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_727932749$lambda$35(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C981@48659L17:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(727932749, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$727932749.<anonymous> (AssetsListScreen.kt:981)");
            }
            TextKt.m2693Text4IGK_g("Edit Item", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_962296016$lambda$36(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C986@48825L51:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(962296016, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$962296016.<anonymous> (AssetsListScreen.kt:986)");
            }
            IconKt.m2150Iconww6aTOc(EditKt.getEdit(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__2013947186$lambda$37(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C990@49028L46:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2013947186, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$-2013947186.<anonymous> (AssetsListScreen.kt:990)");
            }
            TextKt.m2693Text4IGK_g("Delete Item", (Modifier) null, ColorKt.Color(4293870660L), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 390, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1779583919$lambda$38(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C995@49225L79:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1779583919, $changed, -1, "com.example.ui.screens.ComposableSingletons$AssetsListScreenKt.lambda$-1779583919.<anonymous> (AssetsListScreen.kt:995)");
            }
            IconKt.m2150Iconww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, ColorKt.Color(4293870660L), $composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
