# Design Decisions:


> This implementation follows the given requirements and incorporates clean code practices, object-oriented design, and SOLID principles. Here's a breakdown of the key components:

1. `Minesweeper.java` class: Main entry point of the game. This class also implements the `Game interface`.
2. `GameHandler.java` class: Handles the game logic, provides methods for revealing cells and checking game state.
3. `UI.java` class: Handles displaying of prompt messages. Overall UI of the game.
4. `Minefield.java` class: Handles the creation of a minefield. This is the class where placing of mines, initializing the grid.
5. `Cell.java` class: Basic POJO that represents an individual cell on an NxN grid.
6. `Position.java` record: A record to keep track the current player position in a grid.
7. `Game.java` interface: A basic interface that our minesweeper game implements.


# Assumptions:

1. Game Flow and Control:
   * The `play()` method in the Minesweeper class handles the main game loop, where it repeatedly displays the grid, gets the next move, and processes the result until the game is over or won.
   * The game should prompt the user to play again or exit after a win or loss. This mechanism involves resetting the game state without restarting the program.
   
2. Error Handling:
   * Invalid moves, `GameHandler` and `UI` classes handle invalid moves.
   * User inputs, user cannot input number of mines greater than 35% of the grid.
   * No maximum grid size, but has a minimum grid size of 3.