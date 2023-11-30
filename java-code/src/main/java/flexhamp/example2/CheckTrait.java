package flexhamp.example2;

import com.flexhamp.models.Animal;

@FunctionalInterface
public interface CheckTrait {
    boolean test(Animal animal);
}
