package com.flexhamp.part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://hashsum.ru/anagrammy/
//134ms
//15.62Mb
public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final char[] a = reader.readLine().toCharArray();
        final char[] b = reader.readLine().toCharArray();

        if (a.length != b.length)
            System.out.println(0);
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.equals(a, b) ? 1 : 0);
    }
}
