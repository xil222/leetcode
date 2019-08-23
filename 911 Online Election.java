class TopVotedCandidate {

    //use a hashMap
    //key: personId, val: count
    Map<Integer, Integer> map = new HashMap<>();
    int[] maxVals;
    int[] timeArray;
    int maxCnt = 0;
    int maxVal = Integer.MIN_VALUE;

    public TopVotedCandidate(int[] persons, int[] times) {
        maxVals = new int[persons.length];
        timeArray = times;
        for (int i = 0; i < persons.length; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            if (map.get(persons[i]) >= maxCnt) {
                maxVal = persons[i];
                maxCnt = map.get(persons[i]);
            }
            maxVals[i] = maxVal;
        }
    }

    //Arrays.binarySearch will return idx if found,
    //and (-i - 1) where idx represents insertion place
    //of first index i greater than it
    //so -idx - 1 fetch the first greater,
    // -idx - 2 fetch the first smaller
    public int q(int t) {
        int idx = Arrays.binarySearch(timeArray, t);
        return idx < 0? maxVals[-idx -2]: maxVals[idx];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */