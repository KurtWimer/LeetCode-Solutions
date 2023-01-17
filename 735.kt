class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val right = ArrayDeque<Int>()
        val ans = mutableListOf<Int>()
        asteroids.forEach {
            if (it > 0){
                right.add(it)
            }
            else if (collide(it, right)){
                ans.add(it)
            }
        }
        ans.addAll(right)
        return ans.toIntArray()
    }

    //Removes colliding asteroids from stack
    //Return Boolean on if asteroid survives
    fun collide(asteroid: Int, stack: ArrayDeque<Int>) : Boolean {
        val absolute = Math.abs(asteroid)
        //destroy any smaller asteroids
        while(absolute > stack.lastOrNull() ?: Integer.MAX_VALUE){
            stack.removeLast()
        }
        //destroy both equally size asteroids
        return if (absolute == stack.lastOrNull() ?: 0){
            stack.removeLast()
            false
        }
        else if (absolute < stack.lastOrNull() ?: 0) false
        else true
    }
}