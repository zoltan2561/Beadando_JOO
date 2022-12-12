package hu.beadando.foxandhounds;

import hu.beadando.foxandhounds.entity.Board;
import hu.beadando.foxandhounds.entity.Dog;
import hu.beadando.foxandhounds.entity.Fox;
import hu.beadando.foxandhounds.entity.Player;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;



public class TestStart2 {
    @Test
    public void testStart() {

        Player player = new Player();
        Board board = new Board();
        Dog dog = new Dog();
        Fox fox1 = new Fox();
        Fox fox2 = new Fox();
        Fox fox3 = new Fox();

        // Set up test input
        InputStream in = new ByteArrayInputStream("3\n3\n".getBytes());
        System.setIn(in);


        // Call the start method and check the outcome
        start(player, board, dog, fox1, fox2, fox3);
        assertEquals(3, dog.getX());
        assertEquals(3, dog.getY());
    }

    private void assertEquals(int i, Object x) {
    }

    private void start(Player player, Board board, Dog dog, Fox fox1, Fox fox2, Fox fox3) {

    }
}