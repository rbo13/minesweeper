package rbo13.github.minesweeper.game;

import java.util.Scanner;

public class UI {

    public static class GameSetup {
        final int gridSize;
        final int totalMines;

        GameSetup(int gridSize, int totalMines) {
            this.gridSize = gridSize;
            this.totalMines = totalMines;
        }

        public int getGridSize() {
            return gridSize;
        }

        public int getTotalMines() {
            return totalMines;
        }
    }

    private final Minefield minefield;
    private final Scanner scanner;
    private static final double MAX_MINE_PERCENTAGE = 0.35;

    public UI(Minefield minefield) {
        this.minefield = minefield;
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcomeMessage() { System.out.println("Welcome to Minesweeper!"); }
}
