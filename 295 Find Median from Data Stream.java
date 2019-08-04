//beats 87%, log(n) --> n stands for size of pq
class MedianFinder {

    //same as 480, use two priorityQueue on this problem
    //one maxHeap storing number smaller than median
    //one minHeap to store number greater than median
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });
    }

    public void addNum(int num) {
        if (num < findMedian()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        } else if (minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            return 0;
        } else if (minHeap.size() == maxHeap.size()) {
            return ((double)(maxHeap.peek()) + (double)(minHeap.peek())) / 2;
        } else {
            return (double)(minHeap.peek());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */