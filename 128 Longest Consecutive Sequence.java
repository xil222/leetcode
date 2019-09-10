class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int maxVal = 0;
        for (int num: nums) {
            if (!set.contains(num)) {
                continue;
            }

            int count = 1;
            set.remove(num);
            int next = num + 1;
            while (set.contains(next)) {
                count++;
                set.remove(next++);
            }

            int prev = num - 1;
            while (set.contains(prev)) {
                count++;
                set.remove(prev--);
            }
            maxVal = Math.max(maxVal, count);
        }

        return maxVal;

    }
}