package rbo13.github.minesweeper;

import rbo13.github.minesweeper.game.Game;
import rbo13.github.minesweeper.game.GameHandler;
import rbo13.github.minesweeper.game.Minefield;
import rbo13.github.minesweeper.game.UI;
import rbo13.github.minesweeper.util.Position;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            start();

            System.out.println("Press any key to play again or 'n' to exit: ");
            String response = scanner.nextLine();

            playAgain = !response.equalsIgnoreCase("n");

            if (playAgain) {
                restartGame();
            }
        } while (playAgain);

        System.out.println("Exiting game, thank you for playing!");
    }

    private void start() {
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

    private void restartGame() {
        this.minefield = new Minefield(minefield.getSize(), minefield.getTotalMines());
        gameHandler.reset(minefield);
        ui.refreshMinefield(minefield);
    }

    private boolean isGameOver() {
        return gameHandler.isGameOver();
    }

    private boolean isGameWon() {
        return gameHandler.isGameWon();
    }
}
