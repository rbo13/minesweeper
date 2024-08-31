package rbo13.github.minesweeper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rbo13.github.minesweeper.game.GameHandler;
import rbo13.github.minesweeper.game.Minefield;
import rbo13.github.minesweeper.game.UI;

import static org.mockito.Mockito.*;

public class MinesweeperTest {

    private Minesweeper minesweeper;
    private Minefield minefield;
    private GameHandler gameHandler;
    private UI ui;

    @BeforeEach
    void setup() {
        minefield = mock(Minefield.class);
        gameHandler = mock(GameHandler.class);
        ui = mock(UI.class);

        minesweeper = new Minesweeper(minefield, gameHandler, ui);
    }

    @Test
    public void testPlay_GameOver() {
        // Setup behavior for the game being over
        when(gameHandler.isGameOver()).thenReturn(true);
        when(gameHandler.isGameWon()).thenReturn(false);

        // Run the play method
        minesweeper.play();

        // Verify that the welcome message and game over message are displayed
        verify(ui).displayWelcomeMessage();
        verify(ui).displayGameOverMessage();
        verify(ui).displayGrid(true);
        verify(ui, never()).displayWinMessage(); // Ensure the win message is not displayed
    }
}
