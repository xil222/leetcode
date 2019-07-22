//use bfs to solve this problem
//check one spot has shortest overall distance to all buildings is the same find one spot that
//is the shortest distance from sum of distance of all the buildings
//set up two 2d array, 1 stores totalDistance from buildings, another check whether spot reached by all buildings
//so we traverse from building
//average time complexity is O(n^2), space complexity is O(n^2)
// beats 43%

class Solution {
    int[] dirX = new int[]{-1,0,0,1};
    int[] dirY = new int[]{0,-1,1,0};

    class Pair {
        int row;
        int col;
        public Pair (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int height = grid.length;
        int width = grid[0].length;

        int[][] reachByBuildings = new int[height][width];
        int[][] totalDistance = new int[height][width];

        int building = 0;

        //iterate the entire grid to fill numbers of reachByBuildings and totalDistance matrices
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    building++;
                    boolean[][] visited = new boolean[height][width];
                    Queue<Pair> queue = new LinkedList<Pair>();
                    queue.offer(new Pair(i, j));
                    visited[i][j] = true; //update the visited right after the queue is optimal
                    int dis = 0;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int num = 0; num < size; num++) {
                            Pair tmp = queue.poll();
                            int currR = tmp.row;
                            int currC = tmp.col;
                            reachByBuildings[currR][currC]++;
                            totalDistance[currR][currC] += dis; //remember is += here
                            for (int k = 0; k < 4; k++) {
                                int newR = currR + dirX[k];
                                int newC = currC + dirY[k];
                                if (isValid(grid, visited, newR, newC)) {
                                    visited[newR][newC] = true;
                                    queue.offer(new Pair(newR, newC));
                                }
                            }
                        }
                        dis++; //be care for the position of this step
                    }
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (reachByBuildings[i][j] == building && grid[i][j] == 0) {
                    minDistance = Math.min(minDistance, totalDistance[i][j]);
                }
            }
        }

        return minDistance == Integer.MAX_VALUE? -1: minDistance;
    }

    //check whether one spot is valid
    private boolean isValid(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }
        return grid[row][col] == 0 && !visited[row][col]? true: false;
    }
}