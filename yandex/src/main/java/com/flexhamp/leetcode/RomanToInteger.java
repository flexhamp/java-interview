package com.flexhamp.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */
public class RomanToInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        final char[] chars = s.toCharArray();
        int res = 0;
        int tail = 0;
        for (char aChar : chars) {
            int curr = getInt(aChar);
            if (tail == 1) {
                if (curr == 5) {
                    res += 3;
                } else if (curr == 10) {
                    res += 8;
                } else {
                    res += curr;
                }
            } else if (tail == 10) {
                if (curr == 50) {
                    res += 30;
                } else if (curr == 100) {
                    res += 80;
                } else {
                    res += curr;
                }
            } else if (tail == 100) {
                if (curr == 500) {
                    res += 300;
                } else if (curr == 1000) {
                    res += 800;
                } else {
                    res += curr;
                }
            } else {
                res += curr;
            }
            tail = curr;
        }
        return res;
    }

    private static int getInt(char c) {
        if (c == 'I')
            return 1;
        if (c == 'V')
            return 5;
        if (c == 'X')
            return 10;
        if (c == 'L')
            return 50;
        if (c == 'C')
            return 100;
        if (c == 'D')
            return 500;
        if (c == 'M')
            return 1000;
        return 0;
    }
}
