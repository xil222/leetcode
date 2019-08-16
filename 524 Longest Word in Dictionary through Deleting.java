//sol1: O(nk)
class Solution {
    //use a integer array to store the index positions of
    //each word in the dictionary
    //just go over the string array
    //assume string length is N, there are k words
    //time complexity is O(kn)
    public String findLongestWord(String s, List<String> d) {
        int[] pos = new int[d.size()];
        String target = "";

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            for (int j = 0; j < pos.length; j++) {
                String tmp = d.get(j);
                if (pos[j] < tmp.length() && tmp.charAt(pos[j]) == cur) {
                    pos[j]++;
                    if (pos[j] == tmp.length()) {
                        if (target.equals("")) {
                            target = tmp;
                        } else {
                            target = compare(target, tmp);
                        }
                    }
                }
            }
        }
        return target;
    }

    private String compare(String target, String tmp) {
        if (target.length() == tmp.length()) {
            if (target.compareTo(tmp) < 0) {
                return target;
            }
            return tmp;
        } else if (target.length() > tmp.length()) {
            return target;
        } else {
            return tmp;
        }
    }
}

//sol2: O(nk + klogk)
class Solution {
    //use another way
    //first sort the d using the priority
    //O(nk + klog(k))
    //then doing iteration one by one
    public String findLongestWord(String s, List<String> d) {
        int[] pos = new int[d.size()];
        String target = "";

        Collections.sort(d, (a,b) -> a.length() != b.length() ? Integer.compare(b.length(), a.length()): a.compareTo(b));

        for (String item: d) {
            int idx = 0;
            for (int i = 0; i < s.length(); i++) {
                if (item.charAt(idx) == s.charAt(i)) idx++;
                if (idx == item.length()) return item;
            }
        }

        return "";
    }
}