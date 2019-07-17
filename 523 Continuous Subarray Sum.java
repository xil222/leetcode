class Solution {
    //Time O(n) Space O(k). Faster than 53.88%, memory less than 93.48%
    public boolean checkSubarraySum(int[] nums, int k) {

        //hashMap to record the remainder and first occ position
        int preSum = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            preSum = k == 0? preSum: preSum % k;
            if (preSum < 0) {
                preSum += k;
            }

            //if find and difference at least two, return true
            if (hashMap.containsKey(preSum) && i - hashMap.get(preSum) >= 2) {
                return true;
            } else if (!hashMap.containsKey(preSum)) {
                hashMap.put(preSum, i);
            }
        }
        return false;
    }
}