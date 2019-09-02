class Solution {
    public String decodeString(String s) {

        Stack<Integer> nums = new Stack<>();
        Stack<String> strings = new Stack<>();

        //if number isDigit --> keep increasing stacking
        //else if '[' --> put previous string and number to stack
        //else if character --> keep adding to res
        //else if ']' --> pop.String + number * res

        String res = "";
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (int) (s.charAt(i) - '0');
            } else if (s.charAt(i) == '[') {
                nums.push(num);
                strings.push(res);
                res = "";
                num = 0;
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(strings.pop());
                int cnt = nums.pop();
                for (int idx = 0; idx < cnt; idx++) {
                    sb.append(res);
                }
                res = sb.toString();
            } else {
                res += s.charAt(i);
            }
        }
        return res;
    }
}


class Solution {
    //Time Complexity: O(n)
    public String decodeString(String s) {
        //this is a stack problem
        //we have number right in front of each '[', therefore they are in pair
        Stack<Integer> val = new Stack<Integer>();
        //need another stack to store strings before the number
        Stack<String> string = new Stack<String>();

        //There are 4 cases:
        //1. if number is continue counting
        //2. if '[' means need to count chars in brackets, initialize a datastruture
        //3. if ']' means need to count things stored
        //4. if just character, append would be enough

        String res = "";
        int idx = 0;

        while (idx < s.length()) {
            //since there is always '[' after number
            if (Character.isDigit(s.charAt(idx))) {
                int num = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    num = num * 10 + (int) (s.charAt(idx) - '0');
                    idx++;
                }
                val.push(num);
            } else if (s.charAt(idx) == '[') { //store all previous stuff
                string.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder sb = new StringBuilder();
                sb.append(string.pop());
                int count = val.pop();
                for (int i = 0; i < count; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                idx++;
            } else {
                res += s.charAt(idx);
                idx++;
            }
        }

        return res.toString();
    }
}