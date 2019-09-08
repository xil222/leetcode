class Solution {
    public int minCost(int[][] costs) {
        //red, blue, green
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int[] prev = new int[3];
        prev[0] = costs[0][0];
        prev[1] = costs[0][1];
        prev[2] = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            int new0 = Math.min(prev[2], prev[1]) + costs[i][0];
            int new1 = Math.min(prev[2], prev[0]) + costs[i][1];
            int new2 = Math.min(prev[0], prev[1]) + costs[i][2];
            prev[0] = new0;
            prev[1] = new1;
            prev[2] = new2;
        }

        return Math.min(prev[2], Math.min(prev[0], prev[1]));
    }
}