//16ms 34%
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (s.length() <= k) {
            return s.length();
        }

        //count different characters from start to end
        int cnt = 0;
        //use two pointers to record the range we are counting right now
        int start = 0;
        //longest substring with k different characters
        int maxLen = 0;
        //hashMap to store
        //key: character  val: number of occurence
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            if (!hashMap.containsKey(s.charAt(end))) {
                hashMap.put(s.charAt(end), 1);
                cnt++;
            } else {
                int num = hashMap.get(s.charAt);
                hashMap.put(s.charAt(end), num+1);
            }
            while (cnt > k) {
                int num = hashMap.get(s.charAt(start));
                if (num == 1) {
                    hashMap.remove(s.charAt(start));
                    cnt--;
                } else {
                    hashMap.put(s.charAt(start), num-1);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}

//improved 13ms 65%
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (s.length() <= k) {
            return s.length();
        }

        //use two pointers to record the range we are counting right now
        int start = 0;
        //longest substring with k different characters
        int maxLen = 0;
        //hashMap to store
        //key: character  val: number of occurence
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char cur = s.charAt(end);
            hashMap.put(cur, hashMap.getOrDefault(cur,0)+1);
            while (hashMap.size() > k) {
                int num = hashMap.get(s.charAt(start));
                if (num == 1) {
                    hashMap.remove(s.charAt(start));
                } else {
                    hashMap.put(s.charAt(start), num-1);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}

//2ms 99%
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (s.length() <= k) {
            return s.length();
        }

        int[] count = new int[256];
        int cnt = 0, start = 0, maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            if (count[s.charAt(end)]++ == 0) cnt++;
            if (cnt > k) {
                while (--count[s.charAt(start++)] > 0);
                cnt--;
            }
            maxLen = Math.max(maxLen, end - start + 1);

        }

        return maxLen;
    }
}