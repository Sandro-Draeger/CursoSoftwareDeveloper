package Character;
import java.util.Scanner;
import Enums.ClassType;

public class Legionnaire extends Hero {
    public String specialAbility;
    public int abilityDamage;

    public Legionnaire(String name, int hp, int attack, ClassType player, String specialAbility, int abilityDamage) {
        super(name, hp, attack, player);
        this.specialAbility = specialAbility;
        this.abilityDamage = abilityDamage;
    }

    public Legionnaire() {
        super("Legionnaire", 120, 15, ClassType.LEGIONNAIRE);
        this.specialAbility = "Long Sword";
        this.abilityDamage = 50;
    }

    @Override
    public void heroDetails() {
        super.heroDetails();
        System.out.println("Special Ability: "+this.specialAbility+" with "+this.abilityDamage+" damage");
        System.out.println("========================\n");
    }




}
