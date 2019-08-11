class Solution {
    //Since the goal is to implement is O(n) time
    //so dp cumulative way to realize that
    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        //using dp,
        //count[i] = count[i/2] + i & 1(last bit)
        for (int i = 1; i <= num; i++) {
            count[i] = count[i / 2] + (i & 1);
        }
        return count;
    }
}