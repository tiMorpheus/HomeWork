package task17;

import org.junit.Before;
import org.junit.Test;
import timur.task17.Component;
import timur.task17.TreeFactory;

import static org.junit.Assert.assertEquals;

public class PolishTest {

    Component component;

    @Before
    public void setUp(){
    component = TreeFactory.getCalculateTree("( 1 + 2 ) * 4 + 5 * ( 3 + 6 )");
    }

    @Test
    public void test(){
        assertEquals(57, component.calculate());
    }
}
