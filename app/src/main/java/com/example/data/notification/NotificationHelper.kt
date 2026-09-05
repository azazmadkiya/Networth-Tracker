package com.example.data.notification

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.MainActivity
import com.example.R
import com.example.data.model.FinancialReminder

object NotificationHelper {

    const val CHANNEL_ID = "net_worth_reminders_channel"
    const val CHANNEL_NAME = "Portfolio & Payment Reminders"
    const val CHANNEL_DESCRIPTION = "Alerts for upcoming SIP payments, EMI dues, and financial portfolio updates"

    fun initNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance).apply {
                description = CHANNEL_DESCRIPTION
                enableVibration(true)
            }
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
            notificationManager?.createNotificationChannel(channel)
        }
    }

    fun hasNotificationPermission(context: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
    }

    fun hasMicrophonePermission(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun sendNotification(
        context: Context,
        title: String,
        content: String,
        notificationId: Int = (System.currentTimeMillis() % 10000).toInt()
    ): Boolean {
        initNotificationChannel(context)

        if (!hasNotificationPermission(context)) {
            return false
        }

        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(
            context,
            notificationId,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification_bell)
            .setContentTitle(title)
            .setContentText(content)
            .setStyle(NotificationCompat.BigTextStyle().bigText(content))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
        notificationManager?.notify(notificationId, builder.build())
        return true
    }

    fun sendTestNotification(context: Context): Boolean {
        return sendNotification(
            context = context,
            title = "🔔 Portfolio Alerts Active",
            content = "Notifications & Reminders are successfully configured! You will receive timely alerts for upcoming EMI and SIP due dates.",
            notificationId = 1001
        )
    }

    fun notifyReminder(context: Context, reminder: FinancialReminder): Boolean {
        val amountStr = if (reminder.amount > 0) " (Budget: ₹ ${String.format("%.0f", reminder.amount)})" else ""
        val typeName = com.example.data.model.ReminderType.fromString(reminder.reminderType).displayName
        val currentEpochDay = System.currentTimeMillis() / 86400000L
        val daysDiff = reminder.dueDateEpochDay - currentEpochDay
        val isEvent = reminder.isEvent || reminder.reminderType == com.example.data.model.ReminderType.EVENT_REMINDER.name

        val dueDesc = when {
            daysDiff < 0 -> if (isEvent) "Event was ${-daysDiff} days ago" else "Overdue by ${-daysDiff} days"
            daysDiff == 0L -> if (isEvent) "Event is Today! 🎉" else "Due today!"
            daysDiff == 1L -> if (isEvent) "Event is Tomorrow!" else "Due tomorrow"
            else -> if (isEvent) "Upcoming Event in $daysDiff days" else "Due in $daysDiff days"
        }

        val title = if (isEvent) "📅 Event Reminder: ${reminder.title}" else "⏰ $typeName: ${reminder.title}"
        val notesSuffix = if (reminder.notes.isNotBlank()) " • ${reminder.notes}" else ""
        val venueSuffix = if (reminder.associatedAccount.isNotBlank()) " @ ${reminder.associatedAccount}" else ""
        val content = "$dueDesc$amountStr$venueSuffix$notesSuffix (${reminder.frequency}). Tap to view."

        return sendNotification(
            context = context,
            title = title,
            content = content,
            notificationId = (reminder.id.hashCode() and 0x7FFFFFFF)
        )
    }
}
