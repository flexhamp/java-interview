package com.flexhamp.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//Подсчет повторяющихся символов
public class CountingRepeatedCharacters {
    public static void main(String[] args) {
        System.out.println(countDuplicateCharacters2("3425gn5 36354 4536545446577u6u56 65475467"));
    }

    public static Map<Character, Integer> countDuplicateCharacters(String s) {
        HashMap<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }

    public static Map<Character, Long> countDuplicateCharacters2(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}
