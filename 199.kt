/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        val stack = ArrayDeque<Pair<TreeNode?, Int>>()//treenode, depth
        stack.add(Pair(root, 1))
        while(stack.isNotEmpty()){
            val (cur, depth) = stack.removeFirst()
            if (cur == null) continue
            if (depth > ans.size){
                ans.add(cur.`val`)
            }
            stack.add(Pair(cur!!.right, depth + 1))
            stack.add(Pair(cur!!.left, depth + 1))
        }
        return ans
    }
}