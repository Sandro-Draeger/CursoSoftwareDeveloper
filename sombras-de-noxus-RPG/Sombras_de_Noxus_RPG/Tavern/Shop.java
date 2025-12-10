package Tavern;

import Item.Item;
import Character.Hero;
import java.util.ArrayList;
import java.util.Random;

import Item.Item;

public class Shop extends Tavern {
    private ArrayList<Item> allItems;

    public Shop(ArrayList<Item> allItems) {
        this.allItems = allItems;
    }


    //função de itens Random
    public ArrayList<Item> randomItems() {
        ArrayList<Item> result = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            int index = r.nextInt(allItems.size());
            result.add(allItems.get(index));
        }

        return result;
    }
//exibir loja
    public void showShop(Shop shop, Hero hero) {
        System.out.println("\n===== WELCOME TO THE SHOP =====\n");

        ArrayList<Item> todayStock = shop.randomItems();

        for (int i = 0; i < todayStock.size(); i++) {
            Item item = todayStock.get(i);
            System.out.println((i + 1) + " - " + item.getName() + " (" + item.getPrice() + " Crowns)");
        }

        System.out.println("\nYou have: " + hero.getGold() + " Crowns");
    }


}


