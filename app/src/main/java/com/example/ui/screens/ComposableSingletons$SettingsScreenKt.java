package com.example.ui.screens;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ContentCopyKt;
import androidx.compose.material.icons.filled.DeleteForeverKt;
import androidx.compose.material.icons.filled.DownloadKt;
import androidx.compose.material.icons.filled.FolderOpenKt;
import androidx.compose.material.icons.filled.LogoutKt;
import androidx.compose.material.icons.filled.SaveKt;
import androidx.compose.material.icons.filled.UploadKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$SettingsScreenKt {
    public static final ComposableSingletons$SettingsScreenKt INSTANCE = new ComposableSingletons$SettingsScreenKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$354649585 = ComposableLambdaKt.composableLambdaInstance(354649585, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda_354649585$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1280011407 = ComposableLambdaKt.composableLambdaInstance(1280011407, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda_1280011407$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$863089629 = ComposableLambdaKt.composableLambdaInstance(863089629, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda14
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda_863089629$lambda$3((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$210339419 = ComposableLambdaKt.composableLambdaInstance(210339419, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda26
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda_210339419$lambda$4((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1307483942, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f234lambda$1307483942 = ComposableLambdaKt.composableLambdaInstance(-1307483942, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda28
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda__1307483942$lambda$6((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-182965733, reason: not valid java name */
    private static Function3<ColumnScope, Composer, Integer, Unit> f240lambda$182965733 = ComposableLambdaKt.composableLambdaInstance(-182965733, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda29
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__182965733$lambda$9((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1568375023, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f237lambda$1568375023 = ComposableLambdaKt.composableLambdaInstance(-1568375023, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda30
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda__1568375023$lambda$11((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-845084590, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f249lambda$845084590 = ComposableLambdaKt.composableLambdaInstance(-845084590, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda31
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda__845084590$lambda$13((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$958429817 = ComposableLambdaKt.composableLambdaInstance(958429817, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda32
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda_958429817$lambda$14((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$760354555 = ComposableLambdaKt.composableLambdaInstance(760354555, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda34
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda_760354555$lambda$15((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$2068606406 = ComposableLambdaKt.composableLambdaInstance(2068606406, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda_2068606406$lambda$16((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<ColumnScope, Composer, Integer, Unit> lambda$1986905566 = ComposableLambdaKt.composableLambdaInstance(1986905566, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda22
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda_1986905566$lambda$19((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1349616364 = ComposableLambdaKt.composableLambdaInstance(1349616364, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda33
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda_1349616364$lambda$20((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$657370501 = ComposableLambdaKt.composableLambdaInstance(657370501, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda35
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda_657370501$lambda$21((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$2008672713 = ComposableLambdaKt.composableLambdaInstance(2008672713, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda36
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda_2008672713$lambda$23((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1498770066, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f236lambda$1498770066 = ComposableLambdaKt.composableLambdaInstance(-1498770066, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda37
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__1498770066$lambda$24((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-775479633, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f248lambda$775479633 = ComposableLambdaKt.composableLambdaInstance(-775479633, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda38
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__775479633$lambda$25((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1788713097, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f239lambda$1788713097 = ComposableLambdaKt.composableLambdaInstance(-1788713097, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda39
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__1788713097$lambda$26((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$327312072 = ComposableLambdaKt.composableLambdaInstance(327312072, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda40
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda_327312072$lambda$27((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1307779555 = ComposableLambdaKt.composableLambdaInstance(1307779555, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda_1307779555$lambda$28((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$722279538 = ComposableLambdaKt.composableLambdaInstance(722279538, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda_722279538$lambda$29((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$2064499704 = ComposableLambdaKt.composableLambdaInstance(2064499704, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda_2064499704$lambda$30((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-114442423, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f231lambda$114442423 = ComposableLambdaKt.composableLambdaInstance(-114442423, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__114442423$lambda$31((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$866025060 = ComposableLambdaKt.composableLambdaInstance(866025060, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda_866025060$lambda$33((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1988304259 = ComposableLambdaKt.composableLambdaInstance(1988304259, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda_1988304259$lambda$34((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-286274237, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f241lambda$286274237 = ComposableLambdaKt.composableLambdaInstance(-286274237, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__286274237$lambda$35((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-304733823, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f242lambda$304733823 = ComposableLambdaKt.composableLambdaInstance(-304733823, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__304733823$lambda$36((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-556196918, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f245lambda$556196918 = ComposableLambdaKt.composableLambdaInstance(-556196918, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__556196918$lambda$37((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$424270565 = ComposableLambdaKt.composableLambdaInstance(424270565, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda_424270565$lambda$38((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-728028732, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f246lambda$728028732 = ComposableLambdaKt.composableLambdaInstance(-728028732, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda13
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__728028732$lambda$39((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-746488318, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f247lambda$746488318 = ComposableLambdaKt.composableLambdaInstance(-746488318, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda15
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__746488318$lambda$40((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-997951413, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f250lambda$997951413 = ComposableLambdaKt.composableLambdaInstance(-997951413, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda16
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__997951413$lambda$41((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-17483930, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f238lambda$17483930 = ComposableLambdaKt.composableLambdaInstance(-17483930, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda17
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda__17483930$lambda$42((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1212503542 = ComposableLambdaKt.composableLambdaInstance(1212503542, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda18
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda_1212503542$lambda$43((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1169783227, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f232lambda$1169783227 = ComposableLambdaKt.composableLambdaInstance(-1169783227, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda19
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__1169783227$lambda$44((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1188242813, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f233lambda$1188242813 = ComposableLambdaKt.composableLambdaInstance(-1188242813, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda20
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__1188242813$lambda$45((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1439705908, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f235lambda$1439705908 = ComposableLambdaKt.composableLambdaInstance(-1439705908, false, new Function3() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda21
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__1439705908$lambda$46((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-459238425, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f244lambda$459238425 = ComposableLambdaKt.composableLambdaInstance(-459238425, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda23
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda__459238425$lambda$48((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-432060075, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f243lambda$432060075 = ComposableLambdaKt.composableLambdaInstance(-432060075, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda24
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda__432060075$lambda$50((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1080010114, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f230lambda$1080010114 = ComposableLambdaKt.composableLambdaInstance(-1080010114, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda25
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda__1080010114$lambda$52((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$663040774 = ComposableLambdaKt.composableLambdaInstance(663040774, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda27
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SettingsScreenKt.lambda_663040774$lambda$54((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-1080010114$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7077getLambda$1080010114$app() {
        return f230lambda$1080010114;
    }

    /* renamed from: getLambda$-114442423$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7078getLambda$114442423$app() {
        return f231lambda$114442423;
    }

    /* renamed from: getLambda$-1169783227$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7079getLambda$1169783227$app() {
        return f232lambda$1169783227;
    }

    /* renamed from: getLambda$-1188242813$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7080getLambda$1188242813$app() {
        return f233lambda$1188242813;
    }

    /* renamed from: getLambda$-1307483942$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7081getLambda$1307483942$app() {
        return f234lambda$1307483942;
    }

    /* renamed from: getLambda$-1439705908$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7082getLambda$1439705908$app() {
        return f235lambda$1439705908;
    }

    /* renamed from: getLambda$-1498770066$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7083getLambda$1498770066$app() {
        return f236lambda$1498770066;
    }

    /* renamed from: getLambda$-1568375023$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7084getLambda$1568375023$app() {
        return f237lambda$1568375023;
    }

    /* renamed from: getLambda$-17483930$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7085getLambda$17483930$app() {
        return f238lambda$17483930;
    }

    /* renamed from: getLambda$-1788713097$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7086getLambda$1788713097$app() {
        return f239lambda$1788713097;
    }

    /* renamed from: getLambda$-182965733$app, reason: not valid java name */
    public final Function3<ColumnScope, Composer, Integer, Unit> m7087getLambda$182965733$app() {
        return f240lambda$182965733;
    }

    /* renamed from: getLambda$-286274237$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7088getLambda$286274237$app() {
        return f241lambda$286274237;
    }

    /* renamed from: getLambda$-304733823$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7089getLambda$304733823$app() {
        return f242lambda$304733823;
    }

    /* renamed from: getLambda$-432060075$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7090getLambda$432060075$app() {
        return f243lambda$432060075;
    }

    /* renamed from: getLambda$-459238425$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7091getLambda$459238425$app() {
        return f244lambda$459238425;
    }

    /* renamed from: getLambda$-556196918$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7092getLambda$556196918$app() {
        return f245lambda$556196918;
    }

    /* renamed from: getLambda$-728028732$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7093getLambda$728028732$app() {
        return f246lambda$728028732;
    }

    /* renamed from: getLambda$-746488318$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7094getLambda$746488318$app() {
        return f247lambda$746488318;
    }

    /* renamed from: getLambda$-775479633$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7095getLambda$775479633$app() {
        return f248lambda$775479633;
    }

    /* renamed from: getLambda$-845084590$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7096getLambda$845084590$app() {
        return f249lambda$845084590;
    }

    /* renamed from: getLambda$-997951413$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7097getLambda$997951413$app() {
        return f250lambda$997951413;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1212503542$app() {
        return lambda$1212503542;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1280011407$app() {
        return lambda$1280011407;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1307779555$app() {
        return lambda$1307779555;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1349616364$app() {
        return lambda$1349616364;
    }

    public final Function3<ColumnScope, Composer, Integer, Unit> getLambda$1986905566$app() {
        return lambda$1986905566;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1988304259$app() {
        return lambda$1988304259;
    }

    public final Function2<Composer, Integer, Unit> getLambda$2008672713$app() {
        return lambda$2008672713;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$2064499704$app() {
        return lambda$2064499704;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$2068606406$app() {
        return lambda$2068606406;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$210339419$app() {
        return lambda$210339419;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$327312072$app() {
        return lambda$327312072;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$354649585$app() {
        return lambda$354649585;
    }

    public final Function2<Composer, Integer, Unit> getLambda$424270565$app() {
        return lambda$424270565;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$657370501$app() {
        return lambda$657370501;
    }

    public final Function2<Composer, Integer, Unit> getLambda$663040774$app() {
        return lambda$663040774;
    }

    public final Function2<Composer, Integer, Unit> getLambda$722279538$app() {
        return lambda$722279538;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$760354555$app() {
        return lambda$760354555;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$863089629$app() {
        return lambda$863089629;
    }

    public final Function2<Composer, Integer, Unit> getLambda$866025060$app() {
        return lambda$866025060;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$958429817$app() {
        return lambda$958429817;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_354649585$lambda$0(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C167@6929L40:SettingsScreen.kt#2thlc2");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(354649585, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$354649585.<anonymous> (SettingsScreen.kt:167)");
            }
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(8)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda_1280011407$lambda$2(androidx.compose.runtime.Composer r32, int r33) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda_1280011407$lambda$2(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_863089629$lambda$3(RowScope OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C209@9123L19:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(863089629, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$863089629.<anonymous> (SettingsScreen.kt:209)");
            }
            TextKt.m2693Text4IGK_g("Change Pass", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_210339419$lambda$4(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C218@9583L86,219@9698L39,220@9766L18:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(210339419, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$210339419.<anonymous> (SettingsScreen.kt:218)");
            }
            IconKt.m2150Iconww6aTOc(LogoutKt.getLogout(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(6)), $composer, 6);
            TextKt.m2693Text4IGK_g("Lock Vault", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0242  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda__182965733$lambda$9(androidx.compose.foundation.layout.ColumnScope r71, androidx.compose.runtime.Composer r72, int r73) {
        /*
            Method dump skipped, instructions count: 937
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda__182965733$lambda$9(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda__1307483942$lambda$6(androidx.compose.runtime.Composer r32, int r33) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda__1307483942$lambda$6(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda__1568375023$lambda$11(androidx.compose.runtime.Composer r32, int r33) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda__1568375023$lambda$11(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda__845084590$lambda$13(androidx.compose.runtime.Composer r32, int r33) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda__845084590$lambda$13(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_958429817$lambda$14(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C404@18912L88,405@19029L39,406@19097L49:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(958429817, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$958429817.<anonymous> (SettingsScreen.kt:404)");
            }
            IconKt.m2150Iconww6aTOc(DownloadKt.getDownload(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(18)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(8)), $composer, 6);
            TextKt.m2693Text4IGK_g("Create Backup File (Save to File Manager)", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_760354555$lambda$15(RowScope OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C416@19605L90,417@19724L39,418@19792L47:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(760354555, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$760354555.<anonymous> (SettingsScreen.kt:416)");
            }
            IconKt.m2150Iconww6aTOc(FolderOpenKt.getFolderOpen(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(18)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(8)), $composer, 6);
            TextKt.m2693Text4IGK_g("Restore Backup File (From File Manager)", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_2068606406$lambda$16(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C425@20168L10,425@20110L79:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2068606406, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$2068606406.<anonymous> (SettingsScreen.kt:425)");
            }
            TextKt.m2693Text4IGK_g("Or paste JSON text manually", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 6, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1349616364$lambda$20(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C437@20537L46,434@20356L1395:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1349616364, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$1349616364.<anonymous> (SettingsScreen.kt:434)");
            }
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "offline_guarantee_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(20)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(ColorKt.Color(4278603323L), 0L, 0L, 0L, $composer, (CardDefaults.$stable << 12) | 6, 14), null, null, lambda$1986905566, $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda_1986905566$lambda$19(androidx.compose.foundation.layout.ColumnScope r83, androidx.compose.runtime.Composer r84, int r85) {
        /*
            Method dump skipped, instructions count: 907
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda_1986905566$lambda$19(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_657370501$lambda$21(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C496@23824L93,497@23942L39,498@24006L45:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(657370501, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$657370501.<anonymous> (SettingsScreen.kt:496)");
            }
            IconKt.m2150Iconww6aTOc(DeleteForeverKt.getDeleteForever(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(18)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(8)), $composer, 6);
            TextKt.m2693Text4IGK_g("Delete All Financial Data & Reset App", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1498770066$lambda$24(LazyItemScope item, Composer $composer, int $changed) {
        long m4157copywmQWz5c;
        long m4157copywmQWz5c2;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C511@24411L11,512@24546L11,506@24184L1405:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1498770066, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-1498770066.<anonymous> (SettingsScreen.kt:506)");
            }
            Modifier testTag = TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "developer_credit_footer");
            RoundedCornerShape m953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(16));
            m4157copywmQWz5c = Color.m4157copywmQWz5c(r15, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(r15) : 0.5f, (r12 & 2) != 0 ? Color.m4165getRedimpl(r15) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(r15) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimaryContainer()) : 0.0f);
            float m6622constructorimpl = Dp.m6622constructorimpl(1);
            m4157copywmQWz5c2 = Color.m4157copywmQWz5c(r15, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(r15) : 0.3f, (r12 & 2) != 0 ? Color.m4165getRedimpl(r15) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(r15) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary()) : 0.0f);
            SurfaceKt.m2543SurfaceT9BRK9s(testTag, m953RoundedCornerShape0680j_4, m4157copywmQWz5c, 0L, 0.0f, 0.0f, BorderStrokeKt.m252BorderStrokecXLIe8U(m6622constructorimpl, m4157copywmQWz5c2), lambda$2008672713, $composer, 12582918, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda_2008672713$lambda$23(androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instructions count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda_2008672713$lambda$23(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__775479633$lambda$25(LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C539@25616L41:SettingsScreen.kt#2thlc2");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-775479633, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-775479633.<anonymous> (SettingsScreen.kt:539)");
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
    public static final Unit lambda_1307779555$lambda$28(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C547@25888L31:SettingsScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1307779555, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$1307779555.<anonymous> (SettingsScreen.kt:547)");
            }
            TextKt.m2693Text4IGK_g("Change Offline Password", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_722279538$lambda$29(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C555@26302L20:SettingsScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(722279538, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$722279538.<anonymous> (SettingsScreen.kt:555)");
            }
            TextKt.m2693Text4IGK_g("New Password", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1788713097$lambda$26(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C571@26951L12:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1788713097, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-1788713097.<anonymous> (SettingsScreen.kt:571)");
            }
            TextKt.m2693Text4IGK_g("Save", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_327312072$lambda$27(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C576@27118L14:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(327312072, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$327312072.<anonymous> (SettingsScreen.kt:576)");
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
    public static final kotlin.Unit lambda_866025060$lambda$33(androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda_866025060$lambda$33(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1988304259$lambda$34(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C594@27790L182:SettingsScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1988304259, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$1988304259.<anonymous> (SettingsScreen.kt:594)");
            }
            TextKt.m2693Text4IGK_g("This will wipe all accounts, assets, liabilities, ledger history, and snapshots from your phone. This action cannot be undone. Make sure you have exported a backup if needed.", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_2064499704$lambda$30(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C605@28471L30:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2064499704, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$2064499704.<anonymous> (SettingsScreen.kt:605)");
            }
            TextKt.m2693Text4IGK_g("Yes, Delete Everything", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__114442423$lambda$31(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C610@28664L14:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-114442423, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-114442423.<anonymous> (SettingsScreen.kt:610)");
            }
            TextKt.m2693Text4IGK_g("Cancel", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_424270565$lambda$38(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C623@29062L30:SettingsScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(424270565, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$424270565.<anonymous> (SettingsScreen.kt:623)");
            }
            TextKt.m2693Text4IGK_g("Backup Saved & Options", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__286274237$lambda$35(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C653@30505L84,654@30614L39,655@30678L29:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-286274237, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-286274237.<anonymous> (SettingsScreen.kt:653)");
            }
            IconKt.m2150Iconww6aTOc(SaveKt.getSave(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(6)), $composer, 6);
            TextKt.m2693Text4IGK_g("Save to Custom Folder", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__304733823$lambda$36(RowScope OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C667@31324L91,668@31440L39,669@31504L22:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-304733823, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-304733823.<anonymous> (SettingsScreen.kt:667)");
            }
            IconKt.m2150Iconww6aTOc(ContentCopyKt.getContentCopy(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(6)), $composer, 6);
            TextKt.m2693Text4IGK_g("Copy JSON Code", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__556196918$lambda$37(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C675@31701L12:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-556196918, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-556196918.<anonymous> (SettingsScreen.kt:675)");
            }
            TextKt.m2693Text4IGK_g("Done", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__17483930$lambda$42(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C685@31943L30:SettingsScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-17483930, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-17483930.<anonymous> (SettingsScreen.kt:685)");
            }
            TextKt.m2693Text4IGK_g("Paste JSON Backup Code", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1212503542$lambda$43(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C693@32379L31:SettingsScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1212503542, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$1212503542.<anonymous> (SettingsScreen.kt:693)");
            }
            TextKt.m2693Text4IGK_g("Paste JSON code here...", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__728028732$lambda$39(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C720@33821L86,721@33932L39,722@33996L35:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-728028732, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-728028732.<anonymous> (SettingsScreen.kt:720)");
            }
            IconKt.m2150Iconww6aTOc(UploadKt.getUpload(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(6)), $composer, 6);
            TextKt.m2693Text4IGK_g("🔀 Merge with Existing Data", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__746488318$lambda$40(RowScope OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C742@35144L36:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-746488318, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-746488318.<anonymous> (SettingsScreen.kt:742)");
            }
            TextKt.m2693Text4IGK_g("⚠️ Replace All Existing Data", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__997951413$lambda$41(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C748@35355L14:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-997951413, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-997951413.<anonymous> (SettingsScreen.kt:748)");
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
    public static final kotlin.Unit lambda__459238425$lambda$48(androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda__459238425$lambda$48(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0296  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda_663040774$lambda$54(androidx.compose.runtime.Composer r49, int r50) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda_663040774$lambda$54(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda__432060075$lambda$50(androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda__432060075$lambda$50(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit lambda__1080010114$lambda$52(androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda__1080010114$lambda$52(androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1169783227$lambda$44(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C833@39931L86,834@40042L39,835@40106L35:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1169783227, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-1169783227.<anonymous> (SettingsScreen.kt:833)");
            }
            IconKt.m2150Iconww6aTOc(UploadKt.getUpload(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(6)), $composer, 6);
            TextKt.m2693Text4IGK_g("🔀 Merge with Existing Data", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1188242813$lambda$45(RowScope OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation($composer, "C852@41112L36:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1188242813, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-1188242813.<anonymous> (SettingsScreen.kt:852)");
            }
            TextKt.m2693Text4IGK_g("⚠️ Replace All Existing Data", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1439705908$lambda$46(RowScope TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C858@41324L14:SettingsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1439705908, $changed, -1, "com.example.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-1439705908.<anonymous> (SettingsScreen.kt:858)");
            }
            TextKt.m2693Text4IGK_g("Cancel", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
