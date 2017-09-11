package entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;


public class GameTest {

    private Game game;
    private Random random;
    @Before
    public void setUp() {
        game = new Game();
        game.getRound();

        random = new Random();
    }

    @Test
    public void testUserPicksFirstBox() {
        Box firstBox = game.userPicksFirstBox();
        Assert.assertNotNull(firstBox);
    }

    @Test
    public void testHostOpensEmptyBox() {
        for (int i = 0; i < 100; i++){
            int notThis = random.nextInt(Box.noOfBoxes);

            Box hostBox = game.hostOpensEmptyBox(notThis);
            Assert.assertFalse(hostBox.isWin());
            Assert.assertFalse(hostBox.getId() == notThis);
        }
    }

    @Test
    public void testUserOpensFinalBox() {
        for (int i = 0; i < 100; i++){
            int notThis = random.nextInt(Box.noOfBoxes);

            Box hostBox = game.userOpensFinalBox(notThis);
            Assert.assertFalse(hostBox.getId() == notThis);
        }
    }

    @Test
    public void testCountResult() {
        Box loosingBox = new Box(0);
        Box winningBox = new Box(1);
        winningBox.setWin(true);

        game.countResult(loosingBox, loosingBox);//switching wins
        Assert.assertTrue(game.getSwitchWins() == 1);//increased+1
        Assert.assertTrue(game.getStayWins() == 0);

        gameResetCounter();

        game.countResult(winningBox, winningBox);//staying wins
        Assert.assertTrue(game.getSwitchWins() == 0);
        Assert.assertTrue(game.getStayWins() == 1);//increased+1

        gameResetCounter();

        game.countResult(loosingBox, winningBox);//switching wins
        Assert.assertTrue(game.getSwitchWins() == 1);//increased+1
        Assert.assertTrue(game.getStayWins() == 0);//does not increase

        gameResetCounter();

        game.countResult(winningBox, loosingBox);//staying wins
        Assert.assertTrue(game.getSwitchWins() == 0);//does not increase
        Assert.assertTrue(game.getStayWins() == 1);//increase +1

        gameResetCounter();

        Box anotherLoosingBox = new Box(2);//staying wins
        game.countResult(loosingBox, anotherLoosingBox);
        Assert.assertTrue(game.getSwitchWins() == 0);//does not increase
        Assert.assertTrue(game.getStayWins() == 1);//increase +1

        gameResetCounter();

        game.countResult(anotherLoosingBox, anotherLoosingBox);//switching wins
        Assert.assertTrue(game.getSwitchWins() == 1);//increased+1
        Assert.assertTrue(game.getStayWins() == 0);//does not increase
    }

    private void gameResetCounter() {
        game.setSwitchWins(0);
        game.setStayWins(0);
    }
}