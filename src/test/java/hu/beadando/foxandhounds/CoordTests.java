package hu.beadando.foxandhounds;

import static org.junit.jupiter.api.Assertions.*;

import hu.beadando.foxandhounds.entity.CoordConverter;
import org.junit.jupiter.api.Test;

class CoordConverterTest {

    @Test
    void testConvertXCoord() {
        assertEquals(0, CoordConverter.convertXCoord("A"));
        assertEquals(-1, CoordConverter.convertXCoord("G"));
        assertEquals(-2, CoordConverter.convertXCoord("AB"));
    }

    @Test
    void testCharConvertToNumber() {
        assertEquals(0, CoordConverter.charConvertToNumber("A"));
        assertEquals(-1, CoordConverter.charConvertToNumber("G"));
    }

    @Test
    void testNumberConvertToChar() {
        assertEquals("A", CoordConverter.numberConvertToChar(0));
        assertEquals("error", CoordConverter.numberConvertToChar(-1));
    }

    @Test
    void testCoordXValidChecker() {
        assertEquals(false, CoordConverter.coordXValidChecker(0));
        assertEquals(true, CoordConverter.coordXValidChecker(-1));
        assertEquals(true, CoordConverter.coordXValidChecker(-2));
        assertEquals(true, CoordConverter.coordXValidChecker(-3));
        assertEquals(true, CoordConverter.coordXValidChecker(6));
    }

    @Test
    void testCoordYValidChecker() {
        assertEquals(false, CoordConverter.coordYValidChecker(1));
        assertEquals(true, CoordConverter.coordYValidChecker(0));
        assertEquals(true, CoordConverter.coordYValidChecker(7));
    }

}
