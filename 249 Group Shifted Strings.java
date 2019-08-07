class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        //for each of the strings, hashMap needs store info includes
        //the ascending of each character as well as the length information
        //need to store the information of recording ascending at each digit
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> hashMap = new HashMap<>();

        for (String item: strings) {
            String key = getKey(item);
            List<String> tmp = hashMap.getOrDefault(key, new ArrayList<String>());
            tmp.add(item);
            hashMap.put(key, tmp);
        }

        for (String key: hashMap.keySet()) {
            List<String> tmp = hashMap.get(key);
            result.add(tmp);
        }
        return result;
    }

    private String getKey(String s) {
        char[] c = s.toCharArray();
        String key = "";
        for (int i = 1; i < c.length; i++) {
            int val = c[i] - c[i-1];
            key += val < 0? val + 26: val;
            key += ",";
        }
        return key;
    }
}