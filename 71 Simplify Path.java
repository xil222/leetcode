class Solution {
    public String simplifyPath(String path) {
        //two steps. put things in the stack till the end
        //reconstruct
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        String result = "";

        for (int i = 0; i < paths.length; i++) {
            String tmp = paths[i];
            if (tmp.equals("") || tmp.equals(".")) {
                continue;
            } else if (tmp.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(tmp);
            }
        }

        //need to consider the reverse sequence
        while(!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        return result.equals("")? "/":result;
    }
}