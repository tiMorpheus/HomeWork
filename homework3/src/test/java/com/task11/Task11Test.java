package com.task11;

import com.timorpheus.task11.PhantomFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task11Test {
    PhantomFactory factory;

    @Before
    public void init(){
        factory = new PhantomFactory(10);


    }

    @Test
    public void loadTest() throws InterruptedException {

    factory.loadA(10);
    factory.loadA(20);
    factory.loadA(30);
    factory.loadA(40);
    factory.loadA(50);
    factory.loadA(60);
    factory.loadA(70);
    factory.loadA(80);
    factory.loadA(90);
    factory.loadA(100);
    factory.loadA(110);

    assertEquals(10,PhantomFactory.getCount());
    }
}
