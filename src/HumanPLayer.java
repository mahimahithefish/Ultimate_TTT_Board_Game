import java.util.*;
public class HumanPlayer extends APlayer{ // generalization relationship with the Aplayer class
    // This is the user, where they will pick the values of Column and the Row values in the console
    private Scanner input = new Scanner(System.in); // takes input from console
    private int rowNum;
    private int colNum;
    @Override
    public int selectRowValue() { //returns the row value the user picked

        System.out.print("Player X, please select a row number (0 - 2):"); // prompts the user
        rowNum = input.nextInt();
        return rowNum;
    }

    @Override
    public int selectColValue() {// returns the col value the user picked
        System.out.print("Player X, please select a column number (0 - 2):"); // prompts the user
        colNum = input.nextInt();
        return colNum;
    }
}
