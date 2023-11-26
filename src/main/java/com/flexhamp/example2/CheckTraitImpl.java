package com.flexhamp.example2;

public class CheckTraitImpl implements CheckTrait {
    @Override
    public boolean test(Animal animal) {
        return animal.isCanHop();
    }
}
