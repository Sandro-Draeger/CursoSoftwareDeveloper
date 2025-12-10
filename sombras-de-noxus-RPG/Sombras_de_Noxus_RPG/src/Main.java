import Character.Hero;
import Character.Boss;
import Enums.ClassType;
import Enums.ItemType;
import Item.Consumable;
import Item.Weapons;
import Tavern.Tavern;
import Tavern.Shop;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) throws InterruptedException {

        //Instanciar os Itens

        // Healing potions
        Consumable smallHealPotion = new Consumable("Small Heal Potion", ItemType.HEAL, 15, 15);
        Consumable mediumHealPotion = new Consumable("Medium Heal Potion", ItemType.HEAL, 25, 30);
        Consumable bigHealPotion = new Consumable("Big Heal Potion", ItemType.HEAL, 40, 60);

        // Attack buff consumables (temporary; effect applied by battle code)
        Consumable smallAttackBuff = new Consumable("Small Attack Increase", ItemType.ATTACK, 10, 40);
        Consumable bigAttackBuff = new Consumable("Big Attack Increase", ItemType.ATTACK, 20, 80);

        // Legionnaire weapons TODO: UPGRADE DE ITENS
        Weapons longSword = new Weapons("Long Sword", ItemType.ATTACK, 10, 100, ClassType.LEGIONNAIRE);
        Weapons greatAxe = new Weapons("Great Axe", ItemType.ATTACK, 18, 220, ClassType.LEGIONNAIRE);

        // Bloody Mage weapons
        Weapons crystalStaff = new Weapons("Crystal Staff", ItemType.ATTACK, 12, 120, ClassType.BLOODY_MAGE);
        Weapons bloodChannelerStaff = new Weapons("Blood Channeler Staff", ItemType.ATTACK, 20, 260, ClassType.BLOODY_MAGE);

        // Crimson Archer weapons
        Weapons recurveBow = new Weapons("Recurve Bow", ItemType.ATTACK, 12, 120, ClassType.CRIMSON_ARCHER);
        Weapons carmineLongbow = new Weapons("Carmine Longbow", ItemType.ATTACK, 18, 220, ClassType.CRIMSON_ARCHER);

        // Red Bastion weapons
        Weapons ironMace = new Weapons("Iron Mace", ItemType.ATTACK, 8, 80, ClassType.RED_BASTION);
        Weapons towerHammer = new Weapons("Tower Hammer", ItemType.ATTACK, 14, 180, ClassType.RED_BASTION);

        // Universal weapon (usable by all classes)
        Weapons crimsonOrb = new Weapons("Crimson Orb", ItemType.ATTACK, 8, 90, null);


        //Declaração da loja e adicição dos itens
        ArrayList shop = new ArrayList<>();
        shop.add(smallHealPotion);
        shop.add(mediumHealPotion);
        shop.add(bigHealPotion);
        shop.add(smallAttackBuff);
        shop.add(bigAttackBuff);
        shop.add(longSword);
        shop.add(greatAxe);
        shop.add(crystalStaff);
        shop.add(bloodChannelerStaff);
        shop.add(recurveBow);
        shop.add(carmineLongbow);
        shop.add(ironMace);
        shop.add(towerHammer);
        shop.add(crimsonOrb);

        //Adicionar a Array a loja da Taverna
        Shop actualShop = new Shop(shop);
        //itens random
        actualShop.randomItems();

        //Instanciar os Boss\s
        Boss boss1 = new Boss("Noxian Brute", 190, 14, 1);
        Boss boss2 = new Boss("Crimson Goliath", 240, 18, 2);
        Boss boss3 = new Boss("Black Rose Enforcer", 295, 21, 3);
        Boss boss4 = new Boss("Vladimir, The Crimson Reaper", 350, 24, 4);
        Boss boss5 = new Boss("LeBlanc, The Pale Sorceress", 410, 28, 5);
        Boss boss6 = new Boss("Mordekaiser, The Iron Revenant", 520, 34, 6);

// =====================
// Game Start
// =====================


        // Jogador escolhe a classe
        Hero player = Hero.chooseCharacter();

        // escolher o nome
        player.chooseYourName();

        player.setGold(200);

        // Mostra o detalhameno do personagem escolhido
        player.heroDetails();

        GameHelper.printDivider();

        Thread.sleep(2000);

        GameHelper.printTavernInit();

        Tavern.tavernMenu(actualShop, player);

    }
}
