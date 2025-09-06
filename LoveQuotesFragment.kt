// LoveQuotesFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlin.random.Random

class LoveQuotesFragment : Fragment() {
    
    private lateinit var quoteText: TextView
    private lateinit var authorText: TextView
    private lateinit var heartIcon: ImageView
    private lateinit var newQuoteButton: Button
    
    private val loveQuotes = listOf(
        Pair("Love is not about how many days, months, or years you have been together. Love is about how much you love each other every single day.", "Unknown"),
        Pair("Being deeply loved by someone gives you strength, while loving someone deeply gives you courage.", "Lao Tzu"),
        Pair("The best thing to hold onto in life is each other.", "Audrey Hepburn"),
        Pair("Love is when the other person's happiness is more important than your own.", "H. Jackson Brown Jr."),
        Pair("In all the world, there is no heart for me like yours. In all the world, there is no love for you like mine.", "Maya Angelou"),
        Pair("You know you're in love when you can't fall asleep because reality is finally better than your dreams.", "Dr. Seuss"),
        Pair("Love is composed of a single soul inhabiting two bodies.", "Aristotle"),
        Pair("The greatest happiness of life is the conviction that we are loved.", "Victor Hugo")
    )
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_love_quotes, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        quoteText = view.findViewById(R.id.quoteText)
        authorText = view.findViewById(R.id.authorText)
        heartIcon = view.findViewById(R.id.heartIcon)
        newQuoteButton = view.findViewById(R.id.newQuoteButton)
        
        displayRandomQuote()
        
        newQuoteButton.setOnClickListener {
            displayRandomQuote()
            animateHeart()
        }
        
        heartIcon.setOnClickListener {
            animateHeart()
        }
    }
    
    private fun displayRandomQuote() {
        val randomQuote = loveQuotes.random()
        quoteText.text = randomQuote.first
        authorText.text = "- ${randomQuote.second}"
    }
    
    private fun animateHeart() {
        val scaleX = ObjectAnimator.ofFloat(heartIcon, "scaleX", 1f, 1.3f, 1f)
        val scaleY = ObjectAnimator.ofFloat(heartIcon, "scaleY", 1f, 1.3f, 1f)
        
        scaleX.duration = 600
        scaleY.duration = 600
        scaleX.interpolator = AccelerateDecelerateInterpolator()
        scaleY.interpolator = AccelerateDecelerateInterpolator()
        
        scaleX.start()
        scaleY.start()
    }
}
