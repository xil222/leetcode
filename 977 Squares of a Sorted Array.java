class Solution {
    public int[] sortedSquares(int[] A) {

        int[] res = new int[A.length];
        int start = 0;
        int end = A.length - 1;

        for (int i = A.length - 1; i >= 0; i--) {
            if (Math.abs(A[start]) > Math.abs(A[end])) {
                res[i] = A[start] * A[start];
                start++;
            } else {
                res[i] = A[end] * A[end];
                end--;
            }
        }

        return res;
    }
}