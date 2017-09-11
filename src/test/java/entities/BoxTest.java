package entities;


import org.junit.Assert;
import org.junit.Test;

public class BoxTest {

    private final int maxBoxes = 3;

    @Test
    public void testGetListOfBoxes() {
        Assert.assertEquals(maxBoxes, Box.getListOfBoxes().size());
    }


}