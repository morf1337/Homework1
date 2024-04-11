package org.example;

import java.util.*;

public class MyArrayList<T> {
    private int size = 0;
    private int capacity = 10;
    private Object[] array;

    public MyArrayList() {
        array = new Object[capacity];
    }

    public MyArrayList(Collection<? extends T> c) {
        size = c.size();
        if (size >= 10) {
            capacity = size * 2;
        }
        array = new Object[capacity];
        int i = 0;
        for (T item : c) {
            array[i] = item;
            i++;
        }
    }

    /**
     * возвращает текущее количество элементов списка(размер)
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * добавляет элемент в конец списка
     *
     * @param element
     */
    public void add(T element) {
        if (size == capacity) {
            realloc();
        }
        array[size] = element;
        size++;
    }

    /**
     * добавляет элемент в список по указанному индексу.
     * если по индексу есть элемент, весь массив элементов
     * начиная с этого индекса сдвигается вправо
     *
     * @param index
     * @param element
     */
    public void add(int index, T element) {
        if (index > capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size == capacity) {
            realloc();
        }
        if (array[index] != null) {
            for (int i = size; i >= index; i--) {
                array[i + 1] = array[i];
            }
        }
        array[index] = element;
        size++;
    }

    /**
     * возвращает элемент по указанному индексу
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index > capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) array[index];
    }


    /**
     * удаляет элемент по указанному индексу.
     * если удаляемый элемент не последний, сдвигает все элементы
     * старше от удаляемого на 1 позицию влево
     *
     * @param index
     */
    public void remove(int index) {
        if (index > capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == size) {
            array[index] = null;
        } else {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            array[size] = null;
        }
        if (size > 0) {
            size--;
        }
    }

    /**
     * полностью очищает содержимое списка
     */
    public void clear() {
        size = 0;
        capacity = 10;
        array = new Object[capacity];
    }

    /**
     * сортирует содержимое массива по переданному компаратору
     *
     * @param comparator
     */
    public void sort(Comparator<T> comparator) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add((T) array[i]);
        }
        QuickSort.sort(list, comparator);
        for (int i = 0; i < size; i++) {
            array[i] = list.get(i);
        }
    }

    private void realloc() {
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
