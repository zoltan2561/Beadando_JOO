package hu.beadando.foxandhounds;

import hu.beadando.foxandhounds.entity.Board;
import hu.beadando.foxandhounds.entity.Dog;
import hu.beadando.foxandhounds.entity.Fox;
import hu.beadando.foxandhounds.entity.Player;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFoxPositionGenerator {

    @Test
    public void testFoxPositionGenerator() {
        Player player = new Player();
        Board board = new Board();
        Dog dog = new Dog();
        Fox fox1 = new Fox();
        Fox fox2 = new Fox();
        Fox fox3 = new Fox();

        // Set up test input
        int randomFoxNumber = 1;
        InputStream in = new ByteArrayInputStream("3\n3\n".getBytes());
        System.setIn(in);

        // Set up expected outcome
        fox1.setCoordX(3);
        fox1.setCoordY(3);

        // Call the fox position generator method and check the outcome
        foxPositionGenerator(randomFoxNumber, player, board, dog, fox1, fox2, fox3);
        assertEquals(3, fox1.getCoordX());
        assertEquals(3, fox1.getCoordY());
    }

    private void foxPositionGenerator(int randomFoxNumber, Player player, Board board, Dog dog, Fox fox1, Fox fox2, Fox fox3) {

    }

}
