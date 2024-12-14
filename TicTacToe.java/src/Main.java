import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        char currentPlayer = 'X';
        boolean gameOn = true;

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Player X goes first.");

        while (gameOn) {
            displayBoard(board);
            playerMove(board, currentPlayer);

            if (checkWinner(board, currentPlayer)) {
                displayBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                gameOn = false;
            } else if (isBoardFull(board)) {
                displayBoard(board);
                System.out.println("It's a draw!");
                gameOn = false;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch player
            }
        }

        System.out.println("Game Over. Thanks for playing!");
    }

    public static void displayBoard(char[][] board) {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println();
    }

    public static void playerMove(char[][] board, char player) {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        while (true) {
            System.out.println("Player " + player + ", enter your move (row and column, 1-3): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = player;
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public static boolean checkWinner(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || // Row
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) { // Column
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) || // Main diagonal
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) { // Opposite diagonal
            return true;
        }

        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
