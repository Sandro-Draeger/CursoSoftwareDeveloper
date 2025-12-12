package Tavern;

import java.util.Random;
import java.util.Scanner;

import Item.Item;

import java.util.ArrayList;

import Character.Hero;

public abstract class Tavern {

    public static void showTavernMenu(Hero hero) {
        System.out.println("============================================================");
        System.out.println("                  WELCOME TO THE NOXIAN HEARTH");
        System.out.println("                    TAVERN, BRAVE " + hero.getName() + "!");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("                  What would you like to do, warrior?");
        System.out.println();
        System.out.println("                        [1] Enter the Shop");
        System.out.println("                        [2] Gambling Games");
        System.out.println("                        [3] Accept Missions");
        System.out.println("                        [4] Inspect your Inventory");
        System.out.println("                        [5] Review your current Status");
        System.out.println();
        System.out.println("============================================================");
        System.out.print("                        Choose an option: ");
        System.out.println();

    }

    public static void gamblingGames(Shop shop, Hero hero) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.println("\nIt costs 15nc to try your luck and role the dice!");
        System.out.println("Will you take the gamble?");
        System.out.println("[1] Yes, I'm in  |  [2] No, I'm out\n");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                if (gamblingResult()) {
                    System.out.println("\nVictory! Your bet was right, warrior! You earned 60 noxian crowns. Your now have " + hero.getGold() + " nc\n");
                    hero.setGold(hero.getGold() + 60);
                } else {
                    System.out.println("\nYou lost... luck was not on your side this time.\n");
                    hero.setGold(hero.getGold() - 15);
                }
                Thread.sleep(2000);
                tavernMenu(shop, hero);
                break;

            case 2:
                tavernMenu(shop, hero);
                break;

            default:
                System.out.println("Invalid option.\n");
                tavernMenu(shop, hero);
                break;
        }
    }


    public static boolean gamblingResult() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        boolean result = false;

        System.out.println("Place your bet, warrior! Choose a number between 1 and 6:");
        int betNum = input.nextInt();

        Random r = new Random();

        Thread.sleep(2000);
        int dice = r.nextInt(6) + 1;
        System.out.println("The dice strikes the table and reveals: " + dice);

        if (betNum == dice) {
            result = true;
        }
        return result;
    }


    public static void tavernMenu(Shop shop, Hero hero) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int option = -1;

        while (option != 3) {
            showTavernMenu(hero);
            option = input.nextInt();

            switch (option) {
                case 1:
                    Shop.showShop(shop, hero);
                    break;
                case 2:
                    gamblingGames(shop, hero);
                    break;
                case 3: //missions
                    break;
                case 4:
                    hero.heroInventory();
                    break;
                case 5:
                    hero.heroDetails();
                    break;
                default:
                    System.out.println("Inlavid option, choose again.\n");
            }
        }


    }
}