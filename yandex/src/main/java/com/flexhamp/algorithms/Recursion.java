package com.flexhamp.algorithms;

public class Recursion {
    public static void main(String[] args) {
        final int N = 3;
        System.out.printf("Triangle(%s): %s", N, triangle(N));
    }

    public static int triangle(int n) {
        if (n == 0) return 0;
        if (n == 1) {
            return 1;
        } else {
            return n + triangle(n - 1);
        }
    }
}
