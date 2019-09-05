class Solution {
    //idea is merging any closing two parts
    //using dfs recursion is the approach
    //there are two cases, single char
    //or {a, b}, using set

    //O(n^2) time complexity, at most O(n) combination
    //each take O(n) time.
    public String[] expand(String S) {
        TreeSet<String> set = new TreeSet<>();
        if (S.length() <= 1) {
            return new String[]{S};
        }

        int idx = 0;
        if (S.charAt(idx) == '{') {
            while (S.charAt(idx) != '}') {
                idx++;
            }
            String[] str1 = S.substring(1, idx).split(",");
            String[] str2 = expand(S.substring(idx+1));
            for (String s1: str1) {
                for (String s2: str2) {
                    set.add(s1 + s2);
                }
            }
        } else { //single char
            String[] str3 = expand(S.substring(idx+1));
            for (String s3: str3) {
                set.add(S.charAt(idx) + s3);
            }
        }
        return set.toArray(new String[0]);
    }
}

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