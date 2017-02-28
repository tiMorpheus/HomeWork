package com.timorpheus.task14;

import java.util.*;

public final class ListUnion {

    private ListUnion() {
    }

    public static <E> List<? super E> getUnion(final List<? extends E> list1, List<? extends E> list2, final Comparator<? super E> comparator ){


        if(comparator == null){
            throw new IllegalArgumentException("Comparator cannot be null");
        }

        if (list1.isEmpty()){
            return new ArrayList<>(list2);
        } else if (list2.isEmpty()){
            return new ArrayList<>(list1);
        }

        List<E> list = new ArrayList<>();
        list.addAll(list1);
        list.addAll(list2);
        Collections.sort(list, comparator);

        return list;
    }

}
