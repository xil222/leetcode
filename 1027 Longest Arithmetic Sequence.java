class Solution {
    public int longestArithSeqLength(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int res = 1;
        //key: arrayIdx, val: map<val, count>
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        //key: val, val: count
        Map<Integer, Integer> s = new HashMap<>();
        s.put(A[0], 1);
        map.put(0, s);

        for (int i = 1; i < A.length; i++) {
            Map<Integer, Integer> cur = new HashMap<>();

            //go from small to large
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                if (map.get(j).containsKey(diff)) {
                    cur.put(diff, map.get(j).get(diff) + 1); //update cur from j small to large guarantee get greatest cnt
                } else {
                    cur.put(diff, 2); //starts from head each length at least 2
                }
                res = Math.max(cur.get(diff), res);
            }
            map.put(i, cur);
        }

        return res;
    }
}