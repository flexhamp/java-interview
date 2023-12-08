package com.flexhamp.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int result = 0;
        int v = 0;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            final int rows = Integer.parseInt(reader.readLine());
            for (int i = 0; i < rows; i++) {
                final int a = Integer.parseInt(reader.readLine());
                if (a == 1) {
                    v++;
                } else {
                    v = 0;
                }
                result = Math.max(v, result);

            }
        } catch (Exception ignored) {
        }
        System.out.println(result);
    }
}
