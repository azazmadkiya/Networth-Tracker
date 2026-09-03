package com.example.data.dao;

import com.example.data.model.LedgerEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: FinancialDao.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH'J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\fJ\u000e\u0010\u0012\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/example/data/dao/LedgerDao;", "", "getAllLedgerEntries", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/model/LedgerEntry;", "getLedgerEntriesForAccount", "accountName", "", "insertLedgerEntry", "", "entry", "(Lcom/example/data/model/LedgerEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLedgerEntries", "", "entries", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLedgerEntry", "deleteAllLedgerEntries", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LedgerDao {
    Object deleteAllLedgerEntries(Continuation<? super Unit> continuation);

    Object deleteLedgerEntry(LedgerEntry ledgerEntry, Continuation<? super Unit> continuation);

    Flow<List<LedgerEntry>> getAllLedgerEntries();

    Flow<List<LedgerEntry>> getLedgerEntriesForAccount(String accountName);

    Object insertLedgerEntries(List<LedgerEntry> list, Continuation<? super Unit> continuation);

    Object insertLedgerEntry(LedgerEntry ledgerEntry, Continuation<? super Long> continuation);
}
