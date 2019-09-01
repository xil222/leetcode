//use stack method O(n)
class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> pos = new Stack<>();
        int startPos = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                pos.push(i);
            } else {
                //not use ')' and update the current pointer
                if (pos.isEmpty()) {
                    startPos = i;
                } else {
                    //use ')' to match up with one '(' and update the maxLen
                    pos.pop();
                    if (pos.isEmpty()) {
                        maxLen = Math.max(i - startPos, maxLen);
                    } else {
                        maxLen = Math.max(i - pos.peek(), maxLen);
                    }
                }
            }
        }
        return maxLen;
    }
}

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
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i]) > 0 ? dp[i- dp[i]]:0;
                maxLen = Math.max(maxLen, dp[i]);
                cnt--;
            }
        }

        return maxLen;
    }
}