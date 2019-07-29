class Solution {
    class Cell {
        int row;
        int col;
        public Cell (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[] dirX = new int[]{-1, 0, 0, 1};
    int[] dirY = new int[]{0, -1, 1, 0};

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        Queue<Cell> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];

        //append starting pos
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Cell(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int distance = 1;
        //use bfs to update
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Cell tmp = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newR = tmp.row + dirX[j];
                    int newC = tmp.col + dirY[j];
                    if (isValid(visited, rooms, newR, newC)) {
                        rooms[newR][newC] = Math.min(rooms[newR][newC], distance);
                        queue.offer(new Cell(newR, newC));
                        visited[newR][newC] = true;
                    }
                }
            }
            distance++;
        }

    }

    //condition for putting a cell into can update only if smaller than that val
    private boolean isValid(boolean[][] visited, int[][] rooms, int row, int col) {
        //out of bound
        if (row < 0 || col < 0 || row >= rooms.length || col >= rooms[0].length){
            return false;
        }

        //condition check
        if (rooms[row][col] <= 0 || visited[row][col]) {
            return false;
        }
        return true;
    }
}