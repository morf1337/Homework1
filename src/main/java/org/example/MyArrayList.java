package org.example;

import java.util.Arrays;
import java.util.Collection;

/*
Реализовать свой ArrayList.
 Методы, обязательные к реализации:
- добавить элемент: add(T element),
- добавить элемент: по индексу: add(int index, T element),
- получить элемент: get(int index),
- удалить элемент remove(int index),
- очистить всю коллекцию: clear(),
- отсортировать sort() и (или) sort(Comparator<T> comparator),
остальное по желанию.

4. Реализовать алгоритм quicksort для реализованного вами ArrayList.
Ваш QuickSort должен принимать список любого типа и сортировать его. Использовать:
○ Java generics
○ Comparable, Comparator

5. Документировать код. Что, зачем и как. Все классы и интерфейсы должны быть
задокументированы на уровне класса (class-level javadoc). Все публичные
методы ваших реализаций должны содержать javadoc. Документация должна
быть в полном объёме и представлять исчерпывающее и интуитивно понятное
руководство пользования вашим кодом для другого разработчика.

6. Все части кода должны быть покрыты Unit тестами.
7. Необходимо убедиться, что тесты запускаются с различными типами данных и большим количеством данных.
*/

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

    public void add(E element) {
        if (size == capacity) {
            realloc();
        }
        array[size] = element;
        size++;
    }

    public void add(int index, E element) {
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

    public E get(int index) {
        if (index > capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

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

    public void clear() {
        size = 0;
        capacity = 10;
        E[] newArray = (E[]) new Object[capacity];
        array = newArray;
    }

    private void realloc() {
        capacity *= 2;
        E[] newArray = (E[]) new Object[capacity];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
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
