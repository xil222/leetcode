class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //if sorted can use two pointers
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start+1, end+1};
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[0];
   }
}