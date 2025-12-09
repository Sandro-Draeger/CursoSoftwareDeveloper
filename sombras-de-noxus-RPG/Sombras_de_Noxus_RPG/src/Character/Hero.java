package Character;

import Enums.ClassType;
import Item.Item;
import java.util.ArrayList;

public class Hero extends Entity {
    public ArrayList<Item> inventory;
    public ClassType player;

    public Hero(String name, int hp, int attack, ClassType player) {
        super(name, hp, attack);
        this.player = player;
    }

}

