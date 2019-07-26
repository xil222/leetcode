class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int[] res = new int[2];
        res[0] = findFirstTarget(nums, target);
        if (res[0] == -1) {
            return new int[]{-1, -1};
        }
        res[1] = findLastTarget(nums, target);
        return res;
    }

    //1. if find and is the right position just return
    //2. if find but not target or greater than target, mid - 1
    //3. if smaller than target mid + 1
    private int findFirstTarget(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target && (mid == 0 || nums[mid - 1] < target)) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[start] == target? start: -1;
    }

    private int findLastTarget(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target && (mid == nums.length-1 || nums[mid+1] > target)) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nums[start] == target? start: -1;
    }

}