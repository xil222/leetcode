
//use dp method 6ms O(n), beats 100% + review
class Solution {
    public int longestValidParentheses(String s) {

        //This problem is looking for a longest substring,
        //so we are using sliding window for this problem.

        //use one stack to store the position of '('
        int[] dp = new int[s.length()];
        int maxLen = 0;
        int cnt  = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (cnt > 0){
                dp[i] = dp[i-1] + 2;
                dp[i] += (i - dp[i]) > 0 ? dp[i- dp[i]]:0;
                maxLen = Math.max(maxLen, dp[i]);
                cnt--;
            }
        }

        return maxLen;
    }
}