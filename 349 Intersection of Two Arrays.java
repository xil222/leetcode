class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for (int item: nums1) {
            hashSet.add(item);
        }

        for (int item: nums2) {
            if (hashSet.contains(item)) res.add(item);
        }

        int[] result = new int[res.size()];
        int idx = 0;
        for (int item: res) {
            result[idx++] = item;
        }
        return result;
    }
}