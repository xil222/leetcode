class Solution {
    //use two pointers, use greedy algorithm,
    //worst case O(n * m), avg complexity O(n + m) when few duplicates
    public int shortestWay(String source, String target) {

        int count = 1;
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();

        int idxT = 0;
        int prevIdx = idxT;

        while (idxT < t.length) {

            for (char i: s) {
                if (i == t[idxT]) {
                    idxT++;
                }
                if (idxT == t.length) return count;
            }

            if (prevIdx == idxT) {
                return -1;
            }

            prevIdx = idxT;
            count++;
        }

        return count;
    }
}