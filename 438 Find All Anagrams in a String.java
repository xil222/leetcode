class Solution {

    //use sliding window to realize whether anagrams satisfied, with
    //O(m+n) time complexity, O(n) space complexity
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() < p.length()) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<>();

        //key: character, value: count
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            hashMap.put(p.charAt(i), hashMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        int size = p.length();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //add character to hashMap
            char tmp = s.charAt(i);
            if (hashMap.containsKey(tmp)) {
                hashMap.put(tmp, hashMap.get(tmp)-1);
                if (hashMap.get(tmp) >= 0) {
                    count++;
                }
            }
            if (i >= p.length() - 1) {
                if (count == size) {
                    result.add(i - size + 1);
                }
                char pre = s.charAt(i - size + 1);
                if (hashMap.containsKey(pre)) {
                    hashMap.put(pre, hashMap.get(pre) + 1);
                    if (hashMap.get(pre) > 0) {
                        count--;
                    }
                }
            }
        }

        return result;
    }
}