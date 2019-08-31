class Solution {
    //naive solution:
    //set up a dp array to store whether till
    //i's indexes can be formed by dict strings
    //Assume s has length m, there are n words
    //and each word average length of k.
    //Then time Complexity is O(mnk), space complexity is O(m).
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String str: wordDict) {
                if (str.length() > i) {
                    continue;
                } else {
                    int start = i - str.length();
                    if (s.substring(start, i).equals(str) && dp[start]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];

    }
}

class Solution {
    //Then time Complexity is O(m^3), space complexity is O(n).
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        Set<String> set = new HashSet<>();
        for (String str: wordDict) {
            set.add(str);
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }
}