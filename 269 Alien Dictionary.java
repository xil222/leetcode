//use bfs to store the children of each character 75.6% time 99.9% space.
class Solution {
    public String alienOrder(String[] words) {

        //record a set of characters map current character mapping to
        Map<Character, Set<Character>> map = new HashMap<>();
        String result = "";

        //record how many different char map to this char,
        //the character with val = 0, should be the start point
        Map<Character, Integer> degree = new HashMap<>();

        if (words == null || words.length == 0) return null;

        for (String s: words) {
            for (char c: s.toCharArray()) {
                degree.put(c, 0);
            }
        }

        //setup the graph connection between characters
        for (int i = 0; i < words.length - 1; i++) {
            for (int idx = 0; idx < Math.min(words[i].length(), words[i+1].length()); idx++) {
                char c1 = words[i].charAt(idx);
                char c2 = words[i+1].charAt(idx);

                if (c1 != c2) {
                    if (!map.containsKey(c1))
                        map.put(c1, new HashSet<Character>());
                    Set<Character> set = map.get(c1);
                    if (set.add(c2)) {
                        degree.put(c2, degree.get(c2)+1);
                        map.put(c1, set);
                    }
                    break;
                }
            }
        }

        //then start the bfs search
        Queue<Character> queue = new LinkedList<>();
        for (char c: degree.keySet()) {
            if (degree.get(c) == 0) {
                queue.add(c);
            }
        }

        //idea is stack all characters with degree 0 back to queue
        while (!queue.isEmpty()) {
            char tmp = queue.poll();
            result += tmp;
            if (map.containsKey(tmp)) {
                for (char sample: map.get(tmp)) {
                    degree.put(sample, degree.get(sample) - 1);
                    if (degree.get(sample) == 0) {
                        queue.offer(sample);
                    }
                }
            }
        }

        //if there is circle, some of the characters will have a higher degree, this will
        //lead to the final generated length shorter hashMap size
        return result.length() == degree.size()? result: "";
    }
}