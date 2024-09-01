package rbo13.github.minesweeper.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import rbo13.github.minesweeper.util.Cell;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UITest {

    private UI ui;
    private Minefield minefield;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outputStream));
        minefield = mock(Minefield.class);
        ui = new UI(minefield);
    }

    @Test
    void testDisplayWelcomeMessage() {
        ui.displayWelcomeMessage();
        String expectedOutput = "Welcome to Minesweeper!\n";
        assertEquals(normalizeLineEndings(expectedOutput), normalizeLineEndings(outputStream.toString()));
    }

    @Test
    void testDisplayGrid_RevealAll() {
        lenient().when(minefield.getSize()).thenReturn(2); // Example: 2x2 grid

        Cell cell1 = mock(Cell.class);
        Cell cell2 = mock(Cell.class);
        Cell cell3 = mock(Cell.class);
        Cell cell4 = mock(Cell.class);

        lenient().when(cell1.isMine()).thenReturn(false);
        lenient().when(cell1.isRevealed()).thenReturn(true);
        lenient().when(cell1.getAdjacentMines()).thenReturn(1);

        lenient().when(cell2.isMine()).thenReturn(true);
        lenient().when(cell2.isRevealed()).thenReturn(true);

        lenient().when(cell3.isMine()).thenReturn(false);
        lenient().when(cell3.isRevealed()).thenReturn(true);
        lenient().when(cell3.getAdjacentMines()).thenReturn(0);

        lenient().when(cell4.isMine()).thenReturn(false);
        lenient().when(cell4.isRevealed()).thenReturn(true);
        lenient().when(cell4.getAdjacentMines()).thenReturn(2);

        lenient().when(minefield.getCell(0, 0)).thenReturn(cell1);
        lenient().when(minefield.getCell(0, 1)).thenReturn(cell2);
        lenient().when(minefield.getCell(1, 0)).thenReturn(cell3);
        lenient().when(minefield.getCell(1, 1)).thenReturn(cell4);

        ui.displayGrid(true);

        String expectedOutput = "  1 2 \n" +  // Header row
                "A 1 X \n" +  // Row A
                "B 0 2 \n";   // Row B

        assertEquals(normalizeLineEndings(expectedOutput), normalizeLineEndings(outputStream.toString()));
    }

    // fix line endings
    private String normalizeLineEndings(String input) {
        return input.replace("\r\n", "\n").replace("\r", "\n");
    }
}
