class UnionFind(val size: Int){
    val parents = MutableList<Int>(size) {it}
    val rank = MutableList<Int>(size) {1}

    fun find(index: Int) : Int {        
        return if (index != parents[index]){
            var parent = find(parents[index])
            parents[index] = parent
            parent
        }
        else index
    }
    
    fun union(a: Int, b: Int){
        val parentA = find(a)
        val parentB = find(b)
        if (parentA == parentB) return
        else if (rank[parentA] < rank[parentB]){
            parents[parentA] = parentB
        }
        else if (rank[parentA] > rank[parentB]){
            parents[parentB] = parentA
        }
        else{
            parents[parentB] = parentA
            rank[parentA]++
        }
    }

    fun numProvinces() : Int {
        val countSet = mutableSetOf<Int>()
        for(i in parents.indices){
            countSet.add(find(i))
        }
        return countSet.size
    }
}

class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val uf = UnionFind(isConnected.size)
        for(i in isConnected.indices){
            for(j in isConnected[i].indices){
                if (isConnected[i][j] == 1){
                    uf.union(i, j)
                }
            }
        }
        return uf.numProvinces()
    }
}