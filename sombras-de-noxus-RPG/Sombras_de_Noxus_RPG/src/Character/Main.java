package Character;

import Enums.ClassType;
import java.util.Scanner;

public class Main {
        static void main(String[] args) {

            // 1. Jogador escolhe a classe
            Hero player = Hero.chooseCharacter();

            // 2. Jogador escolhe o nome
            player.chooseYourName();

            // 3. Mostra detalhes do personagem
            player.heroDetails();


        }


    }
