package hu.beadando.foxandhounds;

import hu.beadando.foxandhounds.entity.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testSetName() {
        Player player = new Player("Alice", 10);
        String newName = "Bob";
        player.setName(newName);
        assertEquals(newName, player.getName());
    }

    @Test
    public void testSetScore() {
        Player player = new Player("Alice", 10);
        int newScore = 15;
        player.setScore(newScore);
        assertEquals(newScore, player.getScore());
    }
}
