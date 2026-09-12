package com.example.data.backup

import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Base64
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec

object EncryptedBackupManager {
    private const val TAG = "EncryptedBackupMgr"
    private const val BACKUP_FILENAME = "family_networth_encrypted_backup.enc"
    private const val SUBFOLDER = "FamilyNetWorth"
    
    private const val ALIAS = "networth_backup_key"
    private const val ANDROID_KEYSTORE = "AndroidKeyStore"
    private const val TRANSFORMATION = "AES/GCM/NoPadding"

    private fun getSecretKey(): SecretKey {
        val keyStore = KeyStore.getInstance(ANDROID_KEYSTORE)
        keyStore.load(null)
        if (!keyStore.containsAlias(ALIAS)) {
            val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, ANDROID_KEYSTORE)
            val keyGenParameterSpec = KeyGenParameterSpec.Builder(
                ALIAS,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
            )
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .build()
            keyGenerator.init(keyGenParameterSpec)
            keyGenerator.generateKey()
        }
        return keyStore.getKey(ALIAS, null) as SecretKey
    }

    private fun encrypt(plainText: String): String {
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey())
        val iv = cipher.iv
        val encrypted = cipher.doFinal(plainText.toByteArray(Charsets.UTF_8))
        
        val ivStr = Base64.encodeToString(iv, Base64.NO_WRAP)
        val encryptedStr = Base64.encodeToString(encrypted, Base64.NO_WRAP)
        
        return "$ivStr:$encryptedStr"
    }

    private fun decrypt(encryptedData: String): String {
        val parts = encryptedData.split(":")
        if (parts.size != 2) throw IllegalArgumentException("Invalid encrypted data format")
        
        val iv = Base64.decode(parts[0], Base64.NO_WRAP)
        val encrypted = Base64.decode(parts[1], Base64.NO_WRAP)
        
        val cipher = Cipher.getInstance(TRANSFORMATION)
        val spec = GCMParameterSpec(128, iv)
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(), spec)
        
        val decrypted = cipher.doFinal(encrypted)
        return String(decrypted, Charsets.UTF_8)
    }

    fun saveEncryptedBackup(context: Context, jsonStr: String): Boolean {
        if (jsonStr.isBlank()) return false
        var savedSuccessfully = false
        
        val encryptedContent = try {
            encrypt(jsonStr)
        } catch (e: Exception) {
            Log.e(TAG, "Encryption failed: ${e.message}")
            return false
        }

        // 1. Try modern MediaStore (survives APK uninstall on Android 10+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            try {
                val resolver = context.contentResolver
                val collection = MediaStore.Downloads.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)

                // Check if existing backup file exists in MediaStore
                val projection = arrayOf(MediaStore.MediaColumns._ID)
                val selection = "${MediaStore.MediaColumns.DISPLAY_NAME} = ? AND ${MediaStore.MediaColumns.RELATIVE_PATH} LIKE ?"
                val selectionArgs = arrayOf(BACKUP_FILENAME, "%$SUBFOLDER%")

                var existingUri: Uri? = null
                resolver.query(collection, projection, selection, selectionArgs, null)?.use { cursor ->
                    if (cursor.moveToFirst()) {
                        val id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.MediaColumns._ID))
                        existingUri = ContentUris.withAppendedId(collection, id)
                    }
                }

                val targetUri = existingUri ?: run {
                    val values = ContentValues().apply {
                        put(MediaStore.MediaColumns.DISPLAY_NAME, BACKUP_FILENAME)
                        put(MediaStore.MediaColumns.MIME_TYPE, "application/octet-stream")
                        put(MediaStore.MediaColumns.RELATIVE_PATH, "${Environment.DIRECTORY_DOWNLOADS}/$SUBFOLDER/")
                        put(MediaStore.MediaColumns.IS_PENDING, 1)
                    }
                    resolver.insert(collection, values)
                }

                if (targetUri != null) {
                    resolver.openOutputStream(targetUri, "wt")?.use { outStream ->
                        outStream.write(encryptedContent.toByteArray(Charsets.UTF_8))
                        outStream.flush()
                        savedSuccessfully = true
                    }

                    if (existingUri == null) {
                        val updateValues = ContentValues().apply {
                            put(MediaStore.MediaColumns.IS_PENDING, 0)
                        }
                        resolver.update(targetUri, updateValues, null, null)
                    }
                }
            } catch (e: Exception) {
                Log.w(TAG, "MediaStore backup save warning: ${e.message}")
            }
        }

        // 2. Direct File storage in public Documents & Downloads (legacy & supplementary)
        val candidateDirs = listOf(
            File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), SUBFOLDER),
            File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), SUBFOLDER),
            File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "")
        )

        for (dir in candidateDirs) {
            try {
                if (!dir.exists()) {
                    dir.mkdirs()
                }
                val file = File(dir, BACKUP_FILENAME)
                FileOutputStream(file).use { fos ->
                    fos.write(encryptedContent.toByteArray(Charsets.UTF_8))
                    fos.flush()
                }
                savedSuccessfully = true
            } catch (e: Exception) {
                Log.d(TAG, "Direct file write warning for ${dir.path}: ${e.message}")
            }
        }

        // 3. Fallback to app-internal backup as additional safety layer
        try {
            val internalBackup = File(context.filesDir, BACKUP_FILENAME)
            FileOutputStream(internalBackup).use { fos ->
                fos.write(encryptedContent.toByteArray(Charsets.UTF_8))
                fos.flush()
            }
            if (!savedSuccessfully) savedSuccessfully = true
        } catch (e: Exception) {
            Log.d(TAG, "Internal backup error: ${e.message}")
        }

        return savedSuccessfully
    }

    fun readEncryptedBackup(context: Context): String? {
        var rawEncryptedContent: String? = null
        
        // 1. Try modern MediaStore on Android 10+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            try {
                val resolver = context.contentResolver
                val collection = MediaStore.Downloads.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
                val projection = arrayOf(MediaStore.MediaColumns._ID)
                val selection = "${MediaStore.MediaColumns.DISPLAY_NAME} = ?"
                val selectionArgs = arrayOf(BACKUP_FILENAME)

                resolver.query(collection, projection, selection, selectionArgs, null)?.use { cursor ->
                    if (cursor.moveToFirst()) {
                        val id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.MediaColumns._ID))
                        val uri = ContentUris.withAppendedId(collection, id)
                        resolver.openInputStream(uri)?.use { inputStream ->
                            val content = inputStream.bufferedReader().use { it.readText() }
                            if (content.contains(":")) {
                                rawEncryptedContent = content
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                Log.w(TAG, "Error reading from MediaStore: ${e.message}")
            }
        }

        // 2. Try direct public storage locations
        if (rawEncryptedContent == null) {
            val candidateFiles = listOf(
                File(File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), SUBFOLDER), BACKUP_FILENAME),
                File(File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), SUBFOLDER), BACKUP_FILENAME),
                File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), BACKUP_FILENAME),
                File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), BACKUP_FILENAME)
            )

            for (file in candidateFiles) {
                try {
                    if (file.exists() && file.canRead()) {
                        val content = FileInputStream(file).bufferedReader().use { it.readText() }
                        if (content.contains(":")) {
                            rawEncryptedContent = content
                            break
                        }
                    }
                } catch (e: Exception) {
                    Log.d(TAG, "Error reading file ${file.path}: ${e.message}")
                }
            }
        }

        // 3. Fallback to app internal backup
        if (rawEncryptedContent == null) {
            try {
                val internalFile = File(context.filesDir, BACKUP_FILENAME)
                if (internalFile.exists() && internalFile.canRead()) {
                    val content = FileInputStream(internalFile).bufferedReader().use { it.readText() }
                    if (content.contains(":")) {
                        rawEncryptedContent = content
                    }
                }
            } catch (e: Exception) {
                Log.d(TAG, "Error reading internal file: ${e.message}")
            }
        }

        if (rawEncryptedContent != null) {
            return try {
                decrypt(rawEncryptedContent!!)
            } catch (e: Exception) {
                Log.e(TAG, "Failed to decrypt backup: ${e.message}")
                null
            }
        }
        return null
    }
}
