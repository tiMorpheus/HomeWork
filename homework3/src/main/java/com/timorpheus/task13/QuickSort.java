package com.timorpheus.task13;

import java.util.Comparator;
import java.util.List;

public class QuickSort<E> {

    private List<E> list;

    public QuickSort() {

    }

    public List<E> sort(List<E> list, Comparator<E> comparator) {
        this.list = list;

        if (list == null || list.size() == 0 || comparator == null) {
            throw new IllegalArgumentException();
        }

        return quicksort(0, list.size() - 1, comparator);
    }

    private List<E> quicksort(int low, int high, Comparator<E> comparator) {

        int left = low;
        int right = high;

        E center = list.get(low + (high - low) / 2);

        while (left <= right) {

            while (comparator.compare((list.get(left)), center) < 0) {
                left++;
            }

            while (comparator.compare((list.get(right)), center) > 0) {
                right--;
            }

            if (left <= right) {
                exchange(left, right);
                left++;
                right--;
            }
        }

        if (low < right)
            quicksort(low, right, comparator);
        if (left < high)
            quicksort(left, high, comparator);

        return list;
    }

    private void exchange(int i, int j) {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

}
