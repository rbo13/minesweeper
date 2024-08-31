package rbo13.github.minesweeper.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import rbo13.github.minesweeper.util.Cell;
import rbo13.github.minesweeper.util.Position;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameHandlerTest {

    private Minefield minefield;
    private GameHandler gameHandler;

    @BeforeEach
    void setup() {
        minefield = Mockito.mock(Minefield.class);
        gameHandler = new GameHandler(minefield);
    }

    @Test
    void testRevealCell_RevealCellAndContinue() {
        Position position = new Position(1, 1);
        Cell cell = Mockito.mock(Cell.class);
        when(minefield.isValidPosition(position.row(), position.col())).thenReturn(true);
        when(minefield.getCell(position.row(), position.col())).thenReturn(cell);
        when(cell.isRevealed()).thenReturn(false);
        when(cell.isMine()).thenReturn(false);
        when(cell.getAdjacentMines()).thenReturn(1);

        gameHandler.revealCell(position);
        verify(cell).setRevealed(true);
        assertFalse(gameHandler.isGameOver());
    }

    @Test
    void testRevealCell_RevealCellAndGameOverOnMine() {
        Position position = new Position(2, 2);
        Cell cell = Mockito.mock(Cell.class);

        when(minefield.isValidPosition(2, 2)).thenReturn(true);
        when(minefield.getCell(2, 2)).thenReturn(cell);
        when(cell.isRevealed()).thenReturn(false);
        when(cell.isMine()).thenReturn(true);

        gameHandler.revealCell(position);

        assertTrue(gameHandler.isGameOver());
    }
}
