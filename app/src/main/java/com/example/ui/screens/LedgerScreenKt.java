package com.example.ui.screens;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AccountBalanceKt;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material.icons.filled.CreditCardKt;
import androidx.compose.material.icons.filled.PaymentsKt;
import androidx.compose.material.icons.filled.ShoppingCartKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.FilterChipDefaults;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
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
import androidx.profileinstaller.ProfileVerifier;
import com.example.data.model.FinancialItem;
import com.example.data.model.LedgerEntry;
import com.example.ui.viewmodel.NetWorthViewModel;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* compiled from: LedgerScreen.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\u0010\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u008a\u0084\u0002²\u0006\u0010\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\f\u0010\u000f\u001a\u0004\u0018\u00010\nX\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\f\u0010\u0014\u001a\u0004\u0018\u00010\fX\u008a\u008e\u0002²\u0006\f\u0010\u0015\u001a\u0004\u0018\u00010\fX\u008a\u008e\u0002²\u0006\n\u0010\u0016\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u001d\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u001e\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\u0011X\u008a\u008e\u0002"}, d2 = {"LedgerScreen", "", "viewModel", "Lcom/example/ui/viewmodel/NetWorthViewModel;", "onAddNewExpense", "Lkotlin/Function0;", "(Lcom/example/ui/viewmodel/NetWorthViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app", "ledgerEntries", "", "Lcom/example/data/model/LedgerEntry;", "allItems", "Lcom/example/data/model/FinancialItem;", "selectedAccountFilter", "", "entryToDelete", "showDirectLedgerDialog", "", "showManageAccountsDialog", "adjustBalanceOnLedgerDelete", "accountToDelete", "editingAccount", "accTitle", "accCategory", "accValueStr", "accOwner", "accNotes", "categoryDropdownExpanded", "ownerDropdownExpanded", "txTitle", "primaryAccount", "secondaryAccount", "amountStr", "isDebitPrimary", "notesStr", "primaryDropdownExpanded"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LedgerScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$237(NetWorthViewModel netWorthViewModel, Function0 function0, int i, Composer composer, int i2) {
        LedgerScreen(netWorthViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0744  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0830  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x083c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0875  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0951  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x095d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0996  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0b15  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0bef  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0bfb  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0c34  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0cf1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0d7d  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0f00  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0f0c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0f45  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x1028  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x1034  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x106d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x1145  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x1151  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x118a  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x12aa  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x131c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x142a  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x14f9  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x1505  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x153c  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x16a5  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x17c8  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x1b4f  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x1d83  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x1e5d  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x1f1b  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x1f0a  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x1e4a  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x1d71  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x1b2a  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x1725  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x1552  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x150b  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x1437 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x13be  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x12b8  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x11a0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x1157  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x1083 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x103a  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0f5b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0f12  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0d8f  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0cff  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0c4a  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0c01  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x09ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0963  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x088b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0842  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x075a  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0711  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0637  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x05ee  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x05dc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x05e8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x070b  */
    /* JADX WARN: Type inference failed for: r27v0 */
    /* JADX WARN: Type inference failed for: r27v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LedgerScreen(final com.example.ui.viewmodel.NetWorthViewModel r183, final kotlin.jvm.functions.Function0<kotlin.Unit> r184, androidx.compose.runtime.Composer r185, final int r186) {
        /*
            Method dump skipped, instructions count: 7990
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.LedgerScreenKt.LedgerScreen(com.example.ui.viewmodel.NetWorthViewModel, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    private static final List<LedgerEntry> LedgerScreen$lambda$0(State<? extends List<LedgerEntry>> state) {
        return (List) state.getValue();
    }

    private static final List<FinancialItem> LedgerScreen$lambda$1(State<? extends List<FinancialItem>> state) {
        return (List) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String LedgerScreen$lambda$3(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final LedgerEntry LedgerScreen$lambda$6(MutableState<LedgerEntry> mutableState) {
        return mutableState.getValue();
    }

    private static final void LedgerScreen$lambda$10(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean LedgerScreen$lambda$9(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final boolean LedgerScreen$lambda$12(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void LedgerScreen$lambda$13(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean LedgerScreen$lambda$15(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void LedgerScreen$lambda$16(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final FinancialItem LedgerScreen$lambda$18(MutableState<FinancialItem> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$69$lambda$39$lambda$33$lambda$32$lambda$31(NetWorthViewModel $viewModel, Context $context) {
        $viewModel.refreshAndRecalculateAll();
        Toast.makeText($context, "🔄 Refreshed & Recalculated Ledger", 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$69$lambda$39$lambda$38$lambda$35$lambda$34(MutableState $showManageAccountsDialog$delegate) {
        LedgerScreen$lambda$13($showManageAccountsDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$69$lambda$39$lambda$38$lambda$37$lambda$36(MutableState $showDirectLedgerDialog$delegate) {
        LedgerScreen$lambda$10($showDirectLedgerDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$69$lambda$54$lambda$45$lambda$42$lambda$41$lambda$40(MutableState $showManageAccountsDialog$delegate) {
        LedgerScreen$lambda$13($showManageAccountsDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$69$lambda$54$lambda$45$lambda$44$lambda$43(MutableState $selectedAccountFilter$delegate) {
        $selectedAccountFilter$delegate.setValue("All Accounts");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$69$lambda$54$lambda$53$lambda$52(final MutableState $selectedAccountFilter$delegate, State $allItems$delegate, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        LazyListScope.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(-2036833594, true, new Function3() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda74
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return LedgerScreenKt.LedgerScreen$lambda$69$lambda$54$lambda$53$lambda$52$lambda$48(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        final List LedgerScreen$lambda$1 = LedgerScreen$lambda$1($allItems$delegate);
        final Function1 function1 = new Function1() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LedgerScreenKt.LedgerScreen$lambda$69$lambda$54$lambda$53$lambda$52$lambda$49((FinancialItem) obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$lambda$69$lambda$54$lambda$53$lambda$52$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke((FinancialItem) p1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(FinancialItem financialItem) {
                return null;
            }
        };
        LazyRow.items(LedgerScreen$lambda$1.size(), new Function1<Integer, Object>() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$lambda$69$lambda$54$lambda$53$lambda$52$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke(LedgerScreen$lambda$1.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$lambda$69$lambda$54$lambda$53$lambda$52$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke(LedgerScreen$lambda$1.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$lambda$69$lambda$54$lambda$53$lambda$52$$inlined$items$default$4
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
                String LedgerScreen$lambda$3;
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
                final FinancialItem financialItem = (FinancialItem) LedgerScreen$lambda$1.get(it);
                $composer.startReplaceGroup(1316692511);
                ComposerKt.sourceInformation($composer, "C*296@13015L37,297@13086L269,303@13395L684,315@14133L355,294@12922L1588:LedgerScreen.kt#2thlc2");
                LedgerScreen$lambda$3 = LedgerScreenKt.LedgerScreen$lambda$3($selectedAccountFilter$delegate);
                boolean equals = StringsKt.equals(LedgerScreen$lambda$3, financialItem.getTitle(), true);
                ComposerKt.sourceInformationMarkerStart($composer, 181025685, "CC(remember):LedgerScreen.kt#9igjgp");
                boolean z = (((i & 112) ^ 48) > 32 && $composer.changed(financialItem)) || (i & 48) == 32;
                Object rememberedValue = $composer.rememberedValue();
                if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState = $selectedAccountFilter$delegate;
                    obj = (Function0) new Function0<Unit>() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$1$2$2$1$3$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mutableState.setValue(FinancialItem.this.getTitle());
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                Function0 function0 = (Function0) obj;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ChipKt.FilterChip(equals, function0, ComposableLambdaKt.rememberComposableLambda(-700179555, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$1$2$2$1$3$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C298@13116L213:LedgerScreen.kt#2thlc2");
                        if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-700179555, $changed2, -1, "com.example.ui.screens.LedgerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LedgerScreen.kt:298)");
                        }
                        String title = FinancialItem.this.getTitle();
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format(Locale.US, "%,.0f", Arrays.copyOf(new Object[]{Double.valueOf(FinancialItem.this.getCurrentValue())}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        TextKt.m2693Text4IGK_g(title + " • ₹" + format, (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 131038);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer, 54), null, false, ComposableLambdaKt.rememberComposableLambda(-722320518, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$1$2$2$1$3$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ImageVector payments;
                        ComposerKt.sourceInformation($composer2, "C304@13425L628:LedgerScreen.kt#2thlc2");
                        if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-722320518, $changed2, -1, "com.example.ui.screens.LedgerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LedgerScreen.kt:304)");
                        }
                        if (FinancialItem.this.isLiability()) {
                            payments = CreditCardKt.getCreditCard(Icons.INSTANCE.getDefault());
                        } else if (StringsKt.contains((CharSequence) FinancialItem.this.getCategory(), (CharSequence) "Expense", true)) {
                            payments = ShoppingCartKt.getShoppingCart(Icons.INSTANCE.getDefault());
                        } else {
                            payments = StringsKt.contains((CharSequence) FinancialItem.this.getCategory(), (CharSequence) "Cash", true) ? PaymentsKt.getPayments(Icons.INSTANCE.getDefault()) : AccountBalanceKt.getAccountBalance(Icons.INSTANCE.getDefault());
                        }
                        IconKt.m2150Iconww6aTOc(payments, (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(14)), 0L, $composer2, 432, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer, 54), null, null, FilterChipDefaults.INSTANCE.m2111filterChipColorsXqyqHi0(0L, 0L, 0L, 0L, 0L, 0L, 0L, ColorKt.Color(financialItem.isLiability() ? 4292617766L : StringsKt.contains((CharSequence) financialItem.getCategory(), (CharSequence) "Expense", true) ? 4286331629L : 4278556265L), 0L, Color.INSTANCE.m4196getWhite0d7_KjU(), Color.INSTANCE.m4196getWhite0d7_KjU(), 0L, $composer, 805306368, (FilterChipDefaults.$stable << 6) | 6, 2431), null, null, null, $composer, 196992, 0, 3800);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$69$lambda$54$lambda$53$lambda$52$lambda$48(final MutableState $selectedAccountFilter$delegate, LazyItemScope item, Composer $composer, int $changed) {
        Object obj;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C283@12330L42,286@12599L11,285@12514L192,281@12208L520:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2036833594, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LedgerScreen.kt:281)");
            }
            boolean areEqual = Intrinsics.areEqual(LedgerScreen$lambda$3($selectedAccountFilter$delegate), "All Accounts");
            ComposerKt.sourceInformationMarkerStart($composer, 1108007792, "CC(remember):LedgerScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda73
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LedgerScreenKt.LedgerScreen$lambda$69$lambda$54$lambda$53$lambda$52$lambda$48$lambda$47$lambda$46(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ChipKt.FilterChip(areEqual, (Function0) obj, ComposableSingletons$LedgerScreenKt.INSTANCE.getLambda$316794099$app(), null, false, null, null, null, FilterChipDefaults.INSTANCE.m2111filterChipColorsXqyqHi0(0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary(), 0L, Color.INSTANCE.m4196getWhite0d7_KjU(), 0L, 0L, $composer, 805306368, FilterChipDefaults.$stable << 6, 3455), null, null, null, $composer, 432, 0, 3832);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$69$lambda$54$lambda$53$lambda$52$lambda$48$lambda$47$lambda$46(MutableState $selectedAccountFilter$delegate) {
        $selectedAccountFilter$delegate.setValue("All Accounts");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object LedgerScreen$lambda$69$lambda$54$lambda$53$lambda$52$lambda$49(FinancialItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$69$lambda$59$lambda$56(double $totalDebits, ColumnScope Card, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C338@15057L681:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1103677103, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous>.<anonymous>.<anonymous> (LedgerScreen.kt:338)");
            }
            Modifier m670padding3ABfNKs = PaddingKt.m670padding3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(10));
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
            ComposerKt.sourceInformationMarkerStart($composer, -1852850554, "C339@15122L225,345@15368L40,348@15566L10,346@15429L291:LedgerScreen.kt#2thlc2");
            TextKt.m2693Text4IGK_g("TOTAL DEBITS (DR)", (Modifier) null, ColorKt.Color(4286331629L), TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 200070, 0, 131026);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(2)), $composer, 6);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "%,.2f", Arrays.copyOf(new Object[]{Double.valueOf($totalDebits)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            TextKt.m2693Text4IGK_g("₹" + format, (Modifier) null, ColorKt.Color(4285343961L), 0L, (FontStyle) null, FontWeight.INSTANCE.getExtraBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 196992, 0, 65498);
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
    public static final Unit LedgerScreen$lambda$69$lambda$59$lambda$58(double $totalCredits, ColumnScope Card, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C363@16084L683:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1993258808, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous>.<anonymous>.<anonymous> (LedgerScreen.kt:363)");
            }
            Modifier m670padding3ABfNKs = PaddingKt.m670padding3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(10));
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
            ComposerKt.sourceInformationMarkerStart($composer, 1307745645, "C364@16149L226,370@16396L40,373@16595L10,371@16457L292:LedgerScreen.kt#2thlc2");
            TextKt.m2693Text4IGK_g("TOTAL CREDITS (CR)", (Modifier) null, ColorKt.Color(4278556265L), TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 200070, 0, 131026);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(2)), $composer, 6);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "%,.2f", Arrays.copyOf(new Object[]{Double.valueOf($totalCredits)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            TextKt.m2693Text4IGK_g("₹" + format, (Modifier) null, ColorKt.Color(4278483031L), 0L, (FontStyle) null, FontWeight.INSTANCE.getExtraBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 196992, 0, 65498);
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
    /* JADX WARN: Removed duplicated region for block: B:25:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit LedgerScreen$lambda$69$lambda$64(androidx.compose.runtime.MutableState r69, kotlin.jvm.functions.Function0 r70, final androidx.compose.runtime.MutableState r71, androidx.compose.foundation.layout.ColumnScope r72, androidx.compose.runtime.Composer r73, int r74) {
        /*
            Method dump skipped, instructions count: 1147
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.LedgerScreenKt.LedgerScreen$lambda$69$lambda$64(androidx.compose.runtime.MutableState, kotlin.jvm.functions.Function0, androidx.compose.runtime.MutableState, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$69$lambda$64$lambda$63$lambda$62$lambda$61$lambda$60(MutableState $showManageAccountsDialog$delegate) {
        LedgerScreen$lambda$13($showManageAccountsDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$69$lambda$68$lambda$67(final List $filteredEntries, final SimpleDateFormat $dateFormatter, final MutableState $entryToDelete$delegate, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final Function1 function1 = new Function1() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LedgerScreenKt.LedgerScreen$lambda$69$lambda$68$lambda$67$lambda$65((LedgerEntry) obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$lambda$69$lambda$68$lambda$67$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke((LedgerEntry) p1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(LedgerEntry ledgerEntry) {
                return null;
            }
        };
        LazyColumn.items($filteredEntries.size(), new Function1<Integer, Object>() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$lambda$69$lambda$68$lambda$67$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke($filteredEntries.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$lambda$69$lambda$68$lambda$67$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke($filteredEntries.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$lambda$69$lambda$68$lambda$67$$inlined$items$default$4
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
                final String str;
                ComposerKt.sourceInformation($composer, "C152@7074L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                int $dirty2 = $dirty;
                if (($dirty2 & 147) == 146 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, $dirty2, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                int i = $dirty2 & 14;
                final LedgerEntry ledgerEntry = (LedgerEntry) $filteredEntries.get(it);
                $composer.startReplaceGroup(1558601314);
                ComposerKt.sourceInformation($composer, "C*456@20454L11,455@20383L116,458@20550L38,462@20770L5814,453@20272L6312:LedgerScreen.kt#2thlc2");
                final boolean equals = StringsKt.equals(ledgerEntry.getEntryType(), "DR", true);
                try {
                    str = $dateFormatter.format(new Date(ledgerEntry.getTimestamp()));
                } catch (Exception e) {
                    str = "";
                }
                RoundedCornerShape m953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(12));
                CardColors m1829cardColorsro_MJ88 = CardDefaults.INSTANCE.m1829cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14);
                CardElevation m1830cardElevationaqJV_2Y = CardDefaults.INSTANCE.m1830cardElevationaqJV_2Y(Dp.m6622constructorimpl(1), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer, (CardDefaults.$stable << 18) | 6, 62);
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                long id = ledgerEntry.getId();
                final MutableState mutableState = $entryToDelete$delegate;
                CardKt.Card(TestTagKt.testTag(fillMaxWidth$default, "ledger_entry_card_" + id), m953RoundedCornerShape0680j_4, m1829cardColorsro_MJ88, m1830cardElevationaqJV_2Y, null, ComposableLambdaKt.rememberComposableLambda(-1299340920, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$1$5$1$2$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                        invoke(columnScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:101:0x0aec  */
                    /* JADX WARN: Removed duplicated region for block: B:104:0x0b8b  */
                    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:107:0x0b65  */
                    /* JADX WARN: Removed duplicated region for block: B:108:0x0aa9  */
                    /* JADX WARN: Removed duplicated region for block: B:109:0x09e8  */
                    /* JADX WARN: Removed duplicated region for block: B:110:0x0991  */
                    /* JADX WARN: Removed duplicated region for block: B:111:0x0988  */
                    /* JADX WARN: Removed duplicated region for block: B:113:0x0934  */
                    /* JADX WARN: Removed duplicated region for block: B:114:0x08ed  */
                    /* JADX WARN: Removed duplicated region for block: B:115:0x084c  */
                    /* JADX WARN: Removed duplicated region for block: B:117:0x0709 A[ADDED_TO_REGION] */
                    /* JADX WARN: Removed duplicated region for block: B:118:0x06c0  */
                    /* JADX WARN: Removed duplicated region for block: B:120:0x05dc  */
                    /* JADX WARN: Removed duplicated region for block: B:121:0x0593  */
                    /* JADX WARN: Removed duplicated region for block: B:123:0x048c A[ADDED_TO_REGION] */
                    /* JADX WARN: Removed duplicated region for block: B:124:0x0432  */
                    /* JADX WARN: Removed duplicated region for block: B:126:0x03ce A[ADDED_TO_REGION] */
                    /* JADX WARN: Removed duplicated region for block: B:127:0x0385  */
                    /* JADX WARN: Removed duplicated region for block: B:130:0x01f3  */
                    /* JADX WARN: Removed duplicated region for block: B:24:0x01e1  */
                    /* JADX WARN: Removed duplicated region for block: B:27:0x01ed  */
                    /* JADX WARN: Removed duplicated region for block: B:35:0x0373  */
                    /* JADX WARN: Removed duplicated region for block: B:38:0x037f  */
                    /* JADX WARN: Removed duplicated region for block: B:41:0x03b8  */
                    /* JADX WARN: Removed duplicated region for block: B:46:0x042c  */
                    /* JADX WARN: Removed duplicated region for block: B:49:0x047d  */
                    /* JADX WARN: Removed duplicated region for block: B:54:0x0581  */
                    /* JADX WARN: Removed duplicated region for block: B:57:0x058d  */
                    /* JADX WARN: Removed duplicated region for block: B:60:0x05c6  */
                    /* JADX WARN: Removed duplicated region for block: B:65:0x06ae  */
                    /* JADX WARN: Removed duplicated region for block: B:68:0x06ba  */
                    /* JADX WARN: Removed duplicated region for block: B:71:0x06f3  */
                    /* JADX WARN: Removed duplicated region for block: B:76:0x07e6  */
                    /* JADX WARN: Removed duplicated region for block: B:79:0x08db  */
                    /* JADX WARN: Removed duplicated region for block: B:82:0x08e7  */
                    /* JADX WARN: Removed duplicated region for block: B:85:0x091e  */
                    /* JADX WARN: Removed duplicated region for block: B:90:0x0983  */
                    /* JADX WARN: Removed duplicated region for block: B:92:0x098e  */
                    /* JADX WARN: Removed duplicated region for block: B:95:0x09e2  */
                    /* JADX WARN: Removed duplicated region for block: B:98:0x0a27  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void invoke(androidx.compose.foundation.layout.ColumnScope r118, androidx.compose.runtime.Composer r119, int r120) {
                        /*
                            Method dump skipped, instructions count: 2959
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.LedgerScreenKt$LedgerScreen$1$5$1$2$1.invoke(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):void");
                    }
                }, $composer, 54), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object LedgerScreen$lambda$69$lambda$68$lambda$67$lambda$65(LedgerEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    private static final FinancialItem LedgerScreen$lambda$71(MutableState<FinancialItem> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String LedgerScreen$lambda$74(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String LedgerScreen$lambda$77(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String LedgerScreen$lambda$80(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String LedgerScreen$lambda$83(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String LedgerScreen$lambda$86(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean LedgerScreen$lambda$89(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void LedgerScreen$lambda$90(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean LedgerScreen$lambda$92(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void LedgerScreen$lambda$93(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$95$lambda$94(MutableState $showManageAccountsDialog$delegate) {
        LedgerScreen$lambda$13($showManageAccountsDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit LedgerScreen$lambda$100(final androidx.compose.runtime.MutableState r74, androidx.compose.runtime.Composer r75, int r76) {
        /*
            Method dump skipped, instructions count: 845
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.LedgerScreenKt.LedgerScreen$lambda$100(androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$100$lambda$99$lambda$98$lambda$97(MutableState $showManageAccountsDialog$delegate) {
        LedgerScreen$lambda$13($showManageAccountsDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0c7b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0d7a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x1075  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0dcf  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0f01  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0c2b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0b56  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0b0d  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0a3f  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x099b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0923  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0854 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x080b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0731  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0683 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0406 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0634  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x066d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0723  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x07f9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0805  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x083e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0915  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x098d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0a2d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0afb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0b07  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0b40  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0ba6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit LedgerScreen$lambda$153(final java.util.List r143, final androidx.compose.runtime.MutableState r144, final androidx.compose.runtime.MutableState r145, androidx.compose.runtime.MutableState r146, final androidx.compose.runtime.MutableState r147, final java.util.List r148, final androidx.compose.runtime.MutableState r149, final androidx.compose.runtime.MutableState r150, final androidx.compose.runtime.MutableState r151, final java.util.List r152, final androidx.compose.runtime.MutableState r153, final com.example.ui.viewmodel.NetWorthViewModel r154, androidx.compose.runtime.State r155, final androidx.compose.runtime.MutableState r156, androidx.compose.runtime.Composer r157, int r158) {
        /*
            Method dump skipped, instructions count: 4219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.LedgerScreenKt.LedgerScreen$lambda$153(java.util.List, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, java.util.List, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, java.util.List, androidx.compose.runtime.MutableState, com.example.ui.viewmodel.NetWorthViewModel, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$104$lambda$103(final List $presets, final MutableState $accTitle$delegate, final MutableState $accCategory$delegate, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        final Function1 function1 = new Function1() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$lambda$153$lambda$152$lambda$104$lambda$103$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke((Pair<? extends String, ? extends String>) p1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Pair<? extends String, ? extends String> pair) {
                return null;
            }
        };
        LazyRow.items($presets.size(), null, new Function1<Integer, Object>() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$lambda$153$lambda$152$lambda$104$lambda$103$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke($presets.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$lambda$153$lambda$152$lambda$104$lambda$103$$inlined$items$default$4
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
                String LedgerScreen$lambda$74;
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
                final Pair pair = (Pair) $presets.get(it);
                $composer.startReplaceGroup(-781024586);
                ComposerKt.sourceInformation($composer, "C*643@30153L159,647@30354L40,641@30006L418:LedgerScreen.kt#2thlc2");
                LedgerScreen$lambda$74 = LedgerScreenKt.LedgerScreen$lambda$74($accTitle$delegate);
                boolean equals = StringsKt.equals(LedgerScreen$lambda$74, (String) pair.getFirst(), true);
                ComposerKt.sourceInformationMarkerStart($composer, -1549210550, "CC(remember):LedgerScreen.kt#9igjgp");
                boolean z = (((i & 112) ^ 48) > 32 && $composer.changed(pair)) || (i & 48) == 32;
                Object rememberedValue = $composer.rememberedValue();
                if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState = $accTitle$delegate;
                    final MutableState mutableState2 = $accCategory$delegate;
                    obj = (Function0) new Function0<Unit>() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$4$1$1$1$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mutableState.setValue(pair.getFirst());
                            mutableState2.setValue(pair.getSecond());
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ChipKt.FilterChip(equals, (Function0) obj, ComposableLambdaKt.rememberComposableLambda(-470821000, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.ui.screens.LedgerScreenKt$LedgerScreen$4$1$1$1$1$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C647@30356L36:LedgerScreen.kt#2thlc2");
                        if (($changed2 & 3) != 2 || !$composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-470821000, $changed2, -1, "com.example.ui.screens.LedgerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LedgerScreen.kt:647)");
                            }
                            TextKt.m2693Text4IGK_g(pair.getFirst(), (Modifier) null, 0L, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131062);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer2.skipToGroupEnd();
                    }
                }, $composer, 54), null, false, null, null, null, null, null, null, null, $composer, 384, 0, 4088);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$106$lambda$105(MutableState $accTitle$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $accTitle$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$118$lambda$108$lambda$107(MutableState $categoryDropdownExpanded$delegate) {
        LedgerScreen$lambda$90($categoryDropdownExpanded$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit LedgerScreen$lambda$153$lambda$152$lambda$118$lambda$110(androidx.compose.runtime.MutableState r49, androidx.compose.runtime.Composer r50, int r51) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.LedgerScreenKt.LedgerScreen$lambda$153$lambda$152$lambda$118$lambda$110(androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$118$lambda$112$lambda$111(MutableState $categoryDropdownExpanded$delegate) {
        LedgerScreen$lambda$90($categoryDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$118$lambda$117(List $categories, final MutableState $accCategory$delegate, final MutableState $categoryDropdownExpanded$delegate, ColumnScope DropdownMenu, Composer $composer, int $changed) {
        Object obj;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C*696@32790L13,697@32851L170,695@32729L326:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1299046146, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LedgerScreen.kt:694)");
            }
            Iterator it = $categories.iterator();
            while (it.hasNext()) {
                final String str = (String) it.next();
                ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1021814146, true, new Function2() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return LedgerScreenKt.LedgerScreen$lambda$153$lambda$152$lambda$118$lambda$117$lambda$116$lambda$113(str, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54);
                ComposerKt.sourceInformationMarkerStart(composer, 565433308, "CC(remember):LedgerScreen.kt#9igjgp");
                boolean changed = composer.changed(str);
                Object rememberedValue = $composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    obj = new Function0() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda44
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return LedgerScreenKt.LedgerScreen$lambda$153$lambda$152$lambda$118$lambda$117$lambda$116$lambda$115$lambda$114(str, $accCategory$delegate, $categoryDropdownExpanded$delegate);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AndroidMenu_androidKt.DropdownMenuItem(rememberComposableLambda, (Function0) obj, null, null, null, false, null, null, null, composer, 6, 508);
                composer = $composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$118$lambda$117$lambda$116$lambda$113(String $cat, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C696@32792L9:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1021814146, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LedgerScreen.kt:696)");
            }
            TextKt.m2693Text4IGK_g($cat, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$118$lambda$117$lambda$116$lambda$115$lambda$114(String $cat, MutableState $accCategory$delegate, MutableState $categoryDropdownExpanded$delegate) {
        $accCategory$delegate.setValue($cat);
        LedgerScreen$lambda$90($categoryDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$133$lambda$120$lambda$119(MutableState $accValueStr$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $accValueStr$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$133$lambda$132$lambda$122$lambda$121(MutableState $ownerDropdownExpanded$delegate) {
        LedgerScreen$lambda$93($ownerDropdownExpanded$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit LedgerScreen$lambda$153$lambda$152$lambda$133$lambda$132$lambda$124(androidx.compose.runtime.MutableState r49, androidx.compose.runtime.Composer r50, int r51) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.LedgerScreenKt.LedgerScreen$lambda$153$lambda$152$lambda$133$lambda$132$lambda$124(androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$133$lambda$132$lambda$126$lambda$125(MutableState $ownerDropdownExpanded$delegate) {
        LedgerScreen$lambda$93($ownerDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$133$lambda$132$lambda$131(List $owners, final MutableState $accOwner$delegate, final MutableState $ownerDropdownExpanded$delegate, ColumnScope DropdownMenu, Composer $composer, int $changed) {
        Object obj;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C*746@35432L11,747@35495L174,745@35367L340:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1640561826, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LedgerScreen.kt:744)");
            }
            Iterator it = $owners.iterator();
            while (it.hasNext()) {
                final String str = (String) it.next();
                ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1734776354, true, new Function2() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda70
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return LedgerScreenKt.LedgerScreen$lambda$153$lambda$152$lambda$133$lambda$132$lambda$131$lambda$130$lambda$127(str, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54);
                ComposerKt.sourceInformationMarkerStart(composer, 1474774588, "CC(remember):LedgerScreen.kt#9igjgp");
                boolean changed = composer.changed(str);
                Object rememberedValue = $composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    obj = new Function0() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda71
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return LedgerScreenKt.LedgerScreen$lambda$153$lambda$152$lambda$133$lambda$132$lambda$131$lambda$130$lambda$129$lambda$128(str, $accOwner$delegate, $ownerDropdownExpanded$delegate);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AndroidMenu_androidKt.DropdownMenuItem(rememberComposableLambda, (Function0) obj, null, null, null, false, null, null, null, composer, 6, 508);
                composer = $composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$133$lambda$132$lambda$131$lambda$130$lambda$127(String $o, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C746@35434L7:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1734776354, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LedgerScreen.kt:746)");
            }
            TextKt.m2693Text4IGK_g($o, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$133$lambda$132$lambda$131$lambda$130$lambda$129$lambda$128(String $o, MutableState $accOwner$delegate, MutableState $ownerDropdownExpanded$delegate) {
        $accOwner$delegate.setValue($o);
        LedgerScreen$lambda$93($ownerDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$135$lambda$134(MutableState $accNotes$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $accNotes$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$141$lambda$137$lambda$136(MutableState $editingAccount$delegate, MutableState $accTitle$delegate, MutableState $accValueStr$delegate, MutableState $accNotes$delegate) {
        $editingAccount$delegate.setValue(null);
        $accTitle$delegate.setValue("");
        $accValueStr$delegate.setValue("");
        $accNotes$delegate.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$141$lambda$139$lambda$138(NetWorthViewModel $viewModel, MutableState $accTitle$delegate, MutableState $accValueStr$delegate, MutableState $accCategory$delegate, MutableState $editingAccount$delegate, MutableState $accOwner$delegate, MutableState $accNotes$delegate) {
        FinancialItem itemToSave;
        if (!StringsKt.isBlank(LedgerScreen$lambda$74($accTitle$delegate))) {
            Double doubleOrNull = StringsKt.toDoubleOrNull(LedgerScreen$lambda$80($accValueStr$delegate));
            double valDouble = doubleOrNull != null ? doubleOrNull.doubleValue() : 0.0d;
            boolean z = true;
            if (!StringsKt.contains((CharSequence) LedgerScreen$lambda$77($accCategory$delegate), (CharSequence) "Loans", true) && !StringsKt.contains((CharSequence) LedgerScreen$lambda$77($accCategory$delegate), (CharSequence) "Expense", true)) {
                z = false;
            }
            boolean isLiab = z;
            if (LedgerScreen$lambda$71($editingAccount$delegate) != null) {
                FinancialItem LedgerScreen$lambda$71 = LedgerScreen$lambda$71($editingAccount$delegate);
                Intrinsics.checkNotNull(LedgerScreen$lambda$71);
                itemToSave = FinancialItem.copy$default(LedgerScreen$lambda$71, 0L, StringsKt.trim((CharSequence) LedgerScreen$lambda$74($accTitle$delegate)).toString(), null, null, LedgerScreen$lambda$83($accOwner$delegate), LedgerScreen$lambda$77($accCategory$delegate), valDouble, 0.0d, isLiab, LedgerScreen$lambda$86($accNotes$delegate), null, System.currentTimeMillis(), 1165, null);
            } else {
                itemToSave = new FinancialItem(0L, StringsKt.trim((CharSequence) LedgerScreen$lambda$74($accTitle$delegate)).toString(), null, null, LedgerScreen$lambda$83($accOwner$delegate), LedgerScreen$lambda$77($accCategory$delegate), valDouble, 0.0d, isLiab, LedgerScreen$lambda$86($accNotes$delegate), null, System.currentTimeMillis(), 1165, null);
            }
            $viewModel.saveFinancialItem(itemToSave);
            $editingAccount$delegate.setValue(null);
            $accTitle$delegate.setValue("");
            $accValueStr$delegate.setValue("");
            $accNotes$delegate.setValue("");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$141$lambda$140(MutableState $editingAccount$delegate, RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C823@39256L85,824@39370L39,825@39438L69:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1190871314, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LedgerScreen.kt:823)");
            }
            IconKt.m2150Iconww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(4)), $composer, 6);
            TextKt.m2693Text4IGK_g(LedgerScreen$lambda$71($editingAccount$delegate) == null ? "Add Account" : "Update Account", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0400 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit LedgerScreen$lambda$153$lambda$152$lambda$151$lambda$150$lambda$149(final com.example.data.model.FinancialItem r85, final androidx.compose.runtime.MutableState r86, final androidx.compose.runtime.MutableState r87, final androidx.compose.runtime.MutableState r88, final androidx.compose.runtime.MutableState r89, final androidx.compose.runtime.MutableState r90, final androidx.compose.runtime.MutableState r91, final androidx.compose.runtime.MutableState r92, androidx.compose.runtime.Composer r93, int r94) {
        /*
            Method dump skipped, instructions count: 1386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.LedgerScreenKt.LedgerScreen$lambda$153$lambda$152$lambda$151$lambda$150$lambda$149(com.example.data.model.FinancialItem, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$151$lambda$150$lambda$149$lambda$148$lambda$147$lambda$144$lambda$143(FinancialItem $acc, MutableState $editingAccount$delegate, MutableState $accTitle$delegate, MutableState $accCategory$delegate, MutableState $accValueStr$delegate, MutableState $accOwner$delegate, MutableState $accNotes$delegate) {
        $editingAccount$delegate.setValue($acc);
        $accTitle$delegate.setValue($acc.getTitle());
        $accCategory$delegate.setValue($acc.getCategory());
        $accValueStr$delegate.setValue($acc.getCurrentValue() > 0.0d ? String.valueOf($acc.getCurrentValue()) : "");
        $accOwner$delegate.setValue($acc.getOwner());
        $accNotes$delegate.setValue($acc.getNotes());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$153$lambda$152$lambda$151$lambda$150$lambda$149$lambda$148$lambda$147$lambda$146$lambda$145(FinancialItem $acc, MutableState $accountToDelete$delegate) {
        $accountToDelete$delegate.setValue($acc);
        return Unit.INSTANCE;
    }

    private static final String LedgerScreen$lambda$155(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String LedgerScreen$lambda$159(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String LedgerScreen$lambda$162(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String LedgerScreen$lambda$165(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean LedgerScreen$lambda$168(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void LedgerScreen$lambda$169(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String LedgerScreen$lambda$171(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean LedgerScreen$lambda$174(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void LedgerScreen$lambda$175(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$177$lambda$176(MutableState $showDirectLedgerDialog$delegate) {
        LedgerScreen$lambda$10($showDirectLedgerDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0712  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x07ae  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0829  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x089c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0837  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x07bc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0722  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x05b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit LedgerScreen$lambda$210(final androidx.compose.runtime.MutableState r98, final androidx.compose.runtime.MutableState r99, final androidx.compose.runtime.MutableState r100, final androidx.compose.runtime.State r101, final androidx.compose.runtime.MutableState r102, final androidx.compose.runtime.MutableState r103, final androidx.compose.runtime.MutableState r104, final androidx.compose.runtime.MutableState r105, androidx.compose.runtime.Composer r106, int r107) {
        /*
            Method dump skipped, instructions count: 2210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.LedgerScreenKt.LedgerScreen$lambda$210(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$210$lambda$209$lambda$185$lambda$184(MutableState $txTitle$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $txTitle$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$210$lambda$209$lambda$197$lambda$187$lambda$186(MutableState $primaryDropdownExpanded$delegate) {
        LedgerScreen$lambda$175($primaryDropdownExpanded$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit LedgerScreen$lambda$210$lambda$209$lambda$197$lambda$189(androidx.compose.runtime.MutableState r49, androidx.compose.runtime.Composer r50, int r51) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.LedgerScreenKt.LedgerScreen$lambda$210$lambda$209$lambda$197$lambda$189(androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$210$lambda$209$lambda$197$lambda$191$lambda$190(MutableState $primaryDropdownExpanded$delegate) {
        LedgerScreen$lambda$175($primaryDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$210$lambda$209$lambda$197$lambda$196(State $allItems$delegate, final MutableState $primaryAccount$delegate, final MutableState $primaryDropdownExpanded$delegate, ColumnScope DropdownMenu, Composer $composer, int $changed) {
        Object obj;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C*977@47929L20,978@47997L179,976@47868L342:LedgerScreen.kt#2thlc2");
        if (($changed & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-153772679, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LedgerScreen.kt:975)");
            }
            for (final FinancialItem financialItem : LedgerScreen$lambda$1($allItems$delegate)) {
                ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(788636078, true, new Function2() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return LedgerScreenKt.LedgerScreen$lambda$210$lambda$209$lambda$197$lambda$196$lambda$195$lambda$192(FinancialItem.this, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54);
                ComposerKt.sourceInformationMarkerStart(composer, -1904501647, "CC(remember):LedgerScreen.kt#9igjgp");
                boolean changed = composer.changed(financialItem);
                Object rememberedValue = $composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    obj = new Function0() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return LedgerScreenKt.LedgerScreen$lambda$210$lambda$209$lambda$197$lambda$196$lambda$195$lambda$194$lambda$193(FinancialItem.this, $primaryAccount$delegate, $primaryDropdownExpanded$delegate);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AndroidMenu_androidKt.DropdownMenuItem(rememberComposableLambda, (Function0) obj, null, null, null, false, null, null, null, composer, 6, 508);
                composer = $composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$210$lambda$209$lambda$197$lambda$196$lambda$195$lambda$192(FinancialItem $item, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C977@47931L16:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(788636078, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LedgerScreen.kt:977)");
            }
            TextKt.m2693Text4IGK_g($item.getTitle(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$210$lambda$209$lambda$197$lambda$196$lambda$195$lambda$194$lambda$193(FinancialItem $item, MutableState $primaryAccount$delegate, MutableState $primaryDropdownExpanded$delegate) {
        $primaryAccount$delegate.setValue($item.getTitle());
        LedgerScreen$lambda$175($primaryDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$210$lambda$209$lambda$199$lambda$198(MutableState $secondaryAccount$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $secondaryAccount$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$210$lambda$209$lambda$204$lambda$201$lambda$200(MutableState $isDebitPrimary$delegate) {
        LedgerScreen$lambda$169($isDebitPrimary$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$210$lambda$209$lambda$204$lambda$203$lambda$202(MutableState $isDebitPrimary$delegate) {
        LedgerScreen$lambda$169($isDebitPrimary$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$210$lambda$209$lambda$206$lambda$205(MutableState $amountStr$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $amountStr$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$210$lambda$209$lambda$208$lambda$207(MutableState $notesStr$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $notesStr$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$180(final NetWorthViewModel $viewModel, final MutableState $amountStr$delegate, final MutableState $txTitle$delegate, final MutableState $primaryAccount$delegate, final MutableState $secondaryAccount$delegate, final MutableState $isDebitPrimary$delegate, final MutableState $notesStr$delegate, final MutableState $showDirectLedgerDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C1047@51097L768,1062@51911L48,1046@51059L977:LedgerScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2086296079, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous> (LedgerScreen.kt:1046)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -819192753, "CC(remember):LedgerScreen.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($viewModel);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LedgerScreenKt.LedgerScreen$lambda$180$lambda$179$lambda$178(NetWorthViewModel.this, $amountStr$delegate, $txTitle$delegate, $primaryAccount$delegate, $secondaryAccount$delegate, $isDebitPrimary$delegate, $notesStr$delegate, $showDirectLedgerDialog$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, null, false, null, ButtonDefaults.INSTANCE.m1809buttonColorsro_MJ88(ColorKt.Color(4286331629L), 0L, 0L, 0L, $composer, (ButtonDefaults.$stable << 12) | 6, 14), null, null, null, null, ComposableSingletons$LedgerScreenKt.INSTANCE.m7049getLambda$1847177185$app(), $composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$180$lambda$179$lambda$178(NetWorthViewModel $viewModel, MutableState $amountStr$delegate, MutableState $txTitle$delegate, MutableState $primaryAccount$delegate, MutableState $secondaryAccount$delegate, MutableState $isDebitPrimary$delegate, MutableState $notesStr$delegate, MutableState $showDirectLedgerDialog$delegate) {
        Double doubleOrNull = StringsKt.toDoubleOrNull(LedgerScreen$lambda$165($amountStr$delegate));
        double amt = doubleOrNull != null ? doubleOrNull.doubleValue() : 0.0d;
        if (!StringsKt.isBlank(LedgerScreen$lambda$155($txTitle$delegate)) && !StringsKt.isBlank(LedgerScreen$lambda$159($primaryAccount$delegate)) && amt > 0.0d) {
            $viewModel.postDirectLedgerEntry(LedgerScreen$lambda$155($txTitle$delegate), LedgerScreen$lambda$159($primaryAccount$delegate), LedgerScreen$lambda$162($secondaryAccount$delegate), amt, LedgerScreen$lambda$168($isDebitPrimary$delegate), "Ledger Adjustment", LedgerScreen$lambda$171($notesStr$delegate));
            LedgerScreen$lambda$10($showDirectLedgerDialog$delegate, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$183(final MutableState $showDirectLedgerDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C1068@52119L34,1068@52098L111:LedgerScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1501524429, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous> (LedgerScreen.kt:1068)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -144033905, "CC(remember):LedgerScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LedgerScreenKt.LedgerScreen$lambda$183$lambda$182$lambda$181(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$LedgerScreenKt.INSTANCE.getLambda$901171888$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$183$lambda$182$lambda$181(MutableState $showDirectLedgerDialog$delegate) {
        LedgerScreen$lambda$10($showDirectLedgerDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$212$lambda$211(MutableState $entryToDelete$delegate) {
        $entryToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x026e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit LedgerScreen$lambda$227(final com.example.data.model.LedgerEntry r83, final double r84, final androidx.compose.runtime.MutableState r86, androidx.compose.runtime.Composer r87, int r88) {
        /*
            Method dump skipped, instructions count: 1139
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.LedgerScreenKt.LedgerScreen$lambda$227(com.example.data.model.LedgerEntry, double, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0223  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit LedgerScreen$lambda$227$lambda$226$lambda$220(com.example.data.model.LedgerEntry r51, double r52, androidx.compose.runtime.Composer r54, int r55) {
        /*
            Method dump skipped, instructions count: 553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.LedgerScreenKt.LedgerScreen$lambda$227$lambda$226$lambda$220(com.example.data.model.LedgerEntry, double, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$227$lambda$226$lambda$222$lambda$221(MutableState $adjustBalanceOnLedgerDelete$delegate) {
        LedgerScreen$lambda$16($adjustBalanceOnLedgerDelete$delegate, !LedgerScreen$lambda$15($adjustBalanceOnLedgerDelete$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223(MutableState $adjustBalanceOnLedgerDelete$delegate, boolean it) {
        LedgerScreen$lambda$16($adjustBalanceOnLedgerDelete$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$215(final NetWorthViewModel $viewModel, final LedgerEntry $target, final MutableState $adjustBalanceOnLedgerDelete$delegate, final MutableState $entryToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C1137@55351L180,1141@55621L11,1141@55577L62,1136@55313L399:LedgerScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1693150768, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous> (LedgerScreen.kt:1136)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 674719108, "CC(remember):LedgerScreen.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($viewModel) | $composer.changed($target);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LedgerScreenKt.LedgerScreen$lambda$215$lambda$214$lambda$213(NetWorthViewModel.this, $target, $adjustBalanceOnLedgerDelete$delegate, $entryToDelete$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, null, false, null, ButtonDefaults.INSTANCE.m1809buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$LedgerScreenKt.INSTANCE.m7043getLambda$1331656736$app(), $composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$215$lambda$214$lambda$213(NetWorthViewModel $viewModel, LedgerEntry $target, MutableState $adjustBalanceOnLedgerDelete$delegate, MutableState $entryToDelete$delegate) {
        $viewModel.deleteLedgerEntry($target, LedgerScreen$lambda$15($adjustBalanceOnLedgerDelete$delegate));
        $entryToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$218(final MutableState $entryToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C1147@55795L24,1147@55774L101:LedgerScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2017044878, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous> (LedgerScreen.kt:1147)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1349878534, "CC(remember):LedgerScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LedgerScreenKt.LedgerScreen$lambda$218$lambda$217$lambda$216(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$LedgerScreenKt.INSTANCE.getLambda$1416692337$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$218$lambda$217$lambda$216(MutableState $entryToDelete$delegate) {
        $entryToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$229$lambda$228(MutableState $accountToDelete$delegate) {
        $accountToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$236(FinancialItem $targetAcc, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1159@56136L44:LedgerScreen.kt#2thlc2");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1947793677, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous> (LedgerScreen.kt:1159)");
            }
            TextKt.m2693Text4IGK_g("Delete Account '" + $targetAcc.getTitle() + "'?", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$232(final NetWorthViewModel $viewModel, final FinancialItem $targetAcc, final MutableState $accountToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C1163@56397L163,1167@56650L11,1167@56606L62,1162@56359L390:LedgerScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1177630319, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous> (LedgerScreen.kt:1162)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -2126335756, "CC(remember):LedgerScreen.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($viewModel) | $composer.changed($targetAcc);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda72
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LedgerScreenKt.LedgerScreen$lambda$232$lambda$231$lambda$230(NetWorthViewModel.this, $targetAcc, $accountToDelete$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, null, false, null, ButtonDefaults.INSTANCE.m1809buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$LedgerScreenKt.INSTANCE.m7053getLambda$816136287$app(), $composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$232$lambda$231$lambda$230(NetWorthViewModel $viewModel, FinancialItem $targetAcc, MutableState $accountToDelete$delegate) {
        $viewModel.deleteFinancialItem($targetAcc, true);
        $accountToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$235(final MutableState $accountToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C1173@56832L26,1173@56811L103:LedgerScreen.kt#2thlc2");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1762401969, $changed, -1, "com.example.ui.screens.LedgerScreen.<anonymous> (LedgerScreen.kt:1173)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1451176311, "CC(remember):LedgerScreen.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.LedgerScreenKt$$ExternalSyntheticLambda67
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LedgerScreenKt.LedgerScreen$lambda$235$lambda$234$lambda$233(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$LedgerScreenKt.INSTANCE.getLambda$1932212786$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LedgerScreen$lambda$235$lambda$234$lambda$233(MutableState $accountToDelete$delegate) {
        $accountToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }
}
