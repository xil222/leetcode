class Solution {
    public int repeatedStringMatch(String A, String B) {

        //A has length m
        //B has length n
        //A has k replicates
        //best case: n = mk
        //worst case: n = (k - 1) * m + 1 + x(need another A)
        //so when iterating to k which mk >= n but m(k-1) < n
        //append one more

        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if(sb.toString().contains(B)) return count;

        if(sb.append(A).toString().contains(B)) return ++count;
        return -1;
    }
}