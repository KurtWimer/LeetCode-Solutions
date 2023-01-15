class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val ans = mutableListOf<IntArray>()
        intervals.sortBy { it[0] }
        if (intervals.size > 0) ans.add(intervals[0])
        for(index in 1 until intervals.size){
            if (intervals[index][0] <= ans.last()[1]){
                ans.last()[1] = Math.max(ans.last()[1], intervals[index][1])
            }
            else{
                ans.add(intervals[index])
            }
        }
        return ans.toTypedArray()
    }
}