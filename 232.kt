class MyQueue() {

    val stackA = ArrayDeque<Int>()
    val stackB = ArrayDeque<Int>()
    var front = -1
    
    fun push(x: Int) {
        if (stackA.isEmpty()) front = x
        stackA.add(x)
    }

    fun pop(): Int {
        if (stackB.isEmpty()){
            while(stackA.isNotEmpty()){
                stackB.add(stackA.removeLast())
            }
        }
        return stackB.removeLast()
    }

    fun peek(): Int {
        return if (stackB.isNotEmpty()) stackB.last
        else front
    }

    fun empty(): Boolean {
        return stackA.isEmpty() && stackB.isEmpty()
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */