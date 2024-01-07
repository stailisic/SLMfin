package bic.slm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;


public class GameTest {

    @Test
    void testMakeMove_ValidMove() {
        Game game = new Game();
        game.board.clear();

        game.makeMove(0, 0);
        assertEquals('X', game.board.cells[0][0]);
    }

    @Test
    void testMakeMove_InvalidMove() {
        Game game = new Game();
        game.board.clear();

        // Make a valid move with player1
        game.makeMove(0, 0); // Player1 makes a move
        char player1Marker = game.currentPlayer.getMarker();
        assertEquals(player1Marker, game.board.cells[0][0]);

        // Switch to player2 and attempt an invalid move in the same cell
        game.switchCurrentPlayer();
        char player2Marker = game.currentPlayer.getMarker();
        if (player1Marker != player2Marker) {
            game.makeMove(0, 0); // Player2 attempts an invalid move
        }

        // Assert the cell remains unchanged (still contains player1's marker)
        assertEquals(player1Marker, game.board.cells[0][0], "Cell should not change after an invalid move");
    }











    @Test
    void testMakeComputerMove() {
        Game game = new Game();
        game.againstComputer = true;
        game.board.clear();

        // Make the computer move
        game.makeComputerMove();

        // Check if any cell contains the computer's marker
        char marker = game.currentPlayer.getMarker();
        boolean moveMade = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.board.cells[i][j] == marker) {
                    moveMade = true;
                    break;
                }
            }
            if (moveMade) {
                break;
            }
        }

        assertTrue(moveMade, "The computer should make a move");
    }



    @Test
    void testHasWinner_PositiveCase() {
        Game game = new Game();
        game.board.clear();

        game.makeMove(0, 0);
        game.makeMove(0, 1);
        game.makeMove(0, 2);
        assertTrue(game.hasWinner());
    }

    @Test
    void testHasWinner_NegativeCase() {
        Game game = new Game();
        game.board.clear();

        game.makeMove(0, 0);
        game.makeMove(1, 1);
        assertFalse(game.hasWinner());
    }
}
