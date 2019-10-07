class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //The goal of this problem is traversing finding all paths
        //from source to target
        //We starts from node 0 to node N - 1.

        //since this is dfs, when drawing dfs diagram, we got
        //avg m edges for each node
        //at most n layers, time complixity is O(m^n)

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        //condition of start case is node 0
        tmp.add(0);
        //use dfs to get all possible paths
        dfs(graph, 0, tmp, result);
        return result;
    }

    private void dfs(int[][] graph, int idx, List<Integer> tmp, List<List<Integer>> result) {
        if (idx == graph.length - 1) {
            result.add(new ArrayList(tmp));
            return;
        }

        if (graph[idx].length == 0) return;
        for (int i = 0; i < graph[idx].length; i++) {
            tmp.add(graph[idx][i]);
            dfs(graph, graph[idx][i], tmp, result);
            tmp.remove(tmp.size()-1);
        }
    }
}