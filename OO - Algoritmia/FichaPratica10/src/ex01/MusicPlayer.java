package ex01;

import java.util.ArrayList;

public class MusicPlayer {
    private String criador;
    private ArrayList<String> programacaoMusical;

    public MusicPlayer(String criador, ArrayList programacaoMusical) {
        this.criador = criador;
        this.programacaoMusical = programacaoMusical;
    }

    public void adicionarMusica(String musica) {
        if (!programacaoMusical.contains(musica)) {
            programacaoMusical.add(musica);
            System.out.println("Adicionada com sucesso");
        } else {
            System.out.println("Esta música já está na playlist");
        }
    }

    public void removerMusica(String musica) {
        if (!programacaoMusical.contains(musica)) {
            programacaoMusical.remove(musica);
            System.out.println("Removida com sucesso");
        } else {
            System.out.println("Esta não está na sua playlist");
        }
    }

    public void trocarMusicas(String musicaNova, String musicaAntiga){
        if(!programacaoMusical.contains(musicaAntiga)){
            musicaAntiga = musicaNova;
            System.out.println("Troca realizada com sucesso");
        } else {
            System.out.println("Musica não encontrada");
        }
    }

    public void limparProgramacao(){
        programacaoMusical.removeAll();//o que eu ponho como parametro.
    }
}

