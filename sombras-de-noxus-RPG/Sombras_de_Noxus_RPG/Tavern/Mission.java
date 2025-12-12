package Tavern;
import java.util.Scanner;
import Character.Hero;
import Character.NPC;

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

    public static void startBattle(Hero hero, NPC enemy) {
        Scanner sc = new Scanner(System.in);
        boolean battleOver = false;

        System.out.println("A wild " + enemy.getName() + " appeared!");

        while (!battleOver) {
            System.out.println("\n--- Battle Menu ---");
            System.out.println("1. Attack");
            System.out.println("2. Special Ability");
            System.out.println("3. Use Potion");
            System.out.println("4. Flee");
            System.out.print("Choose your action: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Attack
                    hero.attackEnemy(enemy);
                    break;

                case 2: // Special Ability
                    hero.useSpecialAtk(enemy);
                    break;

                case 3: // Use Potion
              //TODO: adicionar uso de poçoes
                    break;

                case 4: // Flee
                    System.out.println("You run from battle! Coward!");
                    battleOver = true;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
            
            if (enemy.getHp() <= 0) {
                System.out.println("You defeated " + enemy.getName() + "!");
                battleOver = true;
            }


            hero.takeDamage(enemy.getAttack());
            if (hero.getHp() <= 0) {
                System.out.println("You have been defeated!");
                battleOver = true;
            }
        }
    }
}


