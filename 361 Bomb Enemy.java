class Solution {
    //idea is the naive way of solving this problem is O(mn(m+n))
    //includes lots of redundent operations, however, to calculate
    //for example a row, enemies we bomb (1D) just needs O(n)
    //expand the case to 2D.
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int maxCnt = 0;
        int rowCount = 0;
        int[] colCount = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'W') {
                    continue;
                }

                if (i == 0 || grid[i-1][j] == 'W') {
                    colCount[j] = bombCol(grid, i, j);
                }

                if (j == 0 || grid[i][j-1] == 'W') {
                    rowCount = bombRow(grid, i, j);
                }

                if (grid[i][j] == '0') {
                    maxCnt = Math.max(maxCnt, colCount[j] + rowCount);
                }

            }
        }
        return maxCnt;
    }

    private int bombRow(char[][] grid, int row, int col) {
        int cnt = 0;
        while (col < grid[0].length && grid[row][col] != 'W') {
            if (grid[row][col++] == 'E') {
                cnt++;
            }
        }
        return cnt;
    }

    private int bombCol(char[][] grid, int row, int col) {
        int cnt = 0;
        while (row < grid.length && grid[row][col] != 'W') {
            if (grid[row++][col] == 'E') {
                cnt++;
            }
        }
        return cnt;
    }

}
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