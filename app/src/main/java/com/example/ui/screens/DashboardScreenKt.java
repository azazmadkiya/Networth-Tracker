package com.example.ui.screens;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AccountBalanceKt;
import androidx.compose.material.icons.filled.ArrowDownwardKt;
import androidx.compose.material.icons.filled.DiamondKt;
import androidx.compose.material.icons.filled.HandshakeKt;
import androidx.compose.material.icons.filled.HomeKt;
import androidx.compose.material.icons.filled.PaymentsKt;
import androidx.compose.material.icons.filled.PieChartKt;
import androidx.compose.material.icons.filled.SavingsKt;
import androidx.compose.material.icons.filled.ShowChartKt;
import androidx.compose.material.icons.filled.TrendingUpKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.FilterChipDefaults;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SelectableChipColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import com.example.data.model.FinancialItem;
import com.example.data.model.FinancialReminder;
import com.example.data.model.NetWorthSnapshot;
import com.example.data.model.OwnerProfile;
import com.example.ui.viewmodel.CategorySummary;
import com.example.ui.viewmodel.NetWorthSummary;
import com.example.ui.viewmodel.NetWorthViewModel;
import com.example.ui.viewmodel.OwnerSummary;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DashboardScreen.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u001aW\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u000b\u001a\u0015\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0010\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a%\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017²\u0006\n\u0010\r\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\u0010\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\u0010\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u001aX\u008a\u0084\u0002²\u0006\u0010\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001aX\u008a\u0084\u0002²\u0006\u0010\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001aX\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\"X\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020$X\u008a\u0084\u0002²\u0006\u0010\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001aX\u008a\u0084\u0002"}, d2 = {"DashboardScreen", "", "viewModel", "Lcom/example/ui/viewmodel/NetWorthViewModel;", "onAddNewItem", "Lkotlin/Function0;", "onNavigateToAssets", "onEditItem", "Lkotlin/Function1;", "Lcom/example/data/model/FinancialItem;", "onNavigateToReminders", "(Lcom/example/ui/viewmodel/NetWorthViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "OwnerSummaryCard", "summary", "Lcom/example/ui/viewmodel/OwnerSummary;", "(Lcom/example/ui/viewmodel/OwnerSummary;Landroidx/compose/runtime/Composer;I)V", "CategoryAllocationCard", "Lcom/example/ui/viewmodel/CategorySummary;", "(Lcom/example/ui/viewmodel/CategorySummary;Landroidx/compose/runtime/Composer;I)V", "TopHoldingCard", "item", "onClick", "(Lcom/example/data/model/FinancialItem;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app", "Lcom/example/ui/viewmodel/NetWorthSummary;", "snapshots", "", "Lcom/example/data/model/NetWorthSnapshot;", "selectedOwner", "", "categorySummaries", "ownerSummaries", "items", "isLiveTracking", "", "liveTickCount", "", "allReminders", "Lcom/example/data/model/FinancialReminder;"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DashboardScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CategoryAllocationCard$lambda$79(CategorySummary categorySummary, int i, Composer composer, int i2) {
        CategoryAllocationCard(categorySummary, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DashboardScreen$lambda$57(NetWorthViewModel netWorthViewModel, Function0 function0, Function0 function02, Function1 function1, Function0 function03, int i, int i2, Composer composer, int i3) {
        DashboardScreen(netWorthViewModel, function0, function02, function1, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OwnerSummaryCard$lambda$70(OwnerSummary ownerSummary, int i, Composer composer, int i2) {
        OwnerSummaryCard(ownerSummary, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TopHoldingCard$lambda$90(FinancialItem financialItem, Function0 function0, int i, int i2, Composer composer, int i3) {
        TopHoldingCard(financialItem, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void DashboardScreen(final com.example.ui.viewmodel.NetWorthViewModel r61, final kotlin.jvm.functions.Function0<kotlin.Unit> r62, final kotlin.jvm.functions.Function0<kotlin.Unit> r63, final kotlin.jvm.functions.Function1<? super com.example.data.model.FinancialItem, kotlin.Unit> r64, kotlin.jvm.functions.Function0<kotlin.Unit> r65, androidx.compose.runtime.Composer r66, final int r67, final int r68) {
        /*
            Method dump skipped, instructions count: 1030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.DashboardScreenKt.DashboardScreen(com.example.ui.viewmodel.NetWorthViewModel, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final NetWorthSummary DashboardScreen$lambda$0(State<NetWorthSummary> state) {
        return (NetWorthSummary) state.getValue();
    }

    private static final List<NetWorthSnapshot> DashboardScreen$lambda$1(State<? extends List<NetWorthSnapshot>> state) {
        return (List) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DashboardScreen$lambda$2(State<String> state) {
        return (String) state.getValue();
    }

    private static final List<CategorySummary> DashboardScreen$lambda$3(State<? extends List<CategorySummary>> state) {
        return (List) state.getValue();
    }

    private static final List<OwnerSummary> DashboardScreen$lambda$4(State<? extends List<OwnerSummary>> state) {
        return (List) state.getValue();
    }

    private static final List<FinancialItem> DashboardScreen$lambda$5(State<? extends List<FinancialItem>> state) {
        return (List) state.getValue();
    }

    private static final List<FinancialReminder> DashboardScreen$lambda$8(State<? extends List<FinancialReminder>> state) {
        return (List) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DashboardScreen$lambda$56$lambda$55$lambda$54(final State $selectedOwner$delegate, final NetWorthViewModel $viewModel, final State $summary$delegate, final Function0 $onNavigateToReminders, final List $pendingReminders, final State $ownerSummaries$delegate, final Function0 $onNavigateToAssets, final State $categorySummaries$delegate, final State $items$delegate, final Function1 $onEditItem, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$DashboardScreenKt.INSTANCE.getLambda$1645740770$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-723128871, true, new Function3() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$14(State.this, $viewModel, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-546800614, true, new Function3() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$29(NetWorthViewModel.this, $selectedOwner$delegate, $summary$delegate, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-370472357, true, new Function3() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$39(Function0.this, $pendingReminders, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        if (Intrinsics.areEqual(DashboardScreen$lambda$2($selectedOwner$delegate), "All")) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(101816573, true, new Function3() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$42(State.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-194144100, true, new Function3() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$48(Function0.this, $categorySummaries$delegate, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-17815843, true, new Function3() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$53(State.this, $onEditItem, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$DashboardScreenKt.INSTANCE.getLambda$158512414$app(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$14(final State $selectedOwner$delegate, final NetWorthViewModel $viewModel, LazyItemScope item, Composer $composer, int $changed) {
        Object obj;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C106@4965L10,107@5031L11,104@4861L268,110@5146L40,114@5370L1439,111@5203L1606:DashboardScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-723128871, $changed, -1, "com.example.ui.screens.DashboardScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DashboardScreen.kt:104)");
            }
            TextKt.m2693Text4IGK_g("Filter Assets by Category", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelMedium(), $composer, 196614, 0, 65498);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(4)), $composer, 6);
            Arrangement.HorizontalOrVertical m550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6622constructorimpl(8));
            Modifier testTag = TestTagKt.testTag(Modifier.INSTANCE, "owner_filter_row");
            Arrangement.HorizontalOrVertical horizontalOrVertical = m550spacedBy0680j_4;
            ComposerKt.sourceInformationMarkerStart($composer, 857875224, "CC(remember):DashboardScreen.kt#9igjgp");
            boolean changed = $composer.changed($selectedOwner$delegate) | $composer.changedInstance($viewModel);
            Object rememberedValue = $composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function1() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$14$lambda$13$lambda$12(NetWorthViewModel.this, $selectedOwner$delegate, (LazyListScope) obj2);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyRow(testTag, null, null, false, horizontalOrVertical, null, null, false, (Function1) obj, $composer, 24582, 238);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$14$lambda$13$lambda$12(final NetWorthViewModel $viewModel, final State $selectedOwner$delegate, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        final List filterCategories = CollectionsKt.listOf((Object[]) new String[]{"All", "Self", "Father", "Mother"});
        final Function1 function1 = new Function1() { // from class: com.example.ui.screens.DashboardScreenKt$DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$14$lambda$13$lambda$12$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke((String) p1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(String str) {
                return null;
            }
        };
        LazyRow.items(filterCategories.size(), null, new Function1<Integer, Object>() { // from class: com.example.ui.screens.DashboardScreenKt$DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$14$lambda$13$lambda$12$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke(filterCategories.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.screens.DashboardScreenKt$DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$14$lambda$13$lambda$12$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                String DashboardScreen$lambda$2;
                Object obj;
                ComposerKt.sourceInformation($composer, "C152@7074L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (($dirty & 147) == 146 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                int i = $dirty & 14;
                final String str = (String) filterCategories.get(it);
                $composer.startReplaceGroup(1448718081);
                ComposerKt.sourceInformation($composer, "C*131@6490L11,132@6587L11,130@6401L246,120@5731L50,121@5819L301,118@5630L1139:DashboardScreen.kt#2thlc2");
                DashboardScreen$lambda$2 = DashboardScreenKt.DashboardScreen$lambda$2($selectedOwner$delegate);
                final boolean equals = StringsKt.equals(DashboardScreen$lambda$2, str, true);
                Function2<Composer, Integer, Unit> lambda$350102924$app = equals ? ComposableSingletons$DashboardScreenKt.INSTANCE.getLambda$350102924$app() : null;
                SelectableChipColors m2111filterChipColorsXqyqHi0 = FilterChipDefaults.INSTANCE.m2111filterChipColorsXqyqHi0(0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimaryContainer(), 0L, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, 0L, $composer, 0, FilterChipDefaults.$stable << 6, 3455);
                Modifier.Companion companion = Modifier.INSTANCE;
                String lowerCase = str.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                Modifier testTag = TestTagKt.testTag(companion, "filter_chip_" + lowerCase);
                ComposerKt.sourceInformationMarkerStart($composer, 878021798, "CC(remember):DashboardScreen.kt#9igjgp");
                boolean changedInstance = $composer.changedInstance($viewModel) | ((((i & 112) ^ 48) > 32 && $composer.changed(str)) || (i & 48) == 32);
                Object rememberedValue = $composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final NetWorthViewModel netWorthViewModel = $viewModel;
                    obj = (Function0) new Function0<Unit>() { // from class: com.example.ui.screens.DashboardScreenKt$DashboardScreen$1$1$1$1$1$1$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            NetWorthViewModel.this.getSelectedOwnerFilter().setValue(str);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ChipKt.FilterChip(equals, (Function0) obj, ComposableLambdaKt.rememberComposableLambda(-746836761, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.ui.screens.DashboardScreenKt$DashboardScreen$1$1$1$1$1$1$1$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C122@5853L237:DashboardScreen.kt#2thlc2");
                        if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-746836761, $changed2, -1, "com.example.ui.screens.DashboardScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DashboardScreen.kt:122)");
                        }
                        TextKt.m2693Text4IGK_g(Intrinsics.areEqual(str, "All") ? "All Assets" : str, (Modifier) null, 0L, 0L, (FontStyle) null, equals ? FontWeight.INSTANCE.getBold() : FontWeight.INSTANCE.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 0, 131038);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer, 54), testTag, false, lambda$350102924$app, null, null, m2111filterChipColorsXqyqHi0, null, null, null, $composer, 384, 0, 3792);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$29(final NetWorthViewModel $viewModel, final State $selectedOwner$delegate, final State $summary$delegate, LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C147@7143L92,150@7254L8525,142@6903L8876:DashboardScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-546800614, $changed, -1, "com.example.ui.screens.DashboardScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DashboardScreen.kt:142)");
            }
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "net_worth_hero_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(24)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(Color.INSTANCE.m4195getUnspecified0d7_KjU(), 0L, 0L, 0L, $composer, (CardDefaults.$stable << 12) | 6, 14), null, null, ComposableLambdaKt.rememberComposableLambda(998701324, true, new Function3() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$29$lambda$28(NetWorthViewModel.this, $selectedOwner$delegate, $summary$delegate, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0bc6  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0bff  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0cd4  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0ce0  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0d17  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0e94  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0f47  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0f08  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0d2d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0ce6  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0c15 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0bcc  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0a04 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x09bb  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x08e6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x089d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x07c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0780  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0384 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x076e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x077a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x07b3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x088b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0897  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x08d0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x09a9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x09b5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x09ee  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0bba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$29$lambda$28(final com.example.ui.viewmodel.NetWorthViewModel r158, androidx.compose.runtime.State r159, final androidx.compose.runtime.State r160, androidx.compose.foundation.layout.ColumnScope r161, androidx.compose.runtime.Composer r162, int r163) {
        /*
            Method dump skipped, instructions count: 3917
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$29$lambda$28(com.example.ui.viewmodel.NetWorthViewModel, androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$29$lambda$28$lambda$27$lambda$26$lambda$18$lambda$17$lambda$16(NetWorthViewModel $viewModel) {
        $viewModel.refreshAndRecalculateAll();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0191  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$29$lambda$28$lambda$27$lambda$26$lambda$25(androidx.compose.runtime.State r52, androidx.compose.runtime.Composer r53, int r54) {
        /*
            Method dump skipped, instructions count: 601
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$29$lambda$28$lambda$27$lambda$26$lambda$25(androidx.compose.runtime.State, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$39(final Function0 $onNavigateToReminders, final List $pendingReminders, LazyItemScope item, Composer $composer, int $changed) {
        Object obj;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C301@16002L35,304@16241L11,304@16199L71,305@16289L3683,298@15881L4091:DashboardScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-370472357, $changed, -1, "com.example.ui.screens.DashboardScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DashboardScreen.kt:298)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer, 458354974, "CC(remember):DashboardScreen.kt#9igjgp");
            boolean changed = $composer.changed($onNavigateToReminders);
            Object rememberedValue = $composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$39$lambda$31$lambda$30(Function0.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CardKt.Card(TestTagKt.testTag(ClickableKt.m258clickableXHw0xAI$default(fillMaxWidth$default, false, null, null, (Function0) obj, 7, null), "dashboard_reminders_banner"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(16)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainer(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(1175029581, true, new Function3() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$39$lambda$38($pendingReminders, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, $composer, 54), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$39$lambda$31$lambda$30(Function0 $onNavigateToReminders) {
        if ($onNavigateToReminders != null) {
            $onNavigateToReminders.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0710  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0638  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$39$lambda$38(final java.util.List r130, androidx.compose.foundation.layout.ColumnScope r131, androidx.compose.runtime.Composer r132, int r133) {
        /*
            Method dump skipped, instructions count: 1814
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$39$lambda$38(java.util.List, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$39$lambda$38$lambda$37$lambda$36$lambda$35$lambda$33$lambda$32(List $pendingReminders, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C342@18417L459:DashboardScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1136315995, $changed, -1, "com.example.ui.screens.DashboardScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DashboardScreen.kt:342)");
            }
            TextKt.m2693Text4IGK_g(String.valueOf($pendingReminders.size()), PaddingKt.m671paddingVpY3zN4(Modifier.INSTANCE, Dp.m6622constructorimpl(6), Dp.m6622constructorimpl(2)), Color.INSTANCE.m4196getWhite0d7_KjU(), TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 200112, 0, 131024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01ae A[LOOP:0: B:24:0x01a8->B:26:0x01ae, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$42(androidx.compose.runtime.State r30, androidx.compose.foundation.lazy.LazyItemScope r31, androidx.compose.runtime.Composer r32, int r33) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$42(androidx.compose.runtime.State, androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x038b A[LOOP:0: B:40:0x0385->B:42:0x038b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$48(final kotlin.jvm.functions.Function0 r56, androidx.compose.runtime.State r57, androidx.compose.foundation.lazy.LazyItemScope r58, androidx.compose.runtime.Composer r59, int r60) {
        /*
            Method dump skipped, instructions count: 973
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$48(kotlin.jvm.functions.Function0, androidx.compose.runtime.State, androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$48$lambda$45$lambda$44$lambda$43(Function0 $onNavigateToAssets) {
        $onNavigateToAssets.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x020f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$53(androidx.compose.runtime.State r39, final kotlin.jvm.functions.Function1 r40, androidx.compose.foundation.lazy.LazyItemScope r41, androidx.compose.runtime.Composer r42, int r43) {
        /*
            Method dump skipped, instructions count: 672
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.DashboardScreenKt.DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$53(androidx.compose.runtime.State, kotlin.jvm.functions.Function1, androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DashboardScreen$lambda$56$lambda$55$lambda$54$lambda$53$lambda$52$lambda$51$lambda$50$lambda$49(Function1 $onEditItem, FinancialItem $item) {
        $onEditItem.invoke($item);
        return Unit.INSTANCE;
    }

    public static final void OwnerSummaryCard(final OwnerSummary summary, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(summary, "summary");
        Composer $composer3 = $composer.startRestartGroup(-1763086492);
        ComposerKt.sourceInformation($composer3, "C(OwnerSummaryCard)472@23990L11,472@23948L74,474@24072L4786,468@23795L5063:DashboardScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(summary) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1763086492, $dirty2, -1, "com.example.ui.screens.OwnerSummaryCard (DashboardScreen.kt:464)");
            }
            OwnerProfile profile = OwnerProfile.INSTANCE.fromString(summary.getOwner());
            final long color = ColorKt.Color(profile.getBadgeColorHex());
            $composer2 = $composer3;
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "owner_summary_card_" + summary.getOwner()), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(16)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(64864982, true, new Function3() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DashboardScreenKt.OwnerSummaryCard$lambda$69(OwnerSummary.this, color, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer2, 54), $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DashboardScreenKt.OwnerSummaryCard$lambda$70(OwnerSummary.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x060c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0760  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x07f1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x07cb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0622  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0352 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit OwnerSummaryCard$lambda$69(final com.example.ui.viewmodel.OwnerSummary r114, final long r115, androidx.compose.foundation.layout.ColumnScope r117, androidx.compose.runtime.Composer r118, int r119) {
        /*
            Method dump skipped, instructions count: 2039
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.DashboardScreenKt.OwnerSummaryCard$lambda$69(com.example.ui.viewmodel.OwnerSummary, long, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x017e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit OwnerSummaryCard$lambda$69$lambda$68$lambda$61$lambda$60$lambda$59(com.example.ui.viewmodel.OwnerSummary r49, long r50, androidx.compose.runtime.Composer r52, int r53) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.DashboardScreenKt.OwnerSummaryCard$lambda$69$lambda$68$lambda$61$lambda$60$lambda$59(com.example.ui.viewmodel.OwnerSummary, long, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit OwnerSummaryCard$lambda$69$lambda$68$lambda$67(com.example.ui.viewmodel.OwnerSummary r83, androidx.compose.runtime.Composer r84, int r85) {
        /*
            Method dump skipped, instructions count: 968
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.DashboardScreenKt.OwnerSummaryCard$lambda$69$lambda$68$lambda$67(com.example.ui.viewmodel.OwnerSummary, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    public static final void CategoryAllocationCard(final CategorySummary summary, Composer $composer, final int $changed) {
        final ImageVector categoryIcon;
        long color;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(summary, "summary");
        Composer $composer3 = $composer.startRestartGroup(1623002678);
        ComposerKt.sourceInformation($composer3, "C(CategoryAllocationCard)607@30158L11,607@30116L62,608@30185L1965,602@29911L2239:DashboardScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(summary) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1623002678, $dirty2, -1, "com.example.ui.screens.CategoryAllocationCard (DashboardScreen.kt:586)");
            }
            if (StringsKt.contains((CharSequence) summary.getCategory(), (CharSequence) "Bank", true)) {
                categoryIcon = AccountBalanceKt.getAccountBalance(Icons.INSTANCE.getDefault());
            } else if (StringsKt.contains((CharSequence) summary.getCategory(), (CharSequence) "Share", true)) {
                categoryIcon = TrendingUpKt.getTrendingUp(Icons.INSTANCE.getDefault());
            } else if (StringsKt.contains((CharSequence) summary.getCategory(), (CharSequence) "Mutual", true)) {
                categoryIcon = PieChartKt.getPieChart(Icons.INSTANCE.getDefault());
            } else if (StringsKt.contains((CharSequence) summary.getCategory(), (CharSequence) "IPO", true)) {
                categoryIcon = ShowChartKt.getShowChart(Icons.INSTANCE.getDefault());
            } else if (StringsKt.contains((CharSequence) summary.getCategory(), (CharSequence) "Paid Loan", true) || StringsKt.contains((CharSequence) summary.getCategory(), (CharSequence) "Aapel", true) || StringsKt.contains((CharSequence) summary.getCategory(), (CharSequence) "Chekvel", true) || StringsKt.contains((CharSequence) summary.getCategory(), (CharSequence) "Loan Given", true)) {
                categoryIcon = HandshakeKt.getHandshake(Icons.INSTANCE.getDefault());
            } else if (StringsKt.contains((CharSequence) summary.getCategory(), (CharSequence) "Gold", true)) {
                categoryIcon = DiamondKt.getDiamond(Icons.INSTANCE.getDefault());
            } else if (StringsKt.contains((CharSequence) summary.getCategory(), (CharSequence) "Estate", true)) {
                categoryIcon = HomeKt.getHome(Icons.INSTANCE.getDefault());
            } else if (StringsKt.contains((CharSequence) summary.getCategory(), (CharSequence) "Cash", true)) {
                categoryIcon = PaymentsKt.getPayments(Icons.INSTANCE.getDefault());
            } else {
                categoryIcon = summary.isLiability() ? ArrowDownwardKt.getArrowDownward(Icons.INSTANCE.getDefault()) : SavingsKt.getSavings(Icons.INSTANCE.getDefault());
            }
            if (summary.isLiability()) {
                $composer3.startReplaceGroup(632476711);
                $composer3.endReplaceGroup();
                color = ColorKt.Color(4293870660L);
            } else {
                $composer3.startReplaceGroup(632478269);
                ComposerKt.sourceInformation($composer3, "600@29886L11");
                color = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
                $composer3.endReplaceGroup();
            }
            final long color2 = color;
            $composer2 = $composer3;
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "category_allocation_card_" + summary.getCategory()), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(12)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-559252732, true, new Function3() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DashboardScreenKt.CategoryAllocationCard$lambda$78(color2, categoryIcon, summary, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer2, 54), $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DashboardScreenKt.CategoryAllocationCard$lambda$79(CategorySummary.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0255  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit CategoryAllocationCard$lambda$78(final long r98, final androidx.compose.ui.graphics.vector.ImageVector r100, final com.example.ui.viewmodel.CategorySummary r101, androidx.compose.foundation.layout.ColumnScope r102, androidx.compose.runtime.Composer r103, int r104) {
        /*
            Method dump skipped, instructions count: 1465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.DashboardScreenKt.CategoryAllocationCard$lambda$78(long, androidx.compose.ui.graphics.vector.ImageVector, com.example.ui.viewmodel.CategorySummary, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit CategoryAllocationCard$lambda$78$lambda$77$lambda$72(androidx.compose.ui.graphics.vector.ImageVector r32, long r33, androidx.compose.runtime.Composer r35, int r36) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.DashboardScreenKt.CategoryAllocationCard$lambda$78$lambda$77$lambda$72(androidx.compose.ui.graphics.vector.ImageVector, long, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    public static final void TopHoldingCard(final FinancialItem item, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Function0 function02;
        final Function0 onClick;
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(item, "item");
        Composer $composer2 = $composer.startRestartGroup(-204197018);
        ComposerKt.sourceInformation($composer2, "C(TopHoldingCard)662@32237L2,670@32450L13,673@32565L3016,667@32357L3224:DashboardScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(item) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            function02 = function0;
        } else if (($changed & 48) == 0) {
            function02 = function0;
            $dirty |= $composer2.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            onClick = function02;
        } else {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1335163976, "CC(remember):DashboardScreen.kt#9igjgp");
                Object rememberedValue = $composer2.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    obj2 = new Function0() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(obj2);
                } else {
                    obj2 = rememberedValue;
                }
                Function0 onClick2 = (Function0) obj2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onClick = onClick2;
            } else {
                onClick = function02;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-204197018, $dirty2, -1, "com.example.ui.screens.TopHoldingCard (DashboardScreen.kt:663)");
            }
            OwnerProfile ownerProf = OwnerProfile.INSTANCE.fromString(item.getOwner());
            final long ownerColor = ColorKt.Color(ownerProf.getBadgeColorHex());
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1335170803, "CC(remember):DashboardScreen.kt#9igjgp");
            boolean z = ($dirty2 & 112) == 32;
            Object rememberedValue2 = $composer2.rememberedValue();
            if (z || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DashboardScreenKt.TopHoldingCard$lambda$83$lambda$82(Function0.this);
                    }
                };
                $composer2.updateRememberedValue(obj);
            } else {
                obj = rememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CardKt.OutlinedCard(TestTagKt.testTag(ClickableKt.m258clickableXHw0xAI$default(fillMaxWidth$default, false, null, null, (Function0) obj, 7, null), "top_holding_card_" + item.getId()), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(12)), null, null, null, ComposableLambdaKt.rememberComposableLambda(467017330, true, new Function3() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return DashboardScreenKt.TopHoldingCard$lambda$89(FinancialItem.this, ownerColor, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, $composer2, 54), $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.DashboardScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return DashboardScreenKt.TopHoldingCard$lambda$90(FinancialItem.this, onClick, $changed, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TopHoldingCard$lambda$83$lambda$82(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x063f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x06cd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0838  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0655  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x060e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0355 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit TopHoldingCard$lambda$89(final com.example.data.model.FinancialItem r112, final long r113, androidx.compose.foundation.layout.ColumnScope r115, androidx.compose.runtime.Composer r116, int r117) {
        /*
            Method dump skipped, instructions count: 2110
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.DashboardScreenKt.TopHoldingCard$lambda$89(com.example.data.model.FinancialItem, long, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TopHoldingCard$lambda$89$lambda$88$lambda$86$lambda$85$lambda$84(FinancialItem $item, long $ownerColor, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C688@33195L322:DashboardScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1717557767, $changed, -1, "com.example.ui.screens.TopHoldingCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DashboardScreen.kt:688)");
            }
            TextKt.m2693Text4IGK_g($item.getOwner(), PaddingKt.m671paddingVpY3zN4(Modifier.INSTANCE, Dp.m6622constructorimpl(6), Dp.m6622constructorimpl(2)), $ownerColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 199728, 0, 131024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
