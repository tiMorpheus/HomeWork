package com.task11;

import com.timorpheus.task11.A;
import com.timorpheus.task11.PhantomFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class Task11Test {
    PhantomFactory factory;
    List<A> listA;

    @Before
    public void init() {
        factory = PhantomFactory.getInstance(10);

        listA = new ArrayList<>();

    }

    @Test
    public void loadTest() throws InterruptedException {

        for (int i = 0; i < 20; i++) {
            factory.loadA();
            System.out.println(factory.getCount());
        }


    }
}
