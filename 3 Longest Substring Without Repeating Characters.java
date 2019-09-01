//2nd time
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //use hashMap to store the begining of each character
        int maxLen = 0;
        Map<Character, Integer> hashMap = new HashMap<>();

        //physical meaning of startInx, the range(startInx, i) is the
        //longest current string with no dup characters
        int startInx = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!hashMap.containsKey(cur)) {
                hashMap.put(cur, i);
            } else {
                int preIdx = hashMap.get(cur);
                startInx = Math.max(startInx, preIdx + 1);
                hashMap.put(cur, i);
            }
            maxLen = Math.max(maxLen, i - startInx + 1);
        }
        return maxLen;
    }
}



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