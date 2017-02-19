package com.timorpheus.task14;

import java.util.*;

public final class ListUnion {

    private ListUnion() {
    }

    public static <E> List<E> getUnion(List<E> list1, List<E> list2, Comparator<E> comparator ){

        List<E> list = new ArrayList<>();
        list.addAll(list1);
        list.addAll(list2);
//        list.sort(comparator);
        Collections.sort(list, comparator);
        return list;
    }
}
