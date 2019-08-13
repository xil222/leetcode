class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int start = 0;
        int end = nums.length - 1;
        int[] res = new int[nums.length];

        //if a < 0 --> largest in the middle, start fill from left
        //if a > 0 --> largest on two sides, start fill from right
        //if a = 0 --> doesn't matter because we got largest on one side
        if (a > 0) {
            for (int i = res.length - 1; i >= 0; i--) {
                int leftVal = cal(a,b,c,nums[start]);
                int rightVal = cal(a,b,c,nums[end]);
                if (leftVal < rightVal) {
                    res[i] = rightVal;
                    end--;
                } else {
                    res[i] = leftVal;
                    start++;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                int leftVal = cal(a,b,c,nums[start]);
                int rightVal = cal(a,b,c,nums[end]);
                if (leftVal < rightVal) {
                    res[i] = leftVal;
                    start++;
                } else {
                    res[i] = rightVal;
                    end--;
                }
            }
        }

        return res;
    }

    private int cal(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }

}