class Solution {

    //this is the optimal solution, time complexity worst case is O(mn)
    public boolean isAlienSorted(String[] words, String order) {
        //use an array to implement the mapping of letters
        int[] map = new int[26];

        //map index of map to real index
        //for example, 'h' is the first letter --> map[7] = 0
        //when comparing two strings, map['h' - 'a'] should be
        //the smallest one inside
        for (int i = 0; i < 26; i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length-1; i++) {
            if (!compare(words[i], words[i+1], map)) {
                return false;
            }
        }

        return true;
    }


    private boolean compare(String a, String b, int[] map) {
        int minLen = Math.min(a.length(), b.length());
        int cnt = 0;

        //three cases:
        //if front smaller than after, return true
        //if greater, return false
        //if same, just count

        for (int i = 0; i < minLen; i++) {
            if (map[a.charAt(i) - 'a'] < map[b.charAt(i) - 'a']) {
                return true;
            } else if (map[a.charAt(i) - 'a'] > map[b.charAt(i) - 'a']) {
                return false;
            } else if (map[a.charAt(i) - 'a'] == map[b.charAt(i) - 'a']) {
                cnt++;
            }
        }

        if (cnt == b.length() && cnt < a.length()) {
            return false;
        }

        return true;
    }
}