package com.example.ui.screens;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
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
import androidx.compose.ui.unit.TextUnitKt;
import com.example.data.model.FinancialItem;
import com.example.data.model.ItemCategory;
import com.example.ui.viewmodel.NetWorthViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: AssetsListScreen.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\t\u001aA\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\u0010\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\f\u0010\u0017\u001a\u0004\u0018\u00010\bX\u008a\u008e\u0002²\u0006\f\u0010\u0018\u001a\u0004\u0018\u00010\bX\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001aX\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001aX\u008a\u008e\u0002²\u0006\n\u0010\u001d\u001a\u00020\u001aX\u008a\u008e\u0002²\u0006\n\u0010\u001e\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\f\u0010 \u001a\u0004\u0018\u00010\u0014X\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\u001aX\u008a\u008e\u0002"}, d2 = {"AssetsListScreen", "", "viewModel", "Lcom/example/ui/viewmodel/NetWorthViewModel;", "onAddNewItem", "Lkotlin/Function0;", "onEditItem", "Lkotlin/Function1;", "Lcom/example/data/model/FinancialItem;", "(Lcom/example/ui/viewmodel/NetWorthViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "FinancialItemCard", "item", "onEdit", "onAdjust", "onDelete", "(Lcom/example/data/model/FinancialItem;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app", "items", "", "searchQuery", "", "selectedOwner", "selectedCategory", "itemToDelete", "itemToAdjust", "showQuickModifyDialog", "", "showQuickDeleteDialog", "showQuickAdjustDialog", "adjustLinkedAccountOnDelete", "adjustedAmountStr", "adjustmentReason", "inputError", "showMenu"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AssetsListScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$150(NetWorthViewModel netWorthViewModel, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        AssetsListScreen(netWorthViewModel, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialItemCard$lambda$182(FinancialItem financialItem, Function0 function0, Function0 function02, Function0 function03, int i, int i2, Composer composer, int i3) {
        FinancialItemCard(financialItem, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x073d A[LOOP:2: B:116:0x0737->B:118:0x073d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x076c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x07a3 A[LOOP:4: B:132:0x079d->B:134:0x07a3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x07cd  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0812  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0815 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0838 A[LOOP:6: B:155:0x0832->B:157:0x0838, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x08fa  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0bfc  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0ceb  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0ea7  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0f60  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x1012  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x10b6  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0d00  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0c10  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0a9c  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x045d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x05bc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0646 A[LOOP:0: B:96:0x0640->B:98:0x0646, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AssetsListScreen(final com.example.ui.viewmodel.NetWorthViewModel r140, final kotlin.jvm.functions.Function0<kotlin.Unit> r141, final kotlin.jvm.functions.Function1<? super com.example.data.model.FinancialItem, kotlin.Unit> r142, androidx.compose.runtime.Composer r143, final int r144) {
        /*
            Method dump skipped, instructions count: 4309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AssetsListScreenKt.AssetsListScreen(com.example.ui.viewmodel.NetWorthViewModel, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    private static final List<FinancialItem> AssetsListScreen$lambda$0(State<? extends List<FinancialItem>> state) {
        return (List) state.getValue();
    }

    private static final String AssetsListScreen$lambda$1(State<String> state) {
        return (String) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AssetsListScreen$lambda$2(State<String> state) {
        return (String) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AssetsListScreen$lambda$3(State<String> state) {
        return (String) state.getValue();
    }

    private static final FinancialItem AssetsListScreen$lambda$5(MutableState<FinancialItem> mutableState) {
        return mutableState.getValue();
    }

    private static final FinancialItem AssetsListScreen$lambda$8(MutableState<FinancialItem> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean AssetsListScreen$lambda$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AssetsListScreen$lambda$12(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean AssetsListScreen$lambda$14(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AssetsListScreen$lambda$15(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean AssetsListScreen$lambda$17(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AssetsListScreen$lambda$18(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean AssetsListScreen$lambda$20(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AssetsListScreen$lambda$21(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$67$lambda$66$lambda$23$lambda$22(NetWorthViewModel $viewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $viewModel.getSearchQuery().setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$67$lambda$66$lambda$26(final NetWorthViewModel $viewModel, State $searchQuery$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-954037029, $changed, -1, "com.example.ui.screens.AssetsListScreen.<anonymous>.<anonymous>.<anonymous> (AssetsListScreen.kt:119)");
            }
            if (AssetsListScreen$lambda$1($searchQuery$delegate).length() > 0) {
                $composer.startReplaceGroup(-1918470592);
                ComposerKt.sourceInformation($composer, "121@5654L36,120@5604L311");
                ComposerKt.sourceInformationMarkerStart($composer, -2001546689, "CC(remember):AssetsListScreen.kt#9igjgp");
                boolean changedInstance = $composer.changedInstance($viewModel);
                Object rememberedValue = $composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    obj = new Function0() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda61
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AssetsListScreenKt.AssetsListScreen$lambda$67$lambda$66$lambda$26$lambda$25$lambda$24(NetWorthViewModel.this);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                IconButtonKt.IconButton((Function0) obj, TestTagKt.testTag(Modifier.INSTANCE, "clear_search_button"), false, null, null, ComposableSingletons$AssetsListScreenKt.INSTANCE.m7034getLambda$773562909$app(), $composer, 196656, 28);
            } else {
                $composer.startReplaceGroup(-1924016089);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$67$lambda$66$lambda$26$lambda$25$lambda$24(NetWorthViewModel $viewModel) {
        $viewModel.getSearchQuery().setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$67$lambda$66$lambda$31$lambda$30(final NetWorthViewModel $viewModel, final State $selectedCategory$delegate, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        List listOf = CollectionsKt.listOf("All");
        Iterable entries = ItemCategory.getEntries();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
        Iterator it = entries.iterator();
        while (it.hasNext()) {
            arrayList.add(((ItemCategory) it.next()).getDisplayName());
        }
        final List categories = CollectionsKt.plus((Collection) listOf, arrayList);
        final Function1 function1 = new Function1() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$67$lambda$66$lambda$31$lambda$30$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke((String) p1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(String str) {
                return null;
            }
        };
        LazyRow.items(categories.size(), null, new Function1<Integer, Object>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$67$lambda$66$lambda$31$lambda$30$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke(categories.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$67$lambda$66$lambda$31$lambda$30$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it2, Composer $composer, int $changed) {
                String AssetsListScreen$lambda$3;
                Object obj;
                ComposerKt.sourceInformation($composer, "C152@7074L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it2) ? 32 : 16;
                }
                if (($dirty & 147) == 146 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                int i = $dirty & 14;
                final String str = (String) categories.get(it2);
                $composer.startReplaceGroup(-1503602406);
                ComposerKt.sourceInformation($composer, "C*143@6582L48,144@6664L13,141@6476L298:AssetsListScreen.kt#2thlc2");
                AssetsListScreen$lambda$3 = AssetsListScreenKt.AssetsListScreen$lambda$3($selectedCategory$delegate);
                boolean areEqual = Intrinsics.areEqual(AssetsListScreen$lambda$3, str);
                ComposerKt.sourceInformationMarkerStart($composer, 505689167, "CC(remember):AssetsListScreen.kt#9igjgp");
                boolean changedInstance = ((((i & 112) ^ 48) > 32 && $composer.changed(str)) || (i & 48) == 32) | $composer.changedInstance($viewModel);
                Object rememberedValue = $composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final NetWorthViewModel netWorthViewModel = $viewModel;
                    obj = (Function0) new Function0<Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$1$1$3$1$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            NetWorthViewModel.this.getSelectedCategoryFilter().setValue(str);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ChipKt.FilterChip(areEqual, (Function0) obj, ComposableLambdaKt.rememberComposableLambda(-397319054, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$1$1$3$1$1$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C144@6666L9:AssetsListScreen.kt#2thlc2");
                        if (($changed2 & 3) != 2 || !$composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-397319054, $changed2, -1, "com.example.ui.screens.AssetsListScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AssetsListScreen.kt:144)");
                            }
                            TextKt.m2693Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer2.skipToGroupEnd();
                    }
                }, $composer, 54), TestTagKt.testTag(Modifier.INSTANCE, "category_chip_" + str), false, null, null, null, null, null, null, null, $composer, 384, 0, 4080);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$67$lambda$66$lambda$37$lambda$36(final List $owners, final NetWorthViewModel $viewModel, final State $selectedOwner$delegate, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        final Function1 function1 = new Function1() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$67$lambda$66$lambda$37$lambda$36$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke((String) p1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(String str) {
                return null;
            }
        };
        LazyRow.items($owners.size(), null, new Function1<Integer, Object>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$67$lambda$66$lambda$37$lambda$36$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke($owners.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$67$lambda$66$lambda$37$lambda$36$$inlined$items$default$4
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
                String AssetsListScreen$lambda$2;
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
                final String str = (String) $owners.get(it);
                $composer.startReplaceGroup(1761302843);
                ComposerKt.sourceInformation($composer, "C*164@7669L45,165@7748L23,162@7566L306:AssetsListScreen.kt#2thlc2");
                AssetsListScreen$lambda$2 = AssetsListScreenKt.AssetsListScreen$lambda$2($selectedOwner$delegate);
                boolean areEqual = Intrinsics.areEqual(AssetsListScreen$lambda$2, str);
                ComposerKt.sourceInformationMarkerStart($composer, -635917405, "CC(remember):AssetsListScreen.kt#9igjgp");
                boolean changedInstance = ((((i & 112) ^ 48) > 32 && $composer.changed(str)) || (i & 48) == 32) | $composer.changedInstance($viewModel);
                Object rememberedValue = $composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final NetWorthViewModel netWorthViewModel = $viewModel;
                    obj = (Function0) new Function0<Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$1$1$4$1$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MutableStateFlow<String> selectedOwnerFilter = NetWorthViewModel.this.getSelectedOwnerFilter();
                            String str2 = str;
                            Intrinsics.checkNotNull(str2);
                            selectedOwnerFilter.setValue(str2);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ChipKt.FilterChip(areEqual, (Function0) obj, ComposableLambdaKt.rememberComposableLambda(766823721, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$1$1$4$1$1$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C165@7750L19:AssetsListScreen.kt#2thlc2");
                        if (($changed2 & 3) != 2 || !$composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(766823721, $changed2, -1, "com.example.ui.screens.AssetsListScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AssetsListScreen.kt:165)");
                            }
                            TextKt.m2693Text4IGK_g("Owner: " + str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer2.skipToGroupEnd();
                    }
                }, $composer, 54), TestTagKt.testTag(Modifier.INSTANCE, "assets_owner_chip_" + str), false, null, null, null, null, null, null, null, $composer, 384, 0, 4080);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0612 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x073d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0749  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0780  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x083e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0a4d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0aea  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0a5b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0a22  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0796 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x074f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AssetsListScreen$lambda$67$lambda$66$lambda$57(double r112, double r114, double r116, androidx.compose.runtime.State r118, androidx.compose.runtime.State r119, kotlin.jvm.functions.Function0 r120, final com.example.ui.viewmodel.NetWorthViewModel r121, final android.content.Context r122, final androidx.compose.runtime.MutableState r123, final androidx.compose.runtime.MutableState r124, final androidx.compose.runtime.MutableState r125, androidx.compose.runtime.Composer r126, int r127) {
        /*
            Method dump skipped, instructions count: 2800
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AssetsListScreenKt.AssetsListScreen$lambda$67$lambda$66$lambda$57(double, double, double, androidx.compose.runtime.State, androidx.compose.runtime.State, kotlin.jvm.functions.Function0, com.example.ui.viewmodel.NetWorthViewModel, android.content.Context, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$67$lambda$66$lambda$57$lambda$56$lambda$55$lambda$54$lambda$47$lambda$46(MutableState $showQuickAdjustDialog$delegate) {
        AssetsListScreen$lambda$18($showQuickAdjustDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$67$lambda$66$lambda$57$lambda$56$lambda$55$lambda$54$lambda$49$lambda$48(MutableState $showQuickModifyDialog$delegate) {
        AssetsListScreen$lambda$12($showQuickModifyDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$67$lambda$66$lambda$57$lambda$56$lambda$55$lambda$54$lambda$51$lambda$50(MutableState $showQuickDeleteDialog$delegate) {
        AssetsListScreen$lambda$15($showQuickDeleteDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$67$lambda$66$lambda$57$lambda$56$lambda$55$lambda$54$lambda$53$lambda$52(NetWorthViewModel $viewModel, Context $context) {
        $viewModel.refreshAndRecalculateAll();
        Toast.makeText($context, "🔄 Refreshed & Recalculated Balances", 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$67$lambda$66$lambda$65$lambda$64(State $items$delegate, final Function1 $onEditItem, final MutableState $itemToAdjust$delegate, final MutableState $adjustLinkedAccountOnDelete$delegate, final MutableState $itemToDelete$delegate, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List AssetsListScreen$lambda$0 = AssetsListScreen$lambda$0($items$delegate);
        final Function1 function1 = new Function1() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AssetsListScreenKt.AssetsListScreen$lambda$67$lambda$66$lambda$65$lambda$64$lambda$59((FinancialItem) obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$67$lambda$66$lambda$65$lambda$64$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke((FinancialItem) p1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(FinancialItem financialItem) {
                return null;
            }
        };
        LazyColumn.items(AssetsListScreen$lambda$0.size(), new Function1<Integer, Object>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$67$lambda$66$lambda$65$lambda$64$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke(AssetsListScreen$lambda$0.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$67$lambda$66$lambda$65$lambda$64$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke(AssetsListScreen$lambda$0.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$67$lambda$66$lambda$65$lambda$64$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:56:0x0172  */
            /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(androidx.compose.foundation.lazy.LazyItemScope r21, int r22, androidx.compose.runtime.Composer r23, int r24) {
                /*
                    Method dump skipped, instructions count: 374
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$67$lambda$66$lambda$65$lambda$64$$inlined$items$default$4.invoke(androidx.compose.foundation.lazy.LazyItemScope, int, androidx.compose.runtime.Composer, int):void");
            }
        }));
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$AssetsListScreenKt.INSTANCE.m7022getLambda$1021999076$app(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object AssetsListScreen$lambda$67$lambda$66$lambda$65$lambda$64$lambda$59(FinancialItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$85$lambda$69$lambda$68(MutableState $itemToDelete$delegate) {
        $itemToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x044f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AssetsListScreen$lambda$85$lambda$84(final com.example.data.model.FinancialItem r83, boolean r84, final boolean r85, final androidx.compose.runtime.MutableState r86, androidx.compose.runtime.Composer r87, int r88) {
        /*
            Method dump skipped, instructions count: 1151
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AssetsListScreenKt.AssetsListScreen$lambda$85$lambda$84(com.example.data.model.FinancialItem, boolean, boolean, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AssetsListScreen$lambda$85$lambda$84$lambda$83$lambda$77(boolean r51, com.example.data.model.FinancialItem r52, androidx.compose.runtime.Composer r53, int r54) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AssetsListScreenKt.AssetsListScreen$lambda$85$lambda$84$lambda$83$lambda$77(boolean, com.example.data.model.FinancialItem, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$85$lambda$84$lambda$83$lambda$79$lambda$78(MutableState $adjustLinkedAccountOnDelete$delegate) {
        AssetsListScreen$lambda$21($adjustLinkedAccountOnDelete$delegate, !AssetsListScreen$lambda$20($adjustLinkedAccountOnDelete$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$85$lambda$84$lambda$83$lambda$82$lambda$81$lambda$80(MutableState $adjustLinkedAccountOnDelete$delegate, boolean it) {
        AssetsListScreen$lambda$21($adjustLinkedAccountOnDelete$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$85$lambda$72(final NetWorthViewModel $viewModel, final FinancialItem $item, final MutableState $adjustLinkedAccountOnDelete$delegate, final MutableState $itemToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C436@21898L178,435@21856L444:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1494469193, $changed, -1, "com.example.ui.screens.AssetsListScreen.<anonymous>.<anonymous> (AssetsListScreen.kt:435)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1665815511, "CC(remember):AssetsListScreen.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($viewModel) | $composer.changed($item);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda62
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AssetsListScreenKt.AssetsListScreen$lambda$85$lambda$72$lambda$71$lambda$70(NetWorthViewModel.this, $item, $adjustLinkedAccountOnDelete$delegate, $itemToDelete$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, TestTagKt.testTag(Modifier.INSTANCE, "confirm_delete_button"), false, null, null, null, null, null, null, ComposableSingletons$AssetsListScreenKt.INSTANCE.getLambda$2021542362$app(), $composer, 805306416, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$85$lambda$72$lambda$71$lambda$70(NetWorthViewModel $viewModel, FinancialItem $item, MutableState $adjustLinkedAccountOnDelete$delegate, MutableState $itemToDelete$delegate) {
        $viewModel.deleteFinancialItem($item, AssetsListScreen$lambda$20($adjustLinkedAccountOnDelete$delegate));
        $itemToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$85$lambda$75(final MutableState $itemToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C447@22404L23,446@22362L241:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1568053771, $changed, -1, "com.example.ui.screens.AssetsListScreen.<anonymous>.<anonymous> (AssetsListScreen.kt:446)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 633848908, "CC(remember):AssetsListScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AssetsListScreenKt.AssetsListScreen$lambda$85$lambda$75$lambda$74$lambda$73(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, TestTagKt.testTag(Modifier.INSTANCE, "cancel_delete_button"), false, null, null, null, null, null, null, ComposableSingletons$AssetsListScreenKt.INSTANCE.getLambda$1947957784$app(), $composer, 805306422, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$85$lambda$75$lambda$74$lambda$73(MutableState $itemToDelete$delegate) {
        $itemToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    private static final String AssetsListScreen$lambda$116$lambda$87(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String AssetsListScreen$lambda$116$lambda$90(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String AssetsListScreen$lambda$116$lambda$93(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$116$lambda$96$lambda$95(MutableState $itemToAdjust$delegate) {
        $itemToAdjust$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AssetsListScreen$lambda$116$lambda$115(boolean r59, final double r60, final com.example.data.model.FinancialItem r62, androidx.compose.runtime.MutableState r63, final androidx.compose.runtime.MutableState r64, final androidx.compose.runtime.MutableState r65, androidx.compose.runtime.Composer r66, int r67) {
        /*
            Method dump skipped, instructions count: 1010
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AssetsListScreenKt.AssetsListScreen$lambda$116$lambda$115(boolean, double, com.example.data.model.FinancialItem, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x022c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AssetsListScreen$lambda$116$lambda$115$lambda$114$lambda$105(com.example.data.model.FinancialItem r52, androidx.compose.runtime.Composer r53, int r54) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AssetsListScreenKt.AssetsListScreen$lambda$116$lambda$115$lambda$114$lambda$105(com.example.data.model.FinancialItem, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$116$lambda$115$lambda$114$lambda$109$lambda$108(MutableState $adjustedAmountStr$delegate, MutableState $inputError$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $adjustedAmountStr$delegate.setValue(it);
        $inputError$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$116$lambda$115$lambda$114$lambda$107$lambda$106(String $it, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C512@25702L11,512@25671L49:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(739931512, $changed, -1, "com.example.ui.screens.AssetsListScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AssetsListScreen.kt:512)");
            }
            TextKt.m2693Text4IGK_g($it, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AssetsListScreen$lambda$116$lambda$115$lambda$114$lambda$111(double r51, com.example.data.model.FinancialItem r53, androidx.compose.runtime.Composer r54, int r55) {
        /*
            Method dump skipped, instructions count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AssetsListScreenKt.AssetsListScreen$lambda$116$lambda$115$lambda$114$lambda$111(double, com.example.data.model.FinancialItem, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$116$lambda$115$lambda$114$lambda$113$lambda$112(MutableState $adjustmentReason$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $adjustmentReason$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$116$lambda$100(final NetWorthViewModel $viewModel, final FinancialItem $item, final MutableState $adjustedAmountStr$delegate, final MutableState $inputError$delegate, final MutableState $adjustmentReason$delegate, final MutableState $itemToAdjust$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C555@27968L471,554@27930L700:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(63539182, $changed, -1, "com.example.ui.screens.AssetsListScreen.<anonymous>.<anonymous> (AssetsListScreen.kt:554)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 931614021, "CC(remember):AssetsListScreen.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($viewModel) | $composer.changed($item);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda37
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AssetsListScreenKt.AssetsListScreen$lambda$116$lambda$100$lambda$99$lambda$98(NetWorthViewModel.this, $item, $adjustedAmountStr$delegate, $inputError$delegate, $adjustmentReason$delegate, $itemToAdjust$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, TestTagKt.testTag(Modifier.INSTANCE, "save_adjusted_amount_button"), false, null, null, null, null, null, null, ComposableSingletons$AssetsListScreenKt.INSTANCE.m7025getLambda$120359426$app(), $composer, 805306416, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$116$lambda$100$lambda$99$lambda$98(NetWorthViewModel $viewModel, FinancialItem $item, MutableState $adjustedAmountStr$delegate, MutableState $inputError$delegate, MutableState $adjustmentReason$delegate, MutableState $itemToAdjust$delegate) {
        Double parsed = StringsKt.toDoubleOrNull(AssetsListScreen$lambda$116$lambda$87($adjustedAmountStr$delegate));
        if (parsed != null && parsed.doubleValue() >= 0.0d) {
            double doubleValue = parsed.doubleValue();
            String AssetsListScreen$lambda$116$lambda$90 = AssetsListScreen$lambda$116$lambda$90($adjustmentReason$delegate);
            if (StringsKt.isBlank(AssetsListScreen$lambda$116$lambda$90)) {
                AssetsListScreen$lambda$116$lambda$90 = "Balance Adjustment";
            }
            $viewModel.adjustAccountBalance($item, doubleValue, AssetsListScreen$lambda$116$lambda$90);
            $itemToAdjust$delegate.setValue(null);
            return Unit.INSTANCE;
        }
        $inputError$delegate.setValue("Please enter a valid non-negative amount");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$116$lambda$103(final MutableState $itemToAdjust$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C570@28713L23,570@28692L100:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1931763540, $changed, -1, "com.example.ui.screens.AssetsListScreen.<anonymous>.<anonymous> (AssetsListScreen.kt:570)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -998888797, "CC(remember):AssetsListScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda53
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AssetsListScreenKt.AssetsListScreen$lambda$116$lambda$103$lambda$102$lambda$101(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$AssetsListScreenKt.INSTANCE.getLambda$1111046159$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$116$lambda$103$lambda$102$lambda$101(MutableState $itemToAdjust$delegate) {
        $itemToAdjust$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$118$lambda$117(MutableState $showQuickAdjustDialog$delegate) {
        AssetsListScreen$lambda$18($showQuickAdjustDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$127(final State $items$delegate, final MutableState $showQuickAdjustDialog$delegate, final MutableState $itemToAdjust$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C594@29668L1686,589@29448L1906:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1953913110, $changed, -1, "com.example.ui.screens.AssetsListScreen.<anonymous> (AssetsListScreen.kt:589)");
            }
            Arrangement.HorizontalOrVertical m550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6622constructorimpl(8));
            Modifier m701height3ABfNKs = SizeKt.m701height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6622constructorimpl(280));
            Arrangement.HorizontalOrVertical horizontalOrVertical = m550spacedBy0680j_4;
            ComposerKt.sourceInformationMarkerStart($composer, 809799660, "CC(remember):AssetsListScreen.kt#9igjgp");
            boolean changed = $composer.changed($items$delegate);
            Object rememberedValue = $composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function1() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return AssetsListScreenKt.AssetsListScreen$lambda$127$lambda$126$lambda$125(State.this, $showQuickAdjustDialog$delegate, $itemToAdjust$delegate, (LazyListScope) obj2);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyColumn(m701height3ABfNKs, null, null, false, horizontalOrVertical, null, null, false, (Function1) obj, $composer, 24582, 238);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$127$lambda$126$lambda$125(State $items$delegate, final MutableState $showQuickAdjustDialog$delegate, final MutableState $itemToAdjust$delegate, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List AssetsListScreen$lambda$0 = AssetsListScreen$lambda$0($items$delegate);
        final Function1 function1 = new Function1() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AssetsListScreenKt.AssetsListScreen$lambda$127$lambda$126$lambda$125$lambda$122((FinancialItem) obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$127$lambda$126$lambda$125$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke((FinancialItem) p1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(FinancialItem financialItem) {
                return null;
            }
        };
        LazyColumn.items(AssetsListScreen$lambda$0.size(), new Function1<Integer, Object>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$127$lambda$126$lambda$125$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke(AssetsListScreen$lambda$0.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$127$lambda$126$lambda$125$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke(AssetsListScreen$lambda$0.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$127$lambda$126$lambda$125$$inlined$items$default$4
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
                final FinancialItem financialItem = (FinancialItem) AssetsListScreen$lambda$0.get(it);
                $composer.startReplaceGroup(-753713624);
                ComposerKt.sourceInformation($composer, "C*598@29885L11,601@30058L157,605@30242L1072,596@29763L1551:AssetsListScreen.kt#2thlc2");
                RoundedCornerShape m953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(12));
                long surfaceContainerHigh = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerHigh();
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart($composer, 1915357353, "CC(remember):AssetsListScreen.kt#9igjgp");
                boolean z = (((i & 112) ^ 48) > 32 && $composer.changed(financialItem)) || (i & 48) == 32;
                Object rememberedValue = $composer.rememberedValue();
                if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState = $showQuickAdjustDialog$delegate;
                    final MutableState mutableState2 = $itemToAdjust$delegate;
                    obj = (Function0) new Function0<Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$6$1$1$2$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            AssetsListScreenKt.AssetsListScreen$lambda$18(mutableState, false);
                            mutableState2.setValue(FinancialItem.this);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                SurfaceKt.m2543SurfaceT9BRK9s(ClickableKt.m258clickableXHw0xAI$default(fillMaxWidth$default, false, null, null, (Function0) obj, 7, null), m953RoundedCornerShape0680j_4, surfaceContainerHigh, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1174549327, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$6$1$1$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:24:0x01d5  */
                    /* JADX WARN: Removed duplicated region for block: B:27:0x01e1  */
                    /* JADX WARN: Removed duplicated region for block: B:30:0x0218  */
                    /* JADX WARN: Removed duplicated region for block: B:35:0x0372  */
                    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:39:0x022e  */
                    /* JADX WARN: Removed duplicated region for block: B:40:0x01e7  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void invoke(androidx.compose.runtime.Composer r84, int r85) {
                        /*
                            Method dump skipped, instructions count: 886
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$6$1$1$2$2.invoke(androidx.compose.runtime.Composer, int):void");
                    }
                }, $composer, 54), $composer, 12582912, 120);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object AssetsListScreen$lambda$127$lambda$126$lambda$125$lambda$122(FinancialItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "adj_" + it.getId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$121(final MutableState $showQuickAdjustDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C627@31437L33,627@31416L110:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1108194235, $changed, -1, "com.example.ui.screens.AssetsListScreen.<anonymous> (AssetsListScreen.kt:627)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -177228292, "CC(remember):AssetsListScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AssetsListScreenKt.AssetsListScreen$lambda$121$lambda$120$lambda$119(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$AssetsListScreenKt.INSTANCE.m7024getLambda$1154160994$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$121$lambda$120$lambda$119(MutableState $showQuickAdjustDialog$delegate) {
        AssetsListScreen$lambda$18($showQuickAdjustDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$129$lambda$128(MutableState $showQuickModifyDialog$delegate) {
        AssetsListScreen$lambda$12($showQuickModifyDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$138(final State $items$delegate, final Function1 $onEditItem, final MutableState $showQuickModifyDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C651@32379L1683,646@32159L1903:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1755820147, $changed, -1, "com.example.ui.screens.AssetsListScreen.<anonymous> (AssetsListScreen.kt:646)");
            }
            Arrangement.HorizontalOrVertical m550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6622constructorimpl(8));
            Modifier m701height3ABfNKs = SizeKt.m701height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6622constructorimpl(280));
            Arrangement.HorizontalOrVertical horizontalOrVertical = m550spacedBy0680j_4;
            ComposerKt.sourceInformationMarkerStart($composer, 578995360, "CC(remember):AssetsListScreen.kt#9igjgp");
            boolean changed = $composer.changed($items$delegate) | $composer.changed($onEditItem);
            Object rememberedValue = $composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function1() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return AssetsListScreenKt.AssetsListScreen$lambda$138$lambda$137$lambda$136(State.this, $onEditItem, $showQuickModifyDialog$delegate, (LazyListScope) obj2);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyColumn(m701height3ABfNKs, null, null, false, horizontalOrVertical, null, null, false, (Function1) obj, $composer, 24582, 238);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$138$lambda$137$lambda$136(State $items$delegate, final Function1 $onEditItem, final MutableState $showQuickModifyDialog$delegate, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List AssetsListScreen$lambda$0 = AssetsListScreen$lambda$0($items$delegate);
        final Function1 function1 = new Function1() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda47
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AssetsListScreenKt.AssetsListScreen$lambda$138$lambda$137$lambda$136$lambda$133((FinancialItem) obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$138$lambda$137$lambda$136$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke((FinancialItem) p1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(FinancialItem financialItem) {
                return null;
            }
        };
        LazyColumn.items(AssetsListScreen$lambda$0.size(), new Function1<Integer, Object>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$138$lambda$137$lambda$136$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke(AssetsListScreen$lambda$0.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$138$lambda$137$lambda$136$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke(AssetsListScreen$lambda$0.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$138$lambda$137$lambda$136$$inlined$items$default$4
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
                final FinancialItem financialItem = (FinancialItem) AssetsListScreen$lambda$0.get(it);
                $composer.startReplaceGroup(-1707381388);
                ComposerKt.sourceInformation($composer, "C*655@32596L11,658@32769L154,662@32950L1072,653@32474L1548:AssetsListScreen.kt#2thlc2");
                RoundedCornerShape m953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(12));
                long surfaceContainerHigh = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceContainerHigh();
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart($composer, -2133278755, "CC(remember):AssetsListScreen.kt#9igjgp");
                boolean changed = $composer.changed($onEditItem) | ((((i & 112) ^ 48) > 32 && $composer.changed(financialItem)) || (i & 48) == 32);
                Object rememberedValue = $composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function13 = $onEditItem;
                    final MutableState mutableState = $showQuickModifyDialog$delegate;
                    obj = (Function0) new Function0<Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$9$1$1$2$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            AssetsListScreenKt.AssetsListScreen$lambda$12(mutableState, false);
                            function13.invoke(financialItem);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                SurfaceKt.m2543SurfaceT9BRK9s(ClickableKt.m258clickableXHw0xAI$default(fillMaxWidth$default, false, null, null, (Function0) obj, 7, null), m953RoundedCornerShape0680j_4, surfaceContainerHigh, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1731114904, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$9$1$1$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:24:0x01d5  */
                    /* JADX WARN: Removed duplicated region for block: B:27:0x01e1  */
                    /* JADX WARN: Removed duplicated region for block: B:30:0x0218  */
                    /* JADX WARN: Removed duplicated region for block: B:35:0x0372  */
                    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:39:0x022e  */
                    /* JADX WARN: Removed duplicated region for block: B:40:0x01e7  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void invoke(androidx.compose.runtime.Composer r84, int r85) {
                        /*
                            Method dump skipped, instructions count: 886
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$9$1$1$2$2.invoke(androidx.compose.runtime.Composer, int):void");
                    }
                }, $composer, 54), $composer, 12582912, 120);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object AssetsListScreen$lambda$138$lambda$137$lambda$136$lambda$133(FinancialItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "mod_" + it.getId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$132(final MutableState $showQuickModifyDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C684@34145L33,684@34124L110:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1552127218, $changed, -1, "com.example.ui.screens.AssetsListScreen.<anonymous> (AssetsListScreen.kt:684)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1240606067, "CC(remember):AssetsListScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda36
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AssetsListScreenKt.AssetsListScreen$lambda$132$lambda$131$lambda$130(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$AssetsListScreenKt.INSTANCE.getLambda$682203925$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$132$lambda$131$lambda$130(MutableState $showQuickModifyDialog$delegate) {
        AssetsListScreen$lambda$12($showQuickModifyDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$140$lambda$139(MutableState $showQuickDeleteDialog$delegate) {
        AssetsListScreen$lambda$15($showQuickDeleteDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$149(final State $items$delegate, final MutableState $showQuickDeleteDialog$delegate, final MutableState $itemToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C708@35100L1639,703@34880L1859:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-469337842, $changed, -1, "com.example.ui.screens.AssetsListScreen.<anonymous> (AssetsListScreen.kt:703)");
            }
            Arrangement.HorizontalOrVertical m550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6622constructorimpl(8));
            Modifier m701height3ABfNKs = SizeKt.m701height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6622constructorimpl(280));
            Arrangement.HorizontalOrVertical horizontalOrVertical = m550spacedBy0680j_4;
            ComposerKt.sourceInformationMarkerStart($composer, -62090827, "CC(remember):AssetsListScreen.kt#9igjgp");
            boolean changed = $composer.changed($items$delegate);
            Object rememberedValue = $composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function1() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda51
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return AssetsListScreenKt.AssetsListScreen$lambda$149$lambda$148$lambda$147(State.this, $showQuickDeleteDialog$delegate, $itemToDelete$delegate, (LazyListScope) obj2);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyColumn(m701height3ABfNKs, null, null, false, horizontalOrVertical, null, null, false, (Function1) obj, $composer, 24582, 238);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$149$lambda$148$lambda$147(State $items$delegate, final MutableState $showQuickDeleteDialog$delegate, final MutableState $itemToDelete$delegate, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List AssetsListScreen$lambda$0 = AssetsListScreen$lambda$0($items$delegate);
        final Function1 function1 = new Function1() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda52
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AssetsListScreenKt.AssetsListScreen$lambda$149$lambda$148$lambda$147$lambda$144((FinancialItem) obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$149$lambda$148$lambda$147$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke((FinancialItem) p1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(FinancialItem financialItem) {
                return null;
            }
        };
        LazyColumn.items(AssetsListScreen$lambda$0.size(), new Function1<Integer, Object>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$149$lambda$148$lambda$147$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke(AssetsListScreen$lambda$0.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$149$lambda$148$lambda$147$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke(AssetsListScreen$lambda$0.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$lambda$149$lambda$148$lambda$147$$inlined$items$default$4
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
                final FinancialItem financialItem = (FinancialItem) AssetsListScreen$lambda$0.get(it);
                $composer.startReplaceGroup(-106216705);
                ComposerKt.sourceInformation($composer, "C*715@35461L157,719@35645L1054,710@35195L1504:AssetsListScreen.kt#2thlc2");
                RoundedCornerShape m953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(12));
                long Color = ColorKt.Color(4294894306L);
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart($composer, 1520601473, "CC(remember):AssetsListScreen.kt#9igjgp");
                boolean z = (((i & 112) ^ 48) > 32 && $composer.changed(financialItem)) || (i & 48) == 32;
                Object rememberedValue = $composer.rememberedValue();
                if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState = $showQuickDeleteDialog$delegate;
                    final MutableState mutableState2 = $itemToDelete$delegate;
                    obj = (Function0) new Function0<Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$12$1$1$2$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            AssetsListScreenKt.AssetsListScreen$lambda$15(mutableState, false);
                            mutableState2.setValue(FinancialItem.this);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                SurfaceKt.m2543SurfaceT9BRK9s(ClickableKt.m258clickableXHw0xAI$default(fillMaxWidth$default, false, null, null, (Function0) obj, 7, null), m953RoundedCornerShape0680j_4, Color, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-444632599, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$12$1$1$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:24:0x01d3  */
                    /* JADX WARN: Removed duplicated region for block: B:27:0x01df  */
                    /* JADX WARN: Removed duplicated region for block: B:30:0x0216  */
                    /* JADX WARN: Removed duplicated region for block: B:35:0x0355  */
                    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:39:0x022c  */
                    /* JADX WARN: Removed duplicated region for block: B:40:0x01e5  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void invoke(androidx.compose.runtime.Composer r74, int r75) {
                        /*
                            Method dump skipped, instructions count: 857
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AssetsListScreenKt$AssetsListScreen$12$1$1$2$2.invoke(androidx.compose.runtime.Composer, int):void");
                    }
                }, $composer, 54), $composer, 12583296, 120);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object AssetsListScreen$lambda$149$lambda$148$lambda$147$lambda$144(FinancialItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "del_" + it.getId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$143(final MutableState $showQuickDeleteDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C741@36822L33,741@36801L110:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1456357773, $changed, -1, "com.example.ui.screens.AssetsListScreen.<anonymous> (AssetsListScreen.kt:741)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 599519924, "CC(remember):AssetsListScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda60
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AssetsListScreenKt.AssetsListScreen$lambda$143$lambda$142$lambda$141(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$AssetsListScreenKt.INSTANCE.getLambda$1968686230$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssetsListScreen$lambda$143$lambda$142$lambda$141(MutableState $showQuickDeleteDialog$delegate) {
        AssetsListScreen$lambda$15($showQuickDeleteDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0398  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FinancialItemCard(final com.example.data.model.FinancialItem r59, final kotlin.jvm.functions.Function0<kotlin.Unit> r60, kotlin.jvm.functions.Function0<kotlin.Unit> r61, final kotlin.jvm.functions.Function0<kotlin.Unit> r62, androidx.compose.runtime.Composer r63, final int r64, final int r65) {
        /*
            Method dump skipped, instructions count: 1273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AssetsListScreenKt.FinancialItemCard(com.example.data.model.FinancialItem, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean FinancialItemCard$lambda$154(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialItemCard$lambda$155(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialItemCard$lambda$181$lambda$157$lambda$156(MutableState $showMenu$delegate) {
        FinancialItemCard$lambda$155($showMenu$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0bad  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0bb9  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0bf2  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0cd8  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0ce4  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0d1d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0d8e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0e17  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0fec  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0ff8  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x102f  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x1192  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x1045  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0ffe  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0eb7  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0edd  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0ef7  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0ecf  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0e00  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0d33 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0cea  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0c08  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0bbf  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x09b2  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x092b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x08e2  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x062a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0351 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0614  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x074c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x08d0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x08dc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0915  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x09a0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0a06  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialItemCard$lambda$181$lambda$171(final com.example.data.model.FinancialItem r163, final long r164, final androidx.compose.ui.graphics.vector.ImageVector r166, kotlin.jvm.functions.Function0 r167, kotlin.jvm.functions.Function0 r168, kotlin.jvm.functions.Function0 r169, androidx.compose.foundation.layout.ColumnScope r170, androidx.compose.runtime.Composer r171, int r172) {
        /*
            Method dump skipped, instructions count: 4504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AssetsListScreenKt.FinancialItemCard$lambda$181$lambda$171(com.example.data.model.FinancialItem, long, androidx.compose.ui.graphics.vector.ImageVector, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialItemCard$lambda$181$lambda$171$lambda$170$lambda$165$lambda$163$lambda$159(com.example.data.model.FinancialItem r32, long r33, androidx.compose.ui.graphics.vector.ImageVector r35, androidx.compose.runtime.Composer r36, int r37) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.AssetsListScreenKt.FinancialItemCard$lambda$181$lambda$171$lambda$170$lambda$165$lambda$163$lambda$159(com.example.data.model.FinancialItem, long, androidx.compose.ui.graphics.vector.ImageVector, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialItemCard$lambda$181$lambda$171$lambda$170$lambda$165$lambda$163$lambda$162$lambda$161$lambda$160(FinancialItem $item, long $ownerColor, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C825@40607L394:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-110002554, $changed, -1, "com.example.ui.screens.FinancialItemCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AssetsListScreen.kt:825)");
            }
            TextKt.m2693Text4IGK_g($item.getOwner(), PaddingKt.m671paddingVpY3zN4(Modifier.INSTANCE, Dp.m6622constructorimpl(6), Dp.m6622constructorimpl(2)), $ownerColor, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 199728, 0, 131024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialItemCard$lambda$181$lambda$171$lambda$170$lambda$169$lambda$167$lambda$166(FinancialItem $item, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C904@44875L414:AssetsListScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-358586756, $changed, -1, "com.example.ui.screens.FinancialItemCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AssetsListScreen.kt:904)");
            }
            TextKt.m2693Text4IGK_g("Deducted from: " + $item.getSourceAccountTitle(), PaddingKt.m671paddingVpY3zN4(Modifier.INSTANCE, Dp.m6622constructorimpl(6), Dp.m6622constructorimpl(2)), ColorKt.Color(4292617766L), TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 200112, 0, 131024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialItemCard$lambda$181$lambda$173$lambda$172(MutableState $showMenu$delegate) {
        FinancialItemCard$lambda$155($showMenu$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialItemCard$lambda$181$lambda$180(FinancialItem $item, final Function0 $onAdjust, final Function0 $onEdit, final Function0 $onDelete, final MutableState $showMenu$delegate, ColumnScope DropdownMenu, Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation($composer, "C973@48307L87,971@48202L401,982@48706L85,980@48616L356,991@49104L87,989@48985L417:AssetsListScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1045270650, $changed, -1, "com.example.ui.screens.FinancialItemCard.<anonymous>.<anonymous> (AssetsListScreen.kt:971)");
            }
            Modifier testTag = TestTagKt.testTag(Modifier.INSTANCE, "long_press_menu_adjust_" + $item.getId());
            Function2<Composer, Integer, Unit> lambda$1028467542$app = ComposableSingletons$AssetsListScreenKt.INSTANCE.getLambda$1028467542$app();
            ComposerKt.sourceInformationMarkerStart($composer, 517256509, "CC(remember):AssetsListScreen.kt#9igjgp");
            boolean changed = $composer.changed($onAdjust);
            Object rememberedValue = $composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda43
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AssetsListScreenKt.FinancialItemCard$lambda$181$lambda$180$lambda$175$lambda$174(Function0.this, $showMenu$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            AndroidMenu_androidKt.DropdownMenuItem(lambda$1028467542$app, (Function0) obj, testTag, ComposableSingletons$AssetsListScreenKt.INSTANCE.m7035getLambda$93075047$app(), null, false, null, null, null, $composer, 3078, 496);
            Modifier testTag2 = TestTagKt.testTag(Modifier.INSTANCE, "long_press_menu_edit_" + $item.getId());
            Function2<Composer, Integer, Unit> lambda$727932749$app = ComposableSingletons$AssetsListScreenKt.INSTANCE.getLambda$727932749$app();
            ComposerKt.sourceInformationMarkerStart($composer, 517269275, "CC(remember):AssetsListScreen.kt#9igjgp");
            boolean changed2 = $composer.changed($onEdit);
            Object rememberedValue2 = $composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                obj2 = new Function0() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda45
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AssetsListScreenKt.FinancialItemCard$lambda$181$lambda$180$lambda$177$lambda$176(Function0.this, $showMenu$delegate);
                    }
                };
                $composer.updateRememberedValue(obj2);
            } else {
                obj2 = rememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            AndroidMenu_androidKt.DropdownMenuItem(lambda$727932749$app, (Function0) obj2, testTag2, ComposableSingletons$AssetsListScreenKt.INSTANCE.getLambda$962296016$app(), null, false, null, null, null, $composer, 3078, 496);
            Modifier testTag3 = TestTagKt.testTag(Modifier.INSTANCE, "long_press_menu_delete_" + $item.getId());
            Function2<Composer, Integer, Unit> m7030getLambda$2013947186$app = ComposableSingletons$AssetsListScreenKt.INSTANCE.m7030getLambda$2013947186$app();
            ComposerKt.sourceInformationMarkerStart($composer, 517282013, "CC(remember):AssetsListScreen.kt#9igjgp");
            boolean changed3 = $composer.changed($onDelete);
            Object rememberedValue3 = $composer.rememberedValue();
            if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                obj3 = new Function0() { // from class: com.example.ui.screens.AssetsListScreenKt$$ExternalSyntheticLambda46
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AssetsListScreenKt.FinancialItemCard$lambda$181$lambda$180$lambda$179$lambda$178(Function0.this, $showMenu$delegate);
                    }
                };
                $composer.updateRememberedValue(obj3);
            } else {
                obj3 = rememberedValue3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            AndroidMenu_androidKt.DropdownMenuItem(m7030getLambda$2013947186$app, (Function0) obj3, testTag3, ComposableSingletons$AssetsListScreenKt.INSTANCE.m7028getLambda$1779583919$app(), null, false, null, null, null, $composer, 3078, 496);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialItemCard$lambda$181$lambda$180$lambda$175$lambda$174(Function0 $onAdjust, MutableState $showMenu$delegate) {
        FinancialItemCard$lambda$155($showMenu$delegate, false);
        $onAdjust.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialItemCard$lambda$181$lambda$180$lambda$177$lambda$176(Function0 $onEdit, MutableState $showMenu$delegate) {
        FinancialItemCard$lambda$155($showMenu$delegate, false);
        $onEdit.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialItemCard$lambda$181$lambda$180$lambda$179$lambda$178(Function0 $onDelete, MutableState $showMenu$delegate) {
        FinancialItemCard$lambda$155($showMenu$delegate, false);
        $onDelete.invoke();
        return Unit.INSTANCE;
    }
}
