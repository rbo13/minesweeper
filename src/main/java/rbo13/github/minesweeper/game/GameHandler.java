package rbo13.github.minesweeper.game;

import rbo13.github.minesweeper.util.Cell;
import rbo13.github.minesweeper.util.Position;

public class GameHandler {

    private static final int MAX_DIRECTION_MOVEMENT = 8;

    private Minefield minefield;
    private boolean gameOver;
    private int revealedCells;

    public GameHandler(Minefield minefield) {
        this.minefield = minefield;
        this.gameOver = false;
        this.revealedCells = 0;
    }

    public void revealCell(Position position) {
        Cell currentCell = minefield.getCell(position.row(), position.col());
        if (currentCell == null) {
            return;
        }

        if (!minefield.isValidPosition(position.row(), position.col()) || minefield.getCell(position.row(), position.col()).isRevealed()) {
            return;
        }

        currentCell.setRevealed(true);
        revealedCells++;

        if (currentCell.isMine()) {
            gameOver = true;
            return;
        }

        if (currentCell.getAdjacentMines() == 0) {
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

    public void reset(Minefield newMinefield) {
        this.minefield = newMinefield;
        this.gameOver = false;
        this.revealedCells = 0;
    }
}
