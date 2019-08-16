class MyCalendarTwo {
    //use treeMap to get keys from low to high
    //use + 1 represents one start
    //use - 1 represents meet one end
    //O(nlogn) time complexity
    TreeMap<Integer, Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        //will iterate the key from low to high
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            count += entry.getValue();
            if (count > 2) { //means
                //will return false so do recover
                map.put(start, map.get(start) - 1);
                if (map.get(start) == 0) {
                    map.remove(start);
                }

                map.put(end, map.get(end) + 1);
                if (map.get(end) == 0) {
                    map.remove(end);
                }
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */