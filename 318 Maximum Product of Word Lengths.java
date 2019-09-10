class Solution {
    //The goal of this problem is to find two words
    //with no dup characters
    //while their length multiplication is long
    //Assume there are m words, average length n
    //there are O(m^2) combination, total time
    //complexity is O(nm^2)

    //key:
    //the approach to optimize the solution is
    //optimizing to O(1) checking whether two
    //words have same characters.

    //Since this problem has assumed only lower case
    //letters, we are able to use 1 bit to represent
    //the occurence of one char, use logic and to check
    //whether two words have same characters

    //Time Complexity: O(m(n + m))
    public int maxProduct(String[] words) {
        int[] vals = new int[words.length];
        int maxLen = 0;

        for (int i = 0; i < words.length; i++) {
            int num = 0;
            String s = words[i];
            for (int j = 0; j < s.length(); j++) {
                num |= 1 << ((int)(s.charAt(j) - 'a'));
            }
            vals[i] = num;
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((vals[i] & vals[j]) == 0) {
                    maxLen = Math.max(maxLen, words[i].length() * words[j].length());
                }
            }
        }
        return maxLen;
    }
}