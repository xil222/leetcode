//Naive solution O(3n) --> O(n)
class Solution {
    //1st step remove spaces
    //2nd step reverse the entire string
    //3rd reverse each of the word
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        int idx = 0;
        while (idx < s.length()) {
            while (idx < s.length() && s.charAt(idx) == ' ') {
                idx++;
            }

            if (idx == s.length()) break;

            if (isFirst) {
                isFirst = false;
            } else {
                sb.append(' ');
            }

            while (idx < s.length() && s.charAt(idx) != ' ') {
                sb.append(s.charAt(idx++));
            }
        }

        reverseString(sb, 0, sb.length()-1);

        //reverse word condition reach the last or reach the space
        int start = 0;
        int end = 0;
        while (end < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            end++;
            start = end;
        }
        reverseString(sb, start, end - 1);

        return sb.toString();
    }

    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            swap(sb, start++, end--);
        }
    }

    private void swap(StringBuilder sb, int start, int end) {
        char tmp = sb.charAt(start);
        sb.setCharAt(start, sb.charAt(end));
        sb.setCharAt(end, tmp);
    }
}

//To optimize we can combine first 2 steps
//iterate from last to first, then reverse each word, complexity to O(2n)