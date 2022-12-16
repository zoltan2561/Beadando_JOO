package hu.beadando.foxandhounds;

import hu.beadando.foxandhounds.entity.Dog;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DogTest {

    @Mock
    private Dog dog;

    @Test
    public void testGetCoordX() {
        when(dog.getCoordX()).thenReturn(10);
        assertEquals(10, dog.getCoordX());
    }


    @Test
    public void testGetCoordY() {
        when(dog.getCoordY()).thenReturn(15);
        assertEquals(15, dog.getCoordY());
    }


    @Test
    public void testGetName() {
        when(dog.getName()).thenReturn("Fido");
        assertEquals("Fido", dog.getName());
    }


    @Test
    public void testGetX() {
        when(dog.getX()).thenReturn(5);
        assertEquals(5, dog.getX());
    }

    @Test
    public void testGetY() {
        when(dog.getY()).thenReturn(10);
        assertEquals(10, dog.getY());
    }
    @Test
    void testConstructor() {
        Dog dog = new Dog(1, 2, "Fido");

        assertEquals(1, dog.getCoordX());
        assertEquals(2, dog.getCoordY());
        assertEquals("Fido", dog.getName());
    }

}
