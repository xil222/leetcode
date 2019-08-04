class Solution {
    public String addStrings(String num1, String num2) {
        //base case
        if (num1 == null || num1.length() == 0) {
            return num2;
        } else if (num2 == null || num2.length() == 0) {
            return num1;
        }

        StringBuilder sb = new StringBuilder();
        int next = 0;
        int val = 0;
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;

        while (idx1 >= 0 || idx2 >= 0 || next == 1) {
            int val1 = idx1 >= 0 ? (num1.charAt(idx1--) - '0'):0;
            int val2 = idx2 >= 0 ? (num2.charAt(idx2--) - '0'):0;
            val = val1 + val2 + next;
            sb.append(val % 10);
            next = val / 10;
        }

        return sb.reverse().toString();
    }
}

class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        } else if (num2 == null || num2.length() == 0) {
            return num1;
        }

        StringBuilder sb = new StringBuilder();
        int next = 0;
        int val = 0;
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;

        while (idx1 >= 0 && idx2 >= 0) {
            val = (num1.charAt(idx1) - '0') + (num2.charAt(idx2) - '0') + next;
            next = val / 10;
            val = val % 10;
            sb.append(val);
            idx1--;
            idx2--;
        }

        while (idx1 >= 0) {
            val = (num1.charAt(idx1) - '0') + next;
            next = val / 10;
            val = val % 10;
            sb.append(val);
            idx1--;
        }

        while (idx2 >= 0) {
            val = (num2.charAt(idx2) - '0') + next;
            next = val / 10;
            val = val % 10;
            sb.append(val);
            idx2--;
        }

        if (next == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}