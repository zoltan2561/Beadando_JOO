package hu.beadando.foxandhounds;
import hu.beadando.foxandhounds.entity.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PlayerTest {

    @Test
    public void testGetName() {
        // Given
        Player player = new Player("John", 0);

        // When
        String name = player.getName();

        // Then
        assertEquals("John", name);
    }

    @Test
    public void testSetName() {
        // Given
        Player player = new Player("John", 0);

        // When
        player.setName("Jane");

        // Then
        assertEquals("Jane", player.getName());
    }

    @Test
    public void testGetScore() {
        // Given
        Player player = new Player("John", 0);

        // When
        int score = player.getScore();

        // Then
        assertEquals(0, score);
    }

    @Test
    public void testSetScore() {
        // Given
        Player player = new Player("John", 0);

        // When
        player.setScore(10);

        // Then
        assertEquals(10, player.getScore());
    }

    @Test
    public void testGetNumWins() {
        // Given
        Player player = new Player("John", 0);
        player.setNumWins(5);

        // When
        int numWins = player.getNumWins();

        // Then
        assertEquals(5, numWins);
    }

    @Test
    public void testSetNumWins() {
        // Given
        Player player = new Player("John", 0);

        // When
        player.setNumWins(5);

        // Then
        assertEquals(5, player.getNumWins());
    }

}

