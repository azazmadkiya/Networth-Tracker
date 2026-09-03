package com.example.ui.screens;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckCircleKt;
import androidx.compose.material.icons.filled.NotificationsKt;
import androidx.compose.material.icons.filled.RadioButtonUncheckedKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
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
import androidx.core.app.NotificationCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.example.data.model.FinancialItem;
import com.example.data.model.FinancialReminder;
import com.example.data.model.ReminderPriority;
import com.example.ui.viewmodel.NetWorthViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RemindersScreen.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001aM\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\u0010\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014X\u008a\u0084\u0002²\u0006\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\f\u0010\u001c\u001a\u0004\u0018\u00010\tX\u008a\u008e\u0002²\u0006\f\u0010\u001d\u001a\u0004\u0018\u00010\tX\u008a\u008e\u0002"}, d2 = {"RemindersScreen", "", "viewModel", "Lcom/example/ui/viewmodel/NetWorthViewModel;", "onBack", "Lkotlin/Function0;", "(Lcom/example/ui/viewmodel/NetWorthViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ReminderItemCard", NotificationCompat.CATEGORY_REMINDER, "Lcom/example/data/model/FinancialReminder;", "todayEpoch", "", "onToggleCompleted", "Lkotlin/Function1;", "", "onEdit", "onDelete", "(Lcom/example/data/model/FinancialReminder;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app", "allReminders", "", "allItems", "Lcom/example/data/model/FinancialItem;", "filterStatus", "", "filterPriority", "filterType", "showAddDialog", "reminderToEdit", "reminderToDelete"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RemindersScreenKt {

    /* compiled from: RemindersScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReminderPriority.values().length];
            try {
                iArr[ReminderPriority.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ReminderPriority.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ReminderPriority.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReminderItemCard$lambda$112(FinancialReminder financialReminder, long j, Function1 function1, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        ReminderItemCard(financialReminder, j, function1, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$85(NetWorthViewModel netWorthViewModel, Function0 function0, int i, int i2, Composer composer, int i3) {
        RemindersScreen(netWorthViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0432 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0424 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03b5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02c9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void RemindersScreen(final com.example.ui.viewmodel.NetWorthViewModel r52, kotlin.jvm.functions.Function0<kotlin.Unit> r53, androidx.compose.runtime.Composer r54, final int r55, final int r56) {
        /*
            Method dump skipped, instructions count: 1604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.RemindersScreenKt.RemindersScreen(com.example.ui.viewmodel.NetWorthViewModel, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final List<FinancialReminder> RemindersScreen$lambda$0(State<? extends List<FinancialReminder>> state) {
        return (List) state.getValue();
    }

    private static final List<FinancialItem> RemindersScreen$lambda$1(State<? extends List<FinancialItem>> state) {
        return (List) state.getValue();
    }

    private static final String RemindersScreen$lambda$3(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String RemindersScreen$lambda$6(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String RemindersScreen$lambda$9(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean RemindersScreen$lambda$12(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RemindersScreen$lambda$13(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final FinancialReminder RemindersScreen$lambda$15(MutableState<FinancialReminder> mutableState) {
        return mutableState.getValue();
    }

    private static final FinancialReminder RemindersScreen$lambda$18(MutableState<FinancialReminder> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int RemindersScreen$lambda$25$lambda$23(FinancialReminder a, FinancialReminder b) {
        if (a.isCompleted() != b.isCompleted()) {
            return Boolean.compare(a.isCompleted(), b.isCompleted());
        }
        int pA = ReminderPriority.INSTANCE.fromString(a.getPriority()).getLevel();
        int pB = ReminderPriority.INSTANCE.fromString(b.getPriority()).getLevel();
        if (pA != pB) {
            return Intrinsics.compare(pB, pA);
        }
        return Intrinsics.compare(a.getDueDateEpochDay(), b.getDueDateEpochDay());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$31(final Function0 $onBack, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C156@7120L477,167@7642L89,146@6717L1028:RemindersScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(191649479, $changed, -1, "com.example.ui.screens.RemindersScreen.<anonymous> (RemindersScreen.kt:146)");
            }
            AppBarKt.m1774TopAppBarGHTll3U(ComposableSingletons$RemindersScreenKt.INSTANCE.m7072getLambda$1058424957$app(), null, ComposableLambdaKt.rememberComposableLambda(-488153151, true, new Function2() { // from class: com.example.ui.screens.RemindersScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RemindersScreenKt.RemindersScreen$lambda$31$lambda$30(Function0.this, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer, 54), null, 0.0f, null, TopAppBarDefaults.INSTANCE.m2864topAppBarColorszjMxDiM(ColorKt.Color(4279179050L), 0L, 0L, 0L, 0L, $composer, (TopAppBarDefaults.$stable << 15) | 6, 30), null, $composer, 390, 186);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$31$lambda$30(Function0 $onBack, Composer $composer, int $changed) {
        Composer $composer2;
        ComposerKt.sourceInformation($composer, "C:RemindersScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-488153151, $changed, -1, "com.example.ui.screens.RemindersScreen.<anonymous>.<anonymous> (RemindersScreen.kt:157)");
            }
            if ($onBack != null) {
                $composer.startReplaceGroup(188797408);
                ComposerKt.sourceInformation($composer, "158@7188L369");
                $composer2 = $composer;
                IconButtonKt.IconButton($onBack, TestTagKt.testTag(Modifier.INSTANCE, "reminders_back_button"), false, null, null, ComposableSingletons$RemindersScreenKt.INSTANCE.getLambda$683719881$app(), $composer2, 196656, 28);
            } else {
                $composer2 = $composer;
                $composer2.startReplaceGroup(181678785);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$34(final MutableState $reminderToEdit$delegate, final MutableState $showAddDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C178@8009L11,179@8075L11,174@7858L102,173@7802L541:RemindersScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1731608950, $changed, -1, "com.example.ui.screens.RemindersScreen.<anonymous> (RemindersScreen.kt:173)");
            }
            long primary = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary();
            long onPrimary = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnPrimary();
            Modifier testTag = TestTagKt.testTag(Modifier.INSTANCE, "add_reminder_fab");
            Function2<Composer, Integer, Unit> lambda$1187247646$app = ComposableSingletons$RemindersScreenKt.INSTANCE.getLambda$1187247646$app();
            Function2<Composer, Integer, Unit> m7076getLambda$81422433$app = ComposableSingletons$RemindersScreenKt.INSTANCE.m7076getLambda$81422433$app();
            ComposerKt.sourceInformationMarkerStart($composer, -1923855056, "CC(remember):RemindersScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.RemindersScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RemindersScreenKt.RemindersScreen$lambda$34$lambda$33$lambda$32(MutableState.this, $showAddDialog$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            FloatingActionButtonKt.m2123ExtendedFloatingActionButtonElI57k(lambda$1187247646$app, m7076getLambda$81422433$app, (Function0) obj, testTag, false, null, primary, onPrimary, null, null, $composer, 3510, 816);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$34$lambda$33$lambda$32(MutableState $reminderToEdit$delegate, MutableState $showAddDialog$delegate) {
        $reminderToEdit$delegate.setValue(null);
        RemindersScreen$lambda$13($showAddDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit RemindersScreen$lambda$70(final double r33, final int r35, final int r36, final java.util.List r37, final long r38, final com.example.ui.viewmodel.NetWorthViewModel r40, final android.content.Context r41, final androidx.compose.runtime.MutableState r42, final androidx.compose.runtime.MutableState r43, final androidx.compose.runtime.MutableState r44, final androidx.compose.runtime.MutableState r45, final androidx.compose.runtime.MutableState r46, androidx.compose.foundation.layout.PaddingValues r47, androidx.compose.runtime.Composer r48, int r49) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.RemindersScreenKt.RemindersScreen$lambda$70(double, int, int, java.util.List, long, com.example.ui.viewmodel.NetWorthViewModel, android.content.Context, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$70$lambda$69$lambda$68(final List $filteredReminders, final double $totalPendingAmount, final int $dueCountTodayOrOverdue, final int $highPriorityPendingCount, final MutableState $filterStatus$delegate, final MutableState $filterPriority$delegate, final MutableState $reminderToEdit$delegate, final MutableState $showAddDialog$delegate, final long $todayEpoch, final NetWorthViewModel $viewModel, final Context $context, final MutableState $reminderToDelete$delegate, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1666584258, true, new Function3() { // from class: com.example.ui.screens.RemindersScreenKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return RemindersScreenKt.RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$44($totalPendingAmount, $dueCountTodayOrOverdue, $highPriorityPendingCount, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-2130626073, true, new Function3() { // from class: com.example.ui.screens.RemindersScreenKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return RemindersScreenKt.RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$57(MutableState.this, $filterPriority$delegate, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        if ($filteredReminders.isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1845993405, true, new Function3() { // from class: com.example.ui.screens.RemindersScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RemindersScreenKt.RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$62(MutableState.this, $reminderToEdit$delegate, $showAddDialog$delegate, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        } else {
            final Function1 function1 = new Function1() { // from class: com.example.ui.screens.RemindersScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RemindersScreenKt.RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$63((FinancialReminder) obj);
                }
            };
            final Function1 function12 = new Function1() { // from class: com.example.ui.screens.RemindersScreenKt$RemindersScreen$lambda$70$lambda$69$lambda$68$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke((FinancialReminder) p1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(FinancialReminder financialReminder) {
                    return null;
                }
            };
            LazyColumn.items($filteredReminders.size(), new Function1<Integer, Object>() { // from class: com.example.ui.screens.RemindersScreenKt$RemindersScreen$lambda$70$lambda$69$lambda$68$$inlined$items$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int index) {
                    return Function1.this.invoke($filteredReminders.get(index));
                }
            }, new Function1<Integer, Object>() { // from class: com.example.ui.screens.RemindersScreenKt$RemindersScreen$lambda$70$lambda$69$lambda$68$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int index) {
                    return Function1.this.invoke($filteredReminders.get(index));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.screens.RemindersScreenKt$RemindersScreen$lambda$70$lambda$69$lambda$68$$inlined$items$default$4
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
                    Object obj2;
                    Function0 function0;
                    Object obj3;
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
                    final FinancialReminder financialReminder = (FinancialReminder) $filteredReminders.get(it);
                    $composer.startReplaceGroup(-1430420597);
                    ComposerKt.sourceInformation($composer, "C*390@19799L356,395@20190L130,399@20357L83,387@19643L819:RemindersScreen.kt#2thlc2");
                    long j = $todayEpoch;
                    ComposerKt.sourceInformationMarkerStart($composer, -46138071, "CC(remember):RemindersScreen.kt#9igjgp");
                    boolean changedInstance = $composer.changedInstance($viewModel) | ((((i & 112) ^ 48) > 32 && $composer.changed(financialReminder)) || (i & 48) == 32) | $composer.changedInstance($context);
                    Object rememberedValue = $composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        final NetWorthViewModel netWorthViewModel = $viewModel;
                        final Context context = $context;
                        obj = (Function1) new Function1<Boolean, Unit>() { // from class: com.example.ui.screens.RemindersScreenKt$RemindersScreen$3$1$1$5$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean completed) {
                                StringBuilder append;
                                String str;
                                NetWorthViewModel.this.setReminderCompleted(financialReminder.getId(), completed);
                                String title = financialReminder.getTitle();
                                if (completed) {
                                    append = new StringBuilder().append("Marked '").append(title);
                                    str = "' as Paid / Completed ✓";
                                } else {
                                    append = new StringBuilder().append("Marked '").append(title);
                                    str = "' as Pending";
                                }
                                String msg = append.append(str).toString();
                                Toast.makeText(context, msg, 0).show();
                            }
                        };
                        $composer.updateRememberedValue(obj);
                    } else {
                        obj = rememberedValue;
                    }
                    Function1 function13 = (Function1) obj;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, -46125785, "CC(remember):RemindersScreen.kt#9igjgp");
                    boolean z = (((i & 112) ^ 48) > 32 && $composer.changed(financialReminder)) || (i & 48) == 32;
                    Object rememberedValue2 = $composer.rememberedValue();
                    if (z || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        final MutableState mutableState = $reminderToEdit$delegate;
                        final MutableState mutableState2 = $showAddDialog$delegate;
                        obj2 = (Function0) new Function0<Unit>() { // from class: com.example.ui.screens.RemindersScreenKt$RemindersScreen$3$1$1$5$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                mutableState.setValue(FinancialReminder.this);
                                RemindersScreenKt.RemindersScreen$lambda$13(mutableState2, true);
                            }
                        };
                        $composer.updateRememberedValue(obj2);
                    } else {
                        obj2 = rememberedValue2;
                    }
                    Function0 function02 = (Function0) obj2;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, -46120488, "CC(remember):RemindersScreen.kt#9igjgp");
                    boolean z2 = (((i & 112) ^ 48) > 32 && $composer.changed(financialReminder)) || (i & 48) == 32;
                    Object rememberedValue3 = $composer.rememberedValue();
                    if (z2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        function0 = function02;
                        final MutableState mutableState3 = $reminderToDelete$delegate;
                        obj3 = (Function0) new Function0<Unit>() { // from class: com.example.ui.screens.RemindersScreenKt$RemindersScreen$3$1$1$5$3$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                mutableState3.setValue(FinancialReminder.this);
                            }
                        };
                        $composer.updateRememberedValue(obj3);
                    } else {
                        function0 = function02;
                        obj3 = rememberedValue3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    RemindersScreenKt.ReminderItemCard(financialReminder, j, function13, function0, (Function0) obj3, $composer, (i >> 3) & 14);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$44(final double $totalPendingAmount, final int $dueCountTodayOrOverdue, final int $highPriorityPendingCount, LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C199@8991L11,199@8949L74,200@9042L5168,196@8756L5454:RemindersScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1666584258, $changed, -1, "com.example.ui.screens.RemindersScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RemindersScreen.kt:196)");
            }
            CardKt.Card(TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "reminders_summary_card"), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(20)), CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-1204511604, true, new Function3() { // from class: com.example.ui.screens.RemindersScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RemindersScreenKt.RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$44$lambda$43($totalPendingAmount, $dueCountTodayOrOverdue, $highPriorityPendingCount, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x06dc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x062d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x034d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$44$lambda$43(double r108, final int r110, final int r111, androidx.compose.foundation.layout.ColumnScope r112, androidx.compose.runtime.Composer r113, int r114) {
        /*
            Method dump skipped, instructions count: 1762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.RemindersScreenKt.RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$44$lambda$43(double, int, int, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$44$lambda$43$lambda$42$lambda$41$lambda$40$lambda$37(int r52, androidx.compose.runtime.Composer r53, int r54) {
        /*
            Method dump skipped, instructions count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.RemindersScreenKt.RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$44$lambda$43$lambda$42$lambda$41$lambda$40$lambda$37(int, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$44$lambda$43$lambda$42$lambda$41$lambda$40$lambda$39(int r51, androidx.compose.runtime.Composer r52, int r53) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.RemindersScreenKt.RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$44$lambda$43$lambda$42$lambda$41$lambda$40$lambda$39(int, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0378 A[EDGE_INSN: B:47:0x0378->B:48:0x0378 BREAK  A[LOOP:0: B:35:0x02ae->B:43:0x0309], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0472 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$57(final androidx.compose.runtime.MutableState r85, final androidx.compose.runtime.MutableState r86, androidx.compose.foundation.lazy.LazyItemScope r87, androidx.compose.runtime.Composer r88, int r89) {
        /*
            Method dump skipped, instructions count: 1672
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.RemindersScreenKt.RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$57(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$57$lambda$56$lambda$49$lambda$48$lambda$46$lambda$45(String $status, MutableState $filterStatus$delegate) {
        $filterStatus$delegate.setValue($status);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$57$lambda$56$lambda$49$lambda$48$lambda$47(String $status, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C299@14945L12:RemindersScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1296709520, $changed, -1, "com.example.ui.screens.RemindersScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RemindersScreen.kt:299)");
            }
            TextKt.m2693Text4IGK_g($status, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$57$lambda$56$lambda$55$lambda$54$lambda$51$lambda$50(String $priKey, MutableState $filterPriority$delegate) {
        $filterPriority$delegate.setValue($priKey);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$57$lambda$56$lambda$55$lambda$54$lambda$53(androidx.compose.ui.graphics.Color r51, boolean r52, java.lang.String r53, androidx.compose.runtime.Composer r54, int r55) {
        /*
            Method dump skipped, instructions count: 507
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.RemindersScreenKt.RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$57$lambda$56$lambda$55$lambda$54$lambda$53(androidx.compose.ui.graphics.Color, boolean, java.lang.String, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$62(final MutableState $filterStatus$delegate, final MutableState $reminderToEdit$delegate, final MutableState $showAddDialog$delegate, LazyItemScope item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C347@17394L2117,344@17214L2297:RemindersScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1845993405, $changed, -1, "com.example.ui.screens.RemindersScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RemindersScreen.kt:344)");
            }
            CardKt.OutlinedCard(PaddingKt.m672paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6622constructorimpl(24), 1, null), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(16)), null, null, null, ComposableLambdaKt.rememberComposableLambda(1867406671, true, new Function3() { // from class: com.example.ui.screens.RemindersScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RemindersScreenKt.RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$62$lambda$61(MutableState.this, $reminderToEdit$delegate, $showAddDialog$delegate, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196614, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$62$lambda$61(MutableState $filterStatus$delegate, final MutableState $reminderToEdit$delegate, final MutableState $showAddDialog$delegate, ColumnScope OutlinedCard, Composer $composer, int $changed) {
        long m4157copywmQWz5c;
        Intrinsics.checkNotNullParameter(OutlinedCard, "$this$OutlinedCard");
        ComposerKt.sourceInformation($composer, "C348@17420L2069:RemindersScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1867406671, $changed, -1, "com.example.ui.screens.RemindersScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RemindersScreen.kt:348)");
            }
            Modifier m670padding3ABfNKs = PaddingKt.m670padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6622constructorimpl(28));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier($composer, m670padding3ABfNKs);
            Function0 constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((390 << 3) & 112) << 6) & 896) | 6;
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
            int i3 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1619678989, "C356@17900L11,352@17642L326,358@17997L41,362@18317L10,359@18067L302,364@18398L40,367@18640L10,368@18716L11,365@18467L307,370@18803L41,372@18923L150,371@18873L590:RemindersScreen.kt#2thlc2");
            ImageVector notifications = NotificationsKt.getNotifications(Icons.INSTANCE.getDefault());
            Modifier m715size3ABfNKs = SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(48));
            m4157copywmQWz5c = Color.m4157copywmQWz5c(r24, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(r24) : 0.6f, (r12 & 2) != 0 ? Color.m4165getRedimpl(r24) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(r24) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary()) : 0.0f);
            IconKt.m2150Iconww6aTOc(notifications, (String) null, m715size3ABfNKs, m4157copywmQWz5c, $composer, 432, 0);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(12)), $composer, 6);
            TextKt.m2693Text4IGK_g(Intrinsics.areEqual(RemindersScreen$lambda$3($filterStatus$delegate), "Pending") ? "No pending payment reminders" : "No reminders found", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(6)), $composer, 6);
            TextKt.m2693Text4IGK_g("Tap the '+' button below to add your first EMI, SIP, or bill reminder.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 6, 0, 65530);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), $composer, 6);
            ComposerKt.sourceInformationMarkerStart($composer, 883571023, "CC(remember):RemindersScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.example.ui.screens.RemindersScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RemindersScreenKt.RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(MutableState.this, $showAddDialog$delegate);
                    }
                };
                $composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) rememberedValue, TestTagKt.testTag(Modifier.INSTANCE, "empty_add_reminder_btn"), false, null, null, null, null, null, null, ComposableSingletons$RemindersScreenKt.INSTANCE.m7073getLambda$1282352855$app(), $composer, 805306422, 508);
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
    public static final Unit RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(MutableState $reminderToEdit$delegate, MutableState $showAddDialog$delegate) {
        $reminderToEdit$delegate.setValue(null);
        RemindersScreen$lambda$13($showAddDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object RemindersScreen$lambda$70$lambda$69$lambda$68$lambda$63(FinancialReminder it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$73$lambda$72(MutableState $showAddDialog$delegate, MutableState $reminderToEdit$delegate) {
        RemindersScreen$lambda$13($showAddDialog$delegate, false);
        $reminderToEdit$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$75$lambda$74(NetWorthViewModel $viewModel, Context $context, MutableState $showAddDialog$delegate, MutableState $reminderToEdit$delegate, FinancialReminder savedReminder) {
        Intrinsics.checkNotNullParameter(savedReminder, "savedReminder");
        $viewModel.saveReminder(savedReminder);
        RemindersScreen$lambda$13($showAddDialog$delegate, false);
        $reminderToEdit$delegate.setValue(null);
        Toast.makeText($context, "Reminder saved successfully!", 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$77$lambda$76(MutableState $reminderToDelete$delegate) {
        $reminderToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$84(FinancialReminder $rem, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C432@21387L55:RemindersScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2017965096, $changed, -1, "com.example.ui.screens.RemindersScreen.<anonymous> (RemindersScreen.kt:432)");
            }
            TextKt.m2693Text4IGK_g("Are you sure you want to delete '" + $rem.getTitle() + "'?", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$80(final NetWorthViewModel $viewModel, final FinancialReminder $rem, final Context $context, final MutableState $reminderToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C435@21530L220,440@21840L11,440@21796L62,434@21492L439:RemindersScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-380884723, $changed, -1, "com.example.ui.screens.RemindersScreen.<anonymous> (RemindersScreen.kt:434)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -957996631, "CC(remember):RemindersScreen.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($viewModel) | $composer.changed($rem) | $composer.changedInstance($context);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.RemindersScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RemindersScreenKt.RemindersScreen$lambda$80$lambda$79$lambda$78(NetWorthViewModel.this, $rem, $context, $reminderToDelete$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, null, false, null, ButtonDefaults.INSTANCE.m1809buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$RemindersScreenKt.INSTANCE.m7074getLambda$169127139$app(), $composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$80$lambda$79$lambda$78(NetWorthViewModel $viewModel, FinancialReminder $rem, Context $context, MutableState $reminderToDelete$delegate) {
        $viewModel.deleteReminder($rem);
        $reminderToDelete$delegate.setValue(null);
        Toast.makeText($context, "Reminder deleted", 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$83(final MutableState $reminderToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C446@22014L27,446@21993L104:RemindersScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1998325173, $changed, -1, "com.example.ui.screens.RemindersScreen.<anonymous> (RemindersScreen.kt:446)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -540108666, "CC(remember):RemindersScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.RemindersScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RemindersScreenKt.RemindersScreen$lambda$83$lambda$82$lambda$81(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$RemindersScreenKt.INSTANCE.getLambda$744479982$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RemindersScreen$lambda$83$lambda$82$lambda$81(MutableState $reminderToDelete$delegate) {
        $reminderToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x032a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ReminderItemCard(final com.example.data.model.FinancialReminder r42, final long r43, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r45, final kotlin.jvm.functions.Function0<kotlin.Unit> r46, final kotlin.jvm.functions.Function0<kotlin.Unit> r47, androidx.compose.runtime.Composer r48, final int r49) {
        /*
            Method dump skipped, instructions count: 1256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.RemindersScreenKt.ReminderItemCard(com.example.data.model.FinancialReminder, long, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0b8b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0ca9  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0cb5  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0cee  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0dd9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0de5  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0e1e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0f06  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0feb  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0ff7  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x1030  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x114f  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x13d4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x11f4  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x1200  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x1237  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x12a6  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x132a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x1395  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x1313  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x124d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x1206  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x1046 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0ffd  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0f60  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0e34 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0deb  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0d04  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0cbb  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0ba3  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0c02  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0a05  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x076b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0722  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x05ca  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0532 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0402 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02ad A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0710  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x071c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0803  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0a4a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit ReminderItemCard$lambda$111(final com.example.data.model.FinancialReminder r157, final kotlin.jvm.functions.Function1 r158, long r159, final long r161, final java.lang.String r163, com.example.data.model.ReminderType r164, com.example.data.model.ReminderFrequency r165, final long r166, final java.lang.String r168, final java.lang.String r169, kotlin.jvm.functions.Function0 r170, kotlin.jvm.functions.Function0 r171, androidx.compose.foundation.layout.ColumnScope r172, androidx.compose.runtime.Composer r173, int r174) {
        /*
            Method dump skipped, instructions count: 5082
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.RemindersScreenKt.ReminderItemCard$lambda$111(com.example.data.model.FinancialReminder, kotlin.jvm.functions.Function1, long, long, java.lang.String, com.example.data.model.ReminderType, com.example.data.model.ReminderFrequency, long, java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReminderItemCard$lambda$111$lambda$110$lambda$102$lambda$93$lambda$92(Function1 $onToggleCompleted, FinancialReminder $reminder) {
        $onToggleCompleted.invoke(Boolean.valueOf(!$reminder.isCompleted()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReminderItemCard$lambda$111$lambda$110$lambda$102$lambda$94(FinancialReminder $reminder, Composer $composer, int $changed) {
        long onSurfaceVariant;
        ComposerKt.sourceInformation($composer, "C522@25018L382:RemindersScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-138801779, $changed, -1, "com.example.ui.screens.ReminderItemCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RemindersScreen.kt:522)");
            }
            ImageVector checkCircle = $reminder.isCompleted() ? CheckCircleKt.getCheckCircle(Icons.INSTANCE.getDefault()) : RadioButtonUncheckedKt.getRadioButtonUnchecked(Icons.INSTANCE.getDefault());
            String str = $reminder.isCompleted() ? "Completed" : "Mark Done";
            if ($reminder.isCompleted()) {
                $composer.startReplaceGroup(-244513282);
                $composer.endReplaceGroup();
                onSurfaceVariant = ColorKt.Color(4279286145L);
            } else {
                $composer.startReplaceGroup(-244511715);
                ComposerKt.sourceInformation($composer, "525@25350L11");
                onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant();
                $composer.endReplaceGroup();
            }
            IconKt.m2150Iconww6aTOc(checkCircle, str, (Modifier) null, onSurfaceVariant, $composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit ReminderItemCard$lambda$111$lambda$110$lambda$102$lambda$100$lambda$97$lambda$96(long r51, java.lang.String r53, androidx.compose.runtime.Composer r54, int r55) {
        /*
            Method dump skipped, instructions count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.RemindersScreenKt.ReminderItemCard$lambda$111$lambda$110$lambda$102$lambda$100$lambda$97$lambda$96(long, java.lang.String, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0202  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit ReminderItemCard$lambda$111$lambda$110$lambda$108$lambda$106$lambda$104(long r51, java.lang.String r53, java.lang.String r54, androidx.compose.runtime.Composer r55, int r56) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.RemindersScreenKt.ReminderItemCard$lambda$111$lambda$110$lambda$108$lambda$106$lambda$104(long, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReminderItemCard$lambda$111$lambda$110$lambda$108$lambda$106$lambda$105(FinancialReminder $reminder, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C648@31651L11,644@31389L324:RemindersScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-748452927, $changed, -1, "com.example.ui.screens.ReminderItemCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RemindersScreen.kt:644)");
            }
            TextKt.m2693Text4IGK_g($reminder.getOwner(), PaddingKt.m671paddingVpY3zN4(Modifier.INSTANCE, Dp.m6622constructorimpl(6), Dp.m6622constructorimpl(3)), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSecondaryContainer(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3120, 0, 131056);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
