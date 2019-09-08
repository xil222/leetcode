class Solution {
    //O(n^2) time complexity
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            int start = i;
            int end = i;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                dp[start--][end++] = true;
            }
        }

        for (int i = 0; i < s.length()-1; i++) {
            int start = i;
            int end = i + 1;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                dp[start--][end++] = true;
            }
        }

        int[] opt = new int[s.length()];

        //opt[i] represents minCut to for strings to index i
        //O(n^2) time complexity
        for (int i = 1; i < s.length(); i++) {
            int minCut = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                if (dp[j][i]) {
                    minCut = j == 0?  0: Math.min(minCut, opt[j-1] + 1);
                }
            }
            opt[i] = minCut;
        }

        return opt[s.length()-1];
    }
}