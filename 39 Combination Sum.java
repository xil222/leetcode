//approach 1
class Solution {
    //method use dfs beats 64%, memory usage 98%
    //use dfs to update, field (result, temp, candidates, layer(for calculate sum), target)
    //for e.g candidates have m element, target is n, time complexity O(n^m), make m smaller
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(result, temp, candidates, 0, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] candidates, int layer, int target) {
        //base case
        if (layer == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList(temp));
            }
            return;
        }

        //traditional way to appending items each layer is one kind of number
        for (int i = 0; i * candidates[layer] <= target; i++) {
            for (int j  = 0; j < i; j++) {
                temp.add(candidates[layer]);
            }
            dfs(result, temp, candidates, layer+1, target - i * candidates[layer]);
            for (int j  = 0; j < i; j++) {
                temp.remove(temp.size() - 1);
            }
        }
    }
}

//approach 2 another way of writing
class Solution {
    //method use dfs beats 45.5%, memory usage 99%
    //each layer represents a point, this time complexity is greater
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(result, temp, candidates, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int layer) {
        //use target value left to determine the condition we execute
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList(temp));
            return;
        } else {
            for (int i = layer; i < candidates.length; i++) {
                temp.add(candidates[i]);
                dfs(result, temp, candidates,  target - candidates[i], i);
                temp.remove(temp.size()- 1);
            }
        }
    }
}