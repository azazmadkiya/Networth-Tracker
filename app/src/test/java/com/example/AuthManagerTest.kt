package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.security.AuthManager
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AuthManagerTest {

    private lateinit var context: Context
    private lateinit var authManager: AuthManager

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE).edit().clear().commit()
        authManager = AuthManager(context)
    }

    @Test
    fun testInitialStateHasNoAccount() {
        assertFalse(authManager.hasAccount())
        assertFalse(authManager.isLoggedIn())
        assertEquals("", authManager.getStoredUserId())
    }

    @Test
    fun testRegisterUserAndLogin() {
        val registered = authManager.registerUser("customUser", "secret1234")
        assertTrue(registered)
        assertTrue(authManager.hasAccount())
        assertTrue(authManager.isLoggedIn())
        assertEquals("customUser", authManager.getStoredUserId())

        // Test logout
        authManager.logout()
        assertFalse(authManager.isLoggedIn())

        // Test login validation
        assertTrue(authManager.validateLogin("customUser", "secret1234"))
        assertTrue(authManager.isLoggedIn())

        // Test invalid login
        assertFalse(authManager.validateLogin("customUser", "wrongPass"))
        assertFalse(authManager.validateLogin("wrongUser", "secret1234"))
    }

    @Test
    fun testUpdatePassword() {
        authManager.registerUser("testUser", "oldPass")
        authManager.updatePassword("newPass456")
        assertTrue(authManager.validateLogin("testUser", "newPass456"))
        assertFalse(authManager.validateLogin("testUser", "oldPass"))
    }
}
