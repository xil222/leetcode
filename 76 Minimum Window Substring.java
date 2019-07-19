//O(N) beats 43%
class Solution {
    public String minWindow(String s, String t) {

        if (s == null || s.length() == 0 || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char item = t.charAt(i);
            if (!hashMap.containsKey(item)) {
                hashMap.put(item, 0);
            }
            hashMap.put(item, hashMap.get(item) + 1);
        }

        int start = 0;
        int minStart = 0;
        int minLen = s.length() + 1;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) - 1);

                if (hashMap.get(s.charAt(i)) >= 0) {
                    count++;
                }

                //in order to get the shortest length, need to set while loop when count == t.length()
                //but update the minimum length continuously
                while (count == t.length()) {
                    if (i - start + 1 < minLen) {
                        minStart = start;
                        minLen = i - start + 1;
                    }

                    if (hashMap.containsKey(s.charAt(start))) {
                        hashMap.put(s.charAt(start), hashMap.get(s.charAt(start)) + 1);
                        if (hashMap.get(s.charAt(start)) > 0) {
                            count--;
                        }
                    }
                    start++;
                }

            }
        }

        return minLen < s.length() + 1? s.substring(minStart, minStart + minLen): "";
    }
}



//remember, this is the logic inside (count == t.length()) is wrong.
class Solution {
    public String maxWindow(String s, String t) {

        if (s == null || s.length() == 0 || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char item = t.charAt(i);
            if (!hashMap.containsKey(item)) {
                hashMap.put(item, 0);
            }
            hashMap.put(item, hashMap.get(item) + 1);
        }

        int start = 0;
        int minStart = 0;
        int minLen = s.length() + 1;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) - 1);

                if (hashMap.get(s.charAt(i)) >= 0) {
                    count++;
                }

                if (count == t.length()) {
                    if (i - start + 1 < minLen) {
                        minStart = start;
                        minLen = i - start + 1;
                    }
                    while (count == t.length()) {
                        if (hashMap.containsKey(s.charAt(start))) {
                            hashMap.put(s.charAt(start), hashMap.get(s.charAt(start)) + 1);
                            if (hashMap.get(s.charAt(start)) > 0) {
                                count--;
                            }
                        }
                        start++;
                    }
                }
            }
        }

        return minLen < s.length()? s.substring(minStart, minStart + minLen): "";
    }
}