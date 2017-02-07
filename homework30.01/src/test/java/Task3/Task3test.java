package Task3;

import org.junit.Test;

import static com.timorpheus.task3.Karatzuba.karatsubaMultiplication;
import static org.junit.Assert.assertEquals;

public class Task3test {


    @Test
    public void testKaratsubaMultiplication() throws Exception {
        long first = 56112111,
                second = 12611;

        assertEquals(karatsubaMultiplication(first, second), first * second);
    }


}
