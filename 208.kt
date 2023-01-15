class Node(){
    var next = HashMap<Char, Node>()
}

class Trie() {
    val root = Node()

    fun insert(word: String) {
        var cur = root
        for(letter in word){
            if (cur.next[letter] == null) {
                cur.next[letter] = Node()
            }
            cur = cur.next[letter]!!
        }
        //add '/' to signify end of word
        if (cur.next['/'] == null) cur.next['/'] = Node()
    }

    fun search(word: String): Boolean {
        var cur = root
        for(letter in word){
            if (cur.next[letter] == null) {
                return false
            }
            cur = cur.next[letter]!!
        }
        return cur.next['/'] != null
    }

    fun startsWith(prefix: String): Boolean {
        var cur = root
        for(letter in prefix){
            if (cur.next[letter] == null) {
                return false
            }
            cur = cur.next[letter]!!
        }
        return true
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */