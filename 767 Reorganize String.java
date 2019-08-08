class Solution {
    class Cell {
        char letter;
        int cnt;
        public Cell(char letter, int cnt) {
            this.letter = letter;
            this.cnt = cnt;
        }
    }

    public String reorganizeString(String S) {
        if (S.length() <= 1) {
            return S;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c: S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) * 2 > S.length() + 1) {
                return "";
            }
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>(){
            @Override
            public int compare(Cell a, Cell b) {
                return b.cnt - a.cnt;
            }
        });

        //put into pq
        for (char item: map.keySet()) {
            pq.offer(new Cell(item, map.get(item)));
        }

        //generate string
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Cell tmp = pq.poll();
            int size = sb.length();
            if (size == 0 || tmp.letter != sb.charAt(size-1)) {
                sb.append(tmp.letter);
                if (tmp.cnt > 1) {
                    pq.offer(new Cell(tmp.letter, tmp.cnt -1 ));
                }
            } else {
                Cell next = pq.poll();
                sb.append(next.letter);
                if (next.cnt > 1) {
                    pq.offer(new Cell(next.letter, next.cnt - 1));
                }
                pq.offer(tmp);
            }
        }

        return sb.toString();
    }
}