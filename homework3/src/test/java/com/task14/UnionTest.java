package com.task14;

import com.timorpheus.task14.ListUnion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class UnionTest {


    List<Integer> list1;
    List<Integer> list2;
    Comparator<Integer> comparator;

    @Before
    public void setUp() {

        list1 = new ArrayList<>();
        list2 = new LinkedList<>();
        comparator = Integer::compareTo;
        for (int i = 0; i < 10; i++) {
            list1.add(i);
            list2.add(i + 10);
        }
    }

    @After
    public void clear() {
        list1.clear();
        list2.clear();
    }

    @Test
    public void unite() {

        List<Integer> result = (List<Integer>) ListUnion.getUnion(list2, list1, comparator);

        for (Integer i : result) {
            System.out.println(i);
        }
    }

    @Test
    public void nullTest() {
//        list1.clear();
        list2.clear();

        List<Integer> result = (List<Integer>) ListUnion.getUnion(list1, list2, comparator);

        for(Integer i : result){
            System.out.println(i);
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void nullComparatorTest() {
        List<Integer> result = (List<Integer>) ListUnion.getUnion(list2, list1, null);
    }

}
