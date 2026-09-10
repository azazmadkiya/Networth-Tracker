package com.example.data.backup

import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import org.json.JSONObject
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

data class OfflineBackupSummary(
    val timestamp: Long,
    val itemCount: Int,
    val reminderCount: Int,
    val ledgerCount: Int,
    val snapshotCount: Int,
    val location: String
) {
    val formattedDate: String
        get() {
            return try {
                val sdf = java.text.SimpleDateFormat("dd MMM yyyy, hh:mm a", java.util.Locale.getDefault())
                sdf.format(java.util.Date(timestamp))
            } catch (e: Exception) {
                "Recent"
            }
        }
}

object OfflineBackupManager {
    private const val TAG = "OfflineBackupMgr"
    private const val BACKUP_FILENAME = "family_networth_offline_backup.json"
    private const val SUBFOLDER = "FamilyNetWorth"

    /**
     * Persists user financial data to offline device storage (survives app uninstall/reinstall).
     * Works 100% offline without requiring any internet or cloud service.
     */
    fun saveOfflineBackup(context: Context, jsonStr: String): Boolean {
        if (jsonStr.isBlank()) return false
        var savedSuccessfully = false

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
                        put(MediaStore.MediaColumns.MIME_TYPE, "application/json")
                        put(MediaStore.MediaColumns.RELATIVE_PATH, "${Environment.DIRECTORY_DOWNLOADS}/$SUBFOLDER/")
                        put(MediaStore.MediaColumns.IS_PENDING, 1)
                    }
                    resolver.insert(collection, values)
                }

                if (targetUri != null) {
                    resolver.openOutputStream(targetUri, "wt")?.use { outStream ->
                        outStream.write(jsonStr.toByteArray(Charsets.UTF_8))
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
                    fos.write(jsonStr.toByteArray(Charsets.UTF_8))
                    fos.flush()
                }
                savedSuccessfully = true
            } catch (e: Exception) {
                // Log and continue to fallback
                Log.d(TAG, "Direct file write warning for ${dir.path}: ${e.message}")
            }
        }

        // 3. Fallback to app-internal backup as additional safety layer
        try {
            val internalBackup = File(context.filesDir, BACKUP_FILENAME)
            FileOutputStream(internalBackup).use { fos ->
                fos.write(jsonStr.toByteArray(Charsets.UTF_8))
                fos.flush()
            }
        } catch (e: Exception) {
            Log.d(TAG, "Internal backup error: ${e.message}")
        }

        return savedSuccessfully
    }

    /**
     * Reads saved offline backup JSON from device storage if available.
     */
    fun readOfflineBackup(context: Context): String? {
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
                            if (isValidBackupJson(content)) {
                                return content
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                Log.w(TAG, "Error reading from MediaStore: ${e.message}")
            }
        }

        // 2. Try direct public storage locations
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
                    if (isValidBackupJson(content)) {
                        return content
                    }
                }
            } catch (e: Exception) {
                Log.d(TAG, "Error reading file ${file.path}: ${e.message}")
            }
        }

        // 3. Fallback to app internal backup
        try {
            val internalFile = File(context.filesDir, BACKUP_FILENAME)
            if (internalFile.exists() && internalFile.canRead()) {
                val content = FileInputStream(internalFile).bufferedReader().use { it.readText() }
                if (isValidBackupJson(content)) {
                    return content
                }
            }
        } catch (e: Exception) {
            Log.d(TAG, "Error reading internal file: ${e.message}")
        }

        return null
    }

    /**
     * Checks if a valid offline backup is present on the device.
     */
    fun hasOfflineBackup(context: Context): Boolean {
        return readOfflineBackup(context) != null
    }

    /**
     * Deletes all offline backups from device storage and internal app storage.
     */
    fun deleteOfflineBackup(context: Context): Boolean {
        var deletedAny = false
        // 1. Delete MediaStore entries (Android 10+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            try {
                val resolver = context.contentResolver
                val collection = MediaStore.Downloads.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
                val projection = arrayOf(MediaStore.MediaColumns._ID)
                val selection = "${MediaStore.MediaColumns.DISPLAY_NAME} = ?"
                val selectionArgs = arrayOf(BACKUP_FILENAME)

                resolver.query(collection, projection, selection, selectionArgs, null)?.use { cursor ->
                    while (cursor.moveToNext()) {
                        val id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.MediaColumns._ID))
                        val uri = ContentUris.withAppendedId(collection, id)
                        val count = resolver.delete(uri, null, null)
                        if (count > 0) deletedAny = true
                    }
                }
            } catch (e: Exception) {
                Log.w(TAG, "Failed deleting from MediaStore: ${e.message}")
            }
        }

        // 2. Direct storage files
        val candidateDirs = listOf(
            File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), SUBFOLDER),
            File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), SUBFOLDER),
            File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), ""),
            File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "")
        )
        for (dir in candidateDirs) {
            try {
                val file = File(dir, BACKUP_FILENAME)
                if (file.exists() && file.delete()) {
                    deletedAny = true
                }
            } catch (e: Exception) {
                Log.d(TAG, "Failed deleting file in ${dir.path}: ${e.message}")
            }
        }

        // 3. Internal app storage file
        try {
            val internalBackup = File(context.filesDir, BACKUP_FILENAME)
            if (internalBackup.exists() && internalBackup.delete()) {
                deletedAny = true
            }
        } catch (e: Exception) {
            Log.d(TAG, "Failed deleting internal backup: ${e.message}")
        }

        return deletedAny
    }

    /**
     * Parses the summary of an offline backup without fully loading all records.
     */
    fun getOfflineBackupSummary(context: Context): OfflineBackupSummary? {
        val jsonStr = readOfflineBackup(context) ?: return null
        return try {
            val root = JSONObject(jsonStr)
            val itemsCount = if (root.has("items")) root.getJSONArray("items").length() else 0
            val remindersCount = if (root.has("reminders")) root.getJSONArray("reminders").length() else 0
            val ledgerCount = if (root.has("ledger")) root.getJSONArray("ledger").length() else 0
            val snapshotCount = if (root.has("snapshots")) root.getJSONArray("snapshots").length() else 0

            OfflineBackupSummary(
                timestamp = System.currentTimeMillis(),
                itemCount = itemsCount,
                reminderCount = remindersCount,
                ledgerCount = ledgerCount,
                snapshotCount = snapshotCount,
                location = "Device Storage (Download/$SUBFOLDER)"
            )
        } catch (e: Exception) {
            null
        }
    }

    private fun isValidBackupJson(jsonStr: String): Boolean {
        if (jsonStr.isBlank()) return false
        return try {
            val root = JSONObject(jsonStr)
            root.has("items") || root.has("ledger") || root.has("reminders")
        } catch (e: Exception) {
            false
        }
    }
}
