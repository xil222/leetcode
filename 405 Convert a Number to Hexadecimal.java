class Solution {
    public String toHex(int num) {
        //from the description, it takes unsigned as input
        if (num == 0) {
            return "0";
        }
        char[] map = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String result = "";
        while (num != 0) {
            result = map[(num & 15)] + result;
            num = num >>> 4 ;
        }
        return result;
    }
}