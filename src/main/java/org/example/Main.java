package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyArrayList<Integer> sample = new MyArrayList<>(Arrays.asList(10, 20, 30, 40));
        System.out.println(sample);
        sample.add(12);
        System.out.println(sample);
        sample.add(3, 3);
        System.out.println(sample);
        sample.remove(2);
        System.out.println(sample);
        for (int i = 0; i < 10; i++) {
            sample.add(2);
        }
        System.out.println(sample);
        List<Integer> librarylist = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        System.out.println(librarylist);
    }
}