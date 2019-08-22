class Solution {
    public int minTransfers(int[][] transactions) {
        //map --> key: id, val: money
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p: transactions) {
            map.put(p[0], map.getOrDefault(p[0], 0) - p[2]);
            map.put(p[1], map.getOrDefault(p[1], 0) + p[2]);
        }

        return dfs(0, new ArrayList<>(map.values()));
    }

    private int dfs(int start, List<Integer> list) {
        while (start < list.size() && list.get(start) == 0) {
            start++;
        }
        if (start == list.size()) {
            return 0;
        }
        int op = Integer.MAX_VALUE;
        for (int i = start + 1; i < list.size(); i++) {
            if (list.get(start) * list.get(i) < 0) {
                list.set(i, list.get(i) + list.get(start));
                op = Math.min(op, 1 + dfs(start + 1, list));
                list.set(i, list.get(i) - list.get(start));
            }
        }
        return op;
    }
}