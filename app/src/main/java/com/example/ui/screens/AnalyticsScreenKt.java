package com.example.ui.screens;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.example.data.model.NetWorthSnapshot;
import com.example.ui.components.NetWorthChartKt;
import com.example.ui.viewmodel.NetWorthSummary;
import com.example.ui.viewmodel.NetWorthViewModel;
import com.example.ui.viewmodel.OwnerSummary;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalyticsScreen.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a#\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\u0010\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u008a\u0084\u0002²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\u0010\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\rX\u008a\u0084\u0002"}, d2 = {"AnalyticsScreen", "", "viewModel", "Lcom/example/ui/viewmodel/NetWorthViewModel;", "(Lcom/example/ui/viewmodel/NetWorthViewModel;Landroidx/compose/runtime/Composer;I)V", "SnapshotLogRow", "snapshot", "Lcom/example/data/model/NetWorthSnapshot;", "onDelete", "Lkotlin/Function0;", "(Lcom/example/data/model/NetWorthSnapshot;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app", "snapshots", "", "summary", "Lcom/example/ui/viewmodel/NetWorthSummary;", "ownerSummaries", "Lcom/example/ui/viewmodel/OwnerSummary;"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnalyticsScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AnalyticsScreen$lambda$32(NetWorthViewModel netWorthViewModel, int i, Composer composer, int i2) {
        AnalyticsScreen(netWorthViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SnapshotLogRow$lambda$37(NetWorthSnapshot netWorthSnapshot, Function0 function0, int i, Composer composer, int i2) {
        SnapshotLogRow(netWorthSnapshot, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AnalyticsScreen(final NetWorthViewModel viewModel, Composer $composer, final int $changed) {
        Object obj;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer $composer2 = $composer.startRestartGroup(1014630551);
        ComposerKt.sourceInformation($composer2, "C(AnalyticsScreen)51@2314L29,52@2381L29,53@2462L29,60@2670L8231,55@2497L8404:AnalyticsScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(viewModel) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1014630551, $dirty2, -1, "com.example.ui.screens.AnalyticsScreen (AnalyticsScreen.kt:50)");
            }
            final State snapshots$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.getSnapshots(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            final State summary$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.getSummary(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            final State ownerSummaries$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.getOwnerSummaries(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            Modifier m672paddingVpY3zN4$default = PaddingKt.m672paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6622constructorimpl(16), 0.0f, 2, null);
            Arrangement.HorizontalOrVertical m550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6622constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart($composer2, 102406302, "CC(remember):AnalyticsScreen.kt#9igjgp");
            boolean changedInstance = $composer2.changedInstance(viewModel) | $composer2.changed(snapshots$delegate) | $composer2.changed(summary$delegate) | $composer2.changed(ownerSummaries$delegate);
            Object rememberedValue = $composer2.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function1() { // from class: com.example.ui.screens.AnalyticsScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return AnalyticsScreenKt.AnalyticsScreen$lambda$31$lambda$30(NetWorthViewModel.this, snapshots$delegate, summary$delegate, ownerSummaries$delegate, (LazyListScope) obj2);
                    }
                };
                $composer2.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(m672paddingVpY3zN4$default, null, null, false, m550spacedBy0680j_4, null, null, false, (Function1) obj, $composer2, 24582, 238);
            $composer2 = $composer2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.AnalyticsScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return AnalyticsScreenKt.AnalyticsScreen$lambda$32(NetWorthViewModel.this, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final List<NetWorthSnapshot> AnalyticsScreen$lambda$0(State<? extends List<NetWorthSnapshot>> state) {
        return (List) state.getValue();
    }

    private static final NetWorthSummary AnalyticsScreen$lambda$1(State<NetWorthSummary> state) {
        return (NetWorthSummary) state.getValue();
    }

    private static final List<OwnerSummary> AnalyticsScreen$lambda$2(State<? extends List<OwnerSummary>> state) {
        return (List) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AnalyticsScreen$lambda$31$lambda$30(final NetWorthViewModel $viewModel, final State $snapshots$delegate, final State $summary$delegate, final State $ownerSummaries$delegate, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$AnalyticsScreenKt.INSTANCE.m7021getLambda$25352405$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1170398562, true, new Function3() { // from class: com.example.ui.screens.AnalyticsScreenKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AnalyticsScreenKt.AnalyticsScreen$lambda$31$lambda$30$lambda$7(NetWorthViewModel.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(467802723, true, new Function3() { // from class: com.example.ui.screens.AnalyticsScreenKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AnalyticsScreenKt.AnalyticsScreen$lambda$31$lambda$30$lambda$10(State.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-234793116, true, new Function3() { // from class: com.example.ui.screens.AnalyticsScreenKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AnalyticsScreenKt.AnalyticsScreen$lambda$31$lambda$30$lambda$17(State.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-937388955, true, new Function3() { // from class: com.example.ui.screens.AnalyticsScreenKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AnalyticsScreenKt.AnalyticsScreen$lambda$31$lambda$30$lambda$25(State.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1639984794, true, new Function3() { // from class: com.example.ui.screens.AnalyticsScreenKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AnalyticsScreenKt.AnalyticsScreen$lambda$31$lambda$30$lambda$26(State.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        if (AnalyticsScreen$lambda$0($snapshots$delegate).isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$AnalyticsScreenKt.INSTANCE.m7020getLambda$161309818$app(), 3, null);
        } else {
            final List sortedWith = CollectionsKt.sortedWith(AnalyticsScreen$lambda$0($snapshots$delegate), new Comparator() { // from class: com.example.ui.screens.AnalyticsScreenKt$AnalyticsScreen$lambda$31$lambda$30$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((NetWorthSnapshot) t2).getTimestamp()), Long.valueOf(((NetWorthSnapshot) t).getTimestamp()));
                }
            });
            final Function1 function1 = new Function1() { // from class: com.example.ui.screens.AnalyticsScreenKt$AnalyticsScreen$lambda$31$lambda$30$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke((NetWorthSnapshot) p1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(NetWorthSnapshot netWorthSnapshot) {
                    return null;
                }
            };
            LazyColumn.items(sortedWith.size(), null, new Function1<Integer, Object>() { // from class: com.example.ui.screens.AnalyticsScreenKt$AnalyticsScreen$lambda$31$lambda$30$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int index) {
                    return Function1.this.invoke(sortedWith.get(index));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.screens.AnalyticsScreenKt$AnalyticsScreen$lambda$31$lambda$30$$inlined$items$default$4
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
                    final NetWorthSnapshot netWorthSnapshot = (NetWorthSnapshot) sortedWith.get(it);
                    $composer.startReplaceGroup(-1803893249);
                    ComposerKt.sourceInformation($composer, "C*235@10776L34,235@10733L78:AnalyticsScreen.kt#2thlc2");
                    ComposerKt.sourceInformationMarkerStart($composer, 911642552, "CC(remember):AnalyticsScreen.kt#9igjgp");
                    boolean changedInstance = ((((i & 112) ^ 48) > 32 && $composer.changed(netWorthSnapshot)) || (i & 48) == 32) | $composer.changedInstance($viewModel);
                    Object rememberedValue = $composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        final NetWorthViewModel netWorthViewModel = $viewModel;
                        obj = (Function0) new Function0<Unit>() { // from class: com.example.ui.screens.AnalyticsScreenKt$AnalyticsScreen$1$1$7$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                NetWorthViewModel.this.deleteSnapshot(netWorthSnapshot);
                            }
                        };
                        $composer.updateRememberedValue(obj);
                    } else {
                        obj = rememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    AnalyticsScreenKt.SnapshotLogRow(netWorthSnapshot, (Function0) obj, $composer, (i >> 3) & 14);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$AnalyticsScreenKt.INSTANCE.getLambda$1952386663$app(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AnalyticsScreen$lambda$31$lambda$30$lambda$7(final com.example.ui.viewmodel.NetWorthViewModel r72, androidx.compose.foundation.lazy.LazyItemScope r73, androidx.compose.runtime.Composer r74, int r75) {
        /*
            Method dump skipped, instructions count: 866
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AnalyticsScreenKt.AnalyticsScreen$lambda$31$lambda$30$lambda$7(com.example.ui.viewmodel.NetWorthViewModel, androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AnalyticsScreen$lambda$31$lambda$30$lambda$7$lambda$6$lambda$5$lambda$4(NetWorthViewModel $viewModel) {
        $viewModel.recordSnapshot("Analytics Trigger");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AnalyticsScreen$lambda$31$lambda$30$lambda$10(final State $snapshots$delegate, LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C99@4277L11,99@4235L74,100@4324L449,96@4056L717:AnalyticsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(467802723, $changed, -1, "com.example.ui.screens.AnalyticsScreen.<anonymous>.<anonymous>.<anonymous> (AnalyticsScreen.kt:96)");
            }
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "analytics_chart_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(20)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-1277597483, true, new Function3() { // from class: com.example.ui.screens.AnalyticsScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AnalyticsScreenKt.AnalyticsScreen$lambda$31$lambda$30$lambda$10$lambda$9(State.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AnalyticsScreen$lambda$31$lambda$30$lambda$10$lambda$9(State $snapshots$delegate, ColumnScope Card, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C101@4342L417:AnalyticsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1277597483, $changed, -1, "com.example.ui.screens.AnalyticsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AnalyticsScreen.kt:101)");
            }
            Modifier m670padding3ABfNKs = PaddingKt.m670padding3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier($composer, m670padding3ABfNKs);
            Function0 constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((6 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                $composer.createNode(constructor);
            } else {
                $composer.useNode();
            }
            Composer m3652constructorimpl = Updater.m3652constructorimpl($composer);
            Updater.m3659setimpl(m3652constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3659setimpl(m3652constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3652constructorimpl.getInserting() || !Intrinsics.areEqual(m3652constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3652constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3652constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3659setimpl(m3652constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i3 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 200760330, "C104@4519L10,102@4407L210,107@4638L41,108@4700L41:AnalyticsScreen.kt#2thlc2");
            TextKt.m2693Text4IGK_g("Net Worth Growth Timeline", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 196614, 0, 65502);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(12)), $composer, 6);
            NetWorthChartKt.m7012NetWorthTrendCharteaDK9VM(AnalyticsScreen$lambda$0($snapshots$delegate), null, 0L, 0L, $composer, 0, 14);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AnalyticsScreen$lambda$31$lambda$30$lambda$17(final State $summary$delegate, LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C118@5072L11,118@5030L75,119@5120L2210,115@4852L2478:AnalyticsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-234793116, $changed, -1, "com.example.ui.screens.AnalyticsScreen.<anonymous>.<anonymous>.<anonymous> (AnalyticsScreen.kt:115)");
            }
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "investment_pnl_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(16)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerHigh(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-1980193322, true, new Function3() { // from class: com.example.ui.screens.AnalyticsScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AnalyticsScreenKt.AnalyticsScreen$lambda$31$lambda$30$lambda$17$lambda$16(State.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0648  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x067f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0736  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x07a4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x082a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x07aa  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0739  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0732  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0695 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x064e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x04f8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AnalyticsScreen$lambda$31$lambda$30$lambda$17$lambda$16(androidx.compose.runtime.State r106, androidx.compose.foundation.layout.ColumnScope r107, androidx.compose.runtime.Composer r108, int r109) {
        /*
            Method dump skipped, instructions count: 2096
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AnalyticsScreenKt.AnalyticsScreen$lambda$31$lambda$30$lambda$17$lambda$16(androidx.compose.runtime.State, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01b0 A[LOOP:0: B:24:0x01aa->B:26:0x01b0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x025c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AnalyticsScreen$lambda$31$lambda$30$lambda$25(androidx.compose.runtime.State r44, androidx.compose.foundation.lazy.LazyItemScope r45, androidx.compose.runtime.Composer r46, int r47) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AnalyticsScreenKt.AnalyticsScreen$lambda$31$lambda$30$lambda$25(androidx.compose.runtime.State, androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AnalyticsScreen$lambda$31$lambda$30$lambda$25$lambda$24$lambda$23$lambda$22(final com.example.ui.viewmodel.OwnerSummary r84, long r85, androidx.compose.foundation.layout.ColumnScope r87, androidx.compose.runtime.Composer r88, int r89) {
        /*
            Method dump skipped, instructions count: 1057
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AnalyticsScreenKt.AnalyticsScreen$lambda$31$lambda$30$lambda$25$lambda$24$lambda$23$lambda$22(com.example.ui.viewmodel.OwnerSummary, long, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AnalyticsScreen$lambda$31$lambda$30$lambda$26(State $snapshots$delegate, LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C219@10177L10,217@10065L194,222@10272L40:AnalyticsScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1639984794, $changed, -1, "com.example.ui.screens.AnalyticsScreen.<anonymous>.<anonymous>.<anonymous> (AnalyticsScreen.kt:217)");
            }
            TextKt.m2693Text4IGK_g("Snapshot History Logs (" + AnalyticsScreen$lambda$0($snapshots$delegate).size() + ")", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(8)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void SnapshotLogRow(final NetWorthSnapshot snapshot, final Function0<Unit> onDelete, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Intrinsics.checkNotNullParameter(onDelete, "onDelete");
        Composer $composer2 = $composer.startRestartGroup(-846501239);
        ComposerKt.sourceInformation($composer2, "C(SnapshotLogRow)P(1)248@11137L1737,245@10992L1882:AnalyticsScreen.kt#2thlc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(snapshot) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(onDelete) ? 32 : 16;
        }
        if (($dirty & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-846501239, $dirty, -1, "com.example.ui.screens.SnapshotLogRow (AnalyticsScreen.kt:244)");
            }
            CardKt.OutlinedCard(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "snapshot_log_" + snapshot.getId()), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(12)), null, null, null, ComposableLambdaKt.rememberComposableLambda(-2067590147, true, new Function3() { // from class: com.example.ui.screens.AnalyticsScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AnalyticsScreenKt.SnapshotLogRow$lambda$36(Function0.this, snapshot, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer2, 54), $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.AnalyticsScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AnalyticsScreenKt.SnapshotLogRow$lambda$37(NetWorthSnapshot.this, onDelete, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SnapshotLogRow$lambda$36(kotlin.jvm.functions.Function0 r80, com.example.data.model.NetWorthSnapshot r81, androidx.compose.foundation.layout.ColumnScope r82, androidx.compose.runtime.Composer r83, int r84) {
        /*
            Method dump skipped, instructions count: 1351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AnalyticsScreenKt.SnapshotLogRow$lambda$36(kotlin.jvm.functions.Function0, com.example.data.model.NetWorthSnapshot, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }
}
