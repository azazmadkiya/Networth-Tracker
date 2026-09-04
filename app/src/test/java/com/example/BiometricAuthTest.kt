package com.example

import com.example.data.security.BiometricStatus
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class BiometricAuthTest {

    @Test
    fun testBiometricStatusDescriptions() {
        assertEquals(
            "Biometric sensor ready (Fingerprint / Face Unlock)",
            BiometricStatus.READY.description
        )
        assertEquals(
            "No biometrics enrolled on this device",
            BiometricStatus.NOT_ENROLLED.description
        )
        assertEquals(
            "Biometric hardware not available",
            BiometricStatus.NO_HARDWARE.description
        )
    }

    @Test
    fun testBiometricStatusEnumValues() {
        val statuses = BiometricStatus.values()
        assertTrue(statuses.contains(BiometricStatus.READY))
        assertTrue(statuses.contains(BiometricStatus.NOT_ENROLLED))
        assertTrue(statuses.contains(BiometricStatus.NO_HARDWARE))
        assertTrue(statuses.contains(BiometricStatus.UNAVAILABLE))
        assertTrue(statuses.contains(BiometricStatus.UNKNOWN))
    }
}
