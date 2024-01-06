package bic.slm;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class Game {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;
    private final Random random;
    private boolean againstComputer;

    public Game() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
        random = new Random();
        againstComputer = false;
    }

    public void start() {
        while (true) {
            System.out.println("Do you want to play against the computer? (Yes/No)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("yes") || response.equals("y")) {
                againstComputer = true;
            }

            playGame();

            System.out.println("Do you want to play again? (Yes/No)");
            response = scanner.nextLine().trim().toLowerCase();

            if (!(response.equals("yes") || response.equals("y"))) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }

    private void playGame() {
        board.clear(); // Clear the board for a new game
        currentPlayer = player1;

        while (true) {
            board.print(currentPlayer);

            if (currentPlayer == player1 || !againstComputer) {
                int row = getPlayerMove("row (0-2): ");
                int col = getPlayerMove("column (0-2): ");
                makeMove(row, col);
            } else {
                makeComputerMove();
            }

            if (hasWinner()) {
                board.print(currentPlayer);
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                break;
            } else if (board.isFull()) {
                board.print(currentPlayer);
                System.out.println("It's a draw!");
                break;
            }

            switchCurrentPlayer();
        }
    }

    private void makeMove(int row, int col) {
        if (board.isCellEmpty(row, col)) {
            board.place(row, col, currentPlayer.getMarker());
        } else {
            System.out.println("Invalid move. Try again.");
            makeMove(getPlayerMove("row (0-2): "), getPlayerMove("column (0-2): "));
        }
    }

    private void makeComputerMove() {
        System.out.println("Computer's turn:");
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!board.isCellEmpty(row, col));

        board.place(row, col, currentPlayer.getMarker());
    }

    private int getPlayerMove(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int move;

        while (true) {
            try {
                System.out.print(prompt);
                move = scanner.nextInt();

                if (move >= 0 && move <= 2) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 0 and 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        return move;
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean hasWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        return (c1 != ' ') && (c1 == c2) && (c2 == c3);
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board.cells[i][0], board.cells[i][1], board.cells[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board.cells[0][i], board.cells[1][i], board.cells[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return (checkRowCol(board.cells[0][0], board.cells[1][1], board.cells[2][2]) ||
                checkRowCol(board.cells[0][2], board.cells[1][1], board.cells[2][0]));
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}