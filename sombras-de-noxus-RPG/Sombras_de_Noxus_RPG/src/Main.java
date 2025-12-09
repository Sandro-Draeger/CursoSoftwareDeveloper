import Character.Hero;
import Character.Boss;
import Enums.ClassType;
import Enums.ItemType;
import Item.Consumable;
import Item.Weapons;

import java.util.ArrayList;

public class Main {
        static void main(String[] args) {

            //Instanciar os Itens //Adicionar PREÇOOOOO
            Consumable sHealPotion = new Consumable("Small Heal Potion", ItemType.HEAL, 10);
            Consumable mHealPotion = new Consumable("Medium Heal Potion", ItemType.HEAL, 15);
            Consumable lHealPotion = new Consumable("Big Heal Potion", ItemType.HEAL, 20);
            Consumable sStrongPotion = new Consumable("Small Attack Increase", ItemType.ATTACK, 10);
            Consumable mStrongPotion = new Consumable("Medium Attack Increase", ItemType.ATTACK, 15);
            Consumable lStrongPotion = new Consumable("Big Attack Increase", ItemType.ATTACK, 20);
            Weapons longSword = new Weapons("Long Sword", ItemType.ATTACK, 10, ClassType.LEGIONNAIRE);

            //Declaração da loja
            ArrayList shop = new ArrayList<>();
            shop.add(sHealPotion);
            shop.add(mHealPotion);
            shop.add(lHealPotion);
            shop.add(sStrongPotion);
            shop.add(mStrongPotion);
            shop.add(lStrongPotion);
            shop.add(longSword);




            //Aqui achar uma figura para representar o inicio do jogo


            // Jogador escolhe a classe
            Hero player = Hero.chooseCharacter();

            // escolher o nome
            player.chooseYourName();

            // Mostra o detalhameno do personagem escolhido
            player.heroDetails();

            //Instanciar os Boss\s
            Boss leBlanc = new Boss("Le Blanc", 200, 20, 3);




        }


    }
