package task8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExceptionsTest extends SingleListTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void addIncorrectIndexTest() {

        list.add(1, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addIncorrectIndex2Test() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(4, -2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeIncorrectIndexTest() {

        list.remove(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeIncorrectIndex2Test() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(3);
    }

    @Test
    public void indexOfTest() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(-1, list.indexOf(12));
    }

    @Test
    public void indexOf2Test() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(-1, list.indexOf(null));
    }

    @Test
    public void containsOfTest() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(false, list.contains(null));
    }

}
