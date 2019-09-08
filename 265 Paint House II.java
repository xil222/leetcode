class Solution {
    //time complexity: O(nk)
    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        //the minCost is non zero at least 2 color
        //prev[i] represents total minCost of houses
        int[] prev = new int[costs[0].length];

        for (int i = 0; i < prev.length; i++) {
            prev[i] = costs[0][i];
        }

        for (int i = 1; i < costs.length; i++) {
            //just find the minimal 2 indexes, cost of itself
            //if smallest no dup with itself, use smallest prev
            //if dup use second smallest prev
            int first;
            int second;
            if (prev[0] < prev[1]) {
                first = 0;
                second = 1;
            } else {
                first = 1;
                second = 0;
            }

            for (int j = 2; j < prev.length; j++) {
                if (prev[j] < prev[first]) {
                    second = first;
                    first = j;
                } else if (prev[j] < prev[second]) {
                    second = j;
                }
            }

            int[] cur = new int[costs[0].length];
            for (int k = 0; k < cur.length; k++) {
                cur[k] = prev[k] == prev[first]? prev[second] + costs[i][k]: prev[first] + costs[i][k];
            }

            for (int k = 0; k < cur.length; k++) {
                prev[k] = cur[k];
            }
        }

        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < prev.length; i++) {
            minVal = Math.min(minVal, prev[i]);
        }

        return minVal;
    }
}