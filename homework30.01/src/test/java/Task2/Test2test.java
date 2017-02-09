package Task2;

import com.timorpheus.task2.ChangeBit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Test2test {

    @Test(expected = IllegalArgumentException.class)
    public void inncorectPositionChangingTest() {



        new ChangeBit().changeBit(33, 0, 5555);
    }

    @Test(expected = IllegalArgumentException.class)
    public void incorrectValueOfBitTest(){
        new ChangeBit().changeBit(32, 3, 5555);
    }

    @Test
    public void testChangeBitOnPosition() throws Exception {
        int number = 5555; //1010110110011

        assertEquals(Integer.toBinaryString(new ChangeBit().changeBit(8, 0, number)), "1010100110011");
        assertEquals(Integer.toBinaryString(new ChangeBit().changeBit(8, 1, number)), "1010110110011");

    }


}
