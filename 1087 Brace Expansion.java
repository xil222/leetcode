class Solution {
    //dfs
    public String[] expand(String S) {
        //need to return the lexicographical order
        TreeSet<String> set = new TreeSet<>();
        if (S.length() == 0) {
            return new String[]{""};
        } else if (S.length() == 1) {
            return new String[]{S};
        }

        int idx = 0;
        if (S.charAt(idx) == '{') {
            while (S.charAt(idx) != '}') {
                idx++;
            }
            String sub = S.substring(1, idx);
            String[] strings = sub.split(",");
            String[] strs = expand(S.substring(idx+1));
            for (int j = 0; j < strings.length; j++) {
                for (String str: strs) {
                    set.add(strings[j] + str);
                }
            }
        } else {
            String[] strs = expand(S.substring(1));
            for (String str: strs) {
                set.add(S.charAt(0) + str);
            }
        }
        return set.toArray(new String[0]);
    }
}