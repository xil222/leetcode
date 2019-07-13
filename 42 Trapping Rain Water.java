//method 1: time O(n), space O(n)
class Solution {
    //basic approach, the area at each pos is min(leftBound, rightBound) - height
    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int[] leftBound = new int[height.length];
        int[] rightBound = new int[height.length];
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            if (i == 0 || height[i] > leftBound[i-1]) {
                leftBound[i] = height[i];
            } else {
                leftBound[i] = leftBound[i-1];
            }
        }

        for (int i = height.length-1; i >= 0; i--) {
            if (i == height.length-1 || height[i] > rightBound[i+1]) {
                rightBound[i] = height[i];
            } else {
                rightBound[i] = rightBound[i+1];
            }
        }

        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftBound[i], rightBound[i]) - height[i];
        }

        return res;
    }
}

//method 2: time O(n), space O(1)
class Solution {
    public int trap(int[] height) {
        int area = 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int leftIdx = 0;
        int rightIdx = height.length - 1;

        //As we move from left to right, leftBound constantly increases
        //As we move from right to left, rightBound keep decreases

        //By keep updating the leftMax and rightMax, we calculate the area
        while (leftIdx <= rightIdx) {
            leftMax = Math.max(height[leftIdx], leftMax);
            rightMax = Math.max(height[rightIdx], rightMax);

            if (leftMax < rightMax) {
                area += leftMax - height[leftIdx];
                leftIdx++;
            } else {
                area += rightMax - height[rightIdx];
                rightIdx--;
            }
        }

        return area;
    }
}

