package ex01;

import java.util.ArrayList;

public class MusicPlayer {
    private String criador;
    private ArrayList<Musica> programacaoMusical;

    public MusicPlayer(String criador, ArrayList programacaoMusical) {
        this.criador = criador;
        this.programacaoMusical = new ArrayList<Musica>();
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

    public void trocarMusicas(int index1, int index2) {

        Musica musica1 = this.programacaoMusical.get(index1);
        Musica musica2 = this.programacaoMusical.get(index2);

        this.programacaoMusical.set(index1, musica2);
        this.programacaoMusical.set(index2, musica1);
    }


    public void limparProgramacao() {
        programacaoMusical.clear();
        System.out.println("PlayList apagada com sucesso");
    }

    public void imprimirRelatorio() {
        for (int i = 0; i < programacaoMusical.size(); i++) {
            System.out.print("Música " + i + ": ");
            programacaoMusical.get(i).exibirDetalhes();
        }
    }
}

