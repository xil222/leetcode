class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            int start = i;
            int end = i;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                dp[start--][end++] = true;
            }
        }

        for (int i = 0; i < s.length()-1; i++) {
            int start = i;
            int end = i + 1;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                dp[start--][end++] = true;
            }
        }

        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<String>(), 0, dp, s);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> tmp, int i, boolean[][] dp, String s) {
        if (i == s.length()) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (dp[i][j]) {
                tmp.add(s.substring(i, j+1));
                dfs(result, tmp, j + 1, dp, s);
                tmp.remove(tmp.size()-1);
            }
        }

    }
}