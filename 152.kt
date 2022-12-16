class Solution {
    fun maxProduct(nums: IntArray): Int {
        var result = nums[0]
        var max = nums[0]
        var min = nums[0]
        for (i in 1 until nums.size){
            val num = nums[i]
            if (num > result) result = num
            val nMax = max(max*num, min*num, num)
            min = min(max*num, min*num, num)
            max = nMax
            result = Math.max(max, result) 
        }
        return result
    }

    //Utilizing vararg for only max and not min function resulted in 14% performance increase
    //theoretically it would be optimal to use for both or neither I suspect something is happening with compiler optimizations
    fun max(vararg nums: Int) : Int {
        var result = Integer.MIN_VALUE
        nums.forEach {result = Math.max(result, it)}
        return result
    }

    fun min(a: Int, b: Int, c: Int) : Int {
        return Math.min(a, Math.min(b, c))
    }
}