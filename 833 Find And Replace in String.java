class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        //this doesn't say indexes is sorted, therefore
        //we need a hashMap to map between index value to index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], i);
        }

        StringBuilder sb = new StringBuilder();
        //if reaches the position of index, do a check
        int idx = 0;
        while (idx < S.length()) {
            if (map.containsKey(idx)) {
                int index = map.get(idx);
                int sourceLen = sources[index].length();
                String sub = S.substring(idx, idx+sourceLen);
                if (idx + sourceLen <= S.length() && sub.equals(sources[index])) {
                    sb.append(targets[index]);
                } else {
                    sb.append(sub);
                }
                idx += sourceLen;
            } else {
                sb.append(S.charAt(idx++));
            }
        }
        return sb.toString();
    }
}