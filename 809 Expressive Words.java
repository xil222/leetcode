class Solution {
    //move two pointers
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String word: words) {
            if (canExtend(S, word)) {
                count++;
            }
        }
        return count;
    }

    //focusing on extend b to a
    private boolean canExtend(String a, String b) {
        //compare a idx with b idx
        //if same:
        //count for a and b, if a length >= 3 or a.length == b.length
        //  continue to the next character
        //if not return false
        int idxA = 0;
        int idxB = 0;
        while (idxA < a.length() && idxB < b.length()) {
            if (a.charAt(idxA) != b.charAt(idxB)) {
                return false;
            } else {
                int lenA = countLen(a, idxA);
                int lenB = countLen(b, idxB);
                if (lenA < 3 && lenA != lenB || lenB > lenA) {
                    return false;
                }
                idxA++;
                idxB++;
                //move index
                while (idxA < a.length() && a.charAt(idxA) == a.charAt(idxA-1)) {
                    idxA++;
                }
                while (idxB < b.length() && b.charAt(idxB) == b.charAt(idxB-1)) {
                    idxB++;
                }
            }
        }
        return idxA == a.length() && idxB == b.length() ? true: false;
    }

    //count length
    private int countLen(String s, int idx) {
        int startIdx = idx;
        while (idx < s.length() - 1 && s.charAt(idx) == s.charAt(idx+1)) {
            idx++;
        }
        return idx - startIdx + 1;
    }
}