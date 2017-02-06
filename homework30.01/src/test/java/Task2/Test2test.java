package Task2;

import com.timorpheus.task2.Task2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Test2test {

    @Test
    public void exceptionTesting() {

        int number = 5555; //1010110110011

        try {
            new Task2().changeBit(33, 0, number);
        } catch (IllegalArgumentException e) {
            assertEquals("bit position not available", e.getMessage());
        }

        try {
            new Task2().changeBit(32, 3, number);
        } catch (IllegalArgumentException e) {
            assertEquals("value of bit to change not available", e.getMessage());
        }
    }

    @Test
    public void testChangeBitOnPosition() throws Exception {
        int number = 5555; //1010110110011

        assertEquals(Integer.toBinaryString(new Task2().changeBit(8, 0, number)), "1010100110011");
        assertEquals(Integer.toBinaryString(new Task2().changeBit(8, 1, number)), "1010110110011");

    }


}
