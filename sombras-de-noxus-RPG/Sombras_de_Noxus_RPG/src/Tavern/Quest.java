package Tavern;

import java.util.Scanner;

import Character.Hero;
import Character.NPC;
import Item.Item;
import helper.GameHelper;

import java.util.Scanner;


public abstract class Quest extends Tavern {

    public static void questMenu(Hero hero) {
        Scanner input = new Scanner(System.in);
        System.out.println("Great warrior " + hero.getName() + ", the path awaits. Choose your next journey.");
        GameHelper.printNoxusMap();
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

    public static boolean startBattle(Hero hero, NPC enemy) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        boolean battleOver = false;
        boolean playerWin = false;
        int heroMaxHp = hero.getHp();
        int enemyMaxHp = enemy.getHp();

        System.out.println("\n===================================");
        System.out.println("           A BATTLE BEGINS");
        System.out.println("===================================");
        System.out.println("A wild " + enemy.getName() + " appeared!\n");

        while (!battleOver) {

            System.out.println("----------- STATUS -----------");
            System.out.println("Hero HP:  " + hero.getHp() + " / " + heroMaxHp + "max");
            System.out.println("Enemy HP: " + enemy.getHp() + " / " + enemyMaxHp + "max");
            System.out.println("--------------------------------\n");

            //Player Turn
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
                    System.out.println("You use " + hero.specialAbility);
                    hero.useSpecialAtk(enemy);
                    break;

                case 3:
                    hero.useConsumable();
                    break;

                case 4:
                    System.out.println("You have run from the battle.");
                    battleOver = true;
                    Quest.questMenu(hero); //TODO: Quando o usuario estiver dentro da Quest, tiro ele da luta mas mantenho na missao.
                    return playerWin;

                default:
                    System.out.println("Invalid choice!");
            }

            if (enemy.getHp() <= 0) {
                System.out.println("\nYou have defeated " + enemy.getName() + "!");
                System.out.println("===================================");
                battleOver = true;
                playerWin = true;
                return playerWin;
            }

            //Enemy Turn
            System.out.println("\nWaiting for enemy response...");
            Thread.sleep(1000);


            if (Math.random() < 0.20) {
                enemy.useSpecialAtk(hero);
            } else {
                enemy.attackEnemy(hero);
            }

            Thread.sleep(1000);

            if (hero.getHp() <= 0) {
                System.out.println("\nYou have been defeated...");
                System.out.println("===================================");
                battleOver = true;
            }

            System.out.println("-------------------------------------\n");
        }
        return playerWin;
    }


    //quest01
    public static void borderOfNoxus(Hero hero, NPC enemy1, NPC enemy2, Shop shop) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        boolean startedQuest = false; //validação se chegou a iniciar a quest.
        boolean endedQuest = false; //validação se completou a quest ou nao.
        int fullHp = hero.getHp();

        //if and else para mudar a msg
        if (startedQuest) {
            System.out.println("You return to the dusty roads of Noxus. The sky still hangs heavy and dark, and the wind smells of iron and gunpowder. The memory of your previous defeat lingers, but the bandits are still out there. Steel yourself; this time, survival depends on sharper wits and greater courage.\n");
        } else {
            System.out.println("You advance along the dusty roads of Noxus. The sky is heavy and dark, and the wind carries the scent of iron and gunpowder. Rumors speak of bandits attacking unwary travelers. Prepare yourself; survival depends on speed and cunning.\n");
        }

        System.out.println("You reach a fork in the road. Which path will you take?");
        System.out.println("[1] Left | [2] Right | [3] Straight ahead\n");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("You are caught off guard by a Noxian vandal! You take 30 damage.");
                hero.takeDamage(30);
                System.out.println("Current HP: " + hero.getHp() + "\n");
                break;
            case 2:
                System.out.println("You encounter a wounded villager. Do you help him?");
                System.out.println("[1] Yes | [2] No");
                int option = input.nextInt();
                if (option == 1) {
                    System.out.println("The villager thanks you and rewards you with 50 Noxian Crowns.");
                    hero.addGold(50);
                } else {
                    System.out.println("The villager dies, but you continue on your journey.");
                }
                break;
            case 3:
                System.out.println("You find a small chest containing 15 Noxian Crowns.");
                hero.addGold(15);
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }

        //batalha contra o primeiro inimigo
        System.out.println("A rustle in the bushes catches your attention. " + enemy1.getName() + " emerges, quick and deadly. Prepare for battle!\n");

        startBattle(hero, enemy1);
        startedQuest = true;
        if (startBattle(hero, enemy1)) {
            System.out.println("Well done! You defeated the Bandit Scout. Your wounds are healed, and your journey continues.");
            hero.setHp(fullHp);
        } else {
            System.out.println("You fought bravely, but the Bandit Scout overpowered you. What will you do?");
            System.out.println("[1] Retry Battle | [2] Return to the Tavern");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    startBattle(hero, enemy1);
                    break;
                case 2:
                    tavernMenu(shop, hero);
                    break;
            }
        }
    }
}




