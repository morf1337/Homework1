package org.example;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E> {
    private int size = 0;
    private int capacity = 10;
    private E[] array;
    public MyArrayList() {
        array = (E[]) new Object[capacity];
    }

    public MyArrayList(Collection<? extends E> c) {
        size = c.size();
        if (size >= 10) {
            capacity = size * 2;
        }
        array = (E[]) new Object[capacity];
        int i = 0;
        for (E item : c) {
            array[i] = item;
            i++;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "size=" + size +
                ", capacity=" + capacity +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
