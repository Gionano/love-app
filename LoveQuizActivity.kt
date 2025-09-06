import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoveQuizActivity : AppCompatActivity() {
    
    private lateinit var partnerName1: EditText
    private lateinit var partnerName2: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultText: TextView
    private lateinit var compatibilityBar: ProgressBar
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_love_quiz)
        
        initViews()
        setupClickListeners()
    }
    
    private fun initViews() {
        partnerName1 = findViewById(R.id.partnerName1)
        partnerName2 = findViewById(R.id.partnerName2)
        calculateButton = findViewById(R.id.calculateButton)
        resultText = findViewById(R.id.resultText)
        compatibilityBar = findViewById(R.id.compatibilityBar)
    }
    
    private fun setupClickListeners() {
        calculateButton.setOnClickListener {
            calculateCompatibility()
        }
    }
    
    private fun calculateCompatibility() {
        val name1 = partnerName1.text.toString().trim()
        val name2 = partnerName2.text.toString().trim()
        
        if (name1.isEmpty() || name2.isEmpty()) {
            Toast.makeText(this, "Please enter both names! 💕", Toast.LENGTH_SHORT).show()
            return
        }
        
        val percentage = LoveCalculator.calculateLovePercentage(name1, name2)
        val message = LoveCalculator.getLoveMessage(percentage)
        
        // Animate the progress bar
        compatibilityBar.progress = 0
        compatibilityBar.visibility = View.VISIBLE
        
        val animator = android.animation.ObjectAnimator.ofInt(compatibilityBar, "progress", 0, percentage)
        animator.duration = 2000
        animator.start()
        
        resultText.text = "$name1 💕 $name2\n\n$percentage% Compatible!\n\n$message"
        resultText.visibility = View.VISIBLE
    }
}