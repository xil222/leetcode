class Solution {
    //go over a small example, 1, 1, 2, 3
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];

        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[0] = 1;
        //dp[n] represents number of decoding ways
        //at nth idx of String s
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }
            if (i >= 2) {
                int num = Integer.valueOf(s.substring(i-2, i));
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i-2];
                }
            }
        }



        return dp[s.length()];
    }
}

//2nd time
public int numDecodings(String s) {
    if (s.length() == 0 || s.charAt(0) == '0') {
        return 0;
    }

    int[] dp = new int[s.length()+1];

    //dp[i] represents num of Decoding, using i chars
    //when updating dp[i] we check dp[i-1] and dp[i]

    dp[0] = 1;

    for (int i = 1; i <= s.length(); i++) {
        if (s.charAt(i-1) != '0') {
            dp[i] += dp[i-1];
        }

        if (i >= 2) {
            int val = Integer.valueOf(s.substring(i-2, i));
            if (val >= 10 && val <= 26) {
                dp[i] += dp[i-2];
            }
        }
    }

    return dp[s.length()];
}