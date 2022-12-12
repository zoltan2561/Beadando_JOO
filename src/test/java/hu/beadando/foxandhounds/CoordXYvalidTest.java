package hu.beadando.foxandhounds;

import org.junit.jupiter.api.Test;

import static hu.beadando.foxandhounds.entity.CoordConverter.coordXValidChecker;
import static hu.beadando.foxandhounds.entity.CoordConverter.coordYValidChecker;
import static org.junit.jupiter.api.Assertions.*;

class CoordValidCheckerTests {
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

//    @Test
//    void testCoordYValidChecker() {
//        // Test y = 0
//        assertTrue(coordYValidChecker(0));
//
//        // Test y = 6
//        assertTrue(coordYValidChecker(6));
//
//        // Test y = 7
//        assertTrue(coordYValidChecker(7));
//
//        // Test y = 1
//        assertFalse(coordYValidChecker(1));
//
//        // Test y = 5
//        assertFalse(coordYValidChecker(5));
//    }
}
