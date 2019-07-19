class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        //idea is moving two pointers from both directions

        String string = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(string.charAt(start))) {
                start++;
            }

            while (end > start && !Character.isLetterOrDigit(string.charAt(end))) {
                end--;
            }

            // These three lines are not necessary
            //if (start >= end) {
            //    break;
            //}

            if (string.charAt(start) != string.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}