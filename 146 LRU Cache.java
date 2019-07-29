class LRUCache {
    //beats 42% time, beats 71% space

    //for this problem, to get a O(1) time complexity
    //we should use LinkedList each node represent key

    //in order to find the place when calling get method
    //or there is redundent when calling put method
    //use a hashMap

    class Node {
        int val;
        int key; //this is for remove tail
        Node next;
        Node prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    //head represents the most recent used node
    //set up dummy head and tail to simplify add and remove action
    Node head;
    Node tail;
    Map<Integer, Node> hashMap; //use map size represents size --> don't need count
    int size;

    public LRUCache(int capacity) {
        size = capacity;
        hashMap = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    //hashMap ensures the complexity to be O(1)
    //get only renew
    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }
        Node node = hashMap.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        //case 1: key exists in the hashMap, remove then add
        //case 2: the map is full --> remove tail and add
        //case 3: just add
        //so overall put add part in the last part
        Node newHead = new Node(key, value);
        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            removeNode(node);
        } else if (hashMap.size() == size) {
            removeNode(tail.prev);
        }
        addNode(newHead);
    }

    private void removeNode(Node node) {
        //remove the node
        hashMap.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNode(Node node) {
        hashMap.put(node.key, node);
        Node next = head.next;
        next.prev = node;
        head.next = node;
        node.prev = head;
        node.next = next;
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */