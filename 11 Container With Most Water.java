//naive way to solve this problem O(n^2), only beats 18%
//max Area (i - j) * Math.min(height[i], height[j]);
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return maxArea;
    }
}

//better approach, greedy O(n) time complexity,
//need to figure out proof, when height[left] == height[right], moving left, right are the same
//because no matter moves which:
//Math.min(height[left+1], height[right])) == Math.min(height[left], height[right-1]))

//proof:
//In this height array, say height[5],[14] composes the greatest area of
//to simplify the proof, when we are at the 4, 14, it has to shift to 5, 14, and it must be
//height[4] < height[14] to ensure [5], [14] to be the largest area.
//if height[4] > height[14], greatest area [4], [14] rather than [5], [14]. b/c area of [4] [14]
//is at least height[14] * (14 - 4). For [5], [14] it is at most (14-5) * height[14], because the
//the most area limited by either side, contradiction.

//greedy approach, time complexity O()
class Solution {
    public int maxArea(int[] height) {
        int leftBound = 0;
        int rightBound = height.length - 1;
        int maxArea = 0;
        while (leftBound < rightBound) {
            maxArea = Math.max(maxArea, (rightBound - leftBound) * Math.min(height[leftBound],height[rightBound]));
            if (height[leftBound] < height[rightBound]) {
                leftBound++;
            } else {
                rightBound--;
            }
        }

        return maxArea;
    }
}