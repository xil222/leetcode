class Solution {
    //left appraoch and right approach
    public int[] productExceptSelf(int[] nums) {
        //notice we initialize array to 0
        int[] result = new int[nums.length];
        int leftProduct = 1;
        int rightProduct = 1;

        //multiply from left, assign the mul since initilize to 0
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        //multiply from right, multiply the right side
        for (int i = nums.length-1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}