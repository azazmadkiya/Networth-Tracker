package com.example.ui.viewmodel;

import com.example.data.model.FinancialItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NetWorthViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/example/ui/viewmodel/NetWorthSummary;", "items", "", "Lcom/example/data/model/FinancialItem;", "owner", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.viewmodel.NetWorthViewModel$summary$1", f = "NetWorthViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class NetWorthViewModel$summary$1 extends SuspendLambda implements Function3<List<? extends FinancialItem>, String, Continuation<? super NetWorthSummary>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ NetWorthViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetWorthViewModel$summary$1(NetWorthViewModel netWorthViewModel, Continuation<? super NetWorthViewModel$summary$1> continuation) {
        super(3, continuation);
        this.this$0 = netWorthViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(List<? extends FinancialItem> list, String str, Continuation<? super NetWorthSummary> continuation) {
        return invoke2((List<FinancialItem>) list, str, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<FinancialItem> list, String str, Continuation<? super NetWorthSummary> continuation) {
        NetWorthViewModel$summary$1 netWorthViewModel$summary$1 = new NetWorthViewModel$summary$1(this.this$0, continuation);
        netWorthViewModel$summary$1.L$0 = list;
        netWorthViewModel$summary$1.L$1 = str;
        return netWorthViewModel$summary$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        List relevantItems;
        boolean isStockCategory;
        List items = (List) this.L$0;
        String owner = (String) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (Intrinsics.areEqual(owner, "All")) {
                    relevantItems = items;
                } else {
                    Collection arrayList = new ArrayList();
                    for (Object obj : items) {
                        if (StringsKt.equals(((FinancialItem) obj).getOwner(), owner, true)) {
                            arrayList.add(obj);
                        }
                    }
                    relevantItems = (List) arrayList;
                }
                double currentValForInvested = 0.0d;
                double stockInvested = 0.0d;
                Iterator it = relevantItems.iterator();
                double assets = 0.0d;
                double liabilities = 0.0d;
                double invested = 0.0d;
                double stockWorth = 0.0d;
                while (true) {
                    if (it.hasNext()) {
                        FinancialItem item = (FinancialItem) it.next();
                        if (item.isLiability()) {
                            liabilities += item.getCurrentValue();
                        } else {
                            assets += item.getCurrentValue();
                            if (item.getInvestedValue() > 0.0d) {
                                invested += item.getInvestedValue();
                                currentValForInvested += item.getCurrentValue();
                            }
                            isStockCategory = this.this$0.isStockCategory(item.getCategory());
                            if (isStockCategory) {
                                stockWorth += item.getCurrentValue();
                                if (item.getInvestedValue() > 0.0d) {
                                    stockInvested += item.getInvestedValue();
                                }
                            }
                        }
                    } else {
                        double netWorth = assets - liabilities;
                        double profitLoss = currentValForInvested - invested;
                        double profitLossPct = invested > 0.0d ? 100.0d * (profitLoss / invested) : 0.0d;
                        double stockPnl = stockWorth - stockInvested;
                        return new NetWorthSummary(assets, liabilities, netWorth, invested, profitLoss, profitLossPct, stockWorth, stockPnl);
                    }
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
