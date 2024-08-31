package rbo13.github.minesweeper;

import rbo13.github.minesweeper.game.Game;
import rbo13.github.minesweeper.game.GameHandler;
import rbo13.github.minesweeper.game.Minefield;
import rbo13.github.minesweeper.game.UI;
import rbo13.github.minesweeper.util.Position;

public class Minesweeper implements Game {

    private Minefield minefield;
    private final GameHandler gameHandler;
    private final UI ui;

    public Minesweeper(int size, int totalMines) {
        minefield = new Minefield(size, totalMines);
        this.gameHandler = new GameHandler(minefield);
        this.ui = new UI(minefield);
    }

    public Minesweeper(Minefield minefield, GameHandler gameHandler, UI ui) {
        this.minefield = minefield;
        this.gameHandler = gameHandler;
        this.ui = ui;
    }

    @Override
    public void play() {
        ui.displayWelcomeMessage();
        while(!isGameOver() && !isGameWon()) {
            ui.displayGrid(false);
            Position position = ui.getNextMove();
            gameHandler.revealCell(position);

            if (gameHandler.isGameOver()) {
                ui.displayGameOverMessage();
                ui.displayGrid(true);
            } else if (gameHandler.isGameWon()) {
                ui.displayWinMessage();
                ui.displayGrid(true);
            }
        }
    }

    private boolean isGameOver() {
        return gameHandler.isGameOver();
    }

    private boolean isGameWon() {
        return gameHandler.isGameWon();
    }
}
