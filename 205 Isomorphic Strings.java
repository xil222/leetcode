class Solution {
    public boolean isIsomorphic(String s, String t) {
        //map character to the same index and
        //then check whether is valid that way
        if (s.length() != t.length()) {
            return false;
        }

        int[] smap = new int[256];
        int[] tmap = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (smap[s.charAt(i)] != tmap[t.charAt(i)]) {
                return false;
            }
            smap[s.charAt(i)] = i + 1;
            tmap[t.charAt(i)] = i + 1;
        }

        return true;
    }
}