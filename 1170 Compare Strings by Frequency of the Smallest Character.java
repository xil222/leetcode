class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        //convert string to res
        int[] len = new int[words.length];
        int[] res = new int[queries.length];
        for (int i = 0; i < len.length; i++) {
            len[i] = getSmallestFreq(words[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            int cnt = 0;
            int qlen = getSmallestFreq(queries[i]);
            for (int j = 0; j < len.length; j++) {
                if (qlen < len[j]) cnt++;
            }
            res[i] = cnt;
        }
        return res;
    }

    private int getSmallestFreq(String ss) {
        int cnt = 1;
        char s = ss.charAt(0);
        for (int i = 1; i < ss.length(); i++) {
            if (ss.charAt(i) < s) {
                cnt = 1;
                s = ss.charAt(i);
            } else if (ss.charAt(i) == s) {
                cnt++;
            }
        }
        return cnt;
    }
}