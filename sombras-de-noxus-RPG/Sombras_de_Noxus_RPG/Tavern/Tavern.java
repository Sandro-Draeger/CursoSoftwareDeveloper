package Tavern;

import java.util.Scanner;

import Item.Item;

import java.util.ArrayList;

import Character.Hero;

public abstract class Tavern {

    public static void showTavernMenu(Hero hero) {
        System.out.println("============================================================");
        System.out.println("                 WELCOME TO THE NOXIAN HEARTH");
        System.out.println("                        TAVERN, BRAVE " + hero.getName() + "!");
        System.out.println("============================================================\n");

        System.out.println("                 What would you like to do, warrior?\n");

        System.out.println("                     [1] Enter the Shop");
        System.out.println("                     [2] Gambling Games");
        System.out.println("                     [3] Accept Missions");


        System.out.println("============================================================");
        System.out.print("                     Choose an option: ");
        System.out.println("============================================================");
    }


    public static void tavernMenu(Shop shop, Hero hero) {
        Scanner input = new Scanner(System.in);
        showTavernMenu(hero);
        int option = input.nextInt();

        switch (option) {
            case 1:
                Shop.showShop(shop, hero);
                break;
            case 2: //gambling games
                break;
            case 3: //missions
                break;
            default:
                System.out.println("Inlavid option, choose again.\n");
        }


    }
}