package rbo13.github.minesweeper;

import rbo13.github.minesweeper.game.Game;
import rbo13.github.minesweeper.game.UI;

public class App
{
    public static void main( String[] args ) {
        UI.GameSetup setup = UI.getGameSetup();
        Game game = new Minesweeper(setup.getGridSize(), setup.getTotalMines());
        game.play();
    }
}
