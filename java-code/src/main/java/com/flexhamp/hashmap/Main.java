package com.flexhamp.hashmap;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.util.HashMap;public class Main {
    public static void main(String[] args) {
//        System.out.println(VM.current().details());

        HashMap<String,String> map = new HashMap<>(64, 0.8F);
        System.out.println(ClassLayout.parseInstance(map).toPrintable());

        for (int i = 0; i < 25; i++) {
            map.put(String.valueOf(i),String.valueOf(i));
            System.out.println(ClassLayout.parseInstance(map).toPrintable());
            System.out.println();
        }

        System.out.println(GraphLayout.parseInstance(map).toFootprint());
//
//
//        stringStringHashMap.put("", "");
//        stringStringHashMap.put("1", "");
//        stringStringHashMap.put("2", "");
        System.out.println("tttt");
//
//        System.out.println(ClassLayout.parseInstance(stringStringHashMap).toPrintable());
//        System.out.println(GraphLayout.parseInstance(stringStringHashMap).toFootprint());
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    static final int hash(int hashCode) {
        int h;
        return (h = hashCode) ^ (h >>> 16);
    }
}
