class Solution {
    public double minAreaFreeRect(int[][] points) {
        //the definition of rectangle
        //is the two diagonals distance the same
        //and they divide each other in half
        if (points.length < 4) {
            return 0;
        }

        //key: info of distance, x,y center positions
        double minVal = Double.MAX_VALUE;
        Map<String, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                long dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                        (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                double centerX = (double)(points[i][0] + points[j][0]) / 2;
                double centerY = (double)(points[i][1] + points[j][1]) / 2;
                String key = dis + " " + centerX + " " + centerY;
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<int[]>());
                }
                map.get(key).add(new int[]{i,j});
            }
        }

        //therefore all vals stored in same key can form rectangles
        //just try all of them to find the one with smallest area
        for (String key: map.keySet()) {
            if (map.get(key).size() < 2) {
                continue;
            }
            List<int[]> values = map.get(key);
            for (int i = 0; i < values.size() - 1; i++) {
                for (int j = i + 1; j < values.size(); j++) {
                    int p1 = values.get(i)[0];
                    int p2 = values.get(i)[1];
                    int p3 = values.get(j)[0];

                    double len1 = Math.sqrt((points[p1][0] - points[p3][0]) * (points[p1][0] - points[p3][0]) + (points[p1][1] - points[p3][1]) * (points[p1][1] - points[p3][1]));
                    double len2 = Math.sqrt((points[p2][0] - points[p3][0]) * (points[p2][0] - points[p3][0]) + (points[p2][1] - points[p3][1]) * (points[p2][1] - points[p3][1]));

                    minVal = Math.min(minVal, len1 * len2);
                }
            }
        }
        return minVal == Double.MAX_VALUE? 0: minVal;

    }
}