package com.example.ui.viewmodel;

import android.app.Application;
import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationRequestCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.data.db.AppDatabase;
import com.example.data.model.FinancialItem;
import com.example.data.model.FinancialReminder;
import com.example.data.model.LedgerEntry;
import com.example.data.model.NetWorthSnapshot;
import com.example.data.repository.NetWorthRepository;
import com.example.data.security.AuthManager;
import com.example.ui.components.FinancialAssetFormKt;
import com.example.ui.components.StockQuote;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;

/* compiled from: NetWorthViewModel.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020*J\b\u0010,\u001a\u00020*H\u0002J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u001cH\u0002J\u0010\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u001cH\u0002J\u0017\u00106\u001a\u0004\u0018\u00010(2\u0006\u00107\u001a\u00020\u001cH\u0002¢\u0006\u0002\u00108J\u0016\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ\u0006\u0010J\u001a\u00020*J\u000e\u0010K\u001a\u00020*2\u0006\u0010L\u001a\u00020.J>\u0010M\u001a\u00020*2\u0006\u00105\u001a\u00020\u001c2\u0006\u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020\u00102\u0006\u0010R\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\u001cJ\u0006\u0010T\u001a\u00020*J \u0010U\u001a\u00020*2\u0006\u0010L\u001a\u00020.2\u0006\u0010V\u001a\u00020(2\b\b\u0002\u0010W\u001a\u00020\u001cJ\u0018\u0010X\u001a\u00020*2\u0006\u0010Y\u001a\u00020\u00152\b\b\u0002\u0010U\u001a\u00020\u0010J\u0018\u0010Z\u001a\u00020*2\u0006\u0010L\u001a\u00020.2\b\b\u0002\u0010[\u001a\u00020\u0010J\u0010\u0010\\\u001a\u00020*2\b\b\u0002\u0010]\u001a\u00020\u001cJ\u000e\u0010^\u001a\u00020*2\u0006\u0010_\u001a\u00020:J\u0006\u0010`\u001a\u00020*J\u000e\u0010a\u001a\u00020*2\u0006\u0010b\u001a\u00020\u0019J\u000e\u0010c\u001a\u00020*2\u0006\u0010b\u001a\u00020\u0019J\u0016\u0010d\u001a\u00020*2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020\u0010J\u0006\u0010h\u001a\u00020\u001cJ,\u0010i\u001a\u00020*2\u0006\u0010j\u001a\u00020\u001c2\b\b\u0002\u0010k\u001a\u00020\u00102\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020*0mJ$\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\u00140o*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00140\u0013H\u0002J$\u0010p\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u00140o*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00140\u0013H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0011R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0011R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020(0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0017R\u001d\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0017R\u001d\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0017R\u001d\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0017R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0013¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0017R\u001d\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0017R\u001d\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0017¨\u0006q"}, d2 = {"Lcom/example/ui/viewmodel/NetWorthViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "database", "Lcom/example/data/db/AppDatabase;", "repository", "Lcom/example/data/repository/NetWorthRepository;", "authManager", "Lcom/example/data/security/AuthManager;", "getAuthManager", "()Lcom/example/data/security/AuthManager;", "isLoggedIn", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "allLedgerEntries", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/data/model/LedgerEntry;", "getAllLedgerEntries", "()Lkotlinx/coroutines/flow/StateFlow;", "allReminders", "Lcom/example/data/model/FinancialReminder;", "getAllReminders", "selectedOwnerFilter", "", "getSelectedOwnerFilter", "selectedCategoryFilter", "getSelectedCategoryFilter", "searchQuery", "getSearchQuery", "isLiveStockTracking", "liveTickCount", "", "getLiveTickCount", "initialStockPrices", "", "", "toggleLiveStockTracking", "", "triggerLiveStockRefresh", "tickLiveStockPrices", "allItems", "Lcom/example/data/model/FinancialItem;", "getAllItems", "liveItems", "getLiveItems", "isStockCategory", "cat", "parseStockSymbol", "title", "getStockPriceFromGlobalList", "symbol", "(Ljava/lang/String;)Ljava/lang/Double;", "snapshots", "Lcom/example/data/model/NetWorthSnapshot;", "getSnapshots", "filteredItems", "getFilteredItems", "summary", "Lcom/example/ui/viewmodel/NetWorthSummary;", "getSummary", "categorySummaries", "Lcom/example/ui/viewmodel/CategorySummary;", "getCategorySummaries", "ownerSummaries", "Lcom/example/ui/viewmodel/OwnerSummary;", "getOwnerSummaries", "login", "idInput", "passwordInput", "logout", "saveFinancialItem", "item", "postDirectLedgerEntry", "primaryAccount", "secondaryAccount", "amount", "isDebitPrimary", "category", "notes", "refreshAndRecalculateAll", "adjustAccountBalance", "newAmount", "reason", "deleteLedgerEntry", "entry", "deleteFinancialItem", "adjustLinkedAccount", "recordSnapshot", "note", "deleteSnapshot", "snapshot", "clearAllData", "saveReminder", NotificationCompat.CATEGORY_REMINDER, "deleteReminder", "setReminderCompleted", "id", "", "completed", "exportBackupJson", "importBackupJson", "jsonStr", "clearExisting", "onResult", "Lkotlin/Function1;", "mapToCategorySummaries", "Lkotlinx/coroutines/flow/Flow;", "mapToOwnerSummaries", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class NetWorthViewModel extends AndroidViewModel {
    public static final int $stable = 8;
    private final StateFlow<List<FinancialItem>> allItems;
    private final StateFlow<List<LedgerEntry>> allLedgerEntries;
    private final StateFlow<List<FinancialReminder>> allReminders;
    private final AuthManager authManager;
    private final StateFlow<List<CategorySummary>> categorySummaries;
    private final AppDatabase database;
    private final StateFlow<List<FinancialItem>> filteredItems;
    private final Map<String, Double> initialStockPrices;
    private final MutableStateFlow<Boolean> isLiveStockTracking;
    private final MutableStateFlow<Boolean> isLoggedIn;
    private final StateFlow<List<FinancialItem>> liveItems;
    private final MutableStateFlow<Integer> liveTickCount;
    private final StateFlow<List<OwnerSummary>> ownerSummaries;
    private final NetWorthRepository repository;
    private final MutableStateFlow<String> searchQuery;
    private final MutableStateFlow<String> selectedCategoryFilter;
    private final MutableStateFlow<String> selectedOwnerFilter;
    private final StateFlow<List<NetWorthSnapshot>> snapshots;
    private final StateFlow<NetWorthSummary> summary;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetWorthViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.database = AppDatabase.INSTANCE.getInstance(application);
        this.repository = new NetWorthRepository(this.database.financialItemDao(), this.database.snapshotDao(), this.database.ledgerDao(), this.database.reminderDao());
        this.authManager = new AuthManager(application);
        this.isLoggedIn = StateFlowKt.MutableStateFlow(Boolean.valueOf(this.authManager.isLoggedIn()));
        this.allLedgerEntries = FlowKt.stateIn(this.repository.getAllLedgerEntries(), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 5000L, 0L, 2, null), CollectionsKt.emptyList());
        this.allReminders = FlowKt.stateIn(this.repository.getAllReminders(), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 5000L, 0L, 2, null), CollectionsKt.emptyList());
        this.selectedOwnerFilter = StateFlowKt.MutableStateFlow("All");
        this.selectedCategoryFilter = StateFlowKt.MutableStateFlow("All");
        this.searchQuery = StateFlowKt.MutableStateFlow("");
        this.isLiveStockTracking = StateFlowKt.MutableStateFlow(false);
        this.liveTickCount = StateFlowKt.MutableStateFlow(0);
        this.initialStockPrices = MapsKt.mutableMapOf(TuplesKt.to("RELIANCE", Double.valueOf(2980.5d)), TuplesKt.to("TCS", Double.valueOf(4210.0d)), TuplesKt.to("INFY", Double.valueOf(1840.25d)), TuplesKt.to("HDFCBANK", Double.valueOf(1655.0d)), TuplesKt.to("TATAMOTORS", Double.valueOf(1035.0d)), TuplesKt.to("ICICIBANK", Double.valueOf(1210.0d)), TuplesKt.to("SBIN", Double.valueOf(845.5d)), TuplesKt.to("ITC", Double.valueOf(495.0d)), TuplesKt.to("BHARTIARTL", Double.valueOf(1480.0d)), TuplesKt.to("LTIM", Double.valueOf(5620.0d)), TuplesKt.to("AAPL", Double.valueOf(228.5d)), TuplesKt.to("GOOGL", Double.valueOf(178.2d)), TuplesKt.to("NVDA", Double.valueOf(128.4d)), TuplesKt.to("MSFT", Double.valueOf(448.2d)), TuplesKt.to("TSLA", Double.valueOf(215.3d)));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        this.allItems = FlowKt.stateIn(this.repository.getAllItems(), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 5000L, 0L, 2, null), CollectionsKt.emptyList());
        this.liveItems = FlowKt.stateIn(FlowKt.combine(this.allItems, this.liveTickCount, this.isLiveStockTracking, new NetWorthViewModel$liveItems$1(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 5000L, 0L, 2, null), CollectionsKt.emptyList());
        this.snapshots = FlowKt.stateIn(this.repository.getAllSnapshots(), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 5000L, 0L, 2, null), CollectionsKt.emptyList());
        this.filteredItems = FlowKt.stateIn(FlowKt.combine(this.liveItems, this.selectedOwnerFilter, this.selectedCategoryFilter, this.searchQuery, new NetWorthViewModel$filteredItems$1(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 5000L, 0L, 2, null), CollectionsKt.emptyList());
        this.summary = FlowKt.stateIn(FlowKt.combine(this.liveItems, this.selectedOwnerFilter, new NetWorthViewModel$summary$1(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 5000L, 0L, 2, null), new NetWorthSummary(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 255, null));
        this.categorySummaries = FlowKt.stateIn(mapToCategorySummaries(this.liveItems), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 5000L, 0L, 2, null), CollectionsKt.emptyList());
        this.ownerSummaries = FlowKt.stateIn(mapToOwnerSummaries(this.liveItems), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 5000L, 0L, 2, null), CollectionsKt.emptyList());
    }

    public final AuthManager getAuthManager() {
        return this.authManager;
    }

    public final MutableStateFlow<Boolean> isLoggedIn() {
        return this.isLoggedIn;
    }

    public final StateFlow<List<LedgerEntry>> getAllLedgerEntries() {
        return this.allLedgerEntries;
    }

    public final StateFlow<List<FinancialReminder>> getAllReminders() {
        return this.allReminders;
    }

    public final MutableStateFlow<String> getSelectedOwnerFilter() {
        return this.selectedOwnerFilter;
    }

    public final MutableStateFlow<String> getSelectedCategoryFilter() {
        return this.selectedCategoryFilter;
    }

    public final MutableStateFlow<String> getSearchQuery() {
        return this.searchQuery;
    }

    public final MutableStateFlow<Boolean> isLiveStockTracking() {
        return this.isLiveStockTracking;
    }

    public final MutableStateFlow<Integer> getLiveTickCount() {
        return this.liveTickCount;
    }

    /* compiled from: NetWorthViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.ui.viewmodel.NetWorthViewModel$1", f = "NetWorthViewModel.kt", i = {0}, l = {LocationRequestCompat.QUALITY_LOW_POWER}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    /* renamed from: com.example.ui.viewmodel.NetWorthViewModel$1, reason: invalid class name */
    /* loaded from: classes8.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0032 -> B:7:0x0035). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r6.label
                switch(r2) {
                    case 0: goto L1a;
                    case 1: goto L15;
                    default: goto Ld;
                }
            Ld:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L15:
                kotlin.ResultKt.throwOnFailure(r7)
                r2 = r6
                goto L35
            L1a:
                kotlin.ResultKt.throwOnFailure(r7)
                r2 = r6
            L1e:
                boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r0)
                if (r3 == 0) goto L4d
                r3 = r2
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r2.L$0 = r0
                r4 = 1
                r2.label = r4
                r4 = 5000(0x1388, double:2.4703E-320)
                java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r4, r3)
                if (r3 != r1) goto L35
                return r1
            L35:
                com.example.ui.viewmodel.NetWorthViewModel r3 = com.example.ui.viewmodel.NetWorthViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r3 = r3.isLiveStockTracking()
                java.lang.Object r3 = r3.getValue()
                java.lang.Boolean r3 = (java.lang.Boolean) r3
                boolean r3 = r3.booleanValue()
                if (r3 == 0) goto L1e
                com.example.ui.viewmodel.NetWorthViewModel r3 = com.example.ui.viewmodel.NetWorthViewModel.this
                com.example.ui.viewmodel.NetWorthViewModel.access$tickLiveStockPrices(r3)
                goto L1e
            L4d:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.ui.viewmodel.NetWorthViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void toggleLiveStockTracking() {
        this.isLiveStockTracking.setValue(Boolean.valueOf(!this.isLiveStockTracking.getValue().booleanValue()));
    }

    public final void triggerLiveStockRefresh() {
        tickLiveStockPrices();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void tickLiveStockPrices() {
        int i;
        Object obj;
        int i2 = 1;
        try {
            if (!FinancialAssetFormKt.getGLOBAL_STOCK_LIST().isEmpty()) {
                int i3 = 0;
                int size = FinancialAssetFormKt.getGLOBAL_STOCK_LIST().size();
                while (i3 < size) {
                    StockQuote item = FinancialAssetFormKt.getGLOBAL_STOCK_LIST().get(i3);
                    String sym = item.getSymbol();
                    String name = item.getName();
                    String exch = item.getExchange();
                    double curPrice = item.getCurrentPrice();
                    double deltaPercent = RangesKt.random(new IntRange(-60, 60), Random.INSTANCE) / 100.0d;
                    double newPrice = RangesKt.coerceAtLeast(((deltaPercent / 100.0d) + 1.0d) * curPrice, 1.0d);
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(newPrice)}, i2));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    double formattedPrice = Double.parseDouble(format);
                    Map map = this.initialStockPrices;
                    String upperCase = sym.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    Object obj2 = map.get(upperCase);
                    if (obj2 == null) {
                        Double valueOf = Double.valueOf(formattedPrice);
                        i = i2;
                        try {
                            map.put(upperCase, valueOf);
                            obj = valueOf;
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            MutableStateFlow<Integer> mutableStateFlow = this.liveTickCount;
                            mutableStateFlow.setValue(Integer.valueOf(mutableStateFlow.getValue().intValue() + 1));
                        }
                    } else {
                        i = i2;
                        obj = obj2;
                    }
                    double baseP = ((Number) obj).doubleValue();
                    double overallChangePct = baseP > 0.0d ? ((formattedPrice - baseP) / baseP) * 100.0d : deltaPercent;
                    FinancialAssetFormKt.getGLOBAL_STOCK_LIST().set(i3, new StockQuote(sym, name, exch, formattedPrice, overallChangePct, overallChangePct >= 0.0d ? i : 0));
                    i3++;
                    i2 = i;
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        MutableStateFlow<Integer> mutableStateFlow2 = this.liveTickCount;
        mutableStateFlow2.setValue(Integer.valueOf(mutableStateFlow2.getValue().intValue() + 1));
    }

    public final StateFlow<List<FinancialItem>> getAllItems() {
        return this.allItems;
    }

    public final StateFlow<List<FinancialItem>> getLiveItems() {
        return this.liveItems;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isStockCategory(String cat) {
        return StringsKt.contains((CharSequence) cat, (CharSequence) "Share Market", true) || StringsKt.contains((CharSequence) cat, (CharSequence) "Stocks", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String parseStockSymbol(String title) {
        Iterable split$default = StringsKt.split$default((CharSequence) title, new String[]{"-"}, false, 0, 6, (Object) null);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        List parts = (List) arrayList;
        if (parts.isEmpty()) {
            return "";
        }
        String upperCase = ((String) parts.get(0)).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Double getStockPriceFromGlobalList(String symbol) {
        StockQuote stockQuote;
        Iterator<StockQuote> it = FinancialAssetFormKt.getGLOBAL_STOCK_LIST().iterator();
        while (true) {
            if (!it.hasNext()) {
                stockQuote = null;
                break;
            }
            stockQuote = it.next();
            if (StringsKt.equals(stockQuote.getSymbol(), symbol, true)) {
                break;
            }
        }
        StockQuote stockQuote2 = stockQuote;
        if (stockQuote2 != null) {
            return Double.valueOf(stockQuote2.getCurrentPrice());
        }
        return null;
    }

    public final StateFlow<List<NetWorthSnapshot>> getSnapshots() {
        return this.snapshots;
    }

    public final StateFlow<List<FinancialItem>> getFilteredItems() {
        return this.filteredItems;
    }

    public final StateFlow<NetWorthSummary> getSummary() {
        return this.summary;
    }

    public final StateFlow<List<CategorySummary>> getCategorySummaries() {
        return this.categorySummaries;
    }

    public final StateFlow<List<OwnerSummary>> getOwnerSummaries() {
        return this.ownerSummaries;
    }

    public final boolean login(String idInput, String passwordInput) {
        Intrinsics.checkNotNullParameter(idInput, "idInput");
        Intrinsics.checkNotNullParameter(passwordInput, "passwordInput");
        boolean success = this.authManager.validateLogin(idInput, passwordInput);
        if (success) {
            this.isLoggedIn.setValue(true);
        }
        return success;
    }

    public final void logout() {
        this.authManager.logout();
        this.isLoggedIn.setValue(false);
    }

    public final void saveFinancialItem(FinancialItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new NetWorthViewModel$saveFinancialItem$1(item, this, null), 3, null);
    }

    public final void postDirectLedgerEntry(String title, String primaryAccount, String secondaryAccount, double amount, boolean isDebitPrimary, String category, String notes) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(primaryAccount, "primaryAccount");
        Intrinsics.checkNotNullParameter(secondaryAccount, "secondaryAccount");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(notes, "notes");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new NetWorthViewModel$postDirectLedgerEntry$1(this, isDebitPrimary, amount, secondaryAccount, title, primaryAccount, category, notes, null), 3, null);
    }

    public final void refreshAndRecalculateAll() {
        tickLiveStockPrices();
        MutableStateFlow<Integer> mutableStateFlow = this.liveTickCount;
        mutableStateFlow.setValue(Integer.valueOf(mutableStateFlow.getValue().intValue() + 1));
    }

    public static /* synthetic */ void adjustAccountBalance$default(NetWorthViewModel netWorthViewModel, FinancialItem financialItem, double d, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "Balance Refresh / Adjustment";
        }
        netWorthViewModel.adjustAccountBalance(financialItem, d, str);
    }

    public final void adjustAccountBalance(FinancialItem item, double newAmount, String reason) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reason, "reason");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new NetWorthViewModel$adjustAccountBalance$1(item, newAmount, this, reason, null), 3, null);
    }

    public static /* synthetic */ void deleteLedgerEntry$default(NetWorthViewModel netWorthViewModel, LedgerEntry ledgerEntry, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        netWorthViewModel.deleteLedgerEntry(ledgerEntry, z);
    }

    public final void deleteLedgerEntry(LedgerEntry entry, boolean adjustAccountBalance) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new NetWorthViewModel$deleteLedgerEntry$1(adjustAccountBalance, this, entry, null), 3, null);
    }

    public static /* synthetic */ void deleteFinancialItem$default(NetWorthViewModel netWorthViewModel, FinancialItem financialItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        netWorthViewModel.deleteFinancialItem(financialItem, z);
    }

    public final void deleteFinancialItem(FinancialItem item, boolean adjustLinkedAccount) {
        Intrinsics.checkNotNullParameter(item, "item");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new NetWorthViewModel$deleteFinancialItem$1(adjustLinkedAccount, item, this, null), 3, null);
    }

    public static /* synthetic */ void recordSnapshot$default(NetWorthViewModel netWorthViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Routine Snapshot";
        }
        netWorthViewModel.recordSnapshot(str);
    }

    public final void recordSnapshot(String note) {
        Intrinsics.checkNotNullParameter(note, "note");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new NetWorthViewModel$recordSnapshot$1(this, note, null), 3, null);
    }

    public final void deleteSnapshot(NetWorthSnapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new NetWorthViewModel$deleteSnapshot$1(this, snapshot, null), 3, null);
    }

    public final void clearAllData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new NetWorthViewModel$clearAllData$1(this, null), 3, null);
    }

    public final void saveReminder(FinancialReminder reminder) {
        Intrinsics.checkNotNullParameter(reminder, "reminder");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new NetWorthViewModel$saveReminder$1(reminder, this, null), 3, null);
    }

    public final void deleteReminder(FinancialReminder reminder) {
        Intrinsics.checkNotNullParameter(reminder, "reminder");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new NetWorthViewModel$deleteReminder$1(this, reminder, null), 3, null);
    }

    public final void setReminderCompleted(long id, boolean completed) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new NetWorthViewModel$setReminderCompleted$1(this, id, completed, null), 3, null);
    }

    public final String exportBackupJson() {
        return this.repository.exportToJson(this.allItems.getValue(), this.snapshots.getValue(), this.allLedgerEntries.getValue(), this.allReminders.getValue());
    }

    public static /* synthetic */ void importBackupJson$default(NetWorthViewModel netWorthViewModel, String str, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        netWorthViewModel.importBackupJson(str, z, function1);
    }

    public final void importBackupJson(String jsonStr, boolean clearExisting, Function1<? super Boolean, Unit> onResult) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new NetWorthViewModel$importBackupJson$1(this, jsonStr, clearExisting, onResult, null), 3, null);
    }

    private final Flow<List<CategorySummary>> mapToCategorySummaries(final StateFlow<? extends List<FinancialItem>> stateFlow) {
        return new Flow<List<CategorySummary>>() {
            @Override
            public Object collect(final FlowCollector<? super List<CategorySummary>> flowCollector, Continuation<? super Unit> completion) {
                return ((Flow) stateFlow).collect(new FlowCollector() {
                    @Override
                    public Object emit(Object value, Continuation continuation) {
                        List items = (List) value;
                        double totalAssets = 0.0d;
                        for (Object obj : items) {
                            FinancialItem item = (FinancialItem) obj;
                            if (!item.isLiability()) {
                                totalAssets += item.getCurrentValue();
                            }
                        }
                        Map<String, List<FinancialItem>> grouped = new LinkedHashMap<>();
                        for (Object obj : items) {
                            FinancialItem item = (FinancialItem) obj;
                            List<FinancialItem> list = grouped.get(item.getCategory());
                            if (list == null) {
                                list = new ArrayList<>();
                                grouped.put(item.getCategory(), list);
                            }
                            list.add(item);
                        }
                        List<CategorySummary> summaries = new ArrayList<>();
                        for (Map.Entry<String, List<FinancialItem>> entry : grouped.entrySet()) {
                            String category = entry.getKey();
                            List<FinancialItem> catItems = entry.getValue();
                            double totalVal = 0.0d;
                            boolean isLiability = false;
                            for (FinancialItem it : catItems) {
                                totalVal += it.getCurrentValue();
                                if (it.isLiability()) {
                                    isLiability = true;
                                }
                            }
                            float pct = totalAssets > 0.0d ? (float) ((totalVal / totalAssets) * 100.0d) : 0.0f;
                            summaries.add(new CategorySummary(category, totalVal, pct, isLiability));
                        }
                        Collections.sort(summaries, new Comparator<CategorySummary>() {
                            @Override
                            public int compare(CategorySummary o1, CategorySummary o2) {
                                return Double.compare(o2.getTotalValue(), o1.getTotalValue());
                            }
                        });
                        return flowCollector.emit(summaries, continuation);
                    }
                }, completion);
            }
        };
    }

    private final Flow<List<OwnerSummary>> mapToOwnerSummaries(final StateFlow<? extends List<FinancialItem>> stateFlow) {
        return new Flow<List<OwnerSummary>>() {
            @Override
            public Object collect(final FlowCollector<? super List<OwnerSummary>> flowCollector, Continuation<? super Unit> completion) {
                return ((Flow) stateFlow).collect(new FlowCollector() {
                    @Override
                    public Object emit(Object value, Continuation continuation) {
                        List items = (List) value;
                        double grandTotalAssets = 0.0d;
                        double grandTotalLiabilities = 0.0d;
                        for (Object obj : items) {
                            FinancialItem item = (FinancialItem) obj;
                            if (item.isLiability()) {
                                grandTotalLiabilities += item.getCurrentValue();
                            } else {
                                grandTotalAssets += item.getCurrentValue();
                            }
                        }
                        double grandTotalNetWorth = grandTotalAssets - grandTotalLiabilities;

                        Map<String, List<FinancialItem>> grouped = new LinkedHashMap<>();
                        for (Object obj : items) {
                            FinancialItem item = (FinancialItem) obj;
                            String owner = item.getOwner();
                            List<FinancialItem> list = grouped.get(owner);
                            if (list == null) {
                                list = new ArrayList<>();
                                grouped.put(owner, list);
                            }
                            list.add(item);
                        }
                        List<OwnerSummary> summaries = new ArrayList<>();
                        for (Map.Entry<String, List<FinancialItem>> entry : grouped.entrySet()) {
                            String owner = entry.getKey();
                            List<FinancialItem> ownerItems = entry.getValue();
                            double ownerAssets = 0.0d;
                            double ownerLiabilities = 0.0d;
                            double stockWorth = 0.0d;
                            double stockInvested = 0.0d;
                            for (FinancialItem it : ownerItems) {
                                if (it.isLiability()) {
                                    ownerLiabilities += it.getCurrentValue();
                                } else {
                                    ownerAssets += it.getCurrentValue();
                                    if (NetWorthViewModel.this.isStockCategory(it.getCategory())) {
                                        stockWorth += it.getCurrentValue();
                                        if (it.getInvestedValue() > 0.0d) {
                                            stockInvested += it.getInvestedValue();
                                        }
                                    }
                                }
                            }
                            double netWorth = ownerAssets - ownerLiabilities;
                            float pct = grandTotalNetWorth > 0.0d ? (float) ((netWorth / grandTotalNetWorth) * 100.0d) : 0.0f;
                            double stockPnl = stockWorth - stockInvested;
                            summaries.add(new OwnerSummary(owner, ownerAssets, ownerLiabilities, netWorth, pct, stockWorth, stockPnl));
                        }
                        Collections.sort(summaries, new Comparator<OwnerSummary>() {
                            @Override
                            public int compare(OwnerSummary o1, OwnerSummary o2) {
                                return Double.compare(o2.getNetWorth(), o1.getNetWorth());
                            }
                        });
                        return flowCollector.emit(summaries, continuation);
                    }
                }, completion);
            }
        };
    }
}
