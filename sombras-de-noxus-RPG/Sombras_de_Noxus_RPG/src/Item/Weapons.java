package Item;

import Enums.ClassType;
import Enums.ItemType;

public class Weapons extends Item{
    public ClassType ableToUse;

    public Weapons(String name, ItemType type, int effect, ClassType ableToUse) {
        super(name, type, effect);
        this.ableToUse = ableToUse;
    }
}
