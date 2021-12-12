/* Makes board comprised of a  2D array of charaacters. Keeps track if there is 3 mark match in the board or not.
 */
public class Board {
    private char[][] board; // making one board
    private int boardNum;

    public Board(int boardNum) {
        board = new char[3][3];
        this.boardNum = boardNum;
        //filling the array with dashes as place markers
        for(int row = 0; row < board.length; row++) { // initializing the board
            for(int col = 0; col < board[row].length; col++) {
                board[row][col] = '-';
            }
        }
    }
    public char[][] getBoard() {// returns the 2D array
        return board;
    }

    //Board number is between 0-9 in the big board
    public int getBoardNum() {
        return boardNum;
    }

    public char getMark(int row, int col) {// returns the status of the place in the board
        return board[row][col];
    }

    public void setMark(int row, int col, char val) {
        board[row][col] = val;
    }

    public void display(int boardNum){
        System.out.println("Printing Board # " + boardNum);
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull() { // also this is a draw
        int spaces = 0;
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                if(board[row][col] == '-') {
                    spaces++;
                }
            }
        }
        if(spaces == 0) {
            return true;
        }
        return false;
    }

    public boolean checkWinner() {// // check if there is a win of 3 in one board
        return (rowMatch() || colMatch() || diagMatch());
    }

    private boolean diagMatch() {// check if there is a win of 3 one board diagonally
        if((board[0][0] != '-') && (board[0][0] == board[1][1]) &&   (board[0][0] == board[2][2])) {
            return true; //if there is a match
        }
        else if((board[0][2] != '-') && (board[0][2] == board[1][1]) && (board[0][2] == board[2][0]) ) {
            return true; //if there is a match
        }
        return false;
    }

    private boolean colMatch() {// check if there is a win of 3 one board vertically
        for(int col = 0; col < board[0].length; col++) {
            if((board[0][col]!= '-' ) &&(board[0][col] == board[1][col]) && (board[0][col] == board[2][col])) {
                return true; //if there is a match
            }
        }
        return false;
    }

    private boolean rowMatch() {// check if there is a win of 3 one board horizontally
        for(int row = 0; row < board.length; row++) {
            if((board[row][0] != '-') && (board[row][0] == board[row][1]) && ( board[row][0] == board[row][2])) {
                return true; //if there is a match
            }
        }
        return false;
    }
}
