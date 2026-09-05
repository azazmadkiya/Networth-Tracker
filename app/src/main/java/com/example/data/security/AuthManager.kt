package com.example.data.security

import android.content.Context
import android.content.SharedPreferences

class AuthManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_USER_ID = "stored_user_id"
        private const val KEY_PASSWORD = "stored_password"
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_BIOMETRIC_ENABLED = "biometric_enabled"
        private const val KEY_HAS_ACCOUNT = "has_account"
        private const val KEY_VOICE_INTERNET_ACCESS = "voice_internet_access"
        private const val KEY_VOICE_INTERNET_DECIDED = "voice_internet_decided"
        private const val KEY_THEME_MODE = "theme_mode" // "system", "light", "dark"
    }

    fun getThemeMode(): String {
        return prefs.getString(KEY_THEME_MODE, "system") ?: "system"
    }

    fun setThemeMode(mode: String) {
        prefs.edit().putString(KEY_THEME_MODE, mode).apply()
    }

    fun hasAccount(): Boolean {
        val hasFlag = prefs.getBoolean(KEY_HAS_ACCOUNT, false)
        val hasId = !prefs.getString(KEY_USER_ID, null).isNullOrBlank()
        val hasPass = !prefs.getString(KEY_PASSWORD, null).isNullOrBlank()
        return hasFlag || (hasId && hasPass)
    }

    fun getStoredUserId(): String {
        return prefs.getString(KEY_USER_ID, "") ?: ""
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun setLoggedIn(loggedIn: Boolean) {
        prefs.edit().putBoolean(KEY_IS_LOGGED_IN, loggedIn).apply()
    }

    fun registerUser(idInput: String, passwordInput: String): Boolean {
        val trimmedId = idInput.trim()
        val trimmedPass = passwordInput.trim()
        if (trimmedId.isEmpty() || trimmedPass.isEmpty()) {
            return false
        }
        prefs.edit()
            .putString(KEY_USER_ID, trimmedId)
            .putString(KEY_PASSWORD, trimmedPass)
            .putBoolean(KEY_HAS_ACCOUNT, true)
            .putBoolean(KEY_IS_LOGGED_IN, true)
            .apply()
        return true
    }

    fun validateLogin(idInput: String, passwordInput: String): Boolean {
        val storedId = getStoredUserId()
        val storedPass = prefs.getString(KEY_PASSWORD, "") ?: ""

        if (storedId.isBlank() || storedPass.isBlank()) {
            return false
        }

        val idMatches = idInput.trim().equals(storedId.trim(), ignoreCase = true)
        val passMatches = passwordInput.trim() == storedPass.trim()

        if (idMatches && passMatches) {
            setLoggedIn(true)
            return true
        }
        return false
    }

    fun updatePassword(newPassword: String) {
        prefs.edit().putString(KEY_PASSWORD, newPassword.trim()).apply()
    }

    fun logout() {
        setLoggedIn(false)
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
}
