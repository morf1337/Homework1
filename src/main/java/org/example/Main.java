package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyArrayList<Integer> sample = new MyArrayList<>(Arrays.asList(10, 20, 30));
//        sample.add(12);
        System.out.println(sample.size());
        System.out.println(sample);
    }
}