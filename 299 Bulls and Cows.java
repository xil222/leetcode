class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        boolean[] isBull = new boolean[secret.length()];
        Map<Character, Integer> map = new HashMap<>();
        //check all buills
        //our goal for this problem is count all bulls
        //and record all counts for each character to
        //finally count number of cows

        //can use either two data structures + 1 pass
        //or use one data structure + 2 passes
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                isBull[i] = true;
                bull++;
            } else {
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            if (isBull[i]) continue;
            char gs = guess.charAt(i);
            if (map.containsKey(gs) && map.get(gs) > 0) {
                cow++;
                map.put(gs, map.get(gs) - 1);
            }
        }
        return Integer.toString(bull) + "A" + Integer.toString(cow) + "B";
    }
}

class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] secretCnt = new int[10];
        int[] guessCnt = new int[10];

        //use one pass array
        for (int i = 0; i < secret.length(); i++) {
            char se = secret.charAt(i);
            char gu = guess.charAt(i);
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                secretCnt[(int)(se - '0')]++;
                guessCnt[(int)(gu - '0')]++;
            }
        }

        for (int i = 0; i < secretCnt.length; i++) {
            cow += Math.min(secretCnt[i], guessCnt[i]);
        }

        return Integer.toString(bull) + "A" + Integer.toString(cow) + "B";
    }
}