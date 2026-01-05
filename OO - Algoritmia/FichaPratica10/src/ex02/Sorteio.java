package ex02;

import java.util.ArrayList;
import java.util.Random;

public class Sorteio {
    private String nome;
    private String premio;
    private ArrayList<Pessoa> listaParticipantes;

    public Sorteio(String nome, String premio) {
        this.nome = nome;
        this.premio = premio;
        this.listaParticipantes = new ArrayList<>();
    }

    public void inscreverParticipantes(Pessoa pNova) {
        if (pNova.getIdade() >= 18) {
            this.listaParticipantes.add(pNova);
            System.out.println("Adicionado com sucesso");
        } else {
            System.out.println("Não tem idade suficiente");
        }
    }

    public Pessoa sortear() {
        Pessoa vencedor = null;
        Random rd = new Random();
        int indexSorteado = rd.nextInt(listaParticipantes.size());
        for (int i = 0; i < listaParticipantes.size(); i++) {
            if (listaParticipantes.get(i).equals(listaParticipantes.get(indexSorteado)))
                vencedor = listaParticipantes.get(i);
        }
        return vencedor;
    }

    public void exibirDetalhes() {
        for (int i = 0; i < listaParticipantes.size(); i++) {
            System.out.print("Participante " + i + ": ");
            listaParticipantes.get(i).exibirDetalhes();
        }
    }
}