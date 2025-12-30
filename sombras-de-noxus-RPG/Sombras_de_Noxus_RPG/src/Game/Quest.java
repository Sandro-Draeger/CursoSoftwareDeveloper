package Game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Character.Hero;
import Character.NPC;
import Enums.ItemType;
import Item.Consumable;
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
                immortalBastionSwamp(hero, shop);
                break;

            case 4:
                crimsonGorge(hero, shop);
                break;

            case 5:
                lostCitadelOfZaunMor(hero, shop);
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

    /**
     * Starts a turn-based battle system between a hero and an enemy (NPC).
     * <p>
     * During the battle, the player can choose actions such as attacking,
     * using special abilities, consuming items, or running away. The battle
     * continues until the hero is defeated, the enemy is defeated, or the
     * player chooses to flee.
     * </p>
     *
     * @param hero  the player-controlled hero who participates in the battle
     * @param enemy the enemy NPC faced by the hero
     * @throws InterruptedException if the thread is interrupted during
     *                              the pauses between turns (Thread.sleep)
     */
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

    /**
     * Starts a riddle-based battle between a hero and an enemy (NPC).
     * <p>
     * Both participants have equal health. The enemy challenges the hero
     * with riddles instead of physical attacks. Correct answers deal damage
     * to the enemy, while wrong answers damage the hero. The battle ends when
     * one side is defeated or the player chooses to flee.
     * </p>
     *
     * @param hero  the player-controlled hero
     * @param enemy the enemy NPC that presents the riddles
     * @throws InterruptedException if the thread is interrupted during delays
     */
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

    //=============== QUESTS ===============


    public static void borderOfNoxus(Hero hero, Shop shop) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        int fullHp = hero.getHp();

        NPC BanditScout = new NPC("Bandit Scout", 55, 55, 6, "quick stab", 10, 1);
        NPC BanditBruiser = new NPC("Bandit Bruiser", 90, 90, 10, "heavy punch", 18, 1);

        System.out.println(
                "You advance along the dusty roads of Noxus.\n"
                        + "The sky hangs heavy, and rumors speak of bandits stalking travelers.\n"
        );

        Thread.sleep(1000);

        // ================= FIRST EVENT =================
        System.out.println("The road splits ahead. What do you do?");
        System.out.println("[1] Take the left path | [2] Help a wounded villager | [3] Search the area");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("A hidden thug ambushes you!");
                hero.removeGold(15);
                System.out.println("He stoled 10 Noxian Crowns");
                break;

            case 2:
                System.out.println("The villager rewards your kindness.");
                hero.addGold(50);
                System.out.println("You receive 50 Noxias Crowns!");
                break;

            case 3:
                System.out.println("You find a small stash of Crowns.");
                hero.addGold(15);
                System.out.println("You receive 15 Noxias Crowns!");
                break;

            default:
                System.out.println("You hesitate and move on.");
                break;
        }

        Thread.sleep(1000);

        // ================= FIRST BATTLE =================
        System.out.println("Movement in the bushes draws your attention.\n"
                + BanditScout.getName() + " lunges at you!\n");

        System.out.println("[1] Fight | [2] Retreat");
        choice = input.nextInt();

        if (choice == 2) {
            tavernMenu(shop, hero);
            return;
        }

        startBattle(hero, BanditScout);

        if (hero.getHp() <= 0) {
            System.out.println("The bandit overwhelms you.");
            tavernMenu(shop, hero);
            return;
        }

        System.out.println("You defeat the scout and press onward.");
        hero.setHp(fullHp);

        Thread.sleep(1000);

        // ================= SECOND EVENT =================
        System.out.println("Further ahead, tension fills the air.\n"
                        + "What do you investigate?\n");
        System.out.println("[1] Dark shadows | [2] Distant noise | [3] Rest briefly");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("A trap snaps shut!");
                hero.takeDamage(35);
                System.out.println("Current HP: " + hero.getHp());
                break;

            case 2:
                System.out.println("A dying soldier hands you his pouch.");
                hero.addGold(60);
                System.out.println("You receive 60 Noxias Crowns!");
                break;

            case 3:
                System.out.println("You steady yourself and recover supplies.");
                hero.addGold(20);
                System.out.println("You receive 20 Noxias Crowns!");
                break;

            default:
                System.out.println("You move on cautiously.");
                break;
        }

        Thread.sleep(1000);

        // ================= FINAL BOSS =================
        System.out.println(
                "A massive figure steps onto the road.\n"
                        + BanditBruiser.getName()
                        + " blocks your path.\n"
        );

        System.out.println("[1] Fight | [2] Retreat");
        choice = input.nextInt();

        if (choice == 2) {
            tavernMenu(shop, hero);
            return;
        }

        startBattle(hero, BanditBruiser);

        if (hero.getHp() > 0) {
            System.out.println("The Bandit Bruiser falls.\n"
                            + "The road is safe once more.");
            hero.setHp(fullHp);
            Hero.levelUp(hero);
            questMenu(hero, shop);
        } else {
            System.out.println("You are forced to retreat.");
            tavernMenu(shop, hero);
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
                    Hero.levelUp(hero);
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
    public static void immortalBastionSwamp(Hero hero, Shop shop) throws InterruptedException {

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
            Hero.levelUp(hero);
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

    //quest04
    public static void crimsonGorge(Hero hero, Shop shop) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int fullHp = hero.getHp();

        // Enemies
        NPC ArcaneWraith = new NPC("Arcane Wraith", 150, 150, 14, "arcane burn", 28, 2);
        NPC ZaunSentinelArmor = new NPC(
                "Zaun Sentinel Armor", 220, 220, 16, "gauntlet smash", 32, 3
        );
        NPC BrokenHexCoreGolem = new NPC(
                "Broken Hex Core Golem", 320, 320, 20, "core burst", 45, 3
        );

        //Bonus Itens
        Consumable mediumHealPotion = new Consumable("Medium Heal Potion", ItemType.HEAL, 25, 30);

        System.out.println(
                "At the heart of the Crimson Gorge, two unstable paths reveal themselves.\n"
                        + "One pulses with raw arcane energy.\n"
                        + "The other echoes with Zaunite machinery.\n"
        );
        System.out.println("[1] Arcane Path | [2] Zaun Path");

        int choice = input.nextInt();
        int pathEvent = random.nextInt(2) + 1;

        switch (choice) {

            // ================= ARCANE PATH =================
            case 1:
                System.out.println(
                        "You step into a chamber where crimson arcane forces distort reality.\n"
                );

                Thread.sleep(1000);

                // ARCANE INTERMEDIATE ENCOUNTER (RIDDLE BATTLE)
                System.out.println(
                        "An Arcane Wraith materializes, but does not attack.\n"
                                + "Its voice echoes directly into your mind...\n"
                );

                // faz com que a batalha só tenha tres perguntas.
                hero.setMaxHp(90);
                hero.setHp(90);

                riddleBattle(hero, ArcaneWraith);

                // Reward for solving the riddle
                System.out.println(
                        "The wraith dissipates, leaving arcane energy behind."
                );
                hero.addItem(mediumHealPotion);
                System.out.println("A medium heal potion was add to your inventory.");
                hero.setMaxHp(fullHp);
                hero.setHp(fullHp);

                Thread.sleep(1000);
                break;

            // ================= ZAUN PATH =================
            case 2:
                System.out.println(
                        "You descend into a corridor filled with steam, pipes, and toxic residue.\n"
                );

                // Random Zaun Event
                if (pathEvent == 1) {
                    System.out.println(
                            "A pressurized pipe bursts, spraying corrosive chemicals!"
                    );
                    hero.takeDamage(25);
                    System.out.println("Current HP: " + hero.getHp());
                } else {
                    System.out.println(
                            "You salvage usable chems from abandoned machinery."
                    );
                    hero.addGold(30);
                    System.out.println("You gain 30 Noxian Crowns.");
                }

                Thread.sleep(1000);

                // ZAUN INTERMEDIATE BATTLE
                System.out.println(ZaunSentinelArmor.getName() + " activates, blocking your advance!\n");

                startBattle(hero, ZaunSentinelArmor);

                if (hero.getHp() <= 0) {
                    System.out.println("The sentinel crushes you without mercy.");
                    tavernMenu(shop, hero);
                    return;
                }
                // Reward for victory
                System.out.println("Well done Warrior, the sentinel collapses, its systems failing.");
                hero.setHp(fullHp);
                System.out.println("You recover your HP and obtain a Small Attack Increase potion, added to your inventory.");

                Thread.sleep(1000);

                //Encontro com o Boss final
                System.out.println(
                        "The Crimson Gorge trembles violently.\n"
                                + "A massive construct rises from the depths.\n"
                                + BrokenHexCoreGolem.getName()
                                + " awakens, its Hex Core blazing uncontrollably.\n"
                );

                System.out.println("[1] Fight | [2] Retreat to the Tavern");
                choice = input.nextInt();

                if (choice == 2) {
                    tavernMenu(shop, hero);
                    return;
                }

                startBattle(hero, BrokenHexCoreGolem);

                if (hero.getHp() > 0) {
                    System.out.println(
                            "With the destruction of the Hex Core Golem,\n"
                                    + "the Crimson Gorge finally grows silent."
                    );
                    hero.setHp(fullHp);
                    Hero.levelUp(hero);
                    questMenu(hero, shop);
                } else {
                    System.out.println(
                            "The golem's power proves overwhelming."
                    );
                    tavernMenu(shop, hero);
                }

        }
    }

    //quest05
    public static void lostCitadelOfZaunMor(Hero hero, Shop shop) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int fullHp = hero.getHp();

        // Enemies
        NPC CrimsonDrake = new NPC("Crimson Drake", 180, 180, 16, "ember spit", 30, 2);
        NPC RaptorBloodfang = new NPC(
                "Raptor Bloodfang", 170, 170, 18, "razor dive", 32, 3
        );
        NPC ElderRedDrake = new NPC(
                "Elder Red Drake", 360, 360, 24, "inferno roar", 55, 4
        );

        //Itens
        Consumable smallHealPotion = new Consumable("Small Heal Potion", ItemType.HEAL, 15, 15);
        Consumable mediumHealPotion = new Consumable("Medium Heal Potion", ItemType.HEAL, 25, 30);
        Consumable smallAttackBuff = new Consumable("Small Attack Increase", ItemType.ATTACK, 10, 40);
        Consumable bigAttackBuff = new Consumable("Big Attack Increase", ItemType.ATTACK, 20, 80);


        System.out.println("You stand before the ruins of Zaun-Mor — a lost citadel swallowed by fire and corruption.\n"
                + "The air burns your lungs, and crimson-scaled creatures circle above.\n"
                + "This place was not meant to be reclaimed.\n");

        Thread.sleep(1000);


        System.out.println("Within the shattered citadel, two paths remain accessible.\n");
        System.out.println("[1] Ascend the shattered battlements | [2] Descend into the molten tunnels\n");

        int choice = input.nextInt();
        int randomEvent = random.nextInt(2) + 1;

        switch (choice) {

            case 1:
                System.out.println("You climb the broken battlements, exposed to the burning sky.\n");

                if (randomEvent == 1) {
                    System.out.println("A sudden firestorm erupts across the towers!");
                    hero.takeDamage(25);
                    System.out.println("Current HP: " + hero.getHp());
                } else {
                    hero.addItem(smallHealPotion);
                    System.out.println("Among the ruins, you discover a Small Heal Potion.\n"
                            + "It has been added to your inventory.");
                }
                break;

            case 2:
                System.out.println("You descend into tunnels flooded with molten residue and toxic fumes.\n");

                if (randomEvent == 1) {
                    System.out.println("Toxic gases overwhelm you!");
                    hero.takeDamage(20);
                    System.out.println("Current HP: " + hero.getHp());

                } else {
                    hero.addGold(40);
                    System.out.println("You scavenge an abandoned Zaunite cache.\n"
                            + "You gain 40 Crowns.");
                }
                break;
        }

        Thread.sleep(1000);

        // ================= FIRST BATTLE =================
        NPC firstEnemy;

        int randomEnemy = random.nextInt(2);

        if (randomEnemy == 0) {
            firstEnemy = CrimsonDrake;
        } else {
            firstEnemy = RaptorBloodfang;
        }

        System.out.println(firstEnemy.getName() + " descends upon you, claws tearing through the air!\n");

        startBattle(hero, firstEnemy);

        if (hero.getHp() <= 0) {
            System.out.println("You fall beneath the beast's assault.");
            tavernMenu(shop, hero);
            return;
        }

        // ================= RESURRECTION MECHANIC =================
        int resurrection = random.nextInt(100);

        if (resurrection < 30) {
            System.out.println("The creature collapses — but its body ignites in crimson flames!\n"
                    + "It rises once more, driven by pure rage!\n");

        } else {
            System.out.println("The creature's body finally goes still.\n"
                    + "It will not rise again.\n");
        }

        firstEnemy.setHp(firstEnemy.getMaxHp() / 2);
        startBattle(hero, firstEnemy);

        if (hero.getHp() <= 0) {
            System.out.println("The resurrected beast finishes you.");
            tavernMenu(shop, hero);
        } else {
            System.out.println("The creature's body finally goes still.\n"
                    + "It will not rise again.\n");
            // Reward after surviving
            hero.addItem(mediumHealPotion);
            System.out.println("You receive a Medium Heal Potion."
                    + "It has been added to your inventory.");
        }

        Thread.sleep(1000);

        // ================= FINAL BOSS =================
        System.out.println(
                "The citadel trembles violently.\n"
                        + "A colossal shadow eclipses the crimson sky.\n"
                        + ElderRedDrake.getName()
                        + " descends, its inferno consuming all hope.\n"
        );

        System.out.println("[1] Face the Elder Drake | [2] Retreat to the Tavern");
        choice = input.nextInt();

        if (choice == 2) {
            tavernMenu(shop, hero);
            return;
        }

        startBattle(hero, ElderRedDrake);

        if (hero.getHp() > 0) {
            System.out.println(
                    "With a final, earth-shattering roar, the Elder Red Drake collapses.\n"
                            + "Zaun-Mor finally falls silent.\n"
                            + "You emerge victorious from the Lost Citadel."
            );
            hero.setHp(fullHp);
            Hero.levelUp(hero);
            questMenu(hero, shop);
        } else {
            System.out.println(
                    "The Elder Drake incinerates all resistance."
            );
            tavernMenu(shop, hero);
        }
    }

    //quest06
    public static void finalTrial(Hero hero, Shop shop) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        //enemies
        NPC VladimirBoss = new NPC(
                "Vladimir – Trifarix of Strength", 420, 420, 26, "blood spear", 60, 4
        );
        NPC LeBlancBoss = new NPC(
                "LeBlanc – Trifarix of Cunning", 340, 340, 22, "illusory strike", 45, 4
        );
        NPC MordekaiserBoss = new NPC(
                "Mordekaiser – Trifarix of Fear", 520, 520, 30, "iron mace", 75, 5
        );

        if (hero.getLevel() < 3) {
            System.out.println(
                    "You feel an overwhelming pressure before the Trial begins.\n"
                            + "This path is reserved for proven warriors.\n"
                            + "Reach at least Level 3 to face the Trifarix.\n"
            );
            questMenu(hero, shop);
            return;
        }

        // =========================
        // INTRO GERAL
        // =========================
        System.out.println(
                "You step forward into the Final Trial.\n\n"
                        + "This is not a mission.\n"
                        + "This is not a conquest.\n\n"
                        + "This is judgment.\n\n"
                        + "Before you stand the Trifarix — the pillars of Noxian dominion.\n"
                        + "Strength. Cunning. Fear.\n\n"
                        + "There will be no retreat.\n"
                        + "There will be no mercy.\n"
                        + "You will face all three — or be erased.\n"
        );
        Thread.sleep(1500);

        // =========================
        // 1) VLADIMIR – STRENGTH
        // =========================
        System.out.println(
                "The air grows heavy with the scent of iron.\n"
                        + "Crimson sigils form as blood bends to unseen will.\n\n"
                        + "A pale noble steps forward, eyes glowing with ancient power.\n"
                        + "Vladimir — Trifarix of Strength.\n\n"
                        + "\"Power is not taken. It is cultivated — in blood.\"\n"
        );
        Thread.sleep(1500);

        startBattle(hero, VladimirBoss);

        if (hero.getHp() <= 0) {
            System.out.println(
                    "Your strength is drained.\n"
                            + "Vladimir turns away as your blood feeds the Trial.\n"
            );
            tavernMenu(shop, hero); // missão falhou, volta pra taverna
            return;
        }

        // Derrota do Vladimir: ele é destruído pra sempre
        System.out.println(
                "Vladimir staggers.\n"
                        + "The crimson sigils unravel as his form dissolves into a storm of blood.\n"
                        + "For the first time, the Trifarix loses a pillar — and it will not return.\n"
        );
        Thread.sleep(1500);

        // =========================
        // 2) LEBLANC – CUNNING
        // =========================
        System.out.println(
                "Slow applause echoes.\n"
                        + "Reality fractures into layered illusions.\n\n"
                        + "A figure emerges from deception itself.\n"
                        + "LeBlanc — Trifarix of Cunning.\n\n"
                        + "\"You seek truth?\"\n"
                        + "\"Truth is the first lie you believed.\"\n"
        );
        Thread.sleep(1500);

        riddleBattle(hero, LeBlancBoss);

        if (hero.getHp() <= 0) {
            System.out.println(
                    "Your mind collapses beneath endless deception.\n"
                            + "LeBlanc vanishes, her laughter lingering in the broken illusions.\n"
            );
            tavernMenu(shop, hero); // missão falhou, volta pra taverna
            return;
        }

        // Derrota “normal” da LeBlanc
        System.out.println(
                "The illusions shatter.\n"
                        + "LeBlanc's smile fades as her form scatters into mirrored fragments.\n"
                        + "For now, Cunning yields — but you can feel her eyes on you still.\n"
        );
        Thread.sleep(1500);

        // =========================
        // 3) MORDEKAISER – FEAR (BOSS FINAL)
        // =========================
        System.out.println(
                "The arena twists into a realm of cold iron and dying stars.\n"
                        + "Each breath becomes a weight, each heartbeat a fading drum.\n\n"
                        + "An armored colossus emerges, every step a funeral bell.\n"
                        + "Mordekaiser — Trifarix of Fear.\n\n"
                        + "\"All things kneel to death.\"\n"
        );
        Thread.sleep(1500);

        startBattle(hero, MordekaiserBoss);

        // =========================
        // MORTE PARA MORDEKAISER → PROPOSTA
        // =========================
        if (hero.getHp() <= 0) {

            System.out.println(
                    "Your body collapses, shattered beneath iron and hatred.\n"
                            + "Darkness claims your sight.\n\n"
                            + "But death does not come.\n"
            );
            Thread.sleep(1500);

            System.out.println(
                    "Cold chains coil around your soul.\n"
                            + "A voice echoes from beyond flesh and time.\n\n"
                            + "\"You endured what countless warriors could not.\"\n"
                            + "\"Kneel — and I shall spare you.\"\n\n"
                            + "Mordekaiser extends his will.\n"
                            + "He offers you a place among the Trifarix.\n"
            );
            Thread.sleep(1500);

            System.out.println(
                    "[1] Accept the Pact — Serve Mordekaiser\n"
                            + "[2] Refuse — Face Oblivion\n"
            );

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println(
                            "\nYou surrender your mortal defiance.\n"
                                    + "Chains bind not your body — but your fate.\n\n"
                                    + "Mordekaiser laughs.\n"
                                    + "\"Rise. You are Trifarix now.\"\n"
                    );
                    Thread.sleep(1500);

                    System.out.println(
                            "The seat once held by Vladimir lies empty no longer.\n"
                                    + "The Trifarix is remade:\n\n"
                                    + "Mordekaiser.\n"
                                    + "LeBlanc.\n"
                                    + hero.getName() + ".\n\n"
                                    + "Your name is carved into the iron will of Noxus — forever.\n"
                    );
                    Thread.sleep(1500);

                    System.out.println("=== ENDING: TRIFARIX ASCENDANT ===");

                    questMenu(hero, shop);
                    return;

                case 2:
                    System.out.println(
                            "\nYou defy him with your last breath.\n"
                                    + "Mordekaiser tightens the chains.\n\n"
                                    + "\"Then be forgotten.\"\n"
                    );
                    Thread.sleep(1500);

                    System.out.println(
                            "Your soul is crushed into the void between worlds.\n"
                                    + "The Final Trial must be faced again.\n"
                    );

                    tavernMenu(shop, hero); // volta pra taverna, precisa recomeçar
                    return;

                default:
                    System.out.println(
                            "Your silence is taken as defiance.\n"
                                    + "The chains tighten.\n"
                    );
                    tavernMenu(shop, hero);
                    return;
            }
        }

        // =========================
        // VITÓRIA CONTRA MORDEKAISER → FINAL GLORIOSO
        // =========================
        System.out.println(
                "The colossus staggers.\n"
                        + "Cracks spread across his iron shell as stolen souls burst free in screams and song.\n\n"
                        + "With a final blow, Mordekaiser falls.\n"
                        + "Fear itself bows before you.\n"
        );
        Thread.sleep(1500);

        System.out.println(
                "Before you, the Trifarix lies broken.\n"
                        + "Strength erased.\n"
                        + "Cunning humbled.\n"
                        + "Fear shattered.\n\n"
                        + "Noxus will remember this day.\n"
                        + "And it will remember your name: " + hero.getName() + ".\n"
        );
        Thread.sleep(1500);

        System.out.println("=== ENDING: NOXIAN LEGEND ===");
        questMenu(hero, shop);
    }

}




