class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //The goal of this problem is counting number of subarrays
        //that is less than K. Since we have assumption that
        //all numbers are positive therefore the more elements
        //we have, the greater our product is.

        //using two pointers, we maintain a dynamic product from
        //some part of array to the other end
        int count = 0;
        int product = 1;
        int start = 0;
        int end = 0;

        while (end < nums.length) {
            product *= nums[end++];
            while (product >= k && start < end) {
                product /= nums[start++];
            }

            //we only need to update in the end
            //the number of subarray ending with end index
            //which is end - start
            count += end - start;
        }
        return count;
    }
}