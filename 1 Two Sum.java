class Solution {
    public int[] twoSum(int[] nums, int target) {

        //key: val, values: idx
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return new int[]{0, 0};
    }
}