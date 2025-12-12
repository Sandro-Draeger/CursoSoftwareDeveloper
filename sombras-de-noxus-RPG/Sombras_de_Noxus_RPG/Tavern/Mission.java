package Tavern;
import java.util.Scanner;
import Character.Hero;

public class Mission extends Tavern{

    public static void missionMenu(Hero hero){
        Scanner input = new Scanner(System.in);
        System.out.println("Great warrior " + hero.getName() + ", the path awaits. Choose your next journey.");
        int choice = input.nextInt();

        switch (choice) {

            case 1: // Mission 1 TODO: Desenhar cada sala e suas sequencias de eventos.
                // código da missão 1
                break;

            case 2: // Mission 2
                // código da missão 2
                break;

            case 3: // Mission 3
                // código da missão 3
                break;

            case 4: // Mission 4
                // código da missão 4
                break;

            case 5: // Mission 5
                // código da missão 5
                break;

            case 6: // Mission 6
                // código da missão 6
                break;

            case 7: // Mission 7
                // código da missão 7
                break;

            default:
                System.out.println("Invalid choice, great warrior. Choose a valid journey.");
                break;
        }

    }
}
