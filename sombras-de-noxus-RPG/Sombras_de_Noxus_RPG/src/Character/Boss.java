package src.Character;

public class Boss extends Entity{
    public int difficulty;

    public Boss(String name, int hp, int attack, int difficulty) {
        super(name, hp, attack);
        this.difficulty = difficulty;
    }
}

