package bic.slm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void testGetMarker_PositiveCase() {
        char expectedMarker = 'X';
        Player player = new Player(expectedMarker);

        assertEquals(expectedMarker, player.getMarker());
    }

    @Test
    void testGetMarker_NegativeCase() {
        char expectedMarker = 'X';
        char unexpectedMarker = 'O';
        Player player = new Player(expectedMarker);

        assertNotEquals(unexpectedMarker, player.getMarker());
    }
}
