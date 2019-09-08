class Solution {
    //Time Complexity: O(2^n)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmp, int[] nums, int index) {
        if (index == nums.length) {
            result.add(new ArrayList(tmp));
            return;
        }

        tmp.add(nums[index]);
        backtrack(result, tmp, nums, index+1);
        tmp.remove(tmp.size()-1);
        while (index < nums.length -1 && nums[index] == nums[index+1]) index++;
        backtrack(result, tmp, nums, index+1);
    }
}