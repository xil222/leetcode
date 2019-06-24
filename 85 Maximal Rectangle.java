class Solution {
    //this is a wrong approach, why? because sometimes an optimal area has multiple shapes,
    //but this kind of dp can only store one of them, that's why
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxArea = 0;
        int[][] row = new int[matrix.length][matrix[0].length];
        int[][] col = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            //System.out.println("/n");
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    row[i][j] = 0;
                    col[i][j] = 0;
                } else {
                    int area = 1;
                    if (i == 0 && j == 0) {
                        row[i][j] = 1;
                        col[i][j] = 1;
                    } else if (i == 0) {
                        row[i][j] = 1;
                        col[i][j] = col[i][j - 1] + 1;
                        area = col[i][j];
                    } else if (j == 0) {
                        row[i][j] = row[i - 1][j] + 1;
                        col[i][j] = 1;
                        area = row[i][j];
                    } else {
                        int a = row[i - 1][j];
                        int b = col[i - 1][j];
                        int c = row[i][j - 1];
                        int d = col[i][j - 1];

                        //first check col
                        if (b > 0 && a + 1 > area) {
                            row[i][j] = a + 1;
                            col[i][j] = 1;
                            area = a + 1;
                        }

                        //then check row
                        if (c > 0 && d + 1 > area) {
                            row[i][j] = 1;
                            col[i][j] = d + 1;
                            area = d + 1;
                        }

                        //think about the case of making combination
                        if (a > 0 && c >= a + 1 && d >= b - 1 && (a + 1) * b > area) {
                            row[i][j] = a + 1;
                            col[i][j] = b;
                            area = (a + 1) * b;
                        }

                        if (c > 0 && a >= c - 1 && b >= d + 1 && (d + 1) * c > area) {
                            row[i][j] = c;
                            col[i][j] = d + 1;
                            area = (d + 1) * c;
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
                //System.out.println(Integer.toString(row[i][j]) + " " + Integer.toString(col[i][j]));

            }
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        int[] left = new int[m];
        int[] right = new int[m];
        int[] height = new int[m];
        Arrays.fill(right, m - 1);

        for (int i = 0; i < n; i++) {
            int curLeft = 0;
            int curRight = m - 1;

            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(curRight, right[j]);
                } else {
                    right[j] = m - 1;
                    curRight = j - 1;
                }
            }

            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(curLeft, left[j]);
                    height[j]++;
                    maxArea = Math.max(maxArea, (right[j] - left[j] + 1) * height[j]);
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
        }
        return maxArea;
    }
}