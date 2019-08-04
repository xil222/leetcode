class Solution {
    class Cell {
        String name;
        int count;
        public Cell(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }

    //time complexity nlog(k)
    public List<String> topKFrequent(String[] words, int k) {
        String[] res = new String[k];
        List<String> result = new ArrayList<String>();

        //first put into hashMap, then generate new data type
        //O(n)
        Map<String, Integer> hashMap = new HashMap<>();
        for (String item: words) {
            hashMap.put(item, hashMap.getOrDefault(item, 0)+1);
        }

        //ascending, then sort by characters
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(k, new Comparator<Cell>(){
            @Override
            public int compare(Cell a, Cell b) {
                if (a.count == b.count) {
                    return b.name.compareTo(a.name);
                }
                return a.count - b.count;
            }
        });

        //O(nlog(k))
        for (String tmp: hashMap.keySet()) {
            int cnt = hashMap.get(tmp);
            Cell top = pq.peek();
            if (pq.size() == k) {
                if (cnt > pq.peek().count || cnt == top.count && tmp.compareTo(top.name) < 0) {
                    pq.poll();
                    pq.offer(new Cell(tmp, cnt));
                }
            } else {
                pq.offer(new Cell(tmp, cnt));
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll().name;
        }

        for (int i = 0; i < k; i++) {
            result.add(res[i]);
        }

        return result;
    }
}