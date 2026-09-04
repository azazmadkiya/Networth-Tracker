package com.example.data.security

import android.content.Context
import android.content.SharedPreferences

class AuthManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    companion object {
        const val DEFAULT_USER_ID = "Azazmadkiya"
        const val DEFAULT_PASSWORD = "96877093150"
        private const val KEY_USER_ID = "stored_user_id"
        private const val KEY_PASSWORD = "stored_password"
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_BIOMETRIC_ENABLED = "biometric_enabled"
    }

    init {
        if (!prefs.contains(KEY_USER_ID)) {
            prefs.edit()
                .putString(KEY_USER_ID, DEFAULT_USER_ID)
                .putString(KEY_PASSWORD, DEFAULT_PASSWORD)
                .putBoolean(KEY_IS_LOGGED_IN, true)
                .apply()
        }
    }

    fun getStoredUserId(): String {
        return prefs.getString(KEY_USER_ID, DEFAULT_USER_ID) ?: DEFAULT_USER_ID
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean(KEY_IS_LOGGED_IN, true)
    }

    fun setLoggedIn(loggedIn: Boolean) {
        prefs.edit().putBoolean(KEY_IS_LOGGED_IN, loggedIn).apply()
    }

    fun validateLogin(idInput: String, passwordInput: String): Boolean {
        val storedId = getStoredUserId()
        val storedPass = prefs.getString(KEY_PASSWORD, DEFAULT_PASSWORD) ?: DEFAULT_PASSWORD
        val idMatches = idInput.trim().equals(storedId.trim(), ignoreCase = true)
        val passMatches = passwordInput.trim() == storedPass.trim()

        if (idMatches && passMatches) {
            setLoggedIn(true)
            return true
        }
        return false
    }

    fun updatePassword(newPassword: String) {
        prefs.edit().putString(KEY_PASSWORD, newPassword).apply()
    }

    fun resetToDefaultCredentials() {
        prefs.edit()
            .putString(KEY_USER_ID, DEFAULT_USER_ID)
            .putString(KEY_PASSWORD, DEFAULT_PASSWORD)
            .apply()
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
}
