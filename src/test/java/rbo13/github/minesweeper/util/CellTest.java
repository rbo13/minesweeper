package rbo13.github.minesweeper.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CellTest {

    @Test
    void testCellInitialization() {
        Cell cell = new Cell();
        assertNotNull(cell);
    }
}
