//all operations require O(1) time complexity
//in order to check whether item in use O(1) time
//need a random to do the random
//and need a list to fetch items

class RandomizedSet {

    /** Initialize your data structure here. */
    Random random;
    //key: val, val: idx
    Map<Integer, Integer> map;
    List<Integer> tmp;

    public RandomizedSet() {
        random = new Random();
        map = new HashMap<>();
        tmp = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, tmp.size());
            tmp.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            //remove the last ele in the list
            //set the val of last element in the list
            //to the pos
            int pos = map.get(val);
            int lastVal = tmp.get(tmp.size()-1);
            map.put(lastVal, pos);
            map.remove(val);
            tmp.set(pos, lastVal);
            tmp.remove(tmp.size()-1);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return tmp.get(random.nextInt(tmp.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */