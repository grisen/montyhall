package entities;

import java.util.List;
import java.util.Random;

public class Round {
    protected final List<Box> listOfBoxes;
    private Random random;

    public Round() {
        random = new Random();

        listOfBoxes = Box.getListOfBoxes();
        pickRandomBox().setWin(true);
    }

    protected Box pickRandomBox() {
        return listOfBoxes.get(random.nextInt(Box.noOfBoxes));
    }

    protected Box hostOpenBox(int notThis) {
        Box chosen;
        do {
            chosen = pickRandomBox();
        } while (chosen.getId() == notThis || chosen.isWin());

        return chosen;
    }

    protected Box playerOpenBox(int notThis) {
        Box chosen;
        do {
            chosen = pickRandomBox();
        } while (chosen.getId() == notThis);

        return chosen;
    }
}
