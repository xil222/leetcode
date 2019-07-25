class Solution {
    public boolean validTicTacToe(String[] board) {
        //there are many conditions for verification
        //number of 'X' equal or 1 more than number of 'O'
        //two sides can't both win
        //when X win diff is 1
        //when O win diff is 0

        int[] row = new int[board.length];
        int[] col = new int[board.length];
        int len = board.length;
        int diag = 0;
        int anti = 0;
        int diff = 0;

        boolean Xwin = false;
        boolean Owin = false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'X') {
                    diff++;
                    row[i]++;
                    col[j]++;
                    if (i == j) diag++;
                    if (i + j == board.length - 1) anti++;

                    if (row[i] == len || col[j] == len || diag == len || anti == len)
                        Xwin = true;

                } else if (board[i].charAt(j) == 'O') {
                    diff--;
                    row[i]--;
                    col[j]--;
                    if (i == j) diag--;
                    if (i + j == board.length - 1) anti--;

                    if (row[i] == -len || col[j] == -len || diag == -len || anti == -len)
                        Owin = true;

                }
            }
        }

        //check number
        if (diff > 1 || diff < 0) return false;

        //this condition includes the possibility of Owin && Xwin b/c here diff can only be 0 or 1
        if (diff == 1 && Owin || diff == 0 && Xwin) {
            return false;
        }

        return true;
    }
}