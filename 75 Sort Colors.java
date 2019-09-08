class Solution {
    //two pointers, swap 0 to the front, both pointers move forward
    //if 1 move curr pointer
    //if 2, swap with right pointer, current pointer not moving
    //Use O(n) time complexity to handle this input array
    public void sortColors(int[] nums) {
        int left = 0; //indexes left side of left are all 0's
        int right = nums.length - 1; //indexes right side of right are all 2's
        int curr = 0;
        while (curr <= right) {
            if (nums[curr] == 0) {
                swap(nums, left, curr);
                left++;
                curr++;
            } else if (nums[curr] == 1) {
                curr++;
            } else {
                swap(nums, curr, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}