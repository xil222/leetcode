//the naive solution O(n^2) * (m + n) trying on all possible bombs in O(n^2)
//and another O(n + m) to extend see how many enemies

//enemies killed at (i,j) equals enemies kill at row i, col j

//time complexity in average is O(mn), space complexity is O(n)

//to optimize from naive to better solution, we find that when iterating to right
//if calculate row --> only if first col or last col index is 'W' should be keep to the right

//if go from top to bot -> only update when first row, or last row index is 'W' to the next 'W' or
//to the end --> so for an entire col number of updates at most is at most col values

//current solution is
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int maxHits = 0;
        int rowHits = 0;
        int[] colHits = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //update row hits only when is the first col or the col before is 'W'
                if (grid[i][j] == 'W') continue;

                if (j == 0 || grid[i][j-1] == 'W') {
                    rowHits = calculateRow(grid, i, j);
                }

                //update col hits only when is the first row or the row before is 'W'
                if (i == 0 || grid[i-1][j] == 'W') {
                    colHits[j] = calculateCol(grid, i, j);
                }

                //update max hits when it is 0
                if (grid[i][j] == '0') maxHits = Math.max(maxHits, rowHits + colHits[j]);
            }
        }
        return maxHits;
    }

    private int calculateRow(char[][] grid, int row, int col) {
        int cnt = 0;
        for (int i = col; i < grid[0].length; i++) {
            if (grid[row][i] == 'W') {
                return cnt;
            } else if (grid[row][i] == 'E') {
                cnt++;
            }
        }
        return cnt;
    }

    private int calculateCol(char[][] grid, int row, int col) {
        int cnt = 0;
        for (int i = row; i < grid.length; i++) {
            if (grid[i][col] == 'W') {
                return cnt;
            } else if (grid[i][col] == 'E') {
                cnt++;
            }
        }
        return cnt;
    }
}