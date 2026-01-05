package VidaMundial;

import VidaMundial.Enums.Dieta;
import VidaMundial.Enums.Familia;
import VidaMundial.SeresVivos.Animal;
import VidaMundial.SeresVivos.Planta;
import VidaMundial.SeresVivos.SerVivo;

import java.util.ArrayList;

public class Main {
    static void main() {
        Planta orquidea = new Planta("Orquídea", "Orchidaceae", "Brasil", 2, Familia.ERVAS, 1);
        Animal gato = new Animal("Juninho", "Gato", "Portugal", 3, true, 2.6, 60, Dieta.CARNÍVORO, "MIAUMMMMN!");

        MeioAmbiente savana = new MeioAmbiente("Savana", 500);

        ArrayList seres = new ArrayList<SerVivo>();

        savana.adicionarSerVivo(orquidea);
        savana.adicionarSerVivo(gato);

        savana.exibirDetalhesAmbiente();

        System.out.println("\n_________________________\n");

        savana.plantaBebe(0);

        System.out.println("\n_________________________\n");

        savana.plantaAbanaComVento(0);

        System.out.println("\n_________________________\n");

        savana.animalFazBarulho(1);

        System.out.println("\n_________________________\n");

        savana.animalMovimenta(1);

        System.out.println("\n_________________________\n");

        savana.animalBebe(1);

        System.out.println("\n_________________________\n");

        savana.exibirDetalhesAmbiente();



    }
}
