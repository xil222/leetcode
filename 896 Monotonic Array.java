class Solution {
    public boolean isMonotonic(int[] A) {
        int increase = 0;
        int decrease = 0;

        while (increase < A.length - 1 && A[increase] <= A[increase+1]) {
            increase++;
        }

        while (decrease < A.length - 1 && A[decrease] >= A[decrease+1]) {
            decrease++;
        }

        return increase == A.length - 1 || decrease == A.length - 1;
    }
}