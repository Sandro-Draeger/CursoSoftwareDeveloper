package Character;
import Enums.ClassType;
import java.util.Scanner;

public abstract class Hero extends Entity {
    public ClassType player;
    public String specialAbility;
    public int abilityDamage;

    public Hero(String name, int hp, int attack, ClassType player, String specialAbility, int abilityDamage) {
        super(name, hp, attack);
        this.player = player;
        this.specialAbility = specialAbility;
        this.abilityDamage = abilityDamage;
    }

    public void heroDetails(){
        System.out.println("============STATUS============");
        System.out.println("* "+this.player);
        System.out.println("* "+this.hp+" (hp)");
        System.out.println("* "+this.attack+" (atk)");
        System.out.println("* "+this.specialAbility+" (special attack)");
        System.out.println("* "+this.abilityDamage+" (special damage)");
        System.out.println("==============================");
    }

    // Função para definir a classe do personagem para o restante do game através de um imput do player.
    public static Hero chooseCharacter() {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose your warrior:");
        System.out.println("[1] - Legionnaire");
        System.out.println("[2] - Bloody Mage");
        System.out.println("[3] - Crimson Archer");
        System.out.println("[4] - Vanguard");

        int choose = input.nextInt();

        switch (choose) {
            case 1:
                System.out.println("You chose the Legionnaire!");
                return new Legionnaire();
            case 2:
                System.out.println("You chose the Bloody Mage!");
                return new BloodyMage();
            case 3:
                System.out.println("You chose the Crimson Archer!");
                return new CrimsonArcher();
            case 4:
                System.out.println("You chose the Red Bastion!");
                return new RedBastion();
            default:
                System.out.println("Invalid option, try again.\n");
                return chooseCharacter();
        }


    }
    // função para que o usuário possa personalizar seu nickName no jogo
    public void chooseYourName(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nNow brave hero, tell us the name that shall echo through legends:");
        String newName = input.next();
        setName(newName);
        System.out.println("Welcome! "+this.name+"! Your journey begins now.\n");
    }


}

