import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

class LoveNotificationHelper(private val context: Context) {
    
    companion object {
        const val CHANNEL_ID = "LOVE_REMINDERS"
        const val NOTIFICATION_ID = 1001
    }
    
    private val loveReminders = listOf(
        "Remember to tell them you love them today! 💕",
        "Send a sweet message to your special someone! 📱💖",
        "Plan a surprise for your loved one! 🎁❤️",
        "Share a laugh together today! 😊💕",
        "Give them a warm hug! 🤗💝"
    )
    
    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Love Reminders"
            val descriptionText = "Daily reminders to spread love"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
    
    fun sendLoveReminder() {
        val randomReminder = loveReminders.random()
        
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_heart)
            .setContentTitle("Love Reminder 💕")
            .setContentText(randomReminder)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
        
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }
}