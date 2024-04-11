package org.example;

import java.util.Comparator;
import java.util.List;

public class QuickSort {

    /**
     * Сортирует список из элементов, тип данных T которых реализует Comparable
     * @param list
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort(List<T> list) {
        sort(list, Comparable::compareTo);
    }

    /**
     * Сортирует список из элементов на основе переданного компаратора
     * @param list
     * @param comparator
     * @param <T>
     */
    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        if (list == null || list.size() <= 1) {
            return;
        }
        quickSort(list, 0, list.size() - 1, comparator);
    }

    private static <T> void quickSort(List<T> list, int left, int right, Comparator<T> comparator) {
        if (left < right) {
            int partitionIndex = partition(list, left, right, comparator);
            quickSort(list, left, partitionIndex - 1, comparator);
            quickSort(list, partitionIndex + 1, right, comparator);
        }
    }

    private static <T> int partition(List<T> list, int left, int right, Comparator<T> comparator) {
        T pivot = list.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, right);
        return i + 1;
    }

    private static <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
