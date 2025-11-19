package ex06;

import ex05.Pessoa;

import java.util.Objects;

public class Competicao {
    private String nomeCompeticao;
    private String pais;
    private Atleta[] listaAtletas;

    public Competicao(String nomeCompeticao, String pais, int quantidadeAtletas) {
        this.nomeCompeticao = nomeCompeticao;
        this.pais = pais;
        this.listaAtletas = new Atleta[quantidadeAtletas];
    }


    public void inscreverAtleta(Atleta participante) {
        for (int i = 0; i < this.listaAtletas.length; i++) {
            if (this.listaAtletas[i] == null) {
                listaAtletas[i] = participante;
                System.out.println(participante.getNome() + " adicionado com sucesso");
                return;
            }
        }
        System.out.println(participante.getNome() + " já se encontra nesta lista");
    }

    public void listarParticipantes() {
        System.out.println("\n----- Lista de Participantes -----");
        for (int i = 0; i < this.listaAtletas.length; i++) {
            if (listaAtletas[i] != null) {
                listaAtletas[i].exibirDetalhes();
            }
        }
    }

    public void atletasDaCasa() {
        for (int i = 0; i < this.listaAtletas.length; i++) {
            if (this.listaAtletas[i] != null) {
                if (this.listaAtletas[i].getPaisOrigem().equals(this.pais)) {
                    this.listaAtletas[i].exibirDetalhes();
                }
            }
        }
    }
}


