
public class UltimateTTTBoard{// Aggregation relationship with Board
    private Board[] ultimateBoard; // stores 9 Standard TTTBorads

    public UltimateTTTBoard() { // Initializing all the 9 Tic-Tac-Toe Boards
        ultimateBoard = new Board[9];
        for(int i = 0; i < ultimateBoard.length; i++) {
            ultimateBoard[i] = new Board(i);
        }
    }

    public void ultimateDisplay() {// prints all the 9 boards to console
        for(int i = 0; i < ultimateBoard.length; i++) {
            ultimateBoard[i].display(i);
            System.out.println();
        }
    }
    //Checks if there is a 3 match wins of Bords, Horizontally, vertically, or Diagonally
    public boolean checkUltimateWinner() { // check if there is a win of 3 small boards
        return (boardRowMatch() || boardColMatch() || boardDiagMatch());
    }

    private boolean boardDiagMatch() {// check if there is a win of 3 small boards diagonally

        if(ultimateBoard[0].checkWinner() && ultimateBoard[4].checkWinner() && ultimateBoard[8].checkWinner()) {
            return true;
        }
        else if(ultimateBoard[2].checkWinner() && ultimateBoard[4].checkWinner() && ultimateBoard[6].checkWinner()){
            return true;
        }
        return false;
    }

    private boolean boardRowMatch() {// check if there is a win of 3 small boards in a row
        if(ultimateBoard[0].checkWinner() && ultimateBoard[1].checkWinner() && ultimateBoard[2].checkWinner()) {
            return true;
        }else if(ultimateBoard[3].checkWinner() && ultimateBoard[4].checkWinner() && ultimateBoard[5].checkWinner()) {
            return true;
        }else if(ultimateBoard[6].checkWinner() && ultimateBoard[7].checkWinner() && ultimateBoard[8].checkWinner()) {
            return true;
        }
        return false;

    }

    private boolean boardColMatch() {// check if there is a win of 3 small boards in a column
        if(ultimateBoard[0].checkWinner() && ultimateBoard[3].checkWinner() && ultimateBoard[6].checkWinner()) {
            return true;
        }else if(ultimateBoard[1].checkWinner() && ultimateBoard[4].checkWinner() && ultimateBoard[7].checkWinner()) {
            return true;
        }else if(ultimateBoard[2].checkWinner() && ultimateBoard[5].checkWinner() && ultimateBoard[8].checkWinner()) {
            return true;
        }
        return false;
    }

    public Board getCurrentBoard(int boardNum) { // returns the current board the move was made on
        return ultimateBoard[boardNum];
    }

    public boolean isUltimateDraw() {// checks if there is no more available spots left, also sees if the ultimate board is full
        int count = 0;
        for(int i = 0; i < ultimateBoard.length; i++) {
            if(ultimateBoard[i].isFull()) {
                count++;
            }
        }
        return (count == 9);
    }
}
