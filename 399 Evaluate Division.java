//To fully understand the time complexity, will try two approaches
//dfs and union find

//1st method, using dfs, this one might take longer time
//beats 90%, time complexity queries has length m, equation has length n.
//O(n) + O(m * n^2) as worst case time complexity
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];

        //1st step store all combination in hashmap, with pair
        Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
        for (int i = 0; i < equations.size(); i++) {
            if (!map.containsKey(equations.get(i).get(0))) {
                map.put(equations.get(i).get(0), new HashMap<String, Double>());
            }
            if (!map.containsKey(equations.get(i).get(1))) {
                map.put(equations.get(i).get(1), new HashMap<String, Double>());
            }

            map.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            map.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
        }

        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), map, 1.0, new HashSet<String>());
        }

        return result;
    }

    //since doing dfs, need to cumulative product
    private double dfs(String start, String end, Map<String, Map<String, Double>> map, double val ,Set<String> visited) {
        if (!map.containsKey(start) || !visited.add(start)) {
            return -1.0;
        }
        //edge case --> if two parameters are same, they not in the hashMap
        if (start.equals(end)) {
            return val;
        }

        Map<String, Double> tmp = map.get(start);
        for (String item: tmp.keySet()) {
            double res = dfs(item, end, map, val * tmp.get(item), visited);
            if (res != -1.0) {
                return res;
            }
        }
        return -1.0;
    }
}

//second approach union find
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        //the key thing is setting a mapping function, there is a line from the starting point all the way
        //to the end, so we can build a graph on that
        Map<String, String> root = new HashMap<>();
        Map<String, Double> dist = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String r1 = find(root, dist, equations.get(i).get(0));
            String r2 = find(root, dist, equations.get(i).get(1));
            root.put(r1, r2);
            dist.put(r1, dist.get(equations.get(i).get(1)) * values[i] / dist.get(equations.get(i).get(0)));
        }
        for (int i = 0; i < queries.size(); i++) {
            if (!root.containsKey(queries.get(i).get(0)) || !root.containsKey(queries.get(i).get(1))) {
                res[i] = -1.0;
                continue;
            }
            String r1 = find(root, dist, queries.get(i).get(0));
            String r2 = find(root, dist, queries.get(i).get(1));
            if (!r1.equals(r2)) {
                res[i] = -1.0;
                continue;
            }
            res[i] = (double) dist.get(queries.get(i).get(0)) / dist.get(queries.get(i).get(1));
        }
        return res;
    }

    private String find(Map<String, String> root, Map<String, Double> dist, String s) {
        if (!root.containsKey(s)) {
            root.put(s, s);
            dist.put(s, 1.0);
            return s;
        }
        if (root.get(s).equals(s)) return s;
        String lastP = root.get(s);
        String p = find(root, dist, lastP);
        root.put(s, p);
        dist.put(s, dist.get(s) * dist.get(lastP));
        return p;
    }
}

