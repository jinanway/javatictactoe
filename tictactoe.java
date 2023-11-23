/*
Tic-Tac-Toe

Overview:
	Your task is to code the game Tic-Tac-Toe utilizuing functions.

	Outline:
		The game will be created for two humans to play.
		Each turn, the program will reprompt the user until they give a valid move.
		If the user chooses a winning move, the game ends.

	Specifics:
		The Board:
			- The Board will be a 2d array of integers, eaching index being a single number.
			- The board is stored in the vaiable "int[row][column] board" in main, and is passed to the functions. 
			- The specific characters and visual design will be up to you, but keep
				usability in mind. You need a character to track each player's move, as well as denote
				empty spaces.
			- For beautification, use: | _ - = and any other line characters to create an aesthetic board design.
				Those of you that get done early can go ham on this and make some really cool stuff.

		Individual Moves:
			- Moves will be stored as an int[] with 2 elements. You can decide which way to store the X and Y values,
				but I reccomend using int[Y, X]. This seems counterintuitive at first, but as you work on the 
				project and pass it to "int[][] board", it'll make much more sense.
*/
import java.util.Scanner;
class Main {

	//---FUNCTIONS--------------------------------------------------------------------

	//gets a valid move from the player
	public static int[] getLegalMove(int[][] board){
		//Get user input for the move
		int[] move = {0,0};
        //scanner saves to potential move to check if move is legal before actaully confiming
        Scanner sc = new Scanner(System.in);
        int[] potentialMove = new int[1000000];
        System.out.print("Coordinate 1: ");
        potentialMove[1] = sc.nextInt();
        System.out.print("Coordinate 2: ");
        potentialMove[0] = sc.nextInt();

        //if the board at that move is set to 0 means no move exists yet so move can be made
        if(potentialMove[0] < 4 && potentialMove[1] < 4 && potentialMove[0] > 0 && potentialMove[1] > 0 && board[potentialMove[0]-1][potentialMove[1]-1] == 0 ){
            move[0] = potentialMove[0];
            move[1] = potentialMove[1];
        //if move is off the tic-tac-toe board then it tells player to choose an in-bound coordinate
        }else if(potentialMove[0] > 3 || potentialMove[0] <= 0 || potentialMove[1] > 3 || potentialMove[1] <= 0){
            System.out.println("Bro that doesn't even exist on the board. Pick coordinates in the range of 1 to 3");
            move[0] = 0;
            move[1] = 1;
        //if move is already taken then it tells player to make a new move
        }else if(board[potentialMove[0] - 1][potentialMove[1]-1] == 1 || board[potentialMove[0] - 1][potentialMove[1] - 1] == 2){
            System.out.println("Sorry that move is already taken, please try another.");
            move[0] = 0;
            move[1] = 1;
        } 
		//return the move
		return move;
	}

	//take legal Y and X values and make a move.
	public static int[][] playMove(int[][] board, int[] move, int player){
        //checks if the move was confirmed as legal or still set as 0, and checks which player is making the move and then sets the move
        if(move[0] != 0 && player == 1){
            board[move[0]-1][move[1]-1] = 1;
        } else if(move[0] != 0 && player == 2){
            board[move[0]-1][move[1]-1] = 2;
        //if the move is returned as zero from the getLegalMove, then getLegalMove function and playMove function are called again
        } else if(move[0] == 0 || move[1] == 0){
            playMove(board, getLegalMove(board), player);
        }
        //returns the updated board
		return board;      
        }
		

	//prints a text representation of the board
	public static void showBoard(int[][] board){
        //string 2d array that holds the univode X and O for the moves
        String[][] game = new String[1000][1000];
        //loop that cycles through the board 2d to find any confirmed moves and then sets the index to X or O based on which player it is (player 1 is 1 and player 2 is 2)
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == 1){
                    game[i][j] = "❌";
                }else if(board[i][j] == 2){
                    game[i][j] = "⭕";
                }else if(board[i][j] == 0){
                    game[i][j] = " ";
                }
            }    
        }
        //actually prints out the text for the board
        System.out.println("   1     2     3");
        System.out.println("      |     |     ");
        System.out.println("1  "+ game[0][0] +"  |  "+ game[0][1] +"  |  "+ game[0][2] +"  ");
        System.out.println(" _____|_____|_____");
        System.out.println("      |     |     ");
        System.out.println("2  "+ game[1][0] +"  |  "+ game[1][1] +"  |  "+ game[1][2] +"  ");
        System.out.println(" _____|_____|_____");
        System.out.println("      |     |     ");
        System.out.println("3  "+ game[2][0]  +"  |  "+ game[2][1] +"  |  "+ game[2][2] +"  ");
        System.out.println("      |     |     ");
	}

	//checks all rows, columns, and diagonals for winners. 
	public static int checkWin(int[][] board){
        //variable storing the winner
        int winner = 0;

        //cycles through all eight win variations for player 1
        if(board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 1){
            winner = 1;
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        } else if(board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 1){
            winner = 1;
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        } else if(board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 1){
            winner = 1;
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        } else if(board[0][0] == 1 && board[1][0] == 1 && board[2][0] == 1){
            winner = 1;
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        } else if(board[0][1] == 1 && board[1][1] == 1 && board[2][1] == 1){
            winner = 1;
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        } else if(board[0][2] == 1 && board[1][2] == 1 && board[2][2] == 1){
            winner = 1;
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        } else if(board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1){
            winner = 1; 
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        } else if(board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1){
            winner = 1;
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        //cyles through all win variations for player 2            
        } else if(board[0][0] == 2 && board[0][1] == 2 && board[0][2] == 2){
            winner = 2;
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        } else if(board[1][0] == 2 && board[1][1] == 2 && board[1][2] == 2){
            winner = 2;
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        } else if(board[2][0] == 2 && board[2][1] == 2 && board[2][2] == 2){
            winner = 2;
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        } else if(board[0][0] == 2 && board[1][0] == 2 && board[2][0] == 2){
            winner = 2;
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        } else if(board[0][1] == 2 && board[1][1] == 2 && board[2][1] == 2){
            winner = 2;
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        } else if(board[0][2] == 2 && board[1][2] == 2 && board[2][2] == 2){
            winner = 2;
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        } else if(board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2){
            winner = 2;
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        } else if(board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2){
            winner = 2;
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        } else if(board[0][0] != 0 && board[0][1] != 0 && board[0][2] != 0 && board[1][0] != 0 && board[1][1] != 0 && board[1][2] != 0 && board[2][0] != 0 && board[2][1] != 0 && board[2][2] != 0){
            winner = 0;
            System.out.println("Tie game! No one won... Re-run the program to play again");
            System.exit(0);
        }
		//Returns 0 for no one, 1 for player 1, and 2 for player 2.	
        return winner;
	}

	public static void main(String[] args) {
        
		//Your code here :)
		int[][] board = {{0, 0, 0},{0, 0, 0},{0, 0, 0}};
		int winner = 0;
        
        //prints out the directions for the player
        System.out.println("Yo whats goodie we boutta play some tic-tac-toe, here's the board:");
        showBoard(board);
        System.out.println("");
        System.out.println("Player 1 is ❌  and Player 2 is ⭕ .");
        System.out.println("The top row of numbers are for Coordinate 1 and left column of numbers are for Coordinate 2.");
        System.out.println("All you gotta do is type the coordinates of your move when it's your turn, got it?");
        System.out.println("");
        
		while(winner == 0){
            /*get valid move
              make valid move
              check winner
              change turn
           */
           //Player 1 function calls
            System.out.println("Player 1, Type each coordinate and then hit enter.");
            board = playMove(board, getLegalMove(board), 1);
            showBoard(board);
            winner = checkWin(board);
            
            //Player 2 function calls
            System.out.println("Player 2, Type your coordinates and then hit enter.");
            board = playMove(board, getLegalMove(board), 2);
            showBoard(board);
            winner = checkWin(board);
            
		}
//some player won!
	}
}
