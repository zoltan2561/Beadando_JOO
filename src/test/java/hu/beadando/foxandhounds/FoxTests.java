package hu.beadando.foxandhounds;

import static org.junit.jupiter.api.Assertions.*;

import hu.beadando.foxandhounds.entity.Fox;
import org.junit.jupiter.api.Test;

class FoxTest {

    @Test
    void testConstructor() {
        Fox fox = new Fox(1, 2, "Foxy");
        assertEquals(1, fox.getCoordX());
        assertEquals(2, fox.getCoordY());
        assertEquals("Foxy", fox.getName());
    }

    @Test
    void testSetCoordX() {
        Fox fox = new Fox(1, 2, "Foxy");
        fox.setCoordX(3);
        assertEquals(3, fox.getCoordX());
    }

    @Test
    void testSetCoordY() {
        Fox fox = new Fox(1, 2, "Foxy");
        fox.setCoordY(4);
        assertEquals(4, fox.getCoordY());
    }

    @Test
    void testSetName() {
        Fox fox = new Fox(1, 2, "Foxy");
        fox.setName("Foxinator");
        assertEquals("Foxinator", fox.getName());
    }

}
