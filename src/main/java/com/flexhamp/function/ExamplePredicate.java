package com.flexhamp.function;

import com.flexhamp.models.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//Используется для проверки того или иного условия
public class ExamplePredicate {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>(List.of(
                new Animal("fish", false, true, 12),
                new Animal("kangaroo", true, false, 5),
                new Animal("rabbit", true, false, 8),
                new Animal("turtle", false, true, 2),
                new Animal("umka", false, true, 4)
        ));

        Predicate<Animal> p1 = a -> a.age() > 6;
        //  Predicate  boolean test(T var1);
        animals.removeIf(p1);
        animals.removeIf(a -> a.age() > 6);
        animals.removeIf(Animal::canHop);

        //  default Predicate<T> and
        Predicate<Animal> p2 = a -> a.age() < 5;
        Predicate<Animal> p3 = a -> a.species().startsWith("f");
        animals.removeIf(p2.and(p3));

        Predicate<Animal> and = p2.and(p3);
        animals.removeIf(and);

        //  default Predicate<T> or
        Predicate<Animal> p4 = a -> a.age() < 5;
        Predicate<Animal> p5 = a -> a.species().startsWith("f");
        animals.removeIf(p4.or(p5));

        Predicate<Animal> or = p4.or(p5);
        animals.removeIf(or);

        //  default Predicate<T> negate
        var numbers = new ArrayList<>(List.of(-1, 4, 5, 0, 2));

        Predicate<Integer> pr1 = n -> n > 0;
        numbers.removeIf(pr1.negate());

        System.out.println(numbers);

        //  default Predicate<T> isEqual
        //  default Predicate<T> not

    }
}


