class Solution {
    public int countComponents(int n, int[][] edges) {

        int[] map = new int[n];
        //first map to itself, using index
        for (int i = 0; i < n; i++) {
            map[i] = i;
        }

        //the idea is everytime we implement a new connection
        //meaning the number of independent regions -1
        for (int[] tmp: edges) {
            int rootA = find(tmp[0], map);
            int rootB = find(tmp[1], map);
            if (rootA != rootB) {
                map[rootA] = rootB;
                n--;
            }
        }

        return n;
    }

    private int find(int idx, int[] map) {
        while (map[idx] != idx) {
            idx = map[idx];
        }
        return idx;
    }

}