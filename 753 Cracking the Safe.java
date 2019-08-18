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