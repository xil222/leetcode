class Solution {
    public int minAddToMakeValid(String S) {
        int adds = 0;
        int left = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    adds++;
                }
            }
        }
        return adds + left;
    }
}