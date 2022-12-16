package hu.beadando.foxandhounds;

import hu.beadando.foxandhounds.entity.CoordConverter;
import org.junit.jupiter.api.Test;

import static hu.beadando.foxandhounds.entity.CoordConverter.coordXValidChecker;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoordConverterTest {


    @Test
    public void testConvertXCoord_withOneCharacterInput_returnsExpectedOutput() {
        // arrange
        String coordXText = "A";

        // act
        int result = CoordConverter.convertXCoord(coordXText);

        // assert
        assertEquals(0, result);
    }

    @Test
    public void testConvertXCoord_withLongerInput_returnsErrorValue() {
        // arrange
        String coordXText = "AB";

        // act
        int result = CoordConverter.convertXCoord(coordXText);

        // assert
        assertEquals(-2, result);
    }


    @Test
    public void testCharConvertToNumber_withValidInput_returnsExpectedOutput() {
        // arrange
        String coordXTextSubbedString = "C";

        // act
        int result = CoordConverter.charConvertToNumber(coordXTextSubbedString);

        // assert
        assertEquals(2, result);
    }

    @Test
    public void testCharConvertToNumber_withInvalidInput_returnsErrorValue() {
        // arrange
        String coordXTextSubbedString = "G";

        // act
        int result = CoordConverter.charConvertToNumber(coordXTextSubbedString);

        // assert
        assertEquals(-1, result);
    }

    @Test
    public void testNumberConvertToChar_withValidInput_returnsExpectedOutput() {
        // arrange
        int x = 2;

        // act
        String result = CoordConverter.numberConvertToChar(x);

        // assert
        assertEquals("C", result);
    }

    @Test
    public void testNumberConvertToChar_withInvalidInput_returnsErrorValue() {
        // arrange
        int x = -1;

        // act
        String result = CoordConverter.numberConvertToChar(x);

        // assert
        assertEquals("error", result);
    }
    @Test
    void testCoordXValidChecker() {
        // Test x = -1
        assertTrue(coordXValidChecker(-1));

        // Test x = -2
        assertTrue(coordXValidChecker(-2));

        // Test x = -3
        assertTrue(coordXValidChecker(-3));

        // Test x = 0
        assertFalse(coordXValidChecker(0));

        // Test x = 6
        assertTrue(coordXValidChecker(6));
    }
}
