import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void printBoard(String[][] board) {
        for (int i = 0; i < 3; i++) {
            System.out.println(String.join(" | ", board[i]));
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public static boolean checkWinner(String[][] board, String player) {
        for (int i = 0; i < 3; i++) {

            // checking row
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }

            // checking col
            for (int j = 0; j < 3; j++) {
                if (board[0][j].equals(player) && board[1][j].equals(player) && board[2][j].equals(player)) {
                    return true;
                }
            }

            // checking digonals
            if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
                return true;
            }
            if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
                return true;
            }
        }
        return false;
    }

    // Checking borad is full or not
    public static boolean isFull(String[][] board) {
        for (String[] row : board) {
            for (String cells : row) {
                if (cells.equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    // Computer Move
    public static int[] comMove(String[][] board) {
        System.out.println("\nComputer's turn (Player O) ");
        Random rand = new Random();
        List<int[]> emptyCells = new ArrayList<>();

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c].equals(" ")) {
                    emptyCells.add(new int[] { r, c });
                }
            }
        }
        return emptyCells.get(rand.nextInt(emptyCells.size()));

    }

    public static void playGame() {
        Scanner sc = new Scanner(System.in);
        String[][] board = new String[3][3];

        // Initialize board
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], " ");
        }

        System.out.println("Welcome to Tic Tac Toe! (You = X, Computer = O)");
        printBoard(board);

        while (true) {
            // Human move
            System.out.println("\nYour turn (Player X).");
            while (true) {
                try {
                    System.out.print("Enter row (0-2): ");
                    int row = sc.nextInt();
                    System.out.print("Enter col (0-2): ");
                    int col = sc.nextInt();

                    if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                        if (board[row][col].equals(" ")) {
                            board[row][col] = "X";
                            break;
                        } else {
                            System.out.println("Cell already taken, try again.");
                        }
                    } else {
                        System.out.println("Invalid input, try again (row and col between 0–2).");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, please enter numbers only.");
                    sc.next(); // clear invalid input
                }
            }

            printBoard(board);

            // Check if human won
            if (checkWinner(board, "X")) {
                System.out.println("\n You win!");
                break;
            }
            if (isFull(board)) {
                System.out.println("\nIt's a tie!");
                break;
            }

            // Computer move
            System.out.println("\nComputer's turn (Player O)...");
            int[] move = comMove(board);
            board[move[0]][move[1]] = "O";
            printBoard(board);

            // Check if computer won
            if (checkWinner(board, "O")) {
                System.out.println("\nComputer wins!");
                break;
            }
            if (isFull(board)) {
                System.out.println("\nIt's a tie!");
                break;
            }
        }

        sc.close();
    }

    public static void main(String[] args) {

        playGame();

    }
}


