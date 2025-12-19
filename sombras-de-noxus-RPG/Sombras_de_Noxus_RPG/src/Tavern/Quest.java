package Tavern;

import java.util.Scanner;

import Character.Hero;
import Character.NPC;
import Item.Item;
import helper.GameHelper;

import java.util.Scanner;


public abstract class Quest extends Tavern {


    public static void questMenu(Hero hero, Shop shop) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Great warrior " + hero.getName() + ", the path awaits. Choose your next journey.");
        GameHelper.printNoxusMap();
        int choice = input.nextInt();

        switch (choice) {

            case 1: borderOfNoxus(hero, shop);
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

            case 7: tavernMenu(shop, hero);
                break;

            default:
                System.out.println("Invalid choice, great warrior. Choose a valid journey.");
                break;
        }
    }

    public static void startBattle(Hero hero, NPC enemy) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        boolean battleOver = false;



        System.out.println("\n===================================");
        System.out.println("           A BATTLE BEGINS");
        System.out.println("===================================");
        System.out.println("A wild " + enemy.getName() + " appeared!\n");

        while (!battleOver) {

            System.out.println("----------- STATUS -----------");
            System.out.println("Hero HP:  " + hero.getHp() + " / " + hero.getMaxHp() + "max");
            System.out.println("Enemy HP: " + enemy.getHp() + " / " + enemy.getMaxHp() + "max");
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
                    return;

                default:
                    System.out.println("Invalid choice!");
            }

            if (enemy.getHp() <= 0) {
                System.out.println("===================================");
                battleOver = true;
                break;
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
    }


    //quest01
    public static void borderOfNoxus(Hero hero, Shop shop) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        boolean startedQuest = false; //validação se chegou a iniciar a quest.
        boolean endedQuest = false; //validação se completou a quest ou nao.
        int fullHp = hero.getHp();

        //enemies
        NPC BanditScout = new NPC("Bandit Scout", 55, 55, 6, "quick stab", 10, 1);
        NPC BanditBruiser = new NPC("Bandit Bruiser", 90, 90, 10, "heavy punch", 18, 1);

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
                System.out.println("You are caught off guard by a Noxian vandal!");
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

        Thread.sleep(1000);



        //batalha contra o primeiro inimigo
        System.out.println("A rustle in the bushes catches your attention. " + BanditScout.getName() + " emerges, quick and deadly. Prepare for battle!\n");
        System.out.println("[1]Lets go! |[2] I prefer to run");
        choice = input.nextInt();
        switch (choice){
            case 1:
                startBattle(hero, BanditScout);
                startedQuest = true;
                if (hero.getHp()>0) {
                    System.out.println("Well done! You defeated the Bandit Scout. Your wounds are healed, and your journey continues.");
                    hero.setHp(fullHp);
                    break;
                } else {
                    System.out.println("You fought bravely, but the Bandit Scout overpowered you. What will you do?");
                    System.out.println("[1] Retry Battle | [2] Return to the Tavern");
                    choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            startBattle(hero, BanditScout);
                            break;
                        case 2:
                            tavernMenu(shop, hero);
                            break;
                    }
                }
            case 2: tavernMenu(shop, hero);
        }
        Thread.sleep(1000);

        if (startedQuest) {
            System.out.println(
                    "The road ahead feels different now. The air is thicker, and every step echoes with the memory of battles fought. "
                            + "You know stronger enemies lie ahead, and there will be no turning back this time.\n"
            );
        } else {
            System.out.println(
                    "You walk cautiously along a narrow path carved between broken stone and twisted iron. "
                            + "Whispers of something powerful ahead make your grip tighten around your weapon.\n"
            );
        }

        Thread.sleep(1000);

        System.out.println("The path splits once more. A strange tension hangs in the air. What do you do?");
        System.out.println("[1] Investigate the shadows | [2] Follow the distant noise | [3] Take a moment to prepare\n");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println(
                        "You step into the shadows, but a sudden trap snaps shut! Blades cut into your armor."
                );
                hero.takeDamage(35);
                System.out.println("Current HP: " + hero.getHp() + "\n");
                break;

            case 2:
                System.out.println(
                        "You follow the noise and find a dying soldier leaning against a broken banner."
                );
                System.out.println("[1] Offer aid | [2] Take what he has and leave");
                int option = input.nextInt();
                if (option == 1) {
                    System.out.println(
                            "With his last breath, the soldier hands you a pouch of Crowns."
                    );
                    hero.addGold(60);
                } else {
                    System.out.println(
                            "You take the pouch without a word. The soldier's eyes fade as you walk away."
                    );
                    hero.addGold(25);
                }
                break;

            case 3:
                System.out.println(
                        "You find a quiet spot to steady your breathing and find 20 Crowns."
                );
                hero.addGold(20);
                break;

            default:
                System.out.println("Your hesitation costs you precious time. Nothing happens.");
                break;
        }

        // batalha contra o boss final da missão 1
        System.out.println(
                "A heavy silence falls over the road. From the shadows steps "
                        + BanditBruiser.getName()
                        + ", towering and scarred, cracking his knuckles as he blocks your path.\n"
        );
        System.out.println("[1] Stand your ground | [2] Fall back to safety");

        choice = input.nextInt();
        switch (choice) {
            case 1:
                startBattle(hero, BanditBruiser);

                if (hero.getHp() > 0) {
                    System.out.println(
                            "Against all odds, you bring the Bandit Bruiser to his knees. "
                                    + "The road grows quiet once more. Your wounds are tended, and victory is yours."
                    );
                    hero.setHp(fullHp);
                    endedQuest = true;
                    Thread.sleep(1000);
                    questMenu(hero, shop);

                } else {
                    System.out.println(
                            "The Bandit Bruiser proves overwhelming. You collapse, beaten but not broken."
                    );
                    System.out.println("[1] Challenge him again | [2] Retreat to the Tavern");
                    choice = input.nextInt();

                    switch (choice) {
                        case 1:
                            startBattle(hero, BanditBruiser);
                            break;
                        case 2:
                            tavernMenu(shop, hero);
                            break;
                    }
                }
                break;

            case 2:
                System.out.println(
                        "You decide this is not the right moment. The Bandit Bruiser laughs as you retreat."
                );
                tavernMenu(shop, hero);
                break;
        }


    }
}




