package flexhamp.example2;

import com.flexhamp.models.Animal;

public class CheckTraitImpl implements CheckTrait {
    @Override
    public boolean test(Animal animal) {
        return animal.canHop();
    }
}
