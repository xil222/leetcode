class Solution {
    //beats 99%
    public int[][] multiply(int[][] A, int[][] B) {
        int x = A.length;
        int y = A[0].length;
        int z = B[0].length;
        int[][] result = new int[x][z];

        //don't think too complex, just check one matrix
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < z; k++) {
                        result[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }

        return result;
    }
}