/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */


//O(logn)time to find one, because in this problem, the range of solution is [1, n]
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        //find one then, it is
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}