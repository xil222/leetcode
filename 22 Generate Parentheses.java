class Solution {
    //condition for valid --> at each position the left parenthesis >= right parenthesis
    //Time Complexity: O(2^n)
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(result, sb, n, n);
        return result;
    }

    private void dfs(List<String> result, StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }

        if (left > 0) {
            sb.append('(');
            dfs(result, sb, left - 1, right);
            sb.deleteCharAt(sb.length()-1);
        }

        if (right > left) {
            sb.append(')');
            dfs(result, sb, left, right - 1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        //need to record number of left parenthesis, right parenthesis
        //in this kind of problem add data type to one list with the dfs
        //approach, remember to remove the last element in that data type
        List<String> result = new ArrayList<>();
        StringBuilder string = new StringBuilder();
        dfs(result, string, n, n);
        return result;
    }

    private void dfs(List<String> result, StringBuilder string, int left, int right) {
        //base case, when dfs reaches the end, we add string to the List
        if (left == 0 && right == 0) {
            result.add(new String(string));
            return;
        }

        //in dfs, 1. append
        //        2. go to next layer
        //        3. remove
        if (left > 0) {
            string.append('(');
            dfs(result, string, left-1, right);
            string.deleteCharAt(string.length()-1);
        }

        if (right > left) {
            string.append(')');
            dfs(result, string, left, right-1);
            string.deleteCharAt(string.length()-1);
        }
    }
}