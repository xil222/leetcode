class MajorityChecker {
    int[] arr;

    public MajorityChecker(int[] arr) {
        this.arr = arr;
    }

    public int query(int left, int right, int threshold) {
        // find major num
        int major = arr[left];
        int count = 1;

        for (int i = left + 1; i <= right; i++) {
            if (count == 0) {
                major = arr[i];
                count = 1;
            } else if (major == arr[i]) {
                count++;
            } else {
                count--;
            }
        }

        //  check the major num's freq >= threshold
        int cnt = 0;

        for (int i = left; i <= right; i++) {
            if (arr[i] == major) {
                cnt++;
            }
        }
        if (cnt >= threshold) {
            return major;
        }
        return -1;
    }
}


/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */