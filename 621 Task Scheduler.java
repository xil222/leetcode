class Solution {
    //greedy approach
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for (int i = 0; i < tasks.length ; i++) {
            count[tasks[i]-'A']++;
        }

        Arrays.sort(count);

        int maxLen = count[25] * (n + 1) - n; //use maxFreq word to separate all other words
        int num = 25;
        while (num >= 1 && count[num-1] == count[num]) {
            num--;
            maxLen++;
        }

        //have to fulfill 2 requirements, satisfy at least maxLen and longest characters
        return Math.max(tasks.length, maxLen);
    }
}