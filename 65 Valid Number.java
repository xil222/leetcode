class Solution {
    public boolean isNumber(String s) {
        //characters should only include number, '+', '-'

        s = s.trim();
        //there are different elements sign, e, dot, number
        // '+' and '-' should only appear at front or right after e
        // 'e' can't appear twice, should be number before after it
        // '.' can't appear twice or after e

        boolean hasDot = false;
        boolean hasE = false;
        boolean numAfterE = true;
        boolean hasNum = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                hasNum = true;
                numAfterE = true;
            } else if (s.charAt(i) == 'e') {
                if (!hasNum || hasE) {
                    return false;
                }
                hasE = true;
                numAfterE = false;
            } else if (s.charAt(i) == '.') {
                if (hasE || hasDot) {
                    return false;
                }
                hasDot = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return hasNum && numAfterE;
    }
}