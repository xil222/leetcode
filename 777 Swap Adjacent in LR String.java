class Solution {
    public boolean canTransform(String start, String end) {
        //the idea is swap 'XL' with 'LX'
        //or swap 'RX' with 'XR' which means each of the
        //swap need to make use of X, however, the relative
        //sequence of L,R is unchanged.
        //so the idea is comparing the relative L,R positive
        //from start to end, R swap to right, L swap to left
        if (start.length() != end.length()) {
            return false;
        }

        int startInx = 0;
        int endInx = 0;

        while (startInx < start.length() && endInx < end.length()) {
            while (startInx < start.length() && start.charAt(startInx) == 'X') {
                startInx++;
            }

            while (endInx < end.length() && end.charAt(endInx) == 'X') {
                endInx++;
            }

            if (startInx == start.length() && endInx == end.length()) {
                return true;
            } else if (startInx == start.length() || endInx == end.length()) {
                return false;
            } else if (start.charAt(startInx) != end.charAt(endInx)) {
                return false;
            }

            if (start.charAt(startInx) == 'R' && startInx > endInx) return false;
            if (start.charAt(startInx) == 'L' && startInx < endInx) return false;

            startInx++;
            endInx++;
        }

        return true;
    }
}