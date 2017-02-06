package Task1;

import com.timorpheus.task1.Task1;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task1test {

    @Test
    public void testCountByte() throws Exception {

        int amountOfBites = new Task1().countByte();
        assertEquals(8, amountOfBites);
    }

    @Test
    public void testCountShort() throws Exception {

        int amountOfBites = new Task1().countShort();
        assertEquals(16, amountOfBites);
    }

    @Test
    public void testCountInt() throws Exception {

        int amountOfBites = new Task1().countInt();
        assertEquals(32, amountOfBites);
    }

    @Test
    public void testCountLong() throws Exception {

        int amountOfBites = new Task1().countLong();
        assertEquals(64, amountOfBites);
    }
}
