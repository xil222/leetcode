//O(n) time complexity, O(n) space complexity
class Solution {
    public int[] dailyTemperatures(int[] T) {

        //from left to right, using Stack
        //storing the index of T
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];

        //conditions store ele in stack
        //for each iteration, pops all elements
        //from stack which are smaller than
        //current element, because we will pop
        //the element once find one greater than itself
        //therefore, the elements in the stack follows
        //a non-increasing pattern
        for (int i = 0; i < T.length; i++) {
            if (i == 0) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                    int idx = stack.pop();
                    res[idx] = i - idx;
                }
                stack.push(i);
            }
        }
        //indexes left are all 0s

        return res;
    }
}