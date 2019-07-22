//use DP beats 100%, O(n^2) time for set up matrix
class NumMatrix {

    //dp[i][j] records the cumulative rectangle sum from (0,0) to (i,j)
    int[][] dp;

    //initialize matrix,takes O(n^2) to set up the matrix
    public NumMatrix(int[][] matrix) {
        if (matrix != null && matrix.length != 0 && matrix[0].length != 0) {
            dp = new int[matrix.length][matrix[0].length];
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[0][0];
                } else if (i == 0) {
                    dp[i][j] = matrix[i][j] + dp[i][j-1];
                } else if (j == 0){
                    dp[i][j] = matrix[i][j] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j] + matrix[i][j] - dp[i-1][j-1];
                }
            }
        }
    }

    //takes O(1) time to compute
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int left = col1 == 0? 0: dp[row2][col1-1];
        int top = row1 == 0? 0: dp[row1-1][col2];
        int topLeft = row1 == 0 || col1 == 0? 0: dp[row1-1][col1-1];

        return dp[row2][col2] - left - top + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */