package com.flexhamp.models;

import java.util.Objects;

public record Animal(String species, boolean canHop, boolean canSwim, int age) {

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", canHop=" + canHop +
                ", canSwim=" + canSwim +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (canHop != animal.canHop) return false;
        if (canSwim != animal.canSwim) return false;
        return Objects.equals(species, animal.species);
    }

}
