class Solution {
    public int maximalSquare(char[][] matrix) {

        //border check
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxArea = 0;

        //dp[i][j] represents the max perimeter square with position i,j as the right bot corner
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else { //matrix[i][j] == 1, and
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        int minLen = Math.min(dp[i-1][j], dp[i-1][j-1]);
                        minLen = Math.min(dp[i][j-1], minLen);
                        dp[i][j] = minLen + 1;
                    }
                    maxArea = Math.max(dp[i][j] * dp[i][j], maxArea);
                }
            }
        }

        return maxArea;
    }
}