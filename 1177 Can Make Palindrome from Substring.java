class Solution {
    //Time: O(S+Q)
    //Space: O(S)
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        //for this problem, each of the String is counted individually
        //keep in mind that we can rearrange the string
        //therefore, we need to count number of each char
        //we can save computation of counting number of each char using dp

        List<Boolean> result = new ArrayList<>();
        int[][] dp = new int[s.length() + 1][26];

        for (int i = 0; i < s.length(); i++) {
            dp[i+1] = dp[i].clone();
            dp[i+1][s.charAt(i)-'a']++;
        }

        //check number of changes needed
        for (int[] q: queries) {
            int cnt = 0;
            for (int i = 0; i < 26; i++) {
                cnt += (dp[q[1]+1][i] - dp[q[0]][i]) % 2;
            }
            result.add(cnt/2 <= q[2]);
        }

        return result;
    }
}