package bic.slm;

import java.util.Scanner;

public class Game {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;

    public Game() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        while (true) {
            board.print(currentPlayer);
            int row = getPlayerMove("row (0-2): ");
            int col = getPlayerMove("column (0-2): ");

            if (board.isCellEmpty(row, col)) {
                board.place(row, col, currentPlayer.getMarker());

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
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private int getPlayerMove(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    private void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
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


