
public abstract class APlayer {// has generalization relationship with ComputerPlayer and HumanPlayer
    private String mark;
    public String getMark() {
        return mark;
    }
    public void setMark(String mark, int row, int col) {
        this.mark = mark;
    }

    public abstract int selectRowValue(); // will be implemented in ComputerPlayer and HumanPlayer
    public abstract int selectColValue(); // will be implemented in ComputerPlayer and HumanPlayer

}
