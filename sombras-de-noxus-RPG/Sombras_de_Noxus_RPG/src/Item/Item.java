package Item;

import Enums.ItemType;

public abstract class Item {
    protected String name;
    protected ItemType type;
    protected int effect;

    public Item(String name, ItemType type, int effect) {
        this.name = name;
        this.type = type;
        this.effect = effect;
    }
}
