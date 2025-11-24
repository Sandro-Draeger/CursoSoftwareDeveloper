package ex01;

import java.util.ArrayList;

public class MusicPlayer {
    private String criador;
    private ArrayList<Musica> programacaoMusical;

    public MusicPlayer(String criador, ArrayList programacaoMusical) {
        this.criador = criador;
        this.programacaoMusical = programacaoMusical;
    }

    public void adicionarMusica(Musica m) {
        if (!programacaoMusical.contains(m)) {
            programacaoMusical.add(m);
            System.out.println("Adicionada com sucesso");
        } else {
            System.out.println("Esta música já está na playlist");
        }
    }

    public void removerMusica(Musica m) {
        if (programacaoMusical.contains(m)) {
            programacaoMusical.remove(m);
            System.out.println("Removida com sucesso");
        } else {
            System.out.println("Esta não está na sua playlist");
        }
    }

    public void trocarMusicas(Musica mAntiga, Musica mNova) {

        boolean contem = false;
        for (int i = 0; i < programacaoMusical.size(); i++)
            if (programacaoMusical.contains(mAntiga)) {
                programacaoMusical.remove(i);
                programacaoMusical.add(mNova);
                contem = true;
            }
        if (contem) {
            System.out.println("Troca realizada com sucesso");
        } else {
            System.out.println("Musica não encontrada");
        }
    }

    public void limparProgramacao() {
        programacaoMusical.clear();
        System.out.println("PlayList apagada com sucesso");
    }

    public void imprimirRelatorio() {
        programacaoMusical.forEach(Musica::exibirDetalhes);
    }
}

