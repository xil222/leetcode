class Solution {
    //naive approach to solve this problem is O(n^2)
    //however, there exists duplicate actions of counting
    //making use a mergeSort optimize to O(nlogn)

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int[] count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i; //index i represents the real index
        }

        //after the sorting, the number in indexes messed up
        //but nums[indexes[i]] sorted, and indexes[i] map to the
        //real position in nums
        mergeSort(0, nums.length-1, count, indexes, nums);

        for (int i = 0; i < count.length; i++) {
            res.add(count[i]);
        }
        return res;
    }

    private void mergeSort(int start, int end, int[] count, int[] indexes, int[] nums) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(start, mid, count, indexes, nums);
        mergeSort(mid+1, end, count, indexes, nums);
        merge(start, end, count, indexes, nums);
    }

    private void merge(int start, int end, int[] count, int[] indexes, int[] nums) {
        int mid = (start + end) / 2;
        int left = start;
        int right = mid + 1;
        int[] tmp = new int[end - start + 1];

        int sort_index = 0;
        int toRight = 0; //represents how many val on right side have been moved to the left

        while (left <= mid && right <= end) {
            if (nums[indexes[right]] < nums[indexes[left]]) {
                tmp[sort_index] = indexes[right];
                toRight++;
                right++;
            } else {
                tmp[sort_index] = indexes[left];
                count[indexes[left]] += toRight;
                left++;
            }
            sort_index++;
        }

        while (left <= mid) {
            tmp[sort_index] = indexes[left];
            count[indexes[left]] += toRight;
            left++;
            sort_index++;
        }

        while (right <= end) {
            tmp[sort_index++] = indexes[right++];
        }

        //map back
        for (int i = 0; i < tmp.length; i++) {
            indexes[start + i] = tmp[i];
        }
    }

}