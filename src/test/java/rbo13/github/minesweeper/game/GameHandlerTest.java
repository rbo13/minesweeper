package rbo13.github.minesweeper.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import rbo13.github.minesweeper.util.Cell;
import rbo13.github.minesweeper.util.Position;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameHandlerTest {

    private Minefield minefield;
    private GameHandler gameHandler;

    @BeforeEach
    void setUp() {
        minefield = mock(Minefield.class);
        when(minefield.getSize()).thenReturn(5);
        when(minefield.getTotalMines()).thenReturn(5);
        when(minefield.isValidPosition(anyInt(), anyInt())).thenReturn(true);
        gameHandler = new GameHandler(minefield);
    }

    @Test
    void testGameOverWhenMineIsRevealed() {
        Cell mineCellMock = mock(Cell.class);
        when(mineCellMock.isMine()).thenReturn(true);
        when(minefield.getCell(0, 0)).thenReturn(mineCellMock);

        gameHandler.revealCell(new Position(0, 0));

        assertTrue(gameHandler.isGameOver());
        assertFalse(gameHandler.isGameWon());
    }

    @Test
    void testGameWonWhenAllSafeCellsRevealed() {
        Cell nonMineCellMock = mock(Cell.class);
        when(nonMineCellMock.isMine()).thenReturn(false);
        when(nonMineCellMock.getAdjacentMines()).thenReturn(1);
        when(minefield.getCell(anyInt(), anyInt())).thenReturn(nonMineCellMock);

        // Reveal all non-mine cells (5x5 grid with 5 mines = 20 non-mine cells)
        for (int i = 0; i < 20; i++) {
            gameHandler.revealCell(new Position(i / 5, i % 5));
        }

        assertTrue(gameHandler.isGameWon());
        assertFalse(gameHandler.isGameOver());
    }
}
