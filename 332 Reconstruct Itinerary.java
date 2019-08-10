class Solution {
    //time complexity is the sort part + the dfs part
    public List<String> findItinerary(List<List<String>> tickets) {
        //need a hashMap to store map<String, List<String>>

        List<String> result = new ArrayList<>();
        if (tickets == null || tickets.size() == 0)  {
            return result;
        }

        int total = tickets.size() + 1;
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < tickets.size(); i++) {
            if (map.containsKey(tickets.get(i).get(0))) {
                List<String> tmp = map.get(tickets.get(i).get(0));
                tmp.add(tickets.get(i).get(1)); //b/c the val here is arraylist, no need to append other values into
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(tickets.get(i).get(1));
                map.put(tickets.get(i).get(0), tmp);
            }
        }

        for (List<String> list: map.values()) {
            Collections.sort(list);
        }

        result.add("JFK");
        dfs("JFK", map, result, total);
        return result;
    }


    //since in this problem, we only need to find a optimal result, so
    //return boolean is a nice way
    private boolean dfs(String cur, Map<String, List<String>> map, List<String> result, int total) {
        if (result.size() == total) {
            return true;
        }

        if (!map.containsKey(cur) || map.get(cur).size() == 0) {
            return false;
        }

        //because we will remove elements in arrayList
        //therefore using for loop is not wise
        List<String> tmp = map.get(cur);
        for (int i = 0; i < tmp.size(); i++) {
            cur = tmp.remove(i);
            result.add(cur);
            if (dfs(cur, map, result, total) ) {
                return true;
            }
            result.remove(result.size()-1);
            tmp.add(i, cur);
        }
        return false;


    }

}