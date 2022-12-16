class Solution {
    lateinit var mem : List<MutableList<Boolean?>>
    lateinit var mNums : IntArray
    fun canPartition(nums: IntArray): Boolean {
        val totalSum = nums.sum()
        if (totalSum % 2 != 0) return false
        val targetSum = totalSum shr 1
        mNums = nums
        mem = List(nums.size+1) { MutableList<Boolean?>(targetSum + 1) {null} }
        mem[0][0] = true

        return dfs(nums.size-1, targetSum)
    }

    fun dfs(index: Int, target: Int) : Boolean {
        //out of bounds
        if (target < 0 || index < 0) return false
        //check memory
        if (mem[index][target] != null) return mem[index][target]!!
        val curr = mNums[index]
        mem[index][target] = dfs(index-1, target - curr) || dfs(index-1, target)
        return mem[index][target]!!
    }
}