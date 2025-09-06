import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class MemoriesFragment : Fragment() {
    
    private lateinit var daysTogetherText: TextView
    private lateinit var relationshipStartDate: Date
    private lateinit var loveMessageText: TextView
    private lateinit var generateMessageButton: Button
    
    private val loveMessages = listOf(
        "Every day with you feels like a beautiful dream come true. 💕",
        "You are my sunshine on cloudy days and my anchor in stormy weather. ❤️",
        "In your eyes, I found my home. In your heart, I found my love. 🏠💖",
        "Thank you for being the reason I smile every single day. 😊💕",
        "You make ordinary moments feel extraordinary just by being there. ✨❤️",
        "My love for you grows stronger with each passing moment. 🌹💕",
        "You are not just my partner, you are my best friend and greatest love. 👫💖"
    )
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_memories, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        daysTogetherText = view.findViewById(R.id.daysTogetherText)
        loveMessageText = view.findViewById(R.id.loveMessageText)
        generateMessageButton = view.findViewById(R.id.generateMessageButton)
        
        // Set a sample relationship start date (6 months ago)
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, -6)
        relationshipStartDate = calendar.time
        
        updateDaysTogether()
        displayRandomLoveMessage()
        
        generateMessageButton.setOnClickListener {
            displayRandomLoveMessage()
        }
    }
    
    private fun updateDaysTogether() {
        val currentDate = Date()
        val diffInMillis = currentDate.time - relationshipStartDate.time
        val daysTogether = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS)
        
        daysTogetherText.text = "We've been together for\n$daysTogether beautiful days! 💕"
    }
    
    private fun displayRandomLoveMessage() {
        val randomMessage = loveMessages.random()
        loveMessageText.text = randomMessage
    }
}
