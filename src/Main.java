import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create a new tic-tac-toe game
        TicTacToe game = new TicTacToe();

        // play the game
        while (!game.isOver()) {
            // display the game board
            System.out.println(game);

            // get the next move from the player
            int row = getRowFromPlayer();
            int col = getColFromPlayer();

            // make the move
            game.move(row, col);
        }

        // display the final game board
        System.out.println(game);

        // print the game result
        if (game.hasWon()) {
            System.out.println("You won!");
        } else {
            System.out.println("It's a draw.");
        }
    }

    // gets the row of the next move from the player
    // gets the row of the next move from the player
    private static int getRowFromPlayer() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();
            if (row >= 0 && row <= 2) {
                return row;
            } else {
                System.out.println("Invalid row. Try again.");
            }
        }
    }

    // gets the column of the next move from the player
    private static int getColFromPlayer() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter column (0-2): ");
            int col = scanner.nextInt();
            if (col >= 0 && col <= 2) {
                return col;
            } else {
                System.out.println("Invalid column. Try again.");
            }
        }
    }

}

