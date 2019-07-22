//method 1 : bfs approach， theoretical time complexity is O(mn) only beats 5%.
class Solution {
    public boolean isBipartite(int[][] graph) {

        if (graph == null || graph.length == 0) return true;

        int[] visited = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        int label = 1;

        //all nodes can put in once
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int j = 0; j < size; j++) {
                        int idx = queue.poll();
                        visited[idx] = label;
                        for (int num: graph[idx]) {
                            if (visited[num] == 0) {
                                queue.offer(num);
                            } else {
                                if (visited[num] == label) {
                                    return false;
                                }
                            }
                        }
                    }
                    label = 3 - label;
                }
            }
        }

        return true;
    }
}

//dfs approach much faster, theoritical time is same but beats 100%
class Solution {
    public boolean isBipartite(int[][] graph) {

        if (graph == null || graph.length == 0) return true;
        int[] visited = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0 && !isValid(graph, visited, i, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValid(int[][] graph, int[] visited, int idx, int label) {

        //base case
        if (visited[idx] != 0) {
            return visited[idx] == label;
        }

        visited[idx] = label;
        for (int num: graph[idx]) {
            if (!isValid(graph, visited, num, 3 - label)) return false;
        }
        return true;
    }
}