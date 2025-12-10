package Tavern;
import java.util.Scanner;
import Item.Item;

import java.util.ArrayList;
import Character.Hero;

public abstract class Tavern {

    public static void showTavernMenu() {
        System.out.println("============================================================");
        System.out.println("                 WELCOME TO THE NOXIAN HEARTH");
        System.out.println("                        TAVERN, BRAVE "+Hero.chooseCharacter().getName()+"!");
        System.out.println("============================================================\n");

        System.out.println("                 What would you like to do, warrior?\n");

        System.out.println("                     [1] Enter the Shop");
        System.out.println("                     [2] Gambling Games");
        System.out.println("                     [3] Accept Missions");


        System.out.println("============================================================");
        System.out.print  ("                     Choose an option: ");
        System.out.println("============================================================");
    }


    public void tavernMenu(){
        Scanner input = new Scanner(System.in);
        showTavernMenu();
        int option = input.nextInt();

        switch(option){
            case 1:
        }

    }
}