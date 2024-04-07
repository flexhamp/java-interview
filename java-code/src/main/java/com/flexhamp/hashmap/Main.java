package com.flexhamp.hashmap;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.util.HashMap;public class Main {
    public static void main(String[] args) {
        System.out.println(VM.current().details());

        final HashMap<String,String> stringStringHashMap = new HashMap<>();

        System.out.println(ClassLayout.parseInstance(stringStringHashMap).toPrintable());
        System.out.println(GraphLayout.parseInstance(stringStringHashMap).toFootprint());


        stringStringHashMap.put("", "");
        stringStringHashMap.put("1", "");
        stringStringHashMap.put("2", "");
        System.out.println("tttt");

        System.out.println(ClassLayout.parseInstance(stringStringHashMap).toPrintable());
        System.out.println(GraphLayout.parseInstance(stringStringHashMap).toFootprint());
    }
}
