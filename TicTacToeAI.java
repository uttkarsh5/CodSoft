import java.util.Scanner;

public class TicTacToeAI {
    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();

        while (true) {
            // Human move
            humanMove();
            printBoard();
            if (isGameOver()) break;

            // AI move
            System.out.println("AI is making a move...");
            aiMove();
            printBoard();
            if (isGameOver()) break;
        }
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    static boolean isGameOver() {
        if (hasWinner('X')) {
            System.out.println("Congratulations! You win!");
            return true;
        }
        if (hasWinner('O')) {
            System.out.println("AI wins! Better luck next time.");
            return true;
        }
        if (isBoardFull()) {
            System.out.println("It's a draw!");
            return true;
        }
        return false;
    }

    static boolean isBoardFull() {
        for (char[] row : board)
            for (char cell : row)
                if (cell == ' ')
                    return false;
        return true;
    }

    static boolean hasWinner(char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++)
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
        for (int j = 0; j < 3; j++)
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player)
                return true;
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;
        return false;
    }

    static void humanMove() {
        int row, col;
        while (true) {
            System.out.print("Enter your move (row[1-3] and column[1-3]): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            if (isValidMove(row, col)) {
                board[row][col] = 'X';
                break;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    static void aiMove() {
        int bestScore = Integer.MIN_VALUE;
        int moveRow = -1, moveCol = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                    int score = minimax(false);
                    board[i][j] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        moveRow = i;
                        moveCol = j;
                    }
                }
            }
        }

        board[moveRow][moveCol] = 'O';
    }

    static int minimax(boolean isMaximizing) {
        if (hasWinner('O')) return 1;
        if (hasWinner('X')) return -1;
        if (isBoardFull()) return 0;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (board[i][j] == ' ') {
                        board[i][j] = 'O';
                        int score = minimax(false);
                        board[i][j] = ' ';
                        bestScore = Math.max(score, bestScore);
                    }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (board[i][j] == ' ') {
                        board[i][j] = 'X';
                        int score = minimax(true);
                        board[i][j] = ' ';
                        bestScore = Math.min(score, bestScore);
                    }
            return bestScore;
        }
    }

    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }
}