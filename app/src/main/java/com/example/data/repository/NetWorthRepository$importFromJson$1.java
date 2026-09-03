package com.example.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetWorthRepository.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.data.repository.NetWorthRepository", f = "NetWorthRepository.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {189, 214, 222, 255, 281}, m = "importFromJson", n = {"jsonStr", "clearExisting", "jsonStr", "root", "itemsArr", "newItems", "clearExisting", "jsonStr", "root", "snapArr", "obj", "clearExisting", "i", "jsonStr", "root", "ledgerArr", "newLedger", "clearExisting", "jsonStr", "root", "remArr", "newReminders", "clearExisting"}, s = {"L$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"})
/* loaded from: classes8.dex */
public final class NetWorthRepository$importFromJson$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetWorthRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetWorthRepository$importFromJson$1(NetWorthRepository netWorthRepository, Continuation<? super NetWorthRepository$importFromJson$1> continuation) {
        super(continuation);
        this.this$0 = netWorthRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.importFromJson(null, false, this);
    }
}
