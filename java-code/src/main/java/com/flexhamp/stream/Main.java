package com.flexhamp.stream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        // Создание стрима

        // От коллекции
        Collection<Integer> list = new ArrayList<>();
        Stream<Integer> stream1 = list.stream();

        // Из массива
        int[] numbers = {1, 2, 3};
        final IntStream stream5 = Arrays.stream(numbers);
        Stream<Integer> stream2 = stream5.boxed();

        // Из файла
        Path path = Paths.get("file.txt");
        try (Stream<String> stream3 = Files.lines(path)) {

        }

        // Генерирование
        Stream<Integer> stream4 = Stream.generate(() -> new Random().nextInt());

        // Билдер
        Stream.Builder<Integer> builder = Stream.builder();
        builder.add(1);
        builder.add(2);
        builder.add(3);
        Stream<Integer> stream = builder.build();
    }


    private static <T> String listToString(List<T> list) {
        if (list == null)
            return null;
        return list.stream().map(Object::toString)
                .collect(Collectors.joining(","));
    }
}
