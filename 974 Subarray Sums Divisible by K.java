class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int count = 0;
        int sum = 0;

        //store Sum and number of Count
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for (int num: A) {
            sum = (sum + num % K + K) % K;
            //we can count number of occurence of remainder
            count += hashMap.getOrDefault(sum, 0);
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}