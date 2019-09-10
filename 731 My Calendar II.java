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

class MyCalendarTwo {
    //idea is we use another treeMap to record the duplicate area
    //if adding region --> overlap with duplicate region
    //return false
    //O(logn) time complexity
    TreeMap<Integer, Integer> firstBook;
    TreeMap<Integer, Integer> duplicate;

    public MyCalendarTwo() {
        firstBook = new TreeMap<>();
        duplicate = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        //first check whether overlap with dup

        Integer prevDup = duplicate.floorKey(start);
        if (prevDup != null && duplicate.get(prevDup) > start) {
            return false;
        }
        Integer nextDup = duplicate.ceilingKey(start);
        if (nextDup != null && nextDup < end) {
            return false;
        }

        if(firstBook.size() == 0) {
            firstBook.put(start, end);
            return true;
        }

        //then check whether overlap with current
        Integer prev = firstBook.floorKey(start);
        if (prev != null && firstBook.get(prev) > start) {
            int endPoint = firstBook.get(prev);
            duplicate.put(start, Math.min(end, endPoint));
            start = prev;
            end = Math.max(end, endPoint);
            firstBook.remove(prev);
        }

        //since we update the end, that might cause duplicate with multiple intervals on the right
        Integer next = firstBook.ceilingKey(start);
        while (next != null && next < end) {
            int endPoint = firstBook.get(next);
            duplicate.put(next, Math.min(end, endPoint));
            firstBook.remove(next);
            end = Math.max(end, endPoint);
            next = firstBook.ceilingKey(start);
        }

        firstBook.put(start, end);

        return true;
    }
}
