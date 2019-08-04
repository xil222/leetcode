class SnapshotArray {

    //key: snapid, val: <idx, val>
    Map<Integer, Map<Integer, Integer>> snapMap = new HashMap<>();

    //key: index, val: val
    Map<Integer, Integer> idxMap = new HashMap<>();
    int snapId;
    int[] snapArray;

    public SnapshotArray(int length) {
        snapArray = new int[length];
        snapId = 0;
    }

    public void set(int index, int val) {
        idxMap.put(index, val);
    }

    public int snap() {
        int id = snapId;
        snapMap.put(snapId++, idxMap);
        idxMap = new HashMap<Integer, Integer>();
        return id;
    }

    public int get(int index, int snap_id) {
        int id = snap_id;
        while (id >= 0) {
            Map<Integer, Integer> tmpMap = snapMap.get(id);
            if (!tmpMap.containsKey(index)) {
                id--;
            } else {
                return tmpMap.get(index);
            }
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */