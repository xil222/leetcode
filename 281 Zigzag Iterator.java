public class ZigzagIterator {

    Queue<Iterator> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (!v1.isEmpty()) {
            queue.offer(v1.iterator());
        }
        if (!v2.isEmpty()) {
            queue.offer(v2.iterator());
        }
    }

    public int next() {
        Iterator tmp = queue.poll();
        int res = (Integer)tmp.next();
        if (tmp.hasNext()) {
            queue.offer(tmp);
        }
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */