class Solution {
    public int calculate(String s) {
        //in doing these kind of problems
        //case 1: number
        //case 2: '+'
        //case 3: '-'
        //case 4: '('
        //case 5: ')'

        //ignore spaces
        //to analyze the logic inside, lets take a more complexed example
        //(1+(4+5+2)-3)+(6+8)
        //when '(' need to put previous sign and value into stack

        //initiate a new datastructure
        //when ')' need to append/add results

        //reset number to 0 after sign, bracket

        Stack<Integer> vals = new Stack<>(); //store the vals before (
        Stack<Character> signs = new Stack<>(); //store the sign before (

        int res = 0;
        int val = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                val = val * 10 + (int)(c - '0');
            } else if (c == '+') {
                res += sign == '+'? val: -val;
                val = 0;
                sign = '+';
            } else if (c == '-') {
                res += sign == '+'? val: -val;
                val = 0;
                sign = '-';
            } else if (c == '(') {
                vals.push(res);
                signs.push(sign);
                res = 0;
                sign = '+';
            } else if (c == ')') {
                res += sign == '+'? val: -val;
                val = 0;
                res = signs.pop() == '+'? res: -res;
                res = vals.pop() + res;
            }
        }

        //if there is number left
        if (val != 0) {
            res += sign == '+'? val : -val;
        }

        return res;
    }
}