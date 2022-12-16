package hu.beadando.foxandhounds;

import hu.beadando.foxandhounds.entity.Board;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BoardTest {

    @Test
    public void testGetCoordsValue() {
        // Given
        Board board = new Board();
        int x = 0;
        int y = 0;
        int expected = 0;

        // When
        int actual = board.getCoordsValue(x, y);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void testSetCoordsValue() {
        // Given
        Board board = new Board();
        int x = 0;
        int y = 0;
        int value = 5;
        int expected = 5;

        // When
        board.setCoordsValue(x, y, value);
        int actual = board.getCoordsValue(x, y);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void testGetGame() {
        // Given
        Board board = new Board();
        boolean expected = true;

        // When
        boolean actual = board.getGame();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void testSetGame() {
        // Given
        Board board = new Board();
        boolean game = false;
        boolean expected = false;

        // When
        board.setGame(game);
        boolean actual = board.getGame();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void testGetWinner() {
        // Given
        Board board = spy(Board.class);
        String expected = "A rokák győztek";
        doReturn(expected).when(board).getWinner();

        // When
        String actual = board.getWinner();

        // Then
        verify(board).getWinner();
        assertEquals(expected, actual);
    }
    @Test
    public void testBoardConstructor() {
        Board board = new Board();

        assertEquals(1, board.getCoordsValue(0, 5));
        assertEquals(2, board.getCoordsValue(1, 0));
        assertEquals(3, board.getCoordsValue(3, 0));
        assertEquals(4, board.getCoordsValue(5, 0));
    }

    @Test
    void testSetDefaultCoords() {
        Board board = new Board();
        board.setDefaultCoords();

        assertEquals(0, board.getCoordsValue(0, 0));
        assertEquals(2, board.getCoordsValue(1, 0));
        assertEquals(0, board.getCoordsValue(2, 0));
        assertEquals(3, board.getCoordsValue(3, 0));
        assertEquals(0, board.getCoordsValue(4, 0));
        assertEquals(4, board.getCoordsValue(5, 0));
        assertEquals(0, board.getCoordsValue(0, 1));
        assertEquals(0, board.getCoordsValue(1, 1));
        // ... stb
    }


    @Test
    void testPrinter() {
        Board board = new Board();

        // Capture the output of the printer method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        board.printer();
        String expectedOutput = "\033[1;35mA   B   C   D   E   F   \033[0m\n" +
                "_____________________\n" +
                "\n" +
                "\n" +
                "\033[1;37m0   0   0   0   0   \033[1;31m1\033[0m   \033[0m  |1\n" +
                "\033[1;32m2\033[0m   0   0   0   0   0   \033[0m  |2\n" +
                "0   0   0   0   0   0   \033[0m  |3\n" +
                "0   0   \033[1;33m3\033[0m   0   0   0   \033[0m  |4\n" +
                "0   0   0   0   0   0   \033[0m  |5\n" +
                "0   0   0   0   0   0   \033[0m  |6\n" +
                "\n" +
                "\n";
       // assertEquals(expectedOutput, outContent.toString());
    }
}




