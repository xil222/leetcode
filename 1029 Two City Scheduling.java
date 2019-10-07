//Approach one:
// Dynamic Programming
// Time Complexity: O(n^2)
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        //The goal of this problem is find the min totalCost
        //off evenly flying all people to two separate cities
        //since we are looking for min totalCost

        if (costs.length == 0) return 0;
        int m = costs.length / 2;
        int[][] dp = new int[m+1][m+1];

        //base case for n people, lets first construct for
        //all for city A, and all for city B within n/2 people
        //dp[i][j], i people assigned to A, j people assigned to B
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + costs[i-1][0];
        }

        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j-1] + costs[j-1][1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.min(dp[i-1][j] + costs[i+j-1][0], dp[i][j-1] + costs[i+j-1][1]);
            }
        }

        return dp[m][m];
    }
}

//Approach two:
// PriorityQueue
// Time Complexity: O(nlogn)
class Solution {
    class Cell {
        int idx;
        int A;
        int B;
        public Cell(int A, int B, int idx) {
            this.A = A;
            this.B = B;
            this.idx = idx;
        }
    }

    public int twoCitySchedCost(int[][] costs) {
        //Our goal is to find min total cost
        //either go to city A or city B
        //with each of the component being used.
        //Therefore, just add on the relative lowest n for city A
        //and add on relative lowest n for city B, add cost together
        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>(){
            public int compare(Cell a, Cell b) {
                return (a.A - a.B) - (b.A - b.B);
            }
        });

        for (int i = 0; i < costs.length; i++) {
            pq.offer(new Cell(costs[i][0], costs[i][1], i));
        }

        int totalCost = 0;
        int half_size = pq.size() / 2;

        while (pq.size() > half_size) {
            totalCost += costs[pq.poll().idx][0];
        }

        while (!pq.isEmpty()) {
            totalCost += costs[pq.poll().idx][1];
        }
        return totalCost;
    }
}


