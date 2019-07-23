//method 1, starts from both sides, O(n) time complexity go from two directions beats 14%
class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return true;

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return helper(s, start + 1, end) || helper(s, start, end - 1);
            }
            start++;
            end--;
        }

        return true;
    }

    private boolean helper(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}