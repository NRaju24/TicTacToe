
# TicTacToe Game

## Overview

This is a simple console-based TicTacToe game implemented in Java. The game allows two players to compete against each other or against an AI opponent. The objective is to align three of your symbols (X or O) in a row, column, or diagonal.

## Features

- Two Player Modes:
  - Play against another human player.
  - Play against an AI opponent.
- Game Board:
  - A 3x3 grid is displayed after each move.
- Move Validation
  - Ensures valid moves are made.
- Win Detection:
  - Checks for winning conditions in rows, columns, and diagonals.
- Draw Detection:
  - Determines if the game ends in a draw.
- Replay Option:
  - Allows starting a new game after the current game ends.

 How to Run

1. **Compile the Program:**
   javac launchGame.java
   ```

2. un the Program:
 java launchGame
   ```

3. Follow the prompts:
   - Choose whether to play against an AI or another player.
   - Enter your moves as row and column values when prompted.

## Code Structure

- TicTacToe Class:
  - Manages the game board, initializes the board, places marks, and checks game status.
- Player Class (Abstract):
  - Base class for players, both human and AI.
- HumanPlayer Class:
  - Allows a human player to make moves.
- AIPlayer Class:
  - Allows an AI player to make random moves.
- launchGame Class:
  - The entry point of the application. Manages game flow and player turns.

## Example Gameplay

```
Enter the row and column values
1
1
X |   |  
-------------
  |   |  
-------------
  |   |  
-------------
Bob turn now
| X |  
-------------
  |   |  
-------------
  |   |  
-------------
```

## Notes

- The board is displayed with `X` and `O` to represent player moves.
- Invalid moves or occupied positions are handled with appropriate messages.
- The game continues until one player wins or the board is full.


## Contact

For questions or suggestions, please contact rajucherukuri24@gmail.com

