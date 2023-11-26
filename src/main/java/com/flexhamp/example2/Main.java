package com.flexhamp.example2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = List.of(
                new Animal("fish", false, true),
                new Animal("kangaroo", true, false),
                new Animal("rabbit", true, false),
                new Animal("turtle", false, true)
        );

        print(animals, new CheckTraitImpl());
    }

    private static void print(List<Animal> animals, CheckTraitImpl checkTrait) {
        animals.stream().filter(checkTrait::test).toList().forEach(System.out::println);
    }
}
