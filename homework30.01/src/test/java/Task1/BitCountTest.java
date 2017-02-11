package Task1;

import com.timorpheus.task1.BitOperation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BitCountTest {

    @Test
    public void testCountByte() throws Exception {

        int amountOfBites = new BitOperation().countByte();
        assertEquals(8, amountOfBites);
    }

    @Test
    public void testCountShort() throws Exception {

        int amountOfBites = new BitOperation().countShort();
        assertEquals(16, amountOfBites);
    }

    @Test
    public void testCountInt() throws Exception {

        int amountOfBites = new BitOperation().countInt();
        assertEquals(32, amountOfBites);
    }

    @Test
    public void testCountLong() throws Exception {

        int amountOfBites = new BitOperation().countLong();
        assertEquals(64, amountOfBites);
    }
}
