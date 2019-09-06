class Solution {
    //use dynamic programming for this problem
    //if the last two digits color are the same, the next has k - 1 option
    //if the last two digits color are different, the next
    //we just update the new one with two cases:
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        }

        //at index 2, cases of diff k * (k - 1), cases of same k
        int diff = k * (k - 1);
        int same = k;

        for (int i = 2; i < n; i++) {
            //the number of diff will become number of same
            //update number of diff with number of same and diff
            int tmp = diff;
            diff = (diff + same) * (k - 1);
            same = tmp;
        }

        return diff + same;
    }
}