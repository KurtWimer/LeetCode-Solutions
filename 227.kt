class Solution {
    fun calculate(s: String): Int {
        val stack = ArrayDeque<Int>()
        var operation = '+'
        var curNum = 0
        for (i in s.indices){          
            if (s[i].isDigit()){
                curNum = curNum  * 10 + s[i].toInt() - '0'.toInt()
            }
            if ((!s[i].isDigit() && s[i] != ' ')|| i == s.length-1){
                if (operation == '+'){
                    stack.add(curNum)
                }
                else if (operation == '-'){
                    stack.add(-curNum)
                }
                else if (operation == '*'){
                    stack.add(stack.removeLast() * curNum)
                }
                else if (operation == '/'){
                    stack.add(stack.removeLast() / curNum)
                }
                operation = s[i]
                curNum = 0
            }
        }
        return stack.sum()
    }
}