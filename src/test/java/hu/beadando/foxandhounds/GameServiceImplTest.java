package hu.beadando.foxandhounds;

import hu.beadando.foxandhounds.entity.Dog;
import hu.beadando.foxandhounds.entity.Fox;
import hu.beadando.foxandhounds.service.GameServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)

class GameServiceImplTest {
    @Mock
    GameServiceImpl gameServiceImpl;

    @Mock
    Dog dog;

    @Mock
    Fox fox;

    @Test
    public void testGetPlayerName() {
        when(gameServiceImpl.getPlayerName()).thenReturn("John Doe");
        String expected = "John Doe";
        String actual = gameServiceImpl.getPlayerName();
        assertEquals(expected, actual);
    }

    @Test
    public void testCoordDogYReader() {
        when(gameServiceImpl.coordDogYReader()).thenReturn(1);
        int expected = 1;
        int actual = gameServiceImpl.coordDogYReader();
        assertEquals(expected, actual);
    }

    @Test
    public void testCoordDogXReader() {
        when(gameServiceImpl.coordDogXReader()).thenReturn(1);
        int expected = 1;
        int actual = gameServiceImpl.coordDogXReader();
        assertEquals(expected, actual);
    }

    @Test
    public void testCoordFoxXGenerator() {
        when(gameServiceImpl.coordFoxXGenerator(fox)).thenReturn(1);
        int expected = 1;
        int actual = gameServiceImpl.coordFoxXGenerator(fox);
        assertEquals(expected, actual);
    }

    @Test
    public void testCoordFoxYGenerator() {
        when(gameServiceImpl.coordFoxYGenerator(fox)).thenReturn(1);
        int expected = 1;
        int actual = gameServiceImpl.coordFoxYGenerator(fox);
        assertEquals(expected, actual);
    }


}
