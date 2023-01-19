class Solution {
    val permutations = mutableListOf<List<Int>>()
    
    fun permute(nums: IntArray): List<List<Int>> {
        permute(nums.toMutableList(), mutableListOf<Int>())
        return permutations
    }

    //Use of mutableList's slightly increases runtime and decreases memory use for minimal added complexity
    fun permute(nums: MutableList<Int>, permutation: MutableList<Int>) {
        if (nums.size == 0){
            permutations.add(permutation.toList())
        }
        for(i in nums.indices){
            val temp = nums.removeAt(i)
            permutation.add(temp)
            permute(nums,permutation)
            permutation.removeAt(permutation.size-1)
            nums.add(i, temp)
        }
    }
}