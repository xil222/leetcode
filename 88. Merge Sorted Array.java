class Solution {
    //remember the index
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int rightBound = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m-1] > nums2[n-1]) {
                nums1[rightBound--] = nums1[m-1];
                m--;
            } else {
                nums1[rightBound--] = nums2[n-1];
                n--;
            }
        }

        //if n = 0, no need to move any more
        while (n > 0) {
            nums1[rightBound--] = nums2[n-1];
            n--;
        }
    }
}

//below looks nicer:
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int rightBound = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[rightBound--] = nums1[m--];
            } else {
                nums1[rightBound--] = nums2[n--];
            }
        }

        while (n >= 0) {
            nums1[rightBound--] = nums2[n--];
        }
    }
}