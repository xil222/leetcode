//for this problem, at each state (includes the
//speed pos the car can either speed up or reverse)
//this is a direct way

class Solution {
    class State {
        int speed;
        int pos;
        public State(int speed, int pos) {
            this.speed = speed;
            this.pos = pos;
        }
    }
    //needs pruning to accelerate
    //pos can't be < 0 || greater equal to 2 * target
    //Time Complexity and Space Compelxity: target * log(target)
    public int racecar(int target) {
        if (target == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(1, 0));
        set.add("1 0");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State tmp = queue.poll();
                if (tmp.pos == target) {
                    return step;
                }
                int Apos = tmp.pos + tmp.speed;
                int Aspeed = 2 * tmp.speed;
                int Rspeed = tmp.speed > 0? -1: 1;
                String A = Integer.toString(Aspeed) + " " + Integer.toString(Apos);
                String R = Integer.toString(Rspeed) + " " + Integer.toString(tmp.pos);
                if (set.add(A) && Apos > 0 && Apos < 2 * target) {
                    queue.offer(new State(Aspeed, Apos));
                }

                if (set.add(R) && tmp.pos < 2 * target) {
                    queue.offer(new State(Rspeed, tmp.pos));
                }
            }
            step++;
        }

        return -1;
    }
}



//use bottom-up dp strategy to update target
//logical time complexity is k * (log(k)^2)
class Solution {
    public int racecar(int target) {
        if (target == 0) {
            return 0;
        }

        //dp[i] represents the min steps to reach position i
        int[] dp = new int[target+1];

        //position forward, acc operation
        //position backward, acc backward
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            int acc_val = 1;
            int pos_for = 1;

            //cases when both accelerate and deaccrate
            for (; pos_for < i; pos_for = (1 << ++acc_val) - 1) {
                for (int rev_val = 0, pos_bac = 0; pos_bac < pos_for; pos_bac = (1 << ++rev_val) - 1) {
                    dp[i] = Math.min(dp[i], 2 + acc_val + rev_val + dp[i - pos_for + pos_bac]) ;
                }
            }
            dp[i] = Math.min(dp[i], acc_val + (i == pos_for ? 0 : 1 + dp[pos_for - i]));


        }
        return dp[target];
    }
}