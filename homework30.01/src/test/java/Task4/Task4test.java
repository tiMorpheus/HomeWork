package Task4;

import com.tiMorpheus.task4.Task4;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task4test {


    @Test
    public void nodTest() throws Exception{

        assertEquals(new Task4().nod(88, 36),4);
    }
}
