package com.example.data.security;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AuthManager.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\tJ\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/example/data/security/AuthManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "getStoredUserId", "", "isLoggedIn", "", "validateLogin", "idInput", "passwordInput", "setLoggedIn", "", "loggedIn", "updatePassword", "newPassword", "resetToDefaultCredentials", "logout", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AuthManager {
    public static final String DEFAULT_PASSWORD = "96877093150";
    public static final String DEFAULT_USER_ID = "Azazmadkiya";
    private static final String KEY_BIOMETRIC_ENABLED = "biometric_enabled";
    private static final String KEY_IS_LOGGED_IN = "is_logged_in";
    private static final String KEY_PASSWORD = "stored_password";
    private static final String KEY_USER_ID = "stored_user_id";
    private final SharedPreferences prefs;
    public static final int $stable = 8;

    public AuthManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("auth_prefs", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.prefs = sharedPreferences;
        if (this.prefs.contains(KEY_USER_ID)) {
            return;
        }
        this.prefs.edit().putString(KEY_USER_ID, DEFAULT_USER_ID).putString(KEY_PASSWORD, DEFAULT_PASSWORD).apply();
    }

    public final String getStoredUserId() {
        String string = this.prefs.getString(KEY_USER_ID, DEFAULT_USER_ID);
        return string == null ? DEFAULT_USER_ID : string;
    }

    public final boolean isLoggedIn() {
        return this.prefs.getBoolean(KEY_IS_LOGGED_IN, true);
    }

    public final boolean validateLogin(String idInput, String passwordInput) {
        Intrinsics.checkNotNullParameter(idInput, "idInput");
        Intrinsics.checkNotNullParameter(passwordInput, "passwordInput");
        String storedId = getStoredUserId();
        SharedPreferences sharedPreferences = this.prefs;
        String storedPass = DEFAULT_PASSWORD;
        String string = sharedPreferences.getString(KEY_PASSWORD, DEFAULT_PASSWORD);
        if (string != null) {
            storedPass = string;
        }
        boolean idMatches = StringsKt.equals(StringsKt.trim((CharSequence) idInput).toString(), StringsKt.trim((CharSequence) storedId).toString(), true);
        boolean passMatches = Intrinsics.areEqual(StringsKt.trim((CharSequence) passwordInput).toString(), StringsKt.trim((CharSequence) storedPass).toString());
        if (idMatches && passMatches) {
            setLoggedIn(true);
            return true;
        }
        return false;
    }

    public final void setLoggedIn(boolean loggedIn) {
        this.prefs.edit().putBoolean(KEY_IS_LOGGED_IN, loggedIn).apply();
    }

    public final void updatePassword(String newPassword) {
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        this.prefs.edit().putString(KEY_PASSWORD, newPassword).apply();
    }

    public final void resetToDefaultCredentials() {
        this.prefs.edit().putString(KEY_USER_ID, DEFAULT_USER_ID).putString(KEY_PASSWORD, DEFAULT_PASSWORD).putBoolean(KEY_IS_LOGGED_IN, false).apply();
    }

    public final void logout() {
        this.prefs.edit().putBoolean(KEY_IS_LOGGED_IN, false).apply();
    }
}
