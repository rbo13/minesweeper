package rbo13.github.minesweeper.util;

public record Cell(boolean isMine, boolean isRevealed, int adjacentMines) {

}
