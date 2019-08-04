//beats 88%
class Solution {
    //worst approach is O(nk)
    //a better approach is to use PriorityQueues
    //a minHeap to store vals more than median --> pq1
    //a maxHeap to store vals less than median --> pq2 maxHeap
    //need to guarantee both heaps size won't differ by one
    //minHeap.size() == maxHeap.size() || minHeap.size() == maxHeap.size() + 1
    //this time complexity is O(nlogk)

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a); /// ***** in order to pass compare max and min --> comparator set b.compareTo(a)
            }
        });

        //use 2 pq, their size can't differetiate by more than 1
        for (int i = 0; i < nums.length; i++) {
            add(nums[i], minHeap, maxHeap);
            if (i >= k - 1) {
                res[i - k + 1] = getMedian(minHeap, maxHeap);
                remove(minHeap, maxHeap, nums[i-k+1]);
            }
        }
        return res;
    }

    //condition for adding, add to pq1 if smaller than median
    //else add to median
    private void add(int val, PriorityQueue<Integer> pq1, PriorityQueue<Integer> pq2) {
        if (val > getMedian(pq1, pq2)) {
            pq1.offer(val);
        } else {
            pq2.offer(val);
        }

        if (pq1.size() - pq2.size() > 1) {
            pq2.offer(pq1.poll());
        }

        if (pq1.size() < pq2.size()) {
            pq1.offer(pq2.poll());
        }

    }

    //getMedian
    private double getMedian(PriorityQueue<Integer> pq1, PriorityQueue<Integer> pq2) {
        if (pq1.size() == 0 && pq2.size() == 0) {
            return 0;
        }

        if (pq1.size() == pq2.size()) {
            return ((double)pq1.peek() + (double)pq2.peek()) / 2;
        }
        return (double)pq1.peek();
    }

    //remove items
    private void remove(PriorityQueue<Integer> pq1, PriorityQueue<Integer> pq2, int val) {
        if (val >= getMedian(pq1, pq2)) {
            pq1.remove(val);
        } else {
            pq2.remove(val);
        }


        if (pq1.size() - pq2.size() > 1) {
            pq2.offer(pq1.poll());
        }

        if (pq1.size() < pq2.size()) {
            pq1.offer(pq2.poll());
        }
    }
}