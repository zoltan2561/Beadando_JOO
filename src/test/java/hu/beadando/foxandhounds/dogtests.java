import static org.junit.jupiter.api.Assertions.*;

import hu.beadando.foxandhounds.entity.Dog;
import org.junit.jupiter.api.Test;

class DogTest {

    @Test
    void testConstructor() {
        Dog dog = new Dog(1, 2, "Fido");
        assertEquals(1, dog.getCoordX());
        assertEquals(2, dog.getCoordY());
        assertEquals("Fido", dog.getName());
    }

    @Test
    void testSetCoordX() {
        Dog dog = new Dog(0, 0, "Fido");
        dog.setCoordX(5);
        assertEquals(5, dog.getCoordX());
    }

    @Test
    void testSetCoordY() {
        Dog dog = new Dog(0, 0, "Fido");
        dog.setCoordY(7);
        assertEquals(7, dog.getCoordY());
    }

    @Test
    void testSetName() {
        Dog dog = new Dog(0, 0, "Fido");
        dog.setName("Max");
        assertEquals("Max", dog.getName());
    }

}
