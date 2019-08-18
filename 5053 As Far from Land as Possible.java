class Solution {
    class Cell {
        int row;
        int col;
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[] dirX = new int[]{-1, 0, 0, 1};
    int[] dirY = new int[]{0, -1, 1, 0};

    public int maxDistance(int[][] grid) {
        //bfs from all land
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<Cell> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Cell(i, j));
                }
            }
        }
        if (queue.isEmpty() || queue.size() == m * n) {
            return -1;
        }

        int dis = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Cell tmp = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = tmp.row + dirX[j];
                    int newY = tmp.col + dirY[j];
                    if (isValid(grid, newX, newY) && !visited[newX][newY]) {
                        queue.offer(new Cell(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            dis++;
        }

        return dis-1;
    }

    private boolean isValid(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 1) {
            return false;
        }
        return true;
    }

}