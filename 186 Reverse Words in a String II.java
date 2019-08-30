class Solution {
    public void reverseWords(char[] str) {
        //reverse the entire array
        //reverse each word
        reverse(str, 0, str.length-1);
        int start = 0;
        int cur = 0;
        while (cur < str.length) {
            while (cur < str.length && str[cur] != ' ') {
                cur++;
            }
            reverse(str, start, cur-1);
            cur++;
            start = cur;
        }
    }

    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }

}