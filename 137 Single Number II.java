class Solution {
    public int singleNumber(int[] nums) {
        //appear three times, construct way to convert 3 to 0
        //instead of 2 to 0, count the occ at each digit
        //00, 01, 10
        int ones = 0;
        int twos = 0;

        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos; //if second bit 1 first bit 0, prevent 11
            twos = (twos ^ nums[i]) & ~ones; //if first bit 1 second bit is 0, prevent 11

        }
        return ones + twos; //ones + twos, ones | twos, ones
    }
}

//second approach makes more sense
//do count on 32 bits, mod each digit by 3
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
            }
            sum %= 3;
            res += sum << i;
        }

        return res;
    }
}
