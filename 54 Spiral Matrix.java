class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;

        dfs(matrix, m, n, 0, result);
        return result;
    }

    private void dfs(int[][] matrix, int height, int width, int offset, List<Integer> result) {
        if (height == 0 || width == 0) {
            return;
        } else if (height == 1) {
            for (int i = offset; i < offset + width; i++) {
                result.add(matrix[offset][i]);
            }
            return;
        } else if (width == 1) {
            for (int i = offset; i < offset + height; i++) {
                result.add(matrix[i][offset]);
            }
            return;
        }

        for (int i = 0; i < width - 1; i++) {
            result.add(matrix[offset][offset+i]);
        }

        for (int i = 0; i < height - 1; i++) {
            result.add(matrix[offset + i][width + offset - 1]);
        }

        for (int i = 0; i < width - 1; i++) {
            result.add(matrix[height + offset - 1][width + offset - 1 - i]);
        }

        for (int i = 0; i < height - 1; i++) {
            result.add(matrix[height + offset - 1 - i][offset]);
        }

        dfs(matrix, height - 2, width - 2, offset + 1, result);
    }

}