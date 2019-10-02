class Solution {
    public int longestStrChain(String[] words) {
        //the goal of this problem is
        //find the longest string chain

        //since for each string with length n - 1
        //there might be multiple options of strings
        //with length n, and there can be more options
        //of strings with length n + 1.

        //therefore, going from reverse way
        //for each string with length n, check all available
        //string with length n + 1, if exists, update the
        //current longest chain length from max length to current length

        //since we update string length from the longest word
        //to shortest word and use a variable to record the longest
        //string chain.

        //we borrow the idea of dp but using HashMap to
        //storing the mapping relationship between String and length of chain
        //to length smaller than itself

        //use hashMap to store maxLen
        //key: String, val: maxLen
        Map<String, Integer> map = new HashMap<>();
        int maxLen = 0;

        //sort the array with ascending length
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });

        for (String word: words) {
            if (map.containsKey(word)) continue;
            map.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                String tmp = sb.deleteCharAt(i).toString();
                if (map.containsKey(tmp) && map.get(tmp) + 1 > map.get(word)) {
                    map.put(word, map.get(tmp) + 1);
                }
            }
            maxLen = Math.max(maxLen, map.get(word));
        }

        return maxLen;
    }
}