class MyCircularDeque {

    int size;
    int start;
    int end;
    int[] arr;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        size = 0;
        start = 0;
        end = -1;
        arr = new int[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (!isFull()) {
            start = (start + arr.length - 1) % arr.length;
            arr[start] = value;
            size++;
            if (end == -1) {
                end = start;
            }
            return true;
        }
        return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (!isFull()) {
            end = (end + 1) % arr.length;
            arr[end] = value;
            size++;
            if (start == -1) {
                start = end;
            }
            return true;
        }
        return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (!isEmpty()) {
            start = (start + 1) % arr.length;
            size--;
            return true;
        }
        return false;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (!isEmpty()) {
            end = (end + arr.length - 1) % arr.length;
            size--;
            return true;
        }
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty()? -1: arr[start];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty()? -1: arr[end];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == arr.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */