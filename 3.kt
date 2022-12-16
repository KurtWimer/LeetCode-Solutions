class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length < 2) return s.length
        var start = 0
        var maxSize = 0
        val map = mutableMapOf<Char, Int>()
        for(end in s.indices){
            val ch = s[end]
            if (map[ch] != null) start = Math.max(start, map[ch]!!)
            if (end-start+1 > maxSize) maxSize = end-start+1
            map[ch] = end + 1
        }
        return maxSize
    }
}