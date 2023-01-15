class MinStack() {
    val stack = ArrayDeque<Int>()
    var minimum = ArrayDeque<Int>()

    fun push(`val`: Int) {
        if (minimum.isEmpty() || `val` <= minimum.last) minimum.add(`val`)
        stack.add(`val`)
    }

    fun pop() {
        val removed = stack.removeLast()
        if (removed == minimum.last) minimum.removeLast()
    }

    fun top(): Int {
        return stack.last
    }

    fun getMin(): Int {
        return minimum.last
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */