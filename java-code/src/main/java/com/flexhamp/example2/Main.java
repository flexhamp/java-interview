package com.flexhamp.example2;

import com.flexhamp.models.Animal;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = List.of(
                new Animal("fish", false, true, 0),
                new Animal("kangaroo", true, false, 0),
                new Animal("rabbit", true, false, 0),
                new Animal("turtle", false, true, 0)
        );


        print(animals, new CheckTraitImpl());
    }

    private static void print(List<Animal> animals, CheckTraitImpl checkTrait) {
        animals.stream().filter(checkTrait::test).toList().forEach(System.out::println);
    }
}
