package hu.beadando.foxandhounds;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import hu.beadando.foxandhounds.entity.Fox;
import hu.beadando.foxandhounds.service.GameServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameServiceImplTest {

    private GameServiceImpl gameService;

    @BeforeEach
    public void setUp() {
        gameService = new GameServiceImpl();
    }

    @Test
    public void testGetPlayerName() {
        // Given
        String playerName = "player1";
        String input = playerName + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        gameService.input = new Scanner(System.in);

        // When
        String result = gameService.getPlayerName();

        // Then
        assertEquals(playerName, result);
    }

    @Test
    public void testCoordDogYReader() {
        // Given
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        gameService.input = new Scanner(System.in);

        // When
        int result = gameService.coordDogYReader();

        // Then
        assertEquals(1, result);
    }

    @Test
    public void testCoordDogXReader() {
        // Given
        String input = "d\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        gameService.input = new Scanner(System.in);

        // When
        int result = gameService.coordDogXReader();

        // Then
        assertEquals(3, result);
    }

    @Test
    public void testCoordFoxXGenerator() {
        // Given
        Fox fox = new Fox(1, 0, "Roka_1");

        // When
        int result = gameService.coordFoxXGenerator(fox);

        // Then
        assertTrue(result == 0 || result == 2);
    }

    @Test
    public void testCoordFoxYGenerator() {
        // Given
        Fox fox = new Fox(1, 0, "Roka_1");

        // When
        int result = gameService.coordFoxYGenerator(fox);

        // Then
        assertTrue(result == -1 || result == 1);
    }
}
