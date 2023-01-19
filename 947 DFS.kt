class Solution {
    fun removeStones(stones: Array<IntArray>): Int {
        val stack = ArrayDeque<Int>()
        val seen = BitSet(stones.size)
        val rows = mutableMapOf<Int, MutableList<Int>>()
        val cols = mutableMapOf<Int, MutableList<Int>>()
        var unremoved = 0
        //create ajacency lists
        for (i in stones.indices){
            val row = stones[i][0]
            val col = stones[i][1]
            if (rows[row] == null) rows[row] = mutableListOf<Int>()
            if (cols[col] == null) cols[col] = mutableListOf<Int>()
            rows[row]!!.add(i)
            cols[col]!!.add(i)
        }

        for (i in stones.indices){
            //identify 'root' stones
            if (!seen[i]) {
                stack.add(i)
                unremoved++
            }
            //dfs remove all connected stones
            while(stack.isNotEmpty()){
                val cur = stack.removeLast()
                //add ajacent stones to stack
                if (!seen[cur]) {
                    seen.set(cur)
                    val row = stones[cur][0]
                    val col = stones[cur][1]
                    rows[row]!!.forEach {
                        stack.add(it)
                    }
                    cols[col]!!.forEach {
                        stack.add(it)
                    }
                }
            }
        }
        return stones.size-unremoved
    }
}