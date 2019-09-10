class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[0];
        }

        //Goal is to maintain a datastructure that includes
        //the greatest number in the sliding window of size k

        //when updating maxVal of sliding window from index
        //i to i + 1,

        //we want to do 2 things, remove front element if out of
        //bound --> update maximum
        //add the new appended element if this element can
        //potentially be the maxinum


        //maintain the datastructure that first ele is greatest
        //ele after that may potentially be the maximum
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            //remove out of bound
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            //then remove from last
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
            if (i >= k - 1) {
                res[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}