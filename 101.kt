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
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true

        val lQueue = ArrayDeque<TreeNode?>()
        val rQueue = ArrayDeque<TreeNode?>()

        lQueue.add(root.left)
        rQueue.add(root.right)

        while(lQueue.isNotEmpty()){
            val left = lQueue.removeFirst()
            val right = rQueue.removeFirst()
            
            if (!helper(left, right)) return false
            else if (left != null && right != null){
                println("Checking ${left?.`val`} ${right?.`val`}")
                if (left.left != null && right.right != null){
                    lQueue.add(left.left)
                    rQueue.add(right.right)
                } else return false
                if (left.right != null && right.left != null){
                    lQueue.add(left.right)
                    rQueue.add(right.left)
                } else return false
                
            }
        }
        return true
    }

    fun helper(p: TreeNode?, q: TreeNode?) : Boolean {
        return if (p == null && q == null) true
        else if (p==null || q == null) false
        else p.`val` == q.`val`
    }
}