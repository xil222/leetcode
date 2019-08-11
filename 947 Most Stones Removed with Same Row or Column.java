//use string to realize union find but too slow
class Solution {

    public int removeStones(int[][] stones) {
        if (stones.length <= 1) {
            return 0;
        }

        int[] cnt = new int[]{stones.length};

        //convert the problem to dynamic to a more static one
        //find a way to implement union find

        //starts with one point mapping to itself
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            String tmp = stones[i][0] + " " + stones[i][1];
            map.put(tmp, tmp);
        }

        //use O(n^2) iterate through all pairs
        for (int i = 0; i < stones.length; i++) {
            String tmp1 = stones[i][0] + " " + stones[i][1];
            for (int j = i+1; j < stones.length; j++) {
                String tmp2 = stones[j][0] + " " + stones[j][1];
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) { //condition for mapping is one element the same
                    union(tmp1, tmp2, cnt, map);
                }
            }
        }

        //we try to find the most number of items removed, so each union group just
        //has one left
        return stones.length - cnt[0];
    }

    private String find(String tmp, Map<String, String> map) {
        if (!map.get(tmp).equals(tmp)) {
            map.put(tmp, find(map.get(tmp), map));
        }
        return map.get(tmp);
    }

    //for an example of stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]];
    //realize mapping of (0,0) -> (0,1) -> (1,0) -> (1,2) -> (2,2) -> (2,1)
    //max we can remove --> is number of 1-step connection
    private void union(String tmp1, String tmp2, int[] cnt, Map<String, String> map) {
        String parent1 = find(tmp1, map);
        String parent2 = find(tmp2, map);

        if (parent1.equals(parent2)) {
            return;
        }
        map.put(parent1, parent2);
        cnt[0]--;
    }
}

class Solution {
    //total time complexity O(n^3)
    public int removeStones(int[][] stones) {
        if (stones.length <= 1) {
            return 0;
        }

        int cnt = stones.length;
        int[] parent = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            parent[i] = i;
        }

        //convert the problem to dynamic to a more static one
        //find a way to implement union find

        //use O(n^2) iterate through all pairs
        for (int i = 0; i < stones.length; i++) {
            for (int j = i+1; j < stones.length; j++) {
                if (stones[i][0] != stones[j][0] && stones[i][1] != stones[j][1]) {
                    continue;
                }

                int root1 = find(parent, i);
                int root2 = find(parent, j);
                if (root1 == root2) {
                    continue;
                } else {
                    parent[root1] = root2;
                    cnt--;
                }
            }
        }


        return stones.length - cnt;
    }

    //keep in mind this is the way to iterate (dfs) --> to find the head
    private int find(int[] parent, int idx) {
        while (parent[idx] != idx) {
            idx = parent[idx];
        }
        return idx;
    }


}
