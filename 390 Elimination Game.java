//Optimal solution:
//  O(logn) time complexity
class Solution {
    public int lastRemaining(int n) {
        //A most efficient approach
        //as each time we remove half of elements
        //as we keep doing elimination size keep / 2
        //till 1 left and that is the element returned

        //just need to maintain the head
        //lets go over the example
        //we change the head when go from left to right
        //or right to left with all odd numbers
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;

        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head = head + step;
            }
            remaining /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }
}

//Naive Approach:
// Maintain two stacks to do the pop and push, nlog(n)
class Solution {
    public int lastRemaining(int n) {
        //this problem is looking for jump elimination
        //one after one from left to right to left

        //therefore we can maintain two stacks and few flags
        //to keep popping, till one element left

        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        boolean lToR = true;
        for (int i = n; i >= 1; i--) {
            left.push(i);
        }

        while (left.size() + right.size() > 1) {
            if (lToR) {
                while (!left.isEmpty()) {
                    left.pop();
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                }
            } else {
                while (!right.isEmpty()) {
                    right.pop();
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                }
            }
            lToR = !lToR;
        }

        return left.size() == 1? left.pop(): right.pop();
    }
}