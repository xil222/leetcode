// key: expand from land to all its reachable land label as visited and increase count of island by 1
class Solution {

    int[] dirX = {-1,0,0,1};
    int[] dirY = {0,-1,1,0};

    //use bfs to traverse to see all islands
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] || grid[i][j] == '0') {
                    continue;
                } else {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] tmp = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int newX = tmp[0] + dirX[k];
                            int newY = tmp[1] + dirY[k];
                            if (isValid(grid, newX, newY) && grid[newX][newY] == '1' && !visited[newX][newY]) {
                                queue.offer(new int[]{newX, newY});
                                visited[newX][newY] = true;
                            }
                        }
                    }
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isValid(char[][] grid, int newX, int newY) {
        if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {
            return false;
        }
        return true;
    }

}