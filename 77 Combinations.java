class Solution {
    //Time Complexity: O(n^k)
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0 || n == 0) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), 1, n, k);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> tmp, int start, int n, int k) {
        if (tmp.size() == k) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i <= n; i++) {
            tmp.add(i);
            dfs(result, tmp, i+1, n, k);
            tmp.remove(tmp.size()-1);
        }
    }

}