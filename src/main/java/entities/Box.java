package entities;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Box {

    private int id;
    private boolean win = false;

    public static final int noOfBoxes = 3;

    public Box (int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public static List<Box> getListOfBoxes() {
        return IntStream.range(0, noOfBoxes).mapToObj(i -> new Box(i)).collect(Collectors.toList());
    }
}
