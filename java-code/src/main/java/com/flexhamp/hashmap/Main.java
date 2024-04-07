package com.flexhamp.hashmap;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.util.HashMap;public class Main {
    public static void main(String[] args) {
        System.out.println(tableSizeFor(7));
//        System.out.println(VM.current().details());
//
//        final HashMap<String,String> stringStringHashMap = new HashMap<>(10);
//
//        System.out.println(ClassLayout.parseInstance(stringStringHashMap).toPrintable());
//        System.out.println(GraphLayout.parseInstance(stringStringHashMap).toFootprint());
//
//
//        stringStringHashMap.put("", "");
//        stringStringHashMap.put("1", "");
//        stringStringHashMap.put("2", "");
//        System.out.println("tttt");
//
//        System.out.println(ClassLayout.parseInstance(stringStringHashMap).toPrintable());
//        System.out.println(GraphLayout.parseInstance(stringStringHashMap).toFootprint());
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        System.out.println(n);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
