package VidaMundial;

import VidaMundial.Enums.Familia;
import VidaMundial.SeresVivos.Animal;
import VidaMundial.SeresVivos.Inseto;
import VidaMundial.SeresVivos.Planta;
import VidaMundial.SeresVivos.SerVivo;

import java.util.ArrayList;

public class MeioAmbiente {
    private String nome;
    private double agua;
    private ArrayList<SerVivo> seres;

    public MeioAmbiente(String nome, double agua) {
        this.nome = nome;
        this.agua = agua;
        this.seres = new ArrayList<>();
    }

    public void adicionarSerVivo(SerVivo novoSer) {
        seres.add(novoSer);
        System.out.println(novoSer.getNome() + " adicionado com sucesso!");
    }

    public void removerSerVivo(SerVivo novoSer) {
        seres.remove(novoSer);
        System.out.println(novoSer.getNome() + " removido com sucesso!");
    }

    public boolean plantaBebe(int indexPlanta) {

        Planta plantaAtual = (Planta) this.seres.get(indexPlanta);

        boolean bebeu = false;

        bebeu = true;
        switch (plantaAtual.getFamilia()) {
            case Familia.ARVORES:
                this.agua -= 1;
                System.out.println(plantaAtual.getNome()+" bebeu 1L de água.");
            case Familia.FLORES:
                this.agua -= 0.1;
                System.out.println(plantaAtual.getNome()+" bebeu 0.10L de água.");
            case Familia.ERVAS:
                this.agua -= 0.25;
                System.out.println(plantaAtual.getNome()+" bebeu 0.25L de água.");
        }
        return bebeu;
    }

    public boolean plantaComeInsetos(int indexPlanta){
        //qual as condições dela comer ou nao...//
        return false;
    }

    public void plantaAbanaComVento(int indexPlanta){
        Planta plantaAtual = (Planta) this.seres.get(indexPlanta);
        System.out.println(plantaAtual.getNome()+" abanou com o vento!");
    }

    public void animalFazBarulho(int indexAnimal){
        Animal animalAtual = (Animal) this.seres.get(indexAnimal);
        System.out.println(animalAtual.getBarulho());
    }

    public void animalMovimenta(int indexAnimal){
        Animal animalAtual = (Animal) this.seres.get(indexAnimal);
        System.out.println(animalAtual.getEspecie()+" "+animalAtual.getNome()+" movimentou-se");
    }

    public boolean animalBebe(int indexAnimal) {

        Animal animalAtual = (Animal) this.seres.get(indexAnimal);
        boolean bebeu = false;
        double totalNecessario = ((Animal) this.seres.get(indexAnimal)).getPeso()*0.025;

        if(totalNecessario>this.agua){
            System.out.println("Animal morreu de cede!");
            this.seres.remove(indexAnimal);
        } else {
            bebeu = true;
            System.out.println("Animal bebeu "+totalNecessario+"l de agua.");
            this.agua -= totalNecessario;
        }

        return bebeu;
    }

    public void exibirDetalhesAmbiente(){
        System.out.println("***** "+this.nome+" *****");
        System.out.println("Total de agua disponivel: "+this.agua+"l.");
        System.out.println("Seres a viver no ambiente:");
        for(SerVivo serAtual : seres){
            if(serAtual instanceof Animal){
                serAtual.exibirDetalhes();
            }
            if (serAtual instanceof Planta){
                serAtual.exibirDetalhes();
            }
            if (serAtual instanceof Inseto){
                serAtual.exibirDetalhes();
            }
        }
    }

}
