//method 1, 68.6%, time complexity O(n^2)
class Solution {
    //the key here is for a string to be valid parenthesis, its number
    //of left, right are equal, and the number of open is 0.
    //use counter to record number of
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        Set<String> ans = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')'){
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        dfs(ans, s, sb,0 ,left, right, 0);
        return new ArrayList<String>(ans);
    }

    private void dfs(Set<String> ans, String s, StringBuilder sb, int pos, int left, int right, int open) {
        //base case
        if (left < 0 || right < 0 || open < 0) {
            return;
        }

        if (pos == s.length()) {
            if (left == 0 && right == 0 && open == 0) {
                ans.add(sb.toString());
            }
            return;
        }

        char item = s.charAt(pos);
        int len = sb.length();
        //every time, we choose to use or not use parenthesis
        if (s.charAt(pos) == '(') {
            dfs(ans, s, sb, pos+1, left - 1, right, open); //not use
            dfs(ans, s, sb.append(item), pos+1, left, right, open + 1); //use
        } else if (s.charAt(pos) == ')') {
            dfs(ans, s, sb, pos+1, left, right - 1 , open); //not use
            dfs(ans, s, sb.append(item), pos+1, left, right, open - 1); //use
        } else {
            dfs(ans, s, sb.append(item), pos + 1, left, right, open);
        }

        //the reverse operation of dfs
        sb.setLength(len);
    }
}

//if asking for just one solution, is that using flag a good approach? when finding one string that satisfies the
//condition, set flag to true then return.


//method 2, this approach is hard but there are lots of things to pay attention 100%
class Solution {
    //the key here is for a string to be valid parenthesis, its number
    //of left, right are equal, and the number of open is 0.
    //use counter to record number of
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        remove(s, result, 0, 0, new char[]{'(', ')'});
        return result;
    }

    private void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; j++) {
                //we only remove the first ')'
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, par);
                }
            }
            //need to pay attention, we return after trying out all options of remove ')'
            return;
        }

        //till here we guarantee that '(' no less than ')'
        String reverse = new StringBuilder(s).reverse().toString();
        if (par[0] == '(')
            remove(reverse, ans, 0, 0, new char[]{')', '('});
        else
            ans.add(reverse);
    }
}
