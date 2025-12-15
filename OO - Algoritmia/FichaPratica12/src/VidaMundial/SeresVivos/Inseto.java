package VidaMundial.SeresVivos;

import java.sql.SQLOutput;

public class Inseto extends SerVivo{
    private boolean venenoso;

    public Inseto(String nome, String especie, String pais, int idade, boolean venenoso) {
        super(nome, especie, pais, idade);
        this.venenoso = venenoso;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        if (venenoso){
            System.out.println("Venenoso 😱");
        } else {
            System.out.println("Não venenoso 😊");
        }
    }
}
