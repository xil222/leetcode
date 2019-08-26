class Solution {
    public boolean checkValidString(String s) {
        //two stacks storing star and left index
        Stack<Integer> star = new Stack<>();
        Stack<Integer> left = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                star.push(i);
            } else if (s.charAt(i) == '(') {
                left.push(i);
            } else {
                if (star.isEmpty() && left.isEmpty()) {
                    return false;
                } else if (!left.isEmpty()) {
                    left.pop();
                } else {
                    star.pop();
                }
            }
        }

        //for star, position index on the right
        while (!left.isEmpty()) {
            if (star.isEmpty() || star.peek() < left.peek()) {
                return false;
            }
            star.pop();
            left.pop();
        }

        return true;
    }
}