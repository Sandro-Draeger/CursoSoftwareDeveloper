package Character;

import Enums.ClassType;
import java.util.Scanner;

public class Main {
    static void main() {
        Hero bloodyMage = new Hero("Bloody Mage", 250, 40, ClassType.BLOODMAGE);
        Hero crimsonArcher = new Hero("Crimson Archer", 250, 40, ClassType.CRIMSONARCHER);
        Hero legionnaire = new Hero("Legionnaire", 250, 40, ClassType.LEGIONNAIRE);
        Hero vanguard = new Hero("Vanguard", 250, 40, ClassType.VANGUARD);
    }

    public Hero choiceCharacter(){
        Scanner input = new Scanner(System.in);

        int character = input.nextInt();
        System.out.println("Choose your warrior:");
        System.out.println("[1] - Legionnaire;");
        System.out.println("[2] - Bloody Mage;");
        System.out.println("[3] - Crimson Archer;");
        System.out.println("[4] - Vanguard;");
        switch (character){
            case 1:
                System.out.println("You choose the Legionnaire!");
        }
        return null;
    }
}
