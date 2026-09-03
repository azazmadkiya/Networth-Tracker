package com.example.ui.viewmodel;

import com.example.data.model.FinancialItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NetWorthViewModel.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "", "Lcom/example/data/model/FinancialItem;", "items", "<unused var>", "", "isLive", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.viewmodel.NetWorthViewModel$liveItems$1", f = "NetWorthViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class NetWorthViewModel$liveItems$1 extends SuspendLambda implements Function4<List<? extends FinancialItem>, Integer, Boolean, Continuation<? super List<? extends FinancialItem>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ NetWorthViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetWorthViewModel$liveItems$1(NetWorthViewModel netWorthViewModel, Continuation<? super NetWorthViewModel$liveItems$1> continuation) {
        super(4, continuation);
        this.this$0 = netWorthViewModel;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(List<? extends FinancialItem> list, Integer num, Boolean bool, Continuation<? super List<? extends FinancialItem>> continuation) {
        return invoke((List<FinancialItem>) list, num.intValue(), bool.booleanValue(), (Continuation<? super List<FinancialItem>>) continuation);
    }

    public final Object invoke(List<FinancialItem> list, int i, boolean z, Continuation<? super List<FinancialItem>> continuation) {
        NetWorthViewModel$liveItems$1 netWorthViewModel$liveItems$1 = new NetWorthViewModel$liveItems$1(this.this$0, continuation);
        netWorthViewModel$liveItems$1.L$0 = list;
        netWorthViewModel$liveItems$1.Z$0 = z;
        return netWorthViewModel$liveItems$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        boolean isStockCategory;
        String parseStockSymbol;
        Double stockPriceFromGlobalList;
        Map map;
        Object obj;
        Iterable items = (List) this.L$0;
        boolean isLive = this.Z$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!isLive) {
                    return items;
                }
                Iterable<FinancialItem> iterable = items;
                NetWorthViewModel netWorthViewModel = this.this$0;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (FinancialItem financialItem : iterable) {
                    isStockCategory = netWorthViewModel.isStockCategory(financialItem.getCategory());
                    if (isStockCategory) {
                        parseStockSymbol = netWorthViewModel.parseStockSymbol(financialItem.getTitle());
                        if (!StringsKt.isBlank(parseStockSymbol)) {
                            stockPriceFromGlobalList = netWorthViewModel.getStockPriceFromGlobalList(parseStockSymbol);
                            if (stockPriceFromGlobalList != null && stockPriceFromGlobalList.doubleValue() > 0.0d) {
                                map = netWorthViewModel.initialStockPrices;
                                String upperCase = parseStockSymbol.toUpperCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                                Object obj2 = map.get(upperCase);
                                if (obj2 == null) {
                                    obj = Boxing.boxDouble(stockPriceFromGlobalList.doubleValue());
                                    map.put(upperCase, obj);
                                } else {
                                    obj = obj2;
                                }
                                double doubleValue = ((Number) obj).doubleValue();
                                financialItem = FinancialItem.copy$default(financialItem, 0L, null, null, null, null, null, financialItem.getCurrentValue() * (doubleValue > 0.0d ? stockPriceFromGlobalList.doubleValue() / doubleValue : 1.0d), 0.0d, false, null, null, 0L, 4031, null);
                            }
                        }
                    }
                    arrayList.add(financialItem);
                }
                return (List) arrayList;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
