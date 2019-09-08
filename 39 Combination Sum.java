class Solution {
    //we can place duplicates, so condition to go to the next element is one element has filled up the array
    //no need to sort
    //assume smallest number is k, target is n, m elements --> so at most O(m^(n/k))
    //assume target n, m candidates --> O(n^m)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int index, int target) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(tmp  ));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            backtrack(result, tmp, candidates, i, target - candidates[i]);
            tmp.remove(tmp.size()-1);
        }
    }
}

class Solution {
    //m candidates, then m layers. m ^ (n/k) compared to above
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
