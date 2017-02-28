package com.task13;

import com.timorpheus.task13.QuickSort;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {


    QuickSort<Integer> quickSort;

    List<Integer> list;

    @Before
    public void setUp() {
        list = new ArrayList<>();
        quickSort = new QuickSort<>();

        list.add(10);
        list.add(5);
        list.add(7);
        list.add(1);
        list.add(3);

    }

    @Test
    public void sortTest() {
        list = quickSort.sort(list, Integer::compareTo);
        assertEquals("[1, 3, 5, 7, 10]", list.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullListElementTest() {
        quickSort.sort(null, Integer::compareTo);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullSizeListElementTest() {
        list.clear();
        quickSort.sort(list, Integer::compareTo);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullComparatorTest() {
        quickSort.sort(list, null);
    }
}
