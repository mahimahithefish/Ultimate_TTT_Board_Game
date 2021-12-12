import java.util.Scanner;

public class UltimateGame {// Association with the APlayer and UltimateBoard Classes
    private UltimateTTTBoard myBoard;
    private char player = 'X'; // player1: X player2: O
    private int rowNum = -1;
    private int colNum = -1;
    private int boardNum = -1;

    public APlayer player1 = new HumanPlayer(); // first is a human player
    public APlayer player2 = new ComputerPlayer(); // second is an AI player


    public UltimateTTTGame() {
        myBoard = new UltimateTTTBoard();
        System.out.println("Welcome to the Ultimate Tic Tac Toe Game"); // prints message
        System.out.println();
    }

    public void game() { // main control of the program
        Scanner input = new Scanner(System.in); // get player1, input for the very first input

        System.out.print("Player " + player + ", please select a board(0 - 8):"); // input from console
        boardNum = input.nextInt();

        boolean ultimateGameWon = myBoard.checkUltimateWinner();// checks if there is a win in the UltimateBoard
        boolean ultimateGameOver = myBoard.isUltimateDraw();// checks if there is a draw in the ultimateBoard

        do {
            myBoard.ultimateDisplay();
            Board temp = myBoard.getCurrentBoard(boardNum);

            System.out.println("Make a move on Board # " + boardNum + " now...");
            //get user input of specified row and column number from the console
            // check which player is making the move:
            //if it is player1 then it will call the Human player methods
            if(player == 'X') { // player1
                rowNum = player1.selectRowValue();
                colNum = player1.selectColValue();
            }// if it is player 2 then it will automatically choose a value
            else if(player == 'O') {// player 2
                rowNum = player2.selectRowValue();
                colNum = player2.selectColValue();
                System.out.println("Player " + player + " selected row: " + rowNum + " and selected column: " + colNum );
            }

            //if move made in the row and column is empty then change it to 'X' or 'O'
            if(temp.getMark(rowNum, colNum) == '-') {
                temp.setMark(rowNum, colNum, player); // made the move

                ultimateGameWon = myBoard.checkUltimateWinner();
                ultimateGameOver = myBoard.isUltimateDraw();

                boardNum = nextBoardMove(rowNum, colNum);
                //changing to the other player.
                if(player == 'X') player = 'O';
                else player = 'X';
            }else {
                System.out.println("invalid move"); // if made a move in an already occupied space!
                System.out.println("try again!");
            }
        }while(!ultimateGameWon && !ultimateGameOver); // if there is are no more empty spots or there is a 3 match.

        System.out.println("Player " + player + " has won the Ultimate game!"); // if the game has ended
        System.out.println("Printing the final board info....");
        myBoard.ultimateDisplay();
    }


    public static int nextBoardMove(int row, int col) {// returns the next Board where the next player will make a move on
        if(row == 0 && col == 0) { // this depends on previous player's move.
            return 0;
        }else if(row == 0 && col == 1) {
            return 1;
        }else if(row == 0 && col == 2) {
            return 2;
        }else if(row == 1 && col == 0) {
            return 3;
        }else if(row == 1 && col == 1) {
            return 4;
        }else if(row == 1 && col == 2) {
            return 5;
        }else if(row == 2 && col == 0) {
            return 6;
        }else if(row == 2 && col == 1) {
            return 7;
        }else if(row == 2 && col == 2) {
            return 8;
        }
        return -1;
    }
}
