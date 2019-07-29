class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }

        //key: value val: cnt
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int item: nums1) {
            hashMap.put(item, hashMap.getOrDefault(item, 0) + 1);
        }

        for (int item: nums2) {
            if (hashMap.containsKey(item) && hashMap.get(item) > 0) {
                res.add(item);
                hashMap.put(item, hashMap.get(item) - 1);
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}