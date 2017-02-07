package Task4;

import com.timorpheus.task4.Evklid;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task4test {


    @Test
    public void nodTest() throws Exception{

        assertEquals(new Evklid().nod(88, 36),4);
    }
}
