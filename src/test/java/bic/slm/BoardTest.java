package bic.slm;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void testClear() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.clear();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', board.cells[i][j]);
            }
        }
    }

    @Test
    void testIsCellEmpty_PositiveCase() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void testIsCellEmpty_NegativeCase() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(1, 1));
    }

    @Test
    void testPlace() {
        Board board = new Board();
        board.place(2, 2, 'O');
        assertEquals('O', board.cells[2][2]);
    }

    @Test
    void testIsFull_PositiveCase() {
        Board board = new Board();
        // Fill the board and check if it is full
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        board.place(1, 0, 'O');
        board.place(1, 1, 'X');
        board.place(1, 2, 'O');
        board.place(2, 0, 'X');
        board.place(2, 1, 'O');
        board.place(2, 2, 'X');

        assertTrue(board.isFull());
    }

    @Test
    void testIsFull_NegativeCase() {
        Board board = new Board();
        assertFalse(board.isFull());
    }

    @Test
    void testPrint() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        board.place(1, 0, 'O');
        board.place(1, 1, 'X');
        board.place(1, 2, 'O');
        board.place(2, 0, 'X');
        board.place(2, 1, 'O');
        board.place(2, 2, 'X');
        board.print(new Player('X'));
    }
}
