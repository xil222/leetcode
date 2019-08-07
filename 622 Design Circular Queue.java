//the most important thing is do % on the queue.length
class MyCircularQueue {
    int[] queue;
    int start;
    int end;
    int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
        start = 0;
        end = -1; //record the idx of last inserted item
        size = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (!isFull()) {
            end = (end + 1) % queue.length;
            queue[end] = value;
            size++;
            return true;
        }
        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (!isEmpty()) {
            start = (start + 1) % queue.length;
            size--;
            return true;
        }
        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty()? -1: queue[start];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty()? -1: queue[end];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == queue.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */