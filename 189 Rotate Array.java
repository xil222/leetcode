class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        swapArray(nums, 0, nums.length-1);
        swapArray(nums, 0, k - 1);
        swapArray(nums, k, nums.length - 1);
    }

    private void swapArray(int[] nums, int startIdx, int endIdx) {
        while (startIdx < endIdx) {
            swap(nums, startIdx, endIdx);
            startIdx++;
            endIdx--;
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}