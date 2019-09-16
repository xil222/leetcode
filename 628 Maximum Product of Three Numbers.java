class Solution {
    public int maximumProduct(int[] nums) {
        //There are O(n^3) combinations of all numbers
        //however, to get the maxVal it is either by
        //2 negative * 1 pos or by 3 pos

        //we maintain a minHeap storing max Positive with max Size 3
        //and we maintain a maxHeap of storing min Negative with max Size 2

        //dont necessary using heap, and not necessary considering cases
        //for positive and negative.

        int max1= Integer.MIN_VALUE;
        int max2= Integer.MIN_VALUE;
        int max3= Integer.MIN_VALUE;

        int min1= Integer.MAX_VALUE;
        int min2= Integer.MAX_VALUE;

        for (int num: nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3){
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}