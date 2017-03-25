package timur.hashtabel;

import org.junit.Before;
import org.junit.Test;
import timur.hashtable.MyHashTable;

import java.util.Hashtable;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class MyTest {


    MyHashTable<Integer,Integer> table;

//    Hashtable<Integer,Integer> table;
    @Before
    public void setUp(){
        table = new MyHashTable<>();

//        table = new Hashtable<>();
    }


    @Test
    public void putTest(){

        table.put(1,1);
        table.put(2,1);
        table.put(3,1);
        table.put(3,1);

        assertEquals(3, table.size());
    }


    @Test
    public void getTest(){

        table.put(10, 20);
        table.put(20, 30);


        assertEquals(20 , (Object) table.get(10));
        assertEquals(null , (Object) table.get(0));
    }


    @Test
    public void remoteTest(){

        table.put(1,1);
        table.put(2,1);
        table.put(3,1);
        table.put(3,1);

        table.remote(3);

        assertEquals(2, table.size());
    }


}
