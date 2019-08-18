class Solution {
    //O(n) time complexity
    public String lastSubstring(String s) {
        if (s == null) {
            return null;
        } else if (s.length() == 0) {
            return "";
        }

        int idx = 1;
        char largest = s.charAt(0);
        int largestIdx = 0;

        while (idx < s.length()) {
            if (s.charAt(idx) > largest) {
                largest = s.charAt(idx);
                largestIdx = idx;
            } else if (s.charAt(idx) == largest){
                int newStart = idx;
                int oldStart = largestIdx;
                while (idx < s.length() && s.charAt(idx) == s.charAt(oldStart)) {
                    idx++;
                    oldStart++;
                }

                if (idx < s.length() && s.charAt(idx) > largest) {
                    largest = s.charAt(idx);
                    largestIdx = idx;
                } else if (idx < s.length() && s.charAt(idx) > s.charAt(oldStart)) {
                    largestIdx = newStart;
                }
            }
            idx++;
        }
        return s.substring(largestIdx);
    }
}