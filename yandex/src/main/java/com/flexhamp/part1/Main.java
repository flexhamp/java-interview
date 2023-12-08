package com.flexhamp.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String J = reader.readLine();
        String S = reader.readLine();

        final long count = S.chars().filter(v -> J.indexOf(v) >= 0).count();
        System.out.println(count);
    }
}
