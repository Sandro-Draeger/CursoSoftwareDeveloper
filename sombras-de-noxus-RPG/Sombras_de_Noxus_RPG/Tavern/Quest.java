package Tavern;
import java.util.Scanner;
import Character.Hero;
import Character.NPC;

public abstract class Quest extends Tavern{

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

    public static void startBattle(Hero hero, NPC enemy) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        boolean battleOver = false;
        int heroMaxHp = hero.getHp();
        int enemyMaxHp = enemy.getHp();

        System.out.println("\n===================================");
        System.out.println("           A BATTLE BEGINS");
        System.out.println("===================================");
        System.out.println("A wild " + enemy.getName() + " appeared!\n");


        while (!battleOver) {

            System.out.println("----------- STATUS -----------");
            System.out.println("Hero HP:  " + hero.getHp() + " / " + heroMaxHp+"max");
            System.out.println("Enemy HP: " + enemy.getHp() + " / " + enemyMaxHp+"max");
            System.out.println("--------------------------------\n");

            System.out.println("----------- BATTLE MENU -----------");
            System.out.println("1. Attack");
            System.out.println("2. Special Ability");
            System.out.println("3. Use Potion");
            System.out.println("4. Run");
            System.out.print("Choose your action: ");

            int choice = sc.nextInt();

            System.out.println("\n-------------------------------------");

            switch (choice) {
                case 1:
                    System.out.println("You attack!");
                    hero.attackEnemy(enemy);
                    break;

                case 2:
                    System.out.println("You use "+hero.specialAbility);
                    hero.useSpecialAtk(enemy);
                    break;

                case 3:
                    hero.useConsumable();
                    break;

                case 4:
                    System.out.println("You have run from the battle.");
                    battleOver = true;
                    Quest.missionMenu(hero);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            System.out.println("\nWaiting for enemy response...");
            Thread.sleep(900);


            if (Math.random() < 0.20) {
                enemy.useSpecialAtk(hero);
            } else {
                enemy.attackEnemy(hero);
            }


            Thread.sleep(900);

            if (enemy.getHp() <= 0) {
                System.out.println("\nYou have defeated " + enemy.getName() + "!");
                System.out.println("===================================");
                battleOver = true;
            }

            if (hero.getHp() <= 0) {
                System.out.println("\nYou have been defeated...");
                System.out.println("===================================");
                battleOver = true;
            }

            System.out.println("-------------------------------------\n");
        }
    }
}


