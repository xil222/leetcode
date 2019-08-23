class Solution {
    //Time: O(mn)
    //idea is checking the condition that
    //the whether idx can extend
    public String addBoldTag(String s, String[] dict) {
        boolean[] canExtend = new boolean[s.length()];

        int end = 0; //end position is not covered yet
        for (int i = 0; i < s.length(); i++) {
            for (String string: dict) {
                if (s.startsWith(string, i)) {
                    end = Math.max(end, i + string.length());
                }
            }
            canExtend[i] = end > i;
        }

        StringBuilder sb = new StringBuilder();

        int idx = 0;
        while (idx < canExtend.length) {
            //first check whether is single
            if (!canExtend[idx]) {
                sb.append(s.charAt(idx++));
            } else {
                int start = idx;
                while (idx < canExtend.length && canExtend[idx]) {
                    idx++;
                }
                sb.append("<b>" + s.substring(start, idx) + "</b>");
            }
        }

        return sb.toString();
    }
}