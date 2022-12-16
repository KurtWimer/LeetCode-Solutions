class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val totalSum = nums.sum()
        if (totalSum % 2 != 0) return false
        val targetSum = totalSum shr 1
        val mem = MutableList(targetSum + 1) {false}
        mem[0] = true

        for (i in nums.indices){
            val curr = nums[i]
            for (target in targetSum downTo curr){
                if (mem[target-curr] == true) mem[target] = true
            }
        }
        return mem[targetSum]
    }
}