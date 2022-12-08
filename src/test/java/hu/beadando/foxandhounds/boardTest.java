import static org.junit.jupiter.api.Assertions.*;

import hu.beadando.foxandhounds.entity.Board;
import org.junit.jupiter.api.Test;

class BoardTest {

    @Test
    void testConstructor() {
        Board board = new Board();
        assertEquals(1, board.getCoordsValue(0, 5));
        assertEquals(2, board.getCoordsValue(1, 0));
        assertEquals(3, board.getCoordsValue(3, 0));
        assertEquals(4, board.getCoordsValue(5, 0));
        assertEquals(0, board.getCoordsValue(0, 0));
        assertEquals(true, board.getGame());
    }

    @Test
    void testSetCoordsValue() {
        Board board = new Board();
        board.setCoordsValue(0, 0, 1);
        assertEquals(1, board.getCoordsValue(0, 0));
    }

    @Test
    void testSetGame() {
        Board board = new Board();
        board.setGame(false);
        assertEquals(false, board.getGame());
    }

}
