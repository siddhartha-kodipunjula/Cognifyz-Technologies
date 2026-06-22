import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            resetBoard();
            displayBoard();
            boolean playing = true;
            while (playing) {
                System.out.println("Player " + currentPlayer + " turn.");
                System.out.print("Enter row (0-2): ");
                int row = scanner.nextInt();
                System.out.print("Enter column (0-2): ");
                int col = scanner.nextInt();
                if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                    System.out.println("Invalid move. Try again.");
                    continue;
                }
                board[row][col] = currentPlayer;
                displayBoard();
                if (checkWin(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    playing = false;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    playing = false;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
            System.out.print("Play again? (y/n): ");
            playAgain = scanner.next().equalsIgnoreCase("y");
        }
        scanner.close();
    }

    private static void resetBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
        currentPlayer = 'X';
    }

    private static void displayBoard() {
        System.out.println("Board: ");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + " ");
            if (i < 2) System.out.println("---+---+---");
        }
    }

    private static boolean checkWin(char p) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) return true;
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) return true;
        }
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) return true;
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) return true;
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ') return false;
        return true;
    }
}
