import Character.Hero;
public class Main {
        static void main(String[] args) {

            //Aqui achar uma figura para representar o inicio do jogo


            // Jogador escolhe a classe
            Hero player = Hero.chooseCharacter();

            // escolher o nome
            player.chooseYourName();

            // Mostra o detalhameno do personagem escolhido
            player.heroDetails();

            //Apresentar uma arte da Classe escolhida


        }


    }
