package com.example.data.dao;

import androidx.core.app.NotificationCompat;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.example.data.model.FinancialReminder;
import com.example.data.model.Reminder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ReminderDao_Impl.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u001aJ\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00170!H\u0016J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00170!H\u0016J\u0016\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010)J\u000e\u0010*\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010%J\u001e\u0010-\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010)J\u000e\u0010.\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/example/data/dao/ReminderDao_Impl;", "Lcom/example/data/dao/ReminderDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfFinancialReminder", "Landroidx/room/EntityInsertAdapter;", "Lcom/example/data/model/FinancialReminder;", "__insertAdapterOfReminder", "Lcom/example/data/model/Reminder;", "__deleteAdapterOfFinancialReminder", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__deleteAdapterOfReminder", "__updateAdapterOfFinancialReminder", "__updateAdapterOfReminder", "insertReminder", "", NotificationCompat.CATEGORY_REMINDER, "(Lcom/example/data/model/FinancialReminder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertReminders", "", "reminders", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSimpleReminder", "(Lcom/example/data/model/Reminder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSimpleReminders", "deleteReminder", "deleteSimpleReminder", "updateReminder", "updateSimpleReminder", "getAllReminders", "Lkotlinx/coroutines/flow/Flow;", "getAllSimpleReminders", "deleteReminderById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCompletionStatus", "completed", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllReminders", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSimpleReminderById", "updateSimpleReminderCompletionStatus", "deleteAllSimpleReminders", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReminderDao_Impl implements ReminderDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<FinancialReminder> __deleteAdapterOfFinancialReminder;
    private final EntityDeleteOrUpdateAdapter<Reminder> __deleteAdapterOfReminder;
    private final EntityInsertAdapter<FinancialReminder> __insertAdapterOfFinancialReminder;
    private final EntityInsertAdapter<Reminder> __insertAdapterOfReminder;
    private final EntityDeleteOrUpdateAdapter<FinancialReminder> __updateAdapterOfFinancialReminder;
    private final EntityDeleteOrUpdateAdapter<Reminder> __updateAdapterOfReminder;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public ReminderDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfFinancialReminder = new EntityInsertAdapter<FinancialReminder>() { // from class: com.example.data.dao.ReminderDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `financial_reminders` (`id`,`title`,`amount`,`reminderType`,`priority`,`dueDateEpochDay`,`frequency`,`owner`,`associatedAccount`,`notes`,`isCompleted`,`createdAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, FinancialReminder entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
                statement.mo6932bindText(2, entity.getTitle());
                statement.mo6929bindDouble(3, entity.getAmount());
                statement.mo6932bindText(4, entity.getReminderType());
                statement.mo6932bindText(5, entity.getPriority());
                statement.mo6930bindLong(6, entity.getDueDateEpochDay());
                statement.mo6932bindText(7, entity.getFrequency());
                statement.mo6932bindText(8, entity.getOwner());
                statement.mo6932bindText(9, entity.getAssociatedAccount());
                statement.mo6932bindText(10, entity.getNotes());
                statement.mo6930bindLong(11, entity.isCompleted() ? 1L : 0L);
                statement.mo6930bindLong(12, entity.getCreatedAt());
            }
        };
        this.__insertAdapterOfReminder = new EntityInsertAdapter<Reminder>() { // from class: com.example.data.dao.ReminderDao_Impl.2
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `reminders` (`id`,`message`,`dueDate`,`priority`,`isCompleted`,`amount`,`category`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Reminder entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
                statement.mo6932bindText(2, entity.getMessage());
                statement.mo6930bindLong(3, entity.getDueDate());
                statement.mo6932bindText(4, entity.getPriority());
                statement.mo6930bindLong(5, entity.isCompleted() ? 1L : 0L);
                statement.mo6929bindDouble(6, entity.getAmount());
                statement.mo6932bindText(7, entity.getCategory());
            }
        };
        this.__deleteAdapterOfFinancialReminder = new EntityDeleteOrUpdateAdapter<FinancialReminder>() { // from class: com.example.data.dao.ReminderDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `financial_reminders` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, FinancialReminder entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
            }
        };
        this.__deleteAdapterOfReminder = new EntityDeleteOrUpdateAdapter<Reminder>() { // from class: com.example.data.dao.ReminderDao_Impl.4
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `reminders` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, Reminder entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfFinancialReminder = new EntityDeleteOrUpdateAdapter<FinancialReminder>() { // from class: com.example.data.dao.ReminderDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `financial_reminders` SET `id` = ?,`title` = ?,`amount` = ?,`reminderType` = ?,`priority` = ?,`dueDateEpochDay` = ?,`frequency` = ?,`owner` = ?,`associatedAccount` = ?,`notes` = ?,`isCompleted` = ?,`createdAt` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, FinancialReminder entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
                statement.mo6932bindText(2, entity.getTitle());
                statement.mo6929bindDouble(3, entity.getAmount());
                statement.mo6932bindText(4, entity.getReminderType());
                statement.mo6932bindText(5, entity.getPriority());
                statement.mo6930bindLong(6, entity.getDueDateEpochDay());
                statement.mo6932bindText(7, entity.getFrequency());
                statement.mo6932bindText(8, entity.getOwner());
                statement.mo6932bindText(9, entity.getAssociatedAccount());
                statement.mo6932bindText(10, entity.getNotes());
                statement.mo6930bindLong(11, entity.isCompleted() ? 1L : 0L);
                statement.mo6930bindLong(12, entity.getCreatedAt());
                statement.mo6930bindLong(13, entity.getId());
            }
        };
        this.__updateAdapterOfReminder = new EntityDeleteOrUpdateAdapter<Reminder>() { // from class: com.example.data.dao.ReminderDao_Impl.6
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `reminders` SET `id` = ?,`message` = ?,`dueDate` = ?,`priority` = ?,`isCompleted` = ?,`amount` = ?,`category` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, Reminder entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6930bindLong(1, entity.getId());
                statement.mo6932bindText(2, entity.getMessage());
                statement.mo6930bindLong(3, entity.getDueDate());
                statement.mo6932bindText(4, entity.getPriority());
                statement.mo6930bindLong(5, entity.isCompleted() ? 1L : 0L);
                statement.mo6929bindDouble(6, entity.getAmount());
                statement.mo6932bindText(7, entity.getCategory());
                statement.mo6930bindLong(8, entity.getId());
            }
        };
    }

    @Override // com.example.data.dao.ReminderDao
    public Object insertReminder(final FinancialReminder reminder, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ReminderDao_Impl.insertReminder$lambda$0(ReminderDao_Impl.this, reminder, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final long insertReminder$lambda$0(ReminderDao_Impl this$0, FinancialReminder $reminder, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        long _result = this$0.__insertAdapterOfFinancialReminder.insertAndReturnId(_connection, $reminder);
        return _result;
    }

    @Override // com.example.data.dao.ReminderDao
    public Object insertReminders(final List<FinancialReminder> list, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReminderDao_Impl.insertReminders$lambda$1(ReminderDao_Impl.this, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit insertReminders$lambda$1(ReminderDao_Impl this$0, List $reminders, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__insertAdapterOfFinancialReminder.insert(_connection, $reminders);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.dao.ReminderDao
    public Object insertSimpleReminder(final Reminder reminder, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ReminderDao_Impl.insertSimpleReminder$lambda$2(ReminderDao_Impl.this, reminder, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final long insertSimpleReminder$lambda$2(ReminderDao_Impl this$0, Reminder $reminder, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        long _result = this$0.__insertAdapterOfReminder.insertAndReturnId(_connection, $reminder);
        return _result;
    }

    @Override // com.example.data.dao.ReminderDao
    public Object insertSimpleReminders(final List<Reminder> list, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReminderDao_Impl.insertSimpleReminders$lambda$3(ReminderDao_Impl.this, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit insertSimpleReminders$lambda$3(ReminderDao_Impl this$0, List $reminders, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__insertAdapterOfReminder.insert(_connection, $reminders);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.dao.ReminderDao
    public Object deleteReminder(final FinancialReminder reminder, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReminderDao_Impl.deleteReminder$lambda$4(ReminderDao_Impl.this, reminder, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteReminder$lambda$4(ReminderDao_Impl this$0, FinancialReminder $reminder, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__deleteAdapterOfFinancialReminder.handle(_connection, $reminder);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.dao.ReminderDao
    public Object deleteSimpleReminder(final Reminder reminder, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReminderDao_Impl.deleteSimpleReminder$lambda$5(ReminderDao_Impl.this, reminder, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteSimpleReminder$lambda$5(ReminderDao_Impl this$0, Reminder $reminder, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__deleteAdapterOfReminder.handle(_connection, $reminder);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.dao.ReminderDao
    public Object updateReminder(final FinancialReminder reminder, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReminderDao_Impl.updateReminder$lambda$6(ReminderDao_Impl.this, reminder, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit updateReminder$lambda$6(ReminderDao_Impl this$0, FinancialReminder $reminder, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__updateAdapterOfFinancialReminder.handle(_connection, $reminder);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.dao.ReminderDao
    public Object updateSimpleReminder(final Reminder reminder, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReminderDao_Impl.updateSimpleReminder$lambda$7(ReminderDao_Impl.this, reminder, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit updateSimpleReminder$lambda$7(ReminderDao_Impl this$0, Reminder $reminder, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__updateAdapterOfReminder.handle(_connection, $reminder);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.dao.ReminderDao
    public Flow<List<FinancialReminder>> getAllReminders() {
        final String _sql = "SELECT * FROM financial_reminders ORDER BY dueDateEpochDay ASC, id ASC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"financial_reminders"}, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReminderDao_Impl.getAllReminders$lambda$8(_sql, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getAllReminders$lambda$8(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            int _tmp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
            int _columnIndexOfAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "amount");
            int _columnIndexOfReminderType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reminderType");
            int _columnIndexOfPriority = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "priority");
            int _columnIndexOfDueDateEpochDay = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "dueDateEpochDay");
            int _columnIndexOfFrequency = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "frequency");
            int _columnIndexOfOwner = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "owner");
            int _columnIndexOfAssociatedAccount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "associatedAccount");
            int _columnIndexOfNotes = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "notes");
            int _columnIndexOfIsCompleted = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isCompleted");
            int _columnIndexOfCreatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "createdAt");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_tmp);
                String _tmpTitle = _stmt.getText(_columnIndexOfTitle);
                double _tmpAmount = _stmt.getDouble(_columnIndexOfAmount);
                String _tmpReminderType = _stmt.getText(_columnIndexOfReminderType);
                String _tmpPriority = _stmt.getText(_columnIndexOfPriority);
                long _tmpDueDateEpochDay = _stmt.getLong(_columnIndexOfDueDateEpochDay);
                String _tmpFrequency = _stmt.getText(_columnIndexOfFrequency);
                String _tmpOwner = _stmt.getText(_columnIndexOfOwner);
                String _tmpAssociatedAccount = _stmt.getText(_columnIndexOfAssociatedAccount);
                String _tmpNotes = _stmt.getText(_columnIndexOfNotes);
                int _columnIndexOfId = _tmp;
                int _tmp2 = (int) _stmt.getLong(_columnIndexOfIsCompleted);
                boolean _tmpIsCompleted = _tmp2 != 0;
                long _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt);
                FinancialReminder _item = new FinancialReminder(_tmpId, _tmpTitle, _tmpAmount, _tmpReminderType, _tmpPriority, _tmpDueDateEpochDay, _tmpFrequency, _tmpOwner, _tmpAssociatedAccount, _tmpNotes, _tmpIsCompleted, _tmpCreatedAt);
                _result.add(_item);
                _tmp = _columnIndexOfId;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.dao.ReminderDao
    public Flow<List<Reminder>> getAllSimpleReminders() {
        final String _sql = "SELECT * FROM reminders ORDER BY dueDate ASC, id ASC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"reminders"}, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReminderDao_Impl.getAllSimpleReminders$lambda$9(_sql, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getAllSimpleReminders$lambda$9(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfMessage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "message");
            int _columnIndexOfDueDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "dueDate");
            int _columnIndexOfPriority = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "priority");
            int _columnIndexOfIsCompleted = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isCompleted");
            int _columnIndexOfAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "amount");
            int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_columnIndexOfId);
                String _tmpMessage = _stmt.getText(_columnIndexOfMessage);
                long _tmpDueDate = _stmt.getLong(_columnIndexOfDueDate);
                String _tmpPriority = _stmt.getText(_columnIndexOfPriority);
                int _tmp = (int) _stmt.getLong(_columnIndexOfIsCompleted);
                boolean _tmpIsCompleted = _tmp != 0;
                double _tmpAmount = _stmt.getDouble(_columnIndexOfAmount);
                String _tmpCategory = _stmt.getText(_columnIndexOfCategory);
                Reminder _item = new Reminder(_tmpId, _tmpMessage, _tmpDueDate, _tmpPriority, _tmpIsCompleted, _tmpAmount, _tmpCategory);
                _result.add(_item);
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.dao.ReminderDao
    public Object deleteReminderById(final long id, Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM financial_reminders WHERE id = ?";
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReminderDao_Impl.deleteReminderById$lambda$10(_sql, id, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteReminderById$lambda$10(String $_sql, long $id, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.mo6930bindLong(1, $id);
            _stmt.step();
            _stmt.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    @Override // com.example.data.dao.ReminderDao
    public Object updateCompletionStatus(final long id, final boolean completed, Continuation<? super Unit> continuation) {
        final String _sql = "UPDATE financial_reminders SET isCompleted = ? WHERE id = ?";
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReminderDao_Impl.updateCompletionStatus$lambda$11(_sql, completed, id, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit updateCompletionStatus$lambda$11(String $_sql, boolean $completed, long $id, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        int _tmp = $completed ? 1 : 0;
        try {
            _stmt.mo6930bindLong(1, _tmp);
            _stmt.mo6930bindLong(2, $id);
            _stmt.step();
            _stmt.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    @Override // com.example.data.dao.ReminderDao
    public Object deleteAllReminders(Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM financial_reminders";
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReminderDao_Impl.deleteAllReminders$lambda$12(_sql, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteAllReminders$lambda$12(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.step();
            _stmt.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    @Override // com.example.data.dao.ReminderDao
    public Object deleteSimpleReminderById(final long id, Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM reminders WHERE id = ?";
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReminderDao_Impl.deleteSimpleReminderById$lambda$13(_sql, id, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteSimpleReminderById$lambda$13(String $_sql, long $id, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.mo6930bindLong(1, $id);
            _stmt.step();
            _stmt.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    @Override // com.example.data.dao.ReminderDao
    public Object updateSimpleReminderCompletionStatus(final long id, final boolean completed, Continuation<? super Unit> continuation) {
        final String _sql = "UPDATE reminders SET isCompleted = ? WHERE id = ?";
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReminderDao_Impl.updateSimpleReminderCompletionStatus$lambda$14(_sql, completed, id, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit updateSimpleReminderCompletionStatus$lambda$14(String $_sql, boolean $completed, long $id, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        int _tmp = $completed ? 1 : 0;
        try {
            _stmt.mo6930bindLong(1, _tmp);
            _stmt.mo6930bindLong(2, $id);
            _stmt.step();
            _stmt.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    @Override // com.example.data.dao.ReminderDao
    public Object deleteAllSimpleReminders(Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM reminders";
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.dao.ReminderDao_Impl$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReminderDao_Impl.deleteAllSimpleReminders$lambda$15(_sql, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteAllSimpleReminders$lambda$15(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.step();
            _stmt.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    /* compiled from: ReminderDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/example/data/dao/ReminderDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<KClass<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}
