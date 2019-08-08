class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        //notice the change of direction
        //1 step, 1 step, 2 steps, 2 steps
        int[][] dirS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<int[]> res = new ArrayList<>();

        int len = 0;
        int dirIdx = 0; //direction index
        res.add(new int[]{r0, c0});

        while (res.size() < R * C) {
            if (dirIdx == 0 || dirIdx == 2) {
                len++;
            }
            for (int i = 0; i < len; i++) {
                r0 += dirS[dirIdx][0];
                c0 += dirS[dirIdx][1];
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C)
                    res.add(new int[]{r0, c0});
            }
            dirIdx = (dirIdx + 1) % 4;
        }

        return res.toArray(new int[R * C][2]);
    }
}