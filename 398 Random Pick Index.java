class Solution {
    //for this problem
    //we try a new algorithm
    //reservior sampling, basic idea
    //is search collect all target
    //and maintain a dynamic random
    //approach to search for the target
    Random rand;
    int[] val;

    public Solution(int[] nums) {
        val = nums;
        rand = new Random();
    }

    //O(n) time complexity
    public int pick(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < val.length; i++) {
            if (val[i] == target) {
                if (rand.nextInt(++count) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */