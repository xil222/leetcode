//Each of the operations takes O(1) time complexity in this case
//the initial function takes O(n) time, may have some potential to optimize
class PhoneDirectory {
    // starting with discussing about the functionality we want to achieve
    // need a data structure to store all available, and
    // use hashSet to store all remaining number

    Set<Integer> set;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        set = new HashSet<>();
        for (int i = 0; i < maxNumbers; i++) {
            set.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (set.isEmpty()) return -1;
        Iterator<Integer> iter = set.iterator();
        int nextVal = iter.next();
        set.remove(nextVal);
        return nextVal;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return set.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        set.add(number);
    }
}




