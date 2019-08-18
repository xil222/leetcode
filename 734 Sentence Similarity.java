//at the begining of this problem, needs to confirm with interviewer
//how many words each word map to
class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            String s1 = pairs.get(i).get(0);
            String s2 = pairs.get(i).get(1);
            if (!map.containsKey(s1)) {
                map.put(s1, new HashSet<String>());
            }
            map.get(s1).add(s2);

            if (!map.containsKey(s2)) {
                map.put(s2, new HashSet<String>());
            }
            map.get(s2).add(s1);
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            } else if (map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i])) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}