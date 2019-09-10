class Solution {
    //key: when adding a new island, we want to check, whether it can be union to
    //existed island group or say extended from

    //if it cannot be extended from any, then add it self to a root
    //if can extend to more than 1 group of islands, need to union 2nd, 3rd
    //group of island back to the 1st group of island, the union actions requires
    //remove the 2nd group from set, and map to the new root, which requires O(nm)
    //operations

    //however, why do we need to label exactly, the key is each time we merge 2 isolated island
    //do we reduce the number count of island by 1.

    //using set + map takes too much time
    //use 2-d array to both represent the visit condition andd group of island
    //condition we make a union is two isolated island have different group

    //others explanation:
    //Union-Find is useful in finding relationship between disjoint subsets (in this case, islands), we can use this simple but amazing algorithm in detecting cycles in undirected graph (see solution here).

    // For this problem, we go through each input position, first mark it as a new island, then perform union find with its neighbours that are islands.

    int[] dirX = {-1,0,0,1};
    int[] dirY = {0,-1,1,0};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> res = new ArrayList<>();
        int count = 0;
        int[] label = new int[m * n];
        Arrays.fill(label, -1);

        for (int[] position: positions) {
            int idx = position[0] * n + position[1];

            if (label[idx] != -1) {
                res.add(count);
                continue;
            }
            label[idx] = idx;
            count++;
            int rootX = findRoot(label, idx);

            for (int i = 0; i < 4; i++) {
                int nx = position[0] + dirX[i];
                int ny = position[1] + dirY[i];
                int newIdx = nx * n + ny;

                //if neighbor not visited or out of boundd, no need merge operations
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || label[newIdx] == -1) {
                    continue;
                }

                int rootY = findRoot(label, newIdx);
                if (rootY != rootX) {
                    count--;
                }

                label[rootY] = rootX;
            }

            //label the other root as the root it merged to is the way to
            //realizing the merge, instead of marking all nodes labels
            res.add(count);
        }

        return res;
    }

    private int findRoot(int[] label, int idx) {
        if (label[idx] == idx) {
            return idx;
        }
        label[idx] = findRoot(label, label[idx]);
        return label[idx];
    }

}