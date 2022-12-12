package hu.beadando.foxandhounds;

import hu.beadando.foxandhounds.entity.Fox;
import hu.beadando.foxandhounds.service.GameServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameServiceImplTest {

    private GameServiceImpl gameService;

    @BeforeEach
    public void setUp() {
        gameService = new GameServiceImpl();
    }
    public void testGetPlayerName() {
        // Mocking the Scanner object
        Scanner mockScanner = Mockito.mock(Scanner.class);
        // Providing a pre-defined input value
        Mockito.when(mockScanner.nextLine()).thenReturn("Player1");

        GameServiceImpl gameService = new GameServiceImpl();
        // Injecting the mocked Scanner object
        gameService.input = mockScanner;

        String playerName = gameService.getPlayerName();
        assertNotNull(playerName);
        assertEquals("Player1", playerName);
    }

    @Test
    public void testCoordFoxYGenerator() {
        GameServiceImpl gameService = new GameServiceImpl();
        Fox fox = new Fox(0, 0, "Roka_1");
        int coordY = gameService.coordFoxYGenerator(fox);
        assertTrue(coordY >= 0 && coordY <= 5);
        assertNotEquals(coordY, fox.getCoordY());
    }

    @Test
    public void testCoordFoxXGenerator_shouldReturnValidCoordX() {
        Fox fox = mock(Fox.class);
        when(fox.getCoordX()).thenReturn(1);

        int coordX = gameService.coordFoxXGenerator(fox);

        assertTrue(coordX >= 0 && coordX <= 5 && coordX != 1);
    }

}
