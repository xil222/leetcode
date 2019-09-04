class Solution {
    //avg time complexity O(m+n), worst case O(mn)
    public boolean isMatch(String s, String p) {
        //the difficult part of this problem is finding a way
        //to figure out how many characters that one * match

        //though we got options of matching s to p,
        //see when using up all chars in s whether we
        //reaches the end of p
        //there are several different cases
        //if single char of s, p matches where char of p
        //when getting a *, move pointer of p

        int sIdx = 0;
        int pIdx = 0;
        int startIdx = -1;
        int match = 0;


        //need to record p index, make it go back when not match
        //need to record the match index of to go back

        while (sIdx < s.length()) {
            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                sIdx++;
                pIdx++;
            } else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
                startIdx = pIdx;
                match = sIdx; // at least match to this digit
                pIdx++;
            } else if (startIdx != -1) { //use * to match, s may go back
                pIdx = startIdx + 1; //restart the index of p to compare with s
                match++;
                sIdx = match;
            } else { //pIdx reaches the end and there is no *
                return false;
            }
        }

        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
            pIdx++;
        }

        return pIdx == p.length();
    }
}