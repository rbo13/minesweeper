package rbo13.github.minesweeper.game;

import java.util.Scanner;

public class UI {

    private final Minefield minefield;
    private final Scanner scanner;

    public UI(Minefield minefield) {
        this.minefield = minefield;
        this.scanner = new Scanner(System.in);
    }
}
