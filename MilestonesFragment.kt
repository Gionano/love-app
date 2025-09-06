import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

data class Milestone(
    val title: String,
    val date: Date,
    val description: String
)

class MilestonesFragment : Fragment() {
    
    private lateinit var milestonesRecyclerView: RecyclerView
    private lateinit var addMilestoneButton: Button
    private lateinit var milestoneAdapter: MilestoneAdapter
    private val milestones = ArrayList<Milestone>()
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_milestones, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        milestonesRecyclerView = view.findViewById(R.id.milestonesRecyclerView)
        addMilestoneButton = view.findViewById(R.id.addMilestoneButton)
        
        setupRecyclerView()
        addSampleMilestones()
        
        addMilestoneButton.setOnClickListener {
            showAddMilestoneDialog()
        }
    }
    
    private fun setupRecyclerView() {
        milestoneAdapter = MilestoneAdapter(milestones)
        milestonesRecyclerView.layoutManager = LinearLayoutManager(context)
        milestonesRecyclerView.adapter = milestoneAdapter
    }
    
    private fun addSampleMilestones() {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        milestones.addAll(listOf(
            Milestone("First Date", dateFormat.parse("2024-02-14")!!, "Our magical first date at the cozy café"),
            Milestone("First Kiss", dateFormat.parse("2024-02-20")!!, "Under the starlit sky in the park"),
            Milestone("Said 'I Love You'", dateFormat.parse("2024-04-15")!!, "The moment we knew it was real"),
            Milestone("Anniversary", dateFormat.parse("2025-02-14")!!, "One year of beautiful memories together")
        ))
        milestoneAdapter.notifyDataSetChanged()
    }
    
    private fun showAddMilestoneDialog() {
        // In a real app, this would show a dialog to add new milestones
        // For this example, we'll add a sample milestone
        val newMilestone = Milestone(
            "New Memory", 
            Date(), 
            "A special moment we'll always remember"
        )
        milestones.add(0, newMilestone)
        milestoneAdapter.notifyItemInserted(0)
    }
}