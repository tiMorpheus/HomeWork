package Task4;

import org.junit.Test;

import static com.timorpheus.task4.Evklid.gcd;
import static org.junit.Assert.assertEquals;

public class EvklidTest {

    @Test
    public void equalsValues() throws Exception{
        assertEquals(3, gcd(3,3));
    }
    
    @Test
    public void maxValueTest() throws Exception{
        assertEquals(Integer.MAX_VALUE, gcd(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(1, gcd(Integer.MAX_VALUE,1));
        assertEquals(1, gcd(1, Integer.MAX_VALUE));
    }

    @Test
    public void borderValuesTest() throws Exception {
        assertEquals(0, gcd(0, 0));
        assertEquals(5, gcd(0, -5));
        assertEquals(5, gcd(-5, 0));
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
