// LoveFragmentAdapter.kt
class LoveFragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3
    
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LoveQuotesFragment()
            1 -> MilestonesFragment()
            2 -> MemoriesFragment()
            else -> LoveQuotesFragment()
        }
    }
}
