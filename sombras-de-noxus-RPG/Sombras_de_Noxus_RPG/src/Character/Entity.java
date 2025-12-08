package src.Character;

public abstract class Entity {
   protected String name;
   protected int hp;
   protected int attack;

    public Entity(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

}