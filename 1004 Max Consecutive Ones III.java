class Solution {
    public int longestOnes(int[] A, int K) {
        //use sliding window, count nubmer of 0s within a window frame
        //O(n) time complexity
        int maxLen = 0;
        int countZero = 0;
        int start = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                countZero++;
            }
            while (countZero > K) {
                if (A[start++] == 0) {
                    countZero--;
                }
            }
            maxLen = Math.max(i - start + 1, maxLen);
        }
        return maxLen;
    }
}