import java.util.Random;

public class ComputerPlayer extends APlayer {// generalization relationship with the APlayer class
    // This is the player which is AI, column and row values will be automatically picked
    private Random random = new  Random();
    private int min = 0;
    private int max = 3;

    @Override
    public int selectRowValue() { // returns a random value from between 0 - 2
        return random.nextInt(max - min) + min;
    } // randomly pick an available row value to make move

    @Override
    public int selectColValue() {// returns a random value from between 0 - 2
        return random.nextInt(max - min) + min;
    } // randomly pick an available column value to make move

}
