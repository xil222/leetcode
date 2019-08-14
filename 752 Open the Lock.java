class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            set.add(deadends[i]);
        }

        if (set.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String tmp = queue.poll();
                if (tmp.equals(target)) {
                    return count;
                }
                StringBuilder sb = new StringBuilder(tmp);
                for (int j = 0; j < 4; j++) {
                    char c = sb.charAt(j);
                    //we need to add condition of turning '0' to '9' and turning '9' to '0'
                    String newtmp1 = sb.substring(0, j) + (c == '0'? 9: c - '0' - 1) + sb.substring(j+1);
                    String newtmp2 = sb.substring(0, j) + (c == '9'? 0: c - '0' + 1) + sb.substring(j+1);
                    if (!set.contains(newtmp1) && !visited.contains(newtmp1)) {
                        visited.add(newtmp1);
                        queue.offer(newtmp1);
                    }

                    if (!set.contains(newtmp2) && !visited.contains(newtmp2)) {
                        visited.add(newtmp2);
                        queue.offer(newtmp2);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}