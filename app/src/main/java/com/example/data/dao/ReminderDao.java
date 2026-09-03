package com.example.data.dao;

import androidx.core.app.NotificationCompat;
import com.example.data.model.FinancialReminder;
import com.example.data.model.Reminder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: FinancialDao.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\tJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H§@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00040\u0003H'J\u0016\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u001aH§@¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0004H§@¢\u0006\u0002\u0010\rJ\u0016\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u001aH§@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u001aH§@¢\u0006\u0002\u0010\u001cJ\u0016\u0010 \u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u0012J\u001e\u0010!\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H§@¢\u0006\u0002\u0010\u0016J\u000e\u0010\"\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0018¨\u0006#À\u0006\u0003"}, d2 = {"Lcom/example/data/dao/ReminderDao;", "", "getAllReminders", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/model/FinancialReminder;", "insertReminder", "", NotificationCompat.CATEGORY_REMINDER, "(Lcom/example/data/model/FinancialReminder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertReminders", "", "reminders", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReminder", "deleteReminder", "deleteReminderById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCompletionStatus", "completed", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllReminders", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSimpleReminders", "Lcom/example/data/model/Reminder;", "insertSimpleReminder", "(Lcom/example/data/model/Reminder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSimpleReminders", "updateSimpleReminder", "deleteSimpleReminder", "deleteSimpleReminderById", "updateSimpleReminderCompletionStatus", "deleteAllSimpleReminders", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ReminderDao {
    Object deleteAllReminders(Continuation<? super Unit> continuation);

    Object deleteAllSimpleReminders(Continuation<? super Unit> continuation);

    Object deleteReminder(FinancialReminder financialReminder, Continuation<? super Unit> continuation);

    Object deleteReminderById(long j, Continuation<? super Unit> continuation);

    Object deleteSimpleReminder(Reminder reminder, Continuation<? super Unit> continuation);

    Object deleteSimpleReminderById(long j, Continuation<? super Unit> continuation);

    Flow<List<FinancialReminder>> getAllReminders();

    Flow<List<Reminder>> getAllSimpleReminders();

    Object insertReminder(FinancialReminder financialReminder, Continuation<? super Long> continuation);

    Object insertReminders(List<FinancialReminder> list, Continuation<? super Unit> continuation);

    Object insertSimpleReminder(Reminder reminder, Continuation<? super Long> continuation);

    Object insertSimpleReminders(List<Reminder> list, Continuation<? super Unit> continuation);

    Object updateCompletionStatus(long j, boolean z, Continuation<? super Unit> continuation);

    Object updateReminder(FinancialReminder financialReminder, Continuation<? super Unit> continuation);

    Object updateSimpleReminder(Reminder reminder, Continuation<? super Unit> continuation);

    Object updateSimpleReminderCompletionStatus(long j, boolean z, Continuation<? super Unit> continuation);
}
