class Solution {
    public int totalHammingDistance(int[] nums) {
        int totalDis = 0;
        //10^9 --> within 32 bits count bit
        for (int i = 0; i < 32; i++) {
            //count numbers which have 1's
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += (nums[j] >> i) & 1;
            }
            //multiply plus
            totalDis += count * (nums.length - count);
        }
        return totalDis;
    }
}