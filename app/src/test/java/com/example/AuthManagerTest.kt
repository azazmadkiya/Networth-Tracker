package com.example

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.test.core.app.ApplicationProvider
import com.example.data.security.AuthManager
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AuthManagerTest {

    private lateinit var authManager: AuthManager
    private lateinit var context: Context

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        authManager = AuthManager(context)
        authManager.logout()
    }

    @Test
    fun testInitialState() {
        assertFalse(authManager.hasPasswordSet())
        assertFalse(authManager.isLoggedIn())
        assertEquals("", authManager.getStoredUserId())
    }

    @Test
    fun testSetPasswordAndValidate() {
        // Set password
        val registered = authManager.setPassword("secret1234")
        assertTrue(registered)

        // After setting password, hasPasswordSet should be true and loggedIn should be true
        assertTrue(authManager.hasPasswordSet())
        assertTrue(authManager.isLoggedIn())

        // Test logout
        authManager.logout()
        assertFalse(authManager.isLoggedIn())

        // Test validate password success
        assertTrue(authManager.validatePassword("secret1234"))
        assertTrue(authManager.isLoggedIn())

        // Test validate password failure
        authManager.logout()
        assertFalse(authManager.validatePassword("wrongPass"))
        assertFalse(authManager.isLoggedIn())
    }

    @Test
    fun testUpdatePassword() {
        authManager.setPassword("oldPass")
        authManager.updatePassword("newPass456")

        assertTrue(authManager.validatePassword("newPass456"))
        assertFalse(authManager.validatePassword("oldPass"))
    }
}
