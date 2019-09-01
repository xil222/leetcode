class MyCalendar {
    //find each of the new added element
    //get the next > start compare with end
    //log(n) time complexity
    //key: start, val: end
    //we are maintaining a valid treeMap always
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }

    //log(n) time complexity.
    public boolean book(int start, int end) {
        Integer last = map.floorKey(start); //return last key <= start
        if (last != null && map.get(last) > start) {
            return false;
        }

        Integer next = map.ceilingKey(start);
        if (next != null && next < end) {
            return false;
        }
        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */