class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val ans = mutableListOf<IntArray>()
        var index = 0
        var start = newInterval[0]
        var end = newInterval[1]

        //handle edge case of empty list

        //find start value for new interval
        while (index < intervals.size && intervals[index][1] < start){
            ans.add(intervals[index])
            index++
        }
        if (index < intervals.size) start = Math.min(start, intervals[index][0])
        //find end value for new interval
        while (index < intervals.size && intervals[index][0] <= end){
            index++
        }
        if (index > 0){
            end = Math.max(end, intervals[index-1][1])
        }
        //insert new interval
        ans.add(intArrayOf(start, end))
        //add remaining alements to ans
        while(index < intervals.size){
            ans.add(intervals[index])
            index++
        }
        return ans.toTypedArray()
    }
}