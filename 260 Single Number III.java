class Solution {
    public int[] singleNumber(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }

        //the result of tmp the xor of two values
        //the ones is the bit they are different
        //we just need to pick out one of them
        //and separate all values in two group
        //because the two distinct numbers are split
        //into two different groups

        //-tmp is the complement of tmp + 1
        //then do &, will help find the first
        //bit which are different
        int mask = tmp & (-tmp);
        int a = 0, b = 0;
        for (int num: nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a,b};

    }
}