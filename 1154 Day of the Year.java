class Solution {
    int[] days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

    public int dayOfYear(String date) {
        String[] input = date.split("-");
        boolean oneMore = Integer.valueOf(input[0]) % 4 == 0 && Integer.valueOf(input[0]) % 100 != 0;
        int cnt = 0;
        int month = Integer.valueOf(input[1]);
        int day = Integer.valueOf(input[2]);
        for (int i = 0; i < month - 1; i++) {
            cnt += days[i];
        }
        cnt += day;
        if (oneMore && month >= 3) {
            cnt++;
        }
        return cnt;

    }
}