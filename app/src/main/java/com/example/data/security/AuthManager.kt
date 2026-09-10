package com.example.data.security

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class AuthManager(context: Context) {

    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val prefs: SharedPreferences = EncryptedSharedPreferences.create(
        context,
        "auth_prefs_secure",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    init {
        migrateOldPrefs(context)
    }

    private fun migrateOldPrefs(context: Context) {
        val oldPrefs = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)
        if (oldPrefs.all.isNotEmpty()) {
            val editor = prefs.edit()
            for ((key, value) in oldPrefs.all) {
                when (value) {
                    is String -> editor.putString(key, value)
                    is Boolean -> editor.putBoolean(key, value)
                    is Int -> editor.putInt(key, value)
                    is Float -> editor.putFloat(key, value)
                    is Long -> editor.putLong(key, value)
                }
            }
            editor.apply()
            oldPrefs.edit().clear().apply()
        }
    }

    companion object {
        private const val KEY_USER_ID = "stored_user_id" // Kept for backwards compatibility if needed
        private const val KEY_PASSWORD = "stored_password"
        private const val KEY_APP_LOCK_PIN = "app_lock_pin"
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_BIOMETRIC_ENABLED = "biometric_enabled"
        private const val KEY_HAS_ACCOUNT = "has_account"
        private const val KEY_VOICE_INTERNET_ACCESS = "voice_internet_access"
        private const val KEY_VOICE_INTERNET_DECIDED = "voice_internet_decided"
        private const val KEY_THEME_MODE = "theme_mode" // "system", "light", "dark"
        private const val KEY_PERMISSIONS_PROMPTED = "initial_permissions_prompted"
    }

    fun getAppLockPin(): String? {
        return prefs.getString(KEY_APP_LOCK_PIN, null)
    }

    fun setAppLockPin(pin: String) {
        prefs.edit().putString(KEY_APP_LOCK_PIN, pin).apply()
    }

    fun isAppLockEnabled(): Boolean {
        return !getAppLockPin().isNullOrEmpty()
    }

    fun getThemeMode(): String {
        return prefs.getString(KEY_THEME_MODE, "system") ?: "system"
    }

    fun setThemeMode(mode: String) {
        prefs.edit().putString(KEY_THEME_MODE, mode).apply()
    }

    fun hasPasswordSet(): Boolean {
        val hasPass = !prefs.getString(KEY_PASSWORD, null).isNullOrBlank()
        // If they had an account from before, treat that as having a password set
        val hasFlag = prefs.getBoolean(KEY_HAS_ACCOUNT, false)
        return hasPass || hasFlag
    }
    
    // For backwards compatibility in other parts of the app if needed
    fun hasAccount(): Boolean = hasPasswordSet()

    fun getStoredUserId(): String {
        return prefs.getString(KEY_USER_ID, "") ?: ""
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun setLoggedIn(loggedIn: Boolean) {
        prefs.edit().putBoolean(KEY_IS_LOGGED_IN, loggedIn).apply()
    }

    fun setPassword(passwordInput: String): Boolean {
        val trimmedPass = passwordInput.trim()
        if (trimmedPass.isEmpty()) {
            return false
        }
        prefs.edit()
            .putString(KEY_PASSWORD, trimmedPass)
            .putBoolean(KEY_HAS_ACCOUNT, true)
            .putBoolean(KEY_IS_LOGGED_IN, true)
            .apply()
        return true
    }
    
    // Backwards compatibility for older code calling registerUser
    fun registerUser(idInput: String, passwordInput: String): Boolean {
        return setPassword(passwordInput)
    }

    fun validatePassword(passwordInput: String): Boolean {
        val storedPass = prefs.getString(KEY_PASSWORD, "") ?: ""

        if (storedPass.isBlank()) {
            return false
        }

        val passMatches = passwordInput.trim() == storedPass.trim()

        if (passMatches) {
            setLoggedIn(true)
            return true
        }
        return false
    }

    // Backwards compatibility
    fun validateLogin(idInput: String, passwordInput: String): Boolean {
        return validatePassword(passwordInput)
    }

    fun updatePassword(newPassword: String) {
        prefs.edit().putString(KEY_PASSWORD, newPassword.trim()).apply()
    }

    fun logout() {
        setLoggedIn(false)
        prefs.edit().remove(KEY_APP_LOCK_PIN).apply()
    }

    fun isBiometricEnabled(): Boolean {
        return prefs.getBoolean(KEY_BIOMETRIC_ENABLED, false)
    }

    fun setBiometricEnabled(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_BIOMETRIC_ENABLED, enabled).apply()
    }

    fun isVoiceInternetAllowed(): Boolean {
        return prefs.getBoolean(KEY_VOICE_INTERNET_ACCESS, false)
    }

    fun setVoiceInternetAllowed(allowed: Boolean) {
        prefs.edit()
            .putBoolean(KEY_VOICE_INTERNET_ACCESS, allowed)
            .putBoolean(KEY_VOICE_INTERNET_DECIDED, true)
            .apply()
    }

    fun hasUserDecidedVoiceInternet(): Boolean {
        return prefs.getBoolean(KEY_VOICE_INTERNET_DECIDED, false)
    }

    fun hasShownInitialPermissionsPrompt(): Boolean {
        return prefs.getBoolean(KEY_PERMISSIONS_PROMPTED, false)
    }

    fun setHasShownInitialPermissionsPrompt(prompted: Boolean) {
        prefs.edit().putBoolean(KEY_PERMISSIONS_PROMPTED, prompted).apply()
    }
}
