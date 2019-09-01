//2nd time: time complexity O(n), space complexity O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        //use hashMap
        //key: preSum, val: number of occurence
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int preSum = 0;

        for (int item: nums) {
            preSum += item;
            if (hashMap.containsKey(preSum - k)) {
                count += hashMap.get(preSum - k);
            }
            hashMap.put(preSum, hashMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {

        int count = 0;
        //Use hashMap, key: preSum, val: number of occurence
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int preSum = 0;

        //to count number of occurence, from index 0,1,2,...n,
        //from a, to n, preSum - sum(1 to a-1) = k,
        //in other words, we have elements stored in hashMap
        //preSum - k, sum(1 to a-1)
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];

            if (hashMap.containsKey(preSum - k)) {
                count += hashMap.get(preSum - k);
            }
            hashMap.put(preSum, hashMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}