class Solution {
    //for this kind of problems, by patient be careful
    //there is lots of small base cases
    public int divide(int dividend, int divisor) {
        //most important thing to care is the Integer range is [-2^(31) ~ 2^(31)-1]
        if (dividend == 0) {
            return 0;
        } else if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            return dividend == Integer.MIN_VALUE? Integer.MAX_VALUE: -dividend;
        }

        boolean isNeg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        long p_dividend = Math.abs((long)dividend);
        long p_divisor = Math.abs((long)divisor);

        long res = isNeg ? -p_dividend / p_divisor : p_dividend / p_divisor;
        int i_res = res < Integer.MIN_VALUE || res > Integer.MAX_VALUE? Integer.MAX_VALUE: (int)res;

        return i_res;
    }
}