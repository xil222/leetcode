class Solution {
    //assume there is n words each with length m, O(nm) time complexity
    public int countCharacters(String[] words, String chars) {
        int[] charsDic = new int[26];
        int count = 0;
        for (int i = 0; i < chars.length(); i++) {
            charsDic[(int)(chars.charAt(i) - 'a')]++;
        }

        for (int i = 0; i < words.length; i++) {
            int[] word = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                word[(int)(words[i].charAt(j) - 'a')]++;
            }
            if (contains(word, charsDic)) {
                count += words[i].length();
            }
        }
        return count;
    }

    private boolean contains(int[] word, int[] chars) {
        for (int i = 0; i < 26; i++) {
            if (word[i] > chars[i]) {
                return false;
            }
        }
        return true;
    }
}