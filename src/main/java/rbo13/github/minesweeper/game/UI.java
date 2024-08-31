package rbo13.github.minesweeper.game;

import rbo13.github.minesweeper.util.Cell;

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
    private static final String MINE = "X ";
    private static final double MAX_MINE_PERCENTAGE = 0.35;

    public UI(Minefield minefield) {
        this.minefield = minefield;
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcomeMessage() { System.out.println("Welcome to Minesweeper!"); }

    public void displayGrid(boolean revealAll) {
        System.out.print("  ");
        for (int i = 0; i < minefield.getSize(); i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < minefield.getSize(); i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < minefield.getSize(); j++) {
                Cell cell = minefield.getCell(i, j);
                if (revealAll || cell.isRevealed()) {
                    if (cell.isMine()) {
                        System.out.print(MINE);
                    } else {
                        System.out.print(cell.getAdjacentMines() + " ");
                    }
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}
