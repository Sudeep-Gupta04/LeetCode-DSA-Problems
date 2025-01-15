
    class Solution {
    public boolean validTicTacToe(String[] board) {
        int countO = 0;
        int countX = 0;

        for (String str : board) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == 'O') {
                    countO++;
                } else if (c == 'X') {
                    countX++;
                }
            }
        }

        if (countO > countX || countX > countO + 1) {
            return false;
        }

        boolean xWins = checkWin(board, 'X');
        boolean oWins = checkWin(board, 'O');

        if (xWins && countX != countO + 1) {
            return false;
        }

        if (oWins && countX != countO) {
            return false;
        }

        if (xWins && oWins) {
            return false;
        }

        return true;
    }

    private boolean checkWin(String[] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) {
                return true;
            }
            if (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) {
                return true;
            }
        }
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) {
            return true;
        }
        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) {
            return true;
        }

        return false;
    }


}