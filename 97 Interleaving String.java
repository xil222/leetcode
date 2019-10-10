class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        //We use dp to denote whether we can compose s3 with s1, s2
        //dp[i][j] represents whether we can construct
        //first i + j chars of string s3, using i chars from s1, and
        //j chars from s2

        //the way we update status dp[i][j] depends on
        //checking dp[i-1][j] and compare (i-1)th index of s1 vs (i+j-1)th index of s3
        //and dp[i][j-1] and compare (j-1) index of s2 vs (i+j-1)th index of s3

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        //base case
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }

        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)
                        || dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
            }
        }

        return dp[s1.length()][s2.length()];
    }
}