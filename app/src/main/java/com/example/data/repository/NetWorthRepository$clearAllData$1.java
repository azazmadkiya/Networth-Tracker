package com.example.data.repository;

import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetWorthRepository.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.data.repository.NetWorthRepository", f = "NetWorthRepository.kt", i = {}, l = {LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 103, LocationRequestCompat.QUALITY_LOW_POWER, 105}, m = "clearAllData", n = {}, s = {})
/* loaded from: classes8.dex */
public final class NetWorthRepository$clearAllData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetWorthRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetWorthRepository$clearAllData$1(NetWorthRepository netWorthRepository, Continuation<? super NetWorthRepository$clearAllData$1> continuation) {
        super(continuation);
        this.this$0 = netWorthRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.clearAllData(this);
    }
}
