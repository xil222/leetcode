class Solution {
    //Naive solution, for each of the word, do dfs
    //on the entire board assume board size m * n, there are k words, assume each with length h
    //total time complexity is O(m^2 * n^2 * k),
    //b/c we are doing the same thing for each word, this approach is not efficient
    //we want while traversing through the board, check for all the words
    //we can optimize the time complexity to O(m ^ 2 * n ^ 2 + k * h)

    class TrieNode {
        String word; //whether at this node is the end of one word
        TrieNode[] nodes;

        public TrieNode() {
            word = "";
            nodes = new TrieNode[26];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        //steps for this problem, set up
        //build the TrieNode
        TrieNode root = new TrieNode();

        //build trie tree based according to the words dictionary
        for (String s: words) {
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                int idx = (int) (s.charAt(i) - 'a');
                if (curr.nodes[idx] == null) {
                    curr.nodes[idx] = new TrieNode();
                }
                curr = curr.nodes[idx];
            }
            curr.word = s;
        }

        List<String> result = new ArrayList<>();

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, visited, board, root, result);
            }
        }

        return result;
    }

    private void dfs(int row, int col, boolean[][] visited, char[][] board, TrieNode node, List<String> result) {
        if (visited[row][col]) {
            return;
        }

        char c = board[row][col];
        int idx = (int) (c - 'a');
        if (node.nodes[idx] == null) {
            return;
        }

        node = node.nodes[idx];

        if (!node.word.isEmpty()) {
            result.add(node.word);
            node.word = "";
        }

        visited[row][col] = true;

        if (row > 0) dfs(row - 1, col, visited, board, node, result);
        if (col > 0) dfs(row, col - 1, visited, board, node, result);
        if (row < visited.length - 1) dfs(row + 1, col, visited, board, node, result);
        if (col < visited[0].length - 1) dfs(row, col + 1, visited, board, node, result);

        visited[row][col] = false;
    }
}