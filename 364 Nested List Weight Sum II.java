/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        //example of all 1s in the second layer, the 2 in the 1st layer
        //which is the opposite of actual layer --> so just calculate
        //the maxDepth, the direct sum, nestedSum
        //ansSum = maxDepth * directSum - nestedSum
        //example1 follows 8 = (2 + 1) * 6 - 10
        //example2 follows 17 = (3 + 1) * 11 - (1 + 2 * 4 + 6 * 3)
        int[] maxDepth = {1};
        int[] sum = {0};
        int defaultSum = dfs(maxDepth, sum, 1, nestedList);
        return (1 + maxDepth[0]) * sum[0] - defaultSum;
    }

    private int dfs(int[] maxDepth, int[] sum, int depth, List<NestedInteger> nestedList) {
        int nestedSum = 0;
        maxDepth[0] = Math.max(maxDepth[0], depth);
        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                int val = nestedList.get(i).getInteger();
                sum[0] += val;
                nestedSum += depth * val;
            } else {
                nestedSum += dfs(maxDepth, sum, depth + 1, nestedList.get(i).getList());
            }
        }
        return nestedSum;
    }

}