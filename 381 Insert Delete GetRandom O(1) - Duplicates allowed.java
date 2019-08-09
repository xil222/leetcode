class RandomizedCollection {

    //this problem is same as the previous one
    Map<Integer, Set<Integer>> map;
    Random random;
    List<Integer> tmp;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        random = new Random();
        tmp = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = false;
        if (!map.containsKey(val)) {
            contains = true;
            map.put(val, new HashSet<Integer>());
        }
        Set<Integer> l = map.get(val);
        l.add(tmp.size());
        tmp.add(val);
        map.put(val, l);
        return contains;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        //if contains, remove the last element in the List<> of mapped val
        if (!map.containsKey(val)) {
            return false;
        }
        int pos = map.get(val).iterator().next();
        map.get(val).remove(pos);
        //change the index of previous last val to the index of this val
        if (pos != tmp.size()-1) {
            int lastEle = tmp.get(tmp.size()-1);
            tmp.set(pos, lastEle);
            map.get(lastEle).remove(tmp.size()-1);
            map.get(lastEle).add(pos);
        }
        tmp.remove(tmp.size()-1);

        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return tmp.get(random.nextInt(tmp.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */