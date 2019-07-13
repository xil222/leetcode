class Solution {
    private final String[] twenties = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num);
    }

    private String helper(int num) {
        //the technique here actually the smaller part is the base case
        String result = new String();
        if (num < 20) {
            result = twenties[num];
        } else if (num < 100) {
            result = TENS[num / 10] + " " + helper(num % 10);
        } else if (num < 1000) {
            result = helper(num / 100) + " Hundred " + helper(num % 100);
        } else if (num < 1000000) {
            result = helper(num / 1000) + " Thousand " + helper(num % 1000);
        } else if (num < 1000000000){
            result = helper(num / 1000000) + " Million " + helper(num % 1000000);
        } else {
            result = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        }

        //use to trim() the last 0 if last digit is 0
        return result.trim();
    }
}