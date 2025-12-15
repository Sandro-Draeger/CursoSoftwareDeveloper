package Tavern;
import java.util.Scanner;
import Character.Hero;
import Character.NPC;
import Item.Item;
import helper.GameHelper;
import java.util.Scanner;


public abstract class Quest extends Tavern{

    public static void questMenu(Hero hero){
        Scanner input = new Scanner(System.in);
        System.out.println("Great warrior " + hero.getName() + ", the path awaits. Choose your next journey.");
        GameHelper.printNoxusMap();
        int choice = input.nextInt();

        switch (choice) {

            case 1: // Mission 1 TODO: Desenhar cada sala e suas sequencias de eventos.
                // código da missão 1
                break;

            case 2: // Mission 2
                // código da missão 2
                break;

            case 3: // Mission 3
                // código da missão 3
                break;

            case 4: // Mission 4
                // código da missão 4
                break;

            case 5: // Mission 5
                // código da missão 5
                break;

            case 6: // Mission 6
                // código da missão 6
                break;

            case 7: // Mission 7
                // código da missão 7
                break;

            default:
                System.out.println("Invalid choice, great warrior. Choose a valid journey.");
                break;
        }
    }

    public static boolean startBattle(Hero hero, NPC enemy) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        boolean battleOver = false;
        boolean playerWin = false;
        int heroMaxHp = hero.getHp();
        int enemyMaxHp = enemy.getHp();

        System.out.println("\n===================================");
        System.out.println("           A BATTLE BEGINS");
        System.out.println("===================================");
        System.out.println("A wild " + enemy.getName() + " appeared!\n");

        while (!battleOver) {

            System.out.println("----------- STATUS -----------");
            System.out.println("Hero HP:  " + hero.getHp() + " / " + heroMaxHp+"max");
            System.out.println("Enemy HP: " + enemy.getHp() + " / " + enemyMaxHp+"max");
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
                    System.out.println("You use "+hero.specialAbility);
                    hero.useSpecialAtk(enemy);
                    break;

                case 3:
                    hero.useConsumable();
                    break;

                case 4:
                    System.out.println("You have run from the battle.");
                    battleOver = true;
                    Quest.questMenu(hero); //TODO: Quando o usuario estiver dentro da Quest, tiro ele da luta mas mantenho na missao.
                    return playerWin;

                default:
                    System.out.println("Invalid choice!");
            }

            if (enemy.getHp() <= 0) {
                System.out.println("\nYou have defeated " + enemy.getName() + "!");
                System.out.println("===================================");
                battleOver = true;
                playerWin = true;
                return playerWin;
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
        return playerWin;
    }


    //quest01
    public static void borderOfNoxus(Hero hero, NPC enemy1, NPC enemy2, Shop shop) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        boolean startQuest = false; //validação se chegou a iniciar a quest.
        boolean endQuest = false; //validação se completou a quest ou nao.

        //if and else para mudar a msg
        System.out.println("msg iniciail");

        System.out.println("escolha de caminhos, tipo esquerda, direita ou em frente");
        int choice = input.nextInt();

        switch (choice){
            case 1:
                System.out.println("você foi pego de surpresa por um vandalo Noxiano, você receber 30 de dano");
                hero.takeDamage(30);
                System.out.println("HP atual: "+hero.getHp());
                break;
            case 2:
                System.out.println("você encontrou com um aldeao ferido, aceita ajuda-lo?");
                System.out.println("[1] Sim | [2] Não");
                int option = input.nextInt();
                if (option==1){
                    System.out.println("ganhou 50 noxian cronws de recompensa");
                hero.addGold(50);
                } else {
                    System.out.println("o aldeao morreu, mas você segue sua jornada");
                }
                break;
            case 3:
                System.out.println("você encontrou um baú com 15 noxian cronws");
                hero.addGold(15);
                break;
            default:
                System.out.println("Opção invalida");
                break;
        }

        //batalha contra o primeiro inimigo
        System.out.println("você encontrou o "+enemy1.getName()+" se prepare para lutar...");
        startBattle(hero, enemy1);
        startQuest = true;
        if (startBattle(hero, enemy1)){
            System.out.println("boa jogador, vc ganhou sua primeira batalha, seu hp foi restaurado para seguir sua jornada.");
            hero.setHp(hero.getHp());
        } else {
            System.out.println("boa tentativa, deseja tentar novamente, ou voltar a Taverna?");
            System.out.println("[1] Repetir Batalha | [2] Voltar a Taverna");
            choice = input.nextInt();
            switch (choice){
                case 1: startBattle(hero, enemy1);
                break;
                case 2: tavernMenu(shop, hero);
                break;
            }
        }
    }
}




