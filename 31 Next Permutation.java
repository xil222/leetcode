class Solution {
    //beats 100% time
    public void nextPermutation(int[] nums) {
        //first base case
        if (nums == null || nums.length < 2) {
            return;
        }

        int idx = nums.length - 1;
        //find the first occurence of previous digit smaller than the later digit
        while (idx > 0) {
            if (nums[idx - 1] < nums[idx]) {
                break;
            }
            idx--;
        }

        //if it is already smallest
        if (idx == 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            // for part of like abcde where a < e < d < c < b
            // swap a with b, --> ebcda --> then reverse b to a --> ebdcb
            // first find most last digit greater than target
            int last = nums.length - 1;
            while (last > idx) {
                if (nums[last] > nums[idx-1]) {
                    break;
                }
                last--;
            }

            swap(nums, idx - 1, last);
            reverse(nums, idx, nums.length - 1);
        }

    }

    private void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

}