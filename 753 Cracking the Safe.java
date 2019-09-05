class Solution {
    public String crackSafe(int n, int k) {
        //k ^ n combinations
        //when our substring covers all the possibilities
        //and is the shortest one, we end
        //so our approach is by appending one by one starting
        //from the smallest possibility 00000s
        int target = (int) Math.pow(k, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append('0');

        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        dfs(sb, n, visited, k, target);
        return sb.toString();
    }

    //the first answer we find is the shortest one as we starts from 00000 and appending gradually larger,
    //each new number we append is new otherwise we remove it and move back
    private boolean dfs(StringBuilder sb, int n, Set<String> visited, int k, int target) {
        if (visited.size() == target) {
            return true;
        }

        String sub = sb.substring(sb.length() - n + 1, sb.length());
        for (int i = 0; i < k; i++) {
            String next = sub + i;
            if (!visited.contains(next)) {
                visited.add(next);
                sb.append(i);
                if (dfs(sb, n, visited, k, target)) {
                    return true;
                }
                sb.deleteCharAt(sb.length()-1);
                visited.remove(next);
            }
        }
        return false;
    }


}

class Solution {
    public String crackSafe(int n, int k) {
        //options decided by k and n
        //total combinations number is k ^ n
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < n; i++) {
            sb.append('0');
        }

        //record length n string that has been visited
        Set<String> set = new HashSet<>();
        set.add(sb.toString());
        int target = (int)Math.pow(k, n);
        //we are targeting at return once we find
        //size of set equals total options
        dfs(sb, set, target, n, k);
        return sb.toString();
    }

    private boolean dfs(StringBuilder sb, Set<String> set, int target, int n, int k) {
        if (set.size() == target) {
            return true;
        }

        //take last n - 1 digits
        //since we want to find the shortest one,
        //once found, need to return
        //otherwise, remove the redundent characters
        //since we need to find the optimal through dfs, requires remove unnecessary items
        String tmp = sb.substring(sb.length()+1-n);
        for (char i = '0'; i < '0' + k; i++) {
            String newString = tmp + i;
            if (!set.contains(newString)) {
                set.add(newString);
                sb.append(i);
                if (dfs(sb, set, target, n, k)) {
                    return true;
                }
                sb.deleteCharAt(sb.length()-1);
                set.remove(newString);
            }
        }
        return false;
    }
}