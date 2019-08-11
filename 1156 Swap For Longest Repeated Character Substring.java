//this approach is O(n^2)
class Solution {
    public int maxRepOpt1(String text) {
        int maxLen = 0;
        char[] input = text.toCharArray();
        int[] count = new int[26];

        for(int i=0; i < input.length; i++)
            count[input[i]-'a']++;

        for (int i = 0; i < input.length; i++) {
            char cur = input[i];
            int j = i;
            int cnt = 0;
            int diff = 0;
            //the third condition to ensure when have a diff,
            //need at least main character to swap with it
            while (j < input.length && (diff == 0 || cur == input[j]) && cnt < count[cur-'a']) {
                if (cur != input[j]) {
                    diff++;
                }
                cnt++;
                j++;
            }
            maxLen = Math.max(maxLen, cnt);
        }
        return maxLen;
    }
}