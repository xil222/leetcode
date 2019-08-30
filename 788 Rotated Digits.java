class Solution {
    public int rotatedDigits(int N) {
        //To see if one number is validDigit just to
        //check each part of the component is valid
        //for instance, 2 and 5 is valid -> 25 is valid
        //69 and 5 is valid -> 695 is valid

        //In other words, for i > 10, whether i
        //is rotatedDigits depends on whether i / 10
        //and i % 10.

        //Need to split the edge cases for (0,1,8) and (2,5,6,9)
        int[] dp = new int[N + 1];

        //dp[i] == 1 represents means only composed of (0,1,8)
        //dp[i] == 2 represents means composed of (2,5,6,9)
        int count = 0;
        for (int i = 0; i <= N; i++) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8)
                    dp[i] = 1;
                if (i == 2 || i == 5 || i == 6 || i == 9) {
                    count++;
                    dp[i] = 2;
                }
            } else {
                if (dp[i % 10] == 1 && dp[i / 10] == 1) {
                    dp[i] = 1;
                } else if (dp[i % 10] + dp[i / 10] >= 3) {
                    dp[i] = 2;
                    count++;
                }
            }
        }

        return count;
    }
}