class Solution {
    fun minWindow(s: String, t: String): String {
        //create a map of occurances in t
        val tMap = mutableMapOf<Char, Int>()
        for(ch in t){
            if (tMap[ch] == null) tMap[ch] = 0
            tMap[ch] = tMap[ch]!! + 1
        }
        
        //find an initial window size containing all elements of t
        var remaining = tMap.keys.size
        var end = 0
        while(remaining > 0 && end < s.length){
            if (tMap[s[end]] != null){
                tMap[s[end]] = tMap[s[end]]!! - 1
                if (tMap[s[end]] == 0) remaining--
            }
            if (remaining > 0) end ++
        }

        //return if no valid substring
        if (remaining > 0) return ""

        //shift start to the right until we find local minimum
        var start = -1
        while((tMap[s[++start]] ?: -1) < 0){
            if (tMap[s[start]] != null){
                tMap[s[start]] = tMap[s[start]]!! + 1
            }
        }
        var ans = s.substring(start..end)
        var target = s[start]
        while(end < s.length){
            //shift end to the right until target is found
            while(++end < s.length && s[end] != target){
                if (tMap[s[end]] != null){
                     tMap[s[end]] = tMap[s[end]]!! - 1
                }
            }
            if (end >= s.length) break

            //shift start to the right until we find local minimum
            while((tMap[s[++start]] ?: -1) < 0){
                if (tMap[s[start]] != null){
                    tMap[s[start]] = tMap[s[start]]!! + 1
                }
            }
            target = s[start]!!

            //assign new window if smaller
            if (end - start < ans.length){
                ans = s.substring(start .. end)
            }
        }
        return ans
    }
}