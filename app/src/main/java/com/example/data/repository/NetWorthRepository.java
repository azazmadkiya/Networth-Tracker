package com.example.data.repository;

import androidx.core.app.NotificationCompat;
import com.example.data.dao.FinancialItemDao;
import com.example.data.dao.LedgerDao;
import com.example.data.dao.ReminderDao;
import com.example.data.dao.SnapshotDao;
import com.example.data.model.FinancialItem;
import com.example.data.model.FinancialReminder;
import com.example.data.model.LedgerEntry;
import com.example.data.model.NetWorthSnapshot;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: NetWorthRepository.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001eJ\u0016\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010$J\u001e\u0010%\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u001a\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000e0\r2\u0006\u0010*\u001a\u00020+J\u0016\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020 2\u0006\u0010-\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010.J\u001a\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u00101\u001a\u00020+J\u0016\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u00104J\u0016\u00105\u001a\u00020 2\u0006\u00103\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u00104J\u0016\u00106\u001a\u00020 2\u0006\u00103\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u00104J&\u00107\u001a\u00020\u001c2\b\b\u0002\u00108\u001a\u00020+2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@¢\u0006\u0002\u0010:J\u0016\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010=J\u000e\u0010>\u001a\u00020 H\u0086@¢\u0006\u0002\u0010?JB\u0010@\u001a\u00020+2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00190\u000eJ \u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020+2\b\b\u0002\u0010G\u001a\u00020'H\u0086@¢\u0006\u0002\u0010HR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006I"}, d2 = {"Lcom/example/data/repository/NetWorthRepository;", "", "itemDao", "Lcom/example/data/dao/FinancialItemDao;", "snapshotDao", "Lcom/example/data/dao/SnapshotDao;", "ledgerDao", "Lcom/example/data/dao/LedgerDao;", "reminderDao", "Lcom/example/data/dao/ReminderDao;", "<init>", "(Lcom/example/data/dao/FinancialItemDao;Lcom/example/data/dao/SnapshotDao;Lcom/example/data/dao/LedgerDao;Lcom/example/data/dao/ReminderDao;)V", "allItems", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/model/FinancialItem;", "getAllItems", "()Lkotlinx/coroutines/flow/Flow;", "allSnapshots", "Lcom/example/data/model/NetWorthSnapshot;", "getAllSnapshots", "allLedgerEntries", "Lcom/example/data/model/LedgerEntry;", "getAllLedgerEntries", "allReminders", "Lcom/example/data/model/FinancialReminder;", "getAllReminders", "insertReminder", "", NotificationCompat.CATEGORY_REMINDER, "(Lcom/example/data/model/FinancialReminder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReminder", "", "deleteReminder", "deleteReminderById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setReminderCompleted", "completed", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLedgerEntriesForAccount", "accountName", "", "insertLedgerEntry", "entry", "(Lcom/example/data/model/LedgerEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLedgerEntry", "getItemsByOwner", "owner", "insertItem", "item", "(Lcom/example/data/model/FinancialItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateItem", "deleteItem", "recordSnapshot", "note", "currentItems", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSnapshot", "snapshot", "(Lcom/example/data/model/NetWorthSnapshot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAllData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportToJson", "items", "snapshots", "ledgerEntries", "reminders", "importFromJson", "jsonStr", "clearExisting", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class NetWorthRepository {
    public static final int $stable = 8;
    private final Flow<List<FinancialItem>> allItems;
    private final Flow<List<LedgerEntry>> allLedgerEntries;
    private final Flow<List<FinancialReminder>> allReminders;
    private final Flow<List<NetWorthSnapshot>> allSnapshots;
    private final FinancialItemDao itemDao;
    private final LedgerDao ledgerDao;
    private final ReminderDao reminderDao;
    private final SnapshotDao snapshotDao;

    public NetWorthRepository(FinancialItemDao itemDao, SnapshotDao snapshotDao, LedgerDao ledgerDao, ReminderDao reminderDao) {
        Intrinsics.checkNotNullParameter(itemDao, "itemDao");
        Intrinsics.checkNotNullParameter(snapshotDao, "snapshotDao");
        Intrinsics.checkNotNullParameter(ledgerDao, "ledgerDao");
        Intrinsics.checkNotNullParameter(reminderDao, "reminderDao");
        this.itemDao = itemDao;
        this.snapshotDao = snapshotDao;
        this.ledgerDao = ledgerDao;
        this.reminderDao = reminderDao;
        this.allItems = this.itemDao.getAllItems();
        this.allSnapshots = this.snapshotDao.getAllSnapshots();
        this.allLedgerEntries = this.ledgerDao.getAllLedgerEntries();
        this.allReminders = this.reminderDao.getAllReminders();
    }

    public final Flow<List<FinancialItem>> getAllItems() {
        return this.allItems;
    }

    public final Flow<List<NetWorthSnapshot>> getAllSnapshots() {
        return this.allSnapshots;
    }

    public final Flow<List<LedgerEntry>> getAllLedgerEntries() {
        return this.allLedgerEntries;
    }

    public final Flow<List<FinancialReminder>> getAllReminders() {
        return this.allReminders;
    }

    public final Object insertReminder(FinancialReminder reminder, Continuation<? super Long> continuation) {
        return this.reminderDao.insertReminder(reminder, continuation);
    }

    public final Object updateReminder(FinancialReminder reminder, Continuation<? super Unit> continuation) {
        Object updateReminder = this.reminderDao.updateReminder(reminder, continuation);
        return updateReminder == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateReminder : Unit.INSTANCE;
    }

    public final Object deleteReminder(FinancialReminder reminder, Continuation<? super Unit> continuation) {
        Object deleteReminder = this.reminderDao.deleteReminder(reminder, continuation);
        return deleteReminder == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deleteReminder : Unit.INSTANCE;
    }

    public final Object deleteReminderById(long id, Continuation<? super Unit> continuation) {
        Object deleteReminderById = this.reminderDao.deleteReminderById(id, continuation);
        return deleteReminderById == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deleteReminderById : Unit.INSTANCE;
    }

    public final Object setReminderCompleted(long id, boolean completed, Continuation<? super Unit> continuation) {
        Object updateCompletionStatus = this.reminderDao.updateCompletionStatus(id, completed, continuation);
        return updateCompletionStatus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateCompletionStatus : Unit.INSTANCE;
    }

    public final Flow<List<LedgerEntry>> getLedgerEntriesForAccount(String accountName) {
        Intrinsics.checkNotNullParameter(accountName, "accountName");
        return this.ledgerDao.getLedgerEntriesForAccount(accountName);
    }

    public final Object insertLedgerEntry(LedgerEntry entry, Continuation<? super Long> continuation) {
        return this.ledgerDao.insertLedgerEntry(entry, continuation);
    }

    public final Object deleteLedgerEntry(LedgerEntry entry, Continuation<? super Unit> continuation) {
        Object deleteLedgerEntry = this.ledgerDao.deleteLedgerEntry(entry, continuation);
        return deleteLedgerEntry == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deleteLedgerEntry : Unit.INSTANCE;
    }

    public final Flow<List<FinancialItem>> getItemsByOwner(String owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        return this.itemDao.getItemsByOwner(owner);
    }

    public final Object insertItem(FinancialItem item, Continuation<? super Long> continuation) {
        return this.itemDao.insertItem(item, continuation);
    }

    public final Object updateItem(FinancialItem item, Continuation<? super Unit> continuation) {
        Object updateItem = this.itemDao.updateItem(item, continuation);
        return updateItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateItem : Unit.INSTANCE;
    }

    public final Object deleteItem(FinancialItem item, Continuation<? super Unit> continuation) {
        Object deleteItem = this.itemDao.deleteItem(item, continuation);
        return deleteItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deleteItem : Unit.INSTANCE;
    }

    public static /* synthetic */ Object recordSnapshot$default(NetWorthRepository netWorthRepository, String str, List list, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Manual Snapshot";
        }
        return netWorthRepository.recordSnapshot(str, list, continuation);
    }

    public final Object recordSnapshot(String note, List<FinancialItem> list, Continuation<? super Long> continuation) {
        double assets = 0.0d;
        double liabilities = 0.0d;
        for (FinancialItem item : list) {
            if (item.isLiability()) {
                liabilities += item.getCurrentValue();
            } else {
                assets += item.getCurrentValue();
            }
        }
        NetWorthSnapshot snapshot = new NetWorthSnapshot(0L, System.currentTimeMillis(), assets, liabilities, assets - liabilities, note, 1, null);
        return this.snapshotDao.insertSnapshot(snapshot, continuation);
    }

    public final Object deleteSnapshot(NetWorthSnapshot snapshot, Continuation<? super Unit> continuation) {
        Object deleteSnapshot = this.snapshotDao.deleteSnapshot(snapshot, continuation);
        return deleteSnapshot == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deleteSnapshot : Unit.INSTANCE;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0021. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object clearAllData(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.example.data.repository.NetWorthRepository$clearAllData$1
            if (r0 == 0) goto L14
            r0 = r6
            com.example.data.repository.NetWorthRepository$clearAllData$1 r0 = (com.example.data.repository.NetWorthRepository$clearAllData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r1 = r0.label
            int r1 = r1 - r2
            r0.label = r1
            goto L19
        L14:
            com.example.data.repository.NetWorthRepository$clearAllData$1 r0 = new com.example.data.repository.NetWorthRepository$clearAllData$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            switch(r3) {
                case 0: goto L3c;
                case 1: goto L38;
                case 2: goto L34;
                case 3: goto L30;
                case 4: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2c:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L6f
        L30:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L63
        L34:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L57
        L38:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L4b
        L3c:
            kotlin.ResultKt.throwOnFailure(r1)
            com.example.data.dao.FinancialItemDao r3 = r5.itemDao
            r4 = 1
            r0.label = r4
            java.lang.Object r3 = r3.deleteAllItems(r0)
            if (r3 != r2) goto L4b
            return r2
        L4b:
            com.example.data.dao.SnapshotDao r3 = r5.snapshotDao
            r4 = 2
            r0.label = r4
            java.lang.Object r3 = r3.deleteAllSnapshots(r0)
            if (r3 != r2) goto L57
            return r2
        L57:
            com.example.data.dao.LedgerDao r3 = r5.ledgerDao
            r4 = 3
            r0.label = r4
            java.lang.Object r3 = r3.deleteAllLedgerEntries(r0)
            if (r3 != r2) goto L63
            return r2
        L63:
            com.example.data.dao.ReminderDao r3 = r5.reminderDao
            r4 = 4
            r0.label = r4
            java.lang.Object r3 = r3.deleteAllReminders(r0)
            if (r3 != r2) goto L6f
            return r2
        L6f:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.data.repository.NetWorthRepository.clearAllData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String exportToJson$default(NetWorthRepository netWorthRepository, List list, List list2, List list3, List list4, int i, Object obj) {
        if ((i & 4) != 0) {
            list3 = CollectionsKt.emptyList();
        }
        if ((i & 8) != 0) {
            list4 = CollectionsKt.emptyList();
        }
        return netWorthRepository.exportToJson(list, list2, list3, list4);
    }

    public final String exportToJson(List<FinancialItem> items, List<NetWorthSnapshot> snapshots, List<LedgerEntry> ledgerEntries, List<FinancialReminder> reminders) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(snapshots, "snapshots");
        Intrinsics.checkNotNullParameter(ledgerEntries, "ledgerEntries");
        String str = "reminders";
        Intrinsics.checkNotNullParameter(reminders, "reminders");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put("exportedAt", System.currentTimeMillis());
        JSONArray itemsArr = new JSONArray();
        for (FinancialItem item : items) {
            JSONObject obj = new JSONObject();
            obj.put("title", item.getTitle());
            obj.put("institution", item.getInstitution());
            obj.put("accountNumber", item.getAccountNumber());
            obj.put("owner", item.getOwner());
            obj.put("category", item.getCategory());
            obj.put("currentValue", item.getCurrentValue());
            obj.put("investedValue", item.getInvestedValue());
            obj.put("isLiability", item.isLiability());
            obj.put("notes", item.getNotes());
            itemsArr.put(obj);
        }
        jSONObject.put("items", itemsArr);
        JSONArray snapArr = new JSONArray();
        for (NetWorthSnapshot s : snapshots) {
            JSONObject obj2 = new JSONObject();
            obj2.put("timestamp", s.getTimestamp());
            obj2.put("totalAssets", s.getTotalAssets());
            obj2.put("totalLiabilities", s.getTotalLiabilities());
            obj2.put("netWorth", s.getNetWorth());
            obj2.put("note", s.getNote());
            snapArr.put(obj2);
            str = str;
        }
        String str2 = str;
        jSONObject.put("snapshots", snapArr);
        JSONArray ledgerArr = new JSONArray();
        for (Iterator<LedgerEntry> it = ledgerEntries.iterator(); it.hasNext(); it = it) {
            LedgerEntry l = it.next();
            JSONObject obj3 = new JSONObject();
            obj3.put("timestamp", l.getTimestamp());
            obj3.put("transactionTitle", l.getTransactionTitle());
            obj3.put("accountName", l.getAccountName());
            obj3.put("oppositeAccountName", l.getOppositeAccountName());
            obj3.put("entryType", l.getEntryType());
            obj3.put("debitAmount", l.getDebitAmount());
            obj3.put("creditAmount", l.getCreditAmount());
            obj3.put("runningBalance", l.getRunningBalance());
            obj3.put("category", l.getCategory());
            obj3.put("notes", l.getNotes());
            ledgerArr.put(obj3);
        }
        jSONObject.put("ledgerEntries", ledgerArr);
        JSONArray remArr = new JSONArray();
        for (FinancialReminder r : reminders) {
            JSONObject obj4 = new JSONObject();
            obj4.put("title", r.getTitle());
            obj4.put("amount", r.getAmount());
            obj4.put("reminderType", r.getReminderType());
            obj4.put("priority", r.getPriority());
            obj4.put("dueDateEpochDay", r.getDueDateEpochDay());
            obj4.put("frequency", r.getFrequency());
            obj4.put("owner", r.getOwner());
            obj4.put("associatedAccount", r.getAssociatedAccount());
            obj4.put("notes", r.getNotes());
            obj4.put("isCompleted", r.isCompleted());
            obj4.put("createdAt", r.getCreatedAt());
            remArr.put(obj4);
        }
        jSONObject.put(str2, remArr);
        String jSONObject2 = jSONObject.toString(2);
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        return jSONObject2;
    }

    public static /* synthetic */ Object importFromJson$default(NetWorthRepository netWorthRepository, String str, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return netWorthRepository.importFromJson(str, z, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:186|143|144|(2:145|146)|(9:150|151|152|153|154|(1:156)|157|158|(2:160|(1:162)(5:163|126|127|128|(3:130|131|(9:99|100|101|102|103|104|105|106|(1:108)(3:109|65|(14:67|68|69|70|(5:72|(7:74|75|76|77|78|79|80)|87|88|(2:90|(1:92)(9:93|27|28|29|(8:31|32|33|34|(4:36|37|38|39)|43|44|(2:46|(1:48)(5:49|15|16|17|18)))(1:55)|51|16|17|18)))(1:96)|95|27|28|29|(0)(0)|51|16|17|18)(0)))(0))(14:133|68|69|70|(0)(0)|95|27|28|29|(0)(0)|51|16|17|18))))(1:148)|149|126|127|128|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(14:67|68|69|70|(5:72|(7:74|75|76|77|78|79|80)|87|88|(2:90|(1:92)(9:93|27|28|29|(8:31|32|33|34|(4:36|37|38|39)|43|44|(2:46|(1:48)(5:49|15|16|17|18)))(1:55)|51|16|17|18)))(1:96)|95|27|28|29|(0)(0)|51|16|17|18) */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x05fb, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x05fc, code lost:
    
        r5 = r67;
        r1 = r0;
        r0 = r70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x05e5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x05e6, code lost:
    
        r68 = r2;
        r2 = r7;
        r1 = r0;
        r0 = r68;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x004b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02a9 A[Catch: Exception -> 0x05fb, TRY_LEAVE, TryCatch #13 {Exception -> 0x05fb, blocks: (B:128:0x02a3, B:130:0x02a9), top: B:127:0x02a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x04b7 A[Catch: Exception -> 0x05e5, TRY_LEAVE, TryCatch #17 {Exception -> 0x05e5, blocks: (B:29:0x04b1, B:31:0x04b7), top: B:28:0x04b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0398 A[Catch: Exception -> 0x05f0, TryCatch #0 {Exception -> 0x05f0, blocks: (B:70:0x0392, B:72:0x0398, B:74:0x03aa), top: B:69:0x0392 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x0329 -> B:64:0x0330). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object importFromJson(java.lang.String r68, boolean r69, kotlin.coroutines.Continuation<? super java.lang.Boolean> r70) {
        /*
            Method dump skipped, instructions count: 1578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.data.repository.NetWorthRepository.importFromJson(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
