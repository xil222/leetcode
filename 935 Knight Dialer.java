class Solution {
    //depth is n, space O(n), time O(10n) --> O(n)
    public static final int MOD = 1000000007;

    public int knightDialer(int N) {

        int[][] map = new int[][]{{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};

        int cnt = 0;
        Integer[][] dp = new Integer[N+1][10];

        for (int i = 0; i < 10; i++) {
            cnt = (cnt + dfs(i, map, N-1, dp)) % MOD;
        }
        return cnt;
    }


    private int dfs(int digit, int[][] map, int N, Integer[][] dp) {
        //base case
        if (N == 0) {
            return 1;
        }
        if (dp[N][digit] != null) {
            return dp[N][digit];
        }

        int cnt = 0;
        for (int val: map[digit]) {
            cnt = (cnt + dfs(val, map, N-1, dp)) % MOD;
        }
        dp[N][digit] = cnt;

        return cnt;
    }
}
//this doesn't work because time exceed, also hashMap takes more time
class Solution {
    public int knightDialer(int N) {

        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        hashMap.put(0, new ArrayList<Integer>(Arrays.asList(4,6)));
        hashMap.put(1, new ArrayList<Integer>(Arrays.asList(6,8)));
        hashMap.put(2, new ArrayList<Integer>(Arrays.asList(7,9)));
        hashMap.put(3, new ArrayList<Integer>(Arrays.asList(4,8)));
        hashMap.put(4, new ArrayList<Integer>(Arrays.asList(0,3,9)));
        hashMap.put(5, new ArrayList<Integer>());
        hashMap.put(6, new ArrayList<Integer>(Arrays.asList(1,0,7)));
        hashMap.put(7, new ArrayList<Integer>(Arrays.asList(2,6)));
        hashMap.put(8, new ArrayList<Integer>(Arrays.asList(1,3)));
        hashMap.put(9, new ArrayList<Integer>(Arrays.asList(2,4)));

        //we can put same elements in to the Queue
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        queue.offer(9);

        int prev = 0;
        int cnt = 0;
        int step = N - 1;
        while (step >= 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                cnt++;
                List<Integer> tmp = hashMap.get(num);
                for (int item: tmp) {
                    queue.offer(item);
                }
            }
            cnt = cnt - prev;
            prev = cnt;
            step--;
        }

        return cnt;
    }
}