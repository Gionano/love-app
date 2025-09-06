import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.*

class LoveWidgetProvider : AppWidgetProvider() {
    
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }
    
    private fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
        val views = RemoteViews(context.packageName, R.layout.love_widget)
        
        // Calculate days together (sample: 6 months ago)
        val startDate = Calendar.getInstance().apply { add(Calendar.MONTH, -6) }.time
        val currentDate = Date()
        val daysTogether = ((currentDate.time - startDate.time) / (1000 * 60 * 60 * 24)).toInt()
        
        views.setTextViewText(R.id.widgetDaysText, "$daysTogether\nDays Together 💕")
        
        // Set up click intent
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        views.setOnClickPendingIntent(R.id.widgetLayout, pendingIntent)
        
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
}
