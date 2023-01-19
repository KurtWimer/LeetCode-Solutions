class Solution {
    lateinit var candidates : List<Int>
    val ans = mutableListOf<List<Int>>()

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        if (candidates.size == 0) return emptyList<List<Int>>()
        //sort the list for early escape
        this.candidates = candidates.sorted()
        dfs(0, target, emptyList<Int>())
        return ans
    }

    fun dfs(startIndex: Int, target: Int, combination: List<Int>) {
        if (target == 0) {
            ans.add(combination)
        }
        for (i in startIndex until candidates.size){
            //ensures we never call the function such that target < 0
            //possible because list is sorted
            if (candidates[i] > target) break 
            dfs(i, target-candidates[i], combination + candidates[i])
        }
    }
}