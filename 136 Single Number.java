class Solution {
    public int singleNumber(int[] nums) {
        //same number xor with same number is 0
        //so just xor all the numbers in the arary
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}