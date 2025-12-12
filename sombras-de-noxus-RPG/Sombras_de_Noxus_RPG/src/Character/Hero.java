package Character;
import Enums.ClassType;
import Item.Weapons;

import java.util.ArrayList;
import java.util.Scanner;
import Item.Item;
import Item.Consumable;

public abstract class Hero extends Entity {
    public ClassType player;
    public String specialAbility;
    public int abilityDamage;
    public int gold;
    public ArrayList<Item> inventory;


    public Hero(String name, int hp, int attack, ClassType player, String specialAbility, int abilityDamage, int gold) {
        super(name, hp, attack);
        this.player = player;
        this.specialAbility = specialAbility;
        this.abilityDamage = abilityDamage;
        this.gold = gold;
        this.inventory = new ArrayList<>();
    }

    public int getGold() {
        return gold;
    }
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public ClassType getPlayer() {
        return player;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public int getAbilityDamage() {
        return abilityDamage;
    }

    public void heroDetails(){
        System.out.println("============STATUS============");
        System.out.println("* "+this.player);
        System.out.println("* "+this.hp+" (hp)");
        System.out.println("* "+this.attack+" (atk)");
        System.out.println("* "+this.specialAbility+" (special attack)");
        System.out.println("* "+this.abilityDamage+" (special damage)");
        System.out.println("* "+this.gold+" nc(Noxian Crowns)");
        System.out.println("==============================");
    }

    public void heroInventory() {
        System.out.println("============ Inventory ============");

        for (Item item : this.inventory) {
            System.out.println("Name:   " + item.getName());
            System.out.println("Effect: " + item.getEffect());
            System.out.println("Type:   " + item.getType());
            System.out.println("-----------------------------------");
        }

        System.out.println("===================================");
    }


    // Função para definir a classe do personagem para o restante do game através de um imput do player.
    public static Hero chooseCharacter() {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose your warrior:");
        System.out.println("[1] - Legionnaire");
        System.out.println("[2] - Bloody Mage");
        System.out.println("[3] - Crimson Archer");
        System.out.println("[4] - Red Bastion");

        //int choose = input.nextInt();
        int choose = 1; //TODO: AJUSTAR

        switch (choose) {
            case 1:
                System.out.println("You chose the Legionnaire!");
                return new Legionnaire();
            case 2:
                System.out.println("You chose the Bloody Mage!");
                return new BloodyMage();
            case 3:
                System.out.println("You chose the Crimson Archer!");
                return new CrimsonArcher();
            case 4:
                System.out.println("You chose the Red Bastion!");
                return new RedBastion();
            default:
                System.out.println("Invalid option, try again.\n");
                return chooseCharacter();
        }


    }
    // função para que o usuário possa personalizar seu nickName no jogo
    public void chooseYourName(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nNow brave hero, tell us the name that shall echo through legends:");
        String newName = input.next();
        setName(newName);
        System.out.println("Welcome! "+this.name+"! Your journey begins now.\n");
    }

    //manipulação gold
    public void addGold(int gold){
        this.gold += gold;
    }

    public void removeGold(int gold){
        this.gold -= gold;
    }


    //Manipulação Inventario
    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    //ações de batalha
    public void attackEnemy(NPC enemy) {
        enemy.hp -= this.attack;
        System.out.println("You dealt " + this.attack + " damage!");
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        System.out.println("You received " + damage + " damage!");
    }

    public void useConsumable(Item potion){
        if (potion instanceof Consumable && this.inventory.contains(potion)){
            this.hp += potion.getEffect();
        }
    }
    
    public void useSpecialAtk(NPC enemy){
        enemy.hp -= this.abilityDamage;
        System.out.println("You dealt " + this.abilityDamage + " damage with your special ability");
    }
}



