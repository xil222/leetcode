//since we need a range includes a number from each list
//each list must includes at least one number
//same as merge K list, maintain a minHeap
//since we got nested list instead of list of linkedlist
//therefore generated cell have three parameters
//assume avg n array each size k. nklog(n) is the time complexity
//beats 72.78%, memory usage 42.75%
class Solution {
    //idx is the idx of array
    //pos is the pos of one array
    //val is the value
    class Cell {
        int idx;
        int pos;
        int val;
        public Cell (int idx, int pos, int val) {
            this.idx = idx;
            this.pos = pos;
            this.val = val;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(nums.size(), new Comparator<Cell>() {
            @Override
            public int compare(Cell a, Cell b) {
                return a.val - b.val;
            }
        });

        //initialize maxVal
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            maxVal = Math.max(maxVal, val);
            pq.offer(new Cell(i, 0, val));
        }

        //initialize the minRange, and rseult
        int minRange = maxVal - pq.peek().val;
        int[] res = new int[]{pq.peek().val, maxVal};

        while (true) {
            Cell tmp = pq.poll();
            //notice tmp.pos + 1 *** not tmp.pos
            if (tmp.pos + 1 == nums.get(tmp.idx).size()) {
                break;
            } else {
                int val = nums.get(tmp.idx).get(tmp.pos + 1);
                //update maxVal and range
                maxVal = Math.max(val, maxVal);
                //then put into priorityQueue
                pq.offer(new Cell(tmp.idx, tmp.pos+1, val));
                if (maxVal - pq.peek().val < minRange) {
                    minRange = maxVal - pq.peek().val;
                    res[0] = pq.peek().val;
                    res[1] = maxVal;
                }
            }
        }

        return res;
    }
}