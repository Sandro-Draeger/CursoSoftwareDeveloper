import Character.Hero;
import Character.NPC;
import Enums.ClassType;
import Enums.ItemType;
import Item.Consumable;
import Item.Weapons;
import Game.Quest;
import Game.Shop;

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

// Legionnaire – Sword Upgrades
        Weapons swordUpgrade1 = new Weapons("Sword Upgrade I - Damage Boost", ItemType.ATTACK, 10, 180, ClassType.LEGIONNAIRE);
        Weapons swordUpgrade2 = new Weapons("Sword Upgrade II - Sharpness Boost", ItemType.ATTACK, 15, 260, ClassType.LEGIONNAIRE);
        Weapons swordUpgrade3 = new Weapons("Sword Upgrade III - Enhanced Blade", ItemType.ATTACK, 20, 340, ClassType.LEGIONNAIRE);

// Bloody Mage – Staff Upgrades
        Weapons staffUpgrade1 = new Weapons("Staff Upgrade I - Power Core", ItemType.ATTACK, 10, 180, ClassType.BLOODY_MAGE);
        Weapons staffUpgrade2 = new Weapons("Staff Upgrade II - Arcane Channeling", ItemType.ATTACK, 15, 260, ClassType.BLOODY_MAGE);
        Weapons staffUpgrade3 = new Weapons("Staff Upgrade III - Enhanced Focus", ItemType.ATTACK, 20, 340, ClassType.BLOODY_MAGE);

// Crimson Archer – Bow Upgrades
        Weapons bowUpgrade1 = new Weapons("Bow Upgrade I - Fire-Tipped Arrows", ItemType.ATTACK, 10, 180, ClassType.CRIMSON_ARCHER);
        Weapons bowUpgrade2 = new Weapons("Bow Upgrade II - Silver-Tipped Arrows", ItemType.ATTACK, 15, 260, ClassType.CRIMSON_ARCHER);
        Weapons bowUpgrade3 = new Weapons("Bow Upgrade III - Reinforced String", ItemType.ATTACK, 20, 340, ClassType.CRIMSON_ARCHER);

// Red Bastion – Shield Upgrades
        Weapons shieldUpgrade1 = new Weapons("Shield Upgrade I - Reinforced Plating", ItemType.ATTACK, 10, 150, ClassType.RED_BASTION);
        Weapons shieldUpgrade2 = new Weapons("Shield Upgrade II - Runic Layer", ItemType.ATTACK, 15, 220, ClassType.RED_BASTION);
        Weapons shieldUpgrade3 = new Weapons("Shield Upgrade III - Impact Boost", ItemType.ATTACK, 20, 300, ClassType.RED_BASTION);

// Universal
        Weapons universalUpgrade = new Weapons("Universal Upgrade - Crimson Essence", ItemType.ATTACK, 12, 200, null);



        //Declaração da loja e adicição dos itens
        ArrayList shop = new ArrayList<>();
        shop.add(smallHealPotion);
        shop.add(mediumHealPotion);
        shop.add(bigHealPotion);
        shop.add(smallAttackBuff);
        shop.add(bigAttackBuff);
        shop.add(swordUpgrade1);
        shop.add(swordUpgrade2);
        shop.add(swordUpgrade3);
        shop.add(staffUpgrade1);
        shop.add(staffUpgrade2);
        shop.add(staffUpgrade3);
        shop.add(bowUpgrade1);
        shop.add(bowUpgrade2);
        shop.add(bowUpgrade3);
        shop.add(shieldUpgrade1);
        shop.add(shieldUpgrade2);
        shop.add(shieldUpgrade3);
        shop.add(universalUpgrade);

        //Adicionar a Array a loja da Taverna
        Shop actualShop = new Shop(shop);
        //itens random
        actualShop.randomItems();



        //Instanciar os Boss\s

// MISSÃO 1
        NPC BanditScout = new NPC("Bandit Scout", 55, 55, 6, "quick stab", 10, 1);
        NPC BanditBruiser = new NPC("Bandit Bruiser", 90, 90, 10, "heavy punch", 18, 1);

// MISSÃO 2
        NPC CrimsonAcolyte = new NPC("Crimson Acolyte", 70, 70, 8, "blood bolt", 15, 1);
        NPC BloodLeech = new NPC("Blood Leech", 40, 40, 5, "life drain", 8, 1);
        NPC AcolyteOfVladimir = new NPC("Acolyte of Vladimir", 140, 140, 12, "blood slash", 25, 2);

// MISSÃO 3
        NPC ToxicSludge = new NPC("Toxic Sludge", 130, 130, 11, "acid spit", 22, 2);
        NPC CorruptedBeast = new NPC("Corrupted Beast", 190, 190, 14, "wild maul", 28, 2);
        NPC ChemBaronRenegadeCaptain = new NPC(
                "Chem-Baron Renegade Captain", 260, 260, 18, "toxic cleaver", 40, 3
        );

// MISSÃO 4
        NPC ArcaneWraith = new NPC("Arcane Wraith", 150, 150, 14, "arcane burn", 28, 2);
        NPC ZaunSentinelArmor = new NPC(
                "Zaun Sentinel Armor", 220, 220, 16, "gauntlet smash", 32, 3
        );
        NPC BrokenHexCoreGolem = new NPC(
                "Broken Hex Core Golem", 320, 320, 20, "core burst", 45, 3
        );

// MISSÃO 5
        NPC CrimsonDrake = new NPC("Crimson Drake", 180, 180, 16, "ember spit", 30, 2);
        NPC RaptorBloodfang = new NPC(
                "Raptor Bloodfang", 170, 170, 18, "razor dive", 32, 3
        );
        NPC ElderRedDrake = new NPC(
                "Elder Red Drake", 360, 360, 24, "inferno roar", 55, 4
        );

// MISSÃO FINAL
        NPC VladimirBoss = new NPC(
                "Vladimir – Trifarix of Strength", 420, 420, 26, "blood spear", 60, 4
        );
        NPC LeBlancBoss = new NPC(
                "LeBlanc – Trifarix of Cunning", 340, 340, 22, "illusory strike", 45, 4
        );
        NPC MordekaiserBoss = new NPC(
                "Mordekaiser – Trifarix of Fear", 520, 520, 30, "iron mace", 75, 5
        );

// =====================
// Game Start
// =====================


        // Jogador escolhe a classe
        Hero player = Hero.chooseCharacter();
        //TODO: Notificar o jogador sobre a arma que esta usando e que pode ter futuros upgrades.

        // escolher o nome
        player.chooseYourName();

        player.setGold(400);

        // Mostra o detalhameno do personagem escolhido
        player.heroDetails();

        Quest.riddleBattle(player,BloodLeech);

        //Tavern.tavernMenu(actualShop, player);

        //Quest.startBattle(player, CrimsonDrake);




    }
}
