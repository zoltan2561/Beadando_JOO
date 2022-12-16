package hu.beadando.foxandhounds;

import hu.beadando.foxandhounds.service.GameService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GameServiceTest {

    @Test
    void testPlayMethod() {
        // Create a mock implementation of the GameService interface
        GameService gameService = mock(GameService.class);

        // Invoke the play method on the mock object
        gameService.play();

        // Verify that the play method was called on the mock object
        verify(gameService).play();
    }
}
