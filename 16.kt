class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val sorted = nums.sorted()
        var diff = Integer.MAX_VALUE
        for (i in 0..sorted.size-2){
            val twoSum = twoSumClosest(sorted, i + 1, target-sorted[i])
            if (Math.abs(diff) > Math.abs(target-sorted[i]-twoSum)){
                diff = target-sorted[i]-twoSum
            }
        }
        return target - diff
    }

    //returns the closest 2Sum to target from the sublist nums[starIndex:]
    //comparison with numbers before is unneccesary because we would have already discovered that combination
    fun twoSumClosest(nums: List<Int>, startIndex: Int, target: Int): Int {
        var start = startIndex
        var end = nums.size-1
        var diff = Integer.MAX_VALUE
        while(start < end){
            if (Math.abs(diff) > Math.abs(target-nums[start]-nums[end])){
                diff = target-nums[start]-nums[end]
            }
            if (diff == 0) return target
            else if (nums[start] + nums[end] > target) end--
            else start++
        }
        return target - diff
    }
}