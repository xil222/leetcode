class Solution {
    private final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    //Roman expression from large to small
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (num > 0) {
            while (num >= values[idx]) {
                num -= values[idx];
                sb.append(strs[idx]);
            }
            idx++;
        }
        return sb.toString();
    }
}