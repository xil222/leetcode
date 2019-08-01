//O(n) time complexity
class Solution {
    public int numDecodings(String s) {
        //still use dynamic programming
        //because evey time we update numDecodings
        //at pos x only depends on pos x-1 and x-2

        long[] dp = new long[s.length()+1];
        if (s.charAt(0) == '0') {
            return 0;
        }

        //dp[n] still represents number of decode ways till index
        //n of string s.
        dp[0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i-1) >= '1' && s.charAt(i-1) <= '9') {
                dp[i] = dp[i-1];
            } else if (s.charAt(i-1) == '*') {
                dp[i] = 9 * dp[i-1];
            }

            if (i >= 2) {
                if (s.charAt(i-1) == '*' && s.charAt(i-2) == '*') {
                    //** represents 11-19 21-26
                    dp[i] += 15 * dp[i-2];
                } else if (s.charAt(i-1) == '*') {
                    //1* 9 possibilities
                    //2* 6 possibilities
                    if (s.charAt(i-2) == '1') {
                        dp[i] += 9 * dp[i-2];
                    } else if (s.charAt(i-2) == '2') {
                        dp[i] += 6 * dp[i-2];
                    }
                } else if (s.charAt(i-2) == '*') {
                    //*0~6 2 possibilities
                    //*7~9 one possibility
                    if (s.charAt(i-1) >= '0' && s.charAt(i-1) <= '6') {
                        dp[i] += 2 * dp[i-2];
                    } else {
                        dp[i] += dp[i-2];
                    }
                } else {
                    int val = Integer.valueOf(s.substring(i-2, i));
                    if (val >= 10 && val <= 26) {
                        dp[i] += dp[i-2];
                    }
                }
            }
            dp[i] %= 1000000007;
        }
        return (int)dp[s.length()];
    }
}