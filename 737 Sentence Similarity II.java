// Provides two approaches 1. Union find  2. Dfs
// Assume words1, words2 length is m, each word length n, Pair ArrayList has length k

class Solution {
    // Union find, time complexity.
    // construct hashMap worst case, all words connected one by one, O(nk^2)
    // in iterating through the word array, worst case O(mk) stack track at most k layer
    // total time complexity O(nmk + nk^2)
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        //use union find to solve this problem
        Map<String, String> map = new HashMap<>();

        for (List<String> tmp: pairs) {
            String root1 = find(tmp.get(0), map);
            String root2 = find(tmp.get(1), map);
            map.put(root1, root2);
        }

        //then iterate words1 and words2,
        //find there root,
        //if root is the same keep going
        //if root is different return false
        for (int i = 0; i < words1.length; i++) {
            String root1 = find(words1[i], map);
            String root2 = find(words2[i], map);

            if (!root1.equals(root2)) {
                return false;
            }
        }
        return true;
    }

    private String find(String input, Map<String, String> map) {
        if (!map.containsKey(input)) {
            map.put(input, input);
        }

        //use if here, finally find the head and put it into
        if (!map.get(input).equals(input)) {
            map.put(input, find(map.get(input), map));
        }
        return map.get(input);
    }
}


class Solution {
    //dfs approach
    //Time Complexity: O(nkm) in last iteraton
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();

        for (List<String> tmp: pairs) {
            String s1 = tmp.get(0);
            String s2 = tmp.get(1);

            if (!map.containsKey(s1)) {
                map.put(s1, new HashSet<>());
            }
            map.get(s1).add(s2);
            if (!map.containsKey(s2)) {
                map.put(s2, new HashSet<>());
            }
            map.get(s2).add(s1);
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            } else if (!map.containsKey(words1[i])) {
                return false;
            } else {
                if (!dfs(words1[i], words2[i], map, new HashSet<String>())) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(String start, String end, Map<String, Set<String>> map, Set<String> visited) {
        //directly check because case where start not exist in the previous condition
        if (map.get(start).contains(end)) {
            return true;
        }

        if (visited.add(start)) {
            for (String item: map.get(start)) {
                if (!visited.contains(item) && dfs(item, end, map, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

}