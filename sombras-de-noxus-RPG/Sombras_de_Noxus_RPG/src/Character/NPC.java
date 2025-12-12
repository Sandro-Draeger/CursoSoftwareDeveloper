package Character;

public class NPC extends Entity{
    public int difficulty;

    public NPC(String name, int hp, int attack, int difficulty) {
        super(name, hp, attack);
        this.difficulty = difficulty;
    }
}

