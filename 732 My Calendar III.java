class MyCalendarThree {

    private TreeMap<Integer, Integer> time;

    public MyCalendarThree() {
        time = new TreeMap<>();
    }

    public int book(int start, int end) {
        time.put(start, time.getOrDefault(start, 0) + 1);
        time.put(end, time.getOrDefault(end, 0) -1);
        int maxVal = 0;
        int cnt = 0;
        for (int val: time.values()) {
            cnt += val;
            maxVal = Math.max(maxVal, cnt);
        }

        return maxVal;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */