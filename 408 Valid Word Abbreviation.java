class Solution {
    //time complexity is length of abbr
    public boolean validWordAbbreviation(String word, String abbr) {
        if (abbr.length() == 0 && word.length() == 0) {
            return true;
        } else if (abbr.length() == 0 || word.length() == 0) {
            return false;
        }

        //go with abbr
        int idxA = 0;
        int idxB = 0;

        while (idxB < abbr.length()) {
            if (idxA >= word.length()) {
                return false;
            }
            if (abbr.charAt(idxB) >= 'a' && abbr.charAt(idxB) <= 'z') {
                if (abbr.charAt(idxB++) != word.charAt(idxA++)) {
                    return false;
                }
            } else {
                //make sure can't start with 0
                if (abbr.charAt(idxB) == '0') {
                    return false;
                }

                int startIdx = idxB;
                while (idxB < abbr.length() && abbr.charAt(idxB) >= '0' && abbr.charAt(idxB) <= '9') {
                    idxB++;
                }
                int val = Integer.valueOf(abbr.substring(startIdx, idxB));
                idxA += val;
            }
        }
        return idxA == word.length() && idxB == abbr.length();
    }
}