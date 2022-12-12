package hu.beadando.foxandhounds;

import hu.beadando.foxandhounds.entity.Dog;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DogTests {
    @Test
    void testConstructor() {
        Dog dog = new Dog(1, 2, "Fido");

        assertEquals(1, dog.getCoordX());
        assertEquals(2, dog.getCoordY());
        assertEquals("Fido", dog.getName());
    }

    @Test
    void testSettersAndGetters() {
        Dog dog = new Dog();

        dog.setCoordX(3);
        dog.setCoordY(4);
        dog.setName("Buddy");

        assertEquals(3, dog.getCoordX());
        assertEquals(4, dog.getCoordY());
        assertEquals("Buddy", dog.getName());
    }
}
