//O(n) space, O(1) time
class TicTacToe {

    int dig;
    int anti;
    int[] rows;
    int[] cols;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        dig = 0;
        anti = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int play = player == 1? 1: -1;
        rows[row] += play;
        cols[col] += play;

        int len = rows.length;
        if (row == col) dig += play;
        if (row + col == len - 1) anti += play;

        if (Math.abs(anti) == len || Math.abs(dig) == len ||
                Math.abs(rows[row]) == len || Math.abs(cols[col]) == len) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */