class Solution {
    public int pivotIndex(int[] nums) {
        //use two preSum array
        //calculate preSum from left and right
        int[] left = new int[nums.length+1];
        int[] right = new int[nums.length+1];

        for (int i = 1; i < left.length; i++) {
            left[i]  = left[i-1] + nums[i-1];
            right[nums.length-i] = right[nums.length-i+1] + nums[nums.length-i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (left[i] == right[i+1]) return i;
        }

        return -1;
    }
}