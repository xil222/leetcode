class Solution {
    public int singleNonDuplicate(int[] nums) {
        //O(logn) time and O(1) space so use binary search
        //search based on the index
        //this problem is not easy to simplify
        //key is design update two pointers satisfy find the res
        //when start == end

        //if index is even:
        //   if same as its left:
        //      then go left
        //   if same as its right:
        //      then go right

        //if index is odd:
        //   if same as its left:
        //      then go right
        //   if same as its right:
        //      then go left

        int start = 0;
        int end = nums.length - 1;

        //since we look for final case when start = end,
        //and we are sure to find one
        //therefore no need to directly handle return case
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 0) { //even digit is 0 and its right is 0, result must be in the right
                if (nums[mid] == nums[mid+1]) {
                    start = mid + 2;
                } else { //mid == mid-1 or unique
                    end = mid;
                }
            } else {
                if (nums[mid] == nums[mid-1]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }

        return nums[start];
    }
}