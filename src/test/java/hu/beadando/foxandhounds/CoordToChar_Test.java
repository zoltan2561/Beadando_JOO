package hu.beadando.foxandhounds;

import org.junit.jupiter.api.Test;

import static hu.beadando.foxandhounds.entity.CoordConverter.*;
import static org.junit.jupiter.api.Assertions.*;

class CoordConverterTests {
    @Test
    void testConvertXCoord() {
        // Test valid input
        assertEquals(3, convertXCoord("D"));

        // Test input with length > 1
        assertEquals(-2, convertXCoord("DE"));

        // Test invalid input
        assertEquals(-1, convertXCoord("G"));
    }

    @Test
    void testCharConvertToNumber() {
        // Test valid input
        assertEquals(3, charConvertToNumber("D"));

        // Test input with length > 1
        assertEquals(-1, charConvertToNumber("DE"));

        // Test invalid input
        assertEquals(-1, charConvertToNumber("G"));
    }

    @Test
    void testNumberConvertToChar() {
        // Test valid input
        assertEquals("D", numberConvertToChar(3));

        // Test input out of range
        assertEquals("error", numberConvertToChar(6));
    }
}
