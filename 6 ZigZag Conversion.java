class Solution {
    //The idea is updating multiple lines at the same time
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;

        StringBuffer[] sb = new StringBuffer[numRows];

        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int idx = 0;
        //this is two steps, one go from top to bot
        //second step from bottom + 1 position to one step before top
        while (idx < len) {
            for (int i = 0; i < numRows && idx < len; i++, idx++) {
                sb[i].append(c[idx]);
            }
            for (int i = numRows - 2; i >= 1 && idx < len; i--, idx++) {
                sb[i].append(c[idx]);
            }
        }

        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }

        return sb[0].toString();
    }
}