package VidaMundial.SeresVivos;

import VidaMundial.Enums.Familia;

public class Planta extends SerVivo{
    private Familia familia;
    private final int defesa;

    public Planta(String nome, String especie, String pais, int idade, Familia familia, int defesa) {
        super(nome, especie, pais, idade);
        this.familia = familia;
        this.defesa = defesa;

    }

    public Familia getFamilia() {
        return familia;
    }

    @Override
    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.println(this.familia + " | Nivel Defesa: "+this.defesa);
    }

}
