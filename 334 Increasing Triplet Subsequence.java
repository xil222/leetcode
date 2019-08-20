class Solution {
    public boolean increasingTriplet(int[] nums) {
        //for this problem, can only use O(1) space
        //means cannot store all increasing number

        //base case
        if (nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int item: nums) {
            if (item <= first) {
                first = item;
            } else if (item <= second) {
                second = item;
            } else {
                return true;
            }
        }

        return false;
    }
}