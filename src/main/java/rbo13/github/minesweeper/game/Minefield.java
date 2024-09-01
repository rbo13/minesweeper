package rbo13.github.minesweeper.game;

import rbo13.github.minesweeper.util.Cell;

import java.security.SecureRandom;

public class Minefield {

    private final int size;
    private final int totalMines;
    private final Cell[][] board;

    public Minefield(int size, int totalMines) {
        this.size = size;
        this.totalMines = totalMines;

        // represents an NxN square.
        this.board = new Cell[size][size];
        initializeGrid();
        placeMines();
        calculateAdjacentMines();
    }

    private void initializeGrid() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Cell();
            }
        }
    }

    private void placeMines() {
        SecureRandom random = new SecureRandom();
        int minesPlaced = 0;

        while(minesPlaced < totalMines) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);

            if (!board[row][col].isMine()) {
                board[row][col].setMine(true);
                minesPlaced++;
            }
        }
    }

    private void calculateAdjacentMines() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (!board[row][col].isMine()) {
                    board[row][col].setAdjacentMines(countAdjacentMines(row, col));
                }
            }
        }
    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (isValidPosition(newRow, newCol) && board[newRow][newCol].isMine()) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public Cell getCell(int row, int col) {
        if (!isValidPosition(row, col)) {
            return null;
        }
        return board[row][col];
    }

    public int getSize() {
        return size;
    }

    public int getTotalMines() {
        return totalMines;
    }
}
