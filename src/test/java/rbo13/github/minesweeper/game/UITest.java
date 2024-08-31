package rbo13.github.minesweeper.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UITest {

    private UI ui;
    private Minefield minefield;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = System.out;

    @BeforeEach
    void setup() {
        minefield = mock(Minefield.class);
        when(minefield.getSize()).thenReturn(4);
        ui = new UI(minefield);
        System.setOut(new PrintStream(outputStream));
    }
}
