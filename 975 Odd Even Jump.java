class Solution {
    //time complexity nlog(n)
    public int oddEvenJumps(int[] A) {
        //from right to left dp

        //dp[i][0] represents reach n-1 from i at odd jump
        //dp[i][1] represents reach n-1 from i at even jump
        boolean[][] dp = new boolean[A.length][2];
        //because we need to fetch the next greater number
        //or next smaller number at the righter side
        //at log(n) complexity
        //we can use TreeMap and dp right to left to implement

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int len = A.length;
        map.put(A[len-1], len-1);
        int count = 1;

        dp[len-1][0] = true;
        dp[len-1][1] = true;

        for (int i = len - 2; i >= 0; i--) {
            //next greater for update odd
            Integer nextGreater = map.ceilingKey(A[i]);
            if (nextGreater != null) {
                dp[i][0] = dp[map.get(nextGreater)][1];
            }

            //next smaller for update even
            Integer nextSmaller = map.floorKey(A[i]);
            if (nextSmaller != null) {
                dp[i][1] = dp[map.get(nextSmaller)][0];
            }
            map.put(A[i],i);

            //to update only see this point as first jump
            //which is dp[i][0]
            count += dp[i][0] ? 1: 0;
        }

        return count;
    }
}