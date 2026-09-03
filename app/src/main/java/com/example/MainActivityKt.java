package com.example;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.NotificationsKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.NavigationBarKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.example.data.model.FinancialItem;
import com.example.ui.components.AddEditItemDialogKt;
import com.example.ui.screens.LoginScreenKt;
import com.example.ui.screens.SplashScreenKt;
import com.example.ui.viewmodel.NetWorthViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\b\u001a\u00020\u0007X\u008a\u0084\u0002²\u0006\u0010\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010\u000e\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\f\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u008a\u008e\u0002"}, d2 = {"MainAppContent", "", "viewModel", "Lcom/example/ui/viewmodel/NetWorthViewModel;", "(Lcom/example/ui/viewmodel/NetWorthViewModel;Landroidx/compose/runtime/Composer;I)V", "app", "showSplash", "", "isLoggedIn", "allItems", "", "Lcom/example/data/model/FinancialItem;", "currentTab", "Lcom/example/NavTab;", "showAddEditDialog", "itemToEdit"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MainActivityKt {

    /* compiled from: MainActivity.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NavTab.values().length];
            try {
                iArr[NavTab.DASHBOARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NavTab.ASSETS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NavTab.LEDGER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[NavTab.ANALYTICS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[NavTab.SETTINGS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[NavTab.REMINDERS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$62(NetWorthViewModel netWorthViewModel, int i, Composer composer, int i2) {
        MainAppContent(netWorthViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void MainAppContent(final NetWorthViewModel viewModel, Composer $composer, final int $changed) {
        Object obj;
        Object obj2;
        int i;
        Object obj3;
        Object obj4;
        final MutableState itemToEdit$delegate;
        final MutableState showAddEditDialog$delegate;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer $composer2 = $composer.startRestartGroup(-277580067);
        ComposerKt.sourceInformation($composer2, "C(MainAppContent)87@3403L33,88@3480L29,89@3549L29,90@3601L45,92@3677L34,93@3734L49:MainActivity.kt#to5c3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(viewModel) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-277580067, $dirty2, -1, "com.example.MainAppContent (MainActivity.kt:86)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -466468002, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue = $composer2.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                $composer2.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            final MutableState showSplash$delegate = (MutableState) obj;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            State isLoggedIn$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.isLoggedIn(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            State allItems$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.getAllItems(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            ComposerKt.sourceInformationMarkerStart($composer2, -466461654, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue2 = $composer2.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                obj2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(NavTab.DASHBOARD, null, 2, null);
                $composer2.updateRememberedValue(obj2);
            } else {
                obj2 = rememberedValue2;
            }
            final MutableState currentTab$delegate = (MutableState) obj2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -466459233, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue3 = $composer2.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                i = 0;
                obj3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(obj3);
            } else {
                i = 0;
                obj3 = rememberedValue3;
            }
            final MutableState showAddEditDialog$delegate2 = (MutableState) obj3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -466457394, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue4 = $composer2.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                obj4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                $composer2.updateRememberedValue(obj4);
            } else {
                obj4 = rememberedValue4;
            }
            final MutableState itemToEdit$delegate2 = (MutableState) obj4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (MainAppContent$lambda$1(showSplash$delegate)) {
                $composer2.startReplaceGroup(-1575204660);
                ComposerKt.sourceInformation($composer2, "97@3860L50,96@3815L105");
                ComposerKt.sourceInformationMarkerStart($composer2, -466453361, "CC(remember):MainActivity.kt#9igjgp");
                Object rememberedValue5 = $composer2.rememberedValue();
                if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    obj8 = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainActivityKt.MainAppContent$lambda$15$lambda$14(MutableState.this);
                        }
                    };
                    $composer2.updateRememberedValue(obj8);
                } else {
                    obj8 = rememberedValue5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                SplashScreenKt.SplashScreen((Function0) obj8, $composer2, 6);
                $composer2.endReplaceGroup();
            } else if (!MainAppContent$lambda$3(isLoggedIn$delegate)) {
                $composer2.startReplaceGroup(-1575060696);
                ComposerKt.sourceInformation($composer2, "103@4001L89,102@3959L141");
                ComposerKt.sourceInformationMarkerStart($composer2, -466448810, "CC(remember):MainActivity.kt#9igjgp");
                boolean changedInstance = $composer2.changedInstance(viewModel);
                Object rememberedValue6 = $composer2.rememberedValue();
                if (changedInstance || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    obj7 = new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj9, Object obj10) {
                            return Boolean.valueOf(MainActivityKt.MainAppContent$lambda$17$lambda$16(NetWorthViewModel.this, (String) obj9, (String) obj10));
                        }
                    };
                    $composer2.updateRememberedValue(obj7);
                } else {
                    obj7 = rememberedValue6;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LoginScreenKt.LoginScreen((Function2) obj7, $composer2, i);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1574604531);
                ComposerKt.sourceInformation($composer2, "108@4149L7,110@4196L2451,163@6673L4002,249@10686L2505,109@4165L9026");
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final Context context = (Context) consume;
                ScaffoldKt.m2408ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(1396314229, true, new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj9, Object obj10) {
                        return MainActivityKt.MainAppContent$lambda$26(NetWorthViewModel.this, context, currentTab$delegate, (Composer) obj9, ((Integer) obj10).intValue());
                    }
                }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(462959892, true, new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj9, Object obj10) {
                        return MainActivityKt.MainAppContent$lambda$38(MutableState.this, (Composer) obj9, ((Integer) obj10).intValue());
                    }
                }, $composer2, 54), null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1085532534, true, new Function3() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj9, Object obj10, Object obj11) {
                        return MainActivityKt.MainAppContent$lambda$56(NetWorthViewModel.this, currentTab$delegate, itemToEdit$delegate2, showAddEditDialog$delegate2, (PaddingValues) obj9, (Composer) obj10, ((Integer) obj11).intValue());
                    }
                }, $composer2, 54), $composer2, 805306800, 505);
                $composer2 = $composer2;
                if (MainAppContent$lambda$9(showAddEditDialog$delegate2)) {
                    $composer2.startReplaceGroup(-1565815411);
                    ComposerKt.sourceInformation($composer2, "323@13437L103,327@13567L171,320@13272L480");
                    FinancialItem MainAppContent$lambda$12 = MainAppContent$lambda$12(itemToEdit$delegate2);
                    Iterable MainAppContent$lambda$4 = MainAppContent$lambda$4(allItems$delegate);
                    Collection arrayList = new ArrayList();
                    for (Object obj9 : MainAppContent$lambda$4) {
                        if (!((FinancialItem) obj9).isLiability()) {
                            arrayList.add(obj9);
                        }
                    }
                    ArrayList arrayList2 = (List) arrayList;
                    ComposerKt.sourceInformationMarkerStart($composer2, -466146844, "CC(remember):MainActivity.kt#9igjgp");
                    Object rememberedValue7 = $composer2.rememberedValue();
                    if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        itemToEdit$delegate = itemToEdit$delegate2;
                        showAddEditDialog$delegate = showAddEditDialog$delegate2;
                        obj5 = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivityKt.MainAppContent$lambda$59$lambda$58(MutableState.this, itemToEdit$delegate);
                            }
                        };
                        $composer2.updateRememberedValue(obj5);
                    } else {
                        itemToEdit$delegate = itemToEdit$delegate2;
                        showAddEditDialog$delegate = showAddEditDialog$delegate2;
                        obj5 = rememberedValue7;
                    }
                    Function0 function0 = (Function0) obj5;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -466142616, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance2 = $composer2.changedInstance(viewModel);
                    Object rememberedValue8 = $composer2.rememberedValue();
                    if (changedInstance2 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        obj6 = new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda23
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj10) {
                                return MainActivityKt.MainAppContent$lambda$61$lambda$60(NetWorthViewModel.this, showAddEditDialog$delegate, itemToEdit$delegate, (FinancialItem) obj10);
                            }
                        };
                        $composer2.updateRememberedValue(obj6);
                    } else {
                        obj6 = rememberedValue8;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    AddEditItemDialogKt.AddEditItemDialog(MainAppContent$lambda$12, arrayList2, function0, (Function1) obj6, $composer2, 384, 0);
                } else {
                    $composer2.startReplaceGroup(-1578983963);
                }
                $composer2.endReplaceGroup();
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj10, Object obj11) {
                    return MainActivityKt.MainAppContent$lambda$62(NetWorthViewModel.this, $changed, (Composer) obj10, ((Integer) obj11).intValue());
                }
            });
        }
    }

    private static final boolean MainAppContent$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MainAppContent$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean MainAppContent$lambda$3(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    private static final List<FinancialItem> MainAppContent$lambda$4(State<? extends List<FinancialItem>> state) {
        return (List) state.getValue();
    }

    private static final NavTab MainAppContent$lambda$6(MutableState<NavTab> mutableState) {
        return mutableState.getValue();
    }

    private static final void MainAppContent$lambda$10(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean MainAppContent$lambda$9(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final FinancialItem MainAppContent$lambda$12(MutableState<FinancialItem> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$15$lambda$14(MutableState $showSplash$delegate) {
        MainAppContent$lambda$2($showSplash$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean MainAppContent$lambda$17$lambda$16(NetWorthViewModel $viewModel, String idInput, String passInput) {
        Intrinsics.checkNotNullParameter(idInput, "idInput");
        Intrinsics.checkNotNullParameter(passInput, "passInput");
        return $viewModel.login(idInput, passInput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$26(final NetWorthViewModel $viewModel, final Context $context, final MutableState $currentTab$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C119@4524L1932,158@6505L110,111@4214L2419:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1396314229, $changed, -1, "com.example.MainAppContent.<anonymous> (MainActivity.kt:111)");
            }
            AppBarKt.m1774TopAppBarGHTll3U(ComposableSingletons$MainActivityKt.INSTANCE.m6935getLambda$1417695175$app(), null, null, ComposableLambdaKt.rememberComposableLambda(1115391460, true, new Function3() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainActivityKt.MainAppContent$lambda$26$lambda$25(NetWorthViewModel.this, $context, $currentTab$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), 0.0f, null, TopAppBarDefaults.INSTANCE.m2864topAppBarColorszjMxDiM(ColorKt.Color(4279179050L), 0L, 0L, 0L, 0L, $composer, (TopAppBarDefaults.$stable << 15) | 6, 30), null, $composer, 3078, 182);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$26$lambda$25(final NetWorthViewModel $viewModel, final Context $context, final MutableState $currentTab$delegate, RowScope TopAppBar, Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        ComposerKt.sourceInformation($composer, "C122@4657L33,124@4802L356,121@4607L551,134@5315L223,133@5265L683,148@6024L22,147@5974L460:MainActivity.kt#to5c3");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1115391460, $changed, -1, "com.example.MainAppContent.<anonymous>.<anonymous> (MainActivity.kt:121)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1850626651, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.MainAppContent$lambda$26$lambda$25$lambda$19$lambda$18(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton((Function0) obj, TestTagKt.testTag(Modifier.INSTANCE, "top_bar_reminders_button"), false, null, null, ComposableLambdaKt.rememberComposableLambda(953823847, true, new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    return MainActivityKt.MainAppContent$lambda$26$lambda$25$lambda$20(MutableState.this, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, $composer, 54), $composer, 196662, 28);
            ComposerKt.sourceInformationMarkerStart($composer, -1850605405, "CC(remember):MainActivity.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($viewModel) | $composer.changedInstance($context);
            Object rememberedValue2 = $composer.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                obj2 = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.MainAppContent$lambda$26$lambda$25$lambda$22$lambda$21(NetWorthViewModel.this, $context);
                    }
                };
                $composer.updateRememberedValue(obj2);
            } else {
                obj2 = rememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton((Function0) obj2, TestTagKt.testTag(Modifier.INSTANCE, "top_bar_refresh_button"), false, null, null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$76745360$app(), $composer, 196656, 28);
            ComposerKt.sourceInformationMarkerStart($composer, -1850582918, "CC(remember):MainActivity.kt#9igjgp");
            boolean changedInstance2 = $composer.changedInstance($viewModel);
            Object rememberedValue3 = $composer.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                obj3 = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.MainAppContent$lambda$26$lambda$25$lambda$24$lambda$23(NetWorthViewModel.this);
                    }
                };
                $composer.updateRememberedValue(obj3);
            } else {
                obj3 = rememberedValue3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton((Function0) obj3, TestTagKt.testTag(Modifier.INSTANCE, "top_bar_lock_button"), false, null, null, ComposableSingletons$MainActivityKt.INSTANCE.m6942getLambda$597321425$app(), $composer, 196656, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$26$lambda$25$lambda$19$lambda$18(MutableState $currentTab$delegate) {
        $currentTab$delegate.setValue(NavTab.REMINDERS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$26$lambda$25$lambda$20(MutableState $currentTab$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C125@4832L300:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(953823847, $changed, -1, "com.example.MainAppContent.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:125)");
            }
            IconKt.m2150Iconww6aTOc(NotificationsKt.getNotifications(Icons.INSTANCE.getDefault()), "Payment Reminders", (Modifier) null, ColorKt.Color(MainAppContent$lambda$6($currentTab$delegate) == NavTab.REMINDERS ? 4294688548L : 4294286859L), $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$26$lambda$25$lambda$22$lambda$21(NetWorthViewModel $viewModel, Context $context) {
        $viewModel.refreshAndRecalculateAll();
        Toast.makeText($context, "🔄 Refreshed & Recalculated Balances", 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$26$lambda$25$lambda$24$lambda$23(NetWorthViewModel $viewModel) {
        $viewModel.logout();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$38(final MutableState $currentTab$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C165@6757L11,167@6878L3783,164@6691L3970:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(462959892, $changed, -1, "com.example.MainAppContent.<anonymous> (MainActivity.kt:164)");
            }
            NavigationBarKt.m2273NavigationBarHsRjFd4(TestTagKt.testTag(Modifier.INSTANCE, "bottom_navigation_bar"), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainer(), 0L, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1813431411, true, new Function3() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainActivityKt.MainAppContent$lambda$38$lambda$37(MutableState.this, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196614, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$38$lambda$37(final MutableState $currentTab$delegate, RowScope NavigationBar, Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Intrinsics.checkNotNullParameter(NavigationBar, "$this$NavigationBar");
        ComposerKt.sourceInformation($composer, "C170@7020L33,168@6900L736,186@7775L30,184@7658L727,202@8524L30,200@8407L724,218@9273L33,216@9153L737,234@10031L32,232@9912L731:MainActivity.kt#to5c3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(NavigationBar) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1813431411, $dirty2, -1, "com.example.MainAppContent.<anonymous>.<anonymous> (MainActivity.kt:168)");
            }
            boolean z = MainAppContent$lambda$6($currentTab$delegate) == NavTab.DASHBOARD;
            Modifier testTag = TestTagKt.testTag(Modifier.INSTANCE, "nav_tab_dashboard");
            ComposerKt.sourceInformationMarkerStart($composer, 1049140782, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.MainAppContent$lambda$38$lambda$37$lambda$28$lambda$27(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            NavigationBarKt.NavigationBarItem(NavigationBar, z, (Function0) obj, ComposableSingletons$MainActivityKt.INSTANCE.m6941getLambda$2059793272$app(), testTag, false, ComposableSingletons$MainActivityKt.INSTANCE.m6940getLambda$1883054453$app(), false, null, null, $composer, ($dirty2 & 14) | 1600896, 464);
            boolean z2 = MainAppContent$lambda$6($currentTab$delegate) == NavTab.ASSETS;
            Modifier testTag2 = TestTagKt.testTag(Modifier.INSTANCE, "nav_tab_assets");
            ComposerKt.sourceInformationMarkerStart($composer, 1049164939, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue2 = $composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                obj2 = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.MainAppContent$lambda$38$lambda$37$lambda$30$lambda$29(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj2);
            } else {
                obj2 = rememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            NavigationBarKt.NavigationBarItem(NavigationBar, z2, (Function0) obj2, ComposableSingletons$MainActivityKt.INSTANCE.m6937getLambda$1493628367$app(), testTag2, false, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$848652148$app(), false, null, null, $composer, ($dirty2 & 14) | 1600896, 464);
            boolean z3 = MainAppContent$lambda$6($currentTab$delegate) == NavTab.LEDGER;
            Modifier testTag3 = TestTagKt.testTag(Modifier.INSTANCE, "nav_tab_ledger");
            ComposerKt.sourceInformationMarkerStart($composer, 1049188907, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue3 = $composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                obj3 = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.MainAppContent$lambda$38$lambda$37$lambda$32$lambda$31(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj3);
            } else {
                obj3 = rememberedValue3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            NavigationBarKt.NavigationBarItem(NavigationBar, z3, (Function0) obj3, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$529871184$app(), testTag3, false, ComposableSingletons$MainActivityKt.INSTANCE.m6936getLambda$1422815597$app(), false, null, null, $composer, ($dirty2 & 14) | 1600896, 464);
            boolean z4 = MainAppContent$lambda$6($currentTab$delegate) == NavTab.ANALYTICS;
            Modifier testTag4 = TestTagKt.testTag(Modifier.INSTANCE, "nav_tab_analytics");
            ComposerKt.sourceInformationMarkerStart($composer, 1049212878, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue4 = $composer.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                obj4 = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.MainAppContent$lambda$38$lambda$37$lambda$34$lambda$33(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj4);
            } else {
                obj4 = rememberedValue4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            NavigationBarKt.NavigationBarItem(NavigationBar, z4, (Function0) obj4, ComposableSingletons$MainActivityKt.INSTANCE.m6939getLambda$1741596561$app(), testTag4, false, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$600683954$app(), false, null, null, $composer, ($dirty2 & 14) | 1600896, 464);
            boolean z5 = MainAppContent$lambda$6($currentTab$delegate) == NavTab.SETTINGS;
            Modifier testTag5 = TestTagKt.testTag(Modifier.INSTANCE, "nav_tab_settings");
            ComposerKt.sourceInformationMarkerStart($composer, 1049237133, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue5 = $composer.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                obj5 = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.MainAppContent$lambda$38$lambda$37$lambda$36$lambda$35(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj5);
            } else {
                obj5 = rememberedValue5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            NavigationBarKt.NavigationBarItem(NavigationBar, z5, (Function0) obj5, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$281902990$app(), testTag5, false, ComposableSingletons$MainActivityKt.INSTANCE.m6938getLambda$1670783791$app(), false, null, null, $composer, ($dirty2 & 14) | 1600896, 464);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$38$lambda$37$lambda$28$lambda$27(MutableState $currentTab$delegate) {
        $currentTab$delegate.setValue(NavTab.DASHBOARD);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$38$lambda$37$lambda$30$lambda$29(MutableState $currentTab$delegate) {
        $currentTab$delegate.setValue(NavTab.ASSETS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$38$lambda$37$lambda$32$lambda$31(MutableState $currentTab$delegate) {
        $currentTab$delegate.setValue(NavTab.LEDGER);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$38$lambda$37$lambda$34$lambda$33(MutableState $currentTab$delegate) {
        $currentTab$delegate.setValue(NavTab.ANALYTICS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$38$lambda$37$lambda$36$lambda$35(MutableState $currentTab$delegate) {
        $currentTab$delegate.setValue(NavTab.SETTINGS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit MainAppContent$lambda$56(com.example.ui.viewmodel.NetWorthViewModel r38, final androidx.compose.runtime.MutableState r39, final androidx.compose.runtime.MutableState r40, final androidx.compose.runtime.MutableState r41, androidx.compose.foundation.layout.PaddingValues r42, androidx.compose.runtime.Composer r43, int r44) {
        /*
            Method dump skipped, instructions count: 1012
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt.MainAppContent$lambda$56(com.example.ui.viewmodel.NetWorthViewModel, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$56$lambda$55$lambda$40$lambda$39(MutableState $itemToEdit$delegate, MutableState $showAddEditDialog$delegate) {
        $itemToEdit$delegate.setValue(null);
        MainAppContent$lambda$10($showAddEditDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$56$lambda$55$lambda$42$lambda$41(MutableState $currentTab$delegate) {
        $currentTab$delegate.setValue(NavTab.ASSETS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$56$lambda$55$lambda$44$lambda$43(MutableState $itemToEdit$delegate, MutableState $showAddEditDialog$delegate, FinancialItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        $itemToEdit$delegate.setValue(item);
        MainAppContent$lambda$10($showAddEditDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$56$lambda$55$lambda$46$lambda$45(MutableState $currentTab$delegate) {
        $currentTab$delegate.setValue(NavTab.REMINDERS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$56$lambda$55$lambda$48$lambda$47(MutableState $itemToEdit$delegate, MutableState $showAddEditDialog$delegate) {
        $itemToEdit$delegate.setValue(null);
        MainAppContent$lambda$10($showAddEditDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$56$lambda$55$lambda$50$lambda$49(MutableState $itemToEdit$delegate, MutableState $showAddEditDialog$delegate, FinancialItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        $itemToEdit$delegate.setValue(item);
        MainAppContent$lambda$10($showAddEditDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$56$lambda$55$lambda$52$lambda$51(MutableState $itemToEdit$delegate, MutableState $showAddEditDialog$delegate) {
        $itemToEdit$delegate.setValue(null);
        MainAppContent$lambda$10($showAddEditDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$56$lambda$55$lambda$54$lambda$53(MutableState $currentTab$delegate) {
        $currentTab$delegate.setValue(NavTab.DASHBOARD);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$59$lambda$58(MutableState $showAddEditDialog$delegate, MutableState $itemToEdit$delegate) {
        MainAppContent$lambda$10($showAddEditDialog$delegate, false);
        $itemToEdit$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainAppContent$lambda$61$lambda$60(NetWorthViewModel $viewModel, MutableState $showAddEditDialog$delegate, MutableState $itemToEdit$delegate, FinancialItem newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        $viewModel.saveFinancialItem(newItem);
        MainAppContent$lambda$10($showAddEditDialog$delegate, false);
        $itemToEdit$delegate.setValue(null);
        return Unit.INSTANCE;
    }
}
