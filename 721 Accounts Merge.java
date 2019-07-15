/* Assume accounts have n list, each with m elements */

//1st method Union find, beats 46.61% time, memory beats 93.79%
class Solution {

    // the idea is that for each account, we assign one parent (different list have different parent)
    // we need to deal with that case
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        //The nested result that needs to be sorted
        List<List<String>> result = new ArrayList<>();
        //key: account, value: account's parent
        Map<String, String> parent = new HashMap<>();
        //key: email account, value: name
        Map<String, String> owner = new HashMap<>();
        //key: parent account, value: all the subaccount
        Map<String, Set<String>> unions = new HashMap<>();

        //first construct the structure for owner and parent hashMap
        //time takes O(m,n)
        for (List<String> tmp: accounts) {
            for (int i = 1; i < tmp.size(); i++) {
                parent.put(tmp.get(i), tmp.get(i));
                owner.put(tmp.get(i),tmp.get(0));
            }
        }

        //in each array, make every component except the first one point to the 1st account name
        //not actually the 1st account name, but the exact the 1st occurence name.
        //I mean total time takes O(mn)
        for (List<String> tmp: accounts) {
            String par = find(tmp.get(1), parent);
            //finish building the parent List
            for (int i = 2; i < tmp.size(); i++)
                parent.put(find(tmp.get(i), parent), par);
        }

        //based on the finished parent map, put things
        //total time takes O(mn)
        for (List<String> tmp: accounts) {
            String par = find(tmp.get(1), parent);
            if (!unions.containsKey(par)) unions.put(par, new HashSet<String>());
            for (int i = 1; i < tmp.size(); i++)
                unions.get(par).add(tmp.get(i));
        }

        //key is parent
        //O(mnlog(mn))
        for (String key: unions.keySet()) {
            List<String> temp = new ArrayList<>(unions.get(key));
            Collections.sort(temp);
            temp.add(0, owner.get(key));
            result.add(temp);
        }

        return result;
    }

    //find the last parent of one String, using recursion
    private String find(String s, Map<String, String> parent) {
        return parent.get(s) == s? s: find(parent.get(s), parent);
    }
}

//2nd method, use build graph + dfs beats 46% memory beats 87% overall time complexity: O(mnlog(mn))
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //It sets up a graph instead of parent, undirected
        Map<String, Set<String>> graph = new HashMap<>(); //<email node, neighbor nodes>
        Map<String, String> userName = new HashMap<>(); //<email, username>

        //set up the mapping of owner, and parent
        //Time: O(mn)
        for (List<String> tmp: accounts) {
            String name = tmp.get(0);
            for (int i = 1; i < tmp.size(); i++) {
                userName.put(tmp.get(i), name);
                if (!graph.containsKey(tmp.get(i))) {
                    graph.put(tmp.get(i), new HashSet<>());
                }
                userName.put(tmp.get(i), name);

                if (i > 1) {
                    graph.get(tmp.get(i)).add(tmp.get(i-1));
                    graph.get(tmp.get(i-1)).add(tmp.get(i));
                }
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        //use dfs, to find all connections of account name
        //still, worst case time O(mnlog(mn)
        for (String email: userName.keySet()) {
            List<String> temp = new ArrayList<>();
            if (visited.add(email)) {
                dfs(graph, temp, visited, email);
                Collections.sort(temp);
                temp.add(0, userName.get(email));
                result.add(temp);
            }
        }
        return result;
    }

    private void dfs(Map<String, Set<String>> graph, List<String> temp, Set<String> visited, String email) {
        temp.add(email);
        for (String item: graph.get(email)) {
            if (visited.add(item)) {
                dfs(graph, temp, visited, item);
            }
        }
    }
}

