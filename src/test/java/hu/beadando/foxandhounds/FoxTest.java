package hu.beadando.foxandhounds;

import hu.beadando.foxandhounds.entity.Fox;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FoxTest {

    @Test
    void testFoxConstructor_withName() {
        int coordX = 1;
        int coordY = 2;
        String name = "Foxy";
        Fox fox = new Fox(coordX, coordY, name);
        assertEquals(coordX, fox.getCoordX());
        assertEquals(coordY, fox.getCoordY());
        assertEquals(name, fox.getName());
    }

//    @Test
//    void testFoxConstructor_withoutName() {
//        int coordX = 3;
//        int coordY = 4;
//        Fox fox = new Fox(coordX, coordY);
//        assertEquals(coordX, fox.getCoordX());
//        assertEquals(coordY, fox.getCoordY());
//        assertNull(fox.getName());
//    }

    @Test
    void testFoxConstructor_default() {
        Fox fox = new Fox();
        assertEquals(0, fox.getCoordX());
        assertEquals(0, fox.getCoordY());
        assertNull(fox.getName());
    }

    @Test
    void testSetCoordX() {
        int coordX = 5;
        Fox fox = new Fox();
        fox.setCoordX(coordX);
        assertEquals(coordX, fox.getCoordX());
    }

    @Test
    void testSetCoordY() {
        int coordY = 6;
        Fox fox = new Fox();
        fox.setCoordY(coordY);
        assertEquals(coordY, fox.getCoordY());
    }

    @Test
    public void testConstructor() {
        Fox fox = new Fox(1, 2, "Fido");
        assertEquals(1, fox.getCoordX());
        assertEquals(2, fox.getCoordY());
    }
}
