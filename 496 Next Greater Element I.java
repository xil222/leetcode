class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //cant use binary search here as the sequence is not sorted
        //naive approach is that use O(n) to check the next greater
        //element for each of the index in the array which overall
        //takes O(n^2) time complexity
        //however, there are duplicate actions

        //assume nums1 size n, nums2 size m.
        //we iterate the second

        //time complexity is O(n+m), space complexity is O(m)
        //keep a hashMap to map the val to next greater val
        //maintain a stack storing values in nums1 from high to low
        //when having a new val, updating all previous

        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.containsKey(nums1[i])? map.get(nums1[i]): -1;
        }

        return res;
    }
}