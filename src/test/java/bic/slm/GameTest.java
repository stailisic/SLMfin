package bic.slm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

        game.makeMove(1, 1);
        game.makeMove(1, 1); // Same move again

        assertEquals(' ', game.board.cells[1][1]);
        game.makeMove(1, 2);
        assertEquals('X', game.board.cells[1][2]);
    }

    @Test
    void testMakeComputerMove() {
        Game game = new Game();
        game.againstComputer = true;
        game.board.clear();

        game.makeComputerMove();
        char marker = game.currentPlayer.getMarker();
        boolean validMove = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.board.cells[i][j] == marker) {
                    validMove = true;
                    break;
                }
            }
            if (validMove) {
                break;
            }
        }
        assertTrue(validMove);
    }

    @Test
    void testSwitchCurrentPlayer() {
        Game game = new Game();
        game.currentPlayer = game.player1;

        game.switchCurrentPlayer();
        assertEquals(game.player2, game.currentPlayer);

        game.switchCurrentPlayer();
        assertEquals(game.player1, game.currentPlayer);
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
