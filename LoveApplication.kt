LoveApplication.kt:
import android.app.Application

class LoveApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        
        // Initialize love notification helper
        val notificationHelper = LoveNotificationHelper(this)
        notificationHelper.createNotificationChannel()
    }
}
