//assume the we set timestamp only grows
//in other words, content we put into data
//structure, its timestamp only grows
class TimeMap {
    class Data {
        String val;
        int time;
        public Data(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }

    //requires hashMap to implement
    //key: String, val: List
    Map<String, List<Data>> hashMap;

    /** Initialize your data structure here. */
    public TimeMap() {
        hashMap = new HashMap<String, List<Data>>();
    }

    public void set(String key, String value, int timestamp) {
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new ArrayList<Data>());
        }
        List<Data> data = hashMap.get(key);
        data.add(new Data(value, timestamp));
        hashMap.put(key, data);
    }

    public String get(String key, int timestamp) {
        if (!hashMap.containsKey(key))
            return "";
        List<Data> data = hashMap.get(key);
        //find the first item before or equal timestamp
        return binarySearch(data, timestamp);
    }

    //O(log(n))
    private String binarySearch(List<Data> data, int timestamp) {
        int start = 0;
        int end = data.size()-1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (data.get(mid).time == timestamp) {
                return data.get(mid).val;
            } else if (data.get(mid).time < timestamp) {
                if (data.get(mid+1).time > timestamp) return data.get(mid).val;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return data.get(start).time <= timestamp? data.get(start).val: "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */