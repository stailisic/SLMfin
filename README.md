![Build Status](https://github.com/stailisic/TicTacToe/actions/workflows/ci.yml/badge.svg)

![Latest Release](https://img.shields.io/github/v/release/stailisic/TicTacToe)



# Java - Game - TicTacToe # 

Collaborators: 
- Yasmin Farghally - ic22b101
- Anna Nagel - ic21b112
- Wen Ting Xu - ic22b085


# User Stories #

#001. As a player, I want to be able to make a move by choosing an empty square, so that I can place my symbol on the board.      
#002. As a player, I want to be notified when the game has ended in a win, loss or draw, so that I can see the result of the game.        
#003. As a player, I want to be notified when the game has ended in a win, loss or draw, so that I can see the result of the game.        
#004. As a player, I want to be able to start a new game after the current game has ended, so that I can play again.         
#005. As a player, I want to be able to play against both the PC and another (human) player. (one at a time)            
#006. As a player, I want to be able to have the option of manually shutting the game at any time/at the end of the game.       


# Project Structure #

The project compromises three main classes: 'Board', 'Game' and 'Player'. Additionally there are test classes for the individual classes.          
The 'Board' class represents the game board and provides methods for placing game pieces, checking game states, and displaying the current game board.             
The 'Game' class controls the flow of the game, facilitates interaction with the user, and implements the game logic. It includes functions for playing against a human player or the computer.           
The 'Player' class represents a player with a specific symbol ('X' or 'O'). The class offers methods for retrieving the player's symbol.       
The 'Main' class contains the main method and serves as the entry point for the game.         


# Starting the Application #

1. Execute the 'Main' class.         
2. The game will start and provide instructions for selecting gamemode (against the computer or another player).


# Functionality Overview #

1. Make a move
Players can make a move by choosing an empty square on the board. The 'Game' class orchestrates this process, ensuring that the chosen move is valid and updating the 'Board' accordingly. The sequence of actions involves:

  - Displaying the current state of the board.    
  - Prompting the player for input (row and column).    
  - Verifying the validity of the chosen move.    
  - Placing the player's symbol on the chosen square.       
  - Continuously allowing players to make moves until the game concludes.   


2. Game result notification
Upon the completion of a game (win, loss, or draw), the 'Game' class notifies players of the result. This involves:

  - Checking for a win, loss, or draw condition after each move.    
  - Displaying the final state of the board.     
  - Notifying the players of the game outcome.     

        
3. Start a new game
After completing a game, players have the option to start a new one. The 'Game' class manages this functionality by:

  - Displaying a prompt asking if the player wants to play again.     
  - Resetting the Board to its initial state for a fresh game.      
  - Allowing the player to choose a new opponent (PC or another player).     

        
4. Play against PC or another player
The 'Game' class supports playing against both the computer and another human player, providing a dynamic gaming experience. The player can:

  - Choose the opponent type at the beginning of each game.      
  - Engage in a strategic battle against the computer or challenge a friend.     

             
5. Manual game Shutdown
Players have the flexibility to manually shut down the game at any point. The 'Game' class enables this by:

  - Displaying a prompt asking if the player wants to exit.     
  - Providing a smooth termination of the application, allowing players to end the session on          their terms.      

      
# Unit Tests #

Each class in the project is accompanied by a dedicated test class to ensure the correctness of its functionality.





