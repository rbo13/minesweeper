package rbo13.github.minesweeper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rbo13.github.minesweeper.game.GameHandler;
import rbo13.github.minesweeper.game.Minefield;
import rbo13.github.minesweeper.util.Position;

import static org.junit.jupiter.api.Assertions.*;

public class MinesweeperTest {

    private Minefield minefield;
    private GameHandler gameHandler;

    @BeforeEach
    void setUp() {
        minefield = new Minefield(4, 3);
        gameHandler = new GameHandler(minefield);
    }

    @Test
    void testInitialization() {
        assertFalse(gameHandler.isGameOver());
        assertFalse(gameHandler.isGameWon());
    }

    @Test
    void testGameOver() {
        // Reveal all cells to find a mine
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gameHandler.revealCell(new Position(i, j));
                if (gameHandler.isGameOver()) {
                    assertTrue(gameHandler.isGameOver());
                    return;
                }
            }
        }
        fail("No mine found");
    }

    @Test
    void testGameWon() {
        // Reveal all non-mine cells
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gameHandler.revealCell(new Position(i, j));
                if (gameHandler.isGameOver()) {
                    return;
                }
            }
        }
        assertTrue(gameHandler.isGameWon());
    }
}
