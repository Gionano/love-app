import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class MilestoneAdapter(private val milestones: List<Milestone>) : 
    RecyclerView.Adapter<MilestoneAdapter.MilestoneViewHolder>() {
    
    private val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
    
    class MilestoneViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleText: TextView = view.findViewById(R.id.milestoneTitle)
        val dateText: TextView = view.findViewById(R.id.milestoneDate)
        val descriptionText: TextView = view.findViewById(R.id.milestoneDescription)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MilestoneViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_milestone, parent, false)
        return MilestoneViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: MilestoneViewHolder, position: Int) {
        val milestone = milestones[position]
        holder.titleText.text = milestone.title
        holder.dateText.text = dateFormat.format(milestone.date)
        holder.descriptionText.text = milestone.description
    }
    
    override fun getItemCount() = milestones.size
}
