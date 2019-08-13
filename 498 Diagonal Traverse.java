class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        //figure out the way to traverse the matrix
        //based on the two directions
        //if col >= n, then row must be off
        //if row >= m, col must be off as well
        //however, if row is off doesn't
        //necessary mean the col is off

        //so we define our conditions: --> all need to change direction
        //col >= n, col = n-1, row = row + 2;
        //row >= m, row = m-1, col = col + 2;
        //row < 0, row = 0
        //col < 0, col = 0

        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] result = new int[m*n];
        int[][] dirs = {{-1, 1}, {1, -1}};
        int dir = 0, col = 0, row = 0;

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row += dirs[dir][0];
            col += dirs[dir][1];

            if (row >= m) {
                row = m - 1;
                col = col + 2;
                dir = 1 - dir;
            }
            if (col >= n) {
                row = row + 2;
                col = n - 1;
                dir = 1 - dir;
            }
            if (row < 0) {
                row = 0;
                dir = 1 - dir;
            }
            if (col < 0) {
                col = 0;
                dir = 1 - dir;
            }

        }

        return result;
    }
}