package Task2;

import org.junit.Test;

import static com.timorpheus.task2.ChangeBit.changeBit;
import static org.junit.Assert.assertEquals;


public class ChangeBitTest {

    @Test(expected = IllegalArgumentException.class)
    public void incorrectPositionChangingTest() {
        changeBit(33, 0, 5555);
        changeBit(33,0, 5555);
    }

    @Test(expected = IllegalArgumentException.class)
    public void incorrectValueOfBitTest(){
        changeBit(32, 3, 5555);
    }

    @Test
    public void changeBitOnPositionTest() throws Exception {
        int number = 5555; //1010110110011

        assertEquals(Integer.toBinaryString(changeBit(8, 0, number)), "1010100110011");
        assertEquals(Integer.toBinaryString(changeBit(8, 1, number)), "1010110110011");
    }
}
