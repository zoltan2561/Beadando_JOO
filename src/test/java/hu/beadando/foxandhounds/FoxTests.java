package hu.beadando.foxandhounds;

import hu.beadando.foxandhounds.entity.Fox;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class FoxTests {
    @Test
     public void testConstructor() {
        Fox fox = new Fox(1, 2, "Fido");
        assertEquals(1, fox.getCoordX());
        assertEquals(2, fox.getCoordY());
    }

    @Test
  public void testSettersAndGetters() {
        Fox fox = new Fox();

        fox.setCoordX(3);
        fox.setCoordY(4);

        assertEquals(3, fox.getCoordX());
        assertEquals(4, fox.getCoordY());
    }
}
