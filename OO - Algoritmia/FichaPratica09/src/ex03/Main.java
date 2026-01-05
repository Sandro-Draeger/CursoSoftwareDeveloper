package ex03;

public class Main {
    static void main() {
    Animal cao = new Animal("Rex", "Shiba Inu", "Japão", 5, new String[]{"ração", "carne", "frango"}, ClasseReinoAnimal.MAMÍFERO);


    cao.fazerBarulho();

    cao.comer("carne", 0.2);
    cao.exibirDetalhes();


    }
}
