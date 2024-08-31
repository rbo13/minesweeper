package rbo13.github.minesweeper.game;

import rbo13.github.minesweeper.util.Cell;
import rbo13.github.minesweeper.util.Position;

public class GameHandler {

    private final Minefield minefield;
    private boolean gameOver;
    private int revealedCells;

    public GameHandler(Minefield minefield) {
        this.minefield = minefield;
        this.gameOver = false;
        this.revealedCells = 0;
    }

    public void revealCell(Position position) {
        if (!minefield.isValidPosition(position.row(), position.col()) || minefield.getCell(position.row(), position.col()).isRevealed()) {
            return;
        }

        Cell cell = minefield.getCell(position.row(), position.col());
        cell.setRevealed(true);
        revealedCells++;

        if (cell.isMine()) {
            gameOver = true;
            return;
        }

        if (cell.getAdjacentMines() == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    revealCell(new Position(position.row() + i, position.col() + j));
                }
            }
        }
    }

    public boolean isGameOver() { return gameOver; }

    public boolean isGameWon() {
        return revealedCells == (minefield.getSize() * minefield.getSize() - minefield.getTotalMines());
    }
}
