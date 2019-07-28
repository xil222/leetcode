//beats 17%, O(mn) time complexity
class Solution {
    public String toGoatLatin(String S) {
        String[] words = S.split("\\s+");
        StringBuilder result = new StringBuilder();
        Set<Character> hashSet = new HashSet<>();
        hashSet.add('a');
        hashSet.add('e');
        hashSet.add('i');
        hashSet.add('o');
        hashSet.add('u');
        hashSet.add('A');
        hashSet.add('E');
        hashSet.add('I');
        hashSet.add('O');
        hashSet.add('U');

        for (int i = 0; i < words.length; i++) {
            if (isVow(hashSet, words[i].charAt(0))) {
                result.append(addVow(new StringBuilder(words[i]), i+2)).append(" ");
            } else {
                result.append(addConsonant(new StringBuilder(words[i]), i+2)).append(" ");
            }
        }

        return result.substring(0, result.length()-1);
    }

    private boolean isVow(Set<Character> hashSet, Character item) {
        if (hashSet.contains(item)) {
            return true;
        }
        return false;
    }

    private String addVow(StringBuilder word, int cnt) {
        word.append('m');
        for (int i = 0; i < cnt; i++)
            word.append('a');
        return word.toString();
    }

    private String addConsonant(StringBuilder word, int cnt) {
        char lastDigit = word.charAt(0);
        word.deleteCharAt(0);
        word.append(lastDigit).append('m');
        for (int i = 0; i < cnt; i++)
            word.append('a');
        return word.toString();
    }
}

//this approach accelerates
class Solution {
    public String toGoatLatin(String S) {
        String[] words = S.split("\\s+");
        StringBuilder result = new StringBuilder();
        Set<Character> hashSet = new HashSet<>();
        hashSet.add('a');
        hashSet.add('e');
        hashSet.add('i');
        hashSet.add('o');
        hashSet.add('u');
        hashSet.add('A');
        hashSet.add('E');
        hashSet.add('I');
        hashSet.add('O');
        hashSet.add('U');

        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                result.append(' ');
            }

            char c = words[i].charAt(0);
            if (hashSet.contains(c)) {
                result.append(words[i]);
            } else {
                result.append(words[i].substring(1, words[i].length()));
                result.append(words[i].charAt(0));
            }
            result.append('m');
            for (int j = 0; j < i + 2; j++) {
                result.append('a');
            }
        }

        return result.toString();
    }


}

