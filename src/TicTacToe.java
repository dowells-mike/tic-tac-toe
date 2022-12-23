// represents a tic tac toe game
class TicTacToe {
    private char[][] board; // the game board
    private char currentPlayer; // the current player (either 'X' or 'O')

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
    }

    // makes a move on the game board
    public void move(int row, int col) {
        // check if the move is valid
        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != 0) {
            // the move is invalid
            return;
        }

        // make the move
        board[row][col] = currentPlayer;

        // switch players
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    // checks if the game is over
    public boolean isOver() {
        // the game is over if there is a winner or if the board is full
        return hasWon() || isBoardFull();
    }
    // checks if there is a winner
    protected boolean hasWon() {
        // check the rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0) {
                return true;
            }
        }

        // check the columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != 0) {
                return true;
            }
        }

        // check the diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0) {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0) {
            return true;
        }

        // there is no winner
        return false;
    }
    // checks if the board is full
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // returns a string representation of the game board
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j] == 0 ? ' ' : board[i][j]);
                if (j < 2) {
                    sb.append('|');
                }
            }
            sb.append("\n");
            if (i < 2) {
                sb.append("-----\n");
            }
        }
        return sb.toString();
    }
}

