class Solution {
    //time complexity is O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        //fix the head pointer, rest two pointers
        //moving all 3 indexes make sure all of them not duplicate
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;
            int target = -nums[i];

            //3 cases:
            //  nums[start] + nums[end] = target
            //  nums[start] + nums[end] < target
            //  nums[start] + nums[end] > target
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == target) {
                    List<Integer> tmp = new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end]));
                    result.add(tmp);
                    start++;
                    end--; // we want to remove all duplicates
                    while (start < end && nums[start] == nums[start-1]) {
                        start++;
                    }

                    while (start < end && nums[end] == nums[end+1]) {
                        end--;
                    }
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}

class Solution {
    //O(n^2) time complexity 55.5% -> 61.3% after improvement
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        //key concept, make sure each time
        //get a set of values at each value occurence standing point can't be
        for (int i = 0; i < nums.length - 2; i++) {
            //make sure each time, starts with one single value
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //above three lines can be modified into:
            //if (i == 0 || (i > 0 && nums[i] != nums[i-1])) --> the below conditions
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    result.add(tmp);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

}
