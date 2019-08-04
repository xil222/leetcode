class Solution {
    public int movesToMakeZigzag(int[] nums) {
        if (nums.length <= 1){
            return 0;
        } else if (nums.length == 2) {
            return nums[0] == nums[1]? 1: 0;
        }

        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i < nums.length; i+=2) {
            if (i == 0) {
                sumOdd += nums[i] > nums[i+1] - 1? nums[i] - (nums[i+1] - 1): 0;
            } else if (i == nums.length -1) {
                sumOdd += nums[i] > nums[i-1] - 1? nums[i] - (nums[i-1] - 1): 0;
            } else {
                sumOdd += nums[i] > Math.min(nums[i-1], nums[i+1]) - 1? nums[i] - Math.min(nums[i-1], nums[i+1]) + 1: 0;
            }
        }

        for (int i = 1; i < nums.length; i+=2) {
            if (i == nums.length -1) {
                sumEven += nums[i] > nums[i-1] - 1? nums[i] - (nums[i-1] - 1): 0;
            } else {
                sumEven += nums[i] > Math.min(nums[i-1], nums[i+1]) - 1? nums[i] - Math.min(nums[i-1], nums[i+1]) + 1: 0;
            }
        }

        return Math.min(sumOdd, sumEven);
    }
}