package com.example

import com.example.ui.screens.SettingsSubScreen
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SettingsComplianceTest {

    @Test
    fun testSettingsSubScreenEntries() {
        val entries = SettingsSubScreen.values()
        assertTrue(entries.contains(SettingsSubScreen.REMINDERS))
        assertTrue(entries.contains(SettingsSubScreen.PRIVACY_POLICY))
        assertTrue(entries.contains(SettingsSubScreen.TERMS_OF_SERVICE))
        assertTrue(entries.contains(SettingsSubScreen.DATA_SAFETY))
        assertTrue(entries.contains(SettingsSubScreen.PLAY_COMPLIANCE))
        assertTrue(entries.contains(SettingsSubScreen.OPEN_SOURCE_LICENSES))
        assertTrue(entries.contains(SettingsSubScreen.ABOUT))
        assertEquals(7, entries.size)
    }
}
