class Solution {
    //O(n) time complexity
    public int lengthOfLongestSubstring(String s) {
        //use a data structure to record the last occurence position of one character
        int maxLen = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        int startInx = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i),i);
            } else {
                int prevPos = hashMap.get(s.charAt(i));
                //need to prevent edge case like 'abba', startInx can only be updated to after
                startInx = Math.max(startInx, prevPos + 1);
                hashMap.put(s.charAt(i), i);
            }
            maxLen = Math.max(maxLen, i - startInx + 1);
        }
        return maxLen;
    }
}