package rbo13.github.minesweeper.game;

import rbo13.github.minesweeper.util.Cell;
import rbo13.github.minesweeper.util.Position;

public class GameHandler {

    /*
     * Minesweeper cell can have 8 adjacent
     * cell direction: top, top-right,
     * right, bottom-right, bottom,
     * bottom-left, left, and top-left.
     */
    private static final int MAX_DIRECTION_MOVEMENT = 8;

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
            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

            for (int i = 0; i < MAX_DIRECTION_MOVEMENT; i++) {
                revealCell(new Position(position.row() + dx[i], position.col() + dy[i]));
            }
        }
    }

    public boolean isGameOver() { return gameOver; }

    public boolean isGameWon() {
        return revealedCells == (minefield.getSize() * minefield.getSize() - minefield.getTotalMines());
    }
}
