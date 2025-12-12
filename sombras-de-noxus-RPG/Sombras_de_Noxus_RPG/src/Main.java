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

// Legionnaire upgrades
        Weapons crimsonCoating = new Weapons("Crimson Coating", ItemType.ATTACK, 8, 180, ClassType.LEGIONNAIRE);
        Weapons blackSteelEdge = new Weapons("Blacksteel Edge", ItemType.ATTACK, 12, 260, ClassType.LEGIONNAIRE);
        Weapons martialEssence = new Weapons("Martial Essence", ItemType.ATTACK, 18, 340, ClassType.LEGIONNAIRE);

// Bloody Mage upgrades
        Weapons dragonBloodCore = new Weapons("Dragonblood Core", ItemType.ATTACK, 8, 180, ClassType.BLOODY_MAGE);
        Weapons arcaneInfusion = new Weapons("Arcane Infusion", ItemType.ATTACK, 12, 260, ClassType.BLOODY_MAGE);
        Weapons crimsonHeart = new Weapons("Crimson Heart", ItemType.ATTACK, 18, 340, ClassType.BLOODY_MAGE);

// Crimson Archer upgrades
        Weapons fireArrows = new Weapons("Fire Arrows", ItemType.ATTACK, 8, 180, ClassType.CRIMSON_ARCHER);
        Weapons silverArrows = new Weapons("Silver Arrows", ItemType.ATTACK, 12, 260, ClassType.CRIMSON_ARCHER);
        Weapons crimsonString = new Weapons("Crimson String", ItemType.ATTACK, 18, 340, ClassType.CRIMSON_ARCHER);

// Red Bastion upgrades
        Weapons bloodstoneReinforcement = new Weapons("Bloodstone Reinforcement", ItemType.ATTACK, 8, 150, ClassType.RED_BASTION);
        Weapons runicPlating = new Weapons("Runic Plating", ItemType.ATTACK, 12, 220, ClassType.RED_BASTION);
        Weapons impactCore = new Weapons("Impact Core", ItemType.ATTACK, 18, 300, ClassType.RED_BASTION);

// Universal upgrade
        Weapons crimsonEssence = new Weapons("Crimson Essence", ItemType.ATTACK, 10, 200, null);



        //Declaração da loja e adicição dos itens
        ArrayList shop = new ArrayList<>();
        shop.add(smallHealPotion);
        shop.add(mediumHealPotion);
        shop.add(bigHealPotion);
        shop.add(smallAttackBuff);
        shop.add(bigAttackBuff);
        shop.add(crimsonCoating);
        shop.add(blackSteelEdge);
        shop.add(martialEssence);
        shop.add(dragonBloodCore);
        shop.add(arcaneInfusion);
        shop.add(crimsonHeart);
        shop.add(fireArrows);
        shop.add(silverArrows);
        shop.add(crimsonString);
        shop.add(bloodstoneReinforcement);
        shop.add(runicPlating);
        shop.add(impactCore);
        shop.add(crimsonEssence);

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
        //TODO: Notificar o jogador sobre a arma que esta usando e que pode ter futuros upgrades.

        // escolher o nome
        player.chooseYourName();

        player.setGold(200);

        // Mostra o detalhameno do personagem escolhido
        player.heroDetails();

        GameHelper.printDivider();

        Thread.sleep(2000);

        GameHelper.printTavernInit();

        Tavern.tavernMenu(actualShop, player);

        player.heroDetails();
        player.heroInventory();


    }
}
