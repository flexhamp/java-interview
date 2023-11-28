package com.flexhamp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final LinkedList<String> strings = new LinkedList<>();
        final ArrayList<String> strings1 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        test(list);
    }

    public static void test(List<? extends Number> list) {

    }
}