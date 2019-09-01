class Trie {
    //The overall time complexity is O(n)
    //for insert, search, and startwith operations.
    class TrieNode {
        Map<Character, TrieNode> map;
        boolean isWord;
        public TrieNode() {
            isWord = false;
            map = new HashMap<>();
        }
    }
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.map.containsKey(c)) {
                curr.map.put(c, new TrieNode());
            }
            curr = curr.map.get(c);
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.map.containsKey(c)) {
                return false;
            }
            curr = curr.map.get(c);
        }
        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!curr.map.containsKey(c)) {
                return false;
            }
            curr = curr.map.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

//Given the chars range from a-z use array to represent
class Trie {
    //The overall time complexity is O(n)
    //for insert, search, and startwith operations.
    class TrieNode {
        TrieNode[] map;
        boolean isWord;
        public TrieNode() {
            isWord = false;
            map = new TrieNode[26];
        }
    }
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (curr.map[idx] == null) {
                curr.map[idx] = new TrieNode();
            }
            curr = curr.map[idx];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (curr.map[idx] == null) {
                return false;
            }
            curr = curr.map[idx];
        }
        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int idx = c - 'a';
            if (curr.map[idx] == null) {
                return false;
            }
            curr = curr.map[idx];
        }
        return true;
    }
}