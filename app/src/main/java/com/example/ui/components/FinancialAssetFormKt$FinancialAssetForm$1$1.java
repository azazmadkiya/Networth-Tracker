package com.example.ui.components;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.example.data.model.FinancialItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FinancialAssetForm.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.components.FinancialAssetFormKt$FinancialAssetForm$1$1", f = "FinancialAssetForm.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class FinancialAssetFormKt$FinancialAssetForm$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $exchangeName$delegate;
    final /* synthetic */ FinancialItem $itemToEdit;
    final /* synthetic */ MutableState<String> $marketPricePerShareStr$delegate;
    final /* synthetic */ MutableState<String> $selectedStockName$delegate;
    final /* synthetic */ MutableState<String> $selectedStockSymbol$delegate;
    final /* synthetic */ SnapshotStateList<StockQuote> $stockList;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FinancialAssetFormKt$FinancialAssetForm$1$1(FinancialItem financialItem, SnapshotStateList<StockQuote> snapshotStateList, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, Continuation<? super FinancialAssetFormKt$FinancialAssetForm$1$1> continuation) {
        super(2, continuation);
        this.$itemToEdit = financialItem;
        this.$stockList = snapshotStateList;
        this.$selectedStockSymbol$delegate = mutableState;
        this.$selectedStockName$delegate = mutableState2;
        this.$marketPricePerShareStr$delegate = mutableState3;
        this.$exchangeName$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FinancialAssetFormKt$FinancialAssetForm$1$1(this.$itemToEdit, this.$stockList, this.$selectedStockSymbol$delegate, this.$selectedStockName$delegate, this.$marketPricePerShareStr$delegate, this.$exchangeName$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FinancialAssetFormKt$FinancialAssetForm$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        StockQuote stockQuote;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$itemToEdit != null && (StringsKt.contains((CharSequence) this.$itemToEdit.getCategory(), (CharSequence) "Share Market", true) || StringsKt.contains((CharSequence) this.$itemToEdit.getCategory(), (CharSequence) "Stocks", true))) {
                    Iterable split$default = StringsKt.split$default((CharSequence) this.$itemToEdit.getTitle(), new String[]{"-"}, false, 0, 6, (Object) null);
                    Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
                    Iterator it = split$default.iterator();
                    while (it.hasNext()) {
                        arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
                    }
                    List titleParts = (List) arrayList;
                    if (!titleParts.isEmpty()) {
                        String symbol = ((String) titleParts.get(0)).toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(symbol, "toUpperCase(...)");
                        String name = titleParts.size() > 1 ? (String) titleParts.get(1) : symbol;
                        Iterator<StockQuote> it2 = this.$stockList.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                stockQuote = it2.next();
                                if (Intrinsics.areEqual(stockQuote.getSymbol(), symbol)) {
                                }
                            } else {
                                stockQuote = null;
                            }
                        }
                        StockQuote currentStock = stockQuote;
                        if (currentStock == null) {
                            double price = this.$itemToEdit.getCurrentValue() > 0.0d ? this.$itemToEdit.getCurrentValue() / 10.0d : 100.0d;
                            StockQuote newQuote = new StockQuote(symbol, name, "NSE", price, 1.0d, true);
                            this.$stockList.add(0, newQuote);
                            this.$selectedStockSymbol$delegate.setValue(symbol);
                            this.$selectedStockName$delegate.setValue(name);
                            MutableState<String> mutableState = this.$marketPricePerShareStr$delegate;
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String format = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Boxing.boxDouble(price)}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                            mutableState.setValue(format);
                        } else {
                            this.$selectedStockSymbol$delegate.setValue(currentStock.getSymbol());
                            this.$selectedStockName$delegate.setValue(currentStock.getName());
                            this.$exchangeName$delegate.setValue(currentStock.getExchange());
                            MutableState<String> mutableState2 = this.$marketPricePerShareStr$delegate;
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                            String format2 = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Boxing.boxDouble(currentStock.getCurrentPrice())}, 1));
                            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                            mutableState2.setValue(format2);
                        }
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
