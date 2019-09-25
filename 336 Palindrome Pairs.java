class Solution {
    //Time Complexity is optimized to O(nk)
    class TrieNode {
        TrieNode[] next;
        int index; //use non -1 val to represent the index of word
        List<Integer> list; //list is storing word with after current index to be parlindrome

        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<Integer>();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        //for this problem, we have naive solution of O(n^2 * k)
        //to reach out the complexity of O(n^2) pair of combinations
        //and k length, therefore, overall time complexity is O(n^2 * k)

        //in order to save duplicate actions, we implement trie tree
        //to reduce number of steps in setting up the tree

        //basic idea is first build trie tree by appending nodes from
        //last digit to first digit

        List<List<Integer>> result = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            searchWord(root, words[i], i, result);
        }
        return result;
    }

    private void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';

            if (root.next[j] == null) {
                root.next[j] = new TrieNode();
            }

            if (isParlindrome(word, 0, i)) {
                root.list.add(index);
            }

            root = root.next[j];
        }

        root.list.add(index);
        root.index = index;
    }

    private void searchWord(TrieNode root, String word, int index, List<List<Integer>> result) {
        //2  conditions:
        //1. We traverse in the tree, if node is end of one word plus
        //the rest of the current word is parlindrome, we append
        //2. After we finish the traversal of one tree, check all index of list
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.index > -1 && root.index != index && isParlindrome(word, i, word.length()-1)) {
                result.add(Arrays.asList(index, root.index));
            }

            root = root.next[idx];
            if (root == null) return;
        }

        for (int i: root.list) {
            if (i != index) result.add(Arrays.asList(index, i));
        }
    }

    private boolean isParlindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }

        return true;
    }

}