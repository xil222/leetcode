//naive: iterate through every pos, double loop, to find the first swap make the number greater
//first loop iterate each digit, second O(n^2) time complexity
//beat 31.82%, memory 5%
class Solution {
    public int maximumSwap(int num) {
        int maxVal = num;

        StringBuilder item = new StringBuilder(Integer.toString(num));
        for (int i = 0; i < item.length(); i++) {
            for (int j = i + 1; j < item.length(); j++) {
                if (item.charAt(j) > item.charAt(i)) {
                    swap(item, i, j);
                    maxVal = Math.max(maxVal, Integer.valueOf(item.toString()));
                    swap(item, i, j);
                }
            }
        }
        return maxVal;
    }

    private void swap(StringBuilder item, int a, int b) {
        char temp = item.charAt(a);
        item.setCharAt(a, item.charAt(b));
        item.setCharAt(b, temp);
    }
}

//method 2, store the last occurence of digits, O(n) time complexity or say O(10n) in worst case
//beat 100% speed, memory 5%
class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] lastOcc = new int[10];
        for (int i = 0; i < digits.length; i++) {
            lastOcc[digits[i]-'0'] = i;
        }

        //take care of digits[lastOcc[j]]
        for (int i = 0; i < digits.length; i++) {
            for (int j = 9; j > digits[i] - '0'; j--) {
                if (lastOcc[j] > i) {
                    char temp = digits[i];
                    digits[i] = digits[lastOcc[j]];
                    digits[lastOcc[j]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }
}