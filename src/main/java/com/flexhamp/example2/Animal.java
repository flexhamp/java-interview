package com.flexhamp.example2;

import java.util.Objects;

public class Animal {
    private final String species;
    private final boolean canHop;
    private final boolean canSwim;

    public Animal(String species, boolean canHop, boolean canSwim) {
        this.species = species;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isCanHop() {
        return canHop;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", canHop=" + canHop +
                ", canSwim=" + canSwim +
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

    @Override
    public int hashCode() {
        int result = species != null ? species.hashCode() : 0;
        result = 31 * result + (canHop ? 1 : 0);
        result = 31 * result + (canSwim ? 1 : 0);
        return result;
    }
}
