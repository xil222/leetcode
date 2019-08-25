class DinnerPlates {

    List<Stack<Integer>> stacks;
    int limit;
    int leftMost; //strict leftMost pos to push capacity not full
    int rightMost; //strict rightMost pos to pop

    public DinnerPlates(int capacity) {
        stacks = new ArrayList<>();
        limit = capacity;
        leftMost = 0;
        rightMost = 0;
    }

    public void push(int val) {
        //all full
        if (leftMost == stacks.size()) {
            stacks.add(new Stack<Integer>());
            rightMost = stacks.size() - 1;
        }

        //not all full
        stacks.get(leftMost).push(val);
        rightMost = Math.max(rightMost, leftMost);
        while (leftMost < stacks.size() && stacks.get(leftMost).size() == limit) {
            leftMost++;
        }

    }


    //update LeftMost
    public int pop() {
        if (rightMost == -1) {
            return -1;
        }
        int res = stacks.get(rightMost).pop();
        leftMost = Math.min(leftMost, rightMost);
        while (rightMost >= 0 && stacks.get(rightMost).size() == 0) rightMost--;
        return res;
    }

    //update LeftMost
    public int popAtStack(int index) {
        if (index >= stacks.size() || index < 0 || stacks.get(index).isEmpty()) {
            return -1;
        }
        int res = stacks.get(index).pop();
        leftMost = Math.min(leftMost, index);
        while (index >= 0 && stacks.get(index).size() == 0) index--;

        return res;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */