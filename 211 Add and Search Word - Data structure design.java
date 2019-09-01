class WordDictionary {

    class TrieNode {
        boolean isWord;
        TrieNode[] nodes;
        public TrieNode() {
            isWord = false;
            nodes = new TrieNode[26];
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = (int) (word.charAt(i) - 'a');
            if (curr.nodes[idx] == null) {
                curr.nodes[idx] = new TrieNode();
            }
            curr = curr.nodes[idx];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }

        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.nodes[i] != null && dfs(node.nodes[i], word, index+1)) { //find one match will make return true
                    return true;
                }
            }
            return false;
        } else {
            int idx = (int) (word.charAt(index) - 'a');
            if (node.nodes[idx] != null) {
                return dfs(node.nodes[idx], word, index+1); //only one option, so just return
            } else {
                return false;
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */