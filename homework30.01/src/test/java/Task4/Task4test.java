package Task4;

import com.timorpheus.task4.Evklid;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static com.timorpheus.task4.Evklid.gcd;

public class Task4test {

    @Test
    public void equalsValues() throws Exception{
        assertEquals(3, gcd(3,3));
    }

    @Test
    public void borderValuesTest() throws Exception {
        assertEquals(0, gcd(0, 0));
        assertEquals(5, gcd(0, -5));
        assertEquals(5, gcd(-5, 0));
        assertEquals(10, gcd(0, 10));
        assertEquals(10, gcd(10, 0));
    }

    @Test
    public void negativeValuesTest() throws Exception {

        assertEquals(5, gcd(-5, -5));
        assertEquals(5, gcd(-5, 5));
        assertEquals(5, gcd(5, -5));

    }


    @Test
    public void nodTest() throws Exception {

        assertEquals(4, gcd(88, 36));
        assertEquals(88, gcd(88, 88));
    }
}
