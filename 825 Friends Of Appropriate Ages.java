class Solution {
    //O(120^2) --> O(n)
    public int numFriendRequests(int[] ages) {

        //bucket sort
        int[] age_bucket = new int[121];
        int count = 0;
        for (int person: ages) {
            age_bucket[person]++;
        }

        //condition 3 included in condition 2 age[A] >= age[B]
        //think about same age or not
        for (int i = 1; i <= 120; i++) { //i --> B
            for (int j = i; j <= 120; j++) { //j --> A
                if (i > 0.5 * j + 7) {
                    if (i == j) {
                        count += age_bucket[j] * (age_bucket[j]-1);
                    } else {
                        count += age_bucket[i] * age_bucket[j];
                    }
                }
            }
        }

        return count;
    }
}