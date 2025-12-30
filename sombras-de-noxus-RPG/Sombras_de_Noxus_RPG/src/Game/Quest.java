package Game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Character.Hero;
import Character.NPC;
import helper.GameHelper;

import static Game.Tavern.tavernMenu;


public abstract class Quest {


    public static void questMenu(Hero hero, Shop shop) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Great warrior " + hero.getName() + ", the path awaits. Choose your next journey.");
        GameHelper.printNoxusMap();
        int choice = input.nextInt();

        switch (choice) {

            case 1:
                borderOfNoxus(hero, shop);
                break;

            case 2:
                bloodRitual(hero, shop);
                break;

            case 3:
                purgeImmortalBastionSwamp(hero, shop);
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

            case 7:
                tavernMenu(shop, hero);
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


    public static void riddleBattle(Hero hero, NPC enemy) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        ArrayList<Riddle> riddles = Riddle.initRiddles();
        enemy.setMaxHp(hero.getMaxHp());
        enemy.setHp(hero.getHp()); //ambos teram as mesmas chances de ganhar, como nao tem poção, a vida do player será o parametro

        System.out.println("\n===================================");
        System.out.println("           RIDDLE BATTLE");
        System.out.println("===================================");
        System.out.println("A wild " + enemy.getName() + " appeared!\n");
        System.out.println("The enemy does not fight with weapons, but with knowledge." +
                "\nIt will challenge you with riddles.\nFor each correct answer, the enemy suffers 30 damage." +
                "\nFor each wrong answer, you suffer 30 damage.\nNo potions, abilities, or items can be used in this trial." +
                "\nChoose wisely — intelligence is your only weapon.");


        while (true) {

            // STATUS
            System.out.println("----------- STATUS -----------");
            System.out.println("Hero HP:  " + hero.getHp() + " / " + hero.getMaxHp() + " max");
            System.out.println("Enemy HP: " + enemy.getHp() + " / " + enemy.getMaxHp() + " max");
            System.out.println("--------------------------------\n");

            // ENEMY TURN
            Riddle riddle = Riddle.getRandomRiddle(riddles);

            System.out.println(riddle.getQuestion());

            for (int i = 0; i < riddle.getOptions().size(); i++) {
                System.out.println((i + 1) + ". " + riddle.getOptions().get(i));
            }

            System.out.print("\nChoose your answer (1-3) or 0 to flee: ");
            int playerAnswer = input.nextInt();

            // FUGIR
            if (playerAnswer == 0) {
                System.out.println("You fled from the riddle battle!");
                return;
            }

            System.out.println("\nWaiting for enemy response...");
            Thread.sleep(800);

            // CHECK ANSWER (1–3)
            if (playerAnswer == riddle.getAnswer()) {
                System.out.println("Correct answer!");
                enemy.setHp(enemy.getHp() - 30);
                System.out.println("You outsmart the enemy and deal 30 damage.");
            } else {
                System.out.println("Wrong answer!");
                hero.takeDamage(30);
            }

            Thread.sleep(800);

            // END CONDITIONS
            if (enemy.getHp() <= 0) {
                System.out.println("\nYou defeated " + enemy.getName() + " with intelligence!");
                System.out.println("===================================");
                return;
            }

            if (hero.getHp() <= 0) {
                System.out.println("\nYou have been defeated...");
                System.out.println("===================================");
                return;
            }

            System.out.println("-------------------------------------\n");
        }
    }


    //quest01
    public static void borderOfNoxus(Hero hero, Shop shop) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        boolean startedQuest = false; //validação se chegou a iniciar a quest.
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
        switch (choice) {
            case 1:
                startBattle(hero, BanditScout);
                startedQuest = true;
                if (hero.getHp() > 0) {
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
            case 2:
                tavernMenu(shop, hero);
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
                    Thread.sleep(1000);
                    questMenu(hero, shop);

                } else {
                    System.out.println(
                            "The Bandit Bruiser proves overwhelming. You collapse, beaten but not broken."
                    );
                    System.out.println("[1] Challenge him again | [2] Retreat to the Tavern");
                    choice = input.nextInt();

                    if (choice == 1) {
                        startBattle(hero, BanditBruiser);
                    } else {
                        tavernMenu(shop, hero);
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

    //quest02
    public static void bloodRitual(Hero hero, Shop shop) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        boolean startedQuest = false;
        int fullHp = hero.getHp();

        // Enemies
        NPC CrimsonAcolyte = new NPC("Crimson Acolyte", 70, 70, 8, "blood bolt", 15, 1);
        NPC BloodLeech = new NPC("Blood Leech", 40, 40, 5, "life drain", 8, 1);
        NPC AcolyteOfVladimir = new NPC("Acolyte of Vladimir", 140, 140, 12, "blood slash", 25, 2);

        // Intro
        if (startedQuest) {
            System.out.println(
                    "Once again, you feel the pull of dark magic beneath Noxus. "
                            + "The metallic scent of blood fills the air, and whispers of the Crimson Circle echo in your mind.\n"
            );
        } else {
            System.out.println(
                    "Beneath the iron streets of Noxus, rumors speak of a forbidden gathering. "
                            + "The Crimson Circle prepares a ritual — fueled by blood and devotion. "
                            + "Those who vanish near the old catacombs are never seen again.\n"
            );
        }

        Thread.sleep(1000);

        // RANDOM EVENT (replaces first choice)
        Random random = new Random();
        int randomEvent = random.nextInt(3) + 1;

        System.out.println(
                "You move deeper into the underground halls of Noxus, the air heavy with blood magic...\n"
        );

        switch (randomEvent) {

            case 1:
                System.out.println(
                        "Forbidden chants echo through the tunnels.\n"
                                + "Before you can react, a surge of blood magic erupts toward you!"
                );
                hero.takeDamage(25);
                System.out.println("Current HP: " + hero.getHp() + "\n");
                break;

            case 2:
                System.out.println(
                        "A fresh trail of blood stains the stone floor.\n"
                                + "Following it, you discover a pouch dropped by fleeing cultists."
                );
                hero.addGold(30);
                System.out.println("You gain 30 Noxian Crowns.\n");
                break;

            case 3:
                System.out.println(
                        "You remain hidden in the shadows.\n"
                                + "The cultists pass by unaware, leaving a few scattered coins behind."
                );
                hero.addGold(15);
                System.out.println("You gain 15 Noxian Crowns.\n");
                break;
        }

        Thread.sleep(1000);

        // First battle
        System.out.println(
                "A hooded figure slowly turns toward you. "
                        + CrimsonAcolyte.getName()
                        + " raises his hand as blood begins to swirl around him.\n"
        );
        System.out.println("[1] Confront him | [2] Retreat to safety");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                startBattle(hero, CrimsonAcolyte);
                startedQuest = true;

                if (hero.getHp() > 0) {
                    System.out.println(
                            "The Crimson Acolyte collapses, his blood magic fading away. "
                                    + "Your wounds close as you press forward."
                    );
                    hero.setHp(fullHp);
                } else {
                    System.out.println(
                            "The acolyte overwhelms you with forbidden magic."
                    );
                    System.out.println("[1] Try again | [2] Return to the Tavern");
                    choice = input.nextInt();

                    if (choice == 1) {
                        startBattle(hero, CrimsonAcolyte);
                    } else {
                        tavernMenu(shop, hero);
                    }
                }
                break;

            case 2:
                tavernMenu(shop, hero);
                break;
        }

        Thread.sleep(1000);

        // Intermediate event
        System.out.println(
                "As you move forward, the blood beneath your feet begins to shift, alive with dark intent.\n"
        );
        System.out.println("How do you proceed?");
        System.out.println("[1] Attempt to destroy it | [2] Move carefully through it\n");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println(
                        "The blood reacts violently, forming sharp blades that tear into your armor!"
                );
                hero.takeDamage(20);
                System.out.println("Current HP: " + hero.getHp() + "\n");
                break;

            case 2:
                System.out.println(
                        "From the pool of blood, a grotesque creature takes shape!"
                );
                startBattle(hero, BloodLeech);
                if (hero.getHp() > 0) {
                    hero.setHp(fullHp);
                }
                break;
        }

        Thread.sleep(1000);

        // Final boss
        System.out.println(
                "At the heart of the ritual chamber stands a towering figure.\n"
                        + "An "
                        + AcolyteOfVladimir.getName()
                        + " watches calmly, blood orbiting his body like a living weapon.\n"
        );
        System.out.println("[1] Interrupt the ritual | [2] Retreat to the Tavern");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                startBattle(hero, AcolyteOfVladimir);

                if (hero.getHp() > 0) {
                    System.out.println(
                            "With a final strike, the ritual collapses. "
                                    + "The acolyte falls, and the Crimson Circle’s influence weakens — for now."
                    );
                    hero.setHp(fullHp);
                    Thread.sleep(1000);
                    questMenu(hero, shop);

                } else {
                    System.out.println(
                            "The power granted by Vladimir’s teachings proves overwhelming."
                    );
                    System.out.println("[1] Challenge him again | [2] Retreat to the Tavern");
                    choice = input.nextInt();

                    if (choice == 1) {
                        startBattle(hero, AcolyteOfVladimir);
                    } else {
                        tavernMenu(shop, hero);
                    }
                }
                break;

            case 2:
                tavernMenu(shop, hero);
                break;
        }
    }

    //quest03
    public static void purgeImmortalBastionSwamp(Hero hero, Shop shop) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int fullHp = hero.getHp();

        // Enemies
        NPC ToxicSludge = new NPC("Toxic Sludge", 130, 130, 11, "acid spit", 22, 2);
        NPC CorruptedBeast = new NPC("Corrupted Beast", 190, 190, 14, "wild maul", 28, 2);
        NPC ChemBaronRenegadeCaptain = new NPC(
                "Chem-Baron Renegade Captain", 260, 260, 18, "toxic cleaver", 40, 3
        );

        System.out.println(
                "You arrive at the swamps surrounding the Immortal Bastion.\n"
                        + "The water is black, thick, and bubbling with chemical waste.\n"
                        + "Noxus has attempted to purge this land before — without success.\n"
        );

        Thread.sleep(1000);

        // evento inicial randomico
        int randomEvent = random.nextInt(3) + 1;

        switch (randomEvent) {
            case 1:
                System.out.println(
                        "A toxic cloud rises from the swamp, burning your lungs!"
                );
                hero.takeDamage(30);
                System.out.println("Current HP: " + hero.getHp() + "\n");
                break;

            case 2:
                System.out.println(
                        "You discover the remains of an old Noxian outpost.\n"
                                + "Among the wreckage, a few Crowns still remain."
                );
                hero.addGold(35);
                break;

            case 3:
                System.out.println(
                        "An eerie silence allows you to mentally prepare for what lies ahead."
                );
                break;
        }

        Thread.sleep(1000);

        // numero de batalhas possiveis
        int encounters = random.nextInt(2) + 1;

        for (int i = 1; i <= encounters; i++) {

            NPC enemy;

            int chances = random.nextInt(100);

            if (chances < 60) {
                enemy = ToxicSludge; // 60%
            } else {
                enemy = CorruptedBeast; // 40%
            }

            System.out.println(
                    "Something stirs beneath the contaminated water...\n"
                            + enemy.getName()
                            + " rises from the swamp!\n"
            );

            System.out.println("[1] Fight | [2] Retreat to the Tavern");
            int choice = input.nextInt();

            if (choice == 2) {
                tavernMenu(shop, hero);
                return;
            }

            startBattle(hero, enemy);

            if (hero.getHp() > 0) {
                System.out.println(
                        "You defeat the creature, but the swamp remains hostile."
                );
                hero.setHp(fullHp);
            } else {
                System.out.println(
                        "You succumb to the swamp's toxic influence."
                );
                System.out.println("[1] Try again | [2] Retreat to the Tavern");
                choice = input.nextInt();

                if (choice == 1) {
                    startBattle(hero, enemy);
                } else {
                    tavernMenu(shop, hero);
                    return;
                }
            }

            Thread.sleep(1000);
        }

        // chances de aparecer o boss ou nao
        int bossAppears = random.nextInt(100);

        if (bossAppears < 40) {
            System.out.println(
                    "After hours of struggle, the swamp finally grows quiet.\n"
                            + "No dominant presence remains.\n"
                            + "The purge was only partial, but sufficient for now."
            );
            questMenu(hero, shop);
            return;
        }

        // Boss encounter
        System.out.println(
                "The ground trembles.\n"
                        + "From the depths of the swamp emerges a man clad in chemical armor.\n"
                        + ChemBaronRenegadeCaptain.getName()
                        + " grips a blade dripping with toxins.\n"
        );

        System.out.println("[1] Confront the Captain | [2] Retreat to the Tavern");
        int choice = input.nextInt();

        if (choice == 2) {
            tavernMenu(shop, hero);
            return;
        }

        startBattle(hero, ChemBaronRenegadeCaptain);

        if (hero.getHp() > 0) {
            System.out.println(
                    "With the fall of the Renegade Captain, chemical control over the swamp collapses.\n"
                            + "Noxus reclaims part of the corrupted territory."
            );
            hero.setHp(fullHp);
            Thread.sleep(1000);
            questMenu(hero, shop);
        } else {
            System.out.println(
                    "The Renegade Captain proves too powerful."
            );
            System.out.println("[1] Challenge him again | [2] Return to the Tavern");
            choice = input.nextInt();

            if (choice == 1) {
                startBattle(hero, ChemBaronRenegadeCaptain);
            } else {
                tavernMenu(shop, hero);
            }
        }
    }


}




