package com.task14;

import com.timorpheus.task14.ListUnion;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UnionTest {


    List<Integer> list1;
    List<Integer> list2;

    @Before
    public void setUp(){

        list1 = new ArrayList<>();
        list2 = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list1.add(i);
            list2.add(i+10);
        }
    }

    @Test
    public void unite(){
        List<Integer> result = ListUnion.getUnion(list2,list1, Integer::compareTo);

        for (Integer i : result){
            System.out.println(i);
        }
    }
}
