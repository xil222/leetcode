class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (List<Integer> list: wall) {
            int pos = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                pos += list.get(i);
                map.put(pos, map.getOrDefault(pos, 0) + 1);
                count = Math.max(count, map.get(pos));
            }
        }

        return wall.size() - count;
    }
}