package com.example;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/example/NavTab;", "", "title", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "DASHBOARD", "ASSETS", "LEDGER", "ANALYTICS", "SETTINGS", "REMINDERS", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public enum NavTab {
    DASHBOARD("Dashboard"),
    ASSETS("Assets"),
    LEDGER("Ledger"),
    ANALYTICS("Analytics"),
    SETTINGS("Settings"),
    REMINDERS("Reminders");

    private final String title;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<NavTab> getEntries() {
        return $ENTRIES;
    }

    NavTab(String title) {
        this.title = title;
    }

    public final String getTitle() {
        return this.title;
    }
}
