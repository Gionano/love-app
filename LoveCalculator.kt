class LoveCalculator {
    companion object {
        fun calculateLovePercentage(name1: String, name2: String): Int {
            val combined = (name1 + name2).lowercase().replace(" ", "")
            val hash = combined.hashCode()
            return (kotlin.math.abs(hash) % 41) + 60 // Always 60-100% for positivity!
        }
        
        fun getLoveMessage(percentage: Int): String {
            return when {
                percentage >= 90 -> "Soulmates! Perfect match made in heaven! 💕✨"
                percentage >= 80 -> "Amazing compatibility! You two are meant to be! 💖"
                percentage >= 70 -> "Great love connection! Beautiful relationship ahead! 💝"
                else -> "Sweet love story! Every love is unique and special! 💗"
            }
        }
    }
}