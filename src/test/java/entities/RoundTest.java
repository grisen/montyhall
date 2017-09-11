package entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class RoundTest {

    private Round round;
    private Random random;
    @Before
    public void setUp() {
        round = new Round();
        random = new Random();
    }

    @Test
    public void testPickRandomBox() throws Exception {
        Box box = round.pickRandomBox();
        Assert.assertNotNull(box);
    }

    @Test
    public void testHostOpenBox() {
        int notThis = random.nextInt(3);

        for (int i = 0; i < 100; i++) {
            Box box = round.hostOpenBox(notThis);
            Assert.assertFalse(box.getId() == notThis);
            Assert.assertFalse(box.isWin());
        }
    }

    @Test
    public void testPlayerOpenBox() {
        int notThis = random.nextInt(3);

        for (int i = 0; i < 100; i++) {
            Box box = round.playerOpenBox(notThis);
            Assert.assertFalse(box.getId() == notThis);
        }
    }

}