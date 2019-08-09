class Solution {

    int[][] dirS = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    //basic approach time complexity is O(m^2*n^2)
    //with pq can be O(mnlog(mn))

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.offer(new int[]{i,j,matrix[i][j]});
            }
        }

        int[][] dp = new int[m][n];
        int maxLen = 1;

        //go from high distance to low distance
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int x = tmp[0];
            int y = tmp[1];
            dp[x][y] = 1;
            for (int[] d: dirS) {
                int newX = x + d[0];
                int newY = y + d[1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || matrix[x][y] >= matrix[newX][newY]) {
                    continue;
                }
                dp[x][y] = Math.max(dp[x][y], dp[newX][newY] + 1);
            }
            maxLen = Math.max(dp[x][y], maxLen);
        }

        return maxLen;
    }
}