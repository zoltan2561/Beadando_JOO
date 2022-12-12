package hu.beadando.foxandhounds;

import hu.beadando.foxandhounds.entity.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class BoardTest {

    @Test
    public void testBoardConstructor() {
        Board board = new Board();

        assertEquals(1, board.getCoordsValue(0, 5));
        assertEquals(2, board.getCoordsValue(1, 0));
        assertEquals(3, board.getCoordsValue(3, 0));
        assertEquals(4, board.getCoordsValue(5, 0));
    }

    @Test
    public void testGetCoordsValue() {
        Board board = new Board();

        assertEquals(1, board.getCoordsValue(0, 5));
        assertEquals(2, board.getCoordsValue(1, 0));
        assertEquals(3, board.getCoordsValue(3, 0));
        assertEquals(4, board.getCoordsValue(5, 0));
        assertEquals(0, board.getCoordsValue(2, 2));
    }

    @Test
    public void testSetCoordsValue() {
        Board board = new Board();

        board.setCoordsValue(2, 2, 5);
        assertEquals(5, board.getCoordsValue(2, 2));
    }

    @Test
    public void testGetGame() {
        Board board = new Board();

        assertTrue(board.getGame());
    }

    @Test
    public void testSetGame() {
        Board board = new Board();

        board.setGame(false);
        assertFalse(board.getGame());
    }

}
