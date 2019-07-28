//beats 100% time complexity
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        //the thing for this problem is that we don't have a target for
        //the binary search, move the index -> which won't miss the peak
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) { //case 1 move to the right
                left = mid + 1;
            } else { //case 2 move to left
                right = mid;
            }
        }
        return nums[left] > nums[right]? left : right;
    }
}