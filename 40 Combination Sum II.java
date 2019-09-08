class Solution {
    //for each item, you can append it or not, just like subset
    //time complexity O(2^n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), candidates, 0, target);
        return result;
    }

    //because each item we only use once
    //so each item we just go to the next layer
    //condition for terminate is has reached the end
    private void backtrack(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int index, int target) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList(tmp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            backtrack(result, tmp, candidates, i+1, target - candidates[i]);
            tmp.remove(tmp.size()-1);
            //only when find a result, can dup exists, we need to move the index to remove dup
            while (i < candidates.length - 1 && candidates[i] == candidates[i+1]) {
                i++;
            }
        }

    }

}