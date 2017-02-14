package task8;

import com.timorpheus.task8and9.MySingleList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleListTest {

    MySingleList<Integer> list;

    @Before
    public void init() {
        list = new MySingleList<>();
    }

    @Test
    public void isEmptyTest(){
        assertEquals(true, list.isEmpty());
        list.add(10);
        assertEquals(false, list.isEmpty());
    }

    @Test
    public void addTest(){
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("1 2 3 ", list.toString());
        assertEquals(3, list.size());
    }

    @Test
    public void sizeTest() {
        assertEquals(0, list.size());
        list.add(10);
        assertEquals("10 ", list.toString());
        assertEquals(1, list.size());
    }

    @Test
    public void addByIndexZeroPositionTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("1 2 3 ", list.toString());
        list.add(0, 0);
        assertEquals("0 1 2 3 ", list.toString());
        assertEquals(4, list.size());
    }

    @Test
    public void addByRandomIndexPositionTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("1 2 3 ", list.toString());
        list.add(2, 21);
        assertEquals("1 2 21 3 ", list.toString());
        assertEquals(4, list.size());
    }

    @Test
    public void removeZeroTest(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        assertEquals(2, list.size());
        assertEquals("2 3 ", list.toString());
    }

    @Test
    public void removeTest(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(2, list.size());
        assertEquals("1 3 ", list.toString());
    }

    @Test
    public void removeTailTest(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assertEquals(2, list.size());
        assertEquals("1 2 ", list.toString());
    }

    @Test
    public void getTest(){
        list.add(1);
        list.add(2);
        list.add(3);
        Integer i = list.get(2);
        assertEquals(3, i.intValue());
    }

    @Test
    public void setTest(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(1, 21);
        assertEquals("1 21 3 ", list.toString());
    }

    @Test
    public void clearTest(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertEquals(0, list.size());
        assertEquals("", list.toString());
    }

    @Test
    public void indexOfTest(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(5);

        assertEquals(4, list.indexOf(5));
    }

    @Test
    public void containsTest(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(5);

        assertEquals(true, list.contains(5));
    }

    @Test
    public void combinateTest(){

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.remove(3);
        assertEquals("1 2 3 5 ", list.toString());
        list.remove(3);
        assertEquals("1 2 3 ", list.toString());
        list.add(3, 10);
        assertEquals("1 2 3 10 ", list.toString());
        list.add(0, -1);
        assertEquals("-1 1 2 3 10 ", list.toString());
    }



}
