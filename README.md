# Tic-Tac-Toe-Artifical-Intel
Tic Tac Toe :Tic tac toe is X’s and O’s is a paper and pencil game for two players X and O, who take turns marking the spaces in a 3×3 grid.Minimax can be implemented using a recursive or backtracking algorithm which traverses a game tree consisting of possible moves and their outcomes.
Tic tac toe is X’s and O’s is a paper and pencil game for two players X and O, who take turns marking the spaces in a 3×3 grid.
Win condition:In order to win the game ,a player(computer or human) must place three of their marks in horizontal or vertical or diagonal.
Draw Condition:If the both players (computer and human) do not meet any condition of win like 3 place horizontal , vertical,diagonal.
Minimax:
Minimax can be implemented using a recursive or backtracking algorithm which traverses a game tree consisting of possible moves and their outcomes. The root node of the tree represents the current game state. Each branch from a node represents a possible move a player could make. Each child node represents the resulting game state of a possible move. 
Mini-max algorithm is a recursive or backtracking algorithm which is used in decision-making and game theory. It provides an optimal move for the player assuming that the opponent is also playing optimally.
The minimax algorithm performs a depth-first search algorithm for the exploration of the complete game tree.
The minimax algorithm proceeds all the way down to the terminal node of the tree, then backtrack the tree as the recursion.
A utility function is used to judge terminal states and assign a numerical value to terminal states based on the rules of the game. If the terminal state represents a winning outcome for the player performing the search then it will be assigned a high value.If at terminal point losing outcome then it is assigned a negative value.Assigning value from terminal to root.
