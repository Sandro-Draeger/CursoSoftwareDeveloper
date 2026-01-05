package ex06;

public class Main {
    static void main() {


        Atleta atleta1 = new Atleta("Pedro", "Futsal", 1.80, 78, "Brasil", 5);
        Atleta atleta2 = new Atleta("Joao", "Vôlei", 1.90, 82, "Africa", 1);
        Atleta atleta3 = new Atleta("Maria", "Futsal", 1.65, 58, "Inglaterra", 2);
        Atleta atleta4 = new Atleta("Leo", "Dança", 1.78, 70, "Alemanha", 5);
        Atleta atleta5 = new Atleta("Pipokinha", "Dança", 1.70, 65, "Brasil", 9);
        Atleta atleta6 = new Atleta("Amanda", "Vôlei", 1.74, 60, "Portugal", 6);


        Competicao volei = new Competicao("Voleizinho de lei", "Brasil", 2);

        Competicao danca = new Competicao("Dança louca", "Alemanha", 2);

        Competicao futsal = new Competicao("Mundial dos cara", "Brasil", 3);

        volei.inscreverAtleta(atleta2);
        volei.inscreverAtleta(atleta6);

        System.out.println("\n-------------------------------------------\n");

        volei.listarParticipantes();
        volei.atletasDaCasa();

        System.out.println("\n-------------------------------------------\n");

        danca.inscreverAtleta(atleta4);
        danca.inscreverAtleta(atleta5);

        System.out.println("\n-------------------------------------------\n");

        danca.listarParticipantes();
        danca.atletasDaCasa();

        System.out.println("\n-------------------------------------------\n");

        futsal.inscreverAtleta(atleta1);
        futsal.inscreverAtleta(atleta3);

        System.out.println("\n-------------------------------------------\n");

        futsal.listarParticipantes();

        System.out.println("\n-------------------------------------------\n");
        futsal.atletasDaCasa();

        System.out.println("\n-------------------------------------------\n");

    }

}


