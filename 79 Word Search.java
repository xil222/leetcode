class Solution {
    //this problem requires dfs, to search for each of the word
    //Time complexity: O(n^2 * m^2), Space complexity: O(n^2)
    int[] dirX = new int[]{-1, 0, 0, 1};
    int[] dirY = new int[]{0, -1, 1, 0};

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        } else if (board.length == 0 || board[0].length == 0) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, visited, 0, word)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(int row, int col, char[][] board, boolean[][] visited, int idx, String word) {
        if (idx == word.length()) {
            return true;
        }

        if (row < 0 || row >= visited.length || col < 0 || col >= visited[0].length) {
            return false;
        } else if (visited[row][col]) {
            return false;
        } else if (word.charAt(idx) != board[row][col]) {
            return false;
        }

        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int newRow = row + dirX[i];
            int newCol = col + dirY[i];
            if (dfs(newRow, newCol, board, visited, idx+1, word)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}