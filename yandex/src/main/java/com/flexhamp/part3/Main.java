package com.flexhamp.part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String tail = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            final int rows = Integer.parseInt(reader.readLine());
            for (int i = 0; i < rows; i++) {
                String s = reader.readLine();
                if (!s.equals(tail)) {
                    System.out.println(s);
                    tail = s;
                }
            }
        } catch (Exception ignored) {
        }
    }
}
