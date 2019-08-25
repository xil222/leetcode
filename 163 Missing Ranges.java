class Solution {
    //well in dealing with edge cases, exclusive helper function can't make it work
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        //this problem since it is inclusive range of nums
        //betweeen lower and upper, therefore the first number to
        //check is the lower, the last number to check is upper

        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            result.add(helper(lower-1, upper+1));
            return result;
        }

        int cur = lower - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > cur + 1) {
                result.add(helper(cur, nums[i]));
            }
            cur = nums[i];
        }

        if (upper > cur) {
            result.add(helper(cur, upper + 1));
        }

        return result;
    }

    //exclusive helper function can't fix the edge case
    private String helper(int start, int end) {
        if (start + 2 == end) {
            return Integer.toString((int)(start + 1));
        } else {
            return Integer.toString((int)(start + 1)) + "->" + Integer.toString((int)(end - 1));
        }
    }
}


//Well I mean inclusive can make it work? This is the way to work without using long
//Need to check everytime when possibly exceeds Integer.MAX_VALUE
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        //this problem since it is inclusive range of nums
        //betweeen lower and upper, therefore the first number to
        //check is the lower, the last number to check is upper

        List<String> result = new ArrayList<>();

        int cur = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == cur && cur < Integer.MAX_VALUE) {
                cur++;
            } else if (cur < nums[i]){
                result.add(helper(cur, nums[i]-1));
                cur = nums[i] == Integer.MAX_VALUE? Integer.MAX_VALUE: nums[i] + 1;
            }
        }

        if (upper >= cur && cur < Integer.MAX_VALUE) {
            result.add(helper(cur, upper));
        }

        return result;
    }

    //inclusive case
    private String helper(int start, int end) {
        return start == end? Integer.toString(start): Integer.toString(start) + "->" + Integer.toString(end);
    }
}